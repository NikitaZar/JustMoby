package ru.nikitazar.justmoby.repository

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import ru.nikitazar.justmoby.R
import ru.nikitazar.justmoby.dto.CardData
import ru.nikitazar.justmoby.dto.CategoryData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor(
    @ApplicationContext private val app: Context
) : Repository {

    override suspend fun getList(): List<CategoryData> =
        listOf(
            CategoryData(
                id = 1,
                name = app.getString(R.string.category_android),
                list = listOf(
                    CardData(
                        id = 1,
                        pic = "and_1"
                    ),
                    CardData(
                        id = 2,
                        pic = "and_2"
                    ),
                    CardData(
                        id = 3,
                        pic = "and_3"
                    ),
                    CardData(
                        id = 4,
                        pic = "and_4"
                    ),
                )
            ),
            CategoryData(
                id = 2,
                name = app.getString(R.string.category_ios),
                list = listOf(
                    CardData(
                        id = 1,
                        pic = "ios_1"
                    ),
                    CardData(
                        id = 2,
                        pic = "ios_2"
                    ),
                    CardData(
                        id = 3,
                        pic = "ios_3"
                    ),
                    CardData(
                        id = 4,
                        pic = "ios_4"
                    ),
                )
            ),
            CategoryData(
                id = 3,
                name = app.getString(R.string.category_Linux),
                list = listOf(
                    CardData(
                        id = 1,
                        pic = "lnx_1"
                    ),
                    CardData(
                        id = 2,
                        pic = "lnx_2"
                    ),
                    CardData(
                        id = 3,
                        pic = "lnx_3"
                    ),
                    CardData(
                        id = 4,
                        pic = "lnx_4"
                    ),
                )
            ),
            CategoryData(
                id = 4,
                name = app.getString(R.string.category_windows),
                list = listOf(
                    CardData(
                        id = 1,
                        pic = "win_1"
                    ),
                    CardData(
                        id = 2,
                        pic = "win_2"
                    ),
                    CardData(
                        id = 3,
                        pic = "win_3"
                    ),
                    CardData(
                        id = 4,
                        pic = "win_4"
                    ),
                )
            ),
            CategoryData(
                id = 5,
                name = app.getString(R.string.category_macos),
                list = listOf(
                    CardData(
                        id = 1,
                        pic = "mos_1"
                    ),
                    CardData(
                        id = 2,
                        pic = "mos_2"
                    ),
                    CardData(
                        id = 3,
                        pic = "mos_3"
                    ),
                    CardData(
                        id = 4,
                        pic = "mos_4"
                    ),
                )
            ),
        )
}