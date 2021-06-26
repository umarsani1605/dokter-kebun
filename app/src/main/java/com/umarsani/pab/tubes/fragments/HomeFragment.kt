package com.umarsani.pab.tubes.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.cardview.widget.CardView
import com.umarsani.pab.tubes.R
import com.umarsani.pab.tubes.CameraActivity

class HomeFragment:Fragment(R.layout.fragment_home), View.OnClickListener {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnKamera: CardView = view.findViewById(R.id.btn_kamera)
        btnKamera.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_kamera -> {
                val moveIntent = Intent(activity, CameraActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }
}