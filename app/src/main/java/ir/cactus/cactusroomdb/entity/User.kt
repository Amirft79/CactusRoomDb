package ir.cactus.cactusroomdb.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "user_table")
@Parcelize
data class User(
    @PrimaryKey(autoGenerate = true) val user_id:Int,
    @ColumnInfo(name="first_name")val firstName:String?,
    @ColumnInfo(name = "last_name")val lastName:String?,
    @ColumnInfo(name = "user_age")val age:Int
) :Parcelable{
}