package ir.cactus.cactusroomdb.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import ir.cactus.cactusroomdb.database.UserDataBase
import ir.cactus.cactusroomdb.entity.User
import ir.cactus.cactusroomdb.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DataBaseViewModel(application:Application) :AndroidViewModel(application) {


    private val readAllData: LiveData<List<User>>
    private val repository:UserRepository

    init {
        val userDao=UserDataBase.getDataBase(application).userDao()
        repository=UserRepository(userDao)
        readAllData=repository.readAllData

    }

    fun addUser(user:User){
        viewModelScope.launch(Dispatchers.IO) {




        }
    }
}