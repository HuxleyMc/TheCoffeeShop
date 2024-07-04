package com.huxleymc.thecoffeeshop.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.huxleymc.thecoffeeshop.data.Drink
import com.huxleymc.thecoffeeshop.testdata.Drinks
import com.huxleymc.thecoffeeshop.ui.theme.Typography

@Composable
fun DrinkCard(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    drink: Drink,
    delay: Int = 1,
    loaded: Boolean = true
) {


    var expanded by remember {
        mutableStateOf(false)
    }

    var showExpand: Boolean? by remember {
        mutableStateOf(null)
    }

    var amount by remember {
        mutableIntStateOf(1)
    }

    val interactionSource = remember { MutableInteractionSource() }

    val loadedScale by animateFloatAsState(
        if (loaded) 1f else 0.5f, label = "", animationSpec = spring(
            dampingRatio = Spring.DampingRatioHighBouncy, stiffness = Spring.StiffnessLow
        )
    )

    Card(
        modifier = modifier
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            )
            .clickable(
                indication = null, interactionSource = interactionSource, onClick = onClick
            )
            .fillMaxWidth()

    ) {
        Box(modifier = Modifier.padding(10.dp)) {
            Column {
                Row {
                    Image(
                        painter = painterResource(id = drink.image),
                        contentDescription = null,
                        modifier = Modifier
                            .height(120.dp)
                            .scale(loadedScale)
                    )
                    Column(
                        horizontalAlignment = Alignment.End, modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = drink.name,
                            style = Typography.headlineLarge,
                            textAlign = TextAlign.End
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = drink.description,
                            overflow = TextOverflow.Ellipsis,
                            style = Typography.bodyMedium.copy(letterSpacing = 0.sp),
                            maxLines = if (expanded) Int.MAX_VALUE else 2,
                            textAlign = TextAlign.End,
                            onTextLayout = {
                                if (it.didOverflowHeight && showExpand == null) {
                                    showExpand = true
                                }
                            },
                            modifier = Modifier.animateContentSize(
                                animationSpec = spring(
                                    dampingRatio = Spring.DampingRatioLowBouncy,
                                    stiffness = Spring.StiffnessLow
                                )
                            )
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        if (showExpand == true) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.End
                            ) {
                                IconButton(onClick = { expanded = !expanded }) {
                                    Icon(
                                        imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                                        contentDescription = null,
                                        tint = Color.Blue,
                                        modifier = Modifier.height(35.dp)
                                    )
                                }


                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(space = 5.dp)
                    ) {
                        Button(
                            onClick = { amount -= 1 },
                            enabled = amount > 1,
                            modifier = Modifier.scale(loadedScale)
                        ) {
                            Text(text = "-", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                        }

                        Button(
                            onClick = { amount = 1 },
                            colors = ButtonDefaults.buttonColors()
                                .copy(containerColor = Color.Green.copy(alpha = 0.4f)),
                            modifier = Modifier.scale(loadedScale)
                        ) {
                            Text(
                                text = "Add $amount",
                                style = Typography.labelLarge,
                                modifier = Modifier.animateContentSize(),
                                color = Color.Black
                            )
                        }

                        Button(
                            onClick = { amount += 1 },
                            enabled = amount < 10,
                            modifier = Modifier.scale(loadedScale)
                        ) {
                            Text(text = "+", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                        }
                    }
                }
            }
        }
    }
}


@Preview
@Composable
private fun DrinkCardPreview() {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(Drinks) {
            DrinkCard(drink = it)
        }
    }
}