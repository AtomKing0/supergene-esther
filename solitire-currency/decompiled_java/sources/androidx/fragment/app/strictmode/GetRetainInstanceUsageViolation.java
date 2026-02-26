package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: GetRetainInstanceUsageViolation.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GetRetainInstanceUsageViolation extends RetainInstanceUsageViolation {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetRetainInstanceUsageViolation(@NotNull Fragment fragment) {
        super(fragment, "Attempting to get retain instance for fragment " + fragment);
        t.i(fragment, "fragment");
    }
}
