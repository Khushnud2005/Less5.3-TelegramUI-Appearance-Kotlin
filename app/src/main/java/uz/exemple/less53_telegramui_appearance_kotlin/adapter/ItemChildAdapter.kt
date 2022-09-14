package uz.exemple.less53_telegramui_appearance_kotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import uz.exemple.less53_telegramui_appearance_kotlin.R
import uz.exemple.less53_telegramui_appearance_kotlin.model.ThemeCardModel

class ItemChildAdapter(var cardList:ArrayList<ThemeCardModel>):RecyclerView.Adapter<ItemChildAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val card = cardList[position]
        holder.cardImage.setImageResource(card.themeCards)
    }

    override fun getItemCount(): Int {
        return cardList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var cardImage: ImageView
        init {
            cardImage = itemView.findViewById(R.id.iv_card_item)
        }
    }
}