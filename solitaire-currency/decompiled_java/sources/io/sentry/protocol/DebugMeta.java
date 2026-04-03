package io.sentry.protocol;

import io.sentry.SentryOptions;
import io.sentry.h2;
import io.sentry.l3;
import io.sentry.m3;
import io.sentry.protocol.DebugImage;
import io.sentry.protocol.SdkInfo;
import io.sentry.w0;
import io.sentry.x1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class DebugMeta implements h2 {

    @Nullable
    private List<DebugImage> images;

    @Nullable
    private SdkInfo sdkInfo;

    @Nullable
    private Map<String, Object> unknown;

    public static final class Deserializer implements x1<DebugMeta> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.sentry.x1
        @NotNull
        public DebugMeta deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            DebugMeta debugMeta = new DebugMeta();
            l3Var.h();
            HashMap map = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                String strC = l3Var.C();
                strC.hashCode();
                if (strC.equals(JsonKeys.IMAGES)) {
                    debugMeta.images = l3Var.D0(w0Var, new DebugImage.Deserializer());
                } else if (strC.equals(JsonKeys.SDK_INFO)) {
                    debugMeta.sdkInfo = (SdkInfo) l3Var.M(w0Var, new SdkInfo.Deserializer());
                } else {
                    if (map == null) {
                        map = new HashMap();
                    }
                    l3Var.r0(w0Var, map, strC);
                }
            }
            l3Var.k();
            debugMeta.setUnknown(map);
            return debugMeta;
        }
    }

    public static final class JsonKeys {
        public static final String IMAGES = "images";
        public static final String SDK_INFO = "sdk_info";
    }

    @ApiStatus.Internal
    @Nullable
    public static DebugMeta buildDebugMeta(@Nullable DebugMeta debugMeta, @NotNull SentryOptions sentryOptions) {
        ArrayList arrayList = new ArrayList();
        if (sentryOptions.getProguardUuid() != null) {
            DebugImage debugImage = new DebugImage();
            debugImage.setType(DebugImage.PROGUARD);
            debugImage.setUuid(sentryOptions.getProguardUuid());
            arrayList.add(debugImage);
        }
        for (String str : sentryOptions.getBundleIds()) {
            DebugImage debugImage2 = new DebugImage();
            debugImage2.setType(DebugImage.JVM);
            debugImage2.setDebugId(str);
            arrayList.add(debugImage2);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (debugMeta == null) {
            debugMeta = new DebugMeta();
        }
        if (debugMeta.getImages() == null) {
            debugMeta.setImages(arrayList);
        } else {
            debugMeta.getImages().addAll(arrayList);
        }
        return debugMeta;
    }

    @Nullable
    public List<DebugImage> getImages() {
        return this.images;
    }

    @Nullable
    public SdkInfo getSdkInfo() {
        return this.sdkInfo;
    }

    @Nullable
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        if (this.sdkInfo != null) {
            m3Var.e(JsonKeys.SDK_INFO).o(w0Var, this.sdkInfo);
        }
        if (this.images != null) {
            m3Var.e(JsonKeys.IMAGES).o(w0Var, this.images);
        }
        Map<String, Object> map = this.unknown;
        if (map != null) {
            for (String str : map.keySet()) {
                m3Var.e(str).o(w0Var, this.unknown.get(str));
            }
        }
        m3Var.k();
    }

    public void setImages(@Nullable List<DebugImage> list) {
        this.images = list != null ? new ArrayList(list) : null;
    }

    public void setSdkInfo(@Nullable SdkInfo sdkInfo) {
        this.sdkInfo = sdkInfo;
    }

    public void setUnknown(@Nullable Map<String, Object> map) {
        this.unknown = map;
    }
}
