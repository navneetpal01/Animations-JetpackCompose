package com.example.animations_jetpackcompose

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun AnimatedContentSizeExample(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        var isAllTextVisible by remember { mutableStateOf(false) }
        Text(
            modifier = Modifier
                .padding(5.dp)
                .clickable {
                    isAllTextVisible = !isAllTextVisible
                } // .animateContentSize(
//                    animationSpec = tween(durationMillis = 1000, easing = LinearEasing),
//                )
                .animateContentSize(
                    //damping Ratio is for adding bouncing effect
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioHighBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
                .background(color = Color.LightGray),
            maxLines = if (isAllTextVisible) Int.MAX_VALUE else 2,
            text = "Dreams, those mysterious journeys we take each night, weave stories from our memories, hopes, and fears.  They can be vivid and fantastical, or filled with everyday anxieties.  While the purpose of dreams remains a puzzle, they offer a window into the depths of our minds, and can spark creativity or guide us towards understanding ourselves."
        )
    }
}