package o7;

import da.d0;
import da.i1;
import da.l0;
import da.s1;
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

/* JADX INFO: compiled from: Demographic.kt */
/* JADX INFO: loaded from: classes4.dex */
@z9.h
public final class b {

    @NotNull
    public static final C0642b Companion = new C0642b(null);

    @Nullable
    private Integer ageRange;

    @Nullable
    private Integer lengthOfResidence;

    @Nullable
    private Integer medianHomeValueUSD;

    @Nullable
    private Integer monthlyHousingPaymentUSD;

    /* JADX INFO: compiled from: Demographic.kt */
    public static final class a implements d0<b> {

        @NotNull
        public static final a INSTANCE;
        public static final /* synthetic */ SerialDescriptor descriptor;

        static {
            a aVar = new a();
            INSTANCE = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.fpd.Demographic", aVar, 4);
            pluginGeneratedSerialDescriptor.k("age_range", true);
            pluginGeneratedSerialDescriptor.k("length_of_residence", true);
            pluginGeneratedSerialDescriptor.k("median_home_value_usd", true);
            pluginGeneratedSerialDescriptor.k("monthly_housing_payment_usd", true);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        private a() {
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] childSerializers() {
            l0 l0Var = l0.f24594a;
            return new KSerializer[]{aa.a.s(l0Var), aa.a.s(l0Var), aa.a.s(l0Var), aa.a.s(l0Var)};
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
        public b deserialize(@NotNull Decoder decoder) {
            Object objK;
            int i10;
            Object objK2;
            Object objK3;
            Object objK4;
            t.i(decoder, "decoder");
            SerialDescriptor descriptor2 = getDescriptor();
            ca.c cVarB = decoder.b(descriptor2);
            Object objK5 = null;
            if (cVarB.p()) {
                l0 l0Var = l0.f24594a;
                objK2 = cVarB.k(descriptor2, 0, l0Var, null);
                objK3 = cVarB.k(descriptor2, 1, l0Var, null);
                Object objK6 = cVarB.k(descriptor2, 2, l0Var, null);
                objK4 = cVarB.k(descriptor2, 3, l0Var, null);
                objK = objK6;
                i10 = 15;
            } else {
                boolean z10 = true;
                int i11 = 0;
                Object objK7 = null;
                objK = null;
                Object objK8 = null;
                while (z10) {
                    int iO = cVarB.o(descriptor2);
                    if (iO == -1) {
                        z10 = false;
                    } else if (iO == 0) {
                        objK5 = cVarB.k(descriptor2, 0, l0.f24594a, objK5);
                        i11 |= 1;
                    } else if (iO == 1) {
                        objK7 = cVarB.k(descriptor2, 1, l0.f24594a, objK7);
                        i11 |= 2;
                    } else if (iO == 2) {
                        objK = cVarB.k(descriptor2, 2, l0.f24594a, objK);
                        i11 |= 4;
                    } else {
                        if (iO != 3) {
                            throw new o(iO);
                        }
                        objK8 = cVarB.k(descriptor2, 3, l0.f24594a, objK8);
                        i11 |= 8;
                    }
                }
                i10 = i11;
                objK2 = objK5;
                objK3 = objK7;
                objK4 = objK8;
            }
            cVarB.c(descriptor2);
            return new b(i10, (Integer) objK2, (Integer) objK3, (Integer) objK, (Integer) objK4, null);
        }

        @Override // z9.j
        public void serialize(@NotNull Encoder encoder, @NotNull b value) {
            t.i(encoder, "encoder");
            t.i(value, "value");
            SerialDescriptor descriptor2 = getDescriptor();
            ca.d dVarB = encoder.b(descriptor2);
            b.write$Self(value, dVarB, descriptor2);
            dVarB.c(descriptor2);
        }
    }

    /* JADX INFO: renamed from: o7.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Demographic.kt */
    public static final class C0642b {
        private C0642b() {
        }

        public /* synthetic */ C0642b(k kVar) {
            this();
        }

        @NotNull
        public final KSerializer<b> serializer() {
            return a.INSTANCE;
        }
    }

    public b() {
    }

    public static final void write$Self(@NotNull b self, @NotNull ca.d output, @NotNull SerialDescriptor serialDesc) {
        t.i(self, "self");
        t.i(output, "output");
        t.i(serialDesc, "serialDesc");
        if (output.z(serialDesc, 0) || self.ageRange != null) {
            output.h(serialDesc, 0, l0.f24594a, self.ageRange);
        }
        if (output.z(serialDesc, 1) || self.lengthOfResidence != null) {
            output.h(serialDesc, 1, l0.f24594a, self.lengthOfResidence);
        }
        if (output.z(serialDesc, 2) || self.medianHomeValueUSD != null) {
            output.h(serialDesc, 2, l0.f24594a, self.medianHomeValueUSD);
        }
        if (output.z(serialDesc, 3) || self.monthlyHousingPaymentUSD != null) {
            output.h(serialDesc, 3, l0.f24594a, self.monthlyHousingPaymentUSD);
        }
    }

    @NotNull
    public final b setAgeRange(int i10) {
        this.ageRange = Integer.valueOf(o7.a.Companion.fromAge$vungle_ads_release(i10).getId());
        return this;
    }

    @NotNull
    public final b setLengthOfResidence(int i10) {
        this.lengthOfResidence = Integer.valueOf(d.Companion.fromYears$vungle_ads_release(i10).getId());
        return this;
    }

    @NotNull
    public final b setMedianHomeValueUSD(int i10) {
        this.medianHomeValueUSD = Integer.valueOf(f.Companion.fromPrice$vungle_ads_release(i10).getId());
        return this;
    }

    @NotNull
    public final b setMonthlyHousingCosts(int i10) {
        this.monthlyHousingPaymentUSD = Integer.valueOf(g.Companion.fromCost$vungle_ads_release(i10).getId());
        return this;
    }

    public /* synthetic */ b(int i10, Integer num, Integer num2, Integer num3, Integer num4, s1 s1Var) {
        if ((i10 & 0) != 0) {
            i1.a(i10, 0, a.INSTANCE.getDescriptor());
        }
        if ((i10 & 1) == 0) {
            this.ageRange = null;
        } else {
            this.ageRange = num;
        }
        if ((i10 & 2) == 0) {
            this.lengthOfResidence = null;
        } else {
            this.lengthOfResidence = num2;
        }
        if ((i10 & 4) == 0) {
            this.medianHomeValueUSD = null;
        } else {
            this.medianHomeValueUSD = num3;
        }
        if ((i10 & 8) == 0) {
            this.monthlyHousingPaymentUSD = null;
        } else {
            this.monthlyHousingPaymentUSD = num4;
        }
    }

    private static /* synthetic */ void getAgeRange$annotations() {
    }

    private static /* synthetic */ void getLengthOfResidence$annotations() {
    }

    private static /* synthetic */ void getMedianHomeValueUSD$annotations() {
    }

    private static /* synthetic */ void getMonthlyHousingPaymentUSD$annotations() {
    }
}
