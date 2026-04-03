package io.sentry.rrweb;

import io.sentry.l3;
import io.sentry.m3;
import io.sentry.rrweb.c;
import io.sentry.util.w;
import io.sentry.w0;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RRWebEvent.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private c f28168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f28169b;

    /* JADX INFO: compiled from: RRWebEvent.java */
    public static final class a {
        public boolean a(@NotNull b bVar, @NotNull String str, @NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            str.hashCode();
            if (str.equals("type")) {
                bVar.f28168a = (c) w.c((c) l3Var.M(w0Var, new c.a()), "");
                return true;
            }
            if (!str.equals("timestamp")) {
                return false;
            }
            bVar.f28169b = l3Var.nextLong();
            return true;
        }
    }

    /* JADX INFO: renamed from: io.sentry.rrweb.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: RRWebEvent.java */
    public static final class C0587b {
        public void a(@NotNull b bVar, @NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
            m3Var.e("type").o(w0Var, bVar.f28168a);
            m3Var.e("timestamp").a(bVar.f28169b);
        }
    }

    protected b(@NotNull c cVar) {
        this.f28168a = cVar;
        this.f28169b = System.currentTimeMillis();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f28169b == bVar.f28169b && this.f28168a == bVar.f28168a;
    }

    public int hashCode() {
        return w.b(this.f28168a, Long.valueOf(this.f28169b));
    }

    protected b() {
        this(c.Custom);
    }
}
