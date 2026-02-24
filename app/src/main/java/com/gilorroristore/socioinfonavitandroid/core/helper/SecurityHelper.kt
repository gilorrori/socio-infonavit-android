package com.gilorroristore.socioinfonavitandroid.core.helper

import android.util.Base64
import com.gilorroristore.socioinfonavitandroid.core.Constants
import java.security.KeyFactory
import java.security.PublicKey
import java.security.spec.X509EncodedKeySpec
import javax.crypto.Cipher

fun getPublicKey(): PublicKey {
    val cleanedKey = Constants.PUBLIC_KEY
        .replace("-----BEGIN PUBLIC KEY-----", "")
        .replace("-----END PUBLIC KEY-----", "")
        .replace("\\s".toRegex(), "")
    val decoded = Base64.decode(cleanedKey, Base64.NO_WRAP)

    val keySpec = X509EncodedKeySpec(decoded)
    val keyFactory = KeyFactory.getInstance("RSA")

    return keyFactory.generatePublic(keySpec)
}

fun encryptRSA(textToEncrypt: String): String {
    val cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding")
    cipher.init(Cipher.ENCRYPT_MODE, getPublicKey())
    val encryptedBytes = cipher.doFinal(textToEncrypt.toByteArray())
    return Base64.encodeToString(encryptedBytes, Base64.NO_WRAP)
}