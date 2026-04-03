package androidx.core.view;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.CancellationSignal;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import android.view.WindowInsetsController;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.media3.common.C;

/* JADX INFO: loaded from: classes.dex */
public final class WindowInsetsControllerCompat {
    public static final int BEHAVIOR_DEFAULT = 1;

    @Deprecated
    public static final int BEHAVIOR_SHOW_BARS_BY_SWIPE = 1;

    @Deprecated
    public static final int BEHAVIOR_SHOW_BARS_BY_TOUCH = 0;
    public static final int BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE = 2;
    private final Impl mImpl;

    @RequiresApi(23)
    private static class Impl23 extends Impl20 {
        Impl23(@NonNull Window window, @NonNull SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            super(window, softwareKeyboardControllerCompat);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightStatusBars() {
            return (this.mWindow.getDecorView().getSystemUiVisibility() & 8192) != 0;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightStatusBars(boolean z10) {
            if (!z10) {
                unsetSystemUiFlag(8192);
                return;
            }
            unsetWindowFlag(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
            setWindowFlag(Integer.MIN_VALUE);
            setSystemUiFlag(8192);
        }
    }

    @RequiresApi(26)
    private static class Impl26 extends Impl23 {
        Impl26(@NonNull Window window, @NonNull SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            super(window, softwareKeyboardControllerCompat);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightNavigationBars() {
            return (this.mWindow.getDecorView().getSystemUiVisibility() & 16) != 0;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightNavigationBars(boolean z10) {
            if (!z10) {
                unsetSystemUiFlag(16);
                return;
            }
            unsetWindowFlag(C.BUFFER_FLAG_FIRST_SAMPLE);
            setWindowFlag(Integer.MIN_VALUE);
            setSystemUiFlag(16);
        }
    }

    public interface OnControllableInsetsChangedListener {
        void onControllableInsetsChanged(@NonNull WindowInsetsControllerCompat windowInsetsControllerCompat, int i10);
    }

    @RequiresApi(30)
    @Deprecated
    private WindowInsetsControllerCompat(@NonNull WindowInsetsController windowInsetsController) {
        this.mImpl = new Impl30(windowInsetsController, this, new SoftwareKeyboardControllerCompat(windowInsetsController));
    }

    @NonNull
    @RequiresApi(30)
    @Deprecated
    public static WindowInsetsControllerCompat toWindowInsetsControllerCompat(@NonNull WindowInsetsController windowInsetsController) {
        return new WindowInsetsControllerCompat(windowInsetsController);
    }

    public void addOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        this.mImpl.addOnControllableInsetsChangedListener(onControllableInsetsChangedListener);
    }

    public void controlWindowInsetsAnimation(int i10, long j10, @Nullable Interpolator interpolator, @Nullable CancellationSignal cancellationSignal, @NonNull WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
        this.mImpl.controlWindowInsetsAnimation(i10, j10, interpolator, cancellationSignal, windowInsetsAnimationControlListenerCompat);
    }

    @SuppressLint({"WrongConstant"})
    public int getSystemBarsBehavior() {
        return this.mImpl.getSystemBarsBehavior();
    }

    public void hide(int i10) {
        this.mImpl.hide(i10);
    }

    public boolean isAppearanceLightNavigationBars() {
        return this.mImpl.isAppearanceLightNavigationBars();
    }

    public boolean isAppearanceLightStatusBars() {
        return this.mImpl.isAppearanceLightStatusBars();
    }

    public void removeOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        this.mImpl.removeOnControllableInsetsChangedListener(onControllableInsetsChangedListener);
    }

    public void setAppearanceLightNavigationBars(boolean z10) {
        this.mImpl.setAppearanceLightNavigationBars(z10);
    }

    public void setAppearanceLightStatusBars(boolean z10) {
        this.mImpl.setAppearanceLightStatusBars(z10);
    }

    public void setSystemBarsBehavior(int i10) {
        this.mImpl.setSystemBarsBehavior(i10);
    }

    public void show(int i10) {
        this.mImpl.show(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(30)
    static class Impl30 extends Impl {
        final WindowInsetsControllerCompat mCompatController;
        final WindowInsetsController mInsetsController;
        private final SimpleArrayMap<OnControllableInsetsChangedListener, WindowInsetsController.OnControllableInsetsChangedListener> mListeners;
        final SoftwareKeyboardControllerCompat mSoftwareKeyboardControllerCompat;
        protected Window mWindow;

        Impl30(@NonNull Window window, @NonNull WindowInsetsControllerCompat windowInsetsControllerCompat, @NonNull SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            this(window.getInsetsController(), windowInsetsControllerCompat, softwareKeyboardControllerCompat);
            this.mWindow = window;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$addOnControllableInsetsChangedListener$0(OnControllableInsetsChangedListener onControllableInsetsChangedListener, WindowInsetsController windowInsetsController, int i10) {
            if (this.mInsetsController == windowInsetsController) {
                onControllableInsetsChangedListener.onControllableInsetsChanged(this.mCompatController, i10);
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void addOnControllableInsetsChangedListener(@NonNull final OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
            if (this.mListeners.containsKey(onControllableInsetsChangedListener)) {
                return;
            }
            WindowInsetsController.OnControllableInsetsChangedListener onControllableInsetsChangedListener2 = new WindowInsetsController.OnControllableInsetsChangedListener() { // from class: androidx.core.view.u4
                @Override // android.view.WindowInsetsController.OnControllableInsetsChangedListener
                public final void onControllableInsetsChanged(WindowInsetsController windowInsetsController, int i10) {
                    this.f913a.lambda$addOnControllableInsetsChangedListener$0(onControllableInsetsChangedListener, windowInsetsController, i10);
                }
            };
            this.mListeners.put(onControllableInsetsChangedListener, onControllableInsetsChangedListener2);
            this.mInsetsController.addOnControllableInsetsChangedListener(onControllableInsetsChangedListener2);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void controlWindowInsetsAnimation(int i10, long j10, @Nullable Interpolator interpolator, @Nullable CancellationSignal cancellationSignal, @NonNull final WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
            this.mInsetsController.controlWindowInsetsAnimation(i10, j10, interpolator, cancellationSignal, new WindowInsetsAnimationControlListener() { // from class: androidx.core.view.WindowInsetsControllerCompat.Impl30.1
                private WindowInsetsAnimationControllerCompat mCompatAnimController = null;

                @Override // android.view.WindowInsetsAnimationControlListener
                public void onCancelled(@Nullable WindowInsetsAnimationController windowInsetsAnimationController) {
                    windowInsetsAnimationControlListenerCompat.onCancelled(windowInsetsAnimationController == null ? null : this.mCompatAnimController);
                }

                @Override // android.view.WindowInsetsAnimationControlListener
                public void onFinished(@NonNull WindowInsetsAnimationController windowInsetsAnimationController) {
                    windowInsetsAnimationControlListenerCompat.onFinished(this.mCompatAnimController);
                }

                @Override // android.view.WindowInsetsAnimationControlListener
                public void onReady(@NonNull WindowInsetsAnimationController windowInsetsAnimationController, int i11) {
                    WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat = new WindowInsetsAnimationControllerCompat(windowInsetsAnimationController);
                    this.mCompatAnimController = windowInsetsAnimationControllerCompat;
                    windowInsetsAnimationControlListenerCompat.onReady(windowInsetsAnimationControllerCompat, i11);
                }
            });
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        @SuppressLint({"WrongConstant"})
        int getSystemBarsBehavior() {
            return this.mInsetsController.getSystemBarsBehavior();
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void hide(int i10) {
            if ((i10 & 8) != 0) {
                this.mSoftwareKeyboardControllerCompat.hide();
            }
            this.mInsetsController.hide(i10 & (-9));
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightNavigationBars() {
            this.mInsetsController.setSystemBarsAppearance(0, 0);
            return (this.mInsetsController.getSystemBarsAppearance() & 16) != 0;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightStatusBars() {
            this.mInsetsController.setSystemBarsAppearance(0, 0);
            return (this.mInsetsController.getSystemBarsAppearance() & 8) != 0;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void removeOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
            WindowInsetsController.OnControllableInsetsChangedListener onControllableInsetsChangedListenerRemove = this.mListeners.remove(onControllableInsetsChangedListener);
            if (onControllableInsetsChangedListenerRemove != null) {
                this.mInsetsController.removeOnControllableInsetsChangedListener(onControllableInsetsChangedListenerRemove);
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightNavigationBars(boolean z10) {
            if (z10) {
                if (this.mWindow != null) {
                    setSystemUiFlag(16);
                }
                this.mInsetsController.setSystemBarsAppearance(16, 16);
            } else {
                if (this.mWindow != null) {
                    unsetSystemUiFlag(16);
                }
                this.mInsetsController.setSystemBarsAppearance(0, 16);
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightStatusBars(boolean z10) {
            if (z10) {
                if (this.mWindow != null) {
                    setSystemUiFlag(8192);
                }
                this.mInsetsController.setSystemBarsAppearance(8, 8);
            } else {
                if (this.mWindow != null) {
                    unsetSystemUiFlag(8192);
                }
                this.mInsetsController.setSystemBarsAppearance(0, 8);
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void setSystemBarsBehavior(int i10) {
            this.mInsetsController.setSystemBarsBehavior(i10);
        }

        protected void setSystemUiFlag(int i10) {
            View decorView = this.mWindow.getDecorView();
            decorView.setSystemUiVisibility(i10 | decorView.getSystemUiVisibility());
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void show(int i10) {
            if ((i10 & 8) != 0) {
                this.mSoftwareKeyboardControllerCompat.show();
            }
            this.mInsetsController.show(i10 & (-9));
        }

        protected void unsetSystemUiFlag(int i10) {
            View decorView = this.mWindow.getDecorView();
            decorView.setSystemUiVisibility((~i10) & decorView.getSystemUiVisibility());
        }

        Impl30(@NonNull WindowInsetsController windowInsetsController, @NonNull WindowInsetsControllerCompat windowInsetsControllerCompat, @NonNull SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            this.mListeners = new SimpleArrayMap<>();
            this.mInsetsController = windowInsetsController;
            this.mCompatController = windowInsetsControllerCompat;
            this.mSoftwareKeyboardControllerCompat = softwareKeyboardControllerCompat;
        }
    }

    public WindowInsetsControllerCompat(@NonNull Window window, @NonNull View view) {
        SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat = new SoftwareKeyboardControllerCompat(view);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 30) {
            this.mImpl = new Impl30(window, this, softwareKeyboardControllerCompat);
        } else if (i10 >= 26) {
            this.mImpl = new Impl26(window, softwareKeyboardControllerCompat);
        } else {
            this.mImpl = new Impl23(window, softwareKeyboardControllerCompat);
        }
    }

    private static class Impl {
        Impl() {
        }

        int getSystemBarsBehavior() {
            return 0;
        }

        public boolean isAppearanceLightNavigationBars() {
            return false;
        }

        public boolean isAppearanceLightStatusBars() {
            return false;
        }

        void addOnControllableInsetsChangedListener(OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        }

        void hide(int i10) {
        }

        void removeOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        }

        public void setAppearanceLightNavigationBars(boolean z10) {
        }

        public void setAppearanceLightStatusBars(boolean z10) {
        }

        void setSystemBarsBehavior(int i10) {
        }

        void show(int i10) {
        }

        void controlWindowInsetsAnimation(int i10, long j10, Interpolator interpolator, CancellationSignal cancellationSignal, WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
        }
    }

    @RequiresApi(20)
    private static class Impl20 extends Impl {

        @NonNull
        private final SoftwareKeyboardControllerCompat mSoftwareKeyboardControllerCompat;

        @NonNull
        protected final Window mWindow;

        Impl20(@NonNull Window window, @NonNull SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            this.mWindow = window;
            this.mSoftwareKeyboardControllerCompat = softwareKeyboardControllerCompat;
        }

        private void hideForType(int i10) {
            if (i10 == 1) {
                setSystemUiFlag(4);
            } else if (i10 == 2) {
                setSystemUiFlag(2);
            } else {
                if (i10 != 8) {
                    return;
                }
                this.mSoftwareKeyboardControllerCompat.hide();
            }
        }

        private void showForType(int i10) {
            if (i10 == 1) {
                unsetSystemUiFlag(4);
                unsetWindowFlag(1024);
            } else if (i10 == 2) {
                unsetSystemUiFlag(2);
            } else {
                if (i10 != 8) {
                    return;
                }
                this.mSoftwareKeyboardControllerCompat.show();
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        int getSystemBarsBehavior() {
            return 0;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void hide(int i10) {
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if ((i10 & i11) != 0) {
                    hideForType(i11);
                }
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void setSystemBarsBehavior(int i10) {
            if (i10 == 0) {
                unsetSystemUiFlag(6144);
                return;
            }
            if (i10 == 1) {
                unsetSystemUiFlag(4096);
                setSystemUiFlag(2048);
            } else {
                if (i10 != 2) {
                    return;
                }
                unsetSystemUiFlag(2048);
                setSystemUiFlag(4096);
            }
        }

        protected void setSystemUiFlag(int i10) {
            View decorView = this.mWindow.getDecorView();
            decorView.setSystemUiVisibility(i10 | decorView.getSystemUiVisibility());
        }

        protected void setWindowFlag(int i10) {
            this.mWindow.addFlags(i10);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void show(int i10) {
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if ((i10 & i11) != 0) {
                    showForType(i11);
                }
            }
        }

        protected void unsetSystemUiFlag(int i10) {
            View decorView = this.mWindow.getDecorView();
            decorView.setSystemUiVisibility((~i10) & decorView.getSystemUiVisibility());
        }

        protected void unsetWindowFlag(int i10) {
            this.mWindow.clearFlags(i10);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void addOnControllableInsetsChangedListener(OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void removeOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void controlWindowInsetsAnimation(int i10, long j10, Interpolator interpolator, CancellationSignal cancellationSignal, WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
        }
    }
}
