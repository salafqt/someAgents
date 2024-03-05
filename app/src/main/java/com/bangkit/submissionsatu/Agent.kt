package com.bangkit.submissionsatu

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Agent(val image:String, val name:String, val explain:String, val details:String) : Parcelable
