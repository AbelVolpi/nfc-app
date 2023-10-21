package com.abelvolpi.nfc_app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.abelvolpi.nfc_app.R
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun ReceiveScreen(
    startNFCReader: () -> Unit,
    pauseNFCReader: () -> Unit
) {
    val lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current

    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_START -> {
                    startNFCReader.invoke()
                }
                Lifecycle.Event.ON_PAUSE -> {
                    pauseNFCReader.invoke()
                }
                else -> {}
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(modifier = Modifier.padding(bottom = 100.dp)) {
            LottieAnimation()
            Spacer(modifier = Modifier.size(20.dp))
            Text(text = "Searching device", modifier = Modifier.align(CenterHorizontally))
        }
    }
}

@Composable
fun LottieAnimation() {
    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(R.raw.nfc_lottie)
    )
    LottieAnimation(
        composition = composition,
        iterations = LottieConstants.IterateForever
    )
}

@Preview
@Composable
fun LottieAnimationPreview() {
    LottieAnimation()
}

@Preview(showBackground = true)
@Composable
fun ReceiveScreenPreview() {
//    ReceiveScreen()
}
