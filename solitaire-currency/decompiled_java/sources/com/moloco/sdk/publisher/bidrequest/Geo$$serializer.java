package com.moloco.sdk.publisher.bidrequest;

import aa.a;
import androidx.compose.runtime.internal.StabilityInferred;
import ca.c;
import ca.d;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import da.c0;
import da.d0;
import da.w1;
import io.sentry.protocol.Geo;
import kotlin.jvm.internal.t;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import org.jetbrains.annotations.NotNull;
import z9.o;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class Geo$$serializer implements d0<Geo> {
    public static final int $stable = 0;

    @NotNull
    public static final Geo$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        Geo$$serializer geo$$serializer = new Geo$$serializer();
        INSTANCE = geo$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.publisher.bidrequest.Geo", geo$$serializer, 6);
        pluginGeneratedSerialDescriptor.k(Geo.JsonKeys.CITY, false);
        pluginGeneratedSerialDescriptor.k(ImpressionData.IMPRESSION_DATA_KEY_COUNTRY, false);
        pluginGeneratedSerialDescriptor.k("region", false);
        pluginGeneratedSerialDescriptor.k("zipCode", false);
        pluginGeneratedSerialDescriptor.k("latitude", false);
        pluginGeneratedSerialDescriptor.k("longitude", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private Geo$$serializer() {
    }

    @Override // da.d0
    @NotNull
    public KSerializer<?>[] childSerializers() {
        w1 w1Var = w1.f24648a;
        c0 c0Var = c0.f24548a;
        return new KSerializer[]{a.s(w1Var), a.s(w1Var), a.s(w1Var), a.s(w1Var), a.s(c0Var), a.s(c0Var)};
    }

    @Override // z9.b
    @NotNull
    public Geo deserialize(@NotNull Decoder decoder) {
        Object objK;
        int i10;
        Object objK2;
        Object objK3;
        Object objK4;
        Object objK5;
        Object objK6;
        t.i(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        int i11 = 5;
        Object objK7 = null;
        if (cVarB.p()) {
            w1 w1Var = w1.f24648a;
            objK2 = cVarB.k(descriptor2, 0, w1Var, null);
            objK3 = cVarB.k(descriptor2, 1, w1Var, null);
            objK4 = cVarB.k(descriptor2, 2, w1Var, null);
            objK5 = cVarB.k(descriptor2, 3, w1Var, null);
            c0 c0Var = c0.f24548a;
            Object objK8 = cVarB.k(descriptor2, 4, c0Var, null);
            objK6 = cVarB.k(descriptor2, 5, c0Var, null);
            objK = objK8;
            i10 = 63;
        } else {
            boolean z10 = true;
            int i12 = 0;
            Object objK9 = null;
            Object objK10 = null;
            Object objK11 = null;
            objK = null;
            Object objK12 = null;
            while (z10) {
                int iO = cVarB.o(descriptor2);
                switch (iO) {
                    case -1:
                        z10 = false;
                        i11 = 5;
                        break;
                    case 0:
                        objK7 = cVarB.k(descriptor2, 0, w1.f24648a, objK7);
                        i12 |= 1;
                        i11 = 5;
                        break;
                    case 1:
                        objK9 = cVarB.k(descriptor2, 1, w1.f24648a, objK9);
                        i12 |= 2;
                        break;
                    case 2:
                        objK10 = cVarB.k(descriptor2, 2, w1.f24648a, objK10);
                        i12 |= 4;
                        break;
                    case 3:
                        objK11 = cVarB.k(descriptor2, 3, w1.f24648a, objK11);
                        i12 |= 8;
                        break;
                    case 4:
                        objK = cVarB.k(descriptor2, 4, c0.f24548a, objK);
                        i12 |= 16;
                        break;
                    case 5:
                        objK12 = cVarB.k(descriptor2, i11, c0.f24548a, objK12);
                        i12 |= 32;
                        break;
                    default:
                        throw new o(iO);
                }
            }
            i10 = i12;
            objK2 = objK7;
            objK3 = objK9;
            objK4 = objK10;
            objK5 = objK11;
            objK6 = objK12;
        }
        cVarB.c(descriptor2);
        return new Geo(i10, (String) objK2, (String) objK3, (String) objK4, (String) objK5, (Float) objK, (Float) objK6, null);
    }

    @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
    @NotNull
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // z9.j
    public void serialize(@NotNull Encoder encoder, @NotNull Geo value) {
        t.i(encoder, "encoder");
        t.i(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        Geo.write$Self(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // da.d0
    @NotNull
    public KSerializer<?>[] typeParametersSerializers() {
        return d0.a.a(this);
    }
}
