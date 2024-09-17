package com.example.mypokedex;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mypokedex.api.API;
import com.example.mypokedex.dto.request.SignUpDto;
import com.example.mypokedex.dto.response.UserDto;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Signupactivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText addressEditText;
    private EditText ageEditText;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        nameEditText = findViewById(R.id.signup_name);
        addressEditText = findViewById(R.id.signup_address);
        ageEditText = findViewById(R.id.signup_age);
        usernameEditText = findViewById(R.id.signup_username);
        passwordEditText = findViewById(R.id.signup_password);
        signupButton = findViewById(R.id.signup_button);

        signupButton.setOnClickListener(v -> {
            String name = nameEditText.getText().toString();
            String address = addressEditText.getText().toString();
            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            int age;

            try {
                age = Integer.parseInt(ageEditText.getText().toString());
            } catch (NumberFormatException e) {
                Toast.makeText(Signupactivity.this, "Invalid age", Toast.LENGTH_SHORT).show();
                return;
            }

            SignUpDto SignUpDto = new SignUpDto(username, password, name, address, age);

            API.userApi().signup(SignUpDto).enqueue(new Callback<UserDto>() {
                @Override
                public void onResponse(Call<UserDto> call, Response<UserDto> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        Toast.makeText(Signupactivity.this, "Signup successful", Toast.LENGTH_SHORT).show();
                        // Navigate to login or another activity
                    } else {
                        Toast.makeText(Signupactivity.this, "Signup failed: " + response.message(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<UserDto> call, Throwable t) {
                    Toast.makeText(Signupactivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}
