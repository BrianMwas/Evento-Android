package com.quicksnap.eventoframework.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun EventoTextField(
    modifier: Modifier = Modifier,
    value: String,
    onChange: (String) -> Unit,
    placeholder: String,
    placeholderStyle: TextStyle,
    textStyle: TextStyle,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    paddingStart: Dp = 0.dp,
    cursorColor: Color,
    paddingEnd: Dp = 0.dp,
    singleLine: Boolean = true,
    suffix: (@Composable () -> Unit)? = null,
    prefix: (@Composable () -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
        BasicTextField(
            value = value,
            onValueChange = onChange,
            singleLine = singleLine,
            textStyle = textStyle,
            cursorBrush = SolidColor(cursorColor),
            modifier = modifier.height(48.dp),
            keyboardOptions = keyboardOptions,
            visualTransformation = visualTransformation,
            decorationBox = { innerTextField ->
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (prefix != null) {
                        prefix()
                    }
                    Box(
                        modifier = Modifier
                            .padding(start = paddingStart, end = paddingEnd)
                            .weight(1f)
                    ) {
                        if (value.isEmpty()) {
                            Text(text = placeholder, style = placeholderStyle)
                        }
                        innerTextField()
                    }
                    if (suffix != null) {
                        suffix()
                    }
                }
            }
        )

}

@Preview
@Composable
fun EventoTextFieldPreview() {
        EventoTextField(
            value = "Username",
            onChange = {
                print("message is $it")
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .background(Color.White)
                .clip(RoundedCornerShape(4.dp)),
            singleLine = true,
            placeholder = "Username",
            placeholderStyle = LocalTextStyle.current.copy(
                color = Color.Gray,
            ),
            paddingStart = 27.dp,
            paddingEnd = 27.dp,
            cursorColor = Color.White,
            textStyle = LocalTextStyle.current.copy(
                color = Color.White
            ),
        )

}