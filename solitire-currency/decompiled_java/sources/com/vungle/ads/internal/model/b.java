package com.vungle.ads.internal.model;

import androidx.annotation.VisibleForTesting;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.vungle.ads.internal.model.a;
import com.vungle.ads.internal.model.g;
import da.d0;
import da.i1;
import da.l0;
import da.p0;
import da.s1;
import da.w1;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import kotlin.collections.w;
import kotlin.collections.z;
import kotlin.jvm.internal.o0;
import kotlin.jvm.internal.s0;
import kotlin.jvm.internal.t;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.r;
import kotlinx.serialization.json.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z9.o;

/* JADX INFO: compiled from: AdPayload.kt */
/* JADX INFO: loaded from: classes4.dex */
@z9.h
public final class b {

    @NotNull
    public static final e Companion = new e(null);

    @NotNull
    public static final String FILE_SCHEME = "file://";

    @NotNull
    public static final String INCENTIVIZED_BODY_TEXT = "INCENTIVIZED_BODY_TEXT";

    @NotNull
    public static final String INCENTIVIZED_CLOSE_TEXT = "INCENTIVIZED_CLOSE_TEXT";

    @NotNull
    public static final String INCENTIVIZED_CONTINUE_TEXT = "INCENTIVIZED_CONTINUE_TEXT";

    @NotNull
    public static final String INCENTIVIZED_TITLE_TEXT = "INCENTIVIZED_TITLE_TEXT";

    @NotNull
    public static final String KEY_TEMPLATE = "template";

    @NotNull
    public static final String KEY_VM = "vmURL";

    @NotNull
    public static final String TPAT_CLICK_COORDINATES_URLS = "video.clickCoordinates";

    @NotNull
    private static final String UNKNOWN = "unknown";

    @Nullable
    private com.vungle.ads.c adConfig;

    @Nullable
    private final List<f> ads;

    @Nullable
    private File assetDirectory;
    private boolean assetsFullyDownloaded;

    @Nullable
    private final com.vungle.ads.internal.model.g config;

    @NotNull
    private Map<String, String> incentivizedTextSettings;

    @NotNull
    private ConcurrentHashMap<String, String> mraidFiles;

    /* JADX INFO: compiled from: AdPayload.kt */
    public static final class a implements d0<b> {

        @NotNull
        public static final a INSTANCE;
        public static final /* synthetic */ SerialDescriptor descriptor;

        static {
            a aVar = new a();
            INSTANCE = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.AdPayload", aVar, 5);
            pluginGeneratedSerialDescriptor.k("ads", true);
            pluginGeneratedSerialDescriptor.k("config", true);
            pluginGeneratedSerialDescriptor.k("mraidFiles", true);
            pluginGeneratedSerialDescriptor.k("incentivizedTextSettings", true);
            pluginGeneratedSerialDescriptor.k("assetsFullyDownloaded", true);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        private a() {
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] childSerializers() {
            KClass kClassB = o0.b(ConcurrentHashMap.class);
            w1 w1Var = w1.f24648a;
            return new KSerializer[]{aa.a.s(new da.f(f.a.INSTANCE)), aa.a.s(g.a.INSTANCE), new z9.a(kClassB, null, new KSerializer[]{w1Var, w1Var}), new p0(w1Var, w1Var), da.h.f24574a};
        }

        @Override // z9.b
        @NotNull
        public b deserialize(@NotNull Decoder decoder) {
            Object objK;
            Object objY;
            Object objY2;
            boolean zC;
            int i10;
            Object objK2;
            Object obj;
            t.i(decoder, "decoder");
            SerialDescriptor descriptor2 = getDescriptor();
            ca.c cVarB = decoder.b(descriptor2);
            int i11 = 3;
            int i12 = 4;
            if (cVarB.p()) {
                objK = cVarB.k(descriptor2, 0, new da.f(f.a.INSTANCE), null);
                objK2 = cVarB.k(descriptor2, 1, g.a.INSTANCE, null);
                KClass kClassB = o0.b(ConcurrentHashMap.class);
                w1 w1Var = w1.f24648a;
                objY = cVarB.y(descriptor2, 2, new z9.a(kClassB, null, new KSerializer[]{w1Var, w1Var}), null);
                objY2 = cVarB.y(descriptor2, 3, new p0(w1Var, w1Var), null);
                i10 = 31;
                zC = cVarB.C(descriptor2, 4);
            } else {
                boolean z10 = true;
                boolean zC2 = false;
                int i13 = 0;
                objK = null;
                Object objY3 = null;
                Object objY4 = null;
                Object objK3 = null;
                while (z10) {
                    int iO = cVarB.o(descriptor2);
                    if (iO == -1) {
                        z10 = false;
                    } else if (iO != 0) {
                        if (iO == 1) {
                            obj = null;
                            objK3 = cVarB.k(descriptor2, 1, g.a.INSTANCE, objK3);
                            i13 |= 2;
                        } else if (iO == 2) {
                            KClass kClassB2 = o0.b(ConcurrentHashMap.class);
                            w1 w1Var2 = w1.f24648a;
                            obj = null;
                            objY3 = cVarB.y(descriptor2, 2, new z9.a(kClassB2, null, new KSerializer[]{w1Var2, w1Var2}), objY3);
                            i13 |= 4;
                        } else if (iO == i11) {
                            w1 w1Var3 = w1.f24648a;
                            objY4 = cVarB.y(descriptor2, i11, new p0(w1Var3, w1Var3), objY4);
                            i13 |= 8;
                        } else {
                            if (iO != i12) {
                                throw new o(iO);
                            }
                            zC2 = cVarB.C(descriptor2, i12);
                            i13 |= 16;
                        }
                        i11 = 3;
                        i12 = 4;
                    } else {
                        objK = cVarB.k(descriptor2, 0, new da.f(f.a.INSTANCE), objK);
                        i13 |= 1;
                        i11 = 3;
                        i12 = 4;
                    }
                }
                objY = objY3;
                objY2 = objY4;
                zC = zC2;
                i10 = i13;
                objK2 = objK3;
            }
            cVarB.c(descriptor2);
            return new b(i10, (List) objK, (com.vungle.ads.internal.model.g) objK2, (ConcurrentHashMap) objY, (Map) objY2, zC, null);
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

    /* JADX INFO: renamed from: com.vungle.ads.internal.model.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AdPayload.kt */
    @z9.h
    public static final class C0511b {

        @NotNull
        public static final C0512b Companion = new C0512b(null);

        @Nullable
        private final Integer height;

        @Nullable
        private final Integer width;

        /* JADX INFO: renamed from: com.vungle.ads.internal.model.b$b$a */
        /* JADX INFO: compiled from: AdPayload.kt */
        public static final class a implements d0<C0511b> {

            @NotNull
            public static final a INSTANCE;
            public static final /* synthetic */ SerialDescriptor descriptor;

            static {
                a aVar = new a();
                INSTANCE = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.AdPayload.AdSizeInfo", aVar, 2);
                pluginGeneratedSerialDescriptor.k("w", true);
                pluginGeneratedSerialDescriptor.k(CmcdData.Factory.STREAMING_FORMAT_HLS, true);
                descriptor = pluginGeneratedSerialDescriptor;
            }

            private a() {
            }

            @Override // da.d0
            @NotNull
            public KSerializer<?>[] childSerializers() {
                l0 l0Var = l0.f24594a;
                return new KSerializer[]{aa.a.s(l0Var), aa.a.s(l0Var)};
            }

            @Override // z9.b
            @NotNull
            public C0511b deserialize(@NotNull Decoder decoder) {
                Object objK;
                int i10;
                Object objK2;
                t.i(decoder, "decoder");
                SerialDescriptor descriptor2 = getDescriptor();
                ca.c cVarB = decoder.b(descriptor2);
                s1 s1Var = null;
                if (cVarB.p()) {
                    l0 l0Var = l0.f24594a;
                    objK2 = cVarB.k(descriptor2, 0, l0Var, null);
                    objK = cVarB.k(descriptor2, 1, l0Var, null);
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
                            objK3 = cVarB.k(descriptor2, 0, l0.f24594a, objK3);
                            i11 |= 1;
                        } else {
                            if (iO != 1) {
                                throw new o(iO);
                            }
                            objK = cVarB.k(descriptor2, 1, l0.f24594a, objK);
                            i11 |= 2;
                        }
                    }
                    i10 = i11;
                    objK2 = objK3;
                }
                cVarB.c(descriptor2);
                return new C0511b(i10, (Integer) objK2, (Integer) objK, s1Var);
            }

            @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
            @NotNull
            public SerialDescriptor getDescriptor() {
                return descriptor;
            }

            @Override // z9.j
            public void serialize(@NotNull Encoder encoder, @NotNull C0511b value) {
                t.i(encoder, "encoder");
                t.i(value, "value");
                SerialDescriptor descriptor2 = getDescriptor();
                ca.d dVarB = encoder.b(descriptor2);
                C0511b.write$Self(value, dVarB, descriptor2);
                dVarB.c(descriptor2);
            }

            @Override // da.d0
            @NotNull
            public KSerializer<?>[] typeParametersSerializers() {
                return d0.a.a(this);
            }
        }

        /* JADX INFO: renamed from: com.vungle.ads.internal.model.b$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AdPayload.kt */
        public static final class C0512b {
            private C0512b() {
            }

            public /* synthetic */ C0512b(kotlin.jvm.internal.k kVar) {
                this();
            }

            @NotNull
            public final KSerializer<C0511b> serializer() {
                return a.INSTANCE;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C0511b() {
            this((Integer) null, (Integer) (0 == true ? 1 : 0), 3, (kotlin.jvm.internal.k) (0 == true ? 1 : 0));
        }

        public static /* synthetic */ C0511b copy$default(C0511b c0511b, Integer num, Integer num2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                num = c0511b.width;
            }
            if ((i10 & 2) != 0) {
                num2 = c0511b.height;
            }
            return c0511b.copy(num, num2);
        }

        public static final void write$Self(@NotNull C0511b self, @NotNull ca.d output, @NotNull SerialDescriptor serialDesc) {
            Integer num;
            Integer num2;
            t.i(self, "self");
            t.i(output, "output");
            t.i(serialDesc, "serialDesc");
            if (output.z(serialDesc, 0) || (num = self.width) == null || num.intValue() != 0) {
                output.h(serialDesc, 0, l0.f24594a, self.width);
            }
            if (output.z(serialDesc, 1) || (num2 = self.height) == null || num2.intValue() != 0) {
                output.h(serialDesc, 1, l0.f24594a, self.height);
            }
        }

        @Nullable
        public final Integer component1() {
            return this.width;
        }

        @Nullable
        public final Integer component2() {
            return this.height;
        }

        @NotNull
        public final C0511b copy(@Nullable Integer num, @Nullable Integer num2) {
            return new C0511b(num, num2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0511b)) {
                return false;
            }
            C0511b c0511b = (C0511b) obj;
            return t.d(this.width, c0511b.width) && t.d(this.height, c0511b.height);
        }

        @Nullable
        public final Integer getHeight() {
            return this.height;
        }

        @Nullable
        public final Integer getWidth() {
            return this.width;
        }

        public int hashCode() {
            Integer num = this.width;
            int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
            Integer num2 = this.height;
            return iHashCode + (num2 != null ? num2.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "AdSizeInfo(width=" + this.width + ", height=" + this.height + ')';
        }

        public C0511b(@Nullable Integer num, @Nullable Integer num2) {
            this.width = num;
            this.height = num2;
        }

        public /* synthetic */ C0511b(int i10, Integer num, Integer num2, s1 s1Var) {
            if ((i10 & 0) != 0) {
                i1.a(i10, 0, a.INSTANCE.getDescriptor());
            }
            if ((i10 & 1) == 0) {
                this.width = 0;
            } else {
                this.width = num;
            }
            if ((i10 & 2) == 0) {
                this.height = 0;
            } else {
                this.height = num2;
            }
        }

        public /* synthetic */ C0511b(Integer num, Integer num2, int i10, kotlin.jvm.internal.k kVar) {
            this((i10 & 1) != 0 ? 0 : num, (i10 & 2) != 0 ? 0 : num2);
        }

        public static /* synthetic */ void getHeight$annotations() {
        }

        public static /* synthetic */ void getWidth$annotations() {
        }
    }

    /* JADX INFO: compiled from: AdPayload.kt */
    @z9.h
    public static final class c {

        @NotNull
        public static final C0513b Companion = new C0513b(null);

        @Nullable
        private final Boolean adLoadOptimizationEnabled;

        @Nullable
        private final String adMarketId;

        @Nullable
        private final C0511b adSizeInfo;

        @Nullable
        private final String adSource;

        @Nullable
        private final String adType;

        @Nullable
        private final String advAppId;

        @Nullable
        private final Boolean clickCoordinatesEnabled;

        @Nullable
        private final String creativeId;

        @Nullable
        private final String deeplinkUrl;

        @Nullable
        private final Integer errorCode;

        @Nullable
        private final Integer expiry;

        @Nullable
        private final String id;

        @Nullable
        private final String info;

        @Nullable
        private final List<String> loadAdUrls;

        @Nullable
        private final List<String> notification;

        @Nullable
        private final Integer showClose;

        @Nullable
        private final Integer showCloseIncentivized;

        @Nullable
        private final Integer sleep;

        @Nullable
        private final Boolean templateHeartbeatCheck;

        @Nullable
        private final g templateSettings;

        @Nullable
        private final String templateType;

        @Nullable
        private final String templateURL;

        @Nullable
        private final Map<String, List<String>> tpat;

        @Nullable
        private final i viewAbility;

        @Nullable
        private final String vmURL;

        /* JADX INFO: compiled from: AdPayload.kt */
        public static final class a implements d0<c> {

            @NotNull
            public static final a INSTANCE;
            public static final /* synthetic */ SerialDescriptor descriptor;

            static {
                a aVar = new a();
                INSTANCE = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.AdPayload.AdUnit", aVar, 25);
                pluginGeneratedSerialDescriptor.k("id", true);
                pluginGeneratedSerialDescriptor.k("ad_type", true);
                pluginGeneratedSerialDescriptor.k("ad_source", true);
                pluginGeneratedSerialDescriptor.k("expiry", true);
                pluginGeneratedSerialDescriptor.k("deeplink_url", true);
                pluginGeneratedSerialDescriptor.k("click_coordinates_enabled", true);
                pluginGeneratedSerialDescriptor.k("ad_load_optimization", true);
                pluginGeneratedSerialDescriptor.k("template_heartbeat_check", true);
                pluginGeneratedSerialDescriptor.k("info", true);
                pluginGeneratedSerialDescriptor.k("sleep", true);
                pluginGeneratedSerialDescriptor.k("error_code", true);
                pluginGeneratedSerialDescriptor.k("tpat", true);
                pluginGeneratedSerialDescriptor.k("vm_url", true);
                pluginGeneratedSerialDescriptor.k("ad_market_id", true);
                pluginGeneratedSerialDescriptor.k("notification", true);
                pluginGeneratedSerialDescriptor.k("load_ad", true);
                pluginGeneratedSerialDescriptor.k("viewability", true);
                pluginGeneratedSerialDescriptor.k("template_url", true);
                pluginGeneratedSerialDescriptor.k("template_type", true);
                pluginGeneratedSerialDescriptor.k("template_settings", true);
                pluginGeneratedSerialDescriptor.k("creative_id", true);
                pluginGeneratedSerialDescriptor.k("app_id", true);
                pluginGeneratedSerialDescriptor.k("show_close", true);
                pluginGeneratedSerialDescriptor.k("show_close_incentivized", true);
                pluginGeneratedSerialDescriptor.k("ad_size", true);
                descriptor = pluginGeneratedSerialDescriptor;
            }

            private a() {
            }

            @Override // da.d0
            @NotNull
            public KSerializer<?>[] childSerializers() {
                w1 w1Var = w1.f24648a;
                l0 l0Var = l0.f24594a;
                da.h hVar = da.h.f24574a;
                return new KSerializer[]{aa.a.s(w1Var), aa.a.s(w1Var), aa.a.s(w1Var), aa.a.s(l0Var), aa.a.s(w1Var), aa.a.s(hVar), aa.a.s(hVar), aa.a.s(hVar), aa.a.s(w1Var), aa.a.s(l0Var), aa.a.s(l0Var), aa.a.s(h.INSTANCE), aa.a.s(w1Var), aa.a.s(w1Var), aa.a.s(new da.f(w1Var)), aa.a.s(new da.f(w1Var)), aa.a.s(i.a.INSTANCE), aa.a.s(w1Var), aa.a.s(w1Var), aa.a.s(g.a.INSTANCE), aa.a.s(w1Var), aa.a.s(w1Var), aa.a.s(l0Var), aa.a.s(l0Var), aa.a.s(C0511b.a.INSTANCE)};
            }

            @Override // z9.b
            @NotNull
            public c deserialize(@NotNull Decoder decoder) {
                Object objK;
                Object objK2;
                Object objK3;
                Object objK4;
                Object obj;
                Object obj2;
                Object obj3;
                Object obj4;
                Object obj5;
                Object objK5;
                Object obj6;
                Object obj7;
                Object objK6;
                Object objK7;
                Object objK8;
                Object obj8;
                Object objK9;
                Object objK10;
                Object objK11;
                Object objK12;
                Object obj9;
                Object objK13;
                Object obj10;
                Object obj11;
                int i10;
                Object obj12;
                Object obj13;
                Object obj14;
                int i11;
                int i12;
                Object obj15;
                Object obj16;
                t.i(decoder, "decoder");
                SerialDescriptor descriptor2 = getDescriptor();
                ca.c cVarB = decoder.b(descriptor2);
                if (cVarB.p()) {
                    w1 w1Var = w1.f24648a;
                    objK12 = cVarB.k(descriptor2, 0, w1Var, null);
                    objK11 = cVarB.k(descriptor2, 1, w1Var, null);
                    objK8 = cVarB.k(descriptor2, 2, w1Var, null);
                    l0 l0Var = l0.f24594a;
                    Object objK14 = cVarB.k(descriptor2, 3, l0Var, null);
                    Object objK15 = cVarB.k(descriptor2, 4, w1Var, null);
                    da.h hVar = da.h.f24574a;
                    Object objK16 = cVarB.k(descriptor2, 5, hVar, null);
                    Object objK17 = cVarB.k(descriptor2, 6, hVar, null);
                    objK9 = cVarB.k(descriptor2, 7, hVar, null);
                    Object objK18 = cVarB.k(descriptor2, 8, w1Var, null);
                    objK10 = cVarB.k(descriptor2, 9, l0Var, null);
                    Object objK19 = cVarB.k(descriptor2, 10, l0Var, null);
                    obj8 = objK14;
                    Object objK20 = cVarB.k(descriptor2, 11, h.INSTANCE, null);
                    Object objK21 = cVarB.k(descriptor2, 12, w1Var, null);
                    obj10 = objK20;
                    objK13 = cVarB.k(descriptor2, 13, w1Var, null);
                    obj = objK21;
                    objK6 = cVarB.k(descriptor2, 14, new da.f(w1Var), null);
                    objK7 = cVarB.k(descriptor2, 15, new da.f(w1Var), null);
                    Object objK22 = cVarB.k(descriptor2, 16, i.a.INSTANCE, null);
                    Object objK23 = cVarB.k(descriptor2, 17, w1Var, null);
                    obj7 = objK22;
                    objK5 = cVarB.k(descriptor2, 18, w1Var, null);
                    obj6 = objK23;
                    Object objK24 = cVarB.k(descriptor2, 19, g.a.INSTANCE, null);
                    Object objK25 = cVarB.k(descriptor2, 20, w1Var, null);
                    Object objK26 = cVarB.k(descriptor2, 21, w1Var, null);
                    Object objK27 = cVarB.k(descriptor2, 22, l0Var, null);
                    obj2 = objK15;
                    obj4 = objK18;
                    i10 = 33554431;
                    obj12 = objK19;
                    obj3 = objK17;
                    objK3 = cVarB.k(descriptor2, 23, l0Var, null);
                    objK2 = cVarB.k(descriptor2, 24, C0511b.a.INSTANCE, null);
                    objK4 = objK27;
                    objK = objK25;
                    obj5 = objK26;
                    obj11 = objK16;
                    obj9 = objK24;
                } else {
                    boolean z10 = true;
                    Object objK28 = null;
                    Object objK29 = null;
                    Object objK30 = null;
                    objK = null;
                    objK2 = null;
                    Object objK31 = null;
                    Object objK32 = null;
                    Object objK33 = null;
                    Object objK34 = null;
                    Object objK35 = null;
                    objK3 = null;
                    objK4 = null;
                    Object objK36 = null;
                    Object objK37 = null;
                    Object objK38 = null;
                    Object objK39 = null;
                    Object objK40 = null;
                    Object objK41 = null;
                    Object objK42 = null;
                    Object objK43 = null;
                    Object objK44 = null;
                    Object objK45 = null;
                    Object objK46 = null;
                    Object objK47 = null;
                    int i13 = 0;
                    Object objK48 = null;
                    while (z10) {
                        Object obj17 = objK35;
                        int iO = cVarB.o(descriptor2);
                        switch (iO) {
                            case -1:
                                obj15 = objK29;
                                obj16 = obj17;
                                z10 = false;
                                objK30 = objK30;
                                objK35 = obj16;
                                objK29 = obj15;
                                break;
                            case 0:
                                obj15 = objK29;
                                obj16 = obj17;
                                objK36 = cVarB.k(descriptor2, 0, w1.f24648a, objK36);
                                i13 |= 1;
                                objK30 = objK30;
                                objK28 = objK28;
                                objK35 = obj16;
                                objK29 = obj15;
                                break;
                            case 1:
                                objK37 = cVarB.k(descriptor2, 1, w1.f24648a, objK37);
                                i13 |= 2;
                                objK29 = objK29;
                                objK30 = objK30;
                                objK28 = objK28;
                                objK35 = obj17;
                                objK38 = objK38;
                                break;
                            case 2:
                                objK38 = cVarB.k(descriptor2, 2, w1.f24648a, objK38);
                                i13 |= 4;
                                objK29 = objK29;
                                objK30 = objK30;
                                objK28 = objK28;
                                objK35 = obj17;
                                objK39 = objK39;
                                break;
                            case 3:
                                objK39 = cVarB.k(descriptor2, 3, l0.f24594a, objK39);
                                i13 |= 8;
                                objK29 = objK29;
                                objK30 = objK30;
                                objK28 = objK28;
                                objK35 = obj17;
                                objK40 = objK40;
                                break;
                            case 4:
                                objK40 = cVarB.k(descriptor2, 4, w1.f24648a, objK40);
                                i13 |= 16;
                                objK29 = objK29;
                                objK30 = objK30;
                                objK28 = objK28;
                                objK35 = obj17;
                                objK41 = objK41;
                                break;
                            case 5:
                                objK41 = cVarB.k(descriptor2, 5, da.h.f24574a, objK41);
                                i13 |= 32;
                                objK29 = objK29;
                                objK30 = objK30;
                                objK28 = objK28;
                                objK35 = obj17;
                                objK42 = objK42;
                                break;
                            case 6:
                                objK42 = cVarB.k(descriptor2, 6, da.h.f24574a, objK42);
                                i13 |= 64;
                                objK29 = objK29;
                                objK30 = objK30;
                                objK28 = objK28;
                                objK35 = obj17;
                                objK43 = objK43;
                                break;
                            case 7:
                                objK43 = cVarB.k(descriptor2, 7, da.h.f24574a, objK43);
                                i13 |= 128;
                                objK29 = objK29;
                                objK30 = objK30;
                                objK28 = objK28;
                                objK35 = obj17;
                                objK44 = objK44;
                                break;
                            case 8:
                                objK44 = cVarB.k(descriptor2, 8, w1.f24648a, objK44);
                                i13 |= 256;
                                objK29 = objK29;
                                objK30 = objK30;
                                objK28 = objK28;
                                objK35 = obj17;
                                objK45 = objK45;
                                break;
                            case 9:
                                objK45 = cVarB.k(descriptor2, 9, l0.f24594a, objK45);
                                i13 |= 512;
                                objK29 = objK29;
                                objK30 = objK30;
                                objK28 = objK28;
                                objK35 = obj17;
                                objK46 = objK46;
                                break;
                            case 10:
                                objK46 = cVarB.k(descriptor2, 10, l0.f24594a, objK46);
                                i13 |= 1024;
                                objK29 = objK29;
                                objK30 = objK30;
                                objK28 = objK28;
                                objK35 = obj17;
                                objK47 = objK47;
                                break;
                            case 11:
                                objK47 = cVarB.k(descriptor2, 11, h.INSTANCE, objK47);
                                i13 |= 2048;
                                objK29 = objK29;
                                objK30 = objK30;
                                objK28 = objK28;
                                objK35 = obj17;
                                break;
                            case 12:
                                i13 |= 4096;
                                objK29 = objK29;
                                objK35 = cVarB.k(descriptor2, 12, w1.f24648a, obj17);
                                objK30 = objK30;
                                objK28 = objK28;
                                break;
                            case 13:
                                objK28 = cVarB.k(descriptor2, 13, w1.f24648a, objK28);
                                i13 |= 8192;
                                objK29 = objK29;
                                objK30 = objK30;
                                objK35 = obj17;
                                break;
                            case 14:
                                obj13 = objK28;
                                obj14 = objK29;
                                objK33 = cVarB.k(descriptor2, 14, new da.f(w1.f24648a), objK33);
                                i13 |= 16384;
                                objK29 = obj14;
                                objK35 = obj17;
                                objK28 = obj13;
                                break;
                            case 15:
                                obj13 = objK28;
                                obj14 = objK29;
                                objK34 = cVarB.k(descriptor2, 15, new da.f(w1.f24648a), objK34);
                                i11 = 32768;
                                i13 |= i11;
                                objK29 = obj14;
                                objK35 = obj17;
                                objK28 = obj13;
                                break;
                            case 16:
                                obj13 = objK28;
                                obj14 = objK29;
                                objK48 = cVarB.k(descriptor2, 16, i.a.INSTANCE, objK48);
                                i11 = 65536;
                                i13 |= i11;
                                objK29 = obj14;
                                objK35 = obj17;
                                objK28 = obj13;
                                break;
                            case 17:
                                obj13 = objK28;
                                obj14 = objK29;
                                objK32 = cVarB.k(descriptor2, 17, w1.f24648a, objK32);
                                i11 = 131072;
                                i13 |= i11;
                                objK29 = obj14;
                                objK35 = obj17;
                                objK28 = obj13;
                                break;
                            case 18:
                                obj13 = objK28;
                                obj14 = objK29;
                                objK31 = cVarB.k(descriptor2, 18, w1.f24648a, objK31);
                                i11 = 262144;
                                i13 |= i11;
                                objK29 = obj14;
                                objK35 = obj17;
                                objK28 = obj13;
                                break;
                            case 19:
                                obj13 = objK28;
                                obj14 = objK29;
                                objK30 = cVarB.k(descriptor2, 19, g.a.INSTANCE, objK30);
                                i11 = 524288;
                                i13 |= i11;
                                objK29 = obj14;
                                objK35 = obj17;
                                objK28 = obj13;
                                break;
                            case 20:
                                obj13 = objK28;
                                objK = cVarB.k(descriptor2, 20, w1.f24648a, objK);
                                i12 = 1048576;
                                i13 |= i12;
                                objK35 = obj17;
                                objK28 = obj13;
                                break;
                            case 21:
                                obj13 = objK28;
                                objK29 = cVarB.k(descriptor2, 21, w1.f24648a, objK29);
                                i12 = 2097152;
                                i13 |= i12;
                                objK35 = obj17;
                                objK28 = obj13;
                                break;
                            case 22:
                                obj13 = objK28;
                                objK4 = cVarB.k(descriptor2, 22, l0.f24594a, objK4);
                                i12 = 4194304;
                                i13 |= i12;
                                objK35 = obj17;
                                objK28 = obj13;
                                break;
                            case 23:
                                obj13 = objK28;
                                objK3 = cVarB.k(descriptor2, 23, l0.f24594a, objK3);
                                i12 = 8388608;
                                i13 |= i12;
                                objK35 = obj17;
                                objK28 = obj13;
                                break;
                            case 24:
                                obj13 = objK28;
                                objK2 = cVarB.k(descriptor2, 24, C0511b.a.INSTANCE, objK2);
                                i12 = 16777216;
                                i13 |= i12;
                                objK35 = obj17;
                                objK28 = obj13;
                                break;
                            default:
                                throw new o(iO);
                        }
                    }
                    Object obj18 = objK28;
                    obj = objK35;
                    obj2 = objK40;
                    obj3 = objK42;
                    obj4 = objK44;
                    obj5 = objK29;
                    objK5 = objK31;
                    obj6 = objK32;
                    obj7 = objK48;
                    objK6 = objK33;
                    objK7 = objK34;
                    objK8 = objK38;
                    obj8 = objK39;
                    objK9 = objK43;
                    objK10 = objK45;
                    objK11 = objK37;
                    objK12 = objK36;
                    obj9 = objK30;
                    objK13 = obj18;
                    obj10 = objK47;
                    obj11 = objK41;
                    i10 = i13;
                    obj12 = objK46;
                }
                cVarB.c(descriptor2);
                return new c(i10, (String) objK12, (String) objK11, (String) objK8, (Integer) obj8, (String) obj2, (Boolean) obj11, (Boolean) obj3, (Boolean) objK9, (String) obj4, (Integer) objK10, (Integer) obj12, (Map) obj10, (String) obj, (String) objK13, (List) objK6, (List) objK7, (i) obj7, (String) obj6, (String) objK5, (g) obj9, (String) objK, (String) obj5, (Integer) objK4, (Integer) objK3, (C0511b) objK2, (s1) null);
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

        /* JADX INFO: renamed from: com.vungle.ads.internal.model.b$c$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AdPayload.kt */
        public static final class C0513b {
            private C0513b() {
            }

            public /* synthetic */ C0513b(kotlin.jvm.internal.k kVar) {
                this();
            }

            @NotNull
            public final KSerializer<c> serializer() {
                return a.INSTANCE;
            }
        }

        public c() {
            this((String) null, (String) null, (String) null, (Integer) null, (String) null, (Boolean) null, (Boolean) null, (Boolean) null, (String) null, (Integer) null, (Integer) null, (Map) null, (String) null, (String) null, (List) null, (List) null, (i) null, (String) null, (String) null, (g) null, (String) null, (String) null, (Integer) null, (Integer) null, (C0511b) null, 33554431, (kotlin.jvm.internal.k) null);
        }

        public static final void write$Self(@NotNull c self, @NotNull ca.d output, @NotNull SerialDescriptor serialDesc) {
            Integer num;
            Integer num2;
            t.i(self, "self");
            t.i(output, "output");
            t.i(serialDesc, "serialDesc");
            if (output.z(serialDesc, 0) || self.id != null) {
                output.h(serialDesc, 0, w1.f24648a, self.id);
            }
            if (output.z(serialDesc, 1) || self.adType != null) {
                output.h(serialDesc, 1, w1.f24648a, self.adType);
            }
            if (output.z(serialDesc, 2) || self.adSource != null) {
                output.h(serialDesc, 2, w1.f24648a, self.adSource);
            }
            if (output.z(serialDesc, 3) || self.expiry != null) {
                output.h(serialDesc, 3, l0.f24594a, self.expiry);
            }
            if (output.z(serialDesc, 4) || self.deeplinkUrl != null) {
                output.h(serialDesc, 4, w1.f24648a, self.deeplinkUrl);
            }
            if (output.z(serialDesc, 5) || self.clickCoordinatesEnabled != null) {
                output.h(serialDesc, 5, da.h.f24574a, self.clickCoordinatesEnabled);
            }
            if (output.z(serialDesc, 6) || self.adLoadOptimizationEnabled != null) {
                output.h(serialDesc, 6, da.h.f24574a, self.adLoadOptimizationEnabled);
            }
            if (output.z(serialDesc, 7) || self.templateHeartbeatCheck != null) {
                output.h(serialDesc, 7, da.h.f24574a, self.templateHeartbeatCheck);
            }
            if (output.z(serialDesc, 8) || self.info != null) {
                output.h(serialDesc, 8, w1.f24648a, self.info);
            }
            if (output.z(serialDesc, 9) || self.sleep != null) {
                output.h(serialDesc, 9, l0.f24594a, self.sleep);
            }
            if (output.z(serialDesc, 10) || self.errorCode != null) {
                output.h(serialDesc, 10, l0.f24594a, self.errorCode);
            }
            if (output.z(serialDesc, 11) || self.tpat != null) {
                output.h(serialDesc, 11, h.INSTANCE, self.tpat);
            }
            if (output.z(serialDesc, 12) || self.vmURL != null) {
                output.h(serialDesc, 12, w1.f24648a, self.vmURL);
            }
            if (output.z(serialDesc, 13) || self.adMarketId != null) {
                output.h(serialDesc, 13, w1.f24648a, self.adMarketId);
            }
            if (output.z(serialDesc, 14) || self.notification != null) {
                output.h(serialDesc, 14, new da.f(w1.f24648a), self.notification);
            }
            if (output.z(serialDesc, 15) || self.loadAdUrls != null) {
                output.h(serialDesc, 15, new da.f(w1.f24648a), self.loadAdUrls);
            }
            if (output.z(serialDesc, 16) || self.viewAbility != null) {
                output.h(serialDesc, 16, i.a.INSTANCE, self.viewAbility);
            }
            if (output.z(serialDesc, 17) || self.templateURL != null) {
                output.h(serialDesc, 17, w1.f24648a, self.templateURL);
            }
            if (output.z(serialDesc, 18) || self.templateType != null) {
                output.h(serialDesc, 18, w1.f24648a, self.templateType);
            }
            if (output.z(serialDesc, 19) || self.templateSettings != null) {
                output.h(serialDesc, 19, g.a.INSTANCE, self.templateSettings);
            }
            if (output.z(serialDesc, 20) || self.creativeId != null) {
                output.h(serialDesc, 20, w1.f24648a, self.creativeId);
            }
            if (output.z(serialDesc, 21) || self.advAppId != null) {
                output.h(serialDesc, 21, w1.f24648a, self.advAppId);
            }
            if (output.z(serialDesc, 22) || (num = self.showClose) == null || num.intValue() != 0) {
                output.h(serialDesc, 22, l0.f24594a, self.showClose);
            }
            if (output.z(serialDesc, 23) || (num2 = self.showCloseIncentivized) == null || num2.intValue() != 0) {
                output.h(serialDesc, 23, l0.f24594a, self.showCloseIncentivized);
            }
            if (output.z(serialDesc, 24) || self.adSizeInfo != null) {
                output.h(serialDesc, 24, C0511b.a.INSTANCE, self.adSizeInfo);
            }
        }

        @Nullable
        public final String component1() {
            return this.id;
        }

        @Nullable
        public final Integer component10() {
            return this.sleep;
        }

        @Nullable
        public final Integer component11() {
            return this.errorCode;
        }

        @Nullable
        public final Map<String, List<String>> component12() {
            return this.tpat;
        }

        @Nullable
        public final String component13() {
            return this.vmURL;
        }

        @Nullable
        public final String component14() {
            return this.adMarketId;
        }

        @Nullable
        public final List<String> component15() {
            return this.notification;
        }

        @Nullable
        public final List<String> component16() {
            return this.loadAdUrls;
        }

        @Nullable
        public final i component17() {
            return this.viewAbility;
        }

        @Nullable
        public final String component18() {
            return this.templateURL;
        }

        @Nullable
        public final String component19() {
            return this.templateType;
        }

        @Nullable
        public final String component2() {
            return this.adType;
        }

        @Nullable
        public final g component20() {
            return this.templateSettings;
        }

        @Nullable
        public final String component21() {
            return this.creativeId;
        }

        @Nullable
        public final String component22() {
            return this.advAppId;
        }

        @Nullable
        public final Integer component23() {
            return this.showClose;
        }

        @Nullable
        public final Integer component24() {
            return this.showCloseIncentivized;
        }

        @Nullable
        public final C0511b component25() {
            return this.adSizeInfo;
        }

        @Nullable
        public final String component3() {
            return this.adSource;
        }

        @Nullable
        public final Integer component4() {
            return this.expiry;
        }

        @Nullable
        public final String component5() {
            return this.deeplinkUrl;
        }

        @Nullable
        public final Boolean component6() {
            return this.clickCoordinatesEnabled;
        }

        @Nullable
        public final Boolean component7() {
            return this.adLoadOptimizationEnabled;
        }

        @Nullable
        public final Boolean component8() {
            return this.templateHeartbeatCheck;
        }

        @Nullable
        public final String component9() {
            return this.info;
        }

        @NotNull
        public final c copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Integer num, @Nullable String str4, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable String str5, @Nullable Integer num2, @Nullable Integer num3, @Nullable Map<String, ? extends List<String>> map, @Nullable String str6, @Nullable String str7, @Nullable List<String> list, @Nullable List<String> list2, @Nullable i iVar, @Nullable String str8, @Nullable String str9, @Nullable g gVar, @Nullable String str10, @Nullable String str11, @Nullable Integer num4, @Nullable Integer num5, @Nullable C0511b c0511b) {
            return new c(str, str2, str3, num, str4, bool, bool2, bool3, str5, num2, num3, map, str6, str7, list, list2, iVar, str8, str9, gVar, str10, str11, num4, num5, c0511b);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return t.d(this.id, cVar.id) && t.d(this.adType, cVar.adType) && t.d(this.adSource, cVar.adSource) && t.d(this.expiry, cVar.expiry) && t.d(this.deeplinkUrl, cVar.deeplinkUrl) && t.d(this.clickCoordinatesEnabled, cVar.clickCoordinatesEnabled) && t.d(this.adLoadOptimizationEnabled, cVar.adLoadOptimizationEnabled) && t.d(this.templateHeartbeatCheck, cVar.templateHeartbeatCheck) && t.d(this.info, cVar.info) && t.d(this.sleep, cVar.sleep) && t.d(this.errorCode, cVar.errorCode) && t.d(this.tpat, cVar.tpat) && t.d(this.vmURL, cVar.vmURL) && t.d(this.adMarketId, cVar.adMarketId) && t.d(this.notification, cVar.notification) && t.d(this.loadAdUrls, cVar.loadAdUrls) && t.d(this.viewAbility, cVar.viewAbility) && t.d(this.templateURL, cVar.templateURL) && t.d(this.templateType, cVar.templateType) && t.d(this.templateSettings, cVar.templateSettings) && t.d(this.creativeId, cVar.creativeId) && t.d(this.advAppId, cVar.advAppId) && t.d(this.showClose, cVar.showClose) && t.d(this.showCloseIncentivized, cVar.showCloseIncentivized) && t.d(this.adSizeInfo, cVar.adSizeInfo);
        }

        @Nullable
        public final Boolean getAdLoadOptimizationEnabled() {
            return this.adLoadOptimizationEnabled;
        }

        @Nullable
        public final String getAdMarketId() {
            return this.adMarketId;
        }

        @Nullable
        public final C0511b getAdSizeInfo() {
            return this.adSizeInfo;
        }

        @Nullable
        public final String getAdSource() {
            return this.adSource;
        }

        @Nullable
        public final String getAdType() {
            return this.adType;
        }

        @Nullable
        public final String getAdvAppId() {
            return this.advAppId;
        }

        @Nullable
        public final Boolean getClickCoordinatesEnabled() {
            return this.clickCoordinatesEnabled;
        }

        @Nullable
        public final String getCreativeId() {
            return this.creativeId;
        }

        @Nullable
        public final String getDeeplinkUrl() {
            return this.deeplinkUrl;
        }

        @Nullable
        public final Integer getErrorCode() {
            return this.errorCode;
        }

        @Nullable
        public final Integer getExpiry() {
            return this.expiry;
        }

        @Nullable
        public final String getId() {
            return this.id;
        }

        @Nullable
        public final String getInfo() {
            return this.info;
        }

        @Nullable
        public final List<String> getLoadAdUrls() {
            return this.loadAdUrls;
        }

        @Nullable
        public final List<String> getNotification() {
            return this.notification;
        }

        @Nullable
        public final Integer getShowClose() {
            return this.showClose;
        }

        @Nullable
        public final Integer getShowCloseIncentivized() {
            return this.showCloseIncentivized;
        }

        @Nullable
        public final Integer getSleep() {
            return this.sleep;
        }

        @Nullable
        public final Boolean getTemplateHeartbeatCheck() {
            return this.templateHeartbeatCheck;
        }

        @Nullable
        public final g getTemplateSettings() {
            return this.templateSettings;
        }

        @Nullable
        public final String getTemplateType() {
            return this.templateType;
        }

        @Nullable
        public final String getTemplateURL() {
            return this.templateURL;
        }

        @Nullable
        public final Map<String, List<String>> getTpat() {
            return this.tpat;
        }

        @Nullable
        public final i getViewAbility() {
            return this.viewAbility;
        }

        @Nullable
        public final String getVmURL() {
            return this.vmURL;
        }

        public int hashCode() {
            String str = this.id;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.adType;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.adSource;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Integer num = this.expiry;
            int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
            String str4 = this.deeplinkUrl;
            int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Boolean bool = this.clickCoordinatesEnabled;
            int iHashCode6 = (iHashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
            Boolean bool2 = this.adLoadOptimizationEnabled;
            int iHashCode7 = (iHashCode6 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            Boolean bool3 = this.templateHeartbeatCheck;
            int iHashCode8 = (iHashCode7 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
            String str5 = this.info;
            int iHashCode9 = (iHashCode8 + (str5 == null ? 0 : str5.hashCode())) * 31;
            Integer num2 = this.sleep;
            int iHashCode10 = (iHashCode9 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.errorCode;
            int iHashCode11 = (iHashCode10 + (num3 == null ? 0 : num3.hashCode())) * 31;
            Map<String, List<String>> map = this.tpat;
            int iHashCode12 = (iHashCode11 + (map == null ? 0 : map.hashCode())) * 31;
            String str6 = this.vmURL;
            int iHashCode13 = (iHashCode12 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.adMarketId;
            int iHashCode14 = (iHashCode13 + (str7 == null ? 0 : str7.hashCode())) * 31;
            List<String> list = this.notification;
            int iHashCode15 = (iHashCode14 + (list == null ? 0 : list.hashCode())) * 31;
            List<String> list2 = this.loadAdUrls;
            int iHashCode16 = (iHashCode15 + (list2 == null ? 0 : list2.hashCode())) * 31;
            i iVar = this.viewAbility;
            int iHashCode17 = (iHashCode16 + (iVar == null ? 0 : iVar.hashCode())) * 31;
            String str8 = this.templateURL;
            int iHashCode18 = (iHashCode17 + (str8 == null ? 0 : str8.hashCode())) * 31;
            String str9 = this.templateType;
            int iHashCode19 = (iHashCode18 + (str9 == null ? 0 : str9.hashCode())) * 31;
            g gVar = this.templateSettings;
            int iHashCode20 = (iHashCode19 + (gVar == null ? 0 : gVar.hashCode())) * 31;
            String str10 = this.creativeId;
            int iHashCode21 = (iHashCode20 + (str10 == null ? 0 : str10.hashCode())) * 31;
            String str11 = this.advAppId;
            int iHashCode22 = (iHashCode21 + (str11 == null ? 0 : str11.hashCode())) * 31;
            Integer num4 = this.showClose;
            int iHashCode23 = (iHashCode22 + (num4 == null ? 0 : num4.hashCode())) * 31;
            Integer num5 = this.showCloseIncentivized;
            int iHashCode24 = (iHashCode23 + (num5 == null ? 0 : num5.hashCode())) * 31;
            C0511b c0511b = this.adSizeInfo;
            return iHashCode24 + (c0511b != null ? c0511b.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "AdUnit(id=" + this.id + ", adType=" + this.adType + ", adSource=" + this.adSource + ", expiry=" + this.expiry + ", deeplinkUrl=" + this.deeplinkUrl + ", clickCoordinatesEnabled=" + this.clickCoordinatesEnabled + ", adLoadOptimizationEnabled=" + this.adLoadOptimizationEnabled + ", templateHeartbeatCheck=" + this.templateHeartbeatCheck + ", info=" + this.info + ", sleep=" + this.sleep + ", errorCode=" + this.errorCode + ", tpat=" + this.tpat + ", vmURL=" + this.vmURL + ", adMarketId=" + this.adMarketId + ", notification=" + this.notification + ", loadAdUrls=" + this.loadAdUrls + ", viewAbility=" + this.viewAbility + ", templateURL=" + this.templateURL + ", templateType=" + this.templateType + ", templateSettings=" + this.templateSettings + ", creativeId=" + this.creativeId + ", advAppId=" + this.advAppId + ", showClose=" + this.showClose + ", showCloseIncentivized=" + this.showCloseIncentivized + ", adSizeInfo=" + this.adSizeInfo + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Integer num, @Nullable String str4, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable String str5, @Nullable Integer num2, @Nullable Integer num3, @Nullable Map<String, ? extends List<String>> map, @Nullable String str6, @Nullable String str7, @Nullable List<String> list, @Nullable List<String> list2, @Nullable i iVar, @Nullable String str8, @Nullable String str9, @Nullable g gVar, @Nullable String str10, @Nullable String str11, @Nullable Integer num4, @Nullable Integer num5, @Nullable C0511b c0511b) {
            this.id = str;
            this.adType = str2;
            this.adSource = str3;
            this.expiry = num;
            this.deeplinkUrl = str4;
            this.clickCoordinatesEnabled = bool;
            this.adLoadOptimizationEnabled = bool2;
            this.templateHeartbeatCheck = bool3;
            this.info = str5;
            this.sleep = num2;
            this.errorCode = num3;
            this.tpat = map;
            this.vmURL = str6;
            this.adMarketId = str7;
            this.notification = list;
            this.loadAdUrls = list2;
            this.viewAbility = iVar;
            this.templateURL = str8;
            this.templateType = str9;
            this.templateSettings = gVar;
            this.creativeId = str10;
            this.advAppId = str11;
            this.showClose = num4;
            this.showCloseIncentivized = num5;
            this.adSizeInfo = c0511b;
        }

        public static /* synthetic */ void getAdLoadOptimizationEnabled$annotations() {
        }

        public static /* synthetic */ void getAdMarketId$annotations() {
        }

        public static /* synthetic */ void getAdSizeInfo$annotations() {
        }

        public static /* synthetic */ void getAdSource$annotations() {
        }

        public static /* synthetic */ void getAdType$annotations() {
        }

        public static /* synthetic */ void getAdvAppId$annotations() {
        }

        public static /* synthetic */ void getClickCoordinatesEnabled$annotations() {
        }

        public static /* synthetic */ void getCreativeId$annotations() {
        }

        public static /* synthetic */ void getDeeplinkUrl$annotations() {
        }

        public static /* synthetic */ void getErrorCode$annotations() {
        }

        public static /* synthetic */ void getExpiry$annotations() {
        }

        public static /* synthetic */ void getId$annotations() {
        }

        public static /* synthetic */ void getInfo$annotations() {
        }

        public static /* synthetic */ void getLoadAdUrls$annotations() {
        }

        public static /* synthetic */ void getNotification$annotations() {
        }

        public static /* synthetic */ void getShowClose$annotations() {
        }

        public static /* synthetic */ void getShowCloseIncentivized$annotations() {
        }

        public static /* synthetic */ void getSleep$annotations() {
        }

        public static /* synthetic */ void getTemplateHeartbeatCheck$annotations() {
        }

        public static /* synthetic */ void getTemplateSettings$annotations() {
        }

        public static /* synthetic */ void getTemplateType$annotations() {
        }

        public static /* synthetic */ void getTemplateURL$annotations() {
        }

        @z9.h(with = h.class)
        public static /* synthetic */ void getTpat$annotations() {
        }

        public static /* synthetic */ void getViewAbility$annotations() {
        }

        public static /* synthetic */ void getVmURL$annotations() {
        }

        public /* synthetic */ c(int i10, String str, String str2, String str3, Integer num, String str4, Boolean bool, Boolean bool2, Boolean bool3, String str5, Integer num2, Integer num3, @z9.h(with = h.class) Map map, String str6, String str7, List list, List list2, i iVar, String str8, String str9, g gVar, String str10, String str11, Integer num4, Integer num5, C0511b c0511b, s1 s1Var) {
            if ((i10 & 0) != 0) {
                i1.a(i10, 0, a.INSTANCE.getDescriptor());
            }
            if ((i10 & 1) == 0) {
                this.id = null;
            } else {
                this.id = str;
            }
            if ((i10 & 2) == 0) {
                this.adType = null;
            } else {
                this.adType = str2;
            }
            if ((i10 & 4) == 0) {
                this.adSource = null;
            } else {
                this.adSource = str3;
            }
            if ((i10 & 8) == 0) {
                this.expiry = null;
            } else {
                this.expiry = num;
            }
            if ((i10 & 16) == 0) {
                this.deeplinkUrl = null;
            } else {
                this.deeplinkUrl = str4;
            }
            if ((i10 & 32) == 0) {
                this.clickCoordinatesEnabled = null;
            } else {
                this.clickCoordinatesEnabled = bool;
            }
            if ((i10 & 64) == 0) {
                this.adLoadOptimizationEnabled = null;
            } else {
                this.adLoadOptimizationEnabled = bool2;
            }
            if ((i10 & 128) == 0) {
                this.templateHeartbeatCheck = null;
            } else {
                this.templateHeartbeatCheck = bool3;
            }
            if ((i10 & 256) == 0) {
                this.info = null;
            } else {
                this.info = str5;
            }
            if ((i10 & 512) == 0) {
                this.sleep = null;
            } else {
                this.sleep = num2;
            }
            if ((i10 & 1024) == 0) {
                this.errorCode = null;
            } else {
                this.errorCode = num3;
            }
            if ((i10 & 2048) == 0) {
                this.tpat = null;
            } else {
                this.tpat = map;
            }
            if ((i10 & 4096) == 0) {
                this.vmURL = null;
            } else {
                this.vmURL = str6;
            }
            if ((i10 & 8192) == 0) {
                this.adMarketId = null;
            } else {
                this.adMarketId = str7;
            }
            if ((i10 & 16384) == 0) {
                this.notification = null;
            } else {
                this.notification = list;
            }
            if ((32768 & i10) == 0) {
                this.loadAdUrls = null;
            } else {
                this.loadAdUrls = list2;
            }
            if ((65536 & i10) == 0) {
                this.viewAbility = null;
            } else {
                this.viewAbility = iVar;
            }
            if ((131072 & i10) == 0) {
                this.templateURL = null;
            } else {
                this.templateURL = str8;
            }
            if ((262144 & i10) == 0) {
                this.templateType = null;
            } else {
                this.templateType = str9;
            }
            if ((524288 & i10) == 0) {
                this.templateSettings = null;
            } else {
                this.templateSettings = gVar;
            }
            if ((1048576 & i10) == 0) {
                this.creativeId = null;
            } else {
                this.creativeId = str10;
            }
            if ((2097152 & i10) == 0) {
                this.advAppId = null;
            } else {
                this.advAppId = str11;
            }
            if ((4194304 & i10) == 0) {
                this.showClose = 0;
            } else {
                this.showClose = num4;
            }
            if ((8388608 & i10) == 0) {
                this.showCloseIncentivized = 0;
            } else {
                this.showCloseIncentivized = num5;
            }
            if ((i10 & 16777216) == 0) {
                this.adSizeInfo = null;
            } else {
                this.adSizeInfo = c0511b;
            }
        }

        public /* synthetic */ c(String str, String str2, String str3, Integer num, String str4, Boolean bool, Boolean bool2, Boolean bool3, String str5, Integer num2, Integer num3, Map map, String str6, String str7, List list, List list2, i iVar, String str8, String str9, g gVar, String str10, String str11, Integer num4, Integer num5, C0511b c0511b, int i10, kotlin.jvm.internal.k kVar) {
            this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : num, (i10 & 16) != 0 ? null : str4, (i10 & 32) != 0 ? null : bool, (i10 & 64) != 0 ? null : bool2, (i10 & 128) != 0 ? null : bool3, (i10 & 256) != 0 ? null : str5, (i10 & 512) != 0 ? null : num2, (i10 & 1024) != 0 ? null : num3, (i10 & 2048) != 0 ? null : map, (i10 & 4096) != 0 ? null : str6, (i10 & 8192) != 0 ? null : str7, (i10 & 16384) != 0 ? null : list, (i10 & 32768) != 0 ? null : list2, (i10 & 65536) != 0 ? null : iVar, (i10 & 131072) != 0 ? null : str8, (i10 & 262144) != 0 ? null : str9, (i10 & 524288) != 0 ? null : gVar, (i10 & 1048576) != 0 ? null : str10, (i10 & 2097152) != 0 ? null : str11, (i10 & 4194304) != 0 ? 0 : num4, (i10 & 8388608) != 0 ? 0 : num5, (i10 & 16777216) != 0 ? null : c0511b);
        }
    }

    /* JADX INFO: compiled from: AdPayload.kt */
    @z9.h
    public static final class d {

        @NotNull
        public static final C0514b Companion = new C0514b(null);

        @Nullable
        private final String extension;

        @Nullable
        private final Boolean required;

        @Nullable
        private final String url;

        /* JADX INFO: compiled from: AdPayload.kt */
        public static final class a implements d0<d> {

            @NotNull
            public static final a INSTANCE;
            public static final /* synthetic */ SerialDescriptor descriptor;

            static {
                a aVar = new a();
                INSTANCE = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.AdPayload.CacheableReplacement", aVar, 3);
                pluginGeneratedSerialDescriptor.k("url", true);
                pluginGeneratedSerialDescriptor.k("extension", true);
                pluginGeneratedSerialDescriptor.k("required", true);
                descriptor = pluginGeneratedSerialDescriptor;
            }

            private a() {
            }

            @Override // da.d0
            @NotNull
            public KSerializer<?>[] childSerializers() {
                w1 w1Var = w1.f24648a;
                return new KSerializer[]{aa.a.s(w1Var), aa.a.s(w1Var), aa.a.s(da.h.f24574a)};
            }

            @Override // z9.b
            @NotNull
            public d deserialize(@NotNull Decoder decoder) {
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
                    objK2 = cVarB.k(descriptor2, 2, da.h.f24574a, null);
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
                            objK6 = cVarB.k(descriptor2, 2, da.h.f24574a, objK6);
                            i11 |= 4;
                        }
                    }
                    i10 = i11;
                    objK = objK5;
                    objK2 = objK6;
                }
                cVarB.c(descriptor2);
                return new d(i10, (String) objK3, (String) objK, (Boolean) objK2, (s1) null);
            }

            @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
            @NotNull
            public SerialDescriptor getDescriptor() {
                return descriptor;
            }

            @Override // z9.j
            public void serialize(@NotNull Encoder encoder, @NotNull d value) {
                t.i(encoder, "encoder");
                t.i(value, "value");
                SerialDescriptor descriptor2 = getDescriptor();
                ca.d dVarB = encoder.b(descriptor2);
                d.write$Self(value, dVarB, descriptor2);
                dVarB.c(descriptor2);
            }

            @Override // da.d0
            @NotNull
            public KSerializer<?>[] typeParametersSerializers() {
                return d0.a.a(this);
            }
        }

        /* JADX INFO: renamed from: com.vungle.ads.internal.model.b$d$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AdPayload.kt */
        public static final class C0514b {
            private C0514b() {
            }

            public /* synthetic */ C0514b(kotlin.jvm.internal.k kVar) {
                this();
            }

            @NotNull
            public final KSerializer<d> serializer() {
                return a.INSTANCE;
            }
        }

        public d() {
            this((String) null, (String) null, (Boolean) null, 7, (kotlin.jvm.internal.k) null);
        }

        public static /* synthetic */ d copy$default(d dVar, String str, String str2, Boolean bool, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = dVar.url;
            }
            if ((i10 & 2) != 0) {
                str2 = dVar.extension;
            }
            if ((i10 & 4) != 0) {
                bool = dVar.required;
            }
            return dVar.copy(str, str2, bool);
        }

        public static final void write$Self(@NotNull d self, @NotNull ca.d output, @NotNull SerialDescriptor serialDesc) {
            t.i(self, "self");
            t.i(output, "output");
            t.i(serialDesc, "serialDesc");
            if (output.z(serialDesc, 0) || self.url != null) {
                output.h(serialDesc, 0, w1.f24648a, self.url);
            }
            if (output.z(serialDesc, 1) || self.extension != null) {
                output.h(serialDesc, 1, w1.f24648a, self.extension);
            }
            if (output.z(serialDesc, 2) || self.required != null) {
                output.h(serialDesc, 2, da.h.f24574a, self.required);
            }
        }

        @Nullable
        public final String component1() {
            return this.url;
        }

        @Nullable
        public final String component2() {
            return this.extension;
        }

        @Nullable
        public final Boolean component3() {
            return this.required;
        }

        @NotNull
        public final d copy(@Nullable String str, @Nullable String str2, @Nullable Boolean bool) {
            return new d(str, str2, bool);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return t.d(this.url, dVar.url) && t.d(this.extension, dVar.extension) && t.d(this.required, dVar.required);
        }

        @Nullable
        public final String getExtension() {
            return this.extension;
        }

        @Nullable
        public final Boolean getRequired() {
            return this.required;
        }

        @Nullable
        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            String str = this.url;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.extension;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            Boolean bool = this.required;
            return iHashCode2 + (bool != null ? bool.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "CacheableReplacement(url=" + this.url + ", extension=" + this.extension + ", required=" + this.required + ')';
        }

        public /* synthetic */ d(int i10, String str, String str2, Boolean bool, s1 s1Var) {
            if ((i10 & 0) != 0) {
                i1.a(i10, 0, a.INSTANCE.getDescriptor());
            }
            if ((i10 & 1) == 0) {
                this.url = null;
            } else {
                this.url = str;
            }
            if ((i10 & 2) == 0) {
                this.extension = null;
            } else {
                this.extension = str2;
            }
            if ((i10 & 4) == 0) {
                this.required = null;
            } else {
                this.required = bool;
            }
        }

        public d(@Nullable String str, @Nullable String str2, @Nullable Boolean bool) {
            this.url = str;
            this.extension = str2;
            this.required = bool;
        }

        public /* synthetic */ d(String str, String str2, Boolean bool, int i10, kotlin.jvm.internal.k kVar) {
            this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : bool);
        }
    }

    /* JADX INFO: compiled from: AdPayload.kt */
    public static final class e {
        private e() {
        }

        public /* synthetic */ e(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final KSerializer<b> serializer() {
            return a.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: AdPayload.kt */
    @z9.h
    public static final class f {

        @NotNull
        public static final C0515b Companion = new C0515b(null);

        @Nullable
        private final c adMarkup;

        @Nullable
        private final String placementReferenceId;

        /* JADX INFO: compiled from: AdPayload.kt */
        public static final class a implements d0<f> {

            @NotNull
            public static final a INSTANCE;
            public static final /* synthetic */ SerialDescriptor descriptor;

            static {
                a aVar = new a();
                INSTANCE = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.AdPayload.PlacementAdUnit", aVar, 2);
                pluginGeneratedSerialDescriptor.k("placement_reference_id", true);
                pluginGeneratedSerialDescriptor.k("ad_markup", true);
                descriptor = pluginGeneratedSerialDescriptor;
            }

            private a() {
            }

            @Override // da.d0
            @NotNull
            public KSerializer<?>[] childSerializers() {
                return new KSerializer[]{aa.a.s(w1.f24648a), aa.a.s(c.a.INSTANCE)};
            }

            @Override // z9.b
            @NotNull
            public f deserialize(@NotNull Decoder decoder) {
                Object objK;
                Object objK2;
                int i10;
                t.i(decoder, "decoder");
                SerialDescriptor descriptor2 = getDescriptor();
                ca.c cVarB = decoder.b(descriptor2);
                s1 s1Var = null;
                if (cVarB.p()) {
                    objK = cVarB.k(descriptor2, 0, w1.f24648a, null);
                    objK2 = cVarB.k(descriptor2, 1, c.a.INSTANCE, null);
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
                            objK = cVarB.k(descriptor2, 0, w1.f24648a, objK);
                            i11 |= 1;
                        } else {
                            if (iO != 1) {
                                throw new o(iO);
                            }
                            objK3 = cVarB.k(descriptor2, 1, c.a.INSTANCE, objK3);
                            i11 |= 2;
                        }
                    }
                    objK2 = objK3;
                    i10 = i11;
                }
                cVarB.c(descriptor2);
                return new f(i10, (String) objK, (c) objK2, s1Var);
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

        /* JADX INFO: renamed from: com.vungle.ads.internal.model.b$f$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AdPayload.kt */
        public static final class C0515b {
            private C0515b() {
            }

            public /* synthetic */ C0515b(kotlin.jvm.internal.k kVar) {
                this();
            }

            @NotNull
            public final KSerializer<f> serializer() {
                return a.INSTANCE;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public f() {
            this((String) null, (c) (0 == true ? 1 : 0), 3, (kotlin.jvm.internal.k) (0 == true ? 1 : 0));
        }

        public static /* synthetic */ f copy$default(f fVar, String str, c cVar, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = fVar.placementReferenceId;
            }
            if ((i10 & 2) != 0) {
                cVar = fVar.adMarkup;
            }
            return fVar.copy(str, cVar);
        }

        public static final void write$Self(@NotNull f self, @NotNull ca.d output, @NotNull SerialDescriptor serialDesc) {
            t.i(self, "self");
            t.i(output, "output");
            t.i(serialDesc, "serialDesc");
            if (output.z(serialDesc, 0) || self.placementReferenceId != null) {
                output.h(serialDesc, 0, w1.f24648a, self.placementReferenceId);
            }
            if (output.z(serialDesc, 1) || self.adMarkup != null) {
                output.h(serialDesc, 1, c.a.INSTANCE, self.adMarkup);
            }
        }

        @Nullable
        public final String component1() {
            return this.placementReferenceId;
        }

        @Nullable
        public final c component2() {
            return this.adMarkup;
        }

        @NotNull
        public final f copy(@Nullable String str, @Nullable c cVar) {
            return new f(str, cVar);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return t.d(this.placementReferenceId, fVar.placementReferenceId) && t.d(this.adMarkup, fVar.adMarkup);
        }

        @Nullable
        public final c getAdMarkup() {
            return this.adMarkup;
        }

        @Nullable
        public final String getPlacementReferenceId() {
            return this.placementReferenceId;
        }

        public int hashCode() {
            String str = this.placementReferenceId;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            c cVar = this.adMarkup;
            return iHashCode + (cVar != null ? cVar.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "PlacementAdUnit(placementReferenceId=" + this.placementReferenceId + ", adMarkup=" + this.adMarkup + ')';
        }

        public /* synthetic */ f(int i10, String str, c cVar, s1 s1Var) {
            if ((i10 & 0) != 0) {
                i1.a(i10, 0, a.INSTANCE.getDescriptor());
            }
            if ((i10 & 1) == 0) {
                this.placementReferenceId = null;
            } else {
                this.placementReferenceId = str;
            }
            if ((i10 & 2) == 0) {
                this.adMarkup = null;
            } else {
                this.adMarkup = cVar;
            }
        }

        public f(@Nullable String str, @Nullable c cVar) {
            this.placementReferenceId = str;
            this.adMarkup = cVar;
        }

        public /* synthetic */ f(String str, c cVar, int i10, kotlin.jvm.internal.k kVar) {
            this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : cVar);
        }

        public static /* synthetic */ void getAdMarkup$annotations() {
        }

        public static /* synthetic */ void getPlacementReferenceId$annotations() {
        }
    }

    /* JADX INFO: compiled from: AdPayload.kt */
    @z9.h
    public static final class g {

        @NotNull
        public static final C0516b Companion = new C0516b(null);

        @Nullable
        private final Map<String, d> cacheableReplacements;

        @Nullable
        private final Map<String, String> normalReplacements;

        /* JADX INFO: compiled from: AdPayload.kt */
        public static final class a implements d0<g> {

            @NotNull
            public static final a INSTANCE;
            public static final /* synthetic */ SerialDescriptor descriptor;

            static {
                a aVar = new a();
                INSTANCE = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.AdPayload.TemplateSettings", aVar, 2);
                pluginGeneratedSerialDescriptor.k("normal_replacements", true);
                pluginGeneratedSerialDescriptor.k("cacheable_replacements", true);
                descriptor = pluginGeneratedSerialDescriptor;
            }

            private a() {
            }

            @Override // da.d0
            @NotNull
            public KSerializer<?>[] childSerializers() {
                w1 w1Var = w1.f24648a;
                return new KSerializer[]{aa.a.s(new p0(w1Var, w1Var)), aa.a.s(new p0(w1Var, d.a.INSTANCE))};
            }

            @Override // z9.b
            @NotNull
            public g deserialize(@NotNull Decoder decoder) {
                Object objK;
                Object objK2;
                int i10;
                t.i(decoder, "decoder");
                SerialDescriptor descriptor2 = getDescriptor();
                ca.c cVarB = decoder.b(descriptor2);
                s1 s1Var = null;
                if (cVarB.p()) {
                    w1 w1Var = w1.f24648a;
                    objK = cVarB.k(descriptor2, 0, new p0(w1Var, w1Var), null);
                    objK2 = cVarB.k(descriptor2, 1, new p0(w1Var, d.a.INSTANCE), null);
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
                            w1 w1Var2 = w1.f24648a;
                            objK = cVarB.k(descriptor2, 0, new p0(w1Var2, w1Var2), objK);
                            i11 |= 1;
                        } else {
                            if (iO != 1) {
                                throw new o(iO);
                            }
                            objK3 = cVarB.k(descriptor2, 1, new p0(w1.f24648a, d.a.INSTANCE), objK3);
                            i11 |= 2;
                        }
                    }
                    objK2 = objK3;
                    i10 = i11;
                }
                cVarB.c(descriptor2);
                return new g(i10, (Map) objK, (Map) objK2, s1Var);
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

        /* JADX INFO: renamed from: com.vungle.ads.internal.model.b$g$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AdPayload.kt */
        public static final class C0516b {
            private C0516b() {
            }

            public /* synthetic */ C0516b(kotlin.jvm.internal.k kVar) {
                this();
            }

            @NotNull
            public final KSerializer<g> serializer() {
                return a.INSTANCE;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public g() {
            this((Map) null, (Map) (0 == true ? 1 : 0), 3, (kotlin.jvm.internal.k) (0 == true ? 1 : 0));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ g copy$default(g gVar, Map map, Map map2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                map = gVar.normalReplacements;
            }
            if ((i10 & 2) != 0) {
                map2 = gVar.cacheableReplacements;
            }
            return gVar.copy(map, map2);
        }

        public static final void write$Self(@NotNull g self, @NotNull ca.d output, @NotNull SerialDescriptor serialDesc) {
            t.i(self, "self");
            t.i(output, "output");
            t.i(serialDesc, "serialDesc");
            if (output.z(serialDesc, 0) || self.normalReplacements != null) {
                w1 w1Var = w1.f24648a;
                output.h(serialDesc, 0, new p0(w1Var, w1Var), self.normalReplacements);
            }
            if (output.z(serialDesc, 1) || self.cacheableReplacements != null) {
                output.h(serialDesc, 1, new p0(w1.f24648a, d.a.INSTANCE), self.cacheableReplacements);
            }
        }

        @Nullable
        public final Map<String, String> component1() {
            return this.normalReplacements;
        }

        @Nullable
        public final Map<String, d> component2() {
            return this.cacheableReplacements;
        }

        @NotNull
        public final g copy(@Nullable Map<String, String> map, @Nullable Map<String, d> map2) {
            return new g(map, map2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return t.d(this.normalReplacements, gVar.normalReplacements) && t.d(this.cacheableReplacements, gVar.cacheableReplacements);
        }

        @Nullable
        public final Map<String, d> getCacheableReplacements() {
            return this.cacheableReplacements;
        }

        @Nullable
        public final Map<String, String> getNormalReplacements() {
            return this.normalReplacements;
        }

        public int hashCode() {
            Map<String, String> map = this.normalReplacements;
            int iHashCode = (map == null ? 0 : map.hashCode()) * 31;
            Map<String, d> map2 = this.cacheableReplacements;
            return iHashCode + (map2 != null ? map2.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "TemplateSettings(normalReplacements=" + this.normalReplacements + ", cacheableReplacements=" + this.cacheableReplacements + ')';
        }

        public /* synthetic */ g(int i10, Map map, Map map2, s1 s1Var) {
            if ((i10 & 0) != 0) {
                i1.a(i10, 0, a.INSTANCE.getDescriptor());
            }
            if ((i10 & 1) == 0) {
                this.normalReplacements = null;
            } else {
                this.normalReplacements = map;
            }
            if ((i10 & 2) == 0) {
                this.cacheableReplacements = null;
            } else {
                this.cacheableReplacements = map2;
            }
        }

        public g(@Nullable Map<String, String> map, @Nullable Map<String, d> map2) {
            this.normalReplacements = map;
            this.cacheableReplacements = map2;
        }

        public /* synthetic */ g(Map map, Map map2, int i10, kotlin.jvm.internal.k kVar) {
            this((i10 & 1) != 0 ? null : map, (i10 & 2) != 0 ? null : map2);
        }

        public static /* synthetic */ void getCacheableReplacements$annotations() {
        }

        public static /* synthetic */ void getNormalReplacements$annotations() {
        }
    }

    /* JADX INFO: compiled from: AdPayload.kt */
    public static final class h extends v<Map<String, ? extends List<? extends String>>> {

        @NotNull
        public static final h INSTANCE = new h();

        /* JADX WARN: Illegal instructions before constructor call */
        private h() {
            s0 s0Var = s0.f29840a;
            super(aa.a.k(aa.a.B(s0Var), aa.a.h(aa.a.B(s0Var))));
        }

        @Override // kotlinx.serialization.json.v
        @NotNull
        protected JsonElement transformDeserialize(@NotNull JsonElement element) {
            t.i(element, "element");
            JsonObject jsonObjectK = kotlinx.serialization.json.h.k(element);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, JsonElement> entry : jsonObjectK.entrySet()) {
                if (!t.d(entry.getKey(), "moat")) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            return new JsonObject(linkedHashMap);
        }
    }

    /* JADX INFO: compiled from: AdPayload.kt */
    @z9.h
    public static final class i {

        @NotNull
        public static final C0517b Companion = new C0517b(null);

        @Nullable
        private final j om;

        /* JADX INFO: compiled from: AdPayload.kt */
        public static final class a implements d0<i> {

            @NotNull
            public static final a INSTANCE;
            public static final /* synthetic */ SerialDescriptor descriptor;

            static {
                a aVar = new a();
                INSTANCE = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.AdPayload.ViewAbility", aVar, 1);
                pluginGeneratedSerialDescriptor.k("om", true);
                descriptor = pluginGeneratedSerialDescriptor;
            }

            private a() {
            }

            @Override // da.d0
            @NotNull
            public KSerializer<?>[] childSerializers() {
                return new KSerializer[]{aa.a.s(j.a.INSTANCE)};
            }

            @Override // z9.b
            @NotNull
            public i deserialize(@NotNull Decoder decoder) {
                Object objK;
                t.i(decoder, "decoder");
                SerialDescriptor descriptor2 = getDescriptor();
                ca.c cVarB = decoder.b(descriptor2);
                int i10 = 1;
                s1 s1Var = null;
                if (cVarB.p()) {
                    objK = cVarB.k(descriptor2, 0, j.a.INSTANCE, null);
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
                            objK = cVarB.k(descriptor2, 0, j.a.INSTANCE, objK);
                            i11 |= 1;
                        }
                    }
                    i10 = i11;
                }
                cVarB.c(descriptor2);
                return new i(i10, (j) objK, s1Var);
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

        /* JADX INFO: renamed from: com.vungle.ads.internal.model.b$i$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AdPayload.kt */
        public static final class C0517b {
            private C0517b() {
            }

            public /* synthetic */ C0517b(kotlin.jvm.internal.k kVar) {
                this();
            }

            @NotNull
            public final KSerializer<i> serializer() {
                return a.INSTANCE;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public i() {
            this((j) null, 1, (kotlin.jvm.internal.k) (0 == true ? 1 : 0));
        }

        public static /* synthetic */ i copy$default(i iVar, j jVar, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                jVar = iVar.om;
            }
            return iVar.copy(jVar);
        }

        public static final void write$Self(@NotNull i self, @NotNull ca.d output, @NotNull SerialDescriptor serialDesc) {
            t.i(self, "self");
            t.i(output, "output");
            t.i(serialDesc, "serialDesc");
            boolean z10 = true;
            if (!output.z(serialDesc, 0) && self.om == null) {
                z10 = false;
            }
            if (z10) {
                output.h(serialDesc, 0, j.a.INSTANCE, self.om);
            }
        }

        @Nullable
        public final j component1() {
            return this.om;
        }

        @NotNull
        public final i copy(@Nullable j jVar) {
            return new i(jVar);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof i) && t.d(this.om, ((i) obj).om);
        }

        @Nullable
        public final j getOm() {
            return this.om;
        }

        public int hashCode() {
            j jVar = this.om;
            if (jVar == null) {
                return 0;
            }
            return jVar.hashCode();
        }

        @NotNull
        public String toString() {
            return "ViewAbility(om=" + this.om + ')';
        }

        public /* synthetic */ i(int i10, j jVar, s1 s1Var) {
            if ((i10 & 0) != 0) {
                i1.a(i10, 0, a.INSTANCE.getDescriptor());
            }
            if ((i10 & 1) == 0) {
                this.om = null;
            } else {
                this.om = jVar;
            }
        }

        public i(@Nullable j jVar) {
            this.om = jVar;
        }

        public /* synthetic */ i(j jVar, int i10, kotlin.jvm.internal.k kVar) {
            this((i10 & 1) != 0 ? null : jVar);
        }
    }

    /* JADX INFO: compiled from: AdPayload.kt */
    @z9.h
    public static final class j {

        @NotNull
        public static final C0518b Companion = new C0518b(null);

        @Nullable
        private final String extraVast;

        @Nullable
        private final Boolean isEnabled;

        /* JADX INFO: compiled from: AdPayload.kt */
        public static final class a implements d0<j> {

            @NotNull
            public static final a INSTANCE;
            public static final /* synthetic */ SerialDescriptor descriptor;

            static {
                a aVar = new a();
                INSTANCE = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.AdPayload.ViewAbilityInfo", aVar, 2);
                pluginGeneratedSerialDescriptor.k("is_enabled", true);
                pluginGeneratedSerialDescriptor.k("extra_vast", true);
                descriptor = pluginGeneratedSerialDescriptor;
            }

            private a() {
            }

            @Override // da.d0
            @NotNull
            public KSerializer<?>[] childSerializers() {
                return new KSerializer[]{aa.a.s(da.h.f24574a), aa.a.s(w1.f24648a)};
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
                    objK = cVarB.k(descriptor2, 0, da.h.f24574a, null);
                    objK2 = cVarB.k(descriptor2, 1, w1.f24648a, null);
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
                            objK3 = cVarB.k(descriptor2, 1, w1.f24648a, objK3);
                            i11 |= 2;
                        }
                    }
                    objK2 = objK3;
                    i10 = i11;
                }
                cVarB.c(descriptor2);
                return new j(i10, (Boolean) objK, (String) objK2, s1Var);
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

        /* JADX INFO: renamed from: com.vungle.ads.internal.model.b$j$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AdPayload.kt */
        public static final class C0518b {
            private C0518b() {
            }

            public /* synthetic */ C0518b(kotlin.jvm.internal.k kVar) {
                this();
            }

            @NotNull
            public final KSerializer<j> serializer() {
                return a.INSTANCE;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public j() {
            this((Boolean) null, (String) (0 == true ? 1 : 0), 3, (kotlin.jvm.internal.k) (0 == true ? 1 : 0));
        }

        public static /* synthetic */ j copy$default(j jVar, Boolean bool, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                bool = jVar.isEnabled;
            }
            if ((i10 & 2) != 0) {
                str = jVar.extraVast;
            }
            return jVar.copy(bool, str);
        }

        public static final void write$Self(@NotNull j self, @NotNull ca.d output, @NotNull SerialDescriptor serialDesc) {
            t.i(self, "self");
            t.i(output, "output");
            t.i(serialDesc, "serialDesc");
            if (output.z(serialDesc, 0) || self.isEnabled != null) {
                output.h(serialDesc, 0, da.h.f24574a, self.isEnabled);
            }
            if (output.z(serialDesc, 1) || self.extraVast != null) {
                output.h(serialDesc, 1, w1.f24648a, self.extraVast);
            }
        }

        @Nullable
        public final Boolean component1() {
            return this.isEnabled;
        }

        @Nullable
        public final String component2() {
            return this.extraVast;
        }

        @NotNull
        public final j copy(@Nullable Boolean bool, @Nullable String str) {
            return new j(bool, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            return t.d(this.isEnabled, jVar.isEnabled) && t.d(this.extraVast, jVar.extraVast);
        }

        @Nullable
        public final String getExtraVast() {
            return this.extraVast;
        }

        public int hashCode() {
            Boolean bool = this.isEnabled;
            int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            String str = this.extraVast;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        @Nullable
        public final Boolean isEnabled() {
            return this.isEnabled;
        }

        @NotNull
        public String toString() {
            return "ViewAbilityInfo(isEnabled=" + this.isEnabled + ", extraVast=" + this.extraVast + ')';
        }

        public /* synthetic */ j(int i10, Boolean bool, String str, s1 s1Var) {
            if ((i10 & 0) != 0) {
                i1.a(i10, 0, a.INSTANCE.getDescriptor());
            }
            if ((i10 & 1) == 0) {
                this.isEnabled = null;
            } else {
                this.isEnabled = bool;
            }
            if ((i10 & 2) == 0) {
                this.extraVast = null;
            } else {
                this.extraVast = str;
            }
        }

        public j(@Nullable Boolean bool, @Nullable String str) {
            this.isEnabled = bool;
            this.extraVast = str;
        }

        public /* synthetic */ j(Boolean bool, String str, int i10, kotlin.jvm.internal.k kVar) {
            this((i10 & 1) != 0 ? null : bool, (i10 & 2) != 0 ? null : str);
        }

        public static /* synthetic */ void getExtraVast$annotations() {
        }

        public static /* synthetic */ void isEnabled$annotations() {
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class k<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return x8.b.a(Boolean.valueOf(((com.vungle.ads.internal.model.a) t11).isRequired()), Boolean.valueOf(((com.vungle.ads.internal.model.a) t10).isRequired()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    private final String complexReplace(String str, String str2, String str3) {
        String strQuote = Pattern.quote(str2);
        t.h(strQuote, "quote(oldValue)");
        return new p9.f(strQuote).b(str, valueOrEmpty(str3));
    }

    private final f getAd() {
        List<f> list = this.ads;
        if (list == null || !(!list.isEmpty())) {
            return null;
        }
        return list.get(0);
    }

    private final c getAdMarkup() {
        f ad = getAd();
        if (ad != null) {
            return ad.getAdMarkup();
        }
        return null;
    }

    public static /* synthetic */ List getTpatUrls$default(b bVar, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        if ((i10 & 4) != 0) {
            str3 = null;
        }
        return bVar.getTpatUrls(str, str2, str3);
    }

    private final String valueOrEmpty(String str) {
        return str == null ? "" : str;
    }

    public static final void write$Self(@NotNull b self, @NotNull ca.d output, @NotNull SerialDescriptor serialDesc) {
        t.i(self, "self");
        t.i(output, "output");
        t.i(serialDesc, "serialDesc");
        if (output.z(serialDesc, 0) || self.ads != null) {
            output.h(serialDesc, 0, new da.f(f.a.INSTANCE), self.ads);
        }
        if (output.z(serialDesc, 1) || self.config != null) {
            output.h(serialDesc, 1, g.a.INSTANCE, self.config);
        }
        if (output.z(serialDesc, 2) || !t.d(self.mraidFiles, new ConcurrentHashMap())) {
            KClass kClassB = o0.b(ConcurrentHashMap.class);
            w1 w1Var = w1.f24648a;
            output.j(serialDesc, 2, new z9.a(kClassB, null, new KSerializer[]{w1Var, w1Var}), self.mraidFiles);
        }
        if (output.z(serialDesc, 3) || !t.d(self.incentivizedTextSettings, new HashMap())) {
            w1 w1Var2 = w1.f24648a;
            output.j(serialDesc, 3, new p0(w1Var2, w1Var2), self.incentivizedTextSettings);
        }
        if (output.z(serialDesc, 4) || self.assetsFullyDownloaded) {
            output.x(serialDesc, 4, self.assetsFullyDownloaded);
        }
    }

    public final int adHeight() {
        C0511b adSizeInfo;
        Integer height;
        c adMarkup = getAdMarkup();
        if (adMarkup == null || (adSizeInfo = adMarkup.getAdSizeInfo()) == null || (height = adSizeInfo.getHeight()) == null) {
            return 0;
        }
        return height.intValue();
    }

    public final boolean adLoadOptimizationEnabled() {
        Boolean adLoadOptimizationEnabled;
        c adMarkup = getAdMarkup();
        if (adMarkup == null || (adLoadOptimizationEnabled = adMarkup.getAdLoadOptimizationEnabled()) == null) {
            return true;
        }
        return adLoadOptimizationEnabled.booleanValue();
    }

    @Nullable
    public final c adUnit() {
        return getAdMarkup();
    }

    public final int adWidth() {
        C0511b adSizeInfo;
        Integer width;
        c adMarkup = getAdMarkup();
        if (adMarkup == null || (adSizeInfo = adMarkup.getAdSizeInfo()) == null || (width = adSizeInfo.getWidth()) == null) {
            return 0;
        }
        return width.intValue();
    }

    @Nullable
    public final String advAppId() {
        c adMarkup = getAdMarkup();
        if (adMarkup != null) {
            return adMarkup.getAdvAppId();
        }
        return null;
    }

    @Nullable
    public final com.vungle.ads.internal.model.g config() {
        return this.config;
    }

    @NotNull
    public final JsonObject createMRAIDArgs() {
        Map<String, String> mRAIDArgsInMap = getMRAIDArgsInMap();
        r rVar = new r();
        for (Map.Entry<String, String> entry : mRAIDArgsInMap.entrySet()) {
            kotlinx.serialization.json.g.c(rVar, entry.getKey(), entry.getValue());
        }
        return rVar.a();
    }

    @Nullable
    public final String eventId() {
        c adMarkup = getAdMarkup();
        if (adMarkup != null) {
            return adMarkup.getId();
        }
        return null;
    }

    @Nullable
    public final com.vungle.ads.c getAdConfig() {
        return this.adConfig;
    }

    @Nullable
    public final File getAssetDirectory() {
        return this.assetDirectory;
    }

    public final boolean getAssetsFullyDownloaded() {
        return this.assetsFullyDownloaded;
    }

    @NotNull
    public final String getCreativeId() {
        String creativeId;
        c adMarkup = getAdMarkup();
        return (adMarkup == null || (creativeId = adMarkup.getCreativeId()) == null) ? "unknown" : creativeId;
    }

    @NotNull
    public final List<com.vungle.ads.internal.model.a> getDownloadableAssets(@NotNull File dir) {
        g templateSettings;
        Map<String, d> cacheableReplacements;
        String templateURL;
        String vmURL;
        t.i(dir, "dir");
        this.assetDirectory = dir;
        ArrayList arrayList = new ArrayList();
        if (!isNativeTemplateType()) {
            c adMarkup = getAdMarkup();
            if (adMarkup == null || (vmURL = adMarkup.getVmURL()) == null) {
                c adMarkup2 = getAdMarkup();
                if (adMarkup2 != null && (templateURL = adMarkup2.getTemplateURL()) != null && com.vungle.ads.internal.util.i.INSTANCE.isValidUrl(templateURL)) {
                    String filePath = new File(dir, KEY_TEMPLATE).getAbsolutePath();
                    t.h(filePath, "filePath");
                    arrayList.add(new com.vungle.ads.internal.model.a(KEY_TEMPLATE, templateURL, filePath, a.EnumC0510a.ZIP, true));
                }
            } else if (com.vungle.ads.internal.util.i.INSTANCE.isValidUrl(vmURL)) {
                String filePath2 = new File(dir, com.vungle.ads.internal.l.AD_INDEX_FILE_NAME).getAbsolutePath();
                t.h(filePath2, "filePath");
                arrayList.add(new com.vungle.ads.internal.model.a(KEY_VM, vmURL, filePath2, a.EnumC0510a.ASSET, true));
            }
        }
        c adMarkup3 = getAdMarkup();
        if (adMarkup3 != null && (templateSettings = adMarkup3.getTemplateSettings()) != null && (cacheableReplacements = templateSettings.getCacheableReplacements()) != null) {
            for (Map.Entry<String, d> entry : cacheableReplacements.entrySet()) {
                d value = entry.getValue();
                if (value.getUrl() != null) {
                    com.vungle.ads.internal.util.i iVar = com.vungle.ads.internal.util.i.INSTANCE;
                    if (iVar.isValidUrl(value.getUrl())) {
                        Boolean required = value.getRequired();
                        boolean zBooleanValue = (!isNativeTemplateType() && adLoadOptimizationEnabled()) ? !com.vungle.ads.internal.k.INSTANCE.isCacheableAssetsRequired() ? false : required != null ? required.booleanValue() : false : true;
                        String filePath3 = new File(dir, iVar.guessFileName(value.getUrl(), value.getExtension())).getAbsolutePath();
                        String key = entry.getKey();
                        String url = value.getUrl();
                        t.h(filePath3, "filePath");
                        arrayList.add(new com.vungle.ads.internal.model.a(key, url, filePath3, a.EnumC0510a.ASSET, zBooleanValue));
                    }
                }
            }
        }
        if (arrayList.size() > 1) {
            z.A(arrayList, new k());
        }
        return arrayList;
    }

    @NotNull
    public final Map<String, String> getIncentivizedTextSettings() {
        return this.incentivizedTextSettings;
    }

    @NotNull
    public final Map<String, String> getMRAIDArgsInMap() {
        g templateSettings;
        Map<String, d> cacheableReplacements;
        g templateSettings2;
        Map<String, String> normalReplacements;
        c adMarkup = getAdMarkup();
        if ((adMarkup != null ? adMarkup.getTemplateSettings() : null) == null) {
            throw new IllegalArgumentException("Advertisement does not have MRAID Arguments!".toString());
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        c adMarkup2 = getAdMarkup();
        if (adMarkup2 != null && (templateSettings2 = adMarkup2.getTemplateSettings()) != null && (normalReplacements = templateSettings2.getNormalReplacements()) != null) {
            linkedHashMap.putAll(normalReplacements);
        }
        c adMarkup3 = getAdMarkup();
        if (adMarkup3 != null && (templateSettings = adMarkup3.getTemplateSettings()) != null && (cacheableReplacements = templateSettings.getCacheableReplacements()) != null) {
            for (Map.Entry<String, d> entry : cacheableReplacements.entrySet()) {
                String url = entry.getValue().getUrl();
                if (url != null) {
                    linkedHashMap.put(entry.getKey(), url);
                }
            }
        }
        if (!this.mraidFiles.isEmpty()) {
            linkedHashMap.putAll(this.mraidFiles);
        }
        if (!this.incentivizedTextSettings.isEmpty()) {
            linkedHashMap.putAll(this.incentivizedTextSettings);
        }
        return linkedHashMap;
    }

    public final int getShowCloseDelay(@Nullable Boolean bool) {
        Integer showClose;
        Integer showCloseIncentivized;
        if (t.d(bool, Boolean.TRUE)) {
            c adMarkup = getAdMarkup();
            if (adMarkup == null || (showCloseIncentivized = adMarkup.getShowCloseIncentivized()) == null) {
                return 0;
            }
            return showCloseIncentivized.intValue() * 1000;
        }
        c adMarkup2 = getAdMarkup();
        if (adMarkup2 == null || (showClose = adMarkup2.getShowClose()) == null) {
            return 0;
        }
        return showClose.intValue() * 1000;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Nullable
    public final List<String> getTpatUrls(@NotNull String event, @Nullable String str, @Nullable String str2) {
        ArrayList arrayList;
        Map<String, List<String>> tpat;
        Map<String, List<String>> tpat2;
        t.i(event, "event");
        c adMarkup = getAdMarkup();
        if ((adMarkup == null || (tpat2 = adMarkup.getTpat()) == null || tpat2.containsKey(event)) ? false : true) {
            com.vungle.ads.o.INSTANCE.logError$vungle_ads_release(128, "Arbitrary tpat key: " + event, placementId(), getCreativeId(), eventId());
            return null;
        }
        c adMarkup2 = getAdMarkup();
        List<String> list = (adMarkup2 == null || (tpat = adMarkup2.getTpat()) == null) ? null : tpat.get(event);
        List<String> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            com.vungle.ads.o.INSTANCE.logError$vungle_ads_release(129, "Empty tpat key: " + event, placementId(), getCreativeId(), eventId());
            return null;
        }
        switch (event.hashCode()) {
            case -2125915830:
                if (!event.equals(com.vungle.ads.internal.l.CHECKPOINT_0)) {
                    return list;
                }
                List<String> list3 = list;
                arrayList = new ArrayList(w.v(list3, 10));
                Iterator<T> it = list3.iterator();
                while (it.hasNext()) {
                    arrayList.add(complexReplace(complexReplace(complexReplace((String) it.next(), com.vungle.ads.internal.l.REMOTE_PLAY_KEY, String.valueOf(!this.assetsFullyDownloaded)), com.vungle.ads.internal.l.NETWORK_OPERATOR_KEY, str), com.vungle.ads.internal.l.DEVICE_VOLUME_KEY, str2));
                }
                break;
                break;
            case -132489083:
                if (!event.equals(com.vungle.ads.internal.l.AD_LOAD_DURATION_TPAT_KEY)) {
                    return list;
                }
                List<String> list4 = list;
                arrayList = new ArrayList(w.v(list4, 10));
                Iterator<T> it2 = list4.iterator();
                while (it2.hasNext()) {
                    arrayList.add(complexReplace((String) it2.next(), com.vungle.ads.internal.l.AD_LOAD_DURATION_KEY, str));
                }
                break;
                break;
            case 1516630125:
                if (!event.equals(com.vungle.ads.internal.l.AD_CLOSE_TPAT_KEY)) {
                    return list;
                }
                List<String> list5 = list;
                arrayList = new ArrayList(w.v(list5, 10));
                Iterator<T> it3 = list5.iterator();
                while (it3.hasNext()) {
                    arrayList.add(complexReplace(complexReplace((String) it3.next(), com.vungle.ads.internal.l.AD_DURATION_KEY, str), com.vungle.ads.internal.l.DEVICE_VOLUME_KEY, str2));
                }
                break;
                break;
            case 1940309120:
                if (!event.equals(com.vungle.ads.internal.l.DEEPLINK_CLICK)) {
                    return list;
                }
                List<String> list6 = list;
                arrayList = new ArrayList(w.v(list6, 10));
                Iterator<T> it4 = list6.iterator();
                while (it4.hasNext()) {
                    arrayList.add(complexReplace((String) it4.next(), com.vungle.ads.internal.l.DEEPLINK_SUCCESS_KEY, str));
                }
                break;
                break;
            default:
                return list;
        }
        return arrayList;
    }

    @Nullable
    public final List<String> getWinNotifications() {
        c adMarkup = getAdMarkup();
        if (adMarkup != null) {
            return adMarkup.getNotification();
        }
        return null;
    }

    public final boolean hasExpired() {
        Integer expiry;
        c adMarkup = getAdMarkup();
        if (adMarkup == null || (expiry = adMarkup.getExpiry()) == null) {
            return false;
        }
        return (((long) expiry.intValue()) > (System.currentTimeMillis() / 1000) ? 1 : (((long) expiry.intValue()) == (System.currentTimeMillis() / 1000) ? 0 : -1)) < 0;
    }

    public final boolean heartbeatEnabled() {
        Boolean templateHeartbeatCheck;
        c adMarkup = getAdMarkup();
        if (adMarkup == null || (templateHeartbeatCheck = adMarkup.getTemplateHeartbeatCheck()) == null) {
            return false;
        }
        return templateHeartbeatCheck.booleanValue();
    }

    public final boolean isClickCoordinatesTrackingEnabled() {
        Boolean clickCoordinatesEnabled;
        c adMarkup = getAdMarkup();
        if (adMarkup == null || (clickCoordinatesEnabled = adMarkup.getClickCoordinatesEnabled()) == null) {
            return false;
        }
        return clickCoordinatesEnabled.booleanValue();
    }

    public final boolean isCriticalAsset(@NotNull String failingUrl) {
        g templateSettings;
        Map<String, d> cacheableReplacements;
        t.i(failingUrl, "failingUrl");
        if (!isNativeTemplateType()) {
            c adMarkup = getAdMarkup();
            if (t.d(adMarkup != null ? adMarkup.getTemplateURL() : null, failingUrl)) {
                return true;
            }
        }
        c adMarkup2 = getAdMarkup();
        if (adMarkup2 == null || (templateSettings = adMarkup2.getTemplateSettings()) == null || (cacheableReplacements = templateSettings.getCacheableReplacements()) == null) {
            return false;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, d> entry : cacheableReplacements.entrySet()) {
            if (t.d(entry.getValue().getUrl(), failingUrl)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return !linkedHashMap.isEmpty();
    }

    public final boolean isNativeTemplateType() {
        return t.d(templateType(), "native");
    }

    public final boolean omEnabled() {
        i viewAbility;
        j om;
        Boolean boolIsEnabled;
        c adMarkup = getAdMarkup();
        if (adMarkup == null || (viewAbility = adMarkup.getViewAbility()) == null || (om = viewAbility.getOm()) == null || (boolIsEnabled = om.isEnabled()) == null) {
            return false;
        }
        return boolIsEnabled.booleanValue();
    }

    @Nullable
    public final String placementId() {
        f ad = getAd();
        if (ad != null) {
            return ad.getPlacementReferenceId();
        }
        return null;
    }

    public final void setAdConfig(@Nullable com.vungle.ads.c cVar) {
        this.adConfig = cVar;
    }

    public final void setAssetFullyDownloaded() {
        this.assetsFullyDownloaded = true;
    }

    public final void setAssetsFullyDownloaded(boolean z10) {
        this.assetsFullyDownloaded = z10;
    }

    public final void setIncentivizedText(@NotNull String title, @NotNull String body, @NotNull String keepWatching, @NotNull String close) {
        t.i(title, "title");
        t.i(body, "body");
        t.i(keepWatching, "keepWatching");
        t.i(close, "close");
        if (title.length() > 0) {
            this.incentivizedTextSettings.put(INCENTIVIZED_TITLE_TEXT, title);
        }
        if (body.length() > 0) {
            this.incentivizedTextSettings.put(INCENTIVIZED_BODY_TEXT, body);
        }
        if (keepWatching.length() > 0) {
            this.incentivizedTextSettings.put(INCENTIVIZED_CONTINUE_TEXT, keepWatching);
        }
        if (close.length() > 0) {
            this.incentivizedTextSettings.put(INCENTIVIZED_CLOSE_TEXT, close);
        }
    }

    public final void setIncentivizedTextSettings(@NotNull Map<String, String> map) {
        t.i(map, "<set-?>");
        this.incentivizedTextSettings = map;
    }

    @Nullable
    public final String templateType() {
        c adMarkup = getAdMarkup();
        if (adMarkup != null) {
            return adMarkup.getTemplateType();
        }
        return null;
    }

    public final synchronized void updateAdAssetPath(@Nullable com.vungle.ads.internal.model.a aVar) {
        if (aVar != null) {
            if (!t.d(KEY_TEMPLATE, aVar.getAdIdentifier())) {
                File file = new File(aVar.getLocalPath());
                if (file.exists()) {
                    String adIdentifier = aVar.getAdIdentifier();
                    this.mraidFiles.put(adIdentifier, FILE_SCHEME + file.getPath());
                }
            }
        }
    }

    public /* synthetic */ b(int i10, List list, com.vungle.ads.internal.model.g gVar, ConcurrentHashMap concurrentHashMap, @VisibleForTesting Map map, boolean z10, s1 s1Var) {
        if ((i10 & 0) != 0) {
            i1.a(i10, 0, a.INSTANCE.getDescriptor());
        }
        if ((i10 & 1) == 0) {
            this.ads = null;
        } else {
            this.ads = list;
        }
        if ((i10 & 2) == 0) {
            this.config = null;
        } else {
            this.config = gVar;
        }
        if ((i10 & 4) == 0) {
            this.mraidFiles = new ConcurrentHashMap<>();
        } else {
            this.mraidFiles = concurrentHashMap;
        }
        if ((i10 & 8) == 0) {
            this.incentivizedTextSettings = new HashMap();
        } else {
            this.incentivizedTextSettings = map;
        }
        if ((i10 & 16) == 0) {
            this.assetsFullyDownloaded = false;
        } else {
            this.assetsFullyDownloaded = z10;
        }
        this.adConfig = null;
        this.assetDirectory = null;
    }

    public b(@Nullable List<f> list, @Nullable com.vungle.ads.internal.model.g gVar) {
        this.ads = list;
        this.config = gVar;
        this.mraidFiles = new ConcurrentHashMap<>();
        this.incentivizedTextSettings = new HashMap();
    }

    public /* synthetic */ b(List list, com.vungle.ads.internal.model.g gVar, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? null : list, (i10 & 2) != 0 ? null : gVar);
    }

    public static /* synthetic */ void getAdConfig$annotations() {
    }

    private static /* synthetic */ void getAds$annotations() {
    }

    public static /* synthetic */ void getAssetDirectory$annotations() {
    }

    private static /* synthetic */ void getConfig$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getIncentivizedTextSettings$annotations() {
    }

    private static /* synthetic */ void getMraidFiles$annotations() {
    }
}
