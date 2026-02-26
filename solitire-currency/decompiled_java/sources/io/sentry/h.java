package io.sentry;

import io.sentry.protocol.App;
import io.sentry.protocol.Browser;
import io.sentry.protocol.Contexts;
import io.sentry.protocol.Device;
import io.sentry.protocol.Gpu;
import io.sentry.protocol.OperatingSystem;
import io.sentry.protocol.Response;
import io.sentry.protocol.SentryRuntime;
import io.sentry.protocol.Spring;
import io.sentry.util.m;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CombinedContextsView.java */
/* JADX INFO: loaded from: classes5.dex */
public final class h extends Contexts {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Contexts f27842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final Contexts f27843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final Contexts f27844c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final h4 f27845d;

    /* JADX INFO: compiled from: CombinedContextsView.java */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f27846a;

        static {
            int[] iArr = new int[h4.values().length];
            f27846a = iArr;
            try {
                iArr[h4.CURRENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f27846a[h4.ISOLATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f27846a[h4.GLOBAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public h(@NotNull Contexts contexts, @NotNull Contexts contexts2, @NotNull Contexts contexts3, @NotNull h4 h4Var) {
        this.f27842a = contexts;
        this.f27843b = contexts2;
        this.f27844c = contexts3;
        this.f27845d = h4Var;
    }

    @NotNull
    private Contexts a() {
        int i10 = a.f27846a[this.f27845d.ordinal()];
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? this.f27844c : this.f27842a : this.f27843b : this.f27844c;
    }

    @NotNull
    private Contexts b() {
        Contexts contexts = new Contexts();
        contexts.putAll(this.f27842a);
        contexts.putAll(this.f27843b);
        contexts.putAll(this.f27844c);
        return contexts;
    }

    @Override // io.sentry.protocol.Contexts
    public boolean containsKey(@Nullable Object obj) {
        return this.f27842a.containsKey(obj) || this.f27843b.containsKey(obj) || this.f27844c.containsKey(obj);
    }

    @Override // io.sentry.protocol.Contexts
    @NotNull
    public Set<Map.Entry<String, Object>> entrySet() {
        return b().entrySet();
    }

    @Override // io.sentry.protocol.Contexts
    @Nullable
    public Object get(@Nullable Object obj) {
        Object obj2 = this.f27844c.get(obj);
        if (obj2 != null) {
            return obj2;
        }
        Object obj3 = this.f27843b.get(obj);
        return obj3 != null ? obj3 : this.f27842a.get(obj);
    }

    @Override // io.sentry.protocol.Contexts
    @Nullable
    public App getApp() {
        App app = this.f27844c.getApp();
        if (app != null) {
            return app;
        }
        App app2 = this.f27843b.getApp();
        return app2 != null ? app2 : this.f27842a.getApp();
    }

    @Override // io.sentry.protocol.Contexts
    @Nullable
    public Browser getBrowser() {
        Browser browser = this.f27844c.getBrowser();
        if (browser != null) {
            return browser;
        }
        Browser browser2 = this.f27843b.getBrowser();
        return browser2 != null ? browser2 : this.f27842a.getBrowser();
    }

    @Override // io.sentry.protocol.Contexts
    @Nullable
    public Device getDevice() {
        Device device = this.f27844c.getDevice();
        if (device != null) {
            return device;
        }
        Device device2 = this.f27843b.getDevice();
        return device2 != null ? device2 : this.f27842a.getDevice();
    }

    @Override // io.sentry.protocol.Contexts
    @Nullable
    public Gpu getGpu() {
        Gpu gpu = this.f27844c.getGpu();
        if (gpu != null) {
            return gpu;
        }
        Gpu gpu2 = this.f27843b.getGpu();
        return gpu2 != null ? gpu2 : this.f27842a.getGpu();
    }

    @Override // io.sentry.protocol.Contexts
    @Nullable
    public OperatingSystem getOperatingSystem() {
        OperatingSystem operatingSystem = this.f27844c.getOperatingSystem();
        if (operatingSystem != null) {
            return operatingSystem;
        }
        OperatingSystem operatingSystem2 = this.f27843b.getOperatingSystem();
        return operatingSystem2 != null ? operatingSystem2 : this.f27842a.getOperatingSystem();
    }

    @Override // io.sentry.protocol.Contexts
    @Nullable
    public Response getResponse() {
        Response response = this.f27844c.getResponse();
        if (response != null) {
            return response;
        }
        Response response2 = this.f27843b.getResponse();
        return response2 != null ? response2 : this.f27842a.getResponse();
    }

    @Override // io.sentry.protocol.Contexts
    @Nullable
    public SentryRuntime getRuntime() {
        SentryRuntime runtime = this.f27844c.getRuntime();
        if (runtime != null) {
            return runtime;
        }
        SentryRuntime runtime2 = this.f27843b.getRuntime();
        return runtime2 != null ? runtime2 : this.f27842a.getRuntime();
    }

    @Override // io.sentry.protocol.Contexts
    public int getSize() {
        return size();
    }

    @Override // io.sentry.protocol.Contexts
    @Nullable
    public Spring getSpring() {
        Spring spring = this.f27844c.getSpring();
        if (spring != null) {
            return spring;
        }
        Spring spring2 = this.f27843b.getSpring();
        return spring2 != null ? spring2 : this.f27842a.getSpring();
    }

    @Override // io.sentry.protocol.Contexts
    @Nullable
    public j8 getTrace() {
        j8 trace = this.f27844c.getTrace();
        if (trace != null) {
            return trace;
        }
        j8 trace2 = this.f27843b.getTrace();
        return trace2 != null ? trace2 : this.f27842a.getTrace();
    }

    @Override // io.sentry.protocol.Contexts
    public boolean isEmpty() {
        return this.f27842a.isEmpty() && this.f27843b.isEmpty() && this.f27844c.isEmpty();
    }

    @Override // io.sentry.protocol.Contexts
    @NotNull
    public Enumeration<String> keys() {
        return b().keys();
    }

    @Override // io.sentry.protocol.Contexts
    @Nullable
    public Object put(@Nullable String str, @Nullable Object obj) {
        return a().put(str, obj);
    }

    @Override // io.sentry.protocol.Contexts
    public void putAll(@Nullable Map<? extends String, ?> map) {
        a().putAll((Map<? extends String, ? extends Object>) map);
    }

    @Override // io.sentry.protocol.Contexts
    @Nullable
    public Object remove(@Nullable Object obj) {
        return a().remove(obj);
    }

    @Override // io.sentry.protocol.Contexts, io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        b().serialize(m3Var, w0Var);
    }

    @Override // io.sentry.protocol.Contexts
    @Nullable
    public Object set(@Nullable String str, @Nullable Object obj) {
        return put(str, obj);
    }

    @Override // io.sentry.protocol.Contexts
    public void setApp(@NotNull App app) {
        a().setApp(app);
    }

    @Override // io.sentry.protocol.Contexts
    public void setBrowser(@NotNull Browser browser) {
        a().setBrowser(browser);
    }

    @Override // io.sentry.protocol.Contexts
    public void setDevice(@NotNull Device device) {
        a().setDevice(device);
    }

    @Override // io.sentry.protocol.Contexts
    public void setGpu(@NotNull Gpu gpu) {
        a().setGpu(gpu);
    }

    @Override // io.sentry.protocol.Contexts
    public void setOperatingSystem(@NotNull OperatingSystem operatingSystem) {
        a().setOperatingSystem(operatingSystem);
    }

    @Override // io.sentry.protocol.Contexts
    public void setResponse(@NotNull Response response) {
        a().setResponse(response);
    }

    @Override // io.sentry.protocol.Contexts
    public void setRuntime(@NotNull SentryRuntime sentryRuntime) {
        a().setRuntime(sentryRuntime);
    }

    @Override // io.sentry.protocol.Contexts
    public void setSpring(@NotNull Spring spring) {
        a().setSpring(spring);
    }

    @Override // io.sentry.protocol.Contexts
    public void setTrace(@NotNull j8 j8Var) {
        a().setTrace(j8Var);
    }

    @Override // io.sentry.protocol.Contexts
    public int size() {
        return b().size();
    }

    @Override // io.sentry.protocol.Contexts
    public void withResponse(m.a<Response> aVar) {
        if (this.f27844c.getResponse() != null) {
            this.f27844c.withResponse(aVar);
            return;
        }
        if (this.f27843b.getResponse() != null) {
            this.f27843b.withResponse(aVar);
        } else if (this.f27842a.getResponse() != null) {
            this.f27842a.withResponse(aVar);
        } else {
            a().withResponse(aVar);
        }
    }

    @Override // io.sentry.protocol.Contexts
    public void putAll(@Nullable Contexts contexts) {
        a().putAll(contexts);
    }
}
