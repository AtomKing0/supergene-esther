package com.braze.ui.inappmessage.listeners;

import android.view.View;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.MessageButton;
import com.braze.ui.inappmessage.InAppMessageCloser;
import com.braze.ui.inappmessage.InAppMessageOperation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IInAppMessageManagerListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IInAppMessageManagerListener {
    void afterInAppMessageViewClosed(@NotNull IInAppMessage iInAppMessage);

    void afterInAppMessageViewOpened(@NotNull View view, @NotNull IInAppMessage iInAppMessage);

    @NotNull
    InAppMessageOperation beforeInAppMessageDisplayed(@NotNull IInAppMessage iInAppMessage);

    void beforeInAppMessageViewClosed(@NotNull View view, @NotNull IInAppMessage iInAppMessage);

    void beforeInAppMessageViewOpened(@NotNull View view, @NotNull IInAppMessage iInAppMessage);

    boolean onInAppMessageButtonClicked(@NotNull IInAppMessage iInAppMessage, @NotNull MessageButton messageButton);

    boolean onInAppMessageButtonClicked(@NotNull IInAppMessage iInAppMessage, @NotNull MessageButton messageButton, @Nullable InAppMessageCloser inAppMessageCloser);

    boolean onInAppMessageClicked(@NotNull IInAppMessage iInAppMessage);

    boolean onInAppMessageClicked(@NotNull IInAppMessage iInAppMessage, @Nullable InAppMessageCloser inAppMessageCloser);

    void onInAppMessageDismissed(@NotNull IInAppMessage iInAppMessage);
}
