package android.support.v4.media.session;

import android.content.Context;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.a;
import android.support.v4.media.session.b;
import android.util.Log;
import android.view.KeyEvent;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.BundleCompat;
import androidx.media.AudioAttributesCompat;
import androidx.versionedparcelable.ParcelUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class MediaControllerCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MediaSessionCompat.Token f645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<a> f646c;

    @RequiresApi(21)
    static class MediaControllerImplApi21 implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final MediaController f647a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Object f648b = new Object();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @GuardedBy("mLock")
        private final List<a> f649c = new ArrayList();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private HashMap<a, a> f650d = new HashMap<>();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final MediaSessionCompat.Token f651e;

        private static class ExtraBinderRequestResultReceiver extends ResultReceiver {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private WeakReference<MediaControllerImplApi21> f652a;

            ExtraBinderRequestResultReceiver(MediaControllerImplApi21 mediaControllerImplApi21) {
                super(null);
                this.f652a = new WeakReference<>(mediaControllerImplApi21);
            }

            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i10, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21 = this.f652a.get();
                if (mediaControllerImplApi21 == null || bundle == null) {
                    return;
                }
                synchronized (mediaControllerImplApi21.f648b) {
                    mediaControllerImplApi21.f651e.e(b.a.o(BundleCompat.getBinder(bundle, "android.support.v4.media.session.EXTRA_BINDER")));
                    mediaControllerImplApi21.f651e.f(ParcelUtils.getVersionedParcelable(bundle, "android.support.v4.media.session.SESSION_TOKEN2"));
                    mediaControllerImplApi21.b();
                }
            }
        }

        private static class a extends a.b {
            a(a aVar) {
                super(aVar);
            }

            @Override // android.support.v4.media.session.a
            public void b(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.a
            public void d() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.a
            public void e(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.a
            public void h(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.a
            public void j(Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.a
            public void m(CharSequence charSequence) throws RemoteException {
                throw new AssertionError();
            }
        }

        MediaControllerImplApi21(Context context, MediaSessionCompat.Token token) {
            this.f651e = token;
            this.f647a = new MediaController(context, (MediaSession.Token) token.d());
            if (token.c() == null) {
                c();
            }
        }

        private void c() {
            d("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, new ExtraBinderRequestResultReceiver(this));
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public boolean a(KeyEvent keyEvent) {
            return this.f647a.dispatchMediaButtonEvent(keyEvent);
        }

        @GuardedBy("mLock")
        void b() {
            if (this.f651e.c() == null) {
                return;
            }
            for (a aVar : this.f649c) {
                a aVar2 = new a(aVar);
                this.f650d.put(aVar, aVar2);
                aVar.f654b = aVar2;
                try {
                    this.f651e.c().i(aVar2);
                    aVar.i(13, null, null);
                } catch (RemoteException e10) {
                    Log.e("MediaControllerCompat", "Dead object in registerCallback.", e10);
                }
            }
            this.f649c.clear();
        }

        public void d(String str, Bundle bundle, ResultReceiver resultReceiver) {
            this.f647a.sendCommand(str, bundle, resultReceiver);
        }
    }

    interface b {
        boolean a(KeyEvent keyEvent);
    }

    @RequiresApi(29)
    static class c extends MediaControllerImplApi21 {
        c(Context context, MediaSessionCompat.Token token) {
            super(context, token);
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f657a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AudioAttributesCompat f658b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f659c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f660d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f661e;

        d(int i10, @NonNull AudioAttributesCompat audioAttributesCompat, int i11, int i12, int i13) {
            this.f657a = i10;
            this.f658b = audioAttributesCompat;
            this.f659c = i11;
            this.f660d = i12;
            this.f661e = i13;
        }
    }

    public MediaControllerCompat(Context context, @NonNull MediaSessionCompat.Token token) {
        if (token == null) {
            throw new IllegalArgumentException("sessionToken must not be null");
        }
        this.f646c = Collections.synchronizedSet(new HashSet());
        this.f645b = token;
        if (Build.VERSION.SDK_INT >= 29) {
            this.f644a = new c(context, token);
        } else {
            this.f644a = new MediaControllerImplApi21(context, token);
        }
    }

    public boolean a(KeyEvent keyEvent) {
        if (keyEvent != null) {
            return this.f644a.a(keyEvent);
        }
        throw new IllegalArgumentException("KeyEvent may not be null");
    }

    public static abstract class a implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MediaController.Callback f653a = new C0023a(this);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        android.support.v4.media.session.a f654b;

        /* JADX INFO: renamed from: android.support.v4.media.session.MediaControllerCompat$a$a, reason: collision with other inner class name */
        @RequiresApi(21)
        private static class C0023a extends MediaController.Callback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final WeakReference<a> f655a;

            C0023a(a aVar) {
                this.f655a = new WeakReference<>(aVar);
            }

            @Override // android.media.session.MediaController.Callback
            public void onAudioInfoChanged(MediaController.PlaybackInfo playbackInfo) {
                a aVar = this.f655a.get();
                if (aVar != null) {
                    aVar.a(new d(playbackInfo.getPlaybackType(), AudioAttributesCompat.wrap(playbackInfo.getAudioAttributes()), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume()));
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onExtrasChanged(Bundle bundle) {
                MediaSessionCompat.a(bundle);
                a aVar = this.f655a.get();
                if (aVar != null) {
                    aVar.b(bundle);
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onMetadataChanged(MediaMetadata mediaMetadata) {
                a aVar = this.f655a.get();
                if (aVar != null) {
                    aVar.c(MediaMetadataCompat.a(mediaMetadata));
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onPlaybackStateChanged(PlaybackState playbackState) {
                a aVar = this.f655a.get();
                if (aVar == null || aVar.f654b != null) {
                    return;
                }
                aVar.d(PlaybackStateCompat.a(playbackState));
            }

            @Override // android.media.session.MediaController.Callback
            public void onQueueChanged(List<MediaSession.QueueItem> list) {
                a aVar = this.f655a.get();
                if (aVar != null) {
                    aVar.e(MediaSessionCompat.QueueItem.b(list));
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onQueueTitleChanged(CharSequence charSequence) {
                a aVar = this.f655a.get();
                if (aVar != null) {
                    aVar.f(charSequence);
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onSessionDestroyed() {
                a aVar = this.f655a.get();
                if (aVar != null) {
                    aVar.g();
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onSessionEvent(String str, Bundle bundle) {
                MediaSessionCompat.a(bundle);
                a aVar = this.f655a.get();
                if (aVar != null) {
                    android.support.v4.media.session.a aVar2 = aVar.f654b;
                    aVar.h(str, bundle);
                }
            }
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            i(8, null, null);
        }

        public void g() {
        }

        private static class b extends a.AbstractBinderC0024a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final WeakReference<a> f656a;

            b(a aVar) {
                this.f656a = new WeakReference<>(aVar);
            }

            @Override // android.support.v4.media.session.a
            public void a() throws RemoteException {
                a aVar = this.f656a.get();
                if (aVar != null) {
                    aVar.i(13, null, null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void f(int i10) throws RemoteException {
                a aVar = this.f656a.get();
                if (aVar != null) {
                    aVar.i(12, Integer.valueOf(i10), null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void k(boolean z10) throws RemoteException {
                a aVar = this.f656a.get();
                if (aVar != null) {
                    aVar.i(11, Boolean.valueOf(z10), null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void n(PlaybackStateCompat playbackStateCompat) throws RemoteException {
                a aVar = this.f656a.get();
                if (aVar != null) {
                    aVar.i(2, playbackStateCompat, null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void onEvent(String str, Bundle bundle) throws RemoteException {
                a aVar = this.f656a.get();
                if (aVar != null) {
                    aVar.i(1, str, bundle);
                }
            }

            @Override // android.support.v4.media.session.a
            public void onRepeatModeChanged(int i10) throws RemoteException {
                a aVar = this.f656a.get();
                if (aVar != null) {
                    aVar.i(9, Integer.valueOf(i10), null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void l(boolean z10) throws RemoteException {
            }
        }

        public void a(d dVar) {
        }

        public void b(Bundle bundle) {
        }

        public void c(MediaMetadataCompat mediaMetadataCompat) {
        }

        public void d(PlaybackStateCompat playbackStateCompat) {
        }

        public void e(List<MediaSessionCompat.QueueItem> list) {
        }

        public void f(CharSequence charSequence) {
        }

        public void h(String str, Bundle bundle) {
        }

        void i(int i10, Object obj, Bundle bundle) {
        }
    }
}
