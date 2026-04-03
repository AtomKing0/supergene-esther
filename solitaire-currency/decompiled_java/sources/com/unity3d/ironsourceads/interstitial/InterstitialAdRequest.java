package com.unity3d.ironsourceads.interstitial;

import android.os.Bundle;
import com.ironsource.oo;
import com.ironsource.qm;
import com.ironsource.xi;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class InterstitialAdRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f23859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f23860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final Bundle f23861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final oo f23862d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final String f23863e;

    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final String f23864a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final String f23865b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private Bundle f23866c;

        public Builder(@NotNull String instanceId, @NotNull String adm) {
            t.i(instanceId, "instanceId");
            t.i(adm, "adm");
            this.f23864a = instanceId;
            this.f23865b = adm;
        }

        @NotNull
        public final InterstitialAdRequest build() {
            return new InterstitialAdRequest(this.f23864a, this.f23865b, this.f23866c, null);
        }

        @NotNull
        public final String getAdm() {
            return this.f23865b;
        }

        @NotNull
        public final String getInstanceId() {
            return this.f23864a;
        }

        @NotNull
        public final Builder withExtraParams(@NotNull Bundle extraParams) {
            t.i(extraParams, "extraParams");
            this.f23866c = extraParams;
            return this;
        }
    }

    private InterstitialAdRequest(String str, String str2, Bundle bundle) {
        this.f23859a = str;
        this.f23860b = str2;
        this.f23861c = bundle;
        this.f23862d = new qm(str);
        String strB = xi.b();
        t.h(strB, "generateMultipleUniqueInstanceId()");
        this.f23863e = strB;
    }

    @NotNull
    public final String getAdId$mediationsdk_release() {
        return this.f23863e;
    }

    @NotNull
    public final String getAdm() {
        return this.f23860b;
    }

    @Nullable
    public final Bundle getExtraParams() {
        return this.f23861c;
    }

    @NotNull
    public final String getInstanceId() {
        return this.f23859a;
    }

    @NotNull
    public final oo getProviderName$mediationsdk_release() {
        return this.f23862d;
    }

    public /* synthetic */ InterstitialAdRequest(String str, String str2, Bundle bundle, k kVar) {
        this(str, str2, bundle);
    }
}
