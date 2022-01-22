package com.example.moviesapp.util.mvp

import android.location.Location

fun Location.toPrintString(): String{
    return "[ $latitude , $longitude ]"
}