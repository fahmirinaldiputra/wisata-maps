package com.mobile.wisatamaps.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.mobile.wisatamaps.DetailWisata
import com.mobile.wisatamaps.ListWisata
import com.mobile.wisatamaps.R
import com.mobile.wisatamaps.model.WisataModel

class WisataAdapter (
    val getListWisata: ListWisata,
    val itemWisataList: List<WisataModel>
) : RecyclerView.Adapter<WisataAdapter.MyViewHolder>(){
    class MyViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        var imgageWisata : ImageView = itemView.findViewById(R.id.imgWisata)
        var txtNamaWisata : TextView = itemView.findViewById(R.id.txtNamaWisata)
        var txtLokasi : TextView = itemView.findViewById(R.id.txtLokasi)
        val cardWisata : CardView = itemView.findViewById(R.id.cardWisata)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val nView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_wisata, parent, false)
        return MyViewHolder(nView)
    }

    override fun getItemCount(): Int {
        return itemWisataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = itemWisataList[position]
        holder.txtNamaWisata.text = currentItem.detailwisata
        holder.txtLokasi.text = currentItem.lokasiWisata
        holder.imgageWisata.setImageResource(currentItem.imageWisata)

        holder.cardWisata.setOnClickListener(){

            //deklarasi intent
            val intent = Intent(getListWisata, DetailWisata::class.java)
            //put Extra
            intent.putExtra("ImageWisata", itemWisataList[position].imageWisata)
            intent.putExtra("NamaWisata",itemWisataList[position].detailwisata)
            intent.putExtra("LokasiWisata",itemWisataList[position].lokasiWisata)
            intent.putExtra("Keterangan",itemWisataList[position].keterangan)
            //intent.putExtra("judul",itemList[position].judul)

            //tambahkan latitude longitude
            intent.putExtra("latitude",itemWisataList[position].latitude)
            intent.putExtra("longitude",itemWisataList[position].longitude)



            // start pindah ke detail
            getListWisata.startActivity(intent)

            Toast.makeText(getListWisata,itemWisataList[position].detailwisata, Toast.LENGTH_SHORT).show()

        }

    }
}