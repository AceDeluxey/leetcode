package org.example.udp.demo1;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;
public class UdpServer {
    //服务器socket要绑定固定的端口
    private static final int PORT = 8888;
    public static void main(String[] args) throws IOException {
        // 1.创建服务端DatagramSocket，指定端口，可以发送及接收UDP数据报
        DatagramSocket socket = new DatagramSocket(PORT);
        //不停的接收客户端udp数据报
        while (true){
            // 2.创建数据报，用于接收客户端发送的数据
            byte[] bytes = new byte[1024];//1m=1024kb, 1kb=1024byte, UDP最64k（包含UDP首部8byte）
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
            System.out.println("------------------------------------------------ ---");
                    System.out.println("等待接收UDP数据报...");
            // 3.等待接收客户端发送的UDP数据报，该方法在接收到数据报之前会一直阻塞，接收到数据报以后，DatagramPacket对象，包含数据（bytes）和客户端ip、端口号
            socket.receive(packet);
            System.out.printf("客户端IP：%s%n",
                    packet.getAddress().getHostAddress());
            System.out.printf("客户端端口号：%s%n", packet.getPort());
            System.out.printf("客户端发送的原生数据为：%s%n",
                    Arrays.toString(packet.getData()));
            System.out.printf("客户端发送的文本数据为：%s%n", new
                    String(packet.getData()));
        }
    }
}

