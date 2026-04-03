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
public final class Gpu implements h2 {
    public static final String TYPE = "gpu";

    @Nullable
    private String apiType;

    @Nullable
    private Integer id;

    @Nullable
    private Integer memorySize;

    @Nullable
    private Boolean multiThreadedRendering;

    @Nullable
    private String name;

    @Nullable
    private String npotSupport;

    @Nullable
    private Map<String, Object> unknown;

    @Nullable
    private String vendorId;

    @Nullable
    private String vendorName;

    @Nullable
    private String version;

    public static final class Deserializer implements x1<Gpu> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.sentry.x1
        @NotNull
        public Gpu deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            String strC;
            l3Var.h();
            Gpu gpu = new Gpu();
            ConcurrentHashMap concurrentHashMap = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strC = l3Var.C();
                strC.hashCode();
                switch (strC) {
                    case "npot_support":
                        gpu.npotSupport = l3Var.o0();
                        break;
                    case "vendor_id":
                        gpu.vendorId = l3Var.o0();
                        break;
                    case "multi_threaded_rendering":
                        gpu.multiThreadedRendering = l3Var.H();
                        break;
                    case "id":
                        gpu.id = l3Var.g0();
                        break;
                    case "name":
                        gpu.name = l3Var.o0();
                        break;
                    case "vendor_name":
                        gpu.vendorName = l3Var.o0();
                        break;
                    case "version":
                        gpu.version = l3Var.o0();
                        break;
                    case "api_type":
                        gpu.apiType = l3Var.o0();
                        break;
                    case "memory_size":
                        gpu.memorySize = l3Var.g0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        l3Var.r0(w0Var, concurrentHashMap, strC);
                        break;
                }
            }
            gpu.setUnknown(concurrentHashMap);
            l3Var.k();
            return gpu;
        }
    }

    public static final class JsonKeys {
        public static final String API_TYPE = "api_type";
        public static final String ID = "id";
        public static final String MEMORY_SIZE = "memory_size";
        public static final String MULTI_THREADED_RENDERING = "multi_threaded_rendering";
        public static final String NAME = "name";
        public static final String NPOT_SUPPORT = "npot_support";
        public static final String VENDOR_ID = "vendor_id";
        public static final String VENDOR_NAME = "vendor_name";
        public static final String VERSION = "version";
    }

    public Gpu() {
    }

    Gpu(@NotNull Gpu gpu) {
        this.name = gpu.name;
        this.id = gpu.id;
        this.vendorId = gpu.vendorId;
        this.vendorName = gpu.vendorName;
        this.memorySize = gpu.memorySize;
        this.apiType = gpu.apiType;
        this.multiThreadedRendering = gpu.multiThreadedRendering;
        this.version = gpu.version;
        this.npotSupport = gpu.npotSupport;
        this.unknown = io.sentry.util.c.b(gpu.unknown);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Gpu.class != obj.getClass()) {
            return false;
        }
        Gpu gpu = (Gpu) obj;
        return w.a(this.name, gpu.name) && w.a(this.id, gpu.id) && w.a(this.vendorId, gpu.vendorId) && w.a(this.vendorName, gpu.vendorName) && w.a(this.memorySize, gpu.memorySize) && w.a(this.apiType, gpu.apiType) && w.a(this.multiThreadedRendering, gpu.multiThreadedRendering) && w.a(this.version, gpu.version) && w.a(this.npotSupport, gpu.npotSupport);
    }

    @Nullable
    public String getApiType() {
        return this.apiType;
    }

    @Nullable
    public Integer getId() {
        return this.id;
    }

    @Nullable
    public Integer getMemorySize() {
        return this.memorySize;
    }

    @Nullable
    public String getName() {
        return this.name;
    }

    @Nullable
    public String getNpotSupport() {
        return this.npotSupport;
    }

    @Nullable
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    @Nullable
    public String getVendorId() {
        return this.vendorId;
    }

    @Nullable
    public String getVendorName() {
        return this.vendorName;
    }

    @Nullable
    public String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return w.b(this.name, this.id, this.vendorId, this.vendorName, this.memorySize, this.apiType, this.multiThreadedRendering, this.version, this.npotSupport);
    }

    @Nullable
    public Boolean isMultiThreadedRendering() {
        return this.multiThreadedRendering;
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        if (this.name != null) {
            m3Var.e("name").g(this.name);
        }
        if (this.id != null) {
            m3Var.e("id").n(this.id);
        }
        if (this.vendorId != null) {
            m3Var.e(JsonKeys.VENDOR_ID).g(this.vendorId);
        }
        if (this.vendorName != null) {
            m3Var.e(JsonKeys.VENDOR_NAME).g(this.vendorName);
        }
        if (this.memorySize != null) {
            m3Var.e("memory_size").n(this.memorySize);
        }
        if (this.apiType != null) {
            m3Var.e(JsonKeys.API_TYPE).g(this.apiType);
        }
        if (this.multiThreadedRendering != null) {
            m3Var.e(JsonKeys.MULTI_THREADED_RENDERING).p(this.multiThreadedRendering);
        }
        if (this.version != null) {
            m3Var.e("version").g(this.version);
        }
        if (this.npotSupport != null) {
            m3Var.e(JsonKeys.NPOT_SUPPORT).g(this.npotSupport);
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

    public void setApiType(@Nullable String str) {
        this.apiType = str;
    }

    public void setId(Integer num) {
        this.id = num;
    }

    public void setMemorySize(@Nullable Integer num) {
        this.memorySize = num;
    }

    public void setMultiThreadedRendering(@Nullable Boolean bool) {
        this.multiThreadedRendering = bool;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNpotSupport(@Nullable String str) {
        this.npotSupport = str;
    }

    public void setUnknown(@Nullable Map<String, Object> map) {
        this.unknown = map;
    }

    public void setVendorId(@Nullable String str) {
        this.vendorId = str;
    }

    public void setVendorName(@Nullable String str) {
        this.vendorName = str;
    }

    public void setVersion(@Nullable String str) {
        this.version = str;
    }
}
