package example.com.interviewincentro.models

import android.os.Parcel
import android.os.Parcelable

class Dream(var dreamtitle:String, var day:String,var description:String, var label:String):Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()
            )


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(dreamtitle)
        parcel.writeString(day)
        parcel.writeString(description)
        parcel.writeString(label)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Dream> {
        override fun createFromParcel(parcel: Parcel): Dream {
            return Dream(parcel)
        }

        override fun newArray(size: Int): Array<Dream?> {
            return arrayOfNulls(size)
        }
    }
}