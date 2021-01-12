package com.kocsgames.kocsengine.model

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory


class Sprite {

    var bitmap: Bitmap? = null
    var physic: Physic? = null
    var pointX: Int = 0
    var pointY: Int = 0

    constructor(){}


    constructor(context: Context, resource: Int, physic: Physic?) {
        this.bitmap = BitmapFactory.decodeResource(context.resources, resource)
        this.physic = physic

    }


}