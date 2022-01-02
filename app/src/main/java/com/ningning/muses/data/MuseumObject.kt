package com.ningning.muses.data

data class MuseumObject(
    val name: String,
    val description: String,
    val likeCount: Int,
    val thumbnail: String,
    val model: String,
)

val MUSEUM_OBJECTS = listOf<MuseumObject>(
    MuseumObject(
        "18th Century Old Oil Can",
        "Mid 18th Century View of Venice Painting Antonietta Brandeis Board Oil Paint ... 18th Century French Oil on Canvas Pheasant Painting in Gilt Frame Signed ...",
        120,
        "https://dl.dropboxusercontent.com/s/qsl2m002jrbln63/18th-century-oil-can-thumbnail.png",
        "https://dl.dropboxusercontent.com/s/kt017q95v3s0a6j/OilCan.glb"
    )
)
