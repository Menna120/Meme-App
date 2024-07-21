package com.example.meme_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.meme_app.databinding.FragmentMemeRecyclerBinding

class MemeRecyclerFragment : Fragment(), OnMemeClickListener {
    private lateinit var _binding: FragmentMemeRecyclerBinding
    private val binding get() = _binding
    private lateinit var recyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMemeRecyclerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.recyclerView
        recyclerView.adapter = MemeAdapter(this, MEME_ITEMS)
    }

    override fun onMemeClick(@DrawableRes imgResId: Int) {
        val bundle = Bundle().apply {
            putInt(requireContext().getString(R.string.image_res_id), imgResId)
        }
        val imageFullScreenFragment = ImageFullScreenFragment()
        imageFullScreenFragment.arguments = bundle
        parentFragmentManager.beginTransaction().replace(R.id.main, imageFullScreenFragment)
            .addToBackStack(null).commit()
    }
}
