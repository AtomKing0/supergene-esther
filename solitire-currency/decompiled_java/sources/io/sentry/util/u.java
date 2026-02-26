package io.sentry.util;

import io.sentry.SentryLevel;
import io.sentry.k3;
import io.sentry.l3;
import io.sentry.w0;
import io.sentry.x1;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: MapObjectReader.java */
/* JADX INFO: loaded from: classes5.dex */
public final class u implements l3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Deque<Map.Entry<String, Object>> f28373a;

    public u(Map<String, Object> map) {
        ArrayDeque arrayDeque = new ArrayDeque();
        this.f28373a = arrayDeque;
        arrayDeque.addLast(new AbstractMap.SimpleEntry(null, map));
    }

    @Nullable
    private <T> T q() throws IOException {
        try {
            return (T) x(null, null);
        } catch (Exception e10) {
            throw new IOException(e10);
        }
    }

    @Nullable
    private <T> T x(@Nullable w0 w0Var, @Nullable x1<T> x1Var) throws Exception {
        Map.Entry<String, Object> entryPeekLast = this.f28373a.peekLast();
        if (entryPeekLast == null) {
            return null;
        }
        T t10 = (T) entryPeekLast.getValue();
        if (x1Var != null && w0Var != null) {
            return x1Var.deserialize(this, w0Var);
        }
        this.f28373a.removeLast();
        return t10;
    }

    @Override // io.sentry.l3
    @Nullable
    public Double A() throws IOException {
        Object objQ = q();
        if (objQ instanceof Number) {
            return Double.valueOf(((Number) objQ).doubleValue());
        }
        return null;
    }

    @Override // io.sentry.l3
    @Nullable
    public Object A0() throws IOException {
        return q();
    }

    @Override // io.sentry.l3
    @NotNull
    public String C() throws IOException {
        Map.Entry<String, Object> entryPeekLast = this.f28373a.peekLast();
        if (entryPeekLast != null && entryPeekLast.getKey() != null) {
            return entryPeekLast.getKey();
        }
        throw new IOException("Expected a name but was " + peek());
    }

    @Override // io.sentry.l3
    @Nullable
    public <T> List<T> D0(@NotNull w0 w0Var, @NotNull x1<T> x1Var) throws IOException {
        if (peek() == io.sentry.vendor.gson.stream.b.NULL) {
            n();
            return null;
        }
        try {
            a();
            ArrayList arrayList = new ArrayList();
            if (i()) {
                do {
                    try {
                        arrayList.add(x1Var.deserialize(this, w0Var));
                    } catch (Exception e10) {
                        w0Var.b(SentryLevel.WARNING, "Failed to deserialize object in list.", e10);
                    }
                } while (peek() == io.sentry.vendor.gson.stream.b.BEGIN_OBJECT);
            }
            c();
            return arrayList;
        } catch (Exception e11) {
            throw new IOException(e11);
        }
    }

    @Override // io.sentry.l3
    @Nullable
    public Date F(@NotNull w0 w0Var) throws IOException {
        return k3.a(o0(), w0Var);
    }

    @Override // io.sentry.l3
    @Nullable
    public Boolean H() throws IOException {
        return (Boolean) q();
    }

    @Override // io.sentry.l3
    @Nullable
    public <T> T M(@NotNull w0 w0Var, @NotNull x1<T> x1Var) throws Exception {
        return (T) x(w0Var, x1Var);
    }

    public void a() throws IOException {
        Map.Entry<String, Object> entryRemoveLast = this.f28373a.removeLast();
        if (entryRemoveLast == null) {
            throw new IOException("No more entries");
        }
        Object value = entryRemoveLast.getValue();
        if (!(value instanceof List)) {
            throw new IOException("Current token is not an object");
        }
        this.f28373a.addLast(new AbstractMap.SimpleEntry(null, io.sentry.vendor.gson.stream.b.END_ARRAY));
        List list = (List) value;
        for (int size = list.size() - 1; size >= 0; size--) {
            this.f28373a.addLast(new AbstractMap.SimpleEntry(null, list.get(size)));
        }
    }

    public void c() throws IOException {
        if (this.f28373a.size() > 1) {
            this.f28373a.removeLast();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f28373a.clear();
    }

    @Override // io.sentry.l3
    public String e0() throws IOException {
        String str = (String) q();
        if (str != null) {
            return str;
        }
        throw new IOException("Expected string");
    }

    @Override // io.sentry.l3
    @Nullable
    public Integer g0() throws IOException {
        Object objQ = q();
        if (objQ instanceof Number) {
            return Integer.valueOf(((Number) objQ).intValue());
        }
        return null;
    }

    @Override // io.sentry.l3
    public void h() throws IOException {
        Map.Entry<String, Object> entryRemoveLast = this.f28373a.removeLast();
        if (entryRemoveLast == null) {
            throw new IOException("No more entries");
        }
        Object value = entryRemoveLast.getValue();
        if (!(value instanceof Map)) {
            throw new IOException("Current token is not an object");
        }
        this.f28373a.addLast(new AbstractMap.SimpleEntry(null, io.sentry.vendor.gson.stream.b.END_OBJECT));
        Iterator it = ((Map) value).entrySet().iterator();
        while (it.hasNext()) {
            this.f28373a.addLast((Map.Entry) it.next());
        }
    }

    public boolean i() throws IOException {
        return !this.f28373a.isEmpty();
    }

    @Override // io.sentry.l3
    @Nullable
    public Long j0() throws IOException {
        Object objQ = q();
        if (objQ instanceof Number) {
            return Long.valueOf(((Number) objQ).longValue());
        }
        return null;
    }

    @Override // io.sentry.l3
    public void k() throws IOException {
        if (this.f28373a.size() > 1) {
            this.f28373a.removeLast();
        }
    }

    public void n() throws IOException {
        if (q() == null) {
            return;
        }
        throw new IOException("Expected null but was " + peek());
    }

    @Override // io.sentry.l3
    public double nextDouble() throws IOException {
        Object objQ = q();
        if (objQ instanceof Number) {
            return ((Number) objQ).doubleValue();
        }
        throw new IOException("Expected double");
    }

    @Override // io.sentry.l3
    public float nextFloat() throws IOException {
        Object objQ = q();
        if (objQ instanceof Number) {
            return ((Number) objQ).floatValue();
        }
        throw new IOException("Expected float");
    }

    @Override // io.sentry.l3
    public int nextInt() throws IOException {
        Object objQ = q();
        if (objQ instanceof Number) {
            return ((Number) objQ).intValue();
        }
        throw new IOException("Expected int");
    }

    @Override // io.sentry.l3
    public long nextLong() throws IOException {
        Object objQ = q();
        if (objQ instanceof Number) {
            return ((Number) objQ).longValue();
        }
        throw new IOException("Expected long");
    }

    @Override // io.sentry.l3
    @Nullable
    public String o0() throws IOException {
        return (String) q();
    }

    @Override // io.sentry.l3
    @NotNull
    public io.sentry.vendor.gson.stream.b peek() throws IOException {
        if (this.f28373a.isEmpty()) {
            return io.sentry.vendor.gson.stream.b.END_DOCUMENT;
        }
        Map.Entry<String, Object> entryPeekLast = this.f28373a.peekLast();
        if (entryPeekLast == null) {
            return io.sentry.vendor.gson.stream.b.END_DOCUMENT;
        }
        if (entryPeekLast.getKey() != null) {
            return io.sentry.vendor.gson.stream.b.NAME;
        }
        Object value = entryPeekLast.getValue();
        return value instanceof Map ? io.sentry.vendor.gson.stream.b.BEGIN_OBJECT : value instanceof List ? io.sentry.vendor.gson.stream.b.BEGIN_ARRAY : value instanceof String ? io.sentry.vendor.gson.stream.b.STRING : value instanceof Number ? io.sentry.vendor.gson.stream.b.NUMBER : value instanceof Boolean ? io.sentry.vendor.gson.stream.b.BOOLEAN : value instanceof io.sentry.vendor.gson.stream.b ? (io.sentry.vendor.gson.stream.b) value : io.sentry.vendor.gson.stream.b.END_DOCUMENT;
    }

    @Override // io.sentry.l3
    @Nullable
    public <T> Map<String, T> q0(@NotNull w0 w0Var, @NotNull x1<T> x1Var) throws IOException {
        if (peek() == io.sentry.vendor.gson.stream.b.NULL) {
            n();
            return null;
        }
        try {
            h();
            HashMap map = new HashMap();
            if (i()) {
                while (true) {
                    try {
                        map.put(C(), x1Var.deserialize(this, w0Var));
                    } catch (Exception e10) {
                        w0Var.b(SentryLevel.WARNING, "Failed to deserialize object in map.", e10);
                    }
                    if (peek() != io.sentry.vendor.gson.stream.b.BEGIN_OBJECT && peek() != io.sentry.vendor.gson.stream.b.NAME) {
                        break;
                    }
                }
            }
            k();
            return map;
        } catch (Exception e11) {
            throw new IOException(e11);
        }
    }

    @Override // io.sentry.l3
    public void r0(@NotNull w0 w0Var, Map<String, Object> map, String str) {
        try {
            map.put(str, A0());
        } catch (Exception e10) {
            w0Var.a(SentryLevel.ERROR, e10, "Error deserializing unknown key: %s", str);
        }
    }

    @Override // io.sentry.l3
    @Nullable
    public TimeZone t(@NotNull w0 w0Var) throws IOException {
        String strO0 = o0();
        if (strO0 != null) {
            return TimeZone.getTimeZone(strO0);
        }
        return null;
    }

    @Override // io.sentry.l3
    @Nullable
    public Float x0() throws IOException {
        Object objQ = q();
        if (objQ instanceof Number) {
            return Float.valueOf(((Number) objQ).floatValue());
        }
        return null;
    }

    @Override // io.sentry.l3
    public void p() throws IOException {
    }

    @Override // io.sentry.l3
    public void j(boolean z10) {
    }
}
