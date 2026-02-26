package com.braze.ui.inappmessage.views;

import android.view.View;
import androidx.core.view.WindowInsetsCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IInAppMessageView.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IInAppMessageView {
    void applyWindowInsets(@NotNull WindowInsetsCompat windowInsetsCompat);

    boolean getHasAppliedWindowInsets();

    @Nullable
    View getMessageClickableView();
}
