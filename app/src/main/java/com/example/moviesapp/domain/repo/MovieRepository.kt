package com.example.moviesapp.domain.repo

import com.example.moviesapp.domain.entity.MovieClass

interface MovieRepository  {
    fun  getMovie():List<MovieClass>
    fun createMovie(movie: MovieClass):Long
    fun updateMovie(id:Long, movie: MovieClass):Boolean
    fun deleteMovie(id:Long):Boolean
}