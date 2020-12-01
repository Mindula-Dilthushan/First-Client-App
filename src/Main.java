import java.io.*;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try {

            Socket socket = new Socket("localhost",5000);

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String message="" , reply="";

            while (!message.equals("end")){
                reply = bufferedReader.readLine();
                dataOutputStream.writeUTF(reply);
                message=dataInputStream.readUTF();
                System.out.println(message);
            }

            dataInputStream.close();
            dataOutputStream.close();
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
