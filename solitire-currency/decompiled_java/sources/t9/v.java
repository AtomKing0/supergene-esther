package t9;

import kotlinx.coroutines.b2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u9.d0;
import z8.g;

/* JADX INFO: compiled from: SafeCollector.common.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class v {

    /* JADX INFO: compiled from: SafeCollector.common.kt */
    static final class a extends kotlin.jvm.internal.v implements h9.p<Integer, g.b, Integer> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ t<?> f34182g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(t<?> tVar) {
            super(2);
            this.f34182g = tVar;
        }

        @NotNull
        public final Integer a(int i10, @NotNull g.b bVar) {
            g.c<?> key = bVar.getKey();
            g.b bVar2 = this.f34182g.f34175k.get(key);
            if (key != b2.O7) {
                return Integer.valueOf(bVar != bVar2 ? Integer.MIN_VALUE : i10 + 1);
            }
            b2 b2Var = (b2) bVar2;
            kotlin.jvm.internal.t.g(bVar, "null cannot be cast to non-null type kotlinx.coroutines.Job");
            b2 b2VarB = v.b((b2) bVar, b2Var);
            if (b2VarB == b2Var) {
                if (b2Var != null) {
                    i10++;
                }
                return Integer.valueOf(i10);
            }
            throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + b2VarB + ", expected child of " + b2Var + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Integer mo4invoke(Integer num, g.b bVar) {
            return a(num.intValue(), bVar);
        }
    }

    public static final void a(@NotNull t<?> tVar, @NotNull z8.g gVar) {
        if (((Number) gVar.fold(0, new a(tVar))).intValue() == tVar.f34176l) {
            return;
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + tVar.f34175k + ",\n\t\tbut emission happened in " + gVar + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
    }

    @Nullable
    public static final b2 b(@Nullable b2 b2Var, @Nullable b2 b2Var2) {
        while (b2Var != null) {
            if (b2Var == b2Var2) {
                return b2Var;
            }
            if (!(b2Var instanceof d0)) {
                return b2Var;
            }
            b2Var = b2Var.getParent();
        }
        return null;
    }
}
