package io.sentry;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JsonObjectReader.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class d2 implements l3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final io.sentry.vendor.gson.stream.a f27755a;

    public d2(Reader reader) {
        this.f27755a = new io.sentry.vendor.gson.stream.a(reader);
    }

    @Override // io.sentry.l3
    @Nullable
    public Double A() throws IOException {
        if (this.f27755a.peek() != io.sentry.vendor.gson.stream.b.NULL) {
            return Double.valueOf(this.f27755a.nextDouble());
        }
        this.f27755a.R();
        return null;
    }

    @Override // io.sentry.l3
    @Nullable
    public Object A0() throws IOException {
        return new c2().e(this);
    }

    @Override // io.sentry.l3
    @NotNull
    public String C() throws IOException {
        return this.f27755a.C();
    }

    @Override // io.sentry.l3
    @Nullable
    public <T> List<T> D0(@NotNull w0 w0Var, @NotNull x1<T> x1Var) throws IOException {
        if (this.f27755a.peek() == io.sentry.vendor.gson.stream.b.NULL) {
            this.f27755a.R();
            return null;
        }
        this.f27755a.a();
        ArrayList arrayList = new ArrayList();
        if (this.f27755a.z()) {
            do {
                try {
                    arrayList.add(x1Var.deserialize(this, w0Var));
                } catch (Exception e10) {
                    w0Var.b(SentryLevel.WARNING, "Failed to deserialize object in list.", e10);
                }
            } while (this.f27755a.peek() == io.sentry.vendor.gson.stream.b.BEGIN_OBJECT);
        }
        this.f27755a.q();
        return arrayList;
    }

    @Override // io.sentry.l3
    @Nullable
    public Date F(w0 w0Var) throws IOException {
        if (this.f27755a.peek() != io.sentry.vendor.gson.stream.b.NULL) {
            return k3.a(this.f27755a.e0(), w0Var);
        }
        this.f27755a.R();
        return null;
    }

    @Override // io.sentry.l3
    @Nullable
    public Boolean H() throws IOException {
        if (this.f27755a.peek() != io.sentry.vendor.gson.stream.b.NULL) {
            return Boolean.valueOf(this.f27755a.L());
        }
        this.f27755a.R();
        return null;
    }

    @Override // io.sentry.l3
    @Nullable
    public <T> T M(@NotNull w0 w0Var, @NotNull x1<T> x1Var) throws Exception {
        if (this.f27755a.peek() != io.sentry.vendor.gson.stream.b.NULL) {
            return x1Var.deserialize(this, w0Var);
        }
        this.f27755a.R();
        return null;
    }

    public void a() throws IOException {
        this.f27755a.a();
    }

    public void c() throws IOException {
        this.f27755a.q();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f27755a.close();
    }

    @Override // io.sentry.l3
    public String e0() throws IOException {
        return this.f27755a.e0();
    }

    @Override // io.sentry.l3
    @Nullable
    public Integer g0() throws IOException {
        if (this.f27755a.peek() != io.sentry.vendor.gson.stream.b.NULL) {
            return Integer.valueOf(this.f27755a.nextInt());
        }
        this.f27755a.R();
        return null;
    }

    @Override // io.sentry.l3
    public void h() throws IOException {
        this.f27755a.h();
    }

    public boolean i() throws IOException {
        return this.f27755a.L();
    }

    @Override // io.sentry.l3
    public void j(boolean z10) {
        this.f27755a.j(z10);
    }

    @Override // io.sentry.l3
    @Nullable
    public Long j0() throws IOException {
        if (this.f27755a.peek() != io.sentry.vendor.gson.stream.b.NULL) {
            return Long.valueOf(this.f27755a.nextLong());
        }
        this.f27755a.R();
        return null;
    }

    @Override // io.sentry.l3
    public void k() throws IOException {
        this.f27755a.k();
    }

    public void n() throws IOException {
        this.f27755a.R();
    }

    @Override // io.sentry.l3
    public double nextDouble() throws IOException {
        return this.f27755a.nextDouble();
    }

    @Override // io.sentry.l3
    public float nextFloat() throws IOException {
        return (float) this.f27755a.nextDouble();
    }

    @Override // io.sentry.l3
    public int nextInt() throws IOException {
        return this.f27755a.nextInt();
    }

    @Override // io.sentry.l3
    public long nextLong() throws IOException {
        return this.f27755a.nextLong();
    }

    @Override // io.sentry.l3
    @Nullable
    public String o0() throws IOException {
        if (this.f27755a.peek() != io.sentry.vendor.gson.stream.b.NULL) {
            return this.f27755a.e0();
        }
        this.f27755a.R();
        return null;
    }

    @Override // io.sentry.l3
    public void p() throws IOException {
        this.f27755a.p();
    }

    @Override // io.sentry.l3
    @NotNull
    public io.sentry.vendor.gson.stream.b peek() throws IOException {
        return this.f27755a.peek();
    }

    @Override // io.sentry.l3
    @Nullable
    public <T> Map<String, T> q0(@NotNull w0 w0Var, @NotNull x1<T> x1Var) throws IOException {
        if (this.f27755a.peek() == io.sentry.vendor.gson.stream.b.NULL) {
            this.f27755a.R();
            return null;
        }
        this.f27755a.h();
        HashMap map = new HashMap();
        if (this.f27755a.z()) {
            while (true) {
                try {
                    map.put(this.f27755a.C(), x1Var.deserialize(this, w0Var));
                } catch (Exception e10) {
                    w0Var.b(SentryLevel.WARNING, "Failed to deserialize object in map.", e10);
                }
                if (this.f27755a.peek() != io.sentry.vendor.gson.stream.b.BEGIN_OBJECT && this.f27755a.peek() != io.sentry.vendor.gson.stream.b.NAME) {
                    break;
                }
            }
        }
        this.f27755a.k();
        return map;
    }

    @Override // io.sentry.l3
    public void r0(w0 w0Var, Map<String, Object> map, String str) {
        try {
            map.put(str, A0());
        } catch (Exception e10) {
            w0Var.a(SentryLevel.ERROR, e10, "Error deserializing unknown key: %s", str);
        }
    }

    @Override // io.sentry.l3
    @Nullable
    public TimeZone t(w0 w0Var) throws IOException {
        if (this.f27755a.peek() == io.sentry.vendor.gson.stream.b.NULL) {
            this.f27755a.R();
            return null;
        }
        try {
            return TimeZone.getTimeZone(this.f27755a.e0());
        } catch (Exception e10) {
            w0Var.b(SentryLevel.ERROR, "Error when deserializing TimeZone", e10);
            return null;
        }
    }

    @Override // io.sentry.l3
    @Nullable
    public Float x0() throws IOException {
        if (this.f27755a.peek() != io.sentry.vendor.gson.stream.b.NULL) {
            return Float.valueOf(nextFloat());
        }
        this.f27755a.R();
        return null;
    }
}
