package com.example.lesson2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class TestView: View {
    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val paint = Paint()
        paint.color = Color.BLUE
        paint.strokeWidth = 10f

        canvas.drawCircle(width/2f, height/2f, Math.min(width/2f, height/2f), paint)

        val rectF = RectF()
        rectF.left = 50f
        rectF.right = 50f
        rectF.top = 100f
        rectF.bottom = 100f

        val paint2 = Paint()
        paint2.color = Color.RED
        paint2.strokeWidth = 10f

        canvas.drawRect(rectF, paint2)

    }
}