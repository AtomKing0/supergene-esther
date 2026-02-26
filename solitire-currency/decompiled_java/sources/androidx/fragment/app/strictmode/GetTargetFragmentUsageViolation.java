package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: GetTargetFragmentUsageViolation.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GetTargetFragmentUsageViolation extends TargetFragmentUsageViolation {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetTargetFragmentUsageViolation(@NotNull Fragment fragment) {
        super(fragment, "Attempting to get target fragment from fragment " + fragment);
        t.i(fragment, "fragment");
    }
}
