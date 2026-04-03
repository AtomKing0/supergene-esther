package da;

import ca.c;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AbstractPolymorphicSerializer.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class b<T> implements KSerializer<T> {
    /* JADX INFO: Access modifiers changed from: private */
    public final T b(ca.c cVar) {
        return (T) c.a.c(cVar, getDescriptor(), 1, z9.f.a(this, cVar, cVar.n(getDescriptor(), 0)), null, 8, null);
    }

    @Nullable
    public z9.b<? extends T> c(@NotNull ca.c decoder, @Nullable String str) {
        kotlin.jvm.internal.t.i(decoder, "decoder");
        return decoder.a().d(e(), str);
    }

    @Nullable
    public z9.j<T> d(@NotNull Encoder encoder, @NotNull T value) {
        kotlin.jvm.internal.t.i(encoder, "encoder");
        kotlin.jvm.internal.t.i(value, "value");
        return encoder.a().e(e(), value);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // z9.b
    @NotNull
    public final T deserialize(@NotNull Decoder decoder) {
        T t10;
        kotlin.jvm.internal.t.i(decoder, "decoder");
        SerialDescriptor descriptor = getDescriptor();
        ca.c cVarB = decoder.b(descriptor);
        kotlin.jvm.internal.n0 n0Var = new kotlin.jvm.internal.n0();
        if (cVarB.p()) {
            t10 = (T) b(cVarB);
        } else {
            t10 = null;
            while (true) {
                int iO = cVarB.o(getDescriptor());
                if (iO != -1) {
                    if (iO == 0) {
                        n0Var.f29834a = (T) cVarB.n(getDescriptor(), iO);
                    } else {
                        if (iO != 1) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Invalid index in polymorphic deserialization of ");
                            String str = (String) n0Var.f29834a;
                            if (str == null) {
                                str = "unknown class";
                            }
                            sb.append(str);
                            sb.append("\n Expected 0, 1 or DECODE_DONE(-1), but found ");
                            sb.append(iO);
                            throw new z9.i(sb.toString());
                        }
                        T t11 = n0Var.f29834a;
                        if (t11 == 0) {
                            throw new IllegalArgumentException("Cannot read polymorphic value before its type token".toString());
                        }
                        n0Var.f29834a = t11;
                        t10 = (T) c.a.c(cVarB, getDescriptor(), iO, z9.f.a(this, cVarB, (String) t11), null, 8, null);
                    }
                } else {
                    if (t10 == null) {
                        throw new IllegalArgumentException(("Polymorphic value has not been read for class " + ((String) n0Var.f29834a)).toString());
                    }
                    kotlin.jvm.internal.t.g(t10, "null cannot be cast to non-null type T of kotlinx.serialization.internal.AbstractPolymorphicSerializer.deserialize$lambda$3");
                }
            }
        }
        cVarB.c(descriptor);
        return t10;
    }

    @NotNull
    public abstract KClass<T> e();

    @Override // z9.j
    public final void serialize(@NotNull Encoder encoder, @NotNull T value) {
        kotlin.jvm.internal.t.i(encoder, "encoder");
        kotlin.jvm.internal.t.i(value, "value");
        z9.j<? super T> jVarB = z9.f.b(this, encoder, value);
        SerialDescriptor descriptor = getDescriptor();
        ca.d dVarB = encoder.b(descriptor);
        dVarB.y(getDescriptor(), 0, jVarB.getDescriptor().h());
        SerialDescriptor descriptor2 = getDescriptor();
        kotlin.jvm.internal.t.g(jVarB, "null cannot be cast to non-null type kotlinx.serialization.SerializationStrategy<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        dVarB.j(descriptor2, 1, jVarB, value);
        dVarB.c(descriptor);
    }
}
