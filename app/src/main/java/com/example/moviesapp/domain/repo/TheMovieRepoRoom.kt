package com.example.moviesapp.domain.repo

import java.util.List;

import com.example.moviesapp.domain.entity.MovieClassRoom;

interface TheMovieRepoRoom {
    fun  getMovie():MutableList<MovieClassRoom>
    fun createMovie(movie: MovieClassRoom):Int
    fun updateMovie(id:Int, movie: MovieClassRoom):Boolean
    fun deleteMovie(id:Int):Boolean
}