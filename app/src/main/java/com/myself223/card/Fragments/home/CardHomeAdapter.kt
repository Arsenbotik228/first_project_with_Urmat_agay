package com.myself223.card.Fragments.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.WindowInsetsAnimationControlListener
import androidx.recyclerview.widget.RecyclerView
import com.myself223.card.databinding.InCategoryBinding
import java.util.Locale.Category

class CardHomeAdapter(private val listener: Clickable): RecyclerView.Adapter<CardHomeAdapter.NoteViewHolder>() {
    private var list = ArrayList<Category>()
    private var inflater:LayoutInflater?=null
    fun addCategory(list:List<Category>){
        this.list.addAll(list)
        notifyDataSetChanged()
    }
    fun changeNote(category: Category, position: Int) {
        list[position] = category
        notifyItemChanged(position)
    }

    fun getList(): List<Category>? {
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

    class NoteViewHolder(val binding: InCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    interface Clickable {
        fun edit(position: Int)
        fun delete(position: Int)
    }

}