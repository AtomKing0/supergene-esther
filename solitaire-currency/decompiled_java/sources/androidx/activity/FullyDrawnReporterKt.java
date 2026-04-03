package androidx.activity;

import kotlin.jvm.internal.r;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: FullyDrawnReporter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FullyDrawnReporterKt {

    /* JADX INFO: renamed from: androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1, reason: invalid class name */
    /* JADX INFO: compiled from: FullyDrawnReporter.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.activity.FullyDrawnReporterKt", f = "FullyDrawnReporter.kt", l = {185}, m = "reportWhenComplete")
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.d {
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
            return FullyDrawnReporterKt.reportWhenComplete(null, null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Object, v8.k0] */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object reportWhenComplete(@org.jetbrains.annotations.NotNull androidx.activity.FullyDrawnReporter r4, @org.jetbrains.annotations.NotNull h9.l<? super z8.d<? super v8.k0>, ? extends java.lang.Object> r5, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r6) {
        /*
            boolean r0 = r6 instanceof androidx.activity.FullyDrawnReporterKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1 r0 = (androidx.activity.FullyDrawnReporterKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1 r0 = new androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            androidx.activity.FullyDrawnReporter r4 = (androidx.activity.FullyDrawnReporter) r4
            v8.u.b(r6)     // Catch: java.lang.Throwable -> L5b
            goto L4f
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            v8.u.b(r6)
            r4.addReporter()
            boolean r6 = r4.isFullyDrawnReported()
            if (r6 == 0) goto L44
            v8.k0 r4 = v8.k0.f35197a
            return r4
        L44:
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L5b
            r0.label = r3     // Catch: java.lang.Throwable -> L5b
            java.lang.Object r5 = r5.invoke(r0)     // Catch: java.lang.Throwable -> L5b
            if (r5 != r1) goto L4f
            return r1
        L4f:
            kotlin.jvm.internal.r.b(r3)
            r4.removeReporter()
            kotlin.jvm.internal.r.a(r3)
            v8.k0 r4 = v8.k0.f35197a
            return r4
        L5b:
            r5 = move-exception
            kotlin.jvm.internal.r.b(r3)
            r4.removeReporter()
            kotlin.jvm.internal.r.a(r3)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.FullyDrawnReporterKt.reportWhenComplete(androidx.activity.FullyDrawnReporter, h9.l, z8.d):java.lang.Object");
    }

    private static final Object reportWhenComplete$$forInline(FullyDrawnReporter fullyDrawnReporter, h9.l<? super z8.d<? super k0>, ? extends Object> lVar, z8.d<? super k0> dVar) {
        fullyDrawnReporter.addReporter();
        if (fullyDrawnReporter.isFullyDrawnReported()) {
            return k0.f35197a;
        }
        try {
            lVar.invoke(dVar);
            r.b(1);
            fullyDrawnReporter.removeReporter();
            r.a(1);
            return k0.f35197a;
        } catch (Throwable th) {
            r.b(1);
            fullyDrawnReporter.removeReporter();
            r.a(1);
            throw th;
        }
    }
}
