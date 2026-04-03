package androidx.media3.exoplayer.source;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@UnstableApi
public abstract class BaseMediaSource implements MediaSource {

    @Nullable
    private Looper looper;

    @Nullable
    private PlayerId playerId;

    @Nullable
    private Timeline timeline;
    private final ArrayList<MediaSource.MediaSourceCaller> mediaSourceCallers = new ArrayList<>(1);
    private final HashSet<MediaSource.MediaSourceCaller> enabledMediaSourceCallers = new HashSet<>(1);
    private final MediaSourceEventListener.EventDispatcher eventDispatcher = new MediaSourceEventListener.EventDispatcher();
    private final DrmSessionEventListener.EventDispatcher drmEventDispatcher = new DrmSessionEventListener.EventDispatcher();

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void addDrmEventListener(Handler handler, DrmSessionEventListener drmSessionEventListener) {
        Assertions.checkNotNull(handler);
        Assertions.checkNotNull(drmSessionEventListener);
        this.drmEventDispatcher.addEventListener(handler, drmSessionEventListener);
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void addEventListener(Handler handler, MediaSourceEventListener mediaSourceEventListener) {
        Assertions.checkNotNull(handler);
        Assertions.checkNotNull(mediaSourceEventListener);
        this.eventDispatcher.addEventListener(handler, mediaSourceEventListener);
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public /* synthetic */ boolean canUpdateMediaItem(MediaItem mediaItem) {
        return s.a(this, mediaItem);
    }

    protected final DrmSessionEventListener.EventDispatcher createDrmEventDispatcher(@Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        return this.drmEventDispatcher.withParameters(0, mediaPeriodId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MediaSourceEventListener.EventDispatcher createEventDispatcher(@Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        return this.eventDispatcher.withParameters(0, mediaPeriodId);
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void disable(MediaSource.MediaSourceCaller mediaSourceCaller) {
        boolean z10 = !this.enabledMediaSourceCallers.isEmpty();
        this.enabledMediaSourceCallers.remove(mediaSourceCaller);
        if (z10 && this.enabledMediaSourceCallers.isEmpty()) {
            disableInternal();
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void enable(MediaSource.MediaSourceCaller mediaSourceCaller) {
        Assertions.checkNotNull(this.looper);
        boolean zIsEmpty = this.enabledMediaSourceCallers.isEmpty();
        this.enabledMediaSourceCallers.add(mediaSourceCaller);
        if (zIsEmpty) {
            enableInternal();
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public /* synthetic */ Timeline getInitialTimeline() {
        return s.b(this);
    }

    protected final PlayerId getPlayerId() {
        return (PlayerId) Assertions.checkStateNotNull(this.playerId);
    }

    protected final boolean isEnabled() {
        return !this.enabledMediaSourceCallers.isEmpty();
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public /* synthetic */ boolean isSingleWindow() {
        return s.c(this);
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void prepareSource(MediaSource.MediaSourceCaller mediaSourceCaller, @Nullable TransferListener transferListener) {
        prepareSource(mediaSourceCaller, transferListener, PlayerId.UNSET);
    }

    protected final boolean prepareSourceCalled() {
        return !this.mediaSourceCallers.isEmpty();
    }

    protected abstract void prepareSourceInternal(@Nullable TransferListener transferListener);

    protected final void refreshSourceInfo(Timeline timeline) {
        this.timeline = timeline;
        Iterator<MediaSource.MediaSourceCaller> it = this.mediaSourceCallers.iterator();
        while (it.hasNext()) {
            it.next().onSourceInfoRefreshed(this, timeline);
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void releaseSource(MediaSource.MediaSourceCaller mediaSourceCaller) {
        this.mediaSourceCallers.remove(mediaSourceCaller);
        if (!this.mediaSourceCallers.isEmpty()) {
            disable(mediaSourceCaller);
            return;
        }
        this.looper = null;
        this.timeline = null;
        this.playerId = null;
        this.enabledMediaSourceCallers.clear();
        releaseSourceInternal();
    }

    protected abstract void releaseSourceInternal();

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void removeDrmEventListener(DrmSessionEventListener drmSessionEventListener) {
        this.drmEventDispatcher.removeEventListener(drmSessionEventListener);
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void removeEventListener(MediaSourceEventListener mediaSourceEventListener) {
        this.eventDispatcher.removeEventListener(mediaSourceEventListener);
    }

    protected final void setPlayerId(PlayerId playerId) {
        this.playerId = playerId;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public /* synthetic */ void updateMediaItem(MediaItem mediaItem) {
        s.e(this, mediaItem);
    }

    protected final DrmSessionEventListener.EventDispatcher createDrmEventDispatcher(int i10, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        return this.drmEventDispatcher.withParameters(i10, mediaPeriodId);
    }

    protected final MediaSourceEventListener.EventDispatcher createEventDispatcher(int i10, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        return this.eventDispatcher.withParameters(i10, mediaPeriodId);
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void prepareSource(MediaSource.MediaSourceCaller mediaSourceCaller, @Nullable TransferListener transferListener, PlayerId playerId) {
        Looper looperMyLooper = Looper.myLooper();
        Looper looper = this.looper;
        Assertions.checkArgument(looper == null || looper == looperMyLooper);
        this.playerId = playerId;
        Timeline timeline = this.timeline;
        this.mediaSourceCallers.add(mediaSourceCaller);
        if (this.looper == null) {
            this.looper = looperMyLooper;
            this.enabledMediaSourceCallers.add(mediaSourceCaller);
            prepareSourceInternal(transferListener);
        } else if (timeline != null) {
            enable(mediaSourceCaller);
            mediaSourceCaller.onSourceInfoRefreshed(this, timeline);
        }
    }

    @Deprecated
    protected final MediaSourceEventListener.EventDispatcher createEventDispatcher(MediaSource.MediaPeriodId mediaPeriodId, long j10) {
        Assertions.checkNotNull(mediaPeriodId);
        return this.eventDispatcher.withParameters(0, mediaPeriodId);
    }

    @Deprecated
    protected final MediaSourceEventListener.EventDispatcher createEventDispatcher(int i10, @Nullable MediaSource.MediaPeriodId mediaPeriodId, long j10) {
        return this.eventDispatcher.withParameters(i10, mediaPeriodId);
    }

    protected void disableInternal() {
    }

    protected void enableInternal() {
    }
}
