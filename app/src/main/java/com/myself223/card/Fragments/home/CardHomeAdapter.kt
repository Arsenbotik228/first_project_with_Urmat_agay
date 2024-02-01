package com.myself223.card.Fragments.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myself223.card.data.room.CategoryModel
import com.myself223.card.databinding.InCategoryBinding

class CardHomeAdapter(private val listener: Clickable): RecyclerView.Adapter<CardHomeAdapter.NoteViewHolder>() {
    private var list = ArrayList<CategoryModel>()
    private var inflater:LayoutInflater?=null
    fun addCategory(list:List<CategoryModel>){
        this.list.addAll(list)
        notifyDataSetChanged()
    }
    fun changeNote(category: CategoryModel, position: Int) {
        list[position] = category
        notifyItemChanged(position)
    }

    fun getList(): List<CategoryModel>? {
        return list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = InCategoryBinding.inflate(inflater, parent, false)
        return NoteViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {


    }
    fun onBind(){

    }

   inner class NoteViewHolder(val binding: InCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {}


    interface Clickable {



       /* fun edit(position: Int)
        fun delete(position: Int)*/
    }

}