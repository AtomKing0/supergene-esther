package io.sentry.protocol;

import io.sentry.h2;
import io.sentry.l3;
import io.sentry.m3;
import io.sentry.w0;
import io.sentry.x1;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class SentryRuntime implements h2 {
    public static final String TYPE = "runtime";

    @Nullable
    private String name;

    @Nullable
    private String rawDescription;

    @Nullable
    private Map<String, Object> unknown;

    @Nullable
    private String version;

    public static final class Deserializer implements x1<SentryRuntime> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.sentry.x1
        @NotNull
        public SentryRuntime deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            String strC;
            l3Var.h();
            SentryRuntime sentryRuntime = new SentryRuntime();
            ConcurrentHashMap concurrentHashMap = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strC = l3Var.C();
                strC.hashCode();
                switch (strC) {
                    case "raw_description":
                        sentryRuntime.rawDescription = l3Var.o0();
                        break;
                    case "name":
                        sentryRuntime.name = l3Var.o0();
                        break;
                    case "version":
                        sentryRuntime.version = l3Var.o0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        l3Var.r0(w0Var, concurrentHashMap, strC);
                        break;
                }
            }
            sentryRuntime.setUnknown(concurrentHashMap);
            l3Var.k();
            return sentryRuntime;
        }
    }

    public static final class JsonKeys {
        public static final String NAME = "name";
        public static final String RAW_DESCRIPTION = "raw_description";
        public static final String VERSION = "version";
    }

    public SentryRuntime() {
    }

    SentryRuntime(@NotNull SentryRuntime sentryRuntime) {
        this.name = sentryRuntime.name;
        this.version = sentryRuntime.version;
        this.rawDescription = sentryRuntime.rawDescription;
        this.unknown = io.sentry.util.c.b(sentryRuntime.unknown);
    }

    @Nullable
    public String getName() {
        return this.name;
    }

    @Nullable
    public String getRawDescription() {
        return this.rawDescription;
    }

    @Nullable
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    @Nullable
    public String getVersion() {
        return this.version;
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        if (this.name != null) {
            m3Var.e("name").g(this.name);
        }
        if (this.version != null) {
            m3Var.e("version").g(this.version);
        }
        if (this.rawDescription != null) {
            m3Var.e("raw_description").g(this.rawDescription);
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

    public void setName(@Nullable String str) {
        this.name = str;
    }

    public void setRawDescription(@Nullable String str) {
        this.rawDescription = str;
    }

    public void setUnknown(@Nullable Map<String, Object> map) {
        this.unknown = map;
    }

    public void setVersion(@Nullable String str) {
        this.version = str;
    }
}
