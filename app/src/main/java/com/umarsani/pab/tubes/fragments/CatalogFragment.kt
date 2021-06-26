package com.umarsani.pab.tubes.fragments

import android.content.Context
import android.content.res.TypedArray
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.umarsani.pab.tubes.R
import com.umarsani.pab.tubes.WeedDataclass
import com.umarsani.pab.tubes.WeedAdapter

class CatalogFragment:Fragment(R.layout.fragment_catalog) {
    private lateinit var adapter: WeedAdapter
    private lateinit var dataName: Array<String>
    private lateinit var dataDescription: Array<String>
    private lateinit var dataPhoto: TypedArray
    private var weeds = arrayListOf<WeedDataclass>()
    private lateinit var parentContext: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        parentContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        super.onCreate(savedInstanceState)

        val view: View = inflater.inflate(R.layout.fragment_catalog, container, false)

        val listView: ListView = view.findViewById(R.id.lv_list)

        adapter = WeedAdapter(parentContext)

        listView.adapter = adapter

        prepare()

        addItem()

        return  view
    }

    private fun prepare() {
        dataName = resources.getStringArray(R.array.data_name)
        dataDescription = resources.getStringArray(R.array.data_description)
        dataPhoto = resources.obtainTypedArray(R.array.data_photo)
    }

    private fun addItem() {
        for (position in dataName.indices) {
            val weed = WeedDataclass(
                    dataPhoto.getResourceId(position, -1),
                    dataName[position],
                    dataDescription[position]
            )
            weeds.add(weed)
        }
        adapter.weeds = weeds
    }
}