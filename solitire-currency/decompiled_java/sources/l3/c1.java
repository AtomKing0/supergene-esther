package l3;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.ArrayList;
import java.util.Arrays;
import k2.h;
import k2.o1;

/* JADX INFO: compiled from: TrackGroup.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c1 implements k2.h {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final h.a<c1> f30481f = new h.a() { // from class: l3.b1
        @Override // k2.h.a
        public final k2.h fromBundle(Bundle bundle) {
            return c1.f(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f30482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f30483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f30484c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final o1[] f30485d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f30486e;

    public c1(o1... o1VarArr) {
        this("", o1VarArr);
    }

    private static String e(int i10) {
        return Integer.toString(i10, 36);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ c1 f(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(e(0));
        return new c1(bundle.getString(e(1), ""), (o1[]) (parcelableArrayList == null ? com.google.common.collect.y.q() : a4.c.b(o1.H, parcelableArrayList)).toArray(new o1[0]));
    }

    private static void g(String str, @Nullable String str2, @Nullable String str3, int i10) {
        a4.t.d("TrackGroup", "", new IllegalStateException("Different " + str + " combined in one TrackGroup: '" + str2 + "' (track 0) and '" + str3 + "' (track " + i10 + ")"));
    }

    private static String h(@Nullable String str) {
        return (str == null || str.equals(C.LANGUAGE_UNDETERMINED)) ? "" : str;
    }

    private static int i(int i10) {
        return i10 | 16384;
    }

    private void j() {
        String strH = h(this.f30485d[0].f29338c);
        int i10 = i(this.f30485d[0].f29340e);
        int i11 = 1;
        while (true) {
            o1[] o1VarArr = this.f30485d;
            if (i11 >= o1VarArr.length) {
                return;
            }
            if (!strH.equals(h(o1VarArr[i11].f29338c))) {
                o1[] o1VarArr2 = this.f30485d;
                g("languages", o1VarArr2[0].f29338c, o1VarArr2[i11].f29338c, i11);
                return;
            } else {
                if (i10 != i(this.f30485d[i11].f29340e)) {
                    g("role flags", Integer.toBinaryString(this.f30485d[0].f29340e), Integer.toBinaryString(this.f30485d[i11].f29340e), i11);
                    return;
                }
                i11++;
            }
        }
    }

    @CheckResult
    public c1 b(String str) {
        return new c1(str, this.f30485d);
    }

    public o1 c(int i10) {
        return this.f30485d[i10];
    }

    public int d(o1 o1Var) {
        int i10 = 0;
        while (true) {
            o1[] o1VarArr = this.f30485d;
            if (i10 >= o1VarArr.length) {
                return -1;
            }
            if (o1Var == o1VarArr[i10]) {
                return i10;
            }
            i10++;
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c1.class != obj.getClass()) {
            return false;
        }
        c1 c1Var = (c1) obj;
        return this.f30483b.equals(c1Var.f30483b) && Arrays.equals(this.f30485d, c1Var.f30485d);
    }

    public int hashCode() {
        if (this.f30486e == 0) {
            this.f30486e = ((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + this.f30483b.hashCode()) * 31) + Arrays.hashCode(this.f30485d);
        }
        return this.f30486e;
    }

    @Override // k2.h
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(this.f30485d.length);
        for (o1 o1Var : this.f30485d) {
            arrayList.add(o1Var.j(true));
        }
        bundle.putParcelableArrayList(e(0), arrayList);
        bundle.putString(e(1), this.f30483b);
        return bundle;
    }

    public c1(String str, o1... o1VarArr) {
        a4.a.a(o1VarArr.length > 0);
        this.f30483b = str;
        this.f30485d = o1VarArr;
        this.f30482a = o1VarArr.length;
        int i10 = a4.x.i(o1VarArr[0].f29347l);
        this.f30484c = i10 == -1 ? a4.x.i(o1VarArr[0].f29346k) : i10;
        j();
    }
}
