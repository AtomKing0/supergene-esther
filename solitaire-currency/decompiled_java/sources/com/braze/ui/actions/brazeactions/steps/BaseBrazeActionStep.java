package com.braze.ui.actions.brazeactions.steps;

import com.braze.Braze;
import com.braze.BrazeUser;
import com.braze.events.IValueCallback;
import com.braze.support.BrazeLogger;
import h9.a;
import h9.l;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: BaseBrazeActionStep.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseBrazeActionStep implements IBrazeActionStep {

    @NotNull
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: BaseBrazeActionStep.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        public final void runOnUser$android_sdk_ui_release(@NotNull Braze braze, @NotNull final l<? super BrazeUser, k0> block) {
            t.i(braze, "<this>");
            t.i(block, "block");
            braze.getCurrentUser(new IValueCallback<BrazeUser>() { // from class: com.braze.ui.actions.brazeactions.steps.BaseBrazeActionStep$Companion$runOnUser$1
                @Override // com.braze.events.IValueCallback
                public void onError() {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) BaseBrazeActionStep$Companion$runOnUser$1$onError$1.INSTANCE, 7, (Object) null);
                }

                @Override // com.braze.events.IValueCallback
                public void onSuccess(@NotNull BrazeUser value) {
                    t.i(value, "value");
                    block.invoke(value);
                }
            });
        }
    }

    private BaseBrazeActionStep() {
    }

    public /* synthetic */ BaseBrazeActionStep(k kVar) {
        this();
    }
}
