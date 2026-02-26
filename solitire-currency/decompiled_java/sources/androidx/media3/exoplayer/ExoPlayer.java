package androidx.media3.exoplayer;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.AuxEffectInfo;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.Effect;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.Player;
import androidx.media3.common.PriorityTaskManager;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.DefaultLivePlaybackSpeedControl;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.PlayerMessage;
import androidx.media3.exoplayer.analytics.AnalyticsCollector;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.analytics.DefaultAnalyticsCollector;
import androidx.media3.exoplayer.image.ImageOutput;
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.ShuffleOrder;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.trackselection.TrackSelectionArray;
import androidx.media3.exoplayer.trackselection.TrackSelector;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import androidx.media3.exoplayer.video.VideoFrameMetadataListener;
import androidx.media3.exoplayer.video.spherical.CameraMotionListener;
import androidx.media3.extractor.DefaultExtractorsFactory;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface ExoPlayer extends Player {

    @UnstableApi
    public static final long DEFAULT_DETACH_SURFACE_TIMEOUT_MS = 2000;

    @UnstableApi
    public static final long DEFAULT_RELEASE_TIMEOUT_MS = 500;

    @UnstableApi
    @Deprecated
    public interface AudioComponent {
        @Deprecated
        void clearAuxEffectInfo();

        @Deprecated
        AudioAttributes getAudioAttributes();

        @Deprecated
        int getAudioSessionId();

        @Deprecated
        boolean getSkipSilenceEnabled();

        @Deprecated
        float getVolume();

        @Deprecated
        void setAudioAttributes(AudioAttributes audioAttributes, boolean z10);

        @Deprecated
        void setAudioSessionId(int i10);

        @Deprecated
        void setAuxEffectInfo(AuxEffectInfo auxEffectInfo);

        @Deprecated
        void setSkipSilenceEnabled(boolean z10);

        @Deprecated
        void setVolume(float f10);
    }

    @UnstableApi
    public interface AudioOffloadListener {
        void onOffloadedPlayback(boolean z10);

        void onSleepingForOffloadChanged(boolean z10);
    }

    public static final class Builder {
        e5.g<Clock, AnalyticsCollector> analyticsCollectorFunction;
        AudioAttributes audioAttributes;
        e5.u<BandwidthMeter> bandwidthMeterSupplier;
        boolean buildCalled;
        Clock clock;
        final Context context;
        long detachSurfaceTimeoutMs;
        boolean deviceVolumeControlEnabled;
        long foregroundModeTimeoutMs;
        boolean handleAudioBecomingNoisy;
        boolean handleAudioFocus;
        LivePlaybackSpeedControl livePlaybackSpeedControl;
        e5.u<LoadControl> loadControlSupplier;
        Looper looper;
        e5.u<MediaSource.Factory> mediaSourceFactorySupplier;
        boolean pauseAtEndOfMediaItems;

        @Nullable
        Looper playbackLooper;

        @Nullable
        PriorityTaskManager priorityTaskManager;
        long releaseTimeoutMs;
        e5.u<RenderersFactory> renderersFactorySupplier;
        long seekBackIncrementMs;
        long seekForwardIncrementMs;
        SeekParameters seekParameters;
        boolean skipSilenceEnabled;
        boolean suppressPlaybackOnUnsuitableOutput;
        e5.u<TrackSelector> trackSelectorSupplier;
        boolean useLazyPreparation;
        boolean usePlatformDiagnostics;
        int videoChangeFrameRateStrategy;
        int videoScalingMode;
        int wakeMode;

        public Builder(final Context context) {
            this(context, (e5.u<RenderersFactory>) new e5.u() { // from class: androidx.media3.exoplayer.q
                @Override // e5.u
                public final Object get() {
                    return ExoPlayer.Builder.lambda$new$0(context);
                }
            }, (e5.u<MediaSource.Factory>) new e5.u() { // from class: androidx.media3.exoplayer.w
                @Override // e5.u
                public final Object get() {
                    return ExoPlayer.Builder.lambda$new$1(context);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ RenderersFactory lambda$new$0(Context context) {
            return new DefaultRenderersFactory(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ MediaSource.Factory lambda$new$1(Context context) {
            return new DefaultMediaSourceFactory(context, new DefaultExtractorsFactory());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ TrackSelector lambda$new$14(Context context) {
            return new DefaultTrackSelector(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ MediaSource.Factory lambda$new$3(Context context) {
            return new DefaultMediaSourceFactory(context, new DefaultExtractorsFactory());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ RenderersFactory lambda$new$4(Context context) {
            return new DefaultRenderersFactory(context);
        }

        public ExoPlayer build() {
            Assertions.checkState(!this.buildCalled);
            this.buildCalled = true;
            return new ExoPlayerImpl(this, null);
        }

        SimpleExoPlayer buildSimpleExoPlayer() {
            Assertions.checkState(!this.buildCalled);
            this.buildCalled = true;
            return new SimpleExoPlayer(this);
        }

        @UnstableApi
        public Builder experimentalSetForegroundModeTimeoutMs(long j10) {
            Assertions.checkState(!this.buildCalled);
            this.foregroundModeTimeoutMs = j10;
            return this;
        }

        @UnstableApi
        public Builder setAnalyticsCollector(final AnalyticsCollector analyticsCollector) {
            Assertions.checkState(!this.buildCalled);
            Assertions.checkNotNull(analyticsCollector);
            this.analyticsCollectorFunction = new e5.g() { // from class: androidx.media3.exoplayer.n
                @Override // e5.g
                public final Object apply(Object obj) {
                    return ExoPlayer.Builder.lambda$setAnalyticsCollector$21(analyticsCollector, (Clock) obj);
                }
            };
            return this;
        }

        public Builder setAudioAttributes(AudioAttributes audioAttributes, boolean z10) {
            Assertions.checkState(!this.buildCalled);
            this.audioAttributes = (AudioAttributes) Assertions.checkNotNull(audioAttributes);
            this.handleAudioFocus = z10;
            return this;
        }

        @UnstableApi
        public Builder setBandwidthMeter(final BandwidthMeter bandwidthMeter) {
            Assertions.checkState(!this.buildCalled);
            Assertions.checkNotNull(bandwidthMeter);
            this.bandwidthMeterSupplier = new e5.u() { // from class: androidx.media3.exoplayer.g
                @Override // e5.u
                public final Object get() {
                    return ExoPlayer.Builder.lambda$setBandwidthMeter$20(bandwidthMeter);
                }
            };
            return this;
        }

        @VisibleForTesting
        @UnstableApi
        public Builder setClock(Clock clock) {
            Assertions.checkState(!this.buildCalled);
            this.clock = clock;
            return this;
        }

        @UnstableApi
        public Builder setDetachSurfaceTimeoutMs(long j10) {
            Assertions.checkState(!this.buildCalled);
            this.detachSurfaceTimeoutMs = j10;
            return this;
        }

        @UnstableApi
        public Builder setDeviceVolumeControlEnabled(boolean z10) {
            Assertions.checkState(!this.buildCalled);
            this.deviceVolumeControlEnabled = z10;
            return this;
        }

        public Builder setHandleAudioBecomingNoisy(boolean z10) {
            Assertions.checkState(!this.buildCalled);
            this.handleAudioBecomingNoisy = z10;
            return this;
        }

        @UnstableApi
        public Builder setLivePlaybackSpeedControl(LivePlaybackSpeedControl livePlaybackSpeedControl) {
            Assertions.checkState(!this.buildCalled);
            this.livePlaybackSpeedControl = (LivePlaybackSpeedControl) Assertions.checkNotNull(livePlaybackSpeedControl);
            return this;
        }

        @UnstableApi
        public Builder setLoadControl(final LoadControl loadControl) {
            Assertions.checkState(!this.buildCalled);
            Assertions.checkNotNull(loadControl);
            this.loadControlSupplier = new e5.u() { // from class: androidx.media3.exoplayer.f
                @Override // e5.u
                public final Object get() {
                    return ExoPlayer.Builder.lambda$setLoadControl$19(loadControl);
                }
            };
            return this;
        }

        @UnstableApi
        public Builder setLooper(Looper looper) {
            Assertions.checkState(!this.buildCalled);
            Assertions.checkNotNull(looper);
            this.looper = looper;
            return this;
        }

        public Builder setMediaSourceFactory(final MediaSource.Factory factory) {
            Assertions.checkState(!this.buildCalled);
            Assertions.checkNotNull(factory);
            this.mediaSourceFactorySupplier = new e5.u() { // from class: androidx.media3.exoplayer.k
                @Override // e5.u
                public final Object get() {
                    return ExoPlayer.Builder.lambda$setMediaSourceFactory$17(factory);
                }
            };
            return this;
        }

        @UnstableApi
        public Builder setPauseAtEndOfMediaItems(boolean z10) {
            Assertions.checkState(!this.buildCalled);
            this.pauseAtEndOfMediaItems = z10;
            return this;
        }

        @UnstableApi
        public Builder setPlaybackLooper(Looper looper) {
            Assertions.checkState(!this.buildCalled);
            this.playbackLooper = looper;
            return this;
        }

        @UnstableApi
        public Builder setPriorityTaskManager(@Nullable PriorityTaskManager priorityTaskManager) {
            Assertions.checkState(!this.buildCalled);
            this.priorityTaskManager = priorityTaskManager;
            return this;
        }

        @UnstableApi
        public Builder setReleaseTimeoutMs(long j10) {
            Assertions.checkState(!this.buildCalled);
            this.releaseTimeoutMs = j10;
            return this;
        }

        @UnstableApi
        public Builder setRenderersFactory(final RenderersFactory renderersFactory) {
            Assertions.checkState(!this.buildCalled);
            Assertions.checkNotNull(renderersFactory);
            this.renderersFactorySupplier = new e5.u() { // from class: androidx.media3.exoplayer.x
                @Override // e5.u
                public final Object get() {
                    return ExoPlayer.Builder.lambda$setRenderersFactory$16(renderersFactory);
                }
            };
            return this;
        }

        @UnstableApi
        public Builder setSeekBackIncrementMs(@IntRange(from = 1) long j10) {
            Assertions.checkArgument(j10 > 0);
            Assertions.checkState(!this.buildCalled);
            this.seekBackIncrementMs = j10;
            return this;
        }

        @UnstableApi
        public Builder setSeekForwardIncrementMs(@IntRange(from = 1) long j10) {
            Assertions.checkArgument(j10 > 0);
            Assertions.checkState(!this.buildCalled);
            this.seekForwardIncrementMs = j10;
            return this;
        }

        @UnstableApi
        public Builder setSeekParameters(SeekParameters seekParameters) {
            Assertions.checkState(!this.buildCalled);
            this.seekParameters = (SeekParameters) Assertions.checkNotNull(seekParameters);
            return this;
        }

        @UnstableApi
        public Builder setSkipSilenceEnabled(boolean z10) {
            Assertions.checkState(!this.buildCalled);
            this.skipSilenceEnabled = z10;
            return this;
        }

        @UnstableApi
        public Builder setSuppressPlaybackOnUnsuitableOutput(boolean z10) {
            Assertions.checkState(!this.buildCalled);
            this.suppressPlaybackOnUnsuitableOutput = z10;
            return this;
        }

        @UnstableApi
        public Builder setTrackSelector(final TrackSelector trackSelector) {
            Assertions.checkState(!this.buildCalled);
            Assertions.checkNotNull(trackSelector);
            this.trackSelectorSupplier = new e5.u() { // from class: androidx.media3.exoplayer.j
                @Override // e5.u
                public final Object get() {
                    return ExoPlayer.Builder.lambda$setTrackSelector$18(trackSelector);
                }
            };
            return this;
        }

        @UnstableApi
        public Builder setUseLazyPreparation(boolean z10) {
            Assertions.checkState(!this.buildCalled);
            this.useLazyPreparation = z10;
            return this;
        }

        @UnstableApi
        public Builder setUsePlatformDiagnostics(boolean z10) {
            Assertions.checkState(!this.buildCalled);
            this.usePlatformDiagnostics = z10;
            return this;
        }

        @UnstableApi
        public Builder setVideoChangeFrameRateStrategy(int i10) {
            Assertions.checkState(!this.buildCalled);
            this.videoChangeFrameRateStrategy = i10;
            return this;
        }

        @UnstableApi
        public Builder setVideoScalingMode(int i10) {
            Assertions.checkState(!this.buildCalled);
            this.videoScalingMode = i10;
            return this;
        }

        public Builder setWakeMode(int i10) {
            Assertions.checkState(!this.buildCalled);
            this.wakeMode = i10;
            return this;
        }

        @UnstableApi
        public Builder(final Context context, final RenderersFactory renderersFactory) {
            this(context, (e5.u<RenderersFactory>) new e5.u() { // from class: androidx.media3.exoplayer.l
                @Override // e5.u
                public final Object get() {
                    return ExoPlayer.Builder.lambda$new$2(renderersFactory);
                }
            }, (e5.u<MediaSource.Factory>) new e5.u() { // from class: androidx.media3.exoplayer.m
                @Override // e5.u
                public final Object get() {
                    return ExoPlayer.Builder.lambda$new$3(context);
                }
            });
            Assertions.checkNotNull(renderersFactory);
        }

        @UnstableApi
        public Builder(final Context context, final MediaSource.Factory factory) {
            this(context, (e5.u<RenderersFactory>) new e5.u() { // from class: androidx.media3.exoplayer.h
                @Override // e5.u
                public final Object get() {
                    return ExoPlayer.Builder.lambda$new$4(context);
                }
            }, (e5.u<MediaSource.Factory>) new e5.u() { // from class: androidx.media3.exoplayer.i
                @Override // e5.u
                public final Object get() {
                    return ExoPlayer.Builder.lambda$new$5(factory);
                }
            });
            Assertions.checkNotNull(factory);
        }

        @UnstableApi
        public Builder(Context context, final RenderersFactory renderersFactory, final MediaSource.Factory factory) {
            this(context, (e5.u<RenderersFactory>) new e5.u() { // from class: androidx.media3.exoplayer.u
                @Override // e5.u
                public final Object get() {
                    return ExoPlayer.Builder.lambda$new$6(renderersFactory);
                }
            }, (e5.u<MediaSource.Factory>) new e5.u() { // from class: androidx.media3.exoplayer.v
                @Override // e5.u
                public final Object get() {
                    return ExoPlayer.Builder.lambda$new$7(factory);
                }
            });
            Assertions.checkNotNull(renderersFactory);
            Assertions.checkNotNull(factory);
        }

        @UnstableApi
        public Builder(Context context, final RenderersFactory renderersFactory, final MediaSource.Factory factory, final TrackSelector trackSelector, final LoadControl loadControl, final BandwidthMeter bandwidthMeter, final AnalyticsCollector analyticsCollector) {
            this(context, (e5.u<RenderersFactory>) new e5.u() { // from class: androidx.media3.exoplayer.y
                @Override // e5.u
                public final Object get() {
                    return ExoPlayer.Builder.lambda$new$8(renderersFactory);
                }
            }, (e5.u<MediaSource.Factory>) new e5.u() { // from class: androidx.media3.exoplayer.z
                @Override // e5.u
                public final Object get() {
                    return ExoPlayer.Builder.lambda$new$9(factory);
                }
            }, (e5.u<TrackSelector>) new e5.u() { // from class: androidx.media3.exoplayer.a0
                @Override // e5.u
                public final Object get() {
                    return ExoPlayer.Builder.lambda$new$10(trackSelector);
                }
            }, (e5.u<LoadControl>) new e5.u() { // from class: androidx.media3.exoplayer.b0
                @Override // e5.u
                public final Object get() {
                    return ExoPlayer.Builder.lambda$new$11(loadControl);
                }
            }, (e5.u<BandwidthMeter>) new e5.u() { // from class: androidx.media3.exoplayer.c0
                @Override // e5.u
                public final Object get() {
                    return ExoPlayer.Builder.lambda$new$12(bandwidthMeter);
                }
            }, (e5.g<Clock, AnalyticsCollector>) new e5.g() { // from class: androidx.media3.exoplayer.d0
                @Override // e5.g
                public final Object apply(Object obj) {
                    return ExoPlayer.Builder.lambda$new$13(analyticsCollector, (Clock) obj);
                }
            });
            Assertions.checkNotNull(renderersFactory);
            Assertions.checkNotNull(factory);
            Assertions.checkNotNull(trackSelector);
            Assertions.checkNotNull(bandwidthMeter);
            Assertions.checkNotNull(analyticsCollector);
        }

        private Builder(final Context context, e5.u<RenderersFactory> uVar, e5.u<MediaSource.Factory> uVar2) {
            this(context, uVar, uVar2, (e5.u<TrackSelector>) new e5.u() { // from class: androidx.media3.exoplayer.o
                @Override // e5.u
                public final Object get() {
                    return ExoPlayer.Builder.lambda$new$14(context);
                }
            }, (e5.u<LoadControl>) new e5.u() { // from class: androidx.media3.exoplayer.p
                @Override // e5.u
                public final Object get() {
                    return new DefaultLoadControl();
                }
            }, (e5.u<BandwidthMeter>) new e5.u() { // from class: androidx.media3.exoplayer.s
                @Override // e5.u
                public final Object get() {
                    return DefaultBandwidthMeter.getSingletonInstance(context);
                }
            }, (e5.g<Clock, AnalyticsCollector>) new e5.g() { // from class: androidx.media3.exoplayer.t
                @Override // e5.g
                public final Object apply(Object obj) {
                    return new DefaultAnalyticsCollector((Clock) obj);
                }
            });
        }

        private Builder(Context context, e5.u<RenderersFactory> uVar, e5.u<MediaSource.Factory> uVar2, e5.u<TrackSelector> uVar3, e5.u<LoadControl> uVar4, e5.u<BandwidthMeter> uVar5, e5.g<Clock, AnalyticsCollector> gVar) {
            this.context = (Context) Assertions.checkNotNull(context);
            this.renderersFactorySupplier = uVar;
            this.mediaSourceFactorySupplier = uVar2;
            this.trackSelectorSupplier = uVar3;
            this.loadControlSupplier = uVar4;
            this.bandwidthMeterSupplier = uVar5;
            this.analyticsCollectorFunction = gVar;
            this.looper = Util.getCurrentOrMainLooper();
            this.audioAttributes = AudioAttributes.DEFAULT;
            this.wakeMode = 0;
            this.videoScalingMode = 1;
            this.videoChangeFrameRateStrategy = 0;
            this.useLazyPreparation = true;
            this.seekParameters = SeekParameters.DEFAULT;
            this.seekBackIncrementMs = 5000L;
            this.seekForwardIncrementMs = 15000L;
            this.livePlaybackSpeedControl = new DefaultLivePlaybackSpeedControl.Builder().build();
            this.clock = Clock.DEFAULT;
            this.releaseTimeoutMs = 500L;
            this.detachSurfaceTimeoutMs = ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
            this.usePlatformDiagnostics = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ TrackSelector lambda$new$10(TrackSelector trackSelector) {
            return trackSelector;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ LoadControl lambda$new$11(LoadControl loadControl) {
            return loadControl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ BandwidthMeter lambda$new$12(BandwidthMeter bandwidthMeter) {
            return bandwidthMeter;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ RenderersFactory lambda$new$2(RenderersFactory renderersFactory) {
            return renderersFactory;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ MediaSource.Factory lambda$new$5(MediaSource.Factory factory) {
            return factory;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ RenderersFactory lambda$new$6(RenderersFactory renderersFactory) {
            return renderersFactory;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ MediaSource.Factory lambda$new$7(MediaSource.Factory factory) {
            return factory;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ RenderersFactory lambda$new$8(RenderersFactory renderersFactory) {
            return renderersFactory;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ MediaSource.Factory lambda$new$9(MediaSource.Factory factory) {
            return factory;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ BandwidthMeter lambda$setBandwidthMeter$20(BandwidthMeter bandwidthMeter) {
            return bandwidthMeter;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ LoadControl lambda$setLoadControl$19(LoadControl loadControl) {
            return loadControl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ MediaSource.Factory lambda$setMediaSourceFactory$17(MediaSource.Factory factory) {
            return factory;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ RenderersFactory lambda$setRenderersFactory$16(RenderersFactory renderersFactory) {
            return renderersFactory;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ TrackSelector lambda$setTrackSelector$18(TrackSelector trackSelector) {
            return trackSelector;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ AnalyticsCollector lambda$new$13(AnalyticsCollector analyticsCollector, Clock clock) {
            return analyticsCollector;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ AnalyticsCollector lambda$setAnalyticsCollector$21(AnalyticsCollector analyticsCollector, Clock clock) {
            return analyticsCollector;
        }
    }

    @UnstableApi
    @Deprecated
    public interface DeviceComponent {
        @Deprecated
        void decreaseDeviceVolume();

        @Deprecated
        DeviceInfo getDeviceInfo();

        @Deprecated
        int getDeviceVolume();

        @Deprecated
        void increaseDeviceVolume();

        @Deprecated
        boolean isDeviceMuted();

        @Deprecated
        void setDeviceMuted(boolean z10);

        @Deprecated
        void setDeviceVolume(int i10);
    }

    @UnstableApi
    @Deprecated
    public interface TextComponent {
        @Deprecated
        CueGroup getCurrentCues();
    }

    @UnstableApi
    @Deprecated
    public interface VideoComponent {
        @Deprecated
        void clearCameraMotionListener(CameraMotionListener cameraMotionListener);

        @Deprecated
        void clearVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener);

        @Deprecated
        void clearVideoSurface();

        @Deprecated
        void clearVideoSurface(@Nullable Surface surface);

        @Deprecated
        void clearVideoSurfaceHolder(@Nullable SurfaceHolder surfaceHolder);

        @Deprecated
        void clearVideoSurfaceView(@Nullable SurfaceView surfaceView);

        @Deprecated
        void clearVideoTextureView(@Nullable TextureView textureView);

        @Deprecated
        int getVideoChangeFrameRateStrategy();

        @Deprecated
        int getVideoScalingMode();

        @Deprecated
        VideoSize getVideoSize();

        @Deprecated
        void setCameraMotionListener(CameraMotionListener cameraMotionListener);

        @Deprecated
        void setVideoChangeFrameRateStrategy(int i10);

        @Deprecated
        void setVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener);

        @Deprecated
        void setVideoScalingMode(int i10);

        @Deprecated
        void setVideoSurface(@Nullable Surface surface);

        @Deprecated
        void setVideoSurfaceHolder(@Nullable SurfaceHolder surfaceHolder);

        @Deprecated
        void setVideoSurfaceView(@Nullable SurfaceView surfaceView);

        @Deprecated
        void setVideoTextureView(@Nullable TextureView textureView);
    }

    void addAnalyticsListener(AnalyticsListener analyticsListener);

    @UnstableApi
    void addAudioOffloadListener(AudioOffloadListener audioOffloadListener);

    @UnstableApi
    void addMediaSource(int i10, MediaSource mediaSource);

    @UnstableApi
    void addMediaSource(MediaSource mediaSource);

    @UnstableApi
    void addMediaSources(int i10, List<MediaSource> list);

    @UnstableApi
    void addMediaSources(List<MediaSource> list);

    @UnstableApi
    void clearAuxEffectInfo();

    @UnstableApi
    void clearCameraMotionListener(CameraMotionListener cameraMotionListener);

    @UnstableApi
    void clearVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener);

    @UnstableApi
    PlayerMessage createMessage(PlayerMessage.Target target);

    @UnstableApi
    AnalyticsCollector getAnalyticsCollector();

    @Nullable
    @UnstableApi
    @Deprecated
    AudioComponent getAudioComponent();

    @Nullable
    @UnstableApi
    DecoderCounters getAudioDecoderCounters();

    @Nullable
    @UnstableApi
    Format getAudioFormat();

    @UnstableApi
    int getAudioSessionId();

    @UnstableApi
    Clock getClock();

    @UnstableApi
    @Deprecated
    TrackGroupArray getCurrentTrackGroups();

    @UnstableApi
    @Deprecated
    TrackSelectionArray getCurrentTrackSelections();

    @Nullable
    @UnstableApi
    @Deprecated
    DeviceComponent getDeviceComponent();

    @UnstableApi
    boolean getPauseAtEndOfMediaItems();

    @UnstableApi
    Looper getPlaybackLooper();

    @Override // androidx.media3.common.Player
    @Nullable
    /* bridge */ /* synthetic */ PlaybackException getPlayerError();

    @Override // androidx.media3.common.Player
    @Nullable
    ExoPlaybackException getPlayerError();

    @UnstableApi
    Renderer getRenderer(int i10);

    @UnstableApi
    int getRendererCount();

    @UnstableApi
    int getRendererType(int i10);

    @UnstableApi
    SeekParameters getSeekParameters();

    @UnstableApi
    boolean getSkipSilenceEnabled();

    @Nullable
    @UnstableApi
    @Deprecated
    TextComponent getTextComponent();

    @Nullable
    @UnstableApi
    TrackSelector getTrackSelector();

    @UnstableApi
    int getVideoChangeFrameRateStrategy();

    @Nullable
    @UnstableApi
    @Deprecated
    VideoComponent getVideoComponent();

    @Nullable
    @UnstableApi
    DecoderCounters getVideoDecoderCounters();

    @Nullable
    @UnstableApi
    Format getVideoFormat();

    @UnstableApi
    int getVideoScalingMode();

    @UnstableApi
    boolean isSleepingForOffload();

    @UnstableApi
    boolean isTunnelingEnabled();

    @UnstableApi
    @Deprecated
    void prepare(MediaSource mediaSource);

    @UnstableApi
    @Deprecated
    void prepare(MediaSource mediaSource, boolean z10, boolean z11);

    void removeAnalyticsListener(AnalyticsListener analyticsListener);

    @UnstableApi
    void removeAudioOffloadListener(AudioOffloadListener audioOffloadListener);

    @Override // androidx.media3.common.Player
    void replaceMediaItem(int i10, MediaItem mediaItem);

    @Override // androidx.media3.common.Player
    void replaceMediaItems(int i10, int i11, List<MediaItem> list);

    @UnstableApi
    void setAudioSessionId(int i10);

    @UnstableApi
    void setAuxEffectInfo(AuxEffectInfo auxEffectInfo);

    @UnstableApi
    void setCameraMotionListener(CameraMotionListener cameraMotionListener);

    @UnstableApi
    void setForegroundMode(boolean z10);

    void setHandleAudioBecomingNoisy(boolean z10);

    @UnstableApi
    void setImageOutput(ImageOutput imageOutput);

    @UnstableApi
    void setMediaSource(MediaSource mediaSource);

    @UnstableApi
    void setMediaSource(MediaSource mediaSource, long j10);

    @UnstableApi
    void setMediaSource(MediaSource mediaSource, boolean z10);

    @UnstableApi
    void setMediaSources(List<MediaSource> list);

    @UnstableApi
    void setMediaSources(List<MediaSource> list, int i10, long j10);

    @UnstableApi
    void setMediaSources(List<MediaSource> list, boolean z10);

    @UnstableApi
    void setPauseAtEndOfMediaItems(boolean z10);

    @RequiresApi(23)
    @UnstableApi
    void setPreferredAudioDevice(@Nullable AudioDeviceInfo audioDeviceInfo);

    @UnstableApi
    void setPriorityTaskManager(@Nullable PriorityTaskManager priorityTaskManager);

    @UnstableApi
    void setSeekParameters(@Nullable SeekParameters seekParameters);

    @UnstableApi
    void setShuffleOrder(ShuffleOrder shuffleOrder);

    @UnstableApi
    void setSkipSilenceEnabled(boolean z10);

    @UnstableApi
    void setVideoChangeFrameRateStrategy(int i10);

    @RequiresApi(18)
    @UnstableApi
    void setVideoEffects(List<Effect> list);

    @UnstableApi
    void setVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener);

    @UnstableApi
    void setVideoScalingMode(int i10);

    void setWakeMode(int i10);
}
