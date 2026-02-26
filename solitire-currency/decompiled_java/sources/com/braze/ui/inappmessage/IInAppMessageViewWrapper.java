package com.braze.ui.inappmessage;

import android.app.Activity;
import android.view.View;
import com.braze.models.inappmessage.IInAppMessage;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: IInAppMessageViewWrapper.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IInAppMessageViewWrapper {
    void close();

    @NotNull
    IInAppMessage getInAppMessage();

    @NotNull
    View getInAppMessageView();

    boolean isAnimatingClose();

    void open(@NotNull Activity activity);
}
