package io.sentry.protocol;

import io.sentry.SentryLevel;
import io.sentry.h2;
import io.sentry.i8;
import io.sentry.l3;
import io.sentry.m3;
import io.sentry.n;
import io.sentry.o8;
import io.sentry.protocol.MeasurementValue;
import io.sentry.protocol.SentryId;
import io.sentry.q8;
import io.sentry.util.w;
import io.sentry.w0;
import io.sentry.x1;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class SentrySpan implements h2 {

    @Nullable
    private Map<String, Object> data;

    @Nullable
    private final String description;

    @NotNull
    private final Map<String, MeasurementValue> measurements;

    @NotNull
    private final String op;

    @Nullable
    private final String origin;

    @Nullable
    private final o8 parentSpanId;

    @NotNull
    private final o8 spanId;

    @NotNull
    private final Double startTimestamp;

    @Nullable
    private final q8 status;

    @NotNull
    private final Map<String, String> tags;

    @Nullable
    private final Double timestamp;

    @NotNull
    private final SentryId traceId;

    @Nullable
    private Map<String, Object> unknown;

    public static final class Deserializer implements x1<SentrySpan> {
        private Exception missingRequiredFieldException(String str, w0 w0Var) {
            String str2 = "Missing required field \"" + str + "\"";
            IllegalStateException illegalStateException = new IllegalStateException(str2);
            w0Var.b(SentryLevel.ERROR, str2, illegalStateException);
            return illegalStateException;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.sentry.x1
        @NotNull
        public SentrySpan deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            String strC;
            l3Var.h();
            Map map = null;
            Double dValueOf = null;
            Double dValueOf2 = null;
            SentryId sentryIdDeserialize = null;
            o8 o8VarDeserialize = null;
            o8 o8Var = null;
            String strO0 = null;
            String strO02 = null;
            q8 q8Var = null;
            String strO03 = null;
            Map mapQ0 = null;
            ConcurrentHashMap concurrentHashMap = null;
            Map map2 = null;
            while (true) {
                String str = strO03;
                q8 q8Var2 = q8Var;
                String str2 = strO02;
                o8 o8Var2 = o8Var;
                if (l3Var.peek() != io.sentry.vendor.gson.stream.b.NAME) {
                    if (dValueOf == null) {
                        throw missingRequiredFieldException("start_timestamp", w0Var);
                    }
                    if (sentryIdDeserialize == null) {
                        throw missingRequiredFieldException(JsonKeys.TRACE_ID, w0Var);
                    }
                    if (o8VarDeserialize == null) {
                        throw missingRequiredFieldException(JsonKeys.SPAN_ID, w0Var);
                    }
                    if (strO0 == null) {
                        throw missingRequiredFieldException(JsonKeys.OP, w0Var);
                    }
                    Map map3 = map == null ? new HashMap() : map;
                    Map map4 = mapQ0 == null ? new HashMap() : mapQ0;
                    SentrySpan sentrySpan = new SentrySpan(dValueOf, dValueOf2, sentryIdDeserialize, o8VarDeserialize, o8Var2, strO0, str2, q8Var2, str, map3, map4, map2);
                    sentrySpan.setUnknown(concurrentHashMap);
                    l3Var.k();
                    return sentrySpan;
                }
                strC = l3Var.C();
                strC.hashCode();
                switch (strC) {
                    case "span_id":
                        o8VarDeserialize = new o8.a().deserialize(l3Var, w0Var);
                        strO03 = str;
                        q8Var = q8Var2;
                        strO02 = str2;
                        o8Var = o8Var2;
                        break;
                    case "parent_span_id":
                        o8Var = (o8) l3Var.M(w0Var, new o8.a());
                        strO03 = str;
                        q8Var = q8Var2;
                        strO02 = str2;
                        break;
                    case "description":
                        strO02 = l3Var.o0();
                        strO03 = str;
                        q8Var = q8Var2;
                        o8Var = o8Var2;
                        break;
                    case "start_timestamp":
                        try {
                            dValueOf = l3Var.A();
                            break;
                        } catch (NumberFormatException unused) {
                            Date dateF = l3Var.F(w0Var);
                            dValueOf = dateF != null ? Double.valueOf(n.b(dateF)) : null;
                        }
                        strO03 = str;
                        q8Var = q8Var2;
                        strO02 = str2;
                        o8Var = o8Var2;
                        break;
                    case "origin":
                        strO03 = l3Var.o0();
                        q8Var = q8Var2;
                        strO02 = str2;
                        o8Var = o8Var2;
                        break;
                    case "status":
                        q8Var = (q8) l3Var.M(w0Var, new q8.a());
                        strO03 = str;
                        strO02 = str2;
                        o8Var = o8Var2;
                        break;
                    case "measurements":
                        mapQ0 = l3Var.q0(w0Var, new MeasurementValue.Deserializer());
                        strO03 = str;
                        q8Var = q8Var2;
                        strO02 = str2;
                        o8Var = o8Var2;
                        break;
                    case "op":
                        strO0 = l3Var.o0();
                        strO03 = str;
                        q8Var = q8Var2;
                        strO02 = str2;
                        o8Var = o8Var2;
                        break;
                    case "data":
                        map2 = (Map) l3Var.A0();
                        strO03 = str;
                        q8Var = q8Var2;
                        strO02 = str2;
                        o8Var = o8Var2;
                        break;
                    case "tags":
                        map = (Map) l3Var.A0();
                        strO03 = str;
                        q8Var = q8Var2;
                        strO02 = str2;
                        o8Var = o8Var2;
                        break;
                    case "timestamp":
                        try {
                            dValueOf2 = l3Var.A();
                            break;
                        } catch (NumberFormatException unused2) {
                            Date dateF2 = l3Var.F(w0Var);
                            dValueOf2 = dateF2 != null ? Double.valueOf(n.b(dateF2)) : null;
                        }
                        strO03 = str;
                        q8Var = q8Var2;
                        strO02 = str2;
                        o8Var = o8Var2;
                        break;
                    case "trace_id":
                        sentryIdDeserialize = new SentryId.Deserializer().deserialize(l3Var, w0Var);
                        strO03 = str;
                        q8Var = q8Var2;
                        strO02 = str2;
                        o8Var = o8Var2;
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        l3Var.r0(w0Var, concurrentHashMap, strC);
                        strO03 = str;
                        q8Var = q8Var2;
                        strO02 = str2;
                        o8Var = o8Var2;
                        break;
                }
            }
        }
    }

    public static final class JsonKeys {
        public static final String DATA = "data";
        public static final String DESCRIPTION = "description";
        public static final String MEASUREMENTS = "measurements";
        public static final String OP = "op";
        public static final String ORIGIN = "origin";
        public static final String PARENT_SPAN_ID = "parent_span_id";
        public static final String SPAN_ID = "span_id";
        public static final String START_TIMESTAMP = "start_timestamp";
        public static final String STATUS = "status";
        public static final String TAGS = "tags";
        public static final String TIMESTAMP = "timestamp";
        public static final String TRACE_ID = "trace_id";
    }

    public SentrySpan(@NotNull i8 i8Var) {
        this(i8Var, i8Var.v());
    }

    @NotNull
    private BigDecimal doubleToBigDecimal(@NotNull Double d10) {
        return BigDecimal.valueOf(d10.doubleValue()).setScale(6, RoundingMode.DOWN);
    }

    @Nullable
    public Map<String, Object> getData() {
        return this.data;
    }

    @Nullable
    public String getDescription() {
        return this.description;
    }

    @NotNull
    public Map<String, MeasurementValue> getMeasurements() {
        return this.measurements;
    }

    @NotNull
    public String getOp() {
        return this.op;
    }

    @Nullable
    public String getOrigin() {
        return this.origin;
    }

    @Nullable
    public o8 getParentSpanId() {
        return this.parentSpanId;
    }

    @NotNull
    public o8 getSpanId() {
        return this.spanId;
    }

    @NotNull
    public Double getStartTimestamp() {
        return this.startTimestamp;
    }

    @Nullable
    public q8 getStatus() {
        return this.status;
    }

    @NotNull
    public Map<String, String> getTags() {
        return this.tags;
    }

    @Nullable
    public Double getTimestamp() {
        return this.timestamp;
    }

    @NotNull
    public SentryId getTraceId() {
        return this.traceId;
    }

    @Nullable
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    public boolean isFinished() {
        return this.timestamp != null;
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        m3Var.e("start_timestamp").o(w0Var, doubleToBigDecimal(this.startTimestamp));
        if (this.timestamp != null) {
            m3Var.e("timestamp").o(w0Var, doubleToBigDecimal(this.timestamp));
        }
        m3Var.e(JsonKeys.TRACE_ID).o(w0Var, this.traceId);
        m3Var.e(JsonKeys.SPAN_ID).o(w0Var, this.spanId);
        if (this.parentSpanId != null) {
            m3Var.e(JsonKeys.PARENT_SPAN_ID).o(w0Var, this.parentSpanId);
        }
        m3Var.e(JsonKeys.OP).g(this.op);
        if (this.description != null) {
            m3Var.e("description").g(this.description);
        }
        if (this.status != null) {
            m3Var.e("status").o(w0Var, this.status);
        }
        if (this.origin != null) {
            m3Var.e("origin").o(w0Var, this.origin);
        }
        if (!this.tags.isEmpty()) {
            m3Var.e(JsonKeys.TAGS).o(w0Var, this.tags);
        }
        if (this.data != null) {
            m3Var.e("data").o(w0Var, this.data);
        }
        if (!this.measurements.isEmpty()) {
            m3Var.e("measurements").o(w0Var, this.measurements);
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

    public void setData(@Nullable Map<String, Object> map) {
        this.data = map;
    }

    public void setUnknown(@Nullable Map<String, Object> map) {
        this.unknown = map;
    }

    @ApiStatus.Internal
    public SentrySpan(@NotNull i8 i8Var, @Nullable Map<String, Object> map) {
        w.c(i8Var, "span is required");
        this.description = i8Var.getDescription();
        this.op = i8Var.y();
        this.spanId = i8Var.D();
        this.parentSpanId = i8Var.A();
        this.traceId = i8Var.F();
        this.status = i8Var.getStatus();
        this.origin = i8Var.r().f();
        Map<String, String> mapB = io.sentry.util.c.b(i8Var.E());
        this.tags = mapB == null ? new ConcurrentHashMap<>() : mapB;
        Map<String, MeasurementValue> mapB2 = io.sentry.util.c.b(i8Var.x());
        this.measurements = mapB2 == null ? new ConcurrentHashMap<>() : mapB2;
        this.timestamp = i8Var.s() == null ? null : Double.valueOf(n.m(i8Var.u().f(i8Var.s())));
        this.startTimestamp = Double.valueOf(n.m(i8Var.u().g()));
        this.data = map;
    }

    @ApiStatus.Internal
    public SentrySpan(@NotNull Double d10, @Nullable Double d11, @NotNull SentryId sentryId, @NotNull o8 o8Var, @Nullable o8 o8Var2, @NotNull String str, @Nullable String str2, @Nullable q8 q8Var, @Nullable String str3, @NotNull Map<String, String> map, @NotNull Map<String, MeasurementValue> map2, @Nullable Map<String, Object> map3) {
        this.startTimestamp = d10;
        this.timestamp = d11;
        this.traceId = sentryId;
        this.spanId = o8Var;
        this.parentSpanId = o8Var2;
        this.op = str;
        this.description = str2;
        this.status = q8Var;
        this.origin = str3;
        this.tags = map;
        this.measurements = map2;
        this.data = map3;
    }
}
