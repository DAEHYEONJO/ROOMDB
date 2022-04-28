package com.jodaehyeon.mmmmmm.data

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class UserRepository(private val userDAO: UserDAO) {

    val allUser: Flow<List<User>> = userDAO.getAllUser()

    @WorkerThread
    suspend fun insert(user:User){
        if (getUserCountById(user.id)==0){
            userDAO.insert(user)
        }
    }

    @WorkerThread
    suspend fun getUserCountById(id: String) = userDAO.findUser(id)

    @WorkerThread
    suspend fun deleteAll(){
        userDAO.deleteAll()
    }

    @WorkerThread
    suspend fun getUserPw(userId:String) = userDAO.findPw(userId)

}