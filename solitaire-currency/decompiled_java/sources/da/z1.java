package da;

import ca.c;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Tuples.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class z1<A, B, C> implements KSerializer<v8.x<? extends A, ? extends B, ? extends C>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final KSerializer<A> f24674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final KSerializer<B> f24675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final KSerializer<C> f24676c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final SerialDescriptor f24677d;

    /* JADX INFO: compiled from: Tuples.kt */
    static final class a extends kotlin.jvm.internal.v implements h9.l<ba.a, v8.k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ z1<A, B, C> f24678g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(z1<A, B, C> z1Var) {
            super(1);
            this.f24678g = z1Var;
        }

        public final void a(@NotNull ba.a buildClassSerialDescriptor) {
            kotlin.jvm.internal.t.i(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
            ba.a.b(buildClassSerialDescriptor, "first", ((z1) this.f24678g).f24674a.getDescriptor(), null, false, 12, null);
            ba.a.b(buildClassSerialDescriptor, "second", ((z1) this.f24678g).f24675b.getDescriptor(), null, false, 12, null);
            ba.a.b(buildClassSerialDescriptor, "third", ((z1) this.f24678g).f24676c.getDescriptor(), null, false, 12, null);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ v8.k0 invoke(ba.a aVar) {
            a(aVar);
            return v8.k0.f35197a;
        }
    }

    public z1(@NotNull KSerializer<A> aSerializer, @NotNull KSerializer<B> bSerializer, @NotNull KSerializer<C> cSerializer) {
        kotlin.jvm.internal.t.i(aSerializer, "aSerializer");
        kotlin.jvm.internal.t.i(bSerializer, "bSerializer");
        kotlin.jvm.internal.t.i(cSerializer, "cSerializer");
        this.f24674a = aSerializer;
        this.f24675b = bSerializer;
        this.f24676c = cSerializer;
        this.f24677d = ba.h.b("kotlin.Triple", new SerialDescriptor[0], new a(this));
    }

    private final v8.x<A, B, C> d(ca.c cVar) {
        Object objC = c.a.c(cVar, getDescriptor(), 0, this.f24674a, null, 8, null);
        Object objC2 = c.a.c(cVar, getDescriptor(), 1, this.f24675b, null, 8, null);
        Object objC3 = c.a.c(cVar, getDescriptor(), 2, this.f24676c, null, 8, null);
        cVar.c(getDescriptor());
        return new v8.x<>(objC, objC2, objC3);
    }

    private final v8.x<A, B, C> e(ca.c cVar) {
        Object objC = a2.f24541a;
        Object objC2 = a2.f24541a;
        Object objC3 = a2.f24541a;
        while (true) {
            int iO = cVar.o(getDescriptor());
            if (iO == -1) {
                cVar.c(getDescriptor());
                if (objC == a2.f24541a) {
                    throw new z9.i("Element 'first' is missing");
                }
                if (objC2 == a2.f24541a) {
                    throw new z9.i("Element 'second' is missing");
                }
                if (objC3 != a2.f24541a) {
                    return new v8.x<>(objC, objC2, objC3);
                }
                throw new z9.i("Element 'third' is missing");
            }
            if (iO == 0) {
                objC = c.a.c(cVar, getDescriptor(), 0, this.f24674a, null, 8, null);
            } else if (iO == 1) {
                objC2 = c.a.c(cVar, getDescriptor(), 1, this.f24675b, null, 8, null);
            } else {
                if (iO != 2) {
                    throw new z9.i("Unexpected index " + iO);
                }
                objC3 = c.a.c(cVar, getDescriptor(), 2, this.f24676c, null, 8, null);
            }
        }
    }

    @Override // z9.b
    @NotNull
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public v8.x<A, B, C> deserialize(@NotNull Decoder decoder) {
        kotlin.jvm.internal.t.i(decoder, "decoder");
        ca.c cVarB = decoder.b(getDescriptor());
        return cVarB.p() ? d(cVarB) : e(cVarB);
    }

    @Override // z9.j
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void serialize(@NotNull Encoder encoder, @NotNull v8.x<? extends A, ? extends B, ? extends C> value) {
        kotlin.jvm.internal.t.i(encoder, "encoder");
        kotlin.jvm.internal.t.i(value, "value");
        ca.d dVarB = encoder.b(getDescriptor());
        dVarB.j(getDescriptor(), 0, this.f24674a, value.d());
        dVarB.j(getDescriptor(), 1, this.f24675b, value.e());
        dVarB.j(getDescriptor(), 2, this.f24676c, value.f());
        dVarB.c(getDescriptor());
    }

    @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
    @NotNull
    public SerialDescriptor getDescriptor() {
        return this.f24677d;
    }
}
