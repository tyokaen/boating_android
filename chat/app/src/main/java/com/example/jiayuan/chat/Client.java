package com.example.jiayuan.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiayuan on 2016/08/01.
 */
public class Client {
   //建立连接
    Writer writer;
    Reader reader;
    Socket client = new Socket();
    List<String>list=new ArrayList<String>();
    public void start() throws Exception{
        System.out.println("1");
        //	InetSocketAddress addr = new InetSocketAddress("192.168.229.128",11118);
        InetSocketAddress addr = new InetSocketAddress("192.168.1.102",11111);
       //建立连接
        client.connect(addr);
        System.out.println("2");
    }
    public void send(String string) throws Exception{
       writer = new OutputStreamWriter(client.getOutputStream());
        writer.write(string);
        writer.flush();
        Thread.sleep(10);
    }
    public void register()throws Exception{
       send("register");
        send("1");
        send("2");
        send("3");
        send("4");
        send("5");
        receive();
        receive();
        receive();
     writer.close();
     reader.close();
   }
    public void login(String str,String str1)throws Exception{
        send(str);
        send(str1);
    }
    public String receive() throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String string = null;
      //  System.out.println("4");
        string = reader.readLine();
        System.out.println("from server:" + string);
        //reader.close();

        return string;
    }
    public void over() throws Exception{
        client.close();
    }
    public static void main(String args[])throws Exception{
        //String host = "127.0.0.1";//服务端ip
        //int port = 22224;//端口


        //往服务器发消息

        //收消息






    }
}



