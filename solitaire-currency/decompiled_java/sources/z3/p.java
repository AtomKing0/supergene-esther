package z3;

import a4.o0;
import androidx.annotation.Nullable;
import java.util.Arrays;
import z3.b;

/* JADX INFO: compiled from: DefaultAllocator.java */
/* JADX INFO: loaded from: classes2.dex */
public final class p implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f37484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f37485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final byte[] f37486c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f37487d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f37488e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f37489f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private a[] f37490g;

    public p(boolean z10, int i10) {
        this(z10, i10, 0);
    }

    @Override // z3.b
    public synchronized void a(a aVar) {
        a[] aVarArr = this.f37490g;
        int i10 = this.f37489f;
        this.f37489f = i10 + 1;
        aVarArr[i10] = aVar;
        this.f37488e--;
        notifyAll();
    }

    @Override // z3.b
    public synchronized a allocate() {
        a aVar;
        this.f37488e++;
        int i10 = this.f37489f;
        if (i10 > 0) {
            a[] aVarArr = this.f37490g;
            int i11 = i10 - 1;
            this.f37489f = i11;
            aVar = (a) a4.a.e(aVarArr[i11]);
            this.f37490g[this.f37489f] = null;
        } else {
            aVar = new a(new byte[this.f37485b], 0);
            int i12 = this.f37488e;
            a[] aVarArr2 = this.f37490g;
            if (i12 > aVarArr2.length) {
                this.f37490g = (a[]) Arrays.copyOf(aVarArr2, aVarArr2.length * 2);
            }
        }
        return aVar;
    }

    @Override // z3.b
    public synchronized void b(@Nullable b.a aVar) {
        while (aVar != null) {
            a[] aVarArr = this.f37490g;
            int i10 = this.f37489f;
            this.f37489f = i10 + 1;
            aVarArr[i10] = aVar.getAllocation();
            this.f37488e--;
            aVar = aVar.next();
        }
        notifyAll();
    }

    public synchronized int c() {
        return this.f37488e * this.f37485b;
    }

    public synchronized void d() {
        if (this.f37484a) {
            e(0);
        }
    }

    public synchronized void e(int i10) {
        boolean z10 = i10 < this.f37487d;
        this.f37487d = i10;
        if (z10) {
            trim();
        }
    }

    @Override // z3.b
    public int getIndividualAllocationLength() {
        return this.f37485b;
    }

    @Override // z3.b
    public synchronized void trim() {
        int i10 = 0;
        int iMax = Math.max(0, o0.l(this.f37487d, this.f37485b) - this.f37488e);
        int i11 = this.f37489f;
        if (iMax >= i11) {
            return;
        }
        if (this.f37486c != null) {
            int i12 = i11 - 1;
            while (i10 <= i12) {
                a aVar = (a) a4.a.e(this.f37490g[i10]);
                if (aVar.f37362a == this.f37486c) {
                    i10++;
                } else {
                    a aVar2 = (a) a4.a.e(this.f37490g[i12]);
                    if (aVar2.f37362a != this.f37486c) {
                        i12--;
                    } else {
                        a[] aVarArr = this.f37490g;
                        aVarArr[i10] = aVar2;
                        aVarArr[i12] = aVar;
                        i12--;
                        i10++;
                    }
                }
            }
            iMax = Math.max(iMax, i10);
            if (iMax >= this.f37489f) {
                return;
            }
        }
        Arrays.fill(this.f37490g, iMax, this.f37489f, (Object) null);
        this.f37489f = iMax;
    }

    public p(boolean z10, int i10, int i11) {
        a4.a.a(i10 > 0);
        a4.a.a(i11 >= 0);
        this.f37484a = z10;
        this.f37485b = i10;
        this.f37489f = i11;
        this.f37490g = new a[i11 + 100];
        if (i11 <= 0) {
            this.f37486c = null;
            return;
        }
        this.f37486c = new byte[i11 * i10];
        for (int i12 = 0; i12 < i11; i12++) {
            this.f37490g[i12] = new a(this.f37486c, i12 * i10);
        }
    }
}
