//Add16.tst

load LeftLogicBitshift.hdl,
output-file LeftLogicBitshift.out,
compare-to LeftLogicBitshift.cmp,
output-list x%B1.16.1 y%B1.16.1 out%B1.16.1;

// Student: Yuhao Ye
// UIN: 529006730
// Email: yeyuhao1234@tamu.edu
// Section : 599


set x %B0000000010101011,
set y %B0000000000000001,
eval,
output;

set x %B1111111111111111,
set y %B0000000000001000,
eval,
output;

set x %B1111111111111111,
set y %B0000000000000000,
eval,
output;


set x %B0000000000101011,
set y %B0000000000000001,
eval,
output;


set x %B0000000000101011,
set y %B0000000000000010,
eval,
output;

set x %B0000000000111111,
set y %B0000000000000100,
eval,
output;




set x %B0000000000111111,
set y %B0000000000000101,
eval,
output;







