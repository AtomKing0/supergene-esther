package io.sentry.clientreport;

import io.sentry.SentryLevel;
import io.sentry.h2;
import io.sentry.l3;
import io.sentry.m3;
import io.sentry.w0;
import io.sentry.x1;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DiscardedEvent.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class g implements h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f27728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f27729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final Long f27730c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private Map<String, Object> f27731d;

    /* JADX INFO: compiled from: DiscardedEvent.java */
    public static final class a implements x1<g> {
        private Exception b(String str, w0 w0Var) {
            String str2 = "Missing required field \"" + str + "\"";
            IllegalStateException illegalStateException = new IllegalStateException(str2);
            w0Var.b(SentryLevel.ERROR, str2, illegalStateException);
            return illegalStateException;
        }

        @Override // io.sentry.x1
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public g deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            String strC;
            l3Var.h();
            String strO0 = null;
            String strO02 = null;
            Long lJ0 = null;
            HashMap map = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strC = l3Var.C();
                strC.hashCode();
                switch (strC) {
                    case "quantity":
                        lJ0 = l3Var.j0();
                        break;
                    case "reason":
                        strO0 = l3Var.o0();
                        break;
                    case "category":
                        strO02 = l3Var.o0();
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
            if (strO0 == null) {
                throw b("reason", w0Var);
            }
            if (strO02 == null) {
                throw b("category", w0Var);
            }
            if (lJ0 == null) {
                throw b("quantity", w0Var);
            }
            g gVar = new g(strO0, strO02, lJ0);
            gVar.d(map);
            return gVar;
        }
    }

    public g(@NotNull String str, @NotNull String str2, @NotNull Long l10) {
        this.f27728a = str;
        this.f27729b = str2;
        this.f27730c = l10;
    }

    @NotNull
    public String a() {
        return this.f27729b;
    }

    @NotNull
    public Long b() {
        return this.f27730c;
    }

    @NotNull
    public String c() {
        return this.f27728a;
    }

    public void d(@Nullable Map<String, Object> map) {
        this.f27731d = map;
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        m3Var.e("reason").g(this.f27728a);
        m3Var.e("category").g(this.f27729b);
        m3Var.e("quantity").n(this.f27730c);
        Map<String, Object> map = this.f27731d;
        if (map != null) {
            for (String str : map.keySet()) {
                m3Var.e(str).o(w0Var, this.f27731d.get(str));
            }
        }
        m3Var.k();
    }

    public String toString() {
        return "DiscardedEvent{reason='" + this.f27728a + "', category='" + this.f27729b + "', quantity=" + this.f27730c + '}';
    }
}
