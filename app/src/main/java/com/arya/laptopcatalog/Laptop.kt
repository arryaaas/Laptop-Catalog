package com.arya.laptopcatalog

import android.os.Parcel
import android.os.Parcelable

data class Laptop(
    var name: String = "",
    var detail: String = "",
    var price: String = "",
    var site: String = "",
    var photo: Int = 0
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readInt())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(detail)
        parcel.writeString(price)
        parcel.writeString(site)
        parcel.writeInt(photo)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Laptop> {
        override fun createFromParcel(parcel: Parcel): Laptop {
            return Laptop(parcel)
        }

        override fun newArray(size: Int): Array<Laptop?> {
            return arrayOfNulls(size)
        }
    }
}