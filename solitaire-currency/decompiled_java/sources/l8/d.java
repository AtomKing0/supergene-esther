package l8;

import h9.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.d0;
import kotlin.collections.v;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.t0;
import l8.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Pipeline.kt */
/* JADX INFO: loaded from: classes.dex */
public class d<TSubject, TContext> {

    @NotNull
    private volatile /* synthetic */ Object _interceptors;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final g8.b f30949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f30950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final List<Object> f30951c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f30952d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f30953e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private h f30954f;

    public d(@NotNull h... phases) {
        t.i(phases, "phases");
        this.f30949a = g8.d.a(true);
        this.f30951c = v.q(Arrays.copyOf(phases, phases.length));
        this._interceptors = null;
    }

    private final List<q<e<TSubject, TContext>, TSubject, z8.d<? super k0>, Object>> b() {
        int iM;
        int i10 = this.f30952d;
        if (i10 == 0) {
            m(v.l());
            return v.l();
        }
        List<Object> list = this.f30951c;
        int i11 = 0;
        if (i10 == 1 && (iM = v.m(list)) >= 0) {
            int i12 = 0;
            while (true) {
                Object obj = list.get(i12);
                c<TSubject, TContext> cVar = obj instanceof c ? (c) obj : null;
                if (cVar != null && !cVar.h()) {
                    List<q<e<TSubject, TContext>, TSubject, z8.d<? super k0>, Object>> listI = cVar.i();
                    p(cVar);
                    return listI;
                }
                if (i12 == iM) {
                    break;
                }
                i12++;
            }
        }
        ArrayList arrayList = new ArrayList();
        int iM2 = v.m(list);
        if (iM2 >= 0) {
            while (true) {
                Object obj2 = list.get(i11);
                c cVar2 = obj2 instanceof c ? (c) obj2 : null;
                if (cVar2 != null) {
                    cVar2.b(arrayList);
                }
                if (i11 == iM2) {
                    break;
                }
                i11++;
            }
        }
        m(arrayList);
        return arrayList;
    }

    private final e<TSubject, TContext> c(TContext tcontext, TSubject tsubject, z8.g gVar) {
        return f.a(tcontext, q(), tsubject, gVar, g());
    }

    private final c<TSubject, TContext> e(h hVar) {
        List<Object> list = this.f30951c;
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            Object obj = list.get(i10);
            if (obj == hVar) {
                c<TSubject, TContext> cVar = new c<>(hVar, i.c.f30960a);
                list.set(i10, cVar);
                return cVar;
            }
            if (obj instanceof c) {
                c<TSubject, TContext> cVar2 = (c) obj;
                if (cVar2.e() == hVar) {
                    return cVar2;
                }
            }
        }
        return null;
    }

    private final int f(h hVar) {
        List<Object> list = this.f30951c;
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            Object obj = list.get(i10);
            if (obj == hVar || ((obj instanceof c) && ((c) obj).e() == hVar)) {
                return i10;
            }
        }
        return -1;
    }

    private final List<q<e<TSubject, TContext>, TSubject, z8.d<? super k0>, Object>> h() {
        return (List) this._interceptors;
    }

    private final boolean i(h hVar) {
        List<Object> list = this.f30951c;
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            Object obj = list.get(i10);
            if (obj == hVar) {
                return true;
            }
            if ((obj instanceof c) && ((c) obj).e() == hVar) {
                return true;
            }
        }
        return false;
    }

    private final void m(List<? extends q<? super e<TSubject, TContext>, ? super TSubject, ? super z8.d<? super k0>, ? extends Object>> list) {
        o(list);
        this.f30953e = false;
        this.f30954f = null;
    }

    private final void n() {
        o(null);
        this.f30953e = false;
        this.f30954f = null;
    }

    private final void o(List<? extends q<? super e<TSubject, TContext>, ? super TSubject, ? super z8.d<? super k0>, ? extends Object>> list) {
        this._interceptors = list;
    }

    private final void p(c<TSubject, TContext> cVar) {
        o(cVar.i());
        this.f30953e = false;
        this.f30954f = cVar.e();
    }

    private final List<q<e<TSubject, TContext>, TSubject, z8.d<? super k0>, Object>> q() {
        if (h() == null) {
            b();
        }
        this.f30953e = true;
        List<q<e<TSubject, TContext>, TSubject, z8.d<? super k0>, Object>> listH = h();
        t.f(listH);
        return listH;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean r(h hVar, q<? super e<TSubject, TContext>, ? super TSubject, ? super z8.d<? super k0>, ? extends Object> qVar) {
        List<q<e<TSubject, TContext>, TSubject, z8.d<? super k0>, Object>> listH = h();
        if (this.f30951c.isEmpty() || listH == null || this.f30953e || !t0.n(listH)) {
            return false;
        }
        if (t.d(this.f30954f, hVar)) {
            listH.add(qVar);
            return true;
        }
        if (!t.d(hVar, d0.t0(this.f30951c)) && f(hVar) != v.m(this.f30951c)) {
            return false;
        }
        c<TSubject, TContext> cVarE = e(hVar);
        t.f(cVarE);
        cVarE.a(qVar);
        listH.add(qVar);
        return true;
    }

    @Nullable
    public final Object d(@NotNull TContext tcontext, @NotNull TSubject tsubject, @NotNull z8.d<? super TSubject> dVar) {
        return c(tcontext, tsubject, dVar.getContext()).b(tsubject, dVar);
    }

    public boolean g() {
        return this.f30950b;
    }

    public final void j(@NotNull h reference, @NotNull h phase) throws b {
        i iVarF;
        h hVarA;
        t.i(reference, "reference");
        t.i(phase, "phase");
        if (i(phase)) {
            return;
        }
        int iF = f(reference);
        if (iF == -1) {
            throw new b("Phase " + reference + " was not registered for this pipeline");
        }
        int i10 = iF + 1;
        int iM = v.m(this.f30951c);
        if (i10 <= iM) {
            while (true) {
                Object obj = this.f30951c.get(i10);
                c cVar = obj instanceof c ? (c) obj : null;
                if (cVar != null && (iVarF = cVar.f()) != null) {
                    i.a aVar = iVarF instanceof i.a ? (i.a) iVarF : null;
                    if (aVar != null && (hVarA = aVar.a()) != null && t.d(hVarA, reference)) {
                        iF = i10;
                    }
                    if (i10 == iM) {
                        break;
                    } else {
                        i10++;
                    }
                } else {
                    break;
                }
            }
        }
        this.f30951c.add(iF + 1, new c(phase, new i.a(reference)));
    }

    public final void k(@NotNull h reference, @NotNull h phase) throws b {
        t.i(reference, "reference");
        t.i(phase, "phase");
        if (i(phase)) {
            return;
        }
        int iF = f(reference);
        if (iF != -1) {
            this.f30951c.add(iF, new c(phase, new i.b(reference)));
            return;
        }
        throw new b("Phase " + reference + " was not registered for this pipeline");
    }

    public final void l(@NotNull h phase, @NotNull q<? super e<TSubject, TContext>, ? super TSubject, ? super z8.d<? super k0>, ? extends Object> block) {
        t.i(phase, "phase");
        t.i(block, "block");
        c<TSubject, TContext> cVarE = e(phase);
        if (cVarE == null) {
            throw new b("Phase " + phase + " was not registered for this pipeline");
        }
        if (r(phase, block)) {
            this.f30952d++;
            return;
        }
        cVarE.a(block);
        this.f30952d++;
        n();
        a();
    }

    public void a() {
    }
}
