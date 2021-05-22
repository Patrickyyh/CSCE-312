// NAME AND UIN
// Name :Yuhao Ye
// UIN: 529006730

// File name: mod.asm

// This program calculates the modulo of two given numbers a and b, which is a%b in math. 
// The value of a is stored in RAM[0] (R0), and the value of b is stored in RAM[1] (R1). 
// The value a is non-negative integer and b is positive integer. 
// The modulo value is stored in RAM[2] (R2).



// Put your code below this line
// Persudo code
// RAM[0] = 9 
// RAM[1] = 2
// RAM[2] = 0
// RAM[2] = 
@R0 // A = 0
D = M  // D = M[0]
//S IF RAM[0] == 0 , RAM[0] == 0
@END
D;JEQ




// if RAM[0] < RAM[1]// Then RAM[2] = RAM[0], and goes into end
@R1 // A = 1
D = D - M // M[0] = M[0] - M[1]
@condition1
D;JLT


// if RAM[0] == RAM[1] , RAM[2] = 0
@END
D;JEQ


@R0 // A = 1
D = M // D = RAM[0]

(LOOP)
    @R1
    D = D - M // RAM[0] = RAM[0] - RAM[1]
    @END
    D;JLT
    @R2
    M = D// RAM[2] = RAM[0]
    @LOOP
    0;JMP
 



(condition1)
    @R0 // A = 0
    D = M // D = ram[0]
    @R2
    M = D // M[2] = RAM[0] D
    @END
    0;JMP
    

// terminate the program
(END)
    @END
    0;JMP





