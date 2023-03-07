package com.quicksnap.model.event

import com.quicksnap.model.ticket.Order
import java.util.*

data class EventDto(
    val id: String,
    val title: String,
    val description: String,
    val category: EventCategory,
    val previews: List<String>,
    val startDate: Date,
    val endDate: Date,
    val durationEachDay: Int,
    val discount: Double?,
    val location: Location,
    val packages: List<EventPackage>,
    val orders: List<Order>,
    val attachments: List<String>?,
    val attending: List<Attendee>,
    val chats: List<Chat>
)
