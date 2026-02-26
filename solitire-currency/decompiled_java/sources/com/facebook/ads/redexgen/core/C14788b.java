package com.facebook.ads.redexgen.core;

import android.media.AudioTrack;
import android.media.metrics.LogSessionId;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8b, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C14788b {
    public static void A00(AudioTrack audioTrack, C14667m c14667m) {
        LogSessionId logSessionIdA00 = c14667m.A00();
        LogSessionId logSessionId = LogSessionId.LOG_SESSION_ID_NONE;
        if (!logSessionIdA00.equals(logSessionId)) {
            audioTrack.setLogSessionId(logSessionIdA00);
        }
    }
}
