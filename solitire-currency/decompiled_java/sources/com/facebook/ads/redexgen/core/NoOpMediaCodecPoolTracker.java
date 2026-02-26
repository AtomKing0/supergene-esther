package com.facebook.ads.redexgen.core;

import io.sentry.protocol.TransactionInfo;
import java.util.Arrays;
import kotlin.Metadata;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ba, reason: from Kotlin metadata */
/* JADX INFO: loaded from: assets/audience_network.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tH\u0016J(\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u0015"}, d2 = {"Lcom/facebook/video/heroplayer/exocustom/NoOpMediaCodecPoolTracker;", "Lcom/facebook/video/heroplayer/exocustom/MediaCodecPoolTracker;", "<init>", "()V", "reportCodecCreated", "", "creatingEvent", "Lcom/facebook/video/heroplayer/exocustom/MediaCodecPoolTracker$CreatingEvent;", "codecInstanceId", "", "reportCodecReleasing", TransactionInfo.JsonKeys.SOURCE, "Lcom/facebook/video/heroplayer/exocustom/MediaCodecPoolTracker$Source;", "reportCodecReleased", "reportCodecAcquiredFromPool", "isVideo", "", "codecName", "", "reportCodecReturnedToPool", "Companion", "fbandroid.java.com.facebook.video.heroplayer.exocustom.exocustom"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NoOpMediaCodecPoolTracker extends MediaCodecPoolTracker {
    public static byte[] A00;
    public static final C2667i7 A01;
    public static final NoOpMediaCodecPoolTracker A02;

    public static String A00(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] ^ i12) ^ 17);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{36, 40, 35, 34, 36, 9, 38, 42, 34, 9, 24, 15, 11, 30, 3, 4, 13, 47, 28, 15, 4, 30, 84, 72, 82, 85, 68, 66};
    }

    static {
        A01();
        A01 = new C2667i7(null);
        A02 = new NoOpMediaCodecPoolTracker();
    }

    @Override // com.facebook.ads.redexgen.core.MediaCodecPoolTracker
    public final void A06(C2654ho c2654ho, int i10) {
        C3078p6.A09(c2654ho, A00(9, 13, 123));
    }

    @Override // com.facebook.ads.redexgen.core.MediaCodecPoolTracker
    public final void A07(EnumC2656hq enumC2656hq, int i10) {
        C3078p6.A09(enumC2656hq, A00(22, 6, 54));
    }

    @Override // com.facebook.ads.redexgen.core.MediaCodecPoolTracker
    public final void A08(EnumC2656hq enumC2656hq, int i10) {
        C3078p6.A09(enumC2656hq, A00(22, 6, 54));
    }

    @Override // com.facebook.ads.redexgen.core.MediaCodecPoolTracker
    public final void A09(EnumC2656hq enumC2656hq, int i10) {
        C3078p6.A09(enumC2656hq, A00(22, 6, 54));
    }

    @Override // com.facebook.ads.redexgen.core.MediaCodecPoolTracker
    public final void A0A(boolean z10, String str, EnumC2656hq enumC2656hq, int i10) {
        C3078p6.A09(str, A00(0, 9, 86));
        C3078p6.A09(enumC2656hq, A00(22, 6, 54));
    }
}
