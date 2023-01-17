package ir.cactus.cactusroomdb.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true) val user_id:Int,
    @ColumnInfo(name="first_name")val firstName:String?,
    @ColumnInfo(name = "last_name")val lastName:String?,
    @ColumnInfo(name = "user_age")val age:Int
) {
}