package com.easytech.qrgenerator.main.model
import android.graphics.Bitmap
import android.os.Parcelable

import kotlinx.parcelize.Parcelize
@Parcelize
data class QrData(
    val qrBitmap: Bitmap,
    val text:String
): Parcelable{
    companion object{
        val QR_DATA_KEY="QR_DATA"
    }
}




