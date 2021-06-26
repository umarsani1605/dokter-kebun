package com.umarsani.pab.tubes.fragments

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.core.content.ContextCompat.checkSelfPermission
import androidx.navigation.fragment.findNavController
import com.umarsani.pab.tubes.R

class PermissionsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (allPermissionsGranted(
                requireContext()
            )
        ) {
            findNavController().navigate(R.id.action_permissions_to_camera)
        } else {
            requestPermissions(
                REQUIRED_PERMISSIONS,
                REQUEST_CODE_PERMISSIONS
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String>, grantResults:
        IntArray
    ) {
        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            if (allPermissionsGranted(
                    requireContext()
                )
            ) {
                findNavController().navigate(R.id.action_permissions_to_camera)
            } else {
                Toast.makeText(
                    context,
                    "Izin tidak diberikan oleh pengguna.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    companion object {
        private const val REQUEST_CODE_PERMISSIONS = 10
        private val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA)
        fun allPermissionsGranted(context: Context) = REQUIRED_PERMISSIONS.all {
            checkSelfPermission(context, it) == PackageManager.PERMISSION_GRANTED
        }
    }
}