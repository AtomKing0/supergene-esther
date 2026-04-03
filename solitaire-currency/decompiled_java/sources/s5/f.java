package s5;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ironsource.v8;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import s5.d;

/* JADX INFO: compiled from: ProtobufDataEncoderContext.java */
/* JADX INFO: loaded from: classes3.dex */
final class f implements p5.e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Charset f33564f = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final p5.c f33565g = p5.c.a(v8.h.W).b(s5.a.b().c(1).a()).a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final p5.c f33566h = p5.c.a("value").b(s5.a.b().c(2).a()).a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final p5.d<Map.Entry<Object, Object>> f33567i = new p5.d() { // from class: s5.e
        @Override // p5.d
        public final void a(Object obj, Object obj2) throws IOException {
            f.t((Map.Entry) obj, (p5.e) obj2);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private OutputStream f33568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<Class<?>, p5.d<?>> f33569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<Class<?>, p5.f<?>> f33570c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final p5.d<Object> f33571d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final i f33572e = new i(this);

    /* JADX INFO: compiled from: ProtobufDataEncoderContext.java */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f33573a;

        static {
            int[] iArr = new int[d.a.values().length];
            f33573a = iArr;
            try {
                iArr[d.a.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33573a[d.a.SIGNED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33573a[d.a.FIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    f(OutputStream outputStream, Map<Class<?>, p5.d<?>> map, Map<Class<?>, p5.f<?>> map2, p5.d<Object> dVar) {
        this.f33568a = outputStream;
        this.f33569b = map;
        this.f33570c = map2;
        this.f33571d = dVar;
    }

    private static ByteBuffer m(int i10) {
        return ByteBuffer.allocate(i10).order(ByteOrder.LITTLE_ENDIAN);
    }

    private <T> long n(p5.d<T> dVar, T t10) throws IOException {
        b bVar = new b();
        try {
            OutputStream outputStream = this.f33568a;
            this.f33568a = bVar;
            try {
                dVar.a(t10, this);
                this.f33568a = outputStream;
                long jA = bVar.a();
                bVar.close();
                return jA;
            } catch (Throwable th) {
                this.f33568a = outputStream;
                throw th;
            }
        } catch (Throwable th2) {
            try {
                bVar.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    private <T> f o(p5.d<T> dVar, p5.c cVar, T t10, boolean z10) throws IOException {
        long jN = n(dVar, t10);
        if (z10 && jN == 0) {
            return this;
        }
        u((s(cVar) << 3) | 2);
        v(jN);
        dVar.a(t10, this);
        return this;
    }

    private <T> f p(p5.f<T> fVar, p5.c cVar, T t10, boolean z10) throws IOException {
        this.f33572e.c(cVar, z10);
        fVar.a(t10, this.f33572e);
        return this;
    }

    private static d r(p5.c cVar) {
        d dVar = (d) cVar.c(d.class);
        if (dVar != null) {
            return dVar;
        }
        throw new p5.b("Field has no @Protobuf config");
    }

    private static int s(p5.c cVar) {
        d dVar = (d) cVar.c(d.class);
        if (dVar != null) {
            return dVar.tag();
        }
        throw new p5.b("Field has no @Protobuf config");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void t(Map.Entry entry, p5.e eVar) throws IOException {
        eVar.d(f33565g, entry.getKey());
        eVar.d(f33566h, entry.getValue());
    }

    private void u(int i10) throws IOException {
        while ((i10 & (-128)) != 0) {
            this.f33568a.write((i10 & 127) | 128);
            i10 >>>= 7;
        }
        this.f33568a.write(i10 & 127);
    }

    private void v(long j10) throws IOException {
        while (((-128) & j10) != 0) {
            this.f33568a.write((((int) j10) & 127) | 128);
            j10 >>>= 7;
        }
        this.f33568a.write(((int) j10) & 127);
    }

    @Override // p5.e
    @NonNull
    public p5.e d(@NonNull p5.c cVar, @Nullable Object obj) throws IOException {
        return g(cVar, obj, true);
    }

    p5.e e(@NonNull p5.c cVar, double d10, boolean z10) throws IOException {
        if (z10 && d10 == 0.0d) {
            return this;
        }
        u((s(cVar) << 3) | 1);
        this.f33568a.write(m(8).putDouble(d10).array());
        return this;
    }

    p5.e f(@NonNull p5.c cVar, float f10, boolean z10) throws IOException {
        if (z10 && f10 == 0.0f) {
            return this;
        }
        u((s(cVar) << 3) | 5);
        this.f33568a.write(m(4).putFloat(f10).array());
        return this;
    }

    p5.e g(@NonNull p5.c cVar, @Nullable Object obj, boolean z10) throws IOException {
        if (obj == null) {
            return this;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z10 && charSequence.length() == 0) {
                return this;
            }
            u((s(cVar) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(f33564f);
            u(bytes.length);
            this.f33568a.write(bytes);
            return this;
        }
        if (obj instanceof Collection) {
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                g(cVar, it.next(), false);
            }
            return this;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                o(f33567i, cVar, (Map.Entry) it2.next(), false);
            }
            return this;
        }
        if (obj instanceof Double) {
            return e(cVar, ((Double) obj).doubleValue(), z10);
        }
        if (obj instanceof Float) {
            return f(cVar, ((Float) obj).floatValue(), z10);
        }
        if (obj instanceof Number) {
            return k(cVar, ((Number) obj).longValue(), z10);
        }
        if (obj instanceof Boolean) {
            return l(cVar, ((Boolean) obj).booleanValue(), z10);
        }
        if (!(obj instanceof byte[])) {
            p5.d<?> dVar = this.f33569b.get(obj.getClass());
            if (dVar != null) {
                return o(dVar, cVar, obj, z10);
            }
            p5.f<?> fVar = this.f33570c.get(obj.getClass());
            return fVar != null ? p(fVar, cVar, obj, z10) : obj instanceof c ? c(cVar, ((c) obj).getNumber()) : obj instanceof Enum ? c(cVar, ((Enum) obj).ordinal()) : o(this.f33571d, cVar, obj, z10);
        }
        byte[] bArr = (byte[]) obj;
        if (z10 && bArr.length == 0) {
            return this;
        }
        u((s(cVar) << 3) | 2);
        u(bArr.length);
        this.f33568a.write(bArr);
        return this;
    }

    @Override // p5.e
    @NonNull
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public f c(@NonNull p5.c cVar, int i10) throws IOException {
        return i(cVar, i10, true);
    }

    f i(@NonNull p5.c cVar, int i10, boolean z10) throws IOException {
        if (z10 && i10 == 0) {
            return this;
        }
        d dVarR = r(cVar);
        int i11 = a.f33573a[dVarR.intEncoding().ordinal()];
        if (i11 == 1) {
            u(dVarR.tag() << 3);
            u(i10);
        } else if (i11 == 2) {
            u(dVarR.tag() << 3);
            u((i10 << 1) ^ (i10 >> 31));
        } else if (i11 == 3) {
            u((dVarR.tag() << 3) | 5);
            this.f33568a.write(m(4).putInt(i10).array());
        }
        return this;
    }

    @Override // p5.e
    @NonNull
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public f b(@NonNull p5.c cVar, long j10) throws IOException {
        return k(cVar, j10, true);
    }

    f k(@NonNull p5.c cVar, long j10, boolean z10) throws IOException {
        if (z10 && j10 == 0) {
            return this;
        }
        d dVarR = r(cVar);
        int i10 = a.f33573a[dVarR.intEncoding().ordinal()];
        if (i10 == 1) {
            u(dVarR.tag() << 3);
            v(j10);
        } else if (i10 == 2) {
            u(dVarR.tag() << 3);
            v((j10 >> 63) ^ (j10 << 1));
        } else if (i10 == 3) {
            u((dVarR.tag() << 3) | 1);
            this.f33568a.write(m(8).putLong(j10).array());
        }
        return this;
    }

    f l(@NonNull p5.c cVar, boolean z10, boolean z11) throws IOException {
        return i(cVar, z10 ? 1 : 0, z11);
    }

    f q(@Nullable Object obj) throws IOException {
        if (obj == null) {
            return this;
        }
        p5.d<?> dVar = this.f33569b.get(obj.getClass());
        if (dVar != null) {
            dVar.a(obj, this);
            return this;
        }
        throw new p5.b("No encoder for " + obj.getClass());
    }
}
