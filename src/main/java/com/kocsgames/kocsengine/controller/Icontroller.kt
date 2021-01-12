package com.kocsgames.kocsengine.controller

import android.graphics.Canvas
import com.kocsgames.kocsengine.communication.IArrayList
import com.kocsgames.kocsengine.model.Sprite

interface Icontroller {

    fun control(canvas: Canvas?, sprites: ArrayList<Sprite>, communication: IArrayList)


}