package com.vungle.ads.internal.signals;

import ca.d;
import com.vungle.ads.internal.model.m;
import com.vungle.ads.internal.signals.c;
import da.d0;
import da.f;
import da.i1;
import da.l0;
import da.s1;
import da.u0;
import da.w1;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z9.h;
import z9.o;

/* JADX INFO: compiled from: SessionData.kt */
/* JADX INFO: loaded from: classes4.dex */
@h
public final class a {

    @NotNull
    public static final b Companion = new b(null);
    private final int sessionCount;
    private long sessionCreationTime;
    private int sessionDepthCounter;
    private long sessionDuration;

    @NotNull
    private final String sessionId;

    @NotNull
    private List<c> signaledAd;

    @NotNull
    private List<m> unclosedAd;

    /* JADX INFO: renamed from: com.vungle.ads.internal.signals.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SessionData.kt */
    public static final class C0529a implements d0<a> {

        @NotNull
        public static final C0529a INSTANCE;
        public static final /* synthetic */ SerialDescriptor descriptor;

        static {
            C0529a c0529a = new C0529a();
            INSTANCE = c0529a;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.signals.SessionData", c0529a, 7);
            pluginGeneratedSerialDescriptor.k("103", false);
            pluginGeneratedSerialDescriptor.k("101", true);
            pluginGeneratedSerialDescriptor.k("100", true);
            pluginGeneratedSerialDescriptor.k("106", true);
            pluginGeneratedSerialDescriptor.k("102", true);
            pluginGeneratedSerialDescriptor.k("104", true);
            pluginGeneratedSerialDescriptor.k("105", true);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        private C0529a() {
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] childSerializers() {
            l0 l0Var = l0.f24594a;
            u0 u0Var = u0.f24629a;
            return new KSerializer[]{l0Var, w1.f24648a, u0Var, new f(c.a.INSTANCE), u0Var, l0Var, new f(m.a.INSTANCE)};
        }

        @Override // z9.b
        @NotNull
        public a deserialize(@NotNull Decoder decoder) {
            Object objY;
            int i10;
            int i11;
            Object objY2;
            int i12;
            String str;
            long j10;
            long j11;
            t.i(decoder, "decoder");
            SerialDescriptor descriptor2 = getDescriptor();
            ca.c cVarB = decoder.b(descriptor2);
            int i13 = 2;
            if (cVarB.p()) {
                int i14 = cVarB.i(descriptor2, 0);
                String strN = cVarB.n(descriptor2, 1);
                long jF = cVarB.f(descriptor2, 2);
                objY2 = cVarB.y(descriptor2, 3, new f(c.a.INSTANCE), null);
                long jF2 = cVarB.f(descriptor2, 4);
                int i15 = cVarB.i(descriptor2, 5);
                objY = cVarB.y(descriptor2, 6, new f(m.a.INSTANCE), null);
                i10 = i15;
                j11 = jF2;
                i11 = 127;
                j10 = jF;
                i12 = i14;
                str = strN;
            } else {
                long jF3 = 0;
                boolean z10 = true;
                int i16 = 0;
                int i17 = 0;
                String strN2 = null;
                Object objY3 = null;
                long jF4 = 0;
                Object objY4 = null;
                int i18 = 0;
                while (z10) {
                    int iO = cVarB.o(descriptor2);
                    switch (iO) {
                        case -1:
                            z10 = false;
                            break;
                        case 0:
                            i17 |= 1;
                            i16 = cVarB.i(descriptor2, 0);
                            break;
                        case 1:
                            strN2 = cVarB.n(descriptor2, 1);
                            i17 |= 2;
                            break;
                        case 2:
                            jF4 = cVarB.f(descriptor2, i13);
                            i17 |= 4;
                            break;
                        case 3:
                            objY3 = cVarB.y(descriptor2, 3, new f(c.a.INSTANCE), objY3);
                            i17 |= 8;
                            i13 = 2;
                            break;
                        case 4:
                            jF3 = cVarB.f(descriptor2, 4);
                            i17 |= 16;
                            i13 = 2;
                            break;
                        case 5:
                            i18 = cVarB.i(descriptor2, 5);
                            i17 |= 32;
                            i13 = 2;
                            break;
                        case 6:
                            objY4 = cVarB.y(descriptor2, 6, new f(m.a.INSTANCE), objY4);
                            i17 |= 64;
                            i13 = 2;
                            break;
                        default:
                            throw new o(iO);
                    }
                }
                objY = objY4;
                i10 = i18;
                i11 = i17;
                objY2 = objY3;
                long j12 = jF3;
                i12 = i16;
                str = strN2;
                j10 = jF4;
                j11 = j12;
            }
            cVarB.c(descriptor2);
            return new a(i11, i12, str, j10, (List) objY2, j11, i10, (List) objY, null);
        }

        @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
        @NotNull
        public SerialDescriptor getDescriptor() {
            return descriptor;
        }

        @Override // z9.j
        public void serialize(@NotNull Encoder encoder, @NotNull a value) {
            t.i(encoder, "encoder");
            t.i(value, "value");
            SerialDescriptor descriptor2 = getDescriptor();
            d dVarB = encoder.b(descriptor2);
            a.write$Self(value, dVarB, descriptor2);
            dVarB.c(descriptor2);
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }
    }

    /* JADX INFO: compiled from: SessionData.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(k kVar) {
            this();
        }

        @NotNull
        public final KSerializer<a> serializer() {
            return C0529a.INSTANCE;
        }
    }

    public a(int i10) {
        this.sessionCount = i10;
        String string = UUID.randomUUID().toString();
        t.h(string, "randomUUID().toString()");
        this.sessionId = string;
        this.sessionCreationTime = System.currentTimeMillis() / 1000;
        this.signaledAd = new ArrayList();
        this.unclosedAd = new ArrayList();
    }

    public static /* synthetic */ a copy$default(a aVar, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = aVar.sessionCount;
        }
        return aVar.copy(i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void write$Self(@org.jetbrains.annotations.NotNull com.vungle.ads.internal.signals.a r9, @org.jetbrains.annotations.NotNull ca.d r10, @org.jetbrains.annotations.NotNull kotlinx.serialization.descriptors.SerialDescriptor r11) {
        /*
            Method dump skipped, instruction units count: 215
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.signals.a.write$Self(com.vungle.ads.internal.signals.a, ca.d, kotlinx.serialization.descriptors.SerialDescriptor):void");
    }

    public final int component1() {
        return this.sessionCount;
    }

    @NotNull
    public final a copy(int i10) {
        return new a(i10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.sessionCount == ((a) obj).sessionCount;
    }

    public final int getSessionCount() {
        return this.sessionCount;
    }

    public final long getSessionCreationTime() {
        return this.sessionCreationTime;
    }

    public final int getSessionDepthCounter() {
        return this.sessionDepthCounter;
    }

    public final long getSessionDuration() {
        return this.sessionDuration;
    }

    @NotNull
    public final String getSessionId() {
        return this.sessionId;
    }

    @NotNull
    public final List<c> getSignaledAd() {
        return this.signaledAd;
    }

    @NotNull
    public final List<m> getUnclosedAd() {
        return this.unclosedAd;
    }

    public int hashCode() {
        return this.sessionCount;
    }

    public final void setSessionCreationTime(long j10) {
        this.sessionCreationTime = j10;
    }

    public final void setSessionDepthCounter(int i10) {
        this.sessionDepthCounter = i10;
    }

    public final void setSessionDuration(long j10) {
        this.sessionDuration = j10;
    }

    public final void setSignaledAd(@NotNull List<c> list) {
        t.i(list, "<set-?>");
        this.signaledAd = list;
    }

    public final void setUnclosedAd(@NotNull List<m> list) {
        t.i(list, "<set-?>");
        this.unclosedAd = list;
    }

    @NotNull
    public String toString() {
        return "SessionData(sessionCount=" + this.sessionCount + ')';
    }

    public /* synthetic */ a(int i10, int i11, String str, long j10, List list, long j11, int i12, List list2, s1 s1Var) {
        if (1 != (i10 & 1)) {
            i1.a(i10, 1, C0529a.INSTANCE.getDescriptor());
        }
        this.sessionCount = i11;
        if ((i10 & 2) == 0) {
            String string = UUID.randomUUID().toString();
            t.h(string, "randomUUID().toString()");
            this.sessionId = string;
        } else {
            this.sessionId = str;
        }
        if ((i10 & 4) == 0) {
            this.sessionCreationTime = System.currentTimeMillis() / 1000;
        } else {
            this.sessionCreationTime = j10;
        }
        if ((i10 & 8) == 0) {
            this.signaledAd = new ArrayList();
        } else {
            this.signaledAd = list;
        }
        if ((i10 & 16) == 0) {
            this.sessionDuration = 0L;
        } else {
            this.sessionDuration = j11;
        }
        if ((i10 & 32) == 0) {
            this.sessionDepthCounter = 0;
        } else {
            this.sessionDepthCounter = i12;
        }
        if ((i10 & 64) == 0) {
            this.unclosedAd = new ArrayList();
        } else {
            this.unclosedAd = list2;
        }
    }

    public static /* synthetic */ void getSessionCount$annotations() {
    }

    public static /* synthetic */ void getSessionCreationTime$annotations() {
    }

    public static /* synthetic */ void getSessionDepthCounter$annotations() {
    }

    public static /* synthetic */ void getSessionDuration$annotations() {
    }

    public static /* synthetic */ void getSessionId$annotations() {
    }

    public static /* synthetic */ void getSignaledAd$annotations() {
    }

    public static /* synthetic */ void getUnclosedAd$annotations() {
    }
}
