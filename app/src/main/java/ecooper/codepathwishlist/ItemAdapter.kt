package ecooper.codepathwishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private val items: List<Item>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemName: TextView
        var itemPrice: TextView
        var itemUri: TextView

        init {
            itemName = itemView.findViewById(R.id.itemName)
            itemPrice = itemView.findViewById(R.id.itemPrice)
            itemUri = itemView.findViewById(R.id.itemUri)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val newView = inflater.inflate(R.layout.item, parent, false)
        return ViewHolder(newView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.itemName.text = item.name
        holder.itemPrice.text = "$" + item.price
        holder.itemUri.text = item.store
    }

    override fun getItemCount(): Int {
        return items.size
    }
}