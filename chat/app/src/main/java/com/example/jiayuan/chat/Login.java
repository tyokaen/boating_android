package com.example.jiayuan.chat;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Login extends Activity {
EditText ed_ID,ed_password,ed_password1,ed_mail;
Button button_send,button1;
    //Socket client = new Socket();
    static String str,str1,str2;
    TextView t;
   static Writer writer;
   // static BufferedReader reader;
   // static Socket client = new Socket();
   // static InetSocketAddress addr = new InetSocketAddress("192.168.11.43",11115);
Client client=new Client();
   // List<String> list=new
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ed_ID=(EditText)findViewById(R.id.EditText3);
        ed_password=(EditText)findViewById(R.id.EditText4);
        ed_password1=(EditText)findViewById(R.id.EditText5);
        ed_mail=(EditText)findViewById(R.id.EditText6);
        button_send=(Button)findViewById(R.id.Button4);
        button1=(Button)findViewById(R.id.Button5);
        ed_ID.addTextChangedListener(watcher);

        button_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str=ed_ID.getText().toString();
                str1=ed_password.getText().toString();
                str2=ed_mail.getText().toString();

                ( new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            client.start();
                            client.register();
                        }
                        catch(Exception e){
                        }
                    }
                })).start();

            }
        });
        print();
       // button1.setOnClickListener(new View.OnClickListener() {
            //@Override
          //  public void onClick(View v) {
            //   ( new Thread(new Runnable() {
                    //@Override
                   // public void run() {
               //      try {


                   //     }
                    //    catch(Exception e){
                     //  }
                //   }
              //  })).start();
        //   }
     //   });

  /*      button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               if(!(editText1.getText().toString().equals(editText2.getText().toString()))){
                   editText2.setText(null);
                   AlertDialog.Builder builder=new AlertDialog.Builder(Login.this);
                   builder.setTitle("校对密码有误，重新输入");
                  final EditText ed=new EditText(Login.this);
                   builder.setView(ed);
                   builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialog, int which) {
                           String str = ed.getText().toString();
                           editText2.setText(str);
                       }
                   });
                   AlertDialog dialog=builder.create();
                   dialog.show();
               }
              else {
                   if (!(editText3.getText().toString().matches("^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\\.([a-zA-Z0-9_-])+)+$"))) {
                       AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                       builder.setTitle("提示信息");
                       builder.setMessage("您输入的邮箱格式不正确");
                       AlertDialog dialog = builder.create();
                       dialog.show();
                   } else {
                       ( new Thread(new Runnable() {
                           @Override
                           public void run() {
                               try {
                                   sendMessage1();
                               }
                               catch(Exception e){

                               }
                           }
                       })).start();
                       Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                       startActivity(intent);
                   }
               }
            }
        }); */
    }
       public void print(){
           System.out.println("jiayuan");
       }
     TextWatcher watcher=new TextWatcher() {
         @Override
         public void beforeTextChanged(CharSequence s, int start, int count, int after) {

         }
         @Override
         public void onTextChanged(CharSequence s, int start, int before, int count) {
         }
         @Override
         public void afterTextChanged(Editable s) {
             int Start=ed_ID.getSelectionStart();
             int end=ed_ID.getSelectionEnd();
             String str=s.toString();
              if(!(str.matches("[a-zA-Z-0-9]{0,13}"))){
                  AlertDialog.Builder builder=new AlertDialog.Builder(Login.this);
                  builder.setTitle("提示信息");
                  builder.setMessage("您输入的信息信息不正确");
                  AlertDialog dialog=builder.create();
                  dialog.show();
                 s.delete(end-1,end);
              }
         }
     };

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
