package com.malmstein.fenster.factory;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;

import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;

public interface IMediaPlayer {
    void setVideoScalingMode(int mode);

    void stop();

    void release();

    void setAudioSessionId(int id);

    int getAudioSessionId();

    void setSurface(Surface surface);

    void setAudioStreamType(int streamType);

    void setScreenOnWhilePlaying(boolean screenOn);

    void prepareAsync();

    void setDataSource(FileDescriptor fileDescriptor, long startOffset, long length) throws IOException;

    void setDataSource(Context context, Uri uri, Map<String, String> headers) throws IOException;

    int getVideoWidth();

    int getVideoHeight();

    boolean isPlaying();

    void seekTo(int millis);

    void setOnPreparedListener(IOnPreparedListener listener);

    void setOnVideoSizeChangedListener(IOnVideoSizeChangedListener listener);

    void setOnCompletionListener(IOnCompletionListener listener);

    void setOnErrorListener(IOnErrorListener listener);

    void setOnInfoListener(IOnInfoListener listener);

    void setOnBufferingUpdateListener(IOnBufferingUpdateListener listener);

    void setOnSeekCompleteListener(IOnSeekCompleteListener listener);

    void reset();

    void start();

    void pause();

    int getCurrentPosition();

    int getDuration();

    interface IOnPreparedListener {
        void onPrepared(final IMediaPlayer mp);
    }

    interface IOnVideoSizeChangedListener {
        void onVideoSizeChanged(final IMediaPlayer mp, final int width, final int height);
    }

    interface IOnCompletionListener {
        void onCompletion(final IMediaPlayer mp);
    }

    interface IOnErrorListener {
        boolean onError(final IMediaPlayer mp, final int frameworkError, final int implError);
    }

    interface IOnInfoListener {
        boolean onInfo(final IMediaPlayer mp, final int arg1, final int arg2);
    }

    interface IOnBufferingUpdateListener {
        void onBufferingUpdate(final IMediaPlayer mp, final int percent);
    }

    interface IOnSeekCompleteListener {
        void onSeekComplete(final IMediaPlayer mp);
    }
}
