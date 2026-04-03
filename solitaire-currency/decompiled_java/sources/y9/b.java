package y9;

import h9.l;
import h9.q;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.j3;
import kotlinx.coroutines.o;
import kotlinx.coroutines.p;
import kotlinx.coroutines.r;
import kotlinx.coroutines.s0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u9.e0;
import v8.k0;

/* JADX INFO: compiled from: Mutex.kt */
/* JADX INFO: loaded from: classes5.dex */
public class b extends e implements y9.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f36903i = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "owner");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private final q<x9.b<?>, Object, Object, l<Throwable, k0>> f36904h;

    @Nullable
    private volatile Object owner;

    /* JADX INFO: compiled from: Mutex.kt */
    private final class a implements o<k0>, j3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public final p<k0> f36905a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final Object f36906b;

        /* JADX INFO: renamed from: y9.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Mutex.kt */
        static final class C0756a extends v implements l<Throwable, k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ b f36908g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ a f36909h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0756a(b bVar, a aVar) {
                super(1);
                this.f36908g = bVar;
                this.f36909h = aVar;
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ k0 invoke(Throwable th) {
                invoke2(th);
                return k0.f35197a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Throwable th) {
                this.f36908g.g(this.f36909h.f36906b);
            }
        }

        /* JADX INFO: renamed from: y9.b$a$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Mutex.kt */
        static final class C0757b extends v implements l<Throwable, k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ b f36910g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ a f36911h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0757b(b bVar, a aVar) {
                super(1);
                this.f36910g = bVar;
                this.f36911h = aVar;
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ k0 invoke(Throwable th) {
                invoke2(th);
                return k0.f35197a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Throwable th) {
                b.f36903i.set(this.f36910g, this.f36911h.f36906b);
                this.f36910g.g(this.f36911h.f36906b);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull p<? super k0> pVar, @Nullable Object obj) {
            this.f36905a = pVar;
            this.f36906b = obj;
        }

        @Override // kotlinx.coroutines.j3
        public void a(@NotNull e0<?> e0Var, int i10) {
            this.f36905a.a(e0Var, i10);
        }

        @Override // kotlinx.coroutines.o
        public boolean b(@Nullable Throwable th) {
            return this.f36905a.b(th);
        }

        @Override // kotlinx.coroutines.o
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void l(@NotNull k0 k0Var, @Nullable l<? super Throwable, k0> lVar) {
            b.f36903i.set(b.this, this.f36906b);
            this.f36905a.l(k0Var, new C0756a(b.this, this));
        }

        @Override // kotlinx.coroutines.o
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void o(@NotNull kotlinx.coroutines.k0 k0Var, @NotNull k0 k0Var2) {
            this.f36905a.o(k0Var, k0Var2);
        }

        @Override // kotlinx.coroutines.o
        @Nullable
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Object k(@NotNull k0 k0Var, @Nullable Object obj, @Nullable l<? super Throwable, k0> lVar) {
            Object objK = this.f36905a.k(k0Var, obj, new C0757b(b.this, this));
            if (objK != null) {
                b.f36903i.set(b.this, this.f36906b);
            }
            return objK;
        }

        @Override // z8.d
        @NotNull
        public z8.g getContext() {
            return this.f36905a.getContext();
        }

        @Override // kotlinx.coroutines.o
        public boolean i() {
            return this.f36905a.i();
        }

        @Override // kotlinx.coroutines.o
        public boolean isActive() {
            return this.f36905a.isActive();
        }

        @Override // kotlinx.coroutines.o
        @Nullable
        public Object j(@NotNull Throwable th) {
            return this.f36905a.j(th);
        }

        @Override // kotlinx.coroutines.o
        public void m(@NotNull l<? super Throwable, k0> lVar) {
            this.f36905a.m(lVar);
        }

        @Override // z8.d
        public void resumeWith(@NotNull Object obj) {
            this.f36905a.resumeWith(obj);
        }

        @Override // kotlinx.coroutines.o
        public void u(@NotNull Object obj) {
            this.f36905a.u(obj);
        }
    }

    /* JADX INFO: renamed from: y9.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Mutex.kt */
    static final class C0758b extends v implements q<x9.b<?>, Object, Object, l<? super Throwable, ? extends k0>> {

        /* JADX INFO: renamed from: y9.b$b$a */
        /* JADX INFO: compiled from: Mutex.kt */
        static final class a extends v implements l<Throwable, k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ b f36913g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ Object f36914h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(b bVar, Object obj) {
                super(1);
                this.f36913g = bVar;
                this.f36914h = obj;
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ k0 invoke(Throwable th) {
                invoke2(th);
                return k0.f35197a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Throwable th) {
                this.f36913g.g(this.f36914h);
            }
        }

        C0758b() {
            super(3);
        }

        @Override // h9.q
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final l<Throwable, k0> invoke(@NotNull x9.b<?> bVar, @Nullable Object obj, @Nullable Object obj2) {
            return new a(b.this, obj);
        }
    }

    public b(boolean z10) {
        super(1, z10 ? 1 : 0);
        this.owner = z10 ? null : c.f36915a;
        this.f36904h = new C0758b();
    }

    private final int r(Object obj) {
        while (f()) {
            Object obj2 = f36903i.get(this);
            if (obj2 != c.f36915a) {
                return obj2 == obj ? 1 : 2;
            }
        }
        return 0;
    }

    static /* synthetic */ Object s(b bVar, Object obj, z8.d<? super k0> dVar) throws Throwable {
        if (bVar.d(obj)) {
            return k0.f35197a;
        }
        Object objT = bVar.t(obj, dVar);
        return objT == a9.d.e() ? objT : k0.f35197a;
    }

    private final Object t(Object obj, z8.d<? super k0> dVar) throws Throwable {
        p pVarB = r.b(a9.c.c(dVar));
        try {
            i(new a(pVarB, obj));
            Object objZ = pVarB.z();
            if (objZ == a9.d.e()) {
                h.c(dVar);
            }
            return objZ == a9.d.e() ? objZ : k0.f35197a;
        } catch (Throwable th) {
            pVarB.K();
            throw th;
        }
    }

    private final int u(Object obj) {
        while (!c()) {
            if (obj == null) {
                return 1;
            }
            int iR = r(obj);
            if (iR == 1) {
                return 2;
            }
            if (iR == 2) {
                return 1;
            }
        }
        f36903i.set(this, obj);
        return 0;
    }

    @Override // y9.a
    public boolean d(@Nullable Object obj) {
        int iU = u(obj);
        if (iU == 0) {
            return true;
        }
        if (iU == 1) {
            return false;
        }
        if (iU != 2) {
            throw new IllegalStateException("unexpected".toString());
        }
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + obj).toString());
    }

    @Override // y9.a
    @Nullable
    public Object e(@Nullable Object obj, @NotNull z8.d<? super k0> dVar) {
        return s(this, obj, dVar);
    }

    @Override // y9.a
    public boolean f() {
        return b() == 0;
    }

    @Override // y9.a
    public void g(@Nullable Object obj) {
        while (f()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f36903i;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 != c.f36915a) {
                if (!(obj2 == obj || obj == null)) {
                    throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
                }
                if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj2, c.f36915a)) {
                    release();
                    return;
                }
            }
        }
        throw new IllegalStateException("This mutex is not locked".toString());
    }

    @NotNull
    public String toString() {
        return "Mutex@" + s0.b(this) + "[isLocked=" + f() + ",owner=" + f36903i.get(this) + ']';
    }
}
