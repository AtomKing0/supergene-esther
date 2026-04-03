package io.sentry;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.InetAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicIntegerArray;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JsonReflectionObjectSerializer.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class g2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<Object> f27823a = new HashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f27824b;

    g2(int i10) {
        this.f27824b = i10;
    }

    @NotNull
    private List<Object> a(@NotNull Collection<?> collection, @NotNull w0 w0Var) throws Exception {
        ArrayList arrayList = new ArrayList();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(d(it.next(), w0Var));
        }
        return arrayList;
    }

    @NotNull
    private List<Object> b(@NotNull Object[] objArr, @NotNull w0 w0Var) throws Exception {
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            arrayList.add(d(obj, w0Var));
        }
        return arrayList;
    }

    @NotNull
    private Map<String, Object> c(@NotNull Map<?, ?> map, @NotNull w0 w0Var) throws Exception {
        HashMap map2 = new HashMap();
        for (Object obj : map.keySet()) {
            Object obj2 = map.get(obj);
            if (obj2 != null) {
                map2.put(obj.toString(), d(obj2, w0Var));
            } else {
                map2.put(obj.toString(), null);
            }
        }
        return map2;
    }

    @Nullable
    public Object d(@Nullable Object obj, @NotNull w0 w0Var) throws Exception {
        Object string;
        Object obj2 = null;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Character) {
            return obj.toString();
        }
        if ((obj instanceof Number) || (obj instanceof Boolean) || (obj instanceof String)) {
            return obj;
        }
        if (obj instanceof Locale) {
            return obj.toString();
        }
        if (obj instanceof AtomicIntegerArray) {
            return io.sentry.util.q.a((AtomicIntegerArray) obj);
        }
        if (obj instanceof AtomicBoolean) {
            return Boolean.valueOf(((AtomicBoolean) obj).get());
        }
        if (obj instanceof URI) {
            return obj.toString();
        }
        if (obj instanceof InetAddress) {
            return obj.toString();
        }
        if (obj instanceof UUID) {
            return obj.toString();
        }
        if (obj instanceof Currency) {
            return obj.toString();
        }
        if (obj instanceof Calendar) {
            return io.sentry.util.q.c((Calendar) obj);
        }
        if (obj.getClass().isEnum()) {
            return obj.toString();
        }
        if (this.f27823a.contains(obj)) {
            w0Var.c(SentryLevel.INFO, "Cyclic reference detected. Calling toString() on object.", new Object[0]);
            return obj.toString();
        }
        this.f27823a.add(obj);
        try {
            if (this.f27823a.size() > this.f27824b) {
                this.f27823a.remove(obj);
                w0Var.c(SentryLevel.INFO, "Max depth exceeded. Calling toString() on object.", new Object[0]);
                return obj.toString();
            }
            try {
            } catch (Exception e10) {
                w0Var.b(SentryLevel.INFO, "Not serializing object due to throwing sub-path.", e10);
            }
            if (obj.getClass().isArray()) {
                string = b((Object[]) obj, w0Var);
            } else if (obj instanceof Collection) {
                string = a((Collection) obj, w0Var);
            } else if (obj instanceof Map) {
                string = c((Map) obj, w0Var);
            } else {
                Map<String, Object> mapE = e(obj, w0Var);
                if (!mapE.isEmpty()) {
                    obj2 = mapE;
                    return obj2;
                }
                string = obj.toString();
            }
            obj2 = string;
            return obj2;
        } finally {
            this.f27823a.remove(obj);
        }
    }

    @NotNull
    public Map<String, Object> e(@NotNull Object obj, @NotNull w0 w0Var) throws Exception {
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        HashMap map = new HashMap();
        for (Field field : declaredFields) {
            if (!Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                String name = field.getName();
                try {
                    field.setAccessible(true);
                    map.put(name, d(field.get(obj), w0Var));
                    field.setAccessible(false);
                } catch (Exception unused) {
                    w0Var.c(SentryLevel.INFO, "Cannot access field " + name + ".", new Object[0]);
                }
            }
        }
        return map;
    }
}
