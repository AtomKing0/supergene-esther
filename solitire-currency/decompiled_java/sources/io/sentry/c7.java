package io.sentry;

import com.ironsource.v8;
import io.sentry.protocol.SentryException;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SentryLockReason.java */
/* JADX INFO: loaded from: classes5.dex */
public final class c7 implements h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f27639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private String f27640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private String f27641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private String f27642d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private Long f27643e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private Map<String, Object> f27644f;

    /* JADX INFO: compiled from: SentryLockReason.java */
    public static final class a implements x1<c7> {
        @Override // io.sentry.x1
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c7 deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            String strC;
            c7 c7Var = new c7();
            l3Var.h();
            ConcurrentHashMap concurrentHashMap = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strC = l3Var.C();
                strC.hashCode();
                switch (strC) {
                    case "package_name":
                        c7Var.f27641c = l3Var.o0();
                        break;
                    case "thread_id":
                        c7Var.f27643e = l3Var.j0();
                        break;
                    case "address":
                        c7Var.f27640b = l3Var.o0();
                        break;
                    case "class_name":
                        c7Var.f27642d = l3Var.o0();
                        break;
                    case "type":
                        c7Var.f27639a = l3Var.nextInt();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        l3Var.r0(w0Var, concurrentHashMap, strC);
                        break;
                }
            }
            c7Var.m(concurrentHashMap);
            l3Var.k();
            return c7Var;
        }
    }

    public c7() {
    }

    public c7(@NotNull c7 c7Var) {
        this.f27639a = c7Var.f27639a;
        this.f27640b = c7Var.f27640b;
        this.f27641c = c7Var.f27641c;
        this.f27642d = c7Var.f27642d;
        this.f27643e = c7Var.f27643e;
        this.f27644f = io.sentry.util.c.b(c7Var.f27644f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c7.class != obj.getClass()) {
            return false;
        }
        return io.sentry.util.w.a(this.f27640b, ((c7) obj).f27640b);
    }

    @Nullable
    public String f() {
        return this.f27640b;
    }

    public int g() {
        return this.f27639a;
    }

    public void h(@Nullable String str) {
        this.f27640b = str;
    }

    public int hashCode() {
        return io.sentry.util.w.b(this.f27640b);
    }

    public void i(@Nullable String str) {
        this.f27642d = str;
    }

    public void j(@Nullable String str) {
        this.f27641c = str;
    }

    public void k(@Nullable Long l10) {
        this.f27643e = l10;
    }

    public void l(int i10) {
        this.f27639a = i10;
    }

    public void m(@Nullable Map<String, Object> map) {
        this.f27644f = map;
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        m3Var.e("type").a(this.f27639a);
        if (this.f27640b != null) {
            m3Var.e("address").g(this.f27640b);
        }
        if (this.f27641c != null) {
            m3Var.e(v8.h.V).g(this.f27641c);
        }
        if (this.f27642d != null) {
            m3Var.e("class_name").g(this.f27642d);
        }
        if (this.f27643e != null) {
            m3Var.e(SentryException.JsonKeys.THREAD_ID).n(this.f27643e);
        }
        Map<String, Object> map = this.f27644f;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.f27644f.get(str);
                m3Var.e(str);
                m3Var.o(w0Var, obj);
            }
        }
        m3Var.k();
    }
}
