package io.sentry;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicIntegerArray;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JsonObjectSerializer.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class e2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g2 f27773a;

    public e2(int i10) {
        this.f27773a = new g2(i10);
    }

    private void b(@NotNull m3 m3Var, @NotNull w0 w0Var, @NotNull Collection<?> collection) throws IOException {
        m3Var.f();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            a(m3Var, w0Var, it.next());
        }
        m3Var.d();
    }

    private void c(@NotNull m3 m3Var, @NotNull w0 w0Var, @NotNull Date date) throws IOException {
        try {
            m3Var.g(n.h(date));
        } catch (Exception e10) {
            w0Var.b(SentryLevel.ERROR, "Error when serializing Date", e10);
            m3Var.q();
        }
    }

    private void d(@NotNull m3 m3Var, @NotNull w0 w0Var, @NotNull Map<?, ?> map) throws IOException {
        m3Var.h();
        for (Object obj : map.keySet()) {
            if (obj instanceof String) {
                m3Var.e((String) obj);
                a(m3Var, w0Var, map.get(obj));
            }
        }
        m3Var.k();
    }

    private void e(@NotNull m3 m3Var, @NotNull w0 w0Var, @NotNull TimeZone timeZone) throws IOException {
        try {
            m3Var.g(timeZone.getID());
        } catch (Exception e10) {
            w0Var.b(SentryLevel.ERROR, "Error when serializing TimeZone", e10);
            m3Var.q();
        }
    }

    public void a(@NotNull m3 m3Var, @NotNull w0 w0Var, @Nullable Object obj) throws IOException {
        if (obj == null) {
            m3Var.q();
            return;
        }
        if (obj instanceof Character) {
            m3Var.g(Character.toString(((Character) obj).charValue()));
            return;
        }
        if (obj instanceof String) {
            m3Var.g((String) obj);
            return;
        }
        if (obj instanceof Boolean) {
            m3Var.c(((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof Number) {
            m3Var.n((Number) obj);
            return;
        }
        if (obj instanceof Date) {
            c(m3Var, w0Var, (Date) obj);
            return;
        }
        if (obj instanceof TimeZone) {
            e(m3Var, w0Var, (TimeZone) obj);
            return;
        }
        if (obj instanceof h2) {
            ((h2) obj).serialize(m3Var, w0Var);
            return;
        }
        if (obj instanceof Collection) {
            b(m3Var, w0Var, (Collection) obj);
            return;
        }
        if (obj.getClass().isArray()) {
            b(m3Var, w0Var, Arrays.asList((Object[]) obj));
            return;
        }
        if (obj instanceof Map) {
            d(m3Var, w0Var, (Map) obj);
            return;
        }
        if (obj instanceof Locale) {
            m3Var.g(obj.toString());
            return;
        }
        if (obj instanceof AtomicIntegerArray) {
            b(m3Var, w0Var, io.sentry.util.q.a((AtomicIntegerArray) obj));
            return;
        }
        if (obj instanceof AtomicBoolean) {
            m3Var.c(((AtomicBoolean) obj).get());
            return;
        }
        if (obj instanceof URI) {
            m3Var.g(obj.toString());
            return;
        }
        if (obj instanceof InetAddress) {
            m3Var.g(obj.toString());
            return;
        }
        if (obj instanceof UUID) {
            m3Var.g(obj.toString());
            return;
        }
        if (obj instanceof Currency) {
            m3Var.g(obj.toString());
            return;
        }
        if (obj instanceof Calendar) {
            d(m3Var, w0Var, io.sentry.util.q.c((Calendar) obj));
            return;
        }
        if (obj.getClass().isEnum()) {
            m3Var.g(obj.toString());
            return;
        }
        try {
            a(m3Var, w0Var, this.f27773a.d(obj, w0Var));
        } catch (Exception e10) {
            w0Var.b(SentryLevel.ERROR, "Failed serializing unknown object.", e10);
            m3Var.g("[OBJECT]");
        }
    }
}
