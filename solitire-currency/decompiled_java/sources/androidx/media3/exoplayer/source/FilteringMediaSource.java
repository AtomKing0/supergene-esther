package androidx.media3.exoplayer.source;

import androidx.annotation.Nullable;
import androidx.media3.common.StreamKey;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.Allocator;
import com.google.common.collect.y;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@UnstableApi
public class FilteringMediaSource extends WrappingMediaSource {
    private final com.google.common.collect.c0<Integer> trackTypes;

    private static final class FilteringMediaPeriod implements MediaPeriod, MediaPeriod.Callback {

        @Nullable
        private MediaPeriod.Callback callback;

        @Nullable
        private TrackGroupArray filteredTrackGroups;
        public final MediaPeriod mediaPeriod;
        private final com.google.common.collect.c0<Integer> trackTypes;

        public FilteringMediaPeriod(MediaPeriod mediaPeriod, com.google.common.collect.c0<Integer> c0Var) {
            this.mediaPeriod = mediaPeriod;
            this.trackTypes = c0Var;
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
        public boolean continueLoading(LoadingInfo loadingInfo) {
            return this.mediaPeriod.continueLoading(loadingInfo);
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public void discardBuffer(long j10, boolean z10) {
            this.mediaPeriod.discardBuffer(j10, z10);
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public long getAdjustedSeekPositionUs(long j10, SeekParameters seekParameters) {
            return this.mediaPeriod.getAdjustedSeekPositionUs(j10, seekParameters);
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
        public long getBufferedPositionUs() {
            return this.mediaPeriod.getBufferedPositionUs();
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
        public long getNextLoadPositionUs() {
            return this.mediaPeriod.getNextLoadPositionUs();
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public List<StreamKey> getStreamKeys(List<ExoTrackSelection> list) {
            return this.mediaPeriod.getStreamKeys(list);
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public TrackGroupArray getTrackGroups() {
            return (TrackGroupArray) Assertions.checkNotNull(this.filteredTrackGroups);
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
        public boolean isLoading() {
            return this.mediaPeriod.isLoading();
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public void maybeThrowPrepareError() throws IOException {
            this.mediaPeriod.maybeThrowPrepareError();
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod.Callback
        public void onPrepared(MediaPeriod mediaPeriod) {
            TrackGroupArray trackGroups = mediaPeriod.getTrackGroups();
            y.a aVarK = com.google.common.collect.y.k();
            for (int i10 = 0; i10 < trackGroups.length; i10++) {
                TrackGroup trackGroup = trackGroups.get(i10);
                if (this.trackTypes.contains(Integer.valueOf(trackGroup.type))) {
                    aVarK.a(trackGroup);
                }
            }
            this.filteredTrackGroups = new TrackGroupArray((TrackGroup[]) aVarK.k().toArray(new TrackGroup[0]));
            ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onPrepared(this);
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public void prepare(MediaPeriod.Callback callback, long j10) {
            this.callback = callback;
            this.mediaPeriod.prepare(this, j10);
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public long readDiscontinuity() {
            return this.mediaPeriod.readDiscontinuity();
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
        public void reevaluateBuffer(long j10) {
            this.mediaPeriod.reevaluateBuffer(j10);
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public long seekToUs(long j10) {
            return this.mediaPeriod.seekToUs(j10);
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public long selectTracks(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j10) {
            return this.mediaPeriod.selectTracks(exoTrackSelectionArr, zArr, sampleStreamArr, zArr2, j10);
        }

        @Override // androidx.media3.exoplayer.source.SequenceableLoader.Callback
        public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
            ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onContinueLoadingRequested(this);
        }
    }

    public FilteringMediaSource(MediaSource mediaSource, int i10) {
        this(mediaSource, com.google.common.collect.c0.r(Integer.valueOf(i10)));
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource, androidx.media3.exoplayer.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j10) {
        return new FilteringMediaPeriod(super.createPeriod(mediaPeriodId, allocator, j10), this.trackTypes);
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource, androidx.media3.exoplayer.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        super.releasePeriod(((FilteringMediaPeriod) mediaPeriod).mediaPeriod);
    }

    public FilteringMediaSource(MediaSource mediaSource, Set<Integer> set) {
        super(mediaSource);
        this.trackTypes = com.google.common.collect.c0.m(set);
    }
}
