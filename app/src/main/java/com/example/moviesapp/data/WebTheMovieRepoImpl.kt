package com.example.moviesapp.data

import com.google.gson.Gson
import com.example.moviesapp.domain.entity.MovieClass
import com.example.moviesapp.domain.entity.Root
import com.example.moviesapp.domain.repo.TheMovieRepo
import com.example.moviesapp.iu.main.App
import com.example.moviesapp.iu.main.MainActivity
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

class WebTheMovieRepoImpl:TheMovieRepo {

    override fun getReposForUserSync(): List<MovieClass> {

        val result= emptyList<MovieClass>().toMutableList()
        var urlConnection: HttpURLConnection? = null
        try {
            val url = URL(themoviedbURl)
            urlConnection = url.openConnection() as HttpURLConnection
            urlConnection.requestMethod = "GET"
            urlConnection.connectTimeout = 5_000

            val bufferedReader = BufferedReader(InputStreamReader(urlConnection.inputStream))

            var resultJson = bufferedReader.readLines().toString()

            var model = gson.fromJson(resultJson, Array<Root>::class.java)

            model.forEach {
                it.results.forEach {
                    result.add(MovieClass(
                        it.image,
                        it.name, it.description, it.year, it.rating, 40.0,40.0
                    ))

                }

            }


        } catch ( e:Exception){

        }
        finally {
            urlConnection?.disconnect()
        }
        return  result
    }
    val themoviedbURl: String =  "https://api.themoviedb.org/3/discover/movie?api_key=b394bdee20e1f534a09fb18b1a16568a&with_genres=27"
    val gson by lazy { Gson() }
    override fun getReposForUserAsync( callback: (List<MovieClass>) -> Unit) {
        Thread {
            callback.invoke(getReposForUserSync())
        }.start()
    }

}