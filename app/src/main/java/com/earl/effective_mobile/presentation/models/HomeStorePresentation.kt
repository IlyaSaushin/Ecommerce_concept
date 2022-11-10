package com.earl.effective_mobile.presentation.models

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition

interface HomeStorePresentation : com.earl.core.Same<HomeStorePresentation> {

    override fun same(data: HomeStorePresentation) = data == this

    fun initColor(bitmap: Bitmap) : Int

    fun details(
        name: TextView,
        description: TextView,
        image: ImageView,
        layout: ConstraintLayout
    )

    fun isNew() : Boolean

    class Base(
        val id: Int,
        val is_new: Boolean,
        val title: String,
        val subtitle: String,
        val picture: String,
        val is_buy: Boolean,
    ) : HomeStorePresentation {

        override fun details(name: TextView, description: TextView, image: ImageView, layout: ConstraintLayout) {
            name.text = title
            description.text = subtitle
            Glide.with(name.context)
                .asBitmap()
                .load(picture)
                .into(object : CustomTarget<Bitmap>(){
                    override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                        layout.setBackgroundColor(initColor(resource))
                        image.setImageBitmap(resource)
                    }
                    override fun onLoadCleared(placeholder: Drawable?) {
                    }
                })
        }

        override fun initColor(bitmap: Bitmap): Int {
            val pixel = bitmap.getPixel(10, 100)
            val redValue: Int = Color.red(pixel)
            val blueValue: Int = Color.blue(pixel)
            val greenValue: Int = Color.green(pixel)
            return Color.rgb(redValue, greenValue, blueValue)
        }

        override fun isNew() = is_new
    }
}