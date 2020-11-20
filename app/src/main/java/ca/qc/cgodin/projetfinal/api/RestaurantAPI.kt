package ca.qc.cgodin.projetfinal.api

import ca.qc.cgodin.projetfinal.models.RestaurantResponse
import ca.qc.cgodin.projetfinal.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RestaurantAPI {

    @GET("maps/api/place/nearbysearch/json")
    suspend fun getRestoList(
        @Query("location")
        latLon: String = "45.4836717,-73.8685617",
        @Query("rankby")
        sortType: String = "distance",
        @Query("type")
        searchType: String = "restaurant",
        @Query("key")
        apiKey: String = API_KEY
    ): Response<RestaurantResponse>

    @GET("maps/api/place/nearbysearch/json")
    suspend fun searchRestoList(
        @Query("location")
        latLon: String = "45.4836717,-73.8685617",
        @Query("distance")
        radius: Int = 1000,
        @Query("type")
        searchType: String = "restaurant",
        @Query("keyword")
        searchTerm: String,
        @Query("key")
        apiKey: String = API_KEY
    ): Response<RestaurantResponse>

}