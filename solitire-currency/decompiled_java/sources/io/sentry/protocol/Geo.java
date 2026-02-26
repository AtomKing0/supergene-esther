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
public final class Geo implements h2 {

    @Nullable
    private String city;

    @Nullable
    private String countryCode;

    @Nullable
    private String region;

    @Nullable
    private Map<String, Object> unknown;

    public static final class Deserializer implements x1<Geo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.sentry.x1
        @NotNull
        public Geo deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            String strC;
            l3Var.h();
            Geo geo = new Geo();
            ConcurrentHashMap concurrentHashMap = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strC = l3Var.C();
                strC.hashCode();
                switch (strC) {
                    case "region":
                        geo.region = l3Var.o0();
                        break;
                    case "city":
                        geo.city = l3Var.o0();
                        break;
                    case "country_code":
                        geo.countryCode = l3Var.o0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        l3Var.r0(w0Var, concurrentHashMap, strC);
                        break;
                }
            }
            geo.setUnknown(concurrentHashMap);
            l3Var.k();
            return geo;
        }
    }

    public static final class JsonKeys {
        public static final String CITY = "city";
        public static final String COUNTRY_CODE = "country_code";
        public static final String REGION = "region";
    }

    public Geo() {
    }

    public Geo(@NotNull Geo geo) {
        this.city = geo.city;
        this.countryCode = geo.countryCode;
        this.region = geo.region;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static Geo fromMap(@NotNull Map<String, Object> map) {
        Geo geo = new Geo();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            String key = entry.getKey();
            key.hashCode();
            byte b10 = -1;
            switch (key.hashCode()) {
                case -934795532:
                    if (key.equals("region")) {
                        b10 = 0;
                    }
                    break;
                case 3053931:
                    if (key.equals(JsonKeys.CITY)) {
                        b10 = 1;
                    }
                    break;
                case 1481071862:
                    if (key.equals(JsonKeys.COUNTRY_CODE)) {
                        b10 = 2;
                    }
                    break;
            }
            switch (b10) {
                case 0:
                    geo.region = value instanceof String ? (String) value : null;
                    break;
                case 1:
                    geo.city = value instanceof String ? (String) value : null;
                    break;
                case 2:
                    geo.countryCode = value instanceof String ? (String) value : null;
                    break;
            }
        }
        return geo;
    }

    @Nullable
    public String getCity() {
        return this.city;
    }

    @Nullable
    public String getCountryCode() {
        return this.countryCode;
    }

    @Nullable
    public String getRegion() {
        return this.region;
    }

    @Nullable
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        if (this.city != null) {
            m3Var.e(JsonKeys.CITY).g(this.city);
        }
        if (this.countryCode != null) {
            m3Var.e(JsonKeys.COUNTRY_CODE).g(this.countryCode);
        }
        if (this.region != null) {
            m3Var.e("region").g(this.region);
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

    public void setCity(@Nullable String str) {
        this.city = str;
    }

    public void setCountryCode(@Nullable String str) {
        this.countryCode = str;
    }

    public void setRegion(@Nullable String str) {
        this.region = str;
    }

    public void setUnknown(@Nullable Map<String, Object> map) {
        this.unknown = map;
    }
}
