import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) throws IOException{

        //端口号
        int port = 7000;
        //在端口上创建一个服务器套接字
        ServerSocket serverSocket = new ServerSocket(port);
        //监听来自客户端的链接
        Socket socket = serverSocket.accept();

        DataInputStream dis = new DataInputStream(
                new BufferedInputStream(socket.getInputStream()));
        DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(socket.getOutputStream()));

        do {

            double length = dis.readDouble();
            System.out.println("服务器接收到的边长数据为：" + length);
            double result = length * length;
            dos.writeDouble(result);
            dos.flush();
        }
        while (dis.readInt() != 0);

        socket.close();
        serverSocket.close();

    }
}

//http://www.jianshu.com/p/ae5e1cee5b04
