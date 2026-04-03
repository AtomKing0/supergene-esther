package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.media.MediaDescription;
import android.media.session.MediaSession;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MediaSessionCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MediaControllerCompat f662a;

    @SuppressLint({"BanParcelableUsage"})
    static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ResultReceiver f666a;

        class a implements Parcelable.Creator<ResultReceiverWrapper> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ResultReceiverWrapper createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public ResultReceiverWrapper[] newArray(int i10) {
                return new ResultReceiverWrapper[i10];
            }
        }

        ResultReceiverWrapper(Parcel parcel) {
            this.f666a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            this.f666a.writeToParcel(parcel, i10);
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f667a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object f668b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @GuardedBy("mLock")
        private b f669c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @GuardedBy("mLock")
        private VersionedParcelable f670d;

        class a implements Parcelable.Creator<Token> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Token createFromParcel(Parcel parcel) {
                return new Token(parcel.readParcelable(null));
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Token[] newArray(int i10) {
                return new Token[i10];
            }
        }

        Token(Object obj) {
            this(obj, null, null);
        }

        public static Token a(Object obj) {
            return b(obj, null);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public static Token b(Object obj, b bVar) {
            if (obj == null) {
                return null;
            }
            if (obj instanceof MediaSession.Token) {
                return new Token(obj, bVar);
            }
            throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public b c() {
            b bVar;
            synchronized (this.f667a) {
                bVar = this.f669c;
            }
            return bVar;
        }

        public Object d() {
            return this.f668b;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public void e(b bVar) {
            synchronized (this.f667a) {
                this.f669c = bVar;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            Object obj2 = this.f668b;
            if (obj2 == null) {
                return token.f668b == null;
            }
            Object obj3 = token.f668b;
            if (obj3 == null) {
                return false;
            }
            return obj2.equals(obj3);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void f(VersionedParcelable versionedParcelable) {
            synchronized (this.f667a) {
                this.f670d = versionedParcelable;
            }
        }

        public int hashCode() {
            Object obj = this.f668b;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeParcelable((Parcelable) this.f668b, i10);
        }

        Token(Object obj, b bVar) {
            this(obj, bVar, null);
        }

        Token(Object obj, b bVar, VersionedParcelable versionedParcelable) {
            this.f667a = new Object();
            this.f668b = obj;
            this.f669c = bVar;
            this.f670d = versionedParcelable;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static void a(@Nullable Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Bundle c(@Nullable Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        a(bundle);
        try {
            bundle.isEmpty();
            return bundle;
        } catch (BadParcelableException unused) {
            Log.e("MediaSessionCompat", "Could not unparcel the data.");
            return null;
        }
    }

    public MediaControllerCompat b() {
        return this.f662a;
    }

    @SuppressLint({"BanParcelableUsage"})
    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MediaDescriptionCompat f663a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f664b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private MediaSession.QueueItem f665c;

        class a implements Parcelable.Creator<QueueItem> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public QueueItem createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public QueueItem[] newArray(int i10) {
                return new QueueItem[i10];
            }
        }

        @RequiresApi(21)
        private static class b {
            @DoNotInline
            static MediaSession.QueueItem a(MediaDescription mediaDescription, long j10) {
                return new MediaSession.QueueItem(mediaDescription, j10);
            }

            @DoNotInline
            static MediaDescription b(MediaSession.QueueItem queueItem) {
                return queueItem.getDescription();
            }

            @DoNotInline
            static long c(MediaSession.QueueItem queueItem) {
                return queueItem.getQueueId();
            }
        }

        private QueueItem(MediaSession.QueueItem queueItem, MediaDescriptionCompat mediaDescriptionCompat, long j10) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null");
            }
            if (j10 == -1) {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            }
            this.f663a = mediaDescriptionCompat;
            this.f664b = j10;
            this.f665c = queueItem;
        }

        public static QueueItem a(Object obj) {
            if (obj == null) {
                return null;
            }
            MediaSession.QueueItem queueItem = (MediaSession.QueueItem) obj;
            return new QueueItem(queueItem, MediaDescriptionCompat.a(b.b(queueItem)), b.c(queueItem));
        }

        public static List<QueueItem> b(List<?> list) {
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

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.f663a + ", Id=" + this.f664b + " }";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            this.f663a.writeToParcel(parcel, i10);
            parcel.writeLong(this.f664b);
        }

        QueueItem(Parcel parcel) {
            this.f663a = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.f664b = parcel.readLong();
        }
    }
}
