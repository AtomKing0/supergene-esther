package com.ironsource;

import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class as implements og {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final a8 f11311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private ConcurrentHashMap<String, Integer> f11312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private ConcurrentHashMap<String, Long> f11313c;

    public as(@NotNull a8 storage) {
        kotlin.jvm.internal.t.i(storage, "storage");
        this.f11311a = storage;
        this.f11312b = new ConcurrentHashMap<>();
        this.f11313c = new ConcurrentHashMap<>();
    }

    @Override // com.ironsource.og
    public int a(@NotNull String identifier) {
        kotlin.jvm.internal.t.i(identifier, "identifier");
        Integer num = this.f11312b.get(identifier);
        if (num != null) {
            return num.intValue();
        }
        Integer numC = this.f11311a.c(identifier);
        if (numC == null) {
            this.f11312b.put(identifier, 0);
            return 0;
        }
        int iIntValue = numC.intValue();
        this.f11312b.put(identifier, Integer.valueOf(iIntValue));
        return iIntValue;
    }

    @Override // com.ironsource.og
    @Nullable
    public Long b(@NotNull String identifier) {
        kotlin.jvm.internal.t.i(identifier, "identifier");
        Long l10 = this.f11313c.get(identifier);
        if (l10 != null) {
            return l10;
        }
        Long lA = this.f11311a.a(identifier);
        if (lA == null) {
            return null;
        }
        long jLongValue = lA.longValue();
        this.f11313c.put(identifier, Long.valueOf(jLongValue));
        return Long.valueOf(jLongValue);
    }

    @Override // com.ironsource.og
    public void a(int i10, @NotNull String identifier) {
        kotlin.jvm.internal.t.i(identifier, "identifier");
        this.f11312b.put(identifier, Integer.valueOf(i10));
        this.f11311a.a(identifier, i10);
    }

    @Override // com.ironsource.og
    public void a(long j10, @NotNull String identifier) {
        kotlin.jvm.internal.t.i(identifier, "identifier");
        this.f11313c.put(identifier, Long.valueOf(j10));
        this.f11311a.a(identifier, j10);
    }
}
