package com.example.di

import android.content.Context
import androidx.room.Room
import com.example.lovecalculator.LoveApi
import com.example.lovecalculator.room.AppDatabase
import com.example.lovecalculator.room.LoveDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideApi(): LoveApi {
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(LoveApi::class.java)
    }

    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "love_db")
            .allowMainThreadQueries().build()
    }

    @Provides
    fun provideDao(appDatabase: AppDatabase): LoveDao {
        return appDatabase.getLoveDao()
    }

    @Provides
    fun provideHero(): Hero {
        return Hero()
    }

    @Provides
    fun providePreference(@ApplicationContext context: Context): Pref {
        return Pref((context))
    }

}