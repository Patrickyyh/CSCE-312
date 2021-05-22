load CPU.hdl,
output-file CPU.out,
compare-to CPU.cmp,
output-list time%S0.4.0 fromM%D0.16.0 In%B0.26.0 Reset%B2.1.2 toM%D1.16.0 writeM%B3.1.3 addressM%D0.16.0 PCOut%D0.16.0;

set In %B0001000001000111, // ADDI R0, R1, 7
tick, output, tock, output;

set fromM %D16,
set In %B1000001000000011, // READ R1, R0
tick, output, tock, output;


set In %B0000010001011000, // ADD R2, R1,R3 
tick, output, tock, output;


set fromM %D19,
set In %B1000100010000000, // READ R4, R2
tick, output, tock, output;

set In %B1011100000000000, // PCOut  = R4
tick, output, tock, output;



// Add more test cases here to increase the robustness of testing

