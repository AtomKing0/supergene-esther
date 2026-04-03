package r5;

import androidx.annotation.NonNull;
import java.io.IOException;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import p5.f;
import p5.g;

/* JADX INFO: compiled from: JsonDataEncoderBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements q5.b<d> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final p5.d<Object> f33307e = new p5.d() { // from class: r5.a
        @Override // p5.d
        public final void a(Object obj, Object obj2) throws IOException {
            d.l(obj, (p5.e) obj2);
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final f<String> f33308f = new f() { // from class: r5.b
        @Override // p5.f
        public final void a(Object obj, Object obj2) throws IOException {
            ((g) obj2).a((String) obj);
        }
    };

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final f<Boolean> f33309g = new f() { // from class: r5.c
        @Override // p5.f
        public final void a(Object obj, Object obj2) throws IOException {
            d.n((Boolean) obj, (g) obj2);
        }
    };

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final b f33310h = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Class<?>, p5.d<?>> f33311a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<Class<?>, f<?>> f33312b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private p5.d<Object> f33313c = f33307e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f33314d = false;

    /* JADX INFO: compiled from: JsonDataEncoderBuilder.java */
    class a implements p5.a {
        a() {
        }

        @Override // p5.a
        public void a(@NonNull Object obj, @NonNull Writer writer) throws IOException {
            e eVar = new e(writer, d.this.f33311a, d.this.f33312b, d.this.f33313c, d.this.f33314d);
            eVar.h(obj, false);
            eVar.p();
        }
    }

    /* JADX INFO: compiled from: JsonDataEncoderBuilder.java */
    private static final class b implements f<Date> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final DateFormat f33316a;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            f33316a = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }

        private b() {
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        @Override // p5.f
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@NonNull Date date, @NonNull g gVar) throws IOException {
            gVar.a(f33316a.format(date));
        }
    }

    public d() {
        p(String.class, f33308f);
        p(Boolean.class, f33309g);
        p(Date.class, f33310h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l(Object obj, p5.e eVar) throws IOException {
        throw new p5.b("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n(Boolean bool, g gVar) throws IOException {
        gVar.e(bool.booleanValue());
    }

    @NonNull
    public p5.a i() {
        return new a();
    }

    @NonNull
    public d j(@NonNull q5.a aVar) {
        aVar.a(this);
        return this;
    }

    @NonNull
    public d k(boolean z10) {
        this.f33314d = z10;
        return this;
    }

    @Override // q5.b
    @NonNull
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public <T> d a(@NonNull Class<T> cls, @NonNull p5.d<? super T> dVar) {
        this.f33311a.put(cls, dVar);
        this.f33312b.remove(cls);
        return this;
    }

    @NonNull
    public <T> d p(@NonNull Class<T> cls, @NonNull f<? super T> fVar) {
        this.f33312b.put(cls, fVar);
        this.f33311a.remove(cls);
        return this;
    }
}
