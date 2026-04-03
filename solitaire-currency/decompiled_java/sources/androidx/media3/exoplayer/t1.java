package androidx.media3.exoplayer;

import androidx.media3.common.Timeline;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;

/* JADX INFO: compiled from: LoadControl.java */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class t1 {
    public static void a(LoadControl loadControl, Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, Renderer[] rendererArr, TrackGroupArray trackGroupArray, ExoTrackSelection[] exoTrackSelectionArr) {
        loadControl.onTracksSelected(rendererArr, trackGroupArray, exoTrackSelectionArr);
    }

    @Deprecated
    public static void b(LoadControl loadControl, Renderer[] rendererArr, TrackGroupArray trackGroupArray, ExoTrackSelection[] exoTrackSelectionArr) {
        loadControl.onTracksSelected(Timeline.EMPTY, LoadControl.EMPTY_MEDIA_PERIOD_ID, rendererArr, trackGroupArray, exoTrackSelectionArr);
    }

    @Deprecated
    public static boolean c(LoadControl loadControl, long j10, float f10, boolean z10, long j11) {
        return loadControl.shouldStartPlayback(Timeline.EMPTY, LoadControl.EMPTY_MEDIA_PERIOD_ID, j10, f10, z10, j11);
    }

    public static boolean d(LoadControl loadControl, Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, long j10, float f10, boolean z10, long j11) {
        return loadControl.shouldStartPlayback(j10, f10, z10, j11);
    }
}
