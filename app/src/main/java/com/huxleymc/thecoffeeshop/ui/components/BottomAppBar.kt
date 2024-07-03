package com.huxleymc.thecoffeeshop.ui.components


import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.huxleymc.thecoffeeshop.R
import com.huxleymc.thecoffeeshop.ui.theme.Typography


@Composable
fun CoffeeShopBottomAppBar() {
    NavigationBar {
        NavigationBarItem(selected = false, label = {
            Text(text = "Home", style = Typography.labelMedium)
        }, onClick = { /*TODO*/ }, icon = {
            Icon(
                painter = painterResource(id = R.drawable.baseline_home_24),
                contentDescription = null
            )
        })
        NavigationBarItem(selected = false, label = {
            Text(text = "Menu", style = Typography.labelMedium)
        }, onClick = { /*TODO*/ }, icon = {
            Icon(
                painter = painterResource(id = R.drawable.baseline_menu_24),
                contentDescription = null
            )
        })
    }
}


@Preview
@Composable
private fun CoffeeShopBottomAppBarPreview() {
    CoffeeShopBottomAppBar()
}