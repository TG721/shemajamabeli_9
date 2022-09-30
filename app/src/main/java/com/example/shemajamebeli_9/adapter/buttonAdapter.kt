package com.example.shemajamebeli_9.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shemajamebeli_9.databinding.ButtonwithimageBinding
import com.example.shemajamebeli_9.databinding.ButtonwithoutimageBinding
import com.example.shemajamebeli_9.model.buttonModel

class buttonAdapter(private var buttons: MutableList<buttonModel>, private val click: (buttonModel) -> Unit)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class ButtonWithImageHolder(private val buttonWithImage: ButtonwithimageBinding) :
        RecyclerView.ViewHolder(buttonWithImage.root){
        fun bind(button: buttonModel, position: Int){
            buttonWithImage.imageInside.setImageResource(button.image!!)
            buttonWithImage.imageView.setOnClickListener {
                click(button)
            }
        }
    }
    inner class ButtonWithOutImageHolder(private val buttonWithOutImage: ButtonwithoutimageBinding) :
        RecyclerView.ViewHolder(buttonWithOutImage.root){
        fun bind(button: buttonModel, position: Int){
            buttonWithOutImage.textNumber.text = button.number.toString()
            buttonWithOutImage.imageView.setOnClickListener {
                click(button)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if(viewType==1){
            val view = ButtonwithimageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            ButtonWithImageHolder(view)
        } else {
            val view = ButtonwithoutimageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            ButtonWithOutImageHolder(view)
        }

    }
    override fun getItemViewType(position: Int): Int {
        if (buttons[position].hasImage) return 1
        if (!buttons[position].hasImage) return 2
        return  0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        return if (getItemViewType(position) == 1) (holder as ButtonWithImageHolder).bind(buttons[position], position)
        else (holder as ButtonWithOutImageHolder).bind(buttons[position], position)

    }
    override fun getItemCount(): Int {
        return buttons.size
    }

}