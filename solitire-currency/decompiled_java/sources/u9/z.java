package u9;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: OnUndeliveredElement.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class z {

    /* JADX INFO: compiled from: OnUndeliveredElement.kt */
    static final class a extends kotlin.jvm.internal.v implements h9.l<Throwable, v8.k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ h9.l<E, v8.k0> f34719g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ E f34720h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ z8.g f34721i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(h9.l<? super E, v8.k0> lVar, E e10, z8.g gVar) {
            super(1);
            this.f34719g = lVar;
            this.f34720h = e10;
            this.f34721i = gVar;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ v8.k0 invoke(Throwable th) {
            invoke2(th);
            return v8.k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Throwable th) {
            z.b(this.f34719g, this.f34720h, this.f34721i);
        }
    }

    @NotNull
    public static final <E> h9.l<Throwable, v8.k0> a(@NotNull h9.l<? super E, v8.k0> lVar, E e10, @NotNull z8.g gVar) {
        return new a(lVar, e10, gVar);
    }

    public static final <E> void b(@NotNull h9.l<? super E, v8.k0> lVar, E e10, @NotNull z8.g gVar) {
        s0 s0VarC = c(lVar, e10, null);
        if (s0VarC != null) {
            kotlinx.coroutines.m0.a(gVar, s0VarC);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static final <E> s0 c(@NotNull h9.l<? super E, v8.k0> lVar, E e10, @Nullable s0 s0Var) {
        try {
            lVar.invoke(e10);
        } catch (Throwable th) {
            if (s0Var == null || s0Var.getCause() == th) {
                return new s0("Exception in undelivered element handler for " + e10, th);
            }
            v8.f.a(s0Var, th);
        }
        return s0Var;
    }

    public static /* synthetic */ s0 d(h9.l lVar, Object obj, s0 s0Var, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            s0Var = null;
        }
        return c(lVar, obj, s0Var);
    }
}
