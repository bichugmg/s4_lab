#include <stdio.h> 
#include <sys/socket.h> 
#include <stdlib.h> 
#include <netinet/in.h> 
#include <string.h> 
#define PORT 8030
   
int main(int argc, char const *argv[]) 
{ 
    struct sockaddr_in address; 
    int sock = 0,i=0, valread,c; 
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
c=1;
  while(1)
{

	if(c==0)
	{
		hello[0]='0';
		send(sock , hello , strlen(hello) , 0 ); 
		
	}
	else
	{
		++i;
	   valread = read( sock , buffer, 1024); 

	    printf("Rec frame %d :  %s\n",i,buffer ); 
		printf("Is it corresct ?\n");
		scanf("%d",&c);
	}
}
   
    return 0; 
} 
