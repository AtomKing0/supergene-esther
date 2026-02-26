package io.sentry;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: MemoryCollectionData.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class m2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final long f27998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f27999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    final n5 f28000c;

    public m2(long j10, long j11, @NotNull n5 n5Var) {
        this.f27998a = j10;
        this.f27999b = j11;
        this.f28000c = n5Var;
    }

    @NotNull
    public n5 a() {
        return this.f28000c;
    }

    public long b() {
        return this.f27998a;
    }

    public long c() {
        return this.f27999b;
    }

    public m2(long j10, @NotNull n5 n5Var) {
        this(j10, -1L, n5Var);
    }
}
