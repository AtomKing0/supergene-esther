package com.ironsource;

import com.ironsource.l0;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class n0 implements l0, l0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final ReadWriteLock f14053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final Map<String, k0> f14054b;

    /* JADX WARN: Multi-variable type inference failed */
    public n0() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.ironsource.l0
    @Nullable
    public k0 a(@NotNull String adId) {
        kotlin.jvm.internal.t.i(adId, "adId");
        this.f14053a.readLock().lock();
        try {
            return this.f14054b.get(adId);
        } finally {
            this.f14053a.readLock().unlock();
        }
    }

    public n0(@NotNull ReadWriteLock readWriteLock) {
        kotlin.jvm.internal.t.i(readWriteLock, "readWriteLock");
        this.f14053a = readWriteLock;
        this.f14054b = new LinkedHashMap();
    }

    @Override // com.ironsource.l0
    @NotNull
    public List<k0> a() {
        this.f14053a.readLock().lock();
        List<k0> listP0 = kotlin.collections.d0.P0(this.f14054b.values());
        this.f14053a.readLock().unlock();
        return listP0;
    }

    public /* synthetic */ n0(ReadWriteLock readWriteLock, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? new ReentrantReadWriteLock() : readWriteLock);
    }

    @Override // com.ironsource.l0.a
    public void a(@NotNull j1 adStatus, @NotNull String adId) {
        kotlin.jvm.internal.t.i(adStatus, "adStatus");
        kotlin.jvm.internal.t.i(adId, "adId");
        this.f14053a.writeLock().lock();
        try {
            k0 k0Var = this.f14054b.get(adId);
            if (k0Var != null) {
                k0Var.a(adStatus);
                k0Var.a(System.currentTimeMillis() / 1000.0d);
            }
        } finally {
            this.f14053a.writeLock().unlock();
        }
    }

    @Override // com.ironsource.l0.a
    public void a(@NotNull k0 adInfo) {
        kotlin.jvm.internal.t.i(adInfo, "adInfo");
        this.f14053a.writeLock().lock();
        try {
            if (this.f14054b.get(adInfo.c()) == null) {
                this.f14054b.put(adInfo.c(), adInfo);
            }
        } finally {
            this.f14053a.writeLock().unlock();
        }
    }

    @Override // com.ironsource.l0.a
    public void a(@NotNull JSONObject json, @NotNull j1 adStatus, @NotNull String adId) {
        kotlin.jvm.internal.t.i(json, "json");
        kotlin.jvm.internal.t.i(adStatus, "adStatus");
        kotlin.jvm.internal.t.i(adId, "adId");
        this.f14053a.writeLock().lock();
        try {
            k0 k0Var = this.f14054b.get(adId);
            if (k0Var != null) {
                String bundleId = json.optString("bundleId");
                kotlin.jvm.internal.t.h(bundleId, "bundleId");
                boolean z10 = true;
                if (bundleId.length() > 0) {
                    k0Var.a(bundleId);
                }
                String dynamicDemandSourceId = json.optString("dynamicDemandSource");
                kotlin.jvm.internal.t.h(dynamicDemandSourceId, "dynamicDemandSourceId");
                if (dynamicDemandSourceId.length() <= 0) {
                    z10 = false;
                }
                if (z10) {
                    k0Var.a(we.f16032b.a(dynamicDemandSourceId));
                }
                k0Var.a(adStatus);
            }
        } finally {
            this.f14053a.writeLock().unlock();
        }
    }
}
