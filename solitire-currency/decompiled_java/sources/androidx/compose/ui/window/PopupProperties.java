package androidx.compose.ui.window;

import androidx.compose.foundation.e;
import androidx.compose.runtime.Immutable;
import androidx.compose.ui.ExperimentalComposeUiApi;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidPopup.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class PopupProperties {
    private final boolean clippingEnabled;
    private final boolean dismissOnBackPress;
    private final boolean dismissOnClickOutside;
    private final boolean excludeFromSystemGesture;
    private final boolean focusable;

    @NotNull
    private final SecureFlagPolicy securePolicy;
    private final boolean usePlatformDefaultWidth;

    @ExperimentalComposeUiApi
    public PopupProperties() {
        this(false, false, false, null, false, false, false, 127, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PopupProperties)) {
            return false;
        }
        PopupProperties popupProperties = (PopupProperties) obj;
        return this.focusable == popupProperties.focusable && this.dismissOnBackPress == popupProperties.dismissOnBackPress && this.dismissOnClickOutside == popupProperties.dismissOnClickOutside && this.securePolicy == popupProperties.securePolicy && this.excludeFromSystemGesture == popupProperties.excludeFromSystemGesture && this.clippingEnabled == popupProperties.clippingEnabled && this.usePlatformDefaultWidth == popupProperties.usePlatformDefaultWidth;
    }

    public final boolean getClippingEnabled() {
        return this.clippingEnabled;
    }

    public final boolean getDismissOnBackPress() {
        return this.dismissOnBackPress;
    }

    public final boolean getDismissOnClickOutside() {
        return this.dismissOnClickOutside;
    }

    public final boolean getExcludeFromSystemGesture() {
        return this.excludeFromSystemGesture;
    }

    public final boolean getFocusable() {
        return this.focusable;
    }

    @NotNull
    public final SecureFlagPolicy getSecurePolicy() {
        return this.securePolicy;
    }

    public final boolean getUsePlatformDefaultWidth() {
        return this.usePlatformDefaultWidth;
    }

    public int hashCode() {
        return (((((((((((((e.a(this.dismissOnBackPress) * 31) + e.a(this.focusable)) * 31) + e.a(this.dismissOnBackPress)) * 31) + e.a(this.dismissOnClickOutside)) * 31) + this.securePolicy.hashCode()) * 31) + e.a(this.excludeFromSystemGesture)) * 31) + e.a(this.clippingEnabled)) * 31) + e.a(this.usePlatformDefaultWidth);
    }

    @ExperimentalComposeUiApi
    public PopupProperties(boolean z10, boolean z11, boolean z12, @NotNull SecureFlagPolicy securePolicy, boolean z13, boolean z14, boolean z15) {
        t.i(securePolicy, "securePolicy");
        this.focusable = z10;
        this.dismissOnBackPress = z11;
        this.dismissOnClickOutside = z12;
        this.securePolicy = securePolicy;
        this.excludeFromSystemGesture = z13;
        this.clippingEnabled = z14;
        this.usePlatformDefaultWidth = z15;
    }

    public /* synthetic */ PopupProperties(boolean z10, boolean z11, boolean z12, SecureFlagPolicy secureFlagPolicy, boolean z13, boolean z14, boolean z15, int i10, k kVar) {
        this((i10 & 1) != 0 ? false : z10, (i10 & 2) != 0 ? true : z11, (i10 & 4) != 0 ? true : z12, (i10 & 8) != 0 ? SecureFlagPolicy.Inherit : secureFlagPolicy, (i10 & 16) != 0 ? true : z13, (i10 & 32) == 0 ? z14 : true, (i10 & 64) != 0 ? false : z15);
    }

    public /* synthetic */ PopupProperties(boolean z10, boolean z11, boolean z12, SecureFlagPolicy secureFlagPolicy, boolean z13, boolean z14, int i10, k kVar) {
        this((i10 & 1) != 0 ? false : z10, (i10 & 2) != 0 ? true : z11, (i10 & 4) != 0 ? true : z12, (i10 & 8) != 0 ? SecureFlagPolicy.Inherit : secureFlagPolicy, (i10 & 16) != 0 ? true : z13, (i10 & 32) == 0 ? z14 : true);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PopupProperties(boolean z10, boolean z11, boolean z12, @NotNull SecureFlagPolicy securePolicy, boolean z13, boolean z14) {
        this(z10, z11, z12, securePolicy, z13, z14, false);
        t.i(securePolicy, "securePolicy");
    }
}
