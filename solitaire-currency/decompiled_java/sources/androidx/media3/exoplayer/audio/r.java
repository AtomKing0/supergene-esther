package androidx.media3.exoplayer.audio;

import android.media.AudioDeviceInfo;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.Format;
import androidx.media3.common.util.Clock;
import androidx.media3.exoplayer.analytics.PlayerId;

/* JADX INFO: compiled from: AudioSink.java */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class r {
    public static AudioOffloadSupport a(AudioSink audioSink, Format format) {
        return AudioOffloadSupport.DEFAULT_UNSUPPORTED;
    }

    public static void b(AudioSink audioSink) {
    }

    public static void c(AudioSink audioSink, Clock clock) {
    }

    @RequiresApi(29)
    public static void e(AudioSink audioSink, int i10) {
    }

    public static void f(AudioSink audioSink, long j10) {
    }

    public static void g(AudioSink audioSink, @Nullable PlayerId playerId) {
    }

    @RequiresApi(23)
    public static void h(AudioSink audioSink, @Nullable AudioDeviceInfo audioDeviceInfo) {
    }

    @RequiresApi(29)
    public static void d(AudioSink audioSink, int i10, int i11) {
    }
}
