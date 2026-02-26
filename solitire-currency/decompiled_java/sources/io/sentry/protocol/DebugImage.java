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
public final class DebugImage implements h2 {
    public static final String JVM = "jvm";
    public static final String PROGUARD = "proguard";

    @Nullable
    private String arch;

    @Nullable
    private String codeFile;

    @Nullable
    private String codeId;

    @Nullable
    private String debugFile;

    @Nullable
    private String debugId;

    @Nullable
    private String imageAddr;

    @Nullable
    private Long imageSize;

    @Nullable
    private String type;

    @Nullable
    private Map<String, Object> unknown;

    @Nullable
    private String uuid;

    public static final class Deserializer implements x1<DebugImage> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.sentry.x1
        @NotNull
        public DebugImage deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            String strC;
            DebugImage debugImage = new DebugImage();
            l3Var.h();
            HashMap map = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strC = l3Var.C();
                strC.hashCode();
                switch (strC) {
                    case "debug_file":
                        debugImage.debugFile = l3Var.o0();
                        break;
                    case "image_addr":
                        debugImage.imageAddr = l3Var.o0();
                        break;
                    case "image_size":
                        debugImage.imageSize = l3Var.j0();
                        break;
                    case "code_file":
                        debugImage.codeFile = l3Var.o0();
                        break;
                    case "arch":
                        debugImage.arch = l3Var.o0();
                        break;
                    case "type":
                        debugImage.type = l3Var.o0();
                        break;
                    case "uuid":
                        debugImage.uuid = l3Var.o0();
                        break;
                    case "debug_id":
                        debugImage.debugId = l3Var.o0();
                        break;
                    case "code_id":
                        debugImage.codeId = l3Var.o0();
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
            debugImage.setUnknown(map);
            return debugImage;
        }
    }

    public static final class JsonKeys {
        public static final String ARCH = "arch";
        public static final String CODE_FILE = "code_file";
        public static final String CODE_ID = "code_id";
        public static final String DEBUG_FILE = "debug_file";
        public static final String DEBUG_ID = "debug_id";
        public static final String IMAGE_ADDR = "image_addr";
        public static final String IMAGE_SIZE = "image_size";
        public static final String TYPE = "type";
        public static final String UUID = "uuid";
    }

    @Nullable
    public String getArch() {
        return this.arch;
    }

    @Nullable
    public String getCodeFile() {
        return this.codeFile;
    }

    @Nullable
    public String getCodeId() {
        return this.codeId;
    }

    @Nullable
    public String getDebugFile() {
        return this.debugFile;
    }

    @Nullable
    public String getDebugId() {
        return this.debugId;
    }

    @Nullable
    public String getImageAddr() {
        return this.imageAddr;
    }

    @Nullable
    public Long getImageSize() {
        return this.imageSize;
    }

    @Nullable
    public String getType() {
        return this.type;
    }

    @Nullable
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    @Nullable
    public String getUuid() {
        return this.uuid;
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        if (this.uuid != null) {
            m3Var.e(JsonKeys.UUID).g(this.uuid);
        }
        if (this.type != null) {
            m3Var.e("type").g(this.type);
        }
        if (this.debugId != null) {
            m3Var.e(JsonKeys.DEBUG_ID).g(this.debugId);
        }
        if (this.debugFile != null) {
            m3Var.e(JsonKeys.DEBUG_FILE).g(this.debugFile);
        }
        if (this.codeId != null) {
            m3Var.e(JsonKeys.CODE_ID).g(this.codeId);
        }
        if (this.codeFile != null) {
            m3Var.e(JsonKeys.CODE_FILE).g(this.codeFile);
        }
        if (this.imageAddr != null) {
            m3Var.e("image_addr").g(this.imageAddr);
        }
        if (this.imageSize != null) {
            m3Var.e(JsonKeys.IMAGE_SIZE).n(this.imageSize);
        }
        if (this.arch != null) {
            m3Var.e(JsonKeys.ARCH).g(this.arch);
        }
        Map<String, Object> map = this.unknown;
        if (map != null) {
            for (String str : map.keySet()) {
                m3Var.e(str).o(w0Var, this.unknown.get(str));
            }
        }
        m3Var.k();
    }

    public void setArch(@Nullable String str) {
        this.arch = str;
    }

    public void setCodeFile(@Nullable String str) {
        this.codeFile = str;
    }

    public void setCodeId(@Nullable String str) {
        this.codeId = str;
    }

    public void setDebugFile(@Nullable String str) {
        this.debugFile = str;
    }

    public void setDebugId(@Nullable String str) {
        this.debugId = str;
    }

    public void setImageAddr(@Nullable String str) {
        this.imageAddr = str;
    }

    public void setImageSize(@Nullable Long l10) {
        this.imageSize = l10;
    }

    public void setType(@Nullable String str) {
        this.type = str;
    }

    public void setUnknown(@Nullable Map<String, Object> map) {
        this.unknown = map;
    }

    public void setUuid(@Nullable String str) {
        this.uuid = str;
    }

    public void setImageSize(long j10) {
        this.imageSize = Long.valueOf(j10);
    }
}
