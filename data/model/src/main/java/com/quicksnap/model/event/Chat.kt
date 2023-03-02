package com.quicksnap.model.event

import com.quicksnap.model.user.UserDto
import java.util.*

data class Chat(
    val id: String,
    val message: String,
    val createdAt: Date,
    val sender: UserDto,
)
