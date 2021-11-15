package com.example.moviesapp.implimentation

import com.example.moviesapp.domain.entity.Movie
import com.example.moviesapp.domain.repo.MovieRepository
import kotlin.contracts.contract

class MovieRepositoryImplementation() : MovieRepository {
    private var  moviesArr:ArrayList<Movie> = ArrayList()
    private  var counter:Long=0

    override fun getMovie(): List<Movie> {
        return ArrayList<Movie>(moviesArr)
    }

    override fun createMovie(movie: Movie): Long {
        movie.id=++counter
        moviesArr.add(movie)
        return counter
    }

    override fun updateMovie(id: Long, movie: Movie): Boolean {
        deleteMovie(id)
        movie.id=id
        moviesArr.add(id.toInt()-1,movie)
        return true
    }

    override fun deleteMovie(id: Long): Boolean {
        for (i in 0..moviesArr.size){
            if(id == moviesArr.get(i).id){
                moviesArr.removeAt(i)
                return true
            }
        }
        return false
    }
}