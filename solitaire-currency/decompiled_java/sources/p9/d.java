package p9;

import java.nio.charset.Charset;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Charsets.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f32951a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final Charset f32952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final Charset f32953c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final Charset f32954d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public static final Charset f32955e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public static final Charset f32956f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public static final Charset f32957g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private static volatile Charset f32958h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private static volatile Charset f32959i;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        kotlin.jvm.internal.t.h(charsetForName, "forName(\"UTF-8\")");
        f32952b = charsetForName;
        Charset charsetForName2 = Charset.forName("UTF-16");
        kotlin.jvm.internal.t.h(charsetForName2, "forName(\"UTF-16\")");
        f32953c = charsetForName2;
        Charset charsetForName3 = Charset.forName("UTF-16BE");
        kotlin.jvm.internal.t.h(charsetForName3, "forName(\"UTF-16BE\")");
        f32954d = charsetForName3;
        Charset charsetForName4 = Charset.forName("UTF-16LE");
        kotlin.jvm.internal.t.h(charsetForName4, "forName(\"UTF-16LE\")");
        f32955e = charsetForName4;
        Charset charsetForName5 = Charset.forName("US-ASCII");
        kotlin.jvm.internal.t.h(charsetForName5, "forName(\"US-ASCII\")");
        f32956f = charsetForName5;
        Charset charsetForName6 = Charset.forName("ISO-8859-1");
        kotlin.jvm.internal.t.h(charsetForName6, "forName(\"ISO-8859-1\")");
        f32957g = charsetForName6;
    }

    private d() {
    }

    @NotNull
    public final Charset a() {
        Charset charset = f32959i;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32BE");
        kotlin.jvm.internal.t.h(charsetForName, "forName(\"UTF-32BE\")");
        f32959i = charsetForName;
        return charsetForName;
    }

    @NotNull
    public final Charset b() {
        Charset charset = f32958h;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32LE");
        kotlin.jvm.internal.t.h(charsetForName, "forName(\"UTF-32LE\")");
        f32958h = charsetForName;
        return charsetForName;
    }
}
