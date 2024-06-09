package com.example.justusvideo.di

import com.example.justusvideo.VideoCallingApp
import com.example.justusvideo.connect.ConnectViewModel
import com.example.justusvideo.video.VideoCallViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule  = module {
    factory{
        val app = androidContext().applicationContext as VideoCallingApp
        app.client
    }

    viewModelOf(::ConnectViewModel)
    viewModelOf(::VideoCallViewModel)
}