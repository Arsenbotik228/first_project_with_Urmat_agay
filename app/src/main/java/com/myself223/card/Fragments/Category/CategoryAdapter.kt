package com.myself223.card.Fragments.Category

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myself223.card.data.room.CategoryModel
import com.myself223.card.databinding.ItemCategoriBinding

class CategoryAdapter(private val listener: Context):RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>(){
    private var list = arrayListOf<CategoryModel>()

    fun addCategory(list:ArrayList<CategoryModel>) {
        this.list = list
        notifyDataSetChanged()

    }
    fun changeCategory(categoryModel: CategoryModel,position: Int){
        list[position]= categoryModel
        notifyItemChanged(position)
    }
    fun getList():List<CategoryModel>{
        return list
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCategoriBinding.inflate(inflater, parent, false)
        return CategoryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.onBind(list[position])
        holder.binding.tvCategory


    }

    class CategoryViewHolder constructor(val binding: ItemCategoriBinding) :RecyclerView.ViewHolder(binding.root)
    {

        fun onBind(category: CategoryModel) {
            binding.tvCategory

        }
    }
    interface Clickable {
        /*fun edit(position: Int)
        fun delete(position: Int)
        fun share(note: Notes)*/
    }
}