package com.quicksnap.qr


import android.graphics.Bitmap
import android.view.ViewGroup
import android.widget.ImageView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.quicksnap.theme.EventoShaped

@Composable
fun QrCodeView(content: String, modifier: Modifier = Modifier, qrCodeProperties: QrCodeProperties) {

    require(content.isNotEmpty()) { "require the content for barcode be not empty" }

    val bitmap = rememberSaveable {
        mutableStateOf<Bitmap?>(null)
    }
    AndroidView(
        modifier = modifier.defaultMinSize(48.dp),
        factory = { context ->
            ImageView(
                context
            ).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                contentDescription = "QrCode for event"
                setImageBitmap(bitmap.value)
            }
        },
        update = { view ->
            // Init qrcode writer
            val writer = MultiFormatWriter()
            try {
                val bitMatrix = writer.encode(content, BarcodeFormat.QR_CODE, 400, 400)
                val encoder = BarcodeEncoder(
                    qrCodeProperties.foregroundColor.toArgb().toLong(),
                    qrCodeProperties.backgroundColor.toArgb().toLong()
                )
                val map = encoder.createBitmap(bitMatrix)
                view.setImageBitmap(map)
            } catch (e: Exception) {
                println("We found an exception")
            }
        }
    )
}

@Composable
@Preview
fun QrCodeViewPreview() {
    Box(modifier = Modifier.fillMaxSize().background(Color.Red)) {
        QrCodeView(
            content = "Brian Mwangi",
            modifier = Modifier
                .size(60.dp)
                .clip(EventoShaped.medium),
            qrCodeProperties = QrCodeProperties(
                foregroundColor = Color.Magenta,
                backgroundColor = Color.Gray
            )
        )
    }
}