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

/* JADX INFO: compiled from: OmSdkData.kt */
/* JADX INFO: loaded from: classes4.dex */
@z9.h
public final class i {

    @NotNull
    public static final b Companion = new b(null);

    @Nullable
    private final String params;

    @Nullable
    private final String vendorKey;

    @Nullable
    private final String vendorURL;

    /* JADX INFO: compiled from: OmSdkData.kt */
    public static final class a implements d0<i> {

        @NotNull
        public static final a INSTANCE;
        public static final /* synthetic */ SerialDescriptor descriptor;

        static {
            a aVar = new a();
            INSTANCE = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.OmSdkData", aVar, 3);
            pluginGeneratedSerialDescriptor.k("params", true);
            pluginGeneratedSerialDescriptor.k("vendorKey", true);
            pluginGeneratedSerialDescriptor.k("vendorURL", true);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        private a() {
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] childSerializers() {
            w1 w1Var = w1.f24648a;
            return new KSerializer[]{aa.a.s(w1Var), aa.a.s(w1Var), aa.a.s(w1Var)};
        }

        @Override // z9.b
        @NotNull
        public i deserialize(@NotNull Decoder decoder) {
            Object objK;
            int i10;
            Object objK2;
            Object objK3;
            t.i(decoder, "decoder");
            SerialDescriptor descriptor2 = getDescriptor();
            ca.c cVarB = decoder.b(descriptor2);
            Object objK4 = null;
            if (cVarB.p()) {
                w1 w1Var = w1.f24648a;
                objK2 = cVarB.k(descriptor2, 0, w1Var, null);
                Object objK5 = cVarB.k(descriptor2, 1, w1Var, null);
                objK3 = cVarB.k(descriptor2, 2, w1Var, null);
                objK = objK5;
                i10 = 7;
            } else {
                boolean z10 = true;
                int i11 = 0;
                objK = null;
                Object objK6 = null;
                while (z10) {
                    int iO = cVarB.o(descriptor2);
                    if (iO == -1) {
                        z10 = false;
                    } else if (iO == 0) {
                        objK4 = cVarB.k(descriptor2, 0, w1.f24648a, objK4);
                        i11 |= 1;
                    } else if (iO == 1) {
                        objK = cVarB.k(descriptor2, 1, w1.f24648a, objK);
                        i11 |= 2;
                    } else {
                        if (iO != 2) {
                            throw new o(iO);
                        }
                        objK6 = cVarB.k(descriptor2, 2, w1.f24648a, objK6);
                        i11 |= 4;
                    }
                }
                i10 = i11;
                objK2 = objK4;
                objK3 = objK6;
            }
            cVarB.c(descriptor2);
            return new i(i10, (String) objK2, (String) objK, (String) objK3, (s1) null);
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

    /* JADX INFO: compiled from: OmSdkData.kt */
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
        this((String) null, (String) null, (String) null, 7, (kotlin.jvm.internal.k) null);
    }

    public static /* synthetic */ i copy$default(i iVar, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = iVar.params;
        }
        if ((i10 & 2) != 0) {
            str2 = iVar.vendorKey;
        }
        if ((i10 & 4) != 0) {
            str3 = iVar.vendorURL;
        }
        return iVar.copy(str, str2, str3);
    }

    public static final void write$Self(@NotNull i self, @NotNull ca.d output, @NotNull SerialDescriptor serialDesc) {
        t.i(self, "self");
        t.i(output, "output");
        t.i(serialDesc, "serialDesc");
        if (output.z(serialDesc, 0) || self.params != null) {
            output.h(serialDesc, 0, w1.f24648a, self.params);
        }
        if (output.z(serialDesc, 1) || self.vendorKey != null) {
            output.h(serialDesc, 1, w1.f24648a, self.vendorKey);
        }
        if (output.z(serialDesc, 2) || self.vendorURL != null) {
            output.h(serialDesc, 2, w1.f24648a, self.vendorURL);
        }
    }

    @Nullable
    public final String component1() {
        return this.params;
    }

    @Nullable
    public final String component2() {
        return this.vendorKey;
    }

    @Nullable
    public final String component3() {
        return this.vendorURL;
    }

    @NotNull
    public final i copy(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        return new i(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return t.d(this.params, iVar.params) && t.d(this.vendorKey, iVar.vendorKey) && t.d(this.vendorURL, iVar.vendorURL);
    }

    @Nullable
    public final String getParams() {
        return this.params;
    }

    @Nullable
    public final String getVendorKey() {
        return this.vendorKey;
    }

    @Nullable
    public final String getVendorURL() {
        return this.vendorURL;
    }

    public int hashCode() {
        String str = this.params;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.vendorKey;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.vendorURL;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "OmSdkData(params=" + this.params + ", vendorKey=" + this.vendorKey + ", vendorURL=" + this.vendorURL + ')';
    }

    public /* synthetic */ i(int i10, String str, String str2, String str3, s1 s1Var) {
        if ((i10 & 0) != 0) {
            i1.a(i10, 0, a.INSTANCE.getDescriptor());
        }
        if ((i10 & 1) == 0) {
            this.params = null;
        } else {
            this.params = str;
        }
        if ((i10 & 2) == 0) {
            this.vendorKey = null;
        } else {
            this.vendorKey = str2;
        }
        if ((i10 & 4) == 0) {
            this.vendorURL = null;
        } else {
            this.vendorURL = str3;
        }
    }

    public i(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.params = str;
        this.vendorKey = str2;
        this.vendorURL = str3;
    }

    public /* synthetic */ i(String str, String str2, String str3, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3);
    }
}
