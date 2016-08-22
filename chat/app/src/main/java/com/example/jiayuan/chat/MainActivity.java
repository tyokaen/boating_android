package com.example.jiayuan.chat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
Button button_login,button_forget,button_zhu;
EditText ed_ID,ed_Password;

    String str,str1,str2;
    TextView t;
    Client client=new Client();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_login=(Button)findViewById(R.id.Button1);
        button_forget=(Button)findViewById(R.id.Button2);
        button_zhu=(Button)findViewById(R.id.Button3);
        ed_ID=(EditText)findViewById(R.id.EditText1);
        ed_Password=(EditText)findViewById(R.id.EditText2);
        t=(TextView)findViewById(R.id.TextView11);
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        str=ed_ID.getText().toString();
                        str=ed_Password.getText().toString();
                ( new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            client.start();
                            //client.login(str,str1);
                            client.send("search|0912|tsukuba|mito");
                           str2= client.receive();
                            System.out.println(str);
                            t.setText(str2);
                       }
                        catch(Exception e){
                        }
                    }
                })).start();

                }
        });
       button_forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
      button_zhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });

    }
    //public void sendmessage()throws Exception{
      //  client.start();
       // client.send();
    //}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
