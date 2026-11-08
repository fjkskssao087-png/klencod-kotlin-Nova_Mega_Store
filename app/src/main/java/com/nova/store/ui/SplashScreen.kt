package com.nova.store.ui

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.*
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onFinished: () -> Unit) {
    var startAnim by remember { mutableStateOf(false) }
    val alpha by animateFloatAsState(if (startAnim) 1f else 0f, tween(1500), label = "a")
    
    // حركة الأنمي (Lottie)
    val composition by rememberLottieComposition(LottieCompositionSpec.Url("https://assets10.lottiefiles.com/packages/lf20_2glqweqs.json"))
    val progress by animateLottieCompositionAsState(composition, iterations = LottieConstants.IterateForever)

    LaunchedEffect(Unit) {
        startAnim = true
        delay(4000) // الانتظار 4 ثوانٍ (مدة الحركة)
        onFinished()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(Color(0xFF1A0B2E), Color(0xFF000000)))),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.alpha(alpha)) {
            // الشخصية المتحركة
            LottieAnimation(
                composition = composition,
                progress = { progress },
                modifier = Modifier.size(250.dp)
            )
            
            Spacer(modifier = Modifier.height(30.dp))
            
            Text("NOVA STORE", fontSize = 48.sp, fontWeight = FontWeight.Black, color = Color.White, letterSpacing = 2.sp)
            Spacer(modifier = Modifier.height(10.dp))
            Text("عالم التسوق الفاخر", fontSize = 18.sp, color = Color(0xFF9D4EDD), fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
        }
    }
}