package o7;

import com.ironsource.mediationsdk.impressionData.ImpressionData;
import da.d0;
import da.i1;
import da.l0;
import da.s1;
import da.w1;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z9.o;

/* JADX INFO: compiled from: Location.kt */
/* JADX INFO: loaded from: classes4.dex */
@z9.h
public final class e {

    @NotNull
    public static final b Companion = new b(null);

    @Nullable
    private String country;

    @Nullable
    private Integer dma;

    @Nullable
    private String regionState;

    /* JADX INFO: compiled from: Location.kt */
    public static final class a implements d0<e> {

        @NotNull
        public static final a INSTANCE;
        public static final /* synthetic */ SerialDescriptor descriptor;

        static {
            a aVar = new a();
            INSTANCE = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.fpd.Location", aVar, 3);
            pluginGeneratedSerialDescriptor.k(ImpressionData.IMPRESSION_DATA_KEY_COUNTRY, true);
            pluginGeneratedSerialDescriptor.k("region_state", true);
            pluginGeneratedSerialDescriptor.k("dma", true);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        private a() {
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] childSerializers() {
            w1 w1Var = w1.f24648a;
            return new KSerializer[]{aa.a.s(w1Var), aa.a.s(w1Var), aa.a.s(l0.f24594a)};
        }

        @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
        @NotNull
        public SerialDescriptor getDescriptor() {
            return descriptor;
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        @Override // z9.b
        @NotNull
        public e deserialize(@NotNull Decoder decoder) {
            int i10;
            Object objK;
            Object objK2;
            t.i(decoder, "decoder");
            SerialDescriptor descriptor2 = getDescriptor();
            ca.c cVarB = decoder.b(descriptor2);
            Object objK3 = null;
            if (cVarB.p()) {
                w1 w1Var = w1.f24648a;
                Object objK4 = cVarB.k(descriptor2, 0, w1Var, null);
                objK = cVarB.k(descriptor2, 1, w1Var, null);
                objK2 = cVarB.k(descriptor2, 2, l0.f24594a, null);
                objK3 = objK4;
                i10 = 7;
            } else {
                boolean z10 = true;
                int i11 = 0;
                Object objK5 = null;
                Object objK6 = null;
                while (z10) {
                    int iO = cVarB.o(descriptor2);
                    if (iO == -1) {
                        z10 = false;
                    } else if (iO == 0) {
                        objK3 = cVarB.k(descriptor2, 0, w1.f24648a, objK3);
                        i11 |= 1;
                    } else if (iO == 1) {
                        objK5 = cVarB.k(descriptor2, 1, w1.f24648a, objK5);
                        i11 |= 2;
                    } else {
                        if (iO != 2) {
                            throw new o(iO);
                        }
                        objK6 = cVarB.k(descriptor2, 2, l0.f24594a, objK6);
                        i11 |= 4;
                    }
                }
                i10 = i11;
                objK = objK5;
                objK2 = objK6;
            }
            cVarB.c(descriptor2);
            return new e(i10, (String) objK3, (String) objK, (Integer) objK2, null);
        }

        @Override // z9.j
        public void serialize(@NotNull Encoder encoder, @NotNull e value) {
            t.i(encoder, "encoder");
            t.i(value, "value");
            SerialDescriptor descriptor2 = getDescriptor();
            ca.d dVarB = encoder.b(descriptor2);
            e.write$Self(value, dVarB, descriptor2);
            dVarB.c(descriptor2);
        }
    }

    /* JADX INFO: compiled from: Location.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(k kVar) {
            this();
        }

        @NotNull
        public final KSerializer<e> serializer() {
            return a.INSTANCE;
        }
    }

    public e() {
    }

    public static final void write$Self(@NotNull e self, @NotNull ca.d output, @NotNull SerialDescriptor serialDesc) {
        t.i(self, "self");
        t.i(output, "output");
        t.i(serialDesc, "serialDesc");
        if (output.z(serialDesc, 0) || self.country != null) {
            output.h(serialDesc, 0, w1.f24648a, self.country);
        }
        if (output.z(serialDesc, 1) || self.regionState != null) {
            output.h(serialDesc, 1, w1.f24648a, self.regionState);
        }
        if (output.z(serialDesc, 2) || self.dma != null) {
            output.h(serialDesc, 2, l0.f24594a, self.dma);
        }
    }

    @NotNull
    public final e setCountry(@NotNull String country) {
        t.i(country, "country");
        this.country = country;
        return this;
    }

    @NotNull
    public final e setDma(int i10) {
        this.dma = Integer.valueOf(i10);
        return this;
    }

    @NotNull
    public final e setRegionState(@NotNull String regionState) {
        t.i(regionState, "regionState");
        this.regionState = regionState;
        return this;
    }

    public /* synthetic */ e(int i10, String str, String str2, Integer num, s1 s1Var) {
        if ((i10 & 0) != 0) {
            i1.a(i10, 0, a.INSTANCE.getDescriptor());
        }
        if ((i10 & 1) == 0) {
            this.country = null;
        } else {
            this.country = str;
        }
        if ((i10 & 2) == 0) {
            this.regionState = null;
        } else {
            this.regionState = str2;
        }
        if ((i10 & 4) == 0) {
            this.dma = null;
        } else {
            this.dma = num;
        }
    }

    private static /* synthetic */ void getCountry$annotations() {
    }

    private static /* synthetic */ void getDma$annotations() {
    }

    private static /* synthetic */ void getRegionState$annotations() {
    }
}
