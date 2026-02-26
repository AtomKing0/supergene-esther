package u9;

import kotlinx.coroutines.z2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.g;

/* JADX INFO: compiled from: ThreadContext.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h0 f34671a = new h0("NO_THREAD_ELEMENTS");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final h9.p<Object, g.b, Object> f34672b = a.f34675g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private static final h9.p<z2<?>, g.b, z2<?>> f34673c = b.f34676g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private static final h9.p<r0, g.b, r0> f34674d = c.f34677g;

    /* JADX INFO: compiled from: ThreadContext.kt */
    static final class a extends kotlin.jvm.internal.v implements h9.p<Object, g.b, Object> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f34675g = new a();

        a() {
            super(2);
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@Nullable Object obj, @NotNull g.b bVar) {
            if (!(bVar instanceof z2)) {
                return obj;
            }
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            int iIntValue = num != null ? num.intValue() : 1;
            return iIntValue == 0 ? bVar : Integer.valueOf(iIntValue + 1);
        }
    }

    /* JADX INFO: compiled from: ThreadContext.kt */
    static final class b extends kotlin.jvm.internal.v implements h9.p<z2<?>, g.b, z2<?>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final b f34676g = new b();

        b() {
            super(2);
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final z2<?> mo4invoke(@Nullable z2<?> z2Var, @NotNull g.b bVar) {
            if (z2Var != null) {
                return z2Var;
            }
            if (bVar instanceof z2) {
                return (z2) bVar;
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: ThreadContext.kt */
    static final class c extends kotlin.jvm.internal.v implements h9.p<r0, g.b, r0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final c f34677g = new c();

        c() {
            super(2);
        }

        @Override // h9.p
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final r0 mo4invoke(@NotNull r0 r0Var, @NotNull g.b bVar) {
            if (bVar instanceof z2) {
                z2<?> z2Var = (z2) bVar;
                r0Var.a(z2Var, z2Var.updateThreadContext(r0Var.f34694a));
            }
            return r0Var;
        }
    }

    public static final void a(@NotNull z8.g gVar, @Nullable Object obj) {
        if (obj == f34671a) {
            return;
        }
        if (obj instanceof r0) {
            ((r0) obj).b(gVar);
            return;
        }
        Object objFold = gVar.fold(null, f34673c);
        kotlin.jvm.internal.t.g(objFold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        ((z2) objFold).restoreThreadContext(gVar, obj);
    }

    @NotNull
    public static final Object b(@NotNull z8.g gVar) {
        Object objFold = gVar.fold(0, f34672b);
        kotlin.jvm.internal.t.f(objFold);
        return objFold;
    }

    @Nullable
    public static final Object c(@NotNull z8.g gVar, @Nullable Object obj) {
        if (obj == null) {
            obj = b(gVar);
        }
        if (obj == 0) {
            return f34671a;
        }
        if (obj instanceof Integer) {
            return gVar.fold(new r0(gVar, ((Number) obj).intValue()), f34674d);
        }
        kotlin.jvm.internal.t.g(obj, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((z2) obj).updateThreadContext(gVar);
    }
}
