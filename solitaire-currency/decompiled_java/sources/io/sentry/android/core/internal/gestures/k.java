package io.sentry.android.core.internal.gestures;

import android.annotation.SuppressLint;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: WindowCallbackAdapter.java */
/* JADX INFO: loaded from: classes5.dex */
public class k implements Window.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Window.Callback f27265a;

    public k(Window.Callback callback) {
        this.f27265a = callback;
    }

    @Override // android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f27265a.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f27265a.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.f27265a.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f27265a.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTouchEvent(@Nullable MotionEvent motionEvent) {
        return this.f27265a.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f27265a.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public void onActionModeFinished(ActionMode actionMode) {
        this.f27265a.onActionModeFinished(actionMode);
    }

    @Override // android.view.Window.Callback
    public void onActionModeStarted(ActionMode actionMode) {
        this.f27265a.onActionModeStarted(actionMode);
    }

    @Override // android.view.Window.Callback
    public void onAttachedToWindow() {
        this.f27265a.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public void onContentChanged() {
        this.f27265a.onContentChanged();
    }

    @Override // android.view.Window.Callback
    public boolean onCreatePanelMenu(int i10, @NotNull Menu menu) {
        return this.f27265a.onCreatePanelMenu(i10, menu);
    }

    @Override // android.view.Window.Callback
    @Nullable
    public View onCreatePanelView(int i10) {
        return this.f27265a.onCreatePanelView(i10);
    }

    @Override // android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.f27265a.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public boolean onMenuItemSelected(int i10, @NotNull MenuItem menuItem) {
        return this.f27265a.onMenuItemSelected(i10, menuItem);
    }

    @Override // android.view.Window.Callback
    public boolean onMenuOpened(int i10, @NotNull Menu menu) {
        return this.f27265a.onMenuOpened(i10, menu);
    }

    @Override // android.view.Window.Callback
    public void onPanelClosed(int i10, @NotNull Menu menu) {
        this.f27265a.onPanelClosed(i10, menu);
    }

    @Override // android.view.Window.Callback
    public boolean onPreparePanel(int i10, @Nullable View view, @NotNull Menu menu) {
        return this.f27265a.onPreparePanel(i10, view, menu);
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested() {
        return this.f27265a.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.f27265a.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.view.Window.Callback
    public void onWindowFocusChanged(boolean z10) {
        this.f27265a.onWindowFocusChanged(z10);
    }

    @Override // android.view.Window.Callback
    @Nullable
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.f27265a.onWindowStartingActionMode(callback);
    }

    @Override // android.view.Window.Callback
    @SuppressLint({"NewApi"})
    public boolean onSearchRequested(SearchEvent searchEvent) {
        return this.f27265a.onSearchRequested(searchEvent);
    }

    @Override // android.view.Window.Callback
    @SuppressLint({"NewApi"})
    @Nullable
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i10) {
        return this.f27265a.onWindowStartingActionMode(callback, i10);
    }
}
