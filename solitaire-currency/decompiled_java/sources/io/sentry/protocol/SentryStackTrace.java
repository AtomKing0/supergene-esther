package io.sentry.protocol;

import io.sentry.h2;
import io.sentry.l3;
import io.sentry.m3;
import io.sentry.protocol.SentryStackFrame;
import io.sentry.w0;
import io.sentry.x1;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class SentryStackTrace implements h2 {

    @Nullable
    private List<SentryStackFrame> frames;

    @Nullable
    private Map<String, String> registers;

    @Nullable
    private Boolean snapshot;

    @Nullable
    private Map<String, Object> unknown;

    public static final class Deserializer implements x1<SentryStackTrace> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.sentry.x1
        @NotNull
        public SentryStackTrace deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            String strC;
            SentryStackTrace sentryStackTrace = new SentryStackTrace();
            l3Var.h();
            ConcurrentHashMap concurrentHashMap = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strC = l3Var.C();
                strC.hashCode();
                switch (strC) {
                    case "frames":
                        sentryStackTrace.frames = l3Var.D0(w0Var, new SentryStackFrame.Deserializer());
                        break;
                    case "registers":
                        sentryStackTrace.registers = io.sentry.util.c.b((Map) l3Var.A0());
                        break;
                    case "snapshot":
                        sentryStackTrace.snapshot = l3Var.H();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        l3Var.r0(w0Var, concurrentHashMap, strC);
                        break;
                }
            }
            sentryStackTrace.setUnknown(concurrentHashMap);
            l3Var.k();
            return sentryStackTrace;
        }
    }

    public static final class JsonKeys {
        public static final String FRAMES = "frames";
        public static final String REGISTERS = "registers";
        public static final String SNAPSHOT = "snapshot";
    }

    public SentryStackTrace() {
    }

    public SentryStackTrace(@Nullable List<SentryStackFrame> list) {
        this.frames = list;
    }

    @Nullable
    public List<SentryStackFrame> getFrames() {
        return this.frames;
    }

    @Nullable
    public Map<String, String> getRegisters() {
        return this.registers;
    }

    @Nullable
    public Boolean getSnapshot() {
        return this.snapshot;
    }

    @Nullable
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        if (this.frames != null) {
            m3Var.e(JsonKeys.FRAMES).o(w0Var, this.frames);
        }
        if (this.registers != null) {
            m3Var.e(JsonKeys.REGISTERS).o(w0Var, this.registers);
        }
        if (this.snapshot != null) {
            m3Var.e(JsonKeys.SNAPSHOT).p(this.snapshot);
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

    public void setFrames(@Nullable List<SentryStackFrame> list) {
        this.frames = list;
    }

    public void setRegisters(@Nullable Map<String, String> map) {
        this.registers = map;
    }

    public void setSnapshot(@Nullable Boolean bool) {
        this.snapshot = bool;
    }

    public void setUnknown(@Nullable Map<String, Object> map) {
        this.unknown = map;
    }
}
