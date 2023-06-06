package com.seyitcanbag.gezegenpro

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.CheckBox
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    val POUND = 2.205
    val MARS = 0.38
    val JUPITER = 2.34
    val VENUS = 0.91

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        boxMars.setOnClickListener(this)
        boxVenus.setOnClickListener(this)
        boxJupiter.setOnClickListener(this)

    }

    fun weightToPound(weight:Double) : Double{
        return weight * POUND
    }
    fun poundToWeight(pound:Double) : Double{
        return pound * 0.453
    }
    override fun onClick(v: View?) {
        v as CheckBox
        var isChecked:Boolean = v.isChecked
        if (!TextUtils.isEmpty(idKilo.text.toString())){
            var userWeight = idKilo.text.toString().toDouble()
            var userPound = weightToPound(userWeight)
            when(v.id){
                R.id.boxMars -> if (isChecked){
                    calculation(v, userPound)
                    boxJupiter.isChecked = false
                    boxVenus.isChecked = false


                }
                R.id.boxJupiter -> if (isChecked){
                    calculation(v, userPound)
                    boxMars.isChecked = false
                    boxVenus.isChecked = false

                }
                R.id.boxVenus -> if (isChecked){
                    calculation(v, userPound)
                    boxMars.isChecked = false
                    boxJupiter.isChecked = false
                }
            }
        }

    }

    fun calculation(checkBox: CheckBox, pound: Double){
        var result:Double = 0.0
        when(checkBox.id){
            R.id.boxMars -> result = MARS * pound
            R.id.boxJupiter -> result = JUPITER * pound
            R.id.boxVenus -> result = VENUS * pound
            else -> 0.0
        }
        var resultToWeight = poundToWeight(result)
        idSonuc.text = resultToWeight.formatla(2).toString()


    }

    fun Double.formatla(howManyDot: Int) = java.lang.String.format("%.${howManyDot}f", this)

}