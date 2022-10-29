package com.imashnake.coinsnd.home

import androidx.annotation.DrawableRes
import com.imashnake.coinsnd.R

enum class Coin(
    val value: Int,
    val symbol: String = "¢",
    @DrawableRes val image: Int
) {
    Toonie(
        value = 2,
        symbol = "$",
        image = R.drawable.toonie_2
    ),
    Loonie(
        value = 1,
        symbol = "$",
        image = R.drawable.loonie_1
    ),
    Quarter(
        value = 25,
        image = R.drawable.quarter_25
    ),
    Dime(
        value  = 10,
        image = R.drawable.dime_10
    ),
    Nickel(
        value = 5,
        image = R.drawable.nickel_5
    )
}
