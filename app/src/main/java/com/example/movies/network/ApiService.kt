package com.example.movies.network

import com.example.movies.model.datamodel.GetMoviesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("movie/now_playing")
    fun getPopularMovies(
        @Query("api_key") apiKey: String = "dea6b6377065f68643ba5398bed9bfd4",
    ): Call<GetMoviesResponse>

}