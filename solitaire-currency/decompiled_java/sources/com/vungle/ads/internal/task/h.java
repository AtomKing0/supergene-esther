package com.vungle.ads.internal.task;

import com.vungle.ads.internal.executor.i;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PriorityRunnable.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class h implements i.b {
    @Override // java.lang.Comparable
    public int compareTo(@NotNull Object other) {
        t.i(other, "other");
        if (!(other instanceof h)) {
            return -1;
        }
        return t.k(((h) other).getPriority(), getPriority());
    }

    public abstract int getPriority();
}
