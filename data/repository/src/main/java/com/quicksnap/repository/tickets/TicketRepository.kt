package com.quicksnap.repository.tickets

interface TicketRepository {
    fun buyTicket()
    fun viewTicket()
    fun cancelEvent()
}