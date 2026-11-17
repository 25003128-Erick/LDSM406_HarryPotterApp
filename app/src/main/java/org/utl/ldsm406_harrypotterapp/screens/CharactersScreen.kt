package org.utl.ldsm406_harrypotterapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import org.utl.ldsm406_harrypotterapp.R
import org.utl.ldsm406_harrypotterapp.components.CharacterCard
import org.utl.ldsm406_harrypotterapp.data.model.Character
import org.utl.ldsm406_harrypotterapp.data.remote.RetrofitInstance
import org.utl.ldsm406_harrypotterapp.data.repository.HogwartsRepository
import org.utl.ldsm406_harrypotterapp.data.repository.UiState
import org.utl.ldsm406_harrypotterapp.viewmodel.CharactersViewModel
import org.utl.ldsm406_harrypotterapp.viewmodel.CharactersViewModelFactory

@Composable
fun CharactersScreen(
    state: UiState<List<Character>>,
    onRetry: () -> Unit
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.oscuro))
    ){
        when(state){
            is UiState.Loading -> {
                Box(modifier = Modifier.fillMaxSize()){
                    CircularProgressIndicator(
                        color = colorResource(R.color.gold)
                    )
                }
            }
            is UiState.Error -> {
                Box(modifier = Modifier.fillMaxSize()){
                    Text("Error")
                }
            }
            is UiState.Success -> {
                if(state.data.isEmpty()){
                    Box(modifier = Modifier.fillMaxSize()){
                        Text("No hay personajes")
                    }
                }else{
                    LazyColumn {
                        items(state.data){character ->
                            CharacterCard(character = character)
                        }
                    }
                }
            }
        }
    }

}

@Composable
fun Characterss(){
    val repository = HogwartsRepository(api = RetrofitInstance.api)
    val factory = remember {
        CharactersViewModelFactory(repository)
    }
    val viewModel: CharactersViewModel = viewModel(
        factory = factory
    )
    var state = viewModel.state.collectAsStateWithLifecycle().value

    CharactersScreen(
        state = state,
        onRetry = {

        }
    )
}