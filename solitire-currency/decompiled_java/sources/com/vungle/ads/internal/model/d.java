package com.vungle.ads.internal.model;

import da.d0;
import da.i1;
import da.s1;
import da.w1;
import kotlin.jvm.internal.t;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z9.o;

/* JADX INFO: compiled from: AppNode.kt */
/* JADX INFO: loaded from: classes4.dex */
@z9.h
public final class d {

    @NotNull
    public static final b Companion = new b(null);

    @NotNull
    private final String appId;

    @NotNull
    private final String bundle;

    @NotNull
    private final String ver;

    /* JADX INFO: compiled from: AppNode.kt */
    public static final class a implements d0<d> {

        @NotNull
        public static final a INSTANCE;
        public static final /* synthetic */ SerialDescriptor descriptor;

        static {
            a aVar = new a();
            INSTANCE = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.AppNode", aVar, 3);
            pluginGeneratedSerialDescriptor.k("bundle", false);
            pluginGeneratedSerialDescriptor.k("ver", false);
            pluginGeneratedSerialDescriptor.k("id", false);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        private a() {
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] childSerializers() {
            w1 w1Var = w1.f24648a;
            return new KSerializer[]{w1Var, w1Var, w1Var};
        }

        @Override // z9.b
        @NotNull
        public d deserialize(@NotNull Decoder decoder) {
            String str;
            String strN;
            String str2;
            int i10;
            t.i(decoder, "decoder");
            SerialDescriptor descriptor2 = getDescriptor();
            ca.c cVarB = decoder.b(descriptor2);
            if (cVarB.p()) {
                String strN2 = cVarB.n(descriptor2, 0);
                String strN3 = cVarB.n(descriptor2, 1);
                str = strN2;
                strN = cVarB.n(descriptor2, 2);
                str2 = strN3;
                i10 = 7;
            } else {
                String strN4 = null;
                String strN5 = null;
                String strN6 = null;
                boolean z10 = true;
                int i11 = 0;
                while (z10) {
                    int iO = cVarB.o(descriptor2);
                    if (iO == -1) {
                        z10 = false;
                    } else if (iO == 0) {
                        strN4 = cVarB.n(descriptor2, 0);
                        i11 |= 1;
                    } else if (iO == 1) {
                        strN6 = cVarB.n(descriptor2, 1);
                        i11 |= 2;
                    } else {
                        if (iO != 2) {
                            throw new o(iO);
                        }
                        strN5 = cVarB.n(descriptor2, 2);
                        i11 |= 4;
                    }
                }
                str = strN4;
                strN = strN5;
                str2 = strN6;
                i10 = i11;
            }
            cVarB.c(descriptor2);
            return new d(i10, str, str2, strN, null);
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

    /* JADX INFO: compiled from: AppNode.kt */
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

    public /* synthetic */ d(int i10, String str, String str2, String str3, s1 s1Var) {
        if (7 != (i10 & 7)) {
            i1.a(i10, 7, a.INSTANCE.getDescriptor());
        }
        this.bundle = str;
        this.ver = str2;
        this.appId = str3;
    }

    public static /* synthetic */ d copy$default(d dVar, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = dVar.bundle;
        }
        if ((i10 & 2) != 0) {
            str2 = dVar.ver;
        }
        if ((i10 & 4) != 0) {
            str3 = dVar.appId;
        }
        return dVar.copy(str, str2, str3);
    }

    public static final void write$Self(@NotNull d self, @NotNull ca.d output, @NotNull SerialDescriptor serialDesc) {
        t.i(self, "self");
        t.i(output, "output");
        t.i(serialDesc, "serialDesc");
        output.y(serialDesc, 0, self.bundle);
        output.y(serialDesc, 1, self.ver);
        output.y(serialDesc, 2, self.appId);
    }

    @NotNull
    public final String component1() {
        return this.bundle;
    }

    @NotNull
    public final String component2() {
        return this.ver;
    }

    @NotNull
    public final String component3() {
        return this.appId;
    }

    @NotNull
    public final d copy(@NotNull String bundle, @NotNull String ver, @NotNull String appId) {
        t.i(bundle, "bundle");
        t.i(ver, "ver");
        t.i(appId, "appId");
        return new d(bundle, ver, appId);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return t.d(this.bundle, dVar.bundle) && t.d(this.ver, dVar.ver) && t.d(this.appId, dVar.appId);
    }

    @NotNull
    public final String getAppId() {
        return this.appId;
    }

    @NotNull
    public final String getBundle() {
        return this.bundle;
    }

    @NotNull
    public final String getVer() {
        return this.ver;
    }

    public int hashCode() {
        return (((this.bundle.hashCode() * 31) + this.ver.hashCode()) * 31) + this.appId.hashCode();
    }

    @NotNull
    public String toString() {
        return "AppNode(bundle=" + this.bundle + ", ver=" + this.ver + ", appId=" + this.appId + ')';
    }

    public d(@NotNull String bundle, @NotNull String ver, @NotNull String appId) {
        t.i(bundle, "bundle");
        t.i(ver, "ver");
        t.i(appId, "appId");
        this.bundle = bundle;
        this.ver = ver;
        this.appId = appId;
    }

    public static /* synthetic */ void getAppId$annotations() {
    }
}
