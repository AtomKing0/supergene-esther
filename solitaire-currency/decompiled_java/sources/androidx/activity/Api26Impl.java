package androidx.activity;

import android.app.Activity;
import android.app.PictureInPictureParams;
import android.graphics.Rect;
import androidx.annotation.RequiresApi;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PipHintTracker.kt */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
public final class Api26Impl {

    @NotNull
    public static final Api26Impl INSTANCE = new Api26Impl();

    private Api26Impl() {
    }

    public final void setPipParamsSourceRectHint(@NotNull Activity activity, @NotNull Rect rect) {
        activity.setPictureInPictureParams(new PictureInPictureParams.Builder().setSourceRectHint(rect).build());
    }
}
