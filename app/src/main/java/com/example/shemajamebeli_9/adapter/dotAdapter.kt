package com.example.shemajamebeli_9.adapter

import android.app.Application
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.shemajamebeli_9.R
import com.example.shemajamebeli_9.databinding.DotBinding

val dots = mutableListOf<Int>(
    R.color.white,
    R.color.white,
    R.color.white,
    R.color.white
)
class dotAdapter(private var dots: MutableList<Int>, private val AppContext: Application)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class DotHolder(private val dotLayout: DotBinding) :
        RecyclerView.ViewHolder(dotLayout.root){
        fun bind(dot: Int, position: Int){
            dotLayout.imageView.setColorFilter(ContextCompat.getColor(AppContext, dot), android.graphics.PorterDuff.Mode.MULTIPLY)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val view = DotBinding.inflate(LayoutInflater.from(parent.context), parent, false)
          return  DotHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        return (holder as DotHolder).bind(dots[position], position)

    }
    override fun getItemCount(): Int {
        return dots.size
    }

}