package ir.cactus.cactusroomdb.repository

import androidx.lifecycle.LiveData
import ir.cactus.cactusroomdb.database.UserDao
import ir.cactus.cactusroomdb.entity.User

class UserRepository(private val userDao:UserDao) {

    val readAllData:LiveData<List<User>> =userDao.readAllUsers()

    suspend fun addUser(user:User){
        userDao.addUser(user)




    }
}