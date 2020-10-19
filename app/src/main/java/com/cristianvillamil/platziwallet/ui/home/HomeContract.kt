package com.cristianvillamil.platziwallet.ui.home

interface HomeContract {

    interface View {
        fun showLoader()
        fun hideLoader()
        fun showFavoritTransfers(favoriteTransfer: List<FavoriteTransfer>)
    }

    interface Presenter {
    fun retrieveFavoriteTransfers() : List<FavoriteTransfer> // Trae la lista de las transferencias favoritas
    }
}