package v8;

import org.jetbrains.annotations.NotNull;
import v8.t;

/* JADX INFO: compiled from: DeepRecursive.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Object f35166a;

    static {
        t.a aVar = t.f35208b;
        f35166a = t.b(a9.d.e());
    }

    public static final <T, R> R b(@NotNull a<T, R> aVar, T t10) {
        kotlin.jvm.internal.t.i(aVar, "<this>");
        return (R) new d(aVar.a(), t10).c();
    }
}
