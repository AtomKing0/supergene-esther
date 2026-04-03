package io.sentry.protocol;

import io.sentry.h2;
import io.sentry.l3;
import io.sentry.m3;
import io.sentry.w0;
import io.sentry.x1;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class Message implements h2 {

    @Nullable
    private String formatted;

    @Nullable
    private String message;

    @Nullable
    private List<String> params;

    @Nullable
    private Map<String, Object> unknown;

    public static final class Deserializer implements x1<Message> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.sentry.x1
        @NotNull
        public Message deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            String strC;
            l3Var.h();
            Message message = new Message();
            ConcurrentHashMap concurrentHashMap = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strC = l3Var.C();
                strC.hashCode();
                switch (strC) {
                    case "params":
                        List list = (List) l3Var.A0();
                        if (list == null) {
                            break;
                        } else {
                            message.params = list;
                            break;
                        }
                        break;
                    case "message":
                        message.message = l3Var.o0();
                        break;
                    case "formatted":
                        message.formatted = l3Var.o0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        l3Var.r0(w0Var, concurrentHashMap, strC);
                        break;
                }
            }
            message.setUnknown(concurrentHashMap);
            l3Var.k();
            return message;
        }
    }

    public static final class JsonKeys {
        public static final String FORMATTED = "formatted";
        public static final String MESSAGE = "message";
        public static final String PARAMS = "params";
    }

    @Nullable
    public String getFormatted() {
        return this.formatted;
    }

    @Nullable
    public String getMessage() {
        return this.message;
    }

    @Nullable
    public List<String> getParams() {
        return this.params;
    }

    @Nullable
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        if (this.formatted != null) {
            m3Var.e(JsonKeys.FORMATTED).g(this.formatted);
        }
        if (this.message != null) {
            m3Var.e("message").g(this.message);
        }
        List<String> list = this.params;
        if (list != null && !list.isEmpty()) {
            m3Var.e("params").o(w0Var, this.params);
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

    public void setFormatted(@Nullable String str) {
        this.formatted = str;
    }

    public void setMessage(@Nullable String str) {
        this.message = str;
    }

    public void setParams(@Nullable List<String> list) {
        this.params = io.sentry.util.c.a(list);
    }

    public void setUnknown(@Nullable Map<String, Object> map) {
        this.unknown = map;
    }
}
