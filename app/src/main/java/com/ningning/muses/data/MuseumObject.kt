package com.ningning.muses.data

data class MuseumObject(
    val name: String,
    val description: String,
    val likeCount: Int,
    val thumbnail: String,
    val model: String,
    val address: String,
    val owner: String,
    val tokenStandard: String,
    val blockchain: String,
)

val MUSEUM_OBJECTS = listOf(
    MuseumObject(
        "18th Century Old Oil Can",
        "Mid 18th Century View of Venice Painting Antonietta Brandeis Board Oil Paint ... 18th Century French Oil on Canvas Pheasant Painting in Gilt Frame Signed ...",
        120,
        "https://dl.dropboxusercontent.com/s/qsl2m002jrbln63/18th-century-oil-can-thumbnail.png",
        "https://dl.dropboxusercontent.com/s/kt017q95v3s0a6j/OilCan.glb",
        "0x2a187453064356c898cae034eaed119e1663acb8",
        "0xe74ab71711981a31d3c38edfe702989f30be29b6",
        "ERC-721",
        "Ethereum"
    ),
    MuseumObject(
        "Gaius Julius Caesar",
        "Gaius Julius Caesar (Latin: [ˈɡaːiʊs ˈjuːliʊs ˈkae̯sar]; 12 July 100 BC – 15 March 44 BC) was a Roman general and statesman. A member of the First Triumvirate, Caesar led the Roman armies in the Gallic Wars before defeating his political rival Pompey in a civil war, and subsequently became dictator of Rome from 49 BC until his assassination in 44 BC. He played a critical role in the events that led to the demise of the Roman Republic and the rise of the Roman Empire.\n" +
                "\n" +
                "In 60 BC, Caesar, Crassus and Pompey formed the First Triumvirate, a political alliance that dominated Roman politics for several years. Their attempts to amass power as Populares were opposed by the Optimates within the Roman Senate, among them Cato the Younger with the frequent support of Cicero. Caesar rose to become one of the most powerful politicians in the Roman Republic through a string of military victories in the Gallic Wars, completed by 51 BC, which greatly extended Roman territory. During this time he both invaded Britain and built a bridge across the Rhine river. These achievements and the support of his veteran army threatened to eclipse the standing of Pompey, who had realigned himself with the Senate after the death of Crassus in 53 BC. With the Gallic Wars concluded, the Senate ordered Caesar to step down from his military command and return to Rome. In 49 BC, Caesar openly defied the Senate's authority by crossing the Rubicon and marching towards Rome at the head of an army.[2] This began Caesar's civil war, which he won, leaving him in a position of near unchallenged power and influence in 45 BC.\n" +
                "\n",
        4001,
        "https://dl.dropboxusercontent.com/s/kh06nuo61r6nvuw/cesar_louvre_museum.png",
        "https://dl.dropboxusercontent.com/s/kh5zum3uxqkp4o1/cesar_louvre_museum.glb",
        "0x3b3ee1931dc30c1957379fac9aba94d1c48a5405",
        "0xcda72070e455bb31c7690a170224ce43623d0b6f",
        "ERC-721",
        "Ethereum"
    ),
    MuseumObject(
        "Amenemhat III",
        "Amenemhat III (Ancient Egyptian: Ỉmn-m-hꜣt) was a pharaoh of ancient Egypt and the sixth king of the Twelfth Dynasty of the Middle Kingdom.[a] He was elevated to throne as co-regent by his father Senusret III, with whom he shared the throne as the active king for twenty years. During his reign, Egypt attained its cultural and economic zenith of the Middle Kingdom.\n" +
                "\n" +
                "The aggressive military and domestic policies of Senusret III, which re-subjugated Nubia and wrested power from the nomarchs allowed Amenemhat III to inherit a stable and peaceful Egypt. He directed his efforts towards an extensive building program with particular focus on Faiyum. Here he dedicated a temple to Sobek, a chapel to Renenutet, erected two colossal statues of himself in Biahmu, and contributed to excavation of Lake Moeris. Most enduring of all, he built for himself two pyramids at Dahshur and Hawara. Becoming the first pharaoh since Sneferu in the Fourth Dynasty to build more than one. Near to his Hawara pyramid is a pyramid for his daughter Neferuptah. To acquire resources for the building program, Amenemhat III exploited the quarries of Egypt and the Sinai for turquoise and copper. Other exploited sites includes the schist quarries at Wadi Hammamat, amethyst from Wadi el-Hudi, fine limestone from Tura, alabaster from Hatnub, red granite from Aswan, and diorite from Nubia. A large corpus of inscriptions attest to the activities at these sites, particularly at Serabit el-Khadim. There is scant evidence of military expeditions during his reign, though a small one is attested at Kumma in his ninth regnal year. He also sent a handful of expeditions to Punt.\n" +
                "\n",
        2351,
        "https://dl.dropboxusercontent.com/s/g4jfyhqdfwr7wko/granite_head_of_amenemhat_iii.png",
        "https://dl.dropboxusercontent.com/s/sh332w3qfthyzaf/granite_head_of_amenemhat_iii.glb",
        "0x495f947276749ce646f68ac8c248420045cb7b5e",
        "0xa4b61e227361a9cd9e62ca10946c27748a382cab",
        "ERC-1155",
        "Ethereum"
    ),
)
