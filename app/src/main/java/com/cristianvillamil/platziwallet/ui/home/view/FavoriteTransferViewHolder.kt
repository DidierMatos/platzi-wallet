package com.cristianvillamil.platziwallet.ui.home.view

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.cristianvillamil.platziwallet.R
import com.cristianvillamil.platziwallet.ui.home.FavoriteTransfer
import com.squareup.picasso.Picasso

//Se encarga de pintar en este caso cada uno de los elementos
class FavoriteTransferViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(item: FavoriteTransfer) {
        val photoImageView = view.findViewById<ImageView>(R.id.profilePhotoImageView)
        Picasso.get().load(item.photoUrl).into(photoImageView)
    }
}