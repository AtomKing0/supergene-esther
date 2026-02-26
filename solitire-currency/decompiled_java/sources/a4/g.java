package a4;

/* JADX INFO: compiled from: ConditionVariable.java */
/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f163b;

    public g() {
        this(d.f148a);
    }

    public synchronized void a() throws InterruptedException {
        while (!this.f163b) {
            wait();
        }
    }

    public synchronized void b() {
        boolean z10 = false;
        while (!this.f163b) {
            try {
                wait();
            } catch (InterruptedException unused) {
                z10 = true;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized boolean c() {
        boolean z10;
        z10 = this.f163b;
        this.f163b = false;
        return z10;
    }

    public synchronized boolean d() {
        return this.f163b;
    }

    public synchronized boolean e() {
        if (this.f163b) {
            return false;
        }
        this.f163b = true;
        notifyAll();
        return true;
    }

    public g(d dVar) {
        this.f162a = dVar;
    }
}
