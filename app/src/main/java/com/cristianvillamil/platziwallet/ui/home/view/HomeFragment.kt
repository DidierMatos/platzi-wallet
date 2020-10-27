package com.cristianvillamil.platziwallet.ui.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cristianvillamil.platziwallet.R
import com.cristianvillamil.platziwallet.ui.home.FavoriteTransfer
import com.cristianvillamil.platziwallet.ui.home.HomeContract
import com.cristianvillamil.platziwallet.ui.home.presenter.HomePresenter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), HomeContract.View {

    private val favoriteTransferAdapter = FavoriteTransferAdapter() //Adaptador del RV y se encarga de renderizar cada uno de los elementos que tenemos de los favoriteTransfers
    private var homePresenter:HomeContract.Presenter? = null//Instancia en Java se colocaba New pero en Kotlin no es necesario

    override fun onCreateView( //Xml que renderiza la vista
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        homePresenter = HomePresenter(this)
        homePresenter?.retrieveFavoriteTransfers() // Si es nulo no llama a la funcion, esto comunica 2 capas
        circularProgress.setProgressWithAnimation( //Donde se muestra el progreso que se tiene y carga la imagen
            70f,
            1000,
            AccelerateDecelerateInterpolator(),
            500
        )
        Picasso
            .get()
            .load("https://media.licdn.com/dms/image/C4E03AQFcCuDIJl0mKg/profile-displayphoto-shrink_200_200/0?e=1583366400&v=beta&t=ymt3xgMe5bKS-2knNDL9mQYFksP9ZHne5ugIqEyRjZs")
            .into(profilePhotoImageView)
    }

    private fun initRecyclerView() {
        favoriteTransfersRecyclerView.layoutManager =
            LinearLayoutManager(context, RecyclerView.HORIZONTAL, false) //Cuando se inicia el RV se coloca esto
        favoriteTransfersRecyclerView.adapter = favoriteTransferAdapter  //seteamos el adaptador




    }

    override fun showLoader() {
        homeLoader.visibility = View.VISIBLE
    }

    override fun hideLoader() {
        homeLoader.visibility = View.GONE
    }

    override fun showFavoritTransfers(favoriteTransfer: List<FavoriteTransfer>) {
        favoriteTransferAdapter.setData(favoriteTransfer) //Seteando la data pero la vista solo se encarga de renderizar con 1 sola responsabilidad
    }
}