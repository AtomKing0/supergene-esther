package com.king.amp.sa;

import android.animation.ValueAnimator;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DefaultDataSource;
import androidx.media3.exoplayer.DefaultRenderersFactory;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.source.ProgressiveMediaSource;
import androidx.media3.ui.PlayerView;
import com.king.amp.sa.i0;
import com.king.amp.sa.r1;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: AbmVideoFragment.java */
/* JADX INFO: loaded from: classes4.dex */
public class l0 extends r0 implements Player.Listener {
    private i0 D;
    private int F;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private k6.f f16790p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private k6.c f16791q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private ExoPlayer f16792r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private PlayerView f16793s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f16794t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long f16796v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f16797w;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float f16799y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    View f16800z;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private c f16795u = c.Idle;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f16798x = 0;
    private boolean A = false;
    private int B = 0;
    private boolean C = false;
    private boolean E = false;

    /* JADX INFO: compiled from: AbmVideoFragment.java */
    class a implements i0.c {
        a() {
        }

        @Override // com.king.amp.sa.i0.c
        public void a(float f10) {
            l0.this.H((int) f10);
        }
    }

    /* JADX INFO: compiled from: AbmVideoFragment.java */
    class b implements i0.b {
        b() {
        }

        @Override // com.king.amp.sa.i0.b
        public void a() {
            if (l0.this.E) {
                return;
            }
            l0.this.H(100);
            l0.this.C = true;
            l0 l0Var = l0.this;
            n nVar = l0Var.f16880d;
            if (nVar != null) {
                nVar.o(l0Var.F);
            }
        }
    }

    /* JADX INFO: compiled from: AbmVideoFragment.java */
    private enum c {
        Idle,
        Initialized,
        Showing,
        Finished
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(ValueAnimator valueAnimator) {
        this.f16792r.setVolume(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(ValueAnimator valueAnimator) {
        this.f16792r.setVolume(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public static l0 W(@NonNull Map<String, String> map, long j10) {
        l0 l0Var = new l0();
        Bundle bundle = new Bundle();
        bundle.putSerializable("custom_map", new HashMap(map));
        bundle.putLong("player_id", j10);
        l0Var.setArguments(bundle);
        return l0Var;
    }

    @Override // com.king.amp.sa.r0
    public boolean C(@NonNull String str) {
        Log.d("AbmVideoFragment", "performAction: " + str);
        if (this.f16792r == null) {
            Log.e("AbmVideoFragment", "Unable to perform action " + str + ", player is null");
            return false;
        }
        str.hashCode();
        if (str.equals("resume")) {
            if (!this.f16792r.isPlaying()) {
                this.f16792r.play();
                y();
                if (this.A) {
                    c0();
                } else {
                    E();
                }
            }
            return true;
        }
        if (!str.equals("pause")) {
            Log.i("AbmVideoFragment", "Skip action: " + str);
            return false;
        }
        if (this.f16792r.isPlaying()) {
            this.f16792r.pause();
            x();
            if (this.A) {
                Y();
            } else {
                B();
            }
        }
        return true;
    }

    @OptIn(markerClass = {UnstableApi.class})
    protected ExoPlayer N(DefaultRenderersFactory defaultRenderersFactory) {
        return new ExoPlayer.Builder(requireActivity()).setRenderersFactory(defaultRenderersFactory).build();
    }

    @OptIn(markerClass = {UnstableApi.class})
    public void O() {
        if (this.f16792r != null) {
            return;
        }
        try {
            DefaultRenderersFactory defaultRenderersFactory = new DefaultRenderersFactory(requireContext());
            defaultRenderersFactory.setExtensionRendererMode(2);
            defaultRenderersFactory.setEnableDecoderFallback(true);
            FragmentActivity activity = getActivity();
            if (activity == null) {
                return;
            }
            ExoPlayer exoPlayerBuild = new ExoPlayer.Builder(activity).setRenderersFactory(defaultRenderersFactory).build();
            this.f16792r = exoPlayerBuild;
            exoPlayerBuild.addListener(this);
            PlayerView playerView = this.f16793s;
            if (playerView != null) {
                playerView.setPlayer(this.f16792r);
                this.f16793s.setUseController(false);
            }
            MediaItem mediaItemBuild = new MediaItem.Builder().setUri(Uri.parse(this.f16794t)).build();
            Log.d("AbmVideoFragment", "play with mediaSource : " + new ProgressiveMediaSource.Factory(new DefaultDataSource.Factory(requireContext())).createMediaSource(mediaItemBuild).toString());
            this.f16792r.setMediaItem(mediaItemBuild);
            ExoPlayer exoPlayer = this.f16792r;
            if (exoPlayer != null) {
                this.f16795u = c.Showing;
                exoPlayer.prepare();
                this.f16797w = (int) (this.f16792r.getVolume() * 100.0f);
            }
        } catch (IllegalStateException e10) {
            Log.e("AbmVideoFragment", "Error creating player", e10);
            a0();
        }
    }

    public boolean P() {
        return this.C;
    }

    public void Q(long j10) {
        if (this.f16792r == null) {
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(j10);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.king.amp.sa.k0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f16788a.U(valueAnimator);
            }
        });
        valueAnimatorOfFloat.start();
    }

    public void R(long j10) {
        ExoPlayer exoPlayer = this.f16792r;
        if (exoPlayer == null) {
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(exoPlayer.getVolume(), 0.0f);
        valueAnimatorOfFloat.setDuration(j10);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.king.amp.sa.j0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f16786a.V(valueAnimator);
            }
        });
        valueAnimatorOfFloat.start();
    }

    public void S(int i10, int i11) {
        r1 r1Var = this.f16890n;
        if (r1Var != null) {
            r1Var.a(r1.c.PROGRESS, i10, null);
        }
        super.A(i10, i11);
    }

    public boolean T() {
        return this.f16795u == c.Finished;
    }

    public void X(float f10, float f11) {
        this.f16799y = f11;
        int i10 = (int) f10;
        if (i10 >= this.f16798x) {
            Log.i("AbmVideoFragment", "Got final progress event, but need ot wait for completion event. Ignoring.");
        } else {
            S(i10, (int) f11);
        }
    }

    protected void Y() {
        if (this.C) {
            this.D = null;
        }
        i0 i0Var = this.D;
        if (i0Var == null || !i0Var.p()) {
            return;
        }
        this.E = true;
        this.D.r();
    }

    protected void Z() {
        Log.d("AbmVideoFragment", "pauseVideo called");
        ExoPlayer exoPlayer = this.f16792r;
        if (exoPlayer == null) {
            Log.e("AbmVideoFragment", "Unable to pause video, player is null");
            return;
        }
        c cVar = this.f16795u;
        c cVar2 = c.Finished;
        if (cVar == cVar2) {
            return;
        }
        if (exoPlayer.isPlaying()) {
            Log.d("AbmVideoFragment", "pauseVideo with mPlayer pause");
            this.f16792r.pause();
            if (this.A) {
                Y();
            } else {
                B();
            }
        }
        if (this.f16795u != cVar2) {
            x();
        }
    }

    public void a0() {
        ExoPlayer exoPlayer = this.f16792r;
        if (exoPlayer != null && !exoPlayer.isPlaying()) {
            this.f16792r.stop();
            this.f16792r.release();
            this.f16792r = null;
        }
        PlayerView playerView = this.f16793s;
        if (playerView != null) {
            playerView.setPlayer(null);
        }
        b0();
    }

    protected void b0() {
        i0 i0Var = this.D;
        if (i0Var != null) {
            i0Var.n();
            this.D = null;
        }
        this.C = false;
        this.E = false;
        H(0);
    }

    protected void c0() {
        i0 i0Var = this.D;
        if (i0Var == null || !this.E) {
            e0();
        } else {
            this.E = false;
            i0Var.s();
        }
    }

    protected void d0() {
        if (this.f16792r == null) {
            Log.e("AbmVideoFragment", "Unable to resume video, player is null");
            return;
        }
        Log.d("AbmVideoFragment", "resumeVideo called");
        c cVar = this.f16795u;
        c cVar2 = c.Finished;
        if (cVar == cVar2) {
            this.f16792r.seekTo(this.f16796v);
        }
        if (!this.f16792r.isPlaying()) {
            Log.d("AbmVideoFragment", "resumeVideo with mPlayer play");
            this.f16792r.play();
            if (!this.A) {
                E();
            }
        }
        if (this.f16795u != cVar2) {
            y();
        }
    }

    protected void e0() {
        i0 i0Var = this.D;
        if (i0Var != null) {
            i0Var.n();
        }
        this.C = false;
        this.E = false;
        H(0);
        i0 i0Var2 = new i0(0, 100, this.B, new LinearInterpolator(), new a(), new b());
        this.D = i0Var2;
        i0Var2.v();
    }

    protected void f0() {
        ExoPlayer exoPlayer = this.f16792r;
        if (exoPlayer == null) {
            return;
        }
        if (exoPlayer.getPlaybackState() == 1 || this.f16792r.getCurrentPosition() == 0) {
            this.f16792r.play();
            c0();
        } else {
            this.f16792r.seekTo(0L);
            this.f16792r.setPlayWhenReady(true);
            c0();
        }
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onAudioAttributesChanged(AudioAttributes audioAttributes) {
        androidx.media3.common.g0.a(this, audioAttributes);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onAudioSessionIdChanged(int i10) {
        androidx.media3.common.g0.b(this, i10);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onAvailableCommandsChanged(Player.Commands commands) {
        androidx.media3.common.g0.c(this, commands);
    }

    @Override // com.king.amp.sa.r0, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.A = Boolean.parseBoolean((String) s(this.f16879c, "is_chapter_video", "false"));
        this.F = Integer.parseInt((String) s(this.f16879c, "chapter_idx", "-1"));
        this.f16881e = true;
        this.f16797w = 0;
        this.f16796v = 0L;
    }

    @Override // com.king.amp.sa.r0, androidx.fragment.app.Fragment
    @OptIn(markerClass = {UnstableApi.class})
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.A = Boolean.parseBoolean((String) s(this.f16879c, "is_chapter_video", "false"));
        this.F = Integer.parseInt((String) s(this.f16879c, "chapter_idx", "-1"));
        this.f16881e = true;
        this.f16797w = 0;
        this.f16796v = 0L;
        if (this.A) {
            k6.c cVarC = k6.c.c(layoutInflater, viewGroup, false);
            this.f16791q = cVarC;
            this.f16800z = cVarC.getRoot();
        } else {
            k6.f fVarC = k6.f.c(layoutInflater, viewGroup, false);
            this.f16790p = fVarC;
            this.f16800z = fVarC.getRoot();
        }
        if (this.A) {
            this.f16800z.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            n nVar = this.f16880d;
            if (nVar != null) {
                nVar.s(0);
            }
        }
        Log.d("AbmVideoFragment", "VideoController play called: " + this.f16879c.toString());
        this.f16793s = this.A ? this.f16791q.f29701c : this.f16790p.f29713c;
        DefaultRenderersFactory defaultRenderersFactory = new DefaultRenderersFactory(requireContext());
        defaultRenderersFactory.setExtensionRendererMode(2);
        defaultRenderersFactory.setEnableDecoderFallback(true);
        for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(0).getCodecInfos()) {
            if (!mediaCodecInfo.isEncoder()) {
                for (String str : mediaCodecInfo.getSupportedTypes()) {
                    Log.i("AbmVideoFragment", ">>> Codec: " + mediaCodecInfo.getName() + ", Type: " + str);
                }
            }
        }
        ExoPlayer exoPlayerN = N(defaultRenderersFactory);
        this.f16792r = exoPlayerN;
        exoPlayerN.addListener(this);
        this.f16793s.setPlayer(this.f16792r);
        this.f16793s.setUseController(false);
        String str2 = (String) s(this.f16879c, "content_file_path", "");
        this.f16794t = str2;
        if (TextUtils.isEmpty(str2)) {
            Log.e("AbmVideoFragment", "Media playback error: media path is empty.");
            this.f16795u = c.Finished;
            w(4, "Media playback error: media path is empty");
            return this.f16800z;
        }
        MediaItem mediaItemBuild = new MediaItem.Builder().setUri(Uri.parse(this.f16794t)).build();
        Log.d("AbmVideoFragment", "play with mediaSource : " + new ProgressiveMediaSource.Factory(new DefaultDataSource.Factory(requireActivity())).createMediaSource(mediaItemBuild).toString());
        this.f16792r.setMediaItem(mediaItemBuild);
        String str3 = (String) s(this.f16879c, "media_duration", "");
        if (!TextUtils.isEmpty(str3)) {
            this.f16798x = Integer.parseInt(str3);
        }
        this.B = this.f16798x * 1000;
        this.f16795u = c.Initialized;
        r1.e eVar = new r1.e();
        eVar.f16918a = "video";
        eVar.f16919b = this.f16798x;
        eVar.f16920c = null;
        t(eVar);
        return this.f16800z;
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onCues(CueGroup cueGroup) {
        androidx.media3.common.g0.d(this, cueGroup);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ExoPlayer exoPlayer = this.f16792r;
        if (exoPlayer != null) {
            exoPlayer.release();
            this.f16792r = null;
        }
        i0 i0Var = this.D;
        if (i0Var != null) {
            i0Var.n();
            this.D = null;
        }
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onDeviceInfoChanged(DeviceInfo deviceInfo) {
        androidx.media3.common.g0.f(this, deviceInfo);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onDeviceVolumeChanged(int i10, boolean z10) {
        androidx.media3.common.g0.g(this, i10, z10);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onEvents(Player player, Player.Events events) {
        androidx.media3.common.g0.h(this, player, events);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onIsLoadingChanged(boolean z10) {
        androidx.media3.common.g0.i(this, z10);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onLoadingChanged(boolean z10) {
        androidx.media3.common.g0.k(this, z10);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onMaxSeekToPreviousPositionChanged(long j10) {
        androidx.media3.common.g0.l(this, j10);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onMediaItemTransition(MediaItem mediaItem, int i10) {
        androidx.media3.common.g0.m(this, mediaItem, i10);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
        androidx.media3.common.g0.n(this, mediaMetadata);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onMetadata(Metadata metadata) {
        androidx.media3.common.g0.o(this, metadata);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onPlayWhenReadyChanged(boolean z10, int i10) {
        androidx.media3.common.g0.p(this, z10, i10);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        androidx.media3.common.g0.q(this, playbackParameters);
    }

    @Override // androidx.media3.common.Player.Listener
    public void onPlaybackStateChanged(int i10) {
        Log.d("AbmVideoFragment", "AbmVideoFragment onPlaybackStateChanged to " + i10);
        if (i10 != 3) {
            if (i10 != 4) {
                return;
            }
            c cVar = this.f16795u;
            c cVar2 = c.Finished;
            if (cVar != cVar2) {
                this.f16795u = cVar2;
                Log.d("AbmVideoFragment", "ExoPlayer completed the display.");
                if (!this.A) {
                    B();
                }
                S(this.f16798x, (int) this.f16799y);
                r1 r1Var = this.f16890n;
                if (r1Var != null) {
                    r1Var.a(r1.c.COMPLETED, 0, null);
                }
                this.f16796v = this.f16792r.getCurrentPosition();
                return;
            }
            return;
        }
        ExoPlayer exoPlayer = this.f16792r;
        if (exoPlayer == null) {
            return;
        }
        long duration = exoPlayer.getDuration() / 1000;
        int i11 = this.f16798x;
        if (i11 == duration || Math.abs(duration - ((long) i11)) <= 1) {
            r1 r1Var2 = this.f16890n;
            if (r1Var2 != null) {
                r1Var2.a(r1.c.READY, 0, null);
                return;
            }
            return;
        }
        Log.e("AbmVideoFragment", "Media playback error: ad content duration is longer than media duration.");
        w(6, "Media playback error: ad content duration is longer than media duration.");
        r1 r1Var3 = this.f16890n;
        if (r1Var3 != null) {
            r1Var3.a(r1.c.ERROR, r1.b.VIDEO.ordinal(), "Incorrect ad duration.");
        }
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i10) {
        androidx.media3.common.g0.s(this, i10);
    }

    @Override // androidx.media3.common.Player.Listener
    public void onPlayerError(@NonNull PlaybackException playbackException) {
        r1 r1Var = this.f16890n;
        if (r1Var != null) {
            r1Var.a(r1.c.ERROR, r1.b.VIDEO.ordinal(), "Playback error.");
        }
        AbmAdPlayer abmAdPlayer = this.f16878b;
        if (abmAdPlayer != null) {
            abmAdPlayer.onPlayerDismissed(6, "code=" + playbackException.errorCode + ", desc=" + playbackException.getMessage());
        }
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onPlayerErrorChanged(PlaybackException playbackException) {
        androidx.media3.common.g0.u(this, playbackException);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onPlayerStateChanged(boolean z10, int i10) {
        androidx.media3.common.g0.v(this, z10, i10);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
        androidx.media3.common.g0.w(this, mediaMetadata);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onPositionDiscontinuity(int i10) {
        androidx.media3.common.g0.x(this, i10);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onRenderedFirstFrame() {
        androidx.media3.common.g0.z(this);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onRepeatModeChanged(int i10) {
        androidx.media3.common.g0.A(this, i10);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onSeekBackIncrementChanged(long j10) {
        androidx.media3.common.g0.B(this, j10);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onSeekForwardIncrementChanged(long j10) {
        androidx.media3.common.g0.C(this, j10);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onShuffleModeEnabledChanged(boolean z10) {
        androidx.media3.common.g0.D(this, z10);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onSkipSilenceEnabledChanged(boolean z10) {
        androidx.media3.common.g0.E(this, z10);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onSurfaceSizeChanged(int i10, int i11) {
        androidx.media3.common.g0.F(this, i10, i11);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onTimelineChanged(Timeline timeline, int i10) {
        androidx.media3.common.g0.G(this, timeline, i10);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters) {
        androidx.media3.common.g0.H(this, trackSelectionParameters);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onTracksChanged(Tracks tracks) {
        androidx.media3.common.g0.I(this, tracks);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onVideoSizeChanged(VideoSize videoSize) {
        androidx.media3.common.g0.J(this, videoSize);
    }

    @Override // com.king.amp.sa.r0, androidx.fragment.app.Fragment
    @MainThread
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        Log.d("AbmVideoFragment", "onViewCreated: " + view.toString());
        if (this.f16795u != c.Initialized || this.f16792r == null) {
            return;
        }
        Log.d("AbmVideoFragment", "start player play");
        r1 r1Var = this.f16890n;
        if (r1Var != null) {
            r1Var.p(this.f16800z);
        } else {
            Log.w("AbmVideoFragment", "Unable to start OM Sdk session, wrapper is null");
        }
        this.f16795u = c.Showing;
        this.f16792r.prepare();
        this.f16797w = (int) (this.f16792r.getVolume() * 100.0f);
        if (!this.A) {
            this.f16792r.play();
            E();
        }
        if (this.A && !this.f16792r.isPlaying() && this.F == 0) {
            this.f16792r.play();
            c0();
        }
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onVolumeChanged(float f10) {
        androidx.media3.common.g0.K(this, f10);
    }

    @Override // com.king.amp.sa.r0, android.view.ViewTreeObserver.OnWindowFocusChangeListener
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        Log.d("AbmVideoFragment", "onWindowFocusChanged with " + z10);
        if (this.f16885i) {
            if (z10) {
                d0();
            } else {
                Z();
            }
        }
    }

    @Override // com.king.amp.sa.r0
    public String p() {
        return "video";
    }

    @Override // com.king.amp.sa.r0
    String r() {
        return "AbmVideoFragment";
    }

    @Override // com.king.amp.sa.r0
    public void u() {
        super.u();
        Z();
    }

    @Override // com.king.amp.sa.r0
    public void v() {
        super.v();
        d0();
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onCues(List list) {
        androidx.media3.common.g0.e(this, list);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i10) {
        androidx.media3.common.g0.y(this, positionInfo, positionInfo2, i10);
    }

    @Override // androidx.media3.common.Player.Listener
    public void onIsPlayingChanged(boolean z10) {
    }
}
