package com.tesapplication.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText userName;
    EditText password;
    TextView dataView;
    Button buttonUser;
    Button buttonPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = findViewById(R.id.idEditUser);
        password = findViewById(R.id.idEditPass);
        dataView = findViewById(R.id.idDatatView);
        buttonUser = findViewById(R.id.idSaveButton);
        buttonPass = findViewById(R.id.idDisplayButton);

        buttonUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveData(v);
                displayData(v);
            }
        });

    }

    public void saveData(View view){
        SharedPreferences sharedPreferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("userName", userName.getText().toString()); //username = key
        editor.putString("password", password.getText().toString());
        editor.apply();

        Toast.makeText(this, "saved in the DB", Toast.LENGTH_LONG).show();

    }

    public void displayData(View view){
        SharedPreferences sharedPreferences = getSharedPreferences("username", Context.MODE_PRIVATE);
        String userNameRetrieved = sharedPreferences.getString("userName", "");
        String passReturnedRetrived = sharedPreferences.getString("password", "");
        String toDisplay = "Data retrieved are user name " + userNameRetrieved + "\n" +" password " + passReturnedRetrived;
        dataView.setText(toDisplay);

    }

    }


    /*
    //Save login info
    public void saveData(View view){
        SharedPreferences loginData = getSharedPreferences("userInfo", Context.MODE_PRIVATE);//private except userInfor
        SharedPreferences.Editor editor = loginData.edit(); //gives a user an object to edit
        editor.putString("userName", userName.getText().toString()); //get a string from EditText and set to username
        editor.putString("password", password.getText().toString()); //get a string from EditText box & set to password
        editor.apply();

        Toast.makeText(this,"Saved",Toast.LENGTH_LONG).show();
    }

    public void displayData(View view){
        SharedPreferences loginData = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String name = loginData.getString("userName", ""); //empty string, if user input doesn't exist to display
        String pass = loginData.getString("password","");
        String msg = "Saved User Name: " + name + "\nSaved Password: " + pass;
        dataView.setText(msg);
    }
}
*/