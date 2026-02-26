package k2;

import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: PlayerMessage.java */
/* JADX INFO: loaded from: classes2.dex */
public final class v2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f29499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f29500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a4.d f29501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final n3 f29502d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f29503e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private Object f29504f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Looper f29505g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f29506h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f29507i = C.TIME_UNSET;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f29508j = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f29509k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f29510l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f29511m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f29512n;

    /* JADX INFO: compiled from: PlayerMessage.java */
    public interface a {
        void a(v2 v2Var);
    }

    /* JADX INFO: compiled from: PlayerMessage.java */
    public interface b {
        void handleMessage(int i10, @Nullable Object obj) throws q;
    }

    public v2(a aVar, b bVar, n3 n3Var, int i10, a4.d dVar, Looper looper) {
        this.f29500b = aVar;
        this.f29499a = bVar;
        this.f29502d = n3Var;
        this.f29505g = looper;
        this.f29501c = dVar;
        this.f29506h = i10;
    }

    public synchronized boolean a(long j10) throws InterruptedException, TimeoutException {
        boolean z10;
        a4.a.g(this.f29509k);
        a4.a.g(this.f29505g.getThread() != Thread.currentThread());
        long jElapsedRealtime = this.f29501c.elapsedRealtime() + j10;
        while (true) {
            z10 = this.f29511m;
            if (z10 || j10 <= 0) {
                break;
            }
            this.f29501c.onThreadBlocked();
            wait(j10);
            j10 = jElapsedRealtime - this.f29501c.elapsedRealtime();
        }
        if (!z10) {
            throw new TimeoutException("Message delivery timed out.");
        }
        return this.f29510l;
    }

    public boolean b() {
        return this.f29508j;
    }

    public Looper c() {
        return this.f29505g;
    }

    public int d() {
        return this.f29506h;
    }

    @Nullable
    public Object e() {
        return this.f29504f;
    }

    public long f() {
        return this.f29507i;
    }

    public b g() {
        return this.f29499a;
    }

    public n3 h() {
        return this.f29502d;
    }

    public int i() {
        return this.f29503e;
    }

    public synchronized boolean j() {
        return this.f29512n;
    }

    public synchronized void k(boolean z10) {
        this.f29510l = z10 | this.f29510l;
        this.f29511m = true;
        notifyAll();
    }

    public v2 l() {
        a4.a.g(!this.f29509k);
        if (this.f29507i == C.TIME_UNSET) {
            a4.a.a(this.f29508j);
        }
        this.f29509k = true;
        this.f29500b.a(this);
        return this;
    }

    public v2 m(@Nullable Object obj) {
        a4.a.g(!this.f29509k);
        this.f29504f = obj;
        return this;
    }

    public v2 n(int i10) {
        a4.a.g(!this.f29509k);
        this.f29503e = i10;
        return this;
    }
}
