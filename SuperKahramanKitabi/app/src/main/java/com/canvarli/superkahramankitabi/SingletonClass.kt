package com.canvarli.superkahramankitabi

import android.graphics.Bitmap

// Bu sınıfın amacı sadece 1 işlem yapmak. Seçilen süperkahramanın bitmap'ini veriyor
class SingletonClass {

    companion object SecilenKahraman {
        var gorsel : Bitmap? = null
    }
}