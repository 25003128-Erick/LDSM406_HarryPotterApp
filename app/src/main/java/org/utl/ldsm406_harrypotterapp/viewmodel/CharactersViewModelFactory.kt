package org.utl.ldsm406_harrypotterapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.utl.ldsm406_harrypotterapp.data.repository.HogwartsRepository

class CharactersViewModelFactory(
    private val repository: HogwartsRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T{
        if(modelClass.isAssignableFrom(CharactersViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return CharactersViewModel(repository) as T
        }
        throw IllegalArgumentException("ViewModel Desconocido")
    }
}