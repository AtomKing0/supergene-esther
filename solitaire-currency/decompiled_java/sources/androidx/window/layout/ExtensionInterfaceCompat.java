package androidx.window.layout;

import android.app.Activity;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ExtensionInterfaceCompat.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface ExtensionInterfaceCompat {

    /* JADX INFO: compiled from: ExtensionInterfaceCompat.kt */
    public interface ExtensionCallbackInterface {
        void onWindowLayoutChanged(@NotNull Activity activity, @NotNull WindowLayoutInfo windowLayoutInfo);
    }

    void onWindowLayoutChangeListenerAdded(@NotNull Activity activity);

    void onWindowLayoutChangeListenerRemoved(@NotNull Activity activity);

    void setExtensionCallback(@NotNull ExtensionCallbackInterface extensionCallbackInterface);

    boolean validateExtensionInterface();
}
