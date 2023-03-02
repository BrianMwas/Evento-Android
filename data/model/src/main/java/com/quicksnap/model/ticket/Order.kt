package com.quicksnap.model.ticket



data class Order(
    val id: String,
    val paymentPlan: Provider,
    val eventId: String,

)
