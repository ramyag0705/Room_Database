package com.example.roomdatabase.data

import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository(private val userDao: UserDatabase) {

//    var database = UserDatabase.getInstance(application).userDao()


    /*suspend fun readALlData(): LiveData<List<User>>{
        return userDao.readAllData()
    }*/
    //val readAllData: LiveData<List<User>> = userDao.readAllData()

//    fun addUser(user: User) {
//        //userDao.userDao().insertUser(user)
//        userDao.insertUser(user)
//    }
    suspend fun addUser(user: User){
        withContext(Dispatchers.IO){
            userDao.userDao().insertUser(user)
        }
    }

//    fun readAllData(): LiveData<List<User>> {
//        return userDao.readAllData()
//    }
     fun readAllData() : LiveData<List<User>>{
        return userDao.userDao().readAllData()
    }
}


    /*suspend fun updateData(userList: List<User>) {
        withContext(Dispatchers.IO) {
            userDao.updateUser(userList)

        }
    }*/

    //fun readAllData() = userDao.userDao().readAllData()

