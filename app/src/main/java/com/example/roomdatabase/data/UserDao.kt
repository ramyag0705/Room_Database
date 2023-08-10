package com.example.roomdatabase.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUser(user: User)

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<User>>

    @Update
    suspend fun updateUser(user: List<User>)
}

//Employee Details
//@Dao
//interface EmployeeDao {
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    fun insertEmployee(employee: Employee)
//
//    @Query("SELECT * FROM employee_table ORDER BY id ASC")
//    fun readAll(): LiveData<List<Employee>>
//}

