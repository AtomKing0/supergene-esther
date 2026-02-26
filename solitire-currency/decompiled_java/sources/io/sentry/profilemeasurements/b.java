package io.sentry.profilemeasurements;

import io.sentry.h2;
import io.sentry.i7;
import io.sentry.l3;
import io.sentry.m3;
import io.sentry.n;
import io.sentry.n5;
import io.sentry.util.w;
import io.sentry.w0;
import io.sentry.x1;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ProfileMeasurementValue.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class b implements h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private Map<String, Object> f28070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private Double f28071b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private String f28072c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private double f28073d;

    /* JADX INFO: compiled from: ProfileMeasurementValue.java */
    public static final class a implements x1<b> {
        @Override // io.sentry.x1
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public b deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            String strC;
            Double dValueOf;
            l3Var.h();
            b bVar = new b();
            ConcurrentHashMap concurrentHashMap = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strC = l3Var.C();
                strC.hashCode();
                switch (strC) {
                    case "elapsed_since_start_ns":
                        String strO0 = l3Var.o0();
                        if (strO0 == null) {
                            break;
                        } else {
                            bVar.f28072c = strO0;
                            break;
                        }
                        break;
                    case "timestamp":
                        try {
                            dValueOf = l3Var.A();
                            break;
                        } catch (NumberFormatException unused) {
                            Date dateF = l3Var.F(w0Var);
                            dValueOf = dateF != null ? Double.valueOf(n.b(dateF)) : null;
                        }
                        if (dValueOf == null) {
                            break;
                        } else {
                            bVar.f28071b = dValueOf;
                            break;
                        }
                        break;
                    case "value":
                        Double dA = l3Var.A();
                        if (dA == null) {
                            break;
                        } else {
                            bVar.f28073d = dA.doubleValue();
                            break;
                        }
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        l3Var.r0(w0Var, concurrentHashMap, strC);
                        break;
                }
            }
            bVar.e(concurrentHashMap);
            l3Var.k();
            return bVar;
        }
    }

    public b() {
        this(0L, 0, new i7(new Date(0L), 0L));
    }

    @NotNull
    private BigDecimal d(@NotNull Double d10) {
        return BigDecimal.valueOf(d10.doubleValue()).setScale(6, RoundingMode.DOWN);
    }

    public void e(@Nullable Map<String, Object> map) {
        this.f28070a = map;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return w.a(this.f28070a, bVar.f28070a) && this.f28072c.equals(bVar.f28072c) && this.f28073d == bVar.f28073d && w.a(this.f28071b, bVar.f28071b);
    }

    public int hashCode() {
        return w.b(this.f28070a, this.f28072c, Double.valueOf(this.f28073d));
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        m3Var.e("value").o(w0Var, Double.valueOf(this.f28073d));
        m3Var.e("elapsed_since_start_ns").o(w0Var, this.f28072c);
        if (this.f28071b != null) {
            m3Var.e("timestamp").o(w0Var, d(this.f28071b));
        }
        Map<String, Object> map = this.f28070a;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.f28070a.get(str);
                m3Var.e(str);
                m3Var.o(w0Var, obj);
            }
        }
        m3Var.k();
    }

    public b(@NotNull Long l10, @NotNull Number number, @NotNull n5 n5Var) {
        this.f28072c = l10.toString();
        this.f28073d = number.doubleValue();
        this.f28071b = Double.valueOf(n.m(n5Var.g()));
    }
}
