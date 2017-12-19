package com.mathheals.finans_proje_odevi;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.IOException;

public class profile extends AppCompatActivity implements View.OnClickListener{
    private Button cikis;
   private Button gercekle;
    private FirebaseAuth firebaseAuth;
    private ImageView image1,image2,image3;
    private Uri filePath;

    ProgressDialog progress;


    public profile()throws IOException {}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        //gelen ıd kısmı
        Bundle useralınan=getIntent().getExtras();
        final String UserId_gelen=useralınan.getString("userıd");


        Toast.makeText(this, UserId_gelen, Toast.LENGTH_SHORT).show();


cikis=(Button)findViewById(R.id.input_exit);
gercekle=(Button)findViewById(R.id.ar_button);

        firebaseAuth=FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser()==null){
            startActivity(new Intent(this,MainActivity.class));

        }
        FirebaseUser user=firebaseAuth.getCurrentUser();

cikis.setOnClickListener(this);
gercekle.setOnClickListener(this);




    }





    @Override
    public void onClick(View v) {
        if(v==cikis){
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(this,MainActivity.class));}
        else if(v==gercekle)
        {
            startActivity(new Intent(this, UnityPlayerNativeActivity.class));

        }


    }
}
