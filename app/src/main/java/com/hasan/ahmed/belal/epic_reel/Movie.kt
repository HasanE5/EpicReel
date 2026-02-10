package com.hasan.ahmed.belal.epic_reel
data class Movie(
    val id: Int,
    val title: String,
    val duration: String,
    val rating: Double,
    val posterUrl: String? = null,
    val description: String = "",
    val genre: String = "Sci-Fi",
    val year: Int = 2024,
)