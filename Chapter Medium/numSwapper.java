// assume a is smaller than b

int b = b - a;
int a = a + b;
int b = a - b;

// using bit operation
int a = a^b;
int b = a^b;
int a = a^b;
