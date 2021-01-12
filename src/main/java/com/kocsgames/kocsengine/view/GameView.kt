package com.kocsgames.kocsengine.view

import android.app.Activity
import android.content.Context
import android.graphics.Canvas
import android.graphics.Point
import android.graphics.Rect
import android.os.Handler
import android.view.MotionEvent
import android.view.View
import com.kocsgames.kocsengine.controller.Controller
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
    var controller: Controller? = null


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

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event!!.action) {
            MotionEvent.ACTION_DOWN -> {
                if (controller != null) {
                    controller!!.actionDown(event.x, event.y)
                }
            }
            MotionEvent.ACTION_MOVE -> {
                if (controller != null) {
                    controller!!.actionMove(event.x, event.y)
                }
            }
            MotionEvent.ACTION_UP -> {
                if (controller != null) {
                    controller!!.actionUp(event.x, event.y)
                }
            }

        }
        return false
    }


}