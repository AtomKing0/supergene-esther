package k2;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: PlaylistTimeline.java */
/* JADX INFO: loaded from: classes2.dex */
final class w2 extends a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f29610f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f29611g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int[] f29612h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int[] f29613i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final n3[] f29614j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Object[] f29615k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final HashMap<Object, Integer> f29616l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w2(Collection<? extends g2> collection, l3.w0 w0Var) {
        super(false, w0Var);
        int iT = 0;
        int size = collection.size();
        this.f29612h = new int[size];
        this.f29613i = new int[size];
        this.f29614j = new n3[size];
        this.f29615k = new Object[size];
        this.f29616l = new HashMap<>();
        int iM = 0;
        int i10 = 0;
        for (g2 g2Var : collection) {
            this.f29614j[i10] = g2Var.getTimeline();
            this.f29613i[i10] = iT;
            this.f29612h[i10] = iM;
            iT += this.f29614j[i10].t();
            iM += this.f29614j[i10].m();
            this.f29615k[i10] = g2Var.getUid();
            this.f29616l.put(this.f29615k[i10], Integer.valueOf(i10));
            i10++;
        }
        this.f29610f = iT;
        this.f29611g = iM;
    }

    @Override // k2.a
    protected int A(int i10) {
        return a4.o0.h(this.f29613i, i10 + 1, false, false);
    }

    @Override // k2.a
    protected Object D(int i10) {
        return this.f29615k[i10];
    }

    @Override // k2.a
    protected int F(int i10) {
        return this.f29612h[i10];
    }

    @Override // k2.a
    protected int G(int i10) {
        return this.f29613i[i10];
    }

    @Override // k2.a
    protected n3 J(int i10) {
        return this.f29614j[i10];
    }

    List<n3> K() {
        return Arrays.asList(this.f29614j);
    }

    @Override // k2.n3
    public int m() {
        return this.f29611g;
    }

    @Override // k2.n3
    public int t() {
        return this.f29610f;
    }

    @Override // k2.a
    protected int y(Object obj) {
        Integer num = this.f29616l.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // k2.a
    protected int z(int i10) {
        return a4.o0.h(this.f29612h, i10 + 1, false, false);
    }
}
