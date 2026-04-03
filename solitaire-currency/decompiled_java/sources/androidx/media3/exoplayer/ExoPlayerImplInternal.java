package androidx.media3.exoplayer;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Metadata;
import androidx.media3.common.ParserException;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSourceException;
import androidx.media3.exoplayer.DefaultMediaClock;
import androidx.media3.exoplayer.MediaPeriodHolder;
import androidx.media3.exoplayer.MediaSourceList;
import androidx.media3.exoplayer.PlayerMessage;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.analytics.AnalyticsCollector;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.metadata.MetadataRenderer;
import androidx.media3.exoplayer.source.BehindLiveWindowException;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.SampleStream;
import androidx.media3.exoplayer.source.ShuffleOrder;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.text.TextRenderer;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.trackselection.TrackSelector;
import androidx.media3.exoplayer.trackselection.TrackSelectorResult;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import com.google.common.collect.y;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
final class ExoPlayerImplInternal implements Handler.Callback, MediaPeriod.Callback, TrackSelector.InvalidationListener, MediaSourceList.MediaSourceListInfoRefreshListener, DefaultMediaClock.PlaybackParametersListener, PlayerMessage.Sender {
    private static final int ACTIVE_INTERVAL_MS = 10;
    private static final int IDLE_INTERVAL_MS = 1000;
    private static final int MSG_ADD_MEDIA_SOURCES = 18;
    private static final int MSG_ATTEMPT_RENDERER_ERROR_RECOVERY = 25;
    private static final int MSG_DO_SOME_WORK = 2;
    private static final int MSG_MOVE_MEDIA_SOURCES = 19;
    private static final int MSG_PERIOD_PREPARED = 8;
    private static final int MSG_PLAYBACK_PARAMETERS_CHANGED_INTERNAL = 16;
    private static final int MSG_PLAYLIST_UPDATE_REQUESTED = 22;
    private static final int MSG_PREPARE = 0;
    private static final int MSG_RELEASE = 7;
    private static final int MSG_REMOVE_MEDIA_SOURCES = 20;
    private static final int MSG_RENDERER_CAPABILITIES_CHANGED = 26;
    private static final int MSG_SEEK_TO = 3;
    private static final int MSG_SEND_MESSAGE = 14;
    private static final int MSG_SEND_MESSAGE_TO_TARGET_THREAD = 15;
    private static final int MSG_SET_FOREGROUND_MODE = 13;
    private static final int MSG_SET_MEDIA_SOURCES = 17;
    private static final int MSG_SET_PAUSE_AT_END_OF_WINDOW = 23;
    private static final int MSG_SET_PLAYBACK_PARAMETERS = 4;
    private static final int MSG_SET_PLAY_WHEN_READY = 1;
    private static final int MSG_SET_REPEAT_MODE = 11;
    private static final int MSG_SET_SEEK_PARAMETERS = 5;
    private static final int MSG_SET_SHUFFLE_ENABLED = 12;
    private static final int MSG_SET_SHUFFLE_ORDER = 21;
    private static final int MSG_SOURCE_CONTINUE_LOADING_REQUESTED = 9;
    private static final int MSG_STOP = 6;
    private static final int MSG_TRACK_SELECTION_INVALIDATED = 10;
    private static final int MSG_UPDATE_MEDIA_SOURCES_WITH_MEDIA_ITEMS = 27;
    private static final long PLAYBACK_BUFFER_EMPTY_THRESHOLD_US = 500000;
    private static final long PLAYBACK_STUCK_AFTER_MS = 4000;
    private static final String TAG = "ExoPlayerImplInternal";
    private final long backBufferDurationUs;
    private final BandwidthMeter bandwidthMeter;
    private final Clock clock;
    private boolean deliverPendingMessageAtStartPositionRequired;
    private final TrackSelectorResult emptyTrackSelectorResult;
    private int enabledRendererCount;
    private boolean foregroundMode;
    private final HandlerWrapper handler;

    @Nullable
    private final HandlerThread internalPlaybackThread;
    private boolean isRebuffering;
    private final LivePlaybackSpeedControl livePlaybackSpeedControl;
    private final LoadControl loadControl;
    private final DefaultMediaClock mediaClock;
    private final MediaSourceList mediaSourceList;
    private int nextPendingMessageIndexHint;
    private boolean offloadSchedulingEnabled;
    private boolean pauseAtEndOfWindow;

    @Nullable
    private SeekPosition pendingInitialSeekPosition;
    private final ArrayList<PendingMessageInfo> pendingMessages;
    private boolean pendingPauseAtEndOfPeriod;

    @Nullable
    private ExoPlaybackException pendingRecoverableRendererError;
    private final Timeline.Period period;
    private PlaybackInfo playbackInfo;
    private PlaybackInfoUpdate playbackInfoUpdate;
    private final PlaybackInfoUpdateListener playbackInfoUpdateListener;
    private final Looper playbackLooper;
    private final MediaPeriodQueue queue;
    private final long releaseTimeoutMs;
    private boolean released;
    private final RendererCapabilities[] rendererCapabilities;
    private long rendererPositionUs;
    private final Renderer[] renderers;
    private final Set<Renderer> renderersToReset;
    private int repeatMode;
    private boolean requestForRendererSleep;
    private final boolean retainBackBufferFromKeyframe;
    private SeekParameters seekParameters;
    private long setForegroundModeTimeoutMs;
    private boolean shouldContinueLoading;
    private boolean shuffleModeEnabled;
    private final TrackSelector trackSelector;
    private final Timeline.Window window;
    private long playbackMaybeBecameStuckAtMs = C.TIME_UNSET;
    private long lastRebufferRealtimeMs = C.TIME_UNSET;

    private static final class MediaSourceListUpdateMessage {
        private final List<MediaSourceList.MediaSourceHolder> mediaSourceHolders;
        private final long positionUs;
        private final ShuffleOrder shuffleOrder;
        private final int windowIndex;

        private MediaSourceListUpdateMessage(List<MediaSourceList.MediaSourceHolder> list, ShuffleOrder shuffleOrder, int i10, long j10) {
            this.mediaSourceHolders = list;
            this.shuffleOrder = shuffleOrder;
            this.windowIndex = i10;
            this.positionUs = j10;
        }
    }

    private static class MoveMediaItemsMessage {
        public final int fromIndex;
        public final int newFromIndex;
        public final ShuffleOrder shuffleOrder;
        public final int toIndex;

        public MoveMediaItemsMessage(int i10, int i11, int i12, ShuffleOrder shuffleOrder) {
            this.fromIndex = i10;
            this.toIndex = i11;
            this.newFromIndex = i12;
            this.shuffleOrder = shuffleOrder;
        }
    }

    private static final class PendingMessageInfo implements Comparable<PendingMessageInfo> {
        public final PlayerMessage message;
        public int resolvedPeriodIndex;
        public long resolvedPeriodTimeUs;

        @Nullable
        public Object resolvedPeriodUid;

        public PendingMessageInfo(PlayerMessage playerMessage) {
            this.message = playerMessage;
        }

        public void setResolvedPosition(int i10, long j10, Object obj) {
            this.resolvedPeriodIndex = i10;
            this.resolvedPeriodTimeUs = j10;
            this.resolvedPeriodUid = obj;
        }

        @Override // java.lang.Comparable
        public int compareTo(PendingMessageInfo pendingMessageInfo) {
            Object obj = this.resolvedPeriodUid;
            if ((obj == null) != (pendingMessageInfo.resolvedPeriodUid == null)) {
                return obj != null ? -1 : 1;
            }
            if (obj == null) {
                return 0;
            }
            int i10 = this.resolvedPeriodIndex - pendingMessageInfo.resolvedPeriodIndex;
            return i10 != 0 ? i10 : Util.compareLong(this.resolvedPeriodTimeUs, pendingMessageInfo.resolvedPeriodTimeUs);
        }
    }

    public static final class PlaybackInfoUpdate {
        public int discontinuityReason;
        private boolean hasPendingChange;
        public boolean hasPlayWhenReadyChangeReason;
        public int operationAcks;
        public int playWhenReadyChangeReason;
        public PlaybackInfo playbackInfo;
        public boolean positionDiscontinuity;

        public PlaybackInfoUpdate(PlaybackInfo playbackInfo) {
            this.playbackInfo = playbackInfo;
        }

        public void incrementPendingOperationAcks(int i10) {
            this.hasPendingChange |= i10 > 0;
            this.operationAcks += i10;
        }

        public void setPlayWhenReadyChangeReason(int i10) {
            this.hasPendingChange = true;
            this.hasPlayWhenReadyChangeReason = true;
            this.playWhenReadyChangeReason = i10;
        }

        public void setPlaybackInfo(PlaybackInfo playbackInfo) {
            this.hasPendingChange |= this.playbackInfo != playbackInfo;
            this.playbackInfo = playbackInfo;
        }

        public void setPositionDiscontinuity(int i10) {
            if (this.positionDiscontinuity && this.discontinuityReason != 5) {
                Assertions.checkArgument(i10 == 5);
                return;
            }
            this.hasPendingChange = true;
            this.positionDiscontinuity = true;
            this.discontinuityReason = i10;
        }
    }

    public interface PlaybackInfoUpdateListener {
        void onPlaybackInfoUpdate(PlaybackInfoUpdate playbackInfoUpdate);
    }

    private static final class PositionUpdateForPlaylistChange {
        public final boolean endPlayback;
        public final boolean forceBufferingState;
        public final MediaSource.MediaPeriodId periodId;
        public final long periodPositionUs;
        public final long requestedContentPositionUs;
        public final boolean setTargetLiveOffset;

        public PositionUpdateForPlaylistChange(MediaSource.MediaPeriodId mediaPeriodId, long j10, long j11, boolean z10, boolean z11, boolean z12) {
            this.periodId = mediaPeriodId;
            this.periodPositionUs = j10;
            this.requestedContentPositionUs = j11;
            this.forceBufferingState = z10;
            this.endPlayback = z11;
            this.setTargetLiveOffset = z12;
        }
    }

    private static final class SeekPosition {
        public final Timeline timeline;
        public final int windowIndex;
        public final long windowPositionUs;

        public SeekPosition(Timeline timeline, int i10, long j10) {
            this.timeline = timeline;
            this.windowIndex = i10;
            this.windowPositionUs = j10;
        }
    }

    public ExoPlayerImplInternal(Renderer[] rendererArr, TrackSelector trackSelector, TrackSelectorResult trackSelectorResult, LoadControl loadControl, BandwidthMeter bandwidthMeter, int i10, boolean z10, AnalyticsCollector analyticsCollector, SeekParameters seekParameters, LivePlaybackSpeedControl livePlaybackSpeedControl, long j10, boolean z11, Looper looper, Clock clock, PlaybackInfoUpdateListener playbackInfoUpdateListener, PlayerId playerId, Looper looper2) {
        this.playbackInfoUpdateListener = playbackInfoUpdateListener;
        this.renderers = rendererArr;
        this.trackSelector = trackSelector;
        this.emptyTrackSelectorResult = trackSelectorResult;
        this.loadControl = loadControl;
        this.bandwidthMeter = bandwidthMeter;
        this.repeatMode = i10;
        this.shuffleModeEnabled = z10;
        this.seekParameters = seekParameters;
        this.livePlaybackSpeedControl = livePlaybackSpeedControl;
        this.releaseTimeoutMs = j10;
        this.setForegroundModeTimeoutMs = j10;
        this.pauseAtEndOfWindow = z11;
        this.clock = clock;
        this.backBufferDurationUs = loadControl.getBackBufferDurationUs();
        this.retainBackBufferFromKeyframe = loadControl.retainBackBufferFromKeyframe();
        PlaybackInfo playbackInfoCreateDummy = PlaybackInfo.createDummy(trackSelectorResult);
        this.playbackInfo = playbackInfoCreateDummy;
        this.playbackInfoUpdate = new PlaybackInfoUpdate(playbackInfoCreateDummy);
        this.rendererCapabilities = new RendererCapabilities[rendererArr.length];
        RendererCapabilities.Listener rendererCapabilitiesListener = trackSelector.getRendererCapabilitiesListener();
        for (int i11 = 0; i11 < rendererArr.length; i11++) {
            rendererArr[i11].init(i11, playerId, clock);
            this.rendererCapabilities[i11] = rendererArr[i11].getCapabilities();
            if (rendererCapabilitiesListener != null) {
                this.rendererCapabilities[i11].setListener(rendererCapabilitiesListener);
            }
        }
        this.mediaClock = new DefaultMediaClock(this, clock);
        this.pendingMessages = new ArrayList<>();
        this.renderersToReset = com.google.common.collect.c1.h();
        this.window = new Timeline.Window();
        this.period = new Timeline.Period();
        trackSelector.init(this, bandwidthMeter);
        this.deliverPendingMessageAtStartPositionRequired = true;
        HandlerWrapper handlerWrapperCreateHandler = clock.createHandler(looper, null);
        this.queue = new MediaPeriodQueue(analyticsCollector, handlerWrapperCreateHandler, new MediaPeriodHolder.Factory() { // from class: androidx.media3.exoplayer.p1
            @Override // androidx.media3.exoplayer.MediaPeriodHolder.Factory
            public final MediaPeriodHolder create(MediaPeriodInfo mediaPeriodInfo, long j11) {
                return this.f1460a.createMediaPeriodHolder(mediaPeriodInfo, j11);
            }
        });
        this.mediaSourceList = new MediaSourceList(this, analyticsCollector, handlerWrapperCreateHandler, playerId);
        if (looper2 != null) {
            this.internalPlaybackThread = null;
            this.playbackLooper = looper2;
        } else {
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
            this.internalPlaybackThread = handlerThread;
            handlerThread.start();
            this.playbackLooper = handlerThread.getLooper();
        }
        this.handler = clock.createHandler(this.playbackLooper, this);
    }

    private void addMediaItemsInternal(MediaSourceListUpdateMessage mediaSourceListUpdateMessage, int i10) throws Throwable {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        MediaSourceList mediaSourceList = this.mediaSourceList;
        if (i10 == -1) {
            i10 = mediaSourceList.getSize();
        }
        handleMediaSourceListInfoRefreshed(mediaSourceList.addMediaSources(i10, mediaSourceListUpdateMessage.mediaSourceHolders, mediaSourceListUpdateMessage.shuffleOrder), false);
    }

    private void allowRenderersToRenderStartOfStreams() {
        TrackSelectorResult trackSelectorResult = this.queue.getPlayingPeriod().getTrackSelectorResult();
        for (int i10 = 0; i10 < this.renderers.length; i10++) {
            if (trackSelectorResult.isRendererEnabled(i10)) {
                this.renderers[i10].enableMayRenderStartOfStream();
            }
        }
    }

    private void attemptRendererErrorRecovery() throws ExoPlaybackException {
        reselectTracksInternalAndSeek();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPeriodHolder createMediaPeriodHolder(MediaPeriodInfo mediaPeriodInfo, long j10) {
        return new MediaPeriodHolder(this.rendererCapabilities, j10, this.trackSelector, this.loadControl.getAllocator(), this.mediaSourceList, mediaPeriodInfo, this.emptyTrackSelectorResult);
    }

    private void deliverMessage(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.isCanceled()) {
            return;
        }
        try {
            playerMessage.getTarget().handleMessage(playerMessage.getType(), playerMessage.getPayload());
        } finally {
            playerMessage.markAsProcessed(true);
        }
    }

    private void disableRenderer(Renderer renderer) throws ExoPlaybackException {
        if (isRendererEnabled(renderer)) {
            this.mediaClock.onRendererDisabled(renderer);
            ensureStopped(renderer);
            renderer.disable();
            this.enabledRendererCount--;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0180  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void doSomeWork() throws androidx.media3.exoplayer.ExoPlaybackException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 507
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ExoPlayerImplInternal.doSomeWork():void");
    }

    private void enableRenderer(int i10, boolean z10, long j10) throws ExoPlaybackException {
        Renderer renderer = this.renderers[i10];
        if (isRendererEnabled(renderer)) {
            return;
        }
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        boolean z11 = readingPeriod == this.queue.getPlayingPeriod();
        TrackSelectorResult trackSelectorResult = readingPeriod.getTrackSelectorResult();
        RendererConfiguration rendererConfiguration = trackSelectorResult.rendererConfigurations[i10];
        Format[] formats = getFormats(trackSelectorResult.selections[i10]);
        boolean z12 = shouldPlayWhenReady() && this.playbackInfo.playbackState == 3;
        boolean z13 = !z10 && z12;
        this.enabledRendererCount++;
        this.renderersToReset.add(renderer);
        renderer.enable(rendererConfiguration, formats, readingPeriod.sampleStreams[i10], this.rendererPositionUs, z13, z11, j10, readingPeriod.getRendererOffset(), readingPeriod.info.id);
        renderer.handleMessage(11, new Renderer.WakeupListener() { // from class: androidx.media3.exoplayer.ExoPlayerImplInternal.1
            @Override // androidx.media3.exoplayer.Renderer.WakeupListener
            public void onSleep() {
                ExoPlayerImplInternal.this.requestForRendererSleep = true;
            }

            @Override // androidx.media3.exoplayer.Renderer.WakeupListener
            public void onWakeup() {
                ExoPlayerImplInternal.this.handler.sendEmptyMessage(2);
            }
        });
        this.mediaClock.onRendererEnabled(renderer);
        if (z12) {
            renderer.start();
        }
    }

    private void enableRenderers() throws ExoPlaybackException {
        enableRenderers(new boolean[this.renderers.length], this.queue.getReadingPeriod().getStartPositionRendererTime());
    }

    private void ensureStopped(Renderer renderer) {
        if (renderer.getState() == 2) {
            renderer.stop();
        }
    }

    private com.google.common.collect.y<Metadata> extractMetadataFromTrackSelectionArray(ExoTrackSelection[] exoTrackSelectionArr) {
        y.a aVar = new y.a();
        boolean z10 = false;
        for (ExoTrackSelection exoTrackSelection : exoTrackSelectionArr) {
            if (exoTrackSelection != null) {
                Metadata metadata = exoTrackSelection.getFormat(0).metadata;
                if (metadata == null) {
                    aVar.a(new Metadata(new Metadata.Entry[0]));
                } else {
                    aVar.a(metadata);
                    z10 = true;
                }
            }
        }
        return z10 ? aVar.k() : com.google.common.collect.y.q();
    }

    private long getCurrentLiveOffsetUs() {
        PlaybackInfo playbackInfo = this.playbackInfo;
        return getLiveOffsetUs(playbackInfo.timeline, playbackInfo.periodId.periodUid, playbackInfo.positionUs);
    }

    private static Format[] getFormats(ExoTrackSelection exoTrackSelection) {
        int length = exoTrackSelection != null ? exoTrackSelection.length() : 0;
        Format[] formatArr = new Format[length];
        for (int i10 = 0; i10 < length; i10++) {
            formatArr[i10] = exoTrackSelection.getFormat(i10);
        }
        return formatArr;
    }

    private long getLiveOffsetUs(Timeline timeline, Object obj, long j10) {
        timeline.getWindow(timeline.getPeriodByUid(obj, this.period).windowIndex, this.window);
        Timeline.Window window = this.window;
        if (window.windowStartTimeMs != C.TIME_UNSET && window.isLive()) {
            Timeline.Window window2 = this.window;
            if (window2.isDynamic) {
                return Util.msToUs(window2.getCurrentUnixTimeMs() - this.window.windowStartTimeMs) - (j10 + this.period.getPositionInWindowUs());
            }
        }
        return C.TIME_UNSET;
    }

    private long getMaxRendererReadPositionUs() {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        if (readingPeriod == null) {
            return 0L;
        }
        long rendererOffset = readingPeriod.getRendererOffset();
        if (!readingPeriod.prepared) {
            return rendererOffset;
        }
        int i10 = 0;
        while (true) {
            Renderer[] rendererArr = this.renderers;
            if (i10 >= rendererArr.length) {
                return rendererOffset;
            }
            if (isRendererEnabled(rendererArr[i10]) && this.renderers[i10].getStream() == readingPeriod.sampleStreams[i10]) {
                long readingPositionUs = this.renderers[i10].getReadingPositionUs();
                if (readingPositionUs == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                rendererOffset = Math.max(readingPositionUs, rendererOffset);
            }
            i10++;
        }
    }

    private Pair<MediaSource.MediaPeriodId, Long> getPlaceholderFirstMediaPeriodPositionUs(Timeline timeline) {
        if (timeline.isEmpty()) {
            return Pair.create(PlaybackInfo.getDummyPeriodForEmptyTimeline(), 0L);
        }
        Pair<Object, Long> periodPositionUs = timeline.getPeriodPositionUs(this.window, this.period, timeline.getFirstWindowIndex(this.shuffleModeEnabled), C.TIME_UNSET);
        MediaSource.MediaPeriodId mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange = this.queue.resolveMediaPeriodIdForAdsAfterPeriodPositionChange(timeline, periodPositionUs.first, 0L);
        long jLongValue = ((Long) periodPositionUs.second).longValue();
        if (mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.isAd()) {
            timeline.getPeriodByUid(mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.periodUid, this.period);
            jLongValue = mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.adIndexInAdGroup == this.period.getFirstAdIndexToPlay(mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.adGroupIndex) ? this.period.getAdResumePositionUs() : 0L;
        }
        return Pair.create(mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange, Long.valueOf(jLongValue));
    }

    private long getTotalBufferedDurationUs() {
        return getTotalBufferedDurationUs(this.playbackInfo.bufferedPositionUs);
    }

    private void handleContinueLoadingRequested(MediaPeriod mediaPeriod) {
        if (this.queue.isLoading(mediaPeriod)) {
            this.queue.reevaluateBuffer(this.rendererPositionUs);
            maybeContinueLoading();
        }
    }

    private void handleIoException(IOException iOException, int i10) {
        ExoPlaybackException exoPlaybackExceptionCreateForSource = ExoPlaybackException.createForSource(iOException, i10);
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        if (playingPeriod != null) {
            exoPlaybackExceptionCreateForSource = exoPlaybackExceptionCreateForSource.copyWithMediaPeriodId(playingPeriod.info.id);
        }
        Log.e(TAG, "Playback error", exoPlaybackExceptionCreateForSource);
        stopInternal(false, false);
        this.playbackInfo = this.playbackInfo.copyWithPlaybackError(exoPlaybackExceptionCreateForSource);
    }

    private void handleLoadingMediaPeriodChanged(boolean z10) {
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        MediaSource.MediaPeriodId mediaPeriodId = loadingPeriod == null ? this.playbackInfo.periodId : loadingPeriod.info.id;
        boolean z11 = !this.playbackInfo.loadingMediaPeriodId.equals(mediaPeriodId);
        if (z11) {
            this.playbackInfo = this.playbackInfo.copyWithLoadingMediaPeriodId(mediaPeriodId);
        }
        PlaybackInfo playbackInfo = this.playbackInfo;
        playbackInfo.bufferedPositionUs = loadingPeriod == null ? playbackInfo.positionUs : loadingPeriod.getBufferedPositionUs();
        this.playbackInfo.totalBufferedDurationUs = getTotalBufferedDurationUs();
        if ((z11 || z10) && loadingPeriod != null && loadingPeriod.prepared) {
            updateLoadControlTrackSelection(loadingPeriod.info.id, loadingPeriod.getTrackGroups(), loadingPeriod.getTrackSelectorResult());
        }
    }

    /* JADX WARN: Not initialized variable reg: 25, insn: 0x0152: MOVE (r5 I:??[long, double]) = (r25 I:??[long, double]) (LINE:339), block:B:77:0x0151 */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void handleMediaSourceListInfoRefreshed(androidx.media3.common.Timeline r28, boolean r29) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 478
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ExoPlayerImplInternal.handleMediaSourceListInfoRefreshed(androidx.media3.common.Timeline, boolean):void");
    }

    private void handlePeriodPrepared(MediaPeriod mediaPeriod) throws ExoPlaybackException {
        if (this.queue.isLoading(mediaPeriod)) {
            MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
            loadingPeriod.handlePrepared(this.mediaClock.getPlaybackParameters().speed, this.playbackInfo.timeline);
            updateLoadControlTrackSelection(loadingPeriod.info.id, loadingPeriod.getTrackGroups(), loadingPeriod.getTrackSelectorResult());
            if (loadingPeriod == this.queue.getPlayingPeriod()) {
                resetRendererPosition(loadingPeriod.info.startPositionUs);
                enableRenderers();
                PlaybackInfo playbackInfo = this.playbackInfo;
                MediaSource.MediaPeriodId mediaPeriodId = playbackInfo.periodId;
                long j10 = loadingPeriod.info.startPositionUs;
                this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, j10, playbackInfo.requestedContentPositionUs, j10, false, 5);
            }
            maybeContinueLoading();
        }
    }

    private void handlePlaybackParameters(PlaybackParameters playbackParameters, boolean z10) throws ExoPlaybackException {
        handlePlaybackParameters(playbackParameters, playbackParameters.speed, true, z10);
    }

    @CheckResult
    private PlaybackInfo handlePositionDiscontinuity(MediaSource.MediaPeriodId mediaPeriodId, long j10, long j11, long j12, boolean z10, int i10) {
        List<Metadata> listQ;
        TrackGroupArray trackGroupArray;
        TrackSelectorResult trackSelectorResult;
        this.deliverPendingMessageAtStartPositionRequired = (!this.deliverPendingMessageAtStartPositionRequired && j10 == this.playbackInfo.positionUs && mediaPeriodId.equals(this.playbackInfo.periodId)) ? false : true;
        resetPendingPauseAtEndOfPeriod();
        PlaybackInfo playbackInfo = this.playbackInfo;
        TrackGroupArray trackGroupArray2 = playbackInfo.trackGroups;
        TrackSelectorResult trackSelectorResult2 = playbackInfo.trackSelectorResult;
        List<Metadata> list = playbackInfo.staticMetadata;
        if (this.mediaSourceList.isPrepared()) {
            MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
            TrackGroupArray trackGroups = playingPeriod == null ? TrackGroupArray.EMPTY : playingPeriod.getTrackGroups();
            TrackSelectorResult trackSelectorResult3 = playingPeriod == null ? this.emptyTrackSelectorResult : playingPeriod.getTrackSelectorResult();
            com.google.common.collect.y<Metadata> yVarExtractMetadataFromTrackSelectionArray = extractMetadataFromTrackSelectionArray(trackSelectorResult3.selections);
            if (playingPeriod != null) {
                MediaPeriodInfo mediaPeriodInfo = playingPeriod.info;
                if (mediaPeriodInfo.requestedContentPositionUs != j11) {
                    playingPeriod.info = mediaPeriodInfo.copyWithRequestedContentPositionUs(j11);
                }
            }
            maybeUpdateOffloadScheduling();
            trackGroupArray = trackGroups;
            trackSelectorResult = trackSelectorResult3;
            listQ = yVarExtractMetadataFromTrackSelectionArray;
        } else if (mediaPeriodId.equals(this.playbackInfo.periodId)) {
            listQ = list;
            trackGroupArray = trackGroupArray2;
            trackSelectorResult = trackSelectorResult2;
        } else {
            trackGroupArray = TrackGroupArray.EMPTY;
            trackSelectorResult = this.emptyTrackSelectorResult;
            listQ = com.google.common.collect.y.q();
        }
        if (z10) {
            this.playbackInfoUpdate.setPositionDiscontinuity(i10);
        }
        return this.playbackInfo.copyWithNewPosition(mediaPeriodId, j10, j11, j12, getTotalBufferedDurationUs(), trackGroupArray, trackSelectorResult, listQ);
    }

    private boolean hasReachedServerSideInsertedAdsTransition(Renderer renderer, MediaPeriodHolder mediaPeriodHolder) {
        MediaPeriodHolder next = mediaPeriodHolder.getNext();
        return mediaPeriodHolder.info.isFollowedByTransitionToSameStream && next.prepared && ((renderer instanceof TextRenderer) || (renderer instanceof MetadataRenderer) || renderer.getReadingPositionUs() >= next.getStartPositionRendererTime());
    }

    private boolean hasReadingPeriodFinishedReading() {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        if (!readingPeriod.prepared) {
            return false;
        }
        int i10 = 0;
        while (true) {
            Renderer[] rendererArr = this.renderers;
            if (i10 >= rendererArr.length) {
                return true;
            }
            Renderer renderer = rendererArr[i10];
            SampleStream sampleStream = readingPeriod.sampleStreams[i10];
            if (renderer.getStream() != sampleStream || (sampleStream != null && !renderer.hasReadStreamToEnd() && !hasReachedServerSideInsertedAdsTransition(renderer, readingPeriod))) {
                break;
            }
            i10++;
        }
        return false;
    }

    private static boolean isIgnorableServerSideAdInsertionPeriodChange(boolean z10, MediaSource.MediaPeriodId mediaPeriodId, long j10, MediaSource.MediaPeriodId mediaPeriodId2, Timeline.Period period, long j11) {
        if (!z10 && j10 == j11 && mediaPeriodId.periodUid.equals(mediaPeriodId2.periodUid)) {
            return (mediaPeriodId.isAd() && period.isServerSideInsertedAdGroup(mediaPeriodId.adGroupIndex)) ? (period.getAdState(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup) == 4 || period.getAdState(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup) == 2) ? false : true : mediaPeriodId2.isAd() && period.isServerSideInsertedAdGroup(mediaPeriodId2.adGroupIndex);
        }
        return false;
    }

    private boolean isLoadingPossible() {
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        return (loadingPeriod == null || loadingPeriod.getNextLoadPositionUs() == Long.MIN_VALUE) ? false : true;
    }

    private static boolean isRendererEnabled(Renderer renderer) {
        return renderer.getState() != 0;
    }

    private boolean isTimelineReady() {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        long j10 = playingPeriod.info.durationUs;
        return playingPeriod.prepared && (j10 == C.TIME_UNSET || this.playbackInfo.positionUs < j10 || !shouldPlayWhenReady());
    }

    private static boolean isUsingPlaceholderPeriod(PlaybackInfo playbackInfo, Timeline.Period period) {
        MediaSource.MediaPeriodId mediaPeriodId = playbackInfo.periodId;
        Timeline timeline = playbackInfo.timeline;
        return timeline.isEmpty() || timeline.getPeriodByUid(mediaPeriodId.periodUid, period).isPlaceholder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$release$0() {
        return Boolean.valueOf(this.released);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendMessageToTargetThread$1(PlayerMessage playerMessage) {
        try {
            deliverMessage(playerMessage);
        } catch (ExoPlaybackException e10) {
            Log.e(TAG, "Unexpected error delivering message on external thread.", e10);
            throw new RuntimeException(e10);
        }
    }

    private void maybeContinueLoading() {
        boolean zShouldContinueLoading = shouldContinueLoading();
        this.shouldContinueLoading = zShouldContinueLoading;
        if (zShouldContinueLoading) {
            this.queue.getLoadingPeriod().continueLoading(this.rendererPositionUs, this.mediaClock.getPlaybackParameters().speed, this.lastRebufferRealtimeMs);
        }
        updateIsLoading();
    }

    private void maybeNotifyPlaybackInfoChanged() {
        this.playbackInfoUpdate.setPlaybackInfo(this.playbackInfo);
        if (this.playbackInfoUpdate.hasPendingChange) {
            this.playbackInfoUpdateListener.onPlaybackInfoUpdate(this.playbackInfoUpdate);
            this.playbackInfoUpdate = new PlaybackInfoUpdate(this.playbackInfo);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x0045, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0074, code lost:
    
        r3 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void maybeTriggerPendingMessages(long r8, long r10) throws androidx.media3.exoplayer.ExoPlaybackException {
        /*
            Method dump skipped, instruction units count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ExoPlayerImplInternal.maybeTriggerPendingMessages(long, long):void");
    }

    private void maybeUpdateLoadingPeriod() throws ExoPlaybackException {
        MediaPeriodInfo nextMediaPeriodInfo;
        this.queue.reevaluateBuffer(this.rendererPositionUs);
        if (this.queue.shouldLoadNextMediaPeriod() && (nextMediaPeriodInfo = this.queue.getNextMediaPeriodInfo(this.rendererPositionUs, this.playbackInfo)) != null) {
            MediaPeriodHolder mediaPeriodHolderEnqueueNextMediaPeriodHolder = this.queue.enqueueNextMediaPeriodHolder(nextMediaPeriodInfo);
            mediaPeriodHolderEnqueueNextMediaPeriodHolder.mediaPeriod.prepare(this, nextMediaPeriodInfo.startPositionUs);
            if (this.queue.getPlayingPeriod() == mediaPeriodHolderEnqueueNextMediaPeriodHolder) {
                resetRendererPosition(nextMediaPeriodInfo.startPositionUs);
            }
            handleLoadingMediaPeriodChanged(false);
        }
        if (!this.shouldContinueLoading) {
            maybeContinueLoading();
        } else {
            this.shouldContinueLoading = isLoadingPossible();
            updateIsLoading();
        }
    }

    private void maybeUpdateOffloadScheduling() {
        boolean z10;
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        if (playingPeriod != null) {
            TrackSelectorResult trackSelectorResult = playingPeriod.getTrackSelectorResult();
            boolean z11 = false;
            int i10 = 0;
            boolean z12 = false;
            while (true) {
                if (i10 >= this.renderers.length) {
                    z10 = true;
                    break;
                }
                if (trackSelectorResult.isRendererEnabled(i10)) {
                    if (this.renderers[i10].getTrackType() != 1) {
                        z10 = false;
                        break;
                    } else if (trackSelectorResult.rendererConfigurations[i10].offloadModePreferred != 0) {
                        z12 = true;
                    }
                }
                i10++;
            }
            if (z12 && z10) {
                z11 = true;
            }
            setOffloadSchedulingEnabled(z11);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void maybeUpdatePlayingPeriod() throws androidx.media3.exoplayer.ExoPlaybackException {
        /*
            r14 = this;
            r0 = 0
            r1 = r0
        L2:
            boolean r2 = r14.shouldAdvancePlayingPeriod()
            if (r2 == 0) goto L64
            if (r1 == 0) goto Ld
            r14.maybeNotifyPlaybackInfoChanged()
        Ld:
            androidx.media3.exoplayer.MediaPeriodQueue r1 = r14.queue
            androidx.media3.exoplayer.MediaPeriodHolder r1 = r1.advancePlayingPeriod()
            java.lang.Object r1 = androidx.media3.common.util.Assertions.checkNotNull(r1)
            androidx.media3.exoplayer.MediaPeriodHolder r1 = (androidx.media3.exoplayer.MediaPeriodHolder) r1
            androidx.media3.exoplayer.PlaybackInfo r2 = r14.playbackInfo
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r2 = r2.periodId
            java.lang.Object r2 = r2.periodUid
            androidx.media3.exoplayer.MediaPeriodInfo r3 = r1.info
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r3 = r3.id
            java.lang.Object r3 = r3.periodUid
            boolean r2 = r2.equals(r3)
            r3 = 1
            if (r2 == 0) goto L45
            androidx.media3.exoplayer.PlaybackInfo r2 = r14.playbackInfo
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r2 = r2.periodId
            int r4 = r2.adGroupIndex
            r5 = -1
            if (r4 != r5) goto L45
            androidx.media3.exoplayer.MediaPeriodInfo r4 = r1.info
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r4 = r4.id
            int r6 = r4.adGroupIndex
            if (r6 != r5) goto L45
            int r2 = r2.nextAdGroupIndex
            int r4 = r4.nextAdGroupIndex
            if (r2 == r4) goto L45
            r2 = r3
            goto L46
        L45:
            r2 = r0
        L46:
            androidx.media3.exoplayer.MediaPeriodInfo r1 = r1.info
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r5 = r1.id
            long r10 = r1.startPositionUs
            long r8 = r1.requestedContentPositionUs
            r12 = r2 ^ 1
            r13 = 0
            r4 = r14
            r6 = r10
            androidx.media3.exoplayer.PlaybackInfo r1 = r4.handlePositionDiscontinuity(r5, r6, r8, r10, r12, r13)
            r14.playbackInfo = r1
            r14.resetPendingPauseAtEndOfPeriod()
            r14.updatePlaybackPositions()
            r14.allowRenderersToRenderStartOfStreams()
            r1 = r3
            goto L2
        L64:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ExoPlayerImplInternal.maybeUpdatePlayingPeriod():void");
    }

    private void maybeUpdateReadingPeriod() throws ExoPlaybackException {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        if (readingPeriod == null) {
            return;
        }
        int i10 = 0;
        if (readingPeriod.getNext() != null && !this.pendingPauseAtEndOfPeriod) {
            if (hasReadingPeriodFinishedReading()) {
                if (readingPeriod.getNext().prepared || this.rendererPositionUs >= readingPeriod.getNext().getStartPositionRendererTime()) {
                    TrackSelectorResult trackSelectorResult = readingPeriod.getTrackSelectorResult();
                    MediaPeriodHolder mediaPeriodHolderAdvanceReadingPeriod = this.queue.advanceReadingPeriod();
                    TrackSelectorResult trackSelectorResult2 = mediaPeriodHolderAdvanceReadingPeriod.getTrackSelectorResult();
                    Timeline timeline = this.playbackInfo.timeline;
                    updatePlaybackSpeedSettingsForNewPeriod(timeline, mediaPeriodHolderAdvanceReadingPeriod.info.id, timeline, readingPeriod.info.id, C.TIME_UNSET, false);
                    if (mediaPeriodHolderAdvanceReadingPeriod.prepared && mediaPeriodHolderAdvanceReadingPeriod.mediaPeriod.readDiscontinuity() != C.TIME_UNSET) {
                        setAllRendererStreamsFinal(mediaPeriodHolderAdvanceReadingPeriod.getStartPositionRendererTime());
                        if (mediaPeriodHolderAdvanceReadingPeriod.isFullyBuffered()) {
                            return;
                        }
                        this.queue.removeAfter(mediaPeriodHolderAdvanceReadingPeriod);
                        handleLoadingMediaPeriodChanged(false);
                        maybeContinueLoading();
                        return;
                    }
                    for (int i11 = 0; i11 < this.renderers.length; i11++) {
                        boolean zIsRendererEnabled = trackSelectorResult.isRendererEnabled(i11);
                        boolean zIsRendererEnabled2 = trackSelectorResult2.isRendererEnabled(i11);
                        if (zIsRendererEnabled && !this.renderers[i11].isCurrentStreamFinal()) {
                            boolean z10 = this.rendererCapabilities[i11].getTrackType() == -2;
                            RendererConfiguration rendererConfiguration = trackSelectorResult.rendererConfigurations[i11];
                            RendererConfiguration rendererConfiguration2 = trackSelectorResult2.rendererConfigurations[i11];
                            if (!zIsRendererEnabled2 || !rendererConfiguration2.equals(rendererConfiguration) || z10) {
                                setCurrentStreamFinal(this.renderers[i11], mediaPeriodHolderAdvanceReadingPeriod.getStartPositionRendererTime());
                            }
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (!readingPeriod.info.isFinal && !this.pendingPauseAtEndOfPeriod) {
            return;
        }
        while (true) {
            Renderer[] rendererArr = this.renderers;
            if (i10 >= rendererArr.length) {
                return;
            }
            Renderer renderer = rendererArr[i10];
            SampleStream sampleStream = readingPeriod.sampleStreams[i10];
            if (sampleStream != null && renderer.getStream() == sampleStream && renderer.hasReadStreamToEnd()) {
                long j10 = readingPeriod.info.durationUs;
                setCurrentStreamFinal(renderer, (j10 == C.TIME_UNSET || j10 == Long.MIN_VALUE) ? -9223372036854775807L : readingPeriod.getRendererOffset() + readingPeriod.info.durationUs);
            }
            i10++;
        }
    }

    private void maybeUpdateReadingRenderers() throws ExoPlaybackException {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        if (readingPeriod == null || this.queue.getPlayingPeriod() == readingPeriod || readingPeriod.allRenderersInCorrectState || !replaceStreamsOrDisableRendererForTransition()) {
            return;
        }
        enableRenderers();
    }

    private void mediaSourceListUpdateRequestedInternal() throws Throwable {
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.createTimeline(), true);
    }

    private void moveMediaItemsInternal(MoveMediaItemsMessage moveMediaItemsMessage) throws Throwable {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.moveMediaSourceRange(moveMediaItemsMessage.fromIndex, moveMediaItemsMessage.toIndex, moveMediaItemsMessage.newFromIndex, moveMediaItemsMessage.shuffleOrder), false);
    }

    private void notifyTrackSelectionDiscontinuity() {
        for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null; playingPeriod = playingPeriod.getNext()) {
            for (ExoTrackSelection exoTrackSelection : playingPeriod.getTrackSelectorResult().selections) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.onDiscontinuity();
                }
            }
        }
    }

    private void notifyTrackSelectionPlayWhenReadyChanged(boolean z10) {
        for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null; playingPeriod = playingPeriod.getNext()) {
            for (ExoTrackSelection exoTrackSelection : playingPeriod.getTrackSelectorResult().selections) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.onPlayWhenReadyChanged(z10);
                }
            }
        }
    }

    private void notifyTrackSelectionRebuffer() {
        for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null; playingPeriod = playingPeriod.getNext()) {
            for (ExoTrackSelection exoTrackSelection : playingPeriod.getTrackSelectorResult().selections) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.onRebuffer();
                }
            }
        }
    }

    private void prepareInternal() {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        resetInternal(false, false, false, true);
        this.loadControl.onPrepared();
        setState(this.playbackInfo.timeline.isEmpty() ? 4 : 2);
        this.mediaSourceList.prepare(this.bandwidthMeter.getTransferListener());
        this.handler.sendEmptyMessage(2);
    }

    private void releaseInternal() {
        resetInternal(true, false, true, false);
        releaseRenderers();
        this.loadControl.onReleased();
        setState(1);
        HandlerThread handlerThread = this.internalPlaybackThread;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        synchronized (this) {
            this.released = true;
            notifyAll();
        }
    }

    private void releaseRenderers() {
        for (int i10 = 0; i10 < this.renderers.length; i10++) {
            this.rendererCapabilities[i10].clearListener();
            this.renderers[i10].release();
        }
    }

    private void removeMediaItemsInternal(int i10, int i11, ShuffleOrder shuffleOrder) throws Throwable {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.removeMediaSourceRange(i10, i11, shuffleOrder), false);
    }

    private boolean replaceStreamsOrDisableRendererForTransition() throws ExoPlaybackException {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        TrackSelectorResult trackSelectorResult = readingPeriod.getTrackSelectorResult();
        int i10 = 0;
        boolean z10 = false;
        while (true) {
            Renderer[] rendererArr = this.renderers;
            if (i10 >= rendererArr.length) {
                return !z10;
            }
            Renderer renderer = rendererArr[i10];
            if (isRendererEnabled(renderer)) {
                boolean z11 = renderer.getStream() != readingPeriod.sampleStreams[i10];
                if (!trackSelectorResult.isRendererEnabled(i10) || z11) {
                    if (!renderer.isCurrentStreamFinal()) {
                        renderer.replaceStream(getFormats(trackSelectorResult.selections[i10]), readingPeriod.sampleStreams[i10], readingPeriod.getStartPositionRendererTime(), readingPeriod.getRendererOffset(), readingPeriod.info.id);
                        if (this.offloadSchedulingEnabled) {
                            setOffloadSchedulingEnabled(false);
                        }
                    } else if (renderer.isEnded()) {
                        disableRenderer(renderer);
                    } else {
                        z10 = true;
                    }
                }
            }
            i10++;
        }
    }

    private void reselectTracksInternal() throws ExoPlaybackException {
        float f10 = this.mediaClock.getPlaybackParameters().speed;
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        boolean z10 = true;
        for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null && playingPeriod.prepared; playingPeriod = playingPeriod.getNext()) {
            TrackSelectorResult trackSelectorResultSelectTracks = playingPeriod.selectTracks(f10, this.playbackInfo.timeline);
            if (!trackSelectorResultSelectTracks.isEquivalent(playingPeriod.getTrackSelectorResult())) {
                if (z10) {
                    MediaPeriodHolder playingPeriod2 = this.queue.getPlayingPeriod();
                    boolean zRemoveAfter = this.queue.removeAfter(playingPeriod2);
                    boolean[] zArr = new boolean[this.renderers.length];
                    long jApplyTrackSelection = playingPeriod2.applyTrackSelection(trackSelectorResultSelectTracks, this.playbackInfo.positionUs, zRemoveAfter, zArr);
                    PlaybackInfo playbackInfo = this.playbackInfo;
                    boolean z11 = (playbackInfo.playbackState == 4 || jApplyTrackSelection == playbackInfo.positionUs) ? false : true;
                    PlaybackInfo playbackInfo2 = this.playbackInfo;
                    this.playbackInfo = handlePositionDiscontinuity(playbackInfo2.periodId, jApplyTrackSelection, playbackInfo2.requestedContentPositionUs, playbackInfo2.discontinuityStartPositionUs, z11, 5);
                    if (z11) {
                        resetRendererPosition(jApplyTrackSelection);
                    }
                    boolean[] zArr2 = new boolean[this.renderers.length];
                    int i10 = 0;
                    while (true) {
                        Renderer[] rendererArr = this.renderers;
                        if (i10 >= rendererArr.length) {
                            break;
                        }
                        Renderer renderer = rendererArr[i10];
                        boolean zIsRendererEnabled = isRendererEnabled(renderer);
                        zArr2[i10] = zIsRendererEnabled;
                        SampleStream sampleStream = playingPeriod2.sampleStreams[i10];
                        if (zIsRendererEnabled) {
                            if (sampleStream != renderer.getStream()) {
                                disableRenderer(renderer);
                            } else if (zArr[i10]) {
                                renderer.resetPosition(this.rendererPositionUs);
                            }
                        }
                        i10++;
                    }
                    enableRenderers(zArr2, this.rendererPositionUs);
                } else {
                    this.queue.removeAfter(playingPeriod);
                    if (playingPeriod.prepared) {
                        playingPeriod.applyTrackSelection(trackSelectorResultSelectTracks, Math.max(playingPeriod.info.startPositionUs, playingPeriod.toPeriodTime(this.rendererPositionUs)), false);
                    }
                }
                handleLoadingMediaPeriodChanged(true);
                if (this.playbackInfo.playbackState != 4) {
                    maybeContinueLoading();
                    updatePlaybackPositions();
                    this.handler.sendEmptyMessage(2);
                    return;
                }
                return;
            }
            if (playingPeriod == readingPeriod) {
                z10 = false;
            }
        }
    }

    private void reselectTracksInternalAndSeek() throws ExoPlaybackException {
        reselectTracksInternal();
        seekToCurrentPosition(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00a3 A[PHI: r5 r6 r8
      0x00a3: PHI (r5v3 androidx.media3.exoplayer.source.MediaSource$MediaPeriodId) = 
      (r5v2 androidx.media3.exoplayer.source.MediaSource$MediaPeriodId)
      (r5v6 androidx.media3.exoplayer.source.MediaSource$MediaPeriodId)
     binds: [B:30:0x007b, B:32:0x00a0] A[DONT_GENERATE, DONT_INLINE]
      0x00a3: PHI (r6v2 long) = (r6v1 long), (r6v9 long) binds: [B:30:0x007b, B:32:0x00a0] A[DONT_GENERATE, DONT_INLINE]
      0x00a3: PHI (r8v3 long) = (r8v2 long), (r8v6 long) binds: [B:30:0x007b, B:32:0x00a0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ed A[PHI: r0
      0x00ed: PHI (r0v10 androidx.media3.common.Timeline) = 
      (r0v9 androidx.media3.common.Timeline)
      (r0v9 androidx.media3.common.Timeline)
      (r0v14 androidx.media3.common.Timeline)
      (r0v14 androidx.media3.common.Timeline)
     binds: [B:36:0x00b2, B:38:0x00b6, B:40:0x00c7, B:42:0x00de] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void resetInternal(boolean r33, boolean r34, boolean r35, boolean r36) {
        /*
            Method dump skipped, instruction units count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ExoPlayerImplInternal.resetInternal(boolean, boolean, boolean, boolean):void");
    }

    private void resetPendingPauseAtEndOfPeriod() {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        this.pendingPauseAtEndOfPeriod = playingPeriod != null && playingPeriod.info.isLastInTimelineWindow && this.pauseAtEndOfWindow;
    }

    private void resetRendererPosition(long j10) throws ExoPlaybackException {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        long rendererTime = playingPeriod == null ? j10 + MediaPeriodQueue.INITIAL_RENDERER_POSITION_OFFSET_US : playingPeriod.toRendererTime(j10);
        this.rendererPositionUs = rendererTime;
        this.mediaClock.resetPosition(rendererTime);
        for (Renderer renderer : this.renderers) {
            if (isRendererEnabled(renderer)) {
                renderer.resetPosition(this.rendererPositionUs);
            }
        }
        notifyTrackSelectionDiscontinuity();
    }

    private static void resolvePendingMessageEndOfStreamPosition(Timeline timeline, PendingMessageInfo pendingMessageInfo, Timeline.Window window, Timeline.Period period) {
        int i10 = timeline.getWindow(timeline.getPeriodByUid(pendingMessageInfo.resolvedPeriodUid, period).windowIndex, window).lastPeriodIndex;
        Object obj = timeline.getPeriod(i10, period, true).uid;
        long j10 = period.durationUs;
        pendingMessageInfo.setResolvedPosition(i10, j10 != C.TIME_UNSET ? j10 - 1 : Long.MAX_VALUE, obj);
    }

    private static boolean resolvePendingMessagePosition(PendingMessageInfo pendingMessageInfo, Timeline timeline, Timeline timeline2, int i10, boolean z10, Timeline.Window window, Timeline.Period period) {
        Object obj = pendingMessageInfo.resolvedPeriodUid;
        if (obj == null) {
            Pair<Object, Long> pairResolveSeekPositionUs = resolveSeekPositionUs(timeline, new SeekPosition(pendingMessageInfo.message.getTimeline(), pendingMessageInfo.message.getMediaItemIndex(), pendingMessageInfo.message.getPositionMs() == Long.MIN_VALUE ? C.TIME_UNSET : Util.msToUs(pendingMessageInfo.message.getPositionMs())), false, i10, z10, window, period);
            if (pairResolveSeekPositionUs == null) {
                return false;
            }
            pendingMessageInfo.setResolvedPosition(timeline.getIndexOfPeriod(pairResolveSeekPositionUs.first), ((Long) pairResolveSeekPositionUs.second).longValue(), pairResolveSeekPositionUs.first);
            if (pendingMessageInfo.message.getPositionMs() == Long.MIN_VALUE) {
                resolvePendingMessageEndOfStreamPosition(timeline, pendingMessageInfo, window, period);
            }
            return true;
        }
        int indexOfPeriod = timeline.getIndexOfPeriod(obj);
        if (indexOfPeriod == -1) {
            return false;
        }
        if (pendingMessageInfo.message.getPositionMs() == Long.MIN_VALUE) {
            resolvePendingMessageEndOfStreamPosition(timeline, pendingMessageInfo, window, period);
            return true;
        }
        pendingMessageInfo.resolvedPeriodIndex = indexOfPeriod;
        timeline2.getPeriodByUid(pendingMessageInfo.resolvedPeriodUid, period);
        if (period.isPlaceholder && timeline2.getWindow(period.windowIndex, window).firstPeriodIndex == timeline2.getIndexOfPeriod(pendingMessageInfo.resolvedPeriodUid)) {
            Pair<Object, Long> periodPositionUs = timeline.getPeriodPositionUs(window, period, timeline.getPeriodByUid(pendingMessageInfo.resolvedPeriodUid, period).windowIndex, pendingMessageInfo.resolvedPeriodTimeUs + period.getPositionInWindowUs());
            pendingMessageInfo.setResolvedPosition(timeline.getIndexOfPeriod(periodPositionUs.first), ((Long) periodPositionUs.second).longValue(), periodPositionUs.first);
        }
        return true;
    }

    private void resolvePendingMessagePositions(Timeline timeline, Timeline timeline2) {
        if (timeline.isEmpty() && timeline2.isEmpty()) {
            return;
        }
        for (int size = this.pendingMessages.size() - 1; size >= 0; size--) {
            if (!resolvePendingMessagePosition(this.pendingMessages.get(size), timeline, timeline2, this.repeatMode, this.shuffleModeEnabled, this.window, this.period)) {
                this.pendingMessages.get(size).message.markAsProcessed(false);
                this.pendingMessages.remove(size);
            }
        }
        Collections.sort(this.pendingMessages);
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static androidx.media3.exoplayer.ExoPlayerImplInternal.PositionUpdateForPlaylistChange resolvePositionForPlaylistChange(androidx.media3.common.Timeline r30, androidx.media3.exoplayer.PlaybackInfo r31, @androidx.annotation.Nullable androidx.media3.exoplayer.ExoPlayerImplInternal.SeekPosition r32, androidx.media3.exoplayer.MediaPeriodQueue r33, int r34, boolean r35, androidx.media3.common.Timeline.Window r36, androidx.media3.common.Timeline.Period r37) {
        /*
            Method dump skipped, instruction units count: 492
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ExoPlayerImplInternal.resolvePositionForPlaylistChange(androidx.media3.common.Timeline, androidx.media3.exoplayer.PlaybackInfo, androidx.media3.exoplayer.ExoPlayerImplInternal$SeekPosition, androidx.media3.exoplayer.MediaPeriodQueue, int, boolean, androidx.media3.common.Timeline$Window, androidx.media3.common.Timeline$Period):androidx.media3.exoplayer.ExoPlayerImplInternal$PositionUpdateForPlaylistChange");
    }

    @Nullable
    private static Pair<Object, Long> resolveSeekPositionUs(Timeline timeline, SeekPosition seekPosition, boolean z10, int i10, boolean z11, Timeline.Window window, Timeline.Period period) {
        Pair<Object, Long> periodPositionUs;
        Object objResolveSubsequentPeriod;
        Timeline timeline2 = seekPosition.timeline;
        if (timeline.isEmpty()) {
            return null;
        }
        Timeline timeline3 = timeline2.isEmpty() ? timeline : timeline2;
        try {
            periodPositionUs = timeline3.getPeriodPositionUs(window, period, seekPosition.windowIndex, seekPosition.windowPositionUs);
        } catch (IndexOutOfBoundsException unused) {
        }
        if (timeline.equals(timeline3)) {
            return periodPositionUs;
        }
        if (timeline.getIndexOfPeriod(periodPositionUs.first) != -1) {
            return (timeline3.getPeriodByUid(periodPositionUs.first, period).isPlaceholder && timeline3.getWindow(period.windowIndex, window).firstPeriodIndex == timeline3.getIndexOfPeriod(periodPositionUs.first)) ? timeline.getPeriodPositionUs(window, period, timeline.getPeriodByUid(periodPositionUs.first, period).windowIndex, seekPosition.windowPositionUs) : periodPositionUs;
        }
        if (z10 && (objResolveSubsequentPeriod = resolveSubsequentPeriod(window, period, i10, z11, periodPositionUs.first, timeline3, timeline)) != null) {
            return timeline.getPeriodPositionUs(window, period, timeline.getPeriodByUid(objResolveSubsequentPeriod, period).windowIndex, C.TIME_UNSET);
        }
        return null;
    }

    @Nullable
    static Object resolveSubsequentPeriod(Timeline.Window window, Timeline.Period period, int i10, boolean z10, Object obj, Timeline timeline, Timeline timeline2) {
        int indexOfPeriod = timeline.getIndexOfPeriod(obj);
        int periodCount = timeline.getPeriodCount();
        int nextPeriodIndex = indexOfPeriod;
        int indexOfPeriod2 = -1;
        for (int i11 = 0; i11 < periodCount && indexOfPeriod2 == -1; i11++) {
            nextPeriodIndex = timeline.getNextPeriodIndex(nextPeriodIndex, period, window, i10, z10);
            if (nextPeriodIndex == -1) {
                break;
            }
            indexOfPeriod2 = timeline2.getIndexOfPeriod(timeline.getUidOfPeriod(nextPeriodIndex));
        }
        if (indexOfPeriod2 == -1) {
            return null;
        }
        return timeline2.getUidOfPeriod(indexOfPeriod2);
    }

    private void scheduleNextWork(long j10, long j11) {
        this.handler.sendEmptyMessageAtTime(2, j10 + j11);
    }

    private void seekToCurrentPosition(boolean z10) throws ExoPlaybackException {
        MediaSource.MediaPeriodId mediaPeriodId = this.queue.getPlayingPeriod().info.id;
        long jSeekToPeriodPosition = seekToPeriodPosition(mediaPeriodId, this.playbackInfo.positionUs, true, false);
        if (jSeekToPeriodPosition != this.playbackInfo.positionUs) {
            PlaybackInfo playbackInfo = this.playbackInfo;
            this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, jSeekToPeriodPosition, playbackInfo.requestedContentPositionUs, playbackInfo.discontinuityStartPositionUs, z10, 5);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00ac A[Catch: all -> 0x0147, TryCatch #1 {all -> 0x0147, blocks: (B:22:0x00a2, B:24:0x00ac, B:27:0x00b2, B:29:0x00b8, B:30:0x00bb, B:32:0x00c1, B:34:0x00cb, B:36:0x00d3, B:40:0x00db, B:42:0x00e5, B:44:0x00f5, B:48:0x00ff, B:52:0x0111, B:56:0x011a), top: B:74:0x00a2 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void seekToInternal(androidx.media3.exoplayer.ExoPlayerImplInternal.SeekPosition r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ExoPlayerImplInternal.seekToInternal(androidx.media3.exoplayer.ExoPlayerImplInternal$SeekPosition):void");
    }

    private long seekToPeriodPosition(MediaSource.MediaPeriodId mediaPeriodId, long j10, boolean z10) throws ExoPlaybackException {
        return seekToPeriodPosition(mediaPeriodId, j10, this.queue.getPlayingPeriod() != this.queue.getReadingPeriod(), z10);
    }

    private void sendMessageInternal(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.getPositionMs() == C.TIME_UNSET) {
            sendMessageToTarget(playerMessage);
            return;
        }
        if (this.playbackInfo.timeline.isEmpty()) {
            this.pendingMessages.add(new PendingMessageInfo(playerMessage));
            return;
        }
        PendingMessageInfo pendingMessageInfo = new PendingMessageInfo(playerMessage);
        Timeline timeline = this.playbackInfo.timeline;
        if (!resolvePendingMessagePosition(pendingMessageInfo, timeline, timeline, this.repeatMode, this.shuffleModeEnabled, this.window, this.period)) {
            playerMessage.markAsProcessed(false);
        } else {
            this.pendingMessages.add(pendingMessageInfo);
            Collections.sort(this.pendingMessages);
        }
    }

    private void sendMessageToTarget(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.getLooper() != this.playbackLooper) {
            this.handler.obtainMessage(15, playerMessage).sendToTarget();
            return;
        }
        deliverMessage(playerMessage);
        int i10 = this.playbackInfo.playbackState;
        if (i10 == 3 || i10 == 2) {
            this.handler.sendEmptyMessage(2);
        }
    }

    private void sendMessageToTargetThread(final PlayerMessage playerMessage) {
        Looper looper = playerMessage.getLooper();
        if (looper.getThread().isAlive()) {
            this.clock.createHandler(looper, null).post(new Runnable() { // from class: androidx.media3.exoplayer.s1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1468a.lambda$sendMessageToTargetThread$1(playerMessage);
                }
            });
        } else {
            Log.w("TAG", "Trying to send message on a dead thread.");
            playerMessage.markAsProcessed(false);
        }
    }

    private void setAllRendererStreamsFinal(long j10) {
        for (Renderer renderer : this.renderers) {
            if (renderer.getStream() != null) {
                setCurrentStreamFinal(renderer, j10);
            }
        }
    }

    private void setCurrentStreamFinal(Renderer renderer, long j10) {
        renderer.setCurrentStreamFinal();
        if (renderer instanceof TextRenderer) {
            ((TextRenderer) renderer).setFinalStreamEndPositionUs(j10);
        }
    }

    private void setForegroundModeInternal(boolean z10, @Nullable AtomicBoolean atomicBoolean) {
        if (this.foregroundMode != z10) {
            this.foregroundMode = z10;
            if (!z10) {
                for (Renderer renderer : this.renderers) {
                    if (!isRendererEnabled(renderer) && this.renderersToReset.remove(renderer)) {
                        renderer.reset();
                    }
                }
            }
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    private void setMediaClockPlaybackParameters(PlaybackParameters playbackParameters) {
        this.handler.removeMessages(16);
        this.mediaClock.setPlaybackParameters(playbackParameters);
    }

    private void setMediaItemsInternal(MediaSourceListUpdateMessage mediaSourceListUpdateMessage) throws Throwable {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        if (mediaSourceListUpdateMessage.windowIndex != -1) {
            this.pendingInitialSeekPosition = new SeekPosition(new PlaylistTimeline(mediaSourceListUpdateMessage.mediaSourceHolders, mediaSourceListUpdateMessage.shuffleOrder), mediaSourceListUpdateMessage.windowIndex, mediaSourceListUpdateMessage.positionUs);
        }
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.setMediaSources(mediaSourceListUpdateMessage.mediaSourceHolders, mediaSourceListUpdateMessage.shuffleOrder), false);
    }

    private void setOffloadSchedulingEnabled(boolean z10) {
        if (z10 == this.offloadSchedulingEnabled) {
            return;
        }
        this.offloadSchedulingEnabled = z10;
        if (z10 || !this.playbackInfo.sleepingForOffload) {
            return;
        }
        this.handler.sendEmptyMessage(2);
    }

    private void setPauseAtEndOfWindowInternal(boolean z10) throws ExoPlaybackException {
        this.pauseAtEndOfWindow = z10;
        resetPendingPauseAtEndOfPeriod();
        if (!this.pendingPauseAtEndOfPeriod || this.queue.getReadingPeriod() == this.queue.getPlayingPeriod()) {
            return;
        }
        seekToCurrentPosition(true);
        handleLoadingMediaPeriodChanged(false);
    }

    private void setPlayWhenReadyInternal(boolean z10, int i10, boolean z11, int i11) throws ExoPlaybackException {
        this.playbackInfoUpdate.incrementPendingOperationAcks(z11 ? 1 : 0);
        this.playbackInfoUpdate.setPlayWhenReadyChangeReason(i11);
        this.playbackInfo = this.playbackInfo.copyWithPlayWhenReady(z10, i10);
        updateRebufferingState(false, false);
        notifyTrackSelectionPlayWhenReadyChanged(z10);
        if (!shouldPlayWhenReady()) {
            stopRenderers();
            updatePlaybackPositions();
            return;
        }
        int i12 = this.playbackInfo.playbackState;
        if (i12 == 3) {
            startRenderers();
            this.handler.sendEmptyMessage(2);
        } else if (i12 == 2) {
            this.handler.sendEmptyMessage(2);
        }
    }

    private void setPlaybackParametersInternal(PlaybackParameters playbackParameters) throws ExoPlaybackException {
        setMediaClockPlaybackParameters(playbackParameters);
        handlePlaybackParameters(this.mediaClock.getPlaybackParameters(), true);
    }

    private void setRepeatModeInternal(int i10) throws ExoPlaybackException {
        this.repeatMode = i10;
        if (!this.queue.updateRepeatMode(this.playbackInfo.timeline, i10)) {
            seekToCurrentPosition(true);
        }
        handleLoadingMediaPeriodChanged(false);
    }

    private void setSeekParametersInternal(SeekParameters seekParameters) {
        this.seekParameters = seekParameters;
    }

    private void setShuffleModeEnabledInternal(boolean z10) throws ExoPlaybackException {
        this.shuffleModeEnabled = z10;
        if (!this.queue.updateShuffleModeEnabled(this.playbackInfo.timeline, z10)) {
            seekToCurrentPosition(true);
        }
        handleLoadingMediaPeriodChanged(false);
    }

    private void setShuffleOrderInternal(ShuffleOrder shuffleOrder) throws Throwable {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.setShuffleOrder(shuffleOrder), false);
    }

    private void setState(int i10) {
        PlaybackInfo playbackInfo = this.playbackInfo;
        if (playbackInfo.playbackState != i10) {
            if (i10 != 2) {
                this.playbackMaybeBecameStuckAtMs = C.TIME_UNSET;
            }
            this.playbackInfo = playbackInfo.copyWithPlaybackState(i10);
        }
    }

    private boolean shouldAdvancePlayingPeriod() {
        MediaPeriodHolder playingPeriod;
        MediaPeriodHolder next;
        return shouldPlayWhenReady() && !this.pendingPauseAtEndOfPeriod && (playingPeriod = this.queue.getPlayingPeriod()) != null && (next = playingPeriod.getNext()) != null && this.rendererPositionUs >= next.getStartPositionRendererTime() && next.allRenderersInCorrectState;
    }

    private boolean shouldContinueLoading() {
        if (!isLoadingPossible()) {
            return false;
        }
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        long totalBufferedDurationUs = getTotalBufferedDurationUs(loadingPeriod.getNextLoadPositionUs());
        long periodTime = loadingPeriod == this.queue.getPlayingPeriod() ? loadingPeriod.toPeriodTime(this.rendererPositionUs) : loadingPeriod.toPeriodTime(this.rendererPositionUs) - loadingPeriod.info.startPositionUs;
        boolean zShouldContinueLoading = this.loadControl.shouldContinueLoading(periodTime, totalBufferedDurationUs, this.mediaClock.getPlaybackParameters().speed);
        if (zShouldContinueLoading || totalBufferedDurationUs >= PLAYBACK_BUFFER_EMPTY_THRESHOLD_US) {
            return zShouldContinueLoading;
        }
        if (this.backBufferDurationUs <= 0 && !this.retainBackBufferFromKeyframe) {
            return zShouldContinueLoading;
        }
        this.queue.getPlayingPeriod().mediaPeriod.discardBuffer(this.playbackInfo.positionUs, false);
        return this.loadControl.shouldContinueLoading(periodTime, totalBufferedDurationUs, this.mediaClock.getPlaybackParameters().speed);
    }

    private boolean shouldPlayWhenReady() {
        PlaybackInfo playbackInfo = this.playbackInfo;
        return playbackInfo.playWhenReady && playbackInfo.playbackSuppressionReason == 0;
    }

    private boolean shouldTransitionToReadyState(boolean z10) {
        if (this.enabledRendererCount == 0) {
            return isTimelineReady();
        }
        if (!z10) {
            return false;
        }
        if (!this.playbackInfo.isLoading) {
            return true;
        }
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        long targetLiveOffsetUs = shouldUseLivePlaybackSpeedControl(this.playbackInfo.timeline, playingPeriod.info.id) ? this.livePlaybackSpeedControl.getTargetLiveOffsetUs() : C.TIME_UNSET;
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        return (loadingPeriod.isFullyBuffered() && loadingPeriod.info.isFinal) || (loadingPeriod.info.id.isAd() && !loadingPeriod.prepared) || this.loadControl.shouldStartPlayback(this.playbackInfo.timeline, playingPeriod.info.id, getTotalBufferedDurationUs(), this.mediaClock.getPlaybackParameters().speed, this.isRebuffering, targetLiveOffsetUs);
    }

    private boolean shouldUseLivePlaybackSpeedControl(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId) {
        if (mediaPeriodId.isAd() || timeline.isEmpty()) {
            return false;
        }
        timeline.getWindow(timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period).windowIndex, this.window);
        if (!this.window.isLive()) {
            return false;
        }
        Timeline.Window window = this.window;
        return window.isDynamic && window.windowStartTimeMs != C.TIME_UNSET;
    }

    private void startRenderers() throws ExoPlaybackException {
        updateRebufferingState(false, false);
        this.mediaClock.start();
        for (Renderer renderer : this.renderers) {
            if (isRendererEnabled(renderer)) {
                renderer.start();
            }
        }
    }

    private void stopInternal(boolean z10, boolean z11) {
        resetInternal(z10 || !this.foregroundMode, false, true, false);
        this.playbackInfoUpdate.incrementPendingOperationAcks(z11 ? 1 : 0);
        this.loadControl.onStopped();
        setState(1);
    }

    private void stopRenderers() throws ExoPlaybackException {
        this.mediaClock.stop();
        for (Renderer renderer : this.renderers) {
            if (isRendererEnabled(renderer)) {
                ensureStopped(renderer);
            }
        }
    }

    private void updateIsLoading() {
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        boolean z10 = this.shouldContinueLoading || (loadingPeriod != null && loadingPeriod.mediaPeriod.isLoading());
        PlaybackInfo playbackInfo = this.playbackInfo;
        if (z10 != playbackInfo.isLoading) {
            this.playbackInfo = playbackInfo.copyWithIsLoading(z10);
        }
    }

    private void updateLoadControlTrackSelection(MediaSource.MediaPeriodId mediaPeriodId, TrackGroupArray trackGroupArray, TrackSelectorResult trackSelectorResult) {
        this.loadControl.onTracksSelected(this.playbackInfo.timeline, mediaPeriodId, this.renderers, trackGroupArray, trackSelectorResult.selections);
    }

    private void updateMediaSourcesWithMediaItemsInternal(int i10, int i11, List<MediaItem> list) throws Throwable {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.updateMediaSourcesWithMediaItems(i10, i11, list), false);
    }

    private void updatePeriods() throws ExoPlaybackException {
        if (this.playbackInfo.timeline.isEmpty() || !this.mediaSourceList.isPrepared()) {
            return;
        }
        maybeUpdateLoadingPeriod();
        maybeUpdateReadingPeriod();
        maybeUpdateReadingRenderers();
        maybeUpdatePlayingPeriod();
    }

    private void updatePlaybackPositions() throws ExoPlaybackException {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        if (playingPeriod == null) {
            return;
        }
        long discontinuity = playingPeriod.prepared ? playingPeriod.mediaPeriod.readDiscontinuity() : -9223372036854775807L;
        if (discontinuity != C.TIME_UNSET) {
            if (!playingPeriod.isFullyBuffered()) {
                this.queue.removeAfter(playingPeriod);
                handleLoadingMediaPeriodChanged(false);
                maybeContinueLoading();
            }
            resetRendererPosition(discontinuity);
            if (discontinuity != this.playbackInfo.positionUs) {
                PlaybackInfo playbackInfo = this.playbackInfo;
                this.playbackInfo = handlePositionDiscontinuity(playbackInfo.periodId, discontinuity, playbackInfo.requestedContentPositionUs, discontinuity, true, 5);
            }
        } else {
            long jSyncAndGetPositionUs = this.mediaClock.syncAndGetPositionUs(playingPeriod != this.queue.getReadingPeriod());
            this.rendererPositionUs = jSyncAndGetPositionUs;
            long periodTime = playingPeriod.toPeriodTime(jSyncAndGetPositionUs);
            maybeTriggerPendingMessages(this.playbackInfo.positionUs, periodTime);
            if (this.mediaClock.hasSkippedSilenceSinceLastCall()) {
                PlaybackInfo playbackInfo2 = this.playbackInfo;
                this.playbackInfo = handlePositionDiscontinuity(playbackInfo2.periodId, periodTime, playbackInfo2.requestedContentPositionUs, periodTime, true, 6);
            } else {
                this.playbackInfo.updatePositionUs(periodTime);
            }
        }
        this.playbackInfo.bufferedPositionUs = this.queue.getLoadingPeriod().getBufferedPositionUs();
        this.playbackInfo.totalBufferedDurationUs = getTotalBufferedDurationUs();
        PlaybackInfo playbackInfo3 = this.playbackInfo;
        if (playbackInfo3.playWhenReady && playbackInfo3.playbackState == 3 && shouldUseLivePlaybackSpeedControl(playbackInfo3.timeline, playbackInfo3.periodId) && this.playbackInfo.playbackParameters.speed == 1.0f) {
            float adjustedPlaybackSpeed = this.livePlaybackSpeedControl.getAdjustedPlaybackSpeed(getCurrentLiveOffsetUs(), getTotalBufferedDurationUs());
            if (this.mediaClock.getPlaybackParameters().speed != adjustedPlaybackSpeed) {
                setMediaClockPlaybackParameters(this.playbackInfo.playbackParameters.withSpeed(adjustedPlaybackSpeed));
                handlePlaybackParameters(this.playbackInfo.playbackParameters, this.mediaClock.getPlaybackParameters().speed, false, false);
            }
        }
    }

    private void updatePlaybackSpeedSettingsForNewPeriod(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline2, MediaSource.MediaPeriodId mediaPeriodId2, long j10, boolean z10) throws ExoPlaybackException {
        if (!shouldUseLivePlaybackSpeedControl(timeline, mediaPeriodId)) {
            PlaybackParameters playbackParameters = mediaPeriodId.isAd() ? PlaybackParameters.DEFAULT : this.playbackInfo.playbackParameters;
            if (this.mediaClock.getPlaybackParameters().equals(playbackParameters)) {
                return;
            }
            setMediaClockPlaybackParameters(playbackParameters);
            handlePlaybackParameters(this.playbackInfo.playbackParameters, playbackParameters.speed, false, false);
            return;
        }
        timeline.getWindow(timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period).windowIndex, this.window);
        this.livePlaybackSpeedControl.setLiveConfiguration((MediaItem.LiveConfiguration) Util.castNonNull(this.window.liveConfiguration));
        if (j10 != C.TIME_UNSET) {
            this.livePlaybackSpeedControl.setTargetLiveOffsetOverrideUs(getLiveOffsetUs(timeline, mediaPeriodId.periodUid, j10));
            return;
        }
        if (!Util.areEqual(!timeline2.isEmpty() ? timeline2.getWindow(timeline2.getPeriodByUid(mediaPeriodId2.periodUid, this.period).windowIndex, this.window).uid : null, this.window.uid) || z10) {
            this.livePlaybackSpeedControl.setTargetLiveOffsetOverrideUs(C.TIME_UNSET);
        }
    }

    private void updateRebufferingState(boolean z10, boolean z11) {
        this.isRebuffering = z10;
        this.lastRebufferRealtimeMs = z11 ? C.TIME_UNSET : this.clock.elapsedRealtime();
    }

    private void updateTrackSelectionPlaybackSpeed(float f10) {
        for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null; playingPeriod = playingPeriod.getNext()) {
            for (ExoTrackSelection exoTrackSelection : playingPeriod.getTrackSelectorResult().selections) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.onPlaybackSpeed(f10);
                }
            }
        }
    }

    private synchronized void waitUninterruptibly(e5.u<Boolean> uVar, long j10) {
        long jElapsedRealtime = this.clock.elapsedRealtime() + j10;
        boolean z10 = false;
        while (!uVar.get().booleanValue() && j10 > 0) {
            try {
                this.clock.onThreadBlocked();
                wait(j10);
            } catch (InterruptedException unused) {
                z10 = true;
            }
            j10 = jElapsedRealtime - this.clock.elapsedRealtime();
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
    }

    public void addMediaSources(int i10, List<MediaSourceList.MediaSourceHolder> list, ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(18, i10, 0, new MediaSourceListUpdateMessage(list, shuffleOrder, -1, C.TIME_UNSET)).sendToTarget();
    }

    public void experimentalSetForegroundModeTimeoutMs(long j10) {
        this.setForegroundModeTimeoutMs = j10;
    }

    public Looper getPlaybackLooper() {
        return this.playbackLooper;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) throws Throwable {
        MediaPeriodHolder readingPeriod;
        int i10;
        try {
            switch (message.what) {
                case 0:
                    prepareInternal();
                    break;
                case 1:
                    setPlayWhenReadyInternal(message.arg1 != 0, message.arg2, true, 1);
                    break;
                case 2:
                    doSomeWork();
                    break;
                case 3:
                    seekToInternal((SeekPosition) message.obj);
                    break;
                case 4:
                    setPlaybackParametersInternal((PlaybackParameters) message.obj);
                    break;
                case 5:
                    setSeekParametersInternal((SeekParameters) message.obj);
                    break;
                case 6:
                    stopInternal(false, true);
                    break;
                case 7:
                    releaseInternal();
                    return true;
                case 8:
                    handlePeriodPrepared((MediaPeriod) message.obj);
                    break;
                case 9:
                    handleContinueLoadingRequested((MediaPeriod) message.obj);
                    break;
                case 10:
                    reselectTracksInternal();
                    break;
                case 11:
                    setRepeatModeInternal(message.arg1);
                    break;
                case 12:
                    setShuffleModeEnabledInternal(message.arg1 != 0);
                    break;
                case 13:
                    setForegroundModeInternal(message.arg1 != 0, (AtomicBoolean) message.obj);
                    break;
                case 14:
                    sendMessageInternal((PlayerMessage) message.obj);
                    break;
                case 15:
                    sendMessageToTargetThread((PlayerMessage) message.obj);
                    break;
                case 16:
                    handlePlaybackParameters((PlaybackParameters) message.obj, false);
                    break;
                case 17:
                    setMediaItemsInternal((MediaSourceListUpdateMessage) message.obj);
                    break;
                case 18:
                    addMediaItemsInternal((MediaSourceListUpdateMessage) message.obj, message.arg1);
                    break;
                case 19:
                    moveMediaItemsInternal((MoveMediaItemsMessage) message.obj);
                    break;
                case 20:
                    removeMediaItemsInternal(message.arg1, message.arg2, (ShuffleOrder) message.obj);
                    break;
                case 21:
                    setShuffleOrderInternal((ShuffleOrder) message.obj);
                    break;
                case 22:
                    mediaSourceListUpdateRequestedInternal();
                    break;
                case 23:
                    setPauseAtEndOfWindowInternal(message.arg1 != 0);
                    break;
                case 24:
                default:
                    return false;
                case 25:
                    attemptRendererErrorRecovery();
                    break;
                case 26:
                    reselectTracksInternalAndSeek();
                    break;
                case 27:
                    updateMediaSourcesWithMediaItemsInternal(message.arg1, message.arg2, (List) message.obj);
                    break;
            }
        } catch (ParserException e10) {
            int i11 = e10.dataType;
            if (i11 == 1) {
                i10 = e10.contentIsMalformed ? 3001 : PlaybackException.ERROR_CODE_PARSING_CONTAINER_UNSUPPORTED;
            } else {
                if (i11 == 4) {
                    i10 = e10.contentIsMalformed ? 3002 : PlaybackException.ERROR_CODE_PARSING_MANIFEST_UNSUPPORTED;
                }
                handleIoException(e10, i);
            }
            i = i10;
            handleIoException(e10, i);
        } catch (DataSourceException e11) {
            handleIoException(e11, e11.reason);
        } catch (ExoPlaybackException e12) {
            e = e12;
            if (e.type == 1 && (readingPeriod = this.queue.getReadingPeriod()) != null) {
                e = e.copyWithMediaPeriodId(readingPeriod.info.id);
            }
            if (e.isRecoverable && (this.pendingRecoverableRendererError == null || e.errorCode == 5003)) {
                Log.w(TAG, "Recoverable renderer error", e);
                ExoPlaybackException exoPlaybackException = this.pendingRecoverableRendererError;
                if (exoPlaybackException != null) {
                    exoPlaybackException.addSuppressed(e);
                    e = this.pendingRecoverableRendererError;
                } else {
                    this.pendingRecoverableRendererError = e;
                }
                HandlerWrapper handlerWrapper = this.handler;
                handlerWrapper.sendMessageAtFrontOfQueue(handlerWrapper.obtainMessage(25, e));
            } else {
                ExoPlaybackException exoPlaybackException2 = this.pendingRecoverableRendererError;
                if (exoPlaybackException2 != null) {
                    exoPlaybackException2.addSuppressed(e);
                    e = this.pendingRecoverableRendererError;
                }
                Log.e(TAG, "Playback error", e);
                if (e.type == 1 && this.queue.getPlayingPeriod() != this.queue.getReadingPeriod()) {
                    while (this.queue.getPlayingPeriod() != this.queue.getReadingPeriod()) {
                        this.queue.advancePlayingPeriod();
                    }
                    MediaPeriodInfo mediaPeriodInfo = ((MediaPeriodHolder) Assertions.checkNotNull(this.queue.getPlayingPeriod())).info;
                    MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodInfo.id;
                    long j10 = mediaPeriodInfo.startPositionUs;
                    this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, j10, mediaPeriodInfo.requestedContentPositionUs, j10, true, 0);
                }
                stopInternal(true, false);
                this.playbackInfo = this.playbackInfo.copyWithPlaybackError(e);
            }
        } catch (DrmSession.DrmSessionException e13) {
            handleIoException(e13, e13.errorCode);
        } catch (BehindLiveWindowException e14) {
            handleIoException(e14, 1002);
        } catch (IOException e15) {
            handleIoException(e15, 2000);
        } catch (RuntimeException e16) {
            ExoPlaybackException exoPlaybackExceptionCreateForUnexpected = ExoPlaybackException.createForUnexpected(e16, ((e16 instanceof IllegalStateException) || (e16 instanceof IllegalArgumentException)) ? 1004 : 1000);
            Log.e(TAG, "Playback error", exoPlaybackExceptionCreateForUnexpected);
            stopInternal(true, false);
            this.playbackInfo = this.playbackInfo.copyWithPlaybackError(exoPlaybackExceptionCreateForUnexpected);
        }
        maybeNotifyPlaybackInfoChanged();
        return true;
    }

    public void moveMediaSources(int i10, int i11, int i12, ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(19, new MoveMediaItemsMessage(i10, i11, i12, shuffleOrder)).sendToTarget();
    }

    @Override // androidx.media3.exoplayer.DefaultMediaClock.PlaybackParametersListener
    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        this.handler.obtainMessage(16, playbackParameters).sendToTarget();
    }

    @Override // androidx.media3.exoplayer.MediaSourceList.MediaSourceListInfoRefreshListener
    public void onPlaylistUpdateRequested() {
        this.handler.sendEmptyMessage(22);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod.Callback
    public void onPrepared(MediaPeriod mediaPeriod) {
        this.handler.obtainMessage(8, mediaPeriod).sendToTarget();
    }

    @Override // androidx.media3.exoplayer.trackselection.TrackSelector.InvalidationListener
    public void onRendererCapabilitiesChanged(Renderer renderer) {
        this.handler.sendEmptyMessage(26);
    }

    @Override // androidx.media3.exoplayer.trackselection.TrackSelector.InvalidationListener
    public void onTrackSelectionsInvalidated() {
        this.handler.sendEmptyMessage(10);
    }

    public void prepare() {
        this.handler.obtainMessage(0).sendToTarget();
    }

    public synchronized boolean release() {
        if (!this.released && this.playbackLooper.getThread().isAlive()) {
            this.handler.sendEmptyMessage(7);
            waitUninterruptibly(new e5.u() { // from class: androidx.media3.exoplayer.q1
                @Override // e5.u
                public final Object get() {
                    return this.f1463a.lambda$release$0();
                }
            }, this.releaseTimeoutMs);
            return this.released;
        }
        return true;
    }

    public void removeMediaSources(int i10, int i11, ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(20, i10, i11, shuffleOrder).sendToTarget();
    }

    public void seekTo(Timeline timeline, int i10, long j10) {
        this.handler.obtainMessage(3, new SeekPosition(timeline, i10, j10)).sendToTarget();
    }

    @Override // androidx.media3.exoplayer.PlayerMessage.Sender
    public synchronized void sendMessage(PlayerMessage playerMessage) {
        if (!this.released && this.playbackLooper.getThread().isAlive()) {
            this.handler.obtainMessage(14, playerMessage).sendToTarget();
            return;
        }
        Log.w(TAG, "Ignoring messages sent after release.");
        playerMessage.markAsProcessed(false);
    }

    public synchronized boolean setForegroundMode(boolean z10) {
        if (!this.released && this.playbackLooper.getThread().isAlive()) {
            if (z10) {
                this.handler.obtainMessage(13, 1, 0).sendToTarget();
                return true;
            }
            final AtomicBoolean atomicBoolean = new AtomicBoolean();
            this.handler.obtainMessage(13, 0, 0, atomicBoolean).sendToTarget();
            waitUninterruptibly(new e5.u() { // from class: androidx.media3.exoplayer.r1
                @Override // e5.u
                public final Object get() {
                    return Boolean.valueOf(atomicBoolean.get());
                }
            }, this.setForegroundModeTimeoutMs);
            return atomicBoolean.get();
        }
        return true;
    }

    public void setMediaSources(List<MediaSourceList.MediaSourceHolder> list, int i10, long j10, ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(17, new MediaSourceListUpdateMessage(list, shuffleOrder, i10, j10)).sendToTarget();
    }

    public void setPauseAtEndOfWindow(boolean z10) {
        this.handler.obtainMessage(23, z10 ? 1 : 0, 0).sendToTarget();
    }

    public void setPlayWhenReady(boolean z10, int i10) {
        this.handler.obtainMessage(1, z10 ? 1 : 0, i10).sendToTarget();
    }

    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        this.handler.obtainMessage(4, playbackParameters).sendToTarget();
    }

    public void setRepeatMode(int i10) {
        this.handler.obtainMessage(11, i10, 0).sendToTarget();
    }

    public void setSeekParameters(SeekParameters seekParameters) {
        this.handler.obtainMessage(5, seekParameters).sendToTarget();
    }

    public void setShuffleModeEnabled(boolean z10) {
        this.handler.obtainMessage(12, z10 ? 1 : 0, 0).sendToTarget();
    }

    public void setShuffleOrder(ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(21, shuffleOrder).sendToTarget();
    }

    public void stop() {
        this.handler.obtainMessage(6).sendToTarget();
    }

    public void updateMediaSourcesWithMediaItems(int i10, int i11, List<MediaItem> list) {
        this.handler.obtainMessage(27, i10, i11, list).sendToTarget();
    }

    private long getTotalBufferedDurationUs(long j10) {
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        if (loadingPeriod == null) {
            return 0L;
        }
        return Math.max(0L, j10 - loadingPeriod.toPeriodTime(this.rendererPositionUs));
    }

    private void handlePlaybackParameters(PlaybackParameters playbackParameters, float f10, boolean z10, boolean z11) throws ExoPlaybackException {
        if (z10) {
            if (z11) {
                this.playbackInfoUpdate.incrementPendingOperationAcks(1);
            }
            this.playbackInfo = this.playbackInfo.copyWithPlaybackParameters(playbackParameters);
        }
        updateTrackSelectionPlaybackSpeed(playbackParameters.speed);
        for (Renderer renderer : this.renderers) {
            if (renderer != null) {
                renderer.setPlaybackSpeed(f10, playbackParameters.speed);
            }
        }
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader.Callback
    public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        this.handler.obtainMessage(9, mediaPeriod).sendToTarget();
    }

    private void enableRenderers(boolean[] zArr, long j10) throws ExoPlaybackException {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        TrackSelectorResult trackSelectorResult = readingPeriod.getTrackSelectorResult();
        for (int i10 = 0; i10 < this.renderers.length; i10++) {
            if (!trackSelectorResult.isRendererEnabled(i10) && this.renderersToReset.remove(this.renderers[i10])) {
                this.renderers[i10].reset();
            }
        }
        for (int i11 = 0; i11 < this.renderers.length; i11++) {
            if (trackSelectorResult.isRendererEnabled(i11)) {
                enableRenderer(i11, zArr[i11], j10);
            }
        }
        readingPeriod.allRenderersInCorrectState = true;
    }

    private long seekToPeriodPosition(MediaSource.MediaPeriodId mediaPeriodId, long j10, boolean z10, boolean z11) throws ExoPlaybackException {
        stopRenderers();
        updateRebufferingState(false, true);
        if (z11 || this.playbackInfo.playbackState == 3) {
            setState(2);
        }
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        MediaPeriodHolder next = playingPeriod;
        while (next != null && !mediaPeriodId.equals(next.info.id)) {
            next = next.getNext();
        }
        if (z10 || playingPeriod != next || (next != null && next.toRendererTime(j10) < 0)) {
            for (Renderer renderer : this.renderers) {
                disableRenderer(renderer);
            }
            if (next != null) {
                while (this.queue.getPlayingPeriod() != next) {
                    this.queue.advancePlayingPeriod();
                }
                this.queue.removeAfter(next);
                next.setRendererOffset(MediaPeriodQueue.INITIAL_RENDERER_POSITION_OFFSET_US);
                enableRenderers();
            }
        }
        if (next != null) {
            this.queue.removeAfter(next);
            if (!next.prepared) {
                next.info = next.info.copyWithStartPositionUs(j10);
            } else if (next.hasEnabledTracks) {
                long jSeekToUs = next.mediaPeriod.seekToUs(j10);
                next.mediaPeriod.discardBuffer(jSeekToUs - this.backBufferDurationUs, this.retainBackBufferFromKeyframe);
                j10 = jSeekToUs;
            }
            resetRendererPosition(j10);
            maybeContinueLoading();
        } else {
            this.queue.clear();
            resetRendererPosition(j10);
        }
        handleLoadingMediaPeriodChanged(false);
        this.handler.sendEmptyMessage(2);
        return j10;
    }
}
