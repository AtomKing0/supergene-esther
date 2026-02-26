package o3;

import a4.o0;
import androidx.annotation.Nullable;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import n2.h;
import n3.i;
import n3.j;
import n3.k;
import n3.n;
import n3.o;
import o3.e;

/* JADX INFO: compiled from: CeaDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class e implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayDeque<b> f32028a = new ArrayDeque<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayDeque<o> f32029b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PriorityQueue<b> f32030c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private b f32031d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f32032e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f32033f;

    /* JADX INFO: compiled from: CeaDecoder.java */
    private static final class b extends n implements Comparable<b> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private long f32034j;

        private b() {
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            if (h() != bVar.h()) {
                return h() ? 1 : -1;
            }
            long j10 = this.f31588e - bVar.f31588e;
            if (j10 == 0) {
                j10 = this.f32034j - bVar.f32034j;
                if (j10 == 0) {
                    return 0;
                }
            }
            return j10 > 0 ? 1 : -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: CeaDecoder.java */
    static final class c extends o {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private h.a<c> f32035f;

        public c(h.a<c> aVar) {
            this.f32035f = aVar;
        }

        @Override // n2.h
        public final void l() {
            this.f32035f.a(this);
        }
    }

    public e() {
        for (int i10 = 0; i10 < 10; i10++) {
            this.f32028a.add(new b());
        }
        this.f32029b = new ArrayDeque<>();
        for (int i11 = 0; i11 < 2; i11++) {
            this.f32029b.add(new c(new h.a() { // from class: o3.d
                @Override // n2.h.a
                public final void a(h hVar) {
                    this.f32027a.j((e.c) hVar);
                }
            }));
        }
        this.f32030c = new PriorityQueue<>();
    }

    private void i(b bVar) {
        bVar.c();
        this.f32028a.add(bVar);
    }

    protected abstract i a();

    protected abstract void b(n nVar);

    @Override // n2.d
    @Nullable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n dequeueInputBuffer() throws k {
        a4.a.g(this.f32031d == null);
        if (this.f32028a.isEmpty()) {
            return null;
        }
        b bVarPollFirst = this.f32028a.pollFirst();
        this.f32031d = bVarPollFirst;
        return bVarPollFirst;
    }

    @Override // n2.d
    @Nullable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public o dequeueOutputBuffer() throws k {
        if (this.f32029b.isEmpty()) {
            return null;
        }
        while (!this.f32030c.isEmpty() && ((b) o0.j(this.f32030c.peek())).f31588e <= this.f32032e) {
            b bVar = (b) o0.j(this.f32030c.poll());
            if (bVar.h()) {
                o oVar = (o) o0.j(this.f32029b.pollFirst());
                oVar.a(4);
                i(bVar);
                return oVar;
            }
            b(bVar);
            if (g()) {
                i iVarA = a();
                o oVar2 = (o) o0.j(this.f32029b.pollFirst());
                oVar2.m(bVar.f31588e, iVarA, Long.MAX_VALUE);
                i(bVar);
                return oVar2;
            }
            i(bVar);
        }
        return null;
    }

    @Nullable
    protected final o e() {
        return this.f32029b.pollFirst();
    }

    protected final long f() {
        return this.f32032e;
    }

    @Override // n2.d
    public void flush() {
        this.f32033f = 0L;
        this.f32032e = 0L;
        while (!this.f32030c.isEmpty()) {
            i((b) o0.j(this.f32030c.poll()));
        }
        b bVar = this.f32031d;
        if (bVar != null) {
            i(bVar);
            this.f32031d = null;
        }
    }

    protected abstract boolean g();

    @Override // n2.d
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void queueInputBuffer(n nVar) throws k {
        a4.a.a(nVar == this.f32031d);
        b bVar = (b) nVar;
        if (bVar.g()) {
            i(bVar);
        } else {
            long j10 = this.f32033f;
            this.f32033f = 1 + j10;
            bVar.f32034j = j10;
            this.f32030c.add(bVar);
        }
        this.f32031d = null;
    }

    protected void j(o oVar) {
        oVar.c();
        this.f32029b.add(oVar);
    }

    @Override // n3.j
    public void setPositionUs(long j10) {
        this.f32032e = j10;
    }

    @Override // n2.d
    public void release() {
    }
}
