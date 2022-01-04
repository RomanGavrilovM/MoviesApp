package com.example.moviesapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.moviesapp.domain.entity.MovieClassRoom

@Database(
    entities = [MovieClassRoom::class],
    version = 1

)
abstract class MovieRoomBd : RoomDatabase() {
    abstract fun movieDao():MovieDao
}