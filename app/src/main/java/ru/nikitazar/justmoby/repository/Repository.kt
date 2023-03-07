package ru.nikitazar.justmoby.repository

import ru.nikitazar.justmoby.dto.CategoryData

interface Repository {
    suspend fun getList(): List<CategoryData>
}