package androidx.media3.exoplayer.video;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import android.view.Display;
import android.view.Surface;
import androidx.annotation.CallSuper;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.C;
import androidx.media3.common.Effect;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.MediaFormatUtil;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.TraceUtil;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import androidx.media3.exoplayer.k2;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import androidx.media3.exoplayer.mediacodec.MediaCodecDecoderException;
import androidx.media3.exoplayer.mediacodec.MediaCodecInfo;
import androidx.media3.exoplayer.mediacodec.MediaCodecRenderer;
import androidx.media3.exoplayer.mediacodec.MediaCodecSelector;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import androidx.media3.exoplayer.video.CompositingVideoSinkProvider;
import androidx.media3.exoplayer.video.VideoFrameReleaseControl;
import androidx.media3.exoplayer.video.VideoRendererEventListener;
import androidx.media3.exoplayer.video.VideoSink;
import androidx.media3.extractor.ts.TsExtractor;
import com.google.android.gms.common.Scopes;
import com.google.common.collect.y;
import com.ironsource.v8;
import io.sentry.protocol.ViewHierarchyNode;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@UnstableApi
public class MediaCodecVideoRenderer extends MediaCodecRenderer implements VideoFrameReleaseControl.FrameTimingEvaluator {
    private static final int HEVC_MAX_INPUT_SIZE_THRESHOLD = 2097152;
    private static final float INITIAL_FORMAT_MAX_INPUT_SIZE_SCALE_FACTOR = 1.5f;
    private static final String KEY_CROP_BOTTOM = "crop-bottom";
    private static final String KEY_CROP_LEFT = "crop-left";
    private static final String KEY_CROP_RIGHT = "crop-right";
    private static final String KEY_CROP_TOP = "crop-top";
    private static final long MIN_EARLY_US_LATE_THRESHOLD = -30000;
    private static final long MIN_EARLY_US_VERY_LATE_THRESHOLD = -500000;
    private static final int[] STANDARD_LONG_EDGE_VIDEO_PX = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private static final String TAG = "MediaCodecVideoRenderer";
    private static final long TUNNELING_EOS_PRESENTATION_TIME_US = Long.MAX_VALUE;
    private static boolean deviceNeedsSetOutputSurfaceWorkaround;
    private static boolean evaluatedDeviceNeedsSetOutputSurfaceWorkaround;
    private int buffersInCodecCount;
    private boolean codecHandlesHdr10PlusOutOfBandMetadata;
    private CodecMaxValues codecMaxValues;
    private boolean codecNeedsSetOutputSurfaceWorkaround;
    private int consecutiveDroppedFrameCount;
    private final Context context;
    private VideoSize decodedVideoSize;
    private final boolean deviceNeedsNoPostProcessWorkaround;

    @Nullable
    private Surface displaySurface;
    private long droppedFrameAccumulationStartTimeMs;
    private int droppedFrames;
    private final VideoRendererEventListener.EventDispatcher eventDispatcher;

    @Nullable
    private VideoFrameMetadataListener frameMetadataListener;
    private boolean hasEffects;
    private boolean hasInitializedPlayback;
    private boolean haveReportedFirstFrameRenderedForCurrentSurface;
    private long lastFrameReleaseTimeNs;
    private final int maxDroppedFramesToNotify;

    @Nullable
    private Size outputResolution;

    @Nullable
    private PlaceholderSurface placeholderSurface;

    @Nullable
    private VideoSize reportedVideoSize;
    private int scalingMode;
    private long totalVideoFrameProcessingOffsetUs;
    private boolean tunneling;
    private int tunnelingAudioSessionId;

    @Nullable
    OnFrameRenderedListenerV23 tunnelingOnFrameRenderedListener;
    private int videoFrameProcessingOffsetCount;
    private final VideoFrameReleaseControl videoFrameReleaseControl;
    private final VideoFrameReleaseControl.FrameReleaseInfo videoFrameReleaseInfo;

    @Nullable
    private VideoSink videoSink;
    private final VideoSinkProvider videoSinkProvider;

    @RequiresApi(26)
    private static final class Api26 {
        private Api26() {
        }

        @DoNotInline
        public static boolean doesDisplaySupportDolbyVision(Context context) {
            DisplayManager displayManager = (DisplayManager) context.getSystemService(v8.h.f15785d);
            Display display = displayManager != null ? displayManager.getDisplay(0) : null;
            if (display == null || !display.isHdr()) {
                return false;
            }
            for (int i10 : display.getHdrCapabilities().getSupportedHdrTypes()) {
                if (i10 == 1) {
                    return true;
                }
            }
            return false;
        }
    }

    protected static final class CodecMaxValues {
        public final int height;
        public final int inputSize;
        public final int width;

        public CodecMaxValues(int i10, int i11, int i12) {
            this.width = i10;
            this.height = i11;
            this.inputSize = i12;
        }
    }

    @RequiresApi(23)
    private final class OnFrameRenderedListenerV23 implements MediaCodecAdapter.OnFrameRenderedListener, Handler.Callback {
        private static final int HANDLE_FRAME_RENDERED = 0;
        private final Handler handler;

        public OnFrameRenderedListenerV23(MediaCodecAdapter mediaCodecAdapter) {
            Handler handlerCreateHandlerForCurrentLooper = Util.createHandlerForCurrentLooper(this);
            this.handler = handlerCreateHandlerForCurrentLooper;
            mediaCodecAdapter.setOnFrameRenderedListener(this, handlerCreateHandlerForCurrentLooper);
        }

        private void handleFrameRendered(long j10) {
            MediaCodecVideoRenderer mediaCodecVideoRenderer = MediaCodecVideoRenderer.this;
            if (this != mediaCodecVideoRenderer.tunnelingOnFrameRenderedListener || mediaCodecVideoRenderer.getCodec() == null) {
                return;
            }
            if (j10 == Long.MAX_VALUE) {
                MediaCodecVideoRenderer.this.onProcessedTunneledEndOfStream();
                return;
            }
            try {
                MediaCodecVideoRenderer.this.onProcessedTunneledBuffer(j10);
            } catch (ExoPlaybackException e10) {
                MediaCodecVideoRenderer.this.setPendingPlaybackException(e10);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            handleFrameRendered(Util.toLong(message.arg1, message.arg2));
            return true;
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter.OnFrameRenderedListener
        public void onFrameRendered(MediaCodecAdapter mediaCodecAdapter, long j10, long j11) {
            if (Util.SDK_INT >= 30) {
                handleFrameRendered(j10);
            } else {
                this.handler.sendMessageAtFrontOfQueue(Message.obtain(this.handler, 0, (int) (j10 >> 32), (int) j10));
            }
        }
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector) {
        this(context, mediaCodecSelector, 0L);
    }

    private static boolean codecAppliesRotation() {
        return Util.SDK_INT >= 21;
    }

    @RequiresApi(21)
    private static void configureTunnelingV21(MediaFormat mediaFormat, int i10) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i10);
    }

    private static boolean deviceNeedsNoPostProcessWorkaround() {
        return "NVIDIA".equals(Util.MANUFACTURER);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static boolean evaluateDeviceNeedsSetOutputSurfaceWorkaround() {
        String str;
        int i10 = Util.SDK_INT;
        byte b10 = 7;
        if (i10 <= 28) {
            String str2 = Util.DEVICE;
            str2.hashCode();
            switch (str2) {
            }
            return true;
        }
        if (i10 <= 27 && "HWEML".equals(Util.DEVICE)) {
            return true;
        }
        str = Util.MODEL;
        str.hashCode();
        switch (str) {
            case "AFTJMST12":
            case "AFTKMST12":
            case "AFTA":
            case "AFTN":
            case "AFTR":
            case "AFTEU011":
            case "AFTEU014":
            case "AFTSO001":
            case "AFTEUFF014":
                break;
            default:
                if (i10 <= 26) {
                    String str3 = Util.DEVICE;
                    str3.hashCode();
                    switch (str3.hashCode()) {
                        case -2144781245:
                            b10 = !str3.equals("GIONEE_SWW1609") ? (byte) -1 : (byte) 0;
                            break;
                        case -2144781185:
                            b10 = !str3.equals("GIONEE_SWW1627") ? (byte) -1 : (byte) 1;
                            break;
                        case -2144781160:
                            b10 = !str3.equals("GIONEE_SWW1631") ? (byte) -1 : (byte) 2;
                            break;
                        case -2097309513:
                            b10 = !str3.equals("K50a40") ? (byte) -1 : (byte) 3;
                            break;
                        case -2022874474:
                            b10 = !str3.equals("CP8676_I02") ? (byte) -1 : (byte) 4;
                            break;
                        case -1978993182:
                            b10 = !str3.equals("NX541J") ? (byte) -1 : (byte) 5;
                            break;
                        case -1978990237:
                            b10 = !str3.equals("NX573J") ? (byte) -1 : (byte) 6;
                            break;
                        case -1936688988:
                            if (!str3.equals("PGN528")) {
                                b10 = -1;
                            }
                            break;
                        case -1936688066:
                            b10 = !str3.equals("PGN610") ? (byte) -1 : (byte) 8;
                            break;
                        case -1936688065:
                            b10 = !str3.equals("PGN611") ? (byte) -1 : (byte) 9;
                            break;
                        case -1931988508:
                            b10 = !str3.equals("AquaPowerM") ? (byte) -1 : (byte) 10;
                            break;
                        case -1885099851:
                            b10 = !str3.equals("RAIJIN") ? (byte) -1 : (byte) 11;
                            break;
                        case -1696512866:
                            b10 = !str3.equals("XT1663") ? (byte) -1 : (byte) 12;
                            break;
                        case -1680025915:
                            b10 = !str3.equals("ComioS1") ? (byte) -1 : (byte) 13;
                            break;
                        case -1615810839:
                            b10 = !str3.equals("Phantom6") ? (byte) -1 : (byte) 14;
                            break;
                        case -1600724499:
                            b10 = !str3.equals("pacificrim") ? (byte) -1 : (byte) 15;
                            break;
                        case -1554255044:
                            b10 = !str3.equals("vernee_M5") ? (byte) -1 : (byte) 16;
                            break;
                        case -1481772737:
                            b10 = !str3.equals("panell_dl") ? (byte) -1 : (byte) 17;
                            break;
                        case -1481772730:
                            b10 = !str3.equals("panell_ds") ? (byte) -1 : (byte) 18;
                            break;
                        case -1481772729:
                            b10 = !str3.equals("panell_dt") ? (byte) -1 : (byte) 19;
                            break;
                        case -1320080169:
                            b10 = !str3.equals("GiONEE_GBL7319") ? (byte) -1 : (byte) 20;
                            break;
                        case -1217592143:
                            b10 = !str3.equals("BRAVIA_ATV2") ? (byte) -1 : (byte) 21;
                            break;
                        case -1180384755:
                            b10 = !str3.equals("iris60") ? (byte) -1 : (byte) 22;
                            break;
                        case -1139198265:
                            b10 = !str3.equals("Slate_Pro") ? (byte) -1 : (byte) 23;
                            break;
                        case -1052835013:
                            b10 = !str3.equals("namath") ? (byte) -1 : (byte) 24;
                            break;
                        case -993250464:
                            b10 = !str3.equals("A10-70F") ? (byte) -1 : (byte) 25;
                            break;
                        case -993250458:
                            b10 = !str3.equals("A10-70L") ? (byte) -1 : (byte) 26;
                            break;
                        case -965403638:
                            b10 = !str3.equals("s905x018") ? (byte) -1 : (byte) 27;
                            break;
                        case -958336948:
                            b10 = !str3.equals("ELUGA_Ray_X") ? (byte) -1 : (byte) 28;
                            break;
                        case -879245230:
                            b10 = !str3.equals("tcl_eu") ? (byte) -1 : (byte) 29;
                            break;
                        case -842500323:
                            b10 = !str3.equals("nicklaus_f") ? (byte) -1 : (byte) 30;
                            break;
                        case -821392978:
                            b10 = !str3.equals("A7000-a") ? (byte) -1 : (byte) 31;
                            break;
                        case -797483286:
                            b10 = !str3.equals("SVP-DTV15") ? (byte) -1 : (byte) 32;
                            break;
                        case -794946968:
                            b10 = !str3.equals("watson") ? (byte) -1 : (byte) 33;
                            break;
                        case -788334647:
                            b10 = !str3.equals("whyred") ? (byte) -1 : (byte) 34;
                            break;
                        case -782144577:
                            b10 = !str3.equals("OnePlus5T") ? (byte) -1 : (byte) 35;
                            break;
                        case -575125681:
                            b10 = !str3.equals("GiONEE_CBL7513") ? (byte) -1 : (byte) 36;
                            break;
                        case -521118391:
                            b10 = !str3.equals("GIONEE_GBL7360") ? (byte) -1 : (byte) 37;
                            break;
                        case -430914369:
                            b10 = !str3.equals("Pixi4-7_3G") ? (byte) -1 : (byte) 38;
                            break;
                        case -290434366:
                            b10 = !str3.equals("taido_row") ? (byte) -1 : (byte) 39;
                            break;
                        case -282781963:
                            b10 = !str3.equals("BLACK-1X") ? (byte) -1 : (byte) 40;
                            break;
                        case -277133239:
                            b10 = !str3.equals("Z12_PRO") ? (byte) -1 : (byte) 41;
                            break;
                        case -173639913:
                            b10 = !str3.equals("ELUGA_A3_Pro") ? (byte) -1 : (byte) 42;
                            break;
                        case -56598463:
                            b10 = !str3.equals("woods_fn") ? (byte) -1 : (byte) 43;
                            break;
                        case 2126:
                            b10 = !str3.equals("C1") ? (byte) -1 : (byte) 44;
                            break;
                        case 2564:
                            b10 = !str3.equals("Q5") ? (byte) -1 : (byte) 45;
                            break;
                        case 2715:
                            b10 = !str3.equals("V1") ? (byte) -1 : (byte) 46;
                            break;
                        case 2719:
                            b10 = !str3.equals("V5") ? (byte) -1 : (byte) 47;
                            break;
                        case 3091:
                            b10 = !str3.equals("b5") ? (byte) -1 : (byte) 48;
                            break;
                        case 3483:
                            b10 = !str3.equals("mh") ? (byte) -1 : (byte) 49;
                            break;
                        case 73405:
                            b10 = !str3.equals("JGZ") ? (byte) -1 : (byte) 50;
                            break;
                        case 75537:
                            b10 = !str3.equals("M04") ? (byte) -1 : (byte) 51;
                            break;
                        case 75739:
                            b10 = !str3.equals("M5c") ? (byte) -1 : (byte) 52;
                            break;
                        case 76779:
                            b10 = !str3.equals("MX6") ? (byte) -1 : (byte) 53;
                            break;
                        case 78669:
                            b10 = !str3.equals("P85") ? (byte) -1 : (byte) 54;
                            break;
                        case 79305:
                            b10 = !str3.equals("PLE") ? (byte) -1 : (byte) 55;
                            break;
                        case 80618:
                            b10 = !str3.equals("QX1") ? (byte) -1 : (byte) 56;
                            break;
                        case 88274:
                            b10 = !str3.equals("Z80") ? (byte) -1 : (byte) 57;
                            break;
                        case 98846:
                            b10 = !str3.equals("cv1") ? (byte) -1 : (byte) 58;
                            break;
                        case 98848:
                            b10 = !str3.equals("cv3") ? (byte) -1 : (byte) 59;
                            break;
                        case 99329:
                            b10 = !str3.equals("deb") ? (byte) -1 : (byte) 60;
                            break;
                        case 101481:
                            b10 = !str3.equals("flo") ? (byte) -1 : (byte) 61;
                            break;
                        case 1513190:
                            b10 = !str3.equals("1601") ? (byte) -1 : (byte) 62;
                            break;
                        case 1514184:
                            b10 = !str3.equals("1713") ? (byte) -1 : (byte) 63;
                            break;
                        case 1514185:
                            b10 = !str3.equals("1714") ? (byte) -1 : (byte) 64;
                            break;
                        case 2133089:
                            b10 = !str3.equals("F01H") ? (byte) -1 : (byte) 65;
                            break;
                        case 2133091:
                            b10 = !str3.equals("F01J") ? (byte) -1 : (byte) 66;
                            break;
                        case 2133120:
                            b10 = !str3.equals("F02H") ? (byte) -1 : (byte) 67;
                            break;
                        case 2133151:
                            b10 = !str3.equals("F03H") ? (byte) -1 : (byte) 68;
                            break;
                        case 2133182:
                            b10 = !str3.equals("F04H") ? (byte) -1 : (byte) 69;
                            break;
                        case 2133184:
                            b10 = !str3.equals("F04J") ? (byte) -1 : (byte) 70;
                            break;
                        case 2436959:
                            b10 = !str3.equals("P681") ? (byte) -1 : (byte) 71;
                            break;
                        case 2463773:
                            b10 = !str3.equals("Q350") ? (byte) -1 : (byte) 72;
                            break;
                        case 2464648:
                            b10 = !str3.equals("Q427") ? (byte) -1 : (byte) 73;
                            break;
                        case 2689555:
                            b10 = !str3.equals("XE2X") ? (byte) -1 : (byte) 74;
                            break;
                        case 3154429:
                            b10 = !str3.equals("fugu") ? (byte) -1 : (byte) 75;
                            break;
                        case 3284551:
                            b10 = !str3.equals("kate") ? (byte) -1 : (byte) 76;
                            break;
                        case 3351335:
                            b10 = !str3.equals("mido") ? (byte) -1 : (byte) 77;
                            break;
                        case 3386211:
                            b10 = !str3.equals("p212") ? (byte) -1 : (byte) 78;
                            break;
                        case 41325051:
                            b10 = !str3.equals("MEIZU_M5") ? (byte) -1 : (byte) 79;
                            break;
                        case 51349633:
                            b10 = !str3.equals("601LV") ? (byte) -1 : (byte) 80;
                            break;
                        case 51350594:
                            b10 = !str3.equals("602LV") ? (byte) -1 : (byte) 81;
                            break;
                        case 55178625:
                            b10 = !str3.equals("Aura_Note_2") ? (byte) -1 : (byte) 82;
                            break;
                        case 61542055:
                            b10 = !str3.equals("A1601") ? (byte) -1 : (byte) 83;
                            break;
                        case 65355429:
                            b10 = !str3.equals("E5643") ? (byte) -1 : (byte) 84;
                            break;
                        case 66214468:
                            b10 = !str3.equals("F3111") ? (byte) -1 : (byte) 85;
                            break;
                        case 66214470:
                            b10 = !str3.equals("F3113") ? (byte) -1 : (byte) 86;
                            break;
                        case 66214473:
                            b10 = !str3.equals("F3116") ? (byte) -1 : (byte) 87;
                            break;
                        case 66215429:
                            b10 = !str3.equals("F3211") ? (byte) -1 : (byte) 88;
                            break;
                        case 66215431:
                            b10 = !str3.equals("F3213") ? (byte) -1 : (byte) 89;
                            break;
                        case 66215433:
                            b10 = !str3.equals("F3215") ? (byte) -1 : (byte) 90;
                            break;
                        case 66216390:
                            b10 = !str3.equals("F3311") ? (byte) -1 : (byte) 91;
                            break;
                        case 76402249:
                            b10 = !str3.equals("PRO7S") ? (byte) -1 : (byte) 92;
                            break;
                        case 76404105:
                            b10 = !str3.equals("Q4260") ? (byte) -1 : (byte) 93;
                            break;
                        case 76404911:
                            b10 = !str3.equals("Q4310") ? (byte) -1 : (byte) 94;
                            break;
                        case 80963634:
                            b10 = !str3.equals("V23GB") ? (byte) -1 : (byte) 95;
                            break;
                        case 82882791:
                            b10 = !str3.equals("X3_HK") ? (byte) -1 : (byte) 96;
                            break;
                        case 98715550:
                            b10 = !str3.equals("i9031") ? (byte) -1 : (byte) 97;
                            break;
                        case 101370885:
                            b10 = !str3.equals("l5460") ? (byte) -1 : (byte) 98;
                            break;
                        case 102844228:
                            b10 = !str3.equals("le_x6") ? (byte) -1 : (byte) 99;
                            break;
                        case 165221241:
                            b10 = !str3.equals("A2016a40") ? (byte) -1 : (byte) 100;
                            break;
                        case 182191441:
                            b10 = !str3.equals("CPY83_I00") ? (byte) -1 : (byte) 101;
                            break;
                        case 245388979:
                            b10 = !str3.equals("marino_f") ? (byte) -1 : (byte) 102;
                            break;
                        case 287431619:
                            b10 = !str3.equals("griffin") ? (byte) -1 : (byte) 103;
                            break;
                        case 307593612:
                            b10 = !str3.equals("A7010a48") ? (byte) -1 : (byte) 104;
                            break;
                        case 308517133:
                            b10 = !str3.equals("A7020a48") ? (byte) -1 : (byte) 105;
                            break;
                        case 316215098:
                            b10 = !str3.equals("TB3-730F") ? (byte) -1 : (byte) 106;
                            break;
                        case 316215116:
                            b10 = !str3.equals("TB3-730X") ? (byte) -1 : (byte) 107;
                            break;
                        case 316246811:
                            b10 = !str3.equals("TB3-850F") ? (byte) -1 : (byte) 108;
                            break;
                        case 316246818:
                            b10 = !str3.equals("TB3-850M") ? (byte) -1 : (byte) 109;
                            break;
                        case 407160593:
                            b10 = !str3.equals("Pixi5-10_4G") ? (byte) -1 : (byte) 110;
                            break;
                        case 507412548:
                            b10 = !str3.equals("QM16XE_U") ? (byte) -1 : (byte) 111;
                            break;
                        case 793982701:
                            b10 = !str3.equals("GIONEE_WBL5708") ? (byte) -1 : (byte) 112;
                            break;
                        case 794038622:
                            b10 = !str3.equals("GIONEE_WBL7365") ? (byte) -1 : (byte) 113;
                            break;
                        case 794040393:
                            b10 = !str3.equals("GIONEE_WBL7519") ? (byte) -1 : (byte) 114;
                            break;
                        case 835649806:
                            b10 = !str3.equals("manning") ? (byte) -1 : (byte) 115;
                            break;
                        case 917340916:
                            b10 = !str3.equals("A7000plus") ? (byte) -1 : (byte) 116;
                            break;
                        case 958008161:
                            b10 = !str3.equals("j2xlteins") ? (byte) -1 : (byte) 117;
                            break;
                        case 1060579533:
                            b10 = !str3.equals("panell_d") ? (byte) -1 : (byte) 118;
                            break;
                        case 1150207623:
                            b10 = !str3.equals("LS-5017") ? (byte) -1 : (byte) 119;
                            break;
                        case 1176899427:
                            b10 = !str3.equals("itel_S41") ? (byte) -1 : (byte) 120;
                            break;
                        case 1280332038:
                            b10 = !str3.equals("hwALE-H") ? (byte) -1 : (byte) 121;
                            break;
                        case 1306947716:
                            b10 = !str3.equals("EverStar_S") ? (byte) -1 : (byte) 122;
                            break;
                        case 1349174697:
                            b10 = !str3.equals("htc_e56ml_dtul") ? (byte) -1 : (byte) 123;
                            break;
                        case 1522194893:
                            b10 = !str3.equals("woods_f") ? (byte) -1 : (byte) 124;
                            break;
                        case 1691543273:
                            b10 = !str3.equals("CPH1609") ? (byte) -1 : (byte) 125;
                            break;
                        case 1691544261:
                            b10 = !str3.equals("CPH1715") ? (byte) -1 : (byte) 126;
                            break;
                        case 1709443163:
                            b10 = !str3.equals("iball8735_9806") ? (byte) -1 : (byte) 127;
                            break;
                        case 1865889110:
                            b10 = !str3.equals("santoni") ? (byte) -1 : (byte) 128;
                            break;
                        case 1906253259:
                            b10 = !str3.equals("PB2-670M") ? (byte) -1 : (byte) 129;
                            break;
                        case 1977196784:
                            b10 = !str3.equals("Infinix-X572") ? (byte) -1 : (byte) 130;
                            break;
                        case 2006372676:
                            b10 = !str3.equals("BRAVIA_ATV3_4K") ? (byte) -1 : (byte) 131;
                            break;
                        case 2019281702:
                            b10 = !str3.equals("DM-01K") ? (byte) -1 : (byte) 132;
                            break;
                        case 2029784656:
                            b10 = !str3.equals("HWBLN-H") ? (byte) -1 : (byte) 133;
                            break;
                        case 2030379515:
                            b10 = !str3.equals("HWCAM-H") ? (byte) -1 : (byte) 134;
                            break;
                        case 2033393791:
                            b10 = !str3.equals("ASUS_X00AD_2") ? (byte) -1 : (byte) 135;
                            break;
                        case 2047190025:
                            b10 = !str3.equals("ELUGA_Note") ? (byte) -1 : (byte) 136;
                            break;
                        case 2047252157:
                            b10 = !str3.equals("ELUGA_Prim") ? (byte) -1 : (byte) 137;
                            break;
                        case 2048319463:
                            b10 = !str3.equals("HWVNS-H") ? (byte) -1 : (byte) 138;
                            break;
                        case 2048855701:
                            b10 = !str3.equals("HWWAS-H") ? (byte) -1 : (byte) 139;
                            break;
                        default:
                            b10 = -1;
                            break;
                    }
                    switch (b10) {
                        default:
                            str.hashCode();
                            if (!str.equals("JSN-L21")) {
                            }
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case 40:
                        case 41:
                        case 42:
                        case 43:
                        case 44:
                        case 45:
                        case 46:
                        case 47:
                        case 48:
                        case 49:
                        case 50:
                        case 51:
                        case 52:
                        case 53:
                        case 54:
                        case 55:
                        case 56:
                        case 57:
                        case 58:
                        case 59:
                        case 60:
                        case 61:
                        case 62:
                        case 63:
                        case 64:
                        case 65:
                        case 66:
                        case 67:
                        case 68:
                        case 69:
                        case 70:
                        case 71:
                        case 72:
                        case 73:
                        case 74:
                        case 75:
                        case 76:
                        case 77:
                        case 78:
                        case 79:
                        case 80:
                        case 81:
                        case 82:
                        case 83:
                        case 84:
                        case 85:
                        case 86:
                        case 87:
                        case 88:
                        case 89:
                        case 90:
                        case 91:
                        case 92:
                        case 93:
                        case 94:
                        case 95:
                        case 96:
                        case 97:
                        case 98:
                        case 99:
                        case 100:
                        case 101:
                        case 102:
                        case 103:
                        case 104:
                        case 105:
                        case 106:
                        case 107:
                        case 108:
                        case 109:
                        case 110:
                        case 111:
                        case 112:
                        case 113:
                        case 114:
                        case 115:
                        case 116:
                        case 117:
                        case 118:
                        case 119:
                        case 120:
                        case 121:
                        case 122:
                        case 123:
                        case 124:
                        case 125:
                        case 126:
                        case 127:
                        case 128:
                        case 129:
                        case 130:
                        case 131:
                        case 132:
                        case 133:
                        case 134:
                        case 135:
                        case 136:
                        case 137:
                        case 138:
                        case TsExtractor.TS_STREAM_TYPE_DTS_UHD /* 139 */:
                            return true;
                    }
                }
                break;
        }
        return true;
    }

    public static int getCodecMaxInputSize(MediaCodecInfo mediaCodecInfo, Format format) {
        int iIntValue;
        int i10 = format.width;
        int i11 = format.height;
        if (i10 == -1 || i11 == -1) {
            return -1;
        }
        String str = (String) Assertions.checkNotNull(format.sampleMimeType);
        if (MimeTypes.VIDEO_DOLBY_VISION.equals(str)) {
            Pair<Integer, Integer> codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(format);
            str = (codecProfileAndLevel == null || !((iIntValue = ((Integer) codecProfileAndLevel.first).intValue()) == 512 || iIntValue == 1 || iIntValue == 2)) ? "video/hevc" : "video/avc";
        }
        str.hashCode();
        switch (str) {
            case "video/3gpp":
            case "video/av01":
            case "video/mp4v-es":
            case "video/x-vnd.on2.vp8":
                return getMaxSampleSize(i10 * i11, 2);
            case "video/hevc":
                return Math.max(2097152, getMaxSampleSize(i10 * i11, 2));
            case "video/avc":
                String str2 = Util.MODEL;
                if ("BRAVIA 4K 2015".equals(str2) || ("Amazon".equals(Util.MANUFACTURER) && ("KFSOWI".equals(str2) || ("AFTS".equals(str2) && mediaCodecInfo.secure)))) {
                    return -1;
                }
                return getMaxSampleSize(Util.ceilDivide(i10, 16) * Util.ceilDivide(i11, 16) * 16 * 16, 2);
            case "video/x-vnd.on2.vp9":
                return getMaxSampleSize(i10 * i11, 4);
            default:
                return -1;
        }
    }

    @Nullable
    private static Point getCodecMaxSize(MediaCodecInfo mediaCodecInfo, Format format) {
        int i10 = format.height;
        int i11 = format.width;
        boolean z10 = i10 > i11;
        int i12 = z10 ? i10 : i11;
        if (z10) {
            i10 = i11;
        }
        float f10 = i10 / i12;
        for (int i13 : STANDARD_LONG_EDGE_VIDEO_PX) {
            int i14 = (int) (i13 * f10);
            if (i13 <= i12 || i14 <= i10) {
                break;
            }
            if (Util.SDK_INT >= 21) {
                int i15 = z10 ? i14 : i13;
                if (!z10) {
                    i13 = i14;
                }
                Point pointAlignVideoSizeV21 = mediaCodecInfo.alignVideoSizeV21(i15, i13);
                float f11 = format.frameRate;
                if (pointAlignVideoSizeV21 != null && mediaCodecInfo.isVideoSizeAndRateSupportedV21(pointAlignVideoSizeV21.x, pointAlignVideoSizeV21.y, f11)) {
                    return pointAlignVideoSizeV21;
                }
            } else {
                try {
                    int iCeilDivide = Util.ceilDivide(i13, 16) * 16;
                    int iCeilDivide2 = Util.ceilDivide(i14, 16) * 16;
                    if (iCeilDivide * iCeilDivide2 <= MediaCodecUtil.maxH264DecodableFrameSize()) {
                        int i16 = z10 ? iCeilDivide2 : iCeilDivide;
                        if (!z10) {
                            iCeilDivide = iCeilDivide2;
                        }
                        return new Point(i16, iCeilDivide);
                    }
                } catch (MediaCodecUtil.DecoderQueryException unused) {
                }
            }
        }
        return null;
    }

    protected static int getMaxInputSize(MediaCodecInfo mediaCodecInfo, Format format) {
        if (format.maxInputSize == -1) {
            return getCodecMaxInputSize(mediaCodecInfo, format);
        }
        int size = format.initializationData.size();
        int length = 0;
        for (int i10 = 0; i10 < size; i10++) {
            length += format.initializationData.get(i10).length;
        }
        return format.maxInputSize + length;
    }

    private static int getMaxSampleSize(int i10, int i11) {
        return (i10 * 3) / (i11 * 2);
    }

    private void maybeNotifyDroppedFrames() {
        if (this.droppedFrames > 0) {
            long jElapsedRealtime = getClock().elapsedRealtime();
            this.eventDispatcher.droppedFrames(this.droppedFrames, jElapsedRealtime - this.droppedFrameAccumulationStartTimeMs);
            this.droppedFrames = 0;
            this.droppedFrameAccumulationStartTimeMs = jElapsedRealtime;
        }
    }

    private void maybeNotifyRenderedFirstFrame() {
        if (!this.videoFrameReleaseControl.onFrameReleasedIsFirstFrame() || this.displaySurface == null) {
            return;
        }
        notifyRenderedFirstFrame();
    }

    private void maybeNotifyVideoFrameProcessingOffset() {
        int i10 = this.videoFrameProcessingOffsetCount;
        if (i10 != 0) {
            this.eventDispatcher.reportVideoFrameProcessingOffset(this.totalVideoFrameProcessingOffsetUs, i10);
            this.totalVideoFrameProcessingOffsetUs = 0L;
            this.videoFrameProcessingOffsetCount = 0;
        }
    }

    private void maybeNotifyVideoSizeChanged(VideoSize videoSize) {
        if (videoSize.equals(VideoSize.UNKNOWN) || videoSize.equals(this.reportedVideoSize)) {
            return;
        }
        this.reportedVideoSize = videoSize;
        this.eventDispatcher.videoSizeChanged(videoSize);
    }

    private boolean maybeReleaseFrame(MediaCodecAdapter mediaCodecAdapter, int i10, long j10, Format format) {
        long releaseTimeNs = this.videoFrameReleaseInfo.getReleaseTimeNs();
        long earlyUs = this.videoFrameReleaseInfo.getEarlyUs();
        if (Util.SDK_INT >= 21) {
            if (shouldSkipBuffersWithIdenticalReleaseTime() && releaseTimeNs == this.lastFrameReleaseTimeNs) {
                skipOutputBuffer(mediaCodecAdapter, i10, j10);
            } else {
                notifyFrameMetadataListener(j10, releaseTimeNs, format);
                renderOutputBufferV21(mediaCodecAdapter, i10, j10, releaseTimeNs);
            }
            updateVideoFrameProcessingOffsetCounters(earlyUs);
            this.lastFrameReleaseTimeNs = releaseTimeNs;
            return true;
        }
        if (earlyUs >= 30000) {
            return false;
        }
        if (earlyUs > 11000) {
            try {
                Thread.sleep((earlyUs - 10000) / 1000);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return false;
            }
        }
        notifyFrameMetadataListener(j10, releaseTimeNs, format);
        renderOutputBuffer(mediaCodecAdapter, i10, j10);
        updateVideoFrameProcessingOffsetCounters(earlyUs);
        return true;
    }

    private void maybeRenotifyRenderedFirstFrame() {
        Surface surface = this.displaySurface;
        if (surface == null || !this.haveReportedFirstFrameRenderedForCurrentSurface) {
            return;
        }
        this.eventDispatcher.renderedFirstFrame(surface);
    }

    private void maybeRenotifyVideoSizeChanged() {
        VideoSize videoSize = this.reportedVideoSize;
        if (videoSize != null) {
            this.eventDispatcher.videoSizeChanged(videoSize);
        }
    }

    private void maybeSetKeyAllowFrameDrop(MediaFormat mediaFormat) {
        VideoSink videoSink = this.videoSink;
        if (videoSink == null || videoSink.isFrameDropAllowedOnInput()) {
            return;
        }
        mediaFormat.setInteger("allow-frame-drop", 0);
    }

    private void maybeUpdateOnFrameRenderedListener() {
        MediaCodecAdapter codec;
        if (Util.SDK_INT < 23 || !this.tunneling || (codec = getCodec()) == null) {
            return;
        }
        this.tunnelingOnFrameRenderedListener = new OnFrameRenderedListenerV23(codec);
    }

    private void notifyFrameMetadataListener(long j10, long j11, Format format) {
        VideoFrameMetadataListener videoFrameMetadataListener = this.frameMetadataListener;
        if (videoFrameMetadataListener != null) {
            videoFrameMetadataListener.onVideoFrameAboutToBeRendered(j10, j11, format, getCodecOutputMediaFormat());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRenderedFirstFrame() {
        this.eventDispatcher.renderedFirstFrame(this.displaySurface);
        this.haveReportedFirstFrameRenderedForCurrentSurface = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onProcessedTunneledEndOfStream() {
        setPendingOutputEndOfStream();
    }

    @RequiresApi(17)
    private void releasePlaceholderSurface() {
        Surface surface = this.displaySurface;
        PlaceholderSurface placeholderSurface = this.placeholderSurface;
        if (surface == placeholderSurface) {
            this.displaySurface = null;
        }
        if (placeholderSurface != null) {
            placeholderSurface.release();
            this.placeholderSurface = null;
        }
    }

    private void renderOutputBuffer(MediaCodecAdapter mediaCodecAdapter, int i10, long j10, long j11) {
        if (Util.SDK_INT >= 21) {
            renderOutputBufferV21(mediaCodecAdapter, i10, j10, j11);
        } else {
            renderOutputBuffer(mediaCodecAdapter, i10, j10);
        }
    }

    @RequiresApi(29)
    private static void setHdr10PlusInfoV29(MediaCodecAdapter mediaCodecAdapter, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("hdr10-plus-info", bArr);
        mediaCodecAdapter.setParameters(bundle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [androidx.media3.exoplayer.video.VideoFrameReleaseControl] */
    /* JADX WARN: Type inference failed for: r0v8, types: [androidx.media3.exoplayer.video.VideoSinkProvider] */
    /* JADX WARN: Type inference failed for: r5v0, types: [androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.video.MediaCodecVideoRenderer] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [android.view.Surface] */
    /* JADX WARN: Type inference failed for: r6v8, types: [androidx.media3.exoplayer.video.PlaceholderSurface] */
    /* JADX WARN: Type inference failed for: r6v9 */
    private void setOutput(@Nullable Object obj) throws ExoPlaybackException {
        ?? NewInstanceV17 = obj instanceof Surface ? (Surface) obj : 0;
        if (NewInstanceV17 == 0) {
            PlaceholderSurface placeholderSurface = this.placeholderSurface;
            if (placeholderSurface != null) {
                NewInstanceV17 = placeholderSurface;
            } else {
                MediaCodecInfo codecInfo = getCodecInfo();
                if (codecInfo != null && shouldUsePlaceholderSurface(codecInfo)) {
                    NewInstanceV17 = PlaceholderSurface.newInstanceV17(this.context, codecInfo.secure);
                    this.placeholderSurface = NewInstanceV17;
                }
            }
        }
        if (this.displaySurface == NewInstanceV17) {
            if (NewInstanceV17 == 0 || NewInstanceV17 == this.placeholderSurface) {
                return;
            }
            maybeRenotifyVideoSizeChanged();
            maybeRenotifyRenderedFirstFrame();
            return;
        }
        this.displaySurface = NewInstanceV17;
        this.videoFrameReleaseControl.setOutputSurface(NewInstanceV17);
        this.haveReportedFirstFrameRenderedForCurrentSurface = false;
        int state = getState();
        MediaCodecAdapter codec = getCodec();
        if (codec != null && !this.videoSinkProvider.isInitialized()) {
            if (Util.SDK_INT < 23 || NewInstanceV17 == 0 || this.codecNeedsSetOutputSurfaceWorkaround) {
                releaseCodec();
                maybeInitCodecOrBypass();
            } else {
                setOutputSurfaceV23(codec, NewInstanceV17);
            }
        }
        if (NewInstanceV17 == 0 || NewInstanceV17 == this.placeholderSurface) {
            this.reportedVideoSize = null;
            if (this.videoSinkProvider.isInitialized()) {
                this.videoSinkProvider.clearOutputSurfaceInfo();
            }
        } else {
            maybeRenotifyVideoSizeChanged();
            if (state == 2) {
                this.videoFrameReleaseControl.join();
            }
            if (this.videoSinkProvider.isInitialized()) {
                this.videoSinkProvider.setOutputSurfaceInfo(NewInstanceV17, Size.UNKNOWN);
            }
        }
        maybeUpdateOnFrameRenderedListener();
    }

    private boolean shouldUsePlaceholderSurface(MediaCodecInfo mediaCodecInfo) {
        return Util.SDK_INT >= 23 && !this.tunneling && !codecNeedsSetOutputSurfaceWorkaround(mediaCodecInfo.name) && (!mediaCodecInfo.secure || PlaceholderSurface.isSecureSupported(this.context));
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected DecoderReuseEvaluation canReuseCodec(MediaCodecInfo mediaCodecInfo, Format format, Format format2) {
        DecoderReuseEvaluation decoderReuseEvaluationCanReuseCodec = mediaCodecInfo.canReuseCodec(format, format2);
        int i10 = decoderReuseEvaluationCanReuseCodec.discardReasons;
        CodecMaxValues codecMaxValues = (CodecMaxValues) Assertions.checkNotNull(this.codecMaxValues);
        if (format2.width > codecMaxValues.width || format2.height > codecMaxValues.height) {
            i10 |= 256;
        }
        if (getMaxInputSize(mediaCodecInfo, format2) > codecMaxValues.inputSize) {
            i10 |= 64;
        }
        int i11 = i10;
        return new DecoderReuseEvaluation(mediaCodecInfo.name, format, format2, i11 != 0 ? 0 : decoderReuseEvaluationCanReuseCodec.result, i11);
    }

    protected boolean codecNeedsSetOutputSurfaceWorkaround(String str) {
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (MediaCodecVideoRenderer.class) {
            if (!evaluatedDeviceNeedsSetOutputSurfaceWorkaround) {
                deviceNeedsSetOutputSurfaceWorkaround = evaluateDeviceNeedsSetOutputSurfaceWorkaround();
                evaluatedDeviceNeedsSetOutputSurfaceWorkaround = true;
            }
        }
        return deviceNeedsSetOutputSurfaceWorkaround;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected MediaCodecDecoderException createDecoderException(Throwable th, @Nullable MediaCodecInfo mediaCodecInfo) {
        return new MediaCodecVideoDecoderException(th, mediaCodecInfo, this.displaySurface);
    }

    protected void dropOutputBuffer(MediaCodecAdapter mediaCodecAdapter, int i10, long j10) {
        TraceUtil.beginSection("dropVideoBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i10, false);
        TraceUtil.endSection();
        updateDroppedBufferCounters(0, 1);
    }

    @Override // androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.Renderer
    public void enableMayRenderStartOfStream() {
        this.videoFrameReleaseControl.allowReleaseFirstFrameBeforeStarted();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected int getCodecBufferFlags(DecoderInputBuffer decoderInputBuffer) {
        return (Util.SDK_INT < 34 || !this.tunneling || decoderInputBuffer.timeUs >= getLastResetPositionUs()) ? 0 : 32;
    }

    protected CodecMaxValues getCodecMaxValues(MediaCodecInfo mediaCodecInfo, Format format, Format[] formatArr) {
        int codecMaxInputSize;
        int iMax = format.width;
        int iMax2 = format.height;
        int maxInputSize = getMaxInputSize(mediaCodecInfo, format);
        if (formatArr.length == 1) {
            if (maxInputSize != -1 && (codecMaxInputSize = getCodecMaxInputSize(mediaCodecInfo, format)) != -1) {
                maxInputSize = Math.min((int) (maxInputSize * INITIAL_FORMAT_MAX_INPUT_SIZE_SCALE_FACTOR), codecMaxInputSize);
            }
            return new CodecMaxValues(iMax, iMax2, maxInputSize);
        }
        int length = formatArr.length;
        boolean z10 = false;
        for (int i10 = 0; i10 < length; i10++) {
            Format formatBuild = formatArr[i10];
            if (format.colorInfo != null && formatBuild.colorInfo == null) {
                formatBuild = formatBuild.buildUpon().setColorInfo(format.colorInfo).build();
            }
            if (mediaCodecInfo.canReuseCodec(format, formatBuild).result != 0) {
                int i11 = formatBuild.width;
                z10 |= i11 == -1 || formatBuild.height == -1;
                iMax = Math.max(iMax, i11);
                iMax2 = Math.max(iMax2, formatBuild.height);
                maxInputSize = Math.max(maxInputSize, getMaxInputSize(mediaCodecInfo, formatBuild));
            }
        }
        if (z10) {
            Log.w(TAG, "Resolutions unknown. Codec max resolution: " + iMax + ViewHierarchyNode.JsonKeys.X + iMax2);
            Point codecMaxSize = getCodecMaxSize(mediaCodecInfo, format);
            if (codecMaxSize != null) {
                iMax = Math.max(iMax, codecMaxSize.x);
                iMax2 = Math.max(iMax2, codecMaxSize.y);
                maxInputSize = Math.max(maxInputSize, getCodecMaxInputSize(mediaCodecInfo, format.buildUpon().setWidth(iMax).setHeight(iMax2).build()));
                Log.w(TAG, "Codec max resolution adjusted to: " + iMax + ViewHierarchyNode.JsonKeys.X + iMax2);
            }
        }
        return new CodecMaxValues(iMax, iMax2, maxInputSize);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected boolean getCodecNeedsEosPropagation() {
        return this.tunneling && Util.SDK_INT < 23;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected float getCodecOperatingRateV23(float f10, Format format, Format[] formatArr) {
        float fMax = -1.0f;
        for (Format format2 : formatArr) {
            float f11 = format2.frameRate;
            if (f11 != -1.0f) {
                fMax = Math.max(fMax, f11);
            }
        }
        if (fMax == -1.0f) {
            return -1.0f;
        }
        return fMax * f10;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected List<MediaCodecInfo> getDecoderInfos(MediaCodecSelector mediaCodecSelector, Format format, boolean z10) throws MediaCodecUtil.DecoderQueryException {
        return MediaCodecUtil.getDecoderInfosSortedByFormatSupport(getDecoderInfos(this.context, mediaCodecSelector, format, z10, this.tunneling), format);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    @TargetApi(17)
    protected MediaCodecAdapter.Configuration getMediaCodecConfiguration(MediaCodecInfo mediaCodecInfo, Format format, @Nullable MediaCrypto mediaCrypto, float f10) {
        PlaceholderSurface placeholderSurface = this.placeholderSurface;
        if (placeholderSurface != null && placeholderSurface.secure != mediaCodecInfo.secure) {
            releasePlaceholderSurface();
        }
        String str = mediaCodecInfo.codecMimeType;
        CodecMaxValues codecMaxValues = getCodecMaxValues(mediaCodecInfo, format, getStreamFormats());
        this.codecMaxValues = codecMaxValues;
        MediaFormat mediaFormat = getMediaFormat(format, str, codecMaxValues, f10, this.deviceNeedsNoPostProcessWorkaround, this.tunneling ? this.tunnelingAudioSessionId : 0);
        if (this.displaySurface == null) {
            if (!shouldUsePlaceholderSurface(mediaCodecInfo)) {
                throw new IllegalStateException();
            }
            if (this.placeholderSurface == null) {
                this.placeholderSurface = PlaceholderSurface.newInstanceV17(this.context, mediaCodecInfo.secure);
            }
            this.displaySurface = this.placeholderSurface;
        }
        maybeSetKeyAllowFrameDrop(mediaFormat);
        VideoSink videoSink = this.videoSink;
        return MediaCodecAdapter.Configuration.createForVideoDecoding(mediaCodecInfo, mediaFormat, format, videoSink != null ? videoSink.getInputSurface() : this.displaySurface, mediaCrypto);
    }

    @SuppressLint({"InlinedApi"})
    @TargetApi(21)
    protected MediaFormat getMediaFormat(Format format, String str, CodecMaxValues codecMaxValues, float f10, boolean z10, int i10) {
        Pair<Integer, Integer> codecProfileAndLevel;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", format.width);
        mediaFormat.setInteger("height", format.height);
        MediaFormatUtil.setCsdBuffers(mediaFormat, format.initializationData);
        MediaFormatUtil.maybeSetFloat(mediaFormat, "frame-rate", format.frameRate);
        MediaFormatUtil.maybeSetInteger(mediaFormat, "rotation-degrees", format.rotationDegrees);
        MediaFormatUtil.maybeSetColorInfo(mediaFormat, format.colorInfo);
        if (MimeTypes.VIDEO_DOLBY_VISION.equals(format.sampleMimeType) && (codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(format)) != null) {
            MediaFormatUtil.maybeSetInteger(mediaFormat, Scopes.PROFILE, ((Integer) codecProfileAndLevel.first).intValue());
        }
        mediaFormat.setInteger("max-width", codecMaxValues.width);
        mediaFormat.setInteger("max-height", codecMaxValues.height);
        MediaFormatUtil.maybeSetInteger(mediaFormat, "max-input-size", codecMaxValues.inputSize);
        if (Util.SDK_INT >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f10 != -1.0f) {
                mediaFormat.setFloat("operating-rate", f10);
            }
        }
        if (z10) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i10 != 0) {
            configureTunnelingV21(mediaFormat, i10);
        }
        return mediaFormat;
    }

    @Override // androidx.media3.exoplayer.Renderer, androidx.media3.exoplayer.RendererCapabilities
    public String getName() {
        return TAG;
    }

    @Nullable
    protected Surface getSurface() {
        return this.displaySurface;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    @TargetApi(29)
    protected void handleInputBufferSupplementalData(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        if (this.codecHandlesHdr10PlusOutOfBandMetadata) {
            ByteBuffer byteBuffer = (ByteBuffer) Assertions.checkNotNull(decoderInputBuffer.supplementalData);
            if (byteBuffer.remaining() >= 7) {
                byte b10 = byteBuffer.get();
                short s10 = byteBuffer.getShort();
                short s11 = byteBuffer.getShort();
                byte b11 = byteBuffer.get();
                byte b12 = byteBuffer.get();
                byteBuffer.position(0);
                if (b10 == -75 && s10 == 60 && s11 == 1 && b11 == 4) {
                    if (b12 == 0 || b12 == 1) {
                        byte[] bArr = new byte[byteBuffer.remaining()];
                        byteBuffer.get(bArr);
                        byteBuffer.position(0);
                        setHdr10PlusInfoV29((MediaCodecAdapter) Assertions.checkNotNull(getCodec()), bArr);
                    }
                }
            }
        }
    }

    @Override // androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.PlayerMessage.Target
    public void handleMessage(int i10, @Nullable Object obj) throws ExoPlaybackException {
        Surface surface;
        if (i10 == 1) {
            setOutput(obj);
            return;
        }
        if (i10 == 7) {
            VideoFrameMetadataListener videoFrameMetadataListener = (VideoFrameMetadataListener) Assertions.checkNotNull(obj);
            this.frameMetadataListener = videoFrameMetadataListener;
            this.videoSinkProvider.setVideoFrameMetadataListener(videoFrameMetadataListener);
            return;
        }
        if (i10 == 10) {
            int iIntValue = ((Integer) Assertions.checkNotNull(obj)).intValue();
            if (this.tunnelingAudioSessionId != iIntValue) {
                this.tunnelingAudioSessionId = iIntValue;
                if (this.tunneling) {
                    releaseCodec();
                    return;
                }
                return;
            }
            return;
        }
        if (i10 == 4) {
            this.scalingMode = ((Integer) Assertions.checkNotNull(obj)).intValue();
            MediaCodecAdapter codec = getCodec();
            if (codec != null) {
                codec.setVideoScalingMode(this.scalingMode);
                return;
            }
            return;
        }
        if (i10 == 5) {
            this.videoFrameReleaseControl.setChangeFrameRateStrategy(((Integer) Assertions.checkNotNull(obj)).intValue());
            return;
        }
        if (i10 == 13) {
            setVideoEffects((List) Assertions.checkNotNull(obj));
            return;
        }
        if (i10 != 14) {
            super.handleMessage(i10, obj);
            return;
        }
        this.outputResolution = (Size) Assertions.checkNotNull(obj);
        if (!this.videoSinkProvider.isInitialized() || ((Size) Assertions.checkNotNull(this.outputResolution)).getWidth() == 0 || ((Size) Assertions.checkNotNull(this.outputResolution)).getHeight() == 0 || (surface = this.displaySurface) == null) {
            return;
        }
        this.videoSinkProvider.setOutputSurfaceInfo(surface, (Size) Assertions.checkNotNull(this.outputResolution));
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.Renderer
    public boolean isEnded() {
        VideoSink videoSink;
        return super.isEnded() && ((videoSink = this.videoSink) == null || videoSink.isEnded());
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.Renderer
    public boolean isReady() {
        PlaceholderSurface placeholderSurface;
        VideoSink videoSink;
        boolean z10 = super.isReady() && ((videoSink = this.videoSink) == null || videoSink.isReady());
        if (z10 && (((placeholderSurface = this.placeholderSurface) != null && this.displaySurface == placeholderSurface) || getCodec() == null || this.tunneling)) {
            return true;
        }
        return this.videoFrameReleaseControl.isReady(z10);
    }

    protected boolean maybeDropBuffersToKeyframe(long j10, boolean z10) throws ExoPlaybackException {
        int iSkipSource = skipSource(j10);
        if (iSkipSource == 0) {
            return false;
        }
        if (z10) {
            DecoderCounters decoderCounters = this.decoderCounters;
            decoderCounters.skippedInputBufferCount += iSkipSource;
            decoderCounters.skippedOutputBufferCount += this.buffersInCodecCount;
        } else {
            this.decoderCounters.droppedToKeyframeCount++;
            updateDroppedBufferCounters(iSkipSource, this.buffersInCodecCount);
        }
        flushOrReinitializeCodec();
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            videoSink.flush();
        }
        return true;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void onCodecError(Exception exc) {
        Log.e(TAG, "Video codec error", exc);
        this.eventDispatcher.videoCodecError(exc);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void onCodecInitialized(String str, MediaCodecAdapter.Configuration configuration, long j10, long j11) {
        this.eventDispatcher.decoderInitialized(str, j10, j11);
        this.codecNeedsSetOutputSurfaceWorkaround = codecNeedsSetOutputSurfaceWorkaround(str);
        this.codecHandlesHdr10PlusOutOfBandMetadata = ((MediaCodecInfo) Assertions.checkNotNull(getCodecInfo())).isHdr10PlusOutOfBandMetadataSupported();
        if (Util.SDK_INT < 23 || !this.tunneling) {
            return;
        }
        this.tunnelingOnFrameRenderedListener = new OnFrameRenderedListenerV23((MediaCodecAdapter) Assertions.checkNotNull(getCodec()));
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void onCodecReleased(String str) {
        this.eventDispatcher.decoderReleased(str);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    protected void onDisabled() {
        this.reportedVideoSize = null;
        this.videoFrameReleaseControl.onDisabled();
        maybeUpdateOnFrameRenderedListener();
        this.haveReportedFirstFrameRenderedForCurrentSurface = false;
        this.tunnelingOnFrameRenderedListener = null;
        try {
            super.onDisabled();
        } finally {
            this.eventDispatcher.disabled(this.decoderCounters);
            this.eventDispatcher.videoSizeChanged(VideoSize.UNKNOWN);
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    protected void onEnabled(boolean z10, boolean z11) throws ExoPlaybackException {
        super.onEnabled(z10, z11);
        boolean z12 = getConfiguration().tunneling;
        Assertions.checkState((z12 && this.tunnelingAudioSessionId == 0) ? false : true);
        if (this.tunneling != z12) {
            this.tunneling = z12;
            releaseCodec();
        }
        this.eventDispatcher.enabled(this.decoderCounters);
        this.videoFrameReleaseControl.onEnabled(z11);
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void onInit() {
        super.onInit();
        Clock clock = getClock();
        this.videoFrameReleaseControl.setClock(clock);
        this.videoSinkProvider.setClock(clock);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    @Nullable
    protected DecoderReuseEvaluation onInputFormatChanged(FormatHolder formatHolder) throws ExoPlaybackException {
        DecoderReuseEvaluation decoderReuseEvaluationOnInputFormatChanged = super.onInputFormatChanged(formatHolder);
        this.eventDispatcher.inputFormatChanged((Format) Assertions.checkNotNull(formatHolder.format), decoderReuseEvaluationOnInputFormatChanged);
        return decoderReuseEvaluationOnInputFormatChanged;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void onOutputFormatChanged(Format format, @Nullable MediaFormat mediaFormat) {
        int integer;
        int integer2;
        MediaCodecAdapter codec = getCodec();
        if (codec != null) {
            codec.setVideoScalingMode(this.scalingMode);
        }
        int i10 = 0;
        if (this.tunneling) {
            integer = format.width;
            integer2 = format.height;
        } else {
            Assertions.checkNotNull(mediaFormat);
            boolean z10 = mediaFormat.containsKey(KEY_CROP_RIGHT) && mediaFormat.containsKey(KEY_CROP_LEFT) && mediaFormat.containsKey(KEY_CROP_BOTTOM) && mediaFormat.containsKey(KEY_CROP_TOP);
            integer = z10 ? (mediaFormat.getInteger(KEY_CROP_RIGHT) - mediaFormat.getInteger(KEY_CROP_LEFT)) + 1 : mediaFormat.getInteger("width");
            integer2 = z10 ? (mediaFormat.getInteger(KEY_CROP_BOTTOM) - mediaFormat.getInteger(KEY_CROP_TOP)) + 1 : mediaFormat.getInteger("height");
        }
        float f10 = format.pixelWidthHeightRatio;
        if (codecAppliesRotation()) {
            int i11 = format.rotationDegrees;
            if (i11 == 90 || i11 == 270) {
                f10 = 1.0f / f10;
                int i12 = integer2;
                integer2 = integer;
                integer = i12;
            }
        } else if (this.videoSink == null) {
            i10 = format.rotationDegrees;
        }
        this.decodedVideoSize = new VideoSize(integer, integer2, i10, f10);
        this.videoFrameReleaseControl.setFrameRate(format.frameRate);
        if (this.videoSink == null || mediaFormat == null) {
            return;
        }
        onReadyToRegisterVideoSinkInputStream();
        ((VideoSink) Assertions.checkNotNull(this.videoSink)).registerInputStream(1, format.buildUpon().setWidth(integer).setHeight(integer2).setRotationDegrees(i10).setPixelWidthHeightRatio(f10).build());
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    protected void onPositionReset(long j10, boolean z10) throws ExoPlaybackException {
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            videoSink.flush();
        }
        super.onPositionReset(j10, z10);
        if (this.videoSinkProvider.isInitialized()) {
            this.videoSinkProvider.setStreamOffsetUs(getOutputStreamOffsetUs());
        }
        this.videoFrameReleaseControl.reset();
        if (z10) {
            this.videoFrameReleaseControl.join();
        }
        maybeUpdateOnFrameRenderedListener();
        this.consecutiveDroppedFrameCount = 0;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    @CallSuper
    protected void onProcessedOutputBuffer(long j10) {
        super.onProcessedOutputBuffer(j10);
        if (this.tunneling) {
            return;
        }
        this.buffersInCodecCount--;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void onProcessedStreamChange() {
        super.onProcessedStreamChange();
        this.videoFrameReleaseControl.onProcessedStreamChange();
        maybeUpdateOnFrameRenderedListener();
        if (this.videoSinkProvider.isInitialized()) {
            this.videoSinkProvider.setStreamOffsetUs(getOutputStreamOffsetUs());
        }
    }

    protected void onProcessedTunneledBuffer(long j10) throws ExoPlaybackException {
        updateOutputFormatForTime(j10);
        maybeNotifyVideoSizeChanged(this.decodedVideoSize);
        this.decoderCounters.renderedOutputBufferCount++;
        maybeNotifyRenderedFirstFrame();
        onProcessedOutputBuffer(j10);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    @CallSuper
    protected void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        boolean z10 = this.tunneling;
        if (!z10) {
            this.buffersInCodecCount++;
        }
        if (Util.SDK_INT >= 23 || !z10) {
            return;
        }
        onProcessedTunneledBuffer(decoderInputBuffer.timeUs);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    @CallSuper
    protected void onReadyToInitializeCodec(Format format) throws ExoPlaybackException {
        Size size;
        if (this.hasEffects && !this.hasInitializedPlayback && !this.videoSinkProvider.isInitialized()) {
            try {
                this.videoSinkProvider.initialize(format);
                this.videoSinkProvider.setStreamOffsetUs(getOutputStreamOffsetUs());
                VideoFrameMetadataListener videoFrameMetadataListener = this.frameMetadataListener;
                if (videoFrameMetadataListener != null) {
                    this.videoSinkProvider.setVideoFrameMetadataListener(videoFrameMetadataListener);
                }
                Surface surface = this.displaySurface;
                if (surface != null && (size = this.outputResolution) != null) {
                    this.videoSinkProvider.setOutputSurfaceInfo(surface, size);
                }
            } catch (VideoSink.VideoSinkException e10) {
                throw createRendererException(e10, format, 7000);
            }
        }
        if (this.videoSink == null && this.videoSinkProvider.isInitialized()) {
            VideoSink sink = this.videoSinkProvider.getSink();
            this.videoSink = sink;
            sink.setListener(new VideoSink.Listener() { // from class: androidx.media3.exoplayer.video.MediaCodecVideoRenderer.1
                @Override // androidx.media3.exoplayer.video.VideoSink.Listener
                public void onError(VideoSink videoSink, VideoSink.VideoSinkException videoSinkException) {
                    MediaCodecVideoRenderer mediaCodecVideoRenderer = MediaCodecVideoRenderer.this;
                    mediaCodecVideoRenderer.setPendingPlaybackException(mediaCodecVideoRenderer.createRendererException(videoSinkException, videoSinkException.format, 7001));
                }

                @Override // androidx.media3.exoplayer.video.VideoSink.Listener
                public void onFirstFrameRendered(VideoSink videoSink) {
                    Assertions.checkStateNotNull(MediaCodecVideoRenderer.this.displaySurface);
                    MediaCodecVideoRenderer.this.notifyRenderedFirstFrame();
                }

                @Override // androidx.media3.exoplayer.video.VideoSink.Listener
                public void onFrameDropped(VideoSink videoSink) {
                    MediaCodecVideoRenderer.this.updateDroppedBufferCounters(0, 1);
                }

                @Override // androidx.media3.exoplayer.video.VideoSink.Listener
                public void onVideoSizeChanged(VideoSink videoSink, VideoSize videoSize) {
                }
            }, com.google.common.util.concurrent.p.a());
        }
        this.hasInitializedPlayback = true;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void onRelease() {
        super.onRelease();
        if (this.videoSinkProvider.isInitialized()) {
            this.videoSinkProvider.release();
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    @TargetApi(17)
    protected void onReset() {
        try {
            super.onReset();
        } finally {
            this.hasInitializedPlayback = false;
            if (this.placeholderSurface != null) {
                releasePlaceholderSurface();
            }
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    protected void onStarted() {
        super.onStarted();
        this.droppedFrames = 0;
        this.droppedFrameAccumulationStartTimeMs = getClock().elapsedRealtime();
        this.totalVideoFrameProcessingOffsetUs = 0L;
        this.videoFrameProcessingOffsetCount = 0;
        this.videoFrameReleaseControl.onStarted();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    protected void onStopped() {
        maybeNotifyDroppedFrames();
        maybeNotifyVideoFrameProcessingOffset();
        this.videoFrameReleaseControl.onStopped();
        super.onStopped();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected boolean processOutputBuffer(long j10, long j11, @Nullable MediaCodecAdapter mediaCodecAdapter, @Nullable ByteBuffer byteBuffer, int i10, int i11, int i12, long j12, boolean z10, boolean z11, Format format) throws ExoPlaybackException {
        Assertions.checkNotNull(mediaCodecAdapter);
        long outputStreamOffsetUs = j12 - getOutputStreamOffsetUs();
        int frameReleaseAction = this.videoFrameReleaseControl.getFrameReleaseAction(j12, j10, j11, getOutputStreamStartPositionUs(), z11, this.videoFrameReleaseInfo);
        if (z10 && !z11) {
            skipOutputBuffer(mediaCodecAdapter, i10, outputStreamOffsetUs);
            return true;
        }
        if (this.displaySurface == this.placeholderSurface) {
            if (this.videoFrameReleaseInfo.getEarlyUs() >= 30000) {
                return false;
            }
            skipOutputBuffer(mediaCodecAdapter, i10, outputStreamOffsetUs);
            updateVideoFrameProcessingOffsetCounters(this.videoFrameReleaseInfo.getEarlyUs());
            return true;
        }
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            try {
                videoSink.render(j10, j11);
                long jRegisterInputFrame = this.videoSink.registerInputFrame(outputStreamOffsetUs, z11);
                if (jRegisterInputFrame == C.TIME_UNSET) {
                    return false;
                }
                renderOutputBuffer(mediaCodecAdapter, i10, outputStreamOffsetUs, jRegisterInputFrame);
                return true;
            } catch (VideoSink.VideoSinkException e10) {
                throw createRendererException(e10, e10.format, 7001);
            }
        }
        if (frameReleaseAction == 0) {
            long jNanoTime = getClock().nanoTime();
            notifyFrameMetadataListener(outputStreamOffsetUs, jNanoTime, format);
            renderOutputBuffer(mediaCodecAdapter, i10, outputStreamOffsetUs, jNanoTime);
            updateVideoFrameProcessingOffsetCounters(this.videoFrameReleaseInfo.getEarlyUs());
            return true;
        }
        if (frameReleaseAction == 1) {
            return maybeReleaseFrame((MediaCodecAdapter) Assertions.checkStateNotNull(mediaCodecAdapter), i10, outputStreamOffsetUs, format);
        }
        if (frameReleaseAction == 2) {
            dropOutputBuffer(mediaCodecAdapter, i10, outputStreamOffsetUs);
            updateVideoFrameProcessingOffsetCounters(this.videoFrameReleaseInfo.getEarlyUs());
            return true;
        }
        if (frameReleaseAction == 3) {
            skipOutputBuffer(mediaCodecAdapter, i10, outputStreamOffsetUs);
            updateVideoFrameProcessingOffsetCounters(this.videoFrameReleaseInfo.getEarlyUs());
            return true;
        }
        if (frameReleaseAction == 4 || frameReleaseAction == 5) {
            return false;
        }
        throw new IllegalStateException(String.valueOf(frameReleaseAction));
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.Renderer
    @CallSuper
    public void render(long j10, long j11) throws ExoPlaybackException {
        super.render(j10, j11);
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            try {
                videoSink.render(j10, j11);
            } catch (VideoSink.VideoSinkException e10) {
                throw createRendererException(e10, e10.format, 7001);
            }
        }
    }

    @RequiresApi(21)
    protected void renderOutputBufferV21(MediaCodecAdapter mediaCodecAdapter, int i10, long j10, long j11) {
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i10, j11);
        TraceUtil.endSection();
        this.decoderCounters.renderedOutputBufferCount++;
        this.consecutiveDroppedFrameCount = 0;
        if (this.videoSink == null) {
            maybeNotifyVideoSizeChanged(this.decodedVideoSize);
            maybeNotifyRenderedFirstFrame();
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    @CallSuper
    protected void resetCodecStateForFlush() {
        super.resetCodecStateForFlush();
        this.buffersInCodecCount = 0;
    }

    @RequiresApi(23)
    protected void setOutputSurfaceV23(MediaCodecAdapter mediaCodecAdapter, Surface surface) {
        mediaCodecAdapter.setOutputSurface(surface);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.Renderer
    public void setPlaybackSpeed(float f10, float f11) throws ExoPlaybackException {
        super.setPlaybackSpeed(f10, f11);
        this.videoFrameReleaseControl.setPlaybackSpeed(f10);
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            videoSink.setPlaybackSpeed(f10);
        }
    }

    public void setVideoEffects(List<Effect> list) {
        this.videoSinkProvider.setVideoEffects(list);
        this.hasEffects = true;
    }

    protected boolean shouldDropBuffersToKeyframe(long j10, long j11, boolean z10) {
        return j10 < MIN_EARLY_US_VERY_LATE_THRESHOLD && !z10;
    }

    @Override // androidx.media3.exoplayer.video.VideoFrameReleaseControl.FrameTimingEvaluator
    public boolean shouldDropFrame(long j10, long j11, boolean z10) {
        return shouldDropOutputBuffer(j10, j11, z10);
    }

    protected boolean shouldDropOutputBuffer(long j10, long j11, boolean z10) {
        return j10 < MIN_EARLY_US_LATE_THRESHOLD && !z10;
    }

    @Override // androidx.media3.exoplayer.video.VideoFrameReleaseControl.FrameTimingEvaluator
    public boolean shouldForceReleaseFrame(long j10, long j11) {
        return shouldForceRenderOutputBuffer(j10, j11);
    }

    protected boolean shouldForceRenderOutputBuffer(long j10, long j11) {
        return j10 < MIN_EARLY_US_LATE_THRESHOLD && j11 > SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US;
    }

    @Override // androidx.media3.exoplayer.video.VideoFrameReleaseControl.FrameTimingEvaluator
    public boolean shouldIgnoreFrame(long j10, long j11, long j12, boolean z10, boolean z11) throws ExoPlaybackException {
        return shouldDropBuffersToKeyframe(j10, j12, z10) && maybeDropBuffersToKeyframe(j11, z11);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected boolean shouldInitCodec(MediaCodecInfo mediaCodecInfo) {
        return this.displaySurface != null || shouldUsePlaceholderSurface(mediaCodecInfo);
    }

    protected boolean shouldSkipBuffersWithIdenticalReleaseTime() {
        return true;
    }

    protected void skipOutputBuffer(MediaCodecAdapter mediaCodecAdapter, int i10, long j10) {
        TraceUtil.beginSection("skipVideoBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i10, false);
        TraceUtil.endSection();
        this.decoderCounters.skippedOutputBufferCount++;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected int supportsFormat(MediaCodecSelector mediaCodecSelector, Format format) throws MediaCodecUtil.DecoderQueryException {
        boolean z10;
        int i10 = 0;
        if (!MimeTypes.isVideo(format.sampleMimeType)) {
            return k2.c(0);
        }
        boolean z11 = format.drmInitData != null;
        List<MediaCodecInfo> decoderInfos = getDecoderInfos(this.context, mediaCodecSelector, format, z11, false);
        if (z11 && decoderInfos.isEmpty()) {
            decoderInfos = getDecoderInfos(this.context, mediaCodecSelector, format, false, false);
        }
        if (decoderInfos.isEmpty()) {
            return k2.c(1);
        }
        if (!MediaCodecRenderer.supportsFormatDrm(format)) {
            return k2.c(2);
        }
        MediaCodecInfo mediaCodecInfo = decoderInfos.get(0);
        boolean zIsFormatSupported = mediaCodecInfo.isFormatSupported(format);
        if (zIsFormatSupported) {
            z10 = true;
        } else {
            for (int i11 = 1; i11 < decoderInfos.size(); i11++) {
                MediaCodecInfo mediaCodecInfo2 = decoderInfos.get(i11);
                if (mediaCodecInfo2.isFormatSupported(format)) {
                    z10 = false;
                    zIsFormatSupported = true;
                    mediaCodecInfo = mediaCodecInfo2;
                    break;
                }
            }
            z10 = true;
        }
        int i12 = zIsFormatSupported ? 4 : 3;
        int i13 = mediaCodecInfo.isSeamlessAdaptationSupported(format) ? 16 : 8;
        int i14 = mediaCodecInfo.hardwareAccelerated ? 64 : 0;
        int i15 = z10 ? 128 : 0;
        if (Util.SDK_INT >= 26 && MimeTypes.VIDEO_DOLBY_VISION.equals(format.sampleMimeType) && !Api26.doesDisplaySupportDolbyVision(this.context)) {
            i15 = 256;
        }
        if (zIsFormatSupported) {
            List<MediaCodecInfo> decoderInfos2 = getDecoderInfos(this.context, mediaCodecSelector, format, z11, true);
            if (!decoderInfos2.isEmpty()) {
                MediaCodecInfo mediaCodecInfo3 = MediaCodecUtil.getDecoderInfosSortedByFormatSupport(decoderInfos2, format).get(0);
                if (mediaCodecInfo3.isFormatSupported(format) && mediaCodecInfo3.isSeamlessAdaptationSupported(format)) {
                    i10 = 32;
                }
            }
        }
        return k2.f(i12, i13, i10, i14, i15);
    }

    protected void updateDroppedBufferCounters(int i10, int i11) {
        DecoderCounters decoderCounters = this.decoderCounters;
        decoderCounters.droppedInputBufferCount += i10;
        int i12 = i10 + i11;
        decoderCounters.droppedBufferCount += i12;
        this.droppedFrames += i12;
        int i13 = this.consecutiveDroppedFrameCount + i12;
        this.consecutiveDroppedFrameCount = i13;
        decoderCounters.maxConsecutiveDroppedBufferCount = Math.max(i13, decoderCounters.maxConsecutiveDroppedBufferCount);
        int i14 = this.maxDroppedFramesToNotify;
        if (i14 <= 0 || this.droppedFrames < i14) {
            return;
        }
        maybeNotifyDroppedFrames();
    }

    protected void updateVideoFrameProcessingOffsetCounters(long j10) {
        this.decoderCounters.addVideoFrameProcessingOffset(j10);
        this.totalVideoFrameProcessingOffsetUs += j10;
        this.videoFrameProcessingOffsetCount++;
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long j10) {
        this(context, mediaCodecSelector, j10, null, null, 0);
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long j10, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i10) {
        this(context, MediaCodecAdapter.Factory.DEFAULT, mediaCodecSelector, j10, false, handler, videoRendererEventListener, i10, 30.0f);
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long j10, boolean z10, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i10) {
        this(context, MediaCodecAdapter.Factory.DEFAULT, mediaCodecSelector, j10, z10, handler, videoRendererEventListener, i10, 30.0f);
    }

    private static List<MediaCodecInfo> getDecoderInfos(Context context, MediaCodecSelector mediaCodecSelector, Format format, boolean z10, boolean z11) throws MediaCodecUtil.DecoderQueryException {
        String str = format.sampleMimeType;
        if (str == null) {
            return y.q();
        }
        if (Util.SDK_INT >= 26 && MimeTypes.VIDEO_DOLBY_VISION.equals(str) && !Api26.doesDisplaySupportDolbyVision(context)) {
            List<MediaCodecInfo> alternativeDecoderInfos = MediaCodecUtil.getAlternativeDecoderInfos(mediaCodecSelector, format, z10, z11);
            if (!alternativeDecoderInfos.isEmpty()) {
                return alternativeDecoderInfos;
            }
        }
        return MediaCodecUtil.getDecoderInfosSoftMatch(mediaCodecSelector, format, z10, z11);
    }

    protected void renderOutputBuffer(MediaCodecAdapter mediaCodecAdapter, int i10, long j10) {
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i10, true);
        TraceUtil.endSection();
        this.decoderCounters.renderedOutputBufferCount++;
        this.consecutiveDroppedFrameCount = 0;
        if (this.videoSink == null) {
            maybeNotifyVideoSizeChanged(this.decodedVideoSize);
            maybeNotifyRenderedFirstFrame();
        }
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, long j10, boolean z10, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i10) {
        this(context, factory, mediaCodecSelector, j10, z10, handler, videoRendererEventListener, i10, 30.0f);
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, long j10, boolean z10, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i10, float f10) {
        this(context, factory, mediaCodecSelector, j10, z10, handler, videoRendererEventListener, i10, f10, null);
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, long j10, boolean z10, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i10, float f10, @Nullable VideoSinkProvider videoSinkProvider) {
        super(2, factory, mediaCodecSelector, z10, f10);
        this.maxDroppedFramesToNotify = i10;
        Context applicationContext = context.getApplicationContext();
        this.context = applicationContext;
        this.eventDispatcher = new VideoRendererEventListener.EventDispatcher(handler, videoRendererEventListener);
        VideoSinkProvider videoSinkProviderBuild = videoSinkProvider == null ? new CompositingVideoSinkProvider.Builder(applicationContext).build() : videoSinkProvider;
        if (videoSinkProviderBuild.getVideoFrameReleaseControl() == null) {
            videoSinkProviderBuild.setVideoFrameReleaseControl(new VideoFrameReleaseControl(applicationContext, this, j10));
        }
        this.videoSinkProvider = videoSinkProviderBuild;
        this.videoFrameReleaseControl = (VideoFrameReleaseControl) Assertions.checkStateNotNull(videoSinkProviderBuild.getVideoFrameReleaseControl());
        this.videoFrameReleaseInfo = new VideoFrameReleaseControl.FrameReleaseInfo();
        this.deviceNeedsNoPostProcessWorkaround = deviceNeedsNoPostProcessWorkaround();
        this.scalingMode = 1;
        this.decodedVideoSize = VideoSize.UNKNOWN;
        this.tunnelingAudioSessionId = 0;
        this.reportedVideoSize = null;
    }

    protected void onReadyToRegisterVideoSinkInputStream() {
    }
}
