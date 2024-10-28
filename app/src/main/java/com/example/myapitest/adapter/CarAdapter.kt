package com.example.myapitest.adapter

import com.example.myapitest.model.Car
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapitest.R
import com.example.myapitest.ui.CircleTransform
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

class CarAdapter(
    private val cars: List<Car>,
    private val carClickListener: (Car) -> Unit,
) : RecyclerView.Adapter<CarAdapter.CarViewHolder>(){
    class CarViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.image)
        val modelView : TextView = view.findViewById(R.id.model)
        val yearlView : TextView = view.findViewById(R.id.year)
        val licenseView : TextView = view.findViewById(R.id.license)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_car_layout, parent, false)
        return CarViewHolder(view)
    }

    override fun getItemCount(): Int = cars.size

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val car = cars[position]
        holder.itemView.setOnClickListener{
            carClickListener.invoke(car)
        }
        holder.modelView.text = car.value.name
        holder.yearlView.text = car.value.year
        holder.licenseView.text = car.value.licence

        Picasso.get()
            .load(car.value.imageUrl)
            .placeholder(R.drawable.ic_download)
            .error(R.drawable.ic_error)
            .transform(CircleTransform())
            .into(holder.imageView)
    }
}