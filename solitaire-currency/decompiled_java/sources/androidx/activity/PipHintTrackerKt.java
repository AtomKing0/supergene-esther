package androidx.activity;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.RequiresApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: PipHintTracker.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PipHintTrackerKt {
    @RequiresApi(26)
    @Nullable
    public static final Object trackPipAnimationHintView(@NotNull final Activity activity, @NotNull View view, @NotNull z8.d<? super k0> dVar) {
        Object objCollect = s9.j.f(new PipHintTrackerKt$trackPipAnimationHintView$flow$1(view, null)).collect(new s9.i() { // from class: androidx.activity.PipHintTrackerKt.trackPipAnimationHintView.2
            @Override // s9.i
            public /* bridge */ /* synthetic */ Object emit(Object obj, z8.d dVar2) {
                return emit((Rect) obj, (z8.d<? super k0>) dVar2);
            }

            @Nullable
            public final Object emit(@NotNull Rect rect, @NotNull z8.d<? super k0> dVar2) {
                Api26Impl.INSTANCE.setPipParamsSourceRectHint(activity, rect);
                return k0.f35197a;
            }
        }, dVar);
        return objCollect == a9.d.e() ? objCollect : k0.f35197a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect trackPipAnimationHintView$positionInWindow(View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect;
    }
}
