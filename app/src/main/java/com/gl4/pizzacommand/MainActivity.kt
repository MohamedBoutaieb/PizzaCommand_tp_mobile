package com.gl4.pizzacommand

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.view.View
import android.widget.*
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    lateinit var txtNom: EditText
    lateinit var txtPrenom: EditText
    lateinit var txtAdr: EditText
    lateinit var radioTaille: RadioGroup
    lateinit var olive: CheckBox
    lateinit var fromage: CheckBox
    lateinit var thon: CheckBox
    lateinit var ananas: CheckBox
    lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtNom = findViewById(R.id.nom)
        txtPrenom = findViewById(R.id.FirstName)
        txtAdr = findViewById(R.id.adresse)
        radioTaille = findViewById(R.id.radioGroup)
        olive = findViewById(R.id.Olive)
        fromage = findViewById(R.id.Fromage)
        thon = findViewById(R.id.Thon)
        ananas = findViewById(R.id.Ananas)
        btn = findViewById(R.id.button)
        radioTaille.setOnCheckedChangeListener { group, checkedId ->
            radioTaille.checkedRadioButtonId
        }
    }

    fun command(view: View?) {
        if (view?.id == R.id.button) {

            val intent = Intent(view.context, SplashScreen::class.java)

            var number = "+21696029368"
            checkPermissions()
            val smsManager: SmsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(
                "$number",
                null,
                "Ton pizza is coming !\n  adresse :${txtAdr.text}",
                null,
                null
            )
            //setUp sms intent
//            val smsIntent = Intent(Intent.ACTION_VIEW)
//            smsIntent.data = Uri.parse("sms:$number")
//            startActivity(smsIntent)
            startActivity(intent)
            val text = "Commande en route"
            val duration = Toast.LENGTH_LONG
            val toast = Toast.makeText(applicationContext, text, duration)
            toast.show()


        }
    }


    // to ask for runtime permissions
    private fun checkPermissions() {
        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.SEND_SMS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.SEND_SMS),
                101
            )
        }
    }
}