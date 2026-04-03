package p5;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: FieldDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f32619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<Class<?>, Object> f32620b;

    /* JADX INFO: compiled from: FieldDescriptor.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f32621a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Map<Class<?>, Object> f32622b = null;

        b(String str) {
            this.f32621a = str;
        }

        @NonNull
        public c a() {
            return new c(this.f32621a, this.f32622b == null ? Collections.emptyMap() : Collections.unmodifiableMap(new HashMap(this.f32622b)));
        }

        @NonNull
        public <T extends Annotation> b b(@NonNull T t10) {
            if (this.f32622b == null) {
                this.f32622b = new HashMap();
            }
            this.f32622b.put(t10.annotationType(), t10);
            return this;
        }
    }

    @NonNull
    public static b a(@NonNull String str) {
        return new b(str);
    }

    @NonNull
    public static c d(@NonNull String str) {
        return new c(str, Collections.emptyMap());
    }

    @NonNull
    public String b() {
        return this.f32619a;
    }

    @Nullable
    public <T extends Annotation> T c(@NonNull Class<T> cls) {
        return (T) this.f32620b.get(cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f32619a.equals(cVar.f32619a) && this.f32620b.equals(cVar.f32620b);
    }

    public int hashCode() {
        return (this.f32619a.hashCode() * 31) + this.f32620b.hashCode();
    }

    @NonNull
    public String toString() {
        return "FieldDescriptor{name=" + this.f32619a + ", properties=" + this.f32620b.values() + "}";
    }

    private c(String str, Map<Class<?>, Object> map) {
        this.f32619a = str;
        this.f32620b = map;
    }
}
