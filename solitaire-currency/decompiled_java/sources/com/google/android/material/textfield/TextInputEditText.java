package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;

/* JADX INFO: loaded from: classes3.dex */
public class TextInputEditText extends AppCompatEditText {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Rect f9655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f9656b;

    public TextInputEditText(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, e4.b.f24757n);
    }

    private boolean a(@Nullable TextInputLayout textInputLayout) {
        return textInputLayout != null && this.f9656b;
    }

    @Nullable
    private CharSequence getHintFromLayout() {
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null) {
            return textInputLayout.getHint();
        }
        return null;
    }

    @Nullable
    private TextInputLayout getTextInputLayout() {
        for (ViewParent parent = getParent(); parent instanceof View; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(@Nullable Rect rect) {
        super.getFocusedRect(rect);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (!a(textInputLayout) || rect == null) {
            return;
        }
        textInputLayout.getFocusedRect(this.f9655a);
        rect.bottom = this.f9655a.bottom;
    }

    @Override // android.view.View
    public boolean getGlobalVisibleRect(@Nullable Rect rect, @Nullable Point point) {
        TextInputLayout textInputLayout = getTextInputLayout();
        if (!a(textInputLayout)) {
            return super.getGlobalVisibleRect(rect, point);
        }
        boolean globalVisibleRect = textInputLayout.getGlobalVisibleRect(rect, point);
        if (globalVisibleRect && point != null) {
            point.offset(-getScrollX(), -getScrollY());
        }
        return globalVisibleRect;
    }

    @Override // android.widget.TextView
    @Nullable
    public CharSequence getHint() {
        TextInputLayout textInputLayout = getTextInputLayout();
        return (textInputLayout == null || !textInputLayout.R()) ? super.getHint() : textInputLayout.getHint();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && textInputLayout.R() && super.getHint() == null && com.google.android.material.internal.i.b()) {
            setHint("");
        }
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    @Nullable
    public InputConnection onCreateInputConnection(@NonNull EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (inputConnectionOnCreateInputConnection != null && editorInfo.hintText == null) {
            editorInfo.hintText = getHintFromLayout();
        }
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        getTextInputLayout();
    }

    @Override // android.view.View
    public boolean requestRectangleOnScreen(@Nullable Rect rect) {
        TextInputLayout textInputLayout = getTextInputLayout();
        if (!a(textInputLayout) || rect == null) {
            return super.requestRectangleOnScreen(rect);
        }
        this.f9655a.set(rect.left, rect.top, rect.right, rect.bottom + (textInputLayout.getHeight() - getHeight()));
        return super.requestRectangleOnScreen(this.f9655a);
    }

    public void setTextInputLayoutFocusedRectEnabled(boolean z10) {
        this.f9656b = z10;
    }

    public TextInputEditText(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(b5.a.c(context, attributeSet, i10, 0), attributeSet, i10);
        this.f9655a = new Rect();
        TypedArray typedArrayI = com.google.android.material.internal.p.i(context, attributeSet, e4.k.f25028n5, i10, e4.j.f24901g, new int[0]);
        setTextInputLayoutFocusedRectEnabled(typedArrayI.getBoolean(e4.k.f25036o5, false));
        typedArrayI.recycle();
    }
}
