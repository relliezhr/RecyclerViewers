package com.example.recyclerviewers

object RecipesData {
    private val data = arrayOf(
        arrayOf(
            "Nasi Goreng",
            "1 buah paha ayam atas bawah rebus, suwir ayamnya\n2 buah telur, kocok lepas\n150 g udang tanpa kulit\n5 buah bakso sapi, potong-potong\n5 buah bakso ikan, potong-potong\n500 g nasi putih\n2 sdm kecap manis Bango\n1 sdt garam\n1/2 sdt gula pasir\n1 buah daun bawang, iris tipis\n1 1/2 sdm bawang goreng untuk taburan\n3 sdm minyak goreng untuk menumis\nBumbu Tumbuk Kasar\n1 sdt terasi, bakar\n3 buah cabai merah besar\n3 buah cabai merah keriting\n2 siung bawang putih\n6 butir bawang merah\nBahan Pelegkap3 buah telur ceplook",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e5/Korean_cuisine-Kimchi_bokkeumbap.jpg/330px-Korean_cuisine-Kimchi_bokkeumbap.jpg"
        ), arrayOf(
            "Semur Betawi",
            "6 buah tahu kotak\n300 gr tempe potong dadu\n3 buah kentang ukuran sedang, potong 2-3 bagian, goreng berkulit\n8 butir bawang merah, iris tipis\n1 lembar daun salam\n1 buah tomat, potong-potong\n1/2 sendok teh pala bubuk\n2 butir cengkeh utuh\n2 cm kayumanis\n200 ml Bango kecap manis\n1 sendok teh garam\n800 ml air\n2 sendok makan minyak untuk menumis\n2 sendok makan bawang goreng untuk taburan\nBumbu Halus\n6 butir kemiri, disangrai\n5 siung bawang putih\n2 sendok teh ketumbar\n1/8 sendok teh jintan putih bubuk",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/4/40/Semur_Daging_Kentang.JPG/300px-Semur_Daging_Kentang.JPG"
        ), arrayOf(
            "Gurame Bakar",
            "800 g (2 ekor) ikan gurame, bersihkan, kerat kedua sisi\n" +
                    "2 sdt air perasan jeruk nipis\n" +
                    "1 sdt garam\n" +
                    "1 sdm air larutan asam jawa\n" +
                    "5 sdm Bango kecap manis\n" +
                    "3 sdm minyak, untuk menumis\n" +
                    "Bumbu halus\n" +
                    "6 butir bawang merah\n" +
                    "3 siung bawang putih\n" +
                    "4 buah cabai merah keriting\n" +
                    "3 buah cabai merah besar\n" +
                    "2 cm jahe\n" +
                    "2 sdt ketumbar butir\n" +
                    "1 sdt garam\n" +
                    "Bahan sambal kecap, aduk rata\n" +
                    "5 sdm Bango kecap manis\n" +
                    "1 buah tomat, buang biji, potong dadu kecil\n" +
                    "5 buah cabai rawit merah, iris tipis\n" +
                    "2 butir bawang merah, iris halus\n" +
                    "5 buah cabai rawit hijau, iris tipis\n" +
                    "1/2 sdt air perasan jeruk nipis",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Gurame_bakar_kecap_1.JPG/408px-Gurame_bakar_kecap_1.JPG"
        ), arrayOf(
            "Semur Jengkol",
            "500 gr jengkol, rebus hingga matang, angkat dan memarkan\n" +
                    "7 sdm Bango kecap manis\n" +
                    "1 sdm gula merah, sisir halus\n" +
                    "1/2 sdt merica putih bubuk\n" +
                    "1 batang serai, memarkan\n" +
                    "2 lembar daun salam\n" +
                    "1 l air\n" +
                    "3 sdm minyak, untuk menumis\n" +
                    "Bumbu Halus\n" +
                    "6 siung bawang putih\n" +
                    "5 butir bawang merah\n" +
                    "2 buah cabai merah keriting\n" +
                    "2 cm kunyit\n" +
                    "3 butir kemiri\n" +
                    "1/2 sdt ketumbar\n" +
                    "1 sdt garam",
            "https://upload.wikimedia.org/wikipedia/commons/7/71/Resep_cara_membuat_semur_jengkol_pedas_yang_yummy.jpg"
        )
    )
    val listData: ArrayList<Recipes>
        get() {
            val list = arrayListOf<Recipes>()
            for (aData in data) {
                val recipes = Recipes()
                recipes.name = aData[0]
                recipes.recipe = aData[1]
                recipes.photo = aData[2]
                list.add(recipes)
            }
            return list
        }
}