package kotlinx.serialization.json;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.s0;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: JsonElementSerializers.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class s implements KSerializer<JsonObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final s f30083a = new s();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final SerialDescriptor f30084b = a.f30085b;

    /* JADX INFO: compiled from: JsonElementSerializers.kt */
    private static final class a implements SerialDescriptor {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        public static final a f30085b = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        private static final String f30086c = "kotlinx.serialization.json.JsonObject";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final /* synthetic */ SerialDescriptor f30087a = aa.a.k(aa.a.B(s0.f29840a), i.f30067a).getDescriptor();

        private a() {
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public boolean b() {
            return this.f30087a.b();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public int c(@NotNull String name) {
            kotlin.jvm.internal.t.i(name, "name");
            return this.f30087a.c(name);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public int d() {
            return this.f30087a.d();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        @NotNull
        public String e(int i10) {
            return this.f30087a.e(i10);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        @NotNull
        public List<Annotation> f(int i10) {
            return this.f30087a.f(i10);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        @NotNull
        public SerialDescriptor g(int i10) {
            return this.f30087a.g(i10);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        @NotNull
        public List<Annotation> getAnnotations() {
            return this.f30087a.getAnnotations();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        @NotNull
        public ba.i getKind() {
            return this.f30087a.getKind();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        @NotNull
        public String h() {
            return f30086c;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public boolean i(int i10) {
            return this.f30087a.i(i10);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public boolean isInline() {
            return this.f30087a.isInline();
        }
    }

    private s() {
    }

    @Override // z9.b
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public JsonObject deserialize(@NotNull Decoder decoder) {
        kotlin.jvm.internal.t.i(decoder, "decoder");
        j.g(decoder);
        return new JsonObject((Map) aa.a.k(aa.a.B(s0.f29840a), i.f30067a).deserialize(decoder));
    }

    @Override // z9.j
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(@NotNull Encoder encoder, @NotNull JsonObject value) {
        kotlin.jvm.internal.t.i(encoder, "encoder");
        kotlin.jvm.internal.t.i(value, "value");
        j.h(encoder);
        aa.a.k(aa.a.B(s0.f29840a), i.f30067a).serialize(encoder, value);
    }

    @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
    @NotNull
    public SerialDescriptor getDescriptor() {
        return f30084b;
    }
}
