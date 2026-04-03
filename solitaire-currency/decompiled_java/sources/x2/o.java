package x2;

import androidx.annotation.Nullable;
import k2.o1;

/* JADX INFO: compiled from: Track.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f35858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f35859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f35860c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f35861d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f35862e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final o1 f35863f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f35864g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public final long[] f35865h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public final long[] f35866i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f35867j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private final p[] f35868k;

    public o(int i10, int i11, long j10, long j11, long j12, o1 o1Var, int i12, @Nullable p[] pVarArr, int i13, @Nullable long[] jArr, @Nullable long[] jArr2) {
        this.f35858a = i10;
        this.f35859b = i11;
        this.f35860c = j10;
        this.f35861d = j11;
        this.f35862e = j12;
        this.f35863f = o1Var;
        this.f35864g = i12;
        this.f35868k = pVarArr;
        this.f35867j = i13;
        this.f35865h = jArr;
        this.f35866i = jArr2;
    }

    @Nullable
    public p a(int i10) {
        p[] pVarArr = this.f35868k;
        if (pVarArr == null) {
            return null;
        }
        return pVarArr[i10];
    }
}
