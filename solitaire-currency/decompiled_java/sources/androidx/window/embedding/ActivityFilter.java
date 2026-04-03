package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import androidx.webkit.ProxyConfig;
import androidx.window.core.ExperimentalWindowApi;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.r;

/* JADX INFO: compiled from: ActivityFilter.kt */
/* JADX INFO: loaded from: classes2.dex */
@ExperimentalWindowApi
public final class ActivityFilter {

    @NotNull
    private final ComponentName componentName;

    @Nullable
    private final String intentAction;

    public ActivityFilter(@NotNull ComponentName componentName, @Nullable String str) {
        t.i(componentName, "componentName");
        this.componentName = componentName;
        this.intentAction = str;
        String packageName = componentName.getPackageName();
        t.h(packageName, "componentName.packageName");
        String className = componentName.getClassName();
        t.h(className, "componentName.className");
        boolean z10 = true;
        if (!(packageName.length() > 0)) {
            throw new IllegalArgumentException("Package name must not be empty".toString());
        }
        if (!(className.length() > 0)) {
            throw new IllegalArgumentException("Activity class name must not be empty.".toString());
        }
        if (!(!r.P(packageName, ProxyConfig.MATCH_ALL_SCHEMES, false, 2, null) || r.e0(packageName, ProxyConfig.MATCH_ALL_SCHEMES, 0, false, 6, null) == packageName.length() - 1)) {
            throw new IllegalArgumentException("Wildcard in package name is only allowed at the end.".toString());
        }
        if (r.P(className, ProxyConfig.MATCH_ALL_SCHEMES, false, 2, null) && r.e0(className, ProxyConfig.MATCH_ALL_SCHEMES, 0, false, 6, null) != className.length() - 1) {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalArgumentException("Wildcard in class name is only allowed at the end.".toString());
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityFilter)) {
            return false;
        }
        ActivityFilter activityFilter = (ActivityFilter) obj;
        return t.d(this.componentName, activityFilter.componentName) && t.d(this.intentAction, activityFilter.intentAction);
    }

    @NotNull
    public final ComponentName getComponentName() {
        return this.componentName;
    }

    @Nullable
    public final String getIntentAction() {
        return this.intentAction;
    }

    public int hashCode() {
        int iHashCode = this.componentName.hashCode() * 31;
        String str = this.intentAction;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final boolean matchesActivity(@NotNull Activity activity) {
        t.i(activity, "activity");
        if (MatcherUtils.INSTANCE.areActivityOrIntentComponentsMatching$window_release(activity, this.componentName)) {
            String str = this.intentAction;
            if (str != null) {
                Intent intent = activity.getIntent();
                if (t.d(str, intent == null ? null : intent.getAction())) {
                }
            }
            return true;
        }
        return false;
    }

    public final boolean matchesIntent(@NotNull Intent intent) {
        t.i(intent, "intent");
        if (!MatcherUtils.INSTANCE.areComponentsMatching$window_release(intent.getComponent(), this.componentName)) {
            return false;
        }
        String str = this.intentAction;
        return str == null || t.d(str, intent.getAction());
    }

    @NotNull
    public String toString() {
        return "ActivityFilter(componentName=" + this.componentName + ", intentAction=" + ((Object) this.intentAction) + ')';
    }
}
