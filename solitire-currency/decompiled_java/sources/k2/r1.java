package k2;

import android.os.Bundle;
import androidx.annotation.Nullable;
import k2.h;

/* JADX INFO: compiled from: HeartRating.java */
/* JADX INFO: loaded from: classes2.dex */
public final class r1 extends y2 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h.a<r1> f29424d = new h.a() { // from class: k2.q1
        @Override // k2.h.a
        public final h fromBundle(Bundle bundle) {
            return r1.e(bundle);
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f29425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f29426c;

    public r1() {
        this.f29425b = false;
        this.f29426c = false;
    }

    private static String c(int i10) {
        return Integer.toString(i10, 36);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static r1 e(Bundle bundle) {
        a4.a.a(bundle.getInt(c(0), -1) == 0);
        return bundle.getBoolean(c(1), false) ? new r1(bundle.getBoolean(c(2), false)) : new r1();
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof r1)) {
            return false;
        }
        r1 r1Var = (r1) obj;
        return this.f29426c == r1Var.f29426c && this.f29425b == r1Var.f29425b;
    }

    public int hashCode() {
        return e5.k.b(Boolean.valueOf(this.f29425b), Boolean.valueOf(this.f29426c));
    }

    @Override // k2.h
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(c(0), 0);
        bundle.putBoolean(c(1), this.f29425b);
        bundle.putBoolean(c(2), this.f29426c);
        return bundle;
    }

    public r1(boolean z10) {
        this.f29425b = true;
        this.f29426c = z10;
    }
}
