package com.example.roomdatabase.di

import androidx.room.Room
import com.example.roomdatabase.data.UserDatabase
import com.example.roomdatabase.data.UserRepository
import com.example.roomdatabase.data.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

fun injectFeature() = loadFeature

private val loadFeature by lazy {
    loadKoinModules(
        listOf(
            dataDaoModule,
            modelDao,
            repoModule,
            viewModelModule
        )
    )
}
val dataDaoModule = module{
    single { Room.databaseBuilder(get(),UserDatabase::class.java, "user_database").build() }
    single { get<UserDatabase>().userDao()}
}

val repoModule = module {
    single{
        UserRepository(get())
    }
}

val modelDao = module {
    includes(dataDaoModule)
    single{
        get<UserDatabase>().userDao()
    }
}

val viewModelModule = module {
    viewModel { UserViewModel(get())}
}