package com.facebook.ads.redexgen.core;

import android.media.metrics.LogSessionId;
import java.util.Objects;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7m, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C14667m {
    public static final C14667m A03;
    public final String A00;
    public final C14657l A01;
    public final Object A02;

    static {
        C14667m c14667m;
        if (AbstractC13764a.A02 < 31) {
            c14667m = new C14667m("");
        } else {
            c14667m = new C14667m(C14657l.A01, "");
        }
        A03 = c14667m;
    }

    public C14667m(C14657l c14657l, String str) {
        this.A01 = c14657l;
        this.A00 = str;
        this.A02 = new Object();
    }

    public C14667m(String str) {
        C3M.A08(AbstractC13764a.A02 < 31);
        this.A00 = str;
        this.A01 = null;
        this.A02 = new Object();
    }

    public final LogSessionId A00() {
        return ((C14657l) C3M.A01(this.A01)).A00;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C14667m)) {
            return false;
        }
        C14667m c14667m = (C14667m) obj;
        if (Objects.equals(this.A00, c14667m.A00) && Objects.equals(this.A01, c14667m.A01) && Objects.equals(this.A02, c14667m.A02)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.A00, this.A01, this.A02);
    }
}
