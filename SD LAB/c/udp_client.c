#include <stdio.h> 
#include <sys/socket.h> 
#include <stdlib.h> 
#include <netinet/in.h> 
#include <string.h> 
#define PORT 8031
   
int main(int argc, char const *argv[]) 
{ 
    struct sockaddr_in address; 
    int sockfd = 0, valread; 
    struct sockaddr_in serv_addr; 
    char hello[] = "Hello from client"; 
    char buffer[1024] = {0}; 

    sockfd = socket(AF_INET, SOCK_DGRAM, 0);
   
   

   
    serv_addr.sin_family = AF_INET; 
    serv_addr.sin_port = htons(PORT); 
       
   
   
 
  int n,len;
sendto(sockfd, (const char *)hello, strlen(hello), 
        MSG_CONFIRM, (const struct sockaddr *) &serv_addr,  
            sizeof(serv_addr)); 
  while(1)
{
   n = recvfrom(sockfd, (char *)buffer, 1024,  
                MSG_WAITALL, (struct sockaddr *) &serv_addr, 
                &len); 
    buffer[n] = '\0'; 
    printf("Server : %s\n", buffer); 
}
   
    return 0; 
} 
