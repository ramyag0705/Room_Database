package com.example.roomdatabase.data

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.dsl.koinApplication


//class UserViewModel(application: Application): AndroidViewModel(application) {
//
//    private val readAllData: LiveData<List<User>>
//    private val repository: UserRepository
//
//    init{
//        val userDao = UserDatabase.getInstance(application).userDao()
//        repository = UserRepository(userDao)
//        readAllData = repository.readAllData
//    }
//
//    suspend fun addUser(user: User){
//    viewModelScope.launch { Dispatchers.IO }
//    repository.addUser(user)
//    }
//}

class UserViewModel(private val repository: UserRepository) : ViewModel() {

   
    private val _userList = MutableLiveData<List<User>>()
    val userList: LiveData<List<User>> = repository.readAllData()
    //val userList: LiveData<List<User>> = userDao.readAllData()

    fun addUser(user : User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }
//    fun addUser(firstName: String, lastName: String?, age:Int){
//        if(firstName.isNotEmpty() && age > 0){
//            val user = User(firstName = firstName, lastName = lastName!!, age = age)
//            viewModelScope.launch {
//                repository.addUser(user)
//            }
//        }else{
//
//        }
//}

//    private fun showToast(message: String){
//        Toast.makeText(application, message, Toast.LENGTH_SHORT).show()
//    }
    fun getAllUsers() {
        _userList.value = repository.readAllData().value
    }
    //fun readAllData() = repository.readAllData()
    }



