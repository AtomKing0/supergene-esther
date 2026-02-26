package com.king.amp.sa;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.ViewModelProvider;
import com.ironsource.v8;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class AbmAdPlayer implements e1 {
    public static final String CHAPTER_AD = "chapters";
    public static final String CURRENT_PAGE = "current_page";
    public static final String DISMISS = "dismiss";
    public static final String DISMISS_END_CARD = "dismiss_end_card";
    public static final String DISMISS_PROMPT = "dismiss_prompt";
    public static final int FileError = 3;
    public static final String HTML = "html";
    public static final String IMAGE = "image";
    public static final String IS_MANUALLY_SCROLLED = "is_manually_scrolled";
    public static final int InvalidParameter = 2;
    private static final String JSON_ERROR_MESSAGE = "Failed to parse json";
    public static final int LayoutError = 4;
    public static final int NetworkError = 5;
    public static final int NoError = 0;
    public static final int NotInitialized = 1;
    public static final String PAUSE = "pause";
    public static final String PAUSE_RESUME_CONTROLLER_TYPE = "controllerType";
    public static final String PAUSE_RESUME_PLAYBACK_FINISHED = "playbackFinished";
    public static final String PAUSE_RESUME_REASON = "reason";
    public static final String PAUSE_RESUME_REWARDED = "rewarded";
    public static final String PREVIOUS_PAGE = "previous_page";
    public static final int PlaybackError = 6;
    public static final String RESUME = "resume";
    public static final String REWARD = "reward";
    public static final String REWARD_GRANTED = "reward_granted";
    public static final String SHOW_PROMPT = "show_prompt";
    private static final String TAG = "AbmAdPlayer";
    public static final String UNDEFINED = "undefined";
    public static final String USER_ACTION_ADVERTISER_ICON = "ad_icon";
    public static final String USER_ACTION_CLOSE = "close";
    public static final String USER_ACTION_CTA = "cta";
    public static final String USER_ACTION_END_CARD_CTA = "end_card_cta";
    public static final String USER_ACTION_END_CARD_SHOWN = "end_card_shown";
    public static final String USER_ACTION_ENGAGEMENT = "engagement";
    public static final String USER_ACTION_MUTE = "mute";
    public static final String USER_ACTION_OPEN_URL = "open_url";
    public static final String USER_ACTION_PAGE_CHANGED = "page_changed";
    public static final String USER_ACTION_PAUSE = "pause";
    public static final String USER_ACTION_PLAYBACK_STARTED = "playback_started";
    public static final String USER_ACTION_PROMPT_CLOSE = "prompt_close";
    public static final String USER_ACTION_PROMPT_CONTINUE = "prompt_continue";
    public static final String USER_ACTION_PROMPT_SHOWN = "prompt_shown";
    public static final String USER_ACTION_RESUME = "resume";
    public static final String USER_ACTION_REWARD = "reward_now";
    public static final String USER_ACTION_UNMUTE = "unmute";
    public static final String USER_ACTION_VERIFICATION_ERROR = "verification_error";
    public static final String VIDEO = "video";
    private static Map<Long, WeakReference<AbmAdPlayer>> sInstanceMap = new ConcurrentHashMap();
    private n mCommonDataVM;
    private final Context mContext;
    private r0 mCurrentMediaController;

    @Nullable
    private HashMap<String, String> mCustomMap;
    private HashMap<Integer, r0> mFragmentMap;
    private final AtomicLong mPlayerObjAddress;
    private y mPromptDialogFragment;
    private int mRewardOffset;
    private int mTotalDuration;
    private WeakReference<AbmAdActivity> mWeakAbmActivity;

    @NonNull
    private ArrayList<HashMap<String, String>> mAdContentList = new ArrayList<>();

    @NonNull
    private AbmMediaPlayerLayoutConfig mLayoutConfig = new AbmMediaPlayerLayoutConfig();

    public AbmAdPlayer(long j10, Activity activity) {
        Log.d(TAG, "AbmAdPlayer created for " + j10);
        this.mPlayerObjAddress = new AtomicLong(j10);
        if (activity == null) {
            onPlayerDismissed(6, "Activity is null");
        }
        this.mContext = activity.getApplicationContext();
        sInstanceMap.put(Long.valueOf(j10), new WeakReference<>(this));
        this.mFragmentMap = new HashMap<>();
    }

    private Integer getAdIndex() {
        try {
            String str = (String) getOrDefault(this.mCustomMap, "ad_index", null);
            if (str == null) {
                str = "0";
            }
            return Integer.valueOf(Integer.parseInt(str));
        } catch (NumberFormatException e10) {
            Log.w(TAG, "Failed to parse", e10);
            return null;
        }
    }

    @Nullable
    public static AbmAdPlayer getInstance(long j10) {
        WeakReference<AbmAdPlayer> weakReference;
        Log.d(TAG, "getInstance called for " + j10);
        if (j10 == 0 || (weakReference = sInstanceMap.get(Long.valueOf(j10))) == null) {
            return null;
        }
        return weakReference.get();
    }

    private <K, V> V getOrDefault(@NonNull Map<K, V> map, K k10, V v10) {
        V v11 = map.get(k10);
        return (v11 != null || map.containsKey(k10)) ? v11 : v10;
    }

    public static native void playerAdContentLoadCompleted(long j10, int i10, int i11, String str);

    public static native void playerAppeared(long j10);

    public static native void playerDismissed(long j10, int i10, String str);

    public static native void playerEvent(long j10, String str, AdProviderNameValuePairs adProviderNameValuePairs);

    public static native void playerProgress(long j10, int i10, int i11);

    public boolean action(@NonNull String str) {
        Log.d(TAG, "action called with " + str);
        if (this.mPlayerObjAddress.get() == 0 || this.mCurrentMediaController == null) {
            Log.w(TAG, "action called but player is uninitialized");
            return false;
        }
        str.hashCode();
        switch (str) {
            case "dismiss_prompt":
                return dismissPrompt();
            case "reward":
            case "reward_granted":
                return updateUIforRewardGranted();
            case "show_prompt":
                return showPrompt();
            case "dismiss_end_card":
                return true;
            case "dismiss":
                return dismissAd();
            default:
                return this.mCurrentMediaController.C(str);
        }
    }

    @VisibleForTesting
    protected s createHtmlFragment(Map<String, String> map, AbmAdPlayer abmAdPlayer, Context context) {
        return new s(map, abmAdPlayer, context);
    }

    @VisibleForTesting
    protected y createPromptDialogFragment(Bundle bundle) {
        return y.w(bundle, this);
    }

    @VisibleForTesting
    protected ViewModelProvider createViewModelProvider(AbmAdActivity abmAdActivity) {
        return new ViewModelProvider(abmAdActivity);
    }

    public void dismiss() {
        action("dismiss");
    }

    protected boolean dismissAd() {
        Log.d(TAG, "dismissAd called");
        dismissPrompt();
        WeakReference<AbmAdActivity> weakReference = this.mWeakAbmActivity;
        if (weakReference == null || weakReference.get() == null) {
            return true;
        }
        this.mWeakAbmActivity.get().finish();
        return true;
    }

    protected boolean dismissPrompt() {
        y yVar = this.mPromptDialogFragment;
        if (yVar == null) {
            return false;
        }
        yVar.dismiss();
        this.mPromptDialogFragment = null;
        return true;
    }

    public r0 getCurrentController() {
        return this.mCurrentMediaController;
    }

    @Nullable
    @VisibleForTesting
    protected HashMap<String, String> getCustomParamsMap() {
        return this.mCustomMap;
    }

    public long getPlayerId() {
        return this.mPlayerObjAddress.get();
    }

    public void init(@NonNull String str) {
        this.mTotalDuration = 0;
        this.mRewardOffset = 0;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("total_duration");
            if (!TextUtils.isEmpty(string)) {
                this.mTotalDuration = Integer.parseInt(string);
            }
            String string2 = jSONObject.getString("reward_offset");
            if (TextUtils.isEmpty(string2)) {
                this.mRewardOffset = this.mTotalDuration;
            } else {
                this.mRewardOffset = Integer.parseInt(string2);
            }
        } catch (JSONException e10) {
            Log.e(TAG, JSON_ERROR_MESSAGE, e10);
        }
    }

    @VisibleForTesting
    protected Map<String, String> initializeCurrentMediaController(String str, Map<String, String> map) {
        str.hashCode();
        switch (str) {
            case "html":
                Integer adIndex = getAdIndex();
                if (adIndex == null || !this.mFragmentMap.containsKey(adIndex)) {
                    Log.d(TAG, "Didn't find preloaded fragment, create new one");
                    this.mCurrentMediaController = s.M(this.mCustomMap, this.mPlayerObjAddress.get());
                } else {
                    Log.d(TAG, "Found preloaded fragment");
                    this.mCurrentMediaController = this.mFragmentMap.get(adIndex);
                }
                return map;
            case "image":
                this.mCurrentMediaController = t.P(this.mCustomMap, this.mPlayerObjAddress.get());
                return map;
            case "video":
                this.mCurrentMediaController = l0.W(this.mCustomMap, this.mPlayerObjAddress.get());
                return map;
            case "chapters":
                List<Map<String, String>> chapterConfigMapList = this.mLayoutConfig.getChapterConfigMapList();
                this.mCurrentMediaController = q.Q(this.mCustomMap, chapterConfigMapList, this.mPlayerObjAddress.get());
                if (!chapterConfigMapList.isEmpty()) {
                    return chapterConfigMapList.get(0);
                }
                onPlayerDismissed(4, "Chapter config map is empty");
                return map;
            default:
                Log.d(TAG, "Config ad type " + str + " is not supported.");
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid ad type ");
                sb.append(str);
                onPlayerDismissed(6, sb.toString());
                return map;
        }
    }

    protected void launchActivityIfNot() {
        WeakReference<AbmAdActivity> weakReference = this.mWeakAbmActivity;
        if (weakReference == null) {
            Log.d(TAG, "Activity is not ready, launch it");
            Intent intent = new Intent(this.mContext, (Class<?>) AbmAdActivity.class);
            intent.setFlags(268435456);
            intent.putExtra("AbmPlayerInstanceId", this.mPlayerObjAddress.get());
            this.mContext.startActivity(intent);
            return;
        }
        if (weakReference.get() != null && !this.mWeakAbmActivity.get().isFinishing() && !this.mWeakAbmActivity.get().isDestroyed()) {
            play();
        } else {
            Log.e(TAG, "Activity state not valid.");
            onPlayerDismissed(6, "Activity state not valid.");
        }
    }

    public void onActivityReady(@Nullable AbmAdActivity abmAdActivity) {
        if (abmAdActivity != null) {
            Log.d(TAG, "onActivityReady called with Activity");
            this.mWeakAbmActivity = new WeakReference<>(abmAdActivity);
            abmAdActivity.I0(((long) this.mTotalDuration) * 1000, ((long) this.mRewardOffset) * 1000);
            this.mCommonDataVM = (n) createViewModelProvider(this.mWeakAbmActivity.get()).get(n.class);
            onPlayerAppeared();
        }
        play();
    }

    public void onPlayerAppeared() {
        Log.d(TAG, "PlayerAppeared called on " + this.mPlayerObjAddress);
        if (this.mPlayerObjAddress.get() != 0) {
            playerAppearedWrapper(this.mPlayerObjAddress.get());
        } else {
            Log.w(TAG, "Failed to handle dismiss, player address is not set");
        }
    }

    public void onPlayerContentPreloadCompleted(int i10, int i11, @NonNull String str) {
        Log.d(TAG, "OnPlayerContentPreloadCompleted called with error code " + i11 + " on " + this.mPlayerObjAddress);
        if (this.mPlayerObjAddress.get() != 0) {
            playerAdContentLoadCompletedWrapper(this.mPlayerObjAddress.get(), i10, i11, str);
        } else {
            Log.d(TAG, "Failed to handle preload completed, player address is not set");
        }
        if (i11 != 0) {
            onPlayerDismissed(i11, str);
            dismissAd();
        }
    }

    public void onPlayerDismissed(int i10, @NonNull String str) {
        Log.d(TAG, "Player dismissed, code=" + i10 + ", msg [" + str + v8.i.f15839e);
        if (this.mPlayerObjAddress.get() != 0) {
            playerDismissedWrapper(this.mPlayerObjAddress.get(), i10, str);
        } else {
            Log.w(TAG, "Failed to handle dismiss, player address is not set");
        }
        if (i10 != 0) {
            dismissAd();
        }
    }

    public void onPlayerEvent(@NonNull String str) {
        Log.d(TAG, "Player event: " + str);
        if (this.mPlayerObjAddress.get() != 0) {
            playerEventWrapper(this.mPlayerObjAddress.get(), str, null);
        } else {
            Log.w(TAG, "Failed to handle event, player address is not set");
        }
    }

    public void onPlayerProgressV1(int i10, float f10) {
        Log.e(TAG, "should not fall in here, this is method for AbmMediaPlayer");
    }

    public void onPlayerProgressV2(int i10, int i11) {
        if (this.mPlayerObjAddress.get() != 0) {
            playerProgress(this.mPlayerObjAddress.get(), i10, i11);
        } else {
            Log.w(TAG, "Failed to handle progress, player address is not set");
        }
    }

    protected void play() {
        r0 r0Var = this.mCurrentMediaController;
        Map<String, String> layoutConfigMap = this.mLayoutConfig.getLayoutConfigMap();
        if (this.mAdContentList.size() > 1) {
            this.mWeakAbmActivity.get().getSupportFragmentManager();
            this.mCurrentMediaController = h0.l0(this.mCustomMap, this.mAdContentList, this.mPlayerObjAddress.get());
        } else {
            HashMap<String, String> map = this.mCustomMap;
            if (map == null) {
                onPlayerDismissed(6, "Custom map is null");
                return;
            }
            String str = (String) getOrDefault(map, "ad_type", null);
            if (TextUtils.isEmpty(str)) {
                onPlayerDismissed(6, "Empty ad type ");
                return;
            }
            Log.d(TAG, "Ad content type is " + str);
            layoutConfigMap = initializeCurrentMediaController(str, layoutConfigMap);
        }
        if (r0Var != null) {
            r0Var.u();
        }
        WeakReference<AbmAdActivity> weakReference = this.mWeakAbmActivity;
        if (weakReference == null || weakReference.get() == null) {
            onPlayerDismissed(6, "activity is destroyed unexpectedly");
            return;
        }
        this.mCurrentMediaController.show(this.mWeakAbmActivity.get().getSupportFragmentManager(), "slide_bottom_up");
        n nVar = this.mCommonDataVM;
        if (nVar != null) {
            nVar.n(layoutConfigMap);
        }
    }

    @VisibleForTesting
    protected void playerAdContentLoadCompletedWrapper(long j10, int i10, int i11, String str) {
        playerAdContentLoadCompleted(j10, i10, i11, str);
    }

    @VisibleForTesting
    protected void playerAppearedWrapper(long j10) {
        playerAppeared(j10);
    }

    @VisibleForTesting
    protected void playerDismissedWrapper(long j10, int i10, String str) {
        playerDismissed(j10, i10, str);
    }

    @VisibleForTesting
    protected void playerEventWrapper(long j10, String str, AdProviderNameValuePairs adProviderNameValuePairs) {
        playerEvent(j10, str, adProviderNameValuePairs);
    }

    public void preloadAdContent(@NonNull String str) {
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("adcontent_list");
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                if (HTML.equals(jSONObject.getString("ad_type"))) {
                    String string = jSONObject.getString("ad_index");
                    if (!TextUtils.isEmpty(string)) {
                        int i11 = Integer.parseInt(string);
                        HashMap map = new HashMap();
                        Iterator<String> itKeys = jSONObject.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            map.put(next, jSONObject.getString(next));
                        }
                        s sVar = new s(map, this, this.mContext);
                        sVar.O();
                        this.mFragmentMap.put(Integer.valueOf(i11), sVar);
                    }
                }
            }
        } catch (JSONException e10) {
            Log.e(TAG, JSON_ERROR_MESSAGE, e10);
        }
    }

    public void resetPlayerAddress() {
        Log.d(TAG, "resetPlayerAddress called");
        sInstanceMap.remove(Long.valueOf(this.mPlayerObjAddress.get()));
        this.mPlayerObjAddress.set(0L);
        this.mCommonDataVM = null;
        this.mCurrentMediaController = null;
        this.mFragmentMap = null;
    }

    public void show(@NonNull String str) {
        Log.i(TAG, "AbmAdPlayer show with: " + str);
        this.mAdContentList = new ArrayList<>();
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("adcontent_list");
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                if (jSONObject.has("content")) {
                    JSONObject jSONObject2 = new JSONObject(jSONObject.getString("content"));
                    HashMap<String, String> map = new HashMap<>();
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        map.put(next, jSONObject2.getString(next));
                    }
                    this.mAdContentList.add(map);
                } else {
                    Log.w(TAG, "No content found in adcontent group");
                }
            }
        } catch (JSONException e10) {
            Log.w(TAG, JSON_ERROR_MESSAGE, e10);
        }
        if (this.mAdContentList.isEmpty()) {
            onPlayerDismissed(6, "Ad content list is empty");
            return;
        }
        HashMap<String, String> map2 = this.mAdContentList.get(0);
        this.mCustomMap = map2;
        if (map2 == null) {
            onPlayerDismissed(6, "Custom map is null");
            return;
        }
        Log.i(TAG, "AbmAdPlayer show mCustomMap: " + this.mCustomMap.toString());
        this.mLayoutConfig = new AbmMediaPlayerLayoutConfig((String) getOrDefault(this.mCustomMap, "content_layout_config", null));
        if (!TextUtils.isEmpty((String) getOrDefault(this.mCustomMap, "content_chapter_config", null))) {
            this.mLayoutConfig.setChapterConfig(this.mCustomMap.get("content_chapter_config"));
        }
        launchActivityIfNot();
    }

    protected boolean showPrompt() {
        Bundle bundle = new Bundle();
        bundle.putString("layout_configuration", this.mLayoutConfig.getLayoutConfigString());
        this.mPromptDialogFragment = createPromptDialogFragment(bundle);
        WeakReference<AbmAdActivity> weakReference = this.mWeakAbmActivity;
        if (weakReference == null || weakReference.get() == null) {
            onPlayerDismissed(6, "activity is destroyed unexpectedly");
            return false;
        }
        this.mPromptDialogFragment.show(this.mWeakAbmActivity.get().getSupportFragmentManager(), "AbmMediaPlayerPromptDialogFragment");
        return true;
    }

    protected boolean updateUIforRewardGranted() {
        n nVar = this.mCommonDataVM;
        if (nVar == null) {
            return true;
        }
        nVar.p(Boolean.TRUE);
        return true;
    }

    @Override // com.king.amp.sa.e1
    public void onPlayerEvent(@NonNull String str, s1<AdProviderNameValuePairs> s1Var) {
        Log.d(TAG, "Player event: " + str + ", with [" + s1Var.toString() + v8.i.f15839e);
        if (this.mPlayerObjAddress.get() != 0) {
            playerEventWrapper(this.mPlayerObjAddress.get(), str, s1Var.e(null));
        } else {
            Log.w(TAG, "Failed to handle event, player address is not set");
            dismissAd();
        }
    }
}
