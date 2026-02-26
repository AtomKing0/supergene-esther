package y2;

import a4.c0;
import android.net.Uri;
import java.io.IOException;
import java.util.Map;
import k2.j2;
import p2.a0;
import p2.e0;
import p2.l;
import p2.m;
import p2.n;
import p2.q;
import p2.r;

/* JADX INFO: compiled from: OggExtractor.java */
/* JADX INFO: loaded from: classes2.dex */
public class d implements l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final r f36453d = new r() { // from class: y2.c
        @Override // p2.r
        public final l[] createExtractors() {
            return d.e();
        }

        @Override // p2.r
        public /* synthetic */ l[] createExtractors(Uri uri, Map map) {
            return q.a(this, uri, map);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private n f36454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private i f36455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f36456c;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l[] e() {
        return new l[]{new d()};
    }

    private static c0 f(c0 c0Var) {
        c0Var.P(0);
        return c0Var;
    }

    private boolean g(m mVar) throws IOException {
        f fVar = new f();
        if (fVar.a(mVar, true) && (fVar.f36463b & 2) == 2) {
            int iMin = Math.min(fVar.f36470i, 8);
            c0 c0Var = new c0(iMin);
            mVar.peekFully(c0Var.d(), 0, iMin);
            if (b.p(f(c0Var))) {
                this.f36455b = new b();
            } else if (j.r(f(c0Var))) {
                this.f36455b = new j();
            } else if (h.p(f(c0Var))) {
                this.f36455b = new h();
            }
            return true;
        }
        return false;
    }

    @Override // p2.l
    public int a(m mVar, a0 a0Var) throws IOException {
        a4.a.i(this.f36454a);
        if (this.f36455b == null) {
            if (!g(mVar)) {
                throw j2.a("Failed to determine bitstream type", null);
            }
            mVar.resetPeekPosition();
        }
        if (!this.f36456c) {
            e0 e0VarTrack = this.f36454a.track(0, 1);
            this.f36454a.endTracks();
            this.f36455b.d(this.f36454a, e0VarTrack);
            this.f36456c = true;
        }
        return this.f36455b.g(mVar, a0Var);
    }

    @Override // p2.l
    public void b(n nVar) {
        this.f36454a = nVar;
    }

    @Override // p2.l
    public boolean c(m mVar) throws IOException {
        try {
            return g(mVar);
        } catch (j2 unused) {
            return false;
        }
    }

    @Override // p2.l
    public void seek(long j10, long j11) {
        i iVar = this.f36455b;
        if (iVar != null) {
            iVar.m(j10, j11);
        }
    }

    @Override // p2.l
    public void release() {
    }
}
