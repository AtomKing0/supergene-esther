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

/* JADX INFO: compiled from: ConfigPayload.kt */
/* JADX INFO: loaded from: classes4.dex */
@z9.h
public final class j {

    @NotNull
    public static final b Companion = new b(null);
    private final boolean headerBidding;

    @NotNull
    private final String referenceId;

    @Nullable
    private final String type;

    @Nullable
    private Long wakeupTime;

    /* JADX INFO: compiled from: ConfigPayload.kt */
    public static final class a implements d0<j> {

        @NotNull
        public static final a INSTANCE;
        public static final /* synthetic */ SerialDescriptor descriptor;

        static {
            a aVar = new a();
            INSTANCE = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.Placement", aVar, 3);
            pluginGeneratedSerialDescriptor.k("placement_ref_id", false);
            pluginGeneratedSerialDescriptor.k("is_hb", true);
            pluginGeneratedSerialDescriptor.k("type", true);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        private a() {
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] childSerializers() {
            w1 w1Var = w1.f24648a;
            return new KSerializer[]{w1Var, da.h.f24574a, aa.a.s(w1Var)};
        }

        @Override // z9.b
        @NotNull
        public j deserialize(@NotNull Decoder decoder) {
            boolean z10;
            int i10;
            String str;
            Object objK;
            t.i(decoder, "decoder");
            SerialDescriptor descriptor2 = getDescriptor();
            ca.c cVarB = decoder.b(descriptor2);
            if (cVarB.p()) {
                String strN = cVarB.n(descriptor2, 0);
                boolean zC = cVarB.C(descriptor2, 1);
                objK = cVarB.k(descriptor2, 2, w1.f24648a, null);
                str = strN;
                z10 = zC;
                i10 = 7;
            } else {
                boolean z11 = true;
                boolean zC2 = false;
                String strN2 = null;
                Object objK2 = null;
                int i11 = 0;
                while (z11) {
                    int iO = cVarB.o(descriptor2);
                    if (iO == -1) {
                        z11 = false;
                    } else if (iO == 0) {
                        strN2 = cVarB.n(descriptor2, 0);
                        i11 |= 1;
                    } else if (iO == 1) {
                        zC2 = cVarB.C(descriptor2, 1);
                        i11 |= 2;
                    } else {
                        if (iO != 2) {
                            throw new o(iO);
                        }
                        objK2 = cVarB.k(descriptor2, 2, w1.f24648a, objK2);
                        i11 |= 4;
                    }
                }
                z10 = zC2;
                i10 = i11;
                str = strN2;
                objK = objK2;
            }
            cVarB.c(descriptor2);
            return new j(i10, str, z10, (String) objK, (s1) null);
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

    public /* synthetic */ j(int i10, String str, boolean z10, String str2, s1 s1Var) {
        if (1 != (i10 & 1)) {
            i1.a(i10, 1, a.INSTANCE.getDescriptor());
        }
        this.referenceId = str;
        if ((i10 & 2) == 0) {
            this.headerBidding = false;
        } else {
            this.headerBidding = z10;
        }
        if ((i10 & 4) == 0) {
            this.type = null;
        } else {
            this.type = str2;
        }
        this.wakeupTime = null;
    }

    public static /* synthetic */ j copy$default(j jVar, String str, boolean z10, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = jVar.referenceId;
        }
        if ((i10 & 2) != 0) {
            z10 = jVar.headerBidding;
        }
        if ((i10 & 4) != 0) {
            str2 = jVar.type;
        }
        return jVar.copy(str, z10, str2);
    }

    public static final void write$Self(@NotNull j self, @NotNull ca.d output, @NotNull SerialDescriptor serialDesc) {
        t.i(self, "self");
        t.i(output, "output");
        t.i(serialDesc, "serialDesc");
        output.y(serialDesc, 0, self.referenceId);
        if (output.z(serialDesc, 1) || self.headerBidding) {
            output.x(serialDesc, 1, self.headerBidding);
        }
        if (output.z(serialDesc, 2) || self.type != null) {
            output.h(serialDesc, 2, w1.f24648a, self.type);
        }
    }

    @NotNull
    public final String component1() {
        return this.referenceId;
    }

    public final boolean component2() {
        return this.headerBidding;
    }

    @Nullable
    public final String component3() {
        return this.type;
    }

    @NotNull
    public final j copy(@NotNull String referenceId, boolean z10, @Nullable String str) {
        t.i(referenceId, "referenceId");
        return new j(referenceId, z10, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return t.d(this.referenceId, jVar.referenceId) && this.headerBidding == jVar.headerBidding && t.d(this.type, jVar.type);
    }

    public final boolean getHeaderBidding() {
        return this.headerBidding;
    }

    @NotNull
    public final String getReferenceId() {
        return this.referenceId;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final Long getWakeupTime() {
        return this.wakeupTime;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int iHashCode = this.referenceId.hashCode() * 31;
        boolean z10 = this.headerBidding;
        ?? r12 = z10;
        if (z10) {
            r12 = 1;
        }
        int i10 = (iHashCode + r12) * 31;
        String str = this.type;
        return i10 + (str == null ? 0 : str.hashCode());
    }

    public final boolean isAppOpen() {
        return t.d(this.type, com.vungle.ads.internal.l.PLACEMENT_TYPE_APP_OPEN);
    }

    public final boolean isBanner() {
        return t.d(this.type, "banner");
    }

    public final boolean isInline() {
        return t.d(this.type, "in_line");
    }

    public final boolean isInterstitial() {
        return t.d(this.type, "interstitial");
    }

    public final boolean isMREC() {
        return t.d(this.type, "mrec");
    }

    public final boolean isNative() {
        return t.d(this.type, "native");
    }

    public final boolean isRewardedVideo() {
        return t.d(this.type, "rewarded");
    }

    public final void setWakeupTime(@Nullable Long l10) {
        this.wakeupTime = l10;
    }

    public final void snooze(long j10) {
        this.wakeupTime = Long.valueOf(System.currentTimeMillis() + (j10 * ((long) 1000)));
    }

    @NotNull
    public String toString() {
        return "Placement(referenceId=" + this.referenceId + ", headerBidding=" + this.headerBidding + ", type=" + this.type + ')';
    }

    public j(@NotNull String referenceId, boolean z10, @Nullable String str) {
        t.i(referenceId, "referenceId");
        this.referenceId = referenceId;
        this.headerBidding = z10;
        this.type = str;
    }

    public /* synthetic */ j(String str, boolean z10, String str2, int i10, kotlin.jvm.internal.k kVar) {
        this(str, (i10 & 2) != 0 ? false : z10, (i10 & 4) != 0 ? null : str2);
    }

    public static /* synthetic */ void getHeaderBidding$annotations() {
    }

    public static /* synthetic */ void getReferenceId$annotations() {
    }

    public static /* synthetic */ void getType$annotations() {
    }

    public static /* synthetic */ void getWakeupTime$annotations() {
    }
}
