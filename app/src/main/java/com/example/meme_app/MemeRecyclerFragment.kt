package com.example.meme_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.meme_app.databinding.FragmentMemeRecyclerBinding


class MemeRecyclerFragment : Fragment() {
    private var _binding: FragmentMemeRecyclerBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private var motionLayoutState = -1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMemeRecyclerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (motionLayoutState != -1) binding.motionLayout.jumpToState(motionLayoutState)
        recyclerView = binding.recyclerView
        recyclerView.adapter = MemeAdapter(MEME_ITEMS, parentFragmentManager)
    }

    override fun onPause() {
        super.onPause()
        motionLayoutState = binding.motionLayout.currentState
    }

}