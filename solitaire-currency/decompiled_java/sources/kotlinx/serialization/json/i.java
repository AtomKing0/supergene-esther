package kotlinx.serialization.json;

import ba.d;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: JsonElementSerializers.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class i implements KSerializer<JsonElement> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f30067a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final SerialDescriptor f30068b = ba.h.c("kotlinx.serialization.json.JsonElement", d.b.f2288a, new SerialDescriptor[0], a.f30069g);

    /* JADX INFO: compiled from: JsonElementSerializers.kt */
    static final class a extends kotlin.jvm.internal.v implements h9.l<ba.a, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f30069g = new a();

        /* JADX INFO: renamed from: kotlinx.serialization.json.i$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: JsonElementSerializers.kt */
        static final class C0608a extends kotlin.jvm.internal.v implements h9.a<SerialDescriptor> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final C0608a f30070g = new C0608a();

            C0608a() {
                super(0);
            }

            @Override // h9.a
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final SerialDescriptor invoke() {
                return t.f30088a.getDescriptor();
            }
        }

        /* JADX INFO: compiled from: JsonElementSerializers.kt */
        static final class b extends kotlin.jvm.internal.v implements h9.a<SerialDescriptor> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final b f30071g = new b();

            b() {
                super(0);
            }

            @Override // h9.a
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final SerialDescriptor invoke() {
                return q.f30080a.getDescriptor();
            }
        }

        /* JADX INFO: compiled from: JsonElementSerializers.kt */
        static final class c extends kotlin.jvm.internal.v implements h9.a<SerialDescriptor> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final c f30072g = new c();

            c() {
                super(0);
            }

            @Override // h9.a
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final SerialDescriptor invoke() {
                return o.f30078a.getDescriptor();
            }
        }

        /* JADX INFO: compiled from: JsonElementSerializers.kt */
        static final class d extends kotlin.jvm.internal.v implements h9.a<SerialDescriptor> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final d f30073g = new d();

            d() {
                super(0);
            }

            @Override // h9.a
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final SerialDescriptor invoke() {
                return s.f30083a.getDescriptor();
            }
        }

        /* JADX INFO: compiled from: JsonElementSerializers.kt */
        static final class e extends kotlin.jvm.internal.v implements h9.a<SerialDescriptor> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final e f30074g = new e();

            e() {
                super(0);
            }

            @Override // h9.a
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final SerialDescriptor invoke() {
                return kotlinx.serialization.json.b.f30037a.getDescriptor();
            }
        }

        a() {
            super(1);
        }

        public final void a(@NotNull ba.a buildSerialDescriptor) {
            kotlin.jvm.internal.t.i(buildSerialDescriptor, "$this$buildSerialDescriptor");
            ba.a.b(buildSerialDescriptor, "JsonPrimitive", j.f(C0608a.f30070g), null, false, 12, null);
            ba.a.b(buildSerialDescriptor, "JsonNull", j.f(b.f30071g), null, false, 12, null);
            ba.a.b(buildSerialDescriptor, "JsonLiteral", j.f(c.f30072g), null, false, 12, null);
            ba.a.b(buildSerialDescriptor, "JsonObject", j.f(d.f30073g), null, false, 12, null);
            ba.a.b(buildSerialDescriptor, "JsonArray", j.f(e.f30074g), null, false, 12, null);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(ba.a aVar) {
            a(aVar);
            return k0.f35197a;
        }
    }

    private i() {
    }

    @Override // z9.b
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public JsonElement deserialize(@NotNull Decoder decoder) {
        kotlin.jvm.internal.t.i(decoder, "decoder");
        return j.d(decoder).g();
    }

    @Override // z9.j
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(@NotNull Encoder encoder, @NotNull JsonElement value) {
        kotlin.jvm.internal.t.i(encoder, "encoder");
        kotlin.jvm.internal.t.i(value, "value");
        j.h(encoder);
        if (value instanceof JsonPrimitive) {
            encoder.E(t.f30088a, value);
        } else if (value instanceof JsonObject) {
            encoder.E(s.f30083a, value);
        } else if (value instanceof JsonArray) {
            encoder.E(b.f30037a, value);
        }
    }

    @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
    @NotNull
    public SerialDescriptor getDescriptor() {
        return f30068b;
    }
}
