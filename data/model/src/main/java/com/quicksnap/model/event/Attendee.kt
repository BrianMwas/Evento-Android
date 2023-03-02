package com.quicksnap.model.event

import com.quicksnap.model.user.UserDto

data class Attendee(
    val id: String,
    val rsvp: Boolean,
    val user: UserDto,
)
