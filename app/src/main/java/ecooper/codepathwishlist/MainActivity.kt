package ecooper.codepathwishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val items : MutableList<Item> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemsRV = findViewById<RecyclerView>(R.id.itemsRV)
        val adapter = ItemAdapter(items)
        itemsRV.adapter = adapter
        itemsRV.layoutManager = LinearLayoutManager(this)

        val newItem = findViewById<Button>(R.id.newItem)
        val newName = findViewById<EditText>(R.id.newName)
        val newPrice = findViewById<EditText>(R.id.newPrice)
        val newStore = findViewById<EditText>(R.id.newStore)

        newItem.setOnClickListener {
            // Check that name and price fields are filled
            // If newPrice is empty, app will crash due to parsing as float
            if (newName.text.isEmpty() || newPrice.text.isEmpty()) {
                Toast.makeText(this@MainActivity, "Name and price must be set", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            items.add(Item(newName.text.toString(), newPrice.text.toString().toFloat(), newStore.text.toString()))

            newName.text.clear()
            newPrice.text.clear()
            newStore.text.clear()

            adapter.notifyDataSetChanged()
        }
    }
}