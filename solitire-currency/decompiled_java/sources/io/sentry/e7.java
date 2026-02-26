package io.sentry;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SentryLogEventAttributeValue.java */
/* JADX INFO: loaded from: classes5.dex */
public final class e7 implements h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private String f27781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private Object f27782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private Map<String, Object> f27783c;

    /* JADX INFO: compiled from: SentryLogEventAttributeValue.java */
    public static final class a implements x1<e7> {
        @Override // io.sentry.x1
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e7 deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            l3Var.h();
            String strO0 = null;
            Object objA0 = null;
            HashMap map = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                String strC = l3Var.C();
                strC.hashCode();
                if (strC.equals("type")) {
                    strO0 = l3Var.o0();
                } else if (strC.equals("value")) {
                    objA0 = l3Var.A0();
                } else {
                    if (map == null) {
                        map = new HashMap();
                    }
                    l3Var.r0(w0Var, map, strC);
                }
            }
            l3Var.k();
            if (strO0 != null) {
                e7 e7Var = new e7(strO0, objA0);
                e7Var.a(map);
                return e7Var;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"type\"");
            w0Var.b(SentryLevel.ERROR, "Missing required field \"type\"", illegalStateException);
            throw illegalStateException;
        }
    }

    public e7(@NotNull String str, @Nullable Object obj) {
        this.f27781a = str;
        if (obj == null || !str.equals(TypedValues.Custom.S_STRING)) {
            this.f27782b = obj;
        } else {
            this.f27782b = obj.toString();
        }
    }

    public void a(@Nullable Map<String, Object> map) {
        this.f27783c = map;
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        m3Var.e("type").o(w0Var, this.f27781a);
        m3Var.e("value").o(w0Var, this.f27782b);
        Map<String, Object> map = this.f27783c;
        if (map != null) {
            for (String str : map.keySet()) {
                m3Var.e(str).o(w0Var, this.f27783c.get(str));
            }
        }
        m3Var.k();
    }
}
