package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ConfirmationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)

        // Get data from intent
        val foodName = intent.getStringExtra("FOOD_NAME")
        val servings = intent.getStringExtra("SERVINGS")
        val orderingName = intent.getStringExtra("ORDERING_NAME")
        val notes = intent.getStringExtra("NOTES")

        // Update TextViews with order details
        findViewById<TextView>(R.id.tvFoodName).text = "Food Name: $foodName"
        findViewById<TextView>(R.id.tvServings).text = "Number of Servings: $servings pax"
        findViewById<TextView>(R.id.tvOrderingName).text = "Ordering Name: $orderingName"
        findViewById<TextView>(R.id.tvNotes).text = "Additional Notes: $notes"

        // Handle back to menu button
        findViewById<Button>(R.id.backtoMenu).setOnClickListener {
            // Clear activity stack and go back to ListFoodActivity
            val intent = Intent(this, ListFoodActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }
}