package androidx.work.impl.constraints;

import androidx.work.impl.model.WorkSpec;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: WorkConstraintsTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface OnConstraintsStateChangedListener {
    void onConstraintsStateChanged(@NotNull WorkSpec workSpec, @NotNull ConstraintsState constraintsState);
}
