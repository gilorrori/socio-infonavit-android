package com.gilorroristore.socioinfonavitandroid.domain.model

import com.gilorroristore.socioinfonavitandroid.R

sealed class BenevitsInfo(
    val miniLogoFullPath: Int,
    val title: Int,
    val description: Int,
    val acquired: Boolean
) {
    data object Apple : BenevitsInfo(
        R.drawable.apple,
        R.string.title_benevits_1,
        R.string.description_benevits_1,
        true
    )

    data object Devlyn : BenevitsInfo(
        R.drawable.devlyn,
        R.string.title_benevits_2,
        R.string.description_benevits_2,
        true
    )

    data object Rappi : BenevitsInfo(
        R.drawable.rappi,
        R.string.title_benevits_3,
        R.string.description_benevits_3,
        true
    )

    data object Xbox : BenevitsInfo(
        R.drawable.xbox,
        R.string.title_benevits_4,
        R.string.description_benevits_4,
        false
    )

    data object Adobe : BenevitsInfo(
        R.drawable.adobe,
        R.string.title_benevits_5,
        R.string.description_benevits_5,
        true
    )

    data object DJI : BenevitsInfo(
        R.drawable.dji,
        R.string.title_benevits_6,
        R.string.description_benevits_6,
        true
    )

    data object Microsoft : BenevitsInfo(
        R.drawable.microsoft,
        R.string.title_benevits_7,
        R.string.description_benevits_7,
        true
    )

    data object Samsung : BenevitsInfo(
        R.drawable.samsung,
        R.string.title_benevits_8,
        R.string.description_benevits_8,
        false
    )
}