package com.gilorroristore.socioinfonavitandroid.ui.home

import com.gilorroristore.socioinfonavitandroid.domain.model.BenevitsInfo

sealed class HomeState {
    data object Loading: HomeState()
    data class Success(val benevitsList: List<BenevitsInfo>): HomeState()
    data class Error(val message: String): HomeState()
}