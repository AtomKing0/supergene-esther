package androidx.activity.contextaware;

import a9.c;
import android.content.Context;
import h9.l;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z8.d;

/* JADX INFO: compiled from: ContextAware.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ContextAwareKt {
    @Nullable
    public static final <R> Object withContextAvailable(@NotNull ContextAware contextAware, @NotNull l<Context, R> lVar, @NotNull d<R> dVar) throws Throwable {
        Context contextPeekAvailableContext = contextAware.peekAvailableContext();
        if (contextPeekAvailableContext != null) {
            return lVar.invoke(contextPeekAvailableContext);
        }
        p pVar = new p(c.c(dVar), 1);
        pVar.C();
        ContextAwareKt$withContextAvailable$2$listener$1 contextAwareKt$withContextAvailable$2$listener$1 = new ContextAwareKt$withContextAvailable$2$listener$1(pVar, lVar);
        contextAware.addOnContextAvailableListener(contextAwareKt$withContextAvailable$2$listener$1);
        pVar.m(new ContextAwareKt$withContextAvailable$2$1(contextAware, contextAwareKt$withContextAvailable$2$listener$1));
        Object objZ = pVar.z();
        if (objZ == a9.d.e()) {
            h.c(dVar);
        }
        return objZ;
    }

    private static final <R> Object withContextAvailable$$forInline(ContextAware contextAware, l<Context, R> lVar, d<R> dVar) throws Throwable {
        Context contextPeekAvailableContext = contextAware.peekAvailableContext();
        if (contextPeekAvailableContext != null) {
            return lVar.invoke(contextPeekAvailableContext);
        }
        r.c(0);
        p pVar = new p(c.c(dVar), 1);
        pVar.C();
        ContextAwareKt$withContextAvailable$2$listener$1 contextAwareKt$withContextAvailable$2$listener$1 = new ContextAwareKt$withContextAvailable$2$listener$1(pVar, lVar);
        contextAware.addOnContextAvailableListener(contextAwareKt$withContextAvailable$2$listener$1);
        pVar.m(new ContextAwareKt$withContextAvailable$2$1(contextAware, contextAwareKt$withContextAvailable$2$listener$1));
        k0 k0Var = k0.f35197a;
        Object objZ = pVar.z();
        if (objZ == a9.d.e()) {
            h.c(dVar);
        }
        r.c(1);
        return objZ;
    }
}
