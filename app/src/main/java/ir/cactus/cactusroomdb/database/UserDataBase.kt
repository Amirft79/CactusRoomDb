package ir.cactus.cactusroomdb.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ir.cactus.cactusroomdb.entity.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDataBase:RoomDatabase() {
    abstract fun userDao():UserDao
    companion object{
        @Volatile
        private var INSTANCE:UserDataBase?=null
        fun getDataBase(context:Context):UserDataBase{
            val tempInstance= INSTANCE
            if (tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance=Room.databaseBuilder(
                    context,
                    UserDataBase::class.java,
                    "user_database"
                ).build()
                INSTANCE=instance
                return instance
            }
        }

    }
}