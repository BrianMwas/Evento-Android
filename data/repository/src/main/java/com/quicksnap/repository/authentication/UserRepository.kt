package com.quicksnap.repository.authentication

interface UserRepository {
    fun login()
    fun signUp()
    fun forgotPassword(emil: String)
    fun changePassword(currentPassword: String, newPassword: String)
    fun updateUser()
}