package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        usernameEditText = findViewById(R.id.etUsername)
        passwordEditText = findViewById(R.id.etPassword)
        loginButton = findViewById(R.id.btnLogin)

        // Set click listener for login button
        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Simple validation
            if (username.isNotEmpty() && password.isNotEmpty()) {
                // For demo purposes, accept any non-empty username/password
                val intent = Intent(this, ListFoodActivity::class.java)
                startActivity(intent)
                finish() // Prevent going back to login screen
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}