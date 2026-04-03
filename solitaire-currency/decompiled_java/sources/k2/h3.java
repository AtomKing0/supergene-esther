package k2;

import android.os.Bundle;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import k2.h;

/* JADX INFO: compiled from: StarRating.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h3 extends y2 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h.a<h3> f29123d = new h.a() { // from class: k2.g3
        @Override // k2.h.a
        public final h fromBundle(Bundle bundle) {
            return h3.e(bundle);
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @IntRange(from = 1)
    private final int f29124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f29125c;

    public h3(@IntRange(from = 1) int i10) {
        a4.a.b(i10 > 0, "maxStars must be a positive integer");
        this.f29124b = i10;
        this.f29125c = -1.0f;
    }

    private static String c(int i10) {
        return Integer.toString(i10, 36);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static h3 e(Bundle bundle) {
        a4.a.a(bundle.getInt(c(0), -1) == 2);
        int i10 = bundle.getInt(c(1), 5);
        float f10 = bundle.getFloat(c(2), -1.0f);
        return f10 == -1.0f ? new h3(i10) : new h3(i10, f10);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof h3)) {
            return false;
        }
        h3 h3Var = (h3) obj;
        return this.f29124b == h3Var.f29124b && this.f29125c == h3Var.f29125c;
    }

    public int hashCode() {
        return e5.k.b(Integer.valueOf(this.f29124b), Float.valueOf(this.f29125c));
    }

    @Override // k2.h
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(c(0), 2);
        bundle.putInt(c(1), this.f29124b);
        bundle.putFloat(c(2), this.f29125c);
        return bundle;
    }

    public h3(@IntRange(from = 1) int i10, @FloatRange(from = 0.0d) float f10) {
        a4.a.b(i10 > 0, "maxStars must be a positive integer");
        a4.a.b(f10 >= 0.0f && f10 <= ((float) i10), "starRating is out of range [0, maxStars]");
        this.f29124b = i10;
        this.f29125c = f10;
    }
}
