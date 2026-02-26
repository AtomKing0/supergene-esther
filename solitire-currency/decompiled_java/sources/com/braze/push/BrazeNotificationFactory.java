package com.braze.push;

import android.app.Notification;
import android.content.Context;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.braze.IBrazeNotificationFactory;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.models.push.BrazeNotificationPayload;
import com.braze.support.BrazeLogger;
import h9.a;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BrazeNotificationFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
public class BrazeNotificationFactory implements IBrazeNotificationFactory {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final BrazeNotificationFactory internalInstance = new BrazeNotificationFactory();

    /* JADX INFO: compiled from: BrazeNotificationFactory.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final BrazeNotificationFactory getInstance() {
            return BrazeNotificationFactory.internalInstance;
        }

        @Nullable
        public final NotificationCompat.Builder populateNotificationBuilder(@NotNull BrazeNotificationPayload payload) {
            t.i(payload, "payload");
            BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (a) new BrazeNotificationFactory$Companion$populateNotificationBuilder$1(payload), 6, (Object) null);
            Context context = payload.getContext();
            if (context == null) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) BrazeNotificationFactory$Companion$populateNotificationBuilder$2.INSTANCE, 7, (Object) null);
                return null;
            }
            BrazeConfigurationProvider configurationProvider = payload.getConfigurationProvider();
            if (configurationProvider == null) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) BrazeNotificationFactory$Companion$populateNotificationBuilder$3.INSTANCE, 7, (Object) null);
                return null;
            }
            Bundle notificationExtras = payload.getNotificationExtras();
            BrazeNotificationUtils.prefetchBitmapsIfNewlyReceivedStoryPush(payload);
            NotificationCompat.Builder autoCancel = new NotificationCompat.Builder(context, BrazeNotificationUtils.getOrCreateNotificationChannelId(payload)).setAutoCancel(true);
            t.h(autoCancel, "Builder(context, notific…     .setAutoCancel(true)");
            BrazeNotificationUtils.setTitleIfPresent(autoCancel, payload);
            BrazeNotificationUtils.setContentIfPresent(autoCancel, payload);
            BrazeNotificationUtils.setTickerIfPresent(autoCancel, payload);
            BrazeNotificationUtils.setSetShowWhen(autoCancel, payload);
            BrazeNotificationUtils.setContentIntentIfPresent(context, autoCancel, notificationExtras);
            BrazeNotificationUtils.setDeleteIntent(context, autoCancel, notificationExtras);
            BrazeNotificationUtils.setSmallIcon(configurationProvider, autoCancel);
            BrazeNotificationUtils.setLargeIconIfPresentAndSupported(autoCancel, payload);
            BrazeNotificationUtils.setSoundIfPresentAndSupported(autoCancel, payload);
            BrazeNotificationUtils.setSummaryTextIfPresentAndSupported(autoCancel, payload);
            BrazeNotificationUtils.setPriorityIfPresentAndSupported(autoCancel, payload);
            BrazeNotificationStyleFactory.Companion.setStyleIfSupported(autoCancel, payload);
            BrazeNotificationActionUtils.addNotificationActions(autoCancel, payload);
            BrazeNotificationUtils.setAccentColorIfPresentAndSupported(autoCancel, payload);
            BrazeNotificationUtils.setCategoryIfPresentAndSupported(autoCancel, payload);
            BrazeNotificationUtils.setVisibilityIfPresentAndSupported(autoCancel, payload);
            BrazeNotificationUtils.setPublicVersionIfPresentAndSupported(autoCancel, payload);
            BrazeNotificationUtils.setNotificationBadgeNumberIfPresent(autoCancel, payload);
            return autoCancel;
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationFactory$createNotification$1, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeNotificationFactory.kt */
    static final class AnonymousClass1 extends v implements a<String> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Notification could not be built. Returning null as created notification";
        }
    }

    @NotNull
    public static final BrazeNotificationFactory getInstance() {
        return Companion.getInstance();
    }

    @Override // com.braze.IBrazeNotificationFactory
    @Nullable
    public Notification createNotification(@NotNull BrazeNotificationPayload payload) {
        t.i(payload, "payload");
        NotificationCompat.Builder builderPopulateNotificationBuilder = Companion.populateNotificationBuilder(payload);
        if (builderPopulateNotificationBuilder != null) {
            return builderPopulateNotificationBuilder.build();
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (a) AnonymousClass1.INSTANCE, 6, (Object) null);
        return null;
    }
}
