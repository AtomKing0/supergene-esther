package n3;

import android.os.Bundle;
import com.google.common.collect.y;
import java.util.ArrayList;
import java.util.List;
import k2.h;

/* JADX INFO: compiled from: CueGroup.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f implements k2.h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f31657c = new f(y.q(), 0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h.a<f> f31658d = new h.a() { // from class: n3.e
        @Override // k2.h.a
        public final k2.h fromBundle(Bundle bundle) {
            return f.c(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y<b> f31659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f31660b;

    public f(List<b> list, long j10) {
        this.f31659a = y.m(list);
        this.f31660b = j10;
    }

    private static y<b> b(List<b> list) {
        y.a aVarK = y.k();
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (list.get(i10).f31626d == null) {
                aVarK.a(list.get(i10));
            }
        }
        return aVarK.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final f c(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(d(0));
        return new f(parcelableArrayList == null ? y.q() : a4.c.b(b.f31622s, parcelableArrayList), bundle.getLong(d(1)));
    }

    private static String d(int i10) {
        return Integer.toString(i10, 36);
    }

    @Override // k2.h
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(d(0), a4.c.d(b(this.f31659a)));
        bundle.putLong(d(1), this.f31660b);
        return bundle;
    }
}
