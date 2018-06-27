package example.com.interviewincentro.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import example.com.interviewincentro.R
import example.com.interviewincentro.models.Dream

class DreamsAdapter(val context : Context, val dreams : List<Dream>, val onClick:(Dream)->Unit) : RecyclerView.Adapter<DreamsAdapter.MyHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): MyHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.dream_item,viewGroup,false)
        return MyHolder(v,onClick)
    }

    override fun getItemCount(): Int {
       return dreams.count()
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val mDream = dreams[position]
        holder.dreamtitleTV?.text=mDream.dreamtitle

        holder.dreamlabelTV?.text=mDream.label

        holder.exploreBT.setOnClickListener {
            onClick(mDream)
        }
    }


    inner class MyHolder(itemView: View,val onClick: (Dream) -> Unit): RecyclerView.ViewHolder(itemView) {
        var dreamtitleTV = itemView.findViewById<TextView>(R.id.item_dreamtitleTV)
        var exploreBT = itemView.findViewById<Button>(R.id.btnExplore)
        var dreamlabelTV = itemView.findViewById<TextView>(R.id.item_dreamlabelTV)


    }
}