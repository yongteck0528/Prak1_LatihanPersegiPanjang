package com.example.prak1_latihanpersegipanjang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var p : EditText
    private lateinit var l : EditText
    private lateinit var kl : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        p = findViewById(R.id.editPanjang)
        l = findViewById(R.id.editLebar)
        kl = findViewById(R.id.txtHasil)

        p.requestFocus()

        val hitung : Button = findViewById(R.id.btn_hitung)
        hitung.setOnClickListener{
            try {


                if (p.length() == 0 && l.length() == 0) {
                    Toast.makeText(this, "Panjang dan Lebar Belum Diinput", Toast.LENGTH_LONG).show()
                } else if (p.length() == 0) {
                    Toast.makeText(this, "Panjang Belum Diinput", Toast.LENGTH_LONG).show()
                } else if (l.length() == 0) {
                    Toast.makeText(this, "Lebar Belum Diinput", Toast.LENGTH_LONG).show()
                } else {
                    val p: Double = p.text.toString().toDouble()
                    val l: Double = l.text.toString().toDouble()
                    val hasil: Double = keliling(p, l)

                    kl.visibility = View.VISIBLE
                    kl.setText("%.2f".format(hasil))
                }
            } catch (e : NumberFormatException){
                Toast.makeText(this, "Input Angka Decimal", Toast.LENGTH_LONG).show()
                p.text.clear()
                l.text.clear()
            }
        }
    }

    private fun keliling(p: Double, l: Double): Double {
        return (p*2)+(l*2)
    }
}