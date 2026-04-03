package com.braze.ui.inappmessage.listeners;

import android.os.Bundle;
import com.braze.models.inappmessage.IInAppMessage;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: IInAppMessageWebViewClientListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IInAppMessageWebViewClientListener {
    void onCloseAction(@NotNull IInAppMessage iInAppMessage, @NotNull String str, @NotNull Bundle bundle);

    void onCustomEventAction(@NotNull IInAppMessage iInAppMessage, @NotNull String str, @NotNull Bundle bundle);

    void onNewsfeedAction(@NotNull IInAppMessage iInAppMessage, @NotNull String str, @NotNull Bundle bundle);

    void onOtherUrlAction(@NotNull IInAppMessage iInAppMessage, @NotNull String str, @NotNull Bundle bundle);
}
