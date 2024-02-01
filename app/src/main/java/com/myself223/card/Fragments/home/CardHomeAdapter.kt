package com.myself223.card.Fragments.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myself223.card.Fragments.Category.CategoryAdapter
import com.myself223.card.data.room.CategoryModel
import com.myself223.card.databinding.InCategoryBinding

class CardHomeAdapter(private val listener: Clickable): RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    private var list = ArrayList<CategoryModel>()
    private var inflater:LayoutInflater?=null
    fun addCategory(list:List<CategoryModel>){
        this.list.addAll(list)
        notifyDataSetChanged()
    }
    fun changeCategory(category: CategoryModel, position: Int) {
        list[position] = category
        notifyItemChanged(position)
    }

    fun getList(): List<CategoryModel>? {
        return list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.CategoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = InCategoryBinding.inflate(inflater, parent, false)
        return CategoryAdapter.CategoryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CategoryModel, position: Int) {


    }
    fun onBind(){

    }

    inner class HomeViewHolder(private val binding: InCategoryBinding): RecyclerView.ViewHolder(binding.root) {
        fun onBind(pos: Int) {
            binding.txtName.text = list[pos].name
        }
    }
    interface Clickable {



       /* fun edit(position: Int)
        fun delete(position: Int)*/
    }

}