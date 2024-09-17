package com.example.mypokedex;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });


        EditText usernameEditText = findViewById(R.id.username);
        EditText passwordEditText = findViewById(R.id.password);
        Button loginButton = findViewById(R.id.login_button);

        loginButton.setOnClickListener(v -> {
            // Reset input field backgrounds to default color (e.g., white)
            usernameEditText.setBackgroundColor(Color.WHITE);
            passwordEditText.setBackgroundColor(Color.WHITE);

            // Check if the entered credentials match the hardcoded ones
            String username = "admin";
            String password = "password123";
            String enteredUsername = usernameEditText.getText().toString();
            String enteredPassword = passwordEditText.getText().toString();

            if (enteredUsername.equals(username) && enteredPassword.equals(password)) {
                Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                // Proceed to the next activity
                Intent intent = new Intent(MainActivity.this, PokeDex.class); // Replace NextActivity.class with your actual next activity
                startActivity(intent);
            } else {
                // Show invalid credentials message and highlight fields
                Toast.makeText(MainActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();

                // Highlight the fields if they are incorrect
                if (!enteredUsername.equals(username)) {
                    usernameEditText.setBackgroundColor(Color.RED);
                }
                if (!enteredPassword.equals(password)) {
                    passwordEditText.setBackgroundColor(Color.RED);
                }
            }

        });
        usernameEditText.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                // Remove hint when EditText is clicked (gains focus)
                usernameEditText.setHint("");
            } else {
                // Restore hint if no text is entered when EditText loses focus
                if (usernameEditText.getText().toString().isEmpty()) {
                    usernameEditText.setHint(R.string.edittext_username);
                }
            }
        });
        passwordEditText.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                // Remove hint when EditText is clicked (gains focus)
                passwordEditText.setHint("");
            } else {
                // Restore hint if no text is entered when EditText loses focus
                if (passwordEditText.getText().toString().isEmpty()) {
                    passwordEditText.setHint(R.string.edittext_password);
                }
            }
        });
    }
}








