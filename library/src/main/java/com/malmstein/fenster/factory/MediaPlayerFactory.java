package com.malmstein.fenster.factory;

public interface MediaPlayerFactory {
    // static constant wrappers
    int get_MEDIA_INFO_VIDEO_RENDERING_START();

    int get_MEDIA_INFO_BUFFERING_START();

    int get_MEDIA_INFO_BUFFERING_END();

    int get_VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING();

    int get_VIDEO_SCALING_MODE_SCALE_TO_FIT();

    int get_MEDIA_ERROR_UNKNOWN();

    int get_MEDIA_ERROR_IO();

    int get_MEDIA_ERROR_MALFORMED();

    int get_MEDIA_ERROR_SERVER_DIED();

    int get_MEDIA_ERROR_TIMED_OUT();

    int get_MEDIA_ERROR_UNSUPPORTED();

    int get_MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK();

    IMediaPlayer newInstance();
}
