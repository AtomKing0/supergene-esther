package com.google.firebase.concurrent;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.StrictMode;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import l5.e0;
import l5.x;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"ThreadPoolCreation"})
public class ExecutorsRegistrar implements ComponentRegistrar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final x<ScheduledExecutorService> f10238a = new x<>(new w5.b() { // from class: m5.b
        @Override // w5.b
        public final Object get() {
            return ExecutorsRegistrar.p();
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final x<ScheduledExecutorService> f10239b = new x<>(new w5.b() { // from class: m5.c
        @Override // w5.b
        public final Object get() {
            return ExecutorsRegistrar.q();
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final x<ScheduledExecutorService> f10240c = new x<>(new w5.b() { // from class: m5.d
        @Override // w5.b
        public final Object get() {
            return ExecutorsRegistrar.r();
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final x<ScheduledExecutorService> f10241d = new x<>(new w5.b() { // from class: m5.e
        @Override // w5.b
        public final Object get() {
            return ExecutorsRegistrar.s();
        }
    });

    private static StrictMode.ThreadPolicy i() {
        StrictMode.ThreadPolicy.Builder builderDetectNetwork = new StrictMode.ThreadPolicy.Builder().detectNetwork();
        int i10 = Build.VERSION.SDK_INT;
        builderDetectNetwork.detectResourceMismatches();
        if (i10 >= 26) {
            builderDetectNetwork.detectUnbufferedIo();
        }
        return builderDetectNetwork.penaltyLog().build();
    }

    private static ThreadFactory j(String str, int i10) {
        return new b(str, i10, null);
    }

    private static ThreadFactory k(String str, int i10, StrictMode.ThreadPolicy threadPolicy) {
        return new b(str, i10, threadPolicy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ScheduledExecutorService l(l5.e eVar) {
        return f10238a.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ScheduledExecutorService m(l5.e eVar) {
        return f10240c.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ScheduledExecutorService n(l5.e eVar) {
        return f10239b.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Executor o(l5.e eVar) {
        return m5.l.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ScheduledExecutorService p() {
        return u(Executors.newFixedThreadPool(4, k("Firebase Background", 10, i())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ScheduledExecutorService q() {
        return u(Executors.newFixedThreadPool(Math.max(2, Runtime.getRuntime().availableProcessors()), k("Firebase Lite", 0, t())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ScheduledExecutorService r() {
        return u(Executors.newCachedThreadPool(j("Firebase Blocking", 11)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ScheduledExecutorService s() {
        return Executors.newSingleThreadScheduledExecutor(j("Firebase Scheduler", 0));
    }

    private static StrictMode.ThreadPolicy t() {
        return new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build();
    }

    private static ScheduledExecutorService u(ExecutorService executorService) {
        return new o(executorService, f10241d.get());
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<l5.c<?>> getComponents() {
        return Arrays.asList(l5.c.f(e0.a(k5.a.class, ScheduledExecutorService.class), e0.a(k5.a.class, ExecutorService.class), e0.a(k5.a.class, Executor.class)).f(new l5.h() { // from class: m5.f
            @Override // l5.h
            public final Object a(l5.e eVar) {
                return ExecutorsRegistrar.l(eVar);
            }
        }).d(), l5.c.f(e0.a(k5.b.class, ScheduledExecutorService.class), e0.a(k5.b.class, ExecutorService.class), e0.a(k5.b.class, Executor.class)).f(new l5.h() { // from class: m5.g
            @Override // l5.h
            public final Object a(l5.e eVar) {
                return ExecutorsRegistrar.m(eVar);
            }
        }).d(), l5.c.f(e0.a(k5.c.class, ScheduledExecutorService.class), e0.a(k5.c.class, ExecutorService.class), e0.a(k5.c.class, Executor.class)).f(new l5.h() { // from class: m5.h
            @Override // l5.h
            public final Object a(l5.e eVar) {
                return ExecutorsRegistrar.n(eVar);
            }
        }).d(), l5.c.e(e0.a(k5.d.class, Executor.class)).f(new l5.h() { // from class: m5.i
            @Override // l5.h
            public final Object a(l5.e eVar) {
                return ExecutorsRegistrar.o(eVar);
            }
        }).d());
    }
}
