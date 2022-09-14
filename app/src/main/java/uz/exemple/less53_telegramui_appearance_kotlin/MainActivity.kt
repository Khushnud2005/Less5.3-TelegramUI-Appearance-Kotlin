package uz.exemple.less53_telegramui_appearance_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.exemple.less53_telegramui_appearance_kotlin.adapter.MainAdapter
import uz.exemple.less53_telegramui_appearance_kotlin.model.ItemModel
import uz.exemple.less53_telegramui_appearance_kotlin.model.MainModel
import uz.exemple.less53_telegramui_appearance_kotlin.model.ThemeCardModel

class MainActivity : AppCompatActivity() {
    private lateinit var mList: ArrayList<MainModel<*>>
    private lateinit var list: ArrayList<ItemModel>
    private lateinit var list2: ArrayList<ItemModel>
    private lateinit var list3: ArrayList<ItemModel>
    private lateinit var list4: ArrayList<ItemModel>
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MainAdapter
    lateinit var cardList: ArrayList<ThemeCardModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    fun initViews() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val cardList = ArrayList<ThemeCardModel>()
        cardList.add(ThemeCardModel(R.drawable.card1))
        cardList.add(ThemeCardModel(R.drawable.card2))
        cardList.add(ThemeCardModel(R.drawable.card3))
        cardList.add(ThemeCardModel(R.drawable.card1))
        cardList.add(ThemeCardModel(R.drawable.card2))
        cardList.add(ThemeCardModel(R.drawable.card3))
        cardList.add(ThemeCardModel(R.drawable.card1))
        cardList.add(ThemeCardModel(R.drawable.card2))
        cardList.add(ThemeCardModel(R.drawable.card3))
        list = ArrayList()
        list.add(ItemModel("Chat Themes", null, null, cardList, false, false))
        list.add(ItemModel("Chat Background", null, null, null, false, false))

        list2 = ArrayList()
        list2.add(ItemModel("Night Mode", null, null, null, true, false))
        list2.add(ItemModel("Auto Night Mode", null, "System", null, false, false))

        list3 = ArrayList()
        list3.add(ItemModel("In-App Browser","Open extremal links within the app",null,null,true,true))
        list3.add(ItemModel("Direct Share","Show recent chats in Android share menu",null,null,true,false))
        list3.add(ItemModel("Enable Animations", null, null, null, true, true))

        list4 = ArrayList()
        list4.add(ItemModel("Large Emoji", null, null, null, true, true))
        list4.add(ItemModel("Raise To Speak", null, null, null, true, false))
        list4.add(ItemModel("Send With Enter", null, null, null, true, false))
        list4.add(ItemModel("Save To Gallery", null, null, null, true, false))
        list4.add(ItemModel("Distance Units", null, "Automatic", null, false, false))

        mList = ArrayList()
        mList.add(MainModel(list))
        mList.add(MainModel(list2))
        mList.add(MainModel(list3))
        mList.add(MainModel(list4))
        adapter = MainAdapter(mList)
        recyclerView.adapter = adapter
    }
}