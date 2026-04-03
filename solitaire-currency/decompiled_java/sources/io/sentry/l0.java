package io.sentry;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Hint.java */
/* JADX INFO: loaded from: classes5.dex */
public final class l0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private static final Map<String, Class<?>> f27969h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Map<String, Object> f27970a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final List<b> f27971b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final io.sentry.util.a f27972c = new io.sentry.util.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private b f27973d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private b f27974e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private b f27975f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private b4 f27976g = null;

    static {
        HashMap map = new HashMap();
        f27969h = map;
        map.put(TypedValues.Custom.S_BOOLEAN, Boolean.class);
        map.put("char", Character.class);
        map.put("byte", Byte.class);
        map.put("short", Short.class);
        map.put("int", Integer.class);
        map.put("long", Long.class);
        map.put(TypedValues.Custom.S_FLOAT, Float.class);
        map.put("double", Double.class);
    }

    private boolean i(@Nullable Object obj, @NotNull Class<?> cls) {
        Class<?> cls2 = f27969h.get(cls.getCanonicalName());
        return obj != null && cls.isPrimitive() && cls2 != null && cls2.isInstance(obj);
    }

    public void a(@Nullable List<b> list) {
        if (list != null) {
            this.f27971b.addAll(list);
        }
    }

    @ApiStatus.Internal
    public void b() {
        k1 k1VarA = this.f27972c.a();
        try {
            Iterator<Map.Entry<String, Object>> it = this.f27970a.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Object> next = it.next();
                if (next.getKey() == null || !next.getKey().startsWith("sentry:")) {
                    it.remove();
                }
            }
            if (k1VarA != null) {
                k1VarA.close();
            }
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Nullable
    public Object c(@NotNull String str) {
        k1 k1VarA = this.f27972c.a();
        try {
            Object obj = this.f27970a.get(str);
            if (k1VarA != null) {
                k1VarA.close();
            }
            return obj;
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Nullable
    public <T> T d(@NotNull String str, @NotNull Class<T> cls) {
        k1 k1VarA = this.f27972c.a();
        try {
            T t10 = (T) this.f27970a.get(str);
            if (cls.isInstance(t10)) {
                if (k1VarA != null) {
                    k1VarA.close();
                }
                return t10;
            }
            if (i(t10, cls)) {
                if (k1VarA != null) {
                    k1VarA.close();
                }
                return t10;
            }
            if (k1VarA == null) {
                return null;
            }
            k1VarA.close();
            return null;
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @NotNull
    public List<b> e() {
        return new ArrayList(this.f27971b);
    }

    @Nullable
    public b f() {
        return this.f27973d;
    }

    @Nullable
    public b g() {
        return this.f27975f;
    }

    @Nullable
    public b h() {
        return this.f27974e;
    }

    public void j(@NotNull String str, @Nullable Object obj) {
        k1 k1VarA = this.f27972c.a();
        try {
            this.f27970a.put(str, obj);
            if (k1VarA != null) {
                k1VarA.close();
            }
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void k(@Nullable b bVar) {
        this.f27973d = bVar;
    }

    public void l(@Nullable b bVar) {
        this.f27975f = bVar;
    }

    public void m(@Nullable b bVar) {
        this.f27974e = bVar;
    }
}
