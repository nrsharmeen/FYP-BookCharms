package com.example.bookcharms

import android.os.Parcel
import android.os.Parcelable

data class EngData(var dataImageE:Int, var dataTitleE:String, var dataDescE: String, var dataDetailImageE: Int): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(dataImageE)
        parcel.writeString(dataTitleE)
        parcel.writeString(dataDescE)
        parcel.writeInt(dataDetailImageE)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<EngData> {
        override fun createFromParcel(parcel: Parcel): EngData {
            return EngData(parcel)
        }

        override fun newArray(size: Int): Array<EngData?> {
            return arrayOfNulls(size)
        }
    }
}

