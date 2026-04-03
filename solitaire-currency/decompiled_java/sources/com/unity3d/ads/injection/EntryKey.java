package com.unity3d.ads.injection;

import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: EntryKey.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class EntryKey {

    @NotNull
    private final KClass<?> instanceClass;

    @NotNull
    private final String named;

    public EntryKey(@NotNull String named, @NotNull KClass<?> instanceClass) {
        t.i(named, "named");
        t.i(instanceClass, "instanceClass");
        this.named = named;
        this.instanceClass = instanceClass;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EntryKey copy$default(EntryKey entryKey, String str, KClass kClass, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = entryKey.named;
        }
        if ((i10 & 2) != 0) {
            kClass = entryKey.instanceClass;
        }
        return entryKey.copy(str, kClass);
    }

    @NotNull
    public final String component1() {
        return this.named;
    }

    @NotNull
    public final KClass<?> component2() {
        return this.instanceClass;
    }

    @NotNull
    public final EntryKey copy(@NotNull String named, @NotNull KClass<?> instanceClass) {
        t.i(named, "named");
        t.i(instanceClass, "instanceClass");
        return new EntryKey(named, instanceClass);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EntryKey)) {
            return false;
        }
        EntryKey entryKey = (EntryKey) obj;
        return t.d(this.named, entryKey.named) && t.d(this.instanceClass, entryKey.instanceClass);
    }

    @NotNull
    public final KClass<?> getInstanceClass() {
        return this.instanceClass;
    }

    @NotNull
    public final String getNamed() {
        return this.named;
    }

    public int hashCode() {
        return (this.named.hashCode() * 31) + this.instanceClass.hashCode();
    }

    @NotNull
    public String toString() {
        return "EntryKey(named=" + this.named + ", instanceClass=" + this.instanceClass + ')';
    }

    public /* synthetic */ EntryKey(String str, KClass kClass, int i10, k kVar) {
        this((i10 & 1) != 0 ? "" : str, kClass);
    }
}
