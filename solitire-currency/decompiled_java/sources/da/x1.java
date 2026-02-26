package da;

import ca.c;
import java.util.ArrayList;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Tagged.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class x1<Tag> implements Decoder, ca.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final ArrayList<Tag> f24654a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f24655b;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: Tagged.kt */
    static final class a<T> extends kotlin.jvm.internal.v implements h9.a<T> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ x1<Tag> f24656g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ z9.b<T> f24657h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ T f24658i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(x1<Tag> x1Var, z9.b<T> bVar, T t10) {
            super(0);
            this.f24656g = x1Var;
            this.f24657h = bVar;
            this.f24658i = t10;
        }

        @Override // h9.a
        @Nullable
        public final T invoke() {
            return this.f24656g.E() ? (T) this.f24656g.I(this.f24657h, this.f24658i) : (T) this.f24656g.j();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: Tagged.kt */
    static final class b<T> extends kotlin.jvm.internal.v implements h9.a<T> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ x1<Tag> f24659g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ z9.b<T> f24660h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ T f24661i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(x1<Tag> x1Var, z9.b<T> bVar, T t10) {
            super(0);
            this.f24659g = x1Var;
            this.f24660h = bVar;
            this.f24661i = t10;
        }

        @Override // h9.a
        public final T invoke() {
            return (T) this.f24659g.I(this.f24660h, this.f24661i);
        }
    }

    private final <E> E Y(Tag tag, h9.a<? extends E> aVar) {
        X(tag);
        E eInvoke = aVar.invoke();
        if (!this.f24655b) {
            W();
        }
        this.f24655b = false;
        return eInvoke;
    }

    @Override // ca.c
    public final char A(@NotNull SerialDescriptor descriptor, int i10) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        return L(V(descriptor, i10));
    }

    @Override // ca.c
    public final byte B(@NotNull SerialDescriptor descriptor, int i10) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        return K(V(descriptor, i10));
    }

    @Override // ca.c
    public final boolean C(@NotNull SerialDescriptor descriptor, int i10) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        return J(V(descriptor, i10));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public abstract <T> T D(@NotNull z9.b<T> bVar);

    @Override // kotlinx.serialization.encoding.Decoder
    public abstract boolean E();

    @Override // ca.c
    public final short F(@NotNull SerialDescriptor descriptor, int i10) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        return S(V(descriptor, i10));
    }

    @Override // ca.c
    public final double G(@NotNull SerialDescriptor descriptor, int i10) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        return M(V(descriptor, i10));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final byte H() {
        return K(W());
    }

    protected <T> T I(@NotNull z9.b<T> deserializer, @Nullable T t10) {
        kotlin.jvm.internal.t.i(deserializer, "deserializer");
        return (T) D(deserializer);
    }

    protected abstract boolean J(Tag tag);

    protected abstract byte K(Tag tag);

    protected abstract char L(Tag tag);

    protected abstract double M(Tag tag);

    protected abstract int N(Tag tag, @NotNull SerialDescriptor serialDescriptor);

    protected abstract float O(Tag tag);

    @NotNull
    protected Decoder P(Tag tag, @NotNull SerialDescriptor inlineDescriptor) {
        kotlin.jvm.internal.t.i(inlineDescriptor, "inlineDescriptor");
        X(tag);
        return this;
    }

    protected abstract int Q(Tag tag);

    protected abstract long R(Tag tag);

    protected abstract short S(Tag tag);

    @NotNull
    protected abstract String T(Tag tag);

    @Nullable
    protected final Tag U() {
        return (Tag) kotlin.collections.d0.u0(this.f24654a);
    }

    protected abstract Tag V(@NotNull SerialDescriptor serialDescriptor, int i10);

    protected final Tag W() {
        ArrayList<Tag> arrayList = this.f24654a;
        Tag tagRemove = arrayList.remove(kotlin.collections.v.m(arrayList));
        this.f24655b = true;
        return tagRemove;
    }

    protected final void X(Tag tag) {
        this.f24654a.add(tag);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final int e(@NotNull SerialDescriptor enumDescriptor) {
        kotlin.jvm.internal.t.i(enumDescriptor, "enumDescriptor");
        return N(W(), enumDescriptor);
    }

    @Override // ca.c
    public final long f(@NotNull SerialDescriptor descriptor, int i10) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        return R(V(descriptor, i10));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final int h() {
        return Q(W());
    }

    @Override // ca.c
    public final int i(@NotNull SerialDescriptor descriptor, int i10) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        return Q(V(descriptor, i10));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    @Nullable
    public final Void j() {
        return null;
    }

    @Override // ca.c
    @Nullable
    public final <T> T k(@NotNull SerialDescriptor descriptor, int i10, @NotNull z9.b<T> deserializer, @Nullable T t10) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        kotlin.jvm.internal.t.i(deserializer, "deserializer");
        return (T) Y(V(descriptor, i10), new a(this, deserializer, t10));
    }

    @Override // ca.c
    public int l(@NotNull SerialDescriptor serialDescriptor) {
        return c.a.a(this, serialDescriptor);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final long m() {
        return R(W());
    }

    @Override // ca.c
    @NotNull
    public final String n(@NotNull SerialDescriptor descriptor, int i10) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        return T(V(descriptor, i10));
    }

    @Override // ca.c
    public boolean p() {
        return c.a.b(this);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    @NotNull
    public final Decoder q(@NotNull SerialDescriptor descriptor) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        return P(W(), descriptor);
    }

    @Override // ca.c
    @NotNull
    public final Decoder r(@NotNull SerialDescriptor descriptor, int i10) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        return P(V(descriptor, i10), descriptor.g(i10));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final short s() {
        return S(W());
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final float t() {
        return O(W());
    }

    @Override // ca.c
    public final float u(@NotNull SerialDescriptor descriptor, int i10) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        return O(V(descriptor, i10));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final double v() {
        return M(W());
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final boolean w() {
        return J(W());
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final char x() {
        return L(W());
    }

    @Override // ca.c
    public final <T> T y(@NotNull SerialDescriptor descriptor, int i10, @NotNull z9.b<T> deserializer, @Nullable T t10) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        kotlin.jvm.internal.t.i(deserializer, "deserializer");
        return (T) Y(V(descriptor, i10), new b(this, deserializer, t10));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    @NotNull
    public final String z() {
        return T(W());
    }
}
