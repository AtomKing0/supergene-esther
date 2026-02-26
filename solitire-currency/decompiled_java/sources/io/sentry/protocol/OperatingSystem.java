package io.sentry.protocol;

import io.sentry.h2;
import io.sentry.l3;
import io.sentry.m3;
import io.sentry.util.w;
import io.sentry.w0;
import io.sentry.x1;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class OperatingSystem implements h2 {
    public static final String TYPE = "os";

    @Nullable
    private String build;

    @Nullable
    private String kernelVersion;

    @Nullable
    private String name;

    @Nullable
    private String rawDescription;

    @Nullable
    private Boolean rooted;

    @Nullable
    private Map<String, Object> unknown;

    @Nullable
    private String version;

    public static final class Deserializer implements x1<OperatingSystem> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.sentry.x1
        @NotNull
        public OperatingSystem deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            String strC;
            l3Var.h();
            OperatingSystem operatingSystem = new OperatingSystem();
            ConcurrentHashMap concurrentHashMap = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strC = l3Var.C();
                strC.hashCode();
                switch (strC) {
                    case "rooted":
                        operatingSystem.rooted = l3Var.H();
                        break;
                    case "raw_description":
                        operatingSystem.rawDescription = l3Var.o0();
                        break;
                    case "name":
                        operatingSystem.name = l3Var.o0();
                        break;
                    case "build":
                        operatingSystem.build = l3Var.o0();
                        break;
                    case "version":
                        operatingSystem.version = l3Var.o0();
                        break;
                    case "kernel_version":
                        operatingSystem.kernelVersion = l3Var.o0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        l3Var.r0(w0Var, concurrentHashMap, strC);
                        break;
                }
            }
            operatingSystem.setUnknown(concurrentHashMap);
            l3Var.k();
            return operatingSystem;
        }
    }

    public static final class JsonKeys {
        public static final String BUILD = "build";
        public static final String KERNEL_VERSION = "kernel_version";
        public static final String NAME = "name";
        public static final String RAW_DESCRIPTION = "raw_description";
        public static final String ROOTED = "rooted";
        public static final String VERSION = "version";
    }

    public OperatingSystem() {
    }

    OperatingSystem(@NotNull OperatingSystem operatingSystem) {
        this.name = operatingSystem.name;
        this.version = operatingSystem.version;
        this.rawDescription = operatingSystem.rawDescription;
        this.build = operatingSystem.build;
        this.kernelVersion = operatingSystem.kernelVersion;
        this.rooted = operatingSystem.rooted;
        this.unknown = io.sentry.util.c.b(operatingSystem.unknown);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || OperatingSystem.class != obj.getClass()) {
            return false;
        }
        OperatingSystem operatingSystem = (OperatingSystem) obj;
        return w.a(this.name, operatingSystem.name) && w.a(this.version, operatingSystem.version) && w.a(this.rawDescription, operatingSystem.rawDescription) && w.a(this.build, operatingSystem.build) && w.a(this.kernelVersion, operatingSystem.kernelVersion) && w.a(this.rooted, operatingSystem.rooted);
    }

    @Nullable
    public String getBuild() {
        return this.build;
    }

    @Nullable
    public String getKernelVersion() {
        return this.kernelVersion;
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

    public int hashCode() {
        return w.b(this.name, this.version, this.rawDescription, this.build, this.kernelVersion, this.rooted);
    }

    @Nullable
    public Boolean isRooted() {
        return this.rooted;
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
        if (this.build != null) {
            m3Var.e(JsonKeys.BUILD).g(this.build);
        }
        if (this.kernelVersion != null) {
            m3Var.e(JsonKeys.KERNEL_VERSION).g(this.kernelVersion);
        }
        if (this.rooted != null) {
            m3Var.e(JsonKeys.ROOTED).p(this.rooted);
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

    public void setBuild(@Nullable String str) {
        this.build = str;
    }

    public void setKernelVersion(@Nullable String str) {
        this.kernelVersion = str;
    }

    public void setName(@Nullable String str) {
        this.name = str;
    }

    public void setRawDescription(@Nullable String str) {
        this.rawDescription = str;
    }

    public void setRooted(@Nullable Boolean bool) {
        this.rooted = bool;
    }

    public void setUnknown(@Nullable Map<String, Object> map) {
        this.unknown = map;
    }

    public void setVersion(@Nullable String str) {
        this.version = str;
    }
}
