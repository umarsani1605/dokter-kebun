package com.umarsani.pab.tubes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.ismaeldivita.chipnavigation.ChipNavigationBar
import com.umarsani.pab.tubes.fragments.HomeFragment
import com.umarsani.pab.tubes.fragments.CatalogFragment
import com.umarsani.pab.tubes.fragments.AboutFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val NavBar = findViewById<ChipNavigationBar>(R.id.ChipNavigationBar)

        val FragmentBeranda = HomeFragment()
        val FragmentRiwayat = CatalogFragment()
        val FragmentTentang = AboutFragment()

        setCurrentFragment(FragmentBeranda)

        NavBar.setOnItemSelectedListener {
                id -> when(id) {
                    R.id.beranda->setCurrentFragment(FragmentBeranda)
                    R.id.riwayat->setCurrentFragment(FragmentRiwayat)
                    R.id.tentang->setCurrentFragment(FragmentTentang)
        }
            true
        }
    }

    private fun setCurrentFragment(fragment:Fragment) = supportFragmentManager.beginTransaction().apply {
        replace(R.id.ScreenFragment,  fragment)
        commit()
    }
}