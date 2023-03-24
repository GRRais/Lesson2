package com.example.lesson2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import java.lang.Float.min

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

    private var centerX = 0f
    private var centerY = 0f

    private var pointerX = 0f
    private var pointerY = 0f


    constructor(context: Context?) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        val attrt = context.obtainStyledAttributes(attrs, R.styleable.TestView, 0, 0)
        val color = attrt.getColor(R.styleable.TestView_pointerColor, 0)

        circlePaint.color = color
    }

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

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        rectF.left = 50f
        rectF.right = w - 50f
        rectF.top = 100f
        rectF.bottom = h - 100f

        arcRectF.left = 50f
        arcRectF.right = w - 50f
        arcRectF.top = 100f
        arcRectF.bottom = h - 100f

        centerX = width/2f
        centerY = height/2f
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

//    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
//
//        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
//        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
//
//        setMeasuredDimension()
//    }

//    fun setData() {
//
//        invalidate()
//    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawCircle(centerX, centerY, min(centerX, centerY), circlePaint)
        canvas.drawRect(rectF, rectPaint)
        canvas.drawArc(arcRectF, 180f, 90f, true, arcPaint)

        canvas.drawCircle(pointerX, pointerY, 200f, circlePaint)

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        super.onTouchEvent(event)

        pointerX = event.x
        pointerY = event.y

        if (rectF.contains(event.x, event.y)) {
            Log.d("TestView", "YESS")
        } else {
            Log.d("TestView", "NO")

        }

        if (event.action == MotionEvent.ACTION_DOWN) {
            Log.d("TestView", "Action_DOWN x = ${event.x}, y = ${event.y}")
        }

        if (event.action == MotionEvent.ACTION_UP) {
            Log.d("TestView", "Action_UP x = ${event.x}, y = ${event.y}")
        }

        if (event.action == MotionEvent.ACTION_MOVE) {
            Log.d("TestView", "Action_MOVE x = ${event.x}, y = ${event.y}")
        }

        invalidate()

        return true
    }
}