package com.myself223.card.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.myself223.card.R
import com.myself223.card.databinding.FragmentCategoryBinding
import com.myself223.card.databinding.FragmentHomeBinding

class CategoryFragment : Fragment() {
    private var navController: NavController? = null
    lateinit var binding: FragmentCategoryBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }
}


