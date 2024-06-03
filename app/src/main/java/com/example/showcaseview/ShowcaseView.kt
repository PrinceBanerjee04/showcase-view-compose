package com.example.showcaseview

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.boundsInWindow
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.layout.onGloballyPositioned

@Composable
fun ShowcaseView(
    modifier: Modifier = Modifier,
    targetContent: @Composable () -> Unit,
    showcaseContent: @Composable () -> Unit
) {
    var targetBounds by remember { mutableStateOf<Rect?>(null) }
    val density = LocalDensity.current

    Box(modifier = modifier) {
        Layout(
            content = { targetContent() },
            modifier = Modifier.onGloballyPositioned { layoutCoordinates ->
                targetBounds = layoutCoordinates.boundsInWindow()
            }
        ) { measurables, constraints ->
            val placeables = measurables.map { it.measure(constraints) }
            layout(constraints.maxWidth, constraints.maxHeight) {
                placeables.forEach { placeable ->
                    placeable.placeRelative(0, 0)
                }
            }
        }

        if (targetBounds != null) {
            Popup(alignment = Alignment.TopStart) {
                Box(
                    Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.7f))
                        .clickable { /* dismiss the showcase */ }
                ) {
                    Box(
                        Modifier
                            .padding(
                                start = with(density) { targetBounds!!.left.toDp() },
                                top = with(density) { targetBounds!!.top.toDp() }
                            )
                            .background(Color.Transparent)
                    ) {
                        showcaseContent()
                    }
                }
            }
        }
    }
}
