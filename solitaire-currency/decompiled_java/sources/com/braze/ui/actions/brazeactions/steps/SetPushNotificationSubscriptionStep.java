package com.braze.ui.actions.brazeactions.steps;

import android.content.Context;
import com.braze.Braze;
import com.braze.BrazeUser;
import com.braze.enums.NotificationSubscriptionType;
import com.braze.support.BrazeLogger;
import h9.a;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: SetPushNotificationSubscriptionStep.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SetPushNotificationSubscriptionStep extends BaseBrazeActionStep {

    @NotNull
    public static final SetPushNotificationSubscriptionStep INSTANCE;

    @NotNull
    private static final String TAG;

    /* JADX INFO: renamed from: com.braze.ui.actions.brazeactions.steps.SetPushNotificationSubscriptionStep$run$1, reason: invalid class name */
    /* JADX INFO: compiled from: SetPushNotificationSubscriptionStep.kt */
    static final class AnonymousClass1 extends v implements a<String> {
        final /* synthetic */ StepData $data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(StepData stepData) {
            super(0);
            this.$data = stepData;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Could not parse subscription type from data " + this.$data;
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.actions.brazeactions.steps.SetPushNotificationSubscriptionStep$run$2, reason: invalid class name */
    /* JADX INFO: compiled from: SetPushNotificationSubscriptionStep.kt */
    static final class AnonymousClass2 extends v implements l<BrazeUser, k0> {
        final /* synthetic */ NotificationSubscriptionType $subscriptionType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(NotificationSubscriptionType notificationSubscriptionType) {
            super(1);
            this.$subscriptionType = notificationSubscriptionType;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(BrazeUser brazeUser) {
            invoke2(brazeUser);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull BrazeUser it) {
            t.i(it, "it");
            it.setPushNotificationSubscriptionType(this.$subscriptionType);
        }
    }

    static {
        SetPushNotificationSubscriptionStep setPushNotificationSubscriptionStep = new SetPushNotificationSubscriptionStep();
        INSTANCE = setPushNotificationSubscriptionStep;
        TAG = BrazeLogger.INSTANCE.brazeLogTag(setPushNotificationSubscriptionStep);
    }

    private SetPushNotificationSubscriptionStep() {
        super(null);
    }

    @Override // com.braze.ui.actions.brazeactions.steps.IBrazeActionStep
    public boolean isValid(@NotNull StepData data) {
        t.i(data, "data");
        return StepData.isArgCountInBounds$default(data, 1, null, 2, null) && data.isArgString(0);
    }

    @Override // com.braze.ui.actions.brazeactions.steps.IBrazeActionStep
    public void run(@NotNull Context context, @NotNull StepData data) {
        t.i(context, "context");
        t.i(data, "data");
        NotificationSubscriptionType notificationSubscriptionTypeFromValue = NotificationSubscriptionType.Companion.fromValue(String.valueOf(data.getFirstArg()));
        if (notificationSubscriptionTypeFromValue == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new AnonymousClass1(data), 7, (Object) null);
        } else {
            BaseBrazeActionStep.Companion.runOnUser$android_sdk_ui_release(Braze.Companion.getInstance(context), new AnonymousClass2(notificationSubscriptionTypeFromValue));
        }
    }
}
