package io.sentry.protocol;

import com.google.android.gms.common.Scopes;
import io.sentry.h2;
import io.sentry.j8;
import io.sentry.k1;
import io.sentry.l3;
import io.sentry.m3;
import io.sentry.protocol.App;
import io.sentry.protocol.Browser;
import io.sentry.protocol.Device;
import io.sentry.protocol.Feedback;
import io.sentry.protocol.Gpu;
import io.sentry.protocol.OperatingSystem;
import io.sentry.protocol.Response;
import io.sentry.protocol.SentryRuntime;
import io.sentry.protocol.Spring;
import io.sentry.u3;
import io.sentry.util.m;
import io.sentry.util.w;
import io.sentry.w0;
import io.sentry.x1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class Contexts implements h2 {
    public static final String REPLAY_ID = "replay_id";
    private static final long serialVersionUID = 252445813254943011L;

    @NotNull
    private final ConcurrentHashMap<String, Object> internalStorage = new ConcurrentHashMap<>();

    @NotNull
    protected final io.sentry.util.a responseLock = new io.sentry.util.a();

    public static final class Deserializer implements x1<Contexts> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.sentry.x1
        @NotNull
        public Contexts deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            String strC;
            Contexts contexts = new Contexts();
            l3Var.h();
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strC = l3Var.C();
                strC.hashCode();
                switch (strC) {
                    case "device":
                        contexts.setDevice(new Device.Deserializer().deserialize(l3Var, w0Var));
                        break;
                    case "spring":
                        contexts.setSpring(new Spring.Deserializer().deserialize(l3Var, w0Var));
                        break;
                    case "response":
                        contexts.setResponse(new Response.Deserializer().deserialize(l3Var, w0Var));
                        break;
                    case "profile":
                        contexts.setProfile(new u3.a().deserialize(l3Var, w0Var));
                        break;
                    case "feedback":
                        contexts.setFeedback(new Feedback.Deserializer().deserialize(l3Var, w0Var));
                        break;
                    case "os":
                        contexts.setOperatingSystem(new OperatingSystem.Deserializer().deserialize(l3Var, w0Var));
                        break;
                    case "app":
                        contexts.setApp(new App.Deserializer().deserialize(l3Var, w0Var));
                        break;
                    case "gpu":
                        contexts.setGpu(new Gpu.Deserializer().deserialize(l3Var, w0Var));
                        break;
                    case "trace":
                        contexts.setTrace(new j8.a().deserialize(l3Var, w0Var));
                        break;
                    case "browser":
                        contexts.setBrowser(new Browser.Deserializer().deserialize(l3Var, w0Var));
                        break;
                    case "runtime":
                        contexts.setRuntime(new SentryRuntime.Deserializer().deserialize(l3Var, w0Var));
                        break;
                    default:
                        Object objA0 = l3Var.A0();
                        if (objA0 == null) {
                            break;
                        } else {
                            contexts.put(strC, objA0);
                            break;
                        }
                        break;
                }
            }
            l3Var.k();
            return contexts;
        }
    }

    public Contexts() {
    }

    @Nullable
    private <T> T toContextType(@NotNull String str, @NotNull Class<T> cls) {
        Object obj = get(str);
        if (cls.isInstance(obj)) {
            return cls.cast(obj);
        }
        return null;
    }

    public boolean containsKey(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        return this.internalStorage.containsKey(obj);
    }

    @NotNull
    public Set<Map.Entry<String, Object>> entrySet() {
        return this.internalStorage.entrySet();
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null || !(obj instanceof Contexts)) {
            return false;
        }
        return this.internalStorage.equals(((Contexts) obj).internalStorage);
    }

    @Nullable
    public Object get(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        return this.internalStorage.get(obj);
    }

    @Nullable
    public App getApp() {
        return (App) toContextType(App.TYPE, App.class);
    }

    @Nullable
    public Browser getBrowser() {
        return (Browser) toContextType(Browser.TYPE, Browser.class);
    }

    @Nullable
    public Device getDevice() {
        return (Device) toContextType("device", Device.class);
    }

    @Nullable
    public Feedback getFeedback() {
        return (Feedback) toContextType(Feedback.TYPE, Feedback.class);
    }

    @Nullable
    public Gpu getGpu() {
        return (Gpu) toContextType(Gpu.TYPE, Gpu.class);
    }

    @Nullable
    public OperatingSystem getOperatingSystem() {
        return (OperatingSystem) toContextType("os", OperatingSystem.class);
    }

    @Nullable
    public u3 getProfile() {
        return (u3) toContextType(Scopes.PROFILE, u3.class);
    }

    @Nullable
    public Response getResponse() {
        return (Response) toContextType("response", Response.class);
    }

    @Nullable
    public SentryRuntime getRuntime() {
        return (SentryRuntime) toContextType(SentryRuntime.TYPE, SentryRuntime.class);
    }

    public int getSize() {
        return size();
    }

    @Nullable
    public Spring getSpring() {
        return (Spring) toContextType(Spring.TYPE, Spring.class);
    }

    @Nullable
    public j8 getTrace() {
        return (j8) toContextType("trace", j8.class);
    }

    public int hashCode() {
        return this.internalStorage.hashCode();
    }

    public boolean isEmpty() {
        return this.internalStorage.isEmpty();
    }

    @NotNull
    public Enumeration<String> keys() {
        return this.internalStorage.keys();
    }

    @Nullable
    public Object put(@Nullable String str, @Nullable Object obj) {
        if (str == null) {
            return null;
        }
        return obj == null ? this.internalStorage.remove(str) : this.internalStorage.put(str, obj);
    }

    public void putAll(@Nullable Map<? extends String, ? extends Object> map) {
        if (map == null) {
            return;
        }
        HashMap map2 = new HashMap();
        for (Map.Entry<? extends String, ? extends Object> entry : map.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                map2.put(entry.getKey(), entry.getValue());
            }
        }
        this.internalStorage.putAll(map2);
    }

    @Nullable
    public Object remove(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        return this.internalStorage.remove(obj);
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        ArrayList<String> list = Collections.list(keys());
        Collections.sort(list);
        for (String str : list) {
            Object obj = get(str);
            if (obj != null) {
                m3Var.e(str).o(w0Var, obj);
            }
        }
        m3Var.k();
    }

    @Nullable
    public Object set(@Nullable String str, @Nullable Object obj) {
        return put(str, obj);
    }

    public void setApp(@NotNull App app) {
        put(App.TYPE, app);
    }

    public void setBrowser(@NotNull Browser browser) {
        put(Browser.TYPE, browser);
    }

    public void setDevice(@NotNull Device device) {
        put("device", device);
    }

    public void setFeedback(@NotNull Feedback feedback) {
        put(Feedback.TYPE, feedback);
    }

    public void setGpu(@NotNull Gpu gpu) {
        put(Gpu.TYPE, gpu);
    }

    public void setOperatingSystem(@NotNull OperatingSystem operatingSystem) {
        put("os", operatingSystem);
    }

    public void setProfile(@Nullable u3 u3Var) {
        w.c(u3Var, "profileContext is required");
        put(Scopes.PROFILE, u3Var);
    }

    public void setResponse(@NotNull Response response) {
        k1 k1VarA = this.responseLock.a();
        try {
            put("response", response);
            if (k1VarA != null) {
                k1VarA.close();
            }
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

    public void setRuntime(@NotNull SentryRuntime sentryRuntime) {
        put(SentryRuntime.TYPE, sentryRuntime);
    }

    public void setSpring(@NotNull Spring spring) {
        put(Spring.TYPE, spring);
    }

    public void setTrace(@NotNull j8 j8Var) {
        w.c(j8Var, "traceContext is required");
        put("trace", j8Var);
    }

    public int size() {
        return this.internalStorage.size();
    }

    public void withResponse(m.a<Response> aVar) {
        k1 k1VarA = this.responseLock.a();
        try {
            Response response = getResponse();
            if (response != null) {
                aVar.accept(response);
            } else {
                Response response2 = new Response();
                setResponse(response2);
                aVar.accept(response2);
            }
            if (k1VarA != null) {
                k1VarA.close();
            }
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

    public Contexts(@NotNull Contexts contexts) {
        for (Map.Entry<String, Object> entry : contexts.entrySet()) {
            if (entry != null) {
                Object value = entry.getValue();
                if (App.TYPE.equals(entry.getKey()) && (value instanceof App)) {
                    setApp(new App((App) value));
                } else if (Browser.TYPE.equals(entry.getKey()) && (value instanceof Browser)) {
                    setBrowser(new Browser((Browser) value));
                } else if ("device".equals(entry.getKey()) && (value instanceof Device)) {
                    setDevice(new Device((Device) value));
                } else if ("os".equals(entry.getKey()) && (value instanceof OperatingSystem)) {
                    setOperatingSystem(new OperatingSystem((OperatingSystem) value));
                } else if (SentryRuntime.TYPE.equals(entry.getKey()) && (value instanceof SentryRuntime)) {
                    setRuntime(new SentryRuntime((SentryRuntime) value));
                } else if (Feedback.TYPE.equals(entry.getKey()) && (value instanceof Feedback)) {
                    setFeedback(new Feedback((Feedback) value));
                } else if (Gpu.TYPE.equals(entry.getKey()) && (value instanceof Gpu)) {
                    setGpu(new Gpu((Gpu) value));
                } else if ("trace".equals(entry.getKey()) && (value instanceof j8)) {
                    setTrace(new j8((j8) value));
                } else if (Scopes.PROFILE.equals(entry.getKey()) && (value instanceof u3)) {
                    setProfile(new u3((u3) value));
                } else if ("response".equals(entry.getKey()) && (value instanceof Response)) {
                    setResponse(new Response((Response) value));
                } else if (Spring.TYPE.equals(entry.getKey()) && (value instanceof Spring)) {
                    setSpring(new Spring((Spring) value));
                } else {
                    put(entry.getKey(), value);
                }
            }
        }
    }

    public void putAll(@Nullable Contexts contexts) {
        if (contexts == null) {
            return;
        }
        this.internalStorage.putAll(contexts.internalStorage);
    }
}
