package androidx.compose.ui.focus;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FocusOrderModifier.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class FocusOrder {
    public static final int $stable = 8;

    @NotNull
    private final FocusProperties focusProperties;

    public FocusOrder(@NotNull FocusProperties focusProperties) {
        t.i(focusProperties, "focusProperties");
        this.focusProperties = focusProperties;
    }

    @NotNull
    public final FocusRequester getDown() {
        return this.focusProperties.getDown();
    }

    @NotNull
    public final FocusRequester getEnd() {
        return this.focusProperties.getEnd();
    }

    @NotNull
    public final FocusRequester getLeft() {
        return this.focusProperties.getLeft();
    }

    @NotNull
    public final FocusRequester getNext() {
        return this.focusProperties.getNext();
    }

    @NotNull
    public final FocusRequester getPrevious() {
        return this.focusProperties.getPrevious();
    }

    @NotNull
    public final FocusRequester getRight() {
        return this.focusProperties.getRight();
    }

    @NotNull
    public final FocusRequester getStart() {
        return this.focusProperties.getStart();
    }

    @NotNull
    public final FocusRequester getUp() {
        return this.focusProperties.getUp();
    }

    public final void setDown(@NotNull FocusRequester down) {
        t.i(down, "down");
        this.focusProperties.setDown(down);
    }

    public final void setEnd(@NotNull FocusRequester end) {
        t.i(end, "end");
        this.focusProperties.setEnd(end);
    }

    public final void setLeft(@NotNull FocusRequester left) {
        t.i(left, "left");
        this.focusProperties.setLeft(left);
    }

    public final void setNext(@NotNull FocusRequester next) {
        t.i(next, "next");
        this.focusProperties.setNext(next);
    }

    public final void setPrevious(@NotNull FocusRequester previous) {
        t.i(previous, "previous");
        this.focusProperties.setPrevious(previous);
    }

    public final void setRight(@NotNull FocusRequester right) {
        t.i(right, "right");
        this.focusProperties.setRight(right);
    }

    public final void setStart(@NotNull FocusRequester start) {
        t.i(start, "start");
        this.focusProperties.setStart(start);
    }

    public final void setUp(@NotNull FocusRequester up) {
        t.i(up, "up");
        this.focusProperties.setUp(up);
    }

    public FocusOrder() {
        this(new FocusPropertiesImpl());
    }
}
