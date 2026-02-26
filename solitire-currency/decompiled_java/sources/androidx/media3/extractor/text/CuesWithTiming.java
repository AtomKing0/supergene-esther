package androidx.media3.extractor.text;

import androidx.media3.common.C;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.UnstableApi;
import com.google.common.collect.y;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@UnstableApi
public class CuesWithTiming {
    public final y<Cue> cues;
    public final long durationUs;
    public final long endTimeUs;
    public final long startTimeUs;

    public CuesWithTiming(List<Cue> list, long j10, long j11) {
        this.cues = y.m(list);
        this.startTimeUs = j10;
        this.durationUs = j11;
        long j12 = C.TIME_UNSET;
        if (j10 != C.TIME_UNSET && j11 != C.TIME_UNSET) {
            j12 = j10 + j11;
        }
        this.endTimeUs = j12;
    }
}
