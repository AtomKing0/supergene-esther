package io.sentry;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SentryDate.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class n5 implements Comparable<n5> {
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NotNull n5 n5Var) {
        return Long.valueOf(g()).compareTo(Long.valueOf(n5Var.g()));
    }

    public long c(@NotNull n5 n5Var) {
        return g() - n5Var.g();
    }

    public final boolean d(@NotNull n5 n5Var) {
        return c(n5Var) > 0;
    }

    public final boolean e(@NotNull n5 n5Var) {
        return c(n5Var) < 0;
    }

    public long f(@Nullable n5 n5Var) {
        return (n5Var == null || compareTo(n5Var) >= 0) ? g() : n5Var.g();
    }

    public abstract long g();
}
