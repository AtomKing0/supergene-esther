package l3;

import android.util.SparseArray;

/* JADX INFO: compiled from: SpannedData.java */
/* JADX INFO: loaded from: classes2.dex */
final class a1<V> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a4.h<V> f30460c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SparseArray<V> f30459b = new SparseArray<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f30458a = -1;

    public a1(a4.h<V> hVar) {
        this.f30460c = hVar;
    }

    public void a(int i10, V v10) {
        if (this.f30458a == -1) {
            a4.a.g(this.f30459b.size() == 0);
            this.f30458a = 0;
        }
        if (this.f30459b.size() > 0) {
            SparseArray<V> sparseArray = this.f30459b;
            int iKeyAt = sparseArray.keyAt(sparseArray.size() - 1);
            a4.a.a(i10 >= iKeyAt);
            if (iKeyAt == i10) {
                a4.h<V> hVar = this.f30460c;
                SparseArray<V> sparseArray2 = this.f30459b;
                hVar.accept(sparseArray2.valueAt(sparseArray2.size() - 1));
            }
        }
        this.f30459b.append(i10, v10);
    }

    public void b() {
        for (int i10 = 0; i10 < this.f30459b.size(); i10++) {
            this.f30460c.accept(this.f30459b.valueAt(i10));
        }
        this.f30458a = -1;
        this.f30459b.clear();
    }

    public void c(int i10) {
        for (int size = this.f30459b.size() - 1; size >= 0 && i10 < this.f30459b.keyAt(size); size--) {
            this.f30460c.accept(this.f30459b.valueAt(size));
            this.f30459b.removeAt(size);
        }
        this.f30458a = this.f30459b.size() > 0 ? Math.min(this.f30458a, this.f30459b.size() - 1) : -1;
    }

    public void d(int i10) {
        int i11 = 0;
        while (i11 < this.f30459b.size() - 1) {
            int i12 = i11 + 1;
            if (i10 < this.f30459b.keyAt(i12)) {
                return;
            }
            this.f30460c.accept(this.f30459b.valueAt(i11));
            this.f30459b.removeAt(i11);
            int i13 = this.f30458a;
            if (i13 > 0) {
                this.f30458a = i13 - 1;
            }
            i11 = i12;
        }
    }

    public V e(int i10) {
        if (this.f30458a == -1) {
            this.f30458a = 0;
        }
        while (true) {
            int i11 = this.f30458a;
            if (i11 <= 0 || i10 >= this.f30459b.keyAt(i11)) {
                break;
            }
            this.f30458a--;
        }
        while (this.f30458a < this.f30459b.size() - 1 && i10 >= this.f30459b.keyAt(this.f30458a + 1)) {
            this.f30458a++;
        }
        return this.f30459b.valueAt(this.f30458a);
    }

    public V f() {
        return this.f30459b.valueAt(r0.size() - 1);
    }

    public boolean g() {
        return this.f30459b.size() == 0;
    }
}
