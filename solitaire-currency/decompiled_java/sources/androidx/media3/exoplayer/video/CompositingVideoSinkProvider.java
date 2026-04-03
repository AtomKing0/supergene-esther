package androidx.media3.exoplayer.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.media3.common.C;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.DebugViewProvider;
import androidx.media3.common.Effect;
import androidx.media3.common.Format;
import androidx.media3.common.FrameInfo;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.PreviewingVideoGraph;
import androidx.media3.common.SurfaceInfo;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.VideoFrameProcessor;
import androidx.media3.common.VideoGraph;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.TimestampIterator;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.video.CompositingVideoSinkProvider;
import androidx.media3.exoplayer.video.VideoFrameRenderControl;
import androidx.media3.exoplayer.video.VideoSink;
import com.google.common.collect.y;
import io.sentry.protocol.OperatingSystem;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@UnstableApi
public final class CompositingVideoSinkProvider implements VideoSinkProvider, VideoGraph.Listener, VideoFrameRenderControl.FrameRenderer {
    private static final Executor NO_OP_EXECUTOR = new Executor() { // from class: androidx.media3.exoplayer.video.e
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            CompositingVideoSinkProvider.lambda$static$0(runnable);
        }
    };
    private static final int STATE_CREATED = 0;
    private static final int STATE_INITIALIZED = 1;
    private static final int STATE_RELEASED = 2;
    private Clock clock;
    private final Context context;

    @Nullable
    private Pair<Surface, Size> currentSurfaceAndSize;
    private HandlerWrapper handler;
    private VideoSink.Listener listener;
    private Executor listenerExecutor;
    private Format outputFormat;
    private int pendingFlushCount;
    private final PreviewingVideoGraph.Factory previewingVideoGraphFactory;
    private int state;
    private List<Effect> videoEffects;
    private VideoFrameMetadataListener videoFrameMetadataListener;
    private VideoFrameReleaseControl videoFrameReleaseControl;
    private VideoFrameRenderControl videoFrameRenderControl;
    private PreviewingVideoGraph videoGraph;
    private VideoSinkImpl videoSinkImpl;

    public static final class Builder {
        private boolean built;
        private final Context context;
        private PreviewingVideoGraph.Factory previewingVideoGraphFactory;
        private VideoFrameProcessor.Factory videoFrameProcessorFactory;

        public Builder(Context context) {
            this.context = context;
        }

        public CompositingVideoSinkProvider build() {
            Assertions.checkState(!this.built);
            if (this.previewingVideoGraphFactory == null) {
                if (this.videoFrameProcessorFactory == null) {
                    this.videoFrameProcessorFactory = new ReflectiveDefaultVideoFrameProcessorFactory();
                }
                this.previewingVideoGraphFactory = new ReflectivePreviewingSingleInputVideoGraphFactory(this.videoFrameProcessorFactory);
            }
            CompositingVideoSinkProvider compositingVideoSinkProvider = new CompositingVideoSinkProvider(this);
            this.built = true;
            return compositingVideoSinkProvider;
        }

        public Builder setPreviewingVideoGraphFactory(PreviewingVideoGraph.Factory factory) {
            this.previewingVideoGraphFactory = factory;
            return this;
        }

        public Builder setVideoFrameProcessorFactory(VideoFrameProcessor.Factory factory) {
            this.videoFrameProcessorFactory = factory;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class ReflectiveDefaultVideoFrameProcessorFactory implements VideoFrameProcessor.Factory {
        private static final e5.u<VideoFrameProcessor.Factory> VIDEO_FRAME_PROCESSOR_FACTORY_SUPPLIER = e5.v.a(new e5.u() { // from class: androidx.media3.exoplayer.video.h
            @Override // e5.u
            public final Object get() {
                return CompositingVideoSinkProvider.ReflectiveDefaultVideoFrameProcessorFactory.lambda$static$0();
            }
        });

        private ReflectiveDefaultVideoFrameProcessorFactory() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ VideoFrameProcessor.Factory lambda$static$0() {
            try {
                Class<?> cls = Class.forName("androidx.media3.effect.DefaultVideoFrameProcessor$Factory$Builder");
                return (VideoFrameProcessor.Factory) Assertions.checkNotNull(cls.getMethod(OperatingSystem.JsonKeys.BUILD, new Class[0]).invoke(cls.getConstructor(new Class[0]).newInstance(new Object[0]), new Object[0]));
            } catch (Exception e10) {
                throw new IllegalStateException(e10);
            }
        }

        @Override // androidx.media3.common.VideoFrameProcessor.Factory
        public VideoFrameProcessor create(Context context, DebugViewProvider debugViewProvider, ColorInfo colorInfo, boolean z10, Executor executor, VideoFrameProcessor.Listener listener) throws VideoFrameProcessingException {
            return VIDEO_FRAME_PROCESSOR_FACTORY_SUPPLIER.get().create(context, debugViewProvider, colorInfo, z10, executor, listener);
        }
    }

    private static final class ReflectivePreviewingSingleInputVideoGraphFactory implements PreviewingVideoGraph.Factory {
        private final VideoFrameProcessor.Factory videoFrameProcessorFactory;

        public ReflectivePreviewingSingleInputVideoGraphFactory(VideoFrameProcessor.Factory factory) {
            this.videoFrameProcessorFactory = factory;
        }

        @Override // androidx.media3.common.PreviewingVideoGraph.Factory
        public PreviewingVideoGraph create(Context context, ColorInfo colorInfo, ColorInfo colorInfo2, DebugViewProvider debugViewProvider, VideoGraph.Listener listener, Executor executor, List<Effect> list, long j10) throws VideoFrameProcessingException {
            Constructor<?> constructor;
            Object[] objArr;
            try {
                constructor = Class.forName("androidx.media3.effect.PreviewingSingleInputVideoGraph$Factory").getConstructor(VideoFrameProcessor.Factory.class);
                objArr = new Object[1];
            } catch (Exception e10) {
                e = e10;
            }
            try {
                objArr[0] = this.videoFrameProcessorFactory;
                return ((PreviewingVideoGraph.Factory) constructor.newInstance(objArr)).create(context, colorInfo, colorInfo2, debugViewProvider, listener, executor, list, j10);
            } catch (Exception e11) {
                e = e11;
                throw VideoFrameProcessingException.from(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class VideoSinkImpl implements VideoSink {
        private final CompositingVideoSinkProvider compositingVideoSinkProvider;
        private final Context context;
        private boolean hasRegisteredFirstInputStream;

        @Nullable
        private Format inputFormat;
        private long inputStreamOffsetUs;
        private int inputType;
        private long pendingInputStreamBufferPresentationTimeUs;
        private boolean pendingInputStreamOffsetChange;

        @Nullable
        private Effect rotationEffect;
        private final VideoFrameProcessor videoFrameProcessor;
        private final int videoFrameProcessorMaxPendingFrameCount;
        private final ArrayList<Effect> videoEffects = new ArrayList<>();
        private long finalBufferPresentationTimeUs = C.TIME_UNSET;
        private long lastBufferPresentationTimeUs = C.TIME_UNSET;

        private static final class ScaleAndRotateAccessor {
            private static Method buildScaleAndRotateTransformationMethod;
            private static Constructor<?> scaleAndRotateTransformationBuilderConstructor;
            private static Method setRotationMethod;

            private ScaleAndRotateAccessor() {
            }

            public static Effect createRotationEffect(float f10) {
                try {
                    prepare();
                    Object objNewInstance = scaleAndRotateTransformationBuilderConstructor.newInstance(new Object[0]);
                    setRotationMethod.invoke(objNewInstance, Float.valueOf(f10));
                    return (Effect) Assertions.checkNotNull(buildScaleAndRotateTransformationMethod.invoke(objNewInstance, new Object[0]));
                } catch (Exception e10) {
                    throw new IllegalStateException(e10);
                }
            }

            private static void prepare() throws NoSuchMethodException, ClassNotFoundException {
                if (scaleAndRotateTransformationBuilderConstructor == null || setRotationMethod == null || buildScaleAndRotateTransformationMethod == null) {
                    Class<?> cls = Class.forName("androidx.media3.effect.ScaleAndRotateTransformation$Builder");
                    scaleAndRotateTransformationBuilderConstructor = cls.getConstructor(new Class[0]);
                    setRotationMethod = cls.getMethod("setRotationDegrees", Float.TYPE);
                    buildScaleAndRotateTransformationMethod = cls.getMethod(OperatingSystem.JsonKeys.BUILD, new Class[0]);
                }
            }
        }

        public VideoSinkImpl(Context context, CompositingVideoSinkProvider compositingVideoSinkProvider, PreviewingVideoGraph previewingVideoGraph) throws VideoFrameProcessingException {
            this.context = context;
            this.compositingVideoSinkProvider = compositingVideoSinkProvider;
            this.videoFrameProcessorMaxPendingFrameCount = Util.getMaxPendingFramesCountForMediaCodecDecoders(context);
            this.videoFrameProcessor = previewingVideoGraph.getProcessor(previewingVideoGraph.registerInput());
        }

        private void maybeRegisterInputStream() {
            if (this.inputFormat == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            Effect effect = this.rotationEffect;
            if (effect != null) {
                arrayList.add(effect);
            }
            arrayList.addAll(this.videoEffects);
            Format format = (Format) Assertions.checkNotNull(this.inputFormat);
            this.videoFrameProcessor.registerInputStream(this.inputType, arrayList, new FrameInfo.Builder(CompositingVideoSinkProvider.getAdjustedInputColorInfo(format.colorInfo), format.width, format.height).setPixelWidthHeightRatio(format.pixelWidthHeightRatio).build());
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void flush() {
            this.videoFrameProcessor.flush();
            this.hasRegisteredFirstInputStream = false;
            this.finalBufferPresentationTimeUs = C.TIME_UNSET;
            this.lastBufferPresentationTimeUs = C.TIME_UNSET;
            this.compositingVideoSinkProvider.flush();
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public Surface getInputSurface() {
            return this.videoFrameProcessor.getInputSurface();
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public boolean isEnded() {
            long j10 = this.finalBufferPresentationTimeUs;
            return j10 != C.TIME_UNSET && this.compositingVideoSinkProvider.hasReleasedFrame(j10);
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public boolean isFrameDropAllowedOnInput() {
            return Util.isFrameDropAllowedOnSurfaceInput(this.context);
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public boolean isReady() {
            return this.compositingVideoSinkProvider.isReady();
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public boolean queueBitmap(Bitmap bitmap, TimestampIterator timestampIterator) {
            return ((VideoFrameProcessor) Assertions.checkStateNotNull(this.videoFrameProcessor)).queueInputBitmap(bitmap, timestampIterator);
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public long registerInputFrame(long j10, boolean z10) {
            Assertions.checkState(this.videoFrameProcessorMaxPendingFrameCount != -1);
            long j11 = this.pendingInputStreamBufferPresentationTimeUs;
            if (j11 != C.TIME_UNSET) {
                if (!this.compositingVideoSinkProvider.hasReleasedFrame(j11)) {
                    return C.TIME_UNSET;
                }
                maybeRegisterInputStream();
                this.pendingInputStreamBufferPresentationTimeUs = C.TIME_UNSET;
            }
            if (this.videoFrameProcessor.getPendingInputFrameCount() >= this.videoFrameProcessorMaxPendingFrameCount || !this.videoFrameProcessor.registerInputFrame()) {
                return C.TIME_UNSET;
            }
            long j12 = this.inputStreamOffsetUs;
            long j13 = j10 + j12;
            if (this.pendingInputStreamOffsetChange) {
                this.compositingVideoSinkProvider.onStreamOffsetChange(j13, j12);
                this.pendingInputStreamOffsetChange = false;
            }
            this.lastBufferPresentationTimeUs = j13;
            if (z10) {
                this.finalBufferPresentationTimeUs = j13;
            }
            return j13 * 1000;
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void registerInputStream(int i10, Format format) {
            int i11;
            Format format2;
            if (i10 != 1 && i10 != 2) {
                throw new UnsupportedOperationException("Unsupported input type " + i10);
            }
            if (i10 != 1 || Util.SDK_INT >= 21 || (i11 = format.rotationDegrees) == -1 || i11 == 0) {
                this.rotationEffect = null;
            } else if (this.rotationEffect == null || (format2 = this.inputFormat) == null || format2.rotationDegrees != i11) {
                this.rotationEffect = ScaleAndRotateAccessor.createRotationEffect(i11);
            }
            this.inputType = i10;
            this.inputFormat = format;
            if (this.hasRegisteredFirstInputStream) {
                Assertions.checkState(this.lastBufferPresentationTimeUs != C.TIME_UNSET);
                this.pendingInputStreamBufferPresentationTimeUs = this.lastBufferPresentationTimeUs;
            } else {
                maybeRegisterInputStream();
                this.hasRegisteredFirstInputStream = true;
                this.pendingInputStreamBufferPresentationTimeUs = C.TIME_UNSET;
            }
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void render(long j10, long j11) throws VideoSink.VideoSinkException {
            try {
                this.compositingVideoSinkProvider.render(j10, j11);
            } catch (ExoPlaybackException e10) {
                Format formatBuild = this.inputFormat;
                if (formatBuild == null) {
                    formatBuild = new Format.Builder().build();
                }
                throw new VideoSink.VideoSinkException(e10, formatBuild);
            }
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void setListener(VideoSink.Listener listener, Executor executor) {
            this.compositingVideoSinkProvider.setListener(listener, executor);
        }

        public void setPendingVideoEffects(List<Effect> list) {
            this.videoEffects.clear();
            this.videoEffects.addAll(list);
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void setPlaybackSpeed(@FloatRange(from = 0.0d, fromInclusive = false) float f10) {
            this.compositingVideoSinkProvider.setPlaybackSpeed(f10);
        }

        public void setStreamOffsetUs(long j10) {
            this.pendingInputStreamOffsetChange = this.inputStreamOffsetUs != j10;
            this.inputStreamOffsetUs = j10;
        }

        public void setVideoEffects(List<Effect> list) {
            setPendingVideoEffects(list);
            maybeRegisterInputStream();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void flush() {
        this.pendingFlushCount++;
        ((VideoFrameRenderControl) Assertions.checkStateNotNull(this.videoFrameRenderControl)).flush();
        ((HandlerWrapper) Assertions.checkStateNotNull(this.handler)).post(new Runnable() { // from class: androidx.media3.exoplayer.video.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f1567a.flushInternal();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void flushInternal() {
        int i10 = this.pendingFlushCount - 1;
        this.pendingFlushCount = i10;
        if (i10 > 0) {
            return;
        }
        if (i10 < 0) {
            throw new IllegalStateException(String.valueOf(this.pendingFlushCount));
        }
        ((VideoFrameRenderControl) Assertions.checkStateNotNull(this.videoFrameRenderControl)).flush();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ColorInfo getAdjustedInputColorInfo(@Nullable ColorInfo colorInfo) {
        return (colorInfo == null || !ColorInfo.isTransferHdr(colorInfo)) ? ColorInfo.SDR_BT709_LIMITED : colorInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasReleasedFrame(long j10) {
        return this.pendingFlushCount == 0 && ((VideoFrameRenderControl) Assertions.checkStateNotNull(this.videoFrameRenderControl)).hasReleasedFrame(j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isReady() {
        return this.pendingFlushCount == 0 && ((VideoFrameRenderControl) Assertions.checkStateNotNull(this.videoFrameRenderControl)).isReady();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dropFrame$4(VideoSink.Listener listener) {
        listener.onFrameDropped((VideoSink) Assertions.checkStateNotNull(this.videoSinkImpl));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onError$1(VideoSink.Listener listener, VideoFrameProcessingException videoFrameProcessingException) {
        VideoSinkImpl videoSinkImpl = (VideoSinkImpl) Assertions.checkStateNotNull(this.videoSinkImpl);
        listener.onError(videoSinkImpl, new VideoSink.VideoSinkException(videoFrameProcessingException, (Format) Assertions.checkStateNotNull(videoSinkImpl.inputFormat)));
    }

    private void maybeSetOutputSurfaceInfo(@Nullable Surface surface, int i10, int i11) {
        if (this.videoGraph != null) {
            this.videoGraph.setOutputSurfaceInfo(surface != null ? new SurfaceInfo(surface, i10, i11) : null);
            ((VideoFrameReleaseControl) Assertions.checkNotNull(this.videoFrameReleaseControl)).setOutputSurface(surface);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStreamOffsetChange(long j10, long j11) {
        ((VideoFrameRenderControl) Assertions.checkStateNotNull(this.videoFrameRenderControl)).onStreamOffsetChange(j10, j11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListener(VideoSink.Listener listener, Executor executor) {
        if (Objects.equals(listener, this.listener)) {
            Assertions.checkState(Objects.equals(executor, this.listenerExecutor));
        } else {
            this.listener = listener;
            this.listenerExecutor = executor;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlaybackSpeed(float f10) {
        ((VideoFrameRenderControl) Assertions.checkStateNotNull(this.videoFrameRenderControl)).setPlaybackSpeed(f10);
    }

    @Override // androidx.media3.exoplayer.video.VideoSinkProvider
    public void clearOutputSurfaceInfo() {
        Size size = Size.UNKNOWN;
        maybeSetOutputSurfaceInfo(null, size.getWidth(), size.getHeight());
        this.currentSurfaceAndSize = null;
    }

    @Override // androidx.media3.exoplayer.video.VideoFrameRenderControl.FrameRenderer
    public void dropFrame() {
        final VideoSink.Listener listener = this.listener;
        this.listenerExecutor.execute(new Runnable() { // from class: androidx.media3.exoplayer.video.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f1573a.lambda$dropFrame$4(listener);
            }
        });
        ((PreviewingVideoGraph) Assertions.checkStateNotNull(this.videoGraph)).renderOutputFrame(-2L);
    }

    @Nullable
    public Surface getOutputSurface() {
        Pair<Surface, Size> pair = this.currentSurfaceAndSize;
        if (pair != null) {
            return (Surface) pair.first;
        }
        return null;
    }

    @Override // androidx.media3.exoplayer.video.VideoSinkProvider
    public VideoSink getSink() {
        return (VideoSink) Assertions.checkStateNotNull(this.videoSinkImpl);
    }

    @Override // androidx.media3.exoplayer.video.VideoSinkProvider
    @Nullable
    public VideoFrameReleaseControl getVideoFrameReleaseControl() {
        return this.videoFrameReleaseControl;
    }

    @Override // androidx.media3.exoplayer.video.VideoSinkProvider
    public void initialize(Format format) throws VideoSink.VideoSinkException {
        boolean z10 = false;
        Assertions.checkState(this.state == 0);
        Assertions.checkStateNotNull(this.videoEffects);
        if (this.videoFrameRenderControl != null && this.videoFrameReleaseControl != null) {
            z10 = true;
        }
        Assertions.checkState(z10);
        this.handler = this.clock.createHandler((Looper) Assertions.checkStateNotNull(Looper.myLooper()), null);
        ColorInfo adjustedInputColorInfo = getAdjustedInputColorInfo(format.colorInfo);
        ColorInfo colorInfoBuild = adjustedInputColorInfo.colorTransfer == 7 ? adjustedInputColorInfo.buildUpon().setColorTransfer(6).build() : adjustedInputColorInfo;
        try {
            PreviewingVideoGraph.Factory factory = this.previewingVideoGraphFactory;
            Context context = this.context;
            DebugViewProvider debugViewProvider = DebugViewProvider.NONE;
            final HandlerWrapper handlerWrapper = this.handler;
            Objects.requireNonNull(handlerWrapper);
            this.videoGraph = factory.create(context, adjustedInputColorInfo, colorInfoBuild, debugViewProvider, this, new Executor() { // from class: androidx.media3.exoplayer.video.g
                @Override // java.util.concurrent.Executor
                public final void execute(Runnable runnable) {
                    handlerWrapper.post(runnable);
                }
            }, y.q(), 0L);
            Pair<Surface, Size> pair = this.currentSurfaceAndSize;
            if (pair != null) {
                Surface surface = (Surface) pair.first;
                Size size = (Size) pair.second;
                maybeSetOutputSurfaceInfo(surface, size.getWidth(), size.getHeight());
            }
            VideoSinkImpl videoSinkImpl = new VideoSinkImpl(this.context, this, this.videoGraph);
            this.videoSinkImpl = videoSinkImpl;
            videoSinkImpl.setVideoEffects((List) Assertions.checkNotNull(this.videoEffects));
            this.state = 1;
        } catch (VideoFrameProcessingException e10) {
            throw new VideoSink.VideoSinkException(e10, format);
        }
    }

    @Override // androidx.media3.exoplayer.video.VideoSinkProvider
    public boolean isInitialized() {
        return this.state == 1;
    }

    @Override // androidx.media3.common.VideoGraph.Listener
    public void onEnded(long j10) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.media3.common.VideoGraph.Listener
    public void onError(final VideoFrameProcessingException videoFrameProcessingException) {
        final VideoSink.Listener listener = this.listener;
        this.listenerExecutor.execute(new Runnable() { // from class: androidx.media3.exoplayer.video.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f1564a.lambda$onError$1(listener, videoFrameProcessingException);
            }
        });
    }

    @Override // androidx.media3.common.VideoGraph.Listener
    public void onOutputFrameAvailableForRendering(long j10) {
        if (this.pendingFlushCount > 0) {
            return;
        }
        ((VideoFrameRenderControl) Assertions.checkStateNotNull(this.videoFrameRenderControl)).onOutputFrameAvailableForRendering(j10);
    }

    @Override // androidx.media3.common.VideoGraph.Listener
    public void onOutputSizeChanged(int i10, int i11) {
        ((VideoFrameRenderControl) Assertions.checkStateNotNull(this.videoFrameRenderControl)).onOutputSizeChanged(i10, i11);
    }

    @Override // androidx.media3.exoplayer.video.VideoFrameRenderControl.FrameRenderer
    public void onVideoSizeChanged(final VideoSize videoSize) {
        this.outputFormat = new Format.Builder().setWidth(videoSize.width).setHeight(videoSize.height).setSampleMimeType(MimeTypes.VIDEO_RAW).build();
        final VideoSinkImpl videoSinkImpl = (VideoSinkImpl) Assertions.checkStateNotNull(this.videoSinkImpl);
        final VideoSink.Listener listener = this.listener;
        this.listenerExecutor.execute(new Runnable() { // from class: androidx.media3.exoplayer.video.c
            @Override // java.lang.Runnable
            public final void run() {
                listener.onVideoSizeChanged(videoSinkImpl, videoSize);
            }
        });
    }

    @Override // androidx.media3.exoplayer.video.VideoSinkProvider
    public void release() {
        if (this.state == 2) {
            return;
        }
        HandlerWrapper handlerWrapper = this.handler;
        if (handlerWrapper != null) {
            handlerWrapper.removeCallbacksAndMessages(null);
        }
        PreviewingVideoGraph previewingVideoGraph = this.videoGraph;
        if (previewingVideoGraph != null) {
            previewingVideoGraph.release();
        }
        this.currentSurfaceAndSize = null;
        this.state = 2;
    }

    public void render(long j10, long j11) throws ExoPlaybackException {
        if (this.pendingFlushCount == 0) {
            ((VideoFrameRenderControl) Assertions.checkStateNotNull(this.videoFrameRenderControl)).render(j10, j11);
        }
    }

    @Override // androidx.media3.exoplayer.video.VideoFrameRenderControl.FrameRenderer
    public void renderFrame(long j10, long j11, long j12, boolean z10) {
        if (z10 && this.listenerExecutor != NO_OP_EXECUTOR) {
            final VideoSinkImpl videoSinkImpl = (VideoSinkImpl) Assertions.checkStateNotNull(this.videoSinkImpl);
            final VideoSink.Listener listener = this.listener;
            this.listenerExecutor.execute(new Runnable() { // from class: androidx.media3.exoplayer.video.d
                @Override // java.lang.Runnable
                public final void run() {
                    listener.onFirstFrameRendered(videoSinkImpl);
                }
            });
        }
        if (this.videoFrameMetadataListener != null) {
            Format formatBuild = this.outputFormat;
            if (formatBuild == null) {
                formatBuild = new Format.Builder().build();
            }
            this.videoFrameMetadataListener.onVideoFrameAboutToBeRendered(j11 - j12, this.clock.nanoTime(), formatBuild, null);
        }
        ((PreviewingVideoGraph) Assertions.checkStateNotNull(this.videoGraph)).renderOutputFrame(j10);
    }

    @Override // androidx.media3.exoplayer.video.VideoSinkProvider
    public void setClock(Clock clock) {
        Assertions.checkState(!isInitialized());
        this.clock = clock;
    }

    @Override // androidx.media3.exoplayer.video.VideoSinkProvider
    public void setOutputSurfaceInfo(Surface surface, Size size) {
        Pair<Surface, Size> pair = this.currentSurfaceAndSize;
        if (pair != null && ((Surface) pair.first).equals(surface) && ((Size) this.currentSurfaceAndSize.second).equals(size)) {
            return;
        }
        this.currentSurfaceAndSize = Pair.create(surface, size);
        maybeSetOutputSurfaceInfo(surface, size.getWidth(), size.getHeight());
    }

    @Override // androidx.media3.exoplayer.video.VideoSinkProvider
    public void setPendingVideoEffects(List<Effect> list) {
        this.videoEffects = list;
        if (isInitialized()) {
            ((VideoSinkImpl) Assertions.checkStateNotNull(this.videoSinkImpl)).setPendingVideoEffects(list);
        }
    }

    @Override // androidx.media3.exoplayer.video.VideoSinkProvider
    public void setStreamOffsetUs(long j10) {
        ((VideoSinkImpl) Assertions.checkStateNotNull(this.videoSinkImpl)).setStreamOffsetUs(j10);
    }

    @Override // androidx.media3.exoplayer.video.VideoSinkProvider
    public void setVideoEffects(List<Effect> list) {
        this.videoEffects = list;
        if (isInitialized()) {
            ((VideoSinkImpl) Assertions.checkStateNotNull(this.videoSinkImpl)).setVideoEffects(list);
        }
    }

    @Override // androidx.media3.exoplayer.video.VideoSinkProvider
    public void setVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener) {
        this.videoFrameMetadataListener = videoFrameMetadataListener;
    }

    @Override // androidx.media3.exoplayer.video.VideoSinkProvider
    public void setVideoFrameReleaseControl(VideoFrameReleaseControl videoFrameReleaseControl) {
        Assertions.checkState(!isInitialized());
        this.videoFrameReleaseControl = videoFrameReleaseControl;
        this.videoFrameRenderControl = new VideoFrameRenderControl(this, videoFrameReleaseControl);
    }

    private CompositingVideoSinkProvider(Builder builder) {
        this.context = builder.context;
        this.previewingVideoGraphFactory = (PreviewingVideoGraph.Factory) Assertions.checkStateNotNull(builder.previewingVideoGraphFactory);
        this.clock = Clock.DEFAULT;
        this.listener = VideoSink.Listener.NO_OP;
        this.listenerExecutor = NO_OP_EXECUTOR;
        this.state = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$0(Runnable runnable) {
    }
}
