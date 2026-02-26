package androidx.activity;

import android.view.View;
import androidx.annotation.RequiresApi;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PipHintTracker.kt */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(19)
public final class Api19Impl {

    @NotNull
    public static final Api19Impl INSTANCE = new Api19Impl();

    private Api19Impl() {
    }

    public final boolean isAttachedToWindow(@NotNull View view) {
        return view.isAttachedToWindow();
    }
}
