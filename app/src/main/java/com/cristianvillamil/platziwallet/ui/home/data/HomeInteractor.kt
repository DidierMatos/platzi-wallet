package com.cristianvillamil.platziwallet.ui.home.data

import android.os.Handler
import com.cristianvillamil.platziwallet.ui.home.FavoriteTransfer
import com.cristianvillamil.platziwallet.ui.home.HomeContract

class HomeInteractor { //Se encarga de la comunicación en la capa de red o en este caso local

    fun retrieveFavoriteTransferFromCache(responseCallback: HomeContract.OnResponseCallback){

        //Data
        val items = ArrayList<FavoriteTransfer>()
        items.add(   //Creando la data del modelo que se mostrará
            FavoriteTransfer(
                1,
                "Freddy Vega",
                456.000,
                "Hace 2h",
                "https://media.licdn.com/dms/image/C4E03AQGlqpsnWjB6Yg/profile-displayphoto-shrink_200_200/0?e=1582761600&v=beta&t=dYj3_HcoKdR66KpEup0FPBTziu8xiF2I2snqJbf4DGM"
            )
        )
        items.add(
            FavoriteTransfer(
                1,
                "Nestor Villamil",
                210.900,
                "Ayer",
                "https://krausefx.com/assets/posts/profilePictures/FelixKrause2016.jpg"
            )
        )
        items.add(
            FavoriteTransfer(
                1,
                "Fernando Ávila",
                456.000,
                "Hace 2h",
                "https://www.oliverwyman.com/content/dam/oliver-wyman/v2/careers/profiles/scottbk-profile-460x460.jpg"
            )
        )
        items.add(
            FavoriteTransfer(
                1,
                "Cristian Villamil",
                456.000,
                "Hace 2h",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTw8mKnjVErhmhl5S_aUZfvf86vwZOMJBqbUqM-guT-kv6K4xu&s"
            )
        )
        items.add(
            FavoriteTransfer(
                1,
                "Cristian Villamil",
                456.000,
                "Hace 2h",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTVSEHZQ2HJu9FEzFLU4yEAUv46sfRQjxUYkiVv7IEFxNndQ_7C&s"
            )
        )

        val runnable = Runnable {
            responseCallback.onResponse(items)
        }
        val handler = Handler()
        handler.postDelayed(runnable, 3000)

    }
}