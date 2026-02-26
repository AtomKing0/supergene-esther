package k2;

import android.os.Bundle;
import androidx.annotation.Nullable;
import k2.h;

/* JADX INFO: compiled from: ThumbRating.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l3 extends y2 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h.a<l3> f29276d = new h.a() { // from class: k2.k3
        @Override // k2.h.a
        public final h fromBundle(Bundle bundle) {
            return l3.e(bundle);
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f29277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f29278c;

    public l3() {
        this.f29277b = false;
        this.f29278c = false;
    }

    private static String c(int i10) {
        return Integer.toString(i10, 36);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static l3 e(Bundle bundle) {
        a4.a.a(bundle.getInt(c(0), -1) == 3);
        return bundle.getBoolean(c(1), false) ? new l3(bundle.getBoolean(c(2), false)) : new l3();
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof l3)) {
            return false;
        }
        l3 l3Var = (l3) obj;
        return this.f29278c == l3Var.f29278c && this.f29277b == l3Var.f29277b;
    }

    public int hashCode() {
        return e5.k.b(Boolean.valueOf(this.f29277b), Boolean.valueOf(this.f29278c));
    }

    @Override // k2.h
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(c(0), 3);
        bundle.putBoolean(c(1), this.f29277b);
        bundle.putBoolean(c(2), this.f29278c);
        return bundle;
    }

    public l3(boolean z10) {
        this.f29277b = true;
        this.f29278c = z10;
    }
}
