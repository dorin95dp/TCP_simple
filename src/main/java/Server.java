import java.io.*;
import java.net.*;

class TCPServer {
    public static void main(String argv[]) throws Exception {
        String clientSentence = "";
        String capitalizedSentence = "";
        ServerSocket serverSocket = new ServerSocket(6789);

        boolean isStopped = false;
        while (!isStopped) {
            Socket connectionSocket = serverSocket.accept();

            // server gets from client
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            clientSentence = inFromClient.readLine();

            // print the data from client
            System.out.println("Received: " + clientSentence);

            capitalizedSentence = clientSentence.toUpperCase() + '\n';

            // send data to client
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            outToClient.writeBytes(capitalizedSentence);
        }
    }
}
