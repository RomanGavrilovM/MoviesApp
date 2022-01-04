package com.example.moviesapp.data.retrofit

import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import com.example.moviesapp.domain.entity.MovieClass
import com.example.moviesapp.domain.entity.Root

interface TheMovieRepoApi {
    @GET("3/discover/movie?api_key=b394bdee20e1f534a09fb18b1a16568a&with_genres=27")
    fun getRepos(): Call<List<MovieClass>>
}