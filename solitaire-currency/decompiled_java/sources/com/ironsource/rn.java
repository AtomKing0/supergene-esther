package com.ironsource;

import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class rn implements ne {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final a8 f14719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private ConcurrentHashMap<String, Long> f14720b;

    public rn(@NotNull a8 storage) {
        kotlin.jvm.internal.t.i(storage, "storage");
        this.f14719a = storage;
        this.f14720b = new ConcurrentHashMap<>();
    }

    @Override // com.ironsource.ne
    @Nullable
    public Long a(@NotNull String identifier) {
        kotlin.jvm.internal.t.i(identifier, "identifier");
        Long l10 = this.f14720b.get(identifier);
        if (l10 != null) {
            return l10;
        }
        Long lB = this.f14719a.b(identifier);
        if (lB == null) {
            return null;
        }
        long jLongValue = lB.longValue();
        this.f14720b.put(identifier, Long.valueOf(jLongValue));
        return Long.valueOf(jLongValue);
    }

    @Override // com.ironsource.ne
    public void a(long j10, @NotNull String identifier) {
        kotlin.jvm.internal.t.i(identifier, "identifier");
        this.f14720b.put(identifier, Long.valueOf(j10));
        this.f14719a.b(identifier, j10);
    }
}
