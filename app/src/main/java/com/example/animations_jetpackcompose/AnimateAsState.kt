package com.example.animations_jetpackcompose

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@Preview
@Composable
fun AnimateAsStateExample() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var scale by remember { mutableStateOf(1f) }
        //using scale cause animatedScale can't be var
        var color by remember { mutableStateOf(Color.Red) }
        val animatedScale by animateFloatAsState(
            targetValue = scale,
            label = " ",
            animationSpec = tween(100)
        )
        val animateColor by animateColorAsState(targetValue = color, label = " ")
        Box(
            modifier = Modifier
                .size(100.dp)
                .scale(animatedScale)
                .clip(CircleShape)
                .background(color = animateColor)
                .clickable {
                    scale += 0.1f
                    color = Color(red = Random.nextInt(225) , green = Random.nextInt(225), blue = Random.nextInt(225))
                }

        )
    }
}