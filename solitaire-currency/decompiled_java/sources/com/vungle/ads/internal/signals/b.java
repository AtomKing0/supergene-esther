package com.vungle.ads.internal.signals;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import androidx.annotation.VisibleForTesting;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.util.c;
import com.vungle.ads.internal.util.p;
import com.vungle.ads.internal.util.q;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.o0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.json.m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.l;
import v8.n;

/* JADX INFO: compiled from: SignalManager.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    @NotNull
    public static final a Companion = new a(null);

    @NotNull
    public static final String SESSION_COUNT_KEY = "vungle_signal_session_count";
    private static final int SESSION_COUNT_NOT_SET = -1;

    @NotNull
    public static final String SESSION_TIME_KEY = "vungle_signal_session_creation_time";
    public static final int SIGNAL_VERSION = 1;

    @NotNull
    private static final String TAG = "SignalManager";
    public static final long TWENTY_FOUR_HOURS_MILLIS = 86400000;

    @NotNull
    private final Context context;

    @NotNull
    private com.vungle.ads.internal.signals.a currentSession;
    private long enterBackgroundTime;
    private long enterForegroundTime;

    @NotNull
    private final l filePreferences$delegate;

    @NotNull
    private final kotlinx.serialization.json.a json;

    @NotNull
    private ConcurrentHashMap<String, Long> mapOfLastLoadTimes;
    private int sessionCount;
    private long sessionDuration;
    private long sessionSeriesCreatedTime;

    @NotNull
    private com.vungle.ads.internal.session.d unclosedAdDetector;

    /* JADX INFO: compiled from: SignalManager.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.vungle.ads.internal.signals.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SignalManager.kt */
    static final class C0530b extends v implements h9.l<kotlinx.serialization.json.c, k0> {
        public static final C0530b INSTANCE = new C0530b();

        C0530b() {
            super(1);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(kotlinx.serialization.json.c cVar) {
            invoke2(cVar);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull kotlinx.serialization.json.c Json) {
            t.i(Json, "$this$Json");
            Json.f(true);
            Json.d(true);
            Json.e(false);
        }
    }

    /* JADX INFO: compiled from: SignalManager.kt */
    public static final class c extends c.C0535c {
        c() {
        }

        @Override // com.vungle.ads.internal.util.c.C0535c
        public void onPause() {
            super.onPause();
            b.this.setEnterBackgroundTime(System.currentTimeMillis());
            b bVar = b.this;
            bVar.setSessionDuration(bVar.getSessionDuration() + (b.this.getEnterBackgroundTime() - b.this.getEnterForegroundTime()));
        }

        @Override // com.vungle.ads.internal.util.c.C0535c
        public void onResume() {
            super.onResume();
            if (b.this.getEnterBackgroundTime() == 0) {
                p.Companion.d(b.TAG, "SignalManager#onResume skipped");
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - b.this.getEnterBackgroundTime() > com.vungle.ads.internal.k.INSTANCE.getSignalsSessionTimeout()) {
                b.this.createNewSessionData();
            }
            b.this.setEnterForegroundTime(jCurrentTimeMillis);
            b.this.setEnterBackgroundTime(0L);
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class d extends v implements h9.a<com.vungle.ads.internal.persistence.b> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.persistence.b, java.lang.Object] */
        @Override // h9.a
        @NotNull
        public final com.vungle.ads.internal.persistence.b invoke() {
            return ServiceLocator.Companion.getInstance(this.$context).getService(com.vungle.ads.internal.persistence.b.class);
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class e extends v implements h9.a<com.vungle.ads.internal.executor.a> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.executor.a, java.lang.Object] */
        @Override // h9.a
        @NotNull
        public final com.vungle.ads.internal.executor.a invoke() {
            return ServiceLocator.Companion.getInstance(this.$context).getService(com.vungle.ads.internal.executor.a.class);
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class f extends v implements h9.a<q> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.util.q, java.lang.Object] */
        @Override // h9.a
        @NotNull
        public final q invoke() {
            return ServiceLocator.Companion.getInstance(this.$context).getService(q.class);
        }
    }

    public b(@NotNull Context context) {
        t.i(context, "context");
        this.context = context;
        this.json = m.b(null, C0530b.INSTANCE, 1, null);
        this.enterForegroundTime = System.currentTimeMillis();
        this.sessionCount = -1;
        this.mapOfLastLoadTimes = new ConcurrentHashMap<>();
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        v8.p pVar = v8.p.f35201a;
        this.filePreferences$delegate = n.b(pVar, new d(context));
        registerNotifications();
        this.sessionSeriesCreatedTime = getFilePreferences().getLong(SESSION_TIME_KEY, -1L);
        updateSessionCount();
        this.currentSession = new com.vungle.ads.internal.signals.a(this.sessionCount);
        com.vungle.ads.internal.session.d dVar = new com.vungle.ads.internal.session.d(context, this.currentSession.getSessionId(), m4101_init_$lambda0(n.b(pVar, new e(context))), m4102_init_$lambda1(n.b(pVar, new f(context))));
        this.unclosedAdDetector = dVar;
        this.currentSession.setUnclosedAd(dVar.retrieveUnclosedAd());
    }

    /* JADX INFO: renamed from: _init_$lambda-0, reason: not valid java name */
    private static final com.vungle.ads.internal.executor.a m4101_init_$lambda0(l<? extends com.vungle.ads.internal.executor.a> lVar) {
        return lVar.getValue();
    }

    /* JADX INFO: renamed from: _init_$lambda-1, reason: not valid java name */
    private static final q m4102_init_$lambda1(l<q> lVar) {
        return lVar.getValue();
    }

    private final void registerNotifications() {
        com.vungle.ads.internal.util.c.Companion.addLifecycleListener(new c());
    }

    private final void updateSessionCount() {
        if (this.sessionCount == -1) {
            this.sessionCount = getFilePreferences().getInt(SESSION_COUNT_KEY, 0);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j10 = this.sessionSeriesCreatedTime;
        long j11 = jCurrentTimeMillis - j10;
        if (j10 < 0 || j11 >= TWENTY_FOUR_HOURS_MILLIS) {
            this.sessionCount = 1;
            getFilePreferences().put(SESSION_TIME_KEY, jCurrentTimeMillis);
            this.sessionSeriesCreatedTime = jCurrentTimeMillis;
        } else {
            this.sessionCount++;
        }
        getFilePreferences().put(SESSION_COUNT_KEY, this.sessionCount);
        getFilePreferences().apply();
    }

    private final void updateSessionDuration() {
        this.currentSession.setSessionDuration((this.sessionDuration + System.currentTimeMillis()) - this.enterForegroundTime);
    }

    public final void createNewSessionData() {
        updateSessionCount();
        this.currentSession = new com.vungle.ads.internal.signals.a(this.sessionCount);
    }

    @Nullable
    public final String generateSignals() {
        updateSessionDuration();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("1:");
            kotlinx.serialization.json.a aVar = this.json;
            com.vungle.ads.internal.signals.a aVar2 = this.currentSession;
            KSerializer<Object> kSerializerB = z9.l.b(aVar.a(), o0.j(com.vungle.ads.internal.signals.a.class));
            t.g(kSerializerB, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            sb.append(aVar.c(kSerializerB, aVar2));
            return sb.toString();
        } catch (Error | Exception unused) {
            return null;
        }
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public final com.vungle.ads.internal.signals.a getCurrentSession$vungle_ads_release() {
        return this.currentSession;
    }

    public final long getEnterBackgroundTime() {
        return this.enterBackgroundTime;
    }

    public final long getEnterForegroundTime() {
        return this.enterForegroundTime;
    }

    @NotNull
    public final com.vungle.ads.internal.persistence.b getFilePreferences() {
        return (com.vungle.ads.internal.persistence.b) this.filePreferences$delegate.getValue();
    }

    @NotNull
    public final ConcurrentHashMap<String, Long> getMapOfLastLoadTimes() {
        return this.mapOfLastLoadTimes;
    }

    public final int getSessionCount() {
        return this.sessionCount;
    }

    public final long getSessionDuration() {
        return this.sessionDuration;
    }

    public final long getSessionSeriesCreatedTime() {
        return this.sessionSeriesCreatedTime;
    }

    @NotNull
    public final synchronized com.vungle.ads.internal.signals.c getSignaledAd(@NotNull String placementId) {
        long jCurrentTimeMillis;
        Long l10;
        t.i(placementId, "placementId");
        jCurrentTimeMillis = System.currentTimeMillis();
        l10 = this.mapOfLastLoadTimes.containsKey(placementId) ? this.mapOfLastLoadTimes.get(placementId) : null;
        this.mapOfLastLoadTimes.put(placementId, Long.valueOf(jCurrentTimeMillis));
        return new com.vungle.ads.internal.signals.c(l10, jCurrentTimeMillis);
    }

    @NotNull
    public final String getUuid() {
        return this.currentSession.getSessionId();
    }

    public final synchronized void increaseSessionDepthCounter() {
        com.vungle.ads.internal.signals.a aVar = this.currentSession;
        aVar.setSessionDepthCounter(aVar.getSessionDepthCounter() + 1);
    }

    public final void recordUnclosedAd(@NotNull com.vungle.ads.internal.model.m unclosedAd) {
        t.i(unclosedAd, "unclosedAd");
        if (com.vungle.ads.internal.k.INSTANCE.signalsDisabled()) {
            return;
        }
        this.unclosedAdDetector.addUnclosedAd(unclosedAd);
    }

    public final void registerSignaledAd(@Nullable Context context, @NotNull com.vungle.ads.internal.signals.c signaledAd) {
        t.i(signaledAd, "signaledAd");
        this.currentSession.getSignaledAd().clear();
        this.currentSession.getSignaledAd().add(signaledAd);
        this.currentSession.getSignaledAd().get(0).setScreenOrientation(screenOrientation(context));
    }

    public final void removeUnclosedAd(@NotNull com.vungle.ads.internal.model.m unclosedAd) {
        t.i(unclosedAd, "unclosedAd");
        if (com.vungle.ads.internal.k.INSTANCE.signalsDisabled()) {
            return;
        }
        this.unclosedAdDetector.removeUnclosedAd(unclosedAd);
    }

    public final int screenOrientation(@Nullable Context context) {
        Configuration configuration;
        if (context == null) {
            context = this.context;
        }
        Resources resources = context.getResources();
        Integer numValueOf = (resources == null || (configuration = resources.getConfiguration()) == null) ? null : Integer.valueOf(configuration.orientation);
        if (numValueOf != null && numValueOf.intValue() == 2) {
            return 2;
        }
        if (numValueOf != null && numValueOf.intValue() == 1) {
            return 1;
        }
        return (numValueOf != null && numValueOf.intValue() == 0) ? 0 : -1;
    }

    public final void setCurrentSession$vungle_ads_release(@NotNull com.vungle.ads.internal.signals.a aVar) {
        t.i(aVar, "<set-?>");
        this.currentSession = aVar;
    }

    public final void setEnterBackgroundTime(long j10) {
        this.enterBackgroundTime = j10;
    }

    public final void setEnterForegroundTime(long j10) {
        this.enterForegroundTime = j10;
    }

    public final void setMapOfLastLoadTimes(@NotNull ConcurrentHashMap<String, Long> concurrentHashMap) {
        t.i(concurrentHashMap, "<set-?>");
        this.mapOfLastLoadTimes = concurrentHashMap;
    }

    public final void setSessionCount(int i10) {
        this.sessionCount = i10;
    }

    public final void setSessionDuration(long j10) {
        this.sessionDuration = j10;
    }

    public final void setSessionSeriesCreatedTime(long j10) {
        this.sessionSeriesCreatedTime = j10;
    }

    public final void updateTemplateSignals(@Nullable String str) {
        if ((str == null || str.length() == 0) || !(true ^ this.currentSession.getSignaledAd().isEmpty())) {
            return;
        }
        this.currentSession.getSignaledAd().get(0).setTemplateSignals(str);
    }

    @VisibleForTesting(otherwise = 2)
    public static /* synthetic */ void getCurrentSession$vungle_ads_release$annotations() {
    }
}
