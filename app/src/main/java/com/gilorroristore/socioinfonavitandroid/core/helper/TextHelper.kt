package com.gilorroristore.socioinfonavitandroid.core.helper

import android.util.Base64
import java.nio.charset.StandardCharsets

fun getBase64FromString(textToB64: String): String {
    val data = textToB64.toByteArray(StandardCharsets.UTF_8)
    return Base64.encodeToString(data, Base64.NO_WRAP)
}

fun getStringFromBase64(base64: String): String {
    val data = Base64.decode(base64, Base64.NO_WRAP)
    return String(data, StandardCharsets.UTF_8)
}