package com.example.calculatorintentweb204

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


lateinit var Buttonsms:Button
lateinit var Buttonemail:Button
lateinit var Buttonshare:Button
lateinit var Buttoncall:Button
lateinit var Buttoncamera:Button
lateinit var ButtonMpesa:Button
lateinit var ButtonDial:Button
class intentactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intentactivity)
        Buttonsms=findViewById(R.id.btn_int1)
        Buttonemail=findViewById(R.id.btn_int2)
        Buttonshare=findViewById(R.id.btn_call)
        Buttoncamera=findViewById(R.id.btn_camera)
        Buttoncall=findViewById(R.id.btn_cal1)
        ButtonMpesa=findViewById(R.id.btn_stk)
        ButtonDial=findViewById(R.id.btn_Dial)

        Buttonsms.setOnClickListener {
            val uri = Uri.parse("smsto:0769475680")

            val intent = Intent(Intent.ACTION_SENDTO, uri)

            intent.putExtra("sms_body", "The SMS text")

            startActivity(intent)


        }
        Buttoncamera.setOnClickListener {
            val takepicture=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takepicture,1)
        }
        Buttonemail.setOnClickListener {
            val emailIntent =
                Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "abc@gmail.com", null))

            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject")

            emailIntent.putExtra(Intent.EXTRA_TEXT, "Body")

            startActivity(Intent.createChooser(emailIntent, "Send email..."))

        }
        Buttoncall.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+918511812660"))

            if (ContextCompat.checkSelfPermission(
                    this@intentactivity,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@intentactivity,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(intent)
            }
        }
        ButtonMpesa.setOnClickListener {
            val simToolKitLaunchIntent =
                applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")

            simToolKitLaunchIntent?.let { startActivity(it) }

        }
        Buttonshare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)

            shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

            shareIntent.type = "text/plain"

            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app!")

            startActivity(shareIntent)
        }
        ButtonDial.setOnClickListener {
            val phone = "0769475680"

            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))

            startActivity(intent)

        }


    }
}