package com.earl.effective_mobile.presentation.screens.productDetails.main.recyclerAdapters

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler

class ImagesRecyclerLayoutManager : LinearLayoutManager {

    constructor(context: Context?) : super(context)

    constructor(context: Context?, orientation: Int, reversed: Boolean) : super(context, orientation, reversed)

    override fun checkLayoutParams(lp: RecyclerView.LayoutParams): Boolean {
//        lp.width = width / 3
        return true
    }

    override fun onLayoutCompleted(state: RecyclerView.State) {
        super.onLayoutCompleted(state)
        scaleMiddleItem()
    }

    override fun scrollHorizontallyBy(dx: Int, recycler: Recycler, state: RecyclerView.State): Int {
        val scrolled = super.scrollHorizontallyBy(dx, recycler, state)
        return if (orientation == RecyclerView.HORIZONTAL) {
            scaleMiddleItem()
            scrolled
        } else {
            0
        }
    }

    private fun scaleMiddleItem() {
        val mid = width / 2.0f
        val d1 = 0.9f * mid
        for (i in 0 until childCount) {
            val child = getChildAt(i)
            val childMid = (getDecoratedRight(child!!) + getDecoratedLeft(child)) / 0.2f
            val d = Math.min(d1, Math.abs(mid - childMid))
            val scale = 1f - 0.15f * d / d1
            child.scaleX = scale
            child.scaleY = scale
        }
    }
}
