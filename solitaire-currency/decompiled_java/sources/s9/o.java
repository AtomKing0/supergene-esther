package s9;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Distinct.kt */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final h9.l<Object, Object> f33747a = b.f33750g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final h9.p<Object, Object, Boolean> f33748b = a.f33749g;

    /* JADX INFO: compiled from: Distinct.kt */
    static final class a extends kotlin.jvm.internal.v implements h9.p<Object, Object, Boolean> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f33749g = new a();

        a() {
            super(2);
        }

        @Override // h9.p
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean mo4invoke(@Nullable Object obj, @Nullable Object obj2) {
            return Boolean.valueOf(kotlin.jvm.internal.t.d(obj, obj2));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> h<T> a(@NotNull h<? extends T> hVar) {
        return hVar instanceof m0 ? hVar : b(hVar, f33747a, f33748b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> h<T> b(h<? extends T> hVar, h9.l<? super T, ? extends Object> lVar, h9.p<Object, Object, Boolean> pVar) {
        if (hVar instanceof g) {
            g gVar = (g) hVar;
            if (gVar.f33686b == lVar && gVar.f33687c == pVar) {
                return hVar;
            }
        }
        return new g(hVar, lVar, pVar);
    }

    /* JADX INFO: compiled from: Distinct.kt */
    static final class b extends kotlin.jvm.internal.v implements h9.l<Object, Object> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final b f33750g = new b();

        b() {
            super(1);
        }

        @Override // h9.l
        @Nullable
        public final Object invoke(@Nullable Object obj) {
            return obj;
        }
    }
}
