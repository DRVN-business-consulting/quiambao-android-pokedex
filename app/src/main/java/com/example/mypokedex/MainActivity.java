package com.example.mypokedex;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mypokedex.api.API;
import com.example.mypokedex.dto.request.LoginDto;
import com.example.mypokedex.dto.response.RefreshTokenDto;
import com.example.mypokedex.model.Pokemon;
import com.example.mypokedex.prefs.AppPreferences;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private Button signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Initialize AppPreferences
        AppPreferences.initialize(this);

        // Initialize UI elements
        usernameEditText = findViewById(R.id.username); // Ensure these IDs match your XML layout
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.login_button);
        signupButton = findViewById(R.id.signup_button);

        // Login button onClick listener
        loginButton.setOnClickListener(view -> {
            String username = usernameEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            // Validate user input
            if (username.isEmpty()) {
                usernameEditText.setError("Username cannot be empty");
                usernameEditText.requestFocus();
                return;
            }

            if (password.isEmpty()) {
                passwordEditText.setError("Password cannot be empty");
                passwordEditText.requestFocus();
                return;
            }

            // Proceed to login if input is valid
            loginUser(username, password);
        });

        // Signup button onClick listener
        signupButton.setOnClickListener(view -> {
            // Navigate to SignupActivity
            Intent intent = new Intent(MainActivity.this, Signupactivity.class);
            startActivity(intent);
        });

        // Handle focus change on username and password fields
        usernameEditText.setOnFocusChangeListener((view, hasFocus) -> {
            if (hasFocus) {
                usernameEditText.setHint("");
            } else if (usernameEditText.getText().toString().isEmpty()) {
                usernameEditText.setHint(R.string.edittext_username);
            }
        });

        passwordEditText.setOnFocusChangeListener((view, hasFocus) -> {
            if (hasFocus) {
                passwordEditText.setHint("");
            } else if (passwordEditText.getText().toString().isEmpty()) {
                passwordEditText.setHint(R.string.edittext_password);
            }
        });
    }

    // The loginUser method handles the API call to login the user
    private void loginUser(String username, String password) {
        // Make the API call to log in
        API.userApi().login(new LoginDto(username, password)).enqueue(new Callback<RefreshTokenDto>() {
            @Override
            public void onResponse(Call<RefreshTokenDto> call, Response<RefreshTokenDto> response) {
                if (response.isSuccessful()) {
                    // Handle successful login: save tokens, navigate to PokeDex activity
                    Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, PokemonDetails.class);
                    startActivity(intent);
                } else {
                    // Handle login failure (e.g., invalid credentials)
                    Toast.makeText(MainActivity.this, "Invalid login credentials", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RefreshTokenDto> call, Throwable t) {
                // Handle network errors or other failures
                Toast.makeText(MainActivity.this, "Login failed: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
