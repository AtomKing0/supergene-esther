package u;

import a0.j;
import com.ironsource.nb;
import ga.d0;
import ga.u;
import ga.x;
import java.io.IOException;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.l;
import v8.n;
import v8.p;

/* JADX INFO: compiled from: CacheResponse.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final l f34197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final l f34198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f34199c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f34200d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f34201e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final u f34202f;

    /* JADX INFO: renamed from: u.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CacheResponse.kt */
    static final class C0699a extends v implements h9.a<ga.d> {
        C0699a() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ga.d invoke() {
            return ga.d.f25999n.b(a.this.d());
        }
    }

    /* JADX INFO: compiled from: CacheResponse.kt */
    static final class b extends v implements h9.a<x> {
        b() {
            super(0);
        }

        @Override // h9.a
        @Nullable
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final x invoke() {
            String strA = a.this.d().a(nb.K);
            if (strA != null) {
                return x.f26237e.b(strA);
            }
            return null;
        }
    }

    public a(@NotNull ua.e eVar) {
        p pVar = p.f35203c;
        this.f34197a = n.b(pVar, new C0699a());
        this.f34198b = n.b(pVar, new b());
        this.f34199c = Long.parseLong(eVar.N());
        this.f34200d = Long.parseLong(eVar.N());
        this.f34201e = Integer.parseInt(eVar.N()) > 0;
        int i10 = Integer.parseInt(eVar.N());
        u.a aVar = new u.a();
        for (int i11 = 0; i11 < i10; i11++) {
            j.b(aVar, eVar.N());
        }
        this.f34202f = aVar.f();
    }

    @NotNull
    public final ga.d a() {
        return (ga.d) this.f34197a.getValue();
    }

    @Nullable
    public final x b() {
        return (x) this.f34198b.getValue();
    }

    public final long c() {
        return this.f34200d;
    }

    @NotNull
    public final u d() {
        return this.f34202f;
    }

    public final long e() {
        return this.f34199c;
    }

    public final boolean f() {
        return this.f34201e;
    }

    public final void g(@NotNull ua.d dVar) throws IOException {
        dVar.b0(this.f34199c).writeByte(10);
        dVar.b0(this.f34200d).writeByte(10);
        dVar.b0(this.f34201e ? 1L : 0L).writeByte(10);
        dVar.b0(this.f34202f.size()).writeByte(10);
        int size = this.f34202f.size();
        for (int i10 = 0; i10 < size; i10++) {
            dVar.E(this.f34202f.e(i10)).E(": ").E(this.f34202f.i(i10)).writeByte(10);
        }
    }

    public a(@NotNull d0 d0Var) {
        p pVar = p.f35203c;
        this.f34197a = n.b(pVar, new C0699a());
        this.f34198b = n.b(pVar, new b());
        this.f34199c = d0Var.J0();
        this.f34200d = d0Var.G0();
        this.f34201e = d0Var.z() != null;
        this.f34202f = d0Var.L();
    }
}
