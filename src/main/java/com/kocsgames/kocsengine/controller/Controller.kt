package com.kocsgames.kocsengine.controller

import android.util.Log
import com.kocsgames.kocsengine.view.GameView

open class Controller(var view: GameView) {


    open fun actionDown(pointX: Float, pointY: Float) {
        Log.i("touchEvent", "actionDown")
    }

    open fun actionUp(pointX: Float, pointY: Float) {
        Log.i("touchEvent", "actionUp")
    }

    open fun actionMove(pointX: Float, pointY: Float) {
        Log.i("touchEvent", "actionMove")
    }
}