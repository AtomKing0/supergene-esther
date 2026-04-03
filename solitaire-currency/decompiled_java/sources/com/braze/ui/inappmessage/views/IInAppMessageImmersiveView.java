package com.braze.ui.inappmessage.views;

import android.view.View;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IInAppMessageImmersiveView.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IInAppMessageImmersiveView extends IInAppMessageView {
    @NotNull
    List<View> getMessageButtonViews(int i10);

    @Nullable
    View getMessageCloseButtonView();
}
