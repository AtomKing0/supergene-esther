package com.braze.ui.inappmessage;

import com.braze.models.inappmessage.IInAppMessage;
import h9.l;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BrazeInAppMessageManager$createBrazeUserChangeEventSubscriber$1$4 extends v implements l<IInAppMessage, Boolean> {
    final /* synthetic */ String $currentUserId;
    final /* synthetic */ BrazeInAppMessageManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BrazeInAppMessageManager$createBrazeUserChangeEventSubscriber$1$4(BrazeInAppMessageManager brazeInAppMessageManager, String str) {
        super(1);
        this.this$0 = brazeInAppMessageManager;
        this.$currentUserId = str;
    }

    @Override // h9.l
    @NotNull
    public final Boolean invoke(IInAppMessage iInAppMessage) {
        return Boolean.valueOf(!this.this$0.isInAppMessageForTheSameUser(iInAppMessage, this.$currentUserId));
    }
}
