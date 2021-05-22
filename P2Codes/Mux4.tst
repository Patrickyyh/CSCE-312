load Mux4.hdl,
output-file Mux4.out,
output-list a%B1.4.1 b%B1.4.1 sel%D2.1.2 out%B1.4.1;




set a 0,
set b 0,
set sel 0,
eval,
output;

set sel 1,
eval,
output;

set a %B0000,
set b %B0000,
set sel 0,
eval,
output;

set sel 1,
eval,
output;


set a %B0001,
set b %B0000,
set sel 0,
eval,
output;


set sel 1,
eval,
output;




set a %B0011,
set b %B0000,
set sel 0,
eval,
output;


set sel 1,
eval,
output;




