package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class RegisterActivity extends AppCompatActivity {
    private Button regBTN;
    private EditText FName, Email, Location, Profession, Password;
    private ImageView pic;
    private CheckBox Male, Female;
    private FirebaseDatabase database;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private String email,password,fullName,occupation,location;
    static final String USERS ="user";
    static final String TAG ="RegisterActivity";

    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        regBTN = findViewById(R.id.RegisterBTN);
        FName = findViewById(R.id.FName_ET);
        Email = findViewById(R.id.Email_ET);
        Location = findViewById(R.id.Location_ET);
        Profession = findViewById(R.id.Profession_ET);
        Password = findViewById(R.id.Password_ET);
        pic = findViewById(R.id.imageView6);
        Male = findViewById(R.id.MaleCheckBox);
        Female = findViewById(R.id.FemaleCheckBox);

        database = FirebaseDatabase.getInstance();
        mDatabase = database.getReference(USERS);
        mAuth = FirebaseAuth.getInstance();



        regBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = Email.getText().toString();
                String password = Password.getText().toString();
                if(TextUtils.isEmpty(email)||TextUtils.isEmpty(password)){
                    Toast.makeText(getApplicationContext(),"Enter Email and Password",Toast.LENGTH_LONG).show();
                    return;
                }
                String fullName = FName.getText().toString();
                String occupation = Profession.getText().toString();
                String location = Location.getText().toString();
                 user = new User(email,password,fullName,occupation,location);
                registerUser();
            }
        });

    }    public void registerUser(){

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // ...
                    }
                });
    }
    public void updateUI(FirebaseUser currentUser){
        String keyId = mDatabase.push().getKey();
        mDatabase.child(keyId).setValue(user);
        Intent intent = new Intent(RegisterActivity.this, BMICalculators.class);
        startActivity(intent);

    }

}