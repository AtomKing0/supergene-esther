package com.unity3d.ironsourceads;

import android.content.Context;
import com.ironsource.pi;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class IronSourceAds {

    @NotNull
    public static final IronSourceAds INSTANCE = new IronSourceAds();

    public enum AdFormat {
        BANNER("Banner"),
        INTERSTITIAL("Interstitial"),
        REWARDED("RewardedVideo");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final String f23835a;

        AdFormat(String str) {
            this.f23835a = str;
        }

        @NotNull
        public final String getValue() {
            return this.f23835a;
        }
    }

    private IronSourceAds() {
    }

    public static final void init(@NotNull Context context, @NotNull InitRequest initRequest, @NotNull InitListener initializationListener) {
        t.i(context, "context");
        t.i(initRequest, "initRequest");
        t.i(initializationListener, "initializationListener");
        pi.f14343a.a(context, initRequest, initializationListener);
    }
}
