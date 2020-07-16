package com.example.consulting;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import java.util.Locale;

public class AdminLogin extends Activity implements TextToSpeech.OnInitListener {
    EditText txtname,txtpass;
    String name,password,nm;
    TextView txterror;
    ProgressBar progressBar;
    SharedPreferences sp;
    TextToSpeech tts;
    Button btnlogin;
    SharedPreferences.Editor se;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        txtname=(EditText)findViewById(R.id.txtname);
        sp=getSharedPreferences("logininfo",MODE_PRIVATE);
        txtpass=(EditText)findViewById(R.id.txtpass);
        //txt=(TextView)findViewById(R.id.txt);
        progressBar= findViewById(R.id.progressBar2);
        btnlogin=(Button) findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nm=txtname.getText().toString();
                String ps=txtpass.getText().toString();
                name=sp.getString("name","");
                password=sp.getString("pass","");

                if (nm.equalsIgnoreCase(name)&&ps.equalsIgnoreCase(password))
                {
                    Intent i=new Intent(AdminLogin.this,ActivityAdmin.class);
                    //Intent i=new Intent(this,MapActivity.class);
                    startActivity(i);
                    //setContentView(R.layout.activity_maps);
                    //tts.speak("welcome dear", TextToSpeech.QUEUE_FLUSH,null,null);
                }
                else
                {
                    txterror.setText("Invalid UserId/Password");
                    //tts.speak("incorrect I D or password. Please Re enter",TextToSpeech.QUEUE_FLUSH,null,null);
                }
            }
        });
    }



    @Override
    public void onInit(int status) {
       // int res=tts.setLanguage(Locale.ENGLISH);
       // if(res==TextToSpeech.LANG_NOT_SUPPORTED||res==TextToSpeech.LANG_NOT_SUPPORTED)
       // {
         //   Toast.makeText(this,"lang not supported",Toast.LENGTH_SHORT).show();
       // }

    }

}
