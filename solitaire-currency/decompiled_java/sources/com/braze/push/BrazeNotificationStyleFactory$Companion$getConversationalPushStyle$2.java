package com.braze.push;

import com.braze.models.push.BrazeNotificationPayload;
import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazeNotificationStyleFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BrazeNotificationStyleFactory$Companion$getConversationalPushStyle$2 extends v implements a<String> {
    final /* synthetic */ BrazeNotificationPayload.ConversationMessage $message;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BrazeNotificationStyleFactory$Companion$getConversationalPushStyle$2(BrazeNotificationPayload.ConversationMessage conversationMessage) {
        super(0);
        this.$message = conversationMessage;
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Message person does not exist in mapping. Not rendering a style. " + this.$message;
    }
}
