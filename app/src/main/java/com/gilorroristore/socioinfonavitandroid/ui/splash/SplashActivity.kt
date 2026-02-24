package com.gilorroristore.socioinfonavitandroid.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.gilorroristore.socioinfonavitandroid.R
import com.gilorroristore.socioinfonavitandroid.core.Constants
import com.gilorroristore.socioinfonavitandroid.databinding.ActivitySplashBinding
import com.gilorroristore.socioinfonavitandroid.ui.login.LoginActivity

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI() {
        Glide.with(this).load(R.drawable.socio_infonavit)
            .transition(DrawableTransitionOptions.withCrossFade(300)).into(binding.ivLogo)
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
            finish()
        }, Constants.SECONDS_SPLASH)
    }
}