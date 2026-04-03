package io.sentry.android.core;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.util.DisplayMetrics;
import androidx.annotation.WorkerThread;
import io.sentry.Breadcrumb;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.core.e1;
import io.sentry.i5;
import io.sentry.j8;
import io.sentry.protocol.App;
import io.sentry.protocol.Contexts;
import io.sentry.protocol.DebugImage;
import io.sentry.protocol.DebugMeta;
import io.sentry.protocol.Device;
import io.sentry.protocol.Mechanism;
import io.sentry.protocol.OperatingSystem;
import io.sentry.protocol.Request;
import io.sentry.protocol.SdkVersion;
import io.sentry.protocol.SentryStackTrace;
import io.sentry.protocol.SentryThread;
import io.sentry.protocol.SentryTransaction;
import io.sentry.protocol.User;
import io.sentry.r6;
import io.sentry.s6;
import io.sentry.s7;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AnrV2EventProcessor.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
@WorkerThread
public final class n0 implements io.sentry.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Context f27418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final SentryAndroidOptions f27419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final w0 f27420c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final s6 f27421d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private final io.sentry.cache.w f27422e;

    public n0(@NotNull Context context, @NotNull SentryAndroidOptions sentryAndroidOptions, @NotNull w0 w0Var) {
        this.f27418a = e1.h(context);
        this.f27419b = sentryAndroidOptions;
        this.f27420c = w0Var;
        this.f27422e = sentryAndroidOptions.findPersistingScopeObserver();
        this.f27421d = new s6(new s7(sentryAndroidOptions));
    }

    private void A(@NotNull i5 i5Var) {
        if (i5Var.getRelease() == null) {
            i5Var.setRelease((String) io.sentry.cache.h.i(this.f27419b, "release.json", String.class));
        }
    }

    private void B(@NotNull r6 r6Var) {
        String str = (String) l(this.f27419b, "replay.json", String.class);
        if (!new File(this.f27419b.getCacheDirPath(), "replay_" + str).exists()) {
            if (!m(r6Var)) {
                return;
            }
            File[] fileArrListFiles = new File(this.f27419b.getCacheDirPath()).listFiles();
            String strSubstring = null;
            if (fileArrListFiles != null) {
                long jLastModified = Long.MIN_VALUE;
                for (File file : fileArrListFiles) {
                    if (file.isDirectory() && file.getName().startsWith("replay_") && file.lastModified() > jLastModified && file.lastModified() <= r6Var.p().getTime()) {
                        jLastModified = file.lastModified();
                        strSubstring = file.getName().substring(7);
                    }
                }
            }
            str = strSubstring;
        }
        if (str == null) {
            return;
        }
        io.sentry.cache.w.R(this.f27419b, str, "replay.json");
        r6Var.getContexts().put("replay_id", str);
    }

    private void C(@NotNull i5 i5Var) {
        if (i5Var.getRequest() == null) {
            i5Var.setRequest((Request) l(this.f27419b, "request.json", Request.class));
        }
    }

    private void D(@NotNull i5 i5Var) {
        Map map = (Map) l(this.f27419b, "tags.json", Map.class);
        if (map == null) {
            return;
        }
        if (i5Var.getTags() == null) {
            i5Var.setTags(new HashMap(map));
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (!i5Var.getTags().containsKey(entry.getKey())) {
                i5Var.setTag((String) entry.getKey(), (String) entry.getValue());
            }
        }
    }

    private void E(@NotNull i5 i5Var) {
        if (i5Var.getSdk() == null) {
            i5Var.setSdk((SdkVersion) io.sentry.cache.h.i(this.f27419b, "sdk-version.json", SdkVersion.class));
        }
    }

    private void F(@NotNull i5 i5Var) {
        try {
            e1.a aVarL = j1.i(this.f27418a, this.f27419b).l();
            if (aVarL != null) {
                for (Map.Entry<String, String> entry : aVarL.a().entrySet()) {
                    i5Var.setTag(entry.getKey(), entry.getValue());
                }
            }
        } catch (Throwable th) {
            this.f27419b.getLogger().b(SentryLevel.ERROR, "Error getting side loaded info.", th);
        }
    }

    private void G(@NotNull r6 r6Var) {
        k(r6Var);
        F(r6Var);
    }

    private void H(@NotNull r6 r6Var) {
        j8 j8Var = (j8) l(this.f27419b, "trace.json", j8.class);
        if (r6Var.getContexts().getTrace() != null || j8Var == null || j8Var.k() == null || j8Var.n() == null) {
            return;
        }
        r6Var.getContexts().setTrace(j8Var);
    }

    private void I(@NotNull r6 r6Var) {
        String str = (String) l(this.f27419b, "transaction.json", String.class);
        if (r6Var.getTransaction() == null) {
            r6Var.A(str);
        }
    }

    private void J(@NotNull i5 i5Var) {
        if (i5Var.getUser() == null) {
            i5Var.setUser((User) l(this.f27419b, "user.json", User.class));
        }
    }

    private void b(@NotNull r6 r6Var, @NotNull Object obj) {
        A(r6Var);
        t(r6Var);
        s(r6Var);
        q(r6Var);
        E(r6Var);
        n(r6Var, obj);
        y(r6Var);
    }

    private void d(@NotNull r6 r6Var, @NotNull Object obj) {
        C(r6Var);
        J(r6Var);
        D(r6Var);
        o(r6Var);
        v(r6Var);
        p(r6Var);
        I(r6Var);
        w(r6Var, obj);
        x(r6Var);
        H(r6Var);
        B(r6Var);
    }

    @Nullable
    private SentryThread e(@Nullable List<SentryThread> list) {
        if (list == null) {
            return null;
        }
        for (SentryThread sentryThread : list) {
            String name = sentryThread.getName();
            if (name != null && name.equals("main")) {
                return sentryThread;
            }
        }
        return null;
    }

    @SuppressLint({"NewApi"})
    @NotNull
    private Device f() {
        Device device = new Device();
        device.setManufacturer(Build.MANUFACTURER);
        device.setBrand(Build.BRAND);
        device.setFamily(e1.m(this.f27419b.getLogger()));
        device.setModel(Build.MODEL);
        device.setModelId(Build.ID);
        device.setArchs(e1.k());
        ActivityManager.MemoryInfo memoryInfoO = e1.o(this.f27418a, this.f27419b.getLogger());
        if (memoryInfoO != null) {
            device.setMemorySize(h(memoryInfoO));
        }
        device.setSimulator(this.f27420c.f());
        DisplayMetrics displayMetricsL = e1.l(this.f27418a, this.f27419b.getLogger());
        if (displayMetricsL != null) {
            device.setScreenWidthPixels(Integer.valueOf(displayMetricsL.widthPixels));
            device.setScreenHeightPixels(Integer.valueOf(displayMetricsL.heightPixels));
            device.setScreenDensity(Float.valueOf(displayMetricsL.density));
            device.setScreenDpi(Integer.valueOf(displayMetricsL.densityDpi));
        }
        if (device.getId() == null) {
            device.setId(g());
        }
        List<Integer> listC = io.sentry.android.core.internal.util.g.a().c();
        if (!listC.isEmpty()) {
            device.setProcessorFrequency(Double.valueOf(((Integer) Collections.max(listC)).doubleValue()));
            device.setProcessorCount(Integer.valueOf(listC.size()));
        }
        return device;
    }

    @Nullable
    private String g() {
        try {
            return o1.a(this.f27418a);
        } catch (Throwable th) {
            this.f27419b.getLogger().b(SentryLevel.ERROR, "Error getting installationId.", th);
            return null;
        }
    }

    @NotNull
    private Long h(@NotNull ActivityManager.MemoryInfo memoryInfo) {
        return Long.valueOf(memoryInfo.totalMem);
    }

    private boolean i(@NotNull Object obj) {
        if (obj instanceof io.sentry.hints.a) {
            return "anr_background".equals(((io.sentry.hints.a) obj).h());
        }
        return false;
    }

    private void j(@NotNull i5 i5Var) {
        String str;
        OperatingSystem operatingSystem = i5Var.getContexts().getOperatingSystem();
        i5Var.getContexts().setOperatingSystem(j1.i(this.f27418a, this.f27419b).j());
        if (operatingSystem != null) {
            String name = operatingSystem.getName();
            if (name == null || name.isEmpty()) {
                str = "os_1";
            } else {
                str = "os_" + name.trim().toLowerCase(Locale.ROOT);
            }
            i5Var.getContexts().put(str, operatingSystem);
        }
    }

    private void k(@NotNull i5 i5Var) {
        User user = i5Var.getUser();
        if (user == null) {
            user = new User();
            i5Var.setUser(user);
        }
        if (user.getId() == null) {
            user.setId(g());
        }
        if (user.getIpAddress() == null && this.f27419b.isSendDefaultPii()) {
            user.setIpAddress("{{auto}}");
        }
    }

    @Nullable
    private <T> T l(@NotNull SentryOptions sentryOptions, @NotNull String str, @NotNull Class<T> cls) {
        io.sentry.cache.w wVar = this.f27422e;
        if (wVar == null) {
            return null;
        }
        return (T) wVar.O(sentryOptions, str, cls);
    }

    private boolean m(@NotNull r6 r6Var) {
        String str = (String) io.sentry.cache.h.i(this.f27419b, "replay-error-sample-rate.json", String.class);
        if (str == null) {
            return false;
        }
        try {
            if (Double.parseDouble(str) >= io.sentry.util.b0.a().d()) {
                return true;
            }
            this.f27419b.getLogger().c(SentryLevel.DEBUG, "Not capturing replay for ANR %s due to not being sampled.", r6Var.getEventId());
            return false;
        } catch (Throwable th) {
            this.f27419b.getLogger().b(SentryLevel.ERROR, "Error parsing replay sample rate.", th);
            return false;
        }
    }

    private void n(@NotNull i5 i5Var, @NotNull Object obj) {
        App app = i5Var.getContexts().getApp();
        if (app == null) {
            app = new App();
        }
        app.setAppName(e1.j(this.f27418a));
        app.setInForeground(Boolean.valueOf(!i(obj)));
        PackageInfo packageInfoQ = e1.q(this.f27418a, this.f27420c);
        if (packageInfoQ != null) {
            app.setAppIdentifier(packageInfoQ.packageName);
        }
        String release = i5Var.getRelease() != null ? i5Var.getRelease() : (String) io.sentry.cache.h.i(this.f27419b, "release.json", String.class);
        if (release != null) {
            try {
                String strSubstring = release.substring(release.indexOf(64) + 1, release.indexOf(43));
                String strSubstring2 = release.substring(release.indexOf(43) + 1);
                app.setAppVersion(strSubstring);
                app.setAppBuild(strSubstring2);
            } catch (Throwable unused) {
                this.f27419b.getLogger().c(SentryLevel.WARNING, "Failed to parse release from scope cache: %s", release);
            }
        }
        try {
            e1.b bVarM = j1.i(this.f27418a, this.f27419b).m();
            if (bVarM != null) {
                app.setSplitApks(Boolean.valueOf(bVarM.b()));
                if (bVarM.a() != null) {
                    app.setSplitNames(Arrays.asList(bVarM.a()));
                }
            }
        } catch (Throwable th) {
            this.f27419b.getLogger().b(SentryLevel.ERROR, "Error getting split apks info.", th);
        }
        i5Var.getContexts().setApp(app);
    }

    private void o(@NotNull i5 i5Var) {
        List<Breadcrumb> list = (List) l(this.f27419b, "breadcrumbs.json", List.class);
        if (list == null) {
            return;
        }
        if (i5Var.getBreadcrumbs() == null) {
            i5Var.setBreadcrumbs(list);
        } else {
            i5Var.getBreadcrumbs().addAll(list);
        }
    }

    private void p(@NotNull i5 i5Var) {
        Contexts contexts = (Contexts) l(this.f27419b, "contexts.json", Contexts.class);
        if (contexts == null) {
            return;
        }
        Contexts contexts2 = i5Var.getContexts();
        for (Map.Entry<String, Object> entry : new Contexts(contexts).entrySet()) {
            Object value = entry.getValue();
            if (!"trace".equals(entry.getKey()) || !(value instanceof j8)) {
                if (!contexts2.containsKey(entry.getKey())) {
                    contexts2.put(entry.getKey(), value);
                }
            }
        }
    }

    private void q(@NotNull i5 i5Var) {
        DebugMeta debugMeta = i5Var.getDebugMeta();
        if (debugMeta == null) {
            debugMeta = new DebugMeta();
        }
        if (debugMeta.getImages() == null) {
            debugMeta.setImages(new ArrayList());
        }
        List<DebugImage> images = debugMeta.getImages();
        if (images != null) {
            String str = (String) io.sentry.cache.h.i(this.f27419b, "proguard-uuid.json", String.class);
            if (str != null) {
                DebugImage debugImage = new DebugImage();
                debugImage.setType(DebugImage.PROGUARD);
                debugImage.setUuid(str);
                images.add(debugImage);
            }
            i5Var.setDebugMeta(debugMeta);
        }
    }

    private void r(@NotNull i5 i5Var) {
        if (i5Var.getContexts().getDevice() == null) {
            i5Var.getContexts().setDevice(f());
        }
    }

    private void s(@NotNull i5 i5Var) {
        String str;
        if (i5Var.getDist() == null) {
            i5Var.setDist((String) io.sentry.cache.h.i(this.f27419b, "dist.json", String.class));
        }
        if (i5Var.getDist() != null || (str = (String) io.sentry.cache.h.i(this.f27419b, "release.json", String.class)) == null) {
            return;
        }
        try {
            i5Var.setDist(str.substring(str.indexOf(43) + 1));
        } catch (Throwable unused) {
            this.f27419b.getLogger().c(SentryLevel.WARNING, "Failed to parse release from scope cache: %s", str);
        }
    }

    private void t(@NotNull i5 i5Var) {
        if (i5Var.getEnvironment() == null) {
            String environment = (String) io.sentry.cache.h.i(this.f27419b, "environment.json", String.class);
            if (environment == null) {
                environment = this.f27419b.getEnvironment();
            }
            i5Var.setEnvironment(environment);
        }
    }

    private void u(@NotNull r6 r6Var, @NotNull Object obj) {
        Mechanism mechanism = new Mechanism();
        if (((io.sentry.hints.c) obj).a()) {
            mechanism.setType("AppExitInfo");
        } else {
            mechanism.setType("HistoricalAppExitInfo");
        }
        String str = "ANR";
        if (i(obj)) {
            str = "Background ANR";
        }
        ApplicationNotResponding applicationNotResponding = new ApplicationNotResponding(str, Thread.currentThread());
        SentryThread sentryThreadE = e(r6Var.o());
        if (sentryThreadE == null) {
            sentryThreadE = new SentryThread();
            sentryThreadE.setStacktrace(new SentryStackTrace());
        }
        r6Var.t(this.f27421d.f(sentryThreadE, mechanism, applicationNotResponding));
    }

    private void v(@NotNull i5 i5Var) {
        Map map = (Map) l(this.f27419b, "extras.json", Map.class);
        if (map == null) {
            return;
        }
        if (i5Var.getExtras() == null) {
            i5Var.setExtras(new HashMap(map));
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (!i5Var.getExtras().containsKey(entry.getKey())) {
                i5Var.getExtras().put((String) entry.getKey(), entry.getValue());
            }
        }
    }

    private void w(@NotNull r6 r6Var, @NotNull Object obj) {
        List<String> list = (List) l(this.f27419b, "fingerprint.json", List.class);
        if (r6Var.k() == null) {
            r6Var.u(list);
        }
        boolean zI = i(obj);
        if (r6Var.k() == null) {
            String[] strArr = new String[2];
            strArr[0] = "{{ default }}";
            strArr[1] = zI ? "background-anr" : "foreground-anr";
            r6Var.u(Arrays.asList(strArr));
        }
    }

    private void x(@NotNull r6 r6Var) {
        SentryLevel sentryLevel = (SentryLevel) l(this.f27419b, "level.json", SentryLevel.class);
        if (r6Var.l() == null) {
            r6Var.v(sentryLevel);
        }
    }

    private void y(@NotNull i5 i5Var) {
        Map map = (Map) io.sentry.cache.h.i(this.f27419b, "tags.json", Map.class);
        if (map == null) {
            return;
        }
        if (i5Var.getTags() == null) {
            i5Var.setTags(new HashMap(map));
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (!i5Var.getTags().containsKey(entry.getKey())) {
                i5Var.setTag((String) entry.getKey(), (String) entry.getValue());
            }
        }
    }

    private void z(@NotNull i5 i5Var) {
        if (i5Var.getPlatform() == null) {
            i5Var.setPlatform(i5.DEFAULT_PLATFORM);
        }
    }

    @Override // io.sentry.g0
    @Nullable
    public r6 a(@NotNull r6 r6Var, @NotNull io.sentry.l0 l0Var) {
        Object objG = io.sentry.util.m.g(l0Var);
        if (!(objG instanceof io.sentry.hints.c)) {
            this.f27419b.getLogger().c(SentryLevel.WARNING, "The event is not Backfillable, but has been passed to BackfillingEventProcessor, skipping.", new Object[0]);
            return r6Var;
        }
        u(r6Var, objG);
        z(r6Var);
        j(r6Var);
        r(r6Var);
        if (!((io.sentry.hints.c) objG).a()) {
            this.f27419b.getLogger().c(SentryLevel.DEBUG, "The event is Backfillable, but should not be enriched, skipping.", new Object[0]);
            return r6Var;
        }
        d(r6Var, objG);
        b(r6Var, objG);
        G(r6Var);
        return r6Var;
    }

    @Override // io.sentry.g0
    @Nullable
    public Long getOrder() {
        return 12000L;
    }

    @Override // io.sentry.g0
    @NotNull
    public SentryTransaction c(@NotNull SentryTransaction sentryTransaction, @NotNull io.sentry.l0 l0Var) {
        return sentryTransaction;
    }
}
