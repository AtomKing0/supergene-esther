package com.facebook.ads.internal.api;

import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Keep;
import com.facebook.ads.MediaViewVideoRenderer;
import com.facebook.ads.VideoStartReason;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public interface MediaViewVideoRendererApi extends AdComponentViewApiProvider {
    void destroy();

    void disengageSeek(VideoStartReason videoStartReason);

    void engageSeek();

    @IntRange(from = 0)
    int getCurrentTimeMs();

    @IntRange(from = 0)
    int getDuration();

    View getVideoView();

    @FloatRange(from = 0.0d, to = 1.0d)
    float getVolume();

    void initialize(AdViewConstructorParams adViewConstructorParams, MediaViewVideoRenderer mediaViewVideoRenderer);

    void pause(boolean z10);

    void play(VideoStartReason videoStartReason);

    void seekTo(@IntRange(from = 0) int i10);

    void setVolume(@FloatRange(from = 0.0d, to = 1.0d) float f10);

    boolean shouldAutoplay();
}
