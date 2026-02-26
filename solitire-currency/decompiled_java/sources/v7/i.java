package v7;

import e8.o;
import e8.o0;
import java.util.ArrayList;
import java.util.Set;
import kotlinx.coroutines.a0;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.f2;
import kotlinx.coroutines.n0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: HttpClientEngine.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final n0 f35152a = new n0("call-context");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final g8.a<s7.b<?>> f35153b = new g8.a<>("client-config");

    @Nullable
    public static final Object b(@NotNull b bVar, @NotNull b2 b2Var, @NotNull z8.d<? super z8.g> dVar) {
        a0 a0VarA = f2.a(b2Var);
        z8.g gVarPlus = bVar.getCoroutineContext().plus(a0VarA).plus(f35152a);
        b2 b2Var2 = (b2) dVar.getContext().get(b2.O7);
        if (b2Var2 != null) {
            a0VarA.J(new k(b2.a.d(b2Var2, true, false, new l(a0VarA), 2, null)));
        }
        return gVarPlus;
    }

    @NotNull
    public static final g8.a<s7.b<?>> c() {
        return f35153b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(a8.d dVar) {
        Set<String> setNames = dVar.e().names();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setNames) {
            if (o.f25274a.v().contains((String) obj)) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            throw new o0(arrayList.toString());
        }
    }
}
