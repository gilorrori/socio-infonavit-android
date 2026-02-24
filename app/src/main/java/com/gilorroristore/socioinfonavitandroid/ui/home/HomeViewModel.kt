package com.gilorroristore.socioinfonavitandroid.ui.home

import android.content.Intent
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gilorroristore.socioinfonavitandroid.core.Constants
import com.gilorroristore.socioinfonavitandroid.data.network.model.BenevitsResponse
import com.gilorroristore.socioinfonavitandroid.data.repositories.InfonavitRepositoryImpl
import com.gilorroristore.socioinfonavitandroid.domain.model.BenevitsInfo
import com.gilorroristore.socioinfonavitandroid.domain.model.RandomBenevit
import com.gilorroristore.socioinfonavitandroid.ui.login.LoginActivity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val infonavitRepository: InfonavitRepositoryImpl,
    private val randomBenevit: RandomBenevit
) : ViewModel() {

    private val _benevitsList = MutableLiveData<HomeState>(HomeState.Loading)
    val benevitsList: LiveData<HomeState> get() = _benevitsList

    fun getBenevitsListFirstRow() {
        _benevitsList.postValue(HomeState.Loading)

        Handler(Looper.getMainLooper()).postDelayed({
            _benevitsList.postValue(HomeState.Success(randomBenevit.getBenevitList()))
        }, 900)


        // Obtener la lista de Benevits desde WS
        viewModelScope.launch {
            // infonavitRepository.getBenevits()

            HomeState.Loading
        }
    }
}


