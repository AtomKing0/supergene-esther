package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ld, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1804Ld implements InterfaceC2364cx {
    public static byte[] A01;
    public static String[] A02 = {"BHXiYjXxfgjD7yDB", "kPfw5HKETqo8dV", "SlBKzsC69frNfTspgJs5v90302jxH173", "0t7u2eeKUCj5gcxeWZIOCTpidMAeGJtt", "hTXrvsDVbOi3Q9xrUBZOJj7T", "iLbLRTjnBQIJ87KFXaIFUijyWt7EPIGc", "0utayShxEdwMeaV3UZeoWviAuyaBWRmj", "gyVOCm6F1v6TZALkbG"};
    public final /* synthetic */ C1803Lc A00;

    public static String A00(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] - i12) - 58);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{25, 23, 9, 22, 7, 16, 13, 7, 15};
    }

    static {
        A01();
    }

    public C1804Ld(C1803Lc c1803Lc) {
        this.A00 = c1803Lc;
    }

    public /* synthetic */ C1804Ld(C1803Lc c1803Lc, C1821Lu c1821Lu) {
        this(c1803Lc);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2364cx
    public final void ACt() {
        this.A00.A0U(true, A00(0, 9, 106));
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2364cx
    public final void ADW() {
        if (!this.A00.A0Z) {
            if (!TextUtils.isEmpty(this.A00.A0I.A25())) {
                this.A00.A0M.AB5(this.A00.A0I.A25(), new C2172Zp().A03(this.A00.A07.getViewabilityChecker()).A02(this.A00.A07.getTouchDataRecorder()).A05());
                W2.A00(this.A00.A0L).A0E(this.A00.A0R.A8d(), this.A00.A0I.A25());
                N3.A07(this.A00.A0I.A21(), this.A00.A0L);
                AbstractC1874Nw.A02(this.A00.A0I.A0t(), X0.A00(this.A00.A0I.A0v()));
                this.A00.A0L.A0F().A3D();
                if (this.A00.A0J.A0P()) {
                    this.A00.A0L.A0F().ADo();
                }
            }
            C1803Lc c1803Lc = this.A00;
            String[] strArr = A02;
            if (strArr[5].charAt(12) == strArr[2].charAt(12)) {
                throw new RuntimeException();
            }
            A02[4] = "GzK3XL6hk7idJD";
            c1803Lc.A0Q.A4b(this.A00.A0R.A88());
            return;
        }
        this.A00.A0L.A0F().ADp();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2364cx
    public final void AE2() {
        this.A00.A0Q.A4b(this.A00.A0R.A7t());
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2364cx
    public final void AFw() {
        this.A00.A0Q.ACf(15);
    }
}
