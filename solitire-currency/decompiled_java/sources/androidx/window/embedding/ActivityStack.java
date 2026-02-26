package androidx.window.embedding;

import android.app.Activity;
import androidx.window.core.ExperimentalWindowApi;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ActivityStack.kt */
/* JADX INFO: loaded from: classes2.dex */
@ExperimentalWindowApi
public final class ActivityStack {

    @NotNull
    private final List<Activity> activities;
    private final boolean isEmpty;

    /* JADX WARN: Multi-variable type inference failed */
    public ActivityStack(@NotNull List<? extends Activity> activities, boolean z10) {
        t.i(activities, "activities");
        this.activities = activities;
        this.isEmpty = z10;
    }

    public final boolean contains(@NotNull Activity activity) {
        t.i(activity, "activity");
        return this.activities.contains(activity);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityStack)) {
            return false;
        }
        ActivityStack activityStack = (ActivityStack) obj;
        return (t.d(this.activities, activityStack.activities) || this.isEmpty == activityStack.isEmpty) ? false : true;
    }

    @NotNull
    public final List<Activity> getActivities$window_release() {
        return this.activities;
    }

    public int hashCode() {
        return ((this.isEmpty ? 1 : 0) * 31) + this.activities.hashCode();
    }

    public final boolean isEmpty() {
        return this.isEmpty;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ActivityStack{");
        sb.append(t.r("activities=", getActivities$window_release()));
        sb.append("isEmpty=" + this.isEmpty + '}');
        String string = sb.toString();
        t.h(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public /* synthetic */ ActivityStack(List list, boolean z10, int i10, k kVar) {
        this(list, (i10 & 2) != 0 ? false : z10);
    }
}
