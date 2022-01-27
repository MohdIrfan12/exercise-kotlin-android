package com.fueled

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.fueled.data.DataRepositoryImpl
import com.fueled.data.util.FileReader
import com.fueled.ui.UsersAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar
    private lateinit var rvUsers: RecyclerView
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var mUsersAdapter: UsersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewModel()

        rvUsers = findViewById(R.id.rvUsers)
        progressBar = findViewById(R.id.progressBar)

        initAdapter()
        attachObserber()
        homeViewModel.getUsers()

    }

    private fun initViewModel() {
        val repository = DataRepositoryImpl(FileReader(this))
        val viewModelFactory = ViewModelFactory(repository)
        homeViewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)
    }

    private fun initAdapter() {
        mUsersAdapter = UsersAdapter()
        rvUsers.adapter = mUsersAdapter
    }

    private fun attachObserber() {
        homeViewModel.responseLiveData.observe(this, {
            mUsersAdapter.setData(it)
            progressBar.visibility = View.GONE
        })
    }

}