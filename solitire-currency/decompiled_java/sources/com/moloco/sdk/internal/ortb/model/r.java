package com.moloco.sdk.internal.ortb.model;

import androidx.compose.runtime.internal.StabilityInferred;
import com.ironsource.ad;
import com.moloco.sdk.internal.ortb.model.c;
import da.d0;
import da.i1;
import da.s1;
import java.util.List;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@z9.h
public final class r {

    @NotNull
    public static final b Companion = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final KSerializer<Object>[] f17789b = {new da.f(c.a.f17691a)};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final List<c> f17790a;

    @StabilityInferred(parameters = 0)
    public static final class a implements d0<r> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f17791a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ PluginGeneratedSerialDescriptor f17792b;

        static {
            a aVar = new a();
            f17791a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.SeatBid", aVar, 1);
            pluginGeneratedSerialDescriptor.k(ad.f11233f, false);
            f17792b = pluginGeneratedSerialDescriptor;
        }

        @Override // z9.b
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public r deserialize(@NotNull Decoder decoder) {
            Object objY;
            kotlin.jvm.internal.t.i(decoder, "decoder");
            SerialDescriptor descriptor = getDescriptor();
            ca.c cVarB = decoder.b(descriptor);
            KSerializer[] kSerializerArr = r.f17789b;
            int i10 = 1;
            s1 s1Var = null;
            if (cVarB.p()) {
                objY = cVarB.y(descriptor, 0, kSerializerArr[0], null);
            } else {
                int i11 = 0;
                Object objY2 = null;
                while (i10 != 0) {
                    int iO = cVarB.o(descriptor);
                    if (iO == -1) {
                        i10 = 0;
                    } else {
                        if (iO != 0) {
                            throw new z9.o(iO);
                        }
                        objY2 = cVarB.y(descriptor, 0, kSerializerArr[0], objY2);
                        i11 |= 1;
                    }
                }
                objY = objY2;
                i10 = i11;
            }
            cVarB.c(descriptor);
            return new r(i10, (List) objY, s1Var);
        }

        @Override // z9.j
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void serialize(@NotNull Encoder encoder, @NotNull r value) {
            kotlin.jvm.internal.t.i(encoder, "encoder");
            kotlin.jvm.internal.t.i(value, "value");
            SerialDescriptor descriptor = getDescriptor();
            ca.d dVarB = encoder.b(descriptor);
            r.a(value, dVarB, descriptor);
            dVarB.c(descriptor);
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] childSerializers() {
            return new KSerializer[]{r.f17789b[0]};
        }

        @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
        @NotNull
        public SerialDescriptor getDescriptor() {
            return f17792b;
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }
    }

    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final KSerializer<r> serializer() {
            return a.f17791a;
        }

        public b() {
        }
    }

    public /* synthetic */ r(int i10, List list, s1 s1Var) {
        if (1 != (i10 & 1)) {
            i1.a(i10, 1, a.f17791a.getDescriptor());
        }
        this.f17790a = list;
    }

    public static final /* synthetic */ void a(r rVar, ca.d dVar, SerialDescriptor serialDescriptor) {
        dVar.j(serialDescriptor, 0, f17789b[0], rVar.f17790a);
    }

    @NotNull
    public final List<c> c() {
        return this.f17790a;
    }

    public r(@NotNull List<c> bid) {
        kotlin.jvm.internal.t.i(bid, "bid");
        this.f17790a = bid;
    }
}
