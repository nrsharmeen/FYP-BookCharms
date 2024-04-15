package com.example.bookcharms

import android.os.Parcel
import android.os.Parcelable

data class FicData(var dataImageF:Int, var dataTitleF:String, var dataDescF: String, var dataDetailImageF: Int): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(dataImageF)
        parcel.writeString(dataTitleF)
        parcel.writeString(dataDescF)
        parcel.writeInt(dataDetailImageF)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FicData> {
        override fun createFromParcel(parcel: Parcel): FicData {
            return FicData(parcel)
        }

        override fun newArray(size: Int): Array<FicData?> {
            return arrayOfNulls(size)
        }
    }
}
