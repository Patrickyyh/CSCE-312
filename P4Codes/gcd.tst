// Yuhao Ye
// 529006730
// Filename = gcd.tst

load gcd.hack,
output-file gcd.out,
compare-to gcd.cmp,
output-list RAM[0]%D2.6.2 RAM[1]%D2.6.2 RAM[2]%D2.6.2;

set RAM[0] 9,
set RAM[1] 6,
set RAM[2] 0,
repeat 400 {
	ticktock;
}
output;

set PC 0,
set RAM[0] 11,
set RAM[1] 21,
set RAM[2] 0,
repeat 400{
	ticktock;
}
output;

set PC 0,
set RAM[0] 18,
set RAM[1] 66,
set RAM[2] 0,
repeat 400 {
	ticktock;
}
output;



set PC 0,
set RAM[0] 64,
set RAM[1] 16,
set RAM[2] 0,
repeat 400 {
	ticktock;
}
output;




set PC 0,
set RAM[0] 64,
set RAM[1] 12,
set RAM[2] 0,
repeat 500 {
	ticktock;
}
output;



set PC 0,
set RAM[0] 12,
set RAM[1] 16,
set RAM[2] 0,
repeat 500 {
	ticktock;
}
output;