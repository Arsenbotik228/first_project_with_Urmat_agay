package com.myself223.card.Fragments

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.myself223.card.R
import com.myself223.card.databinding.FragmentOnBoardBinding
import com.myself223.card.databinding.FragmentProfileBinding

class Profile_Fragment : Fragment() {
    private val binding : FragmentProfileBinding by lazy {
        FragmentProfileBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.prCvImg.clipToOutline = true
        val defaultName : String = "No Name"
        val defaultSurname : String = "No Surname"

        binding.btnSave.setOnClickListener {
            if (binding.etNewName == null && binding.etNewSurname == null){
                binding.tvName.text = defaultName
                binding.tvFamilia.text = defaultSurname
            }else{
                binding.tvName.text = binding.etNewName.text
                binding.tvFamilia.text = binding.etNewSurname.text
                binding.etNewName.text = null
                binding.etNewSurname.text = null
            }
        }
    }

}