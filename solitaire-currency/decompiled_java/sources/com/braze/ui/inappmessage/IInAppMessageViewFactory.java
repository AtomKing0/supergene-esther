package com.braze.ui.inappmessage;

import android.app.Activity;
import android.view.View;
import com.braze.models.inappmessage.IInAppMessage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IInAppMessageViewFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IInAppMessageViewFactory {
    @Nullable
    View createInAppMessageView(@NotNull Activity activity, @NotNull IInAppMessage iInAppMessage);
}
