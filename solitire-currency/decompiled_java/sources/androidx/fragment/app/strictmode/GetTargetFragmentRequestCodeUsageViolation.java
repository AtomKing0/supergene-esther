package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: GetTargetFragmentRequestCodeUsageViolation.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GetTargetFragmentRequestCodeUsageViolation extends TargetFragmentUsageViolation {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetTargetFragmentRequestCodeUsageViolation(@NotNull Fragment fragment) {
        super(fragment, "Attempting to get target request code from fragment " + fragment);
        t.i(fragment, "fragment");
    }
}
