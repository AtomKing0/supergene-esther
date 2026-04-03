package com.facebook.ads.redexgen.core;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.eY, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2461eY {
    public float A00;
    public LF A01;
    public Map<String, String> A02;

    public C2461eY(LF lf) {
        this(lf, 0.0f);
    }

    public C2461eY(LF lf, float f10) {
        this(lf, f10, null);
    }

    public C2461eY(@Nullable LF lf, float f10, Map<String, String> windowParams) {
        this.A01 = lf;
        this.A00 = f10;
        if (windowParams != null) {
            this.A02 = windowParams;
        } else {
            this.A02 = new HashMap();
        }
    }

    public final float A00() {
        return this.A00;
    }

    public final int A01() {
        return this.A01.A03();
    }

    public final LF A02() {
        return this.A01;
    }

    public final Map<String, String> A03() {
        return this.A02;
    }

    public final boolean A04() {
        return this.A01 == LF.A0I;
    }
}
