package com.quicksnap.repository.authentication

import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun login(email: String, password: String)
    suspend fun signUp(email: String, password: String, username: String)
    suspend fun facebookLogin()
    suspend fun twitterLogin()
    suspend fun googleLogin()
    suspend fun forgotPassword(emil: String)
    suspend fun changePassword(currentPassword: String, newPassword: String)
    suspend fun updateUser()
    suspend fun signOut()
}