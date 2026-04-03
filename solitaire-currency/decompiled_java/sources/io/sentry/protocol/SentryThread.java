package io.sentry.protocol;

import io.sentry.c7;
import io.sentry.h2;
import io.sentry.l3;
import io.sentry.m3;
import io.sentry.protocol.SentryStackTrace;
import io.sentry.w0;
import io.sentry.x1;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class SentryThread implements h2 {

    @Nullable
    private Boolean crashed;

    @Nullable
    private Boolean current;

    @Nullable
    private Boolean daemon;

    @Nullable
    private Map<String, c7> heldLocks;

    @Nullable
    private Long id;

    @Nullable
    private Boolean main;

    @Nullable
    private String name;

    @Nullable
    private Integer priority;

    @Nullable
    private SentryStackTrace stacktrace;

    @Nullable
    private String state;

    @Nullable
    private Map<String, Object> unknown;

    public static final class Deserializer implements x1<SentryThread> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.sentry.x1
        @NotNull
        public SentryThread deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            String strC;
            SentryThread sentryThread = new SentryThread();
            l3Var.h();
            ConcurrentHashMap concurrentHashMap = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strC = l3Var.C();
                strC.hashCode();
                switch (strC) {
                    case "daemon":
                        sentryThread.daemon = l3Var.H();
                        break;
                    case "priority":
                        sentryThread.priority = l3Var.g0();
                        break;
                    case "held_locks":
                        Map mapQ0 = l3Var.q0(w0Var, new c7.a());
                        if (mapQ0 == null) {
                            break;
                        } else {
                            sentryThread.heldLocks = new HashMap(mapQ0);
                            break;
                        }
                        break;
                    case "id":
                        sentryThread.id = l3Var.j0();
                        break;
                    case "main":
                        sentryThread.main = l3Var.H();
                        break;
                    case "name":
                        sentryThread.name = l3Var.o0();
                        break;
                    case "state":
                        sentryThread.state = l3Var.o0();
                        break;
                    case "crashed":
                        sentryThread.crashed = l3Var.H();
                        break;
                    case "current":
                        sentryThread.current = l3Var.H();
                        break;
                    case "stacktrace":
                        sentryThread.stacktrace = (SentryStackTrace) l3Var.M(w0Var, new SentryStackTrace.Deserializer());
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        l3Var.r0(w0Var, concurrentHashMap, strC);
                        break;
                }
            }
            sentryThread.setUnknown(concurrentHashMap);
            l3Var.k();
            return sentryThread;
        }
    }

    public static final class JsonKeys {
        public static final String CRASHED = "crashed";
        public static final String CURRENT = "current";
        public static final String DAEMON = "daemon";
        public static final String HELD_LOCKS = "held_locks";
        public static final String ID = "id";
        public static final String MAIN = "main";
        public static final String NAME = "name";
        public static final String PRIORITY = "priority";
        public static final String STACKTRACE = "stacktrace";
        public static final String STATE = "state";
    }

    @Nullable
    public Map<String, c7> getHeldLocks() {
        return this.heldLocks;
    }

    @Nullable
    public Long getId() {
        return this.id;
    }

    @Nullable
    public String getName() {
        return this.name;
    }

    @Nullable
    public Integer getPriority() {
        return this.priority;
    }

    @Nullable
    public SentryStackTrace getStacktrace() {
        return this.stacktrace;
    }

    @Nullable
    public String getState() {
        return this.state;
    }

    @Nullable
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    @Nullable
    public Boolean isCrashed() {
        return this.crashed;
    }

    @Nullable
    public Boolean isCurrent() {
        return this.current;
    }

    @Nullable
    public Boolean isDaemon() {
        return this.daemon;
    }

    @Nullable
    public Boolean isMain() {
        return this.main;
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        if (this.id != null) {
            m3Var.e("id").n(this.id);
        }
        if (this.priority != null) {
            m3Var.e("priority").n(this.priority);
        }
        if (this.name != null) {
            m3Var.e("name").g(this.name);
        }
        if (this.state != null) {
            m3Var.e("state").g(this.state);
        }
        if (this.crashed != null) {
            m3Var.e(JsonKeys.CRASHED).p(this.crashed);
        }
        if (this.current != null) {
            m3Var.e(JsonKeys.CURRENT).p(this.current);
        }
        if (this.daemon != null) {
            m3Var.e(JsonKeys.DAEMON).p(this.daemon);
        }
        if (this.main != null) {
            m3Var.e("main").p(this.main);
        }
        if (this.stacktrace != null) {
            m3Var.e("stacktrace").o(w0Var, this.stacktrace);
        }
        if (this.heldLocks != null) {
            m3Var.e(JsonKeys.HELD_LOCKS).o(w0Var, this.heldLocks);
        }
        Map<String, Object> map = this.unknown;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.unknown.get(str);
                m3Var.e(str);
                m3Var.o(w0Var, obj);
            }
        }
        m3Var.k();
    }

    public void setCrashed(@Nullable Boolean bool) {
        this.crashed = bool;
    }

    public void setCurrent(@Nullable Boolean bool) {
        this.current = bool;
    }

    public void setDaemon(@Nullable Boolean bool) {
        this.daemon = bool;
    }

    public void setHeldLocks(@Nullable Map<String, c7> map) {
        this.heldLocks = map;
    }

    public void setId(@Nullable Long l10) {
        this.id = l10;
    }

    public void setMain(@Nullable Boolean bool) {
        this.main = bool;
    }

    public void setName(@Nullable String str) {
        this.name = str;
    }

    public void setPriority(@Nullable Integer num) {
        this.priority = num;
    }

    public void setStacktrace(@Nullable SentryStackTrace sentryStackTrace) {
        this.stacktrace = sentryStackTrace;
    }

    public void setState(@Nullable String str) {
        this.state = str;
    }

    public void setUnknown(@Nullable Map<String, Object> map) {
        this.unknown = map;
    }
}
