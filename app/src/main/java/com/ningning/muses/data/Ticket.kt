package com.ningning.muses.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Ticket(
    val expired: String,
    val isValid: Boolean,
    val museum: Museum,
) : Parcelable