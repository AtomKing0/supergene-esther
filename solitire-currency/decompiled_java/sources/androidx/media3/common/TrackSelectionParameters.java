package androidx.media3.common;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Looper;
import android.view.accessibility.CaptioningManager;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.Bundleable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.BundleCollectionUtil;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.trackselection.AdaptiveTrackSelection;
import com.google.common.collect.y;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class TrackSelectionParameters implements Bundleable {

    @UnstableApi
    @Deprecated
    public static final Bundleable.Creator<TrackSelectionParameters> CREATOR;

    @UnstableApi
    @Deprecated
    public static final TrackSelectionParameters DEFAULT;

    @UnstableApi
    public static final TrackSelectionParameters DEFAULT_WITHOUT_CONTEXT;
    private static final String FIELD_AUDIO_OFFLOAD_MODE_PREFERENCE;
    private static final String FIELD_AUDIO_OFFLOAD_PREFERENCES;

    @UnstableApi
    protected static final int FIELD_CUSTOM_ID_BASE = 1000;
    private static final String FIELD_DISABLED_TRACK_TYPE;
    private static final String FIELD_FORCE_HIGHEST_SUPPORTED_BITRATE;
    private static final String FIELD_FORCE_LOWEST_BITRATE;
    private static final String FIELD_IGNORED_TEXT_SELECTION_FLAGS;
    private static final String FIELD_IS_GAPLESS_SUPPORT_REQUIRED;
    private static final String FIELD_IS_PREFER_IMAGE_OVER_VIDEO_ENABLED;
    private static final String FIELD_IS_SPEED_CHANGE_SUPPORT_REQUIRED;
    private static final String FIELD_MAX_AUDIO_BITRATE;
    private static final String FIELD_MAX_AUDIO_CHANNEL_COUNT;
    private static final String FIELD_MAX_VIDEO_BITRATE;
    private static final String FIELD_MAX_VIDEO_FRAMERATE;
    private static final String FIELD_MAX_VIDEO_HEIGHT;
    private static final String FIELD_MAX_VIDEO_WIDTH;
    private static final String FIELD_MIN_VIDEO_BITRATE;
    private static final String FIELD_MIN_VIDEO_FRAMERATE;
    private static final String FIELD_MIN_VIDEO_HEIGHT;
    private static final String FIELD_MIN_VIDEO_WIDTH;
    private static final String FIELD_PREFERRED_AUDIO_LANGUAGES;
    private static final String FIELD_PREFERRED_AUDIO_MIME_TYPES;
    private static final String FIELD_PREFERRED_AUDIO_ROLE_FLAGS;
    private static final String FIELD_PREFERRED_TEXT_LANGUAGES;
    private static final String FIELD_PREFERRED_TEXT_ROLE_FLAGS;
    private static final String FIELD_PREFERRED_VIDEO_MIMETYPES;
    private static final String FIELD_PREFERRED_VIDEO_ROLE_FLAGS;
    private static final String FIELD_SELECTION_OVERRIDES;
    private static final String FIELD_SELECT_UNDETERMINED_TEXT_LANGUAGE;
    private static final String FIELD_VIEWPORT_HEIGHT;
    private static final String FIELD_VIEWPORT_ORIENTATION_MAY_CHANGE;
    private static final String FIELD_VIEWPORT_WIDTH;

    @UnstableApi
    public final AudioOffloadPreferences audioOffloadPreferences;
    public final com.google.common.collect.c0<Integer> disabledTrackTypes;
    public final boolean forceHighestSupportedBitrate;
    public final boolean forceLowestBitrate;
    public final int ignoredTextSelectionFlags;

    @UnstableApi
    public final boolean isPrioritizeImageOverVideoEnabled;
    public final int maxAudioBitrate;
    public final int maxAudioChannelCount;
    public final int maxVideoBitrate;
    public final int maxVideoFrameRate;
    public final int maxVideoHeight;
    public final int maxVideoWidth;
    public final int minVideoBitrate;
    public final int minVideoFrameRate;
    public final int minVideoHeight;
    public final int minVideoWidth;
    public final com.google.common.collect.a0<TrackGroup, TrackSelectionOverride> overrides;
    public final com.google.common.collect.y<String> preferredAudioLanguages;
    public final com.google.common.collect.y<String> preferredAudioMimeTypes;
    public final int preferredAudioRoleFlags;
    public final com.google.common.collect.y<String> preferredTextLanguages;
    public final int preferredTextRoleFlags;
    public final com.google.common.collect.y<String> preferredVideoMimeTypes;
    public final int preferredVideoRoleFlags;
    public final boolean selectUndeterminedTextLanguage;
    public final int viewportHeight;
    public final boolean viewportOrientationMayChange;
    public final int viewportWidth;

    @UnstableApi
    public static final class AudioOffloadPreferences implements Bundleable {
        public static final int AUDIO_OFFLOAD_MODE_DISABLED = 0;
        public static final int AUDIO_OFFLOAD_MODE_ENABLED = 1;
        public static final int AUDIO_OFFLOAD_MODE_REQUIRED = 2;
        public static final AudioOffloadPreferences DEFAULT = new Builder().build();
        private static final String FIELD_AUDIO_OFFLOAD_MODE_PREFERENCE = Util.intToStringMaxRadix(1);
        private static final String FIELD_IS_GAPLESS_SUPPORT_REQUIRED = Util.intToStringMaxRadix(2);
        private static final String FIELD_IS_SPEED_CHANGE_SUPPORT_REQUIRED = Util.intToStringMaxRadix(3);
        public final int audioOffloadMode;
        public final boolean isGaplessSupportRequired;
        public final boolean isSpeedChangeSupportRequired;

        @Target({ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface AudioOffloadMode {
        }

        public static final class Builder {
            private int audioOffloadMode = 0;
            private boolean isGaplessSupportRequired = false;
            private boolean isSpeedChangeSupportRequired = false;

            public AudioOffloadPreferences build() {
                return new AudioOffloadPreferences(this);
            }

            public Builder setAudioOffloadMode(int i10) {
                this.audioOffloadMode = i10;
                return this;
            }

            public Builder setIsGaplessSupportRequired(boolean z10) {
                this.isGaplessSupportRequired = z10;
                return this;
            }

            public Builder setIsSpeedChangeSupportRequired(boolean z10) {
                this.isSpeedChangeSupportRequired = z10;
                return this;
            }
        }

        public static AudioOffloadPreferences fromBundle(Bundle bundle) {
            Builder builder = new Builder();
            String str = FIELD_AUDIO_OFFLOAD_MODE_PREFERENCE;
            AudioOffloadPreferences audioOffloadPreferences = DEFAULT;
            return builder.setAudioOffloadMode(bundle.getInt(str, audioOffloadPreferences.audioOffloadMode)).setIsGaplessSupportRequired(bundle.getBoolean(FIELD_IS_GAPLESS_SUPPORT_REQUIRED, audioOffloadPreferences.isGaplessSupportRequired)).setIsSpeedChangeSupportRequired(bundle.getBoolean(FIELD_IS_SPEED_CHANGE_SUPPORT_REQUIRED, audioOffloadPreferences.isSpeedChangeSupportRequired)).build();
        }

        public Builder buildUpon() {
            return new Builder().setAudioOffloadMode(this.audioOffloadMode).setIsGaplessSupportRequired(this.isGaplessSupportRequired).setIsSpeedChangeSupportRequired(this.isSpeedChangeSupportRequired);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || AudioOffloadPreferences.class != obj.getClass()) {
                return false;
            }
            AudioOffloadPreferences audioOffloadPreferences = (AudioOffloadPreferences) obj;
            return this.audioOffloadMode == audioOffloadPreferences.audioOffloadMode && this.isGaplessSupportRequired == audioOffloadPreferences.isGaplessSupportRequired && this.isSpeedChangeSupportRequired == audioOffloadPreferences.isSpeedChangeSupportRequired;
        }

        public int hashCode() {
            return ((((this.audioOffloadMode + 31) * 31) + (this.isGaplessSupportRequired ? 1 : 0)) * 31) + (this.isSpeedChangeSupportRequired ? 1 : 0);
        }

        @Override // androidx.media3.common.Bundleable
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putInt(FIELD_AUDIO_OFFLOAD_MODE_PREFERENCE, this.audioOffloadMode);
            bundle.putBoolean(FIELD_IS_GAPLESS_SUPPORT_REQUIRED, this.isGaplessSupportRequired);
            bundle.putBoolean(FIELD_IS_SPEED_CHANGE_SUPPORT_REQUIRED, this.isSpeedChangeSupportRequired);
            return bundle;
        }

        private AudioOffloadPreferences(Builder builder) {
            this.audioOffloadMode = builder.audioOffloadMode;
            this.isGaplessSupportRequired = builder.isGaplessSupportRequired;
            this.isSpeedChangeSupportRequired = builder.isSpeedChangeSupportRequired;
        }
    }

    static {
        TrackSelectionParameters trackSelectionParametersBuild = new Builder().build();
        DEFAULT_WITHOUT_CONTEXT = trackSelectionParametersBuild;
        DEFAULT = trackSelectionParametersBuild;
        FIELD_PREFERRED_AUDIO_LANGUAGES = Util.intToStringMaxRadix(1);
        FIELD_PREFERRED_AUDIO_ROLE_FLAGS = Util.intToStringMaxRadix(2);
        FIELD_PREFERRED_TEXT_LANGUAGES = Util.intToStringMaxRadix(3);
        FIELD_PREFERRED_TEXT_ROLE_FLAGS = Util.intToStringMaxRadix(4);
        FIELD_SELECT_UNDETERMINED_TEXT_LANGUAGE = Util.intToStringMaxRadix(5);
        FIELD_MAX_VIDEO_WIDTH = Util.intToStringMaxRadix(6);
        FIELD_MAX_VIDEO_HEIGHT = Util.intToStringMaxRadix(7);
        FIELD_MAX_VIDEO_FRAMERATE = Util.intToStringMaxRadix(8);
        FIELD_MAX_VIDEO_BITRATE = Util.intToStringMaxRadix(9);
        FIELD_MIN_VIDEO_WIDTH = Util.intToStringMaxRadix(10);
        FIELD_MIN_VIDEO_HEIGHT = Util.intToStringMaxRadix(11);
        FIELD_MIN_VIDEO_FRAMERATE = Util.intToStringMaxRadix(12);
        FIELD_MIN_VIDEO_BITRATE = Util.intToStringMaxRadix(13);
        FIELD_VIEWPORT_WIDTH = Util.intToStringMaxRadix(14);
        FIELD_VIEWPORT_HEIGHT = Util.intToStringMaxRadix(15);
        FIELD_VIEWPORT_ORIENTATION_MAY_CHANGE = Util.intToStringMaxRadix(16);
        FIELD_PREFERRED_VIDEO_MIMETYPES = Util.intToStringMaxRadix(17);
        FIELD_MAX_AUDIO_CHANNEL_COUNT = Util.intToStringMaxRadix(18);
        FIELD_MAX_AUDIO_BITRATE = Util.intToStringMaxRadix(19);
        FIELD_PREFERRED_AUDIO_MIME_TYPES = Util.intToStringMaxRadix(20);
        FIELD_FORCE_LOWEST_BITRATE = Util.intToStringMaxRadix(21);
        FIELD_FORCE_HIGHEST_SUPPORTED_BITRATE = Util.intToStringMaxRadix(22);
        FIELD_SELECTION_OVERRIDES = Util.intToStringMaxRadix(23);
        FIELD_DISABLED_TRACK_TYPE = Util.intToStringMaxRadix(24);
        FIELD_PREFERRED_VIDEO_ROLE_FLAGS = Util.intToStringMaxRadix(25);
        FIELD_IGNORED_TEXT_SELECTION_FLAGS = Util.intToStringMaxRadix(26);
        FIELD_AUDIO_OFFLOAD_MODE_PREFERENCE = Util.intToStringMaxRadix(27);
        FIELD_IS_GAPLESS_SUPPORT_REQUIRED = Util.intToStringMaxRadix(28);
        FIELD_IS_SPEED_CHANGE_SUPPORT_REQUIRED = Util.intToStringMaxRadix(29);
        FIELD_AUDIO_OFFLOAD_PREFERENCES = Util.intToStringMaxRadix(30);
        FIELD_IS_PREFER_IMAGE_OVER_VIDEO_ENABLED = Util.intToStringMaxRadix(31);
        CREATOR = new Bundleable.Creator() { // from class: androidx.media3.common.k3
            @Override // androidx.media3.common.Bundleable.Creator
            public final Bundleable fromBundle(Bundle bundle) {
                return TrackSelectionParameters.fromBundle(bundle);
            }
        };
    }

    @UnstableApi
    protected TrackSelectionParameters(Builder builder) {
        this.maxVideoWidth = builder.maxVideoWidth;
        this.maxVideoHeight = builder.maxVideoHeight;
        this.maxVideoFrameRate = builder.maxVideoFrameRate;
        this.maxVideoBitrate = builder.maxVideoBitrate;
        this.minVideoWidth = builder.minVideoWidth;
        this.minVideoHeight = builder.minVideoHeight;
        this.minVideoFrameRate = builder.minVideoFrameRate;
        this.minVideoBitrate = builder.minVideoBitrate;
        this.viewportWidth = builder.viewportWidth;
        this.viewportHeight = builder.viewportHeight;
        this.viewportOrientationMayChange = builder.viewportOrientationMayChange;
        this.preferredVideoMimeTypes = builder.preferredVideoMimeTypes;
        this.preferredVideoRoleFlags = builder.preferredVideoRoleFlags;
        this.preferredAudioLanguages = builder.preferredAudioLanguages;
        this.preferredAudioRoleFlags = builder.preferredAudioRoleFlags;
        this.maxAudioChannelCount = builder.maxAudioChannelCount;
        this.maxAudioBitrate = builder.maxAudioBitrate;
        this.preferredAudioMimeTypes = builder.preferredAudioMimeTypes;
        this.audioOffloadPreferences = builder.audioOffloadPreferences;
        this.preferredTextLanguages = builder.preferredTextLanguages;
        this.preferredTextRoleFlags = builder.preferredTextRoleFlags;
        this.ignoredTextSelectionFlags = builder.ignoredTextSelectionFlags;
        this.selectUndeterminedTextLanguage = builder.selectUndeterminedTextLanguage;
        this.isPrioritizeImageOverVideoEnabled = builder.isPrioritizeImageOverVideoEnabled;
        this.forceLowestBitrate = builder.forceLowestBitrate;
        this.forceHighestSupportedBitrate = builder.forceHighestSupportedBitrate;
        this.overrides = com.google.common.collect.a0.c(builder.overrides);
        this.disabledTrackTypes = com.google.common.collect.c0.m(builder.disabledTrackTypes);
    }

    public static TrackSelectionParameters fromBundle(Bundle bundle) {
        return new Builder(bundle).build();
    }

    public static TrackSelectionParameters getDefaults(Context context) {
        return new Builder(context).build();
    }

    public Builder buildUpon() {
        return new Builder(this);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TrackSelectionParameters trackSelectionParameters = (TrackSelectionParameters) obj;
        return this.maxVideoWidth == trackSelectionParameters.maxVideoWidth && this.maxVideoHeight == trackSelectionParameters.maxVideoHeight && this.maxVideoFrameRate == trackSelectionParameters.maxVideoFrameRate && this.maxVideoBitrate == trackSelectionParameters.maxVideoBitrate && this.minVideoWidth == trackSelectionParameters.minVideoWidth && this.minVideoHeight == trackSelectionParameters.minVideoHeight && this.minVideoFrameRate == trackSelectionParameters.minVideoFrameRate && this.minVideoBitrate == trackSelectionParameters.minVideoBitrate && this.viewportOrientationMayChange == trackSelectionParameters.viewportOrientationMayChange && this.viewportWidth == trackSelectionParameters.viewportWidth && this.viewportHeight == trackSelectionParameters.viewportHeight && this.preferredVideoMimeTypes.equals(trackSelectionParameters.preferredVideoMimeTypes) && this.preferredVideoRoleFlags == trackSelectionParameters.preferredVideoRoleFlags && this.preferredAudioLanguages.equals(trackSelectionParameters.preferredAudioLanguages) && this.preferredAudioRoleFlags == trackSelectionParameters.preferredAudioRoleFlags && this.maxAudioChannelCount == trackSelectionParameters.maxAudioChannelCount && this.maxAudioBitrate == trackSelectionParameters.maxAudioBitrate && this.preferredAudioMimeTypes.equals(trackSelectionParameters.preferredAudioMimeTypes) && this.audioOffloadPreferences.equals(trackSelectionParameters.audioOffloadPreferences) && this.preferredTextLanguages.equals(trackSelectionParameters.preferredTextLanguages) && this.preferredTextRoleFlags == trackSelectionParameters.preferredTextRoleFlags && this.ignoredTextSelectionFlags == trackSelectionParameters.ignoredTextSelectionFlags && this.selectUndeterminedTextLanguage == trackSelectionParameters.selectUndeterminedTextLanguage && this.isPrioritizeImageOverVideoEnabled == trackSelectionParameters.isPrioritizeImageOverVideoEnabled && this.forceLowestBitrate == trackSelectionParameters.forceLowestBitrate && this.forceHighestSupportedBitrate == trackSelectionParameters.forceHighestSupportedBitrate && this.overrides.equals(trackSelectionParameters.overrides) && this.disabledTrackTypes.equals(trackSelectionParameters.disabledTrackTypes);
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((((((((((((((((((this.maxVideoWidth + 31) * 31) + this.maxVideoHeight) * 31) + this.maxVideoFrameRate) * 31) + this.maxVideoBitrate) * 31) + this.minVideoWidth) * 31) + this.minVideoHeight) * 31) + this.minVideoFrameRate) * 31) + this.minVideoBitrate) * 31) + (this.viewportOrientationMayChange ? 1 : 0)) * 31) + this.viewportWidth) * 31) + this.viewportHeight) * 31) + this.preferredVideoMimeTypes.hashCode()) * 31) + this.preferredVideoRoleFlags) * 31) + this.preferredAudioLanguages.hashCode()) * 31) + this.preferredAudioRoleFlags) * 31) + this.maxAudioChannelCount) * 31) + this.maxAudioBitrate) * 31) + this.preferredAudioMimeTypes.hashCode()) * 31) + this.audioOffloadPreferences.hashCode()) * 31) + this.preferredTextLanguages.hashCode()) * 31) + this.preferredTextRoleFlags) * 31) + this.ignoredTextSelectionFlags) * 31) + (this.selectUndeterminedTextLanguage ? 1 : 0)) * 31) + (this.isPrioritizeImageOverVideoEnabled ? 1 : 0)) * 31) + (this.forceLowestBitrate ? 1 : 0)) * 31) + (this.forceHighestSupportedBitrate ? 1 : 0)) * 31) + this.overrides.hashCode()) * 31) + this.disabledTrackTypes.hashCode();
    }

    @Override // androidx.media3.common.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(FIELD_MAX_VIDEO_WIDTH, this.maxVideoWidth);
        bundle.putInt(FIELD_MAX_VIDEO_HEIGHT, this.maxVideoHeight);
        bundle.putInt(FIELD_MAX_VIDEO_FRAMERATE, this.maxVideoFrameRate);
        bundle.putInt(FIELD_MAX_VIDEO_BITRATE, this.maxVideoBitrate);
        bundle.putInt(FIELD_MIN_VIDEO_WIDTH, this.minVideoWidth);
        bundle.putInt(FIELD_MIN_VIDEO_HEIGHT, this.minVideoHeight);
        bundle.putInt(FIELD_MIN_VIDEO_FRAMERATE, this.minVideoFrameRate);
        bundle.putInt(FIELD_MIN_VIDEO_BITRATE, this.minVideoBitrate);
        bundle.putInt(FIELD_VIEWPORT_WIDTH, this.viewportWidth);
        bundle.putInt(FIELD_VIEWPORT_HEIGHT, this.viewportHeight);
        bundle.putBoolean(FIELD_VIEWPORT_ORIENTATION_MAY_CHANGE, this.viewportOrientationMayChange);
        bundle.putStringArray(FIELD_PREFERRED_VIDEO_MIMETYPES, (String[]) this.preferredVideoMimeTypes.toArray(new String[0]));
        bundle.putInt(FIELD_PREFERRED_VIDEO_ROLE_FLAGS, this.preferredVideoRoleFlags);
        bundle.putStringArray(FIELD_PREFERRED_AUDIO_LANGUAGES, (String[]) this.preferredAudioLanguages.toArray(new String[0]));
        bundle.putInt(FIELD_PREFERRED_AUDIO_ROLE_FLAGS, this.preferredAudioRoleFlags);
        bundle.putInt(FIELD_MAX_AUDIO_CHANNEL_COUNT, this.maxAudioChannelCount);
        bundle.putInt(FIELD_MAX_AUDIO_BITRATE, this.maxAudioBitrate);
        bundle.putStringArray(FIELD_PREFERRED_AUDIO_MIME_TYPES, (String[]) this.preferredAudioMimeTypes.toArray(new String[0]));
        bundle.putStringArray(FIELD_PREFERRED_TEXT_LANGUAGES, (String[]) this.preferredTextLanguages.toArray(new String[0]));
        bundle.putInt(FIELD_PREFERRED_TEXT_ROLE_FLAGS, this.preferredTextRoleFlags);
        bundle.putInt(FIELD_IGNORED_TEXT_SELECTION_FLAGS, this.ignoredTextSelectionFlags);
        bundle.putBoolean(FIELD_SELECT_UNDETERMINED_TEXT_LANGUAGE, this.selectUndeterminedTextLanguage);
        bundle.putInt(FIELD_AUDIO_OFFLOAD_MODE_PREFERENCE, this.audioOffloadPreferences.audioOffloadMode);
        bundle.putBoolean(FIELD_IS_GAPLESS_SUPPORT_REQUIRED, this.audioOffloadPreferences.isGaplessSupportRequired);
        bundle.putBoolean(FIELD_IS_SPEED_CHANGE_SUPPORT_REQUIRED, this.audioOffloadPreferences.isSpeedChangeSupportRequired);
        bundle.putBundle(FIELD_AUDIO_OFFLOAD_PREFERENCES, this.audioOffloadPreferences.toBundle());
        bundle.putBoolean(FIELD_IS_PREFER_IMAGE_OVER_VIDEO_ENABLED, this.isPrioritizeImageOverVideoEnabled);
        bundle.putBoolean(FIELD_FORCE_LOWEST_BITRATE, this.forceLowestBitrate);
        bundle.putBoolean(FIELD_FORCE_HIGHEST_SUPPORTED_BITRATE, this.forceHighestSupportedBitrate);
        bundle.putParcelableArrayList(FIELD_SELECTION_OVERRIDES, BundleCollectionUtil.toBundleArrayList(this.overrides.values(), new e5.g() { // from class: androidx.media3.common.j3
            @Override // e5.g
            public final Object apply(Object obj) {
                return ((TrackSelectionOverride) obj).toBundle();
            }
        }));
        bundle.putIntArray(FIELD_DISABLED_TRACK_TYPE, g5.e.k(this.disabledTrackTypes));
        return bundle;
    }

    public static class Builder {
        private AudioOffloadPreferences audioOffloadPreferences;
        private HashSet<Integer> disabledTrackTypes;
        private boolean forceHighestSupportedBitrate;
        private boolean forceLowestBitrate;
        private int ignoredTextSelectionFlags;
        private boolean isPrioritizeImageOverVideoEnabled;
        private int maxAudioBitrate;
        private int maxAudioChannelCount;
        private int maxVideoBitrate;
        private int maxVideoFrameRate;
        private int maxVideoHeight;
        private int maxVideoWidth;
        private int minVideoBitrate;
        private int minVideoFrameRate;
        private int minVideoHeight;
        private int minVideoWidth;
        private HashMap<TrackGroup, TrackSelectionOverride> overrides;
        private com.google.common.collect.y<String> preferredAudioLanguages;
        private com.google.common.collect.y<String> preferredAudioMimeTypes;
        private int preferredAudioRoleFlags;
        private com.google.common.collect.y<String> preferredTextLanguages;
        private int preferredTextRoleFlags;
        private com.google.common.collect.y<String> preferredVideoMimeTypes;
        private int preferredVideoRoleFlags;
        private boolean selectUndeterminedTextLanguage;
        private int viewportHeight;
        private boolean viewportOrientationMayChange;
        private int viewportWidth;

        @UnstableApi
        @Deprecated
        public Builder() {
            this.maxVideoWidth = Integer.MAX_VALUE;
            this.maxVideoHeight = Integer.MAX_VALUE;
            this.maxVideoFrameRate = Integer.MAX_VALUE;
            this.maxVideoBitrate = Integer.MAX_VALUE;
            this.viewportWidth = Integer.MAX_VALUE;
            this.viewportHeight = Integer.MAX_VALUE;
            this.viewportOrientationMayChange = true;
            this.preferredVideoMimeTypes = com.google.common.collect.y.q();
            this.preferredVideoRoleFlags = 0;
            this.preferredAudioLanguages = com.google.common.collect.y.q();
            this.preferredAudioRoleFlags = 0;
            this.maxAudioChannelCount = Integer.MAX_VALUE;
            this.maxAudioBitrate = Integer.MAX_VALUE;
            this.preferredAudioMimeTypes = com.google.common.collect.y.q();
            this.audioOffloadPreferences = AudioOffloadPreferences.DEFAULT;
            this.preferredTextLanguages = com.google.common.collect.y.q();
            this.preferredTextRoleFlags = 0;
            this.ignoredTextSelectionFlags = 0;
            this.selectUndeterminedTextLanguage = false;
            this.isPrioritizeImageOverVideoEnabled = false;
            this.forceLowestBitrate = false;
            this.forceHighestSupportedBitrate = false;
            this.overrides = new HashMap<>();
            this.disabledTrackTypes = new HashSet<>();
        }

        private static AudioOffloadPreferences getAudioOffloadPreferencesFromBundle(Bundle bundle) {
            Bundle bundle2 = bundle.getBundle(TrackSelectionParameters.FIELD_AUDIO_OFFLOAD_PREFERENCES);
            if (bundle2 != null) {
                return AudioOffloadPreferences.fromBundle(bundle2);
            }
            AudioOffloadPreferences.Builder builder = new AudioOffloadPreferences.Builder();
            String str = TrackSelectionParameters.FIELD_AUDIO_OFFLOAD_MODE_PREFERENCE;
            AudioOffloadPreferences audioOffloadPreferences = AudioOffloadPreferences.DEFAULT;
            return builder.setAudioOffloadMode(bundle.getInt(str, audioOffloadPreferences.audioOffloadMode)).setIsGaplessSupportRequired(bundle.getBoolean(TrackSelectionParameters.FIELD_IS_GAPLESS_SUPPORT_REQUIRED, audioOffloadPreferences.isGaplessSupportRequired)).setIsSpeedChangeSupportRequired(bundle.getBoolean(TrackSelectionParameters.FIELD_IS_SPEED_CHANGE_SUPPORT_REQUIRED, audioOffloadPreferences.isSpeedChangeSupportRequired)).build();
        }

        private void init(TrackSelectionParameters trackSelectionParameters) {
            this.maxVideoWidth = trackSelectionParameters.maxVideoWidth;
            this.maxVideoHeight = trackSelectionParameters.maxVideoHeight;
            this.maxVideoFrameRate = trackSelectionParameters.maxVideoFrameRate;
            this.maxVideoBitrate = trackSelectionParameters.maxVideoBitrate;
            this.minVideoWidth = trackSelectionParameters.minVideoWidth;
            this.minVideoHeight = trackSelectionParameters.minVideoHeight;
            this.minVideoFrameRate = trackSelectionParameters.minVideoFrameRate;
            this.minVideoBitrate = trackSelectionParameters.minVideoBitrate;
            this.viewportWidth = trackSelectionParameters.viewportWidth;
            this.viewportHeight = trackSelectionParameters.viewportHeight;
            this.viewportOrientationMayChange = trackSelectionParameters.viewportOrientationMayChange;
            this.preferredVideoMimeTypes = trackSelectionParameters.preferredVideoMimeTypes;
            this.preferredVideoRoleFlags = trackSelectionParameters.preferredVideoRoleFlags;
            this.preferredAudioLanguages = trackSelectionParameters.preferredAudioLanguages;
            this.preferredAudioRoleFlags = trackSelectionParameters.preferredAudioRoleFlags;
            this.maxAudioChannelCount = trackSelectionParameters.maxAudioChannelCount;
            this.maxAudioBitrate = trackSelectionParameters.maxAudioBitrate;
            this.preferredAudioMimeTypes = trackSelectionParameters.preferredAudioMimeTypes;
            this.audioOffloadPreferences = trackSelectionParameters.audioOffloadPreferences;
            this.preferredTextLanguages = trackSelectionParameters.preferredTextLanguages;
            this.preferredTextRoleFlags = trackSelectionParameters.preferredTextRoleFlags;
            this.ignoredTextSelectionFlags = trackSelectionParameters.ignoredTextSelectionFlags;
            this.selectUndeterminedTextLanguage = trackSelectionParameters.selectUndeterminedTextLanguage;
            this.isPrioritizeImageOverVideoEnabled = trackSelectionParameters.isPrioritizeImageOverVideoEnabled;
            this.forceLowestBitrate = trackSelectionParameters.forceLowestBitrate;
            this.forceHighestSupportedBitrate = trackSelectionParameters.forceHighestSupportedBitrate;
            this.disabledTrackTypes = new HashSet<>(trackSelectionParameters.disabledTrackTypes);
            this.overrides = new HashMap<>(trackSelectionParameters.overrides);
        }

        private static com.google.common.collect.y<String> normalizeLanguageCodes(String[] strArr) {
            y.a aVarK = com.google.common.collect.y.k();
            for (String str : (String[]) Assertions.checkNotNull(strArr)) {
                aVarK.a(Util.normalizeLanguageCode((String) Assertions.checkNotNull(str)));
            }
            return aVarK.k();
        }

        @RequiresApi(19)
        private void setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettingsV19(Context context) {
            CaptioningManager captioningManager;
            if ((Util.SDK_INT >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled()) {
                this.preferredTextRoleFlags = 1088;
                Locale locale = captioningManager.getLocale();
                if (locale != null) {
                    this.preferredTextLanguages = com.google.common.collect.y.r(Util.getLocaleLanguageTag(locale));
                }
            }
        }

        public Builder addOverride(TrackSelectionOverride trackSelectionOverride) {
            this.overrides.put(trackSelectionOverride.mediaTrackGroup, trackSelectionOverride);
            return this;
        }

        public TrackSelectionParameters build() {
            return new TrackSelectionParameters(this);
        }

        public Builder clearOverride(TrackGroup trackGroup) {
            this.overrides.remove(trackGroup);
            return this;
        }

        public Builder clearOverrides() {
            this.overrides.clear();
            return this;
        }

        public Builder clearOverridesOfType(int i10) {
            Iterator<TrackSelectionOverride> it = this.overrides.values().iterator();
            while (it.hasNext()) {
                if (it.next().getType() == i10) {
                    it.remove();
                }
            }
            return this;
        }

        public Builder clearVideoSizeConstraints() {
            return setMaxVideoSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }

        public Builder clearViewportSizeConstraints() {
            return setViewportSize(Integer.MAX_VALUE, Integer.MAX_VALUE, true);
        }

        @UnstableApi
        protected Builder set(TrackSelectionParameters trackSelectionParameters) {
            init(trackSelectionParameters);
            return this;
        }

        @UnstableApi
        public Builder setAudioOffloadPreferences(AudioOffloadPreferences audioOffloadPreferences) {
            this.audioOffloadPreferences = audioOffloadPreferences;
            return this;
        }

        @UnstableApi
        @Deprecated
        public Builder setDisabledTrackTypes(Set<Integer> set) {
            this.disabledTrackTypes.clear();
            this.disabledTrackTypes.addAll(set);
            return this;
        }

        public Builder setForceHighestSupportedBitrate(boolean z10) {
            this.forceHighestSupportedBitrate = z10;
            return this;
        }

        public Builder setForceLowestBitrate(boolean z10) {
            this.forceLowestBitrate = z10;
            return this;
        }

        public Builder setIgnoredTextSelectionFlags(int i10) {
            this.ignoredTextSelectionFlags = i10;
            return this;
        }

        public Builder setMaxAudioBitrate(int i10) {
            this.maxAudioBitrate = i10;
            return this;
        }

        public Builder setMaxAudioChannelCount(int i10) {
            this.maxAudioChannelCount = i10;
            return this;
        }

        public Builder setMaxVideoBitrate(int i10) {
            this.maxVideoBitrate = i10;
            return this;
        }

        public Builder setMaxVideoFrameRate(int i10) {
            this.maxVideoFrameRate = i10;
            return this;
        }

        public Builder setMaxVideoSize(int i10, int i11) {
            this.maxVideoWidth = i10;
            this.maxVideoHeight = i11;
            return this;
        }

        public Builder setMaxVideoSizeSd() {
            return setMaxVideoSize(AdaptiveTrackSelection.DEFAULT_MAX_WIDTH_TO_DISCARD, AdaptiveTrackSelection.DEFAULT_MAX_HEIGHT_TO_DISCARD);
        }

        public Builder setMinVideoBitrate(int i10) {
            this.minVideoBitrate = i10;
            return this;
        }

        public Builder setMinVideoFrameRate(int i10) {
            this.minVideoFrameRate = i10;
            return this;
        }

        public Builder setMinVideoSize(int i10, int i11) {
            this.minVideoWidth = i10;
            this.minVideoHeight = i11;
            return this;
        }

        public Builder setOverrideForType(TrackSelectionOverride trackSelectionOverride) {
            clearOverridesOfType(trackSelectionOverride.getType());
            this.overrides.put(trackSelectionOverride.mediaTrackGroup, trackSelectionOverride);
            return this;
        }

        public Builder setPreferredAudioLanguage(@Nullable String str) {
            return str == null ? setPreferredAudioLanguages(new String[0]) : setPreferredAudioLanguages(str);
        }

        public Builder setPreferredAudioLanguages(String... strArr) {
            this.preferredAudioLanguages = normalizeLanguageCodes(strArr);
            return this;
        }

        public Builder setPreferredAudioMimeType(@Nullable String str) {
            return str == null ? setPreferredAudioMimeTypes(new String[0]) : setPreferredAudioMimeTypes(str);
        }

        public Builder setPreferredAudioMimeTypes(String... strArr) {
            this.preferredAudioMimeTypes = com.google.common.collect.y.n(strArr);
            return this;
        }

        public Builder setPreferredAudioRoleFlags(int i10) {
            this.preferredAudioRoleFlags = i10;
            return this;
        }

        public Builder setPreferredTextLanguage(@Nullable String str) {
            return str == null ? setPreferredTextLanguages(new String[0]) : setPreferredTextLanguages(str);
        }

        public Builder setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(Context context) {
            if (Util.SDK_INT >= 19) {
                setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettingsV19(context);
            }
            return this;
        }

        public Builder setPreferredTextLanguages(String... strArr) {
            this.preferredTextLanguages = normalizeLanguageCodes(strArr);
            return this;
        }

        public Builder setPreferredTextRoleFlags(int i10) {
            this.preferredTextRoleFlags = i10;
            return this;
        }

        public Builder setPreferredVideoMimeType(@Nullable String str) {
            return str == null ? setPreferredVideoMimeTypes(new String[0]) : setPreferredVideoMimeTypes(str);
        }

        public Builder setPreferredVideoMimeTypes(String... strArr) {
            this.preferredVideoMimeTypes = com.google.common.collect.y.n(strArr);
            return this;
        }

        public Builder setPreferredVideoRoleFlags(int i10) {
            this.preferredVideoRoleFlags = i10;
            return this;
        }

        @UnstableApi
        public Builder setPrioritizeImageOverVideoEnabled(boolean z10) {
            this.isPrioritizeImageOverVideoEnabled = z10;
            return this;
        }

        public Builder setSelectUndeterminedTextLanguage(boolean z10) {
            this.selectUndeterminedTextLanguage = z10;
            return this;
        }

        public Builder setTrackTypeDisabled(int i10, boolean z10) {
            if (z10) {
                this.disabledTrackTypes.add(Integer.valueOf(i10));
            } else {
                this.disabledTrackTypes.remove(Integer.valueOf(i10));
            }
            return this;
        }

        public Builder setViewportSize(int i10, int i11, boolean z10) {
            this.viewportWidth = i10;
            this.viewportHeight = i11;
            this.viewportOrientationMayChange = z10;
            return this;
        }

        public Builder setViewportSizeToPhysicalDisplaySize(Context context, boolean z10) {
            Point currentDisplayModeSize = Util.getCurrentDisplayModeSize(context);
            return setViewportSize(currentDisplayModeSize.x, currentDisplayModeSize.y, z10);
        }

        public Builder(Context context) {
            this();
            setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(context);
            setViewportSizeToPhysicalDisplaySize(context, true);
        }

        @UnstableApi
        protected Builder(TrackSelectionParameters trackSelectionParameters) {
            init(trackSelectionParameters);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @UnstableApi
        protected Builder(Bundle bundle) {
            com.google.common.collect.y yVarFromBundleList;
            String str = TrackSelectionParameters.FIELD_MAX_VIDEO_WIDTH;
            TrackSelectionParameters trackSelectionParameters = TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT;
            this.maxVideoWidth = bundle.getInt(str, trackSelectionParameters.maxVideoWidth);
            this.maxVideoHeight = bundle.getInt(TrackSelectionParameters.FIELD_MAX_VIDEO_HEIGHT, trackSelectionParameters.maxVideoHeight);
            this.maxVideoFrameRate = bundle.getInt(TrackSelectionParameters.FIELD_MAX_VIDEO_FRAMERATE, trackSelectionParameters.maxVideoFrameRate);
            this.maxVideoBitrate = bundle.getInt(TrackSelectionParameters.FIELD_MAX_VIDEO_BITRATE, trackSelectionParameters.maxVideoBitrate);
            this.minVideoWidth = bundle.getInt(TrackSelectionParameters.FIELD_MIN_VIDEO_WIDTH, trackSelectionParameters.minVideoWidth);
            this.minVideoHeight = bundle.getInt(TrackSelectionParameters.FIELD_MIN_VIDEO_HEIGHT, trackSelectionParameters.minVideoHeight);
            this.minVideoFrameRate = bundle.getInt(TrackSelectionParameters.FIELD_MIN_VIDEO_FRAMERATE, trackSelectionParameters.minVideoFrameRate);
            this.minVideoBitrate = bundle.getInt(TrackSelectionParameters.FIELD_MIN_VIDEO_BITRATE, trackSelectionParameters.minVideoBitrate);
            this.viewportWidth = bundle.getInt(TrackSelectionParameters.FIELD_VIEWPORT_WIDTH, trackSelectionParameters.viewportWidth);
            this.viewportHeight = bundle.getInt(TrackSelectionParameters.FIELD_VIEWPORT_HEIGHT, trackSelectionParameters.viewportHeight);
            this.viewportOrientationMayChange = bundle.getBoolean(TrackSelectionParameters.FIELD_VIEWPORT_ORIENTATION_MAY_CHANGE, trackSelectionParameters.viewportOrientationMayChange);
            this.preferredVideoMimeTypes = com.google.common.collect.y.n((String[]) e5.i.a(bundle.getStringArray(TrackSelectionParameters.FIELD_PREFERRED_VIDEO_MIMETYPES), new String[0]));
            this.preferredVideoRoleFlags = bundle.getInt(TrackSelectionParameters.FIELD_PREFERRED_VIDEO_ROLE_FLAGS, trackSelectionParameters.preferredVideoRoleFlags);
            this.preferredAudioLanguages = normalizeLanguageCodes((String[]) e5.i.a(bundle.getStringArray(TrackSelectionParameters.FIELD_PREFERRED_AUDIO_LANGUAGES), new String[0]));
            this.preferredAudioRoleFlags = bundle.getInt(TrackSelectionParameters.FIELD_PREFERRED_AUDIO_ROLE_FLAGS, trackSelectionParameters.preferredAudioRoleFlags);
            this.maxAudioChannelCount = bundle.getInt(TrackSelectionParameters.FIELD_MAX_AUDIO_CHANNEL_COUNT, trackSelectionParameters.maxAudioChannelCount);
            this.maxAudioBitrate = bundle.getInt(TrackSelectionParameters.FIELD_MAX_AUDIO_BITRATE, trackSelectionParameters.maxAudioBitrate);
            this.preferredAudioMimeTypes = com.google.common.collect.y.n((String[]) e5.i.a(bundle.getStringArray(TrackSelectionParameters.FIELD_PREFERRED_AUDIO_MIME_TYPES), new String[0]));
            this.audioOffloadPreferences = getAudioOffloadPreferencesFromBundle(bundle);
            this.preferredTextLanguages = normalizeLanguageCodes((String[]) e5.i.a(bundle.getStringArray(TrackSelectionParameters.FIELD_PREFERRED_TEXT_LANGUAGES), new String[0]));
            this.preferredTextRoleFlags = bundle.getInt(TrackSelectionParameters.FIELD_PREFERRED_TEXT_ROLE_FLAGS, trackSelectionParameters.preferredTextRoleFlags);
            this.ignoredTextSelectionFlags = bundle.getInt(TrackSelectionParameters.FIELD_IGNORED_TEXT_SELECTION_FLAGS, trackSelectionParameters.ignoredTextSelectionFlags);
            this.selectUndeterminedTextLanguage = bundle.getBoolean(TrackSelectionParameters.FIELD_SELECT_UNDETERMINED_TEXT_LANGUAGE, trackSelectionParameters.selectUndeterminedTextLanguage);
            this.isPrioritizeImageOverVideoEnabled = bundle.getBoolean(TrackSelectionParameters.FIELD_IS_PREFER_IMAGE_OVER_VIDEO_ENABLED, trackSelectionParameters.isPrioritizeImageOverVideoEnabled);
            this.forceLowestBitrate = bundle.getBoolean(TrackSelectionParameters.FIELD_FORCE_LOWEST_BITRATE, trackSelectionParameters.forceLowestBitrate);
            this.forceHighestSupportedBitrate = bundle.getBoolean(TrackSelectionParameters.FIELD_FORCE_HIGHEST_SUPPORTED_BITRATE, trackSelectionParameters.forceHighestSupportedBitrate);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(TrackSelectionParameters.FIELD_SELECTION_OVERRIDES);
            if (parcelableArrayList == null) {
                yVarFromBundleList = com.google.common.collect.y.q();
            } else {
                yVarFromBundleList = BundleCollectionUtil.fromBundleList(new e5.g() { // from class: androidx.media3.common.l3
                    @Override // e5.g
                    public final Object apply(Object obj) {
                        return TrackSelectionOverride.fromBundle((Bundle) obj);
                    }
                }, parcelableArrayList);
            }
            this.overrides = new HashMap<>();
            for (int i10 = 0; i10 < yVarFromBundleList.size(); i10++) {
                TrackSelectionOverride trackSelectionOverride = (TrackSelectionOverride) yVarFromBundleList.get(i10);
                this.overrides.put(trackSelectionOverride.mediaTrackGroup, trackSelectionOverride);
            }
            int[] iArr = (int[]) e5.i.a(bundle.getIntArray(TrackSelectionParameters.FIELD_DISABLED_TRACK_TYPE), new int[0]);
            this.disabledTrackTypes = new HashSet<>();
            for (int i11 : iArr) {
                this.disabledTrackTypes.add(Integer.valueOf(i11));
            }
        }
    }
}
