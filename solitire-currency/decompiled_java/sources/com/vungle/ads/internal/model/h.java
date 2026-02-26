package com.vungle.ads.internal.model;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.ironsource.ad;
import da.c0;
import da.d0;
import da.i1;
import da.l0;
import da.s1;
import da.w1;
import io.sentry.protocol.Device;
import kotlin.jvm.internal.t;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z9.o;

/* JADX INFO: compiled from: DeviceNode.kt */
/* JADX INFO: loaded from: classes4.dex */
@z9.h
public final class h {

    @NotNull
    public static final b Companion = new b(null);

    @Nullable
    private final String carrier;

    @Nullable
    private c ext;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f24348h;

    @Nullable
    private String ifa;

    @Nullable
    private Integer lmt;

    @NotNull
    private final String make;

    @NotNull
    private final String model;

    @NotNull
    private final String os;

    @NotNull
    private final String osv;

    /* JADX INFO: renamed from: ua, reason: collision with root package name */
    @Nullable
    private String f24349ua;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final int f24350w;

    /* JADX INFO: compiled from: DeviceNode.kt */
    public static final class a implements d0<h> {

        @NotNull
        public static final a INSTANCE;
        public static final /* synthetic */ SerialDescriptor descriptor;

        static {
            a aVar = new a();
            INSTANCE = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.DeviceNode", aVar, 11);
            pluginGeneratedSerialDescriptor.k(ad.f11262r, false);
            pluginGeneratedSerialDescriptor.k("model", false);
            pluginGeneratedSerialDescriptor.k(ad.f11278z, false);
            pluginGeneratedSerialDescriptor.k(ad.f11277y0, true);
            pluginGeneratedSerialDescriptor.k("os", false);
            pluginGeneratedSerialDescriptor.k("w", false);
            pluginGeneratedSerialDescriptor.k(CmcdData.Factory.STREAMING_FORMAT_HLS, false);
            pluginGeneratedSerialDescriptor.k(ad.U, true);
            pluginGeneratedSerialDescriptor.k("ifa", true);
            pluginGeneratedSerialDescriptor.k("lmt", true);
            pluginGeneratedSerialDescriptor.k("ext", true);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        private a() {
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] childSerializers() {
            w1 w1Var = w1.f24648a;
            l0 l0Var = l0.f24594a;
            return new KSerializer[]{w1Var, w1Var, w1Var, aa.a.s(w1Var), w1Var, l0Var, l0Var, aa.a.s(w1Var), aa.a.s(w1Var), aa.a.s(l0Var), aa.a.s(c.a.INSTANCE)};
        }

        @Override // z9.b
        @NotNull
        public h deserialize(@NotNull Decoder decoder) {
            Object objK;
            String strN;
            Object objK2;
            Object objK3;
            Object objK4;
            Object objK5;
            int i10;
            String str;
            String str2;
            int i11;
            int i12;
            String str3;
            t.i(decoder, "decoder");
            SerialDescriptor descriptor2 = getDescriptor();
            ca.c cVarB = decoder.b(descriptor2);
            int i13 = 10;
            int i14 = 9;
            if (cVarB.p()) {
                String strN2 = cVarB.n(descriptor2, 0);
                String strN3 = cVarB.n(descriptor2, 1);
                String strN4 = cVarB.n(descriptor2, 2);
                w1 w1Var = w1.f24648a;
                objK5 = cVarB.k(descriptor2, 3, w1Var, null);
                String strN5 = cVarB.n(descriptor2, 4);
                int i15 = cVarB.i(descriptor2, 5);
                int i16 = cVarB.i(descriptor2, 6);
                objK4 = cVarB.k(descriptor2, 7, w1Var, null);
                Object objK6 = cVarB.k(descriptor2, 8, w1Var, null);
                objK2 = cVarB.k(descriptor2, 9, l0.f24594a, null);
                objK3 = cVarB.k(descriptor2, 10, c.a.INSTANCE, null);
                i11 = i16;
                i12 = i15;
                str3 = strN5;
                strN = strN3;
                str = strN2;
                str2 = strN4;
                objK = objK6;
                i10 = 2047;
            } else {
                boolean z10 = true;
                int i17 = 0;
                int i18 = 0;
                Object objK7 = null;
                Object objK8 = null;
                objK = null;
                Object objK9 = null;
                String strN6 = null;
                strN = null;
                String strN7 = null;
                String strN8 = null;
                Object objK10 = null;
                int i19 = 0;
                while (z10) {
                    int iO = cVarB.o(descriptor2);
                    switch (iO) {
                        case -1:
                            z10 = false;
                            i13 = 10;
                            break;
                        case 0:
                            strN6 = cVarB.n(descriptor2, 0);
                            i18 |= 1;
                            i13 = 10;
                            i14 = 9;
                            break;
                        case 1:
                            strN = cVarB.n(descriptor2, 1);
                            i18 |= 2;
                            i13 = 10;
                            i14 = 9;
                            break;
                        case 2:
                            strN7 = cVarB.n(descriptor2, 2);
                            i18 |= 4;
                            i13 = 10;
                            i14 = 9;
                            break;
                        case 3:
                            objK10 = cVarB.k(descriptor2, 3, w1.f24648a, objK10);
                            i18 |= 8;
                            i13 = 10;
                            i14 = 9;
                            break;
                        case 4:
                            strN8 = cVarB.n(descriptor2, 4);
                            i18 |= 16;
                            i13 = 10;
                            break;
                        case 5:
                            i19 = cVarB.i(descriptor2, 5);
                            i18 |= 32;
                            break;
                        case 6:
                            i17 = cVarB.i(descriptor2, 6);
                            i18 |= 64;
                            break;
                        case 7:
                            objK9 = cVarB.k(descriptor2, 7, w1.f24648a, objK9);
                            i18 |= 128;
                            break;
                        case 8:
                            objK = cVarB.k(descriptor2, 8, w1.f24648a, objK);
                            i18 |= 256;
                            break;
                        case 9:
                            objK7 = cVarB.k(descriptor2, i14, l0.f24594a, objK7);
                            i18 |= 512;
                            break;
                        case 10:
                            objK8 = cVarB.k(descriptor2, i13, c.a.INSTANCE, objK8);
                            i18 |= 1024;
                            break;
                        default:
                            throw new o(iO);
                    }
                }
                objK2 = objK7;
                objK3 = objK8;
                objK4 = objK9;
                objK5 = objK10;
                i10 = i18;
                str = strN6;
                str2 = strN7;
                i11 = i17;
                i12 = i19;
                str3 = strN8;
            }
            cVarB.c(descriptor2);
            return new h(i10, str, strN, str2, (String) objK5, str3, i12, i11, (String) objK4, (String) objK, (Integer) objK2, (c) objK3, (s1) null);
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

    /* JADX INFO: compiled from: DeviceNode.kt */
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

    /* JADX INFO: compiled from: DeviceNode.kt */
    @z9.h
    public static final class c {

        @NotNull
        public static final b Companion = new b(null);

        @Nullable
        private String amazonAdvertisingId;

        @Nullable
        private String appSetId;

        @Nullable
        private Integer appSetIdScope;
        private float batteryLevel;
        private int batterySaverEnabled;

        @Nullable
        private String batteryState;

        @Nullable
        private String connectionType;

        @Nullable
        private String connectionTypeDetail;

        @Nullable
        private String gaid;
        private boolean isGooglePlayServicesAvailable;
        private boolean isSideloadEnabled;
        private boolean isTv;

        @Nullable
        private String language;

        @Nullable
        private String locale;
        private int sdCardAvailable;
        private int soundEnabled;

        @Nullable
        private String timeZone;
        private float volumeLevel;

        /* JADX INFO: compiled from: DeviceNode.kt */
        public static final class a implements d0<c> {

            @NotNull
            public static final a INSTANCE;
            public static final /* synthetic */ SerialDescriptor descriptor;

            static {
                a aVar = new a();
                INSTANCE = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.DeviceNode.VungleExt", aVar, 18);
                pluginGeneratedSerialDescriptor.k("is_google_play_services_available", true);
                pluginGeneratedSerialDescriptor.k("app_set_id", true);
                pluginGeneratedSerialDescriptor.k("app_set_id_scope", true);
                pluginGeneratedSerialDescriptor.k(Device.JsonKeys.BATTERY_LEVEL, true);
                pluginGeneratedSerialDescriptor.k("battery_state", true);
                pluginGeneratedSerialDescriptor.k("battery_saver_enabled", true);
                pluginGeneratedSerialDescriptor.k(Device.JsonKeys.CONNECTION_TYPE, true);
                pluginGeneratedSerialDescriptor.k("connection_type_detail", true);
                pluginGeneratedSerialDescriptor.k(Device.JsonKeys.LOCALE, true);
                pluginGeneratedSerialDescriptor.k("language", true);
                pluginGeneratedSerialDescriptor.k("time_zone", true);
                pluginGeneratedSerialDescriptor.k("volume_level", true);
                pluginGeneratedSerialDescriptor.k("sound_enabled", true);
                pluginGeneratedSerialDescriptor.k("is_tv", true);
                pluginGeneratedSerialDescriptor.k("sd_card_available", true);
                pluginGeneratedSerialDescriptor.k("is_sideload_enabled", true);
                pluginGeneratedSerialDescriptor.k(ad.D0, true);
                pluginGeneratedSerialDescriptor.k("amazon_advertising_id", true);
                descriptor = pluginGeneratedSerialDescriptor;
            }

            private a() {
            }

            @Override // da.d0
            @NotNull
            public KSerializer<?>[] childSerializers() {
                da.h hVar = da.h.f24574a;
                w1 w1Var = w1.f24648a;
                l0 l0Var = l0.f24594a;
                c0 c0Var = c0.f24548a;
                return new KSerializer[]{hVar, aa.a.s(w1Var), aa.a.s(l0Var), c0Var, aa.a.s(w1Var), l0Var, aa.a.s(w1Var), aa.a.s(w1Var), aa.a.s(w1Var), aa.a.s(w1Var), aa.a.s(w1Var), c0Var, l0Var, hVar, l0Var, hVar, aa.a.s(w1Var), aa.a.s(w1Var)};
            }

            @Override // z9.b
            @NotNull
            public c deserialize(@NotNull Decoder decoder) {
                Object objK;
                int i10;
                float fU;
                Object obj;
                Object obj2;
                Object obj3;
                boolean z10;
                Object objK2;
                Object objK3;
                Object obj4;
                Object objK4;
                int i11;
                boolean z11;
                int i12;
                float f10;
                int i13;
                Object obj5;
                boolean z12;
                Object obj6;
                Object obj7;
                Object obj8;
                t.i(decoder, "decoder");
                SerialDescriptor descriptor2 = getDescriptor();
                ca.c cVarB = decoder.b(descriptor2);
                int i14 = 0;
                if (cVarB.p()) {
                    boolean zC = cVarB.C(descriptor2, 0);
                    w1 w1Var = w1.f24648a;
                    Object objK5 = cVarB.k(descriptor2, 1, w1Var, null);
                    Object objK6 = cVarB.k(descriptor2, 2, l0.f24594a, null);
                    float fU2 = cVarB.u(descriptor2, 3);
                    Object objK7 = cVarB.k(descriptor2, 4, w1Var, null);
                    int i15 = cVarB.i(descriptor2, 5);
                    Object objK8 = cVarB.k(descriptor2, 6, w1Var, null);
                    Object objK9 = cVarB.k(descriptor2, 7, w1Var, null);
                    objK3 = cVarB.k(descriptor2, 8, w1Var, null);
                    Object objK10 = cVarB.k(descriptor2, 9, w1Var, null);
                    objK2 = cVarB.k(descriptor2, 10, w1Var, null);
                    float fU3 = cVarB.u(descriptor2, 11);
                    int i16 = cVarB.i(descriptor2, 12);
                    boolean zC2 = cVarB.C(descriptor2, 13);
                    int i17 = cVarB.i(descriptor2, 14);
                    boolean zC3 = cVarB.C(descriptor2, 15);
                    obj2 = objK5;
                    objK4 = cVarB.k(descriptor2, 16, w1Var, null);
                    Object objK11 = cVarB.k(descriptor2, 17, w1Var, null);
                    i10 = i16;
                    fU = fU2;
                    obj5 = objK10;
                    obj4 = objK8;
                    obj = objK7;
                    f10 = fU3;
                    z11 = zC3;
                    i11 = i17;
                    z10 = zC2;
                    z12 = zC;
                    objK = objK9;
                    i12 = i15;
                    i13 = 262143;
                    obj6 = objK11;
                    obj3 = objK6;
                } else {
                    int i18 = 17;
                    Object objK12 = null;
                    Object objK13 = null;
                    Object objK14 = null;
                    Object objK15 = null;
                    Object objK16 = null;
                    Object objK17 = null;
                    Object objK18 = null;
                    objK = null;
                    Object objK19 = null;
                    int i19 = 0;
                    boolean zC4 = false;
                    i10 = 0;
                    int i20 = 0;
                    boolean z13 = true;
                    fU = 0.0f;
                    float fU4 = 0.0f;
                    Object objK20 = null;
                    boolean zC5 = false;
                    boolean zC6 = false;
                    while (z13) {
                        int iO = cVarB.o(descriptor2);
                        switch (iO) {
                            case -1:
                                obj8 = objK19;
                                z13 = false;
                                objK13 = objK13;
                                objK19 = obj8;
                                i18 = 17;
                                break;
                            case 0:
                                obj8 = objK19;
                                zC5 = cVarB.C(descriptor2, 0);
                                i14 |= 1;
                                objK13 = objK13;
                                objK12 = objK12;
                                objK19 = obj8;
                                i18 = 17;
                                break;
                            case 1:
                                Object obj9 = objK13;
                                i14 |= 2;
                                objK12 = objK12;
                                i18 = 17;
                                objK19 = cVarB.k(descriptor2, 1, w1.f24648a, objK19);
                                objK13 = obj9;
                                break;
                            case 2:
                                obj7 = objK13;
                                objK20 = cVarB.k(descriptor2, 2, l0.f24594a, objK20);
                                i14 |= 4;
                                objK13 = obj7;
                                i18 = 17;
                                break;
                            case 3:
                                obj7 = objK13;
                                fU = cVarB.u(descriptor2, 3);
                                i14 |= 8;
                                objK13 = obj7;
                                i18 = 17;
                                break;
                            case 4:
                                obj7 = objK13;
                                objK12 = cVarB.k(descriptor2, 4, w1.f24648a, objK12);
                                i14 |= 16;
                                objK13 = obj7;
                                i18 = 17;
                                break;
                            case 5:
                                obj7 = objK13;
                                i20 = cVarB.i(descriptor2, 5);
                                i14 |= 32;
                                objK13 = obj7;
                                i18 = 17;
                                break;
                            case 6:
                                obj7 = objK13;
                                objK18 = cVarB.k(descriptor2, 6, w1.f24648a, objK18);
                                i14 |= 64;
                                objK13 = obj7;
                                i18 = 17;
                                break;
                            case 7:
                                obj7 = objK13;
                                objK = cVarB.k(descriptor2, 7, w1.f24648a, objK);
                                i14 |= 128;
                                objK13 = obj7;
                                i18 = 17;
                                break;
                            case 8:
                                obj7 = objK13;
                                objK17 = cVarB.k(descriptor2, 8, w1.f24648a, objK17);
                                i14 |= 256;
                                objK13 = obj7;
                                i18 = 17;
                                break;
                            case 9:
                                obj7 = objK13;
                                objK16 = cVarB.k(descriptor2, 9, w1.f24648a, objK16);
                                i14 |= 512;
                                objK13 = obj7;
                                i18 = 17;
                                break;
                            case 10:
                                objK15 = cVarB.k(descriptor2, 10, w1.f24648a, objK15);
                                i14 |= 1024;
                                objK13 = objK13;
                                i18 = 17;
                                break;
                            case 11:
                                fU4 = cVarB.u(descriptor2, 11);
                                i14 |= 2048;
                                i18 = 17;
                                break;
                            case 12:
                                i10 = cVarB.i(descriptor2, 12);
                                i14 |= 4096;
                                i18 = 17;
                                break;
                            case 13:
                                i14 |= 8192;
                                zC6 = cVarB.C(descriptor2, 13);
                                i18 = 17;
                                break;
                            case 14:
                                i19 = cVarB.i(descriptor2, 14);
                                i14 |= 16384;
                                i18 = 17;
                                break;
                            case 15:
                                zC4 = cVarB.C(descriptor2, 15);
                                i14 |= 32768;
                                i18 = 17;
                                break;
                            case 16:
                                objK13 = cVarB.k(descriptor2, 16, w1.f24648a, objK13);
                                i14 |= 65536;
                                i18 = 17;
                                break;
                            case 17:
                                objK14 = cVarB.k(descriptor2, i18, w1.f24648a, objK14);
                                i14 |= 131072;
                                break;
                            default:
                                throw new o(iO);
                        }
                    }
                    Object obj10 = objK13;
                    Object obj11 = objK19;
                    obj = objK12;
                    obj2 = obj11;
                    obj3 = objK20;
                    z10 = zC6;
                    objK2 = objK15;
                    objK3 = objK17;
                    obj4 = objK18;
                    objK4 = obj10;
                    i11 = i19;
                    z11 = zC4;
                    i12 = i20;
                    f10 = fU4;
                    i13 = i14;
                    obj5 = objK16;
                    z12 = zC5;
                    obj6 = objK14;
                }
                cVarB.c(descriptor2);
                return new c(i13, z12, (String) obj2, (Integer) obj3, fU, (String) obj, i12, (String) obj4, (String) objK, (String) objK3, (String) obj5, (String) objK2, f10, i10, z10, i11, z11, (String) objK4, (String) obj6, (s1) null);
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

        /* JADX INFO: compiled from: DeviceNode.kt */
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
            this(false, (String) null, (Integer) null, 0.0f, (String) null, 0, (String) null, (String) null, (String) null, (String) null, (String) null, 0.0f, 0, false, 0, false, (String) null, (String) null, 262143, (kotlin.jvm.internal.k) null);
        }

        public static final void write$Self(@NotNull c self, @NotNull ca.d output, @NotNull SerialDescriptor serialDesc) {
            t.i(self, "self");
            t.i(output, "output");
            t.i(serialDesc, "serialDesc");
            if (output.z(serialDesc, 0) || self.isGooglePlayServicesAvailable) {
                output.x(serialDesc, 0, self.isGooglePlayServicesAvailable);
            }
            if (output.z(serialDesc, 1) || self.appSetId != null) {
                output.h(serialDesc, 1, w1.f24648a, self.appSetId);
            }
            if (output.z(serialDesc, 2) || self.appSetIdScope != null) {
                output.h(serialDesc, 2, l0.f24594a, self.appSetIdScope);
            }
            if (output.z(serialDesc, 3) || !t.d(Float.valueOf(self.batteryLevel), Float.valueOf(0.0f))) {
                output.s(serialDesc, 3, self.batteryLevel);
            }
            if (output.z(serialDesc, 4) || self.batteryState != null) {
                output.h(serialDesc, 4, w1.f24648a, self.batteryState);
            }
            if (output.z(serialDesc, 5) || self.batterySaverEnabled != 0) {
                output.w(serialDesc, 5, self.batterySaverEnabled);
            }
            if (output.z(serialDesc, 6) || self.connectionType != null) {
                output.h(serialDesc, 6, w1.f24648a, self.connectionType);
            }
            if (output.z(serialDesc, 7) || self.connectionTypeDetail != null) {
                output.h(serialDesc, 7, w1.f24648a, self.connectionTypeDetail);
            }
            if (output.z(serialDesc, 8) || self.locale != null) {
                output.h(serialDesc, 8, w1.f24648a, self.locale);
            }
            if (output.z(serialDesc, 9) || self.language != null) {
                output.h(serialDesc, 9, w1.f24648a, self.language);
            }
            if (output.z(serialDesc, 10) || self.timeZone != null) {
                output.h(serialDesc, 10, w1.f24648a, self.timeZone);
            }
            if (output.z(serialDesc, 11) || !t.d(Float.valueOf(self.volumeLevel), Float.valueOf(0.0f))) {
                output.s(serialDesc, 11, self.volumeLevel);
            }
            if (output.z(serialDesc, 12) || self.soundEnabled != 1) {
                output.w(serialDesc, 12, self.soundEnabled);
            }
            if (output.z(serialDesc, 13) || self.isTv) {
                output.x(serialDesc, 13, self.isTv);
            }
            if (output.z(serialDesc, 14) || self.sdCardAvailable != 1) {
                output.w(serialDesc, 14, self.sdCardAvailable);
            }
            if (output.z(serialDesc, 15) || self.isSideloadEnabled) {
                output.x(serialDesc, 15, self.isSideloadEnabled);
            }
            if (output.z(serialDesc, 16) || self.gaid != null) {
                output.h(serialDesc, 16, w1.f24648a, self.gaid);
            }
            if (output.z(serialDesc, 17) || self.amazonAdvertisingId != null) {
                output.h(serialDesc, 17, w1.f24648a, self.amazonAdvertisingId);
            }
        }

        public final boolean component1() {
            return this.isGooglePlayServicesAvailable;
        }

        @Nullable
        public final String component10() {
            return this.language;
        }

        @Nullable
        public final String component11() {
            return this.timeZone;
        }

        public final float component12() {
            return this.volumeLevel;
        }

        public final int component13() {
            return this.soundEnabled;
        }

        public final boolean component14() {
            return this.isTv;
        }

        public final int component15() {
            return this.sdCardAvailable;
        }

        public final boolean component16() {
            return this.isSideloadEnabled;
        }

        @Nullable
        public final String component17() {
            return this.gaid;
        }

        @Nullable
        public final String component18() {
            return this.amazonAdvertisingId;
        }

        @Nullable
        public final String component2() {
            return this.appSetId;
        }

        @Nullable
        public final Integer component3() {
            return this.appSetIdScope;
        }

        public final float component4() {
            return this.batteryLevel;
        }

        @Nullable
        public final String component5() {
            return this.batteryState;
        }

        public final int component6() {
            return this.batterySaverEnabled;
        }

        @Nullable
        public final String component7() {
            return this.connectionType;
        }

        @Nullable
        public final String component8() {
            return this.connectionTypeDetail;
        }

        @Nullable
        public final String component9() {
            return this.locale;
        }

        @NotNull
        public final c copy(boolean z10, @Nullable String str, @Nullable Integer num, float f10, @Nullable String str2, int i10, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, float f11, int i11, boolean z11, int i12, boolean z12, @Nullable String str8, @Nullable String str9) {
            return new c(z10, str, num, f10, str2, i10, str3, str4, str5, str6, str7, f11, i11, z11, i12, z12, str8, str9);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.isGooglePlayServicesAvailable == cVar.isGooglePlayServicesAvailable && t.d(this.appSetId, cVar.appSetId) && t.d(this.appSetIdScope, cVar.appSetIdScope) && t.d(Float.valueOf(this.batteryLevel), Float.valueOf(cVar.batteryLevel)) && t.d(this.batteryState, cVar.batteryState) && this.batterySaverEnabled == cVar.batterySaverEnabled && t.d(this.connectionType, cVar.connectionType) && t.d(this.connectionTypeDetail, cVar.connectionTypeDetail) && t.d(this.locale, cVar.locale) && t.d(this.language, cVar.language) && t.d(this.timeZone, cVar.timeZone) && t.d(Float.valueOf(this.volumeLevel), Float.valueOf(cVar.volumeLevel)) && this.soundEnabled == cVar.soundEnabled && this.isTv == cVar.isTv && this.sdCardAvailable == cVar.sdCardAvailable && this.isSideloadEnabled == cVar.isSideloadEnabled && t.d(this.gaid, cVar.gaid) && t.d(this.amazonAdvertisingId, cVar.amazonAdvertisingId);
        }

        @Nullable
        public final String getAmazonAdvertisingId() {
            return this.amazonAdvertisingId;
        }

        @Nullable
        public final String getAppSetId() {
            return this.appSetId;
        }

        @Nullable
        public final Integer getAppSetIdScope() {
            return this.appSetIdScope;
        }

        public final float getBatteryLevel() {
            return this.batteryLevel;
        }

        public final int getBatterySaverEnabled() {
            return this.batterySaverEnabled;
        }

        @Nullable
        public final String getBatteryState() {
            return this.batteryState;
        }

        @Nullable
        public final String getConnectionType() {
            return this.connectionType;
        }

        @Nullable
        public final String getConnectionTypeDetail() {
            return this.connectionTypeDetail;
        }

        @Nullable
        public final String getGaid() {
            return this.gaid;
        }

        @Nullable
        public final String getLanguage() {
            return this.language;
        }

        @Nullable
        public final String getLocale() {
            return this.locale;
        }

        public final int getSdCardAvailable() {
            return this.sdCardAvailable;
        }

        public final int getSoundEnabled() {
            return this.soundEnabled;
        }

        @Nullable
        public final String getTimeZone() {
            return this.timeZone;
        }

        public final float getVolumeLevel() {
            return this.volumeLevel;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v36 */
        /* JADX WARN: Type inference failed for: r0v37 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r2v31, types: [int] */
        /* JADX WARN: Type inference failed for: r2v34 */
        /* JADX WARN: Type inference failed for: r2v43 */
        public int hashCode() {
            boolean z10 = this.isGooglePlayServicesAvailable;
            ?? r02 = z10;
            if (z10) {
                r02 = 1;
            }
            int i10 = r02 * 31;
            String str = this.appSetId;
            int iHashCode = (i10 + (str == null ? 0 : str.hashCode())) * 31;
            Integer num = this.appSetIdScope;
            int iHashCode2 = (((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + Float.floatToIntBits(this.batteryLevel)) * 31;
            String str2 = this.batteryState;
            int iHashCode3 = (((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.batterySaverEnabled) * 31;
            String str3 = this.connectionType;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.connectionTypeDetail;
            int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.locale;
            int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.language;
            int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.timeZone;
            int iHashCode8 = (((((iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31) + Float.floatToIntBits(this.volumeLevel)) * 31) + this.soundEnabled) * 31;
            boolean z11 = this.isTv;
            ?? r22 = z11;
            if (z11) {
                r22 = 1;
            }
            int i11 = (((iHashCode8 + r22) * 31) + this.sdCardAvailable) * 31;
            boolean z12 = this.isSideloadEnabled;
            int i12 = (i11 + (z12 ? 1 : z12)) * 31;
            String str8 = this.gaid;
            int iHashCode9 = (i12 + (str8 == null ? 0 : str8.hashCode())) * 31;
            String str9 = this.amazonAdvertisingId;
            return iHashCode9 + (str9 != null ? str9.hashCode() : 0);
        }

        public final boolean isGooglePlayServicesAvailable() {
            return this.isGooglePlayServicesAvailable;
        }

        public final boolean isSideloadEnabled() {
            return this.isSideloadEnabled;
        }

        public final boolean isTv() {
            return this.isTv;
        }

        public final void setAmazonAdvertisingId(@Nullable String str) {
            this.amazonAdvertisingId = str;
        }

        public final void setAppSetId(@Nullable String str) {
            this.appSetId = str;
        }

        public final void setAppSetIdScope(@Nullable Integer num) {
            this.appSetIdScope = num;
        }

        public final void setBatteryLevel(float f10) {
            this.batteryLevel = f10;
        }

        public final void setBatterySaverEnabled(int i10) {
            this.batterySaverEnabled = i10;
        }

        public final void setBatteryState(@Nullable String str) {
            this.batteryState = str;
        }

        public final void setConnectionType(@Nullable String str) {
            this.connectionType = str;
        }

        public final void setConnectionTypeDetail(@Nullable String str) {
            this.connectionTypeDetail = str;
        }

        public final void setGaid(@Nullable String str) {
            this.gaid = str;
        }

        public final void setGooglePlayServicesAvailable(boolean z10) {
            this.isGooglePlayServicesAvailable = z10;
        }

        public final void setLanguage(@Nullable String str) {
            this.language = str;
        }

        public final void setLocale(@Nullable String str) {
            this.locale = str;
        }

        public final void setSdCardAvailable(int i10) {
            this.sdCardAvailable = i10;
        }

        public final void setSideloadEnabled(boolean z10) {
            this.isSideloadEnabled = z10;
        }

        public final void setSoundEnabled(int i10) {
            this.soundEnabled = i10;
        }

        public final void setTimeZone(@Nullable String str) {
            this.timeZone = str;
        }

        public final void setTv(boolean z10) {
            this.isTv = z10;
        }

        public final void setVolumeLevel(float f10) {
            this.volumeLevel = f10;
        }

        @NotNull
        public String toString() {
            return "VungleExt(isGooglePlayServicesAvailable=" + this.isGooglePlayServicesAvailable + ", appSetId=" + this.appSetId + ", appSetIdScope=" + this.appSetIdScope + ", batteryLevel=" + this.batteryLevel + ", batteryState=" + this.batteryState + ", batterySaverEnabled=" + this.batterySaverEnabled + ", connectionType=" + this.connectionType + ", connectionTypeDetail=" + this.connectionTypeDetail + ", locale=" + this.locale + ", language=" + this.language + ", timeZone=" + this.timeZone + ", volumeLevel=" + this.volumeLevel + ", soundEnabled=" + this.soundEnabled + ", isTv=" + this.isTv + ", sdCardAvailable=" + this.sdCardAvailable + ", isSideloadEnabled=" + this.isSideloadEnabled + ", gaid=" + this.gaid + ", amazonAdvertisingId=" + this.amazonAdvertisingId + ')';
        }

        public /* synthetic */ c(int i10, boolean z10, String str, Integer num, float f10, String str2, int i11, String str3, String str4, String str5, String str6, String str7, float f11, int i12, boolean z11, int i13, boolean z12, String str8, String str9, s1 s1Var) {
            if ((i10 & 0) != 0) {
                i1.a(i10, 0, a.INSTANCE.getDescriptor());
            }
            if ((i10 & 1) == 0) {
                this.isGooglePlayServicesAvailable = false;
            } else {
                this.isGooglePlayServicesAvailable = z10;
            }
            if ((i10 & 2) == 0) {
                this.appSetId = null;
            } else {
                this.appSetId = str;
            }
            if ((i10 & 4) == 0) {
                this.appSetIdScope = null;
            } else {
                this.appSetIdScope = num;
            }
            if ((i10 & 8) == 0) {
                this.batteryLevel = 0.0f;
            } else {
                this.batteryLevel = f10;
            }
            if ((i10 & 16) == 0) {
                this.batteryState = null;
            } else {
                this.batteryState = str2;
            }
            if ((i10 & 32) == 0) {
                this.batterySaverEnabled = 0;
            } else {
                this.batterySaverEnabled = i11;
            }
            if ((i10 & 64) == 0) {
                this.connectionType = null;
            } else {
                this.connectionType = str3;
            }
            if ((i10 & 128) == 0) {
                this.connectionTypeDetail = null;
            } else {
                this.connectionTypeDetail = str4;
            }
            if ((i10 & 256) == 0) {
                this.locale = null;
            } else {
                this.locale = str5;
            }
            if ((i10 & 512) == 0) {
                this.language = null;
            } else {
                this.language = str6;
            }
            if ((i10 & 1024) == 0) {
                this.timeZone = null;
            } else {
                this.timeZone = str7;
            }
            if ((i10 & 2048) == 0) {
                this.volumeLevel = 0.0f;
            } else {
                this.volumeLevel = f11;
            }
            if ((i10 & 4096) == 0) {
                this.soundEnabled = 1;
            } else {
                this.soundEnabled = i12;
            }
            if ((i10 & 8192) == 0) {
                this.isTv = false;
            } else {
                this.isTv = z11;
            }
            if ((i10 & 16384) == 0) {
                this.sdCardAvailable = 1;
            } else {
                this.sdCardAvailable = i13;
            }
            if ((32768 & i10) == 0) {
                this.isSideloadEnabled = false;
            } else {
                this.isSideloadEnabled = z12;
            }
            if ((65536 & i10) == 0) {
                this.gaid = null;
            } else {
                this.gaid = str8;
            }
            if ((i10 & 131072) == 0) {
                this.amazonAdvertisingId = null;
            } else {
                this.amazonAdvertisingId = str9;
            }
        }

        public c(boolean z10, @Nullable String str, @Nullable Integer num, float f10, @Nullable String str2, int i10, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, float f11, int i11, boolean z11, int i12, boolean z12, @Nullable String str8, @Nullable String str9) {
            this.isGooglePlayServicesAvailable = z10;
            this.appSetId = str;
            this.appSetIdScope = num;
            this.batteryLevel = f10;
            this.batteryState = str2;
            this.batterySaverEnabled = i10;
            this.connectionType = str3;
            this.connectionTypeDetail = str4;
            this.locale = str5;
            this.language = str6;
            this.timeZone = str7;
            this.volumeLevel = f11;
            this.soundEnabled = i11;
            this.isTv = z11;
            this.sdCardAvailable = i12;
            this.isSideloadEnabled = z12;
            this.gaid = str8;
            this.amazonAdvertisingId = str9;
        }

        public static /* synthetic */ void getAmazonAdvertisingId$annotations() {
        }

        public static /* synthetic */ void getAppSetId$annotations() {
        }

        public static /* synthetic */ void getAppSetIdScope$annotations() {
        }

        public static /* synthetic */ void getBatteryLevel$annotations() {
        }

        public static /* synthetic */ void getBatterySaverEnabled$annotations() {
        }

        public static /* synthetic */ void getBatteryState$annotations() {
        }

        public static /* synthetic */ void getConnectionType$annotations() {
        }

        public static /* synthetic */ void getConnectionTypeDetail$annotations() {
        }

        public static /* synthetic */ void getGaid$annotations() {
        }

        public static /* synthetic */ void getLanguage$annotations() {
        }

        public static /* synthetic */ void getLocale$annotations() {
        }

        public static /* synthetic */ void getSdCardAvailable$annotations() {
        }

        public static /* synthetic */ void getSoundEnabled$annotations() {
        }

        public static /* synthetic */ void getTimeZone$annotations() {
        }

        public static /* synthetic */ void getVolumeLevel$annotations() {
        }

        public static /* synthetic */ void isGooglePlayServicesAvailable$annotations() {
        }

        public static /* synthetic */ void isSideloadEnabled$annotations() {
        }

        public static /* synthetic */ void isTv$annotations() {
        }

        public /* synthetic */ c(boolean z10, String str, Integer num, float f10, String str2, int i10, String str3, String str4, String str5, String str6, String str7, float f11, int i11, boolean z11, int i12, boolean z12, String str8, String str9, int i13, kotlin.jvm.internal.k kVar) {
            this((i13 & 1) != 0 ? false : z10, (i13 & 2) != 0 ? null : str, (i13 & 4) != 0 ? null : num, (i13 & 8) != 0 ? 0.0f : f10, (i13 & 16) != 0 ? null : str2, (i13 & 32) != 0 ? 0 : i10, (i13 & 64) != 0 ? null : str3, (i13 & 128) != 0 ? null : str4, (i13 & 256) != 0 ? null : str5, (i13 & 512) != 0 ? null : str6, (i13 & 1024) != 0 ? null : str7, (i13 & 2048) == 0 ? f11 : 0.0f, (i13 & 4096) != 0 ? 1 : i11, (i13 & 8192) != 0 ? false : z11, (i13 & 16384) == 0 ? i12 : 1, (32768 & i13) != 0 ? false : z12, (i13 & 65536) != 0 ? null : str8, (i13 & 131072) != 0 ? null : str9);
        }
    }

    public /* synthetic */ h(int i10, String str, String str2, String str3, String str4, String str5, int i11, int i12, String str6, String str7, Integer num, c cVar, s1 s1Var) {
        if (119 != (i10 & 119)) {
            i1.a(i10, 119, a.INSTANCE.getDescriptor());
        }
        this.make = str;
        this.model = str2;
        this.osv = str3;
        if ((i10 & 8) == 0) {
            this.carrier = null;
        } else {
            this.carrier = str4;
        }
        this.os = str5;
        this.f24350w = i11;
        this.f24348h = i12;
        if ((i10 & 128) == 0) {
            this.f24349ua = null;
        } else {
            this.f24349ua = str6;
        }
        if ((i10 & 256) == 0) {
            this.ifa = null;
        } else {
            this.ifa = str7;
        }
        if ((i10 & 512) == 0) {
            this.lmt = null;
        } else {
            this.lmt = num;
        }
        if ((i10 & 1024) == 0) {
            this.ext = null;
        } else {
            this.ext = cVar;
        }
    }

    public static final void write$Self(@NotNull h self, @NotNull ca.d output, @NotNull SerialDescriptor serialDesc) {
        t.i(self, "self");
        t.i(output, "output");
        t.i(serialDesc, "serialDesc");
        output.y(serialDesc, 0, self.make);
        output.y(serialDesc, 1, self.model);
        output.y(serialDesc, 2, self.osv);
        if (output.z(serialDesc, 3) || self.carrier != null) {
            output.h(serialDesc, 3, w1.f24648a, self.carrier);
        }
        output.y(serialDesc, 4, self.os);
        output.w(serialDesc, 5, self.f24350w);
        output.w(serialDesc, 6, self.f24348h);
        if (output.z(serialDesc, 7) || self.f24349ua != null) {
            output.h(serialDesc, 7, w1.f24648a, self.f24349ua);
        }
        if (output.z(serialDesc, 8) || self.ifa != null) {
            output.h(serialDesc, 8, w1.f24648a, self.ifa);
        }
        if (output.z(serialDesc, 9) || self.lmt != null) {
            output.h(serialDesc, 9, l0.f24594a, self.lmt);
        }
        if (output.z(serialDesc, 10) || self.ext != null) {
            output.h(serialDesc, 10, c.a.INSTANCE, self.ext);
        }
    }

    @NotNull
    public final String component1() {
        return this.make;
    }

    @Nullable
    public final Integer component10() {
        return this.lmt;
    }

    @Nullable
    public final c component11() {
        return this.ext;
    }

    @NotNull
    public final String component2() {
        return this.model;
    }

    @NotNull
    public final String component3() {
        return this.osv;
    }

    @Nullable
    public final String component4() {
        return this.carrier;
    }

    @NotNull
    public final String component5() {
        return this.os;
    }

    public final int component6() {
        return this.f24350w;
    }

    public final int component7() {
        return this.f24348h;
    }

    @Nullable
    public final String component8() {
        return this.f24349ua;
    }

    @Nullable
    public final String component9() {
        return this.ifa;
    }

    @NotNull
    public final h copy(@NotNull String make, @NotNull String model, @NotNull String osv, @Nullable String str, @NotNull String os, int i10, int i11, @Nullable String str2, @Nullable String str3, @Nullable Integer num, @Nullable c cVar) {
        t.i(make, "make");
        t.i(model, "model");
        t.i(osv, "osv");
        t.i(os, "os");
        return new h(make, model, osv, str, os, i10, i11, str2, str3, num, cVar);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return t.d(this.make, hVar.make) && t.d(this.model, hVar.model) && t.d(this.osv, hVar.osv) && t.d(this.carrier, hVar.carrier) && t.d(this.os, hVar.os) && this.f24350w == hVar.f24350w && this.f24348h == hVar.f24348h && t.d(this.f24349ua, hVar.f24349ua) && t.d(this.ifa, hVar.ifa) && t.d(this.lmt, hVar.lmt) && t.d(this.ext, hVar.ext);
    }

    @Nullable
    public final String getCarrier() {
        return this.carrier;
    }

    @Nullable
    public final c getExt() {
        return this.ext;
    }

    public final int getH() {
        return this.f24348h;
    }

    @Nullable
    public final String getIfa() {
        return this.ifa;
    }

    @Nullable
    public final Integer getLmt() {
        return this.lmt;
    }

    @NotNull
    public final String getMake() {
        return this.make;
    }

    @NotNull
    public final String getModel() {
        return this.model;
    }

    @NotNull
    public final String getOs() {
        return this.os;
    }

    @NotNull
    public final String getOsv() {
        return this.osv;
    }

    @Nullable
    public final String getUa() {
        return this.f24349ua;
    }

    public final int getW() {
        return this.f24350w;
    }

    public int hashCode() {
        int iHashCode = ((((this.make.hashCode() * 31) + this.model.hashCode()) * 31) + this.osv.hashCode()) * 31;
        String str = this.carrier;
        int iHashCode2 = (((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.os.hashCode()) * 31) + this.f24350w) * 31) + this.f24348h) * 31;
        String str2 = this.f24349ua;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.ifa;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.lmt;
        int iHashCode5 = (iHashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        c cVar = this.ext;
        return iHashCode5 + (cVar != null ? cVar.hashCode() : 0);
    }

    public final void setExt(@Nullable c cVar) {
        this.ext = cVar;
    }

    public final void setIfa(@Nullable String str) {
        this.ifa = str;
    }

    public final void setLmt(@Nullable Integer num) {
        this.lmt = num;
    }

    public final void setUa(@Nullable String str) {
        this.f24349ua = str;
    }

    @NotNull
    public String toString() {
        return "DeviceNode(make=" + this.make + ", model=" + this.model + ", osv=" + this.osv + ", carrier=" + this.carrier + ", os=" + this.os + ", w=" + this.f24350w + ", h=" + this.f24348h + ", ua=" + this.f24349ua + ", ifa=" + this.ifa + ", lmt=" + this.lmt + ", ext=" + this.ext + ')';
    }

    public h(@NotNull String make, @NotNull String model, @NotNull String osv, @Nullable String str, @NotNull String os, int i10, int i11, @Nullable String str2, @Nullable String str3, @Nullable Integer num, @Nullable c cVar) {
        t.i(make, "make");
        t.i(model, "model");
        t.i(osv, "osv");
        t.i(os, "os");
        this.make = make;
        this.model = model;
        this.osv = osv;
        this.carrier = str;
        this.os = os;
        this.f24350w = i10;
        this.f24348h = i11;
        this.f24349ua = str2;
        this.ifa = str3;
        this.lmt = num;
        this.ext = cVar;
    }

    public /* synthetic */ h(String str, String str2, String str3, String str4, String str5, int i10, int i11, String str6, String str7, Integer num, c cVar, int i12, kotlin.jvm.internal.k kVar) {
        this(str, str2, str3, (i12 & 8) != 0 ? null : str4, str5, i10, i11, (i12 & 128) != 0 ? null : str6, (i12 & 256) != 0 ? null : str7, (i12 & 512) != 0 ? null : num, (i12 & 1024) != 0 ? null : cVar);
    }
}
