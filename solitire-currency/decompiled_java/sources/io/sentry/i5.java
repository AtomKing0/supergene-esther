package io.sentry;

import com.unity3d.services.core.di.ServiceProvider;
import io.sentry.Breadcrumb;
import io.sentry.protocol.Contexts;
import io.sentry.protocol.DebugMeta;
import io.sentry.protocol.Request;
import io.sentry.protocol.SdkVersion;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentrySpan;
import io.sentry.protocol.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SentryBaseEvent.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class i5 {
    public static final String DEFAULT_PLATFORM = "java";

    @Nullable
    private List<Breadcrumb> breadcrumbs;

    @NotNull
    private final Contexts contexts;

    @Nullable
    private DebugMeta debugMeta;

    @Nullable
    private String dist;

    @Nullable
    private String environment;

    @Nullable
    private SentryId eventId;

    @Nullable
    private Map<String, Object> extra;

    @Nullable
    private String platform;

    @Nullable
    private String release;

    @Nullable
    private Request request;

    @Nullable
    private SdkVersion sdk;

    @Nullable
    private String serverName;

    @Nullable
    private Map<String, String> tags;

    @Nullable
    protected transient Throwable throwable;

    @Nullable
    private User user;

    /* JADX INFO: compiled from: SentryBaseEvent.java */
    public static final class a {
        public boolean a(@NotNull i5 i5Var, @NotNull String str, @NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            str.hashCode();
            switch (str) {
                case "debug_meta":
                    i5Var.debugMeta = (DebugMeta) l3Var.M(w0Var, new DebugMeta.Deserializer());
                    return true;
                case "server_name":
                    i5Var.serverName = l3Var.o0();
                    return true;
                case "contexts":
                    i5Var.contexts.putAll(new Contexts.Deserializer().deserialize(l3Var, w0Var));
                    return true;
                case "environment":
                    i5Var.environment = l3Var.o0();
                    return true;
                case "breadcrumbs":
                    i5Var.breadcrumbs = l3Var.D0(w0Var, new Breadcrumb.a());
                    return true;
                case "sdk":
                    i5Var.sdk = (SdkVersion) l3Var.M(w0Var, new SdkVersion.Deserializer());
                    return true;
                case "dist":
                    i5Var.dist = l3Var.o0();
                    return true;
                case "tags":
                    i5Var.tags = io.sentry.util.c.b((Map) l3Var.A0());
                    return true;
                case "user":
                    i5Var.user = (User) l3Var.M(w0Var, new User.Deserializer());
                    return true;
                case "extra":
                    i5Var.extra = io.sentry.util.c.b((Map) l3Var.A0());
                    return true;
                case "event_id":
                    i5Var.eventId = (SentryId) l3Var.M(w0Var, new SentryId.Deserializer());
                    return true;
                case "release":
                    i5Var.release = l3Var.o0();
                    return true;
                case "request":
                    i5Var.request = (Request) l3Var.M(w0Var, new Request.Deserializer());
                    return true;
                case "platform":
                    i5Var.platform = l3Var.o0();
                    return true;
                default:
                    return false;
            }
        }
    }

    /* JADX INFO: compiled from: SentryBaseEvent.java */
    public static final class b {
        public void a(@NotNull i5 i5Var, @NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
            if (i5Var.eventId != null) {
                m3Var.e("event_id").o(w0Var, i5Var.eventId);
            }
            m3Var.e("contexts").o(w0Var, i5Var.contexts);
            if (i5Var.sdk != null) {
                m3Var.e(ServiceProvider.NAMED_SDK).o(w0Var, i5Var.sdk);
            }
            if (i5Var.request != null) {
                m3Var.e(com.vungle.ads.internal.ui.a.REQUEST_KEY_EXTRA).o(w0Var, i5Var.request);
            }
            if (i5Var.tags != null && !i5Var.tags.isEmpty()) {
                m3Var.e(SentrySpan.JsonKeys.TAGS).o(w0Var, i5Var.tags);
            }
            if (i5Var.release != null) {
                m3Var.e("release").g(i5Var.release);
            }
            if (i5Var.environment != null) {
                m3Var.e("environment").g(i5Var.environment);
            }
            if (i5Var.platform != null) {
                m3Var.e("platform").g(i5Var.platform);
            }
            if (i5Var.user != null) {
                m3Var.e("user").o(w0Var, i5Var.user);
            }
            if (i5Var.serverName != null) {
                m3Var.e("server_name").g(i5Var.serverName);
            }
            if (i5Var.dist != null) {
                m3Var.e("dist").g(i5Var.dist);
            }
            if (i5Var.breadcrumbs != null && !i5Var.breadcrumbs.isEmpty()) {
                m3Var.e("breadcrumbs").o(w0Var, i5Var.breadcrumbs);
            }
            if (i5Var.debugMeta != null) {
                m3Var.e("debug_meta").o(w0Var, i5Var.debugMeta);
            }
            if (i5Var.extra == null || i5Var.extra.isEmpty()) {
                return;
            }
            m3Var.e("extra").o(w0Var, i5Var.extra);
        }
    }

    protected i5(@NotNull SentryId sentryId) {
        this.contexts = new Contexts();
        this.eventId = sentryId;
    }

    public void addBreadcrumb(@NotNull Breadcrumb breadcrumb) {
        if (this.breadcrumbs == null) {
            this.breadcrumbs = new ArrayList();
        }
        this.breadcrumbs.add(breadcrumb);
    }

    @Nullable
    public List<Breadcrumb> getBreadcrumbs() {
        return this.breadcrumbs;
    }

    @NotNull
    public Contexts getContexts() {
        return this.contexts;
    }

    @Nullable
    public DebugMeta getDebugMeta() {
        return this.debugMeta;
    }

    @Nullable
    public String getDist() {
        return this.dist;
    }

    @Nullable
    public String getEnvironment() {
        return this.environment;
    }

    @Nullable
    public SentryId getEventId() {
        return this.eventId;
    }

    @Nullable
    public Object getExtra(@Nullable String str) {
        Map<String, Object> map = this.extra;
        if (map == null || str == null) {
            return null;
        }
        return map.get(str);
    }

    @Nullable
    public Map<String, Object> getExtras() {
        return this.extra;
    }

    @Nullable
    public String getPlatform() {
        return this.platform;
    }

    @Nullable
    public String getRelease() {
        return this.release;
    }

    @Nullable
    public Request getRequest() {
        return this.request;
    }

    @Nullable
    public SdkVersion getSdk() {
        return this.sdk;
    }

    @Nullable
    public String getServerName() {
        return this.serverName;
    }

    @Nullable
    public String getTag(@Nullable String str) {
        Map<String, String> map = this.tags;
        if (map == null || str == null) {
            return null;
        }
        return map.get(str);
    }

    @ApiStatus.Internal
    @Nullable
    public Map<String, String> getTags() {
        return this.tags;
    }

    @Nullable
    public Throwable getThrowable() {
        Throwable th = this.throwable;
        return th instanceof io.sentry.exception.a ? ((io.sentry.exception.a) th).c() : th;
    }

    @ApiStatus.Internal
    @Nullable
    public Throwable getThrowableMechanism() {
        return this.throwable;
    }

    @Nullable
    public User getUser() {
        return this.user;
    }

    public void removeExtra(@Nullable String str) {
        Map<String, Object> map = this.extra;
        if (map == null || str == null) {
            return;
        }
        map.remove(str);
    }

    public void removeTag(@Nullable String str) {
        Map<String, String> map = this.tags;
        if (map == null || str == null) {
            return;
        }
        map.remove(str);
    }

    public void setBreadcrumbs(@Nullable List<Breadcrumb> list) {
        this.breadcrumbs = io.sentry.util.c.a(list);
    }

    public void setDebugMeta(@Nullable DebugMeta debugMeta) {
        this.debugMeta = debugMeta;
    }

    public void setDist(@Nullable String str) {
        this.dist = str;
    }

    public void setEnvironment(@Nullable String str) {
        this.environment = str;
    }

    public void setEventId(@Nullable SentryId sentryId) {
        this.eventId = sentryId;
    }

    public void setExtra(@Nullable String str, @Nullable Object obj) {
        if (this.extra == null) {
            this.extra = new HashMap();
        }
        if (str == null) {
            return;
        }
        if (obj == null) {
            removeExtra(str);
        } else {
            this.extra.put(str, obj);
        }
    }

    public void setExtras(@Nullable Map<String, Object> map) {
        this.extra = io.sentry.util.c.c(map);
    }

    public void setPlatform(@Nullable String str) {
        this.platform = str;
    }

    public void setRelease(@Nullable String str) {
        this.release = str;
    }

    public void setRequest(@Nullable Request request) {
        this.request = request;
    }

    public void setSdk(@Nullable SdkVersion sdkVersion) {
        this.sdk = sdkVersion;
    }

    public void setServerName(@Nullable String str) {
        this.serverName = str;
    }

    public void setTag(@Nullable String str, @Nullable String str2) {
        if (this.tags == null) {
            this.tags = new HashMap();
        }
        if (str == null) {
            return;
        }
        if (str2 == null) {
            removeTag(str);
        } else {
            this.tags.put(str, str2);
        }
    }

    public void setTags(@Nullable Map<String, String> map) {
        this.tags = io.sentry.util.c.c(map);
    }

    public void setThrowable(@Nullable Throwable th) {
        this.throwable = th;
    }

    public void setUser(@Nullable User user) {
        this.user = user;
    }

    protected i5() {
        this(new SentryId());
    }

    public void addBreadcrumb(@Nullable String str) {
        addBreadcrumb(new Breadcrumb(str));
    }
}
