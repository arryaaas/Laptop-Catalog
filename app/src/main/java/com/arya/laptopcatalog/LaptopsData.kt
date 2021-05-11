package com.arya.laptopcatalog

object LaptopsData {
    private val laptopNames = arrayOf(
        "HP Omen",
        "HP Pavilion Gaming",
        "HP Spectre",
        "HP Envy",
        "HP Pavilion",
        "HP Essential Home",
        "HP EliteBook",
        "HP ProBook",
        "HP Essential Business",
        "HP ZBook"
    )

    private val laptopDetails = arrayOf(
        "Mainkan game sebaik mungkin dari mana saja dengan kekuatan dan grafis sekelas desktop.",
        "Grafis dan keandalan dalam perangkat yang terjangkau untuk memenuhi kebutuhan game dan multi-tugas Anda.",
        "Didesain untuk melengkapi gaya Anda dengan bahan premium dan tampilan yang memukau.",
        "Desain ramping dengan performa agar Anda tetap produktif dan terhibur ke mana pun Anda pergi.",
        "Buat, hubungkan, dan bagikan dengan perangkat serbaguna yang memungkinkan Anda menuangkan kreativitas Anda.",
        "Laptop terjangkau dengan performa andal untuk menjalankan tugas sehari-hari Anda.",
        "Laptop trendi yang sangat ringan dengan keamanan terbaik untuk selalu melindungi data Anda di mana pun Anda bekerja.",
        "Laptop tahan lama dengan keandalan dan keamanan untuk menyesuaikan bisnis Anda yang sedang berkembang.",
        "Performa andal untuk menyelesaikan tugas sehari-hari Anda tanpa menguras kantong.",
        "Performa kelas profesional dan grafis profesional untuk pekerja di industri kreatif dan teknis."
    )

    private val laptopPrices = arrayOf(
        "Mulai Dari:  Rp 18.599.000",
        "Mulai Dari:  Rp 11.499.000",
        "Mulai Dari:  Rp 16.899.000",
        "Mulai Dari:  Rp 15.899.000",
        "Mulai Dari:  Rp 11.499.000",
        "Mulai Dari:  Rp 5.799.000",
        "Mulai Dari:  Rp 20.500.000",
        "Mulai Dari:  Rp 14.199.000",
        "Mulai Dari:  Rp 9.200.000",
        "Mulai Dari:  Rp 19.699.000"
    )

    private val laptopSite = arrayOf(
        "https://store.hp.com/id-id/default/laptops-tablets/personal-laptops/omen-laptops.html",
        "https://store.hp.com/id-id/default/laptops-tablets/personal-laptops/pavilion-laptops/pavilion-gaming.html",
        "https://store.hp.com/id-id/default/laptops-tablets/personal-laptops/spectre-laptops.html",
        "https://store.hp.com/id-id/default/laptops-tablets/personal-laptops/envy-laptops.html",
        "https://store.hp.com/id-id/default/laptops-tablets/personal-laptops/pavilion-laptops.html",
        "https://store.hp.com/id-id/default/laptops-tablets/personal-laptops/hp-essential-laptops.html",
        "https://store.hp.com/id-id/default/laptops-tablets/business-laptops/elite-laptops.html",
        "https://store.hp.com/id-id/default/laptops-tablets/business-laptops/probook-laptops.html",
        "https://store.hp.com/id-id/default/laptops-tablets/business-laptops/hp-essential-laptops.html",
        "https://store.hp.com/id-id/default/laptops-tablets/business-laptops/zbook-laptops.html"
    )

    private val laptopsImages = intArrayOf(
        R.drawable.hp_omen,
        R.drawable.hp_pavilion_gaming,
        R.drawable.hp_spectre,
        R.drawable.hp_envy,
        R.drawable.hp_pavilion,
        R.drawable.hp_essential_home,
        R.drawable.hp_elitebook,
        R.drawable.hp_probook,
        R.drawable.hp_essential_bussiness,
        R.drawable.hp_zbook
    )

    val listData: ArrayList<Laptop>
        get() {
            val list = arrayListOf<Laptop>()
            for (position in laptopNames.indices) {
                val laptop = Laptop()
                laptop.name = laptopNames[position]
                laptop.detail = laptopDetails[position]
                laptop.price = laptopPrices[position]
                laptop.site = laptopSite[position]
                laptop.photo = laptopsImages[position]
                list.add(laptop)
            }
            return list
        }
}