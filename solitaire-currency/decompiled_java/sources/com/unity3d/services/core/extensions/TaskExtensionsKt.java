package com.unity3d.services.core.extensions;

import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TaskExtensions.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TaskExtensionsKt {

    /* JADX INFO: renamed from: com.unity3d.services.core.extensions.TaskExtensionsKt$withRetry$1, reason: invalid class name */
    /* JADX INFO: compiled from: TaskExtensions.kt */
    @f(c = "com.unity3d.services.core.extensions.TaskExtensionsKt", f = "TaskExtensions.kt", l = {17, 30}, m = "withRetry")
    static final class AnonymousClass1<T> extends d {
        double D$0;
        int I$0;
        int I$1;
        int I$2;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
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
            return TaskExtensionsKt.withRetry(0L, 0, 0.0d, null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0083 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x012c -> B:45:0x0132). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x0147 -> B:49:0x0153). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object withRetry(long r20, int r22, double r23, @org.jetbrains.annotations.NotNull java.lang.Exception r25, @org.jetbrains.annotations.NotNull h9.p<? super java.lang.Integer, ? super z8.d<? super T>, ? extends java.lang.Object> r26, @org.jetbrains.annotations.NotNull z8.d<? super T> r27) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 351
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.extensions.TaskExtensionsKt.withRetry(long, int, double, java.lang.Exception, h9.p, z8.d):java.lang.Object");
    }
}
