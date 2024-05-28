package com.example.birthdaycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.birthdaycard.ui.theme.BirthdayCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BirthdayCardTheme {
                BirthdayCard()
            }
        }
    }
}

@Composable
fun BirthdayCard() {
    Box() {
        BirthdayCardImage()
        BirthdayCardText(R.string.happy_birthday_text, R.string.signature_text, modifier = Modifier)
    }
}

@Composable
fun BirthdayCardText(birthdayText: Int, signatureText: Int, modifier: Modifier = Modifier) {
    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(birthdayText),
            fontSize = 100.sp, textAlign = TextAlign.Center, lineHeight = 116.sp
        )
        Text(
            text = stringResource(signatureText),
            fontSize = 40.sp, modifier = Modifier.align(alignment = Alignment.End)
        )
    }
}

/**
 * La propiedad contentScale permite redimensionar el tamaño de una imagen para que esta ocupe todo el espacio disponible.
 * La propiedad alpha modifica la opacidad de una imagen.
 * */
@Composable
fun BirthdayCardImage() {
    Image(
        painter = painterResource(id = R.drawable.androidparty),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        alpha = 0.5f
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BirthdayCardTheme {
        BirthdayCard()
    }
}