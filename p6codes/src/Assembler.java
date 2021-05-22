/*
* Project name : Assembler.java
* Name: Yuhao Ye
* UIN: 529006730
* Email: yeyuhao1234@tamu.edu
* Date:
* Description : Read the instruction from *.asm file and convert it to the coressponding
* machine code and write it to the *.hack file
* 11/13/2020
* */



import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Assembler {

    // Map store corresponding operation code and operation type  of each instructions
    private static Map<String , String>register = new HashMap<String ,String >();
    private static Map<String , String>arithmetic = new HashMap<String , String>();
    private static Map<String , String>logic = new HashMap<String , String>();
    private static Map<String , String>memory = new HashMap<String , String>();
    private static Map<String , String>branch = new HashMap<String , String>();
    private static Map<String , String>inputOroutput = new HashMap<String , String>();
    private static Object FileNotFoundException;


    /**
     * function : public String getRegister(String number)
     * @param R
     * @return  This function return the machine code of Arithmetic instruction
     */
    public static  String getRegister(String R){
        // loadng the address of each register in the map;
        register.put("R0","000");
        register.put("R1","001");
        register.put("R2","010");
        register.put("R3","011");
        register.put("R4","100");
        register.put("R5","101");
        register.put("R6","110");
        register.put("R7","111");
        return register.get(R);
    }



    /**
     * function : public String getArithmetic (String instruc)
     * @param instruc
     * @return  This function return the machine code of Arithmetic instruction
     */
    public static String getArithmetic (String [] instruc){

        arithmetic.put("ADD","0000");
        arithmetic.put("ADDI","0001");
        arithmetic.put("SUB","0010");
        arithmetic.put("SUBI","0011");

 // Handling the wrong number of token argument input
        // e.g  if input ADD R0,R1,R2,R3,R4 , then exists the program because
        // there is one extra token in the insturction (R4)
        if(instruc.length != 4){
            System.out.println("SYNTAX ERROR: Illegal Instruction Encountered");
            System.exit(0);
        }

        // Handling with Add and SUB
        if(instruc[0].equals("ADD") || instruc[0].equals("SUB")) {

            String instructGenerate  = arithmetic.get(instruc[0]);
            String destRegister = getRegister(instruc[1]);
            String src1Resigter = getRegister(instruc[2]);
            String src2Register = getRegister(instruc[3]);
            return instructGenerate.concat(destRegister).concat(src1Resigter).concat(src2Register).concat("000");

        } //Handling the case ADDI and SUBI
        else{

            int temp_number = Integer.parseInt(instruc[3]);
            // if number > 63 or number < 0 ; then terminate the program.
            if((temp_number > 63) || (temp_number < 0)){
                System.out.println("SYNTAX ERROR: Illegal Instruction Encountered");
                System.exit(0);
            }


            String instructGenerate  = arithmetic.get(instruc[0]);
            String destRegister = getRegister(instruc[1]);
            String src1Resigter = getRegister(instruc[2]);
            String binaryValue  = Integer.toBinaryString(temp_number);
            // convert int number into String 6-bits binary number
            binaryValue  =String.format("%6s",binaryValue).replaceAll(" ","0");

            return instructGenerate.concat(destRegister).concat(src1Resigter).concat(binaryValue);
        }
    }


    /**
     * function :  String getLogic(String [] instruc)
     * @param instruc
     * @return  This function return the binary number of Logic instruction
     */
    public static String getLogic (String [] instruc){


        // Handling the wrong number of token argument input
        if(instruc.length != 4){

            System.out.println("SYNTAX ERROR: Illegal Instruction Encountered");
            System.exit(-1);
        }

        logic.put("NAND","0100");
        logic.put("NOR","0110");
        String opCode = logic.get(instruc[0]);
        String desRegister  = getRegister(instruc[1]);
        String src1Register = getRegister(instruc[2]);
        String src2Register = getRegister(instruc[3]);
        return opCode.concat(desRegister).concat(src1Register).concat(src2Register).concat("000");
    }


    /**
     * function :  String getMemory (String instruc)
     * @param instruc
     * @return  This function return the binary number of Memory instruction
     */
    public static String getMemory (String []  instruc){
        if(instruc.length != 3){
            System.out.println("SYNTAX ERROR: Illegal Instruction Encountered");
            System.exit(-1);
        }

        memory.put("READ","1000");
        memory.put("WRITE","1010");
        String opCode = memory.get(instruc[0]);
        String desRegister  = getRegister(instruc[1]);
        String srcRegister = getRegister(instruc[2]);

        return opCode.concat(desRegister).concat(srcRegister).concat("000000");
    }


    /**
     * function :  String getBranch (String [] instruc)
     * @param instruc
     * @return  This function return the binary machine code of Branch instruction
     */
    public static String getBranch (String [] instruc){

        branch.put("JMP","1011");
        branch.put("BEQ","1001");

        if(instruc[0].equals("JMP")){
            if(instruc.length != 2){
                System.out.println("SYNTAX ERROR: Illegal Instruction Encountered");
                System.exit(-1);
            }

            String opCode = branch.get("JMP");
            String targetAddress = getRegister(instruc[1]);
            return opCode.concat(targetAddress).concat("000000000");

        }else{

            if(instruc.length != 3 ){
                System.out.println("SYNTAX ERROR: Illegal Instruction Encountered");
                System.exit(-1);
            }
    // "BEQ","R4","R2"
            String opCode = branch.get("BEQ");
            String targetAddress = getRegister(instruc[1]);
            String srcRegister = getRegister(instruc[2]);
            return opCode.concat(targetAddress).concat(srcRegister).concat("000000");
        }
    }


    /**
     * function :  String getInOrOut (String [] instruc)
     * @param instruc
     * @return  This function return the binary machine code of Input Or Output instruction
     */
    public static String getInOrOut (String [] instruc){

        inputOroutput.put("INP","1110");
        inputOroutput.put("OUT","1100");
        if(instruc[0].equals("INP")){
            if(instruc.length != 2){
                System.out.println("SYNTAX ERROR: Illegal Instruction Encountered");
                System.exit(-1);
            }

            String opcode = inputOroutput.get("INP");
            String targetAddress  = getRegister(instruc[1]);
            return opcode.concat(targetAddress).concat("000000000");

        }else{
            if(instruc.length != 3 ){
                System.out.println("SYNTAX ERROR: Illegal Instruction Encountered");
                System.exit(-1);
            }

             String opcode=  inputOroutput.get("OUT");
             String targetAddress  = getRegister(instruc[1]);
             String srcRegister  = getRegister(instruc[2]);
             return opcode.concat(targetAddress).concat(srcRegister).concat("000000");
        }




    }




    /**
    * @param line
    * @return if the linw is empty or comment then return true
    */

    public static  boolean Check_special (String line){
          if (line.equals("") || line.substring(0,2).equals("//")){
              return true;
          }else{
              return false;
          }
    }



    /**
     * @param line,token
     * Description : Check if All valid instructions MUST contain at least one space character between every token and at
       least one comma character between every token argument..
     * @return return false if there is any syntax error e.g no space or comma between every token
     */


    public static boolean Check_Syntax(String line,String [] token){
        // If there are Invalid characters then return false;
        if (token.length == 1){
            return false;
        }



        // if there is no comma character between token argument, then return false;
        int instrucType = instrucDecide(token[0]);
        int temp_position = line.indexOf(token[1]) ;
        if(instrucType == 1 || instrucType == 2 || instrucType == 3 || token[0].equals("BEQ") || token[0].equals("OUT") ){
            for(int i = 1  ; i < (token.length-1) ; ++i){

                int position1 =  line.indexOf(token[i],temp_position);
                temp_position = position1;
                temp_position += 2;
                int position2 = line.indexOf(token[i+1],temp_position);
                if( !((line.substring(position1,position2)).contains(",") && (line.substring(position1,position2)).contains(" ")) ){
                    return false;
                }
            }
        }

        return true;



    }


/*
Description : This function decide type of instruction
@param: String keyword
@return:
For example : iF it is  arithmetic, then return 1;
 */
    public static int instrucDecide (String keyword){
        if(keyword.equals("ADD") || keyword.equals("ADDI") || keyword.equals("SUB") || keyword.equals("SUBI")){
            return 1;
        }else if (keyword.equals("NAND") || keyword.equals("NOR")){
            return 2;
        }else if (keyword.equals("READ") || keyword.equals("WRITE")){
            return 3;
        }else if(keyword.equals("JMP") || keyword.equals("BEQ")){
            return 4;
        }else{
            return 5;
        }


    }




    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {

        // Name of output file
        String hackName;
        Vector<String> line = new Vector<String>();
        String temp_line = null;


        //Read IO , Read all instruction in the program
        if(!new File(args[0]).exists()) {
            //If the the file does not exit, then terminate the program
            System.out.println("Pleas input the valid path of the file in command lin");
            System.exit(-1);
        }
        FileInputStream fstream = new FileInputStream(args[0]);
        File readFile = new File(args[0]);
        System.out.println(args[0]);


        // Get the file name from the path
        // e.g Add.asm, then hackName = Add
        hackName =  args[0].substring((readFile.getAbsolutePath().lastIndexOf("\\"))+1,args[0].lastIndexOf("."));
        BufferedReader reader = new BufferedReader( new InputStreamReader(fstream));


        // Write IO, write corresponding binary code into the file
        //The directory should be exactly the same as the path of *.asm
        OutputStreamWriter ostream = new OutputStreamWriter(new FileOutputStream(readFile.getParent().concat("\\").concat(hackName+".hack")));



      // Read all the instrustions and store them into the vector line
        while((temp_line = reader.readLine()) != null){
           if(!Check_special(temp_line))
           {
               // check inline comments
               if(temp_line.contains("//")){
                   int index = temp_line.indexOf("//");
                   String temp = temp_line.substring(0,index);
                   line.add(temp);
               }else{
                   line.add(temp_line);
               }
           }

          }


      String [] store ;
      for(int i = 0 ; i < line.size() ; ++i){

         store = line.get(i).split("[\\s,]+");
         if (!Check_Syntax(line.get(i),store)){
             System.out.println("SYNTAX ERROR: Illegal Instruction Encountered");
             System.exit(-1);
         }

         int instrType = instrucDecide(store[0]);
         String instrucion = null;
         switch (instrType){
             case 1: instrucion = getArithmetic(store);
                     break;
             case 2: instrucion = getLogic(store);
                     break;
             case 3: instrucion = getMemory(store);
                     break;
             case 4: instrucion = getBranch(store);
                     break;
             case 5: instrucion = getInOrOut(store);
                     break;
         }
         ostream.write(instrucion+"\n");
         ostream.flush();
      }
       System.out.println("The hack file has been generated successfully !");
       ostream.close();
       reader.close();

    }
}
