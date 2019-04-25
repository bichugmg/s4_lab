#include <unistd.h> 
#include <stdio.h> 
#include <sys/socket.h> 
#include <stdlib.h> 
#include <netinet/in.h> 
#include <string.h> 
#define PORT 8030
int main(int argc, char const *argv[]) 
{ 
    int server_fd, new_socket, valread; 
    struct sockaddr_in address; 
    int opt = 1,i=0; 
    int addrlen = sizeof(address); 
    char buffer[1024] = "0"; 
    char hello[20] = "Hello from server"; 
       
    server_fd = socket(AF_INET, SOCK_STREAM, 0);

   
    address.sin_family = AF_INET; 
    address.sin_addr.s_addr = INADDR_ANY; 
    address.sin_port = htons( PORT ); 
    bind(server_fd, (struct sockaddr *)&address,  sizeof(address)); 

    

   

listen(server_fd, 3);
if ((new_socket = accept(server_fd, (struct sockaddr *)&address,  
                       (socklen_t*)&addrlen))<0) 
    { 
        perror("accept"); 
        exit(EXIT_FAILURE); 
    } 
else
printf("connect");
    valread = read( new_socket , buffer, 1024); 
    printf("%s\n",buffer ); 
while(1)
{
	 if(strcmp(buffer,"0")==0)
	{
		++i;
		printf("Enter frame %d : ",i);
		scanf("%s",hello);
	    	send(new_socket , hello , strlen(hello) , 0 ); 
		sprintf(buffer,"0");
	}
	else
	{
		read( new_socket , buffer, 1024); 
		 if(strcmp(buffer,"1")==0)
		printf("error");
	}
	
	 
	

}
    
    
    return 0; 
} 
