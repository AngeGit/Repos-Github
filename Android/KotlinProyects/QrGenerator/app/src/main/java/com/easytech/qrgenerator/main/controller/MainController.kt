package com.easytech.qrgenerator.main.controller

import android.graphics.Bitmap
import android.widget.ImageView
import com.google.zxing.BarcodeFormat
import com.journeyapps.barcodescanner.BarcodeEncoder

fun ImageView.generateQR(text:String) : Bitmap? {
        try {
            var barcodeEncoder: BarcodeEncoder = BarcodeEncoder()
            var bitmap: Bitmap = barcodeEncoder.encodeBitmap(
                text,
                BarcodeFormat.QR_CODE,
                250,
                250
            )
            return bitmap
        }catch(e:Exception){
            e.printStackTrace()
            return null
        }

}