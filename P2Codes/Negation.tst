//Negation.tst

load Negation.hdl,
output-file Negation.out,
compare-to Negation.cmp,
output-list in%B1.16.1 out%B1.16.1;

// Student: Yuhao Ye
// UIN: 529006730
// Email: yeyuhao1234@tamu.edu
// Section : 599


//in=1
set in %B0000000000000001,
eval,
output;

//in=255
set in %B0000000011111111,
eval,
output;

//in=256
set in %B0000000100000000,
eval,
output;

//in=-1
set in %B1111111111111111,
eval,
output;

//in = 2
set in %B0000000000000010,
eval,
output;

//in = 4
set in %B0000000000000100,
eval,
output;


// in = 15
set in %B0000000000001111,
eval,
output;



//Write more tst commands and also complete the .cmp file accordingly