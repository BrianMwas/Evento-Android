package com.quicksnap.eventoframework.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ExpandedButton(
    modifier: Modifier = Modifier,
    height: Dp = 48.dp,
    background: Color,
    shape: Shape,
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
            .clip(shape),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = background,
            contentColor = Color.White,
            disabledBackgroundColor = background.copy(alpha = 0.5f)
        ),
        onClick = onClick
    ) {
        content()
    }
}