package com.gilorroristore.socioinfonavitandroid.ui.login

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.EditorInfo
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.gilorroristore.socioinfonavitandroid.R
import com.gilorroristore.socioinfonavitandroid.databinding.ActivityLoginBinding
import com.gilorroristore.socioinfonavitandroid.ui.home.HomeActivity
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val loginViewModel by viewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        initObservers()
    }

    private fun initUI() {
        var userEnable = false
        var pswEnable = false

        binding.etUser.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence?,
                start: Int,
                before: Int,
                count: Int
            ) {
                if (s.toString().isNotEmpty()) {
                    userEnable = true
                    binding.btnSignin.isEnabled = (userEnable && pswEnable)
                } else {
                    userEnable = false
                    binding.btnSignin.isEnabled = false
                }
            }
        })

        binding.etPSW.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence?,
                start: Int,
                before: Int,
                count: Int
            ) {
                if (s.toString().isNotEmpty()) {
                    pswEnable = true
                    binding.btnSignin.isEnabled = (userEnable && pswEnable)
                } else {
                    pswEnable = false
                    binding.btnSignin.isEnabled = false
                }
            }
        })

        binding.etPSW.setOnEditorActionListener { _, actionId, _ ->
            when (actionId) {
                EditorInfo.IME_ACTION_DONE -> {
                    evaluateCred()
                    true
                }

                else -> false
            }
        }

        binding.btnSignin.setOnClickListener {
            evaluateCred()
        }
    }

    fun evaluateCred() {
        val user = binding.etUser.text.toString()
        val psw = binding.etPSW.text.toString()
        if (user.isNotEmpty() && psw.isNotEmpty()) {
            loginViewModel.login("$user:$psw")
        }
    }

    private fun initObservers() {
        loginViewModel.loginState.observe(this) {
            if (it) {
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            } else {
                Snackbar.make(
                    binding.btnSignin,
                    getString(R.string.error_credentials_label),
                    Snackbar.LENGTH_LONG
                ).show()
            }
        }
    }
}