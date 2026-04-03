package f8;

import e8.d;
import e8.v;
import f8.b;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.q;
import p9.t;

/* JADX INFO: compiled from: TextContent.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c extends b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f25731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final e8.c f25732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final v f25733c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final byte[] f25734d;

    public /* synthetic */ c(String str, e8.c cVar, v vVar, int i10, k kVar) {
        this(str, cVar, (i10 & 4) != 0 ? null : vVar);
    }

    @Override // f8.b
    @NotNull
    public Long a() {
        return Long.valueOf(this.f25734d.length);
    }

    @Override // f8.b
    @NotNull
    public e8.c b() {
        return this.f25732b;
    }

    @Override // f8.b.a
    @NotNull
    public byte[] d() {
        return this.f25734d;
    }

    @NotNull
    public String toString() {
        return "TextContent[" + b() + "] \"" + t.h1(this.f25731a, 30) + '\"';
    }

    public c(@NotNull String text, @NotNull e8.c contentType, @Nullable v vVar) {
        byte[] bArrG;
        kotlin.jvm.internal.t.i(text, "text");
        kotlin.jvm.internal.t.i(contentType, "contentType");
        this.f25731a = text;
        this.f25732b = contentType;
        this.f25733c = vVar;
        Charset charsetA = d.a(b());
        charsetA = charsetA == null ? p9.d.f32952b : charsetA;
        if (kotlin.jvm.internal.t.d(charsetA, p9.d.f32952b)) {
            bArrG = q.u(text);
        } else {
            CharsetEncoder charsetEncoderNewEncoder = charsetA.newEncoder();
            kotlin.jvm.internal.t.h(charsetEncoderNewEncoder, "charset.newEncoder()");
            bArrG = o8.a.g(charsetEncoderNewEncoder, text, 0, text.length());
        }
        this.f25734d = bArrG;
    }
}
