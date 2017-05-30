import java.io.*;
import java.net.*;

/**
 * Usage:input a string, server will return a value.
 **/

class TCPClient {
    public static void main(String argv[]) throws Exception {
        String sentence = "";
        String modifiedSentence = "";
        Socket clientSocket = new Socket("localhost", 6789);

        // read from user
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        sentence = inFromUser.readLine();

        // client send to server
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        outToServer.writeBytes(sentence + '\n');

        // client read from server
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        modifiedSentence = inFromServer.readLine();

        System.out.println("FROM SERVER: " + modifiedSentence);

        clientSocket.close();
    }
}
