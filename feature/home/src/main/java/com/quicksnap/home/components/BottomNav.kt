package com.quicksnap.home.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.quicksnap.home.R
import com.quicksnap.theme.EventoColors
import com.quicksnap.theme.Gray
import com.quicksnap.theme.selectedBottomNavItemColor
import com.quicksnap.theme.unselectedBottomNavItemColorDark

enum class BottomBarDestinations(
    @DrawableRes val icon: Int,
    @StringRes val label: Int,
) {
    Events(R.drawable.home, R.string.home),
    Tickets(R.drawable.ticket, R.string.tickets),
    HelpCenter(R.drawable.help_center, R.string.help_center),
    Profile(R.drawable.person, R.string.profile)
}

@Composable
fun BottomBar(
    bottomTab: BottomBarDestinations,
    setCurrentBottomBar: (BottomBarDestinations) -> Unit,
) {
    val bottomBarHeight = 60.dp
    val pages = BottomBarDestinations.values()

    BottomNavigation(
        modifier = Modifier
            .fillMaxWidth()
            .navigationBarsPadding()
            .heightIn(min = bottomBarHeight),
        backgroundColor = EventoColors.onBackground
    ) {
        pages.forEach { destination ->
            val selected = destination == bottomTab
            BottomNavigationItem(
                modifier = Modifier.navigationBarsPadding(),
                selected = selected,
                onClick = {
                    setCurrentBottomBar(destination)
                },
                selectedContentColor = selectedBottomNavItemColor,
                unselectedContentColor = if (isSystemInDarkTheme())
                    unselectedBottomNavItemColorDark
                else Gray,
                alwaysShowLabel = false,
                icon = {
                    if (destination == BottomBarDestinations.Profile) {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(R.drawable.profile_img)
                                .crossfade(true)
                                .build(),
                            contentDescription = "Profile photo",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(32.dp)
                                .clip(CircleShape)
                        )
                    } else {
                        Icon(
                            painterResource(destination.icon),
                            contentDescription = stringResource(id = destination.label)
                        )
                    }
                },
                label = {
                    Text(
                        text = stringResource(destination.label),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            )
        }
    }
}