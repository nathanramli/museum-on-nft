package com.ningning.muses.data

import android.os.Parcelable
import com.ningning.muses.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class Museum(
    val name: String,
    val location: String,
    val type: String,
    val established: String,
    val image: Int,
) : Parcelable

val MUSEUMS = listOf<Museum>(
    Museum(
        "Van Gogh Museum",
        "Amsterdam, Netherlands",
        "Art, National",
        "2 June 1973",
        R.drawable.img_van_gogh_museum,
    ),
    Museum(
        "The Metropolitan Museum of Art",
        "New York City, New York",
        "Art",
        "1870 era",
        R.drawable.img_the_metropolitan_museum_of_art,
    ),
    Museum(
        "The British Museum",
        "London, England",
        "Art, History, Culture, National",
        "1753 era",
        R.drawable.img_the_british_museum,
    ),
    Museum(
        "Vatican Museums",
        "Vatican City, Vatican",
        "History",
        "1506 era",
        R.drawable.img_vatican_museums,
    ),
    Museum(
        "Louvre Museum",
        "Paris, France",
        "Art",
        "10 August 1793",
        R.drawable.img_louvre_museum,
    ),
)
