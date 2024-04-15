package com.example.bookcharms

import android.os.Parcel
import android.os.Parcelable

data class NonFicData(var dataImageNF:Int, var dataTitleNF:String, var dataDescNF: String, var dataDetailImageNF: Int): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(dataImageNF)
        parcel.writeString(dataTitleNF)
        parcel.writeString(dataDescNF)
        parcel.writeInt(dataDetailImageNF)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NonFicData> {
        override fun createFromParcel(parcel: Parcel): NonFicData {
            return NonFicData(parcel)
        }

        override fun newArray(size: Int): Array<NonFicData?> {
            return arrayOfNulls(size)
        }
    }
}
