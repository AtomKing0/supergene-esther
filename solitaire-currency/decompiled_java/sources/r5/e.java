package r5;

import android.util.Base64;
import android.util.JsonWriter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import p5.f;
import p5.g;

/* JADX INFO: compiled from: JsonValueObjectEncoderContext.java */
/* JADX INFO: loaded from: classes3.dex */
final class e implements p5.e, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e f33317a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f33318b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final JsonWriter f33319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<Class<?>, p5.d<?>> f33320d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<Class<?>, f<?>> f33321e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final p5.d<Object> f33322f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f33323g;

    e(@NonNull Writer writer, @NonNull Map<Class<?>, p5.d<?>> map, @NonNull Map<Class<?>, f<?>> map2, p5.d<Object> dVar, boolean z10) {
        this.f33319c = new JsonWriter(writer);
        this.f33320d = map;
        this.f33321e = map2;
        this.f33322f = dVar;
        this.f33323g = z10;
    }

    private boolean o(Object obj) {
        return obj == null || obj.getClass().isArray() || (obj instanceof Collection) || (obj instanceof Date) || (obj instanceof Enum) || (obj instanceof Number);
    }

    private e r(@NonNull String str, @Nullable Object obj) throws IOException, p5.b {
        t();
        this.f33319c.name(str);
        if (obj != null) {
            return h(obj, false);
        }
        this.f33319c.nullValue();
        return this;
    }

    private e s(@NonNull String str, @Nullable Object obj) throws IOException, p5.b {
        if (obj == null) {
            return this;
        }
        t();
        this.f33319c.name(str);
        return h(obj, false);
    }

    private void t() throws IOException {
        if (!this.f33318b) {
            throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
        }
        e eVar = this.f33317a;
        if (eVar != null) {
            eVar.t();
            this.f33317a.f33318b = false;
            this.f33317a = null;
            this.f33319c.endObject();
        }
    }

    @Override // p5.e
    @NonNull
    public p5.e b(@NonNull p5.c cVar, long j10) throws IOException {
        return k(cVar.b(), j10);
    }

    @Override // p5.e
    @NonNull
    public p5.e c(@NonNull p5.c cVar, int i10) throws IOException {
        return j(cVar.b(), i10);
    }

    @Override // p5.e
    @NonNull
    public p5.e d(@NonNull p5.c cVar, @Nullable Object obj) throws IOException {
        return l(cVar.b(), obj);
    }

    @NonNull
    public e f(int i10) throws IOException {
        t();
        this.f33319c.value(i10);
        return this;
    }

    @NonNull
    public e g(long j10) throws IOException {
        t();
        this.f33319c.value(j10);
        return this;
    }

    @NonNull
    e h(@Nullable Object obj, boolean z10) throws IOException {
        int i10 = 0;
        if (z10 && o(obj)) {
            Object[] objArr = new Object[1];
            objArr[0] = obj == null ? null : obj.getClass();
            throw new p5.b(String.format("%s cannot be encoded inline", objArr));
        }
        if (obj == null) {
            this.f33319c.nullValue();
            return this;
        }
        if (obj instanceof Number) {
            this.f33319c.value((Number) obj);
            return this;
        }
        if (!obj.getClass().isArray()) {
            if (obj instanceof Collection) {
                this.f33319c.beginArray();
                Iterator it = ((Collection) obj).iterator();
                while (it.hasNext()) {
                    h(it.next(), false);
                }
                this.f33319c.endArray();
                return this;
            }
            if (obj instanceof Map) {
                this.f33319c.beginObject();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    Object key = entry.getKey();
                    try {
                        l((String) key, entry.getValue());
                    } catch (ClassCastException e10) {
                        throw new p5.b(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", key, key.getClass()), e10);
                    }
                }
                this.f33319c.endObject();
                return this;
            }
            p5.d<?> dVar = this.f33320d.get(obj.getClass());
            if (dVar != null) {
                return q(dVar, obj, z10);
            }
            f<?> fVar = this.f33321e.get(obj.getClass());
            if (fVar != null) {
                fVar.a(obj, this);
                return this;
            }
            if (!(obj instanceof Enum)) {
                return q(this.f33322f, obj, z10);
            }
            a(((Enum) obj).name());
            return this;
        }
        if (obj instanceof byte[]) {
            return n((byte[]) obj);
        }
        this.f33319c.beginArray();
        if (obj instanceof int[]) {
            int length = ((int[]) obj).length;
            while (i10 < length) {
                this.f33319c.value(r6[i10]);
                i10++;
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            int length2 = jArr.length;
            while (i10 < length2) {
                g(jArr[i10]);
                i10++;
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length3 = dArr.length;
            while (i10 < length3) {
                this.f33319c.value(dArr[i10]);
                i10++;
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            int length4 = zArr.length;
            while (i10 < length4) {
                this.f33319c.value(zArr[i10]);
                i10++;
            }
        } else if (obj instanceof Number[]) {
            for (Number number : (Number[]) obj) {
                h(number, false);
            }
        } else {
            for (Object obj2 : (Object[]) obj) {
                h(obj2, false);
            }
        }
        this.f33319c.endArray();
        return this;
    }

    @Override // p5.g
    @NonNull
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public e a(@Nullable String str) throws IOException {
        t();
        this.f33319c.value(str);
        return this;
    }

    @NonNull
    public e j(@NonNull String str, int i10) throws IOException {
        t();
        this.f33319c.name(str);
        return f(i10);
    }

    @NonNull
    public e k(@NonNull String str, long j10) throws IOException {
        t();
        this.f33319c.name(str);
        return g(j10);
    }

    @NonNull
    public e l(@NonNull String str, @Nullable Object obj) throws IOException {
        return this.f33323g ? s(str, obj) : r(str, obj);
    }

    @Override // p5.g
    @NonNull
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public e e(boolean z10) throws IOException {
        t();
        this.f33319c.value(z10);
        return this;
    }

    @NonNull
    public e n(@Nullable byte[] bArr) throws IOException {
        t();
        if (bArr == null) {
            this.f33319c.nullValue();
        } else {
            this.f33319c.value(Base64.encodeToString(bArr, 2));
        }
        return this;
    }

    void p() throws IOException {
        t();
        this.f33319c.flush();
    }

    e q(p5.d<Object> dVar, Object obj, boolean z10) throws IOException {
        if (!z10) {
            this.f33319c.beginObject();
        }
        dVar.a(obj, this);
        if (!z10) {
            this.f33319c.endObject();
        }
        return this;
    }
}
