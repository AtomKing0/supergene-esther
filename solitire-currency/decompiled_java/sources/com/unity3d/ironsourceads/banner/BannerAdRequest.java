package com.unity3d.ironsourceads.banner;

import android.content.Context;
import android.os.Bundle;
import com.ironsource.oo;
import com.ironsource.qm;
import com.ironsource.xi;
import com.unity3d.ironsourceads.AdSize;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class BannerAdRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Context f23840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f23841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final String f23842c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final AdSize f23843d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private final Bundle f23844e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final oo f23845f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final String f23846g;

    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final Context f23847a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final String f23848b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        private final String f23849c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        private final AdSize f23850d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        private Bundle f23851e;

        public Builder(@NotNull Context context, @NotNull String instanceId, @NotNull String adm, @NotNull AdSize size) {
            t.i(context, "context");
            t.i(instanceId, "instanceId");
            t.i(adm, "adm");
            t.i(size, "size");
            this.f23847a = context;
            this.f23848b = instanceId;
            this.f23849c = adm;
            this.f23850d = size;
        }

        @NotNull
        public final BannerAdRequest build() {
            return new BannerAdRequest(this.f23847a, this.f23848b, this.f23849c, this.f23850d, this.f23851e, null);
        }

        @NotNull
        public final String getAdm() {
            return this.f23849c;
        }

        @NotNull
        public final Context getContext() {
            return this.f23847a;
        }

        @NotNull
        public final String getInstanceId() {
            return this.f23848b;
        }

        @NotNull
        public final AdSize getSize() {
            return this.f23850d;
        }

        @NotNull
        public final Builder withExtraParams(@NotNull Bundle extraParams) {
            t.i(extraParams, "extraParams");
            this.f23851e = extraParams;
            return this;
        }
    }

    private BannerAdRequest(Context context, String str, String str2, AdSize adSize, Bundle bundle) {
        this.f23840a = context;
        this.f23841b = str;
        this.f23842c = str2;
        this.f23843d = adSize;
        this.f23844e = bundle;
        this.f23845f = new qm(str);
        String strB = xi.b();
        t.h(strB, "generateMultipleUniqueInstanceId()");
        this.f23846g = strB;
    }

    @NotNull
    public final String getAdId$mediationsdk_release() {
        return this.f23846g;
    }

    @NotNull
    public final String getAdm() {
        return this.f23842c;
    }

    @NotNull
    public final Context getContext() {
        return this.f23840a;
    }

    @Nullable
    public final Bundle getExtraParams() {
        return this.f23844e;
    }

    @NotNull
    public final String getInstanceId() {
        return this.f23841b;
    }

    @NotNull
    public final oo getProviderName$mediationsdk_release() {
        return this.f23845f;
    }

    @NotNull
    public final AdSize getSize() {
        return this.f23843d;
    }

    public /* synthetic */ BannerAdRequest(Context context, String str, String str2, AdSize adSize, Bundle bundle, k kVar) {
        this(context, str, str2, adSize, bundle);
    }
}
