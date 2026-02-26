package io.sentry;

import java.lang.reflect.InvocationTargetException;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SpanFactoryFactory.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class k8 {
    @NotNull
    public static o1 a(@NotNull io.sentry.util.s sVar, @NotNull w0 w0Var) {
        Class<?> clsC;
        if (io.sentry.util.y.c() && sVar.a("io.sentry.opentelemetry.OtelSpanFactory", w0Var) && (clsC = sVar.c("io.sentry.opentelemetry.OtelSpanFactory", w0Var)) != null) {
            try {
                Object objNewInstance = clsC.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                if (objNewInstance != null && (objNewInstance instanceof o1)) {
                    return (o1) objNewInstance;
                }
            } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
            }
        }
        return new s();
    }
}
