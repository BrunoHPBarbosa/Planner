package com.app.planner.data.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import java.io.ByteArrayOutputStream

fun Context.imageUriBitmap(uri: Uri): Bitmap? =
    try {
        val contentResolver = this.contentResolver
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            val source = ImageDecoder.createSource(contentResolver,uri)
            ImageDecoder.decodeBitmap(source)
        }else{
            MediaStore.Images.Media.getBitmap(contentResolver,uri)
        }
    }catch (_: Exception){
        null
    }

fun imageBitMapToBase64(bitmap: Bitmap): String {
    val biteArrayOutPutString = ByteArrayOutputStream()
    bitmap.compress(Bitmap.CompressFormat.WEBP, 50, biteArrayOutPutString)
    val byteArray = biteArrayOutPutString.toByteArray()
    return android.util.Base64.encodeToString(byteArray, android.util.Base64.DEFAULT)
}

fun imageBase64ToBitmap(base64String: String): Bitmap? =
    try {
        val decodeBytes = android.util.Base64.decode(base64String,android.util.Base64.DEFAULT)
        BitmapFactory.decodeByteArray(decodeBytes,0,decodeBytes.size)
    }catch (_: Exception) {
        null
    }