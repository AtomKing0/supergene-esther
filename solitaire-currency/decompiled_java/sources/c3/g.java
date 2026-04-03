package c3;

import a4.o0;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import c3.a;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import k2.b3;
import k2.o1;
import k2.p1;

/* JADX INFO: compiled from: MetadataRenderer.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g extends k2.f implements Handler.Callback {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final d f4496n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final f f4497o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    private final Handler f4498p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final e f4499q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final boolean f4500r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    private c f4501s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f4502t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f4503u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long f4504v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @Nullable
    private a f4505w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private long f4506x;

    public g(f fVar, @Nullable Looper looper) {
        this(fVar, looper, d.f4494a);
    }

    private void A(a aVar) {
        this.f4497o.j(aVar);
    }

    private boolean B(long j10) {
        boolean z10;
        a aVar = this.f4505w;
        if (aVar == null || (!this.f4500r && aVar.f4493b > y(j10))) {
            z10 = false;
        } else {
            z(this.f4505w);
            this.f4505w = null;
            z10 = true;
        }
        if (this.f4502t && this.f4505w == null) {
            this.f4503u = true;
        }
        return z10;
    }

    private void C() {
        if (this.f4502t || this.f4505w != null) {
            return;
        }
        this.f4499q.c();
        p1 p1VarI = i();
        int iU = u(p1VarI, this.f4499q, 0);
        if (iU != -4) {
            if (iU == -5) {
                this.f4504v = ((o1) a4.a.e(p1VarI.f29409b)).f29351p;
            }
        } else {
            if (this.f4499q.h()) {
                this.f4502t = true;
                return;
            }
            e eVar = this.f4499q;
            eVar.f4495i = this.f4504v;
            eVar.n();
            a aVarA = ((c) o0.j(this.f4501s)).a(this.f4499q);
            if (aVarA != null) {
                ArrayList arrayList = new ArrayList(aVarA.e());
                x(aVarA, arrayList);
                if (arrayList.isEmpty()) {
                    return;
                }
                this.f4505w = new a(y(this.f4499q.f31588e), arrayList);
            }
        }
    }

    private void x(a aVar, List<a.b> list) {
        for (int i10 = 0; i10 < aVar.e(); i10++) {
            o1 wrappedMetadataFormat = aVar.d(i10).getWrappedMetadataFormat();
            if (wrappedMetadataFormat == null || !this.f4496n.a(wrappedMetadataFormat)) {
                list.add(aVar.d(i10));
            } else {
                c cVarB = this.f4496n.b(wrappedMetadataFormat);
                byte[] bArr = (byte[]) a4.a.e(aVar.d(i10).getWrappedMetadataBytes());
                this.f4499q.c();
                this.f4499q.m(bArr.length);
                ((ByteBuffer) o0.j(this.f4499q.f31586c)).put(bArr);
                this.f4499q.n();
                a aVarA = cVarB.a(this.f4499q);
                if (aVarA != null) {
                    x(aVarA, list);
                }
            }
        }
    }

    private long y(long j10) {
        a4.a.g(j10 != C.TIME_UNSET);
        a4.a.g(this.f4506x != C.TIME_UNSET);
        return j10 - this.f4506x;
    }

    private void z(a aVar) {
        Handler handler = this.f4498p;
        if (handler != null) {
            handler.obtainMessage(0, aVar).sendToTarget();
        } else {
            A(aVar);
        }
    }

    @Override // k2.c3
    public int a(o1 o1Var) {
        if (this.f4496n.a(o1Var)) {
            return b3.a(o1Var.E == 0 ? 4 : 2);
        }
        return b3.a(0);
    }

    @Override // k2.a3, k2.c3
    public String getName() {
        return "MetadataRenderer";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            throw new IllegalStateException();
        }
        A((a) message.obj);
        return true;
    }

    @Override // k2.a3
    public boolean isEnded() {
        return this.f4503u;
    }

    @Override // k2.a3
    public boolean isReady() {
        return true;
    }

    @Override // k2.f
    protected void n() {
        this.f4505w = null;
        this.f4501s = null;
        this.f4506x = C.TIME_UNSET;
    }

    @Override // k2.f
    protected void p(long j10, boolean z10) {
        this.f4505w = null;
        this.f4502t = false;
        this.f4503u = false;
    }

    @Override // k2.a3
    public void render(long j10, long j11) {
        boolean zB = true;
        while (zB) {
            C();
            zB = B(j10);
        }
    }

    @Override // k2.f
    protected void t(o1[] o1VarArr, long j10, long j11) {
        this.f4501s = this.f4496n.b(o1VarArr[0]);
        a aVar = this.f4505w;
        if (aVar != null) {
            this.f4505w = aVar.c((aVar.f4493b + this.f4506x) - j11);
        }
        this.f4506x = j11;
    }

    public g(f fVar, @Nullable Looper looper, d dVar) {
        this(fVar, looper, dVar, false);
    }

    public g(f fVar, @Nullable Looper looper, d dVar, boolean z10) {
        super(5);
        this.f4497o = (f) a4.a.e(fVar);
        this.f4498p = looper == null ? null : o0.t(looper, this);
        this.f4496n = (d) a4.a.e(dVar);
        this.f4500r = z10;
        this.f4499q = new e();
        this.f4506x = C.TIME_UNSET;
    }
}
