load PriorityEncoder83.hdl,
output-file PriorityEncoder83.out,
compare-to PriorityEncoder83.cmp,
output-list a%B1.8.1 out%B1.3.1 idle%B1.1.1;



set a %B00000001,
eval,
output;


set a %B00000010,
eval,
output;

set a %B00000100,
eval,
output;

set a %B00001000,
eval,
output;

set a %B00010000,
eval,
output;

set a %B00100000,
eval,
output;

set a %B01000000,
eval,
output;

set a %B10000000,
eval,
output;


set a %B00000000,
eval,
output;
