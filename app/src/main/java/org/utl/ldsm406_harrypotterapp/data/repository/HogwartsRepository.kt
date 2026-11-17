package org.utl.ldsm406_harrypotterapp.data.repository

import org.utl.ldsm406_harrypotterapp.data.remote.HogwartsApiService

class HogwartsRepository(
    private val api: HogwartsApiService
) {
    suspend fun getCharacters() = api.getCharacters().data
    suspend fun getBooks() = api.getBooks().data
}