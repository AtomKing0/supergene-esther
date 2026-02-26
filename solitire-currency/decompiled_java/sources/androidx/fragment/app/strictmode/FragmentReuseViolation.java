package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FragmentReuseViolation.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FragmentReuseViolation extends Violation {

    @NotNull
    private final String previousFragmentId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentReuseViolation(@NotNull Fragment fragment, @NotNull String previousFragmentId) {
        super(fragment, "Attempting to reuse fragment " + fragment + " with previous ID " + previousFragmentId);
        t.i(fragment, "fragment");
        t.i(previousFragmentId, "previousFragmentId");
        this.previousFragmentId = previousFragmentId;
    }

    @NotNull
    public final String getPreviousFragmentId() {
        return this.previousFragmentId;
    }
}
