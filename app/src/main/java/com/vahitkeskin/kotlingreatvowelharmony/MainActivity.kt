package com.vahitkeskin.kotlingreatvowelharmony

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.vahitkeskin.kotlingreatvowelharmony.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun checkIt(view: View) {
        val thick = arrayOf("a", "ı", "o", "u")
        val thin = arrayOf("e", "i", "ö", "ü")
        val number = arrayOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9")
        var thinIsThere = false
        var thickIsThere = false
        var numberIsThere = false
        val inputValue = binding.etInput.text.toString()
        if (inputValue.isNotEmpty()) {
            for (charter in inputValue.toCharArray()) {
                if (thick.contains(charter.toString())) {
                    thickIsThere = true
                }
                if (thin.contains(charter.toString())) {
                    thinIsThere = true
                }
                if (number.contains(charter.toString())) {
                    numberIsThere = true
                }
            }
            binding.tvOutput.isVisible = true
            if (numberIsThere) {
                binding.tvOutput.text = "\"$inputValue\" Bir rakam"
            } else if (thickIsThere && thinIsThere) {
                binding.tvOutput.text = "\"$inputValue\" Büyük ünlü uyumuna uymaz"
            } else if (thickIsThere && !thinIsThere) {
                binding.tvOutput.text = "\"$inputValue\" Büyük ünlü uyumuna uyar"
            } else if (!thickIsThere && thinIsThere) {
                binding.tvOutput.text = "\"$inputValue\" Büyük ünlü uyumuna uyar"
            }
        } else {
            binding.etInput.error = "Lütfen doldurunuz!!!"
        }
        binding.etInput.text.clear()
    }
}