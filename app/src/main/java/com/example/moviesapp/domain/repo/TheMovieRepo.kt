package com.example.moviesapp.domain.repo

import androidx.annotation.WorkerThread
import com.example.moviesapp.domain.entity.MovieClass
import javax.security.auth.callback.Callback

interface TheMovieRepo {
    @WorkerThread
    fun getReposForUserSync():List<MovieClass>
    fun getReposForUserAsync(callback: (List<MovieClass>)->Unit)
}