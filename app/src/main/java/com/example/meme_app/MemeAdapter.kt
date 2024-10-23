package com.example.meme_app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.meme_app.databinding.MemeItemBinding


class MemeAdapter(
    private val listener: OnMemeClickListener, private val memeItems: List<MemeItem>
) : RecyclerView.Adapter<MemeAdapter.ViewHolder>() {

    inner class ViewHolder(
        private val binding: MemeItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MemeItem) {
            binding.memeImage.apply {
                setImageResource(item.imageResId)
                setOnClickListener {
                    listener.onMemeClick(item.imageResId)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MemeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(memeItems[position])
    }

    override fun getItemCount(): Int = memeItems.size
}