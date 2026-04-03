package com.facebook.ads.redexgen.core;

import android.view.View;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.at, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC2236at implements View.OnClickListener {
    public static byte[] A02;
    public static String[] A03 = {"5siEYkdbttFpPpKGpl3QSuzD1TdUzqaY", "myaIheKQJ4XKLjb9jwKnfQPKdgb03x65", "7UC9gtjSNciDETfiVIuIcEpkShzxljy2", "zUgtzOTCnewqlW3ay8eN5ZGY8omlP8wl", "HCNRIc1Jq5CHui75", "5JldaPh0422ECqUrSdIW3CP66xzzDRpo", "6NBLbo7bp32p6xzITlg23gMBc6vteD1q", "6aVSVJl49uZRPmkaVoTjRyLu3FUElegz"};
    public final /* synthetic */ KE A00;
    public final /* synthetic */ C2237au A01;

    public static String A00(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i10, i10 + i11);
        int i13 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A03[6].charAt(12) == 'g') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[0] = "VNdWttTdUjFkQFP8JWlqZZM22OaN4Km2";
            strArr[3] = "R7Bf4UcSP1AaUkuG6x1PRuhjomEl3ayd";
            if (i13 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] ^ i12) ^ 11);
            i13++;
        }
    }

    public static void A01() {
        A02 = new byte[]{87, 90, 94, 91, 90, 77};
    }

    static {
        A01();
    }

    public ViewOnClickListenerC2236at(C2237au c2237au, KE ke) {
        this.A01 = c2237au;
        this.A00 = ke;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (AbstractC2066Vl.A02(this)) {
            return;
        }
        try {
            if (this.A00 != null) {
                this.A00.A0E(A00(0, 6, 52));
            }
        } catch (Throwable th) {
            if (A03[6].charAt(12) == 'g') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[5] = "pv88L2Qv4olKMchOaCJJbvU1UVpDqKti";
            strArr[2] = "h7t7tL7arYQ0kU7vuWKWmfHlmY1cI4wR";
            AbstractC2066Vl.A00(th, this);
        }
    }
}
