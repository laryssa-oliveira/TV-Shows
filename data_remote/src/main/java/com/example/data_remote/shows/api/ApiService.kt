package com.example.data_remote.shows.api

import com.example.data.constants.Constants.BASE_URL
import com.example.data.constants.Constants.SHOWS
import com.example.data_remote.shows.model.ShowResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface ApiService {

    @GET(SHOWS)
    suspend fun getShows(): Response<List<ShowResponse>>
    @GET(SHOWS)
    suspend fun getSearchShows(@Query("q") search: String): Response<List<ShowResponse>>

    companion object {
        fun newInstance(): ApiService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(getClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiService::class.java)

        private fun getClient(): OkHttpClient = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build()

    }
}