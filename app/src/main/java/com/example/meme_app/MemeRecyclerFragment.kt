package com.example.meme_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.meme_app.databinding.FragmentMemeRecyclerBinding


class MemeRecyclerFragment : Fragment() {
    private var _binding: FragmentMemeRecyclerBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private val memeItems = listOf(
        MemeItem(R.drawable.image_1),
        MemeItem(R.drawable.image_2),
        MemeItem(R.drawable.image_3),
        MemeItem(R.drawable.image_4),
        MemeItem(R.drawable.image_5),
        MemeItem(R.drawable.image_6),
        MemeItem(R.drawable.image_7),
        MemeItem(R.drawable.image_8),
        MemeItem(R.drawable.image_9),
        MemeItem(R.drawable.image_10),
        MemeItem(R.drawable.image_11),
        MemeItem(R.drawable.image_12),
        MemeItem(R.drawable.image_13),
        MemeItem(R.drawable.image_14),
        MemeItem(R.drawable.image_15),
        MemeItem(R.drawable.image_16),
        MemeItem(R.drawable.image_17),
        MemeItem(R.drawable.image_18),
        MemeItem(R.drawable.image_19),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMemeRecyclerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.recyclerView
        recyclerView.adapter = MemeAdapter(memeItems, parentFragmentManager)
    }

}