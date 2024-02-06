package com.myself223.card.Fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.card.fragments.cardhomeadapter.CardHomeAdapter
import com.myself223.card.App
import com.myself223.card.Fragments.AddCategory.AddCategoryFragment
import com.myself223.card.R
import com.myself223.card.data.room.models.CategoryModel
import com.myself223.card.databinding.FragmentHomeBinding


class HomeFragment : Fragment(), CardHomeAdapter.Result {
    private var navController: NavController? = null



    private val binding: FragmentHomeBinding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }

    private lateinit var adapter: CardHomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController = findNavController()
        initOnBoard()
        initAdapter()
        binding.btnAdd.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("key" ,"category")
            findNavController().navigate(R.id.addCategoryFragment,bundle)
        }

    }

    private fun initAdapter() {
        adapter = CardHomeAdapter(this)
        adapter.setList(App.database.getDao().getAllCard())
        binding.rvMain.adapter = adapter
    }

    private fun initOnBoard() {
        if (!App.prefs.isShow()) {
            App.prefs.changeShow(true)
            findNavController().navigate(R.id.onBoard)
        }
    }

    override fun OnClick(pos: Int, list: List<CategoryModel>) {
        val bundle  = Bundle()
        val cat = ArrayList(list)
        bundle.putSerializable("list", cat)
        bundle.putInt("pos",pos)
        findNavController().navigate(R.id.categoryFragment, bundle)
    }


}