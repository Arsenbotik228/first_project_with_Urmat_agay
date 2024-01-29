package com.myself223.card.Fragments.OnBoard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myself223.card.R
import com.myself223.card.databinding.ItemOnBoardBinding

class OnBoardAdapter : RecyclerView.Adapter<OnBoardAdapter.BoardViewHolder>() {
    private val img = listOf(
        R.drawable.img_2,
        R.drawable.img,
        R.drawable.img_1
    )
    private val title = listOf(
        "ЧУХАНИ ПИСЮНЧИК!",
        "Я ПРИЕМНЫЙ",
        "ЛИСТАНИ ЕСЛИ ГЕЙ!"
    )
    private val desc = listOf(
        "ВАШИ РОДИТЕЛИ СЛУЧАЙНО НЕ ПИРАТЫ?",
        "СЕРЬЕЗНО ПОСМОТРИТЕ КАРТИНКУ СВЕРХУ",
        "И ПРОЧИТАЙ ЭТО ЕСЛИ ГЕЙ"
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