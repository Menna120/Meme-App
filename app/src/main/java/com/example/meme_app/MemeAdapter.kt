package com.example.meme_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.meme_app.databinding.MemeItemBinding

class MemeAdapter(
    private val memeItems: List<MemeItem>,
    private val fragmentManager: FragmentManager
) :
    RecyclerView.Adapter<MemeAdapter.CardViewHolder>() {

    class CardViewHolder(val binding: MemeItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = MemeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val currentItem = memeItems[position]
        holder.binding.memeImage.apply {
            setImageResource(currentItem.imageResId)
            setOnClickListener {
                val bundle = Bundle().apply {
                    putInt("imageResId", currentItem.imageResId)
                }
                val imageFullScreenFragment = ImageFullScreenFragment()
                imageFullScreenFragment.arguments = bundle
                fragmentManager
                    .beginTransaction()
                    .replace(R.id.main, imageFullScreenFragment)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    override fun getItemCount(): Int = memeItems.size
}