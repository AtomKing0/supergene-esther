package u9;

import kotlinx.coroutines.z2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ThreadContext.kt */
/* JADX INFO: loaded from: classes5.dex */
final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final z8.g f34694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final Object[] f34695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final z2<Object>[] f34696c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f34697d;

    public r0(@NotNull z8.g gVar, int i10) {
        this.f34694a = gVar;
        this.f34695b = new Object[i10];
        this.f34696c = new z2[i10];
    }

    public final void a(@NotNull z2<?> z2Var, @Nullable Object obj) {
        Object[] objArr = this.f34695b;
        int i10 = this.f34697d;
        objArr[i10] = obj;
        z2<Object>[] z2VarArr = this.f34696c;
        this.f34697d = i10 + 1;
        kotlin.jvm.internal.t.g(z2Var, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        z2VarArr[i10] = z2Var;
    }

    public final void b(@NotNull z8.g gVar) {
        int length = this.f34696c.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i10 = length - 1;
            z2<Object> z2Var = this.f34696c[length];
            kotlin.jvm.internal.t.f(z2Var);
            z2Var.restoreThreadContext(gVar, this.f34695b[length]);
            if (i10 < 0) {
                return;
            } else {
                length = i10;
            }
        }
    }
}
