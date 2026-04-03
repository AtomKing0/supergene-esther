package com.facebook.ads.redexgen.core;

import androidx.media3.common.C;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5I, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class C5I {
    public int A00;

    public final void A00(int i10) {
        this.A00 |= i10;
    }

    public final void A01(int i10) {
        this.A00 &= ~i10;
    }

    public final void A02(int i10) {
        this.A00 = i10;
    }

    public final boolean A03() {
        return A09(268435456);
    }

    public final boolean A04() {
        return A09(Integer.MIN_VALUE);
    }

    public final boolean A05() {
        return A09(4);
    }

    public final boolean A06() {
        return A09(C.BUFFER_FLAG_FIRST_SAMPLE);
    }

    public final boolean A07() {
        return A09(1);
    }

    @MetaExoPlayerCustomization("Add method to determine if we are at the last sample")
    public final boolean A08() {
        return A09(536870912);
    }

    public final boolean A09(int i10) {
        return (this.A00 & i10) == i10;
    }

    public void A0A() {
        this.A00 = 0;
    }
}
