package da;

import ba.j;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ObjectSerializer.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class c1<T> implements KSerializer<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final T f24550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private List<? extends Annotation> f24551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final v8.l f24552c;

    /* JADX INFO: compiled from: ObjectSerializer.kt */
    static final class a extends kotlin.jvm.internal.v implements h9.a<SerialDescriptor> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f24553g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ c1<T> f24554h;

        /* JADX INFO: renamed from: da.c1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ObjectSerializer.kt */
        static final class C0542a extends kotlin.jvm.internal.v implements h9.l<ba.a, v8.k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ c1<T> f24555g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0542a(c1<T> c1Var) {
                super(1);
                this.f24555g = c1Var;
            }

            public final void a(@NotNull ba.a buildSerialDescriptor) {
                kotlin.jvm.internal.t.i(buildSerialDescriptor, "$this$buildSerialDescriptor");
                buildSerialDescriptor.h(((c1) this.f24555g).f24551b);
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ v8.k0 invoke(ba.a aVar) {
                a(aVar);
                return v8.k0.f35197a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, c1<T> c1Var) {
            super(0);
            this.f24553g = str;
            this.f24554h = c1Var;
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final SerialDescriptor invoke() {
            return ba.h.c(this.f24553g, j.d.f2324a, new SerialDescriptor[0], new C0542a(this.f24554h));
        }
    }

    public c1(@NotNull String serialName, @NotNull T objectInstance) {
        kotlin.jvm.internal.t.i(serialName, "serialName");
        kotlin.jvm.internal.t.i(objectInstance, "objectInstance");
        this.f24550a = objectInstance;
        this.f24551b = kotlin.collections.v.l();
        this.f24552c = v8.n.b(v8.p.f35202b, new a(serialName, this));
    }

    @Override // z9.b
    @NotNull
    public T deserialize(@NotNull Decoder decoder) {
        kotlin.jvm.internal.t.i(decoder, "decoder");
        SerialDescriptor descriptor = getDescriptor();
        ca.c cVarB = decoder.b(descriptor);
        int iO = cVarB.o(getDescriptor());
        if (iO == -1) {
            v8.k0 k0Var = v8.k0.f35197a;
            cVarB.c(descriptor);
            return this.f24550a;
        }
        throw new z9.i("Unexpected index " + iO);
    }

    @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
    @NotNull
    public SerialDescriptor getDescriptor() {
        return (SerialDescriptor) this.f24552c.getValue();
    }

    @Override // z9.j
    public void serialize(@NotNull Encoder encoder, @NotNull T value) {
        kotlin.jvm.internal.t.i(encoder, "encoder");
        kotlin.jvm.internal.t.i(value, "value");
        encoder.b(getDescriptor()).c(getDescriptor());
    }
}
