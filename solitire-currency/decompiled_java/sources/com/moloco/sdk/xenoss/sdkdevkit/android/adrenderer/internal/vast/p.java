package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast;

import com.moloco.sdk.service_locator.a;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.s0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final v8.l f20741a = v8.n.a(a.f20749g);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final p9.f f20742b = new p9.f("\\[ERRORCODE]");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final p9.f f20743c = new p9.f("\\[CONTENTPLAYHEAD]");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final p9.f f20744d = new p9.f("\\[CACHEBUSTING]");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public static final p9.f f20745e = new p9.f("\\[ASSETURI]");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public static final p9.f f20746f = new p9.f("\\[[^]]*]");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public static final p9.f f20747g = new p9.f("\\[MEDIAPLAYHEAD]");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public static final p9.f f20748h = new p9.f("\\[ADPLAYHEAD]");

    public static final class a extends v implements h9.a<o> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f20749g = new a();

        public a() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final o invoke() {
            return new o(a.i.f18932a.c());
        }
    }

    @NotNull
    public static final n a() {
        return j();
    }

    public static final String b(int i10) {
        return f(i10);
    }

    public static final String c(String str) {
        try {
            String strEncode = URLEncoder.encode(str, "UTF-8");
            t.h(strEncode, "{\n        URLEncoder.encode(this, \"UTF-8\")\n    }");
            return strEncode;
        } catch (Exception unused) {
            return "";
        }
    }

    public static final String f(int i10) {
        long j10 = i10;
        s0 s0Var = s0.f29840a;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        String str = String.format("%02d:%02d:%02d.%03d", Arrays.copyOf(new Object[]{Long.valueOf(timeUnit.toHours(j10)), Long.valueOf(timeUnit.toMinutes(j10) % TimeUnit.HOURS.toMinutes(1L)), Long.valueOf(timeUnit.toSeconds(j10) % TimeUnit.MINUTES.toSeconds(1L)), Long.valueOf(j10 % ((long) 1000))}, 4));
        t.h(str, "format(format, *args)");
        return str;
    }

    public static final String g(String str, Integer num, Integer num2, String str2, String str3) {
        if (num != null) {
            num.intValue();
            str = f20742b.b(str, num.toString());
        }
        if (num2 != null) {
            num2.intValue();
            str = f20747g.b(f20748h.b(f20743c.b(str, f(num2.intValue())), b(num2.intValue())), i(num2.intValue()));
        }
        if (str2 != null) {
            str = f20745e.b(str, c(str2));
        }
        if (str3 != null) {
            str = f20744d.b(str, str3);
        }
        return f20746f.b(str, "");
    }

    public static final String h() {
        s0 s0Var = s0.f29840a;
        String str = String.format("%08d", Arrays.copyOf(new Object[]{Integer.valueOf(l9.c.f30972a.e(1, 99999999))}, 1));
        t.h(str, "format(format, *args)");
        return str;
    }

    public static final String i(int i10) {
        return "-1";
    }

    public static final o j() {
        return (o) f20741a.getValue();
    }
}
