package com.nova.store.data

data class Product(
    val id: Int,
    val name: String,
    val price: Double,
    val imageUrl: String,
    val category: String
)

val mockProducts = listOf(
    Product(1, "ساعة ذكية Nova Pro", 299.99, "https://images.unsplash.com/photo-1546868871-7041f2a55e12?w=500&q=80", "إلكترونيات"),
    Product(2, "سماعات لاسلكية X", 149.50, "https://images.unsplash.com/photo-1505740420928-5e560c06d30e?w=500&q=80", "إلكترونيات"),
    Product(3, "حذاء رياضي فاخر", 199.00, "https://images.unsplash.com/photo-1542291026-7eec264c27ff?w=500&q=80", "أزياء"),
    Product(4, "نظارة شمسية سوداء", 89.99, "https://images.unsplash.com/photo-1511499767150-a48a237f0083?w=500&q=80", "أزياء"),
    Product(5, "حقيبة ظهر جلدية", 120.00, "https://images.unsplash.com/photo-1553062407-98eeb64c6a62?w=500&q=80", "أزياء"),
    Product(6, "كاميرا احترافية", 899.99, "https://images.unsplash.com/photo-1516035069371-29a1b244cc32?w=500&q=80", "إلكترونيات")
)