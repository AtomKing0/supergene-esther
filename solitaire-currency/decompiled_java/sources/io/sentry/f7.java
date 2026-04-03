package io.sentry;

import io.sentry.d7;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SentryLogEvents.java */
/* JADX INFO: loaded from: classes5.dex */
public final class f7 implements h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private List<d7> f27810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private Map<String, Object> f27811b;

    /* JADX INFO: compiled from: SentryLogEvents.java */
    public static final class a implements x1<f7> {
        @Override // io.sentry.x1
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public f7 deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            l3Var.h();
            List listD0 = null;
            HashMap map = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                String strC = l3Var.C();
                strC.hashCode();
                if (strC.equals("items")) {
                    listD0 = l3Var.D0(w0Var, new d7.a());
                } else {
                    if (map == null) {
                        map = new HashMap();
                    }
                    l3Var.r0(w0Var, map, strC);
                }
            }
            l3Var.k();
            if (listD0 != null) {
                f7 f7Var = new f7(listD0);
                f7Var.b(map);
                return f7Var;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"items\"");
            w0Var.b(SentryLevel.ERROR, "Missing required field \"items\"", illegalStateException);
            throw illegalStateException;
        }
    }

    public f7(@NotNull List<d7> list) {
        this.f27810a = list;
    }

    @NotNull
    public List<d7> a() {
        return this.f27810a;
    }

    public void b(@Nullable Map<String, Object> map) {
        this.f27811b = map;
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        m3Var.e("items").o(w0Var, this.f27810a);
        Map<String, Object> map = this.f27811b;
        if (map != null) {
            for (String str : map.keySet()) {
                m3Var.e(str).o(w0Var, this.f27811b.get(str));
            }
        }
        m3Var.k();
    }
}
