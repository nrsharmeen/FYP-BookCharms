package com.example.bookcharms

import android.os.Parcel
import android.os.Parcelable

data class BestData(var dataImageB:Int, var dataTitleB:String, var dataDescB: String, var dataDetailImageB: Int): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(dataImageB)
        parcel.writeString(dataTitleB)
        parcel.writeString(dataDescB)
        parcel.writeInt(dataDetailImageB)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BestData> {
        override fun createFromParcel(parcel: Parcel): BestData {
            return BestData(parcel)
        }

        override fun newArray(size: Int): Array<BestData?> {
            return arrayOfNulls(size)
        }
    }
}
