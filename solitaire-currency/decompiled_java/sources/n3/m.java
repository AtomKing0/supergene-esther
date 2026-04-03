package n3;

import a4.c0;
import a4.o0;
import androidx.media3.common.C;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;
import k2.j2;
import k2.o1;
import p2.a0;
import p2.e0;
import p2.z;

/* JADX INFO: compiled from: SubtitleExtractor.java */
/* JADX INFO: loaded from: classes2.dex */
public class m implements p2.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f31672a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final o1 f31675d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private p2.n f31678g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private e0 f31679h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f31680i;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f31673b = new d();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c0 f31674c = new c0();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<Long> f31676e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<c0> f31677f = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f31681j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f31682k = C.TIME_UNSET;

    public m(j jVar, o1 o1Var) {
        this.f31672a = jVar;
        this.f31675d = o1Var.b().e0("text/x-exoplayer-cues").I(o1Var.f29347l).E();
    }

    private void d() throws IOException, n2.f {
        try {
            n nVarDequeueInputBuffer = this.f31672a.dequeueInputBuffer();
            while (nVarDequeueInputBuffer == null) {
                Thread.sleep(5L);
                nVarDequeueInputBuffer = this.f31672a.dequeueInputBuffer();
            }
            nVarDequeueInputBuffer.m(this.f31680i);
            nVarDequeueInputBuffer.f31586c.put(this.f31674c.d(), 0, this.f31680i);
            nVarDequeueInputBuffer.f31586c.limit(this.f31680i);
            this.f31672a.queueInputBuffer(nVarDequeueInputBuffer);
            o oVarDequeueOutputBuffer = this.f31672a.dequeueOutputBuffer();
            while (oVarDequeueOutputBuffer == null) {
                Thread.sleep(5L);
                oVarDequeueOutputBuffer = this.f31672a.dequeueOutputBuffer();
            }
            for (int i10 = 0; i10 < oVarDequeueOutputBuffer.getEventTimeCount(); i10++) {
                byte[] bArrA = this.f31673b.a(oVarDequeueOutputBuffer.getCues(oVarDequeueOutputBuffer.getEventTime(i10)));
                this.f31676e.add(Long.valueOf(oVarDequeueOutputBuffer.getEventTime(i10)));
                this.f31677f.add(new c0(bArrA));
            }
            oVarDequeueOutputBuffer.l();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        } catch (k e10) {
            throw j2.a("SubtitleDecoder failed.", e10);
        }
    }

    private boolean e(p2.m mVar) throws IOException {
        int iB = this.f31674c.b();
        int i10 = this.f31680i;
        if (iB == i10) {
            this.f31674c.c(i10 + 1024);
        }
        int i11 = mVar.read(this.f31674c.d(), this.f31680i, this.f31674c.b() - this.f31680i);
        if (i11 != -1) {
            this.f31680i += i11;
        }
        long length = mVar.getLength();
        return (length != -1 && ((long) this.f31680i) == length) || i11 == -1;
    }

    private boolean f(p2.m mVar) throws IOException {
        return mVar.skip((mVar.getLength() > (-1L) ? 1 : (mVar.getLength() == (-1L) ? 0 : -1)) != 0 ? g5.e.d(mVar.getLength()) : 1024) == -1;
    }

    private void g() {
        a4.a.i(this.f31679h);
        a4.a.g(this.f31676e.size() == this.f31677f.size());
        long j10 = this.f31682k;
        for (int iG = j10 == C.TIME_UNSET ? 0 : o0.g(this.f31676e, Long.valueOf(j10), true, true); iG < this.f31677f.size(); iG++) {
            c0 c0Var = this.f31677f.get(iG);
            c0Var.P(0);
            int length = c0Var.d().length;
            this.f31679h.e(c0Var, length);
            this.f31679h.a(this.f31676e.get(iG).longValue(), 1, length, 0, null);
        }
    }

    @Override // p2.l
    public int a(p2.m mVar, a0 a0Var) throws IOException, n2.f {
        int i10 = this.f31681j;
        a4.a.g((i10 == 0 || i10 == 5) ? false : true);
        if (this.f31681j == 1) {
            this.f31674c.L(mVar.getLength() != -1 ? g5.e.d(mVar.getLength()) : 1024);
            this.f31680i = 0;
            this.f31681j = 2;
        }
        if (this.f31681j == 2 && e(mVar)) {
            d();
            g();
            this.f31681j = 4;
        }
        if (this.f31681j == 3 && f(mVar)) {
            g();
            this.f31681j = 4;
        }
        return this.f31681j == 4 ? -1 : 0;
    }

    @Override // p2.l
    public void b(p2.n nVar) {
        a4.a.g(this.f31681j == 0);
        this.f31678g = nVar;
        this.f31679h = nVar.track(0, 3);
        this.f31678g.endTracks();
        this.f31678g.h(new z(new long[]{0}, new long[]{0}, C.TIME_UNSET));
        this.f31679h.f(this.f31675d);
        this.f31681j = 1;
    }

    @Override // p2.l
    public boolean c(p2.m mVar) throws IOException {
        return true;
    }

    @Override // p2.l
    public void release() {
        if (this.f31681j == 5) {
            return;
        }
        this.f31672a.release();
        this.f31681j = 5;
    }

    @Override // p2.l
    public void seek(long j10, long j11) {
        int i10 = this.f31681j;
        a4.a.g((i10 == 0 || i10 == 5) ? false : true);
        this.f31682k = j11;
        if (this.f31681j == 2) {
            this.f31681j = 1;
        }
        if (this.f31681j == 4) {
            this.f31681j = 3;
        }
    }
}
