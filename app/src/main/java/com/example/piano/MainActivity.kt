package com.example.piano

import android.content.Context
import android.content.pm.ActivityInfo
import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.piano.ui.theme.PianoTheme


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PianoTheme{
                Scaffold(modifier = Modifier.fillMaxSize())
                    { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MyLayout() {
    Teclado()
}

@Composable
fun Teclado() {
    val context = LocalContext.current

    Row(Modifier.fillMaxSize()) {

        Column(Modifier.weight(2f).fillMaxHeight().background(Color.Black))
        {

            Box(Modifier.fillMaxWidth().background(Color.Black).size(50.dp))
            Tecla(Modifier.weight(1f)
                .clickable { playSound(context,R.raw.c3) })
                Row (Modifier.weight(0.25f)){
                    Box(Modifier.fillMaxHeight().weight(1f).background(Color.White))
                    Box(Modifier.fillMaxHeight().weight(1f).background(Color.Black))}
            Tecla(Modifier.weight(1f)
                .clickable { playSound(context,R.raw.d3) })
            Row (Modifier.weight(0.25f)){
                Box(Modifier.fillMaxHeight().weight(1f).background(Color.White))
                Box(Modifier.fillMaxHeight().weight(1f).background(Color.Black))}

            Tecla(Modifier.weight(1f)
                .clickable { playSound(context,R.raw.e3) })
            Row (Modifier.weight(0.25f)){
                Box(Modifier.fillMaxHeight().weight(1f).background(Color.White))
                Box(Modifier.fillMaxHeight().weight(1f).background(Color.Black))}
            Tecla(Modifier.weight(1f)
                .clickable { playSound(context,R.raw.f3) })
            Row (Modifier.weight(0.25f)){
                Box(Modifier.fillMaxHeight().weight(1f).background(Color.White))
                Box(Modifier.fillMaxHeight().weight(1f).background(Color.Black))}
            Tecla(Modifier.weight(1f)
                .clickable { playSound(context,R.raw.g3) })
            Row (Modifier.weight(0.25f)){
                Box(Modifier.fillMaxHeight().weight(1f).background(Color.White))
                Box(Modifier.fillMaxHeight().weight(1f).background(Color.Black))}
            Tecla(Modifier.weight(1f)
                .clickable { playSound(context,R.raw.la) })
            Row (Modifier.weight(0.25f)){
                Box(Modifier.fillMaxHeight().weight(1f).background(Color.White))
                Box(Modifier.fillMaxHeight().weight(1f).background(Color.Black))}
            Tecla(Modifier.weight(1f)
                .clickable { playSound(context,R.raw.b3) })
        }
        Column (Modifier.fillMaxHeight().weight(2f).background(Color(0xff4e342e)))
        {
            Box(Modifier.fillMaxWidth().background(Color.Black).size(50.dp))
            Image(
                painter = painterResource(id = R.drawable.piano_parte_de_arriba),
                contentDescription = "Parte superior del piano",
                modifier = Modifier.fillMaxHeight().size(200.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun Tecla(modifier: Modifier) {
        Box(
            modifier
                .fillMaxWidth()
                .background(Color.White),

        )

}
fun playSound(context : Context, soundId : Int){
    val mediaPlayer = MediaPlayer.create(context,soundId)

    mediaPlayer.start()
    mediaPlayer.setOnCompletionListener {
        mediaPlayer.release()
    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    MyLayout()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PianoTheme {
        Greeting("Android")
    }
}