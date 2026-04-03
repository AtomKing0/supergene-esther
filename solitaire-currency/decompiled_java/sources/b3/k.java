package b3;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: IntArrayQueue.java */
/* JADX INFO: loaded from: classes2.dex */
final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1987a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1988b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1989c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int[] f1990d = new int[16];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f1991e;

    public k() {
        this.f1991e = r0.length - 1;
    }

    private void c() {
        int[] iArr = this.f1990d;
        int length = iArr.length << 1;
        if (length < 0) {
            throw new IllegalStateException();
        }
        int[] iArr2 = new int[length];
        int length2 = iArr.length;
        int i10 = this.f1987a;
        int i11 = length2 - i10;
        System.arraycopy(iArr, i10, iArr2, 0, i11);
        System.arraycopy(this.f1990d, 0, iArr2, i11, i10);
        this.f1987a = 0;
        this.f1988b = this.f1989c - 1;
        this.f1990d = iArr2;
        this.f1991e = iArr2.length - 1;
    }

    public void a(int i10) {
        if (this.f1989c == this.f1990d.length) {
            c();
        }
        int i11 = (this.f1988b + 1) & this.f1991e;
        this.f1988b = i11;
        this.f1990d[i11] = i10;
        this.f1989c++;
    }

    public void b() {
        this.f1987a = 0;
        this.f1988b = -1;
        this.f1989c = 0;
    }

    public boolean d() {
        return this.f1989c == 0;
    }

    public int e() {
        int i10 = this.f1989c;
        if (i10 == 0) {
            throw new NoSuchElementException();
        }
        int[] iArr = this.f1990d;
        int i11 = this.f1987a;
        int i12 = iArr[i11];
        this.f1987a = (i11 + 1) & this.f1991e;
        this.f1989c = i10 - 1;
        return i12;
    }
}
