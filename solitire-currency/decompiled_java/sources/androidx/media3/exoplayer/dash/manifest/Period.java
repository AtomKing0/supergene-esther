package androidx.media3.exoplayer.dash.manifest;

import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@UnstableApi
public class Period {
    public final List<AdaptationSet> adaptationSets;

    @Nullable
    public final Descriptor assetIdentifier;
    public final List<EventStream> eventStreams;

    @Nullable
    public final String id;
    public final long startMs;

    public Period(@Nullable String str, long j10, List<AdaptationSet> list) {
        this(str, j10, list, Collections.emptyList(), null);
    }

    public int getAdaptationSetIndex(int i10) {
        int size = this.adaptationSets.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (this.adaptationSets.get(i11).type == i10) {
                return i11;
            }
        }
        return -1;
    }

    public Period(@Nullable String str, long j10, List<AdaptationSet> list, List<EventStream> list2) {
        this(str, j10, list, list2, null);
    }

    public Period(@Nullable String str, long j10, List<AdaptationSet> list, List<EventStream> list2, @Nullable Descriptor descriptor) {
        this.id = str;
        this.startMs = j10;
        this.adaptationSets = Collections.unmodifiableList(list);
        this.eventStreams = Collections.unmodifiableList(list2);
        this.assetIdentifier = descriptor;
    }
}
