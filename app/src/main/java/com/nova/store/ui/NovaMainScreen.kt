package com.nova.store.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.nova.store.data.Product
import com.nova.store.data.mockProducts

sealed class NavItem(val route: String, val icon: ImageVector, val label: String) {
    object Home : NavItem("home", Icons.Default.Home, "الرئيسية")
    object Cart : NavItem("cart", Icons.Default.ShoppingCart, "السلة")
    object Profile : NavItem("profile", Icons.Default.Person, "حسابي")
}

@Composable
fun NovaMainScreen() {
    var currentScreen by remember { mutableStateOf<NavItem>(NavItem.Home) }
    val cartItems = remember { mutableStateListOf<Product>() }

    Scaffold(
        bottomBar = {
            NavigationBar(containerColor = Color(0xFF1A1A24)) {
                listOf(NavItem.Home, NavItem.Cart, NavItem.Profile).forEach { item ->
                    NavigationBarItem(
                        icon = { Icon(item.icon, contentDescription = item.label) },
                        label = { Text(item.label) },
                        selected = currentScreen == item,
                        onClick = { currentScreen = item },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color(0xFFFF006E),
                            selectedTextColor = Color(0xFFFF006E),
                            unselectedIconColor = Color.Gray,
                            unselectedTextColor = Color.Gray
                        )
                    )
                }
            }
        }
    ) { padding ->
        Box(Modifier.padding(padding).fillMaxSize().background(Color(0xFF0A0A0F))) {
            when (currentScreen) {
                NavItem.Home -> StoreHomeScreen(cartItems) { cartItems.add(it) }
                NavItem.Cart -> CartScreen(cartItems)
                NavItem.Profile -> ProfileScreen()
            }
        }
    }
}