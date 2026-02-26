package com.facebook.ads.redexgen.core;

import androidx.media3.common.C;
import com.facebook.ads.androidx.media3.common.Timeline;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6x, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C14516x {
    public static final C2911mL A0E = new C2911mL(new Object());
    public final int A00;
    public final long A01;
    public final long A02;
    public final Timeline A03;
    public final C2911mL A04;
    public final C2911mL A05;
    public final C2901mA A06;
    public final EL A07;

    @MetaExoPlayerCustomization(type = {"NEW_CLASS_ARG"}, value = "Start Stall Logging")
    public final EnumC2640hX A08;

    @MetaExoPlayerCustomization(type = {"NEW_CLASS_ARG"}, value = "Determine if stall is from Audio for logging")
    public final boolean A09;
    public final boolean A0A;
    public volatile long A0B;
    public volatile long A0C;
    public volatile long A0D;

    public C14516x(Timeline timeline, long j10, C2901mA c2901mA, EL el) {
        this(timeline, A0E, j10, C.TIME_UNSET, 1, false, c2901mA, el, A0E, j10, j10, j10, EnumC2640hX.A09, false);
    }

    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "Customized to call base constructor")
    public C14516x(Timeline timeline, C2911mL c2911mL, long j10, long j11, int i10, boolean z10, C2901mA c2901mA, EL el, C2911mL c2911mL2, long j12, long j13, long j14) {
        this(timeline, c2911mL, j10, j11, i10, z10, c2901mA, el, c2911mL2, j12, j13, j14, EnumC2640hX.A09, false);
    }

    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "Customized to add new parameters")
    public C14516x(@MetaExoPlayerCustomization(type = {"NEW_METHOD_ARGS"}) Timeline timeline, @MetaExoPlayerCustomization(type = {"NEW_METHOD_ARGS"}) C2911mL c2911mL, long j10, long j11, int i10, boolean z10, C2901mA c2901mA, EL el, C2911mL c2911mL2, long j12, long j13, long j14, EnumC2640hX enumC2640hX, boolean z11) {
        this.A03 = timeline;
        this.A05 = c2911mL;
        this.A02 = j10;
        this.A01 = j11;
        this.A0C = j10;
        this.A00 = i10;
        this.A0A = z10;
        this.A06 = c2901mA;
        this.A07 = el;
        this.A04 = c2911mL2;
        this.A0B = j12;
        this.A0D = j13;
        this.A0C = j14;
        this.A08 = enumC2640hX;
        this.A09 = z11;
    }

    public static void A00(C14516x c14516x, C14516x c14516x2) {
        c14516x2.A0C = c14516x.A0C;
        c14516x2.A0B = c14516x.A0B;
        c14516x2.A0D = c14516x.A0D;
    }

    public final C14516x A01(int i10) {
        C14516x c14516x = new C14516x(this.A03, this.A05, this.A02, this.A01, i10, this.A0A, this.A06, this.A07, this.A04, this.A0B, this.A0D, this.A0C, this.A08, this.A09);
        A00(this, c14516x);
        return c14516x;
    }

    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "Stall Reason Logging in Hero")
    public final C14516x A02(int i10, EnumC2640hX enumC2640hX, boolean z10) {
        C14516x c14516x = new C14516x(this.A03, this.A05, this.A02, this.A01, i10, this.A0A, this.A06, this.A07, this.A04, this.A0B, this.A0D, this.A0C, enumC2640hX, z10);
        A00(this, c14516x);
        return c14516x;
    }

    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "To track Audio Stalls for Logging")
    public final C14516x A03(int i10, boolean z10) {
        C14516x c14516x = new C14516x(this.A03, this.A05, this.A02, this.A01, i10, this.A0A, this.A06, this.A07, this.A04, this.A0B, this.A0D, this.A0C, this.A08, z10);
        A00(this, c14516x);
        return c14516x;
    }

    public final C14516x A04(Timeline timeline) {
        C14516x c14516x = new C14516x(timeline, this.A05, this.A02, this.A01, this.A00, this.A0A, this.A06, this.A07, this.A04, this.A0B, this.A0D, this.A0C, this.A08, this.A09);
        A00(this, c14516x);
        return c14516x;
    }

    public final C14516x A05(C2911mL c2911mL) {
        return new C14516x(this.A03, this.A05, this.A02, this.A01, this.A00, this.A0A, this.A06, this.A07, c2911mL, this.A0B, this.A0D, this.A0C, this.A08, this.A09);
    }

    public final C14516x A06(C2911mL c2911mL, long j10, long j11, long j12) {
        long j13 = j11;
        Timeline timeline = this.A03;
        if (!c2911mL.A00()) {
            j13 = C.TIME_UNSET;
        }
        return new C14516x(timeline, c2911mL, j10, j13, this.A00, this.A0A, this.A06, this.A07, this.A04, this.A0B, j12, j10);
    }

    public final C14516x A07(C2901mA c2901mA, EL el) {
        C14516x c14516x = new C14516x(this.A03, this.A05, this.A02, this.A01, this.A00, this.A0A, c2901mA, el, this.A04, this.A0B, this.A0D, this.A0C, this.A08, this.A09);
        A00(this, c14516x);
        return c14516x;
    }

    public final C14516x A08(boolean z10) {
        C14516x c14516x = new C14516x(this.A03, this.A05, this.A02, this.A01, this.A00, z10, this.A06, this.A07, this.A04, this.A0B, this.A0D, this.A0C, this.A08, this.A09);
        A00(this, c14516x);
        return c14516x;
    }
}
