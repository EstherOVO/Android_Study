package com.busanit.ch11_persistence.e_room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

// 데이터 접근 객체의 인터페이스
@Dao
interface UserDAO {

//  삽입(Insert문 Object - Relational Mapping : ORM)
    @Insert
    suspend fun insert(user: User)

    @Query("SELECT * FROM users")
    suspend fun getAll(): List<User>
}