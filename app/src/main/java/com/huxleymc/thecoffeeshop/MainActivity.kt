package com.huxleymc.thecoffeeshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.huxleymc.thecoffeeshop.testdata.Drinks
import com.huxleymc.thecoffeeshop.ui.components.CoffeeShopBottomAppBar
import com.huxleymc.thecoffeeshop.ui.components.DrinkCard
import com.huxleymc.thecoffeeshop.ui.theme.TheCoffeeShopTheme
import com.huxleymc.thecoffeeshop.ui.theme.Typography

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppContainer(modifier: Modifier = Modifier) {
    Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = {
        CoffeeShopBottomAppBar()
    }, topBar = {
        TopAppBar(title = {
            Text(text = "Coffee Shop", style = Typography.titleLarge)
        })
    }) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
        ) {
            LazyColumn(
                modifier = Modifier.padding(horizontal = 12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(Drinks) {
                    DrinkCard(drink = it)
                }
            }
        }
    }
}

@Preview()
@Composable
fun AppContainerPreview() {
    TheCoffeeShopTheme {
        AppContainer()
    }
}