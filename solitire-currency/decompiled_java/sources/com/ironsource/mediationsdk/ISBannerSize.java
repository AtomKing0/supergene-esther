package com.ironsource.mediationsdk;

import androidx.compose.animation.core.AnimationConstants;
import com.vungle.ads.internal.protos.Sdk$SDKError;

/* JADX INFO: loaded from: classes4.dex */
public class ISBannerSize {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f13243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f13244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f13245c;
    public ISContainerParams containerParams;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f13246d;
    public static final ISBannerSize BANNER = l.a(l.f13634a, Sdk$SDKError.b.WEBVIEW_ERROR_VALUE, 50);
    public static final ISBannerSize LARGE = l.a(l.f13635b, Sdk$SDKError.b.WEBVIEW_ERROR_VALUE, 90);
    public static final ISBannerSize RECTANGLE = l.a(l.f13636c, AnimationConstants.DefaultDurationMillis, 250);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected static final ISBannerSize f13242e = l.a();
    public static final ISBannerSize SMART = l.a(l.f13638e, 0, 0);

    public ISBannerSize(int i10, int i11) {
        this("CUSTOM", i10, i11);
    }

    public static int getMaximalAdaptiveHeight(int i10) {
        return l.b(i10);
    }

    public String getDescription() {
        return this.f13245c;
    }

    public int getHeight() {
        return this.f13244b;
    }

    public int getWidth() {
        return this.f13243a;
    }

    public boolean isAdaptive() {
        return this.f13246d;
    }

    public boolean isSmart() {
        return this.f13245c.equals(l.f13638e);
    }

    public void setAdaptive(boolean z10) {
        this.f13246d = z10;
    }

    public void setContainerParams(ISContainerParams iSContainerParams) {
        if (l.a(iSContainerParams, this.f13243a, this.f13244b)) {
            this.containerParams = iSContainerParams;
        }
    }

    public ISBannerSize(String str, int i10, int i11) {
        this.f13245c = str;
        this.f13243a = i10;
        this.f13244b = i11;
        this.containerParams = new ISContainerParams(i10, i11);
    }
}
