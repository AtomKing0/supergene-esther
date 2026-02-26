package com.braze.ui.inappmessage;

import android.view.View;
import android.view.animation.Animation;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.ui.inappmessage.listeners.IInAppMessageViewLifecycleListener;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IInAppMessageViewWrapperFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IInAppMessageViewWrapperFactory {
    @NotNull
    IInAppMessageViewWrapper createInAppMessageViewWrapper(@NotNull View view, @NotNull IInAppMessage iInAppMessage, @NotNull IInAppMessageViewLifecycleListener iInAppMessageViewLifecycleListener, @NotNull BrazeConfigurationProvider brazeConfigurationProvider, @Nullable Animation animation, @Nullable Animation animation2, @Nullable View view2);

    @NotNull
    IInAppMessageViewWrapper createInAppMessageViewWrapper(@NotNull View view, @NotNull IInAppMessage iInAppMessage, @NotNull IInAppMessageViewLifecycleListener iInAppMessageViewLifecycleListener, @NotNull BrazeConfigurationProvider brazeConfigurationProvider, @Nullable Animation animation, @Nullable Animation animation2, @Nullable View view2, @Nullable List<? extends View> list, @Nullable View view3);
}
