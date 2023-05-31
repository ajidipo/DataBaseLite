package com.example.latihanroomdbl.data

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addUser(user: User)

    // otomatis declare jika sudah ada 1 yang di declare
    @Update
    fun updateUser(user: User)

    @Delete
    fun deleteUser(user: User)

    @Query("SELECT * FROM user_table ORDER By id ASC")
    fun readAllData(): LiveData<List<User>>

}