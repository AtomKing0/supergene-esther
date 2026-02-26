package com.vungle.ads.internal.model;

import com.ironsource.jo;
import com.onetrust.otpublishers.headless.Public.OTVendorListMode;
import com.vungle.ads.internal.model.j;
import da.d0;
import da.i1;
import da.l0;
import da.s1;
import da.u0;
import da.w1;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.q0;
import kotlin.jvm.internal.t;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z9.o;

/* JADX INFO: compiled from: ConfigPayload.kt */
/* JADX INFO: loaded from: classes4.dex */
@z9.h
public final class g {

    @NotNull
    public static final d Companion = new d(null);

    @Nullable
    private b autoRedirect;

    @Nullable
    private final c cleverCache;

    @Nullable
    private final String configExtension;

    @Nullable
    private Long configLastValidatedTimestamp;

    @Nullable
    private final e configSettings;

    @Nullable
    private final Boolean disableAdId;

    @Nullable
    private final f endpoints;

    @Nullable
    private final Boolean fpdEnabled;

    @Nullable
    private final Boolean isCacheableAssetsRequired;

    @Nullable
    private final Boolean isReportIncentivizedEnabled;

    @Nullable
    private final i logMetricsSettings;

    @Nullable
    private final List<com.vungle.ads.internal.model.j> placements;

    @Nullable
    private final Boolean rtaDebugging;

    @Nullable
    private final Integer sessionTimeout;

    @Nullable
    private final Integer signalSessionTimeout;

    @Nullable
    private final Boolean signalsDisabled;

    @Nullable
    private final j userPrivacy;

    @Nullable
    private final k viewAbility;

    @Nullable
    private final Boolean waitForConnectivityForTPAT;

    /* JADX INFO: compiled from: ConfigPayload.kt */
    public static final class a implements d0<g> {

        @NotNull
        public static final a INSTANCE;
        public static final /* synthetic */ SerialDescriptor descriptor;

        static {
            a aVar = new a();
            INSTANCE = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.ConfigPayload", aVar, 19);
            pluginGeneratedSerialDescriptor.k("reuse_assets", true);
            pluginGeneratedSerialDescriptor.k("config", true);
            pluginGeneratedSerialDescriptor.k("endpoints", true);
            pluginGeneratedSerialDescriptor.k("log_metrics", true);
            pluginGeneratedSerialDescriptor.k(jo.f12765c, true);
            pluginGeneratedSerialDescriptor.k("user", true);
            pluginGeneratedSerialDescriptor.k("viewability", true);
            pluginGeneratedSerialDescriptor.k("config_extension", true);
            pluginGeneratedSerialDescriptor.k("disable_ad_id", true);
            pluginGeneratedSerialDescriptor.k("ri_enabled", true);
            pluginGeneratedSerialDescriptor.k("session_timeout", true);
            pluginGeneratedSerialDescriptor.k("wait_for_connectivity_for_tpat", true);
            pluginGeneratedSerialDescriptor.k("sdk_session_timeout", true);
            pluginGeneratedSerialDescriptor.k("cacheable_assets_required", true);
            pluginGeneratedSerialDescriptor.k("signals_disabled", true);
            pluginGeneratedSerialDescriptor.k("fpd_enabled", true);
            pluginGeneratedSerialDescriptor.k("rta_debugging", true);
            pluginGeneratedSerialDescriptor.k("config_last_validated_ts", true);
            pluginGeneratedSerialDescriptor.k("auto_redirect", true);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        private a() {
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] childSerializers() {
            da.h hVar = da.h.f24574a;
            l0 l0Var = l0.f24594a;
            return new KSerializer[]{aa.a.s(c.a.INSTANCE), aa.a.s(e.a.INSTANCE), aa.a.s(f.a.INSTANCE), aa.a.s(i.a.INSTANCE), aa.a.s(new da.f(j.a.INSTANCE)), aa.a.s(j.a.INSTANCE), aa.a.s(k.a.INSTANCE), aa.a.s(w1.f24648a), aa.a.s(hVar), aa.a.s(hVar), aa.a.s(l0Var), aa.a.s(hVar), aa.a.s(l0Var), aa.a.s(hVar), aa.a.s(hVar), aa.a.s(hVar), aa.a.s(hVar), aa.a.s(u0.f24629a), aa.a.s(b.a.INSTANCE)};
        }

        @Override // z9.b
        @NotNull
        public g deserialize(@NotNull Decoder decoder) {
            Object objK;
            Object objK2;
            Object obj;
            Object obj2;
            Object obj3;
            Object objK3;
            int i10;
            Object objK4;
            Object objK5;
            Object objK6;
            Object objK7;
            Object objK8;
            Object objK9;
            Object objK10;
            Object objK11;
            Object obj4;
            Object objK12;
            Object objK13;
            Object objK14;
            Object objK15;
            Object obj5;
            Object obj6;
            Object obj7;
            Object obj8;
            Object obj9;
            t.i(decoder, "decoder");
            SerialDescriptor descriptor2 = getDescriptor();
            ca.c cVarB = decoder.b(descriptor2);
            if (cVarB.p()) {
                Object objK16 = cVarB.k(descriptor2, 0, c.a.INSTANCE, null);
                objK10 = cVarB.k(descriptor2, 1, e.a.INSTANCE, null);
                objK3 = cVarB.k(descriptor2, 2, f.a.INSTANCE, null);
                Object objK17 = cVarB.k(descriptor2, 3, i.a.INSTANCE, null);
                Object objK18 = cVarB.k(descriptor2, 4, new da.f(j.a.INSTANCE), null);
                objK15 = cVarB.k(descriptor2, 5, j.a.INSTANCE, null);
                objK14 = cVarB.k(descriptor2, 6, k.a.INSTANCE, null);
                objK13 = cVarB.k(descriptor2, 7, w1.f24648a, null);
                da.h hVar = da.h.f24574a;
                objK12 = cVarB.k(descriptor2, 8, hVar, null);
                objK11 = cVarB.k(descriptor2, 9, hVar, null);
                l0 l0Var = l0.f24594a;
                objK5 = cVarB.k(descriptor2, 10, l0Var, null);
                objK4 = cVarB.k(descriptor2, 11, hVar, null);
                Object objK19 = cVarB.k(descriptor2, 12, l0Var, null);
                Object objK20 = cVarB.k(descriptor2, 13, hVar, null);
                obj4 = objK19;
                objK9 = cVarB.k(descriptor2, 14, hVar, null);
                objK8 = cVarB.k(descriptor2, 15, hVar, null);
                objK7 = cVarB.k(descriptor2, 16, hVar, null);
                i10 = 524287;
                obj = objK20;
                objK = objK18;
                objK6 = cVarB.k(descriptor2, 17, u0.f24629a, null);
                obj2 = objK16;
                objK2 = cVarB.k(descriptor2, 18, b.a.INSTANCE, null);
                obj3 = objK17;
            } else {
                boolean z10 = true;
                Object objK21 = null;
                Object objK22 = null;
                Object objK23 = null;
                Object objK24 = null;
                Object objK25 = null;
                Object objK26 = null;
                Object objK27 = null;
                Object objK28 = null;
                Object objK29 = null;
                Object objK30 = null;
                objK = null;
                Object objK31 = null;
                Object objK32 = null;
                Object objK33 = null;
                Object objK34 = null;
                Object objK35 = null;
                Object objK36 = null;
                Object objK37 = null;
                int i11 = 0;
                Object objK38 = null;
                while (z10) {
                    int iO = cVarB.o(descriptor2);
                    switch (iO) {
                        case -1:
                            obj5 = objK38;
                            obj6 = objK21;
                            obj7 = objK25;
                            z10 = false;
                            objK25 = obj7;
                            objK38 = obj5;
                            objK21 = obj6;
                            break;
                        case 0:
                            obj6 = objK21;
                            obj7 = objK25;
                            obj5 = objK38;
                            objK37 = cVarB.k(descriptor2, 0, c.a.INSTANCE, objK37);
                            i11 |= 1;
                            objK25 = obj7;
                            objK38 = obj5;
                            objK21 = obj6;
                            break;
                        case 1:
                            obj6 = objK21;
                            objK38 = cVarB.k(descriptor2, 1, e.a.INSTANCE, objK38);
                            i11 |= 2;
                            objK25 = objK25;
                            objK21 = obj6;
                            break;
                        case 2:
                            obj8 = objK38;
                            obj9 = objK25;
                            objK24 = cVarB.k(descriptor2, 2, f.a.INSTANCE, objK24);
                            i11 |= 4;
                            objK25 = obj9;
                            objK38 = obj8;
                            break;
                        case 3:
                            obj8 = objK38;
                            obj9 = objK25;
                            objK23 = cVarB.k(descriptor2, 3, i.a.INSTANCE, objK23);
                            i11 |= 8;
                            objK25 = obj9;
                            objK38 = obj8;
                            break;
                        case 4:
                            obj8 = objK38;
                            obj9 = objK25;
                            objK = cVarB.k(descriptor2, 4, new da.f(j.a.INSTANCE), objK);
                            i11 |= 16;
                            objK25 = obj9;
                            objK38 = obj8;
                            break;
                        case 5:
                            obj8 = objK38;
                            obj9 = objK25;
                            objK21 = cVarB.k(descriptor2, 5, j.a.INSTANCE, objK21);
                            i11 |= 32;
                            objK25 = obj9;
                            objK38 = obj8;
                            break;
                        case 6:
                            obj8 = objK38;
                            obj9 = objK25;
                            objK30 = cVarB.k(descriptor2, 6, k.a.INSTANCE, objK30);
                            i11 |= 64;
                            objK25 = obj9;
                            objK38 = obj8;
                            break;
                        case 7:
                            obj8 = objK38;
                            obj9 = objK25;
                            objK29 = cVarB.k(descriptor2, 7, w1.f24648a, objK29);
                            i11 |= 128;
                            objK25 = obj9;
                            objK38 = obj8;
                            break;
                        case 8:
                            obj8 = objK38;
                            obj9 = objK25;
                            objK28 = cVarB.k(descriptor2, 8, da.h.f24574a, objK28);
                            i11 |= 256;
                            objK25 = obj9;
                            objK38 = obj8;
                            break;
                        case 9:
                            obj8 = objK38;
                            obj9 = objK25;
                            objK22 = cVarB.k(descriptor2, 9, da.h.f24574a, objK22);
                            i11 |= 512;
                            objK25 = obj9;
                            objK38 = obj8;
                            break;
                        case 10:
                            obj8 = objK38;
                            obj9 = objK25;
                            objK27 = cVarB.k(descriptor2, 10, l0.f24594a, objK27);
                            i11 |= 1024;
                            objK25 = obj9;
                            objK38 = obj8;
                            break;
                        case 11:
                            obj8 = objK38;
                            obj9 = objK25;
                            objK26 = cVarB.k(descriptor2, 11, da.h.f24574a, objK26);
                            i11 |= 2048;
                            objK25 = obj9;
                            objK38 = obj8;
                            break;
                        case 12:
                            obj8 = objK38;
                            objK31 = cVarB.k(descriptor2, 12, l0.f24594a, objK31);
                            i11 |= 4096;
                            objK25 = objK25;
                            objK32 = objK32;
                            objK38 = obj8;
                            break;
                        case 13:
                            obj8 = objK38;
                            objK32 = cVarB.k(descriptor2, 13, da.h.f24574a, objK32);
                            i11 |= 8192;
                            objK25 = objK25;
                            objK33 = objK33;
                            objK38 = obj8;
                            break;
                        case 14:
                            obj8 = objK38;
                            objK33 = cVarB.k(descriptor2, 14, da.h.f24574a, objK33);
                            i11 |= 16384;
                            objK25 = objK25;
                            objK34 = objK34;
                            objK38 = obj8;
                            break;
                        case 15:
                            obj8 = objK38;
                            objK34 = cVarB.k(descriptor2, 15, da.h.f24574a, objK34);
                            i11 |= 32768;
                            objK25 = objK25;
                            objK35 = objK35;
                            objK38 = obj8;
                            break;
                        case 16:
                            obj8 = objK38;
                            objK35 = cVarB.k(descriptor2, 16, da.h.f24574a, objK35);
                            i11 |= 65536;
                            objK25 = objK25;
                            objK36 = objK36;
                            objK38 = obj8;
                            break;
                        case 17:
                            obj8 = objK38;
                            obj9 = objK25;
                            objK36 = cVarB.k(descriptor2, 17, u0.f24629a, objK36);
                            i11 |= 131072;
                            objK25 = obj9;
                            objK38 = obj8;
                            break;
                        case 18:
                            objK25 = cVarB.k(descriptor2, 18, b.a.INSTANCE, objK25);
                            i11 |= 262144;
                            objK38 = objK38;
                            break;
                        default:
                            throw new o(iO);
                    }
                }
                Object obj10 = objK38;
                Object obj11 = objK21;
                objK2 = objK25;
                obj = objK32;
                obj2 = objK37;
                obj3 = objK23;
                objK3 = objK24;
                i10 = i11;
                objK4 = objK26;
                objK5 = objK27;
                objK6 = objK36;
                objK7 = objK35;
                objK8 = objK34;
                objK9 = objK33;
                objK10 = obj10;
                objK11 = objK22;
                obj4 = objK31;
                objK12 = objK28;
                objK13 = objK29;
                objK14 = objK30;
                objK15 = obj11;
            }
            cVarB.c(descriptor2);
            return new g(i10, (c) obj2, (e) objK10, (f) objK3, (i) obj3, (List) objK, (j) objK15, (k) objK14, (String) objK13, (Boolean) objK12, (Boolean) objK11, (Integer) objK5, (Boolean) objK4, (Integer) obj4, (Boolean) obj, (Boolean) objK9, (Boolean) objK8, (Boolean) objK7, (Long) objK6, (b) objK2, (s1) null);
        }

        @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
        @NotNull
        public SerialDescriptor getDescriptor() {
            return descriptor;
        }

        @Override // z9.j
        public void serialize(@NotNull Encoder encoder, @NotNull g value) {
            t.i(encoder, "encoder");
            t.i(value, "value");
            SerialDescriptor descriptor2 = getDescriptor();
            ca.d dVarB = encoder.b(descriptor2);
            g.write$Self(value, dVarB, descriptor2);
            dVarB.c(descriptor2);
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }
    }

    /* JADX INFO: compiled from: ConfigPayload.kt */
    @z9.h
    public static final class b {

        @NotNull
        public static final C0521b Companion = new C0521b(null);

        @Nullable
        private final Long afterClickDuration;

        @Nullable
        private final Boolean allowAutoRedirect;

        /* JADX INFO: compiled from: ConfigPayload.kt */
        public static final class a implements d0<b> {

            @NotNull
            public static final a INSTANCE;
            public static final /* synthetic */ SerialDescriptor descriptor;

            static {
                a aVar = new a();
                INSTANCE = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.ConfigPayload.AutoRedirect", aVar, 2);
                pluginGeneratedSerialDescriptor.k("allow_auto_redirect", true);
                pluginGeneratedSerialDescriptor.k("after_click_ms", true);
                descriptor = pluginGeneratedSerialDescriptor;
            }

            private a() {
            }

            @Override // da.d0
            @NotNull
            public KSerializer<?>[] childSerializers() {
                return new KSerializer[]{aa.a.s(da.h.f24574a), aa.a.s(u0.f24629a)};
            }

            @Override // z9.b
            @NotNull
            public b deserialize(@NotNull Decoder decoder) {
                Object objK;
                Object objK2;
                int i10;
                t.i(decoder, "decoder");
                SerialDescriptor descriptor2 = getDescriptor();
                ca.c cVarB = decoder.b(descriptor2);
                s1 s1Var = null;
                if (cVarB.p()) {
                    objK = cVarB.k(descriptor2, 0, da.h.f24574a, null);
                    objK2 = cVarB.k(descriptor2, 1, u0.f24629a, null);
                    i10 = 3;
                } else {
                    boolean z10 = true;
                    int i11 = 0;
                    objK = null;
                    Object objK3 = null;
                    while (z10) {
                        int iO = cVarB.o(descriptor2);
                        if (iO == -1) {
                            z10 = false;
                        } else if (iO == 0) {
                            objK = cVarB.k(descriptor2, 0, da.h.f24574a, objK);
                            i11 |= 1;
                        } else {
                            if (iO != 1) {
                                throw new o(iO);
                            }
                            objK3 = cVarB.k(descriptor2, 1, u0.f24629a, objK3);
                            i11 |= 2;
                        }
                    }
                    objK2 = objK3;
                    i10 = i11;
                }
                cVarB.c(descriptor2);
                return new b(i10, (Boolean) objK, (Long) objK2, s1Var);
            }

            @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
            @NotNull
            public SerialDescriptor getDescriptor() {
                return descriptor;
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

            @Override // da.d0
            @NotNull
            public KSerializer<?>[] typeParametersSerializers() {
                return d0.a.a(this);
            }
        }

        /* JADX INFO: renamed from: com.vungle.ads.internal.model.g$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ConfigPayload.kt */
        public static final class C0521b {
            private C0521b() {
            }

            public /* synthetic */ C0521b(kotlin.jvm.internal.k kVar) {
                this();
            }

            @NotNull
            public final KSerializer<b> serializer() {
                return a.INSTANCE;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b() {
            this((Boolean) null, (Long) (0 == true ? 1 : 0), 3, (kotlin.jvm.internal.k) (0 == true ? 1 : 0));
        }

        public static /* synthetic */ b copy$default(b bVar, Boolean bool, Long l10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                bool = bVar.allowAutoRedirect;
            }
            if ((i10 & 2) != 0) {
                l10 = bVar.afterClickDuration;
            }
            return bVar.copy(bool, l10);
        }

        public static final void write$Self(@NotNull b self, @NotNull ca.d output, @NotNull SerialDescriptor serialDesc) {
            Long l10;
            t.i(self, "self");
            t.i(output, "output");
            t.i(serialDesc, "serialDesc");
            if (output.z(serialDesc, 0) || !t.d(self.allowAutoRedirect, Boolean.FALSE)) {
                output.h(serialDesc, 0, da.h.f24574a, self.allowAutoRedirect);
            }
            if (output.z(serialDesc, 1) || (l10 = self.afterClickDuration) == null || l10.longValue() != Long.MAX_VALUE) {
                output.h(serialDesc, 1, u0.f24629a, self.afterClickDuration);
            }
        }

        @Nullable
        public final Boolean component1() {
            return this.allowAutoRedirect;
        }

        @Nullable
        public final Long component2() {
            return this.afterClickDuration;
        }

        @NotNull
        public final b copy(@Nullable Boolean bool, @Nullable Long l10) {
            return new b(bool, l10);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return t.d(this.allowAutoRedirect, bVar.allowAutoRedirect) && t.d(this.afterClickDuration, bVar.afterClickDuration);
        }

        @Nullable
        public final Long getAfterClickDuration() {
            return this.afterClickDuration;
        }

        @Nullable
        public final Boolean getAllowAutoRedirect() {
            return this.allowAutoRedirect;
        }

        public int hashCode() {
            Boolean bool = this.allowAutoRedirect;
            int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            Long l10 = this.afterClickDuration;
            return iHashCode + (l10 != null ? l10.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "AutoRedirect(allowAutoRedirect=" + this.allowAutoRedirect + ", afterClickDuration=" + this.afterClickDuration + ')';
        }

        public /* synthetic */ b(int i10, Boolean bool, Long l10, s1 s1Var) {
            if ((i10 & 0) != 0) {
                i1.a(i10, 0, a.INSTANCE.getDescriptor());
            }
            this.allowAutoRedirect = (i10 & 1) == 0 ? Boolean.FALSE : bool;
            if ((i10 & 2) == 0) {
                this.afterClickDuration = Long.MAX_VALUE;
            } else {
                this.afterClickDuration = l10;
            }
        }

        public b(@Nullable Boolean bool, @Nullable Long l10) {
            this.allowAutoRedirect = bool;
            this.afterClickDuration = l10;
        }

        public /* synthetic */ b(Boolean bool, Long l10, int i10, kotlin.jvm.internal.k kVar) {
            this((i10 & 1) != 0 ? Boolean.FALSE : bool, (i10 & 2) != 0 ? Long.MAX_VALUE : l10);
        }

        public static /* synthetic */ void getAfterClickDuration$annotations() {
        }

        public static /* synthetic */ void getAllowAutoRedirect$annotations() {
        }
    }

    /* JADX INFO: compiled from: ConfigPayload.kt */
    @z9.h
    public static final class c {

        @NotNull
        public static final b Companion = new b(null);

        @Nullable
        private final Integer diskPercentage;

        @Nullable
        private final Long diskSize;

        @Nullable
        private final Boolean enabled;

        /* JADX INFO: compiled from: ConfigPayload.kt */
        public static final class a implements d0<c> {

            @NotNull
            public static final a INSTANCE;
            public static final /* synthetic */ SerialDescriptor descriptor;

            static {
                a aVar = new a();
                INSTANCE = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.ConfigPayload.CleverCache", aVar, 3);
                pluginGeneratedSerialDescriptor.k("enabled", true);
                pluginGeneratedSerialDescriptor.k("disk_size", true);
                pluginGeneratedSerialDescriptor.k("disk_percentage", true);
                descriptor = pluginGeneratedSerialDescriptor;
            }

            private a() {
            }

            @Override // da.d0
            @NotNull
            public KSerializer<?>[] childSerializers() {
                return new KSerializer[]{aa.a.s(da.h.f24574a), aa.a.s(u0.f24629a), aa.a.s(l0.f24594a)};
            }

            @Override // z9.b
            @NotNull
            public c deserialize(@NotNull Decoder decoder) {
                Object objK;
                Object objK2;
                int i10;
                Object objK3;
                t.i(decoder, "decoder");
                SerialDescriptor descriptor2 = getDescriptor();
                ca.c cVarB = decoder.b(descriptor2);
                Object objK4 = null;
                if (cVarB.p()) {
                    objK3 = cVarB.k(descriptor2, 0, da.h.f24574a, null);
                    objK = cVarB.k(descriptor2, 1, u0.f24629a, null);
                    objK2 = cVarB.k(descriptor2, 2, l0.f24594a, null);
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
                            objK4 = cVarB.k(descriptor2, 0, da.h.f24574a, objK4);
                            i11 |= 1;
                        } else if (iO == 1) {
                            objK5 = cVarB.k(descriptor2, 1, u0.f24629a, objK5);
                            i11 |= 2;
                        } else {
                            if (iO != 2) {
                                throw new o(iO);
                            }
                            objK6 = cVarB.k(descriptor2, 2, l0.f24594a, objK6);
                            i11 |= 4;
                        }
                    }
                    objK = objK5;
                    objK2 = objK6;
                    Object obj = objK4;
                    i10 = i11;
                    objK3 = obj;
                }
                cVarB.c(descriptor2);
                return new c(i10, (Boolean) objK3, (Long) objK, (Integer) objK2, (s1) null);
            }

            @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
            @NotNull
            public SerialDescriptor getDescriptor() {
                return descriptor;
            }

            @Override // z9.j
            public void serialize(@NotNull Encoder encoder, @NotNull c value) {
                t.i(encoder, "encoder");
                t.i(value, "value");
                SerialDescriptor descriptor2 = getDescriptor();
                ca.d dVarB = encoder.b(descriptor2);
                c.write$Self(value, dVarB, descriptor2);
                dVarB.c(descriptor2);
            }

            @Override // da.d0
            @NotNull
            public KSerializer<?>[] typeParametersSerializers() {
                return d0.a.a(this);
            }
        }

        /* JADX INFO: compiled from: ConfigPayload.kt */
        public static final class b {
            private b() {
            }

            public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
                this();
            }

            @NotNull
            public final KSerializer<c> serializer() {
                return a.INSTANCE;
            }
        }

        public c() {
            this((Boolean) null, (Long) null, (Integer) null, 7, (kotlin.jvm.internal.k) null);
        }

        public static /* synthetic */ c copy$default(c cVar, Boolean bool, Long l10, Integer num, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                bool = cVar.enabled;
            }
            if ((i10 & 2) != 0) {
                l10 = cVar.diskSize;
            }
            if ((i10 & 4) != 0) {
                num = cVar.diskPercentage;
            }
            return cVar.copy(bool, l10, num);
        }

        public static final void write$Self(@NotNull c self, @NotNull ca.d output, @NotNull SerialDescriptor serialDesc) {
            Long l10;
            Integer num;
            t.i(self, "self");
            t.i(output, "output");
            t.i(serialDesc, "serialDesc");
            if (output.z(serialDesc, 0) || !t.d(self.enabled, Boolean.FALSE)) {
                output.h(serialDesc, 0, da.h.f24574a, self.enabled);
            }
            if (output.z(serialDesc, 1) || (l10 = self.diskSize) == null || l10.longValue() != 1000) {
                output.h(serialDesc, 1, u0.f24629a, self.diskSize);
            }
            if (output.z(serialDesc, 2) || (num = self.diskPercentage) == null || num.intValue() != 3) {
                output.h(serialDesc, 2, l0.f24594a, self.diskPercentage);
            }
        }

        @Nullable
        public final Boolean component1() {
            return this.enabled;
        }

        @Nullable
        public final Long component2() {
            return this.diskSize;
        }

        @Nullable
        public final Integer component3() {
            return this.diskPercentage;
        }

        @NotNull
        public final c copy(@Nullable Boolean bool, @Nullable Long l10, @Nullable Integer num) {
            return new c(bool, l10, num);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return t.d(this.enabled, cVar.enabled) && t.d(this.diskSize, cVar.diskSize) && t.d(this.diskPercentage, cVar.diskPercentage);
        }

        @Nullable
        public final Integer getDiskPercentage() {
            return this.diskPercentage;
        }

        @Nullable
        public final Long getDiskSize() {
            return this.diskSize;
        }

        @Nullable
        public final Boolean getEnabled() {
            return this.enabled;
        }

        public int hashCode() {
            Boolean bool = this.enabled;
            int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            Long l10 = this.diskSize;
            int iHashCode2 = (iHashCode + (l10 == null ? 0 : l10.hashCode())) * 31;
            Integer num = this.diskPercentage;
            return iHashCode2 + (num != null ? num.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "CleverCache(enabled=" + this.enabled + ", diskSize=" + this.diskSize + ", diskPercentage=" + this.diskPercentage + ')';
        }

        public /* synthetic */ c(int i10, Boolean bool, Long l10, Integer num, s1 s1Var) {
            if ((i10 & 0) != 0) {
                i1.a(i10, 0, a.INSTANCE.getDescriptor());
            }
            this.enabled = (i10 & 1) == 0 ? Boolean.FALSE : bool;
            if ((i10 & 2) == 0) {
                this.diskSize = 1000L;
            } else {
                this.diskSize = l10;
            }
            if ((i10 & 4) == 0) {
                this.diskPercentage = 3;
            } else {
                this.diskPercentage = num;
            }
        }

        public c(@Nullable Boolean bool, @Nullable Long l10, @Nullable Integer num) {
            this.enabled = bool;
            this.diskSize = l10;
            this.diskPercentage = num;
        }

        public /* synthetic */ c(Boolean bool, Long l10, Integer num, int i10, kotlin.jvm.internal.k kVar) {
            this((i10 & 1) != 0 ? Boolean.FALSE : bool, (i10 & 2) != 0 ? 1000L : l10, (i10 & 4) != 0 ? 3 : num);
        }

        public static /* synthetic */ void getDiskPercentage$annotations() {
        }

        public static /* synthetic */ void getDiskSize$annotations() {
        }

        public static /* synthetic */ void getEnabled$annotations() {
        }
    }

    /* JADX INFO: compiled from: ConfigPayload.kt */
    public static final class d {
        private d() {
        }

        public /* synthetic */ d(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final KSerializer<g> serializer() {
            return a.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: ConfigPayload.kt */
    @z9.h
    public static final class e {

        @NotNull
        public static final b Companion = new b(null);

        @Nullable
        private final Long refreshTime;

        /* JADX INFO: compiled from: ConfigPayload.kt */
        public static final class a implements d0<e> {

            @NotNull
            public static final a INSTANCE;
            public static final /* synthetic */ SerialDescriptor descriptor;

            static {
                a aVar = new a();
                INSTANCE = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.ConfigPayload.ConfigSettings", aVar, 1);
                pluginGeneratedSerialDescriptor.k("refresh_interval", true);
                descriptor = pluginGeneratedSerialDescriptor;
            }

            private a() {
            }

            @Override // da.d0
            @NotNull
            public KSerializer<?>[] childSerializers() {
                return new KSerializer[]{aa.a.s(u0.f24629a)};
            }

            @Override // z9.b
            @NotNull
            public e deserialize(@NotNull Decoder decoder) {
                Object objK;
                t.i(decoder, "decoder");
                SerialDescriptor descriptor2 = getDescriptor();
                ca.c cVarB = decoder.b(descriptor2);
                int i10 = 1;
                s1 s1Var = null;
                if (cVarB.p()) {
                    objK = cVarB.k(descriptor2, 0, u0.f24629a, null);
                } else {
                    int i11 = 0;
                    objK = null;
                    while (i10 != 0) {
                        int iO = cVarB.o(descriptor2);
                        if (iO == -1) {
                            i10 = 0;
                        } else {
                            if (iO != 0) {
                                throw new o(iO);
                            }
                            objK = cVarB.k(descriptor2, 0, u0.f24629a, objK);
                            i11 |= 1;
                        }
                    }
                    i10 = i11;
                }
                cVarB.c(descriptor2);
                return new e(i10, (Long) objK, s1Var);
            }

            @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
            @NotNull
            public SerialDescriptor getDescriptor() {
                return descriptor;
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

            @Override // da.d0
            @NotNull
            public KSerializer<?>[] typeParametersSerializers() {
                return d0.a.a(this);
            }
        }

        /* JADX INFO: compiled from: ConfigPayload.kt */
        public static final class b {
            private b() {
            }

            public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
                this();
            }

            @NotNull
            public final KSerializer<e> serializer() {
                return a.INSTANCE;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public e() {
            this((Long) null, 1, (kotlin.jvm.internal.k) (0 == true ? 1 : 0));
        }

        public static /* synthetic */ e copy$default(e eVar, Long l10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                l10 = eVar.refreshTime;
            }
            return eVar.copy(l10);
        }

        public static final void write$Self(@NotNull e self, @NotNull ca.d output, @NotNull SerialDescriptor serialDesc) {
            t.i(self, "self");
            t.i(output, "output");
            t.i(serialDesc, "serialDesc");
            boolean z10 = true;
            if (!output.z(serialDesc, 0) && self.refreshTime == null) {
                z10 = false;
            }
            if (z10) {
                output.h(serialDesc, 0, u0.f24629a, self.refreshTime);
            }
        }

        @Nullable
        public final Long component1() {
            return this.refreshTime;
        }

        @NotNull
        public final e copy(@Nullable Long l10) {
            return new e(l10);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof e) && t.d(this.refreshTime, ((e) obj).refreshTime);
        }

        @Nullable
        public final Long getRefreshTime() {
            return this.refreshTime;
        }

        public int hashCode() {
            Long l10 = this.refreshTime;
            if (l10 == null) {
                return 0;
            }
            return l10.hashCode();
        }

        @NotNull
        public String toString() {
            return "ConfigSettings(refreshTime=" + this.refreshTime + ')';
        }

        public /* synthetic */ e(int i10, Long l10, s1 s1Var) {
            if ((i10 & 0) != 0) {
                i1.a(i10, 0, a.INSTANCE.getDescriptor());
            }
            if ((i10 & 1) == 0) {
                this.refreshTime = null;
            } else {
                this.refreshTime = l10;
            }
        }

        public e(@Nullable Long l10) {
            this.refreshTime = l10;
        }

        public /* synthetic */ e(Long l10, int i10, kotlin.jvm.internal.k kVar) {
            this((i10 & 1) != 0 ? null : l10);
        }

        public static /* synthetic */ void getRefreshTime$annotations() {
        }
    }

    /* JADX INFO: compiled from: ConfigPayload.kt */
    @z9.h
    public static final class f {

        @NotNull
        public static final b Companion = new b(null);

        @Nullable
        private final String adsEndpoint;

        @Nullable
        private final String errorLogsEndpoint;

        @Nullable
        private final String metricsEndpoint;

        @Nullable
        private final String mraidEndpoint;

        @Nullable
        private final String riEndpoint;

        /* JADX INFO: compiled from: ConfigPayload.kt */
        public static final class a implements d0<f> {

            @NotNull
            public static final a INSTANCE;
            public static final /* synthetic */ SerialDescriptor descriptor;

            static {
                a aVar = new a();
                INSTANCE = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.ConfigPayload.Endpoints", aVar, 5);
                pluginGeneratedSerialDescriptor.k("ads", true);
                pluginGeneratedSerialDescriptor.k("ri", true);
                pluginGeneratedSerialDescriptor.k("error_logs", true);
                pluginGeneratedSerialDescriptor.k("metrics", true);
                pluginGeneratedSerialDescriptor.k("mraid_js", true);
                descriptor = pluginGeneratedSerialDescriptor;
            }

            private a() {
            }

            @Override // da.d0
            @NotNull
            public KSerializer<?>[] childSerializers() {
                w1 w1Var = w1.f24648a;
                return new KSerializer[]{aa.a.s(w1Var), aa.a.s(w1Var), aa.a.s(w1Var), aa.a.s(w1Var), aa.a.s(w1Var)};
            }

            @Override // z9.b
            @NotNull
            public f deserialize(@NotNull Decoder decoder) {
                Object objK;
                int i10;
                Object objK2;
                Object objK3;
                Object objK4;
                Object objK5;
                t.i(decoder, "decoder");
                SerialDescriptor descriptor2 = getDescriptor();
                ca.c cVarB = decoder.b(descriptor2);
                Object objK6 = null;
                if (cVarB.p()) {
                    w1 w1Var = w1.f24648a;
                    objK2 = cVarB.k(descriptor2, 0, w1Var, null);
                    objK3 = cVarB.k(descriptor2, 1, w1Var, null);
                    Object objK7 = cVarB.k(descriptor2, 2, w1Var, null);
                    objK4 = cVarB.k(descriptor2, 3, w1Var, null);
                    objK5 = cVarB.k(descriptor2, 4, w1Var, null);
                    objK = objK7;
                    i10 = 31;
                } else {
                    boolean z10 = true;
                    int i11 = 0;
                    Object objK8 = null;
                    objK = null;
                    Object objK9 = null;
                    Object objK10 = null;
                    while (z10) {
                        int iO = cVarB.o(descriptor2);
                        if (iO == -1) {
                            z10 = false;
                        } else if (iO == 0) {
                            objK6 = cVarB.k(descriptor2, 0, w1.f24648a, objK6);
                            i11 |= 1;
                        } else if (iO == 1) {
                            objK8 = cVarB.k(descriptor2, 1, w1.f24648a, objK8);
                            i11 |= 2;
                        } else if (iO == 2) {
                            objK = cVarB.k(descriptor2, 2, w1.f24648a, objK);
                            i11 |= 4;
                        } else if (iO == 3) {
                            objK9 = cVarB.k(descriptor2, 3, w1.f24648a, objK9);
                            i11 |= 8;
                        } else {
                            if (iO != 4) {
                                throw new o(iO);
                            }
                            objK10 = cVarB.k(descriptor2, 4, w1.f24648a, objK10);
                            i11 |= 16;
                        }
                    }
                    i10 = i11;
                    objK2 = objK6;
                    objK3 = objK8;
                    objK4 = objK9;
                    objK5 = objK10;
                }
                cVarB.c(descriptor2);
                return new f(i10, (String) objK2, (String) objK3, (String) objK, (String) objK4, (String) objK5, (s1) null);
            }

            @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
            @NotNull
            public SerialDescriptor getDescriptor() {
                return descriptor;
            }

            @Override // z9.j
            public void serialize(@NotNull Encoder encoder, @NotNull f value) {
                t.i(encoder, "encoder");
                t.i(value, "value");
                SerialDescriptor descriptor2 = getDescriptor();
                ca.d dVarB = encoder.b(descriptor2);
                f.write$Self(value, dVarB, descriptor2);
                dVarB.c(descriptor2);
            }

            @Override // da.d0
            @NotNull
            public KSerializer<?>[] typeParametersSerializers() {
                return d0.a.a(this);
            }
        }

        /* JADX INFO: compiled from: ConfigPayload.kt */
        public static final class b {
            private b() {
            }

            public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
                this();
            }

            @NotNull
            public final KSerializer<f> serializer() {
                return a.INSTANCE;
            }
        }

        public f() {
            this((String) null, (String) null, (String) null, (String) null, (String) null, 31, (kotlin.jvm.internal.k) null);
        }

        public static /* synthetic */ f copy$default(f fVar, String str, String str2, String str3, String str4, String str5, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = fVar.adsEndpoint;
            }
            if ((i10 & 2) != 0) {
                str2 = fVar.riEndpoint;
            }
            String str6 = str2;
            if ((i10 & 4) != 0) {
                str3 = fVar.errorLogsEndpoint;
            }
            String str7 = str3;
            if ((i10 & 8) != 0) {
                str4 = fVar.metricsEndpoint;
            }
            String str8 = str4;
            if ((i10 & 16) != 0) {
                str5 = fVar.mraidEndpoint;
            }
            return fVar.copy(str, str6, str7, str8, str5);
        }

        public static final void write$Self(@NotNull f self, @NotNull ca.d output, @NotNull SerialDescriptor serialDesc) {
            t.i(self, "self");
            t.i(output, "output");
            t.i(serialDesc, "serialDesc");
            if (output.z(serialDesc, 0) || self.adsEndpoint != null) {
                output.h(serialDesc, 0, w1.f24648a, self.adsEndpoint);
            }
            if (output.z(serialDesc, 1) || self.riEndpoint != null) {
                output.h(serialDesc, 1, w1.f24648a, self.riEndpoint);
            }
            if (output.z(serialDesc, 2) || self.errorLogsEndpoint != null) {
                output.h(serialDesc, 2, w1.f24648a, self.errorLogsEndpoint);
            }
            if (output.z(serialDesc, 3) || self.metricsEndpoint != null) {
                output.h(serialDesc, 3, w1.f24648a, self.metricsEndpoint);
            }
            if (output.z(serialDesc, 4) || self.mraidEndpoint != null) {
                output.h(serialDesc, 4, w1.f24648a, self.mraidEndpoint);
            }
        }

        @Nullable
        public final String component1() {
            return this.adsEndpoint;
        }

        @Nullable
        public final String component2() {
            return this.riEndpoint;
        }

        @Nullable
        public final String component3() {
            return this.errorLogsEndpoint;
        }

        @Nullable
        public final String component4() {
            return this.metricsEndpoint;
        }

        @Nullable
        public final String component5() {
            return this.mraidEndpoint;
        }

        @NotNull
        public final f copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
            return new f(str, str2, str3, str4, str5);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return t.d(this.adsEndpoint, fVar.adsEndpoint) && t.d(this.riEndpoint, fVar.riEndpoint) && t.d(this.errorLogsEndpoint, fVar.errorLogsEndpoint) && t.d(this.metricsEndpoint, fVar.metricsEndpoint) && t.d(this.mraidEndpoint, fVar.mraidEndpoint);
        }

        @Nullable
        public final String getAdsEndpoint() {
            return this.adsEndpoint;
        }

        @Nullable
        public final String getErrorLogsEndpoint() {
            return this.errorLogsEndpoint;
        }

        @Nullable
        public final String getMetricsEndpoint() {
            return this.metricsEndpoint;
        }

        @Nullable
        public final String getMraidEndpoint() {
            return this.mraidEndpoint;
        }

        @Nullable
        public final String getRiEndpoint() {
            return this.riEndpoint;
        }

        public int hashCode() {
            String str = this.adsEndpoint;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.riEndpoint;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.errorLogsEndpoint;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.metricsEndpoint;
            int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.mraidEndpoint;
            return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Endpoints(adsEndpoint=" + this.adsEndpoint + ", riEndpoint=" + this.riEndpoint + ", errorLogsEndpoint=" + this.errorLogsEndpoint + ", metricsEndpoint=" + this.metricsEndpoint + ", mraidEndpoint=" + this.mraidEndpoint + ')';
        }

        public /* synthetic */ f(int i10, String str, String str2, String str3, String str4, String str5, s1 s1Var) {
            if ((i10 & 0) != 0) {
                i1.a(i10, 0, a.INSTANCE.getDescriptor());
            }
            if ((i10 & 1) == 0) {
                this.adsEndpoint = null;
            } else {
                this.adsEndpoint = str;
            }
            if ((i10 & 2) == 0) {
                this.riEndpoint = null;
            } else {
                this.riEndpoint = str2;
            }
            if ((i10 & 4) == 0) {
                this.errorLogsEndpoint = null;
            } else {
                this.errorLogsEndpoint = str3;
            }
            if ((i10 & 8) == 0) {
                this.metricsEndpoint = null;
            } else {
                this.metricsEndpoint = str4;
            }
            if ((i10 & 16) == 0) {
                this.mraidEndpoint = null;
            } else {
                this.mraidEndpoint = str5;
            }
        }

        public f(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
            this.adsEndpoint = str;
            this.riEndpoint = str2;
            this.errorLogsEndpoint = str3;
            this.metricsEndpoint = str4;
            this.mraidEndpoint = str5;
        }

        public /* synthetic */ f(String str, String str2, String str3, String str4, String str5, int i10, kotlin.jvm.internal.k kVar) {
            this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? null : str5);
        }

        public static /* synthetic */ void getAdsEndpoint$annotations() {
        }

        public static /* synthetic */ void getErrorLogsEndpoint$annotations() {
        }

        public static /* synthetic */ void getMetricsEndpoint$annotations() {
        }

        public static /* synthetic */ void getMraidEndpoint$annotations() {
        }

        public static /* synthetic */ void getRiEndpoint$annotations() {
        }
    }

    /* JADX INFO: renamed from: com.vungle.ads.internal.model.g$g, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ConfigPayload.kt */
    @z9.h
    public static final class C0522g {

        @NotNull
        public static final b Companion = new b(null);

        @Nullable
        private final String buttonAccept;

        @Nullable
        private final String buttonDeny;

        @Nullable
        private final String consentMessage;

        @Nullable
        private final String consentMessageVersion;

        @Nullable
        private final String consentTitle;

        @Nullable
        private final Boolean isCountryDataProtected;

        /* JADX INFO: renamed from: com.vungle.ads.internal.model.g$g$a */
        /* JADX INFO: compiled from: ConfigPayload.kt */
        public static final class a implements d0<C0522g> {

            @NotNull
            public static final a INSTANCE;
            public static final /* synthetic */ SerialDescriptor descriptor;

            static {
                a aVar = new a();
                INSTANCE = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.ConfigPayload.GDPRSettings", aVar, 6);
                pluginGeneratedSerialDescriptor.k("is_country_data_protected", true);
                pluginGeneratedSerialDescriptor.k("consent_title", true);
                pluginGeneratedSerialDescriptor.k("consent_message", true);
                pluginGeneratedSerialDescriptor.k("consent_message_version", true);
                pluginGeneratedSerialDescriptor.k("button_accept", true);
                pluginGeneratedSerialDescriptor.k("button_deny", true);
                descriptor = pluginGeneratedSerialDescriptor;
            }

            private a() {
            }

            @Override // da.d0
            @NotNull
            public KSerializer<?>[] childSerializers() {
                w1 w1Var = w1.f24648a;
                return new KSerializer[]{aa.a.s(da.h.f24574a), aa.a.s(w1Var), aa.a.s(w1Var), aa.a.s(w1Var), aa.a.s(w1Var), aa.a.s(w1Var)};
            }

            @Override // z9.b
            @NotNull
            public C0522g deserialize(@NotNull Decoder decoder) {
                Object objK;
                Object objK2;
                Object objK3;
                Object objK4;
                Object objK5;
                int i10;
                Object objK6;
                t.i(decoder, "decoder");
                SerialDescriptor descriptor2 = getDescriptor();
                ca.c cVarB = decoder.b(descriptor2);
                int i11 = 5;
                Object objK7 = null;
                if (cVarB.p()) {
                    objK6 = cVarB.k(descriptor2, 0, da.h.f24574a, null);
                    w1 w1Var = w1.f24648a;
                    objK = cVarB.k(descriptor2, 1, w1Var, null);
                    objK2 = cVarB.k(descriptor2, 2, w1Var, null);
                    objK3 = cVarB.k(descriptor2, 3, w1Var, null);
                    objK4 = cVarB.k(descriptor2, 4, w1Var, null);
                    objK5 = cVarB.k(descriptor2, 5, w1Var, null);
                    i10 = 63;
                } else {
                    boolean z10 = true;
                    int i12 = 0;
                    Object objK8 = null;
                    Object objK9 = null;
                    Object objK10 = null;
                    Object objK11 = null;
                    Object objK12 = null;
                    while (z10) {
                        int iO = cVarB.o(descriptor2);
                        switch (iO) {
                            case -1:
                                z10 = false;
                                i11 = 5;
                                break;
                            case 0:
                                objK7 = cVarB.k(descriptor2, 0, da.h.f24574a, objK7);
                                i12 |= 1;
                                i11 = 5;
                                break;
                            case 1:
                                objK8 = cVarB.k(descriptor2, 1, w1.f24648a, objK8);
                                i12 |= 2;
                                break;
                            case 2:
                                objK9 = cVarB.k(descriptor2, 2, w1.f24648a, objK9);
                                i12 |= 4;
                                break;
                            case 3:
                                objK10 = cVarB.k(descriptor2, 3, w1.f24648a, objK10);
                                i12 |= 8;
                                break;
                            case 4:
                                objK11 = cVarB.k(descriptor2, 4, w1.f24648a, objK11);
                                i12 |= 16;
                                break;
                            case 5:
                                objK12 = cVarB.k(descriptor2, i11, w1.f24648a, objK12);
                                i12 |= 32;
                                break;
                            default:
                                throw new o(iO);
                        }
                    }
                    objK = objK8;
                    objK2 = objK9;
                    objK3 = objK10;
                    objK4 = objK11;
                    objK5 = objK12;
                    Object obj = objK7;
                    i10 = i12;
                    objK6 = obj;
                }
                cVarB.c(descriptor2);
                return new C0522g(i10, (Boolean) objK6, (String) objK, (String) objK2, (String) objK3, (String) objK4, (String) objK5, (s1) null);
            }

            @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
            @NotNull
            public SerialDescriptor getDescriptor() {
                return descriptor;
            }

            @Override // z9.j
            public void serialize(@NotNull Encoder encoder, @NotNull C0522g value) {
                t.i(encoder, "encoder");
                t.i(value, "value");
                SerialDescriptor descriptor2 = getDescriptor();
                ca.d dVarB = encoder.b(descriptor2);
                C0522g.write$Self(value, dVarB, descriptor2);
                dVarB.c(descriptor2);
            }

            @Override // da.d0
            @NotNull
            public KSerializer<?>[] typeParametersSerializers() {
                return d0.a.a(this);
            }
        }

        /* JADX INFO: renamed from: com.vungle.ads.internal.model.g$g$b */
        /* JADX INFO: compiled from: ConfigPayload.kt */
        public static final class b {
            private b() {
            }

            public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
                this();
            }

            @NotNull
            public final KSerializer<C0522g> serializer() {
                return a.INSTANCE;
            }
        }

        public C0522g() {
            this((Boolean) null, (String) null, (String) null, (String) null, (String) null, (String) null, 63, (kotlin.jvm.internal.k) null);
        }

        public static /* synthetic */ C0522g copy$default(C0522g c0522g, Boolean bool, String str, String str2, String str3, String str4, String str5, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                bool = c0522g.isCountryDataProtected;
            }
            if ((i10 & 2) != 0) {
                str = c0522g.consentTitle;
            }
            String str6 = str;
            if ((i10 & 4) != 0) {
                str2 = c0522g.consentMessage;
            }
            String str7 = str2;
            if ((i10 & 8) != 0) {
                str3 = c0522g.consentMessageVersion;
            }
            String str8 = str3;
            if ((i10 & 16) != 0) {
                str4 = c0522g.buttonAccept;
            }
            String str9 = str4;
            if ((i10 & 32) != 0) {
                str5 = c0522g.buttonDeny;
            }
            return c0522g.copy(bool, str6, str7, str8, str9, str5);
        }

        public static final void write$Self(@NotNull C0522g self, @NotNull ca.d output, @NotNull SerialDescriptor serialDesc) {
            t.i(self, "self");
            t.i(output, "output");
            t.i(serialDesc, "serialDesc");
            if (output.z(serialDesc, 0) || self.isCountryDataProtected != null) {
                output.h(serialDesc, 0, da.h.f24574a, self.isCountryDataProtected);
            }
            if (output.z(serialDesc, 1) || self.consentTitle != null) {
                output.h(serialDesc, 1, w1.f24648a, self.consentTitle);
            }
            if (output.z(serialDesc, 2) || self.consentMessage != null) {
                output.h(serialDesc, 2, w1.f24648a, self.consentMessage);
            }
            if (output.z(serialDesc, 3) || self.consentMessageVersion != null) {
                output.h(serialDesc, 3, w1.f24648a, self.consentMessageVersion);
            }
            if (output.z(serialDesc, 4) || self.buttonAccept != null) {
                output.h(serialDesc, 4, w1.f24648a, self.buttonAccept);
            }
            if (output.z(serialDesc, 5) || self.buttonDeny != null) {
                output.h(serialDesc, 5, w1.f24648a, self.buttonDeny);
            }
        }

        @Nullable
        public final Boolean component1() {
            return this.isCountryDataProtected;
        }

        @Nullable
        public final String component2() {
            return this.consentTitle;
        }

        @Nullable
        public final String component3() {
            return this.consentMessage;
        }

        @Nullable
        public final String component4() {
            return this.consentMessageVersion;
        }

        @Nullable
        public final String component5() {
            return this.buttonAccept;
        }

        @Nullable
        public final String component6() {
            return this.buttonDeny;
        }

        @NotNull
        public final C0522g copy(@Nullable Boolean bool, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
            return new C0522g(bool, str, str2, str3, str4, str5);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0522g)) {
                return false;
            }
            C0522g c0522g = (C0522g) obj;
            return t.d(this.isCountryDataProtected, c0522g.isCountryDataProtected) && t.d(this.consentTitle, c0522g.consentTitle) && t.d(this.consentMessage, c0522g.consentMessage) && t.d(this.consentMessageVersion, c0522g.consentMessageVersion) && t.d(this.buttonAccept, c0522g.buttonAccept) && t.d(this.buttonDeny, c0522g.buttonDeny);
        }

        @Nullable
        public final String getButtonAccept() {
            return this.buttonAccept;
        }

        @Nullable
        public final String getButtonDeny() {
            return this.buttonDeny;
        }

        @Nullable
        public final String getConsentMessage() {
            return this.consentMessage;
        }

        @Nullable
        public final String getConsentMessageVersion() {
            return this.consentMessageVersion;
        }

        @Nullable
        public final String getConsentTitle() {
            return this.consentTitle;
        }

        public int hashCode() {
            Boolean bool = this.isCountryDataProtected;
            int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            String str = this.consentTitle;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.consentMessage;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.consentMessageVersion;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.buttonAccept;
            int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.buttonDeny;
            return iHashCode5 + (str5 != null ? str5.hashCode() : 0);
        }

        @Nullable
        public final Boolean isCountryDataProtected() {
            return this.isCountryDataProtected;
        }

        @NotNull
        public String toString() {
            return "GDPRSettings(isCountryDataProtected=" + this.isCountryDataProtected + ", consentTitle=" + this.consentTitle + ", consentMessage=" + this.consentMessage + ", consentMessageVersion=" + this.consentMessageVersion + ", buttonAccept=" + this.buttonAccept + ", buttonDeny=" + this.buttonDeny + ')';
        }

        public /* synthetic */ C0522g(int i10, Boolean bool, String str, String str2, String str3, String str4, String str5, s1 s1Var) {
            if ((i10 & 0) != 0) {
                i1.a(i10, 0, a.INSTANCE.getDescriptor());
            }
            if ((i10 & 1) == 0) {
                this.isCountryDataProtected = null;
            } else {
                this.isCountryDataProtected = bool;
            }
            if ((i10 & 2) == 0) {
                this.consentTitle = null;
            } else {
                this.consentTitle = str;
            }
            if ((i10 & 4) == 0) {
                this.consentMessage = null;
            } else {
                this.consentMessage = str2;
            }
            if ((i10 & 8) == 0) {
                this.consentMessageVersion = null;
            } else {
                this.consentMessageVersion = str3;
            }
            if ((i10 & 16) == 0) {
                this.buttonAccept = null;
            } else {
                this.buttonAccept = str4;
            }
            if ((i10 & 32) == 0) {
                this.buttonDeny = null;
            } else {
                this.buttonDeny = str5;
            }
        }

        public C0522g(@Nullable Boolean bool, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
            this.isCountryDataProtected = bool;
            this.consentTitle = str;
            this.consentMessage = str2;
            this.consentMessageVersion = str3;
            this.buttonAccept = str4;
            this.buttonDeny = str5;
        }

        public /* synthetic */ C0522g(Boolean bool, String str, String str2, String str3, String str4, String str5, int i10, kotlin.jvm.internal.k kVar) {
            this((i10 & 1) != 0 ? null : bool, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? null : str2, (i10 & 8) != 0 ? null : str3, (i10 & 16) != 0 ? null : str4, (i10 & 32) != 0 ? null : str5);
        }

        public static /* synthetic */ void getButtonAccept$annotations() {
        }

        public static /* synthetic */ void getButtonDeny$annotations() {
        }

        public static /* synthetic */ void getConsentMessage$annotations() {
        }

        public static /* synthetic */ void getConsentMessageVersion$annotations() {
        }

        public static /* synthetic */ void getConsentTitle$annotations() {
        }

        public static /* synthetic */ void isCountryDataProtected$annotations() {
        }
    }

    /* JADX INFO: compiled from: ConfigPayload.kt */
    @z9.h
    public static final class h {

        @NotNull
        public static final b Companion = new b(null);

        @Nullable
        private final Integer tcfStatus;

        /* JADX INFO: compiled from: ConfigPayload.kt */
        public static final class a implements d0<h> {

            @NotNull
            public static final a INSTANCE;
            public static final /* synthetic */ SerialDescriptor descriptor;

            static {
                a aVar = new a();
                INSTANCE = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.ConfigPayload.IABSettings", aVar, 1);
                pluginGeneratedSerialDescriptor.k("tcf_status", true);
                descriptor = pluginGeneratedSerialDescriptor;
            }

            private a() {
            }

            @Override // da.d0
            @NotNull
            public KSerializer<?>[] childSerializers() {
                return new KSerializer[]{aa.a.s(l0.f24594a)};
            }

            @Override // z9.b
            @NotNull
            public h deserialize(@NotNull Decoder decoder) {
                Object objK;
                t.i(decoder, "decoder");
                SerialDescriptor descriptor2 = getDescriptor();
                ca.c cVarB = decoder.b(descriptor2);
                int i10 = 1;
                s1 s1Var = null;
                if (cVarB.p()) {
                    objK = cVarB.k(descriptor2, 0, l0.f24594a, null);
                } else {
                    int i11 = 0;
                    objK = null;
                    while (i10 != 0) {
                        int iO = cVarB.o(descriptor2);
                        if (iO == -1) {
                            i10 = 0;
                        } else {
                            if (iO != 0) {
                                throw new o(iO);
                            }
                            objK = cVarB.k(descriptor2, 0, l0.f24594a, objK);
                            i11 |= 1;
                        }
                    }
                    i10 = i11;
                }
                cVarB.c(descriptor2);
                return new h(i10, (Integer) objK, s1Var);
            }

            @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
            @NotNull
            public SerialDescriptor getDescriptor() {
                return descriptor;
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

            @Override // da.d0
            @NotNull
            public KSerializer<?>[] typeParametersSerializers() {
                return d0.a.a(this);
            }
        }

        /* JADX INFO: compiled from: ConfigPayload.kt */
        public static final class b {
            private b() {
            }

            public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
                this();
            }

            @NotNull
            public final KSerializer<h> serializer() {
                return a.INSTANCE;
            }
        }

        /* JADX INFO: compiled from: ConfigPayload.kt */
        public enum c {
            ALLOW_ID(0),
            DISABLE_ID(1),
            LEGACY(2);


            @NotNull
            public static final a Companion = new a(null);

            @NotNull
            private static final Map<Integer, c> rawValueMap;
            private final int rawValue;

            /* JADX INFO: compiled from: ConfigPayload.kt */
            public static final class a {
                private a() {
                }

                public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
                    this();
                }

                @Nullable
                public final c fromRawValue(@Nullable Integer num) {
                    return (c) c.rawValueMap.get(num);
                }
            }

            static {
                c[] cVarArrValues = values();
                LinkedHashMap linkedHashMap = new LinkedHashMap(n9.o.e(q0.d(cVarArrValues.length), 16));
                for (c cVar : cVarArrValues) {
                    linkedHashMap.put(Integer.valueOf(cVar.rawValue), cVar);
                }
                rawValueMap = linkedHashMap;
            }

            c(int i10) {
                this.rawValue = i10;
            }

            public final int getRawValue() {
                return this.rawValue;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public h() {
            this((Integer) null, 1, (kotlin.jvm.internal.k) (0 == true ? 1 : 0));
        }

        public static /* synthetic */ h copy$default(h hVar, Integer num, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                num = hVar.tcfStatus;
            }
            return hVar.copy(num);
        }

        public static final void write$Self(@NotNull h self, @NotNull ca.d output, @NotNull SerialDescriptor serialDesc) {
            t.i(self, "self");
            t.i(output, "output");
            t.i(serialDesc, "serialDesc");
            boolean z10 = true;
            if (!output.z(serialDesc, 0) && self.tcfStatus == null) {
                z10 = false;
            }
            if (z10) {
                output.h(serialDesc, 0, l0.f24594a, self.tcfStatus);
            }
        }

        @Nullable
        public final Integer component1() {
            return this.tcfStatus;
        }

        @NotNull
        public final h copy(@Nullable Integer num) {
            return new h(num);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof h) && t.d(this.tcfStatus, ((h) obj).tcfStatus);
        }

        @Nullable
        public final Integer getTcfStatus() {
            return this.tcfStatus;
        }

        public int hashCode() {
            Integer num = this.tcfStatus;
            if (num == null) {
                return 0;
            }
            return num.hashCode();
        }

        @NotNull
        public String toString() {
            return "IABSettings(tcfStatus=" + this.tcfStatus + ')';
        }

        public /* synthetic */ h(int i10, Integer num, s1 s1Var) {
            if ((i10 & 0) != 0) {
                i1.a(i10, 0, a.INSTANCE.getDescriptor());
            }
            if ((i10 & 1) == 0) {
                this.tcfStatus = null;
            } else {
                this.tcfStatus = num;
            }
        }

        public h(@Nullable Integer num) {
            this.tcfStatus = num;
        }

        public /* synthetic */ h(Integer num, int i10, kotlin.jvm.internal.k kVar) {
            this((i10 & 1) != 0 ? null : num);
        }

        public static /* synthetic */ void getTcfStatus$annotations() {
        }
    }

    /* JADX INFO: compiled from: ConfigPayload.kt */
    @z9.h
    public static final class i {

        @NotNull
        public static final b Companion = new b(null);

        @Nullable
        private final Integer errorLogLevel;

        @Nullable
        private final Boolean metricsEnabled;

        /* JADX INFO: compiled from: ConfigPayload.kt */
        public static final class a implements d0<i> {

            @NotNull
            public static final a INSTANCE;
            public static final /* synthetic */ SerialDescriptor descriptor;

            static {
                a aVar = new a();
                INSTANCE = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.ConfigPayload.LogMetricsSettings", aVar, 2);
                pluginGeneratedSerialDescriptor.k("error_log_level", true);
                pluginGeneratedSerialDescriptor.k("metrics_is_enabled", true);
                descriptor = pluginGeneratedSerialDescriptor;
            }

            private a() {
            }

            @Override // da.d0
            @NotNull
            public KSerializer<?>[] childSerializers() {
                return new KSerializer[]{aa.a.s(l0.f24594a), aa.a.s(da.h.f24574a)};
            }

            @Override // z9.b
            @NotNull
            public i deserialize(@NotNull Decoder decoder) {
                Object objK;
                Object objK2;
                int i10;
                t.i(decoder, "decoder");
                SerialDescriptor descriptor2 = getDescriptor();
                ca.c cVarB = decoder.b(descriptor2);
                s1 s1Var = null;
                if (cVarB.p()) {
                    objK = cVarB.k(descriptor2, 0, l0.f24594a, null);
                    objK2 = cVarB.k(descriptor2, 1, da.h.f24574a, null);
                    i10 = 3;
                } else {
                    boolean z10 = true;
                    int i11 = 0;
                    objK = null;
                    Object objK3 = null;
                    while (z10) {
                        int iO = cVarB.o(descriptor2);
                        if (iO == -1) {
                            z10 = false;
                        } else if (iO == 0) {
                            objK = cVarB.k(descriptor2, 0, l0.f24594a, objK);
                            i11 |= 1;
                        } else {
                            if (iO != 1) {
                                throw new o(iO);
                            }
                            objK3 = cVarB.k(descriptor2, 1, da.h.f24574a, objK3);
                            i11 |= 2;
                        }
                    }
                    objK2 = objK3;
                    i10 = i11;
                }
                cVarB.c(descriptor2);
                return new i(i10, (Integer) objK, (Boolean) objK2, s1Var);
            }

            @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
            @NotNull
            public SerialDescriptor getDescriptor() {
                return descriptor;
            }

            @Override // z9.j
            public void serialize(@NotNull Encoder encoder, @NotNull i value) {
                t.i(encoder, "encoder");
                t.i(value, "value");
                SerialDescriptor descriptor2 = getDescriptor();
                ca.d dVarB = encoder.b(descriptor2);
                i.write$Self(value, dVarB, descriptor2);
                dVarB.c(descriptor2);
            }

            @Override // da.d0
            @NotNull
            public KSerializer<?>[] typeParametersSerializers() {
                return d0.a.a(this);
            }
        }

        /* JADX INFO: compiled from: ConfigPayload.kt */
        public static final class b {
            private b() {
            }

            public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
                this();
            }

            @NotNull
            public final KSerializer<i> serializer() {
                return a.INSTANCE;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public i() {
            this((Integer) null, (Boolean) (0 == true ? 1 : 0), 3, (kotlin.jvm.internal.k) (0 == true ? 1 : 0));
        }

        public static /* synthetic */ i copy$default(i iVar, Integer num, Boolean bool, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                num = iVar.errorLogLevel;
            }
            if ((i10 & 2) != 0) {
                bool = iVar.metricsEnabled;
            }
            return iVar.copy(num, bool);
        }

        public static final void write$Self(@NotNull i self, @NotNull ca.d output, @NotNull SerialDescriptor serialDesc) {
            t.i(self, "self");
            t.i(output, "output");
            t.i(serialDesc, "serialDesc");
            if (output.z(serialDesc, 0) || self.errorLogLevel != null) {
                output.h(serialDesc, 0, l0.f24594a, self.errorLogLevel);
            }
            if (output.z(serialDesc, 1) || self.metricsEnabled != null) {
                output.h(serialDesc, 1, da.h.f24574a, self.metricsEnabled);
            }
        }

        @Nullable
        public final Integer component1() {
            return this.errorLogLevel;
        }

        @Nullable
        public final Boolean component2() {
            return this.metricsEnabled;
        }

        @NotNull
        public final i copy(@Nullable Integer num, @Nullable Boolean bool) {
            return new i(num, bool);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return t.d(this.errorLogLevel, iVar.errorLogLevel) && t.d(this.metricsEnabled, iVar.metricsEnabled);
        }

        @Nullable
        public final Integer getErrorLogLevel() {
            return this.errorLogLevel;
        }

        @Nullable
        public final Boolean getMetricsEnabled() {
            return this.metricsEnabled;
        }

        public int hashCode() {
            Integer num = this.errorLogLevel;
            int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
            Boolean bool = this.metricsEnabled;
            return iHashCode + (bool != null ? bool.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "LogMetricsSettings(errorLogLevel=" + this.errorLogLevel + ", metricsEnabled=" + this.metricsEnabled + ')';
        }

        public /* synthetic */ i(int i10, Integer num, Boolean bool, s1 s1Var) {
            if ((i10 & 0) != 0) {
                i1.a(i10, 0, a.INSTANCE.getDescriptor());
            }
            if ((i10 & 1) == 0) {
                this.errorLogLevel = null;
            } else {
                this.errorLogLevel = num;
            }
            if ((i10 & 2) == 0) {
                this.metricsEnabled = null;
            } else {
                this.metricsEnabled = bool;
            }
        }

        public i(@Nullable Integer num, @Nullable Boolean bool) {
            this.errorLogLevel = num;
            this.metricsEnabled = bool;
        }

        public /* synthetic */ i(Integer num, Boolean bool, int i10, kotlin.jvm.internal.k kVar) {
            this((i10 & 1) != 0 ? null : num, (i10 & 2) != 0 ? null : bool);
        }

        public static /* synthetic */ void getErrorLogLevel$annotations() {
        }

        public static /* synthetic */ void getMetricsEnabled$annotations() {
        }
    }

    /* JADX INFO: compiled from: ConfigPayload.kt */
    @z9.h
    public static final class j {

        @NotNull
        public static final b Companion = new b(null);

        @Nullable
        private final C0522g gdpr;

        @Nullable
        private final h iab;

        /* JADX INFO: compiled from: ConfigPayload.kt */
        public static final class a implements d0<j> {

            @NotNull
            public static final a INSTANCE;
            public static final /* synthetic */ SerialDescriptor descriptor;

            static {
                a aVar = new a();
                INSTANCE = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.ConfigPayload.UserPrivacy", aVar, 2);
                pluginGeneratedSerialDescriptor.k("gdpr", true);
                pluginGeneratedSerialDescriptor.k(OTVendorListMode.IAB, true);
                descriptor = pluginGeneratedSerialDescriptor;
            }

            private a() {
            }

            @Override // da.d0
            @NotNull
            public KSerializer<?>[] childSerializers() {
                return new KSerializer[]{aa.a.s(C0522g.a.INSTANCE), aa.a.s(h.a.INSTANCE)};
            }

            @Override // z9.b
            @NotNull
            public j deserialize(@NotNull Decoder decoder) {
                Object objK;
                Object objK2;
                int i10;
                t.i(decoder, "decoder");
                SerialDescriptor descriptor2 = getDescriptor();
                ca.c cVarB = decoder.b(descriptor2);
                s1 s1Var = null;
                if (cVarB.p()) {
                    objK = cVarB.k(descriptor2, 0, C0522g.a.INSTANCE, null);
                    objK2 = cVarB.k(descriptor2, 1, h.a.INSTANCE, null);
                    i10 = 3;
                } else {
                    boolean z10 = true;
                    int i11 = 0;
                    objK = null;
                    Object objK3 = null;
                    while (z10) {
                        int iO = cVarB.o(descriptor2);
                        if (iO == -1) {
                            z10 = false;
                        } else if (iO == 0) {
                            objK = cVarB.k(descriptor2, 0, C0522g.a.INSTANCE, objK);
                            i11 |= 1;
                        } else {
                            if (iO != 1) {
                                throw new o(iO);
                            }
                            objK3 = cVarB.k(descriptor2, 1, h.a.INSTANCE, objK3);
                            i11 |= 2;
                        }
                    }
                    objK2 = objK3;
                    i10 = i11;
                }
                cVarB.c(descriptor2);
                return new j(i10, (C0522g) objK, (h) objK2, s1Var);
            }

            @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
            @NotNull
            public SerialDescriptor getDescriptor() {
                return descriptor;
            }

            @Override // z9.j
            public void serialize(@NotNull Encoder encoder, @NotNull j value) {
                t.i(encoder, "encoder");
                t.i(value, "value");
                SerialDescriptor descriptor2 = getDescriptor();
                ca.d dVarB = encoder.b(descriptor2);
                j.write$Self(value, dVarB, descriptor2);
                dVarB.c(descriptor2);
            }

            @Override // da.d0
            @NotNull
            public KSerializer<?>[] typeParametersSerializers() {
                return d0.a.a(this);
            }
        }

        /* JADX INFO: compiled from: ConfigPayload.kt */
        public static final class b {
            private b() {
            }

            public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
                this();
            }

            @NotNull
            public final KSerializer<j> serializer() {
                return a.INSTANCE;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public j() {
            this((C0522g) null, (h) (0 == true ? 1 : 0), 3, (kotlin.jvm.internal.k) (0 == true ? 1 : 0));
        }

        public static /* synthetic */ j copy$default(j jVar, C0522g c0522g, h hVar, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                c0522g = jVar.gdpr;
            }
            if ((i10 & 2) != 0) {
                hVar = jVar.iab;
            }
            return jVar.copy(c0522g, hVar);
        }

        public static final void write$Self(@NotNull j self, @NotNull ca.d output, @NotNull SerialDescriptor serialDesc) {
            t.i(self, "self");
            t.i(output, "output");
            t.i(serialDesc, "serialDesc");
            if (output.z(serialDesc, 0) || self.gdpr != null) {
                output.h(serialDesc, 0, C0522g.a.INSTANCE, self.gdpr);
            }
            if (output.z(serialDesc, 1) || self.iab != null) {
                output.h(serialDesc, 1, h.a.INSTANCE, self.iab);
            }
        }

        @Nullable
        public final C0522g component1() {
            return this.gdpr;
        }

        @Nullable
        public final h component2() {
            return this.iab;
        }

        @NotNull
        public final j copy(@Nullable C0522g c0522g, @Nullable h hVar) {
            return new j(c0522g, hVar);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            return t.d(this.gdpr, jVar.gdpr) && t.d(this.iab, jVar.iab);
        }

        @Nullable
        public final C0522g getGdpr() {
            return this.gdpr;
        }

        @Nullable
        public final h getIab() {
            return this.iab;
        }

        public int hashCode() {
            C0522g c0522g = this.gdpr;
            int iHashCode = (c0522g == null ? 0 : c0522g.hashCode()) * 31;
            h hVar = this.iab;
            return iHashCode + (hVar != null ? hVar.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "UserPrivacy(gdpr=" + this.gdpr + ", iab=" + this.iab + ')';
        }

        public /* synthetic */ j(int i10, C0522g c0522g, h hVar, s1 s1Var) {
            if ((i10 & 0) != 0) {
                i1.a(i10, 0, a.INSTANCE.getDescriptor());
            }
            if ((i10 & 1) == 0) {
                this.gdpr = null;
            } else {
                this.gdpr = c0522g;
            }
            if ((i10 & 2) == 0) {
                this.iab = null;
            } else {
                this.iab = hVar;
            }
        }

        public j(@Nullable C0522g c0522g, @Nullable h hVar) {
            this.gdpr = c0522g;
            this.iab = hVar;
        }

        public /* synthetic */ j(C0522g c0522g, h hVar, int i10, kotlin.jvm.internal.k kVar) {
            this((i10 & 1) != 0 ? null : c0522g, (i10 & 2) != 0 ? null : hVar);
        }

        public static /* synthetic */ void getGdpr$annotations() {
        }

        public static /* synthetic */ void getIab$annotations() {
        }
    }

    /* JADX INFO: compiled from: ConfigPayload.kt */
    @z9.h
    public static final class k {

        @NotNull
        public static final b Companion = new b(null);

        @Nullable
        private final Boolean om;

        /* JADX INFO: compiled from: ConfigPayload.kt */
        public static final class a implements d0<k> {

            @NotNull
            public static final a INSTANCE;
            public static final /* synthetic */ SerialDescriptor descriptor;

            static {
                a aVar = new a();
                INSTANCE = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.ConfigPayload.ViewAbilitySettings", aVar, 1);
                pluginGeneratedSerialDescriptor.k("om", true);
                descriptor = pluginGeneratedSerialDescriptor;
            }

            private a() {
            }

            @Override // da.d0
            @NotNull
            public KSerializer<?>[] childSerializers() {
                return new KSerializer[]{aa.a.s(da.h.f24574a)};
            }

            @Override // z9.b
            @NotNull
            public k deserialize(@NotNull Decoder decoder) {
                Object objK;
                t.i(decoder, "decoder");
                SerialDescriptor descriptor2 = getDescriptor();
                ca.c cVarB = decoder.b(descriptor2);
                int i10 = 1;
                s1 s1Var = null;
                if (cVarB.p()) {
                    objK = cVarB.k(descriptor2, 0, da.h.f24574a, null);
                } else {
                    int i11 = 0;
                    objK = null;
                    while (i10 != 0) {
                        int iO = cVarB.o(descriptor2);
                        if (iO == -1) {
                            i10 = 0;
                        } else {
                            if (iO != 0) {
                                throw new o(iO);
                            }
                            objK = cVarB.k(descriptor2, 0, da.h.f24574a, objK);
                            i11 |= 1;
                        }
                    }
                    i10 = i11;
                }
                cVarB.c(descriptor2);
                return new k(i10, (Boolean) objK, s1Var);
            }

            @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
            @NotNull
            public SerialDescriptor getDescriptor() {
                return descriptor;
            }

            @Override // z9.j
            public void serialize(@NotNull Encoder encoder, @NotNull k value) {
                t.i(encoder, "encoder");
                t.i(value, "value");
                SerialDescriptor descriptor2 = getDescriptor();
                ca.d dVarB = encoder.b(descriptor2);
                k.write$Self(value, dVarB, descriptor2);
                dVarB.c(descriptor2);
            }

            @Override // da.d0
            @NotNull
            public KSerializer<?>[] typeParametersSerializers() {
                return d0.a.a(this);
            }
        }

        /* JADX INFO: compiled from: ConfigPayload.kt */
        public static final class b {
            private b() {
            }

            public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
                this();
            }

            @NotNull
            public final KSerializer<k> serializer() {
                return a.INSTANCE;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public k() {
            this((Boolean) null, 1, (kotlin.jvm.internal.k) (0 == true ? 1 : 0));
        }

        public static /* synthetic */ k copy$default(k kVar, Boolean bool, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                bool = kVar.om;
            }
            return kVar.copy(bool);
        }

        public static final void write$Self(@NotNull k self, @NotNull ca.d output, @NotNull SerialDescriptor serialDesc) {
            t.i(self, "self");
            t.i(output, "output");
            t.i(serialDesc, "serialDesc");
            boolean z10 = true;
            if (!output.z(serialDesc, 0) && self.om == null) {
                z10 = false;
            }
            if (z10) {
                output.h(serialDesc, 0, da.h.f24574a, self.om);
            }
        }

        @Nullable
        public final Boolean component1() {
            return this.om;
        }

        @NotNull
        public final k copy(@Nullable Boolean bool) {
            return new k(bool);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof k) && t.d(this.om, ((k) obj).om);
        }

        @Nullable
        public final Boolean getOm() {
            return this.om;
        }

        public int hashCode() {
            Boolean bool = this.om;
            if (bool == null) {
                return 0;
            }
            return bool.hashCode();
        }

        @NotNull
        public String toString() {
            return "ViewAbilitySettings(om=" + this.om + ')';
        }

        public /* synthetic */ k(int i10, Boolean bool, s1 s1Var) {
            if ((i10 & 0) != 0) {
                i1.a(i10, 0, a.INSTANCE.getDescriptor());
            }
            if ((i10 & 1) == 0) {
                this.om = null;
            } else {
                this.om = bool;
            }
        }

        public k(@Nullable Boolean bool) {
            this.om = bool;
        }

        public /* synthetic */ k(Boolean bool, int i10, kotlin.jvm.internal.k kVar) {
            this((i10 & 1) != 0 ? null : bool);
        }

        public static /* synthetic */ void getOm$annotations() {
        }
    }

    public g() {
        this((c) null, (e) null, (f) null, (i) null, (List) null, (j) null, (k) null, (String) null, (Boolean) null, (Boolean) null, (Integer) null, (Boolean) null, (Integer) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Long) null, (b) null, 524287, (kotlin.jvm.internal.k) null);
    }

    public static final void write$Self(@NotNull g self, @NotNull ca.d output, @NotNull SerialDescriptor serialDesc) {
        t.i(self, "self");
        t.i(output, "output");
        t.i(serialDesc, "serialDesc");
        if (output.z(serialDesc, 0) || self.cleverCache != null) {
            output.h(serialDesc, 0, c.a.INSTANCE, self.cleverCache);
        }
        if (output.z(serialDesc, 1) || self.configSettings != null) {
            output.h(serialDesc, 1, e.a.INSTANCE, self.configSettings);
        }
        if (output.z(serialDesc, 2) || self.endpoints != null) {
            output.h(serialDesc, 2, f.a.INSTANCE, self.endpoints);
        }
        if (output.z(serialDesc, 3) || self.logMetricsSettings != null) {
            output.h(serialDesc, 3, i.a.INSTANCE, self.logMetricsSettings);
        }
        if (output.z(serialDesc, 4) || self.placements != null) {
            output.h(serialDesc, 4, new da.f(j.a.INSTANCE), self.placements);
        }
        if (output.z(serialDesc, 5) || self.userPrivacy != null) {
            output.h(serialDesc, 5, j.a.INSTANCE, self.userPrivacy);
        }
        if (output.z(serialDesc, 6) || self.viewAbility != null) {
            output.h(serialDesc, 6, k.a.INSTANCE, self.viewAbility);
        }
        if (output.z(serialDesc, 7) || self.configExtension != null) {
            output.h(serialDesc, 7, w1.f24648a, self.configExtension);
        }
        if (output.z(serialDesc, 8) || !t.d(self.disableAdId, Boolean.TRUE)) {
            output.h(serialDesc, 8, da.h.f24574a, self.disableAdId);
        }
        if (output.z(serialDesc, 9) || self.isReportIncentivizedEnabled != null) {
            output.h(serialDesc, 9, da.h.f24574a, self.isReportIncentivizedEnabled);
        }
        if (output.z(serialDesc, 10) || self.sessionTimeout != null) {
            output.h(serialDesc, 10, l0.f24594a, self.sessionTimeout);
        }
        if (output.z(serialDesc, 11) || self.waitForConnectivityForTPAT != null) {
            output.h(serialDesc, 11, da.h.f24574a, self.waitForConnectivityForTPAT);
        }
        if (output.z(serialDesc, 12) || self.signalSessionTimeout != null) {
            output.h(serialDesc, 12, l0.f24594a, self.signalSessionTimeout);
        }
        if (output.z(serialDesc, 13) || self.isCacheableAssetsRequired != null) {
            output.h(serialDesc, 13, da.h.f24574a, self.isCacheableAssetsRequired);
        }
        if (output.z(serialDesc, 14) || self.signalsDisabled != null) {
            output.h(serialDesc, 14, da.h.f24574a, self.signalsDisabled);
        }
        if (output.z(serialDesc, 15) || self.fpdEnabled != null) {
            output.h(serialDesc, 15, da.h.f24574a, self.fpdEnabled);
        }
        if (output.z(serialDesc, 16) || self.rtaDebugging != null) {
            output.h(serialDesc, 16, da.h.f24574a, self.rtaDebugging);
        }
        if (output.z(serialDesc, 17) || self.configLastValidatedTimestamp != null) {
            output.h(serialDesc, 17, u0.f24629a, self.configLastValidatedTimestamp);
        }
        if (output.z(serialDesc, 18) || self.autoRedirect != null) {
            output.h(serialDesc, 18, b.a.INSTANCE, self.autoRedirect);
        }
    }

    @Nullable
    public final c component1() {
        return this.cleverCache;
    }

    @Nullable
    public final Boolean component10() {
        return this.isReportIncentivizedEnabled;
    }

    @Nullable
    public final Integer component11() {
        return this.sessionTimeout;
    }

    @Nullable
    public final Boolean component12() {
        return this.waitForConnectivityForTPAT;
    }

    @Nullable
    public final Integer component13() {
        return this.signalSessionTimeout;
    }

    @Nullable
    public final Boolean component14() {
        return this.isCacheableAssetsRequired;
    }

    @Nullable
    public final Boolean component15() {
        return this.signalsDisabled;
    }

    @Nullable
    public final Boolean component16() {
        return this.fpdEnabled;
    }

    @Nullable
    public final Boolean component17() {
        return this.rtaDebugging;
    }

    @Nullable
    public final Long component18() {
        return this.configLastValidatedTimestamp;
    }

    @Nullable
    public final b component19() {
        return this.autoRedirect;
    }

    @Nullable
    public final e component2() {
        return this.configSettings;
    }

    @Nullable
    public final f component3() {
        return this.endpoints;
    }

    @Nullable
    public final i component4() {
        return this.logMetricsSettings;
    }

    @Nullable
    public final List<com.vungle.ads.internal.model.j> component5() {
        return this.placements;
    }

    @Nullable
    public final j component6() {
        return this.userPrivacy;
    }

    @Nullable
    public final k component7() {
        return this.viewAbility;
    }

    @Nullable
    public final String component8() {
        return this.configExtension;
    }

    @Nullable
    public final Boolean component9() {
        return this.disableAdId;
    }

    @NotNull
    public final g copy(@Nullable c cVar, @Nullable e eVar, @Nullable f fVar, @Nullable i iVar, @Nullable List<com.vungle.ads.internal.model.j> list, @Nullable j jVar, @Nullable k kVar, @Nullable String str, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Integer num, @Nullable Boolean bool3, @Nullable Integer num2, @Nullable Boolean bool4, @Nullable Boolean bool5, @Nullable Boolean bool6, @Nullable Boolean bool7, @Nullable Long l10, @Nullable b bVar) {
        return new g(cVar, eVar, fVar, iVar, list, jVar, kVar, str, bool, bool2, num, bool3, num2, bool4, bool5, bool6, bool7, l10, bVar);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return t.d(this.cleverCache, gVar.cleverCache) && t.d(this.configSettings, gVar.configSettings) && t.d(this.endpoints, gVar.endpoints) && t.d(this.logMetricsSettings, gVar.logMetricsSettings) && t.d(this.placements, gVar.placements) && t.d(this.userPrivacy, gVar.userPrivacy) && t.d(this.viewAbility, gVar.viewAbility) && t.d(this.configExtension, gVar.configExtension) && t.d(this.disableAdId, gVar.disableAdId) && t.d(this.isReportIncentivizedEnabled, gVar.isReportIncentivizedEnabled) && t.d(this.sessionTimeout, gVar.sessionTimeout) && t.d(this.waitForConnectivityForTPAT, gVar.waitForConnectivityForTPAT) && t.d(this.signalSessionTimeout, gVar.signalSessionTimeout) && t.d(this.isCacheableAssetsRequired, gVar.isCacheableAssetsRequired) && t.d(this.signalsDisabled, gVar.signalsDisabled) && t.d(this.fpdEnabled, gVar.fpdEnabled) && t.d(this.rtaDebugging, gVar.rtaDebugging) && t.d(this.configLastValidatedTimestamp, gVar.configLastValidatedTimestamp) && t.d(this.autoRedirect, gVar.autoRedirect);
    }

    @Nullable
    public final b getAutoRedirect() {
        return this.autoRedirect;
    }

    @Nullable
    public final c getCleverCache() {
        return this.cleverCache;
    }

    @Nullable
    public final String getConfigExtension() {
        return this.configExtension;
    }

    @Nullable
    public final Long getConfigLastValidatedTimestamp() {
        return this.configLastValidatedTimestamp;
    }

    @Nullable
    public final e getConfigSettings() {
        return this.configSettings;
    }

    @Nullable
    public final Boolean getDisableAdId() {
        return this.disableAdId;
    }

    @Nullable
    public final f getEndpoints() {
        return this.endpoints;
    }

    @Nullable
    public final Boolean getFpdEnabled() {
        return this.fpdEnabled;
    }

    @Nullable
    public final i getLogMetricsSettings() {
        return this.logMetricsSettings;
    }

    @Nullable
    public final List<com.vungle.ads.internal.model.j> getPlacements() {
        return this.placements;
    }

    @Nullable
    public final Boolean getRtaDebugging() {
        return this.rtaDebugging;
    }

    @Nullable
    public final Integer getSessionTimeout() {
        return this.sessionTimeout;
    }

    @Nullable
    public final Integer getSignalSessionTimeout() {
        return this.signalSessionTimeout;
    }

    @Nullable
    public final Boolean getSignalsDisabled() {
        return this.signalsDisabled;
    }

    @Nullable
    public final j getUserPrivacy() {
        return this.userPrivacy;
    }

    @Nullable
    public final k getViewAbility() {
        return this.viewAbility;
    }

    @Nullable
    public final Boolean getWaitForConnectivityForTPAT() {
        return this.waitForConnectivityForTPAT;
    }

    public int hashCode() {
        c cVar = this.cleverCache;
        int iHashCode = (cVar == null ? 0 : cVar.hashCode()) * 31;
        e eVar = this.configSettings;
        int iHashCode2 = (iHashCode + (eVar == null ? 0 : eVar.hashCode())) * 31;
        f fVar = this.endpoints;
        int iHashCode3 = (iHashCode2 + (fVar == null ? 0 : fVar.hashCode())) * 31;
        i iVar = this.logMetricsSettings;
        int iHashCode4 = (iHashCode3 + (iVar == null ? 0 : iVar.hashCode())) * 31;
        List<com.vungle.ads.internal.model.j> list = this.placements;
        int iHashCode5 = (iHashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        j jVar = this.userPrivacy;
        int iHashCode6 = (iHashCode5 + (jVar == null ? 0 : jVar.hashCode())) * 31;
        k kVar = this.viewAbility;
        int iHashCode7 = (iHashCode6 + (kVar == null ? 0 : kVar.hashCode())) * 31;
        String str = this.configExtension;
        int iHashCode8 = (iHashCode7 + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.disableAdId;
        int iHashCode9 = (iHashCode8 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isReportIncentivizedEnabled;
        int iHashCode10 = (iHashCode9 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Integer num = this.sessionTimeout;
        int iHashCode11 = (iHashCode10 + (num == null ? 0 : num.hashCode())) * 31;
        Boolean bool3 = this.waitForConnectivityForTPAT;
        int iHashCode12 = (iHashCode11 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Integer num2 = this.signalSessionTimeout;
        int iHashCode13 = (iHashCode12 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Boolean bool4 = this.isCacheableAssetsRequired;
        int iHashCode14 = (iHashCode13 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Boolean bool5 = this.signalsDisabled;
        int iHashCode15 = (iHashCode14 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        Boolean bool6 = this.fpdEnabled;
        int iHashCode16 = (iHashCode15 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
        Boolean bool7 = this.rtaDebugging;
        int iHashCode17 = (iHashCode16 + (bool7 == null ? 0 : bool7.hashCode())) * 31;
        Long l10 = this.configLastValidatedTimestamp;
        int iHashCode18 = (iHashCode17 + (l10 == null ? 0 : l10.hashCode())) * 31;
        b bVar = this.autoRedirect;
        return iHashCode18 + (bVar != null ? bVar.hashCode() : 0);
    }

    @Nullable
    public final Boolean isCacheableAssetsRequired() {
        return this.isCacheableAssetsRequired;
    }

    @Nullable
    public final Boolean isReportIncentivizedEnabled() {
        return this.isReportIncentivizedEnabled;
    }

    public final void setAutoRedirect(@Nullable b bVar) {
        this.autoRedirect = bVar;
    }

    public final void setConfigLastValidatedTimestamp(@Nullable Long l10) {
        this.configLastValidatedTimestamp = l10;
    }

    @NotNull
    public String toString() {
        return "ConfigPayload(cleverCache=" + this.cleverCache + ", configSettings=" + this.configSettings + ", endpoints=" + this.endpoints + ", logMetricsSettings=" + this.logMetricsSettings + ", placements=" + this.placements + ", userPrivacy=" + this.userPrivacy + ", viewAbility=" + this.viewAbility + ", configExtension=" + this.configExtension + ", disableAdId=" + this.disableAdId + ", isReportIncentivizedEnabled=" + this.isReportIncentivizedEnabled + ", sessionTimeout=" + this.sessionTimeout + ", waitForConnectivityForTPAT=" + this.waitForConnectivityForTPAT + ", signalSessionTimeout=" + this.signalSessionTimeout + ", isCacheableAssetsRequired=" + this.isCacheableAssetsRequired + ", signalsDisabled=" + this.signalsDisabled + ", fpdEnabled=" + this.fpdEnabled + ", rtaDebugging=" + this.rtaDebugging + ", configLastValidatedTimestamp=" + this.configLastValidatedTimestamp + ", autoRedirect=" + this.autoRedirect + ')';
    }

    public /* synthetic */ g(int i10, c cVar, e eVar, f fVar, i iVar, List list, j jVar, k kVar, String str, Boolean bool, Boolean bool2, Integer num, Boolean bool3, Integer num2, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Long l10, b bVar, s1 s1Var) {
        if ((i10 & 0) != 0) {
            i1.a(i10, 0, a.INSTANCE.getDescriptor());
        }
        if ((i10 & 1) == 0) {
            this.cleverCache = null;
        } else {
            this.cleverCache = cVar;
        }
        if ((i10 & 2) == 0) {
            this.configSettings = null;
        } else {
            this.configSettings = eVar;
        }
        if ((i10 & 4) == 0) {
            this.endpoints = null;
        } else {
            this.endpoints = fVar;
        }
        if ((i10 & 8) == 0) {
            this.logMetricsSettings = null;
        } else {
            this.logMetricsSettings = iVar;
        }
        if ((i10 & 16) == 0) {
            this.placements = null;
        } else {
            this.placements = list;
        }
        if ((i10 & 32) == 0) {
            this.userPrivacy = null;
        } else {
            this.userPrivacy = jVar;
        }
        if ((i10 & 64) == 0) {
            this.viewAbility = null;
        } else {
            this.viewAbility = kVar;
        }
        if ((i10 & 128) == 0) {
            this.configExtension = null;
        } else {
            this.configExtension = str;
        }
        this.disableAdId = (i10 & 256) == 0 ? Boolean.TRUE : bool;
        if ((i10 & 512) == 0) {
            this.isReportIncentivizedEnabled = null;
        } else {
            this.isReportIncentivizedEnabled = bool2;
        }
        if ((i10 & 1024) == 0) {
            this.sessionTimeout = null;
        } else {
            this.sessionTimeout = num;
        }
        if ((i10 & 2048) == 0) {
            this.waitForConnectivityForTPAT = null;
        } else {
            this.waitForConnectivityForTPAT = bool3;
        }
        if ((i10 & 4096) == 0) {
            this.signalSessionTimeout = null;
        } else {
            this.signalSessionTimeout = num2;
        }
        if ((i10 & 8192) == 0) {
            this.isCacheableAssetsRequired = null;
        } else {
            this.isCacheableAssetsRequired = bool4;
        }
        if ((i10 & 16384) == 0) {
            this.signalsDisabled = null;
        } else {
            this.signalsDisabled = bool5;
        }
        if ((32768 & i10) == 0) {
            this.fpdEnabled = null;
        } else {
            this.fpdEnabled = bool6;
        }
        if ((65536 & i10) == 0) {
            this.rtaDebugging = null;
        } else {
            this.rtaDebugging = bool7;
        }
        if ((131072 & i10) == 0) {
            this.configLastValidatedTimestamp = null;
        } else {
            this.configLastValidatedTimestamp = l10;
        }
        if ((i10 & 262144) == 0) {
            this.autoRedirect = null;
        } else {
            this.autoRedirect = bVar;
        }
    }

    public g(@Nullable c cVar, @Nullable e eVar, @Nullable f fVar, @Nullable i iVar, @Nullable List<com.vungle.ads.internal.model.j> list, @Nullable j jVar, @Nullable k kVar, @Nullable String str, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Integer num, @Nullable Boolean bool3, @Nullable Integer num2, @Nullable Boolean bool4, @Nullable Boolean bool5, @Nullable Boolean bool6, @Nullable Boolean bool7, @Nullable Long l10, @Nullable b bVar) {
        this.cleverCache = cVar;
        this.configSettings = eVar;
        this.endpoints = fVar;
        this.logMetricsSettings = iVar;
        this.placements = list;
        this.userPrivacy = jVar;
        this.viewAbility = kVar;
        this.configExtension = str;
        this.disableAdId = bool;
        this.isReportIncentivizedEnabled = bool2;
        this.sessionTimeout = num;
        this.waitForConnectivityForTPAT = bool3;
        this.signalSessionTimeout = num2;
        this.isCacheableAssetsRequired = bool4;
        this.signalsDisabled = bool5;
        this.fpdEnabled = bool6;
        this.rtaDebugging = bool7;
        this.configLastValidatedTimestamp = l10;
        this.autoRedirect = bVar;
    }

    public static /* synthetic */ void getAutoRedirect$annotations() {
    }

    public static /* synthetic */ void getCleverCache$annotations() {
    }

    public static /* synthetic */ void getConfigExtension$annotations() {
    }

    public static /* synthetic */ void getConfigLastValidatedTimestamp$annotations() {
    }

    public static /* synthetic */ void getConfigSettings$annotations() {
    }

    public static /* synthetic */ void getDisableAdId$annotations() {
    }

    public static /* synthetic */ void getEndpoints$annotations() {
    }

    public static /* synthetic */ void getFpdEnabled$annotations() {
    }

    public static /* synthetic */ void getLogMetricsSettings$annotations() {
    }

    public static /* synthetic */ void getPlacements$annotations() {
    }

    public static /* synthetic */ void getRtaDebugging$annotations() {
    }

    public static /* synthetic */ void getSessionTimeout$annotations() {
    }

    public static /* synthetic */ void getSignalSessionTimeout$annotations() {
    }

    public static /* synthetic */ void getSignalsDisabled$annotations() {
    }

    public static /* synthetic */ void getUserPrivacy$annotations() {
    }

    public static /* synthetic */ void getViewAbility$annotations() {
    }

    public static /* synthetic */ void getWaitForConnectivityForTPAT$annotations() {
    }

    public static /* synthetic */ void isCacheableAssetsRequired$annotations() {
    }

    public static /* synthetic */ void isReportIncentivizedEnabled$annotations() {
    }

    public /* synthetic */ g(c cVar, e eVar, f fVar, i iVar, List list, j jVar, k kVar, String str, Boolean bool, Boolean bool2, Integer num, Boolean bool3, Integer num2, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Long l10, b bVar, int i10, kotlin.jvm.internal.k kVar2) {
        this((i10 & 1) != 0 ? null : cVar, (i10 & 2) != 0 ? null : eVar, (i10 & 4) != 0 ? null : fVar, (i10 & 8) != 0 ? null : iVar, (i10 & 16) != 0 ? null : list, (i10 & 32) != 0 ? null : jVar, (i10 & 64) != 0 ? null : kVar, (i10 & 128) != 0 ? null : str, (i10 & 256) != 0 ? Boolean.TRUE : bool, (i10 & 512) != 0 ? null : bool2, (i10 & 1024) != 0 ? null : num, (i10 & 2048) != 0 ? null : bool3, (i10 & 4096) != 0 ? null : num2, (i10 & 8192) != 0 ? null : bool4, (i10 & 16384) != 0 ? null : bool5, (i10 & 32768) != 0 ? null : bool6, (i10 & 65536) != 0 ? null : bool7, (i10 & 131072) != 0 ? null : l10, (i10 & 262144) != 0 ? null : bVar);
    }
}
