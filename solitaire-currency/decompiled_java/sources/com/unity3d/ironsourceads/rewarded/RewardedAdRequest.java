package com.unity3d.ironsourceads.rewarded;

import android.os.Bundle;
import com.ironsource.oo;
import com.ironsource.qm;
import com.ironsource.xi;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class RewardedAdRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f23872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f23873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final Bundle f23874c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final oo f23875d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final String f23876e;

    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final String f23877a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final String f23878b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private Bundle f23879c;

        public Builder(@NotNull String instanceId, @NotNull String adm) {
            t.i(instanceId, "instanceId");
            t.i(adm, "adm");
            this.f23877a = instanceId;
            this.f23878b = adm;
        }

        @NotNull
        public final RewardedAdRequest build() {
            return new RewardedAdRequest(this.f23877a, this.f23878b, this.f23879c, null);
        }

        @NotNull
        public final String getAdm() {
            return this.f23878b;
        }

        @NotNull
        public final String getInstanceId() {
            return this.f23877a;
        }

        @NotNull
        public final Builder withExtraParams(@NotNull Bundle extraParams) {
            t.i(extraParams, "extraParams");
            this.f23879c = extraParams;
            return this;
        }
    }

    private RewardedAdRequest(String str, String str2, Bundle bundle) {
        this.f23872a = str;
        this.f23873b = str2;
        this.f23874c = bundle;
        this.f23875d = new qm(str);
        String strB = xi.b();
        t.h(strB, "generateMultipleUniqueInstanceId()");
        this.f23876e = strB;
    }

    @NotNull
    public final String getAdId$mediationsdk_release() {
        return this.f23876e;
    }

    @NotNull
    public final String getAdm() {
        return this.f23873b;
    }

    @Nullable
    public final Bundle getExtraParams() {
        return this.f23874c;
    }

    @NotNull
    public final String getInstanceId() {
        return this.f23872a;
    }

    @NotNull
    public final oo getProviderName$mediationsdk_release() {
        return this.f23875d;
    }

    public /* synthetic */ RewardedAdRequest(String str, String str2, Bundle bundle, k kVar) {
        this(str, str2, bundle);
    }
}
