package com.example.lesson2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class TestView: View {

    private val circlePaint = Paint().apply {
        color = Color.BLUE
        strokeWidth = 10f
    }

    private val rectF = RectF()

    private val rectPaint = Paint().apply {
        color = Color.RED
    }

    private val arcPaint = Paint().apply {
        color = Color.GREEN
    }

    private val arcRectF = RectF()


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

//    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
//
//        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
//        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
//
//        setMeasuredDimension()
//    }

    fun setData() {

        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawCircle(width/2f, height/2f, Math.min(width/2f, height/2f), circlePaint)

        rectF.left = 50f
        rectF.right = width - 50f
        rectF.top = 100f
        rectF.bottom = height - 100f

        canvas.drawRect(rectF, rectPaint)

        arcRectF.left = 50f
        arcRectF.right = width - 50f
        arcRectF.top = 100f
        arcRectF.bottom = height - 100f

        canvas.drawArc(arcRectF, 200f, 90f, true, arcPaint)

    }
}