package x9;

import h9.l;
import h9.q;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.collections.d0;
import kotlin.collections.u;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.j3;
import kotlinx.coroutines.m;
import kotlinx.coroutines.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u9.e0;
import v8.k0;
import z8.g;

/* JADX INFO: compiled from: Select.kt */
/* JADX INFO: loaded from: classes5.dex */
public class a<R> extends m implements b, j3 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f36223f = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "state");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final g f36224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private List<a<R>.C0733a> f36225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private Object f36226c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f36227d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private Object f36228e;

    @Nullable
    private volatile Object state;

    /* JADX INFO: renamed from: x9.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Select.kt */
    public final class C0733a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public final Object f36229a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private final Object f36230b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public final q<b<?>, Object, Object, l<Throwable, k0>> f36231c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public Object f36232d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f36233e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a<R> f36234f;

        @Nullable
        public final l<Throwable, k0> a(@NotNull b<?> bVar, @Nullable Object obj) {
            q<b<?>, Object, Object, l<Throwable, k0>> qVar = this.f36231c;
            if (qVar != null) {
                return qVar.invoke(bVar, this.f36230b, obj);
            }
            return null;
        }

        public final void b() {
            Object obj = this.f36232d;
            a<R> aVar = this.f36234f;
            if (obj instanceof e0) {
                ((e0) obj).o(this.f36233e, null, aVar.getContext());
                return;
            }
            g1 g1Var = obj instanceof g1 ? (g1) obj : null;
            if (g1Var != null) {
                g1Var.dispose();
            }
        }
    }

    private final a<R>.C0733a e(Object obj) {
        List<a<R>.C0733a> list = this.f36225b;
        Object obj2 = null;
        if (list == null) {
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((C0733a) next).f36229a == obj) {
                obj2 = next;
                break;
            }
        }
        a<R>.C0733a c0733a = (C0733a) obj2;
        if (c0733a != null) {
            return c0733a;
        }
        throw new IllegalStateException(("Clause with object " + obj + " is not found").toString());
    }

    private final int g(Object obj, Object obj2) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f36223f;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj3 instanceof o) {
                a<R>.C0733a c0733aE = e(obj);
                if (c0733aE == null) {
                    continue;
                } else {
                    l<Throwable, k0> lVarA = c0733aE.a(this, obj2);
                    if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj3, c0733aE)) {
                        this.f36228e = obj2;
                        if (c.h((o) obj3, lVarA)) {
                            return 0;
                        }
                        this.f36228e = null;
                        return 2;
                    }
                }
            } else {
                if (t.d(obj3, c.f36237c) ? true : obj3 instanceof C0733a) {
                    return 3;
                }
                if (t.d(obj3, c.f36238d)) {
                    return 2;
                }
                if (t.d(obj3, c.f36236b)) {
                    if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj3, u.e(obj))) {
                        return 1;
                    }
                } else {
                    if (!(obj3 instanceof List)) {
                        throw new IllegalStateException(("Unexpected state: " + obj3).toString());
                    }
                    if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj3, d0.B0((Collection) obj3, obj))) {
                        return 1;
                    }
                }
            }
        }
    }

    @Override // kotlinx.coroutines.j3
    public void a(@NotNull e0<?> e0Var, int i10) {
        this.f36226c = e0Var;
        this.f36227d = i10;
    }

    @Override // x9.b
    public void b(@Nullable Object obj) {
        this.f36228e = obj;
    }

    @Override // x9.b
    public boolean c(@NotNull Object obj, @Nullable Object obj2) {
        return g(obj, obj2) == 0;
    }

    @Override // kotlinx.coroutines.n
    public void d(@Nullable Throwable th) {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f36223f;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            if (obj == c.f36237c) {
                return;
            }
        } while (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj, c.f36238d));
        List<a<R>.C0733a> list = this.f36225b;
        if (list == null) {
            return;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((C0733a) it.next()).b();
        }
        this.f36228e = c.f36239e;
        this.f36225b = null;
    }

    @NotNull
    public final d f(@NotNull Object obj, @Nullable Object obj2) {
        return c.a(g(obj, obj2));
    }

    @Override // x9.b
    @NotNull
    public g getContext() {
        return this.f36224a;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Throwable th) {
        d(th);
        return k0.f35197a;
    }
}
