package io.sentry;

import io.sentry.i5;
import io.sentry.protocol.SentryId;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SentryReplayEvent.java */
/* JADX INFO: loaded from: classes5.dex */
public final class p7 extends i5 implements h2 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f28054d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private Date f28056f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private Map<String, Object> f28060j;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private SentryId f28053c = new SentryId();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private String f28051a = "replay_event";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private b f28052b = b.SESSION;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private List<String> f28058h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private List<String> f28059i = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private List<String> f28057g = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private Date f28055e = n.d();

    /* JADX INFO: compiled from: SentryReplayEvent.java */
    public static final class a implements x1<p7> {
        @Override // io.sentry.x1
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public p7 deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            String strC;
            i5.a aVar = new i5.a();
            p7 p7Var = new p7();
            l3Var.h();
            String strO0 = null;
            b bVar = null;
            Integer numG0 = null;
            Date dateF = null;
            HashMap map = null;
            SentryId sentryId = null;
            Date dateF2 = null;
            List<String> list = null;
            List<String> list2 = null;
            List<String> list3 = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strC = l3Var.C();
                strC.hashCode();
                switch (strC) {
                    case "replay_id":
                        sentryId = (SentryId) l3Var.M(w0Var, new SentryId.Deserializer());
                        break;
                    case "replay_start_timestamp":
                        dateF2 = l3Var.F(w0Var);
                        break;
                    case "type":
                        strO0 = l3Var.o0();
                        break;
                    case "urls":
                        list = (List) l3Var.A0();
                        break;
                    case "timestamp":
                        dateF = l3Var.F(w0Var);
                        break;
                    case "error_ids":
                        list2 = (List) l3Var.A0();
                        break;
                    case "trace_ids":
                        list3 = (List) l3Var.A0();
                        break;
                    case "replay_type":
                        bVar = (b) l3Var.M(w0Var, new b.a());
                        break;
                    case "segment_id":
                        numG0 = l3Var.g0();
                        break;
                    default:
                        if (!aVar.a(p7Var, strC, l3Var, w0Var)) {
                            if (map == null) {
                                map = new HashMap();
                            }
                            l3Var.r0(w0Var, map, strC);
                            break;
                        } else {
                            break;
                        }
                        break;
                }
            }
            l3Var.k();
            if (strO0 != null) {
                p7Var.h(strO0);
            }
            if (bVar != null) {
                p7Var.d(bVar);
            }
            if (numG0 != null) {
                p7Var.e(numG0.intValue());
            }
            if (dateF != null) {
                p7Var.f(dateF);
            }
            p7Var.b(sentryId);
            p7Var.c(dateF2);
            p7Var.i(list);
            p7Var.a(list2);
            p7Var.g(list3);
            p7Var.setUnknown(map);
            return p7Var;
        }
    }

    /* JADX INFO: compiled from: SentryReplayEvent.java */
    public enum b implements h2 {
        SESSION,
        BUFFER;

        /* JADX INFO: compiled from: SentryReplayEvent.java */
        public static final class a implements x1<b> {
            @Override // io.sentry.x1
            @NotNull
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public b deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
                return b.valueOf(l3Var.e0().toUpperCase(Locale.ROOT));
            }
        }

        @Override // io.sentry.h2
        public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
            m3Var.g(name().toLowerCase(Locale.ROOT));
        }
    }

    public void a(@Nullable List<String> list) {
        this.f28058h = list;
    }

    public void b(@Nullable SentryId sentryId) {
        this.f28053c = sentryId;
    }

    public void c(@Nullable Date date) {
        this.f28056f = date;
    }

    public void d(@NotNull b bVar) {
        this.f28052b = bVar;
    }

    public void e(int i10) {
        this.f28054d = i10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p7.class != obj.getClass()) {
            return false;
        }
        p7 p7Var = (p7) obj;
        return this.f28054d == p7Var.f28054d && io.sentry.util.w.a(this.f28051a, p7Var.f28051a) && this.f28052b == p7Var.f28052b && io.sentry.util.w.a(this.f28053c, p7Var.f28053c) && io.sentry.util.w.a(this.f28057g, p7Var.f28057g) && io.sentry.util.w.a(this.f28058h, p7Var.f28058h) && io.sentry.util.w.a(this.f28059i, p7Var.f28059i);
    }

    public void f(@NotNull Date date) {
        this.f28055e = date;
    }

    public void g(@Nullable List<String> list) {
        this.f28059i = list;
    }

    public void h(@NotNull String str) {
        this.f28051a = str;
    }

    public int hashCode() {
        return io.sentry.util.w.b(this.f28051a, this.f28052b, this.f28053c, Integer.valueOf(this.f28054d), this.f28057g, this.f28058h, this.f28059i);
    }

    public void i(@Nullable List<String> list) {
        this.f28057g = list;
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        m3Var.e("type").g(this.f28051a);
        m3Var.e("replay_type").o(w0Var, this.f28052b);
        m3Var.e("segment_id").a(this.f28054d);
        m3Var.e("timestamp").o(w0Var, this.f28055e);
        if (this.f28053c != null) {
            m3Var.e("replay_id").o(w0Var, this.f28053c);
        }
        if (this.f28056f != null) {
            m3Var.e("replay_start_timestamp").o(w0Var, this.f28056f);
        }
        if (this.f28057g != null) {
            m3Var.e("urls").o(w0Var, this.f28057g);
        }
        if (this.f28058h != null) {
            m3Var.e("error_ids").o(w0Var, this.f28058h);
        }
        if (this.f28059i != null) {
            m3Var.e("trace_ids").o(w0Var, this.f28059i);
        }
        new i5.b().a(this, m3Var, w0Var);
        Map<String, Object> map = this.f28060j;
        if (map != null) {
            for (String str : map.keySet()) {
                m3Var.e(str).o(w0Var, this.f28060j.get(str));
            }
        }
        m3Var.k();
    }

    public void setUnknown(@Nullable Map<String, Object> map) {
        this.f28060j = map;
    }
}
