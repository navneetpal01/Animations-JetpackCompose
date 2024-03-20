package com.example.animations_jetpackcompose

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedVisibilityExample() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ){

        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var isVisible by remember { mutableStateOf(true) }
            AnimatedVisibility(visible = isVisible) {
                Text(text = "Animate")
            }
            Spacer(modifier = Modifier.height(12.dp))
            Button(onClick = {
                isVisible = !isVisible
            }) {
                Text(text = "Click")
            }
        }
    }
}

@Preview
@Composable
fun AnimatedVisibilityExampleSecond() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ){

        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var isVisible by remember { mutableStateOf(false) }
            AnimatedVisibility(
                visible = isVisible,
                enter = fadeIn(animationSpec = tween(1000)) + expandVertically() + scaleIn(
                    initialScale = 1000f , transformOrigin = TransformOrigin.Center
                ) + slideIn(initialOffset ={ IntOffset(x = 500,y = 100) }),
                exit = fadeOut() + slideOutHorizontally()
            ) {
               Image(
                   modifier = Modifier
                       .size(100.dp)
                       .clip(shape = CircleShape),
                   painter = painterResource(id = R.drawable.pikalogo),
                   contentDescription = "Pikachu",
                   contentScale = ContentScale.Crop
               )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Button(onClick = {
                isVisible = !isVisible
            }) {
                Text(text = "Click")
            }
        }
    }
}