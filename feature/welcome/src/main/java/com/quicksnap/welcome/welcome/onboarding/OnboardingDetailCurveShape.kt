package com.quicksnap.welcome.welcome.onboarding

import android.graphics.Canvas
import android.graphics.Paint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp


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

class TrapeziumShape: Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(
            path = drawTrapeziumShape(size = size)
        )
    }

    private fun drawTrapeziumShape(size: Size): Path {
        return Path().apply {
            val height = size.height
            val width = size.width
            moveTo(0f, 0.16f * height)
            cubicTo(0f, 0.14f * height, 0.02f * width, 0.12f * height, 0.06f * width, 0.11f * height)
            lineTo(0.92f * width, 0.002f * height)
            cubicTo(width * 0.962f, -0.002f * height, width, 0.02f * height, width, 0.04f * height)
            lineTo(width, height)
            lineTo(0f, height)
            lineTo(0f, 0.16f * height)
            close()
        }
    }
}

@Composable
@Preview
fun ShapePreview() {
    Box(modifier = Modifier.size(800.dp).background(Color.Gray)) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(600.dp)
            .background(Color.White)
            .graphicsLayer {
                shadowElevation = 9.dp.toPx()
                clip = true
                shape = TrapeziumShape()
            }) {
            Text(text = "Testing the shape")
        }
    }
}