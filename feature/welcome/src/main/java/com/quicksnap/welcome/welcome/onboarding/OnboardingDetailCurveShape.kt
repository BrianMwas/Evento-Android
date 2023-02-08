package com.quicksnap.welcome.welcome.onboarding

import android.graphics.Canvas
import android.graphics.Paint
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection



class OnboardingDetailCurveShape: Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(
            path = drawOnBoardingBackground(size = size)
        )
    }

    private fun drawOnBoardingBackground(size: Size): Path {
        return Path().apply {
            val height = size.height
            val width = size.width
            moveTo(0f, 0.35f * height)
            cubicTo(0f, 0.33f * height, 0.01f * width, 0.31f * height, 0.05f * width, 0.3f * height)
            lineTo(0.89f * width, 0.006f * height)
            cubicTo(width * 0.92f, -0.001f * height, width, 0.02f * height, width, 0.07f * height)
            lineTo(width, height)
            lineTo(0f, height)
            lineTo(0f, 0.35f * height)
            close()
        }
    }
}