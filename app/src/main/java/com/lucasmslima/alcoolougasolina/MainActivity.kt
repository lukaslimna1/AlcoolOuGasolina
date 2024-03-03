package com.lucasmslima.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    //Alcool
    private lateinit var textInputAlcool: TextInputLayout
    private lateinit var editAlcool: TextInputEditText
    //Gasolina
    private lateinit var textInputGasolina: TextInputLayout
    private lateinit var editGasolina: TextInputEditText

    private lateinit var btnCalcular:Button
    private lateinit var textResult: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inicializarComponentesInterface()
        btnCalcular.setOnClickListener {
            calcularMelhorPreco()
        }


    }

    private fun calcularMelhorPreco() {
        val precoAlcool = editAlcool.text.toString()
        val precoGasolina = editGasolina.text.toString()

        val resultadoValidacao = validarCampos(precoAlcool, precoGasolina)
        if (resultadoValidacao){
            //Converte para Numero
            val alcool = precoAlcool.toDouble()
            val gasolina = precoGasolina.toDouble()
            // faz o calculo
            val resultado = alcool / gasolina
            if (resultado >= 0.7){
                textResult.text = "Melhor utilizar Gasolina"

            }else {
                textResult.text = "Melhor utilizar Álcool"
            }
        }

    }

    private fun validarCampos(pAlcool: String, pGasolina: String): Boolean {

        textInputAlcool.error = null
        textInputGasolina.error = null

        if (pAlcool.isEmpty()){
            textInputAlcool.error = "Digite o preço do álcool"
            return false
        } else if (pGasolina. isEmpty()){
            textInputGasolina.error = "Digite o preço da Gasolina"
            return false
        }


        return true
    }

    private fun inicializarComponentesInterface() {
        textInputAlcool = findViewById(R.id.text_input_alcool)
        editAlcool = findViewById(R.id.edit_alcool)

        textInputGasolina = findViewById(R.id.text_input_gasolina)
        editGasolina = findViewById(R.id.edit_gasolina)

        btnCalcular = findViewById(R.id.btn_calcular)
        textResult = findViewById(R.id.text_resultado)

    }
}