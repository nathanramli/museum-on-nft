package com.ningning.muses.data

import android.os.Parcelable
import com.ningning.muses.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class MuseumSection(
    val section: String,
    val list: List<Museum>
) : Parcelable

val PopularMuseums = listOf<MuseumSection>(
    MuseumSection(
        "Art",
        listOf<Museum>(
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
        )
    ),
    MuseumSection(
        "Halls of Fame",
        listOf<Museum>(
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
            Museum(
                "Van Gogh Museum",
                "Amsterdam, Netherlands",
                "Art, National",
                "2 June 1973",
                R.drawable.img_van_gogh_museum,
            ),
        )
    ),
    MuseumSection(
        "Military",
        listOf<Museum>(
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
            Museum(
                "Van Gogh Museum",
                "Amsterdam, Netherlands",
                "Art, National",
                "2 June 1973",
                R.drawable.img_van_gogh_museum,
            ),
        )
    ),
    MuseumSection(
        "Music",
        listOf<Museum>(
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
        )
    )
)