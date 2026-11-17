package org.utl.ldsm406_harrypotterapp.data.remote

import org.utl.ldsm406_harrypotterapp.data.model.ApiResponse
import org.utl.ldsm406_harrypotterapp.data.model.Book
import org.utl.ldsm406_harrypotterapp.data.model.Character
import retrofit2.http.GET

interface HogwartsApiService {
    @GET("books")
    suspend fun getBooks(): ApiResponse<List<Book>>

    @GET("characters")
    suspend fun getCharacters(): ApiResponse<List<Character>>
}