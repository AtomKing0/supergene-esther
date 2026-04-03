package com.moloco.sdk.acm.services;

import android.util.Log;
import h9.p;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.q;
import p9.r;
import v8.k0;
import v8.u;

/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f17473a = new e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final o0 f17474b = p0.a(e1.c());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final ArrayList<a> f17475c = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f17476d = com.moloco.sdk.acm.services.b.f17466a.a("debug.moloco.enable_logs");

    public interface a {
        void a(@NotNull String str, @NotNull String str2);
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.acm.services.MolocoMetricsLogger$fireListeners$1", f = "MolocoMetricsLogger.kt", l = {}, m = "invokeSuspend")
    public static final class b extends l implements p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f17477j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ String f17478k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ String f17479l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2, z8.d<? super b> dVar) {
            super(2, dVar);
            this.f17478k = str;
            this.f17479l = str2;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((b) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new b(this.f17478k, this.f17479l, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f17477j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            ArrayList arrayList = e.f17475c;
            String str = this.f17478k;
            String str2 = this.f17479l;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((a) it.next()).a(e.f17473a.k(str), str2);
            }
            return k0.f35197a;
        }
    }

    public static /* synthetic */ void e(e eVar, String str, String str2, Throwable th, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "ACM";
        }
        if ((i10 & 4) != 0) {
            th = null;
        }
        if ((i10 & 8) != 0) {
            z10 = false;
        }
        eVar.h(str, str2, th, z10);
    }

    public static /* synthetic */ void f(e eVar, String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "ACM";
        }
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        eVar.i(str, str2, z10);
    }

    public static /* synthetic */ void l(e eVar, String str, String str2, Throwable th, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "ACM";
        }
        if ((i10 & 4) != 0) {
            th = null;
        }
        if ((i10 & 8) != 0) {
            z10 = false;
        }
        eVar.n(str, str2, th, z10);
    }

    public static /* synthetic */ void m(e eVar, String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "ACM";
        }
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        eVar.o(str, str2, z10);
    }

    public final StackTraceElement a(StackTraceElement[] stackTraceElementArr) {
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            if (!t.d(stackTraceElement.getClassName(), f17473a.getClass().getCanonicalName())) {
                return stackTraceElement;
            }
        }
        return (StackTraceElement) kotlin.collections.p.N(stackTraceElementArr);
    }

    public final String c(String str) {
        try {
            return '[' + j() + "] " + str;
        } catch (Exception unused) {
            return str;
        }
    }

    public final void g(String str, String str2) {
        k.d(f17474b, null, null, new b(str, str2, null), 3, null);
    }

    public final void h(@NotNull String tag, @NotNull String msg, @Nullable Throwable th, boolean z10) {
        t.i(tag, "tag");
        t.i(msg, "msg");
        if (f17476d || z10) {
            String strK = k(tag);
            String strC = c(msg);
            Log.e(strK, strC, th);
            g(strK, strC);
        }
    }

    public final void i(@NotNull String tag, @NotNull String msg, boolean z10) {
        t.i(tag, "tag");
        t.i(msg, "msg");
        if (f17476d || z10) {
            String strK = k(tag);
            String strC = c(msg);
            Log.d(strK, strC);
            g(strK, strC);
        }
    }

    @NotNull
    public final String j() throws ClassNotFoundException {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        t.h(stackTrace, "Throwable().stackTrace");
        StackTraceElement stackTraceElementA = a(stackTrace);
        String className = stackTraceElementA.getClassName();
        stackTraceElementA.getMethodName();
        Class<?> cls = Class.forName(className);
        cls.isAnonymousClass();
        cls.getDeclaredMethods();
        String methodName = stackTraceElementA.getMethodName();
        if (t.d(methodName, "invokeSuspend")) {
            String className2 = stackTraceElementA.getClassName();
            t.h(className2, "stackTraceElement.className");
            methodName = r.R0(r.w0(className2, "$1"), "$", null, 2, null);
        }
        t.h(methodName, "stackTraceElement.method…t\n            }\n        }");
        return methodName;
    }

    public final String k(String str) {
        if (q.K(str, "ACM", false, 2, null)) {
            return str;
        }
        return "ACM" + str;
    }

    public final void n(@NotNull String tag, @NotNull String msg, @Nullable Throwable th, boolean z10) {
        t.i(tag, "tag");
        t.i(msg, "msg");
        if (f17476d || z10) {
            String strK = k(tag);
            String strC = c(msg);
            Log.w(strK, strC, th);
            g(strK, strC);
        }
    }

    public final void o(@NotNull String tag, @NotNull String msg, boolean z10) {
        t.i(tag, "tag");
        t.i(msg, "msg");
        if (f17476d || z10) {
            String strK = k(tag);
            String strC = c(msg);
            Log.i(strK, strC);
            g(strK, strC);
        }
    }
}
