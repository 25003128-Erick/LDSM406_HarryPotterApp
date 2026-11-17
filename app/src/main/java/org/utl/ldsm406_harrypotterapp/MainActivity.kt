package org.utl.ldsm406_harrypotterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import org.utl.ldsm406_harrypotterapp.data.remote.RetrofitInstance
import org.utl.ldsm406_harrypotterapp.data.repository.HogwartsRepository
import org.utl.ldsm406_harrypotterapp.navigation.HomeView
import org.utl.ldsm406_harrypotterapp.screens.CharactersScreen
import org.utl.ldsm406_harrypotterapp.viewmodel.CharactersViewModel
import org.utl.ldsm406_harrypotterapp.viewmodel.CharactersViewModelFactory


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            HomeView()
        }
    }
}

