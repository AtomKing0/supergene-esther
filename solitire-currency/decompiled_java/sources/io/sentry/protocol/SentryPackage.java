package io.sentry.protocol;

import io.sentry.SentryLevel;
import io.sentry.h2;
import io.sentry.l3;
import io.sentry.m3;
import io.sentry.util.w;
import io.sentry.w0;
import io.sentry.x1;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class SentryPackage implements h2 {

    @NotNull
    private String name;

    @Nullable
    private Map<String, Object> unknown;

    @NotNull
    private String version;

    public static final class Deserializer implements x1<SentryPackage> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.sentry.x1
        @NotNull
        public SentryPackage deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            l3Var.h();
            String strE0 = null;
            String strE02 = null;
            HashMap map = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                String strC = l3Var.C();
                strC.hashCode();
                if (strC.equals("name")) {
                    strE0 = l3Var.e0();
                } else if (strC.equals("version")) {
                    strE02 = l3Var.e0();
                } else {
                    if (map == null) {
                        map = new HashMap();
                    }
                    l3Var.r0(w0Var, map, strC);
                }
            }
            l3Var.k();
            if (strE0 == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"name\"");
                w0Var.b(SentryLevel.ERROR, "Missing required field \"name\"", illegalStateException);
                throw illegalStateException;
            }
            if (strE02 != null) {
                SentryPackage sentryPackage = new SentryPackage(strE0, strE02);
                sentryPackage.setUnknown(map);
                return sentryPackage;
            }
            IllegalStateException illegalStateException2 = new IllegalStateException("Missing required field \"version\"");
            w0Var.b(SentryLevel.ERROR, "Missing required field \"version\"", illegalStateException2);
            throw illegalStateException2;
        }
    }

    public static final class JsonKeys {
        public static final String NAME = "name";
        public static final String VERSION = "version";
    }

    public SentryPackage(@NotNull String str, @NotNull String str2) {
        this.name = (String) w.c(str, "name is required.");
        this.version = (String) w.c(str2, "version is required.");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SentryPackage.class != obj.getClass()) {
            return false;
        }
        SentryPackage sentryPackage = (SentryPackage) obj;
        return Objects.equals(this.name, sentryPackage.name) && Objects.equals(this.version, sentryPackage.version);
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    @Nullable
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    @NotNull
    public String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return Objects.hash(this.name, this.version);
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        m3Var.e("name").g(this.name);
        m3Var.e("version").g(this.version);
        Map<String, Object> map = this.unknown;
        if (map != null) {
            for (String str : map.keySet()) {
                m3Var.e(str).o(w0Var, this.unknown.get(str));
            }
        }
        m3Var.k();
    }

    public void setName(@NotNull String str) {
        this.name = (String) w.c(str, "name is required.");
    }

    public void setUnknown(@Nullable Map<String, Object> map) {
        this.unknown = map;
    }

    public void setVersion(@NotNull String str) {
        this.version = (String) w.c(str, "version is required.");
    }
}
