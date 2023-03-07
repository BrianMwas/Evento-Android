package com.quicksnap.tickets.presentation.components

import android.graphics.Canvas
import android.graphics.Paint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

class HorizontalTicketShape(private val cornerRadius: Float) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline = Outline.Generic(
        drawShape(size = size, radius = cornerRadius)
    )

    private fun drawShape(size: Size, radius: Float) = Path().apply {
        moveTo(0.9668f * size.width, 0f)
        lineTo(0.77f*size.width, 0f)
        cubicTo(0.7704918f * size.width, 0.03620690f *size.height, 0.7588798f * size.width, 0.06551724f * size.height, 0.7445355f * size.width, 0.06551724f * size.height)
        cubicTo(size.width * 0.7301913f, size.height * 0.06551724f, size.width * 0.7185792f, size.height * 0.03620690f, size.width *0.7185792f, 0f )
        lineTo(size.width * 0.03319672f, 0f)
        cubicTo(size.width *0.01489071f, 0f, 0f, size.height * 0.03758621f, 0f, size.height * 0.08379310f)
        lineTo(0f, size.height* 0.9162069f)
        cubicTo(0f, size.height * 0.9624138f, size.width * 0.01489071f, size.height, size.width * 0.03319672f, size.height)
        lineTo(size.width * 0.7185792f, size.height)
        cubicTo(size.width * 0.7185792f, size.height * 0.9637931f, size.width * 0.7301913f, size.height * 0.9344828f, size.width * 0.7445355f, size.height * 0.9344828f)
        cubicTo(size.width * 0.7588798f, size.height * 0.9344828f, size.width * 0.7704918f, size.height * 0.9637931f, size.width * 0.7704918f, size.height)
        lineTo(size.width * 0.77f, size.height)
        lineTo(size.width * 0.966f, size.height)
        cubicTo(size.width * 0.9851093f, size.height, size.width, size.height * 0.9624138f, size.width, size.height * 0.9162069f)
        lineTo(size.width, size.height * 0.083f)
        cubicTo(size.width, size.height* 0.03758621f, size.width * 0.9851093f, 0f, size.width * 0.9668033f, 0f)
        close()
    }
}

@Preview
@Composable
fun HorizontalShapePreview() {
    Box(modifier = Modifier.fillMaxSize().background(Color.Gray).padding(10.dp)) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clip(HorizontalTicketShape(25f))
            .background(Color.Red)
            .padding(16.dp)) {
            Text(text = "Horizontal Shape")
        }
    }
}