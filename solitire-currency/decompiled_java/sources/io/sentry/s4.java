package io.sentry;

import java.lang.reflect.InvocationTargetException;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ScopesStorageFactory.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class s4 {
    @NotNull
    public static g1 a(@NotNull io.sentry.util.s sVar, @NotNull w0 w0Var) {
        g1 g1VarB = b(sVar, w0Var);
        g1VarB.a();
        return g1VarB;
    }

    @NotNull
    private static g1 b(@NotNull io.sentry.util.s sVar, @NotNull w0 w0Var) {
        Class<?> clsC;
        if (io.sentry.util.y.c() && sVar.a("io.sentry.opentelemetry.OtelContextScopesStorage", w0Var) && (clsC = sVar.c("io.sentry.opentelemetry.OtelContextScopesStorage", w0Var)) != null) {
            try {
                Object objNewInstance = clsC.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                if (objNewInstance != null && (objNewInstance instanceof g1)) {
                    return (g1) objNewInstance;
                }
            } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
            }
        }
        return new r();
    }
}
