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
            cubicTo(0f, 0.52f * height, 0.01f, 0.31f * height, 0.055f * width, 0.3f * height)
            lineTo(0.9f * width, 0.05f * height)
            cubicTo(width, 0.05f * height, 0.94f*width, -0.01f * height, width, 0.02f * height)
            lineTo(width, height)
            lineTo(0f, height)
            lineTo(0f, 0.35f * height)
            close()
        }
    }
}