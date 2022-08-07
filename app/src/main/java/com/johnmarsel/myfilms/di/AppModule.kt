package com.johnmarsel.myfilms.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.johnmarsel.myfilms.data.local.FilmDatabase
import com.johnmarsel.myfilms.data.local.LocalDataSource
import com.johnmarsel.myfilms.data.remote.FilmsApi
import com.johnmarsel.myfilms.data.remote.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(FilmsApi.BASE_URL)
            .client(OkHttpClient.Builder().also { client ->
                val logging = HttpLoggingInterceptor()
                logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                client.addInterceptor(logging)
            }.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideFilmsApi(retrofit: Retrofit): FilmsApi =
        retrofit.create(FilmsApi::class.java)

    @Provides
    @Singleton
    fun provideDatabase(app: Application): FilmDatabase =
        Room.databaseBuilder(app, FilmDatabase::class.java, "database")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideLocalRepository(db: FilmDatabase): LocalDataSource {
        return LocalDataSource(db)
    }

    @Provides
    @Singleton
    fun provideRemoteRepository(filmsApi: FilmsApi): RemoteDataSource {
        return RemoteDataSource(filmsApi)
    }
}