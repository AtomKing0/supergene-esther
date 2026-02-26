package com.moloco.sdk.internal.error.crash;

import com.moloco.sdk.internal.error.crash.c;
import h9.p;
import java.lang.Thread;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements com.moloco.sdk.internal.error.crash.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final d f17631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public Thread.UncaughtExceptionHandler f17632b;

    @f(c = "com.moloco.sdk.internal.error.crash.CrashDetectorServiceImpl$register$2", f = "CrashDetectorService.kt", l = {}, m = "invokeSuspend")
    public static final class a extends l implements p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f17633j;

        public a(z8.d<? super a> dVar) {
            super(2, dVar);
        }

        public static final void f(c cVar, Thread thread, Throwable throwable) {
            k0 k0Var;
            d dVar = cVar.f17631a;
            t.h(throwable, "throwable");
            dVar.a(throwable);
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = cVar.f17632b;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, throwable);
                k0Var = k0.f35197a;
            } else {
                k0Var = null;
            }
            if (k0Var != null) {
                return;
            }
            System.exit(2);
            throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((a) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return c.this.new a(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f17633j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            if (c.this.f17632b == null) {
                c.this.f17632b = Thread.getDefaultUncaughtExceptionHandler();
                final c cVar = c.this;
                Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.moloco.sdk.internal.error.crash.b
                    @Override // java.lang.Thread.UncaughtExceptionHandler
                    public final void uncaughtException(Thread thread, Throwable th) {
                        c.a.f(cVar, thread, th);
                    }
                });
            }
            return k0.f35197a;
        }
    }

    public c(@NotNull d crashHandler) {
        t.i(crashHandler, "crashHandler");
        this.f17631a = crashHandler;
    }

    @Override // com.moloco.sdk.internal.error.crash.a
    @Nullable
    public Object a(@NotNull z8.d<? super k0> dVar) {
        Object objG = i.g(com.moloco.sdk.internal.scheduling.c.a().getMain(), new a(null), dVar);
        return objG == a9.d.e() ? objG : k0.f35197a;
    }
}
