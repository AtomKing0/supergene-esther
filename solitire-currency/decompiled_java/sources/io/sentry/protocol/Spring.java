package io.sentry.protocol;

import io.sentry.h2;
import io.sentry.l3;
import io.sentry.m3;
import io.sentry.w0;
import io.sentry.x1;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class Spring implements h2 {
    public static final String TYPE = "spring";

    @Nullable
    private String[] activeProfiles;

    @Nullable
    private Map<String, Object> unknown;

    public static final class Deserializer implements x1<Spring> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.sentry.x1
        @NotNull
        public Spring deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            l3Var.h();
            Spring spring = new Spring();
            ConcurrentHashMap concurrentHashMap = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                String strC = l3Var.C();
                strC.hashCode();
                if (strC.equals(JsonKeys.ACTIVE_PROFILES)) {
                    List list = (List) l3Var.A0();
                    if (list != null) {
                        String[] strArr = new String[list.size()];
                        list.toArray(strArr);
                        spring.activeProfiles = strArr;
                    }
                } else {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    l3Var.r0(w0Var, concurrentHashMap, strC);
                }
            }
            spring.setUnknown(concurrentHashMap);
            l3Var.k();
            return spring;
        }
    }

    public static final class JsonKeys {
        public static final String ACTIVE_PROFILES = "active_profiles";
    }

    public Spring() {
    }

    public Spring(@NotNull Spring spring) {
        this.activeProfiles = spring.activeProfiles;
        this.unknown = io.sentry.util.c.b(spring.unknown);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Spring.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.activeProfiles, ((Spring) obj).activeProfiles);
    }

    @Nullable
    public String[] getActiveProfiles() {
        return this.activeProfiles;
    }

    @Nullable
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    public int hashCode() {
        return Arrays.hashCode(this.activeProfiles);
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        if (this.activeProfiles != null) {
            m3Var.e(JsonKeys.ACTIVE_PROFILES).o(w0Var, this.activeProfiles);
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

    public void setActiveProfiles(@Nullable String[] strArr) {
        this.activeProfiles = strArr;
    }

    public void setUnknown(@Nullable Map<String, Object> map) {
        this.unknown = map;
    }
}
