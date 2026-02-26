package io.sentry.internal.eventprocessor;

import io.sentry.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: EventProcessorAndOrder.java */
/* JADX INFO: loaded from: classes5.dex */
public final class a implements Comparable<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final g0 f27918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final Long f27919b;

    public a(@NotNull g0 g0Var, @Nullable Long l10) {
        this.f27918a = g0Var;
        if (l10 == null) {
            this.f27919b = Long.valueOf(System.nanoTime());
        } else {
            this.f27919b = l10;
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NotNull a aVar) {
        return this.f27919b.compareTo(aVar.f27919b);
    }

    @NotNull
    public g0 c() {
        return this.f27918a;
    }
}
