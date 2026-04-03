package io.sentry.protocol;

import io.sentry.c7;
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
public final class SentryStackFrame implements h2 {

    @Nullable
    private Boolean _native;

    @Nullable
    private String _package;

    @Nullable
    private String absPath;

    @Nullable
    private String addrMode;

    @Nullable
    private Integer colno;

    @Nullable
    private String contextLine;

    @Nullable
    private String filename;

    @Nullable
    private List<Integer> framesOmitted;

    @Nullable
    private String function;

    @Nullable
    private String imageAddr;

    @Nullable
    private Boolean inApp;

    @Nullable
    private String instructionAddr;

    @Nullable
    private Integer lineno;

    @Nullable
    private c7 lock;

    @Nullable
    private String module;

    @Nullable
    private String platform;

    @Nullable
    private List<String> postContext;

    @Nullable
    private List<String> preContext;

    @Nullable
    private String rawFunction;

    @Nullable
    private String symbol;

    @Nullable
    private String symbolAddr;

    @Nullable
    private Map<String, Object> unknown;

    @Nullable
    private Map<String, String> vars;

    public static final class Deserializer implements x1<SentryStackFrame> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.sentry.x1
        @NotNull
        public SentryStackFrame deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            String strC;
            SentryStackFrame sentryStackFrame = new SentryStackFrame();
            l3Var.h();
            ConcurrentHashMap concurrentHashMap = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strC = l3Var.C();
                strC.hashCode();
                switch (strC) {
                    case "post_context":
                        sentryStackFrame.postContext = (List) l3Var.A0();
                        break;
                    case "image_addr":
                        sentryStackFrame.imageAddr = l3Var.o0();
                        break;
                    case "in_app":
                        sentryStackFrame.inApp = l3Var.H();
                        break;
                    case "raw_function":
                        sentryStackFrame.rawFunction = l3Var.o0();
                        break;
                    case "lineno":
                        sentryStackFrame.lineno = l3Var.g0();
                        break;
                    case "module":
                        sentryStackFrame.module = l3Var.o0();
                        break;
                    case "native":
                        sentryStackFrame._native = l3Var.H();
                        break;
                    case "symbol":
                        sentryStackFrame.symbol = l3Var.o0();
                        break;
                    case "package":
                        sentryStackFrame._package = l3Var.o0();
                        break;
                    case "filename":
                        sentryStackFrame.filename = l3Var.o0();
                        break;
                    case "symbol_addr":
                        sentryStackFrame.symbolAddr = l3Var.o0();
                        break;
                    case "lock":
                        sentryStackFrame.lock = (c7) l3Var.M(w0Var, new c7.a());
                        break;
                    case "colno":
                        sentryStackFrame.colno = l3Var.g0();
                        break;
                    case "instruction_addr":
                        sentryStackFrame.instructionAddr = l3Var.o0();
                        break;
                    case "pre_context":
                        sentryStackFrame.preContext = (List) l3Var.A0();
                        break;
                    case "addr_mode":
                        sentryStackFrame.addrMode = l3Var.o0();
                        break;
                    case "context_line":
                        sentryStackFrame.contextLine = l3Var.o0();
                        break;
                    case "function":
                        sentryStackFrame.function = l3Var.o0();
                        break;
                    case "abs_path":
                        sentryStackFrame.absPath = l3Var.o0();
                        break;
                    case "platform":
                        sentryStackFrame.platform = l3Var.o0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        l3Var.r0(w0Var, concurrentHashMap, strC);
                        break;
                }
            }
            sentryStackFrame.setUnknown(concurrentHashMap);
            l3Var.k();
            return sentryStackFrame;
        }
    }

    public static final class JsonKeys {
        public static final String ABS_PATH = "abs_path";
        public static final String ADDR_MODE = "addr_mode";
        public static final String COLNO = "colno";
        public static final String CONTEXT_LINE = "context_line";
        public static final String FILENAME = "filename";
        public static final String FUNCTION = "function";
        public static final String IMAGE_ADDR = "image_addr";
        public static final String INSTRUCTION_ADDR = "instruction_addr";
        public static final String IN_APP = "in_app";
        public static final String LINENO = "lineno";
        public static final String LOCK = "lock";
        public static final String MODULE = "module";
        public static final String NATIVE = "native";
        public static final String PACKAGE = "package";
        public static final String PLATFORM = "platform";
        public static final String POST_CONTEXT = "post_context";
        public static final String PRE_CONTEXT = "pre_context";
        public static final String RAW_FUNCTION = "raw_function";
        public static final String SYMBOL = "symbol";
        public static final String SYMBOL_ADDR = "symbol_addr";
    }

    @Nullable
    public String getAbsPath() {
        return this.absPath;
    }

    @Nullable
    public String getAddrMode() {
        return this.addrMode;
    }

    @Nullable
    public Integer getColno() {
        return this.colno;
    }

    @Nullable
    public String getContextLine() {
        return this.contextLine;
    }

    @Nullable
    public String getFilename() {
        return this.filename;
    }

    @Nullable
    public List<Integer> getFramesOmitted() {
        return this.framesOmitted;
    }

    @Nullable
    public String getFunction() {
        return this.function;
    }

    @Nullable
    public String getImageAddr() {
        return this.imageAddr;
    }

    @Nullable
    public String getInstructionAddr() {
        return this.instructionAddr;
    }

    @Nullable
    public Integer getLineno() {
        return this.lineno;
    }

    @Nullable
    public c7 getLock() {
        return this.lock;
    }

    @Nullable
    public String getModule() {
        return this.module;
    }

    @Nullable
    public String getPackage() {
        return this._package;
    }

    @Nullable
    public String getPlatform() {
        return this.platform;
    }

    @Nullable
    public List<String> getPostContext() {
        return this.postContext;
    }

    @Nullable
    public List<String> getPreContext() {
        return this.preContext;
    }

    @Nullable
    public String getRawFunction() {
        return this.rawFunction;
    }

    @Nullable
    public String getSymbol() {
        return this.symbol;
    }

    @Nullable
    public String getSymbolAddr() {
        return this.symbolAddr;
    }

    @Nullable
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    @Nullable
    public Map<String, String> getVars() {
        return this.vars;
    }

    @Nullable
    public Boolean isInApp() {
        return this.inApp;
    }

    @Nullable
    public Boolean isNative() {
        return this._native;
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        if (this.filename != null) {
            m3Var.e(JsonKeys.FILENAME).g(this.filename);
        }
        if (this.function != null) {
            m3Var.e(JsonKeys.FUNCTION).g(this.function);
        }
        if (this.module != null) {
            m3Var.e("module").g(this.module);
        }
        if (this.lineno != null) {
            m3Var.e(JsonKeys.LINENO).n(this.lineno);
        }
        if (this.colno != null) {
            m3Var.e(JsonKeys.COLNO).n(this.colno);
        }
        if (this.absPath != null) {
            m3Var.e(JsonKeys.ABS_PATH).g(this.absPath);
        }
        if (this.contextLine != null) {
            m3Var.e(JsonKeys.CONTEXT_LINE).g(this.contextLine);
        }
        if (this.inApp != null) {
            m3Var.e(JsonKeys.IN_APP).p(this.inApp);
        }
        if (this._package != null) {
            m3Var.e(JsonKeys.PACKAGE).g(this._package);
        }
        if (this._native != null) {
            m3Var.e("native").p(this._native);
        }
        if (this.platform != null) {
            m3Var.e("platform").g(this.platform);
        }
        if (this.imageAddr != null) {
            m3Var.e("image_addr").g(this.imageAddr);
        }
        if (this.symbolAddr != null) {
            m3Var.e(JsonKeys.SYMBOL_ADDR).g(this.symbolAddr);
        }
        if (this.instructionAddr != null) {
            m3Var.e(JsonKeys.INSTRUCTION_ADDR).g(this.instructionAddr);
        }
        if (this.addrMode != null) {
            m3Var.e(JsonKeys.ADDR_MODE).g(this.addrMode);
        }
        if (this.rawFunction != null) {
            m3Var.e(JsonKeys.RAW_FUNCTION).g(this.rawFunction);
        }
        if (this.symbol != null) {
            m3Var.e(JsonKeys.SYMBOL).g(this.symbol);
        }
        if (this.lock != null) {
            m3Var.e(JsonKeys.LOCK).o(w0Var, this.lock);
        }
        List<String> list = this.preContext;
        if (list != null && !list.isEmpty()) {
            m3Var.e(JsonKeys.PRE_CONTEXT).o(w0Var, this.preContext);
        }
        List<String> list2 = this.postContext;
        if (list2 != null && !list2.isEmpty()) {
            m3Var.e(JsonKeys.POST_CONTEXT).o(w0Var, this.postContext);
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

    public void setAbsPath(@Nullable String str) {
        this.absPath = str;
    }

    public void setAddrMode(@Nullable String str) {
        this.addrMode = str;
    }

    public void setColno(@Nullable Integer num) {
        this.colno = num;
    }

    public void setContextLine(@Nullable String str) {
        this.contextLine = str;
    }

    public void setFilename(@Nullable String str) {
        this.filename = str;
    }

    public void setFramesOmitted(@Nullable List<Integer> list) {
        this.framesOmitted = list;
    }

    public void setFunction(@Nullable String str) {
        this.function = str;
    }

    public void setImageAddr(@Nullable String str) {
        this.imageAddr = str;
    }

    public void setInApp(@Nullable Boolean bool) {
        this.inApp = bool;
    }

    public void setInstructionAddr(@Nullable String str) {
        this.instructionAddr = str;
    }

    public void setLineno(@Nullable Integer num) {
        this.lineno = num;
    }

    public void setLock(@Nullable c7 c7Var) {
        this.lock = c7Var;
    }

    public void setModule(@Nullable String str) {
        this.module = str;
    }

    public void setNative(@Nullable Boolean bool) {
        this._native = bool;
    }

    public void setPackage(@Nullable String str) {
        this._package = str;
    }

    public void setPlatform(@Nullable String str) {
        this.platform = str;
    }

    public void setPostContext(@Nullable List<String> list) {
        this.postContext = list;
    }

    public void setPreContext(@Nullable List<String> list) {
        this.preContext = list;
    }

    public void setRawFunction(@Nullable String str) {
        this.rawFunction = str;
    }

    public void setSymbol(@Nullable String str) {
        this.symbol = str;
    }

    public void setSymbolAddr(@Nullable String str) {
        this.symbolAddr = str;
    }

    public void setUnknown(@Nullable Map<String, Object> map) {
        this.unknown = map;
    }

    public void setVars(@Nullable Map<String, String> map) {
        this.vars = map;
    }
}
