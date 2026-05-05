#include <stdio.h>
#include <unistd.h>
int main() {
printf("Executing ls command\n");
execlp("ls", "ls", "-l", NULL);
printf("This line will not execute\n");
return 0;
}
