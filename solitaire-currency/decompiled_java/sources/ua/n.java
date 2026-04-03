package ua;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ForwardingTimeout.kt */
/* JADX INFO: loaded from: classes5.dex */
public class n extends a1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private a1 f34786f;

    public n(@NotNull a1 delegate) {
        kotlin.jvm.internal.t.i(delegate, "delegate");
        this.f34786f = delegate;
    }

    @Override // ua.a1
    @NotNull
    public a1 a() {
        return this.f34786f.a();
    }

    @Override // ua.a1
    @NotNull
    public a1 b() {
        return this.f34786f.b();
    }

    @Override // ua.a1
    public long c() {
        return this.f34786f.c();
    }

    @Override // ua.a1
    @NotNull
    public a1 d(long j10) {
        return this.f34786f.d(j10);
    }

    @Override // ua.a1
    public boolean e() {
        return this.f34786f.e();
    }

    @Override // ua.a1
    public void f() throws IOException {
        this.f34786f.f();
    }

    @Override // ua.a1
    @NotNull
    public a1 g(long j10, @NotNull TimeUnit unit) {
        kotlin.jvm.internal.t.i(unit, "unit");
        return this.f34786f.g(j10, unit);
    }

    @NotNull
    public final a1 i() {
        return this.f34786f;
    }

    @NotNull
    public final n j(@NotNull a1 delegate) {
        kotlin.jvm.internal.t.i(delegate, "delegate");
        this.f34786f = delegate;
        return this;
    }
}
