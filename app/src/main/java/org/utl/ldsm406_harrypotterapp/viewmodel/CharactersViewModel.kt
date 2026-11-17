package org.utl.ldsm406_harrypotterapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.utl.ldsm406_harrypotterapp.data.model.Character
import org.utl.ldsm406_harrypotterapp.data.repository.HogwartsRepository
import org.utl.ldsm406_harrypotterapp.data.repository.UiState

class CharactersViewModel (
    private val repository: HogwartsRepository
): ViewModel() {
    private val _state = MutableStateFlow<UiState<List<Character>>>(UiState.Loading)
    val state: StateFlow<UiState<List<Character>>> = _state.asStateFlow()
    init {
        loadCharacters()
    }

    fun loadCharacters() {
        viewModelScope.launch {
            _state.value = UiState.Loading

            try {
                val result = repository.getCharacters()
                _state.value = UiState.Success(result)
            }catch (exception: Exception){
                _state.value = UiState.Error(
                    exception.message ?: "No fue ppsible cargar los personajes"
                )
            }
        }
    }
}