package com.example.android.grata

import java.text.SimpleDateFormat
import java.util.*

fun formatDate(date : Date): String{
    //'d E M Y'
    val postFormater = SimpleDateFormat("d EEEE MMMM y")
    val newDateStr = postFormater.format(date)
    return newDateStr
}