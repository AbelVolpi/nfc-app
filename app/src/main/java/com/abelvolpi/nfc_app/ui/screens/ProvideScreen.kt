package com.abelvolpi.nfc_app.ui.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abelvolpi.nfc_app.R
import com.abelvolpi.nfc_app.ui.theme.Gray

@Composable
fun ProvideScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 80.dp, start = 40.dp, end = 40.dp)
        ) {
            Box(modifier = Modifier.align(Alignment.CenterHorizontally)){
                ProfileImage()
            }
            Text(
                text = "Username",
                modifier = Modifier.padding(top = 40.dp),
                fontSize = 25.sp,
                fontFamily = FontFamily(Font(R.font.robotoflex_regular))
            )
            Text(
                text = "(47) 9999-9999",
                modifier = Modifier.padding(top = 15.dp),
                fontSize = 20.sp,
                fontFamily = FontFamily(
                    Font(
                        R.font.robotoflex_regular
                    )
                )
            )
        }

        Button(
            onClick = { /*TODO*/ },
            contentPadding = PaddingValues(
                start = 20.dp,
                top = 12.dp,
                end = 20.dp,
                bottom = 12.dp
            ),
            shape = RoundedCornerShape(10.dp), colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(
                    bottom = 40.dp,
                    start = 20.dp,
                    end = 20.dp
                )
                .fillMaxWidth()
        ) {
            Text(
                text = "Provide",
                fontSize = 20.sp,
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.robotoflex_regular))
            )
        }
    }
}

@Preview
@Composable
fun ProfileImage() {
    val infiniteTransition = rememberInfiniteTransition()
    val rotationAnimation = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(tween(1000, easing = LinearEasing))
    )
    val borderWidth = 4.dp
    Image(
        painter = painterResource(id = R.drawable.dog),
        contentScale = ContentScale.Crop,
        contentDescription = "",
        modifier = Modifier
            .size(140.dp)
            .drawBehind {
                rotate(rotationAnimation.value) {
                    drawCircle(color = Gray, style = Stroke(12f))
                }
            }
            .padding(borderWidth)
            .clip(CircleShape),

    )

}

@Preview(showBackground = true)
@Composable
fun ProvideScreenPreview() {
    ProvideScreen()
}
