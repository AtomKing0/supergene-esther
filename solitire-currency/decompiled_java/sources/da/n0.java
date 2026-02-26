package da;

import ca.c;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Tuples.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class n0<K, V, R> implements KSerializer<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final KSerializer<K> f24600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final KSerializer<V> f24601b;

    public /* synthetic */ n0(KSerializer kSerializer, KSerializer kSerializer2, kotlin.jvm.internal.k kVar) {
        this(kSerializer, kSerializer2);
    }

    protected abstract K a(R r10);

    protected abstract V b(R r10);

    protected abstract R c(K k10, V v10);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // z9.b
    public R deserialize(@NotNull Decoder decoder) {
        kotlin.jvm.internal.t.i(decoder, "decoder");
        ca.c cVarB = decoder.b(getDescriptor());
        if (cVarB.p()) {
            return (R) c(c.a.c(cVarB, getDescriptor(), 0, this.f24600a, null, 8, null), c.a.c(cVarB, getDescriptor(), 1, this.f24601b, null, 8, null));
        }
        Object objC = a2.f24541a;
        Object objC2 = a2.f24541a;
        while (true) {
            int iO = cVarB.o(getDescriptor());
            if (iO == -1) {
                cVarB.c(getDescriptor());
                if (objC == a2.f24541a) {
                    throw new z9.i("Element 'key' is missing");
                }
                if (objC2 != a2.f24541a) {
                    return (R) c(objC, objC2);
                }
                throw new z9.i("Element 'value' is missing");
            }
            if (iO == 0) {
                objC = c.a.c(cVarB, getDescriptor(), 0, this.f24600a, null, 8, null);
            } else {
                if (iO != 1) {
                    throw new z9.i("Invalid index: " + iO);
                }
                objC2 = c.a.c(cVarB, getDescriptor(), 1, this.f24601b, null, 8, null);
            }
        }
    }

    @Override // z9.j
    public void serialize(@NotNull Encoder encoder, R r10) {
        kotlin.jvm.internal.t.i(encoder, "encoder");
        ca.d dVarB = encoder.b(getDescriptor());
        dVarB.j(getDescriptor(), 0, this.f24600a, a(r10));
        dVarB.j(getDescriptor(), 1, this.f24601b, b(r10));
        dVarB.c(getDescriptor());
    }

    private n0(KSerializer<K> kSerializer, KSerializer<V> kSerializer2) {
        this.f24600a = kSerializer;
        this.f24601b = kSerializer2;
    }
}
