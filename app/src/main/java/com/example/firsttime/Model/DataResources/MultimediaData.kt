package com.example.firsttime.Model.DataResources

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MultimediaData(
    var multimedia: List<HashMap<String,String>>
    ): Parcelable
