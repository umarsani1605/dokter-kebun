package com.umarsani.pab.tubes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class WeedAdapter internal constructor(private val context: Context) : BaseAdapter() {

    internal var weeds = arrayListOf<WeedDataclass>()

    override fun getCount(): Int = weeds.size

    override fun getItem(i: Int): Any = weeds[i]

    override fun getItemId(i: Int): Long = i.toLong()

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View {
        var itemView = view
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.weed_items, viewGroup, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val weed = getItem(position) as WeedDataclass
        viewHolder.bind(weed)
        return itemView
    }

    private inner class ViewHolder constructor(private val view: View) {
        private val txtName: TextView = view.findViewById(R.id.txt_name)
        private val txtDescription: TextView = view.findViewById(R.id.txt_description)
        private val imgPhoto: ImageView = view.findViewById(R.id.img_photo)

        internal fun bind(weedDataclass: WeedDataclass) {
            txtName.text = weedDataclass.name
            txtDescription.text = weedDataclass.description
            imgPhoto.setImageResource(weedDataclass.photo)
        }
    }
}
