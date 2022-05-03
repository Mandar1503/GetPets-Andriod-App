package com.example.admin.getpets;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private EditText eName;
    private EditText Password;
    private Button Login;
    private TextView userRegistration;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eName= findViewById(R.id.etName);
        Password= findViewById(R.id.etPassword);
        Login= findViewById(R.id.btnLogin);
        userRegistration = findViewById(R.id.tvRegister);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        FirebaseUser user = firebaseAuth.getCurrentUser();

       /* if(user!=null)
        {
            finish();
            startActivity(new Intent(MainActivity.this,Main3Activity.class));
        }*/

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(eName.getText().toString(),Password.getText().toString());
            }
        });

        userRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Register.class));
            }
        });
    }

    private Boolean validate1()
    {
        Boolean result = false;

        String name = eName.getText().toString();
        String password = Password.getText().toString();

        if(name.isEmpty() || password.isEmpty())
        {
            Toast.makeText(this,"Please enter all the details",Toast.LENGTH_SHORT).show();
        }else
        {
            result=true;
        }
        return result;
    }


    private  void validate (String userName,String userPassword) {
        if(validate1())
        {
        progressDialog.setMessage("Breath-in and Breath-out");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(userName, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    progressDialog.dismiss();
                    Toast.makeText(MainActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, Main3Activity.class));
                } else {
                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }
        });
    }
    }
//    public void sendMessage(View view)
//    {
//        Intent i = new Intent(MainActivity.this,Main3Activity.class);
//
//        startActivity(i);
//    }
//    public void sendMessagetwo(View view)
//    {
//        Intent i = new Intent(MainActivity.this,Register.class);
//
//        startActivity(i);
//    }
}
