package com.facebook.ads.redexgen.core;

import android.net.Uri;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Lv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract /* synthetic */ class AbstractC1822Lv {
    public static String[] A00 = {"kAVLkaOPTenDjNStg3AqGnsJ6mUxlh", "fdMZ5FC2", "RcZfMO7G0A", "D26EIYlb", "rGLz93weyR", "", "QBfYKUrTqNlMcNacns9hu", ""};

    public static /* synthetic */ String A00(AnonymousClass56 anonymousClass56) {
        if (anonymousClass56.A08 != null) {
            return anonymousClass56.A08;
        }
        Uri uri = anonymousClass56.A06;
        String[] strArr = A00;
        if (strArr[5].length() != strArr[7].length()) {
            throw new RuntimeException();
        }
        A00[6] = "qSUHhmHVZn4hNc1KXxuwz";
        return uri.toString();
    }
}
