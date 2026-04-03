package da;

import ca.c;
import java.util.Iterator;
import java.util.Map;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CollectionSerializers.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class x0<Key, Value, Collection, Builder extends Map<Key, Value>> extends a<Map.Entry<? extends Key, ? extends Value>, Collection, Builder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final KSerializer<Key> f24652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final KSerializer<Value> f24653b;

    public /* synthetic */ x0(KSerializer kSerializer, KSerializer kSerializer2, kotlin.jvm.internal.k kVar) {
        this(kSerializer, kSerializer2);
    }

    @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
    @NotNull
    public abstract SerialDescriptor getDescriptor();

    @NotNull
    public final KSerializer<Key> m() {
        return this.f24652a;
    }

    @NotNull
    public final KSerializer<Value> n() {
        return this.f24653b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.a
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public final void g(@NotNull ca.c decoder, @NotNull Builder builder, int i10, int i11) {
        kotlin.jvm.internal.t.i(decoder, "decoder");
        kotlin.jvm.internal.t.i(builder, "builder");
        if (!(i11 >= 0)) {
            throw new IllegalArgumentException("Size must be known in advance when using READ_ALL".toString());
        }
        n9.g gVarT = n9.o.t(n9.o.u(0, i11 * 2), 2);
        int iB = gVarT.b();
        int iE = gVarT.e();
        int iF = gVarT.f();
        if ((iF <= 0 || iB > iE) && (iF >= 0 || iE > iB)) {
            return;
        }
        while (true) {
            h(decoder, i10 + iB, builder, false);
            if (iB == iE) {
                return;
            } else {
                iB += iF;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.a
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public final void h(@NotNull ca.c decoder, int i10, @NotNull Builder builder, boolean z10) {
        int iO;
        kotlin.jvm.internal.t.i(decoder, "decoder");
        kotlin.jvm.internal.t.i(builder, "builder");
        Object objC = c.a.c(decoder, getDescriptor(), i10, this.f24652a, null, 8, null);
        if (z10) {
            iO = decoder.o(getDescriptor());
            if (!(iO == i10 + 1)) {
                throw new IllegalArgumentException(("Value must follow key in a map, index for key: " + i10 + ", returned index for value: " + iO).toString());
            }
        } else {
            iO = i10 + 1;
        }
        int i11 = iO;
        builder.put(objC, (!builder.containsKey(objC) || (this.f24653b.getDescriptor().getKind() instanceof ba.e)) ? c.a.c(decoder, getDescriptor(), i11, this.f24653b, null, 8, null) : decoder.y(getDescriptor(), i11, this.f24653b, kotlin.collections.r0.h(builder, objC)));
    }

    @Override // z9.j
    public void serialize(@NotNull Encoder encoder, Collection collection) {
        kotlin.jvm.internal.t.i(encoder, "encoder");
        int iE = e(collection);
        SerialDescriptor descriptor = getDescriptor();
        ca.d dVarI = encoder.i(descriptor, iE);
        Iterator<Map.Entry<? extends Key, ? extends Value>> itD = d(collection);
        int i10 = 0;
        while (itD.hasNext()) {
            Map.Entry<? extends Key, ? extends Value> next = itD.next();
            Key key = next.getKey();
            Value value = next.getValue();
            int i11 = i10 + 1;
            dVarI.j(getDescriptor(), i10, m(), key);
            dVarI.j(getDescriptor(), i11, n(), value);
            i10 = i11 + 1;
        }
        dVarI.c(descriptor);
    }

    private x0(KSerializer<Key> kSerializer, KSerializer<Value> kSerializer2) {
        super(null);
        this.f24652a = kSerializer;
        this.f24653b = kSerializer2;
    }
}
