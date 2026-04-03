package y1;

import android.content.Context;
import f2.w;
import f2.x;
import g2.m0;
import g2.n0;
import g2.u0;
import java.util.concurrent.Executor;
import y1.u;

/* JADX INFO: compiled from: DaggerTransportRuntimeComponent.java */
/* JADX INFO: loaded from: classes2.dex */
final class e extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private u8.a<Executor> f36396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private u8.a<Context> f36397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private u8.a f36398c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private u8.a f36399d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private u8.a f36400e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private u8.a<String> f36401f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private u8.a<m0> f36402g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private u8.a<f2.f> f36403h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private u8.a<x> f36404i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private u8.a<e2.c> f36405j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private u8.a<f2.r> f36406k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private u8.a<f2.v> f36407l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private u8.a<t> f36408m;

    /* JADX INFO: compiled from: DaggerTransportRuntimeComponent.java */
    private static final class b implements u.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f36409a;

        private b() {
        }

        @Override // y1.u.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a(Context context) {
            this.f36409a = (Context) a2.d.b(context);
            return this;
        }

        @Override // y1.u.a
        public u build() {
            a2.d.a(this.f36409a, Context.class);
            return new e(this.f36409a);
        }
    }

    public static u.a i() {
        return new b();
    }

    private void n(Context context) {
        this.f36396a = a2.a.a(k.a());
        a2.b bVarA = a2.c.a(context);
        this.f36397b = bVarA;
        z1.j jVarA = z1.j.a(bVarA, i2.c.a(), i2.d.a());
        this.f36398c = jVarA;
        this.f36399d = a2.a.a(z1.l.a(this.f36397b, jVarA));
        this.f36400e = u0.a(this.f36397b, g2.g.a(), g2.i.a());
        this.f36401f = a2.a.a(g2.h.a(this.f36397b));
        this.f36402g = a2.a.a(n0.a(i2.c.a(), i2.d.a(), g2.j.a(), this.f36400e, this.f36401f));
        e2.g gVarB = e2.g.b(i2.c.a());
        this.f36403h = gVarB;
        e2.i iVarA = e2.i.a(this.f36397b, this.f36402g, gVarB, i2.d.a());
        this.f36404i = iVarA;
        u8.a<Executor> aVar = this.f36396a;
        u8.a aVar2 = this.f36399d;
        u8.a<m0> aVar3 = this.f36402g;
        this.f36405j = e2.d.a(aVar, aVar2, iVarA, aVar3, aVar3);
        u8.a<Context> aVar4 = this.f36397b;
        u8.a aVar5 = this.f36399d;
        u8.a<m0> aVar6 = this.f36402g;
        this.f36406k = f2.s.a(aVar4, aVar5, aVar6, this.f36404i, this.f36396a, aVar6, i2.c.a(), i2.d.a(), this.f36402g);
        u8.a<Executor> aVar7 = this.f36396a;
        u8.a<m0> aVar8 = this.f36402g;
        this.f36407l = w.a(aVar7, aVar8, this.f36404i, aVar8);
        this.f36408m = a2.a.a(v.a(i2.c.a(), i2.d.a(), this.f36405j, this.f36406k, this.f36407l));
    }

    @Override // y1.u
    g2.d a() {
        return this.f36402g.get();
    }

    @Override // y1.u
    t c() {
        return this.f36408m.get();
    }

    private e(Context context) {
        n(context);
    }
}
