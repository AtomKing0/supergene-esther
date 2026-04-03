package android.support.v4.media;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.media.MediaDescription;
import android.media.browse.MediaBrowser;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.b;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.collection.ArrayMap;
import androidx.core.app.BundleCompat;
import androidx.media.MediaBrowserCompatUtils;
import androidx.media.MediaBrowserProtocol;
import androidx.media.MediaBrowserServiceCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class MediaBrowserCompat {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final boolean f593b = Log.isLoggable("MediaBrowserCompat", 3);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f594a;

    private static class ItemReceiver extends b.b {
        @Override // b.b
        protected void a(int i10, Bundle bundle) {
            if (bundle != null) {
                bundle = MediaSessionCompat.c(bundle);
            }
            if (i10 != 0 || bundle == null || !bundle.containsKey(MediaBrowserServiceCompat.KEY_MEDIA_ITEM)) {
                throw null;
            }
            Parcelable parcelable = bundle.getParcelable(MediaBrowserServiceCompat.KEY_MEDIA_ITEM);
            if (parcelable != null && !(parcelable instanceof MediaItem)) {
                throw null;
            }
            throw null;
        }
    }

    private static class SearchResultReceiver extends b.b {
        @Override // b.b
        protected void a(int i10, Bundle bundle) {
            if (bundle != null) {
                bundle = MediaSessionCompat.c(bundle);
            }
            if (i10 != 0 || bundle == null || !bundle.containsKey(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS)) {
                throw null;
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS);
            parcelableArray.getClass();
            ArrayList arrayList = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                arrayList.add((MediaItem) parcelable);
            }
            throw null;
        }
    }

    @RequiresApi(21)
    private static class a {
        @DoNotInline
        static MediaDescription a(MediaBrowser.MediaItem mediaItem) {
            return mediaItem.getDescription();
        }

        @DoNotInline
        static int b(MediaBrowser.MediaItem mediaItem) {
            return mediaItem.getFlags();
        }
    }

    private static class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference<h> f597a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private WeakReference<Messenger> f598b;

        b(h hVar) {
            this.f597a = new WeakReference<>(hVar);
        }

        void a(Messenger messenger) {
            this.f598b = new WeakReference<>(messenger);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            WeakReference<Messenger> weakReference = this.f598b;
            if (weakReference == null || weakReference.get() == null || this.f597a.get() == null) {
                return;
            }
            Bundle data = message.getData();
            MediaSessionCompat.a(data);
            h hVar = this.f597a.get();
            Messenger messenger = this.f598b.get();
            try {
                int i10 = message.what;
                if (i10 == 1) {
                    Bundle bundle = data.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS);
                    MediaSessionCompat.a(bundle);
                    hVar.d(messenger, data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), (MediaSessionCompat.Token) data.getParcelable(MediaBrowserProtocol.DATA_MEDIA_SESSION_TOKEN), bundle);
                } else if (i10 == 2) {
                    hVar.f(messenger);
                } else if (i10 != 3) {
                    Log.w("MediaBrowserCompat", "Unhandled message: " + message + "\n  Client version: 1\n  Service version: " + message.arg1);
                } else {
                    Bundle bundle2 = data.getBundle(MediaBrowserProtocol.DATA_OPTIONS);
                    MediaSessionCompat.a(bundle2);
                    Bundle bundle3 = data.getBundle(MediaBrowserProtocol.DATA_NOTIFY_CHILDREN_CHANGED_OPTIONS);
                    MediaSessionCompat.a(bundle3);
                    hVar.a(messenger, data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), data.getParcelableArrayList(MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST), bundle2, bundle3);
                }
            } catch (BadParcelableException unused) {
                Log.e("MediaBrowserCompat", "Could not unparcel the data.");
                if (message.what == 1) {
                    hVar.f(messenger);
                }
            }
        }
    }

    interface d {
        void b();

        void disconnect();

        @NonNull
        MediaSessionCompat.Token getSessionToken();
    }

    @RequiresApi(23)
    static class f extends e {
        f(Context context, ComponentName componentName, c cVar, Bundle bundle) {
            super(context, componentName, cVar, bundle);
        }
    }

    @RequiresApi(26)
    static class g extends f {
        g(Context context, ComponentName componentName, c cVar, Bundle bundle) {
            super(context, componentName, cVar, bundle);
        }
    }

    interface h {
        void a(Messenger messenger, String str, List<MediaItem> list, Bundle bundle, Bundle bundle2);

        void d(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle);

        void f(Messenger messenger);
    }

    private static class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Messenger f610a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Bundle f611b;

        public i(IBinder iBinder, Bundle bundle) {
            this.f610a = new Messenger(iBinder);
            this.f611b = bundle;
        }

        private void b(int i10, Bundle bundle, Messenger messenger) throws RemoteException {
            Message messageObtain = Message.obtain();
            messageObtain.what = i10;
            messageObtain.arg1 = 1;
            messageObtain.setData(bundle);
            messageObtain.replyTo = messenger;
            this.f610a.send(messageObtain);
        }

        void a(Context context, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString(MediaBrowserProtocol.DATA_PACKAGE_NAME, context.getPackageName());
            bundle.putInt(MediaBrowserProtocol.DATA_CALLING_PID, Process.myPid());
            bundle.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, this.f611b);
            b(6, bundle, messenger);
        }

        void c(Messenger messenger) throws RemoteException {
            b(7, null, messenger);
        }
    }

    private static class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<k> f612a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<Bundle> f613b = new ArrayList();

        public k a(Bundle bundle) {
            for (int i10 = 0; i10 < this.f613b.size(); i10++) {
                if (MediaBrowserCompatUtils.areSameOptions(this.f613b.get(i10), bundle)) {
                    return this.f612a.get(i10);
                }
            }
            return null;
        }

        public List<k> b() {
            return this.f612a;
        }

        public List<Bundle> c() {
            return this.f613b;
        }
    }

    public MediaBrowserCompat(Context context, ComponentName componentName, c cVar, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f594a = new g(context, componentName, cVar, bundle);
        } else {
            this.f594a = new f(context, componentName, cVar, bundle);
        }
    }

    public void a() {
        Log.d("MediaBrowserCompat", "Connecting to a MediaBrowserService.");
        this.f594a.b();
    }

    public void b() {
        this.f594a.disconnect();
    }

    @NonNull
    public MediaSessionCompat.Token c() {
        return this.f594a.getSessionToken();
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f595a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final MediaDescriptionCompat f596b;

        class a implements Parcelable.Creator<MediaItem> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public MediaItem createFromParcel(Parcel parcel) {
                return new MediaItem(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public MediaItem[] newArray(int i10) {
                return new MediaItem[i10];
            }
        }

        public MediaItem(@NonNull MediaDescriptionCompat mediaDescriptionCompat, int i10) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("description cannot be null");
            }
            if (TextUtils.isEmpty(mediaDescriptionCompat.c())) {
                throw new IllegalArgumentException("description must have a non-empty media id");
            }
            this.f595a = i10;
            this.f596b = mediaDescriptionCompat;
        }

        public static MediaItem a(Object obj) {
            if (obj == null) {
                return null;
            }
            MediaBrowser.MediaItem mediaItem = (MediaBrowser.MediaItem) obj;
            return new MediaItem(MediaDescriptionCompat.a(a.a(mediaItem)), a.b(mediaItem));
        }

        public static List<MediaItem> b(List<?> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator<?> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(a(it.next()));
            }
            return arrayList;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NonNull
        public String toString() {
            return "MediaItem{mFlags=" + this.f595a + ", mDescription=" + this.f596b + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f595a);
            this.f596b.writeToParcel(parcel, i10);
        }

        MediaItem(Parcel parcel) {
            this.f595a = parcel.readInt();
            this.f596b = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }
    }

    public static class c {
        final MediaBrowser.ConnectionCallback mConnectionCallbackFwk = new a();
        b mConnectionCallbackInternal;

        @RequiresApi(21)
        private class a extends MediaBrowser.ConnectionCallback {
            a() {
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnected() {
                b bVar = c.this.mConnectionCallbackInternal;
                if (bVar != null) {
                    bVar.onConnected();
                }
                c.this.onConnected();
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnectionFailed() {
                b bVar = c.this.mConnectionCallbackInternal;
                if (bVar != null) {
                    bVar.c();
                }
                c.this.onConnectionFailed();
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnectionSuspended() {
                b bVar = c.this.mConnectionCallbackInternal;
                if (bVar != null) {
                    bVar.e();
                }
                c.this.onConnectionSuspended();
            }
        }

        interface b {
            void c();

            void e();

            void onConnected();
        }

        void setInternalConnectionCallback(b bVar) {
            this.mConnectionCallbackInternal = bVar;
        }

        public void onConnected() {
        }

        public void onConnectionFailed() {
        }

        public void onConnectionSuspended() {
        }
    }

    @RequiresApi(21)
    static class e implements d, h, c.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Context f600a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected final MediaBrowser f601b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected final Bundle f602c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        protected final b f603d = new b(this);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final ArrayMap<String, j> f604e = new ArrayMap<>();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        protected int f605f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        protected i f606g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        protected Messenger f607h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private MediaSessionCompat.Token f608i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private Bundle f609j;

        e(Context context, ComponentName componentName, c cVar, Bundle bundle) {
            this.f600a = context;
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            this.f602c = bundle2;
            bundle2.putInt(MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 1);
            bundle2.putInt(MediaBrowserProtocol.EXTRA_CALLING_PID, Process.myPid());
            cVar.setInternalConnectionCallback(this);
            this.f601b = new MediaBrowser(context, componentName, cVar.mConnectionCallbackFwk, bundle2);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.h
        public void a(Messenger messenger, String str, List<MediaItem> list, Bundle bundle, Bundle bundle2) {
            if (this.f607h != messenger) {
                return;
            }
            j jVar = this.f604e.get(str);
            if (jVar == null) {
                if (MediaBrowserCompat.f593b) {
                    Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + str);
                    return;
                }
                return;
            }
            k kVarA = jVar.a(bundle);
            if (kVarA != null) {
                if (bundle == null) {
                    if (list == null) {
                        kVarA.c(str);
                        return;
                    }
                    this.f609j = bundle2;
                    kVarA.a(str, list);
                    this.f609j = null;
                    return;
                }
                if (list == null) {
                    kVarA.d(str, bundle);
                    return;
                }
                this.f609j = bundle2;
                kVarA.b(str, list, bundle);
                this.f609j = null;
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.d
        public void b() {
            this.f601b.connect();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.d
        public void disconnect() {
            Messenger messenger;
            i iVar = this.f606g;
            if (iVar != null && (messenger = this.f607h) != null) {
                try {
                    iVar.c(messenger);
                } catch (RemoteException unused) {
                    Log.i("MediaBrowserCompat", "Remote error unregistering client messenger.");
                }
            }
            this.f601b.disconnect();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.c.b
        public void e() {
            this.f606g = null;
            this.f607h = null;
            this.f608i = null;
            this.f603d.a(null);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.d
        @NonNull
        public MediaSessionCompat.Token getSessionToken() {
            if (this.f608i == null) {
                this.f608i = MediaSessionCompat.Token.a(this.f601b.getSessionToken());
            }
            return this.f608i;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.c.b
        public void onConnected() {
            try {
                Bundle extras = this.f601b.getExtras();
                if (extras == null) {
                    return;
                }
                this.f605f = extras.getInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 0);
                IBinder binder = BundleCompat.getBinder(extras, MediaBrowserProtocol.EXTRA_MESSENGER_BINDER);
                if (binder != null) {
                    this.f606g = new i(binder, this.f602c);
                    Messenger messenger = new Messenger(this.f603d);
                    this.f607h = messenger;
                    this.f603d.a(messenger);
                    try {
                        this.f606g.a(this.f600a, this.f607h);
                    } catch (RemoteException unused) {
                        Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
                    }
                }
                android.support.v4.media.session.b bVarO = b.a.o(BundleCompat.getBinder(extras, MediaBrowserProtocol.EXTRA_SESSION_BINDER));
                if (bVarO != null) {
                    this.f608i = MediaSessionCompat.Token.b(this.f601b.getSessionToken(), bVarO);
                }
            } catch (IllegalStateException e10) {
                Log.e("MediaBrowserCompat", "Unexpected IllegalStateException", e10);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.c.b
        public void c() {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.h
        public void f(Messenger messenger) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.h
        public void d(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
        }
    }

    public static abstract class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MediaBrowser.SubscriptionCallback f614a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final IBinder f615b = new Binder();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        WeakReference<j> f616c;

        @RequiresApi(21)
        private class a extends MediaBrowser.SubscriptionCallback {
            a() {
            }

            List<MediaItem> a(List<MediaItem> list, Bundle bundle) {
                if (list == null) {
                    return null;
                }
                int i10 = bundle.getInt("android.media.browse.extra.PAGE", -1);
                int i11 = bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
                if (i10 == -1 && i11 == -1) {
                    return list;
                }
                int i12 = i11 * i10;
                int size = i12 + i11;
                if (i10 < 0 || i11 < 1 || i12 >= list.size()) {
                    return Collections.emptyList();
                }
                if (size > list.size()) {
                    size = list.size();
                }
                return list.subList(i12, size);
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onChildrenLoaded(@NonNull String str, List<MediaBrowser.MediaItem> list) {
                WeakReference<j> weakReference = k.this.f616c;
                j jVar = weakReference == null ? null : weakReference.get();
                if (jVar == null) {
                    k.this.a(str, MediaItem.b(list));
                    return;
                }
                List<MediaItem> listB = MediaItem.b(list);
                List<k> listB2 = jVar.b();
                List<Bundle> listC = jVar.c();
                for (int i10 = 0; i10 < listB2.size(); i10++) {
                    Bundle bundle = listC.get(i10);
                    if (bundle == null) {
                        k.this.a(str, listB);
                    } else {
                        k.this.b(str, a(listB, bundle), bundle);
                    }
                }
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onError(@NonNull String str) {
                k.this.c(str);
            }
        }

        @RequiresApi(26)
        private class b extends a {
            b() {
                super();
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onChildrenLoaded(@NonNull String str, @NonNull List<MediaBrowser.MediaItem> list, @NonNull Bundle bundle) {
                MediaSessionCompat.a(bundle);
                k.this.b(str, MediaItem.b(list), bundle);
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onError(@NonNull String str, @NonNull Bundle bundle) {
                MediaSessionCompat.a(bundle);
                k.this.d(str, bundle);
            }
        }

        public k() {
            if (Build.VERSION.SDK_INT >= 26) {
                this.f614a = new b();
            } else {
                this.f614a = new a();
            }
        }

        public void c(@NonNull String str) {
        }

        public void a(@NonNull String str, @NonNull List<MediaItem> list) {
        }

        public void d(@NonNull String str, @NonNull Bundle bundle) {
        }

        public void b(@NonNull String str, @NonNull List<MediaItem> list, @NonNull Bundle bundle) {
        }
    }

    private static class CustomActionResultReceiver extends b.b {
        @Override // b.b
        protected void a(int i10, Bundle bundle) {
        }
    }
}
