package com.myself223.card.Fragments.AddCategory

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.myself223.card.App
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
     /*   val bundle = Bundle()
        if (arguments!= null){
            binding.edNameCategory.setText(requireArguments().getString("changeTitle"))
            binding.btnSave.setOnClickListener{
                val changeTitle = binding.edNameCategory.text.toString()
                val position = requireArguments().getInt("position")
                val category = CategoryModel(changeTitle,0)
                bundle.putSerializable("edit_category",category)
                bundle.putInt("position",position)
                requireActivity().supportFragmentManager.setFragmentResult("change_category", bundle)
                requireActivity().supportFragmentManager.popBackStack()
            }
        }/*else{
            binding.btnSave.setOnClickListener {
                val name = binding.edNameCategory.text.toString()
                val image =
                val category = CategoryModel(name = name, image = )

                App.db.getDao().insertNotes(category)
                navController?.navigateUp()
            }
        }




    */}*/
    }

}




