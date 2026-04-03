package a0;

import ga.d0;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.t;

/* JADX INFO: compiled from: Calls.kt */
/* JADX INFO: loaded from: classes2.dex */
final class k implements ga.f, h9.l<Throwable, k0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final ga.e f46a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final kotlinx.coroutines.o<d0> f47b;

    /* JADX WARN: Multi-variable type inference failed */
    public k(@NotNull ga.e eVar, @NotNull kotlinx.coroutines.o<? super d0> oVar) {
        this.f46a = eVar;
        this.f47b = oVar;
    }

    public void a(@Nullable Throwable th) {
        try {
            this.f46a.cancel();
        } catch (Throwable unused) {
        }
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Throwable th) {
        a(th);
        return k0.f35197a;
    }

    @Override // ga.f
    public void onFailure(@NotNull ga.e eVar, @NotNull IOException iOException) {
        if (eVar.isCanceled()) {
            return;
        }
        kotlinx.coroutines.o<d0> oVar = this.f47b;
        t.a aVar = v8.t.f35208b;
        oVar.resumeWith(v8.t.b(v8.u.a(iOException)));
    }

    @Override // ga.f
    public void onResponse(@NotNull ga.e eVar, @NotNull d0 d0Var) {
        this.f47b.resumeWith(v8.t.b(d0Var));
    }
}
