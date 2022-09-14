package uz.exemple.less53_telegramui_appearance_kotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.switchmaterial.SwitchMaterial
import uz.exemple.less53_telegramui_appearance_kotlin.R
import uz.exemple.less53_telegramui_appearance_kotlin.model.ItemModel
import uz.exemple.less53_telegramui_appearance_kotlin.model.ThemeCardModel

class ItemAdapter(var itemList:ArrayList<ItemModel>):RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_child, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        if (item.cardList != null && position <= 1) {
            holder.switch1.visibility = View.GONE
        }

        holder.tv_childTitle.setText(item.title)

        if (item.desc != null) {
            holder.tv_childDesc.setText(item.desc)
            holder.tv_childDesc.visibility = View.VISIBLE
        }
        if (item.text2 != null) {
            holder.tv_text2.visibility = View.VISIBLE
            holder.tv_text2.setText(item.text2)
        }
        if (item.switch1) {
            holder.switch1.visibility = View.VISIBLE
            holder.switch1.isChecked = item.switchOnOff
            holder.iv_childRight.visibility = View.GONE
        }
        if (item.cardList != null) {
            val cardList: ArrayList<ThemeCardModel> = item.cardList!!
            val adapter = ItemChildAdapter(cardList)
            holder.rv_theme_cards.layoutManager =
                LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false)
            holder.rv_theme_cards.adapter = adapter
        }
        if (position == itemList.size - 1) {
            holder.Ll_line.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var iv_childRight: ImageView
        lateinit var tv_childTitle: TextView
        lateinit var Ll_line: LinearLayout
        lateinit var tv_childDesc: TextView
        lateinit var tv_text2: TextView
        lateinit var switch1: SwitchMaterial
        lateinit var rv_theme_cards: RecyclerView

        init {
            rv_theme_cards = itemView.findViewById(R.id.rv_theme_cards)
            iv_childRight = itemView.findViewById(R.id.iv_childRight)
            tv_childTitle = itemView.findViewById(R.id.tv_childTitle)
            tv_childDesc = itemView.findViewById(R.id.tv_childDesc)
            tv_text2 = itemView.findViewById(R.id.tv_text2)
            Ll_line = itemView.findViewById(R.id.Ll_line)
            switch1 = itemView.findViewById(R.id.switch1)
        }
    }


}