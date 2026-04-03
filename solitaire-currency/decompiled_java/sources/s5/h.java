package s5;

import androidx.annotation.NonNull;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import s5.h;

/* JADX INFO: compiled from: ProtobufEncoder.java */
/* JADX INFO: loaded from: classes3.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Class<?>, p5.d<?>> f33574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<Class<?>, p5.f<?>> f33575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final p5.d<Object> f33576c;

    /* JADX INFO: compiled from: ProtobufEncoder.java */
    public static final class a implements q5.b<a> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final p5.d<Object> f33577d = new p5.d() { // from class: s5.g
            @Override // p5.d
            public final void a(Object obj, Object obj2) throws IOException {
                h.a.e(obj, (p5.e) obj2);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<Class<?>, p5.d<?>> f33578a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map<Class<?>, p5.f<?>> f33579b = new HashMap();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private p5.d<Object> f33580c = f33577d;

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void e(Object obj, p5.e eVar) throws IOException {
            throw new p5.b("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
        }

        public h c() {
            return new h(new HashMap(this.f33578a), new HashMap(this.f33579b), this.f33580c);
        }

        @NonNull
        public a d(@NonNull q5.a aVar) {
            aVar.a(this);
            return this;
        }

        @Override // q5.b
        @NonNull
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public <U> a a(@NonNull Class<U> cls, @NonNull p5.d<? super U> dVar) {
            this.f33578a.put(cls, dVar);
            this.f33579b.remove(cls);
            return this;
        }
    }

    h(Map<Class<?>, p5.d<?>> map, Map<Class<?>, p5.f<?>> map2, p5.d<Object> dVar) {
        this.f33574a = map;
        this.f33575b = map2;
        this.f33576c = dVar;
    }

    public static a a() {
        return new a();
    }

    public void b(@NonNull Object obj, @NonNull OutputStream outputStream) throws IOException {
        new f(outputStream, this.f33574a, this.f33575b, this.f33576c).q(obj);
    }

    @NonNull
    public byte[] c(@NonNull Object obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            b(obj, byteArrayOutputStream);
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }
}
