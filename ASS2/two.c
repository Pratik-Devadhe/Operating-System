#include<stdio.h>
#include<unistd.h>
#include<sys/wait.h>
int main(){
  
    pid_t pid;
    
    pid = fork();
    
    if(pid < 0){
      printf("Fork Failed....");
    }else if(pid == 0){
        printf("Child process running... %d \n", getpid() );
        sleep(3);
        printf("Child process exiting..");
        
    }else{
      wait(NULL);
      printf("Parent process : %d \n", getpid() );
      printf("Child process id : %d \n" , pid);
    }
  
return 0;
}
