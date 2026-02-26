package io.sentry;

import java.util.Date;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SentryNanotimeDate.java */
/* JADX INFO: loaded from: classes5.dex */
public final class i7 extends n5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Date f27891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f27892b;

    public i7() {
        this(n.d(), System.nanoTime());
    }

    private long h(@NotNull i7 i7Var, @NotNull i7 i7Var2) {
        return i7Var.g() + (i7Var2.f27892b - i7Var.f27892b);
    }

    @Override // io.sentry.n5, java.lang.Comparable
    /* JADX INFO: renamed from: a */
    public int compareTo(@NotNull n5 n5Var) {
        if (!(n5Var instanceof i7)) {
            return super.compareTo(n5Var);
        }
        i7 i7Var = (i7) n5Var;
        long time = this.f27891a.getTime();
        long time2 = i7Var.f27891a.getTime();
        return time == time2 ? Long.valueOf(this.f27892b).compareTo(Long.valueOf(i7Var.f27892b)) : Long.valueOf(time).compareTo(Long.valueOf(time2));
    }

    @Override // io.sentry.n5
    public long c(@NotNull n5 n5Var) {
        return n5Var instanceof i7 ? this.f27892b - ((i7) n5Var).f27892b : super.c(n5Var);
    }

    @Override // io.sentry.n5
    public long f(@Nullable n5 n5Var) {
        if (n5Var == null || !(n5Var instanceof i7)) {
            return super.f(n5Var);
        }
        i7 i7Var = (i7) n5Var;
        return compareTo(n5Var) < 0 ? h(this, i7Var) : h(i7Var, this);
    }

    @Override // io.sentry.n5
    public long g() {
        return n.a(this.f27891a);
    }

    public i7(@NotNull Date date, long j10) {
        this.f27891a = date;
        this.f27892b = j10;
    }
}
