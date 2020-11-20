package ca.qc.cgodin.projetfinal.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ca.qc.cgodin.projetfinal.R
import ca.qc.cgodin.projetfinal.bd.Converters
import ca.qc.cgodin.projetfinal.models.Restaurant
import ca.qc.cgodin.projetfinal.util.Constants.Companion.API_KEY
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_resto.view.*

class RestaurantAdapter: RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>() {

    inner class RestaurantViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    private val differCallback = object: DiffUtil.ItemCallback<Restaurant>() {
        override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem.place_id == newItem.place_id
        }

        override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        return RestaurantViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_resto,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val restaurant = differ.currentList[position]

        holder.itemView.apply{
            Glide.with(this).load("https://maps.googleapis.com/maps/api/place/" +
                    "photo?maxwidth=400&photoreference="+restaurant.photos[0].photo_reference + "&key=" + API_KEY).into(ivLogo)
            tvName.text = restaurant.name.toString()
            //tvOpen_now.text = if (restaurant.opening_hours.open_now) "Overt" else "Fermé"
            tvOpen_now.text = restaurant.vicinity

            setOnClickListener{
                onItemClickListener?.let {it(restaurant)}
            }
        }
    }

    private var onItemClickListener: ((Restaurant) -> Unit)? = null

    fun setOnItemClickListener(listener: (Restaurant)->Unit) {
        onItemClickListener = listener
    }
}