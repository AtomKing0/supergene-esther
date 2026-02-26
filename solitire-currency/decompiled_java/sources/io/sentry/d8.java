package io.sentry;

import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SentryValues.java */
/* JADX INFO: loaded from: classes5.dex */
final class d8<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<T> f27768a;

    d8(@Nullable List<T> list) {
        this.f27768a = new ArrayList(list == null ? new ArrayList<>(0) : list);
    }

    @NotNull
    public List<T> a() {
        return this.f27768a;
    }
}
