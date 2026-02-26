package com.vungle.ads.internal.signals;

import ca.d;
import da.d0;
import da.i1;
import da.l0;
import da.s1;
import da.u0;
import da.w1;
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

/* JADX INFO: compiled from: SignaledAd.kt */
/* JADX INFO: loaded from: classes4.dex */
@h
public final class c {

    @NotNull
    public static final b Companion = new b(null);
    private long adAvailabilityCallbackTime;

    @Nullable
    private String eventId;

    @Nullable
    private final Long lastAdLoadTime;
    private final long loadAdTime;
    private long playAdTime;
    private int screenOrientation;

    @Nullable
    private String templateSignals;
    private long timeBetweenAdAvailabilityAndPlayAd;
    private final long timeSinceLastAdLoad;

    /* JADX INFO: compiled from: SignaledAd.kt */
    public static final class a implements d0<c> {

        @NotNull
        public static final a INSTANCE;
        public static final /* synthetic */ SerialDescriptor descriptor;

        static {
            a aVar = new a();
            INSTANCE = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.signals.SignaledAd", aVar, 5);
            pluginGeneratedSerialDescriptor.k("500", true);
            pluginGeneratedSerialDescriptor.k("109", false);
            pluginGeneratedSerialDescriptor.k("107", true);
            pluginGeneratedSerialDescriptor.k("110", true);
            pluginGeneratedSerialDescriptor.k("108", true);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        private a() {
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] childSerializers() {
            w1 w1Var = w1.f24648a;
            u0 u0Var = u0.f24629a;
            return new KSerializer[]{aa.a.s(w1Var), u0Var, aa.a.s(w1Var), u0Var, l0.f24594a};
        }

        @Override // z9.b
        @NotNull
        public c deserialize(@NotNull Decoder decoder) {
            long jF;
            int i10;
            Object obj;
            long j10;
            int i11;
            Object objK;
            t.i(decoder, "decoder");
            SerialDescriptor descriptor2 = getDescriptor();
            ca.c cVarB = decoder.b(descriptor2);
            int i12 = 3;
            if (cVarB.p()) {
                w1 w1Var = w1.f24648a;
                Object objK2 = cVarB.k(descriptor2, 0, w1Var, null);
                long jF2 = cVarB.f(descriptor2, 1);
                objK = cVarB.k(descriptor2, 2, w1Var, null);
                long jF3 = cVarB.f(descriptor2, 3);
                i10 = 31;
                i11 = cVarB.i(descriptor2, 4);
                obj = objK2;
                j10 = jF2;
                jF = jF3;
            } else {
                jF = 0;
                boolean z10 = true;
                int i13 = 0;
                Object objK3 = null;
                Object objK4 = null;
                long jF4 = 0;
                int i14 = 0;
                while (z10) {
                    int iO = cVarB.o(descriptor2);
                    if (iO == -1) {
                        z10 = false;
                    } else if (iO == 0) {
                        objK3 = cVarB.k(descriptor2, 0, w1.f24648a, objK3);
                        i14 |= 1;
                    } else if (iO == 1) {
                        jF4 = cVarB.f(descriptor2, 1);
                        i14 |= 2;
                    } else if (iO == 2) {
                        objK4 = cVarB.k(descriptor2, 2, w1.f24648a, objK4);
                        i14 |= 4;
                    } else if (iO == i12) {
                        jF = cVarB.f(descriptor2, i12);
                        i14 |= 8;
                    } else {
                        if (iO != 4) {
                            throw new o(iO);
                        }
                        i13 = cVarB.i(descriptor2, 4);
                        i14 |= 16;
                    }
                    i12 = 3;
                }
                i10 = i14;
                obj = objK3;
                j10 = jF4;
                i11 = i13;
                objK = objK4;
            }
            cVarB.c(descriptor2);
            return new c(i10, (String) obj, j10, (String) objK, jF, i11, null);
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
            d dVarB = encoder.b(descriptor2);
            c.write$Self(value, dVarB, descriptor2);
            dVarB.c(descriptor2);
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }
    }

    /* JADX INFO: compiled from: SignaledAd.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(k kVar) {
            this();
        }

        @NotNull
        public final KSerializer<c> serializer() {
            return a.INSTANCE;
        }
    }

    public c() {
        this(null, 0L, 3, null);
    }

    public static /* synthetic */ c copy$default(c cVar, Long l10, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            l10 = cVar.lastAdLoadTime;
        }
        if ((i10 & 2) != 0) {
            j10 = cVar.loadAdTime;
        }
        return cVar.copy(l10, j10);
    }

    private final long getTimeDifference(Long l10, long j10) {
        if (l10 == null) {
            return -1L;
        }
        long jLongValue = j10 - l10.longValue();
        if (jLongValue < 0) {
            return -1L;
        }
        return jLongValue;
    }

    public static final void write$Self(@NotNull c self, @NotNull d output, @NotNull SerialDescriptor serialDesc) {
        t.i(self, "self");
        t.i(output, "output");
        t.i(serialDesc, "serialDesc");
        if (output.z(serialDesc, 0) || self.templateSignals != null) {
            output.h(serialDesc, 0, w1.f24648a, self.templateSignals);
        }
        output.F(serialDesc, 1, self.timeSinceLastAdLoad);
        if (output.z(serialDesc, 2) || self.eventId != null) {
            output.h(serialDesc, 2, w1.f24648a, self.eventId);
        }
        if (output.z(serialDesc, 3) || self.timeBetweenAdAvailabilityAndPlayAd != 0) {
            output.F(serialDesc, 3, self.timeBetweenAdAvailabilityAndPlayAd);
        }
        if (output.z(serialDesc, 4) || self.screenOrientation != 0) {
            output.w(serialDesc, 4, self.screenOrientation);
        }
    }

    public final void calculateTimeBetweenAdAvailabilityAndPlayAd() {
        this.timeBetweenAdAvailabilityAndPlayAd = getTimeDifference(Long.valueOf(this.adAvailabilityCallbackTime), this.playAdTime);
    }

    @Nullable
    public final Long component1() {
        return this.lastAdLoadTime;
    }

    public final long component2() {
        return this.loadAdTime;
    }

    @NotNull
    public final c copy(@Nullable Long l10, long j10) {
        return new c(l10, j10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return t.d(this.lastAdLoadTime, cVar.lastAdLoadTime) && this.loadAdTime == cVar.loadAdTime;
    }

    public final long getAdAvailabilityCallbackTime() {
        return this.adAvailabilityCallbackTime;
    }

    @Nullable
    public final String getEventId() {
        return this.eventId;
    }

    @Nullable
    public final Long getLastAdLoadTime() {
        return this.lastAdLoadTime;
    }

    public final long getLoadAdTime() {
        return this.loadAdTime;
    }

    public final long getPlayAdTime() {
        return this.playAdTime;
    }

    public final int getScreenOrientation() {
        return this.screenOrientation;
    }

    @Nullable
    public final String getTemplateSignals() {
        return this.templateSignals;
    }

    public final long getTimeBetweenAdAvailabilityAndPlayAd() {
        return this.timeBetweenAdAvailabilityAndPlayAd;
    }

    public final long getTimeSinceLastAdLoad() {
        return this.timeSinceLastAdLoad;
    }

    public int hashCode() {
        Long l10 = this.lastAdLoadTime;
        return ((l10 == null ? 0 : l10.hashCode()) * 31) + androidx.compose.animation.a.a(this.loadAdTime);
    }

    public final void setAdAvailabilityCallbackTime(long j10) {
        this.adAvailabilityCallbackTime = j10;
    }

    public final void setEventId(@Nullable String str) {
        this.eventId = str;
    }

    public final void setPlayAdTime(long j10) {
        this.playAdTime = j10;
    }

    public final void setScreenOrientation(int i10) {
        this.screenOrientation = i10;
    }

    public final void setTemplateSignals(@Nullable String str) {
        this.templateSignals = str;
    }

    public final void setTimeBetweenAdAvailabilityAndPlayAd(long j10) {
        this.timeBetweenAdAvailabilityAndPlayAd = j10;
    }

    @NotNull
    public String toString() {
        return "SignaledAd(lastAdLoadTime=" + this.lastAdLoadTime + ", loadAdTime=" + this.loadAdTime + ')';
    }

    public /* synthetic */ c(int i10, String str, long j10, String str2, long j11, int i11, s1 s1Var) {
        if (2 != (i10 & 2)) {
            i1.a(i10, 2, a.INSTANCE.getDescriptor());
        }
        this.lastAdLoadTime = 0L;
        this.loadAdTime = 0L;
        if ((i10 & 1) == 0) {
            this.templateSignals = null;
        } else {
            this.templateSignals = str;
        }
        this.timeSinceLastAdLoad = j10;
        if ((i10 & 4) == 0) {
            this.eventId = null;
        } else {
            this.eventId = str2;
        }
        if ((i10 & 8) == 0) {
            this.timeBetweenAdAvailabilityAndPlayAd = 0L;
        } else {
            this.timeBetweenAdAvailabilityAndPlayAd = j11;
        }
        if ((i10 & 16) == 0) {
            this.screenOrientation = 0;
        } else {
            this.screenOrientation = i11;
        }
        this.adAvailabilityCallbackTime = 0L;
        this.playAdTime = 0L;
        this.timeSinceLastAdLoad = getTimeDifference(0L, 0L);
    }

    public c(@Nullable Long l10, long j10) {
        this.lastAdLoadTime = l10;
        this.loadAdTime = j10;
        this.timeSinceLastAdLoad = getTimeDifference(l10, j10);
    }

    public /* synthetic */ c(Long l10, long j10, int i10, k kVar) {
        this((i10 & 1) != 0 ? 0L : l10, (i10 & 2) != 0 ? 0L : j10);
    }

    public static /* synthetic */ void getAdAvailabilityCallbackTime$annotations() {
    }

    public static /* synthetic */ void getEventId$annotations() {
    }

    public static /* synthetic */ void getLastAdLoadTime$annotations() {
    }

    public static /* synthetic */ void getLoadAdTime$annotations() {
    }

    public static /* synthetic */ void getPlayAdTime$annotations() {
    }

    public static /* synthetic */ void getScreenOrientation$annotations() {
    }

    public static /* synthetic */ void getTemplateSignals$annotations() {
    }

    public static /* synthetic */ void getTimeBetweenAdAvailabilityAndPlayAd$annotations() {
    }

    public static /* synthetic */ void getTimeSinceLastAdLoad$annotations() {
    }
}
