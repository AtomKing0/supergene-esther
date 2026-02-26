package s7;

import h9.l;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.collections.d0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v7.h;
import v8.k0;

/* JADX INFO: compiled from: HttpClientJvm.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final List<c> f33627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final h<?> f33628b;

    static {
        h<?> hVarA;
        ServiceLoader serviceLoaderLoad = ServiceLoader.load(c.class, c.class.getClassLoader());
        t.h(serviceLoaderLoad, "load(it, it.classLoader)");
        List<c> listP0 = d0.P0(serviceLoaderLoad);
        f33627a = listP0;
        c cVar = (c) d0.k0(listP0);
        if (cVar == null || (hVarA = cVar.a()) == null) {
            throw new IllegalStateException("Failed to find HTTP client engine implementation in the classpath: consider adding client engine dependency. See https://ktor.io/docs/http-client-engines.html".toString());
        }
        f33628b = hVarA;
    }

    @NotNull
    public static final a a(@NotNull l<? super b<?>, k0> block) {
        t.i(block, "block");
        return e.a(f33628b, block);
    }
}
