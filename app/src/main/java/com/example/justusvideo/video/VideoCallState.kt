package com.example.justusvideo.video

import io.getstream.video.android.core.Call

data class VideoCallState (
    val call: Call,
    var callState: CallState? = null,
    val error: String? = null
)

enum class  CallState {
    JOINING,
    ACTIVE,
    ENDED
}