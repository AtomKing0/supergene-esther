package androidx.window.embedding;

import androidx.window.core.ExperimentalWindowApi;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.d0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ActivityRule.kt */
/* JADX INFO: loaded from: classes2.dex */
@ExperimentalWindowApi
public final class ActivityRule extends EmbeddingRule {
    private final boolean alwaysExpand;

    @NotNull
    private final Set<ActivityFilter> filters;

    public /* synthetic */ ActivityRule(Set set, boolean z10, int i10, k kVar) {
        this(set, (i10 & 2) != 0 ? false : z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityRule)) {
            return false;
        }
        ActivityRule activityRule = (ActivityRule) obj;
        return t.d(this.filters, activityRule.filters) && this.alwaysExpand == activityRule.alwaysExpand;
    }

    public final boolean getAlwaysExpand() {
        return this.alwaysExpand;
    }

    @NotNull
    public final Set<ActivityFilter> getFilters() {
        return this.filters;
    }

    public int hashCode() {
        return (this.filters.hashCode() * 31) + androidx.compose.foundation.e.a(this.alwaysExpand);
    }

    @NotNull
    public final ActivityRule plus$window_release(@NotNull ActivityFilter filter) {
        t.i(filter, "filter");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(this.filters);
        linkedHashSet.add(filter);
        return new ActivityRule(d0.T0(linkedHashSet), this.alwaysExpand);
    }

    public ActivityRule(@NotNull Set<ActivityFilter> filters, boolean z10) {
        t.i(filters, "filters");
        this.alwaysExpand = z10;
        this.filters = d0.T0(filters);
    }
}
