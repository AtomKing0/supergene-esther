package io.sentry.protocol;

import io.sentry.h2;
import io.sentry.l3;
import io.sentry.m3;
import io.sentry.protocol.Mechanism;
import io.sentry.protocol.SentryStackTrace;
import io.sentry.w0;
import io.sentry.x1;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class SentryException implements h2 {

    @Nullable
    private Mechanism mechanism;

    @Nullable
    private String module;

    @Nullable
    private SentryStackTrace stacktrace;

    @Nullable
    private Long threadId;

    @Nullable
    private String type;

    @Nullable
    private Map<String, Object> unknown;

    @Nullable
    private String value;

    public static final class Deserializer implements x1<SentryException> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.sentry.x1
        @NotNull
        public SentryException deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            String strC;
            SentryException sentryException = new SentryException();
            l3Var.h();
            HashMap map = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strC = l3Var.C();
                strC.hashCode();
                switch (strC) {
                    case "thread_id":
                        sentryException.threadId = l3Var.j0();
                        break;
                    case "module":
                        sentryException.module = l3Var.o0();
                        break;
                    case "type":
                        sentryException.type = l3Var.o0();
                        break;
                    case "value":
                        sentryException.value = l3Var.o0();
                        break;
                    case "mechanism":
                        sentryException.mechanism = (Mechanism) l3Var.M(w0Var, new Mechanism.Deserializer());
                        break;
                    case "stacktrace":
                        sentryException.stacktrace = (SentryStackTrace) l3Var.M(w0Var, new SentryStackTrace.Deserializer());
                        break;
                    default:
                        if (map == null) {
                            map = new HashMap();
                        }
                        l3Var.r0(w0Var, map, strC);
                        break;
                }
            }
            l3Var.k();
            sentryException.setUnknown(map);
            return sentryException;
        }
    }

    public static final class JsonKeys {
        public static final String MECHANISM = "mechanism";
        public static final String MODULE = "module";
        public static final String STACKTRACE = "stacktrace";
        public static final String THREAD_ID = "thread_id";
        public static final String TYPE = "type";
        public static final String VALUE = "value";
    }

    @Nullable
    public Mechanism getMechanism() {
        return this.mechanism;
    }

    @Nullable
    public String getModule() {
        return this.module;
    }

    @Nullable
    public SentryStackTrace getStacktrace() {
        return this.stacktrace;
    }

    @Nullable
    public Long getThreadId() {
        return this.threadId;
    }

    @Nullable
    public String getType() {
        return this.type;
    }

    @Nullable
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    @Nullable
    public String getValue() {
        return this.value;
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        if (this.type != null) {
            m3Var.e("type").g(this.type);
        }
        if (this.value != null) {
            m3Var.e("value").g(this.value);
        }
        if (this.module != null) {
            m3Var.e("module").g(this.module);
        }
        if (this.threadId != null) {
            m3Var.e(JsonKeys.THREAD_ID).n(this.threadId);
        }
        if (this.stacktrace != null) {
            m3Var.e("stacktrace").o(w0Var, this.stacktrace);
        }
        if (this.mechanism != null) {
            m3Var.e(JsonKeys.MECHANISM).o(w0Var, this.mechanism);
        }
        Map<String, Object> map = this.unknown;
        if (map != null) {
            for (String str : map.keySet()) {
                m3Var.e(str).o(w0Var, this.unknown.get(str));
            }
        }
        m3Var.k();
    }

    public void setMechanism(@Nullable Mechanism mechanism) {
        this.mechanism = mechanism;
    }

    public void setModule(@Nullable String str) {
        this.module = str;
    }

    public void setStacktrace(@Nullable SentryStackTrace sentryStackTrace) {
        this.stacktrace = sentryStackTrace;
    }

    public void setThreadId(@Nullable Long l10) {
        this.threadId = l10;
    }

    public void setType(@Nullable String str) {
        this.type = str;
    }

    public void setUnknown(@Nullable Map<String, Object> map) {
        this.unknown = map;
    }

    public void setValue(@Nullable String str) {
        this.value = str;
    }
}
