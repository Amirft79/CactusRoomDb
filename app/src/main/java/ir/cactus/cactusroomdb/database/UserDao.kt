package ir.cactus.cactusroomdb.database

import androidx.lifecycle.LiveData
import androidx.room.*
import ir.cactus.cactusroomdb.entity.User

@Dao
interface UserDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user:User)

    @Query("SELECT * FROM user_table")
    fun readAllUsers():LiveData<List<User>>

    @Update
    suspend fun updateUser(user:User)


}