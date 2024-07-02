package com.huxleymc.thecoffeeshop.testdata

import com.huxleymc.thecoffeeshop.data.Drink



//Name,Description
//Espresso,
//Americano,A diluted espresso, created by adding hot water to a shot of espresso, giving it a similar strength but different flavor from traditional drip coffee.
//Latte,A creamy coffee drink made with one shot of espresso and steamed milk, typically topped with a small amount of milk foam.
//Cappuccino,A popular coffee drink made with equal parts espresso, steamed milk, and milk foam, often topped with cocoa powder or cinnamon.
//Macchiato,A type of espresso coffee drink with a small amount of steamed milk or milk foam, giving it a strong coffee flavor.
//Mocha,A chocolate-flavored variant of a latte, made with espresso, steamed milk, and chocolate syrup, often topped with whipped cream.
//Flat White,A coffee drink originating from Australia and New Zealand, made with espresso and steamed milk, similar to a latte but with a thinner layer of foam.
//Affogato,A coffee-based dessert made by pouring a shot of hot espresso over a scoop of vanilla ice cream or gelato.
//Café au Lait,A coffee drink made with brewed coffee and steamed milk in equal proportions, popular in France.
//Irish Coffee,A cocktail consisting of hot coffee, Irish whiskey, sugar, and topped with thick cream, often served in a warm mug.


val Drinks = listOf(
    Drink(
        name = "Flat White",
        price = 2.99,
        description = "A flat white is a coffee drink consisting of espresso and steamed milk. It generally has a higher proportion of espresso to milk than a caffè latte, and lacks the thick layer of foam in a cappuccino. While the origin of the flat white is unclear, various café owners in Australia and New Zealand claim its invention."
    ),
    Drink(
        name = "Espresso",
        description = "A strong and highly concentrated coffee made by forcing hot water through finely-ground coffee beans.",
        price = 2.99
    ),
    Drink(
        name = "Macchiato",
        description = "A type of espresso coffee drink with a small amount of steamed milk or milk foam, giving it a strong coffee flavor",
        price = 3.88
    )

)