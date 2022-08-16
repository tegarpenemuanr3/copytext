package com.tegarpenemuan.copytext

import android.content.ClipData
import android.content.ClipboardManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.tegarpenemuan.copytext.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bindView()
    }

    private fun bindView() {
        binding.ivCopy.setOnClickListener {
            Toast.makeText(this,"Text berhasil di copy",Toast.LENGTH_SHORT).show()
            copyText(binding.tvHelloWorld.text.toString())
        }
    }

    fun copyText(text:String) {
        val copyManager = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        val copyText = ClipData.newPlainText("text", text)
        copyManager.setPrimaryClip(copyText)
    }
}