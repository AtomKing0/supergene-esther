package com.moloco.sdk.internal.services.analytics;

import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i;
import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements com.moloco.sdk.internal.services.analytics.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final i f18402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a f18403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.b f18404c;

    @f(c = "com.moloco.sdk.internal.services.analytics.AnalyticsServiceImpl$recordApplicationBackground$1", f = "AnalyticsService.kt", l = {48}, m = "invokeSuspend")
    public static final class a extends l implements p<o0, d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f18405j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ long f18407l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(long j10, d<? super a> dVar) {
            super(2, dVar);
            this.f18407l = j10;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
            return ((a) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return b.this.new a(this.f18407l, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f18405j;
            if (i10 == 0) {
                u.b(obj);
                com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar = b.this.f18403b;
                long j10 = this.f18407l;
                a.AbstractC0481a.C0482a c0482a = a.AbstractC0481a.C0482a.f21673a;
                String strA = b.this.f18404c.a();
                this.f18405j = 1;
                obj = aVar.a(j10, c0482a, strA, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            b.this.f18402a.a((String) obj);
            return k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.internal.services.analytics.b$b, reason: collision with other inner class name */
    @f(c = "com.moloco.sdk.internal.services.analytics.AnalyticsServiceImpl$recordApplicationForeground$1", f = "AnalyticsService.kt", l = {31}, m = "invokeSuspend")
    public static final class C0325b extends l implements p<o0, d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f18408j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ long f18410l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ long f18411m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0325b(long j10, long j11, d<? super C0325b> dVar) {
            super(2, dVar);
            this.f18410l = j10;
            this.f18411m = j11;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
            return ((C0325b) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return b.this.new C0325b(this.f18410l, this.f18411m, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f18408j;
            if (i10 == 0) {
                u.b(obj);
                com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar = b.this.f18403b;
                long j10 = this.f18410l;
                a.AbstractC0481a.b bVar = new a.AbstractC0481a.b(this.f18411m);
                String strD = b.this.f18404c.d();
                this.f18408j = 1;
                obj = aVar.a(j10, bVar, strD, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            b.this.f18402a.a((String) obj);
            return k0.f35197a;
        }
    }

    public b(@NotNull i persistentHttpRequest, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.core.services.b configService) {
        t.i(persistentHttpRequest, "persistentHttpRequest");
        t.i(customUserEventBuilderService, "customUserEventBuilderService");
        t.i(configService, "configService");
        this.f18402a = persistentHttpRequest;
        this.f18403b = customUserEventBuilderService;
        this.f18404c = configService;
    }

    @Override // com.moloco.sdk.internal.services.analytics.a
    public void a(long j10) {
        if (!this.f18404c.c() || this.f18404c.a().length() <= 0) {
            return;
        }
        MolocoLogger.debug$default(MolocoLogger.INSTANCE, "AnalyticsService", "Recording applicationBackground with timestamp: " + j10, false, 4, null);
        k.d(com.moloco.sdk.internal.scheduling.d.f18390a.a(), null, null, new a(j10, null), 3, null);
    }

    @Override // com.moloco.sdk.internal.services.analytics.a
    public void b(long j10, long j11) {
        if (!this.f18404c.c() || this.f18404c.d().length() <= 0) {
            return;
        }
        MolocoLogger.debug$default(MolocoLogger.INSTANCE, "AnalyticsService", "Recording applicationForeground with timestamp: " + j10 + ", lastBgTimestamp: " + j11, false, 4, null);
        k.d(com.moloco.sdk.internal.scheduling.d.f18390a.a(), null, null, new C0325b(j10, j11, null), 3, null);
    }
}
