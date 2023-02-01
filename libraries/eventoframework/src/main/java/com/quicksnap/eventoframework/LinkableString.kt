package com.quicksnap.eventoframework

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp

@Composable
fun LinkableString(
    modifier: Modifier = Modifier,
    appendString: String,
    pushString: String,
    annotationLink: String = "",
    onClick : () -> Unit
) {
    val annotatedString = buildAnnotatedString {
        append(appendString)
        pushStringAnnotation(tag = pushString, annotationLink)
        withStyle(
            style = SpanStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold
            ),
        ) {
            append(pushString)
        }
        pop()
    }

    ClickableText(
        modifier = modifier,
        text = annotatedString,
        style = MaterialTheme.typography.body1.copy(
            fontSize = 15.sp,
        ),
        onClick = { offset ->
            annotatedString.getStringAnnotations(tag = pushString, start = offset, end = offset)
                .firstOrNull()?.let {
                    onClick()
                }
        }
    )
}