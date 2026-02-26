package com.braze.ui.inappmessage.factories;

import android.R;
import android.content.res.Resources;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.braze.enums.inappmessage.SlideFrom;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.InAppMessageSlideup;
import com.braze.ui.inappmessage.IInAppMessageAnimationFactory;
import com.braze.ui.support.AnimationUtils;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DefaultInAppMessageAnimationFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
public class DefaultInAppMessageAnimationFactory implements IInAppMessageAnimationFactory {
    private final long shortAnimationDurationMs = Resources.getSystem().getInteger(R.integer.config_shortAnimTime);

    @Override // com.braze.ui.inappmessage.IInAppMessageAnimationFactory
    @Nullable
    public Animation getClosingAnimation(@NotNull IInAppMessage inAppMessage) {
        t.i(inAppMessage, "inAppMessage");
        return inAppMessage instanceof InAppMessageSlideup ? ((InAppMessageSlideup) inAppMessage).getSlideFrom() == SlideFrom.TOP ? AnimationUtils.createVerticalAnimation(0.0f, -1.0f, this.shortAnimationDurationMs, false) : AnimationUtils.createVerticalAnimation(0.0f, 1.0f, this.shortAnimationDurationMs, false) : AnimationUtils.setAnimationParams(new AlphaAnimation(1.0f, 0.0f), this.shortAnimationDurationMs, false);
    }

    @Override // com.braze.ui.inappmessage.IInAppMessageAnimationFactory
    @Nullable
    public Animation getOpeningAnimation(@NotNull IInAppMessage inAppMessage) {
        t.i(inAppMessage, "inAppMessage");
        return inAppMessage instanceof InAppMessageSlideup ? ((InAppMessageSlideup) inAppMessage).getSlideFrom() == SlideFrom.TOP ? AnimationUtils.createVerticalAnimation(-1.0f, 0.0f, this.shortAnimationDurationMs, false) : AnimationUtils.createVerticalAnimation(1.0f, 0.0f, this.shortAnimationDurationMs, false) : AnimationUtils.setAnimationParams(new AlphaAnimation(0.0f, 1.0f), this.shortAnimationDurationMs, true);
    }
}
