package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.di.IServiceComponent;
import com.unity3d.services.core.di.IServiceProvider;
import com.unity3d.services.core.domain.task.BaseParams;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.t;
import z8.d;

/* JADX INFO: compiled from: BaseTask.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface BaseTask<P extends BaseParams, R> extends IServiceComponent {

    /* JADX INFO: compiled from: BaseTask.kt */
    public static final class DefaultImpls {
        @NotNull
        public static <P extends BaseParams, R> IServiceProvider getServiceProvider(@NotNull BaseTask<? super P, R> baseTask) {
            return IServiceComponent.DefaultImpls.getServiceProvider(baseTask);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @org.jetbrains.annotations.Nullable
        /* JADX INFO: renamed from: invoke-gIAlu-s, reason: not valid java name */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static <P extends com.unity3d.services.core.domain.task.BaseParams, R> java.lang.Object m4001invokegIAlus(@org.jetbrains.annotations.NotNull com.unity3d.services.core.domain.task.BaseTask<? super P, R> r4, @org.jetbrains.annotations.NotNull P r5, @org.jetbrains.annotations.NotNull z8.d<? super v8.t<? extends R>> r6) {
            /*
                boolean r0 = r6 instanceof com.unity3d.services.core.domain.task.BaseTask$invoke$1
                if (r0 == 0) goto L13
                r0 = r6
                com.unity3d.services.core.domain.task.BaseTask$invoke$1 r0 = (com.unity3d.services.core.domain.task.BaseTask$invoke$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.unity3d.services.core.domain.task.BaseTask$invoke$1 r0 = new com.unity3d.services.core.domain.task.BaseTask$invoke$1
                r0.<init>(r6)
            L18:
                java.lang.Object r6 = r0.result
                java.lang.Object r1 = a9.b.e()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L37
                if (r2 != r3) goto L2f
                v8.u.b(r6)
                v8.t r6 = (v8.t) r6
                java.lang.Object r4 = r6.j()
                goto L43
            L2f:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L37:
                v8.u.b(r6)
                r0.label = r3
                java.lang.Object r4 = r4.mo3999doWorkgIAlus(r5, r0)
                if (r4 != r1) goto L43
                return r1
            L43:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.domain.task.BaseTask.DefaultImpls.m4001invokegIAlus(com.unity3d.services.core.domain.task.BaseTask, com.unity3d.services.core.domain.task.BaseParams, z8.d):java.lang.Object");
        }
    }

    @Nullable
    /* JADX INFO: renamed from: doWork-gIAlu-s, reason: not valid java name */
    Object mo3999doWorkgIAlus(@NotNull P p10, @NotNull d<? super t<? extends R>> dVar);

    @Nullable
    /* JADX INFO: renamed from: invoke-gIAlu-s, reason: not valid java name */
    Object mo4000invokegIAlus(@NotNull P p10, @NotNull d<? super t<? extends R>> dVar);
}
