package com.braze.ui.inappmessage.listeners;

import android.view.View;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.IInAppMessageImmersive;
import com.braze.models.inappmessage.MessageButton;
import com.braze.ui.inappmessage.InAppMessageCloser;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: IInAppMessageViewLifecycleListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IInAppMessageViewLifecycleListener {
    void afterClosed(@NotNull IInAppMessage iInAppMessage);

    void afterOpened(@NotNull View view, @NotNull IInAppMessage iInAppMessage);

    void beforeClosed(@NotNull View view, @NotNull IInAppMessage iInAppMessage);

    void beforeOpened(@NotNull View view, @NotNull IInAppMessage iInAppMessage);

    void onButtonClicked(@NotNull InAppMessageCloser inAppMessageCloser, @NotNull MessageButton messageButton, @NotNull IInAppMessageImmersive iInAppMessageImmersive);

    void onClicked(@NotNull InAppMessageCloser inAppMessageCloser, @NotNull View view, @NotNull IInAppMessage iInAppMessage);

    void onDismissed(@NotNull View view, @NotNull IInAppMessage iInAppMessage);
}
