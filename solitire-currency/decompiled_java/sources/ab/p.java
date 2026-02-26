package ab;

import ga.e;
import ga.e0;
import java.io.IOException;
import java.util.Objects;
import ua.k0;
import ua.z0;

/* JADX INFO: compiled from: OkHttpCall.java */
/* JADX INFO: loaded from: classes5.dex */
final class p<T> implements ab.b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final x f447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object[] f448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e.a f449c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final h<e0, T> f450d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f451e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ga.e f452f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Throwable f453g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f454h;

    /* JADX INFO: compiled from: OkHttpCall.java */
    class a implements ga.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f455a;

        a(d dVar) {
            this.f455a = dVar;
        }

        private void a(Throwable th) {
            try {
                this.f455a.b(p.this, th);
            } catch (Throwable th2) {
                d0.s(th2);
                th2.printStackTrace();
            }
        }

        @Override // ga.f
        public void onFailure(ga.e eVar, IOException iOException) {
            a(iOException);
        }

        @Override // ga.f
        public void onResponse(ga.e eVar, ga.d0 d0Var) {
            try {
                try {
                    this.f455a.a(p.this, p.this.e(d0Var));
                } catch (Throwable th) {
                    d0.s(th);
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                d0.s(th2);
                a(th2);
            }
        }
    }

    /* JADX INFO: compiled from: OkHttpCall.java */
    static final class b extends e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e0 f457a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ua.e f458b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        IOException f459c;

        /* JADX INFO: compiled from: OkHttpCall.java */
        class a extends ua.m {
            a(z0 z0Var) {
                super(z0Var);
            }

            @Override // ua.m, ua.z0
            public long read(ua.c cVar, long j10) throws IOException {
                try {
                    return super.read(cVar, j10);
                } catch (IOException e10) {
                    b.this.f459c = e10;
                    throw e10;
                }
            }
        }

        b(e0 e0Var) {
            this.f457a = e0Var;
            this.f458b = k0.d(new a(e0Var.source()));
        }

        @Override // ga.e0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f457a.close();
        }

        @Override // ga.e0
        public long contentLength() {
            return this.f457a.contentLength();
        }

        @Override // ga.e0
        public ga.x contentType() {
            return this.f457a.contentType();
        }

        @Override // ga.e0
        public ua.e source() {
            return this.f458b;
        }

        void throwIfCaught() throws IOException {
            IOException iOException = this.f459c;
            if (iOException != null) {
                throw iOException;
            }
        }
    }

    /* JADX INFO: compiled from: OkHttpCall.java */
    static final class c extends e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ga.x f461a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f462b;

        c(ga.x xVar, long j10) {
            this.f461a = xVar;
            this.f462b = j10;
        }

        @Override // ga.e0
        public long contentLength() {
            return this.f462b;
        }

        @Override // ga.e0
        public ga.x contentType() {
            return this.f461a;
        }

        @Override // ga.e0
        public ua.e source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    p(x xVar, Object[] objArr, e.a aVar, h<e0, T> hVar) {
        this.f447a = xVar;
        this.f448b = objArr;
        this.f449c = aVar;
        this.f450d = hVar;
    }

    private ga.e c() throws IOException {
        ga.e eVarB = this.f449c.b(this.f447a.a(this.f448b));
        if (eVarB != null) {
            return eVarB;
        }
        throw new NullPointerException("Call.Factory returned null.");
    }

    private ga.e d() throws IOException {
        ga.e eVar = this.f452f;
        if (eVar != null) {
            return eVar;
        }
        Throwable th = this.f453g;
        if (th != null) {
            if (th instanceof IOException) {
                throw ((IOException) th);
            }
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            throw ((Error) th);
        }
        try {
            ga.e eVarC = c();
            this.f452f = eVarC;
            return eVarC;
        } catch (IOException | Error | RuntimeException e10) {
            d0.s(e10);
            this.f453g = e10;
            throw e10;
        }
    }

    @Override // ab.b
    public synchronized ga.b0 a() {
        try {
        } catch (IOException e10) {
            throw new RuntimeException("Unable to create request.", e10);
        }
        return d().a();
    }

    @Override // ab.b
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public p<T> m1clone() {
        return new p<>(this.f447a, this.f448b, this.f449c, this.f450d);
    }

    @Override // ab.b
    public void cancel() {
        ga.e eVar;
        this.f451e = true;
        synchronized (this) {
            eVar = this.f452f;
        }
        if (eVar != null) {
            eVar.cancel();
        }
    }

    y<T> e(ga.d0 d0Var) throws IOException {
        e0 e0VarA = d0Var.a();
        ga.d0 d0VarC = d0Var.W().b(new c(e0VarA.contentType(), e0VarA.contentLength())).c();
        int iQ = d0VarC.q();
        if (iQ < 200 || iQ >= 300) {
            try {
                return y.c(d0.a(e0VarA), d0VarC);
            } finally {
                e0VarA.close();
            }
        }
        if (iQ == 204 || iQ == 205) {
            e0VarA.close();
            return y.g(null, d0VarC);
        }
        b bVar = new b(e0VarA);
        try {
            return y.g(this.f450d.convert(bVar), d0VarC);
        } catch (RuntimeException e10) {
            bVar.throwIfCaught();
            throw e10;
        }
    }

    @Override // ab.b
    public y<T> execute() throws IOException {
        ga.e eVarD;
        synchronized (this) {
            if (this.f454h) {
                throw new IllegalStateException("Already executed.");
            }
            this.f454h = true;
            eVarD = d();
        }
        if (this.f451e) {
            eVarD.cancel();
        }
        return e(eVarD.execute());
    }

    @Override // ab.b
    public void i0(d<T> dVar) {
        ga.e eVar;
        Throwable th;
        Objects.requireNonNull(dVar, "callback == null");
        synchronized (this) {
            if (this.f454h) {
                throw new IllegalStateException("Already executed.");
            }
            this.f454h = true;
            eVar = this.f452f;
            th = this.f453g;
            if (eVar == null && th == null) {
                try {
                    ga.e eVarC = c();
                    this.f452f = eVarC;
                    eVar = eVarC;
                } catch (Throwable th2) {
                    th = th2;
                    d0.s(th);
                    this.f453g = th;
                }
            }
        }
        if (th != null) {
            dVar.b(this, th);
            return;
        }
        if (this.f451e) {
            eVar.cancel();
        }
        eVar.n(new a(dVar));
    }

    @Override // ab.b
    public boolean isCanceled() {
        boolean z10 = true;
        if (this.f451e) {
            return true;
        }
        synchronized (this) {
            ga.e eVar = this.f452f;
            if (eVar == null || !eVar.isCanceled()) {
                z10 = false;
            }
        }
        return z10;
    }
}
