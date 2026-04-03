package android.support.v4.media.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import androidx.annotation.RestrictTo;
import java.util.List;

/* JADX INFO: compiled from: IMediaControllerCallback.java */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public interface a extends IInterface {

    /* JADX INFO: compiled from: IMediaControllerCallback.java */
    public static class b {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T b(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }
    }

    void a() throws RemoteException;

    void b(List<MediaSessionCompat.QueueItem> list) throws RemoteException;

    void d() throws RemoteException;

    void e(MediaMetadataCompat mediaMetadataCompat) throws RemoteException;

    void f(int i10) throws RemoteException;

    void h(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException;

    void j(Bundle bundle) throws RemoteException;

    void k(boolean z10) throws RemoteException;

    void l(boolean z10) throws RemoteException;

    void m(CharSequence charSequence) throws RemoteException;

    void n(PlaybackStateCompat playbackStateCompat) throws RemoteException;

    void onEvent(String str, Bundle bundle) throws RemoteException;

    void onRepeatModeChanged(int i10) throws RemoteException;

    /* JADX INFO: renamed from: android.support.v4.media.session.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IMediaControllerCallback.java */
    public static abstract class AbstractBinderC0024a extends Binder implements a {
        public AbstractBinderC0024a() {
            attachInterface(this, "android.support.v4.media.session.IMediaControllerCallback");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            }
            if (i10 == 1598968902) {
                parcel2.writeString("android.support.v4.media.session.IMediaControllerCallback");
                return true;
            }
            switch (i10) {
                case 1:
                    onEvent(parcel.readString(), (Bundle) b.b(parcel, Bundle.CREATOR));
                    return true;
                case 2:
                    d();
                    return true;
                case 3:
                    n((PlaybackStateCompat) b.b(parcel, PlaybackStateCompat.CREATOR));
                    return true;
                case 4:
                    e((MediaMetadataCompat) b.b(parcel, MediaMetadataCompat.CREATOR));
                    return true;
                case 5:
                    b(parcel.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR));
                    return true;
                case 6:
                    m((CharSequence) b.b(parcel, TextUtils.CHAR_SEQUENCE_CREATOR));
                    return true;
                case 7:
                    j((Bundle) b.b(parcel, Bundle.CREATOR));
                    return true;
                case 8:
                    h((ParcelableVolumeInfo) b.b(parcel, ParcelableVolumeInfo.CREATOR));
                    return true;
                case 9:
                    onRepeatModeChanged(parcel.readInt());
                    return true;
                case 10:
                    l(parcel.readInt() != 0);
                    return true;
                case 11:
                    k(parcel.readInt() != 0);
                    return true;
                case 12:
                    f(parcel.readInt());
                    return true;
                case 13:
                    a();
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
