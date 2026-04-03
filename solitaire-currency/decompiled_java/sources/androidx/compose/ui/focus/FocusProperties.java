package androidx.compose.ui.focus;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FocusProperties.kt */
/* JADX INFO: loaded from: classes.dex */
public interface FocusProperties {
    boolean getCanFocus();

    @NotNull
    FocusRequester getDown();

    @NotNull
    FocusRequester getEnd();

    @NotNull
    FocusRequester getLeft();

    @NotNull
    FocusRequester getNext();

    @NotNull
    FocusRequester getPrevious();

    @NotNull
    FocusRequester getRight();

    @NotNull
    FocusRequester getStart();

    @NotNull
    FocusRequester getUp();

    void setCanFocus(boolean z10);

    void setDown(@NotNull FocusRequester focusRequester);

    void setEnd(@NotNull FocusRequester focusRequester);

    void setLeft(@NotNull FocusRequester focusRequester);

    void setNext(@NotNull FocusRequester focusRequester);

    void setPrevious(@NotNull FocusRequester focusRequester);

    void setRight(@NotNull FocusRequester focusRequester);

    void setStart(@NotNull FocusRequester focusRequester);

    void setUp(@NotNull FocusRequester focusRequester);
}
