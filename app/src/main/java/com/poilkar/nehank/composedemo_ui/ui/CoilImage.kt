package com.poilkar.nehank.composedemo_ui.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.transform.BlurTransformation
import coil.transform.CircleCropTransformation
import coil.transform.GrayscaleTransformation
import coil.transform.RoundedCornersTransformation
import com.poilkar.nehank.composedemo_ui.R

@ExperimentalCoilApi
@Composable
fun CoilImage() {
    Box(
        modifier = Modifier
            .height(500.dp)
            .width(500.dp),
        contentAlignment = Alignment.Center
    ) {
        val painter = rememberImagePainter(
            data = "https://avatars.githubusercontent.com/u/38486841?s…00&u=2e9695be8e0089fc0a56f91310d1b45498d3dc7a&v=4",
            builder = {
                placeholder(R.drawable.ic_placeholder)
                crossfade(1000)
                transformations(
//                    GrayscaleTransformation(),
                    CircleCropTransformation(),
//                    BlurTransformation(LocalContext.current),
//                    RoundedCornersTransformation(50f)
                )
            }
        )
        val painterState = painter.state
        Image(painter = painter, contentDescription = "Logo")

        // loader before image
//        if(painterState is ImagePainter.State.Loading){
//            CircularProgressIndicator()
//        }
    }
}

@ExperimentalCoilApi
@Preview
@Composable
fun CoilImagePreview(){
    CoilImage()
}