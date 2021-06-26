package com.umarsani.pab.tubes.fragments

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.os.Bundle
import android.util.Log
import android.util.Size
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.umarsani.pab.tubes.CameraActivity.Companion.getOutputDirectory
import kotlinx.android.synthetic.main.fragment_camera.*
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import com.umarsani.pab.tubes.R

class CameraFragment : Fragment() {

    private lateinit var preview: Preview
    private lateinit var imageCapture: ImageCapture
    private lateinit var camera: Camera
    private lateinit var bitmap: Bitmap

    private lateinit var outputDirectory: File
    private lateinit var cameraExecutor: ExecutorService

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_camera, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        camera_capture_button.setOnClickListener { takePhoto() }

        outputDirectory = getOutputDirectory(requireContext())

        cameraExecutor = Executors.newSingleThreadExecutor()

        startCamera()
    }

    private fun startCamera() {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(requireContext())

        cameraProviderFuture.addListener(Runnable {
            val cameraProvider: ProcessCameraProvider = cameraProviderFuture.get()

            preview = Preview.Builder()
                .build()

            imageCapture = ImageCapture.Builder()
                .setCaptureMode(ImageCapture.CAPTURE_MODE_MINIMIZE_LATENCY)
                .setTargetResolution(Size(512, 512))
                .build()

            val cameraSelector =
                CameraSelector.Builder().requireLensFacing(CameraSelector.LENS_FACING_BACK)
                    .build()

            try {
                cameraProvider.unbindAll()

                camera = cameraProvider.bindToLifecycle(
                    this, cameraSelector, preview, imageCapture
                )
                preview?.setSurfaceProvider(viewFinder.createSurfaceProvider(camera?.cameraInfo))
            } catch (exc: Exception) {
                Log.e(TAG, "Binding gagal", exc)
            }

        }, ContextCompat.getMainExecutor(requireContext()))
    }

    private fun takePhoto() {
        val imageCapture = imageCapture ?: return

        val photoFile = File(
            outputDirectory,
            SimpleDateFormat(
                FILENAME_FORMAT, Locale.US
            ).format(System.currentTimeMillis()) + ".jpg"
        )

        imageCapture.takePicture(
            ContextCompat.getMainExecutor(requireContext()),
            object : ImageCapture.OnImageCapturedCallback() {
                override fun onCaptureSuccess(image: ImageProxy) {

                    val buffer = image.planes[0].buffer
                    buffer.rewind()
                    val bytes = ByteArray(buffer.remaining())
                    buffer.get(bytes)
                    bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size, null)
                    val degrees = image.imageInfo.rotationDegrees

                    if (degrees != 0) {
                        bitmap = rotateBitmap(bitmap!!, degrees)
                    }

                    val filePath = saveBitmap(bitmap, photoFile)

                    val action = CameraFragmentDirections.actionCameraToInference(filePath)
                    findNavController().navigate(action)
                }
            })

    }

    private fun saveBitmap(bitmap: Bitmap?, file: File): String {

        try {
            val stream: OutputStream = FileOutputStream(file)
            bitmap?.compress(Bitmap.CompressFormat.JPEG, 100, stream)
            stream.flush()
            stream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return file.absolutePath

    }

    private fun rotateBitmap(bitmap: Bitmap, rotationDegrees: Int): Bitmap {

        val rotationMatrix = Matrix()
        rotationMatrix.postRotate(rotationDegrees.toFloat())
        val rotatedBitmap =
            Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height, rotationMatrix, true)
        bitmap.recycle()

        return rotatedBitmap
    }

    override fun onResume() {
        super.onResume()
        if (!PermissionsFragment.allPermissionsGranted(
                requireContext()
            )
        ) {
            findNavController().navigate(R.id.action_camera_to_permissions)
        }
    }

    companion object {
        private const val TAG = "CameraFragment"
        private const val FILENAME_FORMAT = "yyyy-MM-dd-HH-mm-ss-SSS"
    }
}