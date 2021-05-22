import java.lang.String;

public class test {
    public static void main(String[] args) {


        int month = 8;
        String monthString = null;
        for (int i = 0; i < 5; i++) {
            switch (month) {
                case 1:
                    monthString = "January";
                    break;
                case 2:
                    monthString = "February";
                    break;
                case 3:
                    monthString = "March";
                    break;
                case 4:
                    monthString = "April";
                    break;
                case 5:
                    monthString = "May";
                    break;
                case 6:
                    monthString = "June";
                    break;
                case 7:
                    monthString = "July";
                    break;
                case 8:
                    monthString = "August";
                    break;
                case 9:
                    monthString = "September";
                    break;
                case 10:
                    monthString = "October";
                    break;
                case 11:
                    monthString = "November";


            }

            System.out.println(monthString);

        }

    }

}



           /*
                String line = "ADDI R5, R5, 5";
                String [] store;
                store = line.split("[\\s,]+");

                System.out.println(line.indexOf("5",10));
                System.out.println(Check_Syntax(line,store));


                /*
                int position1 =  line.indexOf("R2");
                int position2 = line.indexOf("R3");
                System.out.println(Check_Syntax(line,store));
                 */
