package io.sentry.clientreport;

import io.sentry.util.w;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ClientReportKey.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f27724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f27725b;

    d(@NotNull String str, @NotNull String str2) {
        this.f27724a = str;
        this.f27725b = str2;
    }

    @NotNull
    public String a() {
        return this.f27725b;
    }

    @NotNull
    public String b() {
        return this.f27724a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return w.a(b(), dVar.b()) && w.a(a(), dVar.a());
    }

    public int hashCode() {
        return w.b(b(), a());
    }
}
