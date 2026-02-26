package com.braze.push;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.ts.PsExtractor;
import com.braze.Braze;
import com.braze.BrazeInternal;
import com.braze.IBrazeDeeplinkHandler;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.enums.BrazeDateFormat;
import com.braze.enums.BrazeViewBounds;
import com.braze.models.push.BrazeNotificationPayload;
import com.braze.push.support.HtmlUtils;
import com.braze.support.BrazeImageUtils;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.IntentUtils;
import com.braze.ui.BrazeDeeplinkHandler;
import com.braze.ui.R$id;
import com.braze.ui.R$layout;
import h9.a;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.q;

/* JADX INFO: compiled from: BrazeNotificationStyleFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
public class BrazeNotificationStyleFactory {

    @NotNull
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: BrazeNotificationStyleFactory.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        private final PendingIntent createStoryPageClickedPendingIntent(Context context, BrazeNotificationPayload brazeNotificationPayload, BrazeNotificationPayload.PushStoryPage pushStoryPage) {
            Intent intent = new Intent("com.braze.action.BRAZE_STORY_CLICKED").setClass(context, NotificationTrampolineActivity.class);
            t.h(intent, "Intent(Constants.BRAZE_S…lineActivity::class.java)");
            intent.setFlags(intent.getFlags() | BrazeDeeplinkHandler.Companion.getInstance().getIntentFlags(IBrazeDeeplinkHandler.IntentFlagPurpose.NOTIFICATION_PUSH_STORY_PAGE_CLICK));
            intent.putExtras(brazeNotificationPayload.getNotificationExtras());
            intent.putExtra("braze_action_uri", pushStoryPage.getDeeplink());
            intent.putExtra("braze_action_use_webview", pushStoryPage.getUseWebview());
            intent.putExtra("braze_story_page_id", pushStoryPage.getStoryPageId());
            intent.putExtra("braze_campaign_id", pushStoryPage.getCampaignId());
            intent.putExtra("nid", BrazeNotificationUtils.getNotificationId(brazeNotificationPayload));
            PendingIntent activity = PendingIntent.getActivity(context, IntentUtils.getRequestCode(), intent, IntentUtils.getImmutablePendingIntentFlags());
            t.h(activity, "getActivity(\n           …tentFlags()\n            )");
            return activity;
        }

        private final PendingIntent createStoryTraversedPendingIntent(Context context, Bundle bundle, int i10) {
            Intent intent = new Intent("com.braze.action.STORY_TRAVERSE").setClass(context, BrazeNotificationUtils.getNotificationReceiverClass());
            t.h(intent, "Intent(Constants.BRAZE_S…otificationReceiverClass)");
            if (bundle != null) {
                bundle.putInt("braze_story_index", i10);
                intent.putExtras(bundle);
            }
            PendingIntent broadcast = PendingIntent.getBroadcast(context, IntentUtils.getRequestCode(), intent, 1073741824 | IntentUtils.getImmutablePendingIntentFlags());
            t.h(broadcast, "getBroadcast(\n          …      flags\n            )");
            return broadcast;
        }

        private final boolean isRemoteViewNotificationAvailableSpaceConstrained(Context context) {
            return Build.VERSION.SDK_INT >= 31 && context.getApplicationContext().getApplicationInfo().targetSdkVersion >= 31;
        }

        private final boolean populatePushStoryPage(RemoteViews remoteViews, BrazeNotificationPayload brazeNotificationPayload, BrazeNotificationPayload.PushStoryPage pushStoryPage) {
            Context context = brazeNotificationPayload.getContext();
            if (context == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) BrazeNotificationStyleFactory$Companion$populatePushStoryPage$1.INSTANCE, 7, (Object) null);
                return false;
            }
            BrazeConfigurationProvider configurationProvider = brazeNotificationPayload.getConfigurationProvider();
            if (configurationProvider == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) BrazeNotificationStyleFactory$Companion$populatePushStoryPage$2.INSTANCE, 7, (Object) null);
                return false;
            }
            String bitmapUrl = pushStoryPage.getBitmapUrl();
            if (bitmapUrl == null || q.z(bitmapUrl)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) BrazeNotificationStyleFactory$Companion$populatePushStoryPage$3.INSTANCE, 7, (Object) null);
                return false;
            }
            Bitmap pushBitmapFromUrl = Braze.Companion.getInstance(context).getImageLoader().getPushBitmapFromUrl(context, brazeNotificationPayload.getNotificationExtras(), bitmapUrl, BrazeViewBounds.NOTIFICATION_ONE_IMAGE_STORY);
            if (pushBitmapFromUrl == null) {
                return false;
            }
            remoteViews.setImageViewBitmap(R$id.com_braze_story_image_view, pushBitmapFromUrl);
            String title = pushStoryPage.getTitle();
            if (title == null || q.z(title)) {
                remoteViews.setInt(R$id.com_braze_story_text_view_container, "setVisibility", 8);
            } else {
                remoteViews.setTextViewText(R$id.com_braze_story_text_view, HtmlUtils.getHtmlSpannedTextIfEnabled(title, configurationProvider));
                remoteViews.setInt(R$id.com_braze_story_text_view_container, "setGravity", pushStoryPage.getTitleGravity());
            }
            String subtitle = pushStoryPage.getSubtitle();
            if (subtitle == null || q.z(subtitle)) {
                remoteViews.setInt(R$id.com_braze_story_text_view_small_container, "setVisibility", 8);
            } else {
                remoteViews.setTextViewText(R$id.com_braze_story_text_view_small, HtmlUtils.getHtmlSpannedTextIfEnabled(subtitle, configurationProvider));
                remoteViews.setInt(R$id.com_braze_story_text_view_small_container, "setGravity", pushStoryPage.getSubtitleGravity());
            }
            remoteViews.setOnClickPendingIntent(R$id.com_braze_story_relative_layout, createStoryPageClickedPendingIntent(context, brazeNotificationPayload, pushStoryPage));
            return true;
        }

        @Nullable
        public final NotificationCompat.BigPictureStyle getBigPictureNotificationStyle(@NotNull BrazeNotificationPayload payload) {
            t.i(payload, "payload");
            Context context = payload.getContext();
            if (context == null) {
                return null;
            }
            String bigImageUrl = payload.getBigImageUrl();
            if (bigImageUrl == null || q.z(bigImageUrl)) {
                return null;
            }
            Bitmap pushBitmapFromUrl = Braze.Companion.getInstance(context).getImageLoader().getPushBitmapFromUrl(context, payload.getNotificationExtras(), bigImageUrl, BrazeViewBounds.NOTIFICATION_EXPANDED_IMAGE);
            if (pushBitmapFromUrl == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new BrazeNotificationStyleFactory$Companion$getBigPictureNotificationStyle$1(bigImageUrl), 7, (Object) null);
                return null;
            }
            try {
                if (pushBitmapFromUrl.getWidth() > pushBitmapFromUrl.getHeight()) {
                    int pixelsFromDensityAndDp = BrazeImageUtils.getPixelsFromDensityAndDp(BrazeImageUtils.getDensityDpi(context), PsExtractor.AUDIO_STREAM);
                    int i10 = pixelsFromDensityAndDp * 2;
                    int displayWidthPixels = BrazeImageUtils.getDisplayWidthPixels(context);
                    if (i10 > displayWidthPixels) {
                        i10 = displayWidthPixels;
                    }
                    try {
                        pushBitmapFromUrl = Bitmap.createScaledBitmap(pushBitmapFromUrl, i10, pixelsFromDensityAndDp, true);
                    } catch (Exception e10) {
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (a) BrazeNotificationStyleFactory$Companion$getBigPictureNotificationStyle$2.INSTANCE, 4, (Object) null);
                    }
                }
                if (pushBitmapFromUrl == null) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (a) BrazeNotificationStyleFactory$Companion$getBigPictureNotificationStyle$3.INSTANCE, 6, (Object) null);
                    return null;
                }
                NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
                bigPictureStyle.bigPicture(pushBitmapFromUrl);
                setBigPictureSummaryAndTitle(bigPictureStyle, payload);
                return bigPictureStyle;
            } catch (Exception e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (a) BrazeNotificationStyleFactory$Companion$getBigPictureNotificationStyle$4.INSTANCE, 4, (Object) null);
                return null;
            }
        }

        @NotNull
        public final NotificationCompat.BigTextStyle getBigTextNotificationStyle(@NotNull BrazeNotificationPayload payload) {
            CharSequence htmlSpannedTextIfEnabled;
            t.i(payload, "payload");
            NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
            BrazeConfigurationProvider configurationProvider = payload.getConfigurationProvider();
            if (configurationProvider == null) {
                return bigTextStyle;
            }
            String contentText = payload.getContentText();
            if (contentText != null && (htmlSpannedTextIfEnabled = HtmlUtils.getHtmlSpannedTextIfEnabled(contentText, configurationProvider)) != null) {
                bigTextStyle.bigText(htmlSpannedTextIfEnabled);
            }
            String bigSummaryText = payload.getBigSummaryText();
            if (bigSummaryText != null) {
                bigTextStyle.setSummaryText(HtmlUtils.getHtmlSpannedTextIfEnabled(bigSummaryText, configurationProvider));
            }
            String bigTitleText = payload.getBigTitleText();
            if (bigTitleText != null) {
                bigTextStyle.setBigContentTitle(HtmlUtils.getHtmlSpannedTextIfEnabled(bigTitleText, configurationProvider));
            }
            return bigTextStyle;
        }

        @Nullable
        public final NotificationCompat.MessagingStyle getConversationalPushStyle(@NotNull NotificationCompat.Builder notificationBuilder, @NotNull BrazeNotificationPayload payload) {
            t.i(notificationBuilder, "notificationBuilder");
            t.i(payload, "payload");
            try {
                Map<String, BrazeNotificationPayload.ConversationPerson> conversationPersonMap = payload.getConversationPersonMap();
                BrazeNotificationPayload.ConversationPerson conversationPerson = conversationPersonMap.get(payload.getConversationReplyPersonId());
                if (conversationPerson == null) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) BrazeNotificationStyleFactory$Companion$getConversationalPushStyle$1.INSTANCE, 7, (Object) null);
                    return null;
                }
                NotificationCompat.MessagingStyle messagingStyle = new NotificationCompat.MessagingStyle(conversationPerson.getPerson());
                for (BrazeNotificationPayload.ConversationMessage conversationMessage : payload.getConversationMessages()) {
                    BrazeNotificationPayload.ConversationPerson conversationPerson2 = conversationPersonMap.get(conversationMessage.getPersonId());
                    if (conversationPerson2 == null) {
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new BrazeNotificationStyleFactory$Companion$getConversationalPushStyle$2(conversationMessage), 7, (Object) null);
                        return null;
                    }
                    messagingStyle.addMessage(conversationMessage.getMessage(), conversationMessage.getTimestamp(), conversationPerson2.getPerson());
                }
                boolean z10 = true;
                if (conversationPersonMap.size() <= 1) {
                    z10 = false;
                }
                messagingStyle.setGroupConversation(z10);
                notificationBuilder.setShortcutId(payload.getConversationShortcutId());
                return messagingStyle;
            } catch (Exception e10) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (a) BrazeNotificationStyleFactory$Companion$getConversationalPushStyle$3.INSTANCE, 4, (Object) null);
                return null;
            }
        }

        @RequiresApi(api = 23)
        @Nullable
        public final NotificationCompat.Style getInlineImageStyle(@NotNull BrazeNotificationPayload payload, @NotNull NotificationCompat.Builder notificationBuilder) {
            t.i(payload, "payload");
            t.i(notificationBuilder, "notificationBuilder");
            Context context = payload.getContext();
            if (context == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) BrazeNotificationStyleFactory$Companion$getInlineImageStyle$1.INSTANCE, 7, (Object) null);
                return null;
            }
            String bigImageUrl = payload.getBigImageUrl();
            if (bigImageUrl == null || q.z(bigImageUrl)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) BrazeNotificationStyleFactory$Companion$getInlineImageStyle$2.INSTANCE, 7, (Object) null);
                return null;
            }
            Bundle notificationExtras = payload.getNotificationExtras();
            Bitmap pushBitmapFromUrl = Braze.Companion.getInstance(context).getImageLoader().getPushBitmapFromUrl(context, notificationExtras, bigImageUrl, BrazeViewBounds.NOTIFICATION_INLINE_PUSH_IMAGE);
            if (pushBitmapFromUrl == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) BrazeNotificationStyleFactory$Companion$getInlineImageStyle$3.INSTANCE, 7, (Object) null);
                return null;
            }
            boolean zIsRemoteViewNotificationAvailableSpaceConstrained = isRemoteViewNotificationAvailableSpaceConstrained(context);
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), zIsRemoteViewNotificationAvailableSpaceConstrained ? R$layout.com_braze_push_inline_image_constrained : R$layout.com_braze_notification_inline_image);
            BrazeConfigurationProvider configurationProvider = BrazeInternal.INSTANCE.getConfigurationProvider(context);
            Icon iconCreateWithResource = Icon.createWithResource(context, configurationProvider.getSmallNotificationIconResourceId());
            t.h(iconCreateWithResource, "createWithResource(\n    …nResourceId\n            )");
            Integer accentColor = payload.getAccentColor();
            if (accentColor != null) {
                iconCreateWithResource.setTint(accentColor.intValue());
            }
            remoteViews.setImageViewIcon(R$id.com_braze_inline_image_push_app_icon, iconCreateWithResource);
            PackageManager packageManager = context.getPackageManager();
            try {
                ApplicationInfo applicationInfo = Build.VERSION.SDK_INT >= 33 ? packageManager.getApplicationInfo(context.getPackageName(), PackageManager.ApplicationInfoFlags.of(0L)) : packageManager.getApplicationInfo(context.getPackageName(), 0);
                t.h(applicationInfo, "{\n                if (Bu…          }\n            }");
                CharSequence applicationLabel = packageManager.getApplicationLabel(applicationInfo);
                t.g(applicationLabel, "null cannot be cast to non-null type kotlin.String");
                remoteViews.setTextViewText(R$id.com_braze_inline_image_push_app_name_text, HtmlUtils.getHtmlSpannedTextIfEnabled((String) applicationLabel, configurationProvider));
                remoteViews.setTextViewText(R$id.com_braze_inline_image_push_time_text, DateTimeUtils.formatDateNow(BrazeDateFormat.CLOCK_12_HOUR));
                String string = notificationExtras.getString("t");
                if (string != null) {
                    remoteViews.setTextViewText(R$id.com_braze_inline_image_push_title_text, HtmlUtils.getHtmlSpannedTextIfEnabled(string, configurationProvider));
                }
                String string2 = notificationExtras.getString(CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY);
                if (string2 != null) {
                    remoteViews.setTextViewText(R$id.com_braze_inline_image_push_content_text, HtmlUtils.getHtmlSpannedTextIfEnabled(string2, configurationProvider));
                }
                notificationBuilder.setCustomContentView(remoteViews);
                if (zIsRemoteViewNotificationAvailableSpaceConstrained) {
                    notificationBuilder.setLargeIcon(pushBitmapFromUrl);
                    return new NotificationCompat.DecoratedCustomViewStyle();
                }
                remoteViews.setImageViewBitmap(R$id.com_braze_inline_image_push_side_image, pushBitmapFromUrl);
                return new NoOpSentinelStyle();
            } catch (PackageManager.NameNotFoundException e10) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (a) BrazeNotificationStyleFactory$Companion$getInlineImageStyle$applicationInfo$1.INSTANCE, 4, (Object) null);
                return null;
            }
        }

        @NotNull
        public final NotificationCompat.Style getNotificationStyle(@NotNull NotificationCompat.Builder notificationBuilder, @NotNull BrazeNotificationPayload payload) {
            NotificationCompat.Style bigPictureNotificationStyle;
            t.i(notificationBuilder, "notificationBuilder");
            t.i(payload, "payload");
            if (payload.isPushStory() && payload.getContext() != null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) BrazeNotificationStyleFactory$Companion$getNotificationStyle$1.INSTANCE, 7, (Object) null);
                bigPictureNotificationStyle = getStoryStyle(notificationBuilder, payload);
            } else if (payload.isConversationalPush() && Build.VERSION.SDK_INT >= 25) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) BrazeNotificationStyleFactory$Companion$getNotificationStyle$2.INSTANCE, 7, (Object) null);
                bigPictureNotificationStyle = getConversationalPushStyle(notificationBuilder, payload);
            } else if (payload.getBigImageUrl() == null) {
                bigPictureNotificationStyle = null;
            } else if (payload.isInlineImagePush()) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) BrazeNotificationStyleFactory$Companion$getNotificationStyle$3.INSTANCE, 7, (Object) null);
                bigPictureNotificationStyle = getInlineImageStyle(payload, notificationBuilder);
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) BrazeNotificationStyleFactory$Companion$getNotificationStyle$4.INSTANCE, 7, (Object) null);
                bigPictureNotificationStyle = getBigPictureNotificationStyle(payload);
            }
            if (bigPictureNotificationStyle != null) {
                return bigPictureNotificationStyle;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) BrazeNotificationStyleFactory$Companion$getNotificationStyle$5.INSTANCE, 7, (Object) null);
            return getBigTextNotificationStyle(payload);
        }

        @Nullable
        public final NotificationCompat.DecoratedCustomViewStyle getStoryStyle(@NotNull NotificationCompat.Builder notificationBuilder, @NotNull BrazeNotificationPayload payload) {
            t.i(notificationBuilder, "notificationBuilder");
            t.i(payload, "payload");
            Context context = payload.getContext();
            if (context == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) BrazeNotificationStyleFactory$Companion$getStoryStyle$1.INSTANCE, 7, (Object) null);
                return null;
            }
            List<BrazeNotificationPayload.PushStoryPage> pushStoryPages = payload.getPushStoryPages();
            int pushStoryPageIndex = payload.getPushStoryPageIndex();
            BrazeNotificationPayload.PushStoryPage pushStoryPage = pushStoryPages.get(pushStoryPageIndex);
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R$layout.com_braze_push_story_one_image);
            if (!populatePushStoryPage(remoteViews, payload, pushStoryPage)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (a) BrazeNotificationStyleFactory$Companion$getStoryStyle$2.INSTANCE, 6, (Object) null);
                return null;
            }
            Bundle notificationExtras = payload.getNotificationExtras();
            NotificationCompat.DecoratedCustomViewStyle decoratedCustomViewStyle = new NotificationCompat.DecoratedCustomViewStyle();
            int size = pushStoryPages.size();
            remoteViews.setOnClickPendingIntent(R$id.com_braze_story_button_previous, createStoryTraversedPendingIntent(context, notificationExtras, ((pushStoryPageIndex - 1) + size) % size));
            remoteViews.setOnClickPendingIntent(R$id.com_braze_story_button_next, createStoryTraversedPendingIntent(context, notificationExtras, (pushStoryPageIndex + 1) % size));
            notificationBuilder.setCustomBigContentView(remoteViews);
            notificationBuilder.setOnlyAlertOnce(true);
            return decoratedCustomViewStyle;
        }

        @VisibleForTesting
        public final void setBigPictureSummaryAndTitle(@NotNull NotificationCompat.BigPictureStyle bigPictureNotificationStyle, @NotNull BrazeNotificationPayload payload) {
            String contentText;
            t.i(bigPictureNotificationStyle, "bigPictureNotificationStyle");
            t.i(payload, "payload");
            BrazeConfigurationProvider configurationProvider = payload.getConfigurationProvider();
            if (configurationProvider == null) {
                return;
            }
            String bigSummaryText = payload.getBigSummaryText();
            String bigTitleText = payload.getBigTitleText();
            String summaryText = payload.getSummaryText();
            if (bigSummaryText != null) {
                bigPictureNotificationStyle.setSummaryText(HtmlUtils.getHtmlSpannedTextIfEnabled(bigSummaryText, configurationProvider));
            }
            if (bigTitleText != null) {
                bigPictureNotificationStyle.setBigContentTitle(HtmlUtils.getHtmlSpannedTextIfEnabled(bigTitleText, configurationProvider));
            }
            if (summaryText == null && bigSummaryText == null && (contentText = payload.getContentText()) != null) {
                bigPictureNotificationStyle.setSummaryText(HtmlUtils.getHtmlSpannedTextIfEnabled(contentText, configurationProvider));
            }
        }

        public final void setStyleIfSupported(@NotNull NotificationCompat.Builder notificationBuilder, @NotNull BrazeNotificationPayload payload) {
            t.i(notificationBuilder, "notificationBuilder");
            t.i(payload, "payload");
            NotificationCompat.Style notificationStyle = getNotificationStyle(notificationBuilder, payload);
            if (notificationStyle instanceof NoOpSentinelStyle) {
                return;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) BrazeNotificationStyleFactory$Companion$setStyleIfSupported$1.INSTANCE, 7, (Object) null);
            notificationBuilder.setStyle(notificationStyle);
        }
    }

    /* JADX INFO: compiled from: BrazeNotificationStyleFactory.kt */
    private static final class NoOpSentinelStyle extends NotificationCompat.Style {
    }
}
