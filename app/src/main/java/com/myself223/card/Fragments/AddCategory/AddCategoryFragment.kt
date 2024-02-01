package com.myself223.card.Fragments.AddCategory

import android.app.Application
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.myself223.card.App
import com.myself223.card.data.room.CardModel
import com.myself223.card.data.room.CategoryModel
import com.myself223.card.databinding.FragmentAddCategoryBinding


class AddCategoryFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentAddCategoryBinding
    private var navController:NavController? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding = FragmentAddCategoryBinding.inflate(inflater,container,false)
         return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        val bundle = Bundle()
        binding.imgAdd.setOnClickListener {
            val photoPickerIntent = Intent(Intent.ACTION_PICK)
            photoPickerIntent.type = "image/*"
            startActivityForResult(photoPickerIntent, 1)
        }
        if (arguments!= null){
            binding.edNameCategory.setText(requireArguments().getString("changeTitle"))
            binding.btnSave.setOnClickListener{
                val changeTitle = binding.edNameCategory.text.toString()
                val position = requireArguments().getInt("position")
                val category = CategoryModel(changeTitle, 1.toString())
                bundle.putSerializable("edit_category",category)
                bundle.putInt("position",position)
                requireActivity().supportFragmentManager.setFragmentResult("change_category", bundle)
                requireActivity().supportFragmentManager.popBackStack()
            }
        }else{
            binding.btnSave.setOnClickListener {
                val name = binding.edNameCategory.text.toString()
                val list = ArrayList<CategoryModel>()


                App.database.getDao().insertCard(
                    CardModel(name = name, list = list)
                )
                findNavController().navigateUp()
            }
        }




    }
    }






