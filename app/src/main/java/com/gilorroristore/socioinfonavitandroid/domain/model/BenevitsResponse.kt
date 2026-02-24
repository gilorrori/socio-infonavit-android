package com.gilorroristore.socioinfonavitandroid.domain.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.google.gson.annotations.SerializedName

data class BenevitsResponse(
    @param:DrawableRes val miniLogoFullPath: Int,
    @param:StringRes val title: Int,
    @param:StringRes val description: Int,
    val acquired: Boolean
)