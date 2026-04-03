package com.vungle.ads.internal.util;

import java.util.HashSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CollectionsConcurrencyUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    @NotNull
    public static final d INSTANCE = new d();

    private d() {
    }

    public static final synchronized void addToSet(@NotNull HashSet<String> hashset, @NotNull String set) {
        kotlin.jvm.internal.t.i(hashset, "hashset");
        kotlin.jvm.internal.t.i(set, "set");
        hashset.add(set);
    }

    @NotNull
    public static final synchronized HashSet<String> getNewHashSet(@Nullable HashSet<String> hashSet) {
        return new HashSet<>(hashSet);
    }
}
