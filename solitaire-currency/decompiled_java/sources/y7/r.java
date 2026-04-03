package y7;

import e8.t;
import e8.v;
import java.util.Set;
import kotlin.collections.z0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: HttpRedirect.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Set<e8.t> f36794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final xa.a f36795b;

    static {
        t.a aVar = e8.t.f25351b;
        f36794a = z0.h(aVar.a(), aVar.b());
        f36795b = k8.a.a("io.ktor.client.plugins.HttpRedirect");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(e8.v vVar) {
        int iE0 = vVar.e0();
        v.a aVar = e8.v.f25372c;
        return (((iE0 == aVar.s().e0() || iE0 == aVar.k().e0()) || iE0 == aVar.S().e0()) || iE0 == aVar.F().e0()) || iE0 == aVar.O().e0();
    }
}
