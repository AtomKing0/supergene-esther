package com.king.usdk.popupwebview.internal;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import androidx.annotation.UiThread;

/* JADX INFO: loaded from: classes4.dex */
@Keep
final class PopupDialog {
    private static final int FULLSCREEN_FLAGS = 5894;
    private View contentView;
    private final boolean forceFullscreen;
    private final WindowManager wndManager;
    private b decorView = null;
    private volatile Popup openedPopup = null;

    class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f17286a = -1;

        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @UiThread
        public void onGlobalLayout() {
            if (PopupDialog.this.contentView == null) {
                return;
            }
            Rect rect = new Rect();
            PopupDialog.this.contentView.getWindowVisibleDisplayFrame(rect);
            int height = PopupDialog.this.contentView.getRootView().getHeight();
            int i10 = height - (rect.bottom - rect.top);
            ViewGroup.LayoutParams layoutParams = PopupDialog.this.contentView.getLayoutParams();
            if (i10 == this.f17286a) {
                if (layoutParams.height != height) {
                    layoutParams.height = height;
                    PopupDialog.this.contentView.requestLayout();
                    return;
                }
                return;
            }
            if (i10 > ((double) height) * 0.33d) {
                layoutParams.height = height - i10;
                PopupDialog popupDialog = PopupDialog.this;
                popupDialog.setFullScreenMode(popupDialog.contentView, true);
            } else {
                layoutParams.height = height;
                PopupDialog popupDialog2 = PopupDialog.this;
                popupDialog2.setFullScreenMode(popupDialog2.contentView, false);
            }
            this.f17286a = i10;
            PopupDialog.this.contentView.requestLayout();
        }
    }

    private final class b extends FrameLayout {
        /* synthetic */ b(PopupDialog popupDialog, Context context, a aVar) {
            this(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        @UiThread
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            KeyEvent.DispatcherState keyDispatcherState;
            if (PopupDialog.this.decorView == this && keyEvent.getKeyCode() == 4 && (keyDispatcherState = getKeyDispatcherState()) != null) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    keyDispatcherState.startTracking(keyEvent, this);
                    return true;
                }
                if (keyEvent.getAction() == 1 && keyDispatcherState.isTracking(keyEvent) && !keyEvent.isCanceled()) {
                    if (PopupDialog.this.openedPopup != null) {
                        PopupDialog.this.openedPopup.backButtonPressed();
                    }
                    return true;
                }
            }
            return super.dispatchKeyEvent(keyEvent);
        }

        private b(Context context) {
            super(context);
        }
    }

    @UiThread
    PopupDialog(View view, boolean z10) {
        this.forceFullscreen = z10;
        this.contentView = view;
        this.wndManager = (WindowManager) view.getContext().getSystemService("window");
    }

    @UiThread
    private boolean checkImmersiveMode(View view) {
        return Build.VERSION.SDK_INT >= 30 ? view.getWindowInsetsController().getSystemBarsBehavior() == 2 : (view.getSystemUiVisibility() & 6144) != 0;
    }

    @UiThread
    private void processDisplayCutout(Context context, WindowManager.LayoutParams layoutParams) {
        Window window;
        if (Build.VERSION.SDK_INT < 28 || !(context instanceof Activity) || (window = ((Activity) context).getWindow()) == null || window.getAttributes() == null) {
            return;
        }
        layoutParams.layoutInDisplayCutoutMode = window.getAttributes().layoutInDisplayCutoutMode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void setFullScreenMode(View view, boolean z10) {
        if (Build.VERSION.SDK_INT < 30) {
            if (z10) {
                view.setSystemUiVisibility(5892);
                return;
            } else {
                view.setSystemUiVisibility(FULLSCREEN_FLAGS);
                return;
            }
        }
        view.getWindowInsetsController().setSystemBarsBehavior(2);
        view.getWindowInsetsController().hide(WindowInsets.Type.statusBars());
        if (z10) {
            view.getWindowInsetsController().show(WindowInsets.Type.navigationBars());
        } else {
            view.getWindowInsetsController().hide(WindowInsets.Type.navigationBars());
        }
    }

    @UiThread
    public void close() {
        this.openedPopup = null;
        b bVar = this.decorView;
        if (bVar != null) {
            if (bVar.getParent() != null) {
                this.wndManager.removeViewImmediate(this.decorView);
            }
            this.decorView = null;
        }
        View view = this.contentView;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.contentView);
            }
        }
    }

    @UiThread
    public void destroy() {
        close();
        this.contentView = null;
    }

    public boolean isOpened() {
        return this.openedPopup != null;
    }

    @SuppressLint({"InlinedApi"})
    @UiThread
    public void open(Popup popup) {
        if (popup == null || this.contentView == null) {
            close();
            return;
        }
        View activityDecorView = popup.getActivityWrapper().getActivityDecorView();
        if (activityDecorView == null) {
            close();
            return;
        }
        if (popup == this.openedPopup) {
            return;
        }
        if (this.openedPopup != null) {
            close();
        }
        this.openedPopup = popup;
        Context context = this.contentView.getContext();
        b bVar = new b(this, context, null);
        this.decorView = bVar;
        bVar.addView(this.contentView, -1, -1);
        this.decorView.setClipChildren(false);
        this.decorView.setClipToPadding(false);
        this.decorView.setFitsSystemWindows(false);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1000;
        layoutParams.token = activityDecorView.getWindowToken();
        layoutParams.softInputMode = 1;
        layoutParams.windowAnimations = 0;
        layoutParams.format = -3;
        layoutParams.flags = 1098907656;
        layoutParams.gravity = 17;
        layoutParams.x = 0;
        layoutParams.y = 0;
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.wndManager.addView(this.decorView, layoutParams);
        if (this.forceFullscreen ? true : checkImmersiveMode(activityDecorView)) {
            setFullScreenMode(this.contentView, false);
            processDisplayCutout(context, layoutParams);
            this.contentView.getViewTreeObserver().addOnGlobalLayoutListener(new a());
        }
        WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) this.decorView.getLayoutParams();
        layoutParams2.flags &= -9;
        this.wndManager.updateViewLayout(this.decorView, layoutParams2);
    }
}
