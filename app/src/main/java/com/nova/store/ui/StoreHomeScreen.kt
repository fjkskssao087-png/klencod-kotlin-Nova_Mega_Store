package com.nova.store.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.nova.store.data.Product
import com.nova.store.data.mockProducts

@Composable
fun StoreHomeScreen(cartItems: List<Product>, onAddToCart: (Product) -> Unit) {
    Column(Modifier.fillMaxSize()) {
        // Header
        Row(
            Modifier.fillMaxWidth().padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text("مرحباً بك في", color = Color.Gray, fontSize = 14.sp)
                Text("Nova Store", color = Color.White, fontSize = 28.sp, fontWeight = FontWeight.Black)
            }
            IconButton(onClick = {}, modifier = Modifier.background(Color(0xFF1A1A24), RoundedCornerShape(12.dp))) {
                Icon(Icons.Default.Search, contentDescription = "Search", tint = Color.White)
            }
        }

        // Banner
        LazyRow(contentPadding = PaddingValues(horizontal = 20.dp), horizontalArrangement = Arrangement.spacedBy(15.dp)) {
            item {
                Box(Modifier.width(300.dp).height(160.dp).background(Brush.horizontalGradient(listOf(Color(0xFF9D4EDD), Color(0xFFFF006E))), RoundedCornerShape(20.dp))) {
                    Text("خصم 50% على الإلكترونيات", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(20.dp))
                }
            }
            item {
                Box(Modifier.width(300.dp).height(160.dp).background(Brush.horizontalGradient(listOf(Color(0xFF0A84FF), Color(0xFF5E5CE6))), RoundedCornerShape(20.dp))) {
                    Text("وصل حديثاً: أزياء 2025", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(20.dp))
                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))
        Text("المنتجات الأكثر مبيعاً", color = Color.White, fontSize = 22.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 20.dp))
        Spacer(modifier = Modifier.height(15.dp))

        // Product Grid
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(20.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            items(mockProducts) { product ->
                ProductCard(product, onAddToCart)
            }
        }
    }
}

@Composable
fun ProductCard(product: Product, onAddToCart: (Product) -> Unit) {
    Column(
        Modifier.background(Color(0xFF1A1A24), RoundedCornerShape(20.dp)).padding(10.dp)
    ) {
        AsyncImage(
            model = product.imageUrl,
            contentDescription = product.name,
            modifier = Modifier.fillMaxWidth().height(150.dp).clip(RoundedCornerShape(15.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(product.name, color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
        Text("\${product.price} ر.س", color = Color(0xFF9D4EDD), fontSize = 16.sp, fontWeight = FontWeight.Black)
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { onAddToCart(product) },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF006E)),
            shape = RoundedCornerShape(12.dp)
        ) {
            Icon(Icons.Default.Add, contentDescription = "Add", tint = Color.White)
            Text("أضف للسلة", color = Color.White, fontWeight = FontWeight.Bold)
        }
    }
}