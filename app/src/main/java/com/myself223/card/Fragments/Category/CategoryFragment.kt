package com.myself223.card.Fragments.Category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.myself223.card.data.room.CategoryModel
import com.myself223.card.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment() {


    private lateinit var binding: FragmentCategoryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }

        if (arguments != null) {
            val list = arguments?.getSerializable("pos") as List<CategoryModel>
            makeText(requireContext(), list[0].name, Toast.LENGTH_SHORT).show()
        }

    }

}

