package com.gilorroristore.socioinfonavitandroid.domain.model

import android.util.Log
import javax.inject.Inject
import kotlin.random.Random

class RandomBenevit @Inject constructor(){
    fun getBenevitList() : List<BenevitsInfo>{
        val benevitList = mutableListOf<BenevitsInfo>()

        for (i in 0..16){
            generateRandoList()?.let {
                if (benevitList.contains(it)) {
                    benevitList.remove(it)
                    benevitList.add(it)
                } else {
                    benevitList.add(it)
                }
            }
        }

        Log.d("MYLIST", benevitList.toString())
        return benevitList
    }


    private fun generateRandoList(): BenevitsInfo? {
        return when(Random.nextInt(0, 8)){
            0 -> BenevitsInfo.Apple
            1 -> BenevitsInfo.Devlyn
            2 -> BenevitsInfo.Rappi
            3 -> BenevitsInfo.Xbox
            4 -> BenevitsInfo.Adobe
            5 -> BenevitsInfo.DJI
            6 -> BenevitsInfo.Microsoft
            7 -> BenevitsInfo.Samsung
            else -> null
        }
    }
}