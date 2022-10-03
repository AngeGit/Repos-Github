package com.easytech.qrgenerator.main.ui


import android.Manifest.permission.CAMERA
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.easytech.qrgenerator.R

import com.easytech.qrgenerator.databinding.ActivityMainBinding
import com.easytech.qrgenerator.main.controller.generateQR
import com.easytech.qrgenerator.main.model.QrData
import com.google.zxing.ResultPoint

import com.journeyapps.barcodescanner.BarcodeResult
import com.journeyapps.barcodescanner.BarcodeCallback
import com.journeyapps.barcodescanner.CaptureManager
import com.journeyapps.barcodescanner.camera.CameraSettings



import com.journeyapps.barcodescanner.DecoratedBarcodeView




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context=this
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btConvert.setOnClickListener {
            if (binding.etMessage.text.toString().trim().equals("")){
                    clearQr()
                    Toast.makeText(this,resources.getText(R.string.empty_edittext), Toast.LENGTH_SHORT).show()
            }else{
                    hideKeyboard()
                    var bitmap=binding.ivQrCode.generateQR(binding.etMessage.text.toString())
                    qrData= QrData(bitmap!!, binding.etMessage.text.toString())
                    showQr()
            }
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i(TAG, "onSaveInstanceState")
        if(qrData!=null){
            outState.putParcelable(QrData.QR_DATA_KEY, qrData)
        }

    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i(TAG, "onRestoreInstanceState")
        qrData=  savedInstanceState.getParcelable(QrData.QR_DATA_KEY)
        showQr()
    }
    fun showQr(){
        binding.ivQrCode.setImageBitmap(qrData!!.qrBitmap)
        binding.etMessage.setText(qrData!!.text)
    }
    fun clearQr(){
        binding.ivQrCode.setImageBitmap(null) //Limpiamos el bitmap
        binding.etMessage.setText("")
    }


    private lateinit var binding: ActivityMainBinding
    private lateinit var context:Context
    private  var qrData: QrData? = null
    private val TAG: String = " ········· MAIN ACTIVITY ········· "
}