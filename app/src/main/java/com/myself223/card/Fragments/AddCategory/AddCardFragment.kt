
package com.myself223.card.Fragments.AddCategory

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.myself223.card.App
import com.myself223.card.R
import com.myself223.card.data.room.models.CardModel
import com.myself223.card.data.room.models.CategoryModel
import com.myself223.card.databinding.FragmentAddCardBinding
import java.io.FileNotFoundException


class AddCardFragment : Fragment() {
    private val binding: FragmentAddCardBinding by lazy {
        FragmentAddCardBinding.inflate(layoutInflater)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments != null) {
            val text = arguments?.getString("key").toString()
            if (text == "element") {
                val pos = arguments?.getInt("position")!!
                val list = arguments?.getSerializable("list") as List<CategoryModel>

                binding.btnSave.setOnClickListener {
                    val name = binding.edNameCategory.text.toString()
                    val models = ArrayList<CategoryModel>()
                    models.add(CategoryModel(name = name, image = "", id = 0))

                    App.database.getDao().updateCard(
                        CardModel(
                        list[pos].id,
                        list[pos].name, models)
                    )
                    findNavController().navigateUp()
                }

            } else {
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
        binding.imgAdd.setOnClickListener {
            val photoPickerIntent = Intent(Intent.ACTION_PICK)
            photoPickerIntent.type = "image/*"
            startActivityForResult(photoPickerIntent, 1)
        }
    }
    override fun onActivityResult(reqCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(reqCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            try {
                if (data?.data != null) {
                    val imageUri = data.data
                    val imageStream = requireActivity().contentResolver.openInputStream(imageUri!!)
                    val selectedImage = BitmapFactory.decodeStream(imageStream)
                    binding.imgAdd?.setImageBitmap(selectedImage)
                } else {
                    Toast.makeText(requireActivity(), "No image selected", Toast.LENGTH_LONG).show()
                }
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
                Toast.makeText(requireActivity(), "Something went wrong", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(requireActivity(), "You haven't picked Image", Toast.LENGTH_LONG).show()
        }
    }



}
