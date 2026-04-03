package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.q;

/* JADX INFO: loaded from: classes4.dex */
public final class h {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19164a;

        static {
            int[] iArr = new int[g.values().length];
            try {
                iArr[g.STATIC_AD_UNKNOWN_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[g.STATIC_AD_WEBVIEW_DATA_WITH_DEFAULT_BASE_URL_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[g.STATIC_AD_WEBVIEW_RECEIVED_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[g.STATIC_AD_WEBVIEW_RENDER_PROCESS_GONE_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f19164a = iArr;
        }
    }

    @NotNull
    public static final i a(@NotNull g gVar) {
        t.i(gVar, "<this>");
        int i10 = a.f19164a[gVar.ordinal()];
        if (i10 == 1) {
            return i.STATIC_BANNER_AD_UNKNOWN_ERROR;
        }
        if (i10 == 2) {
            return i.STATIC_BANNER_AD_WEBVIEW_DATA_WITH_DEFAULT_BASE_URL_ERROR;
        }
        if (i10 == 3) {
            return i.STATIC_BANNER_AD_WEBVIEW_RECEIVED_ERROR;
        }
        if (i10 == 4) {
            return i.STATIC_BANNER_AD_WEBVIEW_RENDER_PROCESS_GONE_ERROR;
        }
        throw new q();
    }

    @NotNull
    public static final j b(@NotNull g gVar) {
        t.i(gVar, "<this>");
        int i10 = a.f19164a[gVar.ordinal()];
        if (i10 == 1) {
            return j.STATIC_FULLSCREEN_AD_UNKNOWN_ERROR;
        }
        if (i10 == 2) {
            return j.STATIC_FULLSCREEN_AD_WEBVIEW_DATA_WITH_DEFAULT_BASE_URL_ERROR;
        }
        if (i10 == 3) {
            return j.STATIC_FULLSCREEN_AD_WEBVIEW_RECEIVED_ERROR;
        }
        if (i10 == 4) {
            return j.STATIC_FULLSCREEN_AD_WEBVIEW_RENDER_PROCESS_GONE_ERROR;
        }
        throw new q();
    }
}
