//NAME AND UIN
// Yuhao Ye
// 529006730
// File name: div.asm

// The program calculates the quotient from a division operation. 
// The values of dividend a and divisor b are stored in RAM[0] (R0) and RAM[1] (R1), respectively. 
// The dividend a is a non-negative integer, and the divisor b is a positive integer. 
// Store the quotient in RAM[2] (R2). Ignore the remainder.


// Put your code below this line

// Persudo code
//RAM[0] / RAM[1] = RAM[2]
//while(RAM[0] > 0){
//     RAM[0] = RAM[0] - RAM[1];
//     RAM[2] = RAM[2] + 1 ;    
//}


@R0 // A = 0
D = M // D = RAM[0]


// set up RAM[2] to zero
@R2
M = 0 // RAM[2] = 0

@END
D;JEQ
//RAM[0] = 15   11   7  3 
// RAM[1] = 4    
// RAM[2] = 0    1   2  3
(LOOP)
    @R1 // A =1
    D = D-M // RAM[0] = RAM[0] - RAM[1]
    //if D < 0 , jump out of the loop 
    @END
    D;JLT
    @R2 // A = 2
    M = M + 1 // RAM[2] = RAM[2] + 1
    @LOOP
    0;JMP


    

//Terminate the program
(END)
    @END
    0;JMP