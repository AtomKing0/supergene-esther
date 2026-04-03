package u9;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LockFreeLinkedList.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Object f34693a = new h0("CONDITION_FALSE");

    @NotNull
    public static final Object a() {
        return f34693a;
    }

    @NotNull
    public static final s b(@NotNull Object obj) {
        s sVar;
        b0 b0Var = obj instanceof b0 ? (b0) obj : null;
        if (b0Var != null && (sVar = b0Var.f34647a) != null) {
            return sVar;
        }
        kotlin.jvm.internal.t.g(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        return (s) obj;
    }
}
