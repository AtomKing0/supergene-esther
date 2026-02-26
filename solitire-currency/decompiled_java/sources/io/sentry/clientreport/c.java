package io.sentry.clientreport;

import io.sentry.SentryLevel;
import io.sentry.clientreport.g;
import io.sentry.h2;
import io.sentry.l3;
import io.sentry.m3;
import io.sentry.n;
import io.sentry.w0;
import io.sentry.x1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ClientReport.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class c implements h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Date f27721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final List<g> f27722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private Map<String, Object> f27723c;

    /* JADX INFO: compiled from: ClientReport.java */
    public static final class a implements x1<c> {
        private Exception b(String str, w0 w0Var) {
            String str2 = "Missing required field \"" + str + "\"";
            IllegalStateException illegalStateException = new IllegalStateException(str2);
            w0Var.b(SentryLevel.ERROR, str2, illegalStateException);
            return illegalStateException;
        }

        @Override // io.sentry.x1
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            ArrayList arrayList = new ArrayList();
            l3Var.h();
            Date dateF = null;
            HashMap map = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                String strC = l3Var.C();
                strC.hashCode();
                if (strC.equals("discarded_events")) {
                    arrayList.addAll(l3Var.D0(w0Var, new g.a()));
                } else if (strC.equals("timestamp")) {
                    dateF = l3Var.F(w0Var);
                } else {
                    if (map == null) {
                        map = new HashMap();
                    }
                    l3Var.r0(w0Var, map, strC);
                }
            }
            l3Var.k();
            if (dateF == null) {
                throw b("timestamp", w0Var);
            }
            if (arrayList.isEmpty()) {
                throw b("discarded_events", w0Var);
            }
            c cVar = new c(dateF, arrayList);
            cVar.b(map);
            return cVar;
        }
    }

    public c(@NotNull Date date, @NotNull List<g> list) {
        this.f27721a = date;
        this.f27722b = list;
    }

    @NotNull
    public List<g> a() {
        return this.f27722b;
    }

    public void b(@Nullable Map<String, Object> map) {
        this.f27723c = map;
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        m3Var.e("timestamp").g(n.h(this.f27721a));
        m3Var.e("discarded_events").o(w0Var, this.f27722b);
        Map<String, Object> map = this.f27723c;
        if (map != null) {
            for (String str : map.keySet()) {
                m3Var.e(str).o(w0Var, this.f27723c.get(str));
            }
        }
        m3Var.k();
    }
}
