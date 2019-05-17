package com.example.roomx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.roomx.Database.GithubRepo
import com.example.roomx.Repository.GithubRepository
import com.example.roomx.ViewModel.GitHubRepoViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this).get(GitHubRepoViewModel::class.java)

        btn.setOnClickListener {
            val name = et1.text.toString()
            if(name.isNotEmpty() && name.isNotBlank()){
                viewModel.insert(GithubRepo(name))
            }
        }

        viewModel.getAll().observe(this, Observer {repos->
            Log.d("LISTA DE REPOS","------------------------------------------------------------------")
            for (repo in repos){
                Log.d("LISTA DE REPOS",repo.name)
            }
        })

    }
}
