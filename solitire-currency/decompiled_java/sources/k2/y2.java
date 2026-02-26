package k2;

import android.os.Bundle;
import k2.h;

/* JADX INFO: compiled from: Rating.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class y2 implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h.a<y2> f29673a = new h.a() { // from class: k2.x2
        @Override // k2.h.a
        public final h fromBundle(Bundle bundle) {
            return y2.b(bundle);
        }
    };

    y2() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static y2 b(Bundle bundle) {
        int i10 = bundle.getInt(c(0), -1);
        if (i10 == 0) {
            return (y2) r1.f29424d.fromBundle(bundle);
        }
        if (i10 == 1) {
            return (y2) l2.f29274c.fromBundle(bundle);
        }
        if (i10 == 2) {
            return (y2) h3.f29123d.fromBundle(bundle);
        }
        if (i10 == 3) {
            return (y2) l3.f29276d.fromBundle(bundle);
        }
        throw new IllegalArgumentException("Unknown RatingType: " + i10);
    }

    private static String c(int i10) {
        return Integer.toString(i10, 36);
    }
}
