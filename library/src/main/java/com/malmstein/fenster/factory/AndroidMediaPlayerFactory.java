package com.malmstein.fenster.factory;

import android.media.MediaPlayer;

public class AndroidMediaPlayerFactory implements MediaPlayerFactory {
    @Override
    public int get_MEDIA_INFO_VIDEO_RENDERING_START() {
        return MediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START;
    }

    @Override
    public int get_MEDIA_INFO_BUFFERING_START() {
        return MediaPlayer.MEDIA_INFO_BUFFERING_START;
    }

    @Override
    public int get_MEDIA_INFO_BUFFERING_END() {
        return MediaPlayer.MEDIA_INFO_BUFFERING_END;
    }

    @Override
    public int get_VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING() {
        return MediaPlayer.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING;
    }

    @Override
    public int get_VIDEO_SCALING_MODE_SCALE_TO_FIT() {
        return MediaPlayer.VIDEO_SCALING_MODE_SCALE_TO_FIT;
    }

    @Override
    public int get_MEDIA_ERROR_UNKNOWN() {
        return MediaPlayer.MEDIA_ERROR_UNKNOWN;
    }

    @Override
    public int get_MEDIA_ERROR_IO() {
        return MediaPlayer.MEDIA_ERROR_IO;
    }

    @Override
    public int get_MEDIA_ERROR_MALFORMED() {
        return MediaPlayer.MEDIA_ERROR_MALFORMED;
    }

    @Override
    public int get_MEDIA_ERROR_SERVER_DIED() {
        return MediaPlayer.MEDIA_ERROR_SERVER_DIED;
    }

    @Override
    public int get_MEDIA_ERROR_TIMED_OUT() {
        return MediaPlayer.MEDIA_ERROR_TIMED_OUT;
    }

    @Override
    public int get_MEDIA_ERROR_UNSUPPORTED() {
        return MediaPlayer.MEDIA_ERROR_UNSUPPORTED;
    }

    @Override
    public int get_MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK() {
        return MediaPlayer.MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK;
    }

    @Override
    public IMediaPlayer newInstance() {
        return new AndroidMediaPlayer();
    }

    private static class AndroidMediaPlayer extends MediaPlayer implements IMediaPlayer {
        @Override
        public void setOnPreparedListener(final IOnPreparedListener listener) {
            setOnPreparedListener(new OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    listener.onPrepared((IMediaPlayer) mp);
                }
            });
        }

        @Override
        public void setOnVideoSizeChangedListener(final IOnVideoSizeChangedListener listener) {
            setOnVideoSizeChangedListener(new OnVideoSizeChangedListener() {
                @Override
                public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
                    listener.onVideoSizeChanged((IMediaPlayer) mp, width, height);
                }
            });
        }

        @Override
        public void setOnCompletionListener(final IOnCompletionListener listener) {
            setOnCompletionListener(new OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    listener.onCompletion((IMediaPlayer) mp);
                }
            });
        }

        @Override
        public void setOnErrorListener(final IOnErrorListener listener) {
            setOnErrorListener(new OnErrorListener() {
                @Override
                public boolean onError(MediaPlayer mp, int what, int extra) {
                    return listener.onError((IMediaPlayer) mp, what, extra);
                }
            });
        }

        @Override
        public void setOnInfoListener(final IOnInfoListener listener) {
            setOnInfoListener(new OnInfoListener() {
                @Override
                public boolean onInfo(MediaPlayer mp, int what, int extra) {
                    return listener.onInfo((IMediaPlayer) mp, what, extra);
                }
            });
        }

        @Override
        public void setOnBufferingUpdateListener(final IOnBufferingUpdateListener listener) {
            setOnBufferingUpdateListener(new OnBufferingUpdateListener() {
                @Override
                public void onBufferingUpdate(MediaPlayer mp, int percent) {
                    listener.onBufferingUpdate((IMediaPlayer) mp, percent);
                }
            });
        }

        @Override
        public void setOnSeekCompleteListener(final IOnSeekCompleteListener listener) {
            setOnSeekCompleteListener(new OnSeekCompleteListener() {
                @Override
                public void onSeekComplete(MediaPlayer mp) {
                    listener.onSeekComplete((IMediaPlayer) mp);
                }
            });
        }
    }
}
