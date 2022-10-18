package com.example.loginwithanimation.view.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginwithanimation.model.UserModel
import com.example.loginwithanimation.model.UserPreference
import kotlinx.coroutines.launch

class SignupViewModel(private val pref: UserPreference) : ViewModel() {
    fun saveUser(user: UserModel) {
        viewModelScope.launch {
            pref.saveUser(user)
        }
    }
}