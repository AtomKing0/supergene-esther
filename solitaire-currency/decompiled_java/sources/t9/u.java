package t9;

import kotlin.jvm.internal.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: SafeCollector.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final h9.q<s9.i<Object>, Object, z8.d<? super k0>, Object> f34180a;

    /* JADX INFO: compiled from: SafeCollector.kt */
    /* synthetic */ class a extends kotlin.jvm.internal.q implements h9.q<s9.i<? super Object>, Object, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f34181b = new a();

        a() {
            super(3, s9.i.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // h9.q
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(@NotNull s9.i<Object> iVar, @Nullable Object obj, @NotNull z8.d<? super k0> dVar) {
            return iVar.emit(obj, dVar);
        }
    }

    static {
        a aVar = a.f34181b;
        kotlin.jvm.internal.t.g(aVar, "null cannot be cast to non-null type kotlin.Function3<kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>, kotlin.Any?, kotlin.coroutines.Continuation<kotlin.Unit>, kotlin.Any?>");
        f34180a = (h9.q) t0.f(aVar, 3);
    }
}
