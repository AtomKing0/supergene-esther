package androidx.compose.foundation.gestures;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ForEachGesture.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class GestureCancellationException extends CancellationException {
    public static final int $stable = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public GestureCancellationException() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public GestureCancellationException(@Nullable String str) {
        super(str);
    }

    public /* synthetic */ GestureCancellationException(String str, int i10, k kVar) {
        this((i10 & 1) != 0 ? null : str);
    }
}
