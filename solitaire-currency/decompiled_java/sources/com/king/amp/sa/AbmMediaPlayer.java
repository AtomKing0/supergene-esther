package com.king.amp.sa;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class AbmMediaPlayer implements e1 {
    public static final int BrowserError = 9;
    public static final String CURRENT_PAGE = "current_page";
    public static final String DISMISS = "dismiss";
    public static final String DISMISS_END_CARD = "dismiss_end_card";
    public static final String DISMISS_PROMPT = "dismiss_prompt";
    public static final int FileError = 3;
    public static final String INTERACTIVE_AD = "interactive";
    public static final String IS_MANUALLY_SCROLLED = "is_manually_scrolled";
    public static final int InvalidParameter = 2;
    public static final int LayoutError = 4;
    public static final int NoError = 0;
    public static final int NotInitialized = 1;
    public static final String OPEN_URL = "open_url";
    public static final String PAUSE = "pause";
    public static final String PREVIOUS_PAGE = "previous_page";
    public static final int PlaybackError = 6;
    public static final String RESUME = "resume";
    public static final String REWARDED_CHAPTERS = "chapters";
    public static final String REWARDED_LONG_RV = "rv_trueview";
    public static final String REWARDED_SHORT_RV = "rv_shortform";
    public static final String REWARD_GRANTED = "reward_granted";
    public static final String SHOW_END_CARD = "show_end_card";
    public static final String SHOW_PROMPT = "show_prompt";
    private static String TAG = "AbmMediaPlayer";
    public static final String UNDEFINED = "undefined";
    public static final String USER_ACTION_ADVERTISER_ICON = "ad_icon";
    public static final String USER_ACTION_AD_CHOICES_ICON = "ad_choices_icon";
    public static final String USER_ACTION_CLOSE = "close";
    public static final String USER_ACTION_CTA = "cta";
    public static final String USER_ACTION_END_CARD_CLOSE = "end_card_close";
    public static final String USER_ACTION_END_CARD_CTA = "end_card_cta";
    public static final String USER_ACTION_END_CARD_SHOWN = "end_card_shown";
    public static final String USER_ACTION_MUTE = "mute";
    public static final String USER_ACTION_NAVIGATE = "navigate";
    public static final String USER_ACTION_PAGE_CHANGED = "page_changed";
    public static final String USER_ACTION_PLAYBACK_STARTED = "playback_started";
    public static final String USER_ACTION_PROMPT_CLOSE = "prompt_close";
    public static final String USER_ACTION_PROMPT_CONTINUE = "prompt_continue";
    public static final String USER_ACTION_UNMUTE = "unmute";
    public static final int Undefined = 8;
    private static String sAdType;
    private static Context sContext;
    private static AbmMediaPlayer sInstance;
    private static i1 sInteractiveAd;
    private boolean mRewardGranted = false;
    private AtomicLong mPlayerObjAddress = new AtomicLong(0);

    public static boolean action(@NonNull String str) {
        AbmMediaPlayer abmMediaPlayer = sInstance;
        if (abmMediaPlayer == null || abmMediaPlayer.mPlayerObjAddress.get() == 0) {
            return false;
        }
        if (sAdType.equals(INTERACTIVE_AD)) {
            sInteractiveAd.b(str);
            return true;
        }
        sInstance.actionIntent(str);
        return true;
    }

    public static void dismiss() {
        action("dismiss");
    }

    public static synchronized AbmMediaPlayer getInstance() {
        if (sInstance == null) {
            sInstance = new AbmMediaPlayer();
        }
        return sInstance;
    }

    public static boolean isActivityRunningInForeground(Context context, Class<? extends AppCompatActivity> cls) {
        ActivityManager activityManager;
        List<ActivityManager.AppTask> appTasks;
        ComponentName componentName;
        if (context != null && cls != null && (activityManager = (ActivityManager) context.getSystemService("activity")) != null && (appTasks = activityManager.getAppTasks()) != null && !appTasks.isEmpty()) {
            Iterator<ActivityManager.AppTask> it = appTasks.iterator();
            while (it.hasNext()) {
                ActivityManager.RecentTaskInfo taskInfo = it.next().getTaskInfo();
                if (taskInfo != null && (componentName = taskInfo.topActivity) != null) {
                    String className = componentName.getClassName();
                    if (!TextUtils.isEmpty(className) && className.equals(cls.getName())) {
                        Log.i(TAG, "Activity " + cls.getName() + " is running");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void pause() {
        action("pause");
    }

    public static void play(@NonNull Map<String, String> map, @NonNull String str, @NonNull String str2) {
        Intent intent = new Intent(sContext, (Class<?>) AbmMediaPlayerActivity.class);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            intent.putExtra(entry.getKey(), entry.getValue());
        }
        intent.putExtra("layout_configuration", str);
        intent.putExtra("Chapter_configuration", str2);
        intent.setFlags(268435456);
        sContext.startActivity(intent);
        sInstance.onPlayerAppeared();
    }

    public static native void playerAppeared(long j10);

    public static native void playerDismissed(long j10, int i10, String str);

    public static native void playerEvent(long j10, String str, AdProviderNameValuePairs adProviderNameValuePairs);

    public static native void playerProgress(long j10, int i10, int i11);

    public static void resetPlayerAddress() {
        AbmMediaPlayer abmMediaPlayer = sInstance;
        if (abmMediaPlayer != null) {
            abmMediaPlayer.mPlayerObjAddress.set(0L);
        }
    }

    public static void resume() {
        action("resume");
    }

    public static void rewardGranted() {
        AbmMediaPlayer abmMediaPlayer = sInstance;
        if (abmMediaPlayer != null) {
            abmMediaPlayer.setRewardGranted(true);
        }
        action("reward_granted");
    }

    public static void setContext(Activity activity) {
        sContext = activity.getApplicationContext();
    }

    public static void show(long j10, @NonNull String[] strArr, @NonNull String str, @NonNull String str2) {
        if (sContext == null) {
            t1.e(TAG, "Context to launch AbmMediaPlayer is null.");
            return;
        }
        if (sInstance == null) {
            getInstance();
        }
        sInstance.mPlayerObjAddress = new AtomicLong(j10);
        HashMap map = new HashMap();
        int i10 = 0;
        while (true) {
            int i11 = i10 + 1;
            if (i11 >= strArr.length) {
                break;
            }
            if (i11 < strArr.length) {
                map.put(strArr[i10], strArr[i11]);
            }
            i10 += 2;
        }
        String str3 = (String) map.get("ad_type");
        sAdType = str3;
        if (str3.equals(INTERACTIVE_AD)) {
            showInteractiveAd(map, str);
            return;
        }
        if (sAdType.equals(REWARDED_LONG_RV) || sAdType.equals(REWARDED_SHORT_RV) || sAdType.equals("chapters")) {
            play(map, str, str2);
            return;
        }
        t1.e(TAG, "Config ad type " + sAdType + " is not supported.");
        playerDismissed(sInstance.mPlayerObjAddress.get(), 6, "Invalid ad type " + sAdType);
    }

    public static void showInteractiveAd(@NonNull Map<String, String> map, @NonNull String str) {
        sInteractiveAd = new i1();
        String str2 = map.get("ad_media");
        String str3 = map.get("video_duration");
        long j10 = str3 != null ? Long.parseLong(str3) : 30L;
        i1.o(sContext);
        sInteractiveAd.p(str2, j10, str);
    }

    public void actionIntent(@NonNull String str) {
        if (isActivityRunningInForeground(sContext, AbmMediaPlayerActivity.class)) {
            Intent intent = new Intent();
            intent.setAction("com.king.amp.sa.UPDATE_PLAYER_ACTIVITY");
            intent.putExtra(str, true);
            LocalBroadcastManager.getInstance(sContext).sendBroadcast(intent);
            return;
        }
        Intent intent2 = new Intent(sContext, (Class<?>) AbmMediaPlayerActivity.class);
        intent2.setFlags(268435456);
        intent2.putExtra(str, true);
        sContext.startActivity(intent2);
    }

    public boolean isRewardGranted() {
        return this.mRewardGranted;
    }

    public void onPlayerAppeared() {
        AtomicLong atomicLong = this.mPlayerObjAddress;
        if (atomicLong == null || atomicLong.get() == 0) {
            return;
        }
        playerAppeared(this.mPlayerObjAddress.get());
    }

    public void onPlayerDismissed(int i10, @NonNull String str) {
        AtomicLong atomicLong = this.mPlayerObjAddress;
        if (atomicLong == null || atomicLong.get() == 0) {
            return;
        }
        playerDismissed(this.mPlayerObjAddress.get(), i10, str);
    }

    @Override // com.king.amp.sa.e1
    public void onPlayerEvent(@NonNull String str, s1<AdProviderNameValuePairs> s1Var) {
        AtomicLong atomicLong = this.mPlayerObjAddress;
        if (atomicLong == null || atomicLong.get() == 0) {
            return;
        }
        playerEvent(this.mPlayerObjAddress.get(), str, s1Var.c() ? s1Var.b() : null);
    }

    public void onPlayerProgressV1(int i10, float f10) {
        AtomicLong atomicLong = this.mPlayerObjAddress;
        if (atomicLong == null || atomicLong.get() == 0) {
            return;
        }
        playerProgress(this.mPlayerObjAddress.get(), i10, (int) f10);
    }

    public void onPlayerProgressV2(int i10, int i11) {
        Log.e(TAG, "Should not be called here!");
    }

    public void setRewardGranted(boolean z10) {
        this.mRewardGranted = z10;
    }

    public void onPlayerEvent(@NonNull String str) {
        AtomicLong atomicLong = this.mPlayerObjAddress;
        if (atomicLong == null || atomicLong.get() == 0) {
            return;
        }
        playerEvent(this.mPlayerObjAddress.get(), str, null);
    }

    public void onPlayerContentPreloadCompleted(int i10, int i11, @NonNull String str) {
    }
}
