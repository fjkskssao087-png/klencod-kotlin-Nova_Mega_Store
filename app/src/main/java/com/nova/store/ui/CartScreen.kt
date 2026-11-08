package com.nova.store.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.nova.store.data.Product

@Composable
fun CartScreen(cartItems: List<Product>) {
    val total = cartItems.sumOf { it.price }

    Column(Modifier.fillMaxSize().padding(20.dp)) {
        Text("سلة المشتريات", color = Color.White, fontSize = 28.sp, fontWeight = FontWeight.Black)
        Spacer(modifier = Modifier.height(20.dp))

        if (cartItems.isEmpty()) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("السلة فارغة، اذهب وأضف منتجات!", color = Color.Gray)
            }
        } else {
            LazyColumn(modifier = Modifier.weight(1f)) {
                items(cartItems) { product ->
                    Row(
                        Modifier.fillMaxWidth().padding(vertical = 10.dp).background(Color(0xFF1A1A24), RoundedCornerShape(15.dp)).padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        AsyncImage(model = product.imageUrl, contentDescription = null, modifier = Modifier.size(60.dp).clip(RoundedCornerShape(10.dp)), contentScale = ContentScale.Crop)
                        Spacer(modifier = Modifier.width(15.dp))
                        Column(Modifier.weight(1f)) {
                            Text(product.name, color = Color.White, fontWeight = FontWeight.Bold)
                            Text("\${product.price} ر.س", color = Color(0xFF9D4EDD))
                        }
                    }
                }
            }
            
            // Checkout Button
            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth().height(60.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9D4EDD)),
                shape = RoundedCornerShape(15.dp)
            ) {
                Text("إتمام الشراء (\${total} ر.س)", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}