package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class dq {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f11855c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f11856d = 2070;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f11857e = 2080;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f11858f = 2090;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f11859g = 2100;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f11860h = 2110;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f11861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f11862b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public dq(int i10, @NotNull String errorMessage) {
        kotlin.jvm.internal.t.i(errorMessage, "errorMessage");
        this.f11861a = i10;
        this.f11862b = errorMessage;
    }

    public final int a() {
        return this.f11861a;
    }

    @NotNull
    public final String b() {
        return this.f11862b;
    }

    public final int c() {
        return this.f11861a;
    }

    @NotNull
    public final String d() {
        return this.f11862b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dq)) {
            return false;
        }
        dq dqVar = (dq) obj;
        return this.f11861a == dqVar.f11861a && kotlin.jvm.internal.t.d(this.f11862b, dqVar.f11862b);
    }

    public int hashCode() {
        return (this.f11861a * 31) + this.f11862b.hashCode();
    }

    @NotNull
    public String toString() {
        return "SdkError(errorCode=" + this.f11861a + ", errorMessage=" + this.f11862b + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public dq(@NotNull IronSourceError error) {
        kotlin.jvm.internal.t.i(error, "error");
        int errorCode = error.getErrorCode();
        String errorMessage = error.getErrorMessage();
        kotlin.jvm.internal.t.h(errorMessage, "error.errorMessage");
        this(errorCode, errorMessage);
    }

    @NotNull
    public final dq a(int i10, @NotNull String errorMessage) {
        kotlin.jvm.internal.t.i(errorMessage, "errorMessage");
        return new dq(i10, errorMessage);
    }

    public static /* synthetic */ dq a(dq dqVar, int i10, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = dqVar.f11861a;
        }
        if ((i11 & 2) != 0) {
            str = dqVar.f11862b;
        }
        return dqVar.a(i10, str);
    }
}
