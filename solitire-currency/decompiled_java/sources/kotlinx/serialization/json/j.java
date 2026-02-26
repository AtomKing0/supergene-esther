package kotlinx.serialization.json;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.internal.o0;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: JsonElementSerializers.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class j {

    /* JADX INFO: compiled from: JsonElementSerializers.kt */
    public static final class a implements SerialDescriptor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final v8.l f30075a;

        a(h9.a<? extends SerialDescriptor> aVar) {
            this.f30075a = v8.n.a(aVar);
        }

        private final SerialDescriptor a() {
            return (SerialDescriptor) this.f30075a.getValue();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public boolean b() {
            return SerialDescriptor.a.c(this);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public int c(@NotNull String name) {
            kotlin.jvm.internal.t.i(name, "name");
            return a().c(name);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public int d() {
            return a().d();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        @NotNull
        public String e(int i10) {
            return a().e(i10);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        @NotNull
        public List<Annotation> f(int i10) {
            return a().f(i10);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        @NotNull
        public SerialDescriptor g(int i10) {
            return a().g(i10);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        @NotNull
        public List<Annotation> getAnnotations() {
            return SerialDescriptor.a.a(this);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        @NotNull
        public ba.i getKind() {
            return a().getKind();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        @NotNull
        public String h() {
            return a().h();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public boolean i(int i10) {
            return a().i(i10);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public boolean isInline() {
            return SerialDescriptor.a.b(this);
        }
    }

    @NotNull
    public static final f d(@NotNull Decoder decoder) {
        kotlin.jvm.internal.t.i(decoder, "<this>");
        f fVar = decoder instanceof f ? (f) decoder : null;
        if (fVar != null) {
            return fVar;
        }
        throw new IllegalStateException("This serializer can be used only with Json format.Expected Decoder to be JsonDecoder, got " + o0.b(decoder.getClass()));
    }

    @NotNull
    public static final k e(@NotNull Encoder encoder) {
        kotlin.jvm.internal.t.i(encoder, "<this>");
        k kVar = encoder instanceof k ? (k) encoder : null;
        if (kVar != null) {
            return kVar;
        }
        throw new IllegalStateException("This serializer can be used only with Json format.Expected Encoder to be JsonEncoder, got " + o0.b(encoder.getClass()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SerialDescriptor f(h9.a<? extends SerialDescriptor> aVar) {
        return new a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Decoder decoder) {
        d(decoder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Encoder encoder) {
        e(encoder);
    }
}
