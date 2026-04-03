package androidx.media3.container;

import androidx.media3.common.util.UnstableApi;

/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class Mp4Util {
    private static final int UNIX_EPOCH_TO_MP4_TIME_DELTA_SECONDS = 2082844800;

    private Mp4Util() {
    }

    public static long mp4TimeToUnixTimeMs(long j10) {
        return (j10 - 2082844800) * 1000;
    }

    public static long unixTimeToMp4TimeSeconds(long j10) {
        return (j10 / 1000) + 2082844800;
    }
}
