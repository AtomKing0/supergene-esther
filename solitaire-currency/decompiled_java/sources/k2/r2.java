package k2;

import a4.m;
import android.os.Bundle;
import android.os.Looper;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import java.util.ArrayList;
import java.util.List;
import k2.h;
import k2.r2;

/* JADX INFO: compiled from: Player.java */
/* JADX INFO: loaded from: classes2.dex */
public interface r2 {

    /* JADX INFO: compiled from: Player.java */
    public static final class b implements h {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f29427b = new a().e();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final h.a<b> f29428c = new h.a() { // from class: k2.s2
            @Override // k2.h.a
            public final h fromBundle(Bundle bundle) {
                return r2.b.d(bundle);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a4.m f29429a;

        /* JADX INFO: compiled from: Player.java */
        public static final class a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private static final int[] f29430b = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 31, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final m.b f29431a = new m.b();

            public a a(int i10) {
                this.f29431a.a(i10);
                return this;
            }

            public a b(b bVar) {
                this.f29431a.b(bVar.f29429a);
                return this;
            }

            public a c(int... iArr) {
                this.f29431a.c(iArr);
                return this;
            }

            public a d(int i10, boolean z10) {
                this.f29431a.d(i10, z10);
                return this;
            }

            public b e() {
                return new b(this.f29431a.e());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b d(Bundle bundle) {
            ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(e(0));
            if (integerArrayList == null) {
                return f29427b;
            }
            a aVar = new a();
            for (int i10 = 0; i10 < integerArrayList.size(); i10++) {
                aVar.a(integerArrayList.get(i10).intValue());
            }
            return aVar.e();
        }

        private static String e(int i10) {
            return Integer.toString(i10, 36);
        }

        public boolean c(int i10) {
            return this.f29429a.a(i10);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                return this.f29429a.equals(((b) obj).f29429a);
            }
            return false;
        }

        public int hashCode() {
            return this.f29429a.hashCode();
        }

        @Override // k2.h
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i10 = 0; i10 < this.f29429a.d(); i10++) {
                arrayList.add(Integer.valueOf(this.f29429a.c(i10)));
            }
            bundle.putIntegerArrayList(e(0), arrayList);
            return bundle;
        }

        private b(a4.m mVar) {
            this.f29429a = mVar;
        }
    }

    /* JADX INFO: compiled from: Player.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a4.m f29432a;

        public c(a4.m mVar) {
            this.f29432a = mVar;
        }

        public boolean a(int i10) {
            return this.f29432a.a(i10);
        }

        public boolean b(int... iArr) {
            return this.f29432a.b(iArr);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof c) {
                return this.f29432a.equals(((c) obj).f29432a);
            }
            return false;
        }

        public int hashCode() {
            return this.f29432a.hashCode();
        }
    }

    /* JADX INFO: compiled from: Player.java */
    public interface d {
        void B(o oVar);

        void D(e eVar, e eVar2, int i10);

        void E(@Nullable n2 n2Var);

        void F(b bVar);

        void G(s3 s3Var);

        void H(x3.z zVar);

        void a(n3.f fVar);

        void f(b4.b0 b0Var);

        void h(q2 q2Var);

        void j(c3.a aVar);

        void m(b2 b2Var);

        @Deprecated
        void onCues(List<n3.b> list);

        void onDeviceVolumeChanged(int i10, boolean z10);

        void onIsLoadingChanged(boolean z10);

        void onIsPlayingChanged(boolean z10);

        @Deprecated
        void onLoadingChanged(boolean z10);

        void onPlayWhenReadyChanged(boolean z10, int i10);

        void onPlaybackStateChanged(int i10);

        void onPlaybackSuppressionReasonChanged(int i10);

        @Deprecated
        void onPlayerStateChanged(boolean z10, int i10);

        @Deprecated
        void onPositionDiscontinuity(int i10);

        void onRenderedFirstFrame();

        void onRepeatModeChanged(int i10);

        void onShuffleModeEnabledChanged(boolean z10);

        void onSkipSilenceEnabledChanged(boolean z10);

        void onSurfaceSizeChanged(int i10, int i11);

        void onVolumeChanged(float f10);

        void t(r2 r2Var, c cVar);

        void u(n2 n2Var);

        void x(@Nullable w1 w1Var, int i10);

        @Deprecated
        void y();

        void z(n3 n3Var, int i10);
    }

    /* JADX INFO: compiled from: Player.java */
    public static final class e implements h {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final h.a<e> f29433k = new h.a() { // from class: k2.u2
            @Override // k2.h.a
            public final h fromBundle(Bundle bundle) {
                return r2.e.b(bundle);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final Object f29434a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Deprecated
        public final int f29435b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f29436c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public final w1 f29437d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        public final Object f29438e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f29439f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f29440g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final long f29441h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f29442i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f29443j;

        public e(@Nullable Object obj, int i10, @Nullable w1 w1Var, @Nullable Object obj2, int i11, long j10, long j11, int i12, int i13) {
            this.f29434a = obj;
            this.f29435b = i10;
            this.f29436c = i10;
            this.f29437d = w1Var;
            this.f29438e = obj2;
            this.f29439f = i11;
            this.f29440g = j10;
            this.f29441h = j11;
            this.f29442i = i12;
            this.f29443j = i13;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static e b(Bundle bundle) {
            int i10 = bundle.getInt(c(0), -1);
            Bundle bundle2 = bundle.getBundle(c(1));
            return new e(null, i10, bundle2 == null ? null : (w1) w1.f29515j.fromBundle(bundle2), null, bundle.getInt(c(2), -1), bundle.getLong(c(3), C.TIME_UNSET), bundle.getLong(c(4), C.TIME_UNSET), bundle.getInt(c(5), -1), bundle.getInt(c(6), -1));
        }

        private static String c(int i10) {
            return Integer.toString(i10, 36);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || e.class != obj.getClass()) {
                return false;
            }
            e eVar = (e) obj;
            return this.f29436c == eVar.f29436c && this.f29439f == eVar.f29439f && this.f29440g == eVar.f29440g && this.f29441h == eVar.f29441h && this.f29442i == eVar.f29442i && this.f29443j == eVar.f29443j && e5.k.a(this.f29434a, eVar.f29434a) && e5.k.a(this.f29438e, eVar.f29438e) && e5.k.a(this.f29437d, eVar.f29437d);
        }

        public int hashCode() {
            return e5.k.b(this.f29434a, Integer.valueOf(this.f29436c), this.f29437d, this.f29438e, Integer.valueOf(this.f29439f), Long.valueOf(this.f29440g), Long.valueOf(this.f29441h), Integer.valueOf(this.f29442i), Integer.valueOf(this.f29443j));
        }

        @Override // k2.h
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putInt(c(0), this.f29436c);
            if (this.f29437d != null) {
                bundle.putBundle(c(1), this.f29437d.toBundle());
            }
            bundle.putInt(c(2), this.f29439f);
            bundle.putLong(c(3), this.f29440g);
            bundle.putLong(c(4), this.f29441h);
            bundle.putInt(c(5), this.f29442i);
            bundle.putInt(c(6), this.f29443j);
            return bundle;
        }
    }

    void a(d dVar);

    void b(q2 q2Var);

    void c(x3.z zVar);

    void clearVideoSurfaceView(@Nullable SurfaceView surfaceView);

    void clearVideoTextureView(@Nullable TextureView textureView);

    void d(w1 w1Var);

    void f(d dVar);

    Looper getApplicationLooper();

    b getAvailableCommands();

    long getContentBufferedPosition();

    long getContentPosition();

    int getCurrentAdGroupIndex();

    int getCurrentAdIndexInAdGroup();

    n3.f getCurrentCues();

    int getCurrentMediaItemIndex();

    int getCurrentPeriodIndex();

    long getCurrentPosition();

    n3 getCurrentTimeline();

    s3 getCurrentTracks();

    long getDuration();

    long getMaxSeekToPreviousPosition();

    b2 getMediaMetadata();

    boolean getPlayWhenReady();

    q2 getPlaybackParameters();

    int getPlaybackState();

    int getPlaybackSuppressionReason();

    @Nullable
    n2 getPlayerError();

    int getRepeatMode();

    long getSeekBackIncrement();

    long getSeekForwardIncrement();

    boolean getShuffleModeEnabled();

    long getTotalBufferedDuration();

    x3.z getTrackSelectionParameters();

    b4.b0 getVideoSize();

    boolean hasNextMediaItem();

    boolean hasPreviousMediaItem();

    boolean isCommandAvailable(int i10);

    boolean isCurrentMediaItemDynamic();

    boolean isCurrentMediaItemLive();

    boolean isCurrentMediaItemSeekable();

    boolean isPlaying();

    boolean isPlayingAd();

    void pause();

    void play();

    void prepare();

    void release();

    void seekBack();

    void seekForward();

    void seekTo(int i10, long j10);

    void seekTo(long j10);

    void seekToNext();

    void seekToPrevious();

    void setMediaItems(List<w1> list, boolean z10);

    void setPlayWhenReady(boolean z10);

    void setRepeatMode(int i10);

    void setShuffleModeEnabled(boolean z10);

    void setVideoSurfaceView(@Nullable SurfaceView surfaceView);

    void setVideoTextureView(@Nullable TextureView textureView);

    void setVolume(@FloatRange(from = 0.0d, to = 1.0d) float f10);
}
