package androidx.window.embedding;

import android.app.Activity;
import androidx.window.core.ExperimentalWindowApi;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SplitInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
@ExperimentalWindowApi
public final class SplitInfo {

    @NotNull
    private final ActivityStack primaryActivityStack;

    @NotNull
    private final ActivityStack secondaryActivityStack;
    private final float splitRatio;

    public SplitInfo(@NotNull ActivityStack primaryActivityStack, @NotNull ActivityStack secondaryActivityStack, float f10) {
        t.i(primaryActivityStack, "primaryActivityStack");
        t.i(secondaryActivityStack, "secondaryActivityStack");
        this.primaryActivityStack = primaryActivityStack;
        this.secondaryActivityStack = secondaryActivityStack;
        this.splitRatio = f10;
    }

    public final boolean contains(@NotNull Activity activity) {
        t.i(activity, "activity");
        return this.primaryActivityStack.contains(activity) || this.secondaryActivityStack.contains(activity);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitInfo)) {
            return false;
        }
        SplitInfo splitInfo = (SplitInfo) obj;
        if (t.d(this.primaryActivityStack, splitInfo.primaryActivityStack) && t.d(this.secondaryActivityStack, splitInfo.secondaryActivityStack)) {
            return (this.splitRatio > splitInfo.splitRatio ? 1 : (this.splitRatio == splitInfo.splitRatio ? 0 : -1)) == 0;
        }
        return false;
    }

    @NotNull
    public final ActivityStack getPrimaryActivityStack() {
        return this.primaryActivityStack;
    }

    @NotNull
    public final ActivityStack getSecondaryActivityStack() {
        return this.secondaryActivityStack;
    }

    public final float getSplitRatio() {
        return this.splitRatio;
    }

    public int hashCode() {
        return (((this.primaryActivityStack.hashCode() * 31) + this.secondaryActivityStack.hashCode()) * 31) + Float.floatToIntBits(this.splitRatio);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SplitInfo:{");
        sb.append("primaryActivityStack=" + getPrimaryActivityStack() + ',');
        sb.append("secondaryActivityStack=" + getSecondaryActivityStack() + ',');
        sb.append("splitRatio=" + getSplitRatio() + '}');
        String string = sb.toString();
        t.h(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
