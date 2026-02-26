package com.braze.ui.inappmessage.listeners;

import android.os.Bundle;
import com.braze.models.inappmessage.IInAppMessage;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: IHtmlInAppMessageActionListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IHtmlInAppMessageActionListener {
    void onCloseClicked(@NotNull IInAppMessage iInAppMessage, @NotNull String str, @NotNull Bundle bundle);

    boolean onCustomEventFired(@NotNull IInAppMessage iInAppMessage, @NotNull String str, @NotNull Bundle bundle);

    boolean onNewsfeedClicked(@NotNull IInAppMessage iInAppMessage, @NotNull String str, @NotNull Bundle bundle);

    boolean onOtherUrlAction(@NotNull IInAppMessage iInAppMessage, @NotNull String str, @NotNull Bundle bundle);
}
