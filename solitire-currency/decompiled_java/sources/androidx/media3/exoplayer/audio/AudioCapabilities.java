package androidx.media3.exoplayer.audio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.net.Uri;
import android.provider.Settings;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.collect.a0;
import com.google.common.collect.c0;
import com.google.common.collect.i1;
import com.google.common.collect.y;
import com.ironsource.v8;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@UnstableApi
public final class AudioCapabilities {

    @VisibleForTesting
    static final int DEFAULT_MAX_CHANNEL_COUNT = 10;

    @VisibleForTesting
    static final int DEFAULT_SAMPLE_RATE_HZ = 48000;
    private static final String EXTERNAL_SURROUND_SOUND_KEY = "external_surround_sound_enabled";
    private final SparseArray<AudioProfile> encodingToAudioProfile;
    private final int maxChannelCount;
    public static final AudioCapabilities DEFAULT_AUDIO_CAPABILITIES = new AudioCapabilities(com.google.common.collect.y.r(AudioProfile.DEFAULT_AUDIO_PROFILE));

    @SuppressLint({"InlinedApi"})
    private static final com.google.common.collect.y<Integer> EXTERNAL_SURROUND_SOUND_ENCODINGS = com.google.common.collect.y.t(2, 5, 6);

    @VisibleForTesting
    static final com.google.common.collect.a0<Integer, Integer> ALL_SURROUND_ENCODINGS_AND_MAX_CHANNELS = new a0.a().f(5, 6).f(17, 6).f(7, 6).f(30, 10).f(18, 6).f(6, 8).f(8, 8).f(14, 8).c();

    @RequiresApi(23)
    private static final class Api23 {
        private Api23() {
        }

        @DoNotInline
        private static com.google.common.collect.c0<Integer> getAllBluetoothDeviceTypes() {
            c0.a aVarI = new c0.a().i(8, 7);
            int i10 = Util.SDK_INT;
            if (i10 >= 31) {
                aVarI.i(26, 27);
            }
            if (i10 >= 33) {
                aVarI.a(30);
            }
            return aVarI.l();
        }

        @DoNotInline
        public static boolean isBluetoothConnected(AudioManager audioManager, @Nullable AudioDeviceInfoApi23 audioDeviceInfoApi23) {
            AudioDeviceInfo[] devices = audioDeviceInfoApi23 == null ? ((AudioManager) Assertions.checkNotNull(audioManager)).getDevices(2) : new AudioDeviceInfo[]{audioDeviceInfoApi23.audioDeviceInfo};
            com.google.common.collect.c0<Integer> allBluetoothDeviceTypes = getAllBluetoothDeviceTypes();
            for (AudioDeviceInfo audioDeviceInfo : devices) {
                if (allBluetoothDeviceTypes.contains(Integer.valueOf(audioDeviceInfo.getType()))) {
                    return true;
                }
            }
            return false;
        }
    }

    @RequiresApi(29)
    private static final class Api29 {
        private Api29() {
        }

        @DoNotInline
        public static com.google.common.collect.y<Integer> getDirectPlaybackSupportedEncodings(AudioAttributes audioAttributes) {
            y.a aVarK = com.google.common.collect.y.k();
            i1<Integer> it = AudioCapabilities.ALL_SURROUND_ENCODINGS_AND_MAX_CHANNELS.keySet().iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                if (Util.SDK_INT >= Util.getApiLevelThatAudioFormatIntroducedAudioEncoding(iIntValue) && AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(iIntValue).setSampleRate(48000).build(), audioAttributes.getAudioAttributesV21().audioAttributes)) {
                    aVarK.a(Integer.valueOf(iIntValue));
                }
            }
            aVarK.a(2);
            return aVarK.k();
        }

        @DoNotInline
        public static int getMaxSupportedChannelCountForPassthrough(int i10, int i11, AudioAttributes audioAttributes) {
            for (int i12 = 10; i12 > 0; i12--) {
                int audioTrackChannelConfig = Util.getAudioTrackChannelConfig(i12);
                if (audioTrackChannelConfig != 0 && AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(i10).setSampleRate(i11).setChannelMask(audioTrackChannelConfig).build(), audioAttributes.getAudioAttributesV21().audioAttributes)) {
                    return i12;
                }
            }
            return 0;
        }
    }

    @RequiresApi(33)
    private static final class Api33 {
        private Api33() {
        }

        @DoNotInline
        public static AudioCapabilities getCapabilitiesInternalForDirectPlayback(AudioManager audioManager, AudioAttributes audioAttributes) {
            return new AudioCapabilities(AudioCapabilities.getAudioProfiles(audioManager.getDirectProfilesForAttributes(audioAttributes.getAudioAttributesV21().audioAttributes)));
        }

        @Nullable
        @DoNotInline
        public static AudioDeviceInfoApi23 getDefaultRoutedDeviceForAttributes(AudioManager audioManager, AudioAttributes audioAttributes) {
            try {
                List<AudioDeviceInfo> audioDevicesForAttributes = ((AudioManager) Assertions.checkNotNull(audioManager)).getAudioDevicesForAttributes(audioAttributes.getAudioAttributesV21().audioAttributes);
                if (audioDevicesForAttributes.isEmpty()) {
                    return null;
                }
                return new AudioDeviceInfoApi23(audioDevicesForAttributes.get(0));
            } catch (RuntimeException unused) {
                return null;
            }
        }
    }

    private static boolean deviceMaySetExternalSurroundSoundGlobalSetting() {
        if (Util.SDK_INT >= 17) {
            String str = Util.MANUFACTURER;
            if ("Amazon".equals(str) || "Xiaomi".equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(33)
    @SuppressLint({"WrongConstant"})
    public static com.google.common.collect.y<AudioProfile> getAudioProfiles(List<android.media.AudioProfile> list) {
        HashMap map = new HashMap();
        map.put(2, new HashSet(g5.e.c(12)));
        for (int i10 = 0; i10 < list.size(); i10++) {
            android.media.AudioProfile audioProfile = list.get(i10);
            if (audioProfile.getEncapsulationType() != 1) {
                int format = audioProfile.getFormat();
                if (Util.isEncodingLinearPcm(format) || ALL_SURROUND_ENCODINGS_AND_MAX_CHANNELS.containsKey(Integer.valueOf(format))) {
                    if (map.containsKey(Integer.valueOf(format))) {
                        ((Set) Assertions.checkNotNull((Set) map.get(Integer.valueOf(format)))).addAll(g5.e.c(audioProfile.getChannelMasks()));
                    } else {
                        map.put(Integer.valueOf(format), new HashSet(g5.e.c(audioProfile.getChannelMasks())));
                    }
                }
            }
        }
        y.a aVarK = com.google.common.collect.y.k();
        for (Map.Entry entry : map.entrySet()) {
            aVarK.a(new AudioProfile(((Integer) entry.getKey()).intValue(), (Set<Integer>) entry.getValue()));
        }
        return aVarK.k();
    }

    @Deprecated
    public static AudioCapabilities getCapabilities(Context context) {
        return getCapabilities(context, AudioAttributes.DEFAULT, null);
    }

    @SuppressLint({"UnprotectedReceiver"})
    static AudioCapabilities getCapabilitiesInternal(Context context, AudioAttributes audioAttributes, @Nullable AudioDeviceInfoApi23 audioDeviceInfoApi23) {
        return getCapabilitiesInternal(context, context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")), audioAttributes, audioDeviceInfoApi23);
    }

    private static int getChannelConfigForPassthrough(int i10) {
        int i11 = Util.SDK_INT;
        if (i11 <= 28) {
            if (i10 == 7) {
                i10 = 8;
            } else if (i10 == 3 || i10 == 4 || i10 == 5) {
                i10 = 6;
            }
        }
        if (i11 <= 26 && "fugu".equals(Util.DEVICE) && i10 == 1) {
            i10 = 2;
        }
        return Util.getAudioTrackChannelConfig(i10);
    }

    @Nullable
    static Uri getExternalSurroundSoundGlobalSettingUri() {
        if (deviceMaySetExternalSurroundSoundGlobalSetting()) {
            return Settings.Global.getUriFor(EXTERNAL_SURROUND_SOUND_KEY);
        }
        return null;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AudioCapabilities)) {
            return false;
        }
        AudioCapabilities audioCapabilities = (AudioCapabilities) obj;
        return Util.contentEquals(this.encodingToAudioProfile, audioCapabilities.encodingToAudioProfile) && this.maxChannelCount == audioCapabilities.maxChannelCount;
    }

    @Nullable
    @Deprecated
    public Pair<Integer, Integer> getEncodingAndChannelConfigForPassthrough(Format format) {
        return getEncodingAndChannelConfigForPassthrough(format, AudioAttributes.DEFAULT);
    }

    public int getMaxChannelCount() {
        return this.maxChannelCount;
    }

    public int hashCode() {
        return this.maxChannelCount + (Util.contentHashCode(this.encodingToAudioProfile) * 31);
    }

    @Deprecated
    public boolean isPassthroughPlaybackSupported(Format format) {
        return isPassthroughPlaybackSupported(format, AudioAttributes.DEFAULT);
    }

    public boolean supportsEncoding(int i10) {
        return Util.contains(this.encodingToAudioProfile, i10);
    }

    public String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.maxChannelCount + ", audioProfiles=" + this.encodingToAudioProfile + v8.i.f15839e;
    }

    @Deprecated
    public AudioCapabilities(@Nullable int[] iArr, int i10) {
        this(getAudioProfiles(iArr, i10));
    }

    public static AudioCapabilities getCapabilities(Context context, AudioAttributes audioAttributes, @Nullable AudioDeviceInfo audioDeviceInfo) {
        return getCapabilitiesInternal(context, audioAttributes, (Util.SDK_INT < 23 || audioDeviceInfo == null) ? null : new AudioDeviceInfoApi23(audioDeviceInfo));
    }

    @Nullable
    public Pair<Integer, Integer> getEncodingAndChannelConfigForPassthrough(Format format, AudioAttributes audioAttributes) {
        int encoding = MimeTypes.getEncoding((String) Assertions.checkNotNull(format.sampleMimeType), format.codecs);
        if (!ALL_SURROUND_ENCODINGS_AND_MAX_CHANNELS.containsKey(Integer.valueOf(encoding))) {
            return null;
        }
        if (encoding == 18 && !supportsEncoding(18)) {
            encoding = 6;
        } else if ((encoding == 8 && !supportsEncoding(8)) || (encoding == 30 && !supportsEncoding(30))) {
            encoding = 7;
        }
        if (!supportsEncoding(encoding)) {
            return null;
        }
        AudioProfile audioProfile = (AudioProfile) Assertions.checkNotNull(this.encodingToAudioProfile.get(encoding));
        int maxSupportedChannelCountForPassthrough = format.channelCount;
        if (maxSupportedChannelCountForPassthrough == -1 || encoding == 18) {
            int i10 = format.sampleRate;
            if (i10 == -1) {
                i10 = 48000;
            }
            maxSupportedChannelCountForPassthrough = audioProfile.getMaxSupportedChannelCountForPassthrough(i10, audioAttributes);
        } else if (!format.sampleMimeType.equals(MimeTypes.AUDIO_DTS_X) || Util.SDK_INT >= 33) {
            if (!audioProfile.supportsChannelCount(maxSupportedChannelCountForPassthrough)) {
                return null;
            }
        } else if (maxSupportedChannelCountForPassthrough > 10) {
            return null;
        }
        int channelConfigForPassthrough = getChannelConfigForPassthrough(maxSupportedChannelCountForPassthrough);
        if (channelConfigForPassthrough == 0) {
            return null;
        }
        return Pair.create(Integer.valueOf(encoding), Integer.valueOf(channelConfigForPassthrough));
    }

    public boolean isPassthroughPlaybackSupported(Format format, AudioAttributes audioAttributes) {
        return getEncodingAndChannelConfigForPassthrough(format, audioAttributes) != null;
    }

    private AudioCapabilities(List<AudioProfile> list) {
        this.encodingToAudioProfile = new SparseArray<>();
        for (int i10 = 0; i10 < list.size(); i10++) {
            AudioProfile audioProfile = list.get(i10);
            this.encodingToAudioProfile.put(audioProfile.encoding, audioProfile);
        }
        int iMax = 0;
        for (int i11 = 0; i11 < this.encodingToAudioProfile.size(); i11++) {
            iMax = Math.max(iMax, this.encodingToAudioProfile.valueAt(i11).maxChannelCount);
        }
        this.maxChannelCount = iMax;
    }

    @SuppressLint({"InlinedApi"})
    static AudioCapabilities getCapabilitiesInternal(Context context, @Nullable Intent intent, AudioAttributes audioAttributes, @Nullable AudioDeviceInfoApi23 audioDeviceInfoApi23) {
        AudioManager audioManager = (AudioManager) Assertions.checkNotNull(context.getSystemService("audio"));
        if (audioDeviceInfoApi23 == null) {
            audioDeviceInfoApi23 = Util.SDK_INT >= 33 ? Api33.getDefaultRoutedDeviceForAttributes(audioManager, audioAttributes) : null;
        }
        int i10 = Util.SDK_INT;
        if (i10 >= 33 && (Util.isTv(context) || Util.isAutomotive(context))) {
            return Api33.getCapabilitiesInternalForDirectPlayback(audioManager, audioAttributes);
        }
        if (i10 >= 23 && Api23.isBluetoothConnected(audioManager, audioDeviceInfoApi23)) {
            return DEFAULT_AUDIO_CAPABILITIES;
        }
        c0.a aVar = new c0.a();
        aVar.a(2);
        if (deviceMaySetExternalSurroundSoundGlobalSetting() && Settings.Global.getInt(context.getContentResolver(), EXTERNAL_SURROUND_SOUND_KEY, 0) == 1) {
            aVar.j(EXTERNAL_SURROUND_SOUND_ENCODINGS);
        }
        if (i10 >= 29 && (Util.isTv(context) || Util.isAutomotive(context))) {
            aVar.j(Api29.getDirectPlaybackSupportedEncodings(audioAttributes));
            return new AudioCapabilities(getAudioProfiles(g5.e.k(aVar.l()), 10));
        }
        if (intent != null && intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 1) {
            int[] intArrayExtra = intent.getIntArrayExtra("android.media.extra.ENCODINGS");
            if (intArrayExtra != null) {
                aVar.j(g5.e.c(intArrayExtra));
            }
            return new AudioCapabilities(getAudioProfiles(g5.e.k(aVar.l()), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 10)));
        }
        return new AudioCapabilities(getAudioProfiles(g5.e.k(aVar.l()), 10));
    }

    private static final class AudioProfile {
        public static final AudioProfile DEFAULT_AUDIO_PROFILE;

        @Nullable
        private final com.google.common.collect.c0<Integer> channelMasks;
        public final int encoding;
        public final int maxChannelCount;

        static {
            DEFAULT_AUDIO_PROFILE = Util.SDK_INT >= 33 ? new AudioProfile(2, getAllChannelMasksForMaxChannelCount(10)) : new AudioProfile(2, 10);
        }

        @RequiresApi(33)
        public AudioProfile(int i10, Set<Integer> set) {
            this.encoding = i10;
            com.google.common.collect.c0<Integer> c0VarM = com.google.common.collect.c0.m(set);
            this.channelMasks = c0VarM;
            i1<Integer> it = c0VarM.iterator();
            int iMax = 0;
            while (it.hasNext()) {
                iMax = Math.max(iMax, Integer.bitCount(it.next().intValue()));
            }
            this.maxChannelCount = iMax;
        }

        private static com.google.common.collect.c0<Integer> getAllChannelMasksForMaxChannelCount(int i10) {
            c0.a aVar = new c0.a();
            for (int i11 = 1; i11 <= i10; i11++) {
                aVar.a(Integer.valueOf(Util.getAudioTrackChannelConfig(i11)));
            }
            return aVar.l();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AudioProfile)) {
                return false;
            }
            AudioProfile audioProfile = (AudioProfile) obj;
            return this.encoding == audioProfile.encoding && this.maxChannelCount == audioProfile.maxChannelCount && Util.areEqual(this.channelMasks, audioProfile.channelMasks);
        }

        public int getMaxSupportedChannelCountForPassthrough(int i10, AudioAttributes audioAttributes) {
            return this.channelMasks != null ? this.maxChannelCount : Util.SDK_INT >= 29 ? Api29.getMaxSupportedChannelCountForPassthrough(this.encoding, i10, audioAttributes) : ((Integer) Assertions.checkNotNull(AudioCapabilities.ALL_SURROUND_ENCODINGS_AND_MAX_CHANNELS.getOrDefault(Integer.valueOf(this.encoding), 0))).intValue();
        }

        public int hashCode() {
            int i10 = ((this.encoding * 31) + this.maxChannelCount) * 31;
            com.google.common.collect.c0<Integer> c0Var = this.channelMasks;
            return i10 + (c0Var == null ? 0 : c0Var.hashCode());
        }

        public boolean supportsChannelCount(int i10) {
            if (this.channelMasks == null) {
                return i10 <= this.maxChannelCount;
            }
            int audioTrackChannelConfig = Util.getAudioTrackChannelConfig(i10);
            if (audioTrackChannelConfig == 0) {
                return false;
            }
            return this.channelMasks.contains(Integer.valueOf(audioTrackChannelConfig));
        }

        public String toString() {
            return "AudioProfile[format=" + this.encoding + ", maxChannelCount=" + this.maxChannelCount + ", channelMasks=" + this.channelMasks + v8.i.f15839e;
        }

        public AudioProfile(int i10, int i11) {
            this.encoding = i10;
            this.maxChannelCount = i11;
            this.channelMasks = null;
        }
    }

    private static com.google.common.collect.y<AudioProfile> getAudioProfiles(@Nullable int[] iArr, int i10) {
        y.a aVarK = com.google.common.collect.y.k();
        if (iArr == null) {
            iArr = new int[0];
        }
        for (int i11 : iArr) {
            aVarK.a(new AudioProfile(i11, i10));
        }
        return aVarK.k();
    }
}
