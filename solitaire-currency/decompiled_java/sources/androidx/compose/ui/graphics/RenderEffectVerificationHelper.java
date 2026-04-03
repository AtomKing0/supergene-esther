package androidx.compose.ui.graphics;

import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.geometry.Offset;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidRenderEffect.android.kt */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(31)
final class RenderEffectVerificationHelper {

    @NotNull
    public static final RenderEffectVerificationHelper INSTANCE = new RenderEffectVerificationHelper();

    private RenderEffectVerificationHelper() {
    }

    @DoNotInline
    @NotNull
    /* JADX INFO: renamed from: createBlurEffect-8A-3gB4, reason: not valid java name */
    public final android.graphics.RenderEffect m1851createBlurEffect8A3gB4(@Nullable RenderEffect renderEffect, float f10, float f11, int i10) {
        if (renderEffect == null) {
            android.graphics.RenderEffect renderEffectCreateBlurEffect = android.graphics.RenderEffect.createBlurEffect(f10, f11, AndroidTileMode_androidKt.m1511toAndroidTileMode0vamqd0(i10));
            kotlin.jvm.internal.t.h(renderEffectCreateBlurEffect, "{\n            android.gr…)\n            )\n        }");
            return renderEffectCreateBlurEffect;
        }
        android.graphics.RenderEffect renderEffectCreateBlurEffect2 = android.graphics.RenderEffect.createBlurEffect(f10, f11, renderEffect.asAndroidRenderEffect(), AndroidTileMode_androidKt.m1511toAndroidTileMode0vamqd0(i10));
        kotlin.jvm.internal.t.h(renderEffectCreateBlurEffect2, "{\n            android.gr…)\n            )\n        }");
        return renderEffectCreateBlurEffect2;
    }

    @DoNotInline
    @NotNull
    /* JADX INFO: renamed from: createOffsetEffect-Uv8p0NA, reason: not valid java name */
    public final android.graphics.RenderEffect m1852createOffsetEffectUv8p0NA(@Nullable RenderEffect renderEffect, long j10) {
        if (renderEffect == null) {
            android.graphics.RenderEffect renderEffectCreateOffsetEffect = android.graphics.RenderEffect.createOffsetEffect(Offset.m1367getXimpl(j10), Offset.m1368getYimpl(j10));
            kotlin.jvm.internal.t.h(renderEffectCreateOffsetEffect, "{\n            android.gr…et.x, offset.y)\n        }");
            return renderEffectCreateOffsetEffect;
        }
        android.graphics.RenderEffect renderEffectCreateOffsetEffect2 = android.graphics.RenderEffect.createOffsetEffect(Offset.m1367getXimpl(j10), Offset.m1368getYimpl(j10), renderEffect.asAndroidRenderEffect());
        kotlin.jvm.internal.t.h(renderEffectCreateOffsetEffect2, "{\n            android.gr…)\n            )\n        }");
        return renderEffectCreateOffsetEffect2;
    }
}
