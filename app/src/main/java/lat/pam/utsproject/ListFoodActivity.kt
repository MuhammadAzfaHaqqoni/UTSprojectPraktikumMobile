package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFoodActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FoodAdapter
    private lateinit var foodList: List<Food>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_food)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Prepare food data
        foodList = listOf(
            Food("Batagor", "Batagor asli enak dari Bandung", R.drawable.batagor),
            Food("Black Salad", "Salad segar yang dibuat secara langsung", R.drawable.black_salad),
            Food("Cappucino", "Kopi cappucino asli yang dibuat dari Kopi Arabica", R.drawable.cappuchino)
        )

        // Initialize adapter with click listener
        adapter = FoodAdapter(foodList) { selectedFood ->
            val intent = Intent(this, OrderActivity::class.java).apply {
                putExtra("FOOD_NAME", selectedFood.name)
                putExtra("FOOD_DESC", selectedFood.description)
                putExtra("FOOD_IMAGE", selectedFood.imageResourceId)
            }
            startActivity(intent)
        }

        recyclerView.adapter = adapter
    }
}