package com.example.bookcharms

import android.os.Parcel
import android.os.Parcelable

data class MalayData(var dataImageM:Int, var dataTitleM:String, var dataDescM: String, var dataDetailImageM: Int): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(dataImageM)
        parcel.writeString(dataTitleM)
        parcel.writeString(dataDescM)
        parcel.writeInt(dataDetailImageM)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MalayData> {
        override fun createFromParcel(parcel: Parcel): MalayData {
            return MalayData(parcel)
        }

        override fun newArray(size: Int): Array<MalayData?> {
            return arrayOfNulls(size)
        }
    }
}

