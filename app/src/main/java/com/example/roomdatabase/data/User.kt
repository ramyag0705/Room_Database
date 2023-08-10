package com.example.roomdatabase.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

import java.util.*

@Parcelize
@Entity("user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val firstName: String,
    //val middleName: String,
    val lastName: String,
    val age: Int,
    //val dateOfBirth: Date
): Parcelable

//Employee Details
//@Parcelize
//@Entity("employee_table")
//data class Employee(
//    @PrimaryKey(autoGenerate = true)
//    val employee_Id: Int = 0,
//    val department: String
//): Parcelable

