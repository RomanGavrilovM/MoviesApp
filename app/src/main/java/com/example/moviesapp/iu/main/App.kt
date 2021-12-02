package com.example.moviesapp.iu.main

import android.app.Application
import android.content.Context
import android.widget.Toast
import com.example.moviesapp.R
import com.example.moviesapp.data.WebTheMovieRepoImpl
import com.example.moviesapp.data.RetrofitTheMovieRepoImpl
import com.example.moviesapp.domain.entity.MovieClass
import com.example.moviesapp.domain.repo.MovieRepository
import com.example.moviesapp.domain.repo.TheMovieRepo
import com.example.moviesapp.implimentation.MovieRepositoryImplementation

class App: Application() {


    val theMovieRepo: TheMovieRepo by lazy { RetrofitTheMovieRepoImpl() }
    var moviesRepo: MovieRepository = MovieRepositoryImplementation()
    var moviesRepoTwo: MovieRepository = MovieRepositoryImplementation()

    fun fillRepoCrazzy() {
        moviesRepoTwo.createMovie(
            MovieClass("https://avatars.mds.yandex.net/get-kinopoisk-image/1629390/34653c61-8b9a-4ba4-8057-6c81d70c71ed/300x450",
            "Я Фильм про1","Оно", "2017",  8.5))
        moviesRepoTwo.createMovie(
            MovieClass("https://avatars.mds.yandex.net/get-kinopoisk-image/1704946/14af6019-b2fe-4e1e-bee5-334d9e472d94/300x450",
            "Я Фильм про2","Чужой", "1979",  8.1))
        moviesRepoTwo.createMovie(
            MovieClass("https://avatars.mds.yandex.net/get-kinopoisk-image/1599028/c892b75a-e75a-4f9e-bda9-d4dd0538145c/300x450",
            "Я Фильм про3","Прочь", "2017",  7.1))
        moviesRepoTwo.createMovie(
            MovieClass("https://avatars.mds.yandex.net/get-kinopoisk-image/1600647/7525f201-fced-4dde-bfc5-b18fd42d5d46/300x450",
            "Я Фильм про4","Оно 2", "2019",  6.5))
        moviesRepoTwo.createMovie(
            MovieClass("https://avatars.mds.yandex.net/get-kinopoisk-image/1600647/e365ec59-b8ba-4d2c-b068-0c472832a47e/300x450",
            "Я Фильм про5","Мгла", "2007",  7.6))
    }

    fun fillRepoFant() {
        moviesRepo.createMovie(
            MovieClass("https://avatars.mds.yandex.net/get-kinopoisk-image/1629390/34653c61-8b9a-4ba4-8057-6c81d70c71ed/300x450",
            "Я Фильм про1","Оно", "2017",  8.5))
        moviesRepo.createMovie(
            MovieClass("https://avatars.mds.yandex.net/get-kinopoisk-image/1704946/14af6019-b2fe-4e1e-bee5-334d9e472d94/300x450",
            "Я Фильм про2","Чужой", "1979",  8.1))
        moviesRepo.createMovie(
            MovieClass("https://avatars.mds.yandex.net/get-kinopoisk-image/1599028/c892b75a-e75a-4f9e-bda9-d4dd0538145c/300x450",
            "Я Фильм про3","Прочь", "2017",  7.1))
        moviesRepo.createMovie(
            MovieClass("https://avatars.mds.yandex.net/get-kinopoisk-image/1600647/7525f201-fced-4dde-bfc5-b18fd42d5d46/300x450",
            "Я Фильм про4","Оно 2", "2019",  6.5))
        moviesRepo.createMovie(
            MovieClass("https://avatars.mds.yandex.net/get-kinopoisk-image/1600647/e365ec59-b8ba-4d2c-b068-0c472832a47e/300x450",
            "Я Фильм про5","Мгла", "2007",  7.6))
    }
}
val Context.app
    get() = applicationContext as App