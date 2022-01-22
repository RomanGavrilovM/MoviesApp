package com.example.moviesapp.data

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.moviesapp.domain.entity.MovieClass
import com.example.moviesapp.domain.repo.TheMovieRepo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.moviesapp.data.retrofit.TheMovieRepoApi


private const val BASE_URL ="https://api.themoviedb.org/"
class RetrofitTheMovieRepoImpl:TheMovieRepo {
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private var api: TheMovieRepoApi = retrofit.create(TheMovieRepoApi::class.java)
    override fun getReposForUserSync(): List<MovieClass> {
        return api.getRepos().execute().body()?: emptyList()
    }

    override fun getReposForUserAsync(callback: (List<MovieClass>) -> Unit) {
        api.getRepos().enqueue(object: Callback<List<MovieClass>>{
            override fun onResponse(call: Call<List<MovieClass>>, response: Response<List<MovieClass>>) {
                callback(response.body()?: emptyList())
            }

            override fun onFailure(call: Call<List<MovieClass>>, t: Throwable) {
                // todo
            }

        })

    }
}