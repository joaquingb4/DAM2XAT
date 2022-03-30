package com.example.damxat.Views.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.damxat.Model.User;
import com.example.damxat.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    FirebaseAuth auth;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button registerButton = findViewById(R.id.registerButton);
        EditText registerUsername = findViewById(R.id.registerUsername);
        EditText registerEmail = findViewById(R.id.registerEmail);
        EditText registerPassword = findViewById(R.id.registerPassword);

        //Comentar
        //Obtenemos una instancia de FireBaseAuth
        auth = FirebaseAuth.getInstance();

        //Comentar
        //AL boton de register se le pone un listener
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = registerUsername.getText().toString();
                String email = registerEmail.getText().toString();
                String password = registerPassword.getText().toString();

                //Comentar
                //Recogemos los campos anteriores  y comprobamos si alguno está vacío
                //Si alguno lo está lanza un mensaje
                if(username.isEmpty() || email.isEmpty() || password.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "All fields are required.", Toast.LENGTH_SHORT).show();
                }else{
                    //Si ninguno lo esta llamamos al metodo registrar y le pasamos los campos que hemos recogido
                    registerUser(username, email, password);
                }

            }
        });
    }

    //Comentar
    public void registerUser(String username, String email, String password){
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                       //Comentar
                       //Se crea un usuario con los campos pasados
                       // y si se crea con éxito también se crea un id de usuario
                        if(task.isSuccessful()){
                            FirebaseUser firebaseUser = auth.getCurrentUser();
                            String userId = firebaseUser.getUid();

                            //Comentar
                            //Y en el proyecto firebase crea usuario con el id recibido
                            //Creamos un objeto usuario también
                            reference = FirebaseDatabase.getInstance().getReference("Users").child(userId);

                            User user = new User(userId, username, "offline");

                            //Comentar
                            //Dentro de el proyecto firebase se llenan los campos con el objeto usuario creado
                            reference.setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    //Comentar
                                    //Si se completa con éxito lanza el login activity
                                    if(task.isSuccessful()) {
                                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                        startActivity(intent);
                                    }
                                }
                            });

                        }else{
                            Toast.makeText(RegisterActivity.this, "You can't register with this email", Toast.LENGTH_SHORT).show();
                        }
                   }
               });
    }
}