package androidx.media3.exoplayer.source;

import androidx.media3.common.C;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.LoadingInfo;
import com.google.common.collect.y;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@UnstableApi
public final class CompositeSequenceableLoader implements SequenceableLoader {
    private long lastAudioVideoBufferedPositionUs;
    private final com.google.common.collect.y<SequenceableLoaderWithTrackTypes> loadersWithTrackTypes;

    private static final class SequenceableLoaderWithTrackTypes implements SequenceableLoader {
        private final SequenceableLoader loader;
        private final com.google.common.collect.y<Integer> trackTypes;

        public SequenceableLoaderWithTrackTypes(SequenceableLoader sequenceableLoader, List<Integer> list) {
            this.loader = sequenceableLoader;
            this.trackTypes = com.google.common.collect.y.m(list);
        }

        @Override // androidx.media3.exoplayer.source.SequenceableLoader
        public boolean continueLoading(LoadingInfo loadingInfo) {
            return this.loader.continueLoading(loadingInfo);
        }

        @Override // androidx.media3.exoplayer.source.SequenceableLoader
        public long getBufferedPositionUs() {
            return this.loader.getBufferedPositionUs();
        }

        @Override // androidx.media3.exoplayer.source.SequenceableLoader
        public long getNextLoadPositionUs() {
            return this.loader.getNextLoadPositionUs();
        }

        public com.google.common.collect.y<Integer> getTrackTypes() {
            return this.trackTypes;
        }

        @Override // androidx.media3.exoplayer.source.SequenceableLoader
        public boolean isLoading() {
            return this.loader.isLoading();
        }

        @Override // androidx.media3.exoplayer.source.SequenceableLoader
        public void reevaluateBuffer(long j10) {
            this.loader.reevaluateBuffer(j10);
        }
    }

    @Deprecated
    public CompositeSequenceableLoader(SequenceableLoader[] sequenceableLoaderArr) {
        this(com.google.common.collect.y.n(sequenceableLoaderArr), Collections.nCopies(sequenceableLoaderArr.length, com.google.common.collect.y.r(-1)));
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public boolean continueLoading(LoadingInfo loadingInfo) {
        boolean zContinueLoading;
        boolean z10 = false;
        do {
            long nextLoadPositionUs = getNextLoadPositionUs();
            if (nextLoadPositionUs == Long.MIN_VALUE) {
                break;
            }
            zContinueLoading = false;
            for (int i10 = 0; i10 < this.loadersWithTrackTypes.size(); i10++) {
                long nextLoadPositionUs2 = this.loadersWithTrackTypes.get(i10).getNextLoadPositionUs();
                boolean z11 = nextLoadPositionUs2 != Long.MIN_VALUE && nextLoadPositionUs2 <= loadingInfo.playbackPositionUs;
                if (nextLoadPositionUs2 == nextLoadPositionUs || z11) {
                    zContinueLoading |= this.loadersWithTrackTypes.get(i10).continueLoading(loadingInfo);
                }
            }
            z10 |= zContinueLoading;
        } while (zContinueLoading);
        return z10;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public long getBufferedPositionUs() {
        long jMin = Long.MAX_VALUE;
        long jMin2 = Long.MAX_VALUE;
        for (int i10 = 0; i10 < this.loadersWithTrackTypes.size(); i10++) {
            SequenceableLoaderWithTrackTypes sequenceableLoaderWithTrackTypes = this.loadersWithTrackTypes.get(i10);
            long bufferedPositionUs = sequenceableLoaderWithTrackTypes.getBufferedPositionUs();
            if ((sequenceableLoaderWithTrackTypes.getTrackTypes().contains(1) || sequenceableLoaderWithTrackTypes.getTrackTypes().contains(2) || sequenceableLoaderWithTrackTypes.getTrackTypes().contains(4)) && bufferedPositionUs != Long.MIN_VALUE) {
                jMin = Math.min(jMin, bufferedPositionUs);
            }
            if (bufferedPositionUs != Long.MIN_VALUE) {
                jMin2 = Math.min(jMin2, bufferedPositionUs);
            }
        }
        if (jMin != Long.MAX_VALUE) {
            this.lastAudioVideoBufferedPositionUs = jMin;
            return jMin;
        }
        if (jMin2 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        long j10 = this.lastAudioVideoBufferedPositionUs;
        return j10 != C.TIME_UNSET ? j10 : jMin2;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        long jMin = Long.MAX_VALUE;
        for (int i10 = 0; i10 < this.loadersWithTrackTypes.size(); i10++) {
            long nextLoadPositionUs = this.loadersWithTrackTypes.get(i10).getNextLoadPositionUs();
            if (nextLoadPositionUs != Long.MIN_VALUE) {
                jMin = Math.min(jMin, nextLoadPositionUs);
            }
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public boolean isLoading() {
        for (int i10 = 0; i10 < this.loadersWithTrackTypes.size(); i10++) {
            if (this.loadersWithTrackTypes.get(i10).isLoading()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public void reevaluateBuffer(long j10) {
        for (int i10 = 0; i10 < this.loadersWithTrackTypes.size(); i10++) {
            this.loadersWithTrackTypes.get(i10).reevaluateBuffer(j10);
        }
    }

    public CompositeSequenceableLoader(List<? extends SequenceableLoader> list, List<List<Integer>> list2) {
        y.a aVarK = com.google.common.collect.y.k();
        Assertions.checkArgument(list.size() == list2.size());
        for (int i10 = 0; i10 < list.size(); i10++) {
            aVarK.a(new SequenceableLoaderWithTrackTypes(list.get(i10), list2.get(i10)));
        }
        this.loadersWithTrackTypes = aVarK.k();
        this.lastAudioVideoBufferedPositionUs = C.TIME_UNSET;
    }
}
