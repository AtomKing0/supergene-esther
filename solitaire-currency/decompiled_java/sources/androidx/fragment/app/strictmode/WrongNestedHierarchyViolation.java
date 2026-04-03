package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: WrongNestedHierarchyViolation.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WrongNestedHierarchyViolation extends Violation {
    private final int containerId;

    @NotNull
    private final Fragment expectedParentFragment;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WrongNestedHierarchyViolation(@NotNull Fragment fragment, @NotNull Fragment expectedParentFragment, int i10) {
        super(fragment, "Attempting to nest fragment " + fragment + " within the view of parent fragment " + expectedParentFragment + " via container with ID " + i10 + " without using parent's childFragmentManager");
        t.i(fragment, "fragment");
        t.i(expectedParentFragment, "expectedParentFragment");
        this.expectedParentFragment = expectedParentFragment;
        this.containerId = i10;
    }

    public final int getContainerId() {
        return this.containerId;
    }

    @NotNull
    public final Fragment getExpectedParentFragment() {
        return this.expectedParentFragment;
    }
}
