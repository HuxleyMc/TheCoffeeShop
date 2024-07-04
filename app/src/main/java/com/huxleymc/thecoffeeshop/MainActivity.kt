package com.huxleymc.thecoffeeshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.huxleymc.thecoffeeshop.testdata.Drinks
import com.huxleymc.thecoffeeshop.ui.components.CoffeeShopBottomAppBar
import com.huxleymc.thecoffeeshop.ui.components.CoffeeShopTopAppBar
import com.huxleymc.thecoffeeshop.ui.components.DrinkCard
import com.huxleymc.thecoffeeshop.ui.theme.TheCoffeeShopTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TheCoffeeShopTheme {
                AppContainer()
            }
        }
    }
}

@Composable
fun AppContainer(modifier: Modifier = Modifier) {

    var loaded by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = null) {
        loaded = true
    }

    Scaffold(modifier = modifier.fillMaxSize(), bottomBar = {
        CoffeeShopBottomAppBar()
    }, topBar = {
        CoffeeShopTopAppBar()
    }) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
        ) {
            LazyColumn(
                modifier = Modifier.padding(horizontal = 12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),

            ) {
                itemsIndexed(Drinks) { index, drink ->
                    DrinkCard(drink = drink, delay = index, loaded = loaded)
                }
                item {
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }
    }
}


@Preview
@Composable
fun AppContainerPreview() {
    TheCoffeeShopTheme {
        AppContainer()
    }
}