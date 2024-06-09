package com.example.justusvideo

import android.app.Application
import com.example.justusvideo.di.appModule
import io.getstream.video.android.core.StreamVideo
import io.getstream.video.android.core.StreamVideoBuilder
import io.getstream.video.android.model.User
import io.getstream.video.android.model.UserType
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class VideoCallingApp:Application() {
    private var currentName: String? = null
    var client: StreamVideo? = null

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@VideoCallingApp)
            modules(appModule)
        }
    }

    fun initVideoClient(username: String) {
        if(client === null || username !== null) {
            StreamVideo.removeClient()
            currentName = username

            client = StreamVideoBuilder(
                context = this,
                apiKey = "r23ywgbhdt8y",
                user = User(
                    id = username,
                    name = username,
                    type = UserType.Guest
                )
            ).build()
        }
    }
}