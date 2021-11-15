package com.example.moviesapp.iu.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.example.moviesapp.R
import com.example.moviesapp.domain.entity.Movie
import com.example.moviesapp.domain.repo.MovieRepository
import com.example.moviesapp.implimentation.MovieRepositoryImplementation
import com.example.moviesapp.iu.MoviesAdapter
import com.example.moviesapp.iu.fragment.ListMovieFragment
import com.example.moviesapp.iu.fragment.OneMovieFragment
import java.util.*

class MainActivity : AppCompatActivity(), ListMovieFragment.Controller,
    OneMovieFragment.Controller{
    var moviesRepo:MovieRepository = MovieRepositoryImplementation()
    var moviesRepoTwo:MovieRepository = MovieRepositoryImplementation()
    var recyclerView:RecyclerView?=null
    var recyclerViewTwo:RecyclerView?=null
    var adapter: MoviesAdapter = MoviesAdapter()
    var adapterTwo: MoviesAdapter = MoviesAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        navView.setupWithNavController(navController)
        navView.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener { item: MenuItem ->
            when(item.itemId){
                //   R.id.navigation_list_movie-> supportFragmentManager.popBackStack()
                //Toast.makeText(this,"Список", Toast.LENGTH_SHORT).show()
                R.id.navigation_favorite_movie-> supportFragmentManager.popBackStack()
                //Toast.makeText(this,"Избранное", Toast.LENGTH_SHORT).show()
                R.id.navigation_ratings_movie-> supportFragmentManager.popBackStack()
                //Toast.makeText(this,"Рейтинг", Toast.LENGTH_SHORT).show()

            }

            true
        })
        fillRepoFant()
        fillRepoCrazzy()
        initRecyclerView()
    }

    private fun fillRepoCrazzy() {
        moviesRepoTwo.createMovie(Movie(R.drawable.quiet_place_2, "Я Фильм про1","Quiet place 2", "2021",  6.9F))
        moviesRepoTwo.createMovie(Movie(R.drawable.canyonlands,"Я Фильм про2","Canyonlands", "2021",  6.8F))
        moviesRepoTwo.createMovie(Movie(R.drawable.trip, "Я Фильм про3","Trip", "2021",  6.7F))
        moviesRepoTwo.createMovie(Movie(R.drawable.the_estate,"Я Фильм про4","The_estate", "2021",  6.5F))
        moviesRepoTwo.createMovie(Movie(R.drawable.mothers,"Я Фильм про5","Mothers", "2021",  6.4F))
    }

    fun initRecyclerView() {
        recyclerView = findViewById<RecyclerView>(R.id.recycler_view_movie)
        initRecyclerViewGroup(recyclerView,adapter,moviesRepo)
        recyclerViewTwo = findViewById<RecyclerView>(R.id.recycler_view_movie_2)
        initRecyclerViewGroup(recyclerViewTwo,adapterTwo,moviesRepoTwo)
    }

    private fun initRecyclerViewGroup(recyclerView: RecyclerView?, adapter: MoviesAdapter,moviesRepo:MovieRepository) {

        var linearLayout: LinearLayoutManager = LinearLayoutManager(this,
            LinearLayoutManager.HORIZONTAL,false)
        // linearLayout.isAutoMeasureEnabled = true
        recyclerView?.layoutManager = linearLayout
        recyclerView?.setHasFixedSize(true)
        //recyclerView?.isNestedScrollingEnabled =false
        recyclerView?.adapter = adapter
        adapter.setDataBase(moviesRepo.getMovie())
        adapter.setOnItemClickListener(object :MoviesAdapter.onItemClickListener{
            override fun onItemClick(item: Movie) {
                openMovieScreen(item)
                Toast.makeText(this@MainActivity, item.id.toString(), Toast.LENGTH_SHORT).show();
            }
        })
    }

    fun openMovieScreen(movie:Movie?) {
        loadFragment( OneMovieFragment(), movie!!)
    }
    fun fillRepoFant() {
        moviesRepo.createMovie(Movie(R.drawable.quiet_place_2, "Я Фильм про1","Quiet place 2", "2021",  6.9F))
        moviesRepo.createMovie(Movie(R.drawable.canyonlands,"Я Фильм про2","Canyonlands", "2021",  6.8F))
        moviesRepo.createMovie(Movie(R.drawable.trip, "Я Фильм про3","Trip", "2021",  6.7F))
        moviesRepo.createMovie(Movie(R.drawable.the_estate,"Я Фильм про4","The_estate", "2021",  6.5F))
        moviesRepo.createMovie(Movie(R.drawable.mothers,"Я Фильм про5","Mothers", "2021",  6.4F))
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.setting-> Toast.makeText(this,"Настройки",Toast.LENGTH_LONG).show()
            R.id.exit-> Toast.makeText(this,"Выход",Toast.LENGTH_LONG).show()
            R.id.search_movie-> Toast.makeText(this,"поиск",Toast.LENGTH_LONG).show()
            android.R.id.home -> supportFragmentManager.popBackStack()
            //  Toast.makeText(this,"Назад",Toast.LENGTH_LONG).show()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.addToBackStack(null)
        transaction.replace(R.id.one_movie_fragment, fragment)
        transaction.commit()

    }
    private fun loadFragment(fragment: Fragment , movie:Movie){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.addToBackStack(null)
        transaction.replace(R.id.one_movie_fragment,  (fragment as OneMovieFragment).newInstance(movie))
        transaction.commit()

    }

    override fun openListMovie() {
        initRecyclerView()
        //  Toast.makeText(this,"Н++",Toast.LENGTH_LONG).show()
    }

    override fun openOneMovie() {

    }

}