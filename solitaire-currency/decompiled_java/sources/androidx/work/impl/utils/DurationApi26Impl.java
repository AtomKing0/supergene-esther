package androidx.work.impl.utils;

import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.time.Duration;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DurationApi26.kt */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(26)
public final class DurationApi26Impl {
    @DoNotInline
    public static final long toMillisCompat(@NotNull Duration duration) {
        t.i(duration, "<this>");
        return duration.toMillis();
    }
}
