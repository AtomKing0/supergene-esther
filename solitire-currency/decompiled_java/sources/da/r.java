package da;

import ca.c;
import java.util.Iterator;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CollectionSerializers.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class r<Element, Collection, Builder> extends a<Element, Collection, Builder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final KSerializer<Element> f24616a;

    public /* synthetic */ r(KSerializer kSerializer, kotlin.jvm.internal.k kVar) {
        this(kSerializer);
    }

    @Override // da.a
    protected final void g(@NotNull ca.c decoder, Builder builder, int i10, int i11) {
        kotlin.jvm.internal.t.i(decoder, "decoder");
        if (!(i11 >= 0)) {
            throw new IllegalArgumentException("Size must be known in advance when using READ_ALL".toString());
        }
        for (int i12 = 0; i12 < i11; i12++) {
            h(decoder, i10 + i12, builder, false);
        }
    }

    @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
    @NotNull
    public abstract SerialDescriptor getDescriptor();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // da.a
    protected void h(@NotNull ca.c decoder, int i10, Builder builder, boolean z10) {
        kotlin.jvm.internal.t.i(decoder, "decoder");
        n(builder, i10, c.a.c(decoder, getDescriptor(), i10, this.f24616a, null, 8, null));
    }

    protected abstract void n(Builder builder, int i10, Element element);

    @Override // z9.j
    public void serialize(@NotNull Encoder encoder, Collection collection) {
        kotlin.jvm.internal.t.i(encoder, "encoder");
        int iE = e(collection);
        SerialDescriptor descriptor = getDescriptor();
        ca.d dVarI = encoder.i(descriptor, iE);
        Iterator<Element> itD = d(collection);
        for (int i10 = 0; i10 < iE; i10++) {
            dVarI.j(getDescriptor(), i10, this.f24616a, itD.next());
        }
        dVarI.c(descriptor);
    }

    private r(KSerializer<Element> kSerializer) {
        super(null);
        this.f24616a = kSerializer;
    }
}
