package ea;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Composers.kt */
/* JADX INFO: loaded from: classes5.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final o0 f25448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f25449b;

    public j(@NotNull o0 writer) {
        kotlin.jvm.internal.t.i(writer, "writer");
        this.f25448a = writer;
        this.f25449b = true;
    }

    public final boolean a() {
        return this.f25449b;
    }

    public void b() {
        this.f25449b = true;
    }

    public void c() {
        this.f25449b = false;
    }

    public void d(byte b10) {
        this.f25448a.writeLong(b10);
    }

    public final void e(char c10) {
        this.f25448a.a(c10);
    }

    public void f(double d10) {
        this.f25448a.c(String.valueOf(d10));
    }

    public void g(float f10) {
        this.f25448a.c(String.valueOf(f10));
    }

    public void h(int i10) {
        this.f25448a.writeLong(i10);
    }

    public void i(long j10) {
        this.f25448a.writeLong(j10);
    }

    public final void j(@NotNull String v10) {
        kotlin.jvm.internal.t.i(v10, "v");
        this.f25448a.c(v10);
    }

    public void k(short s10) {
        this.f25448a.writeLong(s10);
    }

    public void l(boolean z10) {
        this.f25448a.c(String.valueOf(z10));
    }

    public final void m(@NotNull String value) {
        kotlin.jvm.internal.t.i(value, "value");
        this.f25448a.b(value);
    }

    protected final void n(boolean z10) {
        this.f25449b = z10;
    }

    public void o() {
    }

    public void p() {
    }
}
