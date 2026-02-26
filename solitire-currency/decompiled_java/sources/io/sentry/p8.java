package io.sentry;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SpanOptions.java */
/* JADX INFO: loaded from: classes5.dex */
public class p8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private n5 f28061a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private f4 f28062b = f4.AUTO;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f28063c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f28064d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f28065e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    protected String f28066f = "manual";

    @Nullable
    public String a() {
        return this.f28066f;
    }

    @NotNull
    public f4 b() {
        return this.f28062b;
    }

    @Nullable
    public n5 c() {
        return this.f28061a;
    }

    public boolean d() {
        return this.f28065e;
    }

    public boolean e() {
        return this.f28064d;
    }

    public boolean f() {
        return this.f28063c;
    }

    public void g(@Nullable String str) {
        this.f28066f = str;
    }

    public void h(@Nullable n5 n5Var) {
        this.f28061a = n5Var;
    }

    public void i(boolean z10) {
        this.f28064d = z10;
    }
}
