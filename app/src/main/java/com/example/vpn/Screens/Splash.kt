package com.example.vpn.Screens


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.slideOut
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vpn.R
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(
    onSplashComplete: () -> Unit,
) {

    var showContent by remember { mutableStateOf(false) }
    var showImage by remember { mutableStateOf(false) }
    var showWhiteScreen by remember { mutableStateOf(false) }
    var showSmallCircles by remember { mutableStateOf(false) }
    var showLargeCircles by remember { mutableStateOf(false) }
    var showText by remember { mutableStateOf(false) }
    var showArrows by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        showContent = true
        showImage = true
        delay(2000)
        showContent = false
        showImage = false
        showWhiteScreen = true
        delay(1500)
        showSmallCircles = true
        delay(1000)
        showLargeCircles = true
        delay(1000)
        showContent = true
        showText = true
        delay(1000)
        showArrows = true
        delay(1000)


        onSplashComplete()

//        showContent=false
//        showImage=false
//        showWhiteScreen = false
//        showSmallCircles = false
//        showLargeCircles = false
//        showText = false
//        showArrows = false

    }

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {


        Box(
            modifier = Modifier.fillMaxSize(),
        ) {
            AnimatedVisibility(
                visible = showWhiteScreen,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                )
            }

            AnimatedVisibility(
                visible = showArrows,
                enter = fadeIn(tween(1000)),
                exit = fadeOut(tween(1000))
            ) {
                Image(
                    painter = painterResource(R.drawable.lines),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 50.dp, bottom = 50.dp)
                        .align(alignment = Alignment.Center)
                )
            }

            AnimatedVisibility(
                visible = showSmallCircles,
                enter = fadeIn(tween(1000)),
                exit = fadeOut(tween(1000))
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        SmallCircle()

                    }
                }
            }
            AnimatedVisibility(
                visible = showLargeCircles,
                enter = fadeIn(tween(1000)),
                exit = fadeOut(tween(1000))
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        LargeCircle()
                    }
                }
            }

            AnimatedVisibility(
                visible = showContent || showText,
                enter = fadeIn(animationSpec = tween(1500)),
                exit = fadeOut(animationSpec = tween(1500))
            ) {
                MidText()
            }


            AnimatedVisibility(
                visible = showImage,
                enter = fadeIn(tween(1500)),  // Smooth fade-in
                exit =     slideOut(tween(1500, easing = FastOutSlowInEasing)){
                    IntOffset(-100, -500)
                }
            ) {
                Box(modifier = Modifier.fillMaxSize()) {
                    Image(
                        painter = painterResource(R.drawable.up),
                        contentDescription = "",
                        modifier = Modifier
                            .size(250.dp)
                            .align(Alignment.TopStart)  // Correct alignment
                            .padding(top = 30.dp, start = 12.dp)
                    )
                }
            }
                AnimatedVisibility(
                    visible = showImage,
                    enter = fadeIn(tween(1500)),  // Smooth fade-in
                    exit = slideOut(tween(1500, easing = FastOutSlowInEasing)){
                        IntOffset(100, 500)
                    }   // Smooth fade-out
                ) {
                    Box(Modifier.fillMaxSize()) {
                        Image(
                            painter = painterResource(R.drawable.down),
                            contentDescription = "",
                            modifier = Modifier
                                .size(250.dp)
                                .align(Alignment.BottomEnd)  // Correct alignment
                                .padding(bottom = 30.dp, end = 25.dp) // Fixed padding
                        )
                    }
                }
            }
        }
    }



@Composable
fun MidText(modifier: Modifier = Modifier) {
    Box(Modifier.fillMaxSize()) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .padding(start = 20.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.img),
                contentDescription = "image"
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                Text(
                    text = "Virtual Internet",
                    style = TextStyle(
                        fontSize = 25.sp,
                        brush = Brush.linearGradient(
                            colors = listOf(
                                Color(0xFF2BD0BF),
                                Color(0xFF1F5CD1)
                            )
                        ),
                        fontWeight = FontWeight.W900
                    ),

                    )
                Line()
                Text(
                    text = "WHERE SECURITY MEETS SPEED",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.W400
                    ),
                    color = Color(0xFF000000)
                )
                Line()
            }
        }
    }
}

@Composable
fun SmallCircle() {
    Box(
        contentAlignment = Alignment.Center
    ) {

        Canvas(
            modifier = Modifier.size(175.dp)
        ) {
            drawCircle(
                color = Color(0xFFDBE7FF),
            )
        }
    }
}

@Composable
fun LargeCircle(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier.size(371.dp)
        ) {
            drawCircle(
                color = Color(0xFFE5EEFF).copy(alpha = 0.5f),
            )
        }
    }
}

@Composable
fun Line() {
    Row(
        modifier = Modifier
//                .fillMaxWidth(0.8f)
            .width(180.dp)
            .height(2.dp)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFF2BD0BF), Color(0xFF1F5CD1)),

                    )
            )
    ) {}
}
//
//shrinkOut(tween(1500, easing = FastOutSlowInEasing), shrinkTowards = Alignment.TopStart){fullSize->
//    IntSize(fullSize.width / 10, fullSize.height / 5)
//}
//AnimatedVisibility(
//visible =  showImage,
//exit = slideOut(tween(100, easing = FastOutSlowInEasing)){
//    IntOffset(-180,50)
//}
//) {
//}