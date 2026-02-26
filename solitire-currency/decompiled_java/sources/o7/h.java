package o7;

import com.vungle.ads.internal.util.r;
import da.c0;
import da.d0;
import da.i1;
import da.s1;
import da.w1;
import java.util.List;
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

/* JADX INFO: compiled from: Revenue.kt */
/* JADX INFO: loaded from: classes4.dex */
@z9.h
public final class h {

    @NotNull
    public static final b Companion = new b(null);

    @Nullable
    private Float earningsByPlacementUSD;

    @Nullable
    private Boolean isUserAPurchaser;

    @Nullable
    private Boolean isUserASubscriber;

    @Nullable
    private Float last30DaysMeanSpendUSD;

    @Nullable
    private Float last30DaysMedianSpendUSD;

    @Nullable
    private Float last30DaysPlacementFillRate;

    @Nullable
    private Float last30DaysTotalSpendUSD;

    @Nullable
    private Float last30DaysUserLtvUSD;

    @Nullable
    private Float last30DaysUserPltvUSD;

    @Nullable
    private Float last7DaysMeanSpendUSD;

    @Nullable
    private Float last7DaysMedianSpendUSD;

    @Nullable
    private Float last7DaysPlacementFillRate;

    @Nullable
    private Float last7DaysTotalSpendUSD;

    @Nullable
    private Float last7DaysUserLtvUSD;

    @Nullable
    private Float last7DaysUserPltvUSD;

    @Nullable
    private List<String> topNAdomain;

    @Nullable
    private Float totalEarningsUSD;

    /* JADX INFO: compiled from: Revenue.kt */
    public static final class a implements d0<h> {

        @NotNull
        public static final a INSTANCE;
        public static final /* synthetic */ SerialDescriptor descriptor;

        static {
            a aVar = new a();
            INSTANCE = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.fpd.Revenue", aVar, 17);
            pluginGeneratedSerialDescriptor.k("total_earnings_usd", true);
            pluginGeneratedSerialDescriptor.k("earnings_by_placement_usd", true);
            pluginGeneratedSerialDescriptor.k("top_n_adomain", true);
            pluginGeneratedSerialDescriptor.k("is_user_a_purchaser", true);
            pluginGeneratedSerialDescriptor.k("is_user_a_subscriber", true);
            pluginGeneratedSerialDescriptor.k("last_7_days_total_spend_usd", true);
            pluginGeneratedSerialDescriptor.k("last_7_days_median_spend_usd", true);
            pluginGeneratedSerialDescriptor.k("last_7_days_mean_spend_usd", true);
            pluginGeneratedSerialDescriptor.k("last_30_days_total_spend_usd", true);
            pluginGeneratedSerialDescriptor.k("last_30_days_median_spend_usd", true);
            pluginGeneratedSerialDescriptor.k("last_30_days_mean_spend_usd", true);
            pluginGeneratedSerialDescriptor.k("last_7_days_user_pltv_usd", true);
            pluginGeneratedSerialDescriptor.k("last_7_days_user_ltv_usd", true);
            pluginGeneratedSerialDescriptor.k("last_30_days_user_pltv_usd", true);
            pluginGeneratedSerialDescriptor.k("last_30_days_user_ltv_usd", true);
            pluginGeneratedSerialDescriptor.k("last_7_days_placement_fill_rate", true);
            pluginGeneratedSerialDescriptor.k("last_30_days_placement_fill_rate", true);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        private a() {
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] childSerializers() {
            c0 c0Var = c0.f24548a;
            da.h hVar = da.h.f24574a;
            return new KSerializer[]{aa.a.s(c0Var), aa.a.s(c0Var), aa.a.s(new da.f(w1.f24648a)), aa.a.s(hVar), aa.a.s(hVar), aa.a.s(c0Var), aa.a.s(c0Var), aa.a.s(c0Var), aa.a.s(c0Var), aa.a.s(c0Var), aa.a.s(c0Var), aa.a.s(c0Var), aa.a.s(c0Var), aa.a.s(c0Var), aa.a.s(c0Var), aa.a.s(c0Var), aa.a.s(c0Var)};
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
        public h deserialize(@NotNull Decoder decoder) {
            Object objK;
            Object obj;
            int i10;
            Object objK2;
            Object obj2;
            Object obj3;
            Object obj4;
            Object objK3;
            Object objK4;
            Object objK5;
            Object objK6;
            Object objK7;
            Object objK8;
            Object objK9;
            Object objK10;
            Object objK11;
            Object objK12;
            Object objK13;
            Object obj5;
            Object obj6;
            Object objK14;
            Object obj7;
            Object obj8;
            Object obj9;
            t.i(decoder, "decoder");
            SerialDescriptor descriptor2 = getDescriptor();
            ca.c cVarB = decoder.b(descriptor2);
            if (cVarB.p()) {
                c0 c0Var = c0.f24548a;
                Object objK15 = cVarB.k(descriptor2, 0, c0Var, null);
                Object objK16 = cVarB.k(descriptor2, 1, c0Var, null);
                Object objK17 = cVarB.k(descriptor2, 2, new da.f(w1.f24648a), null);
                da.h hVar = da.h.f24574a;
                Object objK18 = cVarB.k(descriptor2, 3, hVar, null);
                objK6 = cVarB.k(descriptor2, 4, hVar, null);
                objK10 = cVarB.k(descriptor2, 5, c0Var, null);
                objK12 = cVarB.k(descriptor2, 6, c0Var, null);
                objK9 = cVarB.k(descriptor2, 7, c0Var, null);
                objK11 = cVarB.k(descriptor2, 8, c0Var, null);
                objK8 = cVarB.k(descriptor2, 9, c0Var, null);
                objK13 = cVarB.k(descriptor2, 10, c0Var, null);
                objK7 = cVarB.k(descriptor2, 11, c0Var, null);
                objK5 = cVarB.k(descriptor2, 12, c0Var, null);
                objK4 = cVarB.k(descriptor2, 13, c0Var, null);
                objK3 = cVarB.k(descriptor2, 14, c0Var, null);
                Object objK19 = cVarB.k(descriptor2, 15, c0Var, null);
                objK2 = cVarB.k(descriptor2, 16, c0Var, null);
                i10 = 131071;
                obj3 = objK18;
                obj = objK15;
                objK = objK16;
                obj4 = objK19;
                obj2 = objK17;
            } else {
                boolean z10 = true;
                Object objK20 = null;
                Object objK21 = null;
                Object objK22 = null;
                objK = null;
                Object objK23 = null;
                Object objK24 = null;
                Object objK25 = null;
                Object objK26 = null;
                Object objK27 = null;
                Object objK28 = null;
                Object objK29 = null;
                Object objK30 = null;
                Object objK31 = null;
                Object objK32 = null;
                Object objK33 = null;
                Object obj10 = null;
                int i11 = 0;
                Object objK34 = null;
                while (z10) {
                    int iO = cVarB.o(descriptor2);
                    switch (iO) {
                        case -1:
                            obj5 = objK34;
                            obj6 = objK22;
                            objK14 = obj10;
                            obj7 = objK20;
                            z10 = false;
                            objK22 = obj6;
                            objK20 = obj7;
                            obj10 = objK14;
                            objK34 = obj5;
                            break;
                        case 0:
                            obj5 = objK34;
                            obj6 = objK22;
                            Object obj11 = obj10;
                            obj7 = objK20;
                            objK14 = cVarB.k(descriptor2, 0, c0.f24548a, obj11);
                            i11 |= 1;
                            objK22 = obj6;
                            objK20 = obj7;
                            obj10 = objK14;
                            objK34 = obj5;
                            break;
                        case 1:
                            objK = cVarB.k(descriptor2, 1, c0.f24548a, objK);
                            i11 |= 2;
                            objK22 = objK22;
                            objK34 = objK34;
                            break;
                        case 2:
                            obj8 = objK22;
                            obj9 = objK;
                            objK34 = cVarB.k(descriptor2, 2, new da.f(w1.f24648a), objK34);
                            i11 |= 4;
                            objK22 = obj8;
                            objK = obj9;
                            break;
                        case 3:
                            obj8 = objK22;
                            obj9 = objK;
                            objK21 = cVarB.k(descriptor2, 3, da.h.f24574a, objK21);
                            i11 |= 8;
                            objK22 = obj8;
                            objK = obj9;
                            break;
                        case 4:
                            obj8 = objK22;
                            obj9 = objK;
                            objK20 = cVarB.k(descriptor2, 4, da.h.f24574a, objK20);
                            i11 |= 16;
                            objK22 = obj8;
                            objK = obj9;
                            break;
                        case 5:
                            obj8 = objK22;
                            obj9 = objK;
                            objK27 = cVarB.k(descriptor2, 5, c0.f24548a, objK27);
                            i11 |= 32;
                            objK22 = obj8;
                            objK = obj9;
                            break;
                        case 6:
                            obj8 = objK22;
                            obj9 = objK;
                            objK28 = cVarB.k(descriptor2, 6, c0.f24548a, objK28);
                            i11 |= 64;
                            objK22 = obj8;
                            objK = obj9;
                            break;
                        case 7:
                            obj8 = objK22;
                            obj9 = objK;
                            objK26 = cVarB.k(descriptor2, 7, c0.f24548a, objK26);
                            i11 |= 128;
                            objK22 = obj8;
                            objK = obj9;
                            break;
                        case 8:
                            obj8 = objK22;
                            obj9 = objK;
                            objK25 = cVarB.k(descriptor2, 8, c0.f24548a, objK25);
                            i11 |= 256;
                            objK22 = obj8;
                            objK = obj9;
                            break;
                        case 9:
                            obj8 = objK22;
                            obj9 = objK;
                            objK24 = cVarB.k(descriptor2, 9, c0.f24548a, objK24);
                            i11 |= 512;
                            objK22 = obj8;
                            objK = obj9;
                            break;
                        case 10:
                            obj8 = objK22;
                            obj9 = objK;
                            objK29 = cVarB.k(descriptor2, 10, c0.f24548a, objK29);
                            i11 |= 1024;
                            objK22 = obj8;
                            objK = obj9;
                            break;
                        case 11:
                            obj8 = objK22;
                            obj9 = objK;
                            objK23 = cVarB.k(descriptor2, 11, c0.f24548a, objK23);
                            i11 |= 2048;
                            objK22 = obj8;
                            objK = obj9;
                            break;
                        case 12:
                            obj9 = objK;
                            objK30 = cVarB.k(descriptor2, 12, c0.f24548a, objK30);
                            i11 |= 4096;
                            objK22 = objK22;
                            objK31 = objK31;
                            objK = obj9;
                            break;
                        case 13:
                            obj9 = objK;
                            objK31 = cVarB.k(descriptor2, 13, c0.f24548a, objK31);
                            i11 |= 8192;
                            objK22 = objK22;
                            objK32 = objK32;
                            objK = obj9;
                            break;
                        case 14:
                            obj9 = objK;
                            objK32 = cVarB.k(descriptor2, 14, c0.f24548a, objK32);
                            i11 |= 16384;
                            objK22 = objK22;
                            objK33 = objK33;
                            objK = obj9;
                            break;
                        case 15:
                            obj9 = objK;
                            obj8 = objK22;
                            objK33 = cVarB.k(descriptor2, 15, c0.f24548a, objK33);
                            i11 |= 32768;
                            objK22 = obj8;
                            objK = obj9;
                            break;
                        case 16:
                            objK22 = cVarB.k(descriptor2, 16, c0.f24548a, objK22);
                            i11 |= 65536;
                            objK = objK;
                            break;
                        default:
                            throw new o(iO);
                    }
                }
                Object obj12 = objK34;
                Object obj13 = obj10;
                Object obj14 = objK20;
                obj = obj13;
                i10 = i11;
                objK2 = objK22;
                obj2 = obj12;
                obj3 = objK21;
                obj4 = objK33;
                objK3 = objK32;
                objK4 = objK31;
                objK5 = objK30;
                objK6 = obj14;
                Object obj15 = objK29;
                objK7 = objK23;
                objK8 = objK24;
                objK9 = objK26;
                objK10 = objK27;
                objK11 = objK25;
                objK12 = objK28;
                objK13 = obj15;
            }
            cVarB.c(descriptor2);
            return new h(i10, (Float) obj, (Float) objK, (List) obj2, (Boolean) obj3, (Boolean) objK6, (Float) objK10, (Float) objK12, (Float) objK9, (Float) objK11, (Float) objK8, (Float) objK13, (Float) objK7, (Float) objK5, (Float) objK4, (Float) objK3, (Float) obj4, (Float) objK2, null);
        }

        @Override // z9.j
        public void serialize(@NotNull Encoder encoder, @NotNull h value) {
            t.i(encoder, "encoder");
            t.i(value, "value");
            SerialDescriptor descriptor2 = getDescriptor();
            ca.d dVarB = encoder.b(descriptor2);
            h.write$Self(value, dVarB, descriptor2);
            dVarB.c(descriptor2);
        }
    }

    /* JADX INFO: compiled from: Revenue.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(k kVar) {
            this();
        }

        @NotNull
        public final KSerializer<h> serializer() {
            return a.INSTANCE;
        }
    }

    public h() {
    }

    public static final void write$Self(@NotNull h self, @NotNull ca.d output, @NotNull SerialDescriptor serialDesc) {
        t.i(self, "self");
        t.i(output, "output");
        t.i(serialDesc, "serialDesc");
        if (output.z(serialDesc, 0) || self.totalEarningsUSD != null) {
            output.h(serialDesc, 0, c0.f24548a, self.totalEarningsUSD);
        }
        if (output.z(serialDesc, 1) || self.earningsByPlacementUSD != null) {
            output.h(serialDesc, 1, c0.f24548a, self.earningsByPlacementUSD);
        }
        if (output.z(serialDesc, 2) || self.topNAdomain != null) {
            output.h(serialDesc, 2, new da.f(w1.f24648a), self.topNAdomain);
        }
        if (output.z(serialDesc, 3) || self.isUserAPurchaser != null) {
            output.h(serialDesc, 3, da.h.f24574a, self.isUserAPurchaser);
        }
        if (output.z(serialDesc, 4) || self.isUserASubscriber != null) {
            output.h(serialDesc, 4, da.h.f24574a, self.isUserASubscriber);
        }
        if (output.z(serialDesc, 5) || self.last7DaysTotalSpendUSD != null) {
            output.h(serialDesc, 5, c0.f24548a, self.last7DaysTotalSpendUSD);
        }
        if (output.z(serialDesc, 6) || self.last7DaysMedianSpendUSD != null) {
            output.h(serialDesc, 6, c0.f24548a, self.last7DaysMedianSpendUSD);
        }
        if (output.z(serialDesc, 7) || self.last7DaysMeanSpendUSD != null) {
            output.h(serialDesc, 7, c0.f24548a, self.last7DaysMeanSpendUSD);
        }
        if (output.z(serialDesc, 8) || self.last30DaysTotalSpendUSD != null) {
            output.h(serialDesc, 8, c0.f24548a, self.last30DaysTotalSpendUSD);
        }
        if (output.z(serialDesc, 9) || self.last30DaysMedianSpendUSD != null) {
            output.h(serialDesc, 9, c0.f24548a, self.last30DaysMedianSpendUSD);
        }
        if (output.z(serialDesc, 10) || self.last30DaysMeanSpendUSD != null) {
            output.h(serialDesc, 10, c0.f24548a, self.last30DaysMeanSpendUSD);
        }
        if (output.z(serialDesc, 11) || self.last7DaysUserPltvUSD != null) {
            output.h(serialDesc, 11, c0.f24548a, self.last7DaysUserPltvUSD);
        }
        if (output.z(serialDesc, 12) || self.last7DaysUserLtvUSD != null) {
            output.h(serialDesc, 12, c0.f24548a, self.last7DaysUserLtvUSD);
        }
        if (output.z(serialDesc, 13) || self.last30DaysUserPltvUSD != null) {
            output.h(serialDesc, 13, c0.f24548a, self.last30DaysUserPltvUSD);
        }
        if (output.z(serialDesc, 14) || self.last30DaysUserLtvUSD != null) {
            output.h(serialDesc, 14, c0.f24548a, self.last30DaysUserLtvUSD);
        }
        if (output.z(serialDesc, 15) || self.last7DaysPlacementFillRate != null) {
            output.h(serialDesc, 15, c0.f24548a, self.last7DaysPlacementFillRate);
        }
        if (output.z(serialDesc, 16) || self.last30DaysPlacementFillRate != null) {
            output.h(serialDesc, 16, c0.f24548a, self.last30DaysPlacementFillRate);
        }
    }

    @NotNull
    public final h setEarningsByPlacement(float f10) {
        if (r.isInRange$default(r.INSTANCE, f10, 0.0f, 0.0f, 4, (Object) null)) {
            this.earningsByPlacementUSD = Float.valueOf(f10);
        }
        return this;
    }

    @NotNull
    public final h setIsUserAPurchaser(boolean z10) {
        this.isUserAPurchaser = Boolean.valueOf(z10);
        return this;
    }

    @NotNull
    public final h setIsUserASubscriber(boolean z10) {
        this.isUserASubscriber = Boolean.valueOf(z10);
        return this;
    }

    @NotNull
    public final h setLast30DaysMeanSpendUsd(float f10) {
        if (r.isInRange$default(r.INSTANCE, f10, 0.0f, 0.0f, 4, (Object) null)) {
            this.last30DaysMeanSpendUSD = Float.valueOf(f10);
        }
        return this;
    }

    @NotNull
    public final h setLast30DaysMedianSpendUsd(float f10) {
        if (r.isInRange$default(r.INSTANCE, f10, 0.0f, 0.0f, 4, (Object) null)) {
            this.last30DaysMedianSpendUSD = Float.valueOf(f10);
        }
        return this;
    }

    @NotNull
    public final h setLast30DaysPlacementFillRate(float f10) {
        if (r.INSTANCE.isInRange(f10, 0.0f, 100.0f)) {
            this.last30DaysPlacementFillRate = Float.valueOf(f10);
        }
        return this;
    }

    @NotNull
    public final h setLast30DaysTotalSpendUsd(float f10) {
        if (r.isInRange$default(r.INSTANCE, f10, 0.0f, 0.0f, 4, (Object) null)) {
            this.last30DaysTotalSpendUSD = Float.valueOf(f10);
        }
        return this;
    }

    @NotNull
    public final h setLast30DaysUserLtvUsd(float f10) {
        if (r.isInRange$default(r.INSTANCE, f10, 0.0f, 0.0f, 4, (Object) null)) {
            this.last30DaysUserLtvUSD = Float.valueOf(f10);
        }
        return this;
    }

    @NotNull
    public final h setLast30DaysUserPltvUsd(float f10) {
        if (r.isInRange$default(r.INSTANCE, f10, 0.0f, 0.0f, 4, (Object) null)) {
            this.last30DaysUserPltvUSD = Float.valueOf(f10);
        }
        return this;
    }

    @NotNull
    public final h setLast7DaysMeanSpendUsd(float f10) {
        if (r.isInRange$default(r.INSTANCE, f10, 0.0f, 0.0f, 4, (Object) null)) {
            this.last7DaysMeanSpendUSD = Float.valueOf(f10);
        }
        return this;
    }

    @NotNull
    public final h setLast7DaysMedianSpendUsd(float f10) {
        if (r.isInRange$default(r.INSTANCE, f10, 0.0f, 0.0f, 4, (Object) null)) {
            this.last7DaysMedianSpendUSD = Float.valueOf(f10);
        }
        return this;
    }

    @NotNull
    public final h setLast7DaysPlacementFillRate(float f10) {
        if (r.INSTANCE.isInRange(f10, 0.0f, 100.0f)) {
            this.last7DaysPlacementFillRate = Float.valueOf(f10);
        }
        return this;
    }

    @NotNull
    public final h setLast7DaysTotalSpendUsd(float f10) {
        if (r.isInRange$default(r.INSTANCE, f10, 0.0f, 0.0f, 4, (Object) null)) {
            this.last7DaysTotalSpendUSD = Float.valueOf(f10);
        }
        return this;
    }

    @NotNull
    public final h setLast7DaysUserLtvUsd(float f10) {
        if (r.isInRange$default(r.INSTANCE, f10, 0.0f, 0.0f, 4, (Object) null)) {
            this.last7DaysUserLtvUSD = Float.valueOf(f10);
        }
        return this;
    }

    @NotNull
    public final h setLast7DaysUserPltvUsd(float f10) {
        if (r.isInRange$default(r.INSTANCE, f10, 0.0f, 0.0f, 4, (Object) null)) {
            this.last7DaysUserPltvUSD = Float.valueOf(f10);
        }
        return this;
    }

    @NotNull
    public final h setTopNAdomain(@Nullable List<String> list) {
        this.topNAdomain = list != null ? kotlin.collections.d0.R0(list) : null;
        return this;
    }

    @NotNull
    public final h setTotalEarningsUsd(float f10) {
        if (r.isInRange$default(r.INSTANCE, f10, 0.0f, 0.0f, 4, (Object) null)) {
            this.totalEarningsUSD = Float.valueOf(f10);
        }
        return this;
    }

    public /* synthetic */ h(int i10, Float f10, Float f11, List list, Boolean bool, Boolean bool2, Float f12, Float f13, Float f14, Float f15, Float f16, Float f17, Float f18, Float f19, Float f20, Float f21, Float f22, Float f23, s1 s1Var) {
        if ((i10 & 0) != 0) {
            i1.a(i10, 0, a.INSTANCE.getDescriptor());
        }
        if ((i10 & 1) == 0) {
            this.totalEarningsUSD = null;
        } else {
            this.totalEarningsUSD = f10;
        }
        if ((i10 & 2) == 0) {
            this.earningsByPlacementUSD = null;
        } else {
            this.earningsByPlacementUSD = f11;
        }
        if ((i10 & 4) == 0) {
            this.topNAdomain = null;
        } else {
            this.topNAdomain = list;
        }
        if ((i10 & 8) == 0) {
            this.isUserAPurchaser = null;
        } else {
            this.isUserAPurchaser = bool;
        }
        if ((i10 & 16) == 0) {
            this.isUserASubscriber = null;
        } else {
            this.isUserASubscriber = bool2;
        }
        if ((i10 & 32) == 0) {
            this.last7DaysTotalSpendUSD = null;
        } else {
            this.last7DaysTotalSpendUSD = f12;
        }
        if ((i10 & 64) == 0) {
            this.last7DaysMedianSpendUSD = null;
        } else {
            this.last7DaysMedianSpendUSD = f13;
        }
        if ((i10 & 128) == 0) {
            this.last7DaysMeanSpendUSD = null;
        } else {
            this.last7DaysMeanSpendUSD = f14;
        }
        if ((i10 & 256) == 0) {
            this.last30DaysTotalSpendUSD = null;
        } else {
            this.last30DaysTotalSpendUSD = f15;
        }
        if ((i10 & 512) == 0) {
            this.last30DaysMedianSpendUSD = null;
        } else {
            this.last30DaysMedianSpendUSD = f16;
        }
        if ((i10 & 1024) == 0) {
            this.last30DaysMeanSpendUSD = null;
        } else {
            this.last30DaysMeanSpendUSD = f17;
        }
        if ((i10 & 2048) == 0) {
            this.last7DaysUserPltvUSD = null;
        } else {
            this.last7DaysUserPltvUSD = f18;
        }
        if ((i10 & 4096) == 0) {
            this.last7DaysUserLtvUSD = null;
        } else {
            this.last7DaysUserLtvUSD = f19;
        }
        if ((i10 & 8192) == 0) {
            this.last30DaysUserPltvUSD = null;
        } else {
            this.last30DaysUserPltvUSD = f20;
        }
        if ((i10 & 16384) == 0) {
            this.last30DaysUserLtvUSD = null;
        } else {
            this.last30DaysUserLtvUSD = f21;
        }
        if ((32768 & i10) == 0) {
            this.last7DaysPlacementFillRate = null;
        } else {
            this.last7DaysPlacementFillRate = f22;
        }
        if ((i10 & 65536) == 0) {
            this.last30DaysPlacementFillRate = null;
        } else {
            this.last30DaysPlacementFillRate = f23;
        }
    }

    private static /* synthetic */ void getEarningsByPlacementUSD$annotations() {
    }

    private static /* synthetic */ void getLast30DaysMeanSpendUSD$annotations() {
    }

    private static /* synthetic */ void getLast30DaysMedianSpendUSD$annotations() {
    }

    private static /* synthetic */ void getLast30DaysPlacementFillRate$annotations() {
    }

    private static /* synthetic */ void getLast30DaysTotalSpendUSD$annotations() {
    }

    private static /* synthetic */ void getLast30DaysUserLtvUSD$annotations() {
    }

    private static /* synthetic */ void getLast30DaysUserPltvUSD$annotations() {
    }

    private static /* synthetic */ void getLast7DaysMeanSpendUSD$annotations() {
    }

    private static /* synthetic */ void getLast7DaysMedianSpendUSD$annotations() {
    }

    private static /* synthetic */ void getLast7DaysPlacementFillRate$annotations() {
    }

    private static /* synthetic */ void getLast7DaysTotalSpendUSD$annotations() {
    }

    private static /* synthetic */ void getLast7DaysUserLtvUSD$annotations() {
    }

    private static /* synthetic */ void getLast7DaysUserPltvUSD$annotations() {
    }

    private static /* synthetic */ void getTopNAdomain$annotations() {
    }

    private static /* synthetic */ void getTotalEarningsUSD$annotations() {
    }

    private static /* synthetic */ void isUserAPurchaser$annotations() {
    }

    private static /* synthetic */ void isUserASubscriber$annotations() {
    }
}
