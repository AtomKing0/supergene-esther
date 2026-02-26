package com.vungle.ads.internal.model;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.ironsource.jo;
import com.onetrust.otpublishers.headless.Public.OTVendorListMode;
import com.vungle.ads.internal.model.d;
import com.vungle.ads.internal.model.h;
import da.d0;
import da.i1;
import da.l0;
import da.s1;
import da.u0;
import da.w1;
import io.sentry.protocol.App;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import o7.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z9.o;

/* JADX INFO: compiled from: CommonRequestBody.kt */
/* JADX INFO: loaded from: classes4.dex */
@z9.h
public final class f {

    @NotNull
    public static final e Companion = new e(null);

    @Nullable
    private final com.vungle.ads.internal.model.d app;

    @NotNull
    private final com.vungle.ads.internal.model.h device;

    @Nullable
    private h ext;

    @Nullable
    private i request;

    @Nullable
    private final j user;

    /* JADX INFO: compiled from: CommonRequestBody.kt */
    public static final class a implements d0<f> {

        @NotNull
        public static final a INSTANCE;
        public static final /* synthetic */ SerialDescriptor descriptor;

        static {
            a aVar = new a();
            INSTANCE = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.CommonRequestBody", aVar, 5);
            pluginGeneratedSerialDescriptor.k("device", false);
            pluginGeneratedSerialDescriptor.k(App.TYPE, true);
            pluginGeneratedSerialDescriptor.k("user", true);
            pluginGeneratedSerialDescriptor.k("ext", true);
            pluginGeneratedSerialDescriptor.k(com.vungle.ads.internal.ui.a.REQUEST_KEY_EXTRA, true);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        private a() {
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] childSerializers() {
            return new KSerializer[]{h.a.INSTANCE, aa.a.s(d.a.INSTANCE), aa.a.s(j.a.INSTANCE), aa.a.s(h.a.INSTANCE), aa.a.s(i.a.INSTANCE)};
        }

        @Override // z9.b
        @NotNull
        public f deserialize(@NotNull Decoder decoder) {
            Object objK;
            Object objK2;
            Object objK3;
            Object objK4;
            int i10;
            Object objY;
            t.i(decoder, "decoder");
            SerialDescriptor descriptor2 = getDescriptor();
            ca.c cVarB = decoder.b(descriptor2);
            Object objY2 = null;
            if (cVarB.p()) {
                objY = cVarB.y(descriptor2, 0, h.a.INSTANCE, null);
                objK = cVarB.k(descriptor2, 1, d.a.INSTANCE, null);
                objK2 = cVarB.k(descriptor2, 2, j.a.INSTANCE, null);
                objK3 = cVarB.k(descriptor2, 3, h.a.INSTANCE, null);
                objK4 = cVarB.k(descriptor2, 4, i.a.INSTANCE, null);
                i10 = 31;
            } else {
                boolean z10 = true;
                int i11 = 0;
                Object objK5 = null;
                Object objK6 = null;
                Object objK7 = null;
                Object objK8 = null;
                while (z10) {
                    int iO = cVarB.o(descriptor2);
                    if (iO == -1) {
                        z10 = false;
                    } else if (iO == 0) {
                        objY2 = cVarB.y(descriptor2, 0, h.a.INSTANCE, objY2);
                        i11 |= 1;
                    } else if (iO == 1) {
                        objK5 = cVarB.k(descriptor2, 1, d.a.INSTANCE, objK5);
                        i11 |= 2;
                    } else if (iO == 2) {
                        objK6 = cVarB.k(descriptor2, 2, j.a.INSTANCE, objK6);
                        i11 |= 4;
                    } else if (iO == 3) {
                        objK7 = cVarB.k(descriptor2, 3, h.a.INSTANCE, objK7);
                        i11 |= 8;
                    } else {
                        if (iO != 4) {
                            throw new o(iO);
                        }
                        objK8 = cVarB.k(descriptor2, 4, i.a.INSTANCE, objK8);
                        i11 |= 16;
                    }
                }
                objK = objK5;
                objK2 = objK6;
                objK3 = objK7;
                objK4 = objK8;
                Object obj = objY2;
                i10 = i11;
                objY = obj;
            }
            cVarB.c(descriptor2);
            return new f(i10, (com.vungle.ads.internal.model.h) objY, (com.vungle.ads.internal.model.d) objK, (j) objK2, (h) objK3, (i) objK4, (s1) null);
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

    /* JADX INFO: compiled from: CommonRequestBody.kt */
    @z9.h
    public static final class c {

        @NotNull
        public static final b Companion = new b(null);

        @NotNull
        private final String status;

        /* JADX INFO: compiled from: CommonRequestBody.kt */
        public static final class a implements d0<c> {

            @NotNull
            public static final a INSTANCE;
            public static final /* synthetic */ SerialDescriptor descriptor;

            static {
                a aVar = new a();
                INSTANCE = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.CommonRequestBody.CCPA", aVar, 1);
                pluginGeneratedSerialDescriptor.k("status", false);
                descriptor = pluginGeneratedSerialDescriptor;
            }

            private a() {
            }

            @Override // da.d0
            @NotNull
            public KSerializer<?>[] childSerializers() {
                return new KSerializer[]{w1.f24648a};
            }

            @Override // z9.b
            @NotNull
            public c deserialize(@NotNull Decoder decoder) {
                String strN;
                t.i(decoder, "decoder");
                SerialDescriptor descriptor2 = getDescriptor();
                ca.c cVarB = decoder.b(descriptor2);
                int i10 = 1;
                s1 s1Var = null;
                if (cVarB.p()) {
                    strN = cVarB.n(descriptor2, 0);
                } else {
                    int i11 = 0;
                    strN = null;
                    while (i10 != 0) {
                        int iO = cVarB.o(descriptor2);
                        if (iO == -1) {
                            i10 = 0;
                        } else {
                            if (iO != 0) {
                                throw new o(iO);
                            }
                            strN = cVarB.n(descriptor2, 0);
                            i11 |= 1;
                        }
                    }
                    i10 = i11;
                }
                cVarB.c(descriptor2);
                return new c(i10, strN, s1Var);
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

        /* JADX INFO: compiled from: CommonRequestBody.kt */
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

        public /* synthetic */ c(int i10, String str, s1 s1Var) {
            if (1 != (i10 & 1)) {
                i1.a(i10, 1, a.INSTANCE.getDescriptor());
            }
            this.status = str;
        }

        public static /* synthetic */ c copy$default(c cVar, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = cVar.status;
            }
            return cVar.copy(str);
        }

        public static final void write$Self(@NotNull c self, @NotNull ca.d output, @NotNull SerialDescriptor serialDesc) {
            t.i(self, "self");
            t.i(output, "output");
            t.i(serialDesc, "serialDesc");
            output.y(serialDesc, 0, self.status);
        }

        @NotNull
        public final String component1() {
            return this.status;
        }

        @NotNull
        public final c copy(@NotNull String status) {
            t.i(status, "status");
            return new c(status);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && t.d(this.status, ((c) obj).status);
        }

        @NotNull
        public final String getStatus() {
            return this.status;
        }

        public int hashCode() {
            return this.status.hashCode();
        }

        @NotNull
        public String toString() {
            return "CCPA(status=" + this.status + ')';
        }

        public c(@NotNull String status) {
            t.i(status, "status");
            this.status = status;
        }
    }

    /* JADX INFO: compiled from: CommonRequestBody.kt */
    @z9.h
    public static final class d {

        @NotNull
        public static final b Companion = new b(null);

        @Nullable
        private final Boolean isCoppa;

        /* JADX INFO: compiled from: CommonRequestBody.kt */
        public static final class a implements d0<d> {

            @NotNull
            public static final a INSTANCE;
            public static final /* synthetic */ SerialDescriptor descriptor;

            static {
                a aVar = new a();
                INSTANCE = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.CommonRequestBody.COPPA", aVar, 1);
                pluginGeneratedSerialDescriptor.k("is_coppa", false);
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
            public d deserialize(@NotNull Decoder decoder) {
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
                return new d(i10, (Boolean) objK, s1Var);
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

        /* JADX INFO: compiled from: CommonRequestBody.kt */
        public static final class b {
            private b() {
            }

            public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
                this();
            }

            @NotNull
            public final KSerializer<d> serializer() {
                return a.INSTANCE;
            }
        }

        public /* synthetic */ d(int i10, Boolean bool, s1 s1Var) {
            if (1 != (i10 & 1)) {
                i1.a(i10, 1, a.INSTANCE.getDescriptor());
            }
            this.isCoppa = bool;
        }

        public static /* synthetic */ d copy$default(d dVar, Boolean bool, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                bool = dVar.isCoppa;
            }
            return dVar.copy(bool);
        }

        public static final void write$Self(@NotNull d self, @NotNull ca.d output, @NotNull SerialDescriptor serialDesc) {
            t.i(self, "self");
            t.i(output, "output");
            t.i(serialDesc, "serialDesc");
            output.h(serialDesc, 0, da.h.f24574a, self.isCoppa);
        }

        @Nullable
        public final Boolean component1() {
            return this.isCoppa;
        }

        @NotNull
        public final d copy(@Nullable Boolean bool) {
            return new d(bool);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && t.d(this.isCoppa, ((d) obj).isCoppa);
        }

        public int hashCode() {
            Boolean bool = this.isCoppa;
            if (bool == null) {
                return 0;
            }
            return bool.hashCode();
        }

        @Nullable
        public final Boolean isCoppa() {
            return this.isCoppa;
        }

        @NotNull
        public String toString() {
            return "COPPA(isCoppa=" + this.isCoppa + ')';
        }

        public d(@Nullable Boolean bool) {
            this.isCoppa = bool;
        }

        public static /* synthetic */ void isCoppa$annotations() {
        }
    }

    /* JADX INFO: compiled from: CommonRequestBody.kt */
    public static final class e {
        private e() {
        }

        public /* synthetic */ e(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final KSerializer<f> serializer() {
            return a.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.vungle.ads.internal.model.f$f, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CommonRequestBody.kt */
    @z9.h
    public static final class C0520f {

        @NotNull
        public static final b Companion = new b(null);

        @NotNull
        private final String consentMessageVersion;

        @NotNull
        private final String consentSource;

        @NotNull
        private final String consentStatus;
        private final long consentTimestamp;

        /* JADX INFO: renamed from: com.vungle.ads.internal.model.f$f$a */
        /* JADX INFO: compiled from: CommonRequestBody.kt */
        public static final class a implements d0<C0520f> {

            @NotNull
            public static final a INSTANCE;
            public static final /* synthetic */ SerialDescriptor descriptor;

            static {
                a aVar = new a();
                INSTANCE = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.CommonRequestBody.GDPR", aVar, 4);
                pluginGeneratedSerialDescriptor.k("consent_status", false);
                pluginGeneratedSerialDescriptor.k("consent_source", false);
                pluginGeneratedSerialDescriptor.k("consent_timestamp", false);
                pluginGeneratedSerialDescriptor.k("consent_message_version", false);
                descriptor = pluginGeneratedSerialDescriptor;
            }

            private a() {
            }

            @Override // da.d0
            @NotNull
            public KSerializer<?>[] childSerializers() {
                w1 w1Var = w1.f24648a;
                return new KSerializer[]{w1Var, w1Var, u0.f24629a, w1Var};
            }

            @Override // z9.b
            @NotNull
            public C0520f deserialize(@NotNull Decoder decoder) {
                String str;
                String strN;
                int i10;
                String str2;
                long j10;
                t.i(decoder, "decoder");
                SerialDescriptor descriptor2 = getDescriptor();
                ca.c cVarB = decoder.b(descriptor2);
                if (cVarB.p()) {
                    String strN2 = cVarB.n(descriptor2, 0);
                    String strN3 = cVarB.n(descriptor2, 1);
                    long jF = cVarB.f(descriptor2, 2);
                    str = strN2;
                    strN = cVarB.n(descriptor2, 3);
                    i10 = 15;
                    str2 = strN3;
                    j10 = jF;
                } else {
                    String strN4 = null;
                    String strN5 = null;
                    boolean z10 = true;
                    long jF2 = 0;
                    String strN6 = null;
                    int i11 = 0;
                    while (z10) {
                        int iO = cVarB.o(descriptor2);
                        if (iO == -1) {
                            z10 = false;
                        } else if (iO == 0) {
                            strN4 = cVarB.n(descriptor2, 0);
                            i11 |= 1;
                        } else if (iO == 1) {
                            strN5 = cVarB.n(descriptor2, 1);
                            i11 |= 2;
                        } else if (iO == 2) {
                            jF2 = cVarB.f(descriptor2, 2);
                            i11 |= 4;
                        } else {
                            if (iO != 3) {
                                throw new o(iO);
                            }
                            strN6 = cVarB.n(descriptor2, 3);
                            i11 |= 8;
                        }
                    }
                    str = strN4;
                    strN = strN6;
                    i10 = i11;
                    str2 = strN5;
                    j10 = jF2;
                }
                cVarB.c(descriptor2);
                return new C0520f(i10, str, str2, j10, strN, null);
            }

            @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
            @NotNull
            public SerialDescriptor getDescriptor() {
                return descriptor;
            }

            @Override // z9.j
            public void serialize(@NotNull Encoder encoder, @NotNull C0520f value) {
                t.i(encoder, "encoder");
                t.i(value, "value");
                SerialDescriptor descriptor2 = getDescriptor();
                ca.d dVarB = encoder.b(descriptor2);
                C0520f.write$Self(value, dVarB, descriptor2);
                dVarB.c(descriptor2);
            }

            @Override // da.d0
            @NotNull
            public KSerializer<?>[] typeParametersSerializers() {
                return d0.a.a(this);
            }
        }

        /* JADX INFO: renamed from: com.vungle.ads.internal.model.f$f$b */
        /* JADX INFO: compiled from: CommonRequestBody.kt */
        public static final class b {
            private b() {
            }

            public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
                this();
            }

            @NotNull
            public final KSerializer<C0520f> serializer() {
                return a.INSTANCE;
            }
        }

        public /* synthetic */ C0520f(int i10, String str, String str2, long j10, String str3, s1 s1Var) {
            if (15 != (i10 & 15)) {
                i1.a(i10, 15, a.INSTANCE.getDescriptor());
            }
            this.consentStatus = str;
            this.consentSource = str2;
            this.consentTimestamp = j10;
            this.consentMessageVersion = str3;
        }

        public static /* synthetic */ C0520f copy$default(C0520f c0520f, String str, String str2, long j10, String str3, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = c0520f.consentStatus;
            }
            if ((i10 & 2) != 0) {
                str2 = c0520f.consentSource;
            }
            String str4 = str2;
            if ((i10 & 4) != 0) {
                j10 = c0520f.consentTimestamp;
            }
            long j11 = j10;
            if ((i10 & 8) != 0) {
                str3 = c0520f.consentMessageVersion;
            }
            return c0520f.copy(str, str4, j11, str3);
        }

        public static final void write$Self(@NotNull C0520f self, @NotNull ca.d output, @NotNull SerialDescriptor serialDesc) {
            t.i(self, "self");
            t.i(output, "output");
            t.i(serialDesc, "serialDesc");
            output.y(serialDesc, 0, self.consentStatus);
            output.y(serialDesc, 1, self.consentSource);
            output.F(serialDesc, 2, self.consentTimestamp);
            output.y(serialDesc, 3, self.consentMessageVersion);
        }

        @NotNull
        public final String component1() {
            return this.consentStatus;
        }

        @NotNull
        public final String component2() {
            return this.consentSource;
        }

        public final long component3() {
            return this.consentTimestamp;
        }

        @NotNull
        public final String component4() {
            return this.consentMessageVersion;
        }

        @NotNull
        public final C0520f copy(@NotNull String consentStatus, @NotNull String consentSource, long j10, @NotNull String consentMessageVersion) {
            t.i(consentStatus, "consentStatus");
            t.i(consentSource, "consentSource");
            t.i(consentMessageVersion, "consentMessageVersion");
            return new C0520f(consentStatus, consentSource, j10, consentMessageVersion);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0520f)) {
                return false;
            }
            C0520f c0520f = (C0520f) obj;
            return t.d(this.consentStatus, c0520f.consentStatus) && t.d(this.consentSource, c0520f.consentSource) && this.consentTimestamp == c0520f.consentTimestamp && t.d(this.consentMessageVersion, c0520f.consentMessageVersion);
        }

        @NotNull
        public final String getConsentMessageVersion() {
            return this.consentMessageVersion;
        }

        @NotNull
        public final String getConsentSource() {
            return this.consentSource;
        }

        @NotNull
        public final String getConsentStatus() {
            return this.consentStatus;
        }

        public final long getConsentTimestamp() {
            return this.consentTimestamp;
        }

        public int hashCode() {
            return (((((this.consentStatus.hashCode() * 31) + this.consentSource.hashCode()) * 31) + androidx.compose.animation.a.a(this.consentTimestamp)) * 31) + this.consentMessageVersion.hashCode();
        }

        @NotNull
        public String toString() {
            return "GDPR(consentStatus=" + this.consentStatus + ", consentSource=" + this.consentSource + ", consentTimestamp=" + this.consentTimestamp + ", consentMessageVersion=" + this.consentMessageVersion + ')';
        }

        public C0520f(@NotNull String consentStatus, @NotNull String consentSource, long j10, @NotNull String consentMessageVersion) {
            t.i(consentStatus, "consentStatus");
            t.i(consentSource, "consentSource");
            t.i(consentMessageVersion, "consentMessageVersion");
            this.consentStatus = consentStatus;
            this.consentSource = consentSource;
            this.consentTimestamp = j10;
            this.consentMessageVersion = consentMessageVersion;
        }

        public static /* synthetic */ void getConsentMessageVersion$annotations() {
        }

        public static /* synthetic */ void getConsentSource$annotations() {
        }

        public static /* synthetic */ void getConsentStatus$annotations() {
        }

        public static /* synthetic */ void getConsentTimestamp$annotations() {
        }
    }

    /* JADX INFO: compiled from: CommonRequestBody.kt */
    @z9.h
    public static final class g {

        @NotNull
        public static final b Companion = new b(null);

        @NotNull
        private final String tcf;

        /* JADX INFO: compiled from: CommonRequestBody.kt */
        public static final class a implements d0<g> {

            @NotNull
            public static final a INSTANCE;
            public static final /* synthetic */ SerialDescriptor descriptor;

            static {
                a aVar = new a();
                INSTANCE = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.CommonRequestBody.IAB", aVar, 1);
                pluginGeneratedSerialDescriptor.k("tcf", false);
                descriptor = pluginGeneratedSerialDescriptor;
            }

            private a() {
            }

            @Override // da.d0
            @NotNull
            public KSerializer<?>[] childSerializers() {
                return new KSerializer[]{w1.f24648a};
            }

            @Override // z9.b
            @NotNull
            public g deserialize(@NotNull Decoder decoder) {
                String strN;
                t.i(decoder, "decoder");
                SerialDescriptor descriptor2 = getDescriptor();
                ca.c cVarB = decoder.b(descriptor2);
                int i10 = 1;
                s1 s1Var = null;
                if (cVarB.p()) {
                    strN = cVarB.n(descriptor2, 0);
                } else {
                    int i11 = 0;
                    strN = null;
                    while (i10 != 0) {
                        int iO = cVarB.o(descriptor2);
                        if (iO == -1) {
                            i10 = 0;
                        } else {
                            if (iO != 0) {
                                throw new o(iO);
                            }
                            strN = cVarB.n(descriptor2, 0);
                            i11 |= 1;
                        }
                    }
                    i10 = i11;
                }
                cVarB.c(descriptor2);
                return new g(i10, strN, s1Var);
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

        /* JADX INFO: compiled from: CommonRequestBody.kt */
        public static final class b {
            private b() {
            }

            public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
                this();
            }

            @NotNull
            public final KSerializer<g> serializer() {
                return a.INSTANCE;
            }
        }

        public /* synthetic */ g(int i10, String str, s1 s1Var) {
            if (1 != (i10 & 1)) {
                i1.a(i10, 1, a.INSTANCE.getDescriptor());
            }
            this.tcf = str;
        }

        public static /* synthetic */ g copy$default(g gVar, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = gVar.tcf;
            }
            return gVar.copy(str);
        }

        public static final void write$Self(@NotNull g self, @NotNull ca.d output, @NotNull SerialDescriptor serialDesc) {
            t.i(self, "self");
            t.i(output, "output");
            t.i(serialDesc, "serialDesc");
            output.y(serialDesc, 0, self.tcf);
        }

        @NotNull
        public final String component1() {
            return this.tcf;
        }

        @NotNull
        public final g copy(@NotNull String tcf) {
            t.i(tcf, "tcf");
            return new g(tcf);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof g) && t.d(this.tcf, ((g) obj).tcf);
        }

        @NotNull
        public final String getTcf() {
            return this.tcf;
        }

        public int hashCode() {
            return this.tcf.hashCode();
        }

        @NotNull
        public String toString() {
            return "IAB(tcf=" + this.tcf + ')';
        }

        public g(@NotNull String tcf) {
            t.i(tcf, "tcf");
            this.tcf = tcf;
        }

        public static /* synthetic */ void getTcf$annotations() {
        }
    }

    /* JADX INFO: compiled from: CommonRequestBody.kt */
    @z9.h
    public static final class h {

        @NotNull
        public static final b Companion = new b(null);

        @Nullable
        private final String configExtension;

        @Nullable
        private final Long configLastValidatedTimestamp;

        @Nullable
        private String signals;

        /* JADX INFO: compiled from: CommonRequestBody.kt */
        public static final class a implements d0<h> {

            @NotNull
            public static final a INSTANCE;
            public static final /* synthetic */ SerialDescriptor descriptor;

            static {
                a aVar = new a();
                INSTANCE = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.CommonRequestBody.RequestExt", aVar, 3);
                pluginGeneratedSerialDescriptor.k("config_extension", true);
                pluginGeneratedSerialDescriptor.k("signals", true);
                pluginGeneratedSerialDescriptor.k("config_last_validated_ts", true);
                descriptor = pluginGeneratedSerialDescriptor;
            }

            private a() {
            }

            @Override // da.d0
            @NotNull
            public KSerializer<?>[] childSerializers() {
                w1 w1Var = w1.f24648a;
                return new KSerializer[]{aa.a.s(w1Var), aa.a.s(w1Var), aa.a.s(u0.f24629a)};
            }

            @Override // z9.b
            @NotNull
            public h deserialize(@NotNull Decoder decoder) {
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
                    objK2 = cVarB.k(descriptor2, 2, u0.f24629a, null);
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
                            objK6 = cVarB.k(descriptor2, 2, u0.f24629a, objK6);
                            i11 |= 4;
                        }
                    }
                    i10 = i11;
                    objK = objK5;
                    objK2 = objK6;
                }
                cVarB.c(descriptor2);
                return new h(i10, (String) objK3, (String) objK, (Long) objK2, (s1) null);
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

        /* JADX INFO: compiled from: CommonRequestBody.kt */
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

        public h() {
            this((String) null, (String) null, (Long) null, 7, (kotlin.jvm.internal.k) null);
        }

        public static /* synthetic */ h copy$default(h hVar, String str, String str2, Long l10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = hVar.configExtension;
            }
            if ((i10 & 2) != 0) {
                str2 = hVar.signals;
            }
            if ((i10 & 4) != 0) {
                l10 = hVar.configLastValidatedTimestamp;
            }
            return hVar.copy(str, str2, l10);
        }

        public static final void write$Self(@NotNull h self, @NotNull ca.d output, @NotNull SerialDescriptor serialDesc) {
            t.i(self, "self");
            t.i(output, "output");
            t.i(serialDesc, "serialDesc");
            if (output.z(serialDesc, 0) || self.configExtension != null) {
                output.h(serialDesc, 0, w1.f24648a, self.configExtension);
            }
            if (output.z(serialDesc, 1) || self.signals != null) {
                output.h(serialDesc, 1, w1.f24648a, self.signals);
            }
            if (output.z(serialDesc, 2) || self.configLastValidatedTimestamp != null) {
                output.h(serialDesc, 2, u0.f24629a, self.configLastValidatedTimestamp);
            }
        }

        @Nullable
        public final String component1() {
            return this.configExtension;
        }

        @Nullable
        public final String component2() {
            return this.signals;
        }

        @Nullable
        public final Long component3() {
            return this.configLastValidatedTimestamp;
        }

        @NotNull
        public final h copy(@Nullable String str, @Nullable String str2, @Nullable Long l10) {
            return new h(str, str2, l10);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return t.d(this.configExtension, hVar.configExtension) && t.d(this.signals, hVar.signals) && t.d(this.configLastValidatedTimestamp, hVar.configLastValidatedTimestamp);
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
        public final String getSignals() {
            return this.signals;
        }

        public int hashCode() {
            String str = this.configExtension;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.signals;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            Long l10 = this.configLastValidatedTimestamp;
            return iHashCode2 + (l10 != null ? l10.hashCode() : 0);
        }

        public final void setSignals(@Nullable String str) {
            this.signals = str;
        }

        @NotNull
        public String toString() {
            return "RequestExt(configExtension=" + this.configExtension + ", signals=" + this.signals + ", configLastValidatedTimestamp=" + this.configLastValidatedTimestamp + ')';
        }

        public /* synthetic */ h(int i10, String str, String str2, Long l10, s1 s1Var) {
            if ((i10 & 0) != 0) {
                i1.a(i10, 0, a.INSTANCE.getDescriptor());
            }
            if ((i10 & 1) == 0) {
                this.configExtension = null;
            } else {
                this.configExtension = str;
            }
            if ((i10 & 2) == 0) {
                this.signals = null;
            } else {
                this.signals = str2;
            }
            if ((i10 & 4) == 0) {
                this.configLastValidatedTimestamp = null;
            } else {
                this.configLastValidatedTimestamp = l10;
            }
        }

        public h(@Nullable String str, @Nullable String str2, @Nullable Long l10) {
            this.configExtension = str;
            this.signals = str2;
            this.configLastValidatedTimestamp = l10;
        }

        public /* synthetic */ h(String str, String str2, Long l10, int i10, kotlin.jvm.internal.k kVar) {
            this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : l10);
        }

        public static /* synthetic */ void getConfigExtension$annotations() {
        }

        public static /* synthetic */ void getConfigLastValidatedTimestamp$annotations() {
        }

        public static /* synthetic */ void getSignals$annotations() {
        }
    }

    /* JADX INFO: compiled from: CommonRequestBody.kt */
    @z9.h
    public static final class i {

        @NotNull
        public static final b Companion = new b(null);

        @Nullable
        private b adSize;

        @Nullable
        private final Long adStartTime;

        @Nullable
        private final String advAppId;

        @Nullable
        private final String placementReferenceId;

        @Nullable
        private final List<String> placements;

        @Nullable
        private final String user;

        /* JADX INFO: compiled from: CommonRequestBody.kt */
        public static final class a implements d0<i> {

            @NotNull
            public static final a INSTANCE;
            public static final /* synthetic */ SerialDescriptor descriptor;

            static {
                a aVar = new a();
                INSTANCE = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.CommonRequestBody.RequestParam", aVar, 6);
                pluginGeneratedSerialDescriptor.k(jo.f12765c, true);
                pluginGeneratedSerialDescriptor.k("ad_size", true);
                pluginGeneratedSerialDescriptor.k("ad_start_time", true);
                pluginGeneratedSerialDescriptor.k("app_id", true);
                pluginGeneratedSerialDescriptor.k("placement_reference_id", true);
                pluginGeneratedSerialDescriptor.k("user", true);
                descriptor = pluginGeneratedSerialDescriptor;
            }

            private a() {
            }

            @Override // da.d0
            @NotNull
            public KSerializer<?>[] childSerializers() {
                w1 w1Var = w1.f24648a;
                return new KSerializer[]{aa.a.s(new da.f(w1Var)), aa.a.s(b.a.INSTANCE), aa.a.s(u0.f24629a), aa.a.s(w1Var), aa.a.s(w1Var), aa.a.s(w1Var)};
            }

            @Override // z9.b
            @NotNull
            public i deserialize(@NotNull Decoder decoder) {
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
                    w1 w1Var = w1.f24648a;
                    objK6 = cVarB.k(descriptor2, 0, new da.f(w1Var), null);
                    objK = cVarB.k(descriptor2, 1, b.a.INSTANCE, null);
                    objK2 = cVarB.k(descriptor2, 2, u0.f24629a, null);
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
                                objK7 = cVarB.k(descriptor2, 0, new da.f(w1.f24648a), objK7);
                                i12 |= 1;
                                i11 = 5;
                                break;
                            case 1:
                                objK8 = cVarB.k(descriptor2, 1, b.a.INSTANCE, objK8);
                                i12 |= 2;
                                break;
                            case 2:
                                objK9 = cVarB.k(descriptor2, 2, u0.f24629a, objK9);
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
                return new i(i10, (List) objK6, (b) objK, (Long) objK2, (String) objK3, (String) objK4, (String) objK5, (s1) null);
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

        /* JADX INFO: compiled from: CommonRequestBody.kt */
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

        public i() {
            this((List) null, (b) null, (Long) null, (String) null, (String) null, (String) null, 63, (kotlin.jvm.internal.k) null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ i copy$default(i iVar, List list, b bVar, Long l10, String str, String str2, String str3, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                list = iVar.placements;
            }
            if ((i10 & 2) != 0) {
                bVar = iVar.adSize;
            }
            b bVar2 = bVar;
            if ((i10 & 4) != 0) {
                l10 = iVar.adStartTime;
            }
            Long l11 = l10;
            if ((i10 & 8) != 0) {
                str = iVar.advAppId;
            }
            String str4 = str;
            if ((i10 & 16) != 0) {
                str2 = iVar.placementReferenceId;
            }
            String str5 = str2;
            if ((i10 & 32) != 0) {
                str3 = iVar.user;
            }
            return iVar.copy(list, bVar2, l11, str4, str5, str3);
        }

        public static final void write$Self(@NotNull i self, @NotNull ca.d output, @NotNull SerialDescriptor serialDesc) {
            t.i(self, "self");
            t.i(output, "output");
            t.i(serialDesc, "serialDesc");
            if (output.z(serialDesc, 0) || self.placements != null) {
                output.h(serialDesc, 0, new da.f(w1.f24648a), self.placements);
            }
            if (output.z(serialDesc, 1) || self.adSize != null) {
                output.h(serialDesc, 1, b.a.INSTANCE, self.adSize);
            }
            if (output.z(serialDesc, 2) || self.adStartTime != null) {
                output.h(serialDesc, 2, u0.f24629a, self.adStartTime);
            }
            if (output.z(serialDesc, 3) || self.advAppId != null) {
                output.h(serialDesc, 3, w1.f24648a, self.advAppId);
            }
            if (output.z(serialDesc, 4) || self.placementReferenceId != null) {
                output.h(serialDesc, 4, w1.f24648a, self.placementReferenceId);
            }
            if (output.z(serialDesc, 5) || self.user != null) {
                output.h(serialDesc, 5, w1.f24648a, self.user);
            }
        }

        @Nullable
        public final List<String> component1() {
            return this.placements;
        }

        @Nullable
        public final b component2() {
            return this.adSize;
        }

        @Nullable
        public final Long component3() {
            return this.adStartTime;
        }

        @Nullable
        public final String component4() {
            return this.advAppId;
        }

        @Nullable
        public final String component5() {
            return this.placementReferenceId;
        }

        @Nullable
        public final String component6() {
            return this.user;
        }

        @NotNull
        public final i copy(@Nullable List<String> list, @Nullable b bVar, @Nullable Long l10, @Nullable String str, @Nullable String str2, @Nullable String str3) {
            return new i(list, bVar, l10, str, str2, str3);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return t.d(this.placements, iVar.placements) && t.d(this.adSize, iVar.adSize) && t.d(this.adStartTime, iVar.adStartTime) && t.d(this.advAppId, iVar.advAppId) && t.d(this.placementReferenceId, iVar.placementReferenceId) && t.d(this.user, iVar.user);
        }

        @Nullable
        public final b getAdSize() {
            return this.adSize;
        }

        @Nullable
        public final Long getAdStartTime() {
            return this.adStartTime;
        }

        @Nullable
        public final String getAdvAppId() {
            return this.advAppId;
        }

        @Nullable
        public final String getPlacementReferenceId() {
            return this.placementReferenceId;
        }

        @Nullable
        public final List<String> getPlacements() {
            return this.placements;
        }

        @Nullable
        public final String getUser() {
            return this.user;
        }

        public int hashCode() {
            List<String> list = this.placements;
            int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
            b bVar = this.adSize;
            int iHashCode2 = (iHashCode + (bVar == null ? 0 : bVar.hashCode())) * 31;
            Long l10 = this.adStartTime;
            int iHashCode3 = (iHashCode2 + (l10 == null ? 0 : l10.hashCode())) * 31;
            String str = this.advAppId;
            int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.placementReferenceId;
            int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.user;
            return iHashCode5 + (str3 != null ? str3.hashCode() : 0);
        }

        public final void setAdSize(@Nullable b bVar) {
            this.adSize = bVar;
        }

        @NotNull
        public String toString() {
            return "RequestParam(placements=" + this.placements + ", adSize=" + this.adSize + ", adStartTime=" + this.adStartTime + ", advAppId=" + this.advAppId + ", placementReferenceId=" + this.placementReferenceId + ", user=" + this.user + ')';
        }

        public /* synthetic */ i(int i10, List list, b bVar, Long l10, String str, String str2, String str3, s1 s1Var) {
            if ((i10 & 0) != 0) {
                i1.a(i10, 0, a.INSTANCE.getDescriptor());
            }
            if ((i10 & 1) == 0) {
                this.placements = null;
            } else {
                this.placements = list;
            }
            if ((i10 & 2) == 0) {
                this.adSize = null;
            } else {
                this.adSize = bVar;
            }
            if ((i10 & 4) == 0) {
                this.adStartTime = null;
            } else {
                this.adStartTime = l10;
            }
            if ((i10 & 8) == 0) {
                this.advAppId = null;
            } else {
                this.advAppId = str;
            }
            if ((i10 & 16) == 0) {
                this.placementReferenceId = null;
            } else {
                this.placementReferenceId = str2;
            }
            if ((i10 & 32) == 0) {
                this.user = null;
            } else {
                this.user = str3;
            }
        }

        public i(@Nullable List<String> list, @Nullable b bVar, @Nullable Long l10, @Nullable String str, @Nullable String str2, @Nullable String str3) {
            this.placements = list;
            this.adSize = bVar;
            this.adStartTime = l10;
            this.advAppId = str;
            this.placementReferenceId = str2;
            this.user = str3;
        }

        public /* synthetic */ i(List list, b bVar, Long l10, String str, String str2, String str3, int i10, kotlin.jvm.internal.k kVar) {
            this((i10 & 1) != 0 ? null : list, (i10 & 2) != 0 ? null : bVar, (i10 & 4) != 0 ? null : l10, (i10 & 8) != 0 ? null : str, (i10 & 16) != 0 ? null : str2, (i10 & 32) != 0 ? null : str3);
        }

        public static /* synthetic */ void getAdSize$annotations() {
        }

        public static /* synthetic */ void getAdStartTime$annotations() {
        }

        public static /* synthetic */ void getAdvAppId$annotations() {
        }

        public static /* synthetic */ void getPlacementReferenceId$annotations() {
        }
    }

    /* JADX INFO: compiled from: CommonRequestBody.kt */
    @z9.h
    public static final class j {

        @NotNull
        public static final b Companion = new b(null);

        @Nullable
        private c ccpa;

        @Nullable
        private d coppa;

        @Nullable
        private o7.c fpd;

        @Nullable
        private C0520f gdpr;

        @Nullable
        private g iab;

        /* JADX INFO: compiled from: CommonRequestBody.kt */
        public static final class a implements d0<j> {

            @NotNull
            public static final a INSTANCE;
            public static final /* synthetic */ SerialDescriptor descriptor;

            static {
                a aVar = new a();
                INSTANCE = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.CommonRequestBody.User", aVar, 5);
                pluginGeneratedSerialDescriptor.k("gdpr", true);
                pluginGeneratedSerialDescriptor.k("ccpa", true);
                pluginGeneratedSerialDescriptor.k("coppa", true);
                pluginGeneratedSerialDescriptor.k("fpd", true);
                pluginGeneratedSerialDescriptor.k(OTVendorListMode.IAB, true);
                descriptor = pluginGeneratedSerialDescriptor;
            }

            private a() {
            }

            @Override // da.d0
            @NotNull
            public KSerializer<?>[] childSerializers() {
                return new KSerializer[]{aa.a.s(C0520f.a.INSTANCE), aa.a.s(c.a.INSTANCE), aa.a.s(d.a.INSTANCE), aa.a.s(c.a.INSTANCE), aa.a.s(g.a.INSTANCE)};
            }

            @Override // z9.b
            @NotNull
            public j deserialize(@NotNull Decoder decoder) {
                Object objK;
                Object objK2;
                Object objK3;
                Object objK4;
                int i10;
                Object objK5;
                t.i(decoder, "decoder");
                SerialDescriptor descriptor2 = getDescriptor();
                ca.c cVarB = decoder.b(descriptor2);
                Object objK6 = null;
                if (cVarB.p()) {
                    objK5 = cVarB.k(descriptor2, 0, C0520f.a.INSTANCE, null);
                    objK = cVarB.k(descriptor2, 1, c.a.INSTANCE, null);
                    objK2 = cVarB.k(descriptor2, 2, d.a.INSTANCE, null);
                    objK3 = cVarB.k(descriptor2, 3, c.a.INSTANCE, null);
                    objK4 = cVarB.k(descriptor2, 4, g.a.INSTANCE, null);
                    i10 = 31;
                } else {
                    boolean z10 = true;
                    int i11 = 0;
                    Object objK7 = null;
                    Object objK8 = null;
                    Object objK9 = null;
                    Object objK10 = null;
                    while (z10) {
                        int iO = cVarB.o(descriptor2);
                        if (iO == -1) {
                            z10 = false;
                        } else if (iO == 0) {
                            objK6 = cVarB.k(descriptor2, 0, C0520f.a.INSTANCE, objK6);
                            i11 |= 1;
                        } else if (iO == 1) {
                            objK7 = cVarB.k(descriptor2, 1, c.a.INSTANCE, objK7);
                            i11 |= 2;
                        } else if (iO == 2) {
                            objK8 = cVarB.k(descriptor2, 2, d.a.INSTANCE, objK8);
                            i11 |= 4;
                        } else if (iO == 3) {
                            objK9 = cVarB.k(descriptor2, 3, c.a.INSTANCE, objK9);
                            i11 |= 8;
                        } else {
                            if (iO != 4) {
                                throw new o(iO);
                            }
                            objK10 = cVarB.k(descriptor2, 4, g.a.INSTANCE, objK10);
                            i11 |= 16;
                        }
                    }
                    objK = objK7;
                    objK2 = objK8;
                    objK3 = objK9;
                    objK4 = objK10;
                    Object obj = objK6;
                    i10 = i11;
                    objK5 = obj;
                }
                cVarB.c(descriptor2);
                return new j(i10, (C0520f) objK5, (c) objK, (d) objK2, (o7.c) objK3, (g) objK4, (s1) null);
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

        /* JADX INFO: compiled from: CommonRequestBody.kt */
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

        public j() {
            this((C0520f) null, (c) null, (d) null, (o7.c) null, (g) null, 31, (kotlin.jvm.internal.k) null);
        }

        public static /* synthetic */ j copy$default(j jVar, C0520f c0520f, c cVar, d dVar, o7.c cVar2, g gVar, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                c0520f = jVar.gdpr;
            }
            if ((i10 & 2) != 0) {
                cVar = jVar.ccpa;
            }
            c cVar3 = cVar;
            if ((i10 & 4) != 0) {
                dVar = jVar.coppa;
            }
            d dVar2 = dVar;
            if ((i10 & 8) != 0) {
                cVar2 = jVar.fpd;
            }
            o7.c cVar4 = cVar2;
            if ((i10 & 16) != 0) {
                gVar = jVar.iab;
            }
            return jVar.copy(c0520f, cVar3, dVar2, cVar4, gVar);
        }

        public static final void write$Self(@NotNull j self, @NotNull ca.d output, @NotNull SerialDescriptor serialDesc) {
            t.i(self, "self");
            t.i(output, "output");
            t.i(serialDesc, "serialDesc");
            if (output.z(serialDesc, 0) || self.gdpr != null) {
                output.h(serialDesc, 0, C0520f.a.INSTANCE, self.gdpr);
            }
            if (output.z(serialDesc, 1) || self.ccpa != null) {
                output.h(serialDesc, 1, c.a.INSTANCE, self.ccpa);
            }
            if (output.z(serialDesc, 2) || self.coppa != null) {
                output.h(serialDesc, 2, d.a.INSTANCE, self.coppa);
            }
            if (output.z(serialDesc, 3) || self.fpd != null) {
                output.h(serialDesc, 3, c.a.INSTANCE, self.fpd);
            }
            if (output.z(serialDesc, 4) || self.iab != null) {
                output.h(serialDesc, 4, g.a.INSTANCE, self.iab);
            }
        }

        @Nullable
        public final C0520f component1() {
            return this.gdpr;
        }

        @Nullable
        public final c component2() {
            return this.ccpa;
        }

        @Nullable
        public final d component3() {
            return this.coppa;
        }

        @Nullable
        public final o7.c component4() {
            return this.fpd;
        }

        @Nullable
        public final g component5() {
            return this.iab;
        }

        @NotNull
        public final j copy(@Nullable C0520f c0520f, @Nullable c cVar, @Nullable d dVar, @Nullable o7.c cVar2, @Nullable g gVar) {
            return new j(c0520f, cVar, dVar, cVar2, gVar);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            return t.d(this.gdpr, jVar.gdpr) && t.d(this.ccpa, jVar.ccpa) && t.d(this.coppa, jVar.coppa) && t.d(this.fpd, jVar.fpd) && t.d(this.iab, jVar.iab);
        }

        @Nullable
        public final c getCcpa() {
            return this.ccpa;
        }

        @Nullable
        public final d getCoppa() {
            return this.coppa;
        }

        @Nullable
        public final o7.c getFpd() {
            return this.fpd;
        }

        @Nullable
        public final C0520f getGdpr() {
            return this.gdpr;
        }

        @Nullable
        public final g getIab() {
            return this.iab;
        }

        public int hashCode() {
            C0520f c0520f = this.gdpr;
            int iHashCode = (c0520f == null ? 0 : c0520f.hashCode()) * 31;
            c cVar = this.ccpa;
            int iHashCode2 = (iHashCode + (cVar == null ? 0 : cVar.hashCode())) * 31;
            d dVar = this.coppa;
            int iHashCode3 = (iHashCode2 + (dVar == null ? 0 : dVar.hashCode())) * 31;
            o7.c cVar2 = this.fpd;
            int iHashCode4 = (iHashCode3 + (cVar2 == null ? 0 : cVar2.hashCode())) * 31;
            g gVar = this.iab;
            return iHashCode4 + (gVar != null ? gVar.hashCode() : 0);
        }

        public final void setCcpa(@Nullable c cVar) {
            this.ccpa = cVar;
        }

        public final void setCoppa(@Nullable d dVar) {
            this.coppa = dVar;
        }

        public final void setFpd(@Nullable o7.c cVar) {
            this.fpd = cVar;
        }

        public final void setGdpr(@Nullable C0520f c0520f) {
            this.gdpr = c0520f;
        }

        public final void setIab(@Nullable g gVar) {
            this.iab = gVar;
        }

        @NotNull
        public String toString() {
            return "User(gdpr=" + this.gdpr + ", ccpa=" + this.ccpa + ", coppa=" + this.coppa + ", fpd=" + this.fpd + ", iab=" + this.iab + ')';
        }

        public /* synthetic */ j(int i10, C0520f c0520f, c cVar, d dVar, o7.c cVar2, g gVar, s1 s1Var) {
            if ((i10 & 0) != 0) {
                i1.a(i10, 0, a.INSTANCE.getDescriptor());
            }
            if ((i10 & 1) == 0) {
                this.gdpr = null;
            } else {
                this.gdpr = c0520f;
            }
            if ((i10 & 2) == 0) {
                this.ccpa = null;
            } else {
                this.ccpa = cVar;
            }
            if ((i10 & 4) == 0) {
                this.coppa = null;
            } else {
                this.coppa = dVar;
            }
            if ((i10 & 8) == 0) {
                this.fpd = null;
            } else {
                this.fpd = cVar2;
            }
            if ((i10 & 16) == 0) {
                this.iab = null;
            } else {
                this.iab = gVar;
            }
        }

        public j(@Nullable C0520f c0520f, @Nullable c cVar, @Nullable d dVar, @Nullable o7.c cVar2, @Nullable g gVar) {
            this.gdpr = c0520f;
            this.ccpa = cVar;
            this.coppa = dVar;
            this.fpd = cVar2;
            this.iab = gVar;
        }

        public /* synthetic */ j(C0520f c0520f, c cVar, d dVar, o7.c cVar2, g gVar, int i10, kotlin.jvm.internal.k kVar) {
            this((i10 & 1) != 0 ? null : c0520f, (i10 & 2) != 0 ? null : cVar, (i10 & 4) != 0 ? null : dVar, (i10 & 8) != 0 ? null : cVar2, (i10 & 16) != 0 ? null : gVar);
        }
    }

    public /* synthetic */ f(int i10, com.vungle.ads.internal.model.h hVar, com.vungle.ads.internal.model.d dVar, j jVar, h hVar2, i iVar, s1 s1Var) {
        if (1 != (i10 & 1)) {
            i1.a(i10, 1, a.INSTANCE.getDescriptor());
        }
        this.device = hVar;
        if ((i10 & 2) == 0) {
            this.app = null;
        } else {
            this.app = dVar;
        }
        if ((i10 & 4) == 0) {
            this.user = null;
        } else {
            this.user = jVar;
        }
        if ((i10 & 8) == 0) {
            this.ext = null;
        } else {
            this.ext = hVar2;
        }
        if ((i10 & 16) == 0) {
            this.request = null;
        } else {
            this.request = iVar;
        }
    }

    public static /* synthetic */ f copy$default(f fVar, com.vungle.ads.internal.model.h hVar, com.vungle.ads.internal.model.d dVar, j jVar, h hVar2, i iVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            hVar = fVar.device;
        }
        if ((i10 & 2) != 0) {
            dVar = fVar.app;
        }
        com.vungle.ads.internal.model.d dVar2 = dVar;
        if ((i10 & 4) != 0) {
            jVar = fVar.user;
        }
        j jVar2 = jVar;
        if ((i10 & 8) != 0) {
            hVar2 = fVar.ext;
        }
        h hVar3 = hVar2;
        if ((i10 & 16) != 0) {
            iVar = fVar.request;
        }
        return fVar.copy(hVar, dVar2, jVar2, hVar3, iVar);
    }

    public static final void write$Self(@NotNull f self, @NotNull ca.d output, @NotNull SerialDescriptor serialDesc) {
        t.i(self, "self");
        t.i(output, "output");
        t.i(serialDesc, "serialDesc");
        output.j(serialDesc, 0, h.a.INSTANCE, self.device);
        if (output.z(serialDesc, 1) || self.app != null) {
            output.h(serialDesc, 1, d.a.INSTANCE, self.app);
        }
        if (output.z(serialDesc, 2) || self.user != null) {
            output.h(serialDesc, 2, j.a.INSTANCE, self.user);
        }
        if (output.z(serialDesc, 3) || self.ext != null) {
            output.h(serialDesc, 3, h.a.INSTANCE, self.ext);
        }
        if (output.z(serialDesc, 4) || self.request != null) {
            output.h(serialDesc, 4, i.a.INSTANCE, self.request);
        }
    }

    @NotNull
    public final com.vungle.ads.internal.model.h component1() {
        return this.device;
    }

    @Nullable
    public final com.vungle.ads.internal.model.d component2() {
        return this.app;
    }

    @Nullable
    public final j component3() {
        return this.user;
    }

    @Nullable
    public final h component4() {
        return this.ext;
    }

    @Nullable
    public final i component5() {
        return this.request;
    }

    @NotNull
    public final f copy(@NotNull com.vungle.ads.internal.model.h device, @Nullable com.vungle.ads.internal.model.d dVar, @Nullable j jVar, @Nullable h hVar, @Nullable i iVar) {
        t.i(device, "device");
        return new f(device, dVar, jVar, hVar, iVar);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return t.d(this.device, fVar.device) && t.d(this.app, fVar.app) && t.d(this.user, fVar.user) && t.d(this.ext, fVar.ext) && t.d(this.request, fVar.request);
    }

    @Nullable
    public final com.vungle.ads.internal.model.d getApp() {
        return this.app;
    }

    @NotNull
    public final com.vungle.ads.internal.model.h getDevice() {
        return this.device;
    }

    @Nullable
    public final h getExt() {
        return this.ext;
    }

    @Nullable
    public final i getRequest() {
        return this.request;
    }

    @Nullable
    public final j getUser() {
        return this.user;
    }

    public int hashCode() {
        int iHashCode = this.device.hashCode() * 31;
        com.vungle.ads.internal.model.d dVar = this.app;
        int iHashCode2 = (iHashCode + (dVar == null ? 0 : dVar.hashCode())) * 31;
        j jVar = this.user;
        int iHashCode3 = (iHashCode2 + (jVar == null ? 0 : jVar.hashCode())) * 31;
        h hVar = this.ext;
        int iHashCode4 = (iHashCode3 + (hVar == null ? 0 : hVar.hashCode())) * 31;
        i iVar = this.request;
        return iHashCode4 + (iVar != null ? iVar.hashCode() : 0);
    }

    public final void setExt(@Nullable h hVar) {
        this.ext = hVar;
    }

    public final void setRequest(@Nullable i iVar) {
        this.request = iVar;
    }

    @NotNull
    public String toString() {
        return "CommonRequestBody(device=" + this.device + ", app=" + this.app + ", user=" + this.user + ", ext=" + this.ext + ", request=" + this.request + ')';
    }

    /* JADX INFO: compiled from: CommonRequestBody.kt */
    @z9.h
    public static final class b {

        @NotNull
        public static final C0519b Companion = new C0519b(null);
        private final int height;
        private final int width;

        /* JADX INFO: compiled from: CommonRequestBody.kt */
        public static final class a implements d0<b> {

            @NotNull
            public static final a INSTANCE;
            public static final /* synthetic */ SerialDescriptor descriptor;

            static {
                a aVar = new a();
                INSTANCE = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.CommonRequestBody.AdSizeParam", aVar, 2);
                pluginGeneratedSerialDescriptor.k("w", false);
                pluginGeneratedSerialDescriptor.k(CmcdData.Factory.STREAMING_FORMAT_HLS, false);
                descriptor = pluginGeneratedSerialDescriptor;
            }

            private a() {
            }

            @Override // da.d0
            @NotNull
            public KSerializer<?>[] childSerializers() {
                l0 l0Var = l0.f24594a;
                return new KSerializer[]{l0Var, l0Var};
            }

            @Override // z9.b
            @NotNull
            public b deserialize(@NotNull Decoder decoder) {
                int i10;
                int i11;
                int i12;
                t.i(decoder, "decoder");
                SerialDescriptor descriptor2 = getDescriptor();
                ca.c cVarB = decoder.b(descriptor2);
                if (cVarB.p()) {
                    i10 = cVarB.i(descriptor2, 0);
                    i11 = cVarB.i(descriptor2, 1);
                    i12 = 3;
                } else {
                    boolean z10 = true;
                    i10 = 0;
                    int i13 = 0;
                    int i14 = 0;
                    while (z10) {
                        int iO = cVarB.o(descriptor2);
                        if (iO == -1) {
                            z10 = false;
                        } else if (iO == 0) {
                            i10 = cVarB.i(descriptor2, 0);
                            i14 |= 1;
                        } else {
                            if (iO != 1) {
                                throw new o(iO);
                            }
                            i13 = cVarB.i(descriptor2, 1);
                            i14 |= 2;
                        }
                    }
                    i11 = i13;
                    i12 = i14;
                }
                cVarB.c(descriptor2);
                return new b(i12, i10, i11, null);
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

        /* JADX INFO: renamed from: com.vungle.ads.internal.model.f$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CommonRequestBody.kt */
        public static final class C0519b {
            private C0519b() {
            }

            public /* synthetic */ C0519b(kotlin.jvm.internal.k kVar) {
                this();
            }

            @NotNull
            public final KSerializer<b> serializer() {
                return a.INSTANCE;
            }
        }

        public b(int i10, int i11) {
            this.width = i10;
            this.height = i11;
        }

        public static /* synthetic */ b copy$default(b bVar, int i10, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i10 = bVar.width;
            }
            if ((i12 & 2) != 0) {
                i11 = bVar.height;
            }
            return bVar.copy(i10, i11);
        }

        public static final void write$Self(@NotNull b self, @NotNull ca.d output, @NotNull SerialDescriptor serialDesc) {
            t.i(self, "self");
            t.i(output, "output");
            t.i(serialDesc, "serialDesc");
            output.w(serialDesc, 0, self.width);
            output.w(serialDesc, 1, self.height);
        }

        public final int component1() {
            return this.width;
        }

        public final int component2() {
            return this.height;
        }

        @NotNull
        public final b copy(int i10, int i11) {
            return new b(i10, i11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.width == bVar.width && this.height == bVar.height;
        }

        public final int getHeight() {
            return this.height;
        }

        public final int getWidth() {
            return this.width;
        }

        public int hashCode() {
            return (this.width * 31) + this.height;
        }

        @NotNull
        public String toString() {
            return "AdSizeParam(width=" + this.width + ", height=" + this.height + ')';
        }

        public /* synthetic */ b(int i10, int i11, int i12, s1 s1Var) {
            if (3 != (i10 & 3)) {
                i1.a(i10, 3, a.INSTANCE.getDescriptor());
            }
            this.width = i11;
            this.height = i12;
        }

        public static /* synthetic */ void getHeight$annotations() {
        }

        public static /* synthetic */ void getWidth$annotations() {
        }
    }

    public f(@NotNull com.vungle.ads.internal.model.h device, @Nullable com.vungle.ads.internal.model.d dVar, @Nullable j jVar, @Nullable h hVar, @Nullable i iVar) {
        t.i(device, "device");
        this.device = device;
        this.app = dVar;
        this.user = jVar;
        this.ext = hVar;
        this.request = iVar;
    }

    public /* synthetic */ f(com.vungle.ads.internal.model.h hVar, com.vungle.ads.internal.model.d dVar, j jVar, h hVar2, i iVar, int i10, kotlin.jvm.internal.k kVar) {
        this(hVar, (i10 & 2) != 0 ? null : dVar, (i10 & 4) != 0 ? null : jVar, (i10 & 8) != 0 ? null : hVar2, (i10 & 16) != 0 ? null : iVar);
    }
}
