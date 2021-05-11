package com.arya.laptopcatalog

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arya.laptopcatalog.databinding.ItemRowLaptopBinding
import com.bumptech.glide.Glide

class ListLaptopAdapter(
    private val listLaptop: ArrayList<Laptop>
) : RecyclerView.Adapter<ListLaptopAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ListViewHolder(val binding: ItemRowLaptopBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(
            ItemRowLaptopBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = listLaptop.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val laptop = listLaptop[position]

        Glide.with(holder.itemView.context)
            .load(laptop.photo)
            .into(holder.binding.imgItemPhoto)

        holder.binding.tvItemName.text = laptop.name
        holder.binding.tvItemDetail.text = laptop.detail
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listLaptop[holder.bindingAdapterPosition])
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Laptop)
    }
}
