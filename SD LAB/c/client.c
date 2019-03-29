#include <stdio.h> 
#include <sys/socket.h> 
#include <stdlib.h> 
#include <netinet/in.h> 
#include <string.h> 
#define PORT 8030
   
int main(int argc, char const *argv[]) 
{ 
    struct sockaddr_in address; 
    int sock = 0, valread; 
    struct sockaddr_in serv_addr; 
    char hello[] = "Hello from client"; 
    char buffer[1024] = {0}; 

    sock = socket(AF_INET, SOCK_STREAM, 0);
   
   

   
    serv_addr.sin_family = AF_INET; 
    serv_addr.sin_port = htons(PORT); 
       
   
   
 
    connect(sock, (struct sockaddr *)&serv_addr, sizeof(serv_addr));
    send(sock , hello , strlen(hello) , 0 ); 
    printf("Hello message sent\n"); 
    valread = read( sock , buffer, 1024); 
    printf("%s\n",buffer ); 
  while(1)
{
   valread = read( sock , buffer, 1024); 
if(valread)
    printf("%s\n",buffer ); 
	else{
scanf("%s",hello);
    send(sock , hello , strlen(hello) , 0 ); 

}
}
   
    return 0; 
} 
