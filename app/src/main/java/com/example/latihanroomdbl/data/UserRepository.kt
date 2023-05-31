package com.example.latihanroomdbl.data

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {
    val readAllData: LiveData<List<User>> = userDao.readAllData()

    // untuk menambahkan data
    suspend fun addUser(user: User){
        userDao.addUser(user)
    }

    // untuk mengubah data
    suspend fun updateUser(user: User){
        userDao.updateUser(user)
    }

    //untuk menghapus data
    suspend fun deleteUser(user: User){
        userDao.deleteUser(user)
    }
}