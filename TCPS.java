import java.net.*;
import java.io.*;

class TCPS {
    public static void main(String[] args) throws Exception {
        ServerSocket sersock = new ServerSocket(4000);
        System.out.println("Sever is ready for connetion");
        Socket sock = sersock.accept();
        System.out.println("Connection is successful and waiting for chattinfgz");
        InputStream istream = sock.getInputStream();
        BufferedReader fileread = new BufferedReader(new InputStreamReader(istream));
        String fname = fileread.readLine();
        BufferedReader contentread = new BufferedReader(new FileReader(fname));
        OutputStream ostream = sock.getOutputStream();
        PrintWriter pwrite = new PrintWriter(ostream, true);
        String str;
        while ((str = contentread.readLine()) != null) {
            pwrite.print(str);
        }
        sock.close();
        sersock.close();
        pwrite.close();
        fileread.close();
        contentread.close();
    }

}



