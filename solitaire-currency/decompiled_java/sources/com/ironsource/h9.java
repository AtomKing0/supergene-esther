package com.ironsource;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class h9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Throwable f12447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f12448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f12449c;

    public h9(@NotNull Throwable throwable) {
        kotlin.jvm.internal.t.i(throwable, "throwable");
        this.f12447a = throwable;
        StringBuilder sb = new StringBuilder();
        StackTraceElement[] stackTrace = throwable.getStackTrace();
        kotlin.jvm.internal.t.h(stackTrace, "throwable.stackTrace");
        sb.append(throwable.toString());
        sb.append(System.lineSeparator());
        boolean z10 = false;
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb.append(stackTraceElement.toString());
            sb.append(';' + System.lineSeparator());
            String string = stackTraceElement.toString();
            kotlin.jvm.internal.t.h(string, "elem.toString()");
            String strE = i9.d().e();
            kotlin.jvm.internal.t.h(strE, "getInstance().keyword");
            if (p9.r.P(string, strE, false, 2, null)) {
                z10 = true;
            }
        }
        Throwable cause = this.f12447a.getCause();
        if (cause != null) {
            sb.append("--CAUSE");
            sb.append(System.lineSeparator());
            sb.append(cause.toString());
            sb.append(System.lineSeparator());
            StackTraceElement[] stackTrace2 = cause.getStackTrace();
            kotlin.jvm.internal.t.h(stackTrace2, "cause.stackTrace");
            for (StackTraceElement stackTraceElement2 : stackTrace2) {
                sb.append(stackTraceElement2.toString());
                sb.append(';' + System.lineSeparator());
                String string2 = stackTraceElement2.toString();
                kotlin.jvm.internal.t.h(string2, "elem.toString()");
                String strE2 = i9.d().e();
                kotlin.jvm.internal.t.h(strE2, "getInstance().keyword");
                if (p9.r.P(string2, strE2, false, 2, null)) {
                    z10 = true;
                }
            }
        }
        String string3 = sb.toString();
        kotlin.jvm.internal.t.h(string3, "builder.toString()");
        this.f12448b = string3;
        this.f12449c = z10;
    }

    public static /* synthetic */ h9 a(h9 h9Var, Throwable th, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            th = h9Var.f12447a;
        }
        return h9Var.a(th);
    }

    @NotNull
    public final String b() {
        return this.f12448b;
    }

    @NotNull
    public final Throwable c() {
        return this.f12447a;
    }

    public final boolean d() {
        return this.f12449c;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof h9) && kotlin.jvm.internal.t.d(this.f12447a, ((h9) obj).f12447a);
    }

    public int hashCode() {
        return this.f12447a.hashCode();
    }

    @NotNull
    public String toString() {
        return "CrashReportWrapper(throwable=" + this.f12447a + ')';
    }

    @NotNull
    public final h9 a(@NotNull Throwable throwable) {
        kotlin.jvm.internal.t.i(throwable, "throwable");
        return new h9(throwable);
    }

    @NotNull
    public final Throwable a() {
        return this.f12447a;
    }
}
