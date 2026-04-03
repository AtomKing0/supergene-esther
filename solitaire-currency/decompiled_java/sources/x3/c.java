package x3;

import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Comparator;
import k2.o1;
import l3.c1;

/* JADX INFO: compiled from: BaseTrackSelection.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final c1 f35926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final int f35927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final int[] f35928c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f35929d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final o1[] f35930e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long[] f35931f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f35932g;

    public c(c1 c1Var, int[] iArr, int i10) {
        int i11 = 0;
        a4.a.g(iArr.length > 0);
        this.f35929d = i10;
        this.f35926a = (c1) a4.a.e(c1Var);
        int length = iArr.length;
        this.f35927b = length;
        this.f35930e = new o1[length];
        for (int i12 = 0; i12 < iArr.length; i12++) {
            this.f35930e[i12] = c1Var.c(iArr[i12]);
        }
        Arrays.sort(this.f35930e, new Comparator() { // from class: x3.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return c.b((o1) obj, (o1) obj2);
            }
        });
        this.f35928c = new int[this.f35927b];
        while (true) {
            int i13 = this.f35927b;
            if (i11 >= i13) {
                this.f35931f = new long[i13];
                return;
            } else {
                this.f35928c[i11] = c1Var.d(this.f35930e[i11]);
                i11++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int b(o1 o1Var, o1 o1Var2) {
        return o1Var2.f29343h - o1Var.f29343h;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.f35926a == cVar.f35926a && Arrays.equals(this.f35928c, cVar.f35928c);
    }

    @Override // x3.v
    public final o1 getFormat(int i10) {
        return this.f35930e[i10];
    }

    @Override // x3.v
    public final int getIndexInTrackGroup(int i10) {
        return this.f35928c[i10];
    }

    @Override // x3.s
    public final o1 getSelectedFormat() {
        return this.f35930e[getSelectedIndex()];
    }

    @Override // x3.v
    public final c1 getTrackGroup() {
        return this.f35926a;
    }

    public int hashCode() {
        if (this.f35932g == 0) {
            this.f35932g = (System.identityHashCode(this.f35926a) * 31) + Arrays.hashCode(this.f35928c);
        }
        return this.f35932g;
    }

    @Override // x3.v
    public final int indexOf(int i10) {
        for (int i11 = 0; i11 < this.f35927b; i11++) {
            if (this.f35928c[i11] == i10) {
                return i11;
            }
        }
        return -1;
    }

    @Override // x3.v
    public final int length() {
        return this.f35928c.length;
    }

    @Override // x3.s
    public /* synthetic */ void onDiscontinuity() {
        r.a(this);
    }

    @Override // x3.s
    public /* synthetic */ void onPlayWhenReadyChanged(boolean z10) {
        r.b(this, z10);
    }

    @Override // x3.s
    public /* synthetic */ void onRebuffer() {
        r.c(this);
    }

    @Override // x3.s
    public void disable() {
    }

    @Override // x3.s
    public void enable() {
    }

    @Override // x3.s
    public void onPlaybackSpeed(float f10) {
    }
}
