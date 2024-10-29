package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        // Get data from intent
        val foodName = intent.getStringExtra("FOOD_NAME") ?: ""

        // Initialize views
        val foodNameTextView = findViewById<TextView>(R.id.etFoodName)
        val servingsEditText = findViewById<EditText>(R.id.etServings)
        val nameEditText = findViewById<EditText>(R.id.etName)
        val notesEditText = findViewById<EditText>(R.id.etNotes)
        val orderButton = findViewById<Button>(R.id.btnOrder)

        // Set food name
        foodNameTextView.text = foodName

        // Handle order button click
        orderButton.setOnClickListener {
            val servings = servingsEditText.text.toString()
            val orderingName = nameEditText.text.toString()
            val notes = notesEditText.text.toString()

            if (servings.isNotEmpty() && orderingName.isNotEmpty()) {
                val intent = Intent(this, ConfirmationActivity::class.java).apply {
                    putExtra("FOOD_NAME", foodName)
                    putExtra("SERVINGS", servings)
                    putExtra("ORDERING_NAME", orderingName)
                    putExtra("NOTES", notes)
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please fill all required fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}