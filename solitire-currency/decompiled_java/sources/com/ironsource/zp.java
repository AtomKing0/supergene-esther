package com.ironsource;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class zp extends ScheduledThreadPoolExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final h9.l<Throwable, v8.k0> f16483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final h9.l<String, v8.k0> f16484b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final class b extends kotlin.jvm.internal.v implements h9.l<String, v8.k0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f16486a = new b();

        b() {
            super(1);
        }

        public final void a(@NotNull String it) {
            kotlin.jvm.internal.t.i(it, "it");
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ v8.k0 invoke(String str) {
            a(str);
            return v8.k0.f35197a;
        }
    }

    public zp() {
        this(0, null, null, 7, null);
    }

    private final String a(String str) {
        return zp.class.getName() + " RuntimeException caught: " + str;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(@Nullable Runnable runnable, @Nullable Throwable th) {
        h9.l<Throwable, v8.k0> lVar;
        Throwable e10;
        super.afterExecute(runnable, th);
        if (th != null) {
            this.f16484b.invoke(a(th.toString()));
            this.f16483a.invoke(th);
            return;
        }
        if ((runnable instanceof Future) && ((Future) runnable).isDone()) {
            try {
                ((Future) runnable).get();
            } catch (InterruptedException e11) {
                i9.d().a(e11);
                this.f16484b.invoke(a(e11.toString()));
                Thread.currentThread().interrupt();
            } catch (CancellationException e12) {
                e10 = e12;
                i9.d().a(e10);
                this.f16484b.invoke(a(e10.toString()));
                lVar = this.f16483a;
                lVar.invoke(e10);
            } catch (ExecutionException e13) {
                i9.d().a(e13);
                this.f16484b.invoke(a(e13.toString()));
                lVar = this.f16483a;
                e10 = e13.getCause();
                lVar.invoke(e10);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public zp(int i10, @NotNull h9.l<? super Throwable, v8.k0> report, @NotNull h9.l<? super String, v8.k0> log) {
        super(i10, new ej());
        kotlin.jvm.internal.t.i(report, "report");
        kotlin.jvm.internal.t.i(log, "log");
        this.f16483a = report;
        this.f16484b = log;
    }

    public /* synthetic */ zp(int i10, h9.l lVar, h9.l lVar2, int i11, kotlin.jvm.internal.k kVar) {
        this((i11 & 1) != 0 ? aq.f11308a : i10, (i11 & 2) != 0 ? a.f16485a : lVar, (i11 & 4) != 0 ? b.f16486a : lVar2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final class a extends kotlin.jvm.internal.v implements h9.l<Throwable, v8.k0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f16485a = new a();

        a() {
            super(1);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ v8.k0 invoke(Throwable th) {
            a(th);
            return v8.k0.f35197a;
        }

        public final void a(@Nullable Throwable th) {
        }
    }
}
