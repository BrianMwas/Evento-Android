package com.quicksnap.model.ticket

import java.util.Date

data class Ticket(
    val id: String,
    val userId: String,
    val orderId: String,
    val paymentStatus: PaymentStatus,
    val createdAt: Date
)