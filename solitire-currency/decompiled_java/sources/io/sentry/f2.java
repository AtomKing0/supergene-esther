package io.sentry;

import java.io.IOException;
import java.io.Writer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JsonObjectWriter.java */
/* JADX INFO: loaded from: classes5.dex */
public final class f2 implements m3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final io.sentry.vendor.gson.stream.c f27805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final e2 f27806b;

    public f2(@NotNull Writer writer, int i10) {
        this.f27805a = new io.sentry.vendor.gson.stream.c(writer);
        this.f27806b = new e2(i10);
    }

    @Override // io.sentry.m3
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public f2 p(@Nullable Boolean bool) throws IOException {
        this.f27805a.L0(bool);
        return this;
    }

    @Override // io.sentry.m3
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public f2 n(@Nullable Number number) throws IOException {
        this.f27805a.M0(number);
        return this;
    }

    @Override // io.sentry.m3
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public f2 g(@Nullable String str) throws IOException {
        this.f27805a.N0(str);
        return this;
    }

    @Override // io.sentry.m3
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public f2 c(boolean z10) throws IOException {
        this.f27805a.O0(z10);
        return this;
    }

    @Override // io.sentry.m3
    @Nullable
    public String i() {
        return this.f27805a.B();
    }

    @Override // io.sentry.m3
    public void j(boolean z10) {
        this.f27805a.j(z10);
    }

    @Override // io.sentry.m3
    public m3 l(@Nullable String str) throws IOException {
        this.f27805a.J(str);
        return this;
    }

    @Override // io.sentry.m3
    public void m(@Nullable String str) {
        this.f27805a.G0(str);
    }

    @Override // io.sentry.m3
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public f2 f() throws IOException {
        this.f27805a.i();
        return this;
    }

    @Override // io.sentry.m3
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public f2 h() throws IOException {
        this.f27805a.n();
        return this;
    }

    @Override // io.sentry.m3
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public f2 d() throws IOException {
        this.f27805a.x();
        return this;
    }

    @Override // io.sentry.m3
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public f2 k() throws IOException {
        this.f27805a.z();
        return this;
    }

    @Override // io.sentry.m3
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public f2 e(@NotNull String str) throws IOException {
        this.f27805a.L(str);
        return this;
    }

    @Override // io.sentry.m3
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public f2 q() throws IOException {
        this.f27805a.R();
        return this;
    }

    @Override // io.sentry.m3
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public f2 b(double d10) throws IOException {
        this.f27805a.J0(d10);
        return this;
    }

    @Override // io.sentry.m3
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public f2 a(long j10) throws IOException {
        this.f27805a.K0(j10);
        return this;
    }

    @Override // io.sentry.m3
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public f2 o(@NotNull w0 w0Var, @Nullable Object obj) throws IOException {
        this.f27806b.a(this, w0Var, obj);
        return this;
    }
}
