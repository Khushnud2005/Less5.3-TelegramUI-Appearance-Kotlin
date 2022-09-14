package uz.exemple.less53_telegramui_appearance_kotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.exemple.less53_telegramui_appearance_kotlin.R
import uz.exemple.less53_telegramui_appearance_kotlin.model.ItemModel
import uz.exemple.less53_telegramui_appearance_kotlin.model.MainModel

class MainAdapter(var mList:ArrayList<MainModel<*>>):RecyclerView.Adapter<MainAdapter.ViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = mList[position]


        holder.item_rv!!.layoutManager = LinearLayoutManager(holder.itemView.context)

        val itemadapter = ItemAdapter(item.itemList as ArrayList<ItemModel>)
        holder.item_rv!!.adapter = itemadapter
    }

    override fun getItemCount(): Int {
        return mList.size
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var item_rv: RecyclerView? = null
        init {
            item_rv = itemView.findViewById(R.id.item_RV)
        }
    }
}