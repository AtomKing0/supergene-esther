package androidx.browser.customtabs;

import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.annotation.AnimRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.browser.customtabs.CustomTabColorSchemeParams;
import androidx.browser.customtabs.CustomTabsSession;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.app.BundleCompat;
import androidx.core.content.ContextCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class CustomTabsIntent {
    public static final int ACTIVITY_HEIGHT_ADJUSTABLE = 1;
    public static final int ACTIVITY_HEIGHT_DEFAULT = 0;
    public static final int ACTIVITY_HEIGHT_FIXED = 2;
    private static final int ACTIVITY_HEIGHT_MAX = 2;
    public static final int CLOSE_BUTTON_POSITION_DEFAULT = 0;
    public static final int CLOSE_BUTTON_POSITION_END = 2;
    private static final int CLOSE_BUTTON_POSITION_MAX = 2;
    public static final int CLOSE_BUTTON_POSITION_START = 1;
    public static final int COLOR_SCHEME_DARK = 2;
    public static final int COLOR_SCHEME_LIGHT = 1;
    private static final int COLOR_SCHEME_MAX = 2;
    public static final int COLOR_SCHEME_SYSTEM = 0;
    public static final String EXTRA_ACTION_BUTTON_BUNDLE = "android.support.customtabs.extra.ACTION_BUTTON_BUNDLE";
    public static final String EXTRA_ACTIVITY_HEIGHT_RESIZE_BEHAVIOR = "androidx.browser.customtabs.extra.ACTIVITY_HEIGHT_RESIZE_BEHAVIOR";
    public static final String EXTRA_CLOSE_BUTTON_ICON = "android.support.customtabs.extra.CLOSE_BUTTON_ICON";
    public static final String EXTRA_CLOSE_BUTTON_POSITION = "androidx.browser.customtabs.extra.CLOSE_BUTTON_POSITION";
    public static final String EXTRA_COLOR_SCHEME = "androidx.browser.customtabs.extra.COLOR_SCHEME";
    public static final String EXTRA_COLOR_SCHEME_PARAMS = "androidx.browser.customtabs.extra.COLOR_SCHEME_PARAMS";

    @Deprecated
    public static final String EXTRA_DEFAULT_SHARE_MENU_ITEM = "android.support.customtabs.extra.SHARE_MENU_ITEM";
    public static final String EXTRA_DISABLE_BACKGROUND_INTERACTION = "androidx.browser.customtabs.extra.DISABLE_BACKGROUND_INTERACTION";
    public static final String EXTRA_DISABLE_BOOKMARKS_BUTTON = "org.chromium.chrome.browser.customtabs.EXTRA_DISABLE_STAR_BUTTON";
    public static final String EXTRA_DISABLE_DOWNLOAD_BUTTON = "org.chromium.chrome.browser.customtabs.EXTRA_DISABLE_DOWNLOAD_BUTTON";
    public static final String EXTRA_ENABLE_INSTANT_APPS = "android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS";
    public static final String EXTRA_ENABLE_URLBAR_HIDING = "android.support.customtabs.extra.ENABLE_URLBAR_HIDING";
    public static final String EXTRA_EXIT_ANIMATION_BUNDLE = "android.support.customtabs.extra.EXIT_ANIMATION_BUNDLE";
    public static final String EXTRA_INITIAL_ACTIVITY_HEIGHT_PX = "androidx.browser.customtabs.extra.INITIAL_ACTIVITY_HEIGHT_PX";
    public static final String EXTRA_MENU_ITEMS = "android.support.customtabs.extra.MENU_ITEMS";
    public static final String EXTRA_NAVIGATION_BAR_COLOR = "androidx.browser.customtabs.extra.NAVIGATION_BAR_COLOR";
    public static final String EXTRA_NAVIGATION_BAR_DIVIDER_COLOR = "androidx.browser.customtabs.extra.NAVIGATION_BAR_DIVIDER_COLOR";
    public static final String EXTRA_REMOTEVIEWS = "android.support.customtabs.extra.EXTRA_REMOTEVIEWS";
    public static final String EXTRA_REMOTEVIEWS_CLICKED_ID = "android.support.customtabs.extra.EXTRA_REMOTEVIEWS_CLICKED_ID";
    public static final String EXTRA_REMOTEVIEWS_PENDINGINTENT = "android.support.customtabs.extra.EXTRA_REMOTEVIEWS_PENDINGINTENT";
    public static final String EXTRA_REMOTEVIEWS_VIEW_IDS = "android.support.customtabs.extra.EXTRA_REMOTEVIEWS_VIEW_IDS";
    public static final String EXTRA_SECONDARY_TOOLBAR_COLOR = "android.support.customtabs.extra.SECONDARY_TOOLBAR_COLOR";
    public static final String EXTRA_SECONDARY_TOOLBAR_SWIPE_UP_GESTURE = "androidx.browser.customtabs.extra.SECONDARY_TOOLBAR_SWIPE_UP_GESTURE";
    public static final String EXTRA_SEND_TO_EXTERNAL_DEFAULT_HANDLER = "android.support.customtabs.extra.SEND_TO_EXTERNAL_HANDLER";
    public static final String EXTRA_SESSION = "android.support.customtabs.extra.SESSION";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String EXTRA_SESSION_ID = "android.support.customtabs.extra.SESSION_ID";
    public static final String EXTRA_SHARE_STATE = "androidx.browser.customtabs.extra.SHARE_STATE";
    public static final String EXTRA_TINT_ACTION_BUTTON = "android.support.customtabs.extra.TINT_ACTION_BUTTON";
    public static final String EXTRA_TITLE_VISIBILITY_STATE = "android.support.customtabs.extra.TITLE_VISIBILITY";
    public static final String EXTRA_TOOLBAR_COLOR = "android.support.customtabs.extra.TOOLBAR_COLOR";
    public static final String EXTRA_TOOLBAR_CORNER_RADIUS_DP = "androidx.browser.customtabs.extra.TOOLBAR_CORNER_RADIUS_DP";
    public static final String EXTRA_TOOLBAR_ITEMS = "android.support.customtabs.extra.TOOLBAR_ITEMS";
    public static final String EXTRA_TRANSLATE_LANGUAGE_TAG = "androidx.browser.customtabs.extra.TRANSLATE_LANGUAGE_TAG";
    private static final String EXTRA_USER_OPT_OUT_FROM_CUSTOM_TABS = "android.support.customtabs.extra.user_opt_out";
    private static final String HTTP_ACCEPT_LANGUAGE = "Accept-Language";
    public static final String KEY_DESCRIPTION = "android.support.customtabs.customaction.DESCRIPTION";
    public static final String KEY_ICON = "android.support.customtabs.customaction.ICON";
    public static final String KEY_ID = "android.support.customtabs.customaction.ID";
    public static final String KEY_MENU_ITEM_TITLE = "android.support.customtabs.customaction.MENU_ITEM_TITLE";
    public static final String KEY_PENDING_INTENT = "android.support.customtabs.customaction.PENDING_INTENT";
    private static final int MAX_TOOLBAR_CORNER_RADIUS_DP = 16;
    private static final int MAX_TOOLBAR_ITEMS = 5;
    public static final int NO_TITLE = 0;
    public static final int SHARE_STATE_DEFAULT = 0;
    private static final int SHARE_STATE_MAX = 2;
    public static final int SHARE_STATE_OFF = 2;
    public static final int SHARE_STATE_ON = 1;
    public static final int SHOW_PAGE_TITLE = 1;
    public static final int TOOLBAR_ACTION_BUTTON_ID = 0;

    @NonNull
    public final Intent intent;

    @Nullable
    public final Bundle startAnimationBundle;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface ActivityHeightResizeBehavior {
    }

    @RequiresApi(api = 21)
    private static class Api21Impl {
        private Api21Impl() {
        }

        @Nullable
        @DoNotInline
        static Locale getLocaleForLanguageTag(Intent intent) {
            String stringExtra = intent.getStringExtra(CustomTabsIntent.EXTRA_TRANSLATE_LANGUAGE_TAG);
            if (stringExtra != null) {
                return Locale.forLanguageTag(stringExtra);
            }
            return null;
        }

        @DoNotInline
        static void setLanguageTag(Intent intent, Locale locale) {
            intent.putExtra(CustomTabsIntent.EXTRA_TRANSLATE_LANGUAGE_TAG, locale.toLanguageTag());
        }
    }

    @RequiresApi(api = 23)
    private static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static ActivityOptions makeBasicActivityOptions() {
            return ActivityOptions.makeBasic();
        }
    }

    @RequiresApi(api = 24)
    private static class Api24Impl {
        private Api24Impl() {
        }

        @Nullable
        @DoNotInline
        static String getDefaultLocale() {
            LocaleList adjustedDefault = LocaleList.getAdjustedDefault();
            if (adjustedDefault.size() > 0) {
                return adjustedDefault.get(0).toLanguageTag();
            }
            return null;
        }
    }

    @RequiresApi(api = 34)
    private static class Api34Impl {
        private Api34Impl() {
        }

        @DoNotInline
        static void setShareIdentityEnabled(ActivityOptions activityOptions, boolean z10) {
            activityOptions.setShareIdentityEnabled(z10);
        }
    }

    public static final class Builder {

        @Nullable
        private ArrayList<Bundle> mActionButtons;

        @Nullable
        private ActivityOptions mActivityOptions;

        @Nullable
        private SparseArray<Bundle> mColorSchemeParamBundles;

        @Nullable
        private Bundle mDefaultColorSchemeBundle;

        @Nullable
        private ArrayList<Bundle> mMenuItems;
        private boolean mShareIdentity;
        private final Intent mIntent = new Intent("android.intent.action.VIEW");
        private final CustomTabColorSchemeParams.Builder mDefaultColorSchemeBuilder = new CustomTabColorSchemeParams.Builder();
        private int mShareState = 0;
        private boolean mInstantAppsEnabled = true;

        public Builder() {
        }

        @RequiresApi(api = 24)
        private void setCurrentLocaleAsDefaultAcceptLanguage() {
            String defaultLocale = Api24Impl.getDefaultLocale();
            if (TextUtils.isEmpty(defaultLocale)) {
                return;
            }
            Bundle bundleExtra = this.mIntent.hasExtra("com.android.browser.headers") ? this.mIntent.getBundleExtra("com.android.browser.headers") : new Bundle();
            if (bundleExtra.containsKey(CustomTabsIntent.HTTP_ACCEPT_LANGUAGE)) {
                return;
            }
            bundleExtra.putString(CustomTabsIntent.HTTP_ACCEPT_LANGUAGE, defaultLocale);
            this.mIntent.putExtra("com.android.browser.headers", bundleExtra);
        }

        @RequiresApi(api = 24)
        private void setLanguageTag(@NonNull Locale locale) {
            Api21Impl.setLanguageTag(this.mIntent, locale);
        }

        private void setSessionParameters(@Nullable IBinder iBinder, @Nullable PendingIntent pendingIntent) {
            Bundle bundle = new Bundle();
            BundleCompat.putBinder(bundle, CustomTabsIntent.EXTRA_SESSION, iBinder);
            if (pendingIntent != null) {
                bundle.putParcelable(CustomTabsIntent.EXTRA_SESSION_ID, pendingIntent);
            }
            this.mIntent.putExtras(bundle);
        }

        @NonNull
        @Deprecated
        public Builder addDefaultShareMenuItem() {
            setShareState(1);
            return this;
        }

        @NonNull
        public Builder addMenuItem(@NonNull String str, @NonNull PendingIntent pendingIntent) {
            if (this.mMenuItems == null) {
                this.mMenuItems = new ArrayList<>();
            }
            Bundle bundle = new Bundle();
            bundle.putString(CustomTabsIntent.KEY_MENU_ITEM_TITLE, str);
            bundle.putParcelable(CustomTabsIntent.KEY_PENDING_INTENT, pendingIntent);
            this.mMenuItems.add(bundle);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder addToolbarItem(int i10, @NonNull Bitmap bitmap, @NonNull String str, @NonNull PendingIntent pendingIntent) throws IllegalStateException {
            if (this.mActionButtons == null) {
                this.mActionButtons = new ArrayList<>();
            }
            if (this.mActionButtons.size() >= 5) {
                throw new IllegalStateException("Exceeded maximum toolbar item count of 5");
            }
            Bundle bundle = new Bundle();
            bundle.putInt(CustomTabsIntent.KEY_ID, i10);
            bundle.putParcelable(CustomTabsIntent.KEY_ICON, bitmap);
            bundle.putString(CustomTabsIntent.KEY_DESCRIPTION, str);
            bundle.putParcelable(CustomTabsIntent.KEY_PENDING_INTENT, pendingIntent);
            this.mActionButtons.add(bundle);
            return this;
        }

        @NonNull
        public CustomTabsIntent build() {
            if (!this.mIntent.hasExtra(CustomTabsIntent.EXTRA_SESSION)) {
                setSessionParameters(null, null);
            }
            ArrayList<Bundle> arrayList = this.mMenuItems;
            if (arrayList != null) {
                this.mIntent.putParcelableArrayListExtra(CustomTabsIntent.EXTRA_MENU_ITEMS, arrayList);
            }
            ArrayList<Bundle> arrayList2 = this.mActionButtons;
            if (arrayList2 != null) {
                this.mIntent.putParcelableArrayListExtra(CustomTabsIntent.EXTRA_TOOLBAR_ITEMS, arrayList2);
            }
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_ENABLE_INSTANT_APPS, this.mInstantAppsEnabled);
            this.mIntent.putExtras(this.mDefaultColorSchemeBuilder.build().toBundle());
            Bundle bundle = this.mDefaultColorSchemeBundle;
            if (bundle != null) {
                this.mIntent.putExtras(bundle);
            }
            if (this.mColorSchemeParamBundles != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putSparseParcelableArray(CustomTabsIntent.EXTRA_COLOR_SCHEME_PARAMS, this.mColorSchemeParamBundles);
                this.mIntent.putExtras(bundle2);
            }
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_SHARE_STATE, this.mShareState);
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 24) {
                setCurrentLocaleAsDefaultAcceptLanguage();
            }
            if (i10 >= 34) {
                setShareIdentityEnabled();
            }
            ActivityOptions activityOptions = this.mActivityOptions;
            return new CustomTabsIntent(this.mIntent, activityOptions != null ? activityOptions.toBundle() : null);
        }

        @NonNull
        @Deprecated
        public Builder enableUrlBarHiding() {
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_ENABLE_URLBAR_HIDING, true);
            return this;
        }

        @NonNull
        public Builder setActionButton(@NonNull Bitmap bitmap, @NonNull String str, @NonNull PendingIntent pendingIntent, boolean z10) {
            Bundle bundle = new Bundle();
            bundle.putInt(CustomTabsIntent.KEY_ID, 0);
            bundle.putParcelable(CustomTabsIntent.KEY_ICON, bitmap);
            bundle.putString(CustomTabsIntent.KEY_DESCRIPTION, str);
            bundle.putParcelable(CustomTabsIntent.KEY_PENDING_INTENT, pendingIntent);
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_ACTION_BUTTON_BUNDLE, bundle);
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_TINT_ACTION_BUTTON, z10);
            return this;
        }

        @NonNull
        public Builder setBackgroundInteractionEnabled(boolean z10) {
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_DISABLE_BACKGROUND_INTERACTION, !z10);
            return this;
        }

        @NonNull
        public Builder setBookmarksButtonEnabled(boolean z10) {
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_DISABLE_BOOKMARKS_BUTTON, !z10);
            return this;
        }

        @NonNull
        public Builder setCloseButtonIcon(@NonNull Bitmap bitmap) {
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_CLOSE_BUTTON_ICON, bitmap);
            return this;
        }

        @NonNull
        public Builder setCloseButtonPosition(int i10) {
            if (i10 < 0 || i10 > 2) {
                throw new IllegalArgumentException("Invalid value for the position argument");
            }
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_CLOSE_BUTTON_POSITION, i10);
            return this;
        }

        @NonNull
        public Builder setColorScheme(int i10) {
            if (i10 < 0 || i10 > 2) {
                throw new IllegalArgumentException("Invalid value for the colorScheme argument");
            }
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_COLOR_SCHEME, i10);
            return this;
        }

        @NonNull
        public Builder setColorSchemeParams(int i10, @NonNull CustomTabColorSchemeParams customTabColorSchemeParams) {
            if (i10 < 0 || i10 > 2 || i10 == 0) {
                throw new IllegalArgumentException("Invalid colorScheme: " + i10);
            }
            if (this.mColorSchemeParamBundles == null) {
                this.mColorSchemeParamBundles = new SparseArray<>();
            }
            this.mColorSchemeParamBundles.put(i10, customTabColorSchemeParams.toBundle());
            return this;
        }

        @NonNull
        public Builder setDefaultColorSchemeParams(@NonNull CustomTabColorSchemeParams customTabColorSchemeParams) {
            this.mDefaultColorSchemeBundle = customTabColorSchemeParams.toBundle();
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setDefaultShareMenuItemEnabled(boolean z10) {
            if (z10) {
                setShareState(1);
            } else {
                setShareState(2);
            }
            return this;
        }

        @NonNull
        public Builder setDownloadButtonEnabled(boolean z10) {
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_DISABLE_DOWNLOAD_BUTTON, !z10);
            return this;
        }

        @NonNull
        public Builder setExitAnimations(@NonNull Context context, @AnimRes int i10, @AnimRes int i11) {
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_EXIT_ANIMATION_BUNDLE, ActivityOptionsCompat.makeCustomAnimation(context, i10, i11).toBundle());
            return this;
        }

        @NonNull
        public Builder setInitialActivityHeightPx(@Dimension(unit = 1) int i10, int i11) {
            if (i10 <= 0) {
                throw new IllegalArgumentException("Invalid value for the initialHeightPx argument");
            }
            if (i11 < 0 || i11 > 2) {
                throw new IllegalArgumentException("Invalid value for the activityHeightResizeBehavior argument");
            }
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_INITIAL_ACTIVITY_HEIGHT_PX, i10);
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_ACTIVITY_HEIGHT_RESIZE_BEHAVIOR, i11);
            return this;
        }

        @NonNull
        public Builder setInstantAppsEnabled(boolean z10) {
            this.mInstantAppsEnabled = z10;
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setNavigationBarColor(@ColorInt int i10) {
            this.mDefaultColorSchemeBuilder.setNavigationBarColor(i10);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setNavigationBarDividerColor(@ColorInt int i10) {
            this.mDefaultColorSchemeBuilder.setNavigationBarDividerColor(i10);
            return this;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public Builder setPendingSession(@NonNull CustomTabsSession.PendingSession pendingSession) {
            setSessionParameters(null, pendingSession.getId());
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setSecondaryToolbarColor(@ColorInt int i10) {
            this.mDefaultColorSchemeBuilder.setSecondaryToolbarColor(i10);
            return this;
        }

        @NonNull
        public Builder setSecondaryToolbarSwipeUpGesture(@Nullable PendingIntent pendingIntent) {
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_SECONDARY_TOOLBAR_SWIPE_UP_GESTURE, pendingIntent);
            return this;
        }

        @NonNull
        public Builder setSecondaryToolbarViews(@NonNull RemoteViews remoteViews, @Nullable int[] iArr, @Nullable PendingIntent pendingIntent) {
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_REMOTEVIEWS, remoteViews);
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_REMOTEVIEWS_VIEW_IDS, iArr);
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_REMOTEVIEWS_PENDINGINTENT, pendingIntent);
            return this;
        }

        @NonNull
        public Builder setSendToExternalDefaultHandlerEnabled(boolean z10) {
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_SEND_TO_EXTERNAL_DEFAULT_HANDLER, z10);
            return this;
        }

        @NonNull
        public Builder setSession(@NonNull CustomTabsSession customTabsSession) {
            this.mIntent.setPackage(customTabsSession.getComponentName().getPackageName());
            setSessionParameters(customTabsSession.getBinder(), customTabsSession.getId());
            return this;
        }

        @NonNull
        public Builder setShareIdentityEnabled(boolean z10) {
            this.mShareIdentity = z10;
            return this;
        }

        @NonNull
        public Builder setShareState(int i10) {
            if (i10 < 0 || i10 > 2) {
                throw new IllegalArgumentException("Invalid value for the shareState argument");
            }
            this.mShareState = i10;
            if (i10 == 1) {
                this.mIntent.putExtra(CustomTabsIntent.EXTRA_DEFAULT_SHARE_MENU_ITEM, true);
            } else if (i10 == 2) {
                this.mIntent.putExtra(CustomTabsIntent.EXTRA_DEFAULT_SHARE_MENU_ITEM, false);
            } else {
                this.mIntent.removeExtra(CustomTabsIntent.EXTRA_DEFAULT_SHARE_MENU_ITEM);
            }
            return this;
        }

        @NonNull
        public Builder setShowTitle(boolean z10) {
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_TITLE_VISIBILITY_STATE, z10 ? 1 : 0);
            return this;
        }

        @NonNull
        public Builder setStartAnimations(@NonNull Context context, @AnimRes int i10, @AnimRes int i11) {
            this.mActivityOptions = ActivityOptions.makeCustomAnimation(context, i10, i11);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setToolbarColor(@ColorInt int i10) {
            this.mDefaultColorSchemeBuilder.setToolbarColor(i10);
            return this;
        }

        @NonNull
        public Builder setToolbarCornerRadiusDp(@Dimension(unit = 0) int i10) {
            if (i10 < 0 || i10 > 16) {
                throw new IllegalArgumentException("Invalid value for the cornerRadiusDp argument");
            }
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_TOOLBAR_CORNER_RADIUS_DP, i10);
            return this;
        }

        @NonNull
        public Builder setTranslateLocale(@NonNull Locale locale) {
            if (Build.VERSION.SDK_INT >= 24) {
                setLanguageTag(locale);
            }
            return this;
        }

        @NonNull
        public Builder setUrlBarHidingEnabled(boolean z10) {
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_ENABLE_URLBAR_HIDING, z10);
            return this;
        }

        @RequiresApi(api = 34)
        private void setShareIdentityEnabled() {
            if (this.mActivityOptions == null) {
                this.mActivityOptions = Api23Impl.makeBasicActivityOptions();
            }
            Api34Impl.setShareIdentityEnabled(this.mActivityOptions, this.mShareIdentity);
        }

        @NonNull
        public Builder setInitialActivityHeightPx(@Dimension(unit = 1) int i10) {
            return setInitialActivityHeightPx(i10, 0);
        }

        public Builder(@Nullable CustomTabsSession customTabsSession) {
            if (customTabsSession != null) {
                setSession(customTabsSession);
            }
        }

        @NonNull
        public Builder setActionButton(@NonNull Bitmap bitmap, @NonNull String str, @NonNull PendingIntent pendingIntent) {
            return setActionButton(bitmap, str, pendingIntent, false);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface CloseButtonPosition {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface ColorScheme {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface ShareState {
    }

    CustomTabsIntent(@NonNull Intent intent, @Nullable Bundle bundle) {
        this.intent = intent;
        this.startAnimationBundle = bundle;
    }

    public static int getActivityResizeBehavior(@NonNull Intent intent) {
        return intent.getIntExtra(EXTRA_ACTIVITY_HEIGHT_RESIZE_BEHAVIOR, 0);
    }

    public static int getCloseButtonPosition(@NonNull Intent intent) {
        return intent.getIntExtra(EXTRA_CLOSE_BUTTON_POSITION, 0);
    }

    @NonNull
    public static CustomTabColorSchemeParams getColorSchemeParams(@NonNull Intent intent, int i10) {
        Bundle bundle;
        if (i10 < 0 || i10 > 2 || i10 == 0) {
            throw new IllegalArgumentException("Invalid colorScheme: " + i10);
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return CustomTabColorSchemeParams.fromBundle(null);
        }
        CustomTabColorSchemeParams customTabColorSchemeParamsFromBundle = CustomTabColorSchemeParams.fromBundle(extras);
        SparseArray sparseParcelableArray = extras.getSparseParcelableArray(EXTRA_COLOR_SCHEME_PARAMS);
        return (sparseParcelableArray == null || (bundle = (Bundle) sparseParcelableArray.get(i10)) == null) ? customTabColorSchemeParamsFromBundle : CustomTabColorSchemeParams.fromBundle(bundle).withDefaults(customTabColorSchemeParamsFromBundle);
    }

    @Dimension(unit = 1)
    public static int getInitialActivityHeightPx(@NonNull Intent intent) {
        return intent.getIntExtra(EXTRA_INITIAL_ACTIVITY_HEIGHT_PX, 0);
    }

    @Nullable
    @RequiresApi(api = 24)
    private static Locale getLocaleForLanguageTag(Intent intent) {
        return Api21Impl.getLocaleForLanguageTag(intent);
    }

    public static int getMaxToolbarItems() {
        return 5;
    }

    @Nullable
    public static PendingIntent getSecondaryToolbarSwipeUpGesture(@NonNull Intent intent) {
        return (PendingIntent) intent.getParcelableExtra(EXTRA_SECONDARY_TOOLBAR_SWIPE_UP_GESTURE);
    }

    @Dimension(unit = 0)
    public static int getToolbarCornerRadiusDp(@NonNull Intent intent) {
        return intent.getIntExtra(EXTRA_TOOLBAR_CORNER_RADIUS_DP, 16);
    }

    @Nullable
    public static Locale getTranslateLocale(@NonNull Intent intent) {
        if (Build.VERSION.SDK_INT >= 24) {
            return getLocaleForLanguageTag(intent);
        }
        return null;
    }

    public static boolean isBackgroundInteractionEnabled(@NonNull Intent intent) {
        return !intent.getBooleanExtra(EXTRA_DISABLE_BACKGROUND_INTERACTION, false);
    }

    public static boolean isBookmarksButtonEnabled(@NonNull Intent intent) {
        return !intent.getBooleanExtra(EXTRA_DISABLE_BOOKMARKS_BUTTON, false);
    }

    public static boolean isDownloadButtonEnabled(@NonNull Intent intent) {
        return !intent.getBooleanExtra(EXTRA_DISABLE_DOWNLOAD_BUTTON, false);
    }

    public static boolean isSendToExternalDefaultHandlerEnabled(@NonNull Intent intent) {
        return intent.getBooleanExtra(EXTRA_SEND_TO_EXTERNAL_DEFAULT_HANDLER, false);
    }

    @NonNull
    public static Intent setAlwaysUseBrowserUI(@Nullable Intent intent) {
        if (intent == null) {
            intent = new Intent("android.intent.action.VIEW");
        }
        intent.addFlags(268435456);
        intent.putExtra(EXTRA_USER_OPT_OUT_FROM_CUSTOM_TABS, true);
        return intent;
    }

    public static boolean shouldAlwaysUseBrowserUI(@NonNull Intent intent) {
        return intent.getBooleanExtra(EXTRA_USER_OPT_OUT_FROM_CUSTOM_TABS, false) && (intent.getFlags() & 268435456) != 0;
    }

    public void launchUrl(@NonNull Context context, @NonNull Uri uri) {
        this.intent.setData(uri);
        ContextCompat.startActivity(context, this.intent, this.startAnimationBundle);
    }
}
