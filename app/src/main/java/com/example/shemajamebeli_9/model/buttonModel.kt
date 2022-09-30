package com.example.shemajamebeli_9.model

import android.media.Image
import com.example.shemajamebeli_9.R

data class buttonModel (
        val number: Int?,
        val hasImage: Boolean,
        val image: Int?
        )

val items = mutableListOf<buttonModel>(
        buttonModel(1, false, null),
        buttonModel(2, false, null),
        buttonModel(3, false, null),
        buttonModel(4, false, null),
        buttonModel(5, false, null),
        buttonModel(6, false, null),
        buttonModel(7, false, null),
        buttonModel(8, false, null),
        buttonModel(9, false, null),
        buttonModel(null, true, R.drawable.ic_touch),
        buttonModel(0, false, null),
        buttonModel(null, true, R.drawable.ic_x)
)