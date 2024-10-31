package com.mobile.wisatamaps

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobile.wisatamaps.adapter.WisataAdapter
import com.mobile.wisatamaps.model.WisataModel

class ListWisata : AppCompatActivity() {

    private var rv_wisata: RecyclerView? = null
    private var WisataAdapter: WisataAdapter? = null

    //array data doctor
    private var wisataList = mutableListOf<WisataModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_wisata)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        rv_wisata = findViewById(R.id.rv_wisata)
        wisataList = ArrayList()
        WisataAdapter= WisataAdapter(this,wisataList);
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(this,1)
        rv_wisata!!.layoutManager = layoutManager
        rv_wisata!!.adapter = WisataAdapter

        //create dummy data
        prepareDataWisata()

    }

    private fun prepareDataWisata() {
        var itemWisata = WisataModel(
            R.drawable.lembah,
            "Lembah Anai",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                    "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
                    "when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
            "padang panjang",-0.48368373335193415, 100.33805669992879
        )
        wisataList.add(itemWisata)
        itemWisata = WisataModel(
            R.drawable.jamgadang,
            "Jam Gadang",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                    "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
                    "when an unknown printer took a galley of type and scrambled it to make a type specimen book."
            ,"bukittinggi",-0.304878, 100.369526

        )
        wisataList.add(itemWisata)
        itemWisata = WisataModel(
            R.drawable.singkarak,
            "Danau Singkarak",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                    "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
                    "when an unknown printer took a galley of type and scrambled it to make a type specimen book."
            ,"singkarak",-0.6006373271558244, 100.53518542809739

        )
        wisataList.add(itemWisata)
        itemWisata = WisataModel(
            R.drawable.kembar,
            "Danau Kembar",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                    "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
                    "when an unknown printer took a galley of type and scrambled it to make a type specimen book."
            ,"solok",-1.0489254314242376, 100.72760195145673

        )
        wisataList.add(itemWisata)
        itemWisata = WisataModel(
            R.drawable.padang,
            "Pantai Padang",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                    "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
                    "when an unknown printer took a galley of type and scrambled it to make a type specimen book."
            ,"padang",-0.9274260537275514, 100.34952707129173

        )
        wisataList.add(itemWisata)
        WisataAdapter!!.notifyDataSetChanged()
    }
}