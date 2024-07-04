package com.huxleymc.thecoffeeshop.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.huxleymc.thecoffeeshop.ui.theme.Typography

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun CoffeeShopTopAppBar() {
    TopAppBar(title = {
        Text(text = "Coffee Shop", style = Typography.titleLarge)
    }, actions = {
        ElevatedButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(end = 12.dp)) {
            Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = null)
        }
    })
}


@Preview
@Composable
private fun CoffeeShopTopAppBarPreview() {
    CoffeeShopTopAppBar()
}