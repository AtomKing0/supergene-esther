package androidx.compose.ui.window;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.q;

/* JADX INFO: compiled from: SecureFlagPolicy.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SecureFlagPolicy_androidKt {

    /* JADX INFO: compiled from: SecureFlagPolicy.android.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SecureFlagPolicy.values().length];
            iArr[SecureFlagPolicy.SecureOff.ordinal()] = 1;
            iArr[SecureFlagPolicy.SecureOn.ordinal()] = 2;
            iArr[SecureFlagPolicy.Inherit.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final boolean shouldApplySecureFlag(@NotNull SecureFlagPolicy secureFlagPolicy, boolean z10) {
        t.i(secureFlagPolicy, "<this>");
        int i10 = WhenMappings.$EnumSwitchMapping$0[secureFlagPolicy.ordinal()];
        if (i10 == 1) {
            return false;
        }
        if (i10 == 2) {
            return true;
        }
        if (i10 == 3) {
            return z10;
        }
        throw new q();
    }
}
