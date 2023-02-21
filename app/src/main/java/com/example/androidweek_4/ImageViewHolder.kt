package com.example.androidweek_4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidweek_4.model.Image


class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    companion object {
        fun from(parent: ViewGroup): ImageViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val view =
                layoutInflater.inflate(R.layout.activity_object, parent, false)
            return ImageViewHolder(view)
        }
    }

    fun bindData(idol: Image) {
        val tv_Name = itemView.findViewById<TextView>(R.id.tv_name)
        val iv_Link_Pic = itemView.findViewById<ImageView>(R.id.iv_link_pic)
        val tv_Address = itemView.findViewById<TextView>(R.id.tv_address)
        tv_Name.text = idol.name
        tv_Address.text = idol.address
        Glide.with(itemView.context).load(idol.link).centerCrop().into(iv_Link_Pic)
    }
}