package androidx.media3.exoplayer.source;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.util.UnstableApi;

/* JADX INFO: loaded from: classes2.dex */
@UnstableApi
public final class MediaLoadData {
    public final int dataType;
    public final long mediaEndTimeMs;
    public final long mediaStartTimeMs;

    @Nullable
    public final Format trackFormat;

    @Nullable
    public final Object trackSelectionData;
    public final int trackSelectionReason;
    public final int trackType;

    public MediaLoadData(int i10) {
        this(i10, -1, null, 0, null, C.TIME_UNSET, C.TIME_UNSET);
    }

    public MediaLoadData(int i10, int i11, @Nullable Format format, int i12, @Nullable Object obj, long j10, long j11) {
        this.dataType = i10;
        this.trackType = i11;
        this.trackFormat = format;
        this.trackSelectionReason = i12;
        this.trackSelectionData = obj;
        this.mediaStartTimeMs = j10;
        this.mediaEndTimeMs = j11;
    }
}
