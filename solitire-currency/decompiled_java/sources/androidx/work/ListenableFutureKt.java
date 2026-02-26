package androidx.work;

import a9.c;
import androidx.annotation.RestrictTo;
import com.google.common.util.concurrent.m;
import java.util.concurrent.ExecutionException;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z8.d;

/* JADX INFO: compiled from: ListenableFuture.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ListenableFutureKt {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Nullable
    public static final <R> Object await(@NotNull m<R> mVar, @NotNull d<? super R> dVar) throws Throwable {
        if (mVar.isDone()) {
            try {
                return mVar.get();
            } catch (ExecutionException e10) {
                Throwable cause = e10.getCause();
                if (cause == null) {
                    throw e10;
                }
                throw cause;
            }
        }
        p pVar = new p(c.c(dVar), 1);
        pVar.C();
        mVar.addListener(new ListenableFutureKt$await$2$1(pVar, mVar), DirectExecutor.INSTANCE);
        pVar.m(new ListenableFutureKt$await$2$2(mVar));
        Object objZ = pVar.z();
        if (objZ == a9.d.e()) {
            h.c(dVar);
        }
        return objZ;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    private static final <R> Object await$$forInline(m<R> mVar, d<? super R> dVar) throws Throwable {
        if (mVar.isDone()) {
            try {
                return mVar.get();
            } catch (ExecutionException e10) {
                Throwable cause = e10.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw e10;
            }
        }
        r.c(0);
        p pVar = new p(c.c(dVar), 1);
        pVar.C();
        mVar.addListener(new ListenableFutureKt$await$2$1(pVar, mVar), DirectExecutor.INSTANCE);
        pVar.m(new ListenableFutureKt$await$2$2(mVar));
        k0 k0Var = k0.f35197a;
        Object objZ = pVar.z();
        if (objZ == a9.d.e()) {
            h.c(dVar);
        }
        r.c(1);
        return objZ;
    }
}
