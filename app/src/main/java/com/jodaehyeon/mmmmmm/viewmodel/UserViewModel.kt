package com.jodaehyeon.mmmmmm.viewmodel

import androidx.lifecycle.*
import com.jodaehyeon.mmmmmm.data.User
import com.jodaehyeon.mmmmmm.data.UserRepository
import kotlinx.coroutines.*

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {

    val allUser: LiveData<List<User>> = userRepository.allUser.asLiveData()
    val curUserPw: MutableLiveData<String> = MutableLiveData()

    fun insert(user: User) = viewModelScope.launch {
        userRepository.insert(user)
    }

    fun findPw(id: String) = viewModelScope.launch {
        curUserPw.value = userRepository.getUserPw(id)
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