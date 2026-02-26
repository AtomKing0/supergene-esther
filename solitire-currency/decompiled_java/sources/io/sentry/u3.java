package io.sentry;

import io.sentry.protocol.SentryId;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ProfileContext.java */
/* JADX INFO: loaded from: classes5.dex */
public final class u3 implements h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private SentryId f28312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private Map<String, Object> f28313b;

    /* JADX INFO: compiled from: ProfileContext.java */
    public static final class a implements x1<u3> {
        @Override // io.sentry.x1
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public u3 deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            l3Var.h();
            u3 u3Var = new u3();
            ConcurrentHashMap concurrentHashMap = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                String strC = l3Var.C();
                strC.hashCode();
                if (strC.equals("profiler_id")) {
                    SentryId sentryId = (SentryId) l3Var.M(w0Var, new SentryId.Deserializer());
                    if (sentryId != null) {
                        u3Var.f28312a = sentryId;
                    }
                } else {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    l3Var.r0(w0Var, concurrentHashMap, strC);
                }
            }
            u3Var.b(concurrentHashMap);
            l3Var.k();
            return u3Var;
        }
    }

    public u3() {
        this(SentryId.EMPTY_ID);
    }

    public void b(@Nullable Map<String, Object> map) {
        this.f28313b = map;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof u3) {
            return this.f28312a.equals(((u3) obj).f28312a);
        }
        return false;
    }

    public int hashCode() {
        return io.sentry.util.w.b(this.f28312a);
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        m3Var.e("profiler_id").o(w0Var, this.f28312a);
        Map<String, Object> map = this.f28313b;
        if (map != null) {
            for (String str : map.keySet()) {
                m3Var.e(str).o(w0Var, this.f28313b.get(str));
            }
        }
        m3Var.k();
    }

    public u3(@NotNull SentryId sentryId) {
        this.f28312a = sentryId;
    }

    public u3(@NotNull u3 u3Var) {
        this.f28312a = u3Var.f28312a;
        Map<String, Object> mapB = io.sentry.util.c.b(u3Var.f28313b);
        if (mapB != null) {
            this.f28313b = mapB;
        }
    }
}
