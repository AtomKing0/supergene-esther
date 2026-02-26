package androidx.media3.exoplayer.source.preload;

import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.SampleStream;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.source.r;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.trackselection.TrackSelectorResult;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class PreloadMediaPeriod implements MediaPeriod {

    @Nullable
    private MediaPeriod.Callback callback;
    public final MediaPeriod mediaPeriod;

    @Nullable
    private PreloadTrackSelectionHolder preloadTrackSelectionHolder;
    private boolean prepareInternalCalled;
    private boolean prepared;

    private static class PreloadTrackSelectionHolder {
        public final boolean[] mayRetainStreamFlags;
        public final boolean[] streamResetFlags;
        public final SampleStream[] streams;
        public final long trackSelectionPositionUs;
        public final TrackSelectorResult trackSelectorResult;

        public PreloadTrackSelectionHolder(TrackSelectorResult trackSelectorResult, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j10) {
            this.trackSelectorResult = trackSelectorResult;
            this.mayRetainStreamFlags = zArr;
            this.streams = sampleStreamArr;
            this.streamResetFlags = zArr2;
            this.trackSelectionPositionUs = j10;
        }
    }

    public PreloadMediaPeriod(MediaPeriod mediaPeriod) {
        this.mediaPeriod = mediaPeriod;
    }

    private static boolean isSameAdaptionSet(ExoTrackSelection exoTrackSelection, ExoTrackSelection exoTrackSelection2) {
        if (!Objects.equals(exoTrackSelection.getTrackGroup(), exoTrackSelection2.getTrackGroup()) || exoTrackSelection.length() != exoTrackSelection2.length()) {
            return false;
        }
        for (int i10 = 0; i10 < exoTrackSelection.length(); i10++) {
            if (exoTrackSelection.getIndexInTrackGroup(i10) != exoTrackSelection2.getIndexInTrackGroup(i10)) {
                return false;
            }
        }
        return true;
    }

    private static boolean maybeUpdatePreloadTrackSelectionHolderForReselection(ExoTrackSelection[] exoTrackSelectionArr, PreloadTrackSelectionHolder preloadTrackSelectionHolder) {
        ExoTrackSelection[] exoTrackSelectionArr2 = ((PreloadTrackSelectionHolder) Assertions.checkNotNull(preloadTrackSelectionHolder)).trackSelectorResult.selections;
        int i10 = 0;
        boolean z10 = false;
        while (i10 < exoTrackSelectionArr.length) {
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i10];
            ExoTrackSelection exoTrackSelection2 = exoTrackSelectionArr2[i10];
            if (exoTrackSelection != null || exoTrackSelection2 != null) {
                preloadTrackSelectionHolder.mayRetainStreamFlags[i10] = false;
                if (exoTrackSelection == null) {
                    preloadTrackSelectionHolder.trackSelectorResult.selections[i10] = null;
                } else if (exoTrackSelection2 == null || !isSameAdaptionSet(exoTrackSelection, exoTrackSelection2)) {
                    preloadTrackSelectionHolder.trackSelectorResult.selections[i10] = exoTrackSelection;
                } else if (exoTrackSelection.getTrackGroup().type == 2 || exoTrackSelection.getTrackGroup().type == 1 || exoTrackSelection.getSelectedIndexInTrackGroup() == exoTrackSelection2.getSelectedIndexInTrackGroup()) {
                    preloadTrackSelectionHolder.mayRetainStreamFlags[i10] = true;
                } else {
                    preloadTrackSelectionHolder.trackSelectorResult.selections[i10] = exoTrackSelection;
                }
                z10 = true;
            }
            i10++;
        }
        return z10;
    }

    private void prepareInternal(long j10) {
        this.prepareInternalCalled = true;
        this.mediaPeriod.prepare(new MediaPeriod.Callback() { // from class: androidx.media3.exoplayer.source.preload.PreloadMediaPeriod.1
            @Override // androidx.media3.exoplayer.source.MediaPeriod.Callback
            public void onPrepared(MediaPeriod mediaPeriod) {
                PreloadMediaPeriod.this.prepared = true;
                ((MediaPeriod.Callback) Assertions.checkNotNull(PreloadMediaPeriod.this.callback)).onPrepared(PreloadMediaPeriod.this);
            }

            @Override // androidx.media3.exoplayer.source.SequenceableLoader.Callback
            public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
                ((MediaPeriod.Callback) Assertions.checkNotNull(PreloadMediaPeriod.this.callback)).onContinueLoadingRequested(PreloadMediaPeriod.this);
            }
        }, j10);
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
    public /* synthetic */ List getStreamKeys(List list) {
        return r.a(this, list);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public TrackGroupArray getTrackGroups() {
        return this.mediaPeriod.getTrackGroups();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public boolean isLoading() {
        return this.mediaPeriod.isLoading();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public void maybeThrowPrepareError() throws IOException {
        this.mediaPeriod.maybeThrowPrepareError();
    }

    void preload(MediaPeriod.Callback callback, long j10) {
        this.callback = callback;
        if (this.prepared) {
            callback.onPrepared(this);
        }
        if (this.prepareInternalCalled) {
            return;
        }
        prepareInternal(j10);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public void prepare(MediaPeriod.Callback callback, long j10) {
        this.callback = callback;
        if (this.prepared) {
            callback.onPrepared(this);
        } else {
            if (this.prepareInternalCalled) {
                return;
            }
            prepareInternal(j10);
        }
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
        PreloadTrackSelectionHolder preloadTrackSelectionHolder = this.preloadTrackSelectionHolder;
        if (preloadTrackSelectionHolder == null) {
            return this.mediaPeriod.selectTracks(exoTrackSelectionArr, zArr, sampleStreamArr, zArr2, j10);
        }
        Assertions.checkState(sampleStreamArr.length == preloadTrackSelectionHolder.streams.length);
        PreloadTrackSelectionHolder preloadTrackSelectionHolder2 = this.preloadTrackSelectionHolder;
        if (j10 == preloadTrackSelectionHolder2.trackSelectionPositionUs) {
            PreloadTrackSelectionHolder preloadTrackSelectionHolder3 = (PreloadTrackSelectionHolder) Assertions.checkNotNull(preloadTrackSelectionHolder2);
            long jSelectTracks = preloadTrackSelectionHolder3.trackSelectionPositionUs;
            boolean[] zArr3 = preloadTrackSelectionHolder3.streamResetFlags;
            if (maybeUpdatePreloadTrackSelectionHolderForReselection(exoTrackSelectionArr, preloadTrackSelectionHolder3)) {
                zArr3 = new boolean[zArr3.length];
                jSelectTracks = this.mediaPeriod.selectTracks(preloadTrackSelectionHolder3.trackSelectorResult.selections, preloadTrackSelectionHolder3.mayRetainStreamFlags, preloadTrackSelectionHolder3.streams, zArr3, preloadTrackSelectionHolder3.trackSelectionPositionUs);
                int i10 = 0;
                while (true) {
                    boolean[] zArr4 = preloadTrackSelectionHolder3.mayRetainStreamFlags;
                    if (i10 >= zArr4.length) {
                        break;
                    }
                    if (zArr4[i10]) {
                        zArr3[i10] = true;
                    }
                    i10++;
                }
            }
            SampleStream[] sampleStreamArr2 = preloadTrackSelectionHolder3.streams;
            System.arraycopy(sampleStreamArr2, 0, sampleStreamArr, 0, sampleStreamArr2.length);
            System.arraycopy(zArr3, 0, zArr2, 0, zArr3.length);
            this.preloadTrackSelectionHolder = null;
            return jSelectTracks;
        }
        int i11 = 0;
        while (true) {
            SampleStream[] sampleStreamArr3 = this.preloadTrackSelectionHolder.streams;
            if (i11 >= sampleStreamArr3.length) {
                this.preloadTrackSelectionHolder = null;
                return this.mediaPeriod.selectTracks(exoTrackSelectionArr, zArr, sampleStreamArr, zArr2, j10);
            }
            SampleStream sampleStream = sampleStreamArr3[i11];
            if (sampleStream != null) {
                sampleStreamArr[i11] = sampleStream;
                zArr[i11] = false;
            }
            i11++;
        }
    }

    long selectTracksForPreloading(TrackSelectorResult trackSelectorResult, long j10) {
        ExoTrackSelection[] exoTrackSelectionArr = trackSelectorResult.selections;
        SampleStream[] sampleStreamArr = new SampleStream[exoTrackSelectionArr.length];
        boolean[] zArr = new boolean[exoTrackSelectionArr.length];
        boolean[] zArr2 = new boolean[exoTrackSelectionArr.length];
        if (this.preloadTrackSelectionHolder != null) {
            for (int i10 = 0; i10 < trackSelectorResult.length; i10++) {
                zArr2[i10] = trackSelectorResult.isEquivalent(((PreloadTrackSelectionHolder) Assertions.checkNotNull(this.preloadTrackSelectionHolder)).trackSelectorResult, i10);
            }
        }
        long jSelectTracks = this.mediaPeriod.selectTracks(exoTrackSelectionArr, zArr2, sampleStreamArr, zArr, j10);
        this.preloadTrackSelectionHolder = new PreloadTrackSelectionHolder(trackSelectorResult, zArr2, sampleStreamArr, zArr, jSelectTracks);
        return jSelectTracks;
    }
}
