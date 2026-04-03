package com.facebook.ads.redexgen.core;

import android.os.Bundle;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.oi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C3055oi implements C1S {
    public final C3059om A00;

    @Deprecated
    public final C15109r A01;
    public final C3057ok A02;
    public final C2Q A03;

    @Deprecated
    public final C3056oj A04;
    public final C3053og A05;
    public final String A06;
    public static String[] A07 = {"wAM8vtdO0lmHfSdh0aX8JSKdnwpCp9D2", "", "J6SB4ddL0FfEeVIHYuGnUGetWM2QRdUO", "0HTq7SjPEUFdYYph8tikUta3pLjb69Rn", "wGA6vSFg01QHk42FD2L8p637KRkqAXcn", "9eG6h6QaFREs2gWO0", "Z5vutuZNVsi2rK7c87KXUNl8wBJYnGEL", "V2BGt2aUfGoyLxnwwGFsOMeTNor3H3xe"};
    public static final C3055oi A09 = new C2I().A05();
    public static final C1R<C3055oi> A08 = new C1R() { // from class: com.facebook.ads.redexgen.X.oo
        @Override // com.facebook.ads.redexgen.core.C1R
        public final C1S A6X(Bundle bundle) {
            return C3055oi.A00(bundle);
        }
    };

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 8 out of bounds for length 8
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static C3055oi A00(Bundle bundle) {
        String str = (String) C3M.A01(bundle.getString(A02(0), ""));
        Bundle bundle2 = bundle.getBundle(A02(1));
        C3057ok c3057ok = bundle2 == null ? C3057ok.A07 : (C3057ok) C3057ok.A06.A6X(bundle2);
        Bundle bundle3 = bundle.getBundle(A02(2));
        C3053og c3053og = bundle3 == null ? C3053og.A0Z : (C3053og) C3053og.A0Y.A6X(bundle3);
        Bundle bundle4 = bundle.getBundle(A02(3));
        return new C3055oi(str, bundle4 == null ? C15109r.A00 : (C15109r) C3059om.A05.A6X(bundle4), null, c3057ok, c3053og);
    }

    public C3055oi(String str, C15109r c15109r, C3056oj c3056oj, C3057ok c3057ok, C3053og c3053og) {
        this.A06 = str;
        this.A03 = c3056oj;
        this.A04 = c3056oj;
        this.A02 = c3057ok;
        this.A05 = c3053og;
        this.A00 = c15109r;
        this.A01 = c15109r;
    }

    public static String A02(int i10) {
        return Integer.toString(i10, 36);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3055oi)) {
            return false;
        }
        C3055oi c3055oi = (C3055oi) obj;
        if (AbstractC13764a.A1E(this.A06, c3055oi.A06)) {
            C3059om c3059om = this.A00;
            C3059om c3059om2 = c3055oi.A00;
            String[] strArr = A07;
            if (strArr[7].charAt(22) != strArr[2].charAt(22)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A07;
            strArr2[7] = "WE1TlvFnuMEFfhCqOSZQGPel0cAOxnij";
            strArr2[2] = "QIjSvgjDyRqWUwkha5pDZVewjWBdao8T";
            if (c3059om.equals(c3059om2) && AbstractC13764a.A1E(this.A03, c3055oi.A03) && AbstractC13764a.A1E(this.A02, c3055oi.A02) && AbstractC13764a.A1E(this.A05, c3055oi.A05)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int result = this.A06.hashCode();
        int i10 = result * 31;
        int result2 = this.A03 != null ? this.A03.hashCode() : 0;
        int iHashCode = (((i10 + result2) * 31) + this.A02.hashCode()) * 31;
        C3059om c3059om = this.A00;
        String[] strArr = A07;
        String str = strArr[4];
        String str2 = strArr[3];
        int iCharAt = str.charAt(31);
        int result3 = str2.charAt(31);
        if (iCharAt != result3) {
            throw new RuntimeException();
        }
        String[] strArr2 = A07;
        strArr2[7] = "oKnJE1KY80M0C2djBAWfSHeSjkObNKTB";
        strArr2[2] = "bdrBBUaZbF1SVnsIGw0ZL6eMFfyDgZAn";
        int result4 = c3059om.hashCode();
        return ((iHashCode + result4) * 31) + this.A05.hashCode();
    }
}
