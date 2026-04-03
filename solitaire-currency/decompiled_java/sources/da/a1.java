package da;

import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: NoOpEncoder.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class a1 extends ca.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a1 f24539a = new a1();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final fa.c f24540b = fa.d.a();

    private a1() {
    }

    @Override // ca.b, kotlinx.serialization.encoding.Encoder
    public void G(@NotNull String value) {
        kotlin.jvm.internal.t.i(value, "value");
    }

    @Override // ca.b
    public void J(@NotNull Object value) {
        kotlin.jvm.internal.t.i(value, "value");
    }

    @Override // kotlinx.serialization.encoding.Encoder
    @NotNull
    public fa.c a() {
        return f24540b;
    }

    @Override // ca.b, kotlinx.serialization.encoding.Encoder
    public void k(@NotNull SerialDescriptor enumDescriptor, int i10) {
        kotlin.jvm.internal.t.i(enumDescriptor, "enumDescriptor");
    }

    @Override // ca.b, kotlinx.serialization.encoding.Encoder
    public void o() {
    }

    @Override // ca.b, kotlinx.serialization.encoding.Encoder
    public void B(int i10) {
    }

    @Override // ca.b, kotlinx.serialization.encoding.Encoder
    public void f(double d10) {
    }

    @Override // ca.b, kotlinx.serialization.encoding.Encoder
    public void g(byte b10) {
    }

    @Override // ca.b, kotlinx.serialization.encoding.Encoder
    public void m(long j10) {
    }

    @Override // ca.b, kotlinx.serialization.encoding.Encoder
    public void q(short s10) {
    }

    @Override // ca.b, kotlinx.serialization.encoding.Encoder
    public void r(boolean z10) {
    }

    @Override // ca.b, kotlinx.serialization.encoding.Encoder
    public void t(float f10) {
    }

    @Override // ca.b, kotlinx.serialization.encoding.Encoder
    public void u(char c10) {
    }
}
