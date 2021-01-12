package com.kocsgames.kocsengine.view

import android.app.Activity
import android.content.Context
import android.graphics.Canvas
import android.graphics.Point
import android.graphics.Rect
import android.os.Handler
import android.view.View
import com.kocsgames.kocsengine.model.Sprite


open class GameView(context: Context) : View(context) {


    var screenWidth: Int
    var screenHeight: Int
    val frame_update_millis = 30
    var frame_runnable: Runnable
    var frame_handler: Handler
    var rect: Rect

    var sprites = ArrayList<Sprite>()
    var background: Sprite? = null


    init {

        var activity = this.context as Activity
        var display = activity.windowManager.defaultDisplay
        var point = Point()

        display.getSize(point)
        screenWidth = point.x
        screenHeight = point.y

        rect = Rect(0, 0, screenWidth, screenHeight)

        frame_handler = Handler()
        frame_runnable = Runnable { invalidate() }

    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        drawBackground(canvas)
        drawSprites(canvas)

        frame_handler.postDelayed(frame_runnable, frame_update_millis.toLong())
    }

    private fun drawBackground(canvas: Canvas?) {
        if (background != null) {
            canvas!!.drawBitmap(background!!.bitmap!!, null, rect, null)
        }
    }

    private fun drawSprites(canvas: Canvas?) {
        for (i in 0 until sprites.size) {
            canvas!!.drawBitmap(
                sprites[i].bitmap!!,
                (sprites[i].pointX)!!.toFloat(),
                (sprites[i].pointY)!!.toFloat(),
                null
            )
        }
    }


}