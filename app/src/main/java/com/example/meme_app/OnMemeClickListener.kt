package com.example.meme_app

import androidx.annotation.DrawableRes

interface OnMemeClickListener {
    fun onMemeClick(@DrawableRes imgResId: Int) // Replace YourDataItem with your actual data class
}