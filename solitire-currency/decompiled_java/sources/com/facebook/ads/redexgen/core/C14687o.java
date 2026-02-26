package com.facebook.ads.redexgen.core;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import androidx.media3.extractor.OpusUtil;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7o, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C14687o {
    public static final AudioAttributes A00 = new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(0).build();

    public static int A00(int i10, int i11) {
        for (int i12 = 8; i12 > 0; i12--) {
            AudioFormat.Builder sampleRate = new AudioFormat.Builder().setEncoding(i10).setSampleRate(i11);
            int channelCount = AbstractC13764a.A01(i12);
            AudioFormat audioFormat = sampleRate.setChannelMask(channelCount).build();
            if (AudioTrack.isDirectPlaybackSupported(audioFormat, A00)) {
                return i12;
            }
        }
        return 0;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.1h != com.google.common.collect.ImmutableList$Builder<java.lang.Integer> */
    /* JADX WARN: Multi-variable type inference failed */
    public static int[] A01() {
        C13071h c13071hA01 = AbstractC1531Am.A01();
        AbstractC3098pg it = C14697p.A06.keySet().iterator();
        while (it.hasNext()) {
            int encoding = ((Integer) it.next()).intValue();
            if (AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(encoding).setSampleRate(OpusUtil.SAMPLE_RATE).build(), A00)) {
                c13071hA01.A04(Integer.valueOf(encoding));
            }
        }
        c13071hA01.A04(2);
        return AD.A0C(c13071hA01.A05());
    }
}
