#include <unistd.h> 
#include <stdio.h> 
#include <sys/socket.h> 
#include <stdlib.h> 
#include <netinet/in.h> 
#include <string.h> 
#define PORT 8031
int main(int argc, char const *argv[]) 
{ 
    int sockfd, new_socket, valread; 
    struct sockaddr_in address,client_address; 
    int opt = 1; 
    int addrlen = sizeof(address); 
    char buffer[1024] = {0}; 
    char hello[20] = "Hello from server"; 
       
    sockfd = socket(AF_INET, SOCK_DGRAM, 0);

   
    address.sin_family = AF_INET; 
    address.sin_addr.s_addr = INADDR_ANY; 
    address.sin_port = htons( PORT ); 
    bind(sockfd, (struct sockaddr *)&address,  sizeof(address)); 

    

   

int len, n; 
    n = recvfrom(sockfd, (char *)buffer, 1024,  
                MSG_WAITALL, ( struct sockaddr *) &address, 
                &len); 
    buffer[n] = '\0'; 
    printf("Client : %s\n", buffer); 
while(1)
{
 scanf("%s",hello);
 sendto(sockfd, (const char *)hello, strlen(hello),  
        MSG_CONFIRM, (const struct sockaddr *) &address, 
            len); 
}
   
    printf("Hello message sent.\n");  
    
    
    return 0; 
} 
