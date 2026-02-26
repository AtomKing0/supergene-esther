package io.sentry.protocol;

import io.sentry.h2;
import io.sentry.l3;
import io.sentry.m3;
import io.sentry.w0;
import io.sentry.x1;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class TransactionInfo implements h2 {

    @Nullable
    private final String source;

    @Nullable
    private Map<String, Object> unknown;

    public static final class Deserializer implements x1<TransactionInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.sentry.x1
        @NotNull
        public TransactionInfo deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            l3Var.h();
            String strO0 = null;
            ConcurrentHashMap concurrentHashMap = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                String strC = l3Var.C();
                strC.hashCode();
                if (strC.equals(JsonKeys.SOURCE)) {
                    strO0 = l3Var.o0();
                } else {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    l3Var.r0(w0Var, concurrentHashMap, strC);
                }
            }
            TransactionInfo transactionInfo = new TransactionInfo(strO0);
            transactionInfo.setUnknown(concurrentHashMap);
            l3Var.k();
            return transactionInfo;
        }
    }

    public static final class JsonKeys {
        public static final String SOURCE = "source";
    }

    public TransactionInfo(@Nullable String str) {
        this.source = str;
    }

    @Nullable
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        if (this.source != null) {
            m3Var.e(JsonKeys.SOURCE).o(w0Var, this.source);
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

    public void setUnknown(@Nullable Map<String, Object> map) {
        this.unknown = map;
    }
}
