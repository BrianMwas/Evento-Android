package com.quicksnap.model.event

enum class PackageCategory {
        GOLD, SILVER, BRONZE, PLATINUM
}


data class EventPackage (
    val name: String,
    val description: String,
    val discount: Double,
    val price: Double,
    val packageCategory: PackageCategory,
)