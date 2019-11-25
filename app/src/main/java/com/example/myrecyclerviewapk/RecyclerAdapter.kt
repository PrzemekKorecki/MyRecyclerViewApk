package com.example.myrecyclerviewapk

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.mycardview.view.*

class RecyclerAdapter (val items:ArrayList<PersonData>,
                       val clickListener:(PersonData, Int)->Unit):RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.mycardview, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var item:PersonData = items[position]

        holder.itemView.setOnClickListener({
            clickListener(item, position)
        })

        holder.lblName.text = items[position].name
        holder.lblPhoneNumber.text = items[position].phoneNumber
    }

}


class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
    val lblName = view.lblName
    val lblPhoneNumber = view.lblPhoneNumber
}