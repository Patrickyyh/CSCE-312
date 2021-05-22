//NAME AND UIN
//Yuhao Ye
// 529006730

// File name: gcd.asm

// This program calculates the greatest common divisor (gcd) of two given 
// non-negative integers, which are stored in RAM[0] (R0) and RAM[1] (R1). 
// The gcd is stored in RAM[2] (R2).


     
// Put your code below this line

@R0 // A = 0
D = M // D = RAM[0]

// store R0 and R1 value to temporary addresses
@R4
M = D //  M[4]  = RAM[0]

@R1
D = M // D = RAM[1]

@R5
M = D // M[5] = RAM[1]

// check if RAM[0] OR RAM[1] is equal to zero
@R4
D = M 
@R0ISZERO
D;JEQ


@R5
D = M
@R1ISZERO
D;JEQ


// Then we put the bigger value ahead
@R0
D = M
@R1
D = D-M // R0 = R0 - R1
@SWIPR0R1
D;JLT

 





(Reminder)
      @R4
      D = M // D = M[4]
      @R5
      D = D-M // D =  D - M[5]
      @Calculation
      D;JLT
      @R4
      M = D // M[4] = D
      
      @R7
      M = D // RAM[reminder] = M[4]
      @Reminder
      0;JMP

(Calculation)

      @R5
      D = M // D = M[5]
      @R4
      M = D // M[4] = M[5]
      @R7
      D = M
      @R5
      M = D //M[5] = R[reminder]
      @R1ISZERO
      D;JEQ
  
      @Reminder
      0;JMP


    



(SWIPR0R1)
// RESET swip R4 AND R5.
    @R4
    D = M // D = M[4]
    @temp
    M = D // M[temp] = M[4]
    @R5
    D = M// D = M[5]
    @R4
    M = D // M[4] = M[5]
    @temp
    D = M
    @R5
    M = D
    @Reminder
    0;JMP   







(R0ISZERO)
    @R5
    D=M
    @R2
    M = D
    @END
    0;JMP



    



(R1ISZERO)
    // if R1 is equal to zero, then assign R0 to R2
    @R4
    D = M
    @R2
    M = D
    @END
    0;JMP





//terminate the program 
(END)
 @END
 0;JMP


