package io.sentry.protocol;

import io.sentry.h2;
import io.sentry.l3;
import io.sentry.m3;
import io.sentry.util.w;
import io.sentry.w0;
import io.sentry.x1;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class Device implements h2 {
    public static final String TYPE = "device";

    @Nullable
    private String[] archs;

    @Nullable
    private Float batteryLevel;

    @Nullable
    private Float batteryTemperature;

    @Nullable
    private Date bootTime;

    @Nullable
    private String brand;

    @Nullable
    private Boolean charging;

    @Nullable
    private String connectionType;

    @Nullable
    private String cpuDescription;

    @Nullable
    private Long externalFreeStorage;

    @Nullable
    private Long externalStorageSize;

    @Nullable
    private String family;

    @Nullable
    private Long freeMemory;

    @Nullable
    private Long freeStorage;

    @Nullable
    private String id;

    @Nullable
    private String locale;

    @Nullable
    private Boolean lowMemory;

    @Nullable
    private String manufacturer;

    @Nullable
    private Long memorySize;

    @Nullable
    private String model;

    @Nullable
    private String modelId;

    @Nullable
    private String name;

    @Nullable
    private Boolean online;

    @Nullable
    private DeviceOrientation orientation;

    @Nullable
    private Integer processorCount;

    @Nullable
    private Double processorFrequency;

    @Nullable
    private Float screenDensity;

    @Nullable
    private Integer screenDpi;

    @Nullable
    private Integer screenHeightPixels;

    @Nullable
    private Integer screenWidthPixels;

    @Nullable
    private Boolean simulator;

    @Nullable
    private Long storageSize;

    @Nullable
    private TimeZone timezone;

    @Nullable
    private Map<String, Object> unknown;

    @Nullable
    private Long usableMemory;

    public static final class Deserializer implements x1<Device> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.sentry.x1
        @NotNull
        public Device deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            String strC;
            l3Var.h();
            Device device = new Device();
            ConcurrentHashMap concurrentHashMap = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strC = l3Var.C();
                strC.hashCode();
                switch (strC) {
                    case "timezone":
                        device.timezone = l3Var.t(w0Var);
                        break;
                    case "boot_time":
                        if (l3Var.peek() != io.sentry.vendor.gson.stream.b.STRING) {
                            break;
                        } else {
                            device.bootTime = l3Var.F(w0Var);
                            break;
                        }
                        break;
                    case "simulator":
                        device.simulator = l3Var.H();
                        break;
                    case "manufacturer":
                        device.manufacturer = l3Var.o0();
                        break;
                    case "processor_count":
                        device.processorCount = l3Var.g0();
                        break;
                    case "orientation":
                        device.orientation = (DeviceOrientation) l3Var.M(w0Var, new DeviceOrientation.Deserializer());
                        break;
                    case "battery_temperature":
                        device.batteryTemperature = l3Var.x0();
                        break;
                    case "family":
                        device.family = l3Var.o0();
                        break;
                    case "locale":
                        device.locale = l3Var.o0();
                        break;
                    case "online":
                        device.online = l3Var.H();
                        break;
                    case "battery_level":
                        device.batteryLevel = l3Var.x0();
                        break;
                    case "model_id":
                        device.modelId = l3Var.o0();
                        break;
                    case "screen_density":
                        device.screenDensity = l3Var.x0();
                        break;
                    case "screen_dpi":
                        device.screenDpi = l3Var.g0();
                        break;
                    case "free_memory":
                        device.freeMemory = l3Var.j0();
                        break;
                    case "id":
                        device.id = l3Var.o0();
                        break;
                    case "name":
                        device.name = l3Var.o0();
                        break;
                    case "low_memory":
                        device.lowMemory = l3Var.H();
                        break;
                    case "archs":
                        List list = (List) l3Var.A0();
                        if (list == null) {
                            break;
                        } else {
                            String[] strArr = new String[list.size()];
                            list.toArray(strArr);
                            device.archs = strArr;
                            break;
                        }
                        break;
                    case "brand":
                        device.brand = l3Var.o0();
                        break;
                    case "model":
                        device.model = l3Var.o0();
                        break;
                    case "cpu_description":
                        device.cpuDescription = l3Var.o0();
                        break;
                    case "processor_frequency":
                        device.processorFrequency = l3Var.A();
                        break;
                    case "connection_type":
                        device.connectionType = l3Var.o0();
                        break;
                    case "screen_width_pixels":
                        device.screenWidthPixels = l3Var.g0();
                        break;
                    case "external_storage_size":
                        device.externalStorageSize = l3Var.j0();
                        break;
                    case "storage_size":
                        device.storageSize = l3Var.j0();
                        break;
                    case "usable_memory":
                        device.usableMemory = l3Var.j0();
                        break;
                    case "memory_size":
                        device.memorySize = l3Var.j0();
                        break;
                    case "charging":
                        device.charging = l3Var.H();
                        break;
                    case "external_free_storage":
                        device.externalFreeStorage = l3Var.j0();
                        break;
                    case "free_storage":
                        device.freeStorage = l3Var.j0();
                        break;
                    case "screen_height_pixels":
                        device.screenHeightPixels = l3Var.g0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        l3Var.r0(w0Var, concurrentHashMap, strC);
                        break;
                }
            }
            device.setUnknown(concurrentHashMap);
            l3Var.k();
            return device;
        }
    }

    public enum DeviceOrientation implements h2 {
        PORTRAIT,
        LANDSCAPE;

        public static final class Deserializer implements x1<DeviceOrientation> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.sentry.x1
            @NotNull
            public DeviceOrientation deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
                return DeviceOrientation.valueOf(l3Var.e0().toUpperCase(Locale.ROOT));
            }
        }

        @Override // io.sentry.h2
        public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
            m3Var.g(toString().toLowerCase(Locale.ROOT));
        }
    }

    public static final class JsonKeys {
        public static final String ARCHS = "archs";
        public static final String BATTERY_LEVEL = "battery_level";
        public static final String BATTERY_TEMPERATURE = "battery_temperature";
        public static final String BOOT_TIME = "boot_time";
        public static final String BRAND = "brand";
        public static final String CHARGING = "charging";
        public static final String CONNECTION_TYPE = "connection_type";
        public static final String CPU_DESCRIPTION = "cpu_description";
        public static final String EXTERNAL_FREE_STORAGE = "external_free_storage";
        public static final String EXTERNAL_STORAGE_SIZE = "external_storage_size";
        public static final String FAMILY = "family";
        public static final String FREE_MEMORY = "free_memory";
        public static final String FREE_STORAGE = "free_storage";
        public static final String ID = "id";
        public static final String LOCALE = "locale";
        public static final String LOW_MEMORY = "low_memory";
        public static final String MANUFACTURER = "manufacturer";
        public static final String MEMORY_SIZE = "memory_size";
        public static final String MODEL = "model";
        public static final String MODEL_ID = "model_id";
        public static final String NAME = "name";
        public static final String ONLINE = "online";
        public static final String ORIENTATION = "orientation";
        public static final String PROCESSOR_COUNT = "processor_count";
        public static final String PROCESSOR_FREQUENCY = "processor_frequency";
        public static final String SCREEN_DENSITY = "screen_density";
        public static final String SCREEN_DPI = "screen_dpi";
        public static final String SCREEN_HEIGHT_PIXELS = "screen_height_pixels";
        public static final String SCREEN_WIDTH_PIXELS = "screen_width_pixels";
        public static final String SIMULATOR = "simulator";
        public static final String STORAGE_SIZE = "storage_size";
        public static final String TIMEZONE = "timezone";
        public static final String USABLE_MEMORY = "usable_memory";
    }

    public Device() {
    }

    Device(@NotNull Device device) {
        this.name = device.name;
        this.manufacturer = device.manufacturer;
        this.brand = device.brand;
        this.family = device.family;
        this.model = device.model;
        this.modelId = device.modelId;
        this.charging = device.charging;
        this.online = device.online;
        this.orientation = device.orientation;
        this.simulator = device.simulator;
        this.memorySize = device.memorySize;
        this.freeMemory = device.freeMemory;
        this.usableMemory = device.usableMemory;
        this.lowMemory = device.lowMemory;
        this.storageSize = device.storageSize;
        this.freeStorage = device.freeStorage;
        this.externalStorageSize = device.externalStorageSize;
        this.externalFreeStorage = device.externalFreeStorage;
        this.screenWidthPixels = device.screenWidthPixels;
        this.screenHeightPixels = device.screenHeightPixels;
        this.screenDensity = device.screenDensity;
        this.screenDpi = device.screenDpi;
        this.bootTime = device.bootTime;
        this.id = device.id;
        this.connectionType = device.connectionType;
        this.batteryTemperature = device.batteryTemperature;
        this.batteryLevel = device.batteryLevel;
        String[] strArr = device.archs;
        this.archs = strArr != null ? (String[]) strArr.clone() : null;
        this.locale = device.locale;
        TimeZone timeZone = device.timezone;
        this.timezone = timeZone != null ? (TimeZone) timeZone.clone() : null;
        this.processorCount = device.processorCount;
        this.processorFrequency = device.processorFrequency;
        this.cpuDescription = device.cpuDescription;
        this.unknown = io.sentry.util.c.b(device.unknown);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Device.class != obj.getClass()) {
            return false;
        }
        Device device = (Device) obj;
        return w.a(this.name, device.name) && w.a(this.manufacturer, device.manufacturer) && w.a(this.brand, device.brand) && w.a(this.family, device.family) && w.a(this.model, device.model) && w.a(this.modelId, device.modelId) && Arrays.equals(this.archs, device.archs) && w.a(this.batteryLevel, device.batteryLevel) && w.a(this.charging, device.charging) && w.a(this.online, device.online) && this.orientation == device.orientation && w.a(this.simulator, device.simulator) && w.a(this.memorySize, device.memorySize) && w.a(this.freeMemory, device.freeMemory) && w.a(this.usableMemory, device.usableMemory) && w.a(this.lowMemory, device.lowMemory) && w.a(this.storageSize, device.storageSize) && w.a(this.freeStorage, device.freeStorage) && w.a(this.externalStorageSize, device.externalStorageSize) && w.a(this.externalFreeStorage, device.externalFreeStorage) && w.a(this.screenWidthPixels, device.screenWidthPixels) && w.a(this.screenHeightPixels, device.screenHeightPixels) && w.a(this.screenDensity, device.screenDensity) && w.a(this.screenDpi, device.screenDpi) && w.a(this.bootTime, device.bootTime) && w.a(this.id, device.id) && w.a(this.locale, device.locale) && w.a(this.connectionType, device.connectionType) && w.a(this.batteryTemperature, device.batteryTemperature) && w.a(this.processorCount, device.processorCount) && w.a(this.processorFrequency, device.processorFrequency) && w.a(this.cpuDescription, device.cpuDescription);
    }

    @Nullable
    public String[] getArchs() {
        return this.archs;
    }

    @Nullable
    public Float getBatteryLevel() {
        return this.batteryLevel;
    }

    @Nullable
    public Float getBatteryTemperature() {
        return this.batteryTemperature;
    }

    @Nullable
    public Date getBootTime() {
        Date date = this.bootTime;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    @Nullable
    public String getBrand() {
        return this.brand;
    }

    @Nullable
    public String getConnectionType() {
        return this.connectionType;
    }

    @Nullable
    public String getCpuDescription() {
        return this.cpuDescription;
    }

    @Nullable
    public Long getExternalFreeStorage() {
        return this.externalFreeStorage;
    }

    @Nullable
    public Long getExternalStorageSize() {
        return this.externalStorageSize;
    }

    @Nullable
    public String getFamily() {
        return this.family;
    }

    @Nullable
    public Long getFreeMemory() {
        return this.freeMemory;
    }

    @Nullable
    public Long getFreeStorage() {
        return this.freeStorage;
    }

    @Nullable
    public String getId() {
        return this.id;
    }

    @Nullable
    public String getLocale() {
        return this.locale;
    }

    @Nullable
    public String getManufacturer() {
        return this.manufacturer;
    }

    @Nullable
    public Long getMemorySize() {
        return this.memorySize;
    }

    @Nullable
    public String getModel() {
        return this.model;
    }

    @Nullable
    public String getModelId() {
        return this.modelId;
    }

    @Nullable
    public String getName() {
        return this.name;
    }

    @Nullable
    public DeviceOrientation getOrientation() {
        return this.orientation;
    }

    @Nullable
    public Integer getProcessorCount() {
        return this.processorCount;
    }

    @Nullable
    public Double getProcessorFrequency() {
        return this.processorFrequency;
    }

    @Nullable
    public Float getScreenDensity() {
        return this.screenDensity;
    }

    @Nullable
    public Integer getScreenDpi() {
        return this.screenDpi;
    }

    @Nullable
    public Integer getScreenHeightPixels() {
        return this.screenHeightPixels;
    }

    @Nullable
    public Integer getScreenWidthPixels() {
        return this.screenWidthPixels;
    }

    @Nullable
    public Long getStorageSize() {
        return this.storageSize;
    }

    @Nullable
    public TimeZone getTimezone() {
        return this.timezone;
    }

    @Nullable
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    @Nullable
    public Long getUsableMemory() {
        return this.usableMemory;
    }

    public int hashCode() {
        return (w.b(this.name, this.manufacturer, this.brand, this.family, this.model, this.modelId, this.batteryLevel, this.charging, this.online, this.orientation, this.simulator, this.memorySize, this.freeMemory, this.usableMemory, this.lowMemory, this.storageSize, this.freeStorage, this.externalStorageSize, this.externalFreeStorage, this.screenWidthPixels, this.screenHeightPixels, this.screenDensity, this.screenDpi, this.bootTime, this.timezone, this.id, this.locale, this.connectionType, this.batteryTemperature, this.processorCount, this.processorFrequency, this.cpuDescription) * 31) + Arrays.hashCode(this.archs);
    }

    @Nullable
    public Boolean isCharging() {
        return this.charging;
    }

    @Nullable
    public Boolean isLowMemory() {
        return this.lowMemory;
    }

    @Nullable
    public Boolean isOnline() {
        return this.online;
    }

    @Nullable
    public Boolean isSimulator() {
        return this.simulator;
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        if (this.name != null) {
            m3Var.e("name").g(this.name);
        }
        if (this.manufacturer != null) {
            m3Var.e(JsonKeys.MANUFACTURER).g(this.manufacturer);
        }
        if (this.brand != null) {
            m3Var.e(JsonKeys.BRAND).g(this.brand);
        }
        if (this.family != null) {
            m3Var.e(JsonKeys.FAMILY).g(this.family);
        }
        if (this.model != null) {
            m3Var.e("model").g(this.model);
        }
        if (this.modelId != null) {
            m3Var.e(JsonKeys.MODEL_ID).g(this.modelId);
        }
        if (this.archs != null) {
            m3Var.e(JsonKeys.ARCHS).o(w0Var, this.archs);
        }
        if (this.batteryLevel != null) {
            m3Var.e(JsonKeys.BATTERY_LEVEL).n(this.batteryLevel);
        }
        if (this.charging != null) {
            m3Var.e(JsonKeys.CHARGING).p(this.charging);
        }
        if (this.online != null) {
            m3Var.e("online").p(this.online);
        }
        if (this.orientation != null) {
            m3Var.e("orientation").o(w0Var, this.orientation);
        }
        if (this.simulator != null) {
            m3Var.e(JsonKeys.SIMULATOR).p(this.simulator);
        }
        if (this.memorySize != null) {
            m3Var.e("memory_size").n(this.memorySize);
        }
        if (this.freeMemory != null) {
            m3Var.e(JsonKeys.FREE_MEMORY).n(this.freeMemory);
        }
        if (this.usableMemory != null) {
            m3Var.e(JsonKeys.USABLE_MEMORY).n(this.usableMemory);
        }
        if (this.lowMemory != null) {
            m3Var.e(JsonKeys.LOW_MEMORY).p(this.lowMemory);
        }
        if (this.storageSize != null) {
            m3Var.e(JsonKeys.STORAGE_SIZE).n(this.storageSize);
        }
        if (this.freeStorage != null) {
            m3Var.e(JsonKeys.FREE_STORAGE).n(this.freeStorage);
        }
        if (this.externalStorageSize != null) {
            m3Var.e(JsonKeys.EXTERNAL_STORAGE_SIZE).n(this.externalStorageSize);
        }
        if (this.externalFreeStorage != null) {
            m3Var.e(JsonKeys.EXTERNAL_FREE_STORAGE).n(this.externalFreeStorage);
        }
        if (this.screenWidthPixels != null) {
            m3Var.e(JsonKeys.SCREEN_WIDTH_PIXELS).n(this.screenWidthPixels);
        }
        if (this.screenHeightPixels != null) {
            m3Var.e(JsonKeys.SCREEN_HEIGHT_PIXELS).n(this.screenHeightPixels);
        }
        if (this.screenDensity != null) {
            m3Var.e(JsonKeys.SCREEN_DENSITY).n(this.screenDensity);
        }
        if (this.screenDpi != null) {
            m3Var.e(JsonKeys.SCREEN_DPI).n(this.screenDpi);
        }
        if (this.bootTime != null) {
            m3Var.e(JsonKeys.BOOT_TIME).o(w0Var, this.bootTime);
        }
        if (this.timezone != null) {
            m3Var.e(JsonKeys.TIMEZONE).o(w0Var, this.timezone);
        }
        if (this.id != null) {
            m3Var.e("id").g(this.id);
        }
        if (this.connectionType != null) {
            m3Var.e(JsonKeys.CONNECTION_TYPE).g(this.connectionType);
        }
        if (this.batteryTemperature != null) {
            m3Var.e(JsonKeys.BATTERY_TEMPERATURE).n(this.batteryTemperature);
        }
        if (this.locale != null) {
            m3Var.e(JsonKeys.LOCALE).g(this.locale);
        }
        if (this.processorCount != null) {
            m3Var.e(JsonKeys.PROCESSOR_COUNT).n(this.processorCount);
        }
        if (this.processorFrequency != null) {
            m3Var.e(JsonKeys.PROCESSOR_FREQUENCY).n(this.processorFrequency);
        }
        if (this.cpuDescription != null) {
            m3Var.e(JsonKeys.CPU_DESCRIPTION).g(this.cpuDescription);
        }
        Map<String, Object> map = this.unknown;
        if (map != null) {
            for (String str : map.keySet()) {
                m3Var.e(str).o(w0Var, this.unknown.get(str));
            }
        }
        m3Var.k();
    }

    public void setArchs(@Nullable String[] strArr) {
        this.archs = strArr;
    }

    public void setBatteryLevel(@Nullable Float f10) {
        this.batteryLevel = f10;
    }

    public void setBatteryTemperature(@Nullable Float f10) {
        this.batteryTemperature = f10;
    }

    public void setBootTime(@Nullable Date date) {
        this.bootTime = date;
    }

    public void setBrand(@Nullable String str) {
        this.brand = str;
    }

    public void setCharging(@Nullable Boolean bool) {
        this.charging = bool;
    }

    public void setConnectionType(@Nullable String str) {
        this.connectionType = str;
    }

    public void setCpuDescription(@Nullable String str) {
        this.cpuDescription = str;
    }

    public void setExternalFreeStorage(@Nullable Long l10) {
        this.externalFreeStorage = l10;
    }

    public void setExternalStorageSize(@Nullable Long l10) {
        this.externalStorageSize = l10;
    }

    public void setFamily(@Nullable String str) {
        this.family = str;
    }

    public void setFreeMemory(@Nullable Long l10) {
        this.freeMemory = l10;
    }

    public void setFreeStorage(@Nullable Long l10) {
        this.freeStorage = l10;
    }

    public void setId(@Nullable String str) {
        this.id = str;
    }

    public void setLocale(@Nullable String str) {
        this.locale = str;
    }

    public void setLowMemory(@Nullable Boolean bool) {
        this.lowMemory = bool;
    }

    public void setManufacturer(@Nullable String str) {
        this.manufacturer = str;
    }

    public void setMemorySize(@Nullable Long l10) {
        this.memorySize = l10;
    }

    public void setModel(@Nullable String str) {
        this.model = str;
    }

    public void setModelId(@Nullable String str) {
        this.modelId = str;
    }

    public void setName(@Nullable String str) {
        this.name = str;
    }

    public void setOnline(@Nullable Boolean bool) {
        this.online = bool;
    }

    public void setOrientation(@Nullable DeviceOrientation deviceOrientation) {
        this.orientation = deviceOrientation;
    }

    public void setProcessorCount(@Nullable Integer num) {
        this.processorCount = num;
    }

    public void setProcessorFrequency(@Nullable Double d10) {
        this.processorFrequency = d10;
    }

    public void setScreenDensity(@Nullable Float f10) {
        this.screenDensity = f10;
    }

    public void setScreenDpi(@Nullable Integer num) {
        this.screenDpi = num;
    }

    public void setScreenHeightPixels(@Nullable Integer num) {
        this.screenHeightPixels = num;
    }

    public void setScreenWidthPixels(@Nullable Integer num) {
        this.screenWidthPixels = num;
    }

    public void setSimulator(@Nullable Boolean bool) {
        this.simulator = bool;
    }

    public void setStorageSize(@Nullable Long l10) {
        this.storageSize = l10;
    }

    public void setTimezone(@Nullable TimeZone timeZone) {
        this.timezone = timeZone;
    }

    public void setUnknown(@Nullable Map<String, Object> map) {
        this.unknown = map;
    }

    public void setUsableMemory(@Nullable Long l10) {
        this.usableMemory = l10;
    }
}
