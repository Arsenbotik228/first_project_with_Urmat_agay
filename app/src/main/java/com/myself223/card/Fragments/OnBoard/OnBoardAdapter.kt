package com.myself223.card.Fragments.OnBoard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.myself223.card.R
import com.myself223.card.databinding.FragmentOnBoardBinding
import com.myself223.card.databinding.ItemOnBoardBinding

class OnBoardAdapter : RecyclerView.Adapter<OnBoardAdapter.BoardViewHolder>() {
    private val img = listOf(
        R.drawable.ic_launcher_background,
        R.drawable.img_1,
        R.drawable.img
    )
    private val title = listOf(
        "Title1",
        "Изучение",
        "Давайте начнём !"
    )
    private val desc = listOf(
        "Desc1",
        "Свайпайте карточку вправо если вы \n запомнили,влево если пока ещё не уверены",
        "Desc3"
    )
    inner class  BoardViewHolder( val binding: ItemOnBoardBinding):
        RecyclerView.ViewHolder(binding.root){
            fun onBind(position:Int){
                binding.bot.setImageResource(img[position])
                binding.textTitle.text = title[position]
                binding.desc.text = desc[position]

            }

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
        return BoardViewHolder(
            ItemOnBoardBinding.inflate(
                LayoutInflater.from(parent.context),parent,false
            )
        )

    }

    override fun getItemCount() = img.size







    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
        holder.onBind(position)
    }
}