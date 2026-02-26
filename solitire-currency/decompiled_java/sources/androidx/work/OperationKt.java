package androidx.work;

import a9.c;
import androidx.work.Operation;
import com.google.common.util.concurrent.m;
import java.util.concurrent.ExecutionException;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Operation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OperationKt {

    /* JADX INFO: renamed from: androidx.work.OperationKt$await$1, reason: invalid class name */
    /* JADX INFO: compiled from: Operation.kt */
    @f(c = "androidx.work.OperationKt", f = "Operation.kt", l = {39}, m = "await")
    static final class AnonymousClass1 extends d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(z8.d<? super AnonymousClass1> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OperationKt.await(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object await(@org.jetbrains.annotations.NotNull androidx.work.Operation r4, @org.jetbrains.annotations.NotNull z8.d<? super androidx.work.Operation.State.SUCCESS> r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof androidx.work.OperationKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r5
            androidx.work.OperationKt$await$1 r0 = (androidx.work.OperationKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.work.OperationKt$await$1 r0 = new androidx.work.OperationKt$await$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            com.google.common.util.concurrent.m r4 = (com.google.common.util.concurrent.m) r4
            v8.u.b(r5)
            goto L88
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            v8.u.b(r5)
            com.google.common.util.concurrent.m r4 = r4.getResult()
            java.lang.String r5 = "result"
            kotlin.jvm.internal.t.h(r4, r5)
            boolean r5 = r4.isDone()
            if (r5 == 0) goto L56
            java.lang.Object r4 = r4.get()     // Catch: java.util.concurrent.ExecutionException -> L4c
            goto L89
        L4c:
            r4 = move-exception
            java.lang.Throwable r5 = r4.getCause()
            if (r5 != 0) goto L54
            goto L55
        L54:
            r4 = r5
        L55:
            throw r4
        L56:
            r0.L$0 = r4
            r0.label = r3
            kotlinx.coroutines.p r5 = new kotlinx.coroutines.p
            z8.d r2 = a9.b.c(r0)
            r5.<init>(r2, r3)
            r5.C()
            androidx.work.ListenableFutureKt$await$2$1 r2 = new androidx.work.ListenableFutureKt$await$2$1
            r2.<init>(r5, r4)
            androidx.work.DirectExecutor r3 = androidx.work.DirectExecutor.INSTANCE
            r4.addListener(r2, r3)
            androidx.work.ListenableFutureKt$await$2$2 r2 = new androidx.work.ListenableFutureKt$await$2$2
            r2.<init>(r4)
            r5.m(r2)
            java.lang.Object r5 = r5.z()
            java.lang.Object r4 = a9.b.e()
            if (r5 != r4) goto L85
            kotlin.coroutines.jvm.internal.h.c(r0)
        L85:
            if (r5 != r1) goto L88
            return r1
        L88:
            r4 = r5
        L89:
            java.lang.String r5 = "result.await()"
            kotlin.jvm.internal.t.h(r4, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.OperationKt.await(androidx.work.Operation, z8.d):java.lang.Object");
    }

    private static final Object await$$forInline(Operation operation, z8.d<? super Operation.State.SUCCESS> dVar) throws Throwable {
        Object objZ;
        m<Operation.State.SUCCESS> result = operation.getResult();
        t.h(result, "result");
        if (result.isDone()) {
            try {
                objZ = result.get();
            } catch (ExecutionException e10) {
                Throwable cause = e10.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw e10;
            }
        } else {
            r.c(0);
            p pVar = new p(c.c(dVar), 1);
            pVar.C();
            result.addListener(new ListenableFutureKt$await$2$1(pVar, result), DirectExecutor.INSTANCE);
            pVar.m(new ListenableFutureKt$await$2$2(result));
            k0 k0Var = k0.f35197a;
            objZ = pVar.z();
            if (objZ == a9.d.e()) {
                h.c(dVar);
            }
            r.c(1);
        }
        t.h(objZ, "result.await()");
        return objZ;
    }
}
