package com.quicksnap.events.presentation.list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.quicksnap.theme.*

enum class EventCategory(val label: String) {
    Climate("Climate"),
    Comedy("Comedy"),
    Education("Education"),
    Sports("Sports"),
    Food("Food"),
    Music("Music"),
    Technology("Technology"),
    Fashion("Fashion"),
    Art("Art"),
}

@Composable
fun EventCategoriesRow(
    modifier: Modifier = Modifier,
    selectedCategory: EventCategory,
    onSelectCategory: (EventCategory) -> Unit,
) {
    ScrollableTabRow(
        modifier = modifier
            .padding(bottom = 20.dp),
        backgroundColor = Color.Transparent,
        selectedTabIndex = selectedCategory.ordinal,
        edgePadding = 32.dp,
        indicator = {
            Box {}
        },
        divider = {
            Spacer(modifier = Modifier.width(4.dp))
        }
    ) {
        val categories = EventCategory.values()
        categories.forEach { category ->
            Tab(
                modifier = Modifier
                    .clip(EventoShaped.small)
                    .background(
                        if (selectedCategory == category) {
                            Primary
                        } else {
                            EventoColors.onBackground
                        }
                    ).padding(horizontal = 4.dp),
                selected = category.ordinal == selectedCategory.ordinal,
                onClick = {
                    onSelectCategory(category)
                },
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 10.dp)
                ) {
                    Text(
                        text = category.label, style = EventoTypography.body1.copy(
                            color = if (selectedCategory == category)
                                White
                            else
                                EventoTypography.body1.color
                        )
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun EventCategoriesPreview() {
    EventCategoriesRow(selectedCategory = EventCategory.Art, onSelectCategory = {})
}