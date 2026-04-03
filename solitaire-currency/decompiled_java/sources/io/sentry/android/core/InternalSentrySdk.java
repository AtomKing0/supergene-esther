package io.sentry.android.core;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.applovin.sdk.AppLovinEventTypes;
import io.sentry.ScopeCallback;
import io.sentry.Sentry;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.e8;
import io.sentry.h4;
import io.sentry.p5;
import io.sentry.p6;
import io.sentry.protocol.App;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentrySpan;
import io.sentry.protocol.SentryTransaction;
import io.sentry.protocol.User;
import io.sentry.r4;
import io.sentry.r6;
import io.sentry.z3;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class InternalSentrySdk {
    private static void addTimeSpanToSerializedSpans(io.sentry.android.core.performance.i iVar, List<Map<String, Object>> list) {
        if (iVar.l()) {
            r4.a().getOptions().getLogger().c(SentryLevel.WARNING, "Can not convert not-started TimeSpan to Map for Hybrid SDKs.", new Object[0]);
            return;
        }
        if (iVar.m()) {
            r4.a().getOptions().getLogger().c(SentryLevel.WARNING, "Can not convert not-stopped TimeSpan to Map for Hybrid SDKs.", new Object[0]);
            return;
        }
        HashMap map = new HashMap();
        map.put("description", iVar.c());
        map.put("start_timestamp_ms", Long.valueOf(iVar.i()));
        map.put("end_timestamp_ms", Long.valueOf(iVar.f()));
        list.add(map);
    }

    @Nullable
    public static SentryId captureEnvelope(@NotNull byte[] bArr, boolean z10) {
        r4 r4VarA = r4.a();
        SentryOptions options = r4VarA.getOptions();
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                io.sentry.l1 serializer = options.getSerializer();
                p5 p5VarA = options.getEnvelopeReader().a(byteArrayInputStream);
                if (p5VarA == null) {
                    byteArrayInputStream.close();
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                e8.b bVar = null;
                boolean z11 = false;
                for (p6 p6Var : p5VarA.c()) {
                    arrayList.add(p6Var);
                    r6 r6VarJ = p6Var.J(serializer);
                    if (r6VarJ != null) {
                        if (r6VarJ.r()) {
                            bVar = e8.b.Crashed;
                        }
                        if (r6VarJ.r() || r6VarJ.s()) {
                            z11 = true;
                        }
                    }
                }
                e8 e8VarUpdateSession = updateSession(r4VarA, options, bVar, z11);
                if (e8VarUpdateSession != null) {
                    arrayList.add(p6.F(serializer, e8VarUpdateSession));
                    deleteCurrentSessionFile(options, (z10 && r4VarA.getOptions().getThreadChecker().a()) ? false : true);
                    if (z10) {
                        r4VarA.startSession();
                    }
                }
                SentryId sentryIdZ = r4VarA.z(new p5(p5VarA.b(), arrayList));
                byteArrayInputStream.close();
                return sentryIdZ;
            } finally {
            }
        } catch (Throwable th) {
            options.getLogger().b(SentryLevel.ERROR, "Failed to capture envelope", th);
            return null;
        }
        options.getLogger().b(SentryLevel.ERROR, "Failed to capture envelope", th);
        return null;
    }

    private static void deleteCurrentSessionFile(@NotNull final SentryOptions sentryOptions, boolean z10) {
        if (z10) {
            deleteCurrentSessionFile(sentryOptions);
            return;
        }
        try {
            sentryOptions.getExecutorService().submit(new Runnable() { // from class: io.sentry.android.core.p1
                @Override // java.lang.Runnable
                public final void run() {
                    InternalSentrySdk.deleteCurrentSessionFile(sentryOptions);
                }
            });
        } catch (Throwable th) {
            sentryOptions.getLogger().b(SentryLevel.WARNING, "Submission of deletion of the current session file rejected.", th);
        }
    }

    public static Map<String, Object> getAppStartMeasurement() {
        io.sentry.android.core.performance.h hVarQ = io.sentry.android.core.performance.h.q();
        ArrayList arrayList = new ArrayList();
        addTimeSpanToSerializedSpans(hVarQ.g(), arrayList);
        addTimeSpanToSerializedSpans(hVarQ.o(), arrayList);
        Iterator<io.sentry.android.core.performance.i> it = hVarQ.p().iterator();
        while (it.hasNext()) {
            addTimeSpanToSerializedSpans(it.next(), arrayList);
        }
        for (io.sentry.android.core.performance.c cVar : hVarQ.h()) {
            addTimeSpanToSerializedSpans(cVar.c(), arrayList);
            addTimeSpanToSerializedSpans(cVar.d(), arrayList);
        }
        HashMap map = new HashMap();
        map.put(SentryTransaction.JsonKeys.SPANS, arrayList);
        map.put("type", hVarQ.n().toString().toLowerCase(Locale.ROOT));
        if (hVarQ.l().n()) {
            map.put("app_start_timestamp_ms", Long.valueOf(hVarQ.l().i()));
        }
        return map;
    }

    @Nullable
    public static io.sentry.c1 getCurrentScope() {
        final AtomicReference atomicReference = new AtomicReference();
        r4.a().o(h4.COMBINED, new ScopeCallback() { // from class: io.sentry.android.core.r1
            @Override // io.sentry.ScopeCallback
            public final void run(io.sentry.c1 c1Var) {
                InternalSentrySdk.lambda$getCurrentScope$0(atomicReference, c1Var);
            }
        });
        return (io.sentry.c1) atomicReference.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getCurrentScope$0(AtomicReference atomicReference, io.sentry.c1 c1Var) {
        atomicReference.set(c1Var.m4216clone());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$updateSession$2(e8.b bVar, boolean z10, AtomicReference atomicReference, SentryOptions sentryOptions, io.sentry.c1 c1Var) {
        e8 session = c1Var.getSession();
        if (session == null) {
            sentryOptions.getLogger().c(SentryLevel.INFO, "Session is null on updateSession", new Object[0]);
        } else if (session.q(bVar, null, z10, null)) {
            if (session.l() == e8.b.Crashed) {
                session.c();
                c1Var.clearSession();
            }
            atomicReference.set(session);
        }
    }

    @NotNull
    public static Map<String, Object> serializeScope(@NotNull Context context, @NotNull SentryAndroidOptions sentryAndroidOptions, @Nullable io.sentry.c1 c1Var) {
        HashMap map = new HashMap();
        if (c1Var == null) {
            return map;
        }
        try {
            io.sentry.w0 logger = sentryAndroidOptions.getLogger();
            io.sentry.util.v vVar = new io.sentry.util.v(map);
            j1 j1VarI = j1.i(context, sentryAndroidOptions);
            c1Var.getContexts().setDevice(j1VarI.a(true, true));
            c1Var.getContexts().setOperatingSystem(j1VarI.j());
            User user = c1Var.getUser();
            if (user == null) {
                user = new User();
                c1Var.setUser(user);
            }
            if (user.getId() == null) {
                try {
                    user.setId(o1.a(context));
                } catch (RuntimeException e10) {
                    logger.b(SentryLevel.ERROR, "Could not retrieve installation ID", e10);
                }
            }
            App app = c1Var.getContexts().getApp();
            if (app == null) {
                app = new App();
            }
            app.setAppName(e1.j(context));
            io.sentry.android.core.performance.i iVarM = io.sentry.android.core.performance.h.q().m(sentryAndroidOptions);
            if (iVarM.n()) {
                app.setAppStartTime(io.sentry.n.o(iVarM.h()));
            }
            w0 w0Var = new w0(sentryAndroidOptions.getLogger());
            PackageInfo packageInfoP = e1.p(context, 4096, sentryAndroidOptions.getLogger(), w0Var);
            if (packageInfoP != null) {
                e1.E(packageInfoP, w0Var, j1VarI, app);
            }
            c1Var.getContexts().setApp(app);
            vVar.e("user").o(logger, c1Var.getUser());
            vVar.e("contexts").o(logger, c1Var.getContexts());
            vVar.e(SentrySpan.JsonKeys.TAGS).o(logger, c1Var.getTags());
            vVar.e("extras").o(logger, c1Var.getExtras());
            vVar.e("fingerprint").o(logger, c1Var.getFingerprint());
            vVar.e(AppLovinEventTypes.USER_COMPLETED_LEVEL).o(logger, c1Var.getLevel());
            vVar.e("breadcrumbs").o(logger, c1Var.getBreadcrumbs());
            return map;
        } catch (Throwable th) {
            sentryAndroidOptions.getLogger().b(SentryLevel.ERROR, "Could not serialize scope.", th);
            return new HashMap();
        }
    }

    public static void setTrace(@NotNull String str, @NotNull String str2, @Nullable Double d10, @Nullable Double d11) {
        io.sentry.util.k0.q(Sentry.getCurrentScopes(), z3.a(str, str2, d10, d11));
    }

    @Nullable
    private static e8 updateSession(@NotNull io.sentry.f1 f1Var, @NotNull final SentryOptions sentryOptions, @Nullable final e8.b bVar, final boolean z10) {
        final AtomicReference atomicReference = new AtomicReference();
        f1Var.n(new ScopeCallback() { // from class: io.sentry.android.core.q1
            @Override // io.sentry.ScopeCallback
            public final void run(io.sentry.c1 c1Var) {
                InternalSentrySdk.lambda$updateSession$2(bVar, z10, atomicReference, sentryOptions, c1Var);
            }
        });
        return (e8) atomicReference.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void deleteCurrentSessionFile(@NotNull SentryOptions sentryOptions) {
        String cacheDirPath = sentryOptions.getCacheDirPath();
        if (cacheDirPath == null) {
            sentryOptions.getLogger().c(SentryLevel.INFO, "Cache dir is not set, not deleting the current session.", new Object[0]);
        } else if (!sentryOptions.isEnableAutoSessionTracking()) {
            sentryOptions.getLogger().c(SentryLevel.DEBUG, "Session tracking is disabled, bailing from deleting current session file.", new Object[0]);
        } else {
            if (io.sentry.cache.f.v(cacheDirPath).delete()) {
                return;
            }
            sentryOptions.getLogger().c(SentryLevel.WARNING, "Failed to delete the current session file.", new Object[0]);
        }
    }
}
