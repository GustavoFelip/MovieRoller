package com.example.diceroller

import android.R.attr.fontWeight
import android.R.attr.top
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiceRollerApp()
            DiceWithButtonAndImage()

        }
    }
}


@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage()
}


@Composable
@Preview
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {

    var result by remember { mutableStateOf(1) }

    val imageResource = when (result) {
        1 -> R.drawable.click
        2 -> R.drawable.rocky2
        3 -> R.drawable.esposadementirinha
        4 -> R.drawable.panico4
        5 -> R.drawable.beforesunset
        6 -> R.drawable.halloween
        7 -> R.drawable.harrypotter
        8 -> R.drawable.onzehomenseumsegredo
        9 -> R.drawable.sebebernaocase2
        10 -> R.drawable.aredesocial
        11 -> R.drawable.asbranquelas
        12 -> R.drawable.ratatouille
        13 -> R.drawable.projetox
        14 -> R.drawable.carros
        15 -> R.drawable.batmancavaleirodastrevas
        16 -> R.drawable.shrek
        17 -> R.drawable.vforvendetta
        18 -> R.drawable.whiplash
        else -> R.drawable.vingadoresultimato
    }

    Box(
        modifier = modifier.fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF101114), // Preto
                        Color(0xFF23252B), // Cinza-escuro
                        Color(0xFF383838)  // Cinza grafite
                    )))) {


        Image(
            painter = painterResource(
                id = R.drawable.martinscorsese
            ),
            contentDescription = "Martin Scorsese - This is Cinema",
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(280.dp),
                contentScale = ContentScale.Fit,
                alignment = Alignment.BottomCenter
        )

    Column(
        // Modifier são classes para modificar um elemento
        modifier = modifier
            .fillMaxSize()
            .padding(top = 5.dp, bottom = 48.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )

    {
        Image(
            painter = painterResource(imageResource),
            contentDescription = result.toString(),
            modifier = Modifier.size(350.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { result = (1..18).random() },
            modifier = Modifier
                .width(150.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF1E88E5)
            )

        ) {
            Text(stringResource(R.string.roll),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White)

        }

    }
        Text(
            text = "MOVIE ROLLER",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 115.dp),
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Red,
            textAlign = TextAlign.Center
        )
}
}