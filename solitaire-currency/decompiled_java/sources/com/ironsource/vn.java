package com.ironsource;

import com.unity3d.services.UnityAdsConstants;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class vn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f15930a;

    public vn(@NotNull String baseControllerUrl) {
        kotlin.jvm.internal.t.i(baseControllerUrl, "baseControllerUrl");
        this.f15930a = baseControllerUrl;
    }

    @NotNull
    public final String a() {
        String str = this.f15930a;
        String strSubstring = str.substring(0, p9.r.k0(str, UnityAdsConstants.DefaultUrls.AD_ASSET_PATH, 0, false, 6, null));
        kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }
}
