package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import androidx.webkit.ProxyConfig;
import androidx.window.core.ExperimentalWindowApi;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import p9.q;
import p9.r;

/* JADX INFO: compiled from: MatcherUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@ExperimentalWindowApi
public final class MatcherUtils {

    @NotNull
    public static final MatcherUtils INSTANCE = new MatcherUtils();
    public static final boolean sDebugMatchers = false;

    @NotNull
    public static final String sMatchersTag = "SplitRuleResolution";

    private MatcherUtils() {
    }

    private final boolean wildcardMatch(String str, String str2) {
        if (!r.P(str2, ProxyConfig.MATCH_ALL_SCHEMES, false, 2, null)) {
            return false;
        }
        if (t.d(str2, ProxyConfig.MATCH_ALL_SCHEMES)) {
            return true;
        }
        if (!(r.e0(str2, ProxyConfig.MATCH_ALL_SCHEMES, 0, false, 6, null) == r.k0(str2, ProxyConfig.MATCH_ALL_SCHEMES, 0, false, 6, null) && q.w(str2, ProxyConfig.MATCH_ALL_SCHEMES, false, 2, null))) {
            throw new IllegalArgumentException("Name pattern with a wildcard must only contain a single wildcard in the end".toString());
        }
        String strSubstring = str2.substring(0, str2.length() - 1);
        t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return q.K(str, strSubstring, false, 2, null);
    }

    public final boolean areActivityOrIntentComponentsMatching$window_release(@NotNull Activity activity, @NotNull ComponentName ruleComponent) {
        ComponentName component;
        t.i(activity, "activity");
        t.i(ruleComponent, "ruleComponent");
        if (areComponentsMatching$window_release(activity.getComponentName(), ruleComponent)) {
            return true;
        }
        Intent intent = activity.getIntent();
        if (intent == null || (component = intent.getComponent()) == null) {
            return false;
        }
        return INSTANCE.areComponentsMatching$window_release(component, ruleComponent);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean areComponentsMatching$window_release(@org.jetbrains.annotations.Nullable android.content.ComponentName r7, @org.jetbrains.annotations.NotNull android.content.ComponentName r8) {
        /*
            r6 = this;
            java.lang.String r0 = "ruleComponent"
            kotlin.jvm.internal.t.i(r8, r0)
            java.lang.String r0 = "*"
            r1 = 1
            r2 = 0
            if (r7 != 0) goto L22
            java.lang.String r7 = r8.getPackageName()
            boolean r7 = kotlin.jvm.internal.t.d(r7, r0)
            if (r7 == 0) goto L20
            java.lang.String r7 = r8.getClassName()
            boolean r7 = kotlin.jvm.internal.t.d(r7, r0)
            if (r7 == 0) goto L20
            goto L21
        L20:
            r1 = r2
        L21:
            return r1
        L22:
            java.lang.String r3 = r7.toString()
            java.lang.String r4 = "activityComponent.toString()"
            kotlin.jvm.internal.t.h(r3, r4)
            r4 = 2
            r5 = 0
            boolean r0 = p9.h.P(r3, r0, r2, r4, r5)
            r0 = r0 ^ r1
            if (r0 == 0) goto L8f
            java.lang.String r0 = r7.getPackageName()
            java.lang.String r3 = r8.getPackageName()
            boolean r0 = kotlin.jvm.internal.t.d(r0, r3)
            if (r0 != 0) goto L5d
            java.lang.String r0 = r7.getPackageName()
            java.lang.String r3 = "activityComponent.packageName"
            kotlin.jvm.internal.t.h(r0, r3)
            java.lang.String r3 = r8.getPackageName()
            java.lang.String r4 = "ruleComponent.packageName"
            kotlin.jvm.internal.t.h(r3, r4)
            boolean r0 = r6.wildcardMatch(r0, r3)
            if (r0 == 0) goto L5b
            goto L5d
        L5b:
            r0 = r2
            goto L5e
        L5d:
            r0 = r1
        L5e:
            java.lang.String r3 = r7.getClassName()
            java.lang.String r4 = r8.getClassName()
            boolean r3 = kotlin.jvm.internal.t.d(r3, r4)
            if (r3 != 0) goto L87
            java.lang.String r7 = r7.getClassName()
            java.lang.String r3 = "activityComponent.className"
            kotlin.jvm.internal.t.h(r7, r3)
            java.lang.String r8 = r8.getClassName()
            java.lang.String r3 = "ruleComponent.className"
            kotlin.jvm.internal.t.h(r8, r3)
            boolean r7 = r6.wildcardMatch(r7, r8)
            if (r7 == 0) goto L85
            goto L87
        L85:
            r7 = r2
            goto L88
        L87:
            r7 = r1
        L88:
            if (r0 == 0) goto L8d
            if (r7 == 0) goto L8d
            goto L8e
        L8d:
            r1 = r2
        L8e:
            return r1
        L8f:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "Wildcard can only be part of the rule."
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.embedding.MatcherUtils.areComponentsMatching$window_release(android.content.ComponentName, android.content.ComponentName):boolean");
    }
}
