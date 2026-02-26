package ab;

import com.ironsource.nb;
import ga.b0;
import ga.s;
import ga.u;
import ga.v;
import ga.y;
import java.io.IOException;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: RequestBuilder.java */
/* JADX INFO: loaded from: classes5.dex */
final class w {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final char[] f514l = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Pattern f515m = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ga.v f517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private v.a f519d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final b0.a f520e = new b0.a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final u.a f521f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ga.x f522g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f523h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private y.a f524i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private s.a f525j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ga.c0 f526k;

    /* JADX INFO: compiled from: RequestBuilder.java */
    private static class a extends ga.c0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ga.c0 f527a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ga.x f528b;

        a(ga.c0 c0Var, ga.x xVar) {
            this.f527a = c0Var;
            this.f528b = xVar;
        }

        @Override // ga.c0
        public long contentLength() throws IOException {
            return this.f527a.contentLength();
        }

        @Override // ga.c0
        public ga.x contentType() {
            return this.f528b;
        }

        @Override // ga.c0
        public void writeTo(ua.d dVar) throws IOException {
            this.f527a.writeTo(dVar);
        }
    }

    w(String str, ga.v vVar, String str2, ga.u uVar, ga.x xVar, boolean z10, boolean z11, boolean z12) {
        this.f516a = str;
        this.f517b = vVar;
        this.f518c = str2;
        this.f522g = xVar;
        this.f523h = z10;
        if (uVar != null) {
            this.f521f = uVar.f();
        } else {
            this.f521f = new u.a();
        }
        if (z11) {
            this.f525j = new s.a();
        } else if (z12) {
            y.a aVar = new y.a();
            this.f524i = aVar;
            aVar.d(ga.y.f26249k);
        }
    }

    private static String i(String str, boolean z10) {
        int length = str.length();
        int iCharCount = 0;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt < 32 || iCodePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(iCodePointAt) != -1 || (!z10 && (iCodePointAt == 47 || iCodePointAt == 37))) {
                ua.c cVar = new ua.c();
                cVar.b1(str, 0, iCharCount);
                j(cVar, str, iCharCount, length, z10);
                return cVar.K0();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str;
    }

    private static void j(ua.c cVar, String str, int i10, int i11, boolean z10) {
        ua.c cVar2 = null;
        while (i10 < i11) {
            int iCodePointAt = str.codePointAt(i10);
            if (!z10 || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt < 32 || iCodePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(iCodePointAt) != -1 || (!z10 && (iCodePointAt == 47 || iCodePointAt == 37))) {
                    if (cVar2 == null) {
                        cVar2 = new ua.c();
                    }
                    cVar2.c1(iCodePointAt);
                    while (!cVar2.m0()) {
                        int i12 = cVar2.readByte() & 255;
                        cVar.writeByte(37);
                        char[] cArr = f514l;
                        cVar.writeByte(cArr[(i12 >> 4) & 15]);
                        cVar.writeByte(cArr[i12 & 15]);
                    }
                } else {
                    cVar.c1(iCodePointAt);
                }
            }
            i10 += Character.charCount(iCodePointAt);
        }
    }

    void a(String str, String str2, boolean z10) {
        if (z10) {
            this.f525j.b(str, str2);
        } else {
            this.f525j.a(str, str2);
        }
    }

    void b(String str, String str2) {
        if (!nb.K.equalsIgnoreCase(str)) {
            this.f521f.a(str, str2);
            return;
        }
        try {
            this.f522g = ga.x.e(str2);
        } catch (IllegalArgumentException e10) {
            throw new IllegalArgumentException("Malformed content type: " + str2, e10);
        }
    }

    void c(ga.u uVar) {
        this.f521f.b(uVar);
    }

    void d(ga.u uVar, ga.c0 c0Var) {
        this.f524i.a(uVar, c0Var);
    }

    void e(y.c cVar) {
        this.f524i.b(cVar);
    }

    void f(String str, String str2, boolean z10) {
        if (this.f518c == null) {
            throw new AssertionError();
        }
        String strI = i(str2, z10);
        String strReplace = this.f518c.replace("{" + str + "}", strI);
        if (!f515m.matcher(strReplace).matches()) {
            this.f518c = strReplace;
            return;
        }
        throw new IllegalArgumentException("@Path parameters shouldn't perform path traversal ('.' or '..'): " + str2);
    }

    void g(String str, String str2, boolean z10) {
        String str3 = this.f518c;
        if (str3 != null) {
            v.a aVarL = this.f517b.l(str3);
            this.f519d = aVarL;
            if (aVarL == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f517b + ", Relative: " + this.f518c);
            }
            this.f518c = null;
        }
        if (z10) {
            this.f519d.a(str, str2);
        } else {
            this.f519d.b(str, str2);
        }
    }

    <T> void h(Class<T> cls, T t10) {
        this.f520e.q(cls, t10);
    }

    b0.a k() {
        ga.v vVarQ;
        v.a aVar = this.f519d;
        if (aVar != null) {
            vVarQ = aVar.c();
        } else {
            vVarQ = this.f517b.q(this.f518c);
            if (vVarQ == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f517b + ", Relative: " + this.f518c);
            }
        }
        ga.c0 aVar2 = this.f526k;
        if (aVar2 == null) {
            s.a aVar3 = this.f525j;
            if (aVar3 != null) {
                aVar2 = aVar3.c();
            } else {
                y.a aVar4 = this.f524i;
                if (aVar4 != null) {
                    aVar2 = aVar4.c();
                } else if (this.f523h) {
                    aVar2 = ga.c0.create((ga.x) null, new byte[0]);
                }
            }
        }
        ga.x xVar = this.f522g;
        if (xVar != null) {
            if (aVar2 != null) {
                aVar2 = new a(aVar2, xVar);
            } else {
                this.f521f.a(nb.K, xVar.toString());
            }
        }
        return this.f520e.r(vVarQ).h(this.f521f.f()).i(this.f516a, aVar2);
    }

    void l(ga.c0 c0Var) {
        this.f526k = c0Var;
    }

    void m(Object obj) {
        this.f518c = obj.toString();
    }
}
