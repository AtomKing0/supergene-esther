package com.braze.ui.inappmessage;

import androidx.annotation.Keep;
import java.util.Locale;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: InAppMessageOperation.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum InAppMessageOperation {
    DISPLAY_NOW,
    DISPLAY_LATER,
    DISCARD,
    REENQUEUE;


    @NotNull
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: InAppMessageOperation.kt */
    @Keep
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @Nullable
        public final InAppMessageOperation fromValue(@Nullable String str) {
            InAppMessageOperation[] inAppMessageOperationArrValues = InAppMessageOperation.values();
            int length = inAppMessageOperationArrValues.length;
            int i10 = 0;
            while (true) {
                String upperCase = null;
                if (i10 >= length) {
                    return null;
                }
                InAppMessageOperation inAppMessageOperation = inAppMessageOperationArrValues[i10];
                String strName = inAppMessageOperation.name();
                if (str != null) {
                    Locale US = Locale.US;
                    t.h(US, "US");
                    upperCase = str.toUpperCase(US);
                    t.h(upperCase, "this as java.lang.String).toUpperCase(locale)");
                }
                if (t.d(strName, upperCase)) {
                    return inAppMessageOperation;
                }
                i10++;
            }
        }
    }
}
