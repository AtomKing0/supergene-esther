package com.unity3d.services.banners;

import android.content.Context;
import com.unity3d.services.core.misc.ViewUtilities;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import j9.c;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: UnityBannerSize.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class UnityBannerSize {
    private final int height;
    private final int width;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final UnityBannerSize leaderboard = new UnityBannerSize(728, 90);

    @NotNull
    private static final UnityBannerSize iabStandard = new UnityBannerSize(468, 60);

    @NotNull
    private static final UnityBannerSize standard = new UnityBannerSize(Sdk$SDKError.b.WEBVIEW_ERROR_VALUE, 50);

    /* JADX INFO: compiled from: UnityBannerSize.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final UnityBannerSize getDynamicSize(@NotNull Context context) {
            t.i(context, "context");
            int iC = c.c(ViewUtilities.dpFromPx(context, context.getResources().getDisplayMetrics().widthPixels));
            return iC >= getLeaderboard().getWidth() ? getLeaderboard() : iC >= getIabStandard().getWidth() ? getIabStandard() : getStandard();
        }

        @NotNull
        public final UnityBannerSize getIabStandard() {
            return UnityBannerSize.iabStandard;
        }

        @NotNull
        public final UnityBannerSize getLeaderboard() {
            return UnityBannerSize.leaderboard;
        }

        @NotNull
        public final UnityBannerSize getStandard() {
            return UnityBannerSize.standard;
        }
    }

    public UnityBannerSize(int i10, int i11) {
        this.width = i10;
        this.height = i11;
    }

    @NotNull
    public static final UnityBannerSize getDynamicSize(@NotNull Context context) {
        return Companion.getDynamicSize(context);
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }
}
