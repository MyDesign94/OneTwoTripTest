package com.example.onetwotriptest.di

import android.content.Context
import com.example.onetwotriptest.core.Constant.BASE_URL
import com.example.onetwotriptest.data.remote.FlightsAPI
import com.example.onetwotriptest.data.repository.GetAllFlightsRepositoryImpl
import com.example.onetwotriptest.domain.interactors.GetAllFlightsInteractor
import com.example.onetwotriptest.domain.reduse.FlightsReduce
import com.example.onetwotriptest.domain.repository.GetAllFlightsRepository
import com.example.onetwotriptest.domain.use_case.GetAllFlightsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideFlightsAPI(client: OkHttpClient): FlightsAPI {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .baseUrl(BASE_URL)
            .build()
            .create(FlightsAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(api: FlightsAPI): GetAllFlightsRepository {
        return GetAllFlightsRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideUseCase(repository: GetAllFlightsRepository ,@ApplicationContext context: Context): GetAllFlightsUseCase {
        return GetAllFlightsInteractor(repository, context = context)
    }

    @Provides
    @Singleton
    fun provideFlightsReduce(useCase: GetAllFlightsUseCase, @ApplicationContext context: Context): FlightsReduce {
        return FlightsReduce(useCase = useCase)
    }
}