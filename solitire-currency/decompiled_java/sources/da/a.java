package da;

import java.util.Iterator;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.encoding.Decoder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CollectionSerializers.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a<Element, Collection, Builder> implements KSerializer<Collection> {
    public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
        this();
    }

    public static /* synthetic */ void i(a aVar, ca.c cVar, int i10, Object obj, boolean z10, int i11, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readElement");
        }
        if ((i11 & 8) != 0) {
            z10 = true;
        }
        aVar.h(cVar, i10, obj, z10);
    }

    private final int j(ca.c cVar, Builder builder) {
        int iL = cVar.l(getDescriptor());
        c(builder, iL);
        return iL;
    }

    protected abstract Builder a();

    protected abstract int b(Builder builder);

    protected abstract void c(Builder builder, int i10);

    @NotNull
    protected abstract Iterator<Element> d(Collection collection);

    @Override // z9.b
    public Collection deserialize(@NotNull Decoder decoder) {
        kotlin.jvm.internal.t.i(decoder, "decoder");
        return f(decoder, null);
    }

    protected abstract int e(Collection collection);

    public final Collection f(@NotNull Decoder decoder, @Nullable Collection collection) {
        Builder builderA;
        kotlin.jvm.internal.t.i(decoder, "decoder");
        if (collection == null || (builderA = k(collection)) == null) {
            builderA = a();
        }
        int iB = b(builderA);
        ca.c cVarB = decoder.b(getDescriptor());
        if (!cVarB.p()) {
            while (true) {
                int iO = cVarB.o(getDescriptor());
                if (iO == -1) {
                    break;
                }
                i(this, cVarB, iB + iO, builderA, false, 8, null);
            }
        } else {
            g(cVarB, builderA, iB, j(cVarB, builderA));
        }
        cVarB.c(getDescriptor());
        return l(builderA);
    }

    protected abstract void g(@NotNull ca.c cVar, Builder builder, int i10, int i11);

    protected abstract void h(@NotNull ca.c cVar, int i10, Builder builder, boolean z10);

    protected abstract Builder k(Collection collection);

    protected abstract Collection l(Builder builder);

    private a() {
    }
}
