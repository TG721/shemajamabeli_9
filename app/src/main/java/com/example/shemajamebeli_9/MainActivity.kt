package com.example.shemajamebeli_9

import android.app.Application
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shemajamebeli_9.adapter.buttonAdapter
import com.example.shemajamebeli_9.adapter.dotAdapter
import com.example.shemajamebeli_9.adapter.dots
import com.example.shemajamebeli_9.databinding.ActivityMainBinding
import com.example.shemajamebeli_9.model.buttonModel
import com.example.shemajamebeli_9.model.items
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

const val passcode =  "0934"

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterDots: dotAdapter
    @Inject
    lateinit var appContext: Application
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setup()
//        listeners()
    }

    private fun listeners() {

    }

    private fun setup() {
        val adapterButtons: buttonAdapter = buttonAdapter(items) {
            onButtonAdapterClick(it)
        }
         adapterDots = dotAdapter(dots, appContext)
        val recyclerViewButtons = binding.recyclerView
        recyclerViewButtons.adapter = adapterButtons
        val recyclerViewDots = binding.recyclerViewTop
        recyclerViewDots.adapter = adapterDots
        recyclerViewButtons.layoutManager = GridLayoutManager(this@MainActivity,3)
        recyclerViewDots.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
    }

    private var inputNum: String = ""
    private var counter: Int = 0
    private fun onButtonAdapterClick(it: buttonModel) {
        //I know that 'when' is better but
        //this time I used if else
        if (!it.hasImage && counter<4) {
            inputNum += it.number
            dots[counter] = R.color.purple_200
            counter++
            if (counter == 4){
                if (inputNum == passcode) {
                    Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
                }
            if (inputNum != passcode) {
                Toast.makeText(this, "Failure", Toast.LENGTH_SHORT).show()
            }
                for (i in 0 until dots.size){
                    dots[i]=R.color.white
                }
                inputNum = ""
                counter=0
        }
        }
        else if(it.image==R.drawable.ic_x && counter!=0){
            inputNum = inputNum.subSequence(0,inputNum.length-1).toString()
            counter--
            dots[counter] = R.color.white
        }
        //we have very limited amount of elements so
        //notifyDataSetChanged() won't hurt the process
        adapterDots.notifyDataSetChanged()
    }
}