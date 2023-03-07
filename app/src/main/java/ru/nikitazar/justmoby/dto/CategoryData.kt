package ru.nikitazar.justmoby.dto

data class CategoryData(
    val id: Int = 0,
    val name: String = "null",
    val list: List<CardData> = emptyList()
)
