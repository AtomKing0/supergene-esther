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

/* JADX INFO: compiled from: UnclosedAd.kt */
/* JADX INFO: loaded from: classes4.dex */
@z9.h
public final class m {

    @NotNull
    public static final b Companion = new b(null);

    @NotNull
    private final String eventId;

    @NotNull
    private String sessionId;

    /* JADX INFO: compiled from: UnclosedAd.kt */
    public static final class a implements d0<m> {

        @NotNull
        public static final a INSTANCE;
        public static final /* synthetic */ SerialDescriptor descriptor;

        static {
            a aVar = new a();
            INSTANCE = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.UnclosedAd", aVar, 2);
            pluginGeneratedSerialDescriptor.k("107", false);
            pluginGeneratedSerialDescriptor.k("101", true);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        private a() {
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] childSerializers() {
            w1 w1Var = w1.f24648a;
            return new KSerializer[]{w1Var, w1Var};
        }

        @Override // z9.b
        @NotNull
        public m deserialize(@NotNull Decoder decoder) {
            String strN;
            String strN2;
            int i10;
            t.i(decoder, "decoder");
            SerialDescriptor descriptor2 = getDescriptor();
            ca.c cVarB = decoder.b(descriptor2);
            s1 s1Var = null;
            if (cVarB.p()) {
                strN = cVarB.n(descriptor2, 0);
                strN2 = cVarB.n(descriptor2, 1);
                i10 = 3;
            } else {
                boolean z10 = true;
                int i11 = 0;
                strN = null;
                String strN3 = null;
                while (z10) {
                    int iO = cVarB.o(descriptor2);
                    if (iO == -1) {
                        z10 = false;
                    } else if (iO == 0) {
                        strN = cVarB.n(descriptor2, 0);
                        i11 |= 1;
                    } else {
                        if (iO != 1) {
                            throw new o(iO);
                        }
                        strN3 = cVarB.n(descriptor2, 1);
                        i11 |= 2;
                    }
                }
                strN2 = strN3;
                i10 = i11;
            }
            cVarB.c(descriptor2);
            return new m(i10, strN, strN2, s1Var);
        }

        @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
        @NotNull
        public SerialDescriptor getDescriptor() {
            return descriptor;
        }

        @Override // z9.j
        public void serialize(@NotNull Encoder encoder, @NotNull m value) {
            t.i(encoder, "encoder");
            t.i(value, "value");
            SerialDescriptor descriptor2 = getDescriptor();
            ca.d dVarB = encoder.b(descriptor2);
            m.write$Self(value, dVarB, descriptor2);
            dVarB.c(descriptor2);
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }
    }

    /* JADX INFO: compiled from: UnclosedAd.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final KSerializer<m> serializer() {
            return a.INSTANCE;
        }
    }

    public /* synthetic */ m(int i10, String str, String str2, s1 s1Var) {
        if (1 != (i10 & 1)) {
            i1.a(i10, 1, a.INSTANCE.getDescriptor());
        }
        this.eventId = str;
        if ((i10 & 2) == 0) {
            this.sessionId = "";
        } else {
            this.sessionId = str2;
        }
    }

    public static /* synthetic */ m copy$default(m mVar, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = mVar.eventId;
        }
        if ((i10 & 2) != 0) {
            str2 = mVar.sessionId;
        }
        return mVar.copy(str, str2);
    }

    public static final void write$Self(@NotNull m self, @NotNull ca.d output, @NotNull SerialDescriptor serialDesc) {
        t.i(self, "self");
        t.i(output, "output");
        t.i(serialDesc, "serialDesc");
        output.y(serialDesc, 0, self.eventId);
        if (output.z(serialDesc, 1) || !t.d(self.sessionId, "")) {
            output.y(serialDesc, 1, self.sessionId);
        }
    }

    @NotNull
    public final String component1() {
        return this.eventId;
    }

    @NotNull
    public final String component2() {
        return this.sessionId;
    }

    @NotNull
    public final m copy(@NotNull String eventId, @NotNull String sessionId) {
        t.i(eventId, "eventId");
        t.i(sessionId, "sessionId");
        return new m(eventId, sessionId);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null || !t.d(m.class, obj.getClass())) {
            return false;
        }
        m mVar = (m) obj;
        return t.d(this.eventId, mVar.eventId) && t.d(this.sessionId, mVar.sessionId);
    }

    @NotNull
    public final String getEventId() {
        return this.eventId;
    }

    @NotNull
    public final String getSessionId() {
        return this.sessionId;
    }

    public int hashCode() {
        return (this.eventId.hashCode() * 31) + this.sessionId.hashCode();
    }

    public final void setSessionId(@NotNull String str) {
        t.i(str, "<set-?>");
        this.sessionId = str;
    }

    @NotNull
    public String toString() {
        return "UnclosedAd(eventId=" + this.eventId + ", sessionId=" + this.sessionId + ')';
    }

    public m(@NotNull String eventId, @NotNull String sessionId) {
        t.i(eventId, "eventId");
        t.i(sessionId, "sessionId");
        this.eventId = eventId;
        this.sessionId = sessionId;
    }

    public /* synthetic */ m(String str, String str2, int i10, kotlin.jvm.internal.k kVar) {
        this(str, (i10 & 2) != 0 ? "" : str2);
    }

    public static /* synthetic */ void getEventId$annotations() {
    }

    public static /* synthetic */ void getSessionId$annotations() {
    }
}
