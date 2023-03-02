package com.quicksnap.repository.events

interface EventsRepository {
    fun createEvent()
    fun getEvents()
    fun getUserEvents()
    fun getEventDetail()
    fun favoriteEvents()
    fun bookEvent()
    fun rsvpEvent()
    fun placeOrderOnEvent()
}