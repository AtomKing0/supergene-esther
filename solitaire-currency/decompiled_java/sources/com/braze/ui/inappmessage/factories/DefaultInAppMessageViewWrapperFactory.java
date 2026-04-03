package com.braze.ui.inappmessage.factories;

import android.view.View;
import android.view.animation.Animation;
import androidx.media3.exoplayer.RendererCapabilities;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.ui.inappmessage.DefaultInAppMessageViewWrapper;
import com.braze.ui.inappmessage.IInAppMessageViewWrapper;
import com.braze.ui.inappmessage.IInAppMessageViewWrapperFactory;
import com.braze.ui.inappmessage.listeners.IInAppMessageViewLifecycleListener;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DefaultInAppMessageViewWrapperFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
public class DefaultInAppMessageViewWrapperFactory implements IInAppMessageViewWrapperFactory {
    @Override // com.braze.ui.inappmessage.IInAppMessageViewWrapperFactory
    @NotNull
    public IInAppMessageViewWrapper createInAppMessageViewWrapper(@NotNull View inAppMessageView, @NotNull IInAppMessage inAppMessage, @NotNull IInAppMessageViewLifecycleListener inAppMessageViewLifecycleListener, @NotNull BrazeConfigurationProvider configurationProvider, @Nullable Animation animation, @Nullable Animation animation2, @Nullable View view) {
        t.i(inAppMessageView, "inAppMessageView");
        t.i(inAppMessage, "inAppMessage");
        t.i(inAppMessageViewLifecycleListener, "inAppMessageViewLifecycleListener");
        t.i(configurationProvider, "configurationProvider");
        return new DefaultInAppMessageViewWrapper(inAppMessageView, inAppMessage, inAppMessageViewLifecycleListener, configurationProvider, animation, animation2, view, null, null, RendererCapabilities.DECODER_SUPPORT_MASK, null);
    }

    @Override // com.braze.ui.inappmessage.IInAppMessageViewWrapperFactory
    @NotNull
    public IInAppMessageViewWrapper createInAppMessageViewWrapper(@NotNull View inAppMessageView, @NotNull IInAppMessage inAppMessage, @NotNull IInAppMessageViewLifecycleListener inAppMessageViewLifecycleListener, @NotNull BrazeConfigurationProvider configurationProvider, @Nullable Animation animation, @Nullable Animation animation2, @Nullable View view, @Nullable List<? extends View> list, @Nullable View view2) {
        t.i(inAppMessageView, "inAppMessageView");
        t.i(inAppMessage, "inAppMessage");
        t.i(inAppMessageViewLifecycleListener, "inAppMessageViewLifecycleListener");
        t.i(configurationProvider, "configurationProvider");
        return new DefaultInAppMessageViewWrapper(inAppMessageView, inAppMessage, inAppMessageViewLifecycleListener, configurationProvider, animation, animation2, view, list, view2);
    }
}
