package com.nova.store.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen() {
    Column(Modifier.fillMaxSize().padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(40.dp))
        Box(Modifier.size(100.dp).background(Color(0xFF1A1A24), CircleShape), contentAlignment = Alignment.Center) {
            Icon(Icons.Default.Person, contentDescription = null, tint = Color(0xFF9D4EDD), modifier = Modifier.size(60.dp))
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text("مستخدم Nova", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text("user@novastore.com", color = Color.Gray, fontSize = 16.sp)
        
        Spacer(modifier = Modifier.height(40.dp))
        
        ListItem(
            headlineContent = { Text("طلباتي", color = Color.White) },
            modifier = Modifier.background(Color(0xFF1A1A24), androidx.compose.foundation.shape.RoundedCornerShape(12.dp))
        )
        Spacer(modifier = Modifier.height(10.dp))
        ListItem(
            headlineContent = { Text("العناوين", color = Color.White) },
            modifier = Modifier.background(Color(0xFF1A1A24), androidx.compose.foundation.shape.RoundedCornerShape(12.dp))
        )
    }
}