package com.example.roomx.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.roomx.Database.GithubDao
import com.example.roomx.Database.GithubRepo

class GithubRepository(private  val repoDao: GithubDao){

    @WorkerThread
    suspend fun insert(repo: GithubRepo){
        repoDao.insert(repo)
    }

    fun getAll(): LiveData<List<GithubRepo>> = repoDao.getAllRepos()

    fun nuke() = repoDao.nukeTable()
}