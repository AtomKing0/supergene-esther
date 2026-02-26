package com.facebook.ads.redexgen.core;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9Y, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C9Y extends C3050od {
    public static byte[] A07;
    public static final C1R<C9Y> A08;
    public static final String A09;
    public static final String A0A;
    public static final String A0B;
    public static final String A0C;
    public static final String A0D;
    public static final String A0E;
    public final boolean A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final C3064or A04;
    public final AbstractC13262a A05;
    public final String A06;

    public static /* synthetic */ C9Y A00(Bundle bundle) {
        return new C9Y(bundle);
    }

    public static String A05(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] - i12) - 61);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A07 = new byte[]{120, -67, -54, -54, -57, -54, -124, 120, -63, -58, -68, -67, -48, -107, -83, -95, -25, -16, -13, -18, -30, -11, -66, -37, -49, 21, 30, 33, 28, 16, 35, 14, 34, 36, 31, 31, 30, 33, 35, 20, 19, -20, -21, -47, -45, -26, -18, -16, -11, -26, -95, -26, -13, -13, -16, -13, -53, -25, -19, -22, -37, -35, -104, -35, -22, -22, -25, -22, -50, -25, -34, -15, -23, -34, -36, -19, -34, -35, -103, -21, -18, -25, -19, -30, -26, -34, -103, -34, -21, -21, -24, -21};
    }

    static {
        A07();
        A08 = new C1R() { // from class: com.facebook.ads.redexgen.X.nR
            @Override // com.facebook.ads.redexgen.core.C1R
            public final C1S A6X(Bundle bundle) {
                return C9Y.A00(bundle);
            }
        };
        A0E = AbstractC13764a.A0h(1001);
        A0D = AbstractC13764a.A0h(1002);
        A0C = AbstractC13764a.A0h(1003);
        A0A = AbstractC13764a.A0h(1004);
        A0B = AbstractC13764a.A0h(1005);
        A09 = AbstractC13764a.A0h(1006);
    }

    public C9Y(int i10, Throwable th, int i11) {
        this(i10, th, null, i11, null, -1, null, 4, false);
    }

    public C9Y(int i10, Throwable th, String str, int i11, String str2, int i12, C3064or c3064or, int i13, boolean z10) {
        this(A06(i10, th, str, str2, i12, c3064or, i13), th, i11, i10, str2, i12, c3064or, i13, null, SystemClock.elapsedRealtime(), z10);
    }

    public C9Y(Bundle bundle) {
        C3064or c3064or;
        super(bundle);
        this.A03 = bundle.getInt(A0E, 2);
        this.A06 = bundle.getString(A0D);
        this.A02 = bundle.getInt(A0C, -1);
        Bundle bundle2 = bundle.getBundle(A0A);
        if (bundle2 == null) {
            c3064or = null;
        } else {
            c3064or = (C3064or) C3064or.A0b.A6X(bundle2);
        }
        this.A04 = c3064or;
        this.A01 = bundle.getInt(A0B, 4);
        this.A00 = bundle.getBoolean(A09, false);
        this.A05 = null;
    }

    public C9Y(String str, Throwable th, int i10, int i11, String str2, int i12, C3064or c3064or, int i13, AbstractC13262a abstractC13262a, long j10, boolean z10) {
        super(str, th, i10, j10);
        C3M.A07(!z10 || i11 == 1);
        C3M.A07(th != null || i11 == 3);
        this.A03 = i11;
        this.A06 = str2;
        this.A02 = i12;
        this.A04 = c3064or;
        this.A01 = i13;
        this.A05 = abstractC13262a;
        this.A00 = z10;
    }

    public static C9Y A01(IOException iOException, int i10) {
        return new C9Y(0, iOException, i10);
    }

    @Deprecated
    public static C9Y A02(RuntimeException runtimeException) {
        return A03(runtimeException, 1000);
    }

    public static C9Y A03(RuntimeException runtimeException, int i10) {
        return new C9Y(2, runtimeException, i10);
    }

    public static C9Y A04(Throwable th, String str, int i10, C3064or c3064or, int i11, boolean z10, int i12) {
        int i13 = i11;
        if (c3064or == null) {
            i13 = 4;
        }
        return new C9Y(1, th, null, i12, str, i10, c3064or, i13, z10);
    }

    public static String A06(@MetaExoPlayerCustomization(type = {"NEW_METHOD_ARGS"}, value = "Throwable cause - linked with Error reporting") int i10, Throwable th, String str, String str2, int i11, C3064or c3064or, int i12) {
        String message;
        String strA05;
        if (str == null) {
            message = th == null ? null : th.getMessage();
        } else {
            message = str;
        }
        if (message != null) {
            return message;
        }
        switch (i10) {
            case 0:
                strA05 = A05(56, 12, 59);
                break;
            case 1:
                StringBuilder sbAppend = new StringBuilder().append(str2);
                String message2 = A05(0, 14, 27);
                StringBuilder sbAppend2 = sbAppend.append(message2).append(i11);
                String message3 = A05(14, 9, 68);
                StringBuilder sbAppend3 = sbAppend2.append(message3).append(c3064or);
                String message4 = A05(23, 19, 114);
                StringBuilder sbAppend4 = sbAppend3.append(message4);
                String message5 = AbstractC13764a.A0g(i12);
                strA05 = sbAppend4.append(message5).toString();
                break;
            case 2:
            default:
                strA05 = A05(68, 24, 60);
                break;
            case 3:
                strA05 = A05(44, 12, 68);
                break;
        }
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sbAppend5 = new StringBuilder().append(strA05);
            String message6 = A05(42, 2, 116);
            return sbAppend5.append(message6).append(str).toString();
        }
        return strA05;
    }
}
