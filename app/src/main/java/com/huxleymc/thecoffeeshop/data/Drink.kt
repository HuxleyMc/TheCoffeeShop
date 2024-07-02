package com.huxleymc.thecoffeeshop.data

import com.huxleymc.thecoffeeshop.R
import java.util.UUID

enum class Milk {
    FullCream,
    Soy,
    Almond,
    Oat,
    Skim,
    None
}


enum class Sweeteners {
    Honey,
    Sugar,
    Maple,
    None
}

enum class Shots(val shot: String) {
    Half("1/2"),
    Single("1"),
    Double("2"),
    HeartAttack("9")
}

data class Drink(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val description: String,
    val image: Int = R.drawable.coffee_cup,
    val price: Double,
    val milk: Milk = Milk.FullCream,
    val sweetener: Sweeteners = Sweeteners.None,
    val shots: Shots = Shots.Double
)