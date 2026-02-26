package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f678c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final float f679d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final long f680e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f681f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final CharSequence f682g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final long f683h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    List<CustomAction> f684i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final long f685j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final Bundle f686k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private PlaybackState f687l;

    class a implements Parcelable.Creator<PlaybackStateCompat> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public PlaybackStateCompat[] newArray(int i10) {
            return new PlaybackStateCompat[i10];
        }
    }

    @RequiresApi(21)
    private static class b {
        @DoNotInline
        static void a(PlaybackState.Builder builder, PlaybackState.CustomAction customAction) {
            builder.addCustomAction(customAction);
        }

        @DoNotInline
        static PlaybackState.CustomAction b(PlaybackState.CustomAction.Builder builder) {
            return builder.build();
        }

        @DoNotInline
        static PlaybackState c(PlaybackState.Builder builder) {
            return builder.build();
        }

        @DoNotInline
        static PlaybackState.Builder d() {
            return new PlaybackState.Builder();
        }

        @DoNotInline
        static PlaybackState.CustomAction.Builder e(String str, CharSequence charSequence, int i10) {
            return new PlaybackState.CustomAction.Builder(str, charSequence, i10);
        }

        @DoNotInline
        static String f(PlaybackState.CustomAction customAction) {
            return customAction.getAction();
        }

        @DoNotInline
        static long g(PlaybackState playbackState) {
            return playbackState.getActions();
        }

        @DoNotInline
        static long h(PlaybackState playbackState) {
            return playbackState.getActiveQueueItemId();
        }

        @DoNotInline
        static long i(PlaybackState playbackState) {
            return playbackState.getBufferedPosition();
        }

        @DoNotInline
        static List<PlaybackState.CustomAction> j(PlaybackState playbackState) {
            return playbackState.getCustomActions();
        }

        @DoNotInline
        static CharSequence k(PlaybackState playbackState) {
            return playbackState.getErrorMessage();
        }

        @DoNotInline
        static Bundle l(PlaybackState.CustomAction customAction) {
            return customAction.getExtras();
        }

        @DoNotInline
        static int m(PlaybackState.CustomAction customAction) {
            return customAction.getIcon();
        }

        @DoNotInline
        static long n(PlaybackState playbackState) {
            return playbackState.getLastPositionUpdateTime();
        }

        @DoNotInline
        static CharSequence o(PlaybackState.CustomAction customAction) {
            return customAction.getName();
        }

        @DoNotInline
        static float p(PlaybackState playbackState) {
            return playbackState.getPlaybackSpeed();
        }

        @DoNotInline
        static long q(PlaybackState playbackState) {
            return playbackState.getPosition();
        }

        @DoNotInline
        static int r(PlaybackState playbackState) {
            return playbackState.getState();
        }

        @DoNotInline
        static void s(PlaybackState.Builder builder, long j10) {
            builder.setActions(j10);
        }

        @DoNotInline
        static void t(PlaybackState.Builder builder, long j10) {
            builder.setActiveQueueItemId(j10);
        }

        @DoNotInline
        static void u(PlaybackState.Builder builder, long j10) {
            builder.setBufferedPosition(j10);
        }

        @DoNotInline
        static void v(PlaybackState.Builder builder, CharSequence charSequence) {
            builder.setErrorMessage(charSequence);
        }

        @DoNotInline
        static void w(PlaybackState.CustomAction.Builder builder, Bundle bundle) {
            builder.setExtras(bundle);
        }

        @DoNotInline
        static void x(PlaybackState.Builder builder, int i10, long j10, float f10, long j11) {
            builder.setState(i10, j10, f10, j11);
        }
    }

    @RequiresApi(22)
    private static class c {
        @DoNotInline
        static Bundle a(PlaybackState playbackState) {
            return playbackState.getExtras();
        }

        @DoNotInline
        static void b(PlaybackState.Builder builder, Bundle bundle) {
            builder.setExtras(bundle);
        }
    }

    PlaybackStateCompat(int i10, long j10, long j11, float f10, long j12, int i11, CharSequence charSequence, long j13, List<CustomAction> list, long j14, Bundle bundle) {
        this.f676a = i10;
        this.f677b = j10;
        this.f678c = j11;
        this.f679d = f10;
        this.f680e = j12;
        this.f681f = i11;
        this.f682g = charSequence;
        this.f683h = j13;
        this.f684i = new ArrayList(list);
        this.f685j = j14;
        this.f686k = bundle;
    }

    public static PlaybackStateCompat a(Object obj) {
        ArrayList arrayList = null;
        if (obj == null) {
            return null;
        }
        PlaybackState playbackState = (PlaybackState) obj;
        List<PlaybackState.CustomAction> listJ = b.j(playbackState);
        if (listJ != null) {
            arrayList = new ArrayList(listJ.size());
            Iterator<PlaybackState.CustomAction> it = listJ.iterator();
            while (it.hasNext()) {
                arrayList.add(CustomAction.a(it.next()));
            }
        }
        Bundle bundleA = c.a(playbackState);
        MediaSessionCompat.a(bundleA);
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(b.r(playbackState), b.q(playbackState), b.i(playbackState), b.p(playbackState), b.g(playbackState), 0, b.k(playbackState), b.n(playbackState), arrayList, b.h(playbackState), bundleA);
        playbackStateCompat.f687l = playbackState;
        return playbackStateCompat;
    }

    public static int b(long j10) {
        if (j10 == 4) {
            return 126;
        }
        if (j10 == 2) {
            return 127;
        }
        if (j10 == 32) {
            return 87;
        }
        if (j10 == 16) {
            return 88;
        }
        if (j10 == 1) {
            return 86;
        }
        if (j10 == 64) {
            return 90;
        }
        if (j10 == 8) {
            return 89;
        }
        return j10 == 512 ? 85 : 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "PlaybackState {state=" + this.f676a + ", position=" + this.f677b + ", buffered position=" + this.f678c + ", speed=" + this.f679d + ", updated=" + this.f683h + ", actions=" + this.f680e + ", error code=" + this.f681f + ", error message=" + this.f682g + ", custom actions=" + this.f684i + ", active item id=" + this.f685j + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f676a);
        parcel.writeLong(this.f677b);
        parcel.writeFloat(this.f679d);
        parcel.writeLong(this.f683h);
        parcel.writeLong(this.f678c);
        parcel.writeLong(this.f680e);
        TextUtils.writeToParcel(this.f682g, parcel, i10);
        parcel.writeTypedList(this.f684i);
        parcel.writeLong(this.f685j);
        parcel.writeBundle(this.f686k);
        parcel.writeInt(this.f681f);
    }

    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f688a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final CharSequence f689b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f690c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Bundle f691d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private PlaybackState.CustomAction f692e;

        class a implements Parcelable.Creator<CustomAction> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public CustomAction[] newArray(int i10) {
                return new CustomAction[i10];
            }
        }

        CustomAction(String str, CharSequence charSequence, int i10, Bundle bundle) {
            this.f688a = str;
            this.f689b = charSequence;
            this.f690c = i10;
            this.f691d = bundle;
        }

        public static CustomAction a(Object obj) {
            if (obj == null) {
                return null;
            }
            PlaybackState.CustomAction customAction = (PlaybackState.CustomAction) obj;
            Bundle bundleL = b.l(customAction);
            MediaSessionCompat.a(bundleL);
            CustomAction customAction2 = new CustomAction(b.f(customAction), b.o(customAction), b.m(customAction), bundleL);
            customAction2.f692e = customAction;
            return customAction2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "Action:mName='" + ((Object) this.f689b) + ", mIcon=" + this.f690c + ", mExtras=" + this.f691d;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f688a);
            TextUtils.writeToParcel(this.f689b, parcel, i10);
            parcel.writeInt(this.f690c);
            parcel.writeBundle(this.f691d);
        }

        CustomAction(Parcel parcel) {
            this.f688a = parcel.readString();
            this.f689b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f690c = parcel.readInt();
            this.f691d = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }
    }

    PlaybackStateCompat(Parcel parcel) {
        this.f676a = parcel.readInt();
        this.f677b = parcel.readLong();
        this.f679d = parcel.readFloat();
        this.f683h = parcel.readLong();
        this.f678c = parcel.readLong();
        this.f680e = parcel.readLong();
        this.f682g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f684i = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f685j = parcel.readLong();
        this.f686k = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.f681f = parcel.readInt();
    }
}
