package z3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import z3.k0;

/* JADX INFO: compiled from: SlidingPercentile.java */
/* JADX INFO: loaded from: classes2.dex */
public class k0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Comparator<b> f37431h = new Comparator() { // from class: z3.i0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return k0.g((k0.b) obj, (k0.b) obj2);
        }
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Comparator<b> f37432i = new Comparator() { // from class: z3.j0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return k0.h((k0.b) obj, (k0.b) obj2);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f37433a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f37437e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f37438f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f37439g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b[] f37435c = new b[5];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList<b> f37434b = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f37436d = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: SlidingPercentile.java */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f37440a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f37441b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f37442c;

        private b() {
        }
    }

    public k0(int i10) {
        this.f37433a = i10;
    }

    private void d() {
        if (this.f37436d != 1) {
            Collections.sort(this.f37434b, f37431h);
            this.f37436d = 1;
        }
    }

    private void e() {
        if (this.f37436d != 0) {
            Collections.sort(this.f37434b, f37432i);
            this.f37436d = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int g(b bVar, b bVar2) {
        return bVar.f37440a - bVar2.f37440a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int h(b bVar, b bVar2) {
        return Float.compare(bVar.f37442c, bVar2.f37442c);
    }

    public void c(int i10, float f10) {
        b bVar;
        d();
        int i11 = this.f37439g;
        if (i11 > 0) {
            b[] bVarArr = this.f37435c;
            int i12 = i11 - 1;
            this.f37439g = i12;
            bVar = bVarArr[i12];
        } else {
            bVar = new b();
        }
        int i13 = this.f37437e;
        this.f37437e = i13 + 1;
        bVar.f37440a = i13;
        bVar.f37441b = i10;
        bVar.f37442c = f10;
        this.f37434b.add(bVar);
        this.f37438f += i10;
        while (true) {
            int i14 = this.f37438f;
            int i15 = this.f37433a;
            if (i14 <= i15) {
                return;
            }
            int i16 = i14 - i15;
            b bVar2 = this.f37434b.get(0);
            int i17 = bVar2.f37441b;
            if (i17 <= i16) {
                this.f37438f -= i17;
                this.f37434b.remove(0);
                int i18 = this.f37439g;
                if (i18 < 5) {
                    b[] bVarArr2 = this.f37435c;
                    this.f37439g = i18 + 1;
                    bVarArr2[i18] = bVar2;
                }
            } else {
                bVar2.f37441b = i17 - i16;
                this.f37438f -= i16;
            }
        }
    }

    public float f(float f10) {
        e();
        float f11 = f10 * this.f37438f;
        int i10 = 0;
        for (int i11 = 0; i11 < this.f37434b.size(); i11++) {
            b bVar = this.f37434b.get(i11);
            i10 += bVar.f37441b;
            if (i10 >= f11) {
                return bVar.f37442c;
            }
        }
        if (this.f37434b.isEmpty()) {
            return Float.NaN;
        }
        return this.f37434b.get(r5.size() - 1).f37442c;
    }

    public void i() {
        this.f37434b.clear();
        this.f37436d = -1;
        this.f37437e = 0;
        this.f37438f = 0;
    }
}
