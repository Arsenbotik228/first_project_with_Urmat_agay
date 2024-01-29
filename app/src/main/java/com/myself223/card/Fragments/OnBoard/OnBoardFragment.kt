package com.myself223.card.Fragments.OnBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.myself223.card.databinding.FragmentOnBoard2Binding
import com.myself223.card.MainActivity

class OnBoardFragment : Fragment() {
    private lateinit var binding: FragmentOnBoard2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoard2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = OnBoardAdapter()
        binding.viwePager2.adapter = adapter

        val mainActivity = activity as? MainActivity
        mainActivity?.hideBottomNav()
    }

    override fun onDestroyView() {
        val mainActivity = activity as? MainActivity
        mainActivity?.showBottomNav()
        super.onDestroyView()
    }
}
