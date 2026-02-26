package io.sentry.protocol;

import io.sentry.h2;
import io.sentry.l3;
import io.sentry.m3;
import io.sentry.w0;
import io.sentry.x1;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class SdkInfo implements h2 {

    @Nullable
    private String sdkName;

    @Nullable
    private Map<String, Object> unknown;

    @Nullable
    private Integer versionMajor;

    @Nullable
    private Integer versionMinor;

    @Nullable
    private Integer versionPatchlevel;

    public static final class Deserializer implements x1<SdkInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.sentry.x1
        @NotNull
        public SdkInfo deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            String strC;
            SdkInfo sdkInfo = new SdkInfo();
            l3Var.h();
            HashMap map = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strC = l3Var.C();
                strC.hashCode();
                switch (strC) {
                    case "sdk_name":
                        sdkInfo.sdkName = l3Var.o0();
                        break;
                    case "version_patchlevel":
                        sdkInfo.versionPatchlevel = l3Var.g0();
                        break;
                    case "version_major":
                        sdkInfo.versionMajor = l3Var.g0();
                        break;
                    case "version_minor":
                        sdkInfo.versionMinor = l3Var.g0();
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
            sdkInfo.setUnknown(map);
            return sdkInfo;
        }
    }

    public static final class JsonKeys {
        public static final String SDK_NAME = "sdk_name";
        public static final String VERSION_MAJOR = "version_major";
        public static final String VERSION_MINOR = "version_minor";
        public static final String VERSION_PATCHLEVEL = "version_patchlevel";
    }

    @Nullable
    public String getSdkName() {
        return this.sdkName;
    }

    @Nullable
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    @Nullable
    public Integer getVersionMajor() {
        return this.versionMajor;
    }

    @Nullable
    public Integer getVersionMinor() {
        return this.versionMinor;
    }

    @Nullable
    public Integer getVersionPatchlevel() {
        return this.versionPatchlevel;
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        if (this.sdkName != null) {
            m3Var.e(JsonKeys.SDK_NAME).g(this.sdkName);
        }
        if (this.versionMajor != null) {
            m3Var.e(JsonKeys.VERSION_MAJOR).n(this.versionMajor);
        }
        if (this.versionMinor != null) {
            m3Var.e(JsonKeys.VERSION_MINOR).n(this.versionMinor);
        }
        if (this.versionPatchlevel != null) {
            m3Var.e(JsonKeys.VERSION_PATCHLEVEL).n(this.versionPatchlevel);
        }
        Map<String, Object> map = this.unknown;
        if (map != null) {
            for (String str : map.keySet()) {
                m3Var.e(str).o(w0Var, this.unknown.get(str));
            }
        }
        m3Var.k();
    }

    public void setSdkName(@Nullable String str) {
        this.sdkName = str;
    }

    public void setUnknown(@Nullable Map<String, Object> map) {
        this.unknown = map;
    }

    public void setVersionMajor(@Nullable Integer num) {
        this.versionMajor = num;
    }

    public void setVersionMinor(@Nullable Integer num) {
        this.versionMinor = num;
    }

    public void setVersionPatchlevel(@Nullable Integer num) {
        this.versionPatchlevel = num;
    }
}
