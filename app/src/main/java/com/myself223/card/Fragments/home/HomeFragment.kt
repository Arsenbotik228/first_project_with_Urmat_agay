package com.myself223.card.Fragments.home

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.myself223.card.App
import com.myself223.card.R
import com.myself223.card.data.room.CategoryModel
import com.myself223.card.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private var adapter: CardHomeAdapter? = null
    private var navController: NavController? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root


    }

    @SuppressLint("ResourceType")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!App.prefs.isShow()){
            findNavController().navigate(R.id.onBoard)
            App.prefs.changeShow(true)
        }


        binding.btnAdd.setOnClickListener{
            findNavController().navigateUp()
            findNavController().navigate(R.id.addCategoryFragment)
        }

        requireActivity().supportFragmentManager.setFragmentResultListener(
            "change_category", this
        ) { _, result ->
            val card: CategoryModel? = result.getSerializable("edit_category") as? CategoryModel
            card?.let {
                adapter?.changeNote(it, result.getInt("position"))
            }
        }
    }
}
