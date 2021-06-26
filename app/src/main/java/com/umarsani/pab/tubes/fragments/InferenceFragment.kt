package com.umarsani.pab.tubes.fragments

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.umarsani.pab.tubes.R
import com.umarsani.pab.tubes.ml.Model
import kotlinx.android.synthetic.main.fragment_inference.*
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.io.File
import java.nio.ByteBuffer

class InferenceFragment : Fragment() {

    private val args: InferenceFragmentArgs by navArgs()
    private lateinit var filePath: String

    private fun getPrediction(bitmap: Bitmap): FloatArray {

        // Memuat model
        val model =
                Model.newInstance(
                        requireContext()
                )

        // Menyiapkan gambar
        val bytes = bitmap.byteCount
        val buffer: ByteBuffer = ByteBuffer.allocate(bytes)
        bitmap.copyPixelsToBuffer(buffer)

        // Menyiapkan input ke model
        val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 256, 256, 3), DataType.FLOAT32)
        inputFeature0.loadBuffer(buffer)

        // Menjalankan inferensi
        val outputs = model.process(inputFeature0)

        // Mendapatkan hasil inferensi
        val outputFeature0 = outputs.outputFeature0AsTensorBuffer

        val outputValue = outputFeature0.floatArray

        return outputValue
    }

    private fun loadText(textResult: FloatArray) {
        var result = textResult.toString()
        text_inference?.setText(result)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        retainInstance = true
        filePath = args.rootDir
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_inference, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val photoFile = File(filePath)

        Glide.with(view)
            .load(photoFile)
            .into(captured_image)

        val selfieBitmap = BitmapFactory.decodeFile(filePath)
        val textResult = getPrediction(selfieBitmap)
        loadText(textResult)
    }

}