load AddSub4.hdl,
output-file AddSub4.out,
compare-to AddSub4.cmp,
output-list a%B1.4.1 b%B1.4.1 sub%B1.1.1 out%B1.4.1 carry%B3.1.3;


// Student: Yuhao Ye
// UIN: 529006730
// Email: yeyuhao1234@tamu.edu
// Section : 599


set a %B0001,
set b %B0001,
set sub 0,
eval,
output;

set sub 1,
eval,
output;


set a %B0011,
set b %B0011,
set sub 0,
eval,
output;

set sub 1,
eval,
output;



set a %B0111,
set b %B0001,
set sub 0,
eval,
output;

set sub 1,
eval,
output;




