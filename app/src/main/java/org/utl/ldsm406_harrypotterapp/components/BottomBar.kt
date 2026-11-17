package org.utl.ldsm406_harrypotterapp.components

import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import org.utl.ldsm406_harrypotterapp.R

data class BottomItem(
    val title: String,
    val icon: ImageVector
)

@Composable
fun BottomBar(
    selectedItem: Int,
    onItemSelected: (Int) -> Unit,

){
    val items = listOf(
        BottomItem("Personajes", Icons.Default.Person),
        BottomItem("Libros", Icons.Default.MenuBook)
    )
    NavigationBar(
        containerColor = colorResource(R.color.oscuro),
        contentColor = colorResource(R.color.plata)
    ){
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItem == index,
                onClick = {onItemSelected(index)},
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title
                    )
                },
                label = {
                    Text(item.title)
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = colorResource(R.color.gold),
                    unselectedIconColor = colorResource(R.color.dorado),
                    selectedTextColor = colorResource(R.color.gold),
                    unselectedTextColor = colorResource(R.color.plata),
                    indicatorColor = colorResource(R.color.cafe)
                )
            )
        }
    }
}