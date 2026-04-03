package y0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: LazyHeaders.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j implements h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, List<i>> f36284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile Map<String, String> f36285d;

    /* JADX INFO: compiled from: LazyHeaders.java */
    public static final class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final String f36286d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final Map<String, List<i>> f36287e;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f36288a = true;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Map<String, List<i>> f36289b = f36287e;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f36290c = true;

        static {
            String strB = b();
            f36286d = strB;
            HashMap map = new HashMap(2);
            if (!TextUtils.isEmpty(strB)) {
                map.put("User-Agent", Collections.singletonList(new b(strB)));
            }
            f36287e = Collections.unmodifiableMap(map);
        }

        @VisibleForTesting
        static String b() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i10 = 0; i10 < length; i10++) {
                char cCharAt = property.charAt(i10);
                if ((cCharAt > 31 || cCharAt == '\t') && cCharAt < 127) {
                    sb.append(cCharAt);
                } else {
                    sb.append('?');
                }
            }
            return sb.toString();
        }

        public j a() {
            this.f36288a = true;
            return new j(this.f36289b);
        }
    }

    /* JADX INFO: compiled from: LazyHeaders.java */
    static final class b implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        private final String f36291a;

        b(@NonNull String str) {
            this.f36291a = str;
        }

        @Override // y0.i
        public String a() {
            return this.f36291a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f36291a.equals(((b) obj).f36291a);
            }
            return false;
        }

        public int hashCode() {
            return this.f36291a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f36291a + "'}";
        }
    }

    j(Map<String, List<i>> map) {
        this.f36284c = Collections.unmodifiableMap(map);
    }

    @NonNull
    private String a(@NonNull List<i> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            String strA = list.get(i10).a();
            if (!TextUtils.isEmpty(strA)) {
                sb.append(strA);
                if (i10 != list.size() - 1) {
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }

    private Map<String, String> c() {
        HashMap map = new HashMap();
        for (Map.Entry<String, List<i>> entry : this.f36284c.entrySet()) {
            String strA = a(entry.getValue());
            if (!TextUtils.isEmpty(strA)) {
                map.put(entry.getKey(), strA);
            }
        }
        return map;
    }

    @Override // y0.h
    public Map<String, String> b() {
        if (this.f36285d == null) {
            synchronized (this) {
                if (this.f36285d == null) {
                    this.f36285d = Collections.unmodifiableMap(c());
                }
            }
        }
        return this.f36285d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof j) {
            return this.f36284c.equals(((j) obj).f36284c);
        }
        return false;
    }

    public int hashCode() {
        return this.f36284c.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f36284c + '}';
    }
}
