package com.braze.ui.inappmessage;

import android.view.animation.Animation;
import com.braze.models.inappmessage.IInAppMessage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IInAppMessageAnimationFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IInAppMessageAnimationFactory {
    @Nullable
    Animation getClosingAnimation(@NotNull IInAppMessage iInAppMessage);

    @Nullable
    Animation getOpeningAnimation(@NotNull IInAppMessage iInAppMessage);
}
