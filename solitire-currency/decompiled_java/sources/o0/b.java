package o0;

import android.view.View;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.MessageButton;
import com.braze.support.BrazeFunctionNotImplemented;
import com.braze.ui.inappmessage.InAppMessageCloser;
import com.braze.ui.inappmessage.listeners.IInAppMessageManagerListener;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IInAppMessageManagerListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b {
    public static void a(IInAppMessageManagerListener iInAppMessageManagerListener, @NotNull IInAppMessage inAppMessage) {
        t.i(inAppMessage, "inAppMessage");
    }

    public static void b(IInAppMessageManagerListener iInAppMessageManagerListener, @NotNull View inAppMessageView, @NotNull IInAppMessage inAppMessage) {
        t.i(inAppMessageView, "inAppMessageView");
        t.i(inAppMessage, "inAppMessage");
    }

    public static void c(IInAppMessageManagerListener iInAppMessageManagerListener, @NotNull View inAppMessageView, @NotNull IInAppMessage inAppMessage) {
        t.i(inAppMessageView, "inAppMessageView");
        t.i(inAppMessage, "inAppMessage");
    }

    public static void d(IInAppMessageManagerListener iInAppMessageManagerListener, @NotNull View inAppMessageView, @NotNull IInAppMessage inAppMessage) {
        t.i(inAppMessageView, "inAppMessageView");
        t.i(inAppMessage, "inAppMessage");
    }

    public static boolean e(IInAppMessageManagerListener iInAppMessageManagerListener, @NotNull IInAppMessage inAppMessage, @NotNull MessageButton button) {
        t.i(inAppMessage, "inAppMessage");
        t.i(button, "button");
        return false;
    }

    public static boolean f(IInAppMessageManagerListener iInAppMessageManagerListener, @NotNull IInAppMessage inAppMessage, @NotNull MessageButton button, @Nullable InAppMessageCloser inAppMessageCloser) throws BrazeFunctionNotImplemented {
        t.i(inAppMessage, "inAppMessage");
        t.i(button, "button");
        throw BrazeFunctionNotImplemented.INSTANCE;
    }

    public static boolean g(IInAppMessageManagerListener iInAppMessageManagerListener, @NotNull IInAppMessage inAppMessage) {
        t.i(inAppMessage, "inAppMessage");
        return false;
    }

    public static boolean h(IInAppMessageManagerListener iInAppMessageManagerListener, @NotNull IInAppMessage inAppMessage, @Nullable InAppMessageCloser inAppMessageCloser) throws BrazeFunctionNotImplemented {
        t.i(inAppMessage, "inAppMessage");
        throw BrazeFunctionNotImplemented.INSTANCE;
    }

    public static void i(IInAppMessageManagerListener iInAppMessageManagerListener, @NotNull IInAppMessage inAppMessage) {
        t.i(inAppMessage, "inAppMessage");
    }
}
