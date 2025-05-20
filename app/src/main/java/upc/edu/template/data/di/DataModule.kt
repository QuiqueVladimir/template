package upc.edu.template.data.di

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import upc.edu.template.data.remote.ApiConstants
import upc.edu.template.data.remote.GameService
import upc.edu.template.data.repository.GameRepository

object DataModule {

    fun getGameRepository(): GameRepository{
        return GameRepository(getGameService())
    }

    fun getGameService(): GameService{
        return getRetrofit().create(GameService::class.java)
    }

    fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


}