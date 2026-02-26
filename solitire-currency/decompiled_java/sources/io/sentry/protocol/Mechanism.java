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
public final class Mechanism implements h2 {

    @Nullable
    private Map<String, Object> data;

    @Nullable
    private String description;

    @Nullable
    private Boolean exceptionGroup;

    @Nullable
    private Integer exceptionId;

    @Nullable
    private Boolean handled;

    @Nullable
    private String helpLink;

    @Nullable
    private Map<String, Object> meta;

    @Nullable
    private Integer parentId;

    @Nullable
    private Boolean synthetic;

    @Nullable
    private final transient Thread thread;

    @Nullable
    private String type;

    @Nullable
    private Map<String, Object> unknown;

    public static final class Deserializer implements x1<Mechanism> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.sentry.x1
        @NotNull
        public Mechanism deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            String strC;
            Mechanism mechanism = new Mechanism();
            l3Var.h();
            HashMap map = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strC = l3Var.C();
                strC.hashCode();
                switch (strC) {
                    case "description":
                        mechanism.description = l3Var.o0();
                        break;
                    case "exception_id":
                        mechanism.exceptionId = l3Var.g0();
                        break;
                    case "data":
                        mechanism.data = io.sentry.util.c.b((Map) l3Var.A0());
                        break;
                    case "meta":
                        mechanism.meta = io.sentry.util.c.b((Map) l3Var.A0());
                        break;
                    case "type":
                        mechanism.type = l3Var.o0();
                        break;
                    case "handled":
                        mechanism.handled = l3Var.H();
                        break;
                    case "synthetic":
                        mechanism.synthetic = l3Var.H();
                        break;
                    case "is_exception_group":
                        mechanism.exceptionGroup = l3Var.H();
                        break;
                    case "help_link":
                        mechanism.helpLink = l3Var.o0();
                        break;
                    case "parent_id":
                        mechanism.parentId = l3Var.g0();
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
            mechanism.setUnknown(map);
            return mechanism;
        }
    }

    public static final class JsonKeys {
        public static final String DATA = "data";
        public static final String DESCRIPTION = "description";
        public static final String EXCEPTION_ID = "exception_id";
        public static final String HANDLED = "handled";
        public static final String HELP_LINK = "help_link";
        public static final String IS_EXCEPTION_GROUP = "is_exception_group";
        public static final String META = "meta";
        public static final String PARENT_ID = "parent_id";
        public static final String SYNTHETIC = "synthetic";
        public static final String TYPE = "type";
    }

    public Mechanism() {
        this(null);
    }

    @Nullable
    public Map<String, Object> getData() {
        return this.data;
    }

    @Nullable
    public String getDescription() {
        return this.description;
    }

    @Nullable
    public Integer getExceptionId() {
        return this.exceptionId;
    }

    @Nullable
    public String getHelpLink() {
        return this.helpLink;
    }

    @Nullable
    public Map<String, Object> getMeta() {
        return this.meta;
    }

    @Nullable
    public Integer getParentId() {
        return this.parentId;
    }

    @Nullable
    public Boolean getSynthetic() {
        return this.synthetic;
    }

    @Nullable
    Thread getThread() {
        return this.thread;
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
    public Boolean isExceptionGroup() {
        return this.exceptionGroup;
    }

    @Nullable
    public Boolean isHandled() {
        return this.handled;
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        if (this.type != null) {
            m3Var.e("type").g(this.type);
        }
        if (this.description != null) {
            m3Var.e("description").g(this.description);
        }
        if (this.helpLink != null) {
            m3Var.e(JsonKeys.HELP_LINK).g(this.helpLink);
        }
        if (this.handled != null) {
            m3Var.e(JsonKeys.HANDLED).p(this.handled);
        }
        if (this.meta != null) {
            m3Var.e(JsonKeys.META).o(w0Var, this.meta);
        }
        if (this.data != null) {
            m3Var.e("data").o(w0Var, this.data);
        }
        if (this.synthetic != null) {
            m3Var.e(JsonKeys.SYNTHETIC).p(this.synthetic);
        }
        if (this.exceptionId != null) {
            m3Var.e(JsonKeys.EXCEPTION_ID).o(w0Var, this.exceptionId);
        }
        if (this.parentId != null) {
            m3Var.e(JsonKeys.PARENT_ID).o(w0Var, this.parentId);
        }
        if (this.exceptionGroup != null) {
            m3Var.e(JsonKeys.IS_EXCEPTION_GROUP).p(this.exceptionGroup);
        }
        Map<String, Object> map = this.unknown;
        if (map != null) {
            for (String str : map.keySet()) {
                m3Var.e(str).o(w0Var, this.unknown.get(str));
            }
        }
        m3Var.k();
    }

    public void setData(@Nullable Map<String, Object> map) {
        this.data = io.sentry.util.c.c(map);
    }

    public void setDescription(@Nullable String str) {
        this.description = str;
    }

    public void setExceptionGroup(@Nullable Boolean bool) {
        this.exceptionGroup = bool;
    }

    public void setExceptionId(@Nullable Integer num) {
        this.exceptionId = num;
    }

    public void setHandled(@Nullable Boolean bool) {
        this.handled = bool;
    }

    public void setHelpLink(@Nullable String str) {
        this.helpLink = str;
    }

    public void setMeta(@Nullable Map<String, Object> map) {
        this.meta = io.sentry.util.c.c(map);
    }

    public void setParentId(@Nullable Integer num) {
        this.parentId = num;
    }

    public void setSynthetic(@Nullable Boolean bool) {
        this.synthetic = bool;
    }

    public void setType(@Nullable String str) {
        this.type = str;
    }

    public void setUnknown(@Nullable Map<String, Object> map) {
        this.unknown = map;
    }

    public Mechanism(@Nullable Thread thread) {
        this.thread = thread;
    }
}
