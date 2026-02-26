package io.sentry.protocol;

import io.sentry.b8;
import io.sentry.h2;
import io.sentry.i5;
import io.sentry.i8;
import io.sentry.j8;
import io.sentry.l3;
import io.sentry.m3;
import io.sentry.n;
import io.sentry.protocol.MeasurementValue;
import io.sentry.protocol.SentrySpan;
import io.sentry.protocol.TransactionInfo;
import io.sentry.q8;
import io.sentry.util.w;
import io.sentry.w0;
import io.sentry.x1;
import io.sentry.x8;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class SentryTransaction extends i5 implements h2 {

    @NotNull
    private final Map<String, MeasurementValue> measurements;

    @NotNull
    private final List<SentrySpan> spans;

    @NotNull
    private Double startTimestamp;

    @Nullable
    private Double timestamp;

    @Nullable
    private String transaction;

    @NotNull
    private TransactionInfo transactionInfo;

    @NotNull
    private final String type;

    @Nullable
    private Map<String, Object> unknown;

    public static final class Deserializer implements x1<SentryTransaction> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.sentry.x1
        @NotNull
        public SentryTransaction deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            String strC;
            l3Var.h();
            SentryTransaction sentryTransaction = new SentryTransaction("", Double.valueOf(0.0d), null, new ArrayList(), new HashMap(), new TransactionInfo(TransactionNameSource.CUSTOM.apiName()));
            i5.a aVar = new i5.a();
            ConcurrentHashMap concurrentHashMap = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strC = l3Var.C();
                strC.hashCode();
                switch (strC) {
                    case "start_timestamp":
                        try {
                            Double dA = l3Var.A();
                            if (dA != null) {
                                sentryTransaction.startTimestamp = dA;
                            }
                            break;
                        } catch (NumberFormatException unused) {
                            Date dateF = l3Var.F(w0Var);
                            if (dateF != null) {
                                sentryTransaction.startTimestamp = Double.valueOf(n.b(dateF));
                            }
                            break;
                        }
                        break;
                    case "measurements":
                        Map mapQ0 = l3Var.q0(w0Var, new MeasurementValue.Deserializer());
                        if (mapQ0 != null) {
                            sentryTransaction.measurements.putAll(mapQ0);
                            break;
                        } else {
                            break;
                        }
                        break;
                    case "type":
                        l3Var.e0();
                        break;
                    case "timestamp":
                        try {
                            Double dA2 = l3Var.A();
                            if (dA2 != null) {
                                sentryTransaction.timestamp = dA2;
                            }
                            break;
                        } catch (NumberFormatException unused2) {
                            Date dateF2 = l3Var.F(w0Var);
                            if (dateF2 != null) {
                                sentryTransaction.timestamp = Double.valueOf(n.b(dateF2));
                            }
                            break;
                        }
                        break;
                    case "spans":
                        List listD0 = l3Var.D0(w0Var, new SentrySpan.Deserializer());
                        if (listD0 != null) {
                            sentryTransaction.spans.addAll(listD0);
                            break;
                        } else {
                            break;
                        }
                        break;
                    case "transaction_info":
                        sentryTransaction.transactionInfo = new TransactionInfo.Deserializer().deserialize(l3Var, w0Var);
                        break;
                    case "transaction":
                        sentryTransaction.transaction = l3Var.o0();
                        break;
                    default:
                        if (aVar.a(sentryTransaction, strC, l3Var, w0Var)) {
                            break;
                        } else {
                            if (concurrentHashMap == null) {
                                concurrentHashMap = new ConcurrentHashMap();
                            }
                            l3Var.r0(w0Var, concurrentHashMap, strC);
                            break;
                        }
                        break;
                }
            }
            sentryTransaction.setUnknown(concurrentHashMap);
            l3Var.k();
            return sentryTransaction;
        }
    }

    public static final class JsonKeys {
        public static final String MEASUREMENTS = "measurements";
        public static final String SPANS = "spans";
        public static final String START_TIMESTAMP = "start_timestamp";
        public static final String TIMESTAMP = "timestamp";
        public static final String TRANSACTION = "transaction";
        public static final String TRANSACTION_INFO = "transaction_info";
        public static final String TYPE = "type";
    }

    public SentryTransaction(@NotNull b8 b8Var) {
        super(b8Var.getEventId());
        this.spans = new ArrayList();
        this.type = JsonKeys.TRANSACTION;
        this.measurements = new HashMap();
        w.c(b8Var, "sentryTracer is required");
        this.startTimestamp = Double.valueOf(n.m(b8Var.u().g()));
        this.timestamp = Double.valueOf(n.m(b8Var.u().f(b8Var.s())));
        this.transaction = b8Var.getName();
        for (i8 i8Var : b8Var.I()) {
            if (Boolean.TRUE.equals(i8Var.d())) {
                this.spans.add(new SentrySpan(i8Var));
            }
        }
        Contexts contexts = getContexts();
        contexts.putAll(b8Var.J());
        j8 j8VarR = b8Var.r();
        Map<String, Object> mapK = b8Var.K();
        j8 j8Var = new j8(j8VarR.n(), j8VarR.k(), j8VarR.g(), j8VarR.e(), j8VarR.c(), j8VarR.j(), j8VarR.l(), j8VarR.f());
        for (Map.Entry<String, String> entry : j8VarR.m().entrySet()) {
            setTag(entry.getKey(), entry.getValue());
        }
        if (mapK != null) {
            for (Map.Entry<String, Object> entry2 : mapK.entrySet()) {
                j8Var.o(entry2.getKey(), entry2.getValue());
            }
        }
        contexts.setTrace(j8Var);
        this.transactionInfo = new TransactionInfo(b8Var.O().apiName());
    }

    @NotNull
    public Map<String, MeasurementValue> getMeasurements() {
        return this.measurements;
    }

    @Nullable
    public x8 getSamplingDecision() {
        j8 trace = getContexts().getTrace();
        if (trace == null) {
            return null;
        }
        return trace.j();
    }

    @NotNull
    public List<SentrySpan> getSpans() {
        return this.spans;
    }

    @NotNull
    public Double getStartTimestamp() {
        return this.startTimestamp;
    }

    @Nullable
    public q8 getStatus() {
        j8 trace = getContexts().getTrace();
        if (trace != null) {
            return trace.l();
        }
        return null;
    }

    @Nullable
    public Double getTimestamp() {
        return this.timestamp;
    }

    @Nullable
    public String getTransaction() {
        return this.transaction;
    }

    @NotNull
    public String getType() {
        return JsonKeys.TRANSACTION;
    }

    @Nullable
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    public boolean isFinished() {
        return this.timestamp != null;
    }

    public boolean isSampled() {
        x8 samplingDecision = getSamplingDecision();
        if (samplingDecision == null) {
            return false;
        }
        return samplingDecision.e().booleanValue();
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        if (this.transaction != null) {
            m3Var.e(JsonKeys.TRANSACTION).g(this.transaction);
        }
        m3Var.e("start_timestamp").o(w0Var, n.c(this.startTimestamp));
        if (this.timestamp != null) {
            m3Var.e("timestamp").o(w0Var, n.c(this.timestamp));
        }
        if (!this.spans.isEmpty()) {
            m3Var.e(JsonKeys.SPANS).o(w0Var, this.spans);
        }
        m3Var.e("type").g(JsonKeys.TRANSACTION);
        if (!this.measurements.isEmpty()) {
            m3Var.e("measurements").o(w0Var, this.measurements);
        }
        m3Var.e(JsonKeys.TRANSACTION_INFO).o(w0Var, this.transactionInfo);
        new i5.b().a(this, m3Var, w0Var);
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

    public void setUnknown(@Nullable Map<String, Object> map) {
        this.unknown = map;
    }

    @ApiStatus.Internal
    public SentryTransaction(@Nullable String str, @NotNull Double d10, @Nullable Double d11, @NotNull List<SentrySpan> list, @NotNull Map<String, MeasurementValue> map, @NotNull TransactionInfo transactionInfo) {
        ArrayList arrayList = new ArrayList();
        this.spans = arrayList;
        this.type = JsonKeys.TRANSACTION;
        HashMap map2 = new HashMap();
        this.measurements = map2;
        this.transaction = str;
        this.startTimestamp = d10;
        this.timestamp = d11;
        arrayList.addAll(list);
        map2.putAll(map);
        Iterator<SentrySpan> it = list.iterator();
        while (it.hasNext()) {
            this.measurements.putAll(it.next().getMeasurements());
        }
        this.transactionInfo = transactionInfo;
    }
}
