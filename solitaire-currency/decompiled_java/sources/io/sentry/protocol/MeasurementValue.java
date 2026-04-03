package io.sentry.protocol;

import io.sentry.SentryLevel;
import io.sentry.h2;
import io.sentry.l3;
import io.sentry.m3;
import io.sentry.w0;
import io.sentry.x1;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.TestOnly;

/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class MeasurementValue implements h2 {
    public static final String KEY_APP_START_COLD = "app_start_cold";
    public static final String KEY_APP_START_WARM = "app_start_warm";
    public static final String KEY_FRAMES_DELAY = "frames_delay";
    public static final String KEY_FRAMES_FROZEN = "frames_frozen";
    public static final String KEY_FRAMES_SLOW = "frames_slow";
    public static final String KEY_FRAMES_TOTAL = "frames_total";
    public static final String KEY_TIME_TO_FULL_DISPLAY = "time_to_full_display";
    public static final String KEY_TIME_TO_INITIAL_DISPLAY = "time_to_initial_display";

    @Nullable
    private final String unit;

    @Nullable
    private Map<String, Object> unknown;

    @NotNull
    private final Number value;

    public static final class Deserializer implements x1<MeasurementValue> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.sentry.x1
        @NotNull
        public MeasurementValue deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            l3Var.h();
            Number number = null;
            String strO0 = null;
            ConcurrentHashMap concurrentHashMap = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                String strC = l3Var.C();
                strC.hashCode();
                if (strC.equals(JsonKeys.UNIT)) {
                    strO0 = l3Var.o0();
                } else if (strC.equals("value")) {
                    number = (Number) l3Var.A0();
                } else {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    l3Var.r0(w0Var, concurrentHashMap, strC);
                }
            }
            l3Var.k();
            if (number != null) {
                MeasurementValue measurementValue = new MeasurementValue(number, strO0);
                measurementValue.setUnknown(concurrentHashMap);
                return measurementValue;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"value\"");
            w0Var.b(SentryLevel.ERROR, "Missing required field \"value\"", illegalStateException);
            throw illegalStateException;
        }
    }

    public static final class JsonKeys {
        public static final String UNIT = "unit";
        public static final String VALUE = "value";
    }

    public MeasurementValue(@NotNull Number number, @Nullable String str) {
        this.value = number;
        this.unit = str;
    }

    @Nullable
    public String getUnit() {
        return this.unit;
    }

    @Nullable
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    @TestOnly
    @NotNull
    public Number getValue() {
        return this.value;
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        m3Var.e("value").n(this.value);
        if (this.unit != null) {
            m3Var.e(JsonKeys.UNIT).g(this.unit);
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

    public void setUnknown(@Nullable Map<String, Object> map) {
        this.unknown = map;
    }

    @TestOnly
    public MeasurementValue(@NotNull Number number, @Nullable String str, @Nullable Map<String, Object> map) {
        this.value = number;
        this.unit = str;
        this.unknown = map;
    }
}
