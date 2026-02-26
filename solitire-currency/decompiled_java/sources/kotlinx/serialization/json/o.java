package kotlinx.serialization.json;

import ba.e;
import ea.a0;
import kotlin.jvm.internal.o0;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;
import p9.x;
import v8.e0;

/* JADX INFO: compiled from: JsonElementSerializers.kt */
/* JADX INFO: loaded from: classes5.dex */
final class o implements KSerializer<n> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final o f30078a = new o();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final SerialDescriptor f30079b = ba.h.a("kotlinx.serialization.json.JsonLiteral", e.i.f2297a);

    private o() {
    }

    @Override // z9.b
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public n deserialize(@NotNull Decoder decoder) {
        kotlin.jvm.internal.t.i(decoder, "decoder");
        JsonElement jsonElementG = j.d(decoder).g();
        if (jsonElementG instanceof n) {
            return (n) jsonElementG;
        }
        throw a0.f(-1, "Unexpected JSON element, expected JsonLiteral, had " + o0.b(jsonElementG.getClass()), jsonElementG.toString());
    }

    @Override // z9.j
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(@NotNull Encoder encoder, @NotNull n value) {
        kotlin.jvm.internal.t.i(encoder, "encoder");
        kotlin.jvm.internal.t.i(value, "value");
        j.h(encoder);
        if (value.b()) {
            encoder.G(value.a());
            return;
        }
        Long lN = h.n(value);
        if (lN != null) {
            encoder.m(lN.longValue());
            return;
        }
        e0 e0VarH = x.h(value.a());
        if (e0VarH != null) {
            encoder.l(aa.a.F(e0.f35179b).getDescriptor()).m(e0VarH.g());
            return;
        }
        Double dH = h.h(value);
        if (dH != null) {
            encoder.f(dH.doubleValue());
            return;
        }
        Boolean boolE = h.e(value);
        if (boolE != null) {
            encoder.r(boolE.booleanValue());
        } else {
            encoder.G(value.a());
        }
    }

    @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
    @NotNull
    public SerialDescriptor getDescriptor() {
        return f30079b;
    }
}
