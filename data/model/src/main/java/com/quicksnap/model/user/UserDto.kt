package com.quicksnap.model.user

import java.util.Date

data class UserDto(
    val id: String,
    val username: String,
    val email: String,
    val profilePhoto: String,
    val preferences: List<String>,
    val createdAt: Date,
)
