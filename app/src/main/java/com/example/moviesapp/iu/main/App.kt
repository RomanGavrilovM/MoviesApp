package com.example.moviesapp.iu.main

import android.app.Application
import com.example.moviesapp.R
import com.example.moviesapp.domain.entity.Movie
import com.example.moviesapp.domain.repo.MovieRepository
import com.example.moviesapp.implimentation.MovieRepositoryImplementation

class App: Application() {
    var moviesRepo: MovieRepository = MovieRepositoryImplementation()
    var moviesRepoTwo: MovieRepository = MovieRepositoryImplementation()



    fun fillRepoCrazzy() {
        moviesRepoTwo.createMovie(Movie("https://avatars.mds.yandex.net/get-kinopoisk-image/1629390/34653c61-8b9a-4ba4-8057-6c81d70c71ed/300x450",
            "Я Фильм про1","Оно", "2017",  8.5F))
        moviesRepoTwo.createMovie(Movie("https://avatars.mds.yandex.net/get-kinopoisk-image/1704946/14af6019-b2fe-4e1e-bee5-334d9e472d94/300x450",
            "Я Фильм про2","Чужой", "1979",  8.1F))
        moviesRepoTwo.createMovie(Movie("https://avatars.mds.yandex.net/get-kinopoisk-image/1599028/c892b75a-e75a-4f9e-bda9-d4dd0538145c/300x450",
            "Я Фильм про3","Прочь", "2017",  7.1F))
        moviesRepoTwo.createMovie(Movie("https://avatars.mds.yandex.net/get-kinopoisk-image/1600647/7525f201-fced-4dde-bfc5-b18fd42d5d46/300x450",
            "Я Фильм про4","Оно 2", "2019",  6.5F))
        moviesRepoTwo.createMovie(Movie("https://avatars.mds.yandex.net/get-kinopoisk-image/1600647/e365ec59-b8ba-4d2c-b068-0c472832a47e/300x450",
            "Я Фильм про5","Мгла", "2007",  7.6F))
    }

    fun fillRepoFant() {
        moviesRepo.createMovie(Movie("https://avatars.mds.yandex.net/get-kinopoisk-image/1629390/34653c61-8b9a-4ba4-8057-6c81d70c71ed/300x450",
            "Я Фильм про1","Оно", "2017",  8.5F))
        moviesRepo.createMovie(Movie("https://avatars.mds.yandex.net/get-kinopoisk-image/1704946/14af6019-b2fe-4e1e-bee5-334d9e472d94/300x450",
            "Я Фильм про2","Чужой", "1979",  8.1F))
        moviesRepo.createMovie(Movie("https://avatars.mds.yandex.net/get-kinopoisk-image/1599028/c892b75a-e75a-4f9e-bda9-d4dd0538145c/300x450",
            "Я Фильм про3","Прочь", "2017",  7.1F))
        moviesRepo.createMovie(Movie("https://avatars.mds.yandex.net/get-kinopoisk-image/1600647/7525f201-fced-4dde-bfc5-b18fd42d5d46/300x450",
            "Я Фильм про4","Оно 2", "2019",  6.5F))
        moviesRepo.createMovie(Movie("https://avatars.mds.yandex.net/get-kinopoisk-image/1600647/e365ec59-b8ba-4d2c-b068-0c472832a47e/300x450",
            "Я Фильм про5","Мгла", "2007",  7.6F))
    }
}