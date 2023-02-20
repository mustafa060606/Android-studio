package com.mustafa.yemektarifleri

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_row.view.*

class ListeRecycleradapter(val yemekListesi:ArrayList<String>,val idListesi:ArrayList<Int>) : RecyclerView.Adapter<ListeRecycleradapter.YemekHolder>() {

    class YemekHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YemekHolder { //hangi row 'u hangi tasarımla oluşturacağımızı belirler.
        val inflater =LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.recycler_row,parent,false)
        return YemekHolder(view)
    }

    override fun getItemCount(): Int { //kaç tane recycler row oluşturacağımızı belirleriz.
        return yemekListesi.size
    }

    override fun onBindViewHolder(holder: YemekHolder, position: Int) { //recycler_row da  oluşturduğumuz yerlerin içine ne koyucaz onu belirleriz.
        holder.itemView.recyclerRowText.text=yemekListesi[position]
        holder.itemView.setOnClickListener {
        val action = ListeFragmentDirections.actionListeFragmentToTarifFragment("recyclerdangeldim",idListesi[position])
            Navigation.findNavController(it).navigate(action)
        }
    }
}