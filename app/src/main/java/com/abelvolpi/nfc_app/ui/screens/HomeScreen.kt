package com.abelvolpi.nfc_app.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abelvolpi.nfc_app.R
import com.abelvolpi.nfc_app.ui.models.Card

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "NFC Transfer")
                },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "",
                        modifier = Modifier
                            .padding(horizontal = 15.dp)
                            .clickable(onClick = {})
                    )
                }
            )
        }
    ) {
        CardsColumn(
            listOf(
                Card("Provide", R.drawable.img1),
                Card("Receive", R.drawable.img2)
            )
        )
    }
}

@Composable
fun CardsColumn(
    cards: List<Card>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        cards.forEach { card ->
            CardRow(card)
        }
    }
}

@Composable
fun CardRow(
    card: Card
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .clip(shape = RoundedCornerShape(15.dp))
            .background(color = Color.DarkGray)
            .clickable(onClick = {})
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .drawWithCache {
                    val gradient = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black),
                        startY = size.height / 3,
                        endY = size.height
                    )
                    onDrawWithContent {
                        drawContent()
                        drawRect(
                            brush = gradient,
                            blendMode = BlendMode.Multiply
                        )
                    }
                },
            contentScale = ContentScale.Crop,
            painter = painterResource(id = card.imageId),
            contentDescription = ""
        )
        Text(
            text = card.title,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(20.dp),
            color = Color.White,
            fontSize = 25.sp,
            fontFamily = FontFamily(Font(R.font.robotoflex_regular))
        )
    }
}

