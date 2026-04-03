package io.sentry.android.core.performance;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ActivityLifecycleTimeSpan.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public class c implements Comparable<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final i f27450a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final i f27451b = new i();

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(c cVar) {
        int iCompare = Long.compare(this.f27450a.k(), cVar.f27450a.k());
        return iCompare == 0 ? Long.compare(this.f27451b.k(), cVar.f27451b.k()) : iCompare;
    }

    @NotNull
    public final i c() {
        return this.f27450a;
    }

    @NotNull
    public final i d() {
        return this.f27451b;
    }
}
