package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.repository.CacheRepository;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CommonClearCache.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CommonClearCache implements ClearCache {

    @NotNull
    private final CacheRepository cacheRepository;

    @NotNull
    private final SendDiagnosticEvent sendDiagnosticEvent;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.CommonClearCache$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: CommonClearCache.kt */
    @f(c = "com.unity3d.ads.core.domain.CommonClearCache", f = "CommonClearCache.kt", l = {18, 19}, m = "invoke")
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.d {
        long J$0;
        long J$1;
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
            return CommonClearCache.this.invoke(this);
        }
    }

    public CommonClearCache(@NotNull CacheRepository cacheRepository, @NotNull SendDiagnosticEvent sendDiagnosticEvent) {
        t.i(cacheRepository, "cacheRepository");
        t.i(sendDiagnosticEvent, "sendDiagnosticEvent");
        this.cacheRepository = cacheRepository;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.unity3d.ads.core.domain.ClearCache
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object invoke(@org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r14) {
        /*
            r13 = this;
            boolean r0 = r14 instanceof com.unity3d.ads.core.domain.CommonClearCache.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r14
            com.unity3d.ads.core.domain.CommonClearCache$invoke$1 r0 = (com.unity3d.ads.core.domain.CommonClearCache.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.unity3d.ads.core.domain.CommonClearCache$invoke$1 r0 = new com.unity3d.ads.core.domain.CommonClearCache$invoke$1
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L46
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            long r1 = r0.J$1
            long r3 = r0.J$0
            java.lang.Object r0 = r0.L$0
            com.unity3d.ads.core.domain.CommonClearCache r0 = (com.unity3d.ads.core.domain.CommonClearCache) r0
            v8.u.b(r14)
            goto L7a
        L34:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L3c:
            long r4 = r0.J$0
            java.lang.Object r2 = r0.L$0
            com.unity3d.ads.core.domain.CommonClearCache r2 = (com.unity3d.ads.core.domain.CommonClearCache) r2
            v8.u.b(r14)
            goto L60
        L46:
            v8.u.b(r14)
            q9.k r14 = q9.k.f33196a
            long r5 = r14.a()
            com.unity3d.ads.core.data.repository.CacheRepository r14 = r13.cacheRepository
            r0.L$0 = r13
            r0.J$0 = r5
            r0.label = r4
            java.lang.Object r14 = r14.getCacheSize(r0)
            if (r14 != r1) goto L5e
            return r1
        L5e:
            r2 = r13
            r4 = r5
        L60:
            java.lang.Number r14 = (java.lang.Number) r14
            long r6 = r14.longValue()
            com.unity3d.ads.core.data.repository.CacheRepository r14 = r2.cacheRepository
            r0.L$0 = r2
            r0.J$0 = r4
            r0.J$1 = r6
            r0.label = r3
            java.lang.Object r14 = r14.clearCache(r0)
            if (r14 != r1) goto L77
            return r1
        L77:
            r0 = r2
            r3 = r4
            r1 = r6
        L7a:
            com.unity3d.ads.core.domain.SendDiagnosticEvent r5 = r0.sendDiagnosticEvent
            java.lang.String r6 = "native_initialize_clear_cache_time"
            q9.k$a r14 = q9.k.a.c(r3)
            double r3 = com.unity3d.ads.core.extensions.TimeExtensionsKt.elapsedMillis(r14)
            java.lang.Double r7 = kotlin.coroutines.jvm.internal.b.b(r3)
            r8 = 0
            r14 = 1024(0x400, float:1.435E-42)
            long r3 = (long) r14
            long r1 = r1 / r3
            int r14 = (int) r1
            java.lang.Integer r14 = kotlin.coroutines.jvm.internal.b.d(r14)
            java.lang.String r0 = "size_kb"
            v8.s r14 = v8.y.a(r0, r14)
            java.util.Map r9 = kotlin.collections.o0.e(r14)
            r10 = 0
            r11 = 20
            r12 = 0
            com.unity3d.ads.core.domain.SendDiagnosticEvent.DefaultImpls.invoke$default(r5, r6, r7, r8, r9, r10, r11, r12)
            v8.k0 r14 = v8.k0.f35197a
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.CommonClearCache.invoke(z8.d):java.lang.Object");
    }
}
