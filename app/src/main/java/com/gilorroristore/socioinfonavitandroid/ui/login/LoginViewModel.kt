package com.gilorroristore.socioinfonavitandroid.ui.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gilorroristore.socioinfonavitandroid.core.Constants
import com.gilorroristore.socioinfonavitandroid.core.helper.encryptRSA
import com.gilorroristore.socioinfonavitandroid.data.network.model.LoginRequest
import com.gilorroristore.socioinfonavitandroid.data.repositories.LoginRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    val loginRepository: LoginRepositoryImpl
) : ViewModel() {
    private val tag: String = LoginViewModel::class.java.simpleName
    private val _loginState = MutableLiveData<Boolean>()
    val loginState: LiveData<Boolean> get() = _loginState

    fun login(cred: String) {
        /*  Obteniendo los datos desde la UI, se concatenan en el formato esperado por el WS y se
        encriptan mediante RSA con la llave publica proporcionada*/
        val encryptedCredentials = LoginRequest(encryptRSA(cred))

        Log.d(tag, "Cadena encriptada $encryptedCredentials \n $cred")

        viewModelScope.launch {
            if (cred == Constants.USER_1 || cred == Constants.USER_2) {
                _loginState.postValue(loginRepository.login(encryptedCredentials))
            } else {
                _loginState.postValue(false)
            }
        }
    }
}