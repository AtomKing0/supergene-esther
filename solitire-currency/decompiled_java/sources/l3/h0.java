package l3;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import k2.f3;
import k2.o1;
import k2.p1;
import l3.x;

/* JADX INFO: compiled from: MergingMediaPeriod.java */
/* JADX INFO: loaded from: classes2.dex */
final class h0 implements x, x.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final x[] f30544a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h f30546c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private x.a f30549f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private e1 f30550g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private v0 f30552i;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ArrayList<x> f30547d = new ArrayList<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final HashMap<c1, c1> f30548e = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final IdentityHashMap<u0, Integer> f30545b = new IdentityHashMap<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private x[] f30551h = new x[0];

    /* JADX INFO: compiled from: MergingMediaPeriod.java */
    private static final class a implements x3.s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final x3.s f30553a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final c1 f30554b;

        public a(x3.s sVar, c1 c1Var) {
            this.f30553a = sVar;
            this.f30554b = c1Var;
        }

        @Override // x3.s
        public void disable() {
            this.f30553a.disable();
        }

        @Override // x3.s
        public void enable() {
            this.f30553a.enable();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f30553a.equals(aVar.f30553a) && this.f30554b.equals(aVar.f30554b);
        }

        @Override // x3.v
        public o1 getFormat(int i10) {
            return this.f30553a.getFormat(i10);
        }

        @Override // x3.v
        public int getIndexInTrackGroup(int i10) {
            return this.f30553a.getIndexInTrackGroup(i10);
        }

        @Override // x3.s
        public o1 getSelectedFormat() {
            return this.f30553a.getSelectedFormat();
        }

        @Override // x3.v
        public c1 getTrackGroup() {
            return this.f30554b;
        }

        public int hashCode() {
            return ((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + this.f30554b.hashCode()) * 31) + this.f30553a.hashCode();
        }

        @Override // x3.v
        public int indexOf(int i10) {
            return this.f30553a.indexOf(i10);
        }

        @Override // x3.v
        public int length() {
            return this.f30553a.length();
        }

        @Override // x3.s
        public void onDiscontinuity() {
            this.f30553a.onDiscontinuity();
        }

        @Override // x3.s
        public void onPlayWhenReadyChanged(boolean z10) {
            this.f30553a.onPlayWhenReadyChanged(z10);
        }

        @Override // x3.s
        public void onPlaybackSpeed(float f10) {
            this.f30553a.onPlaybackSpeed(f10);
        }

        @Override // x3.s
        public void onRebuffer() {
            this.f30553a.onRebuffer();
        }
    }

    /* JADX INFO: compiled from: MergingMediaPeriod.java */
    private static final class b implements x, x.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final x f30555a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f30556b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private x.a f30557c;

        public b(x xVar, long j10) {
            this.f30555a = xVar;
            this.f30556b = j10;
        }

        @Override // l3.x, l3.v0
        public boolean a(long j10) {
            return this.f30555a.a(j10 - this.f30556b);
        }

        @Override // l3.x
        public void b(x.a aVar, long j10) {
            this.f30557c = aVar;
            this.f30555a.b(this, j10 - this.f30556b);
        }

        @Override // l3.x.a
        public void d(x xVar) {
            ((x.a) a4.a.e(this.f30557c)).d(this);
        }

        @Override // l3.x
        public void discardBuffer(long j10, boolean z10) {
            this.f30555a.discardBuffer(j10 - this.f30556b, z10);
        }

        @Override // l3.v0.a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void c(x xVar) {
            ((x.a) a4.a.e(this.f30557c)).c(this);
        }

        @Override // l3.x
        public long g(x3.s[] sVarArr, boolean[] zArr, u0[] u0VarArr, boolean[] zArr2, long j10) {
            u0[] u0VarArr2 = new u0[u0VarArr.length];
            int i10 = 0;
            while (true) {
                u0 u0VarB = null;
                if (i10 >= u0VarArr.length) {
                    break;
                }
                c cVar = (c) u0VarArr[i10];
                if (cVar != null) {
                    u0VarB = cVar.b();
                }
                u0VarArr2[i10] = u0VarB;
                i10++;
            }
            long jG = this.f30555a.g(sVarArr, zArr, u0VarArr2, zArr2, j10 - this.f30556b);
            for (int i11 = 0; i11 < u0VarArr.length; i11++) {
                u0 u0Var = u0VarArr2[i11];
                if (u0Var == null) {
                    u0VarArr[i11] = null;
                } else {
                    u0 u0Var2 = u0VarArr[i11];
                    if (u0Var2 == null || ((c) u0Var2).b() != u0Var) {
                        u0VarArr[i11] = new c(u0Var, this.f30556b);
                    }
                }
            }
            return jG + this.f30556b;
        }

        @Override // l3.x, l3.v0
        public long getBufferedPositionUs() {
            long bufferedPositionUs = this.f30555a.getBufferedPositionUs();
            if (bufferedPositionUs == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            return this.f30556b + bufferedPositionUs;
        }

        @Override // l3.x, l3.v0
        public long getNextLoadPositionUs() {
            long nextLoadPositionUs = this.f30555a.getNextLoadPositionUs();
            if (nextLoadPositionUs == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            return this.f30556b + nextLoadPositionUs;
        }

        @Override // l3.x
        public e1 getTrackGroups() {
            return this.f30555a.getTrackGroups();
        }

        @Override // l3.x
        public long i(long j10, f3 f3Var) {
            return this.f30555a.i(j10 - this.f30556b, f3Var) + this.f30556b;
        }

        @Override // l3.x, l3.v0
        public boolean isLoading() {
            return this.f30555a.isLoading();
        }

        @Override // l3.x
        public void maybeThrowPrepareError() throws IOException {
            this.f30555a.maybeThrowPrepareError();
        }

        @Override // l3.x
        public long readDiscontinuity() {
            long discontinuity = this.f30555a.readDiscontinuity();
            return discontinuity == C.TIME_UNSET ? C.TIME_UNSET : this.f30556b + discontinuity;
        }

        @Override // l3.x, l3.v0
        public void reevaluateBuffer(long j10) {
            this.f30555a.reevaluateBuffer(j10 - this.f30556b);
        }

        @Override // l3.x
        public long seekToUs(long j10) {
            return this.f30555a.seekToUs(j10 - this.f30556b) + this.f30556b;
        }
    }

    /* JADX INFO: compiled from: MergingMediaPeriod.java */
    private static final class c implements u0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final u0 f30558a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f30559b;

        public c(u0 u0Var, long j10) {
            this.f30558a = u0Var;
            this.f30559b = j10;
        }

        @Override // l3.u0
        public int a(p1 p1Var, n2.g gVar, int i10) {
            int iA = this.f30558a.a(p1Var, gVar, i10);
            if (iA == -4) {
                gVar.f31588e = Math.max(0L, gVar.f31588e + this.f30559b);
            }
            return iA;
        }

        public u0 b() {
            return this.f30558a;
        }

        @Override // l3.u0
        public boolean isReady() {
            return this.f30558a.isReady();
        }

        @Override // l3.u0
        public void maybeThrowError() throws IOException {
            this.f30558a.maybeThrowError();
        }

        @Override // l3.u0
        public int skipData(long j10) {
            return this.f30558a.skipData(j10 - this.f30559b);
        }
    }

    public h0(h hVar, long[] jArr, x... xVarArr) {
        this.f30546c = hVar;
        this.f30544a = xVarArr;
        this.f30552i = hVar.a(new v0[0]);
        for (int i10 = 0; i10 < xVarArr.length; i10++) {
            long j10 = jArr[i10];
            if (j10 != 0) {
                this.f30544a[i10] = new b(xVarArr[i10], j10);
            }
        }
    }

    @Override // l3.x, l3.v0
    public boolean a(long j10) {
        if (this.f30547d.isEmpty()) {
            return this.f30552i.a(j10);
        }
        int size = this.f30547d.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f30547d.get(i10).a(j10);
        }
        return false;
    }

    @Override // l3.x
    public void b(x.a aVar, long j10) {
        this.f30549f = aVar;
        Collections.addAll(this.f30547d, this.f30544a);
        for (x xVar : this.f30544a) {
            xVar.b(this, j10);
        }
    }

    @Override // l3.x.a
    public void d(x xVar) {
        this.f30547d.remove(xVar);
        if (!this.f30547d.isEmpty()) {
            return;
        }
        int i10 = 0;
        for (x xVar2 : this.f30544a) {
            i10 += xVar2.getTrackGroups().f30517a;
        }
        c1[] c1VarArr = new c1[i10];
        int i11 = 0;
        int i12 = 0;
        while (true) {
            x[] xVarArr = this.f30544a;
            if (i11 >= xVarArr.length) {
                this.f30550g = new e1(c1VarArr);
                ((x.a) a4.a.e(this.f30549f)).d(this);
                return;
            }
            e1 trackGroups = xVarArr[i11].getTrackGroups();
            int i13 = trackGroups.f30517a;
            int i14 = 0;
            while (i14 < i13) {
                c1 c1VarB = trackGroups.b(i14);
                c1 c1VarB2 = c1VarB.b(i11 + ":" + c1VarB.f30483b);
                this.f30548e.put(c1VarB2, c1VarB);
                c1VarArr[i12] = c1VarB2;
                i14++;
                i12++;
            }
            i11++;
        }
    }

    @Override // l3.x
    public void discardBuffer(long j10, boolean z10) {
        for (x xVar : this.f30551h) {
            xVar.discardBuffer(j10, z10);
        }
    }

    public x e(int i10) {
        x xVar = this.f30544a[i10];
        return xVar instanceof b ? ((b) xVar).f30555a : xVar;
    }

    @Override // l3.v0.a
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void c(x xVar) {
        ((x.a) a4.a.e(this.f30549f)).c(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // l3.x
    public long g(x3.s[] sVarArr, boolean[] zArr, u0[] u0VarArr, boolean[] zArr2, long j10) {
        Integer num;
        int[] iArr = new int[sVarArr.length];
        int[] iArr2 = new int[sVarArr.length];
        int i10 = 0;
        while (true) {
            if (i10 >= sVarArr.length) {
                break;
            }
            u0 u0Var = u0VarArr[i10];
            num = u0Var != null ? this.f30545b.get(u0Var) : null;
            iArr[i10] = num == null ? -1 : num.intValue();
            iArr2[i10] = -1;
            x3.s sVar = sVarArr[i10];
            if (sVar != null) {
                c1 c1Var = (c1) a4.a.e(this.f30548e.get(sVar.getTrackGroup()));
                int i11 = 0;
                while (true) {
                    x[] xVarArr = this.f30544a;
                    if (i11 >= xVarArr.length) {
                        break;
                    }
                    if (xVarArr[i11].getTrackGroups().c(c1Var) != -1) {
                        iArr2[i10] = i11;
                        break;
                    }
                    i11++;
                }
            }
            i10++;
        }
        this.f30545b.clear();
        int length = sVarArr.length;
        u0[] u0VarArr2 = new u0[length];
        u0[] u0VarArr3 = new u0[sVarArr.length];
        Object[] objArr = new x3.s[sVarArr.length];
        ArrayList arrayList = new ArrayList(this.f30544a.length);
        long j11 = j10;
        int i12 = 0;
        while (i12 < this.f30544a.length) {
            for (int i13 = 0; i13 < sVarArr.length; i13++) {
                u0VarArr3[i13] = iArr[i13] == i12 ? u0VarArr[i13] : num;
                if (iArr2[i13] == i12) {
                    x3.s sVar2 = (x3.s) a4.a.e(sVarArr[i13]);
                    objArr[i13] = new a(sVar2, (c1) a4.a.e(this.f30548e.get(sVar2.getTrackGroup())));
                } else {
                    objArr[i13] = num;
                }
            }
            int i14 = i12;
            ArrayList arrayList2 = arrayList;
            Object[] objArr2 = objArr;
            long jG = this.f30544a[i12].g(objArr, zArr, u0VarArr3, zArr2, j11);
            if (i14 == 0) {
                j11 = jG;
            } else if (jG != j11) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            boolean z10 = false;
            for (int i15 = 0; i15 < sVarArr.length; i15++) {
                if (iArr2[i15] == i14) {
                    u0 u0Var2 = (u0) a4.a.e(u0VarArr3[i15]);
                    u0VarArr2[i15] = u0VarArr3[i15];
                    this.f30545b.put(u0Var2, Integer.valueOf(i14));
                    z10 = true;
                } else if (iArr[i15] == i14) {
                    a4.a.g(u0VarArr3[i15] == 0);
                }
            }
            if (z10) {
                arrayList2.add(this.f30544a[i14]);
            }
            i12 = i14 + 1;
            arrayList = arrayList2;
            objArr = objArr2;
            num = null;
        }
        System.arraycopy(u0VarArr2, 0, u0VarArr, 0, length);
        x[] xVarArr2 = (x[]) arrayList.toArray(new x[0]);
        this.f30551h = xVarArr2;
        this.f30552i = this.f30546c.a(xVarArr2);
        return j11;
    }

    @Override // l3.x, l3.v0
    public long getBufferedPositionUs() {
        return this.f30552i.getBufferedPositionUs();
    }

    @Override // l3.x, l3.v0
    public long getNextLoadPositionUs() {
        return this.f30552i.getNextLoadPositionUs();
    }

    @Override // l3.x
    public e1 getTrackGroups() {
        return (e1) a4.a.e(this.f30550g);
    }

    @Override // l3.x
    public long i(long j10, f3 f3Var) {
        x[] xVarArr = this.f30551h;
        return (xVarArr.length > 0 ? xVarArr[0] : this.f30544a[0]).i(j10, f3Var);
    }

    @Override // l3.x, l3.v0
    public boolean isLoading() {
        return this.f30552i.isLoading();
    }

    @Override // l3.x
    public void maybeThrowPrepareError() throws IOException {
        for (x xVar : this.f30544a) {
            xVar.maybeThrowPrepareError();
        }
    }

    @Override // l3.x
    public long readDiscontinuity() {
        long j10 = -9223372036854775807L;
        for (x xVar : this.f30551h) {
            long discontinuity = xVar.readDiscontinuity();
            if (discontinuity == C.TIME_UNSET) {
                if (j10 != C.TIME_UNSET && xVar.seekToUs(j10) != j10) {
                    throw new IllegalStateException("Unexpected child seekToUs result.");
                }
            } else if (j10 == C.TIME_UNSET) {
                for (x xVar2 : this.f30551h) {
                    if (xVar2 == xVar) {
                        break;
                    }
                    if (xVar2.seekToUs(discontinuity) != discontinuity) {
                        throw new IllegalStateException("Unexpected child seekToUs result.");
                    }
                }
                j10 = discontinuity;
            } else if (discontinuity != j10) {
                throw new IllegalStateException("Conflicting discontinuities.");
            }
        }
        return j10;
    }

    @Override // l3.x, l3.v0
    public void reevaluateBuffer(long j10) {
        this.f30552i.reevaluateBuffer(j10);
    }

    @Override // l3.x
    public long seekToUs(long j10) {
        long jSeekToUs = this.f30551h[0].seekToUs(j10);
        int i10 = 1;
        while (true) {
            x[] xVarArr = this.f30551h;
            if (i10 >= xVarArr.length) {
                return jSeekToUs;
            }
            if (xVarArr[i10].seekToUs(jSeekToUs) != jSeekToUs) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
            i10++;
        }
    }
}
