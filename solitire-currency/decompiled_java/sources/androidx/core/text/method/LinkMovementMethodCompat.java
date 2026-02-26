package androidx.core.text.method;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.Touch;
import android.view.MotionEvent;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.core.os.BuildCompat;

/* JADX INFO: loaded from: classes.dex */
public class LinkMovementMethodCompat extends LinkMovementMethod {
    private static LinkMovementMethodCompat sInstance;

    private LinkMovementMethodCompat() {
    }

    @NonNull
    public static LinkMovementMethodCompat getInstance() {
        if (sInstance == null) {
            sInstance = new LinkMovementMethodCompat();
        }
        return sInstance;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public boolean onTouchEvent(@Nullable TextView textView, @Nullable Spannable spannable, @Nullable MotionEvent motionEvent) {
        if (!BuildCompat.isAtLeastV()) {
            int action = motionEvent.getAction();
            boolean z10 = true;
            if (action == 1 || action == 0) {
                int x10 = (int) motionEvent.getX();
                int y10 = (int) motionEvent.getY();
                int totalPaddingLeft = x10 - textView.getTotalPaddingLeft();
                int totalPaddingTop = y10 - textView.getTotalPaddingTop();
                int scrollX = totalPaddingLeft + textView.getScrollX();
                int scrollY = totalPaddingTop + textView.getScrollY();
                Layout layout = textView.getLayout();
                if (scrollY >= 0 && scrollY <= layout.getHeight()) {
                    int lineForVertical = layout.getLineForVertical(scrollY);
                    float f10 = scrollX;
                    if (f10 >= layout.getLineLeft(lineForVertical) && f10 <= layout.getLineRight(lineForVertical)) {
                        z10 = false;
                    }
                }
                if (z10) {
                    Selection.removeSelection(spannable);
                    return Touch.onTouchEvent(textView, spannable, motionEvent);
                }
            }
        }
        return super.onTouchEvent(textView, spannable, motionEvent);
    }
}
