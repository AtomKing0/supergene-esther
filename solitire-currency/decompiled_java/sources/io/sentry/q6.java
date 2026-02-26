package io.sentry;

import io.sentry.b7;
import io.sentry.protocol.SentryStackFrame;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SentryEnvelopeItemHeader.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class q6 implements h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final String f28112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final Integer f28113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final String f28114c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final String f28115d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final b7 f28116e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f28117f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private final Callable<Integer> f28118g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private final String f28119h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private Map<String, Object> f28120i;

    /* JADX INFO: compiled from: SentryEnvelopeItemHeader.java */
    public static final class a implements x1<q6> {
        private Exception b(String str, w0 w0Var) {
            String str2 = "Missing required field \"" + str + "\"";
            IllegalStateException illegalStateException = new IllegalStateException(str2);
            w0Var.b(SentryLevel.ERROR, str2, illegalStateException);
            return illegalStateException;
        }

        @Override // io.sentry.x1
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public q6 deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            String strC;
            l3Var.h();
            HashMap map = null;
            b7 b7Var = null;
            String strO0 = null;
            String strO02 = null;
            String strO03 = null;
            String strO04 = null;
            Integer numG0 = null;
            int iNextInt = 0;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strC = l3Var.C();
                strC.hashCode();
                switch (strC) {
                    case "item_count":
                        numG0 = l3Var.g0();
                        break;
                    case "length":
                        iNextInt = l3Var.nextInt();
                        break;
                    case "filename":
                        strO02 = l3Var.o0();
                        break;
                    case "attachment_type":
                        strO03 = l3Var.o0();
                        break;
                    case "type":
                        b7Var = (b7) l3Var.M(w0Var, new b7.a());
                        break;
                    case "content_type":
                        strO0 = l3Var.o0();
                        break;
                    case "platform":
                        strO04 = l3Var.o0();
                        break;
                    default:
                        if (map == null) {
                            map = new HashMap();
                        }
                        l3Var.r0(w0Var, map, strC);
                        break;
                }
            }
            if (b7Var == null) {
                throw b("type", w0Var);
            }
            q6 q6Var = new q6(b7Var, iNextInt, strO0, strO02, strO03, strO04, numG0);
            q6Var.c(map);
            l3Var.k();
            return q6Var;
        }
    }

    @ApiStatus.Internal
    public q6(@NotNull b7 b7Var, int i10, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Integer num) {
        this.f28116e = (b7) io.sentry.util.w.c(b7Var, "type is required");
        this.f28112a = str;
        this.f28117f = i10;
        this.f28114c = str2;
        this.f28118g = null;
        this.f28119h = str3;
        this.f28115d = str4;
        this.f28113b = num;
    }

    public int a() {
        Callable<Integer> callable = this.f28118g;
        if (callable == null) {
            return this.f28117f;
        }
        try {
            return callable.call().intValue();
        } catch (Throwable unused) {
            return -1;
        }
    }

    @NotNull
    public b7 b() {
        return this.f28116e;
    }

    public void c(@Nullable Map<String, Object> map) {
        this.f28120i = map;
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        if (this.f28112a != null) {
            m3Var.e("content_type").g(this.f28112a);
        }
        if (this.f28114c != null) {
            m3Var.e(SentryStackFrame.JsonKeys.FILENAME).g(this.f28114c);
        }
        m3Var.e("type").o(w0Var, this.f28116e);
        if (this.f28119h != null) {
            m3Var.e("attachment_type").g(this.f28119h);
        }
        if (this.f28115d != null) {
            m3Var.e("platform").g(this.f28115d);
        }
        if (this.f28113b != null) {
            m3Var.e("item_count").n(this.f28113b);
        }
        m3Var.e("length").a(a());
        Map<String, Object> map = this.f28120i;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.f28120i.get(str);
                m3Var.e(str);
                m3Var.o(w0Var, obj);
            }
        }
        m3Var.k();
    }

    q6(@NotNull b7 b7Var, @Nullable Callable<Integer> callable, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        this(b7Var, callable, str, str2, str3, (String) null, (Integer) null);
    }

    q6(@NotNull b7 b7Var, @Nullable Callable<Integer> callable, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Integer num) {
        this.f28116e = (b7) io.sentry.util.w.c(b7Var, "type is required");
        this.f28112a = str;
        this.f28117f = -1;
        this.f28114c = str2;
        this.f28118g = callable;
        this.f28119h = str3;
        this.f28115d = str4;
        this.f28113b = num;
    }

    q6(@NotNull b7 b7Var, @Nullable Callable<Integer> callable, @Nullable String str, @Nullable String str2) {
        this(b7Var, callable, str, str2, null);
    }
}
