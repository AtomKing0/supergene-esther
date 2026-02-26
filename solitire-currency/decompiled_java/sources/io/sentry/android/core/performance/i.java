package io.sentry.android.core.performance;

import android.os.SystemClock;
import io.sentry.h7;
import io.sentry.n;
import io.sentry.n5;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TimeSpan.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public class i implements Comparable<i> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private String f27473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f27474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f27475c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f27476d;

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NotNull i iVar) {
        return Long.compare(this.f27474b, iVar.f27474b);
    }

    @Nullable
    public String c() {
        return this.f27473a;
    }

    public long d() {
        if (o()) {
            return this.f27476d - this.f27475c;
        }
        return 0L;
    }

    @Nullable
    public n5 e() {
        if (o()) {
            return new h7(n.i(f()));
        }
        return null;
    }

    public long f() {
        if (n()) {
            return this.f27474b + d();
        }
        return 0L;
    }

    public double g() {
        return n.j(f());
    }

    @Nullable
    public n5 h() {
        if (n()) {
            return new h7(n.i(i()));
        }
        return null;
    }

    public long i() {
        return this.f27474b;
    }

    public double j() {
        return n.j(this.f27474b);
    }

    public long k() {
        return this.f27475c;
    }

    public boolean l() {
        return this.f27475c == 0;
    }

    public boolean m() {
        return this.f27476d == 0;
    }

    public boolean n() {
        return this.f27475c != 0;
    }

    public boolean o() {
        return this.f27476d != 0;
    }

    public void p() {
        this.f27473a = null;
        this.f27475c = 0L;
        this.f27476d = 0L;
        this.f27474b = 0L;
    }

    public void q(long j10) {
        this.f27475c = j10;
        this.f27474b = System.currentTimeMillis() - (SystemClock.uptimeMillis() - this.f27475c);
    }

    public void r(@Nullable String str, long j10, long j11, long j12) {
        this.f27473a = str;
        this.f27474b = j10;
        this.f27475c = j11;
        this.f27476d = j12;
    }

    public void s() {
        this.f27475c = SystemClock.uptimeMillis();
        this.f27474b = System.currentTimeMillis();
    }

    public void t() {
        this.f27476d = SystemClock.uptimeMillis();
    }
}
