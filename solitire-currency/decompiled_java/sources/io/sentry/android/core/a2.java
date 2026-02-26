package io.sentry.android.core;

import io.sentry.android.core.performance.h;
import io.sentry.j8;
import io.sentry.l2;
import io.sentry.o8;
import io.sentry.protocol.App;
import io.sentry.protocol.MeasurementValue;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentrySpan;
import io.sentry.protocol.SentryTransaction;
import io.sentry.q8;
import io.sentry.r6;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PerformanceAndroidEventProcessor.java */
/* JADX INFO: loaded from: classes5.dex */
final class a2 implements io.sentry.g0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final h f27118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final SentryAndroidOptions f27119c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f27117a = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final io.sentry.util.a f27120d = new io.sentry.util.a();

    a2(@NotNull SentryAndroidOptions sentryAndroidOptions, @NotNull h hVar) {
        this.f27119c = (SentryAndroidOptions) io.sentry.util.w.c(sentryAndroidOptions, "SentryAndroidOptions is required");
        this.f27118b = (h) io.sentry.util.w.c(hVar, "ActivityFramesTracker is required");
    }

    private void b(@NotNull io.sentry.android.core.performance.h hVar, @NotNull SentryTransaction sentryTransaction) {
        j8 trace;
        o8 spanId;
        if (hVar.n() == h.a.COLD && (trace = sentryTransaction.getContexts().getTrace()) != null) {
            SentryId sentryIdN = trace.n();
            Iterator<SentrySpan> it = sentryTransaction.getSpans().iterator();
            while (true) {
                if (!it.hasNext()) {
                    spanId = null;
                    break;
                }
                SentrySpan next = it.next();
                if (next.getOp().contentEquals("app.start.cold")) {
                    spanId = next.getSpanId();
                    break;
                }
            }
            io.sentry.android.core.performance.i iVarG = hVar.g();
            if (iVarG.n() && Math.abs(iVarG.d()) <= 10000) {
                sentryTransaction.getSpans().add(g(iVarG, spanId, sentryIdN, "process.load"));
            }
            List<io.sentry.android.core.performance.i> listP = hVar.p();
            if (!listP.isEmpty()) {
                Iterator<io.sentry.android.core.performance.i> it2 = listP.iterator();
                while (it2.hasNext()) {
                    sentryTransaction.getSpans().add(g(it2.next(), spanId, sentryIdN, "contentprovider.load"));
                }
            }
            io.sentry.android.core.performance.i iVarO = hVar.o();
            if (iVarO.o()) {
                sentryTransaction.getSpans().add(g(iVarO, spanId, sentryIdN, "application.load"));
            }
        }
    }

    private boolean d(@NotNull SentryTransaction sentryTransaction) {
        for (SentrySpan sentrySpan : sentryTransaction.getSpans()) {
            if (sentrySpan.getOp().contentEquals("app.start.cold") || sentrySpan.getOp().contentEquals("app.start.warm")) {
                return true;
            }
        }
        j8 trace = sentryTransaction.getContexts().getTrace();
        return trace != null && (trace.e().equals("app.start.cold") || trace.e().equals("app.start.warm"));
    }

    private static boolean e(double d10, @NotNull SentrySpan sentrySpan) {
        return d10 >= sentrySpan.getStartTimestamp().doubleValue() && (sentrySpan.getTimestamp() == null || d10 <= sentrySpan.getTimestamp().doubleValue());
    }

    private void f(SentryTransaction sentryTransaction) {
        Object obj;
        SentrySpan sentrySpan = null;
        SentrySpan sentrySpan2 = null;
        for (SentrySpan sentrySpan3 : sentryTransaction.getSpans()) {
            if ("ui.load.initial_display".equals(sentrySpan3.getOp())) {
                sentrySpan = sentrySpan3;
            } else if ("ui.load.full_display".equals(sentrySpan3.getOp())) {
                sentrySpan2 = sentrySpan3;
            }
            if (sentrySpan != null && sentrySpan2 != null) {
                break;
            }
        }
        if (sentrySpan == null && sentrySpan2 == null) {
            return;
        }
        for (SentrySpan sentrySpan4 : sentryTransaction.getSpans()) {
            if (sentrySpan4 != sentrySpan && sentrySpan4 != sentrySpan2) {
                Map<String, Object> data = sentrySpan4.getData();
                boolean z10 = false;
                boolean z11 = sentrySpan != null && e(sentrySpan4.getStartTimestamp().doubleValue(), sentrySpan) && (data == null || (obj = data.get("thread.name")) == null || "main".equals(obj));
                if (sentrySpan2 != null && e(sentrySpan4.getStartTimestamp().doubleValue(), sentrySpan2)) {
                    z10 = true;
                }
                if (z11 || z10) {
                    Map<String, Object> data2 = sentrySpan4.getData();
                    if (data2 == null) {
                        data2 = new ConcurrentHashMap<>();
                        sentrySpan4.setData(data2);
                    }
                    if (z11) {
                        data2.put("ui.contributes_to_ttid", Boolean.TRUE);
                    }
                    if (z10) {
                        data2.put("ui.contributes_to_ttfd", Boolean.TRUE);
                    }
                }
            }
        }
    }

    @NotNull
    private static SentrySpan g(@NotNull io.sentry.android.core.performance.i iVar, @Nullable o8 o8Var, @NotNull SentryId sentryId, @NotNull String str) {
        HashMap map = new HashMap(2);
        map.put("thread.id", Long.valueOf(io.sentry.android.core.internal.util.d.f27300b));
        map.put("thread.name", "main");
        Boolean bool = Boolean.TRUE;
        map.put("ui.contributes_to_ttid", bool);
        map.put("ui.contributes_to_ttfd", bool);
        return new SentrySpan(Double.valueOf(iVar.j()), Double.valueOf(iVar.g()), sentryId, new o8(), o8Var, str, iVar.c(), q8.OK, "auto.ui", new ConcurrentHashMap(), new ConcurrentHashMap(), map);
    }

    @Override // io.sentry.g0
    @NotNull
    public SentryTransaction c(@NotNull SentryTransaction sentryTransaction, @NotNull io.sentry.l0 l0Var) {
        Map<String, MeasurementValue> mapQ;
        io.sentry.k1 k1VarA = this.f27120d.a();
        try {
            if (!this.f27119c.isTracingEnabled()) {
                if (k1VarA != null) {
                    k1VarA.close();
                }
                return sentryTransaction;
            }
            io.sentry.android.core.performance.h hVarQ = io.sentry.android.core.performance.h.q();
            if (d(sentryTransaction)) {
                if (hVarQ.C()) {
                    long jD = hVarQ.m(this.f27119c).d();
                    if (jD != 0) {
                        sentryTransaction.getMeasurements().put(hVarQ.n() == h.a.COLD ? MeasurementValue.KEY_APP_START_COLD : MeasurementValue.KEY_APP_START_WARM, new MeasurementValue(Float.valueOf(jD), l2.a.MILLISECOND.apiName()));
                        b(hVarQ, sentryTransaction);
                        hVarQ.w();
                    }
                }
                App app = sentryTransaction.getContexts().getApp();
                if (app == null) {
                    app = new App();
                    sentryTransaction.getContexts().setApp(app);
                }
                app.setStartType(hVarQ.n() == h.a.COLD ? "cold" : "warm");
            }
            f(sentryTransaction);
            SentryId eventId = sentryTransaction.getEventId();
            j8 trace = sentryTransaction.getContexts().getTrace();
            if (eventId != null && trace != null && trace.e().contentEquals("ui.load") && (mapQ = this.f27118b.q(eventId)) != null) {
                sentryTransaction.getMeasurements().putAll(mapQ);
            }
            if (k1VarA != null) {
                k1VarA.close();
            }
            return sentryTransaction;
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // io.sentry.g0
    @Nullable
    public Long getOrder() {
        return 9000L;
    }

    @Override // io.sentry.g0
    @Nullable
    public r6 a(@NotNull r6 r6Var, @NotNull io.sentry.l0 l0Var) {
        return r6Var;
    }
}
