package b4;

import android.os.Bundle;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import k2.h;

/* JADX INFO: compiled from: VideoSize.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b0 implements k2.h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b0 f2077e = new b0(0, 0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final h.a<b0> f2078f = new h.a() { // from class: b4.a0
        @Override // k2.h.a
        public final k2.h fromBundle(Bundle bundle) {
            return b0.c(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @IntRange(from = 0)
    public final int f2079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @IntRange(from = 0)
    public final int f2080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @IntRange(from = 0, to = 359)
    public final int f2081c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @FloatRange(from = 0.0d, fromInclusive = false)
    public final float f2082d;

    public b0(@IntRange(from = 0) int i10, @IntRange(from = 0) int i11) {
        this(i10, i11, 0, 1.0f);
    }

    private static String b(int i10) {
        return Integer.toString(i10, 36);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ b0 c(Bundle bundle) {
        return new b0(bundle.getInt(b(0), 0), bundle.getInt(b(1), 0), bundle.getInt(b(2), 0), bundle.getFloat(b(3), 1.0f));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return this.f2079a == b0Var.f2079a && this.f2080b == b0Var.f2080b && this.f2081c == b0Var.f2081c && this.f2082d == b0Var.f2082d;
    }

    public int hashCode() {
        return ((((((217 + this.f2079a) * 31) + this.f2080b) * 31) + this.f2081c) * 31) + Float.floatToRawIntBits(this.f2082d);
    }

    @Override // k2.h
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(b(0), this.f2079a);
        bundle.putInt(b(1), this.f2080b);
        bundle.putInt(b(2), this.f2081c);
        bundle.putFloat(b(3), this.f2082d);
        return bundle;
    }

    public b0(@IntRange(from = 0) int i10, @IntRange(from = 0) int i11, @IntRange(from = 0, to = 359) int i12, @FloatRange(from = 0.0d, fromInclusive = false) float f10) {
        this.f2079a = i10;
        this.f2080b = i11;
        this.f2081c = i12;
        this.f2082d = f10;
    }
}
