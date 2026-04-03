package da;

import java.util.ArrayList;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Tagged.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class y1<Tag> implements Encoder, ca.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final ArrayList<Tag> f24668a = new ArrayList<>();

    private final boolean H(SerialDescriptor serialDescriptor, int i10) {
        Z(X(serialDescriptor, i10));
        return true;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void B(int i10) {
        Q(Y(), i10);
    }

    @Override // ca.d
    public final void C(@NotNull SerialDescriptor descriptor, int i10, short s10) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        S(X(descriptor, i10), s10);
    }

    @Override // ca.d
    public final void D(@NotNull SerialDescriptor descriptor, int i10, double d10) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        M(X(descriptor, i10), d10);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public abstract <T> void E(@NotNull z9.j<? super T> jVar, T t10);

    @Override // ca.d
    public final void F(@NotNull SerialDescriptor descriptor, int i10, long j10) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        R(X(descriptor, i10), j10);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void G(@NotNull String value) {
        kotlin.jvm.internal.t.i(value, "value");
        T(Y(), value);
    }

    public <T> void I(@NotNull z9.j<? super T> jVar, @Nullable T t10) {
        Encoder.a.c(this, jVar, t10);
    }

    protected abstract void J(Tag tag, boolean z10);

    protected abstract void K(Tag tag, byte b10);

    protected abstract void L(Tag tag, char c10);

    protected abstract void M(Tag tag, double d10);

    protected abstract void N(Tag tag, @NotNull SerialDescriptor serialDescriptor, int i10);

    protected abstract void O(Tag tag, float f10);

    @NotNull
    protected Encoder P(Tag tag, @NotNull SerialDescriptor inlineDescriptor) {
        kotlin.jvm.internal.t.i(inlineDescriptor, "inlineDescriptor");
        Z(tag);
        return this;
    }

    protected abstract void Q(Tag tag, int i10);

    protected abstract void R(Tag tag, long j10);

    protected abstract void S(Tag tag, short s10);

    protected abstract void T(Tag tag, @NotNull String str);

    protected abstract void U(@NotNull SerialDescriptor serialDescriptor);

    protected final Tag V() {
        return (Tag) kotlin.collections.d0.t0(this.f24668a);
    }

    @Nullable
    protected final Tag W() {
        return (Tag) kotlin.collections.d0.u0(this.f24668a);
    }

    protected abstract Tag X(@NotNull SerialDescriptor serialDescriptor, int i10);

    protected final Tag Y() {
        if (!(!this.f24668a.isEmpty())) {
            throw new z9.i("No tag in stack for requested element");
        }
        ArrayList<Tag> arrayList = this.f24668a;
        return arrayList.remove(kotlin.collections.v.m(arrayList));
    }

    protected final void Z(Tag tag) {
        this.f24668a.add(tag);
    }

    @Override // ca.d
    public final void c(@NotNull SerialDescriptor descriptor) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        if (!this.f24668a.isEmpty()) {
            Y();
        }
        U(descriptor);
    }

    @Override // ca.d
    @NotNull
    public final Encoder e(@NotNull SerialDescriptor descriptor, int i10) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        return P(X(descriptor, i10), descriptor.g(i10));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void f(double d10) {
        M(Y(), d10);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void g(byte b10) {
        K(Y(), b10);
    }

    @Override // ca.d
    public <T> void h(@NotNull SerialDescriptor descriptor, int i10, @NotNull z9.j<? super T> serializer, @Nullable T t10) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        kotlin.jvm.internal.t.i(serializer, "serializer");
        if (H(descriptor, i10)) {
            I(serializer, t10);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    @NotNull
    public ca.d i(@NotNull SerialDescriptor serialDescriptor, int i10) {
        return Encoder.a.a(this, serialDescriptor, i10);
    }

    @Override // ca.d
    public <T> void j(@NotNull SerialDescriptor descriptor, int i10, @NotNull z9.j<? super T> serializer, T t10) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        kotlin.jvm.internal.t.i(serializer, "serializer");
        if (H(descriptor, i10)) {
            E(serializer, t10);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void k(@NotNull SerialDescriptor enumDescriptor, int i10) {
        kotlin.jvm.internal.t.i(enumDescriptor, "enumDescriptor");
        N(Y(), enumDescriptor, i10);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    @NotNull
    public final Encoder l(@NotNull SerialDescriptor descriptor) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        return P(Y(), descriptor);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void m(long j10) {
        R(Y(), j10);
    }

    @Override // ca.d
    public final void n(@NotNull SerialDescriptor descriptor, int i10, char c10) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        L(X(descriptor, i10), c10);
    }

    @Override // ca.d
    public final void p(@NotNull SerialDescriptor descriptor, int i10, byte b10) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        K(X(descriptor, i10), b10);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void q(short s10) {
        S(Y(), s10);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void r(boolean z10) {
        J(Y(), z10);
    }

    @Override // ca.d
    public final void s(@NotNull SerialDescriptor descriptor, int i10, float f10) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        O(X(descriptor, i10), f10);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void t(float f10) {
        O(Y(), f10);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void u(char c10) {
        L(Y(), c10);
    }

    @Override // ca.d
    public final void w(@NotNull SerialDescriptor descriptor, int i10, int i11) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        Q(X(descriptor, i10), i11);
    }

    @Override // ca.d
    public final void x(@NotNull SerialDescriptor descriptor, int i10, boolean z10) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        J(X(descriptor, i10), z10);
    }

    @Override // ca.d
    public final void y(@NotNull SerialDescriptor descriptor, int i10, @NotNull String value) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        kotlin.jvm.internal.t.i(value, "value");
        T(X(descriptor, i10), value);
    }
}
