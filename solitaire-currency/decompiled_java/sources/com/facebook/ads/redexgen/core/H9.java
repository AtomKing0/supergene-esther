package com.facebook.ads.redexgen.core;

import androidx.media3.extractor.WavUtil;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class H9 {
    public static int A00(int i10, int i11) {
        switch (i10) {
            case 1:
            case WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE /* 65534 */:
                return AbstractC13764a.A03(i11);
            case 3:
                return i11 == 32 ? 4 : 0;
            default:
                return 0;
        }
    }
}
