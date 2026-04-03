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

/* JADX INFO: compiled from: RtbToken.kt */
/* JADX INFO: loaded from: classes4.dex */
@z9.h
public final class k {

    @NotNull
    public static final b Companion = new b(null);

    @Nullable
    private final String sdkUserAgent;

    /* JADX INFO: compiled from: RtbToken.kt */
    public static final class a implements d0<k> {

        @NotNull
        public static final a INSTANCE;
        public static final /* synthetic */ SerialDescriptor descriptor;

        static {
            a aVar = new a();
            INSTANCE = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.RtbRequest", aVar, 1);
            pluginGeneratedSerialDescriptor.k("sdk_user_agent", true);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        private a() {
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] childSerializers() {
            return new KSerializer[]{aa.a.s(w1.f24648a)};
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
                objK = cVarB.k(descriptor2, 0, w1.f24648a, null);
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
                        objK = cVarB.k(descriptor2, 0, w1.f24648a, objK);
                        i11 |= 1;
                    }
                }
                i10 = i11;
            }
            cVarB.c(descriptor2);
            return new k(i10, (String) objK, s1Var);
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

    /* JADX INFO: compiled from: RtbToken.kt */
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
        this((String) null, 1, (kotlin.jvm.internal.k) (0 == true ? 1 : 0));
    }

    public static /* synthetic */ k copy$default(k kVar, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = kVar.sdkUserAgent;
        }
        return kVar.copy(str);
    }

    public static final void write$Self(@NotNull k self, @NotNull ca.d output, @NotNull SerialDescriptor serialDesc) {
        t.i(self, "self");
        t.i(output, "output");
        t.i(serialDesc, "serialDesc");
        boolean z10 = true;
        if (!output.z(serialDesc, 0) && self.sdkUserAgent == null) {
            z10 = false;
        }
        if (z10) {
            output.h(serialDesc, 0, w1.f24648a, self.sdkUserAgent);
        }
    }

    @Nullable
    public final String component1() {
        return this.sdkUserAgent;
    }

    @NotNull
    public final k copy(@Nullable String str) {
        return new k(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof k) && t.d(this.sdkUserAgent, ((k) obj).sdkUserAgent);
    }

    @Nullable
    public final String getSdkUserAgent() {
        return this.sdkUserAgent;
    }

    public int hashCode() {
        String str = this.sdkUserAgent;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @NotNull
    public String toString() {
        return "RtbRequest(sdkUserAgent=" + this.sdkUserAgent + ')';
    }

    public /* synthetic */ k(int i10, String str, s1 s1Var) {
        if ((i10 & 0) != 0) {
            i1.a(i10, 0, a.INSTANCE.getDescriptor());
        }
        if ((i10 & 1) == 0) {
            this.sdkUserAgent = null;
        } else {
            this.sdkUserAgent = str;
        }
    }

    public k(@Nullable String str) {
        this.sdkUserAgent = str;
    }

    public /* synthetic */ k(String str, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? null : str);
    }

    public static /* synthetic */ void getSdkUserAgent$annotations() {
    }
}
