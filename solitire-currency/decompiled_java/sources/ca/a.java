package ca;

import ca.c;
import kotlin.jvm.internal.o0;
import kotlin.jvm.internal.t;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z9.i;

/* JADX INFO: compiled from: AbstractDecoder.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a implements Decoder, c {
    @Override // ca.c
    public final char A(@NotNull SerialDescriptor descriptor, int i10) {
        t.i(descriptor, "descriptor");
        return x();
    }

    @Override // ca.c
    public final byte B(@NotNull SerialDescriptor descriptor, int i10) {
        t.i(descriptor, "descriptor");
        return H();
    }

    @Override // ca.c
    public final boolean C(@NotNull SerialDescriptor descriptor, int i10) {
        t.i(descriptor, "descriptor");
        return w();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public <T> T D(@NotNull z9.b<T> bVar) {
        return (T) Decoder.a.a(this, bVar);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public boolean E() {
        return true;
    }

    @Override // ca.c
    public final short F(@NotNull SerialDescriptor descriptor, int i10) {
        t.i(descriptor, "descriptor");
        return s();
    }

    @Override // ca.c
    public final double G(@NotNull SerialDescriptor descriptor, int i10) {
        t.i(descriptor, "descriptor");
        return v();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public abstract byte H();

    public <T> T I(@NotNull z9.b<T> deserializer, @Nullable T t10) {
        t.i(deserializer, "deserializer");
        return (T) D(deserializer);
    }

    @NotNull
    public Object J() {
        throw new i(o0.b(getClass()) + " can't retrieve untyped values");
    }

    @Override // kotlinx.serialization.encoding.Decoder
    @NotNull
    public c b(@NotNull SerialDescriptor descriptor) {
        t.i(descriptor, "descriptor");
        return this;
    }

    @Override // ca.c
    public void c(@NotNull SerialDescriptor descriptor) {
        t.i(descriptor, "descriptor");
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public int e(@NotNull SerialDescriptor enumDescriptor) {
        t.i(enumDescriptor, "enumDescriptor");
        Object objJ = J();
        t.g(objJ, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) objJ).intValue();
    }

    @Override // ca.c
    public final long f(@NotNull SerialDescriptor descriptor, int i10) {
        t.i(descriptor, "descriptor");
        return m();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public abstract int h();

    @Override // ca.c
    public final int i(@NotNull SerialDescriptor descriptor, int i10) {
        t.i(descriptor, "descriptor");
        return h();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    @Nullable
    public Void j() {
        return null;
    }

    @Override // ca.c
    @Nullable
    public final <T> T k(@NotNull SerialDescriptor descriptor, int i10, @NotNull z9.b<T> deserializer, @Nullable T t10) {
        t.i(descriptor, "descriptor");
        t.i(deserializer, "deserializer");
        return (deserializer.getDescriptor().b() || E()) ? (T) I(deserializer, t10) : (T) j();
    }

    @Override // ca.c
    public int l(@NotNull SerialDescriptor serialDescriptor) {
        return c.a.a(this, serialDescriptor);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public abstract long m();

    @Override // ca.c
    @NotNull
    public final String n(@NotNull SerialDescriptor descriptor, int i10) {
        t.i(descriptor, "descriptor");
        return z();
    }

    @Override // ca.c
    public boolean p() {
        return c.a.b(this);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    @NotNull
    public Decoder q(@NotNull SerialDescriptor descriptor) {
        t.i(descriptor, "descriptor");
        return this;
    }

    @Override // ca.c
    @NotNull
    public Decoder r(@NotNull SerialDescriptor descriptor, int i10) {
        t.i(descriptor, "descriptor");
        return q(descriptor.g(i10));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public abstract short s();

    @Override // kotlinx.serialization.encoding.Decoder
    public float t() {
        Object objJ = J();
        t.g(objJ, "null cannot be cast to non-null type kotlin.Float");
        return ((Float) objJ).floatValue();
    }

    @Override // ca.c
    public final float u(@NotNull SerialDescriptor descriptor, int i10) {
        t.i(descriptor, "descriptor");
        return t();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public double v() {
        Object objJ = J();
        t.g(objJ, "null cannot be cast to non-null type kotlin.Double");
        return ((Double) objJ).doubleValue();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public boolean w() {
        Object objJ = J();
        t.g(objJ, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) objJ).booleanValue();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public char x() {
        Object objJ = J();
        t.g(objJ, "null cannot be cast to non-null type kotlin.Char");
        return ((Character) objJ).charValue();
    }

    @Override // ca.c
    public <T> T y(@NotNull SerialDescriptor descriptor, int i10, @NotNull z9.b<T> deserializer, @Nullable T t10) {
        t.i(descriptor, "descriptor");
        t.i(deserializer, "deserializer");
        return (T) I(deserializer, t10);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    @NotNull
    public String z() {
        Object objJ = J();
        t.g(objJ, "null cannot be cast to non-null type kotlin.String");
        return (String) objJ;
    }
}
