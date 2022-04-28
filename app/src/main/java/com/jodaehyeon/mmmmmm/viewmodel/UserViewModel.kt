package com.jodaehyeon.mmmmmm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.jodaehyeon.mmmmmm.data.User
import com.jodaehyeon.mmmmmm.data.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {

    val allUser: LiveData<List<User>> = userRepository.allUser.asLiveData()

    fun insert(user: User) = viewModelScope.launch {
        userRepository.insert(user)
    }

    fun findUserCount(id: String): Int{
        return allUser.value!!.count{
            it.id == id
        }
    }

    fun deleteAll() = viewModelScope.launch {
        userRepository.deleteAll()
    }

}