package com.ironsource;

import java.lang.ref.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class cn implements bn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private t5 f11596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private WeakReference<v5> f11597b = new WeakReference<>(null);

    public final void a(@NotNull t5 loadListener) {
        kotlin.jvm.internal.t.i(loadListener, "loadListener");
        this.f11596a = loadListener;
    }

    @Override // com.ironsource.bn
    public void onBannerClick() {
        v5 v5Var = this.f11597b.get();
        if (v5Var != null) {
            v5Var.onBannerClick();
        }
    }

    @Override // com.ironsource.bn
    public void onBannerLoadFail(@NotNull String description) {
        kotlin.jvm.internal.t.i(description, "description");
        t5 t5Var = this.f11596a;
        if (t5Var != null) {
            t5Var.onBannerLoadFail(description);
        }
    }

    @Override // com.ironsource.bn
    public void onBannerLoadSuccess(@NotNull mi adInstance, @NotNull jf adContainer) {
        kotlin.jvm.internal.t.i(adInstance, "adInstance");
        kotlin.jvm.internal.t.i(adContainer, "adContainer");
        t5 t5Var = this.f11596a;
        if (t5Var != null) {
            t5Var.onBannerLoadSuccess(adInstance, adContainer);
        }
    }

    @Override // com.ironsource.bn
    public void onBannerShowSuccess() {
        v5 v5Var = this.f11597b.get();
        if (v5Var != null) {
            v5Var.onBannerShowSuccess();
        }
    }

    public final void a(@NotNull v5 showListener) {
        kotlin.jvm.internal.t.i(showListener, "showListener");
        this.f11597b = new WeakReference<>(showListener);
    }

    @Override // com.ironsource.bn
    public void onBannerInitSuccess() {
    }

    @Override // com.ironsource.bn
    public void onBannerInitFailed(@Nullable String str) {
    }
}
