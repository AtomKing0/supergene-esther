package androidx.window.layout;

import androidx.annotation.RestrictTo;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: WindowInfoTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface WindowInfoTrackerDecorator {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    WindowInfoTracker decorate(@NotNull WindowInfoTracker windowInfoTracker);
}
