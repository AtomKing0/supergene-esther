package z9;

import ba.i;
import da.h1;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: ContextualSerializer.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class a<T> implements KSerializer<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final KClass<T> f37612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final KSerializer<T> f37613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final List<KSerializer<?>> f37614c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final SerialDescriptor f37615d;

    /* JADX INFO: renamed from: z9.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ContextualSerializer.kt */
    static final class C0767a extends v implements h9.l<ba.a, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ a<T> f37616g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0767a(a<T> aVar) {
            super(1);
            this.f37616g = aVar;
        }

        public final void a(@NotNull ba.a buildSerialDescriptor) {
            SerialDescriptor descriptor;
            t.i(buildSerialDescriptor, "$this$buildSerialDescriptor");
            KSerializer kSerializer = ((a) this.f37616g).f37613b;
            List<Annotation> annotations = (kSerializer == null || (descriptor = kSerializer.getDescriptor()) == null) ? null : descriptor.getAnnotations();
            if (annotations == null) {
                annotations = kotlin.collections.v.l();
            }
            buildSerialDescriptor.h(annotations);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(ba.a aVar) {
            a(aVar);
            return k0.f35197a;
        }
    }

    public a(@NotNull KClass<T> serializableClass, @Nullable KSerializer<T> kSerializer, @NotNull KSerializer<?>[] typeArgumentsSerializers) {
        t.i(serializableClass, "serializableClass");
        t.i(typeArgumentsSerializers, "typeArgumentsSerializers");
        this.f37612a = serializableClass;
        this.f37613b = kSerializer;
        this.f37614c = kotlin.collections.o.c(typeArgumentsSerializers);
        this.f37615d = ba.b.c(ba.h.c("kotlinx.serialization.ContextualSerializer", i.a.f2319a, new SerialDescriptor[0], new C0767a(this)), serializableClass);
    }

    private final KSerializer<T> b(fa.c cVar) {
        KSerializer<T> kSerializerB = cVar.b(this.f37612a, this.f37614c);
        if (kSerializerB != null || (kSerializerB = this.f37613b) != null) {
            return kSerializerB;
        }
        h1.d(this.f37612a);
        throw new v8.h();
    }

    @Override // z9.b
    @NotNull
    public T deserialize(@NotNull Decoder decoder) {
        t.i(decoder, "decoder");
        return (T) decoder.D(b(decoder.a()));
    }

    @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
    @NotNull
    public SerialDescriptor getDescriptor() {
        return this.f37615d;
    }

    @Override // z9.j
    public void serialize(@NotNull Encoder encoder, @NotNull T value) {
        t.i(encoder, "encoder");
        t.i(value, "value");
        encoder.E(b(encoder.a()), value);
    }
}
