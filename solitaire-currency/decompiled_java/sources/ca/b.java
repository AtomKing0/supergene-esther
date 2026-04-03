package ca;

import ca.d;
import da.a1;
import kotlin.jvm.internal.o0;
import kotlin.jvm.internal.t;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z9.i;
import z9.j;

/* JADX INFO: compiled from: AbstractEncoder.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class b implements Encoder, d {
    @Override // kotlinx.serialization.encoding.Encoder
    public abstract void B(int i10);

    @Override // ca.d
    public final void C(@NotNull SerialDescriptor descriptor, int i10, short s10) {
        t.i(descriptor, "descriptor");
        if (H(descriptor, i10)) {
            q(s10);
        }
    }

    @Override // ca.d
    public final void D(@NotNull SerialDescriptor descriptor, int i10, double d10) {
        t.i(descriptor, "descriptor");
        if (H(descriptor, i10)) {
            f(d10);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public <T> void E(@NotNull j<? super T> jVar, T t10) {
        Encoder.a.d(this, jVar, t10);
    }

    @Override // ca.d
    public final void F(@NotNull SerialDescriptor descriptor, int i10, long j10) {
        t.i(descriptor, "descriptor");
        if (H(descriptor, i10)) {
            m(j10);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void G(@NotNull String value) {
        t.i(value, "value");
        J(value);
    }

    public boolean H(@NotNull SerialDescriptor descriptor, int i10) {
        t.i(descriptor, "descriptor");
        return true;
    }

    public <T> void I(@NotNull j<? super T> jVar, @Nullable T t10) {
        Encoder.a.c(this, jVar, t10);
    }

    public void J(@NotNull Object value) {
        t.i(value, "value");
        throw new i("Non-serializable " + o0.b(value.getClass()) + " is not supported by " + o0.b(getClass()) + " encoder");
    }

    @Override // kotlinx.serialization.encoding.Encoder
    @NotNull
    public d b(@NotNull SerialDescriptor descriptor) {
        t.i(descriptor, "descriptor");
        return this;
    }

    @Override // ca.d
    public void c(@NotNull SerialDescriptor descriptor) {
        t.i(descriptor, "descriptor");
    }

    @Override // ca.d
    @NotNull
    public final Encoder e(@NotNull SerialDescriptor descriptor, int i10) {
        t.i(descriptor, "descriptor");
        return H(descriptor, i10) ? l(descriptor.g(i10)) : a1.f24539a;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void f(double d10) {
        J(Double.valueOf(d10));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public abstract void g(byte b10);

    @Override // ca.d
    public <T> void h(@NotNull SerialDescriptor descriptor, int i10, @NotNull j<? super T> serializer, @Nullable T t10) {
        t.i(descriptor, "descriptor");
        t.i(serializer, "serializer");
        if (H(descriptor, i10)) {
            I(serializer, t10);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    @NotNull
    public d i(@NotNull SerialDescriptor serialDescriptor, int i10) {
        return Encoder.a.a(this, serialDescriptor, i10);
    }

    @Override // ca.d
    public <T> void j(@NotNull SerialDescriptor descriptor, int i10, @NotNull j<? super T> serializer, T t10) {
        t.i(descriptor, "descriptor");
        t.i(serializer, "serializer");
        if (H(descriptor, i10)) {
            E(serializer, t10);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void k(@NotNull SerialDescriptor enumDescriptor, int i10) {
        t.i(enumDescriptor, "enumDescriptor");
        J(Integer.valueOf(i10));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    @NotNull
    public Encoder l(@NotNull SerialDescriptor descriptor) {
        t.i(descriptor, "descriptor");
        return this;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public abstract void m(long j10);

    @Override // ca.d
    public final void n(@NotNull SerialDescriptor descriptor, int i10, char c10) {
        t.i(descriptor, "descriptor");
        if (H(descriptor, i10)) {
            u(c10);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void o() {
        throw new i("'null' is not supported by default");
    }

    @Override // ca.d
    public final void p(@NotNull SerialDescriptor descriptor, int i10, byte b10) {
        t.i(descriptor, "descriptor");
        if (H(descriptor, i10)) {
            g(b10);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public abstract void q(short s10);

    @Override // kotlinx.serialization.encoding.Encoder
    public void r(boolean z10) {
        J(Boolean.valueOf(z10));
    }

    @Override // ca.d
    public final void s(@NotNull SerialDescriptor descriptor, int i10, float f10) {
        t.i(descriptor, "descriptor");
        if (H(descriptor, i10)) {
            t(f10);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void t(float f10) {
        J(Float.valueOf(f10));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void u(char c10) {
        J(Character.valueOf(c10));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void v() {
        Encoder.a.b(this);
    }

    @Override // ca.d
    public final void w(@NotNull SerialDescriptor descriptor, int i10, int i11) {
        t.i(descriptor, "descriptor");
        if (H(descriptor, i10)) {
            B(i11);
        }
    }

    @Override // ca.d
    public final void x(@NotNull SerialDescriptor descriptor, int i10, boolean z10) {
        t.i(descriptor, "descriptor");
        if (H(descriptor, i10)) {
            r(z10);
        }
    }

    @Override // ca.d
    public final void y(@NotNull SerialDescriptor descriptor, int i10, @NotNull String value) {
        t.i(descriptor, "descriptor");
        t.i(value, "value");
        if (H(descriptor, i10)) {
            G(value);
        }
    }

    @Override // ca.d
    public boolean z(@NotNull SerialDescriptor serialDescriptor, int i10) {
        return d.a.a(this, serialDescriptor, i10);
    }
}
