package com.cristianvillamil.platziwallet.ui.home

data class FavoriteTransfer( // Mapea donde estan los datos de las transferencias favoritas en el home
    val id: Int,
    val name: String = "",
    val amount: Double = 0.0,
    val date: String?,
    val photoUrl: String?
)