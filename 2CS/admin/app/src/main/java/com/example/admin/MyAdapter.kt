package com.example.admin

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.carenta.databinding.CarLayoutBinding

class MyAdapter(val context: Context,var data:List<Car>):RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(CarLayoutBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.apply {
            // We bring the image from the data base
            Glide.with(context).load(url+data[position].image).into(image)
            model.text = data[position].model
            //moteur.text = data[position].motor
            tarif.text = data[position].tarif+"0DA/day"
            if(data[position].disponibility=="1"){
                disponibility.text = "Available"
                disponibility.setTextColor(Color.GREEN)
            } else{
                disponibility.text = "Not Available"
                disponibility.setTextColor(Color.RED)
            }
        }

        // we display the car's in cards then once the user clicks on one of them we send the data to the next fragment
        val card = holder.binding.card
        card.setOnClickListener {
            var bundle = bundleOf("car" to data[position])
            it.findNavController().navigate(R.id.action_mainFragment_to_detailFragment,bundle)
        }
    }

    class MyViewHolder(val binding: CarLayoutBinding) : RecyclerView.ViewHolder(binding.root) {}

}