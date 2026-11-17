package org.utl.ldsm406_harrypotterapp.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import org.utl.ldsm406_harrypotterapp.R
import org.utl.ldsm406_harrypotterapp.components.BottomBar
import org.utl.ldsm406_harrypotterapp.screens.BooksScreen
import org.utl.ldsm406_harrypotterapp.screens.Bookss
import org.utl.ldsm406_harrypotterapp.screens.CharactersScreen
import org.utl.ldsm406_harrypotterapp.screens.Characterss

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(){
    var selectedItem by remember { mutableStateOf(0) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = if (selectedItem == 0) "Personajes" else "Libros",
                        color = colorResource(R.color.gold)
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(R.color.oscuro)
                )
            )
        },
        bottomBar = {
            BottomBar(
                selectedItem = selectedItem,
                onItemSelected = {
                    selectedItem = it
                }
            )
        }
    ) {paddingValues ->
        Box(
            modifier = Modifier.fillMaxSize()
                .padding(paddingValues)

        ){
            when(selectedItem){
                0 -> Characterss()
                1 -> Bookss()
            }
        }

    }
}


@Preview
@Composable
fun PreviewHome(){
    HomeView()
}