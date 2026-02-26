package com.ironsource;

import com.ironsource.ig;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class cq implements ig, ig.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private bq f11612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f11613b;

    @Override // com.ironsource.ig
    @Nullable
    public ak a() {
        bq bqVar = this.f11612a;
        if (bqVar != null) {
            return new ak(bqVar);
        }
        return null;
    }

    @Override // com.ironsource.ig
    @Nullable
    public oi b() {
        bq bqVar = this.f11612a;
        if (bqVar != null) {
            return new oi(bqVar);
        }
        return null;
    }

    @Override // com.ironsource.ig
    public boolean c() {
        return this.f11613b;
    }

    @Override // com.ironsource.ig.a
    public void d() {
        this.f11613b = true;
    }

    @Override // com.ironsource.ig.a
    public void a(@NotNull bq sdkConfig) {
        kotlin.jvm.internal.t.i(sdkConfig, "sdkConfig");
        this.f11612a = sdkConfig;
    }
}
