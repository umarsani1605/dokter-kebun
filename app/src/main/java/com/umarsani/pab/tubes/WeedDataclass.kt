package com.umarsani.pab.tubes

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WeedDataclass(
        var photo: Int,
        var name: String,
        var description: String
) : Parcelable