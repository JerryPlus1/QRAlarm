package com.sweak.qralarm.features.add_edit_alarm.di

import android.content.ContentResolver
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object AddEditAlarmModule {

    @Provides
    @ViewModelScoped
    fun provideContentResolver(
        @ApplicationContext context: Context
    ): ContentResolver = context.contentResolver
}