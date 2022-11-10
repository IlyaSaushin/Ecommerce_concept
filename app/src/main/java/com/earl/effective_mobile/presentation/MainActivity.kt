package com.earl.effective_mobile.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.earl.effective_mobile.R
import com.earl.effective_mobile.databinding.ActivityMainBinding
import com.earl.effective_mobile.presentation.screens.main.MainFragment
import com.earl.effective_mobile.presentation.screens.basket.BasketFragment
import com.earl.effective_mobile.presentation.screens.productDetails.main.ProductDetailsFragment

class MainActivity : AppCompatActivity(), NavigationContract {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        showFragment(MainFragment.newInstance())
    }

    override fun mainFragment() {
        showFragment(MainFragment())
    }

    override fun detailsFragment() {
        showFragment(ProductDetailsFragment.newInstance())
    }

    override fun cartFragment() {
        showFragment(BasketFragment.newInstance())
    }

    override fun back() {
        supportFragmentManager.popBackStack()
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}