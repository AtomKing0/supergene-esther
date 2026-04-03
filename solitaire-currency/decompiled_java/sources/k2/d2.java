package k2;

import androidx.annotation.Nullable;
import com.ironsource.mediationsdk.logger.IronSourceError;
import l3.a0;

/* JADX INFO: compiled from: MediaPeriodInfo.java */
/* JADX INFO: loaded from: classes2.dex */
final class d2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a0.b f29065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f29066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f29067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f29068d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f29069e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f29070f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f29071g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f29072h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f29073i;

    d2(a0.b bVar, long j10, long j11, long j12, long j13, boolean z10, boolean z11, boolean z12, boolean z13) {
        boolean z14 = false;
        a4.a.a(!z13 || z11);
        a4.a.a(!z12 || z11);
        if (!z10 || (!z11 && !z12 && !z13)) {
            z14 = true;
        }
        a4.a.a(z14);
        this.f29065a = bVar;
        this.f29066b = j10;
        this.f29067c = j11;
        this.f29068d = j12;
        this.f29069e = j13;
        this.f29070f = z10;
        this.f29071g = z11;
        this.f29072h = z12;
        this.f29073i = z13;
    }

    public d2 a(long j10) {
        return j10 == this.f29067c ? this : new d2(this.f29065a, this.f29066b, j10, this.f29068d, this.f29069e, this.f29070f, this.f29071g, this.f29072h, this.f29073i);
    }

    public d2 b(long j10) {
        return j10 == this.f29066b ? this : new d2(this.f29065a, j10, this.f29067c, this.f29068d, this.f29069e, this.f29070f, this.f29071g, this.f29072h, this.f29073i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d2.class != obj.getClass()) {
            return false;
        }
        d2 d2Var = (d2) obj;
        return this.f29066b == d2Var.f29066b && this.f29067c == d2Var.f29067c && this.f29068d == d2Var.f29068d && this.f29069e == d2Var.f29069e && this.f29070f == d2Var.f29070f && this.f29071g == d2Var.f29071g && this.f29072h == d2Var.f29072h && this.f29073i == d2Var.f29073i && a4.o0.c(this.f29065a, d2Var.f29065a);
    }

    public int hashCode() {
        return ((((((((((((((((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + this.f29065a.hashCode()) * 31) + ((int) this.f29066b)) * 31) + ((int) this.f29067c)) * 31) + ((int) this.f29068d)) * 31) + ((int) this.f29069e)) * 31) + (this.f29070f ? 1 : 0)) * 31) + (this.f29071g ? 1 : 0)) * 31) + (this.f29072h ? 1 : 0)) * 31) + (this.f29073i ? 1 : 0);
    }
}
