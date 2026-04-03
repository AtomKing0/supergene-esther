package io.sentry.util;

import io.sentry.SentryLevel;
import io.sentry.h2;
import io.sentry.m3;
import io.sentry.w0;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicIntegerArray;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: MapObjectWriter.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class v implements m3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    final Map<String, Object> f28374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    final ArrayDeque<Object> f28375b;

    public v(@NotNull Map<String, Object> map) {
        this.f28374a = map;
        ArrayDeque<Object> arrayDeque = new ArrayDeque<>();
        this.f28375b = arrayDeque;
        arrayDeque.addLast(map);
    }

    private void A(@NotNull w0 w0Var, @NotNull Date date) throws IOException {
        try {
            g(io.sentry.n.h(date));
        } catch (Exception e10) {
            w0Var.b(SentryLevel.ERROR, "Error when serializing Date", e10);
            q();
        }
    }

    private void B(@NotNull w0 w0Var, @NotNull Map<?, ?> map) throws IOException {
        h();
        for (Object obj : map.keySet()) {
            if (obj instanceof String) {
                e((String) obj);
                o(w0Var, map.get(obj));
            }
        }
        k();
    }

    private void C(@NotNull w0 w0Var, @NotNull TimeZone timeZone) throws IOException {
        try {
            g(timeZone.getID());
        } catch (Exception e10) {
            w0Var.b(SentryLevel.ERROR, "Error when serializing TimeZone", e10);
            q();
        }
    }

    @NotNull
    private Map<String, Object> x() {
        Object objPeekLast = this.f28375b.peekLast();
        if (objPeekLast == null) {
            throw new IllegalStateException("Stack is empty.");
        }
        if (objPeekLast instanceof Map) {
            return (Map) objPeekLast;
        }
        throw new IllegalStateException("Stack element is not a Map.");
    }

    private void y(@Nullable Object obj) {
        Object objPeekLast = this.f28375b.peekLast();
        if (objPeekLast instanceof List) {
            ((List) objPeekLast).add(obj);
        } else {
            if (!(objPeekLast instanceof String)) {
                throw new IllegalStateException("Invalid stack state, expected array or string on top");
            }
            x().put((String) this.f28375b.removeLast(), obj);
        }
    }

    private void z(@NotNull w0 w0Var, @NotNull Collection<?> collection) throws IOException {
        f();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            o(w0Var, it.next());
        }
        d();
    }

    @Override // io.sentry.m3
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public v b(double d10) throws IOException {
        y(Double.valueOf(d10));
        return this;
    }

    @Override // io.sentry.m3
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public v a(long j10) throws IOException {
        y(Long.valueOf(j10));
        return this;
    }

    @Override // io.sentry.m3
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public v o(@NotNull w0 w0Var, @Nullable Object obj) throws IOException {
        if (obj == null) {
            q();
        } else if (obj instanceof Character) {
            g(Character.toString(((Character) obj).charValue()));
        } else if (obj instanceof String) {
            g((String) obj);
        } else if (obj instanceof Boolean) {
            c(((Boolean) obj).booleanValue());
        } else if (obj instanceof Number) {
            n((Number) obj);
        } else if (obj instanceof Date) {
            A(w0Var, (Date) obj);
        } else if (obj instanceof TimeZone) {
            C(w0Var, (TimeZone) obj);
        } else if (obj instanceof h2) {
            ((h2) obj).serialize(this, w0Var);
        } else if (obj instanceof Collection) {
            z(w0Var, (Collection) obj);
        } else if (obj.getClass().isArray()) {
            z(w0Var, Arrays.asList((Object[]) obj));
        } else if (obj instanceof Map) {
            B(w0Var, (Map) obj);
        } else if (obj instanceof Locale) {
            g(obj.toString());
        } else if (obj instanceof AtomicIntegerArray) {
            z(w0Var, q.a((AtomicIntegerArray) obj));
        } else if (obj instanceof AtomicBoolean) {
            c(((AtomicBoolean) obj).get());
        } else if ((obj instanceof URI) || (obj instanceof InetAddress) || (obj instanceof UUID) || (obj instanceof Currency)) {
            g(obj.toString());
        } else if (obj instanceof Calendar) {
            B(w0Var, q.c((Calendar) obj));
        } else if (obj.getClass().isEnum()) {
            g(obj.toString());
        } else {
            w0Var.c(SentryLevel.WARNING, "Failed serializing unknown object.", obj);
        }
        return this;
    }

    @Override // io.sentry.m3
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public v p(@Nullable Boolean bool) throws IOException {
        y(bool);
        return this;
    }

    @Override // io.sentry.m3
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public v n(@Nullable Number number) throws IOException {
        y(number);
        return this;
    }

    @Override // io.sentry.m3
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public v g(@Nullable String str) throws IOException {
        y(str);
        return this;
    }

    @Override // io.sentry.m3
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public v c(boolean z10) throws IOException {
        y(Boolean.valueOf(z10));
        return this;
    }

    @Override // io.sentry.m3
    @Nullable
    public String i() {
        return null;
    }

    @Override // io.sentry.m3
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public v f() throws IOException {
        this.f28375b.add(new ArrayList());
        return this;
    }

    @Override // io.sentry.m3
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public v h() throws IOException {
        this.f28375b.addLast(new HashMap());
        return this;
    }

    @Override // io.sentry.m3
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public v d() throws IOException {
        k();
        return this;
    }

    @Override // io.sentry.m3
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public v k() throws IOException {
        y(this.f28375b.removeLast());
        return this;
    }

    @Override // io.sentry.m3
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public v e(@NotNull String str) throws IOException {
        this.f28375b.add(str);
        return this;
    }

    @Override // io.sentry.m3
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public v q() throws IOException {
        y(null);
        return this;
    }

    @Override // io.sentry.m3
    public void j(boolean z10) {
    }

    @Override // io.sentry.m3
    public m3 l(@Nullable String str) throws IOException {
        return this;
    }

    @Override // io.sentry.m3
    public void m(@Nullable String str) {
    }
}
