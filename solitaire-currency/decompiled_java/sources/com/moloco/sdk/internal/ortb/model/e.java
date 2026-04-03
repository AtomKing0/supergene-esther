package com.moloco.sdk.internal.ortb.model;

import androidx.compose.runtime.internal.StabilityInferred;
import com.moloco.sdk.internal.ortb.model.r;
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
public final class e {

    @NotNull
    public static final b Companion = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final KSerializer<Object>[] f17699b = {new da.f(r.a.f17791a)};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final List<r> f17700a;

    @StabilityInferred(parameters = 0)
    public static final class a implements d0<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f17701a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ PluginGeneratedSerialDescriptor f17702b;

        static {
            a aVar = new a();
            f17701a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.BidResponse", aVar, 1);
            pluginGeneratedSerialDescriptor.k("seatbid", false);
            f17702b = pluginGeneratedSerialDescriptor;
        }

        @Override // z9.b
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e deserialize(@NotNull Decoder decoder) {
            Object objY;
            kotlin.jvm.internal.t.i(decoder, "decoder");
            SerialDescriptor descriptor = getDescriptor();
            ca.c cVarB = decoder.b(descriptor);
            KSerializer[] kSerializerArr = e.f17699b;
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
            return new e(i10, (List) objY, s1Var);
        }

        @Override // z9.j
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void serialize(@NotNull Encoder encoder, @NotNull e value) {
            kotlin.jvm.internal.t.i(encoder, "encoder");
            kotlin.jvm.internal.t.i(value, "value");
            SerialDescriptor descriptor = getDescriptor();
            ca.d dVarB = encoder.b(descriptor);
            e.a(value, dVarB, descriptor);
            dVarB.c(descriptor);
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] childSerializers() {
            return new KSerializer[]{e.f17699b[0]};
        }

        @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
        @NotNull
        public SerialDescriptor getDescriptor() {
            return f17702b;
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
        public final KSerializer<e> serializer() {
            return a.f17701a;
        }

        public b() {
        }
    }

    public /* synthetic */ e(int i10, List list, s1 s1Var) {
        if (1 != (i10 & 1)) {
            i1.a(i10, 1, a.f17701a.getDescriptor());
        }
        this.f17700a = list;
    }

    public static final /* synthetic */ void a(e eVar, ca.d dVar, SerialDescriptor serialDescriptor) {
        dVar.j(serialDescriptor, 0, f17699b[0], eVar.f17700a);
    }

    @NotNull
    public final List<r> c() {
        return this.f17700a;
    }

    public e(@NotNull List<r> seatBid) {
        kotlin.jvm.internal.t.i(seatBid, "seatBid");
        this.f17700a = seatBid;
    }
}
