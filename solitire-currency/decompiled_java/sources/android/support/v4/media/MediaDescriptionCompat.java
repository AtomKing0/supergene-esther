package android.support.v4.media;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CharSequence f620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CharSequence f621c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CharSequence f622d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Bitmap f623e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Uri f624f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Bundle f625g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Uri f626h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private MediaDescription f627i;

    class a implements Parcelable.Creator<MediaDescriptionCompat> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            return MediaDescriptionCompat.a(MediaDescription.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public MediaDescriptionCompat[] newArray(int i10) {
            return new MediaDescriptionCompat[i10];
        }
    }

    @RequiresApi(21)
    private static class b {
        @DoNotInline
        static MediaDescription a(MediaDescription.Builder builder) {
            return builder.build();
        }

        @DoNotInline
        static MediaDescription.Builder b() {
            return new MediaDescription.Builder();
        }

        @Nullable
        @DoNotInline
        static CharSequence c(MediaDescription mediaDescription) {
            return mediaDescription.getDescription();
        }

        @Nullable
        @DoNotInline
        static Bundle d(MediaDescription mediaDescription) {
            return mediaDescription.getExtras();
        }

        @Nullable
        @DoNotInline
        static Bitmap e(MediaDescription mediaDescription) {
            return mediaDescription.getIconBitmap();
        }

        @Nullable
        @DoNotInline
        static Uri f(MediaDescription mediaDescription) {
            return mediaDescription.getIconUri();
        }

        @Nullable
        @DoNotInline
        static String g(MediaDescription mediaDescription) {
            return mediaDescription.getMediaId();
        }

        @Nullable
        @DoNotInline
        static CharSequence h(MediaDescription mediaDescription) {
            return mediaDescription.getSubtitle();
        }

        @Nullable
        @DoNotInline
        static CharSequence i(MediaDescription mediaDescription) {
            return mediaDescription.getTitle();
        }

        @DoNotInline
        static void j(MediaDescription.Builder builder, @Nullable CharSequence charSequence) {
            builder.setDescription(charSequence);
        }

        @DoNotInline
        static void k(MediaDescription.Builder builder, @Nullable Bundle bundle) {
            builder.setExtras(bundle);
        }

        @DoNotInline
        static void l(MediaDescription.Builder builder, @Nullable Bitmap bitmap) {
            builder.setIconBitmap(bitmap);
        }

        @DoNotInline
        static void m(MediaDescription.Builder builder, @Nullable Uri uri) {
            builder.setIconUri(uri);
        }

        @DoNotInline
        static void n(MediaDescription.Builder builder, @Nullable String str) {
            builder.setMediaId(str);
        }

        @DoNotInline
        static void o(MediaDescription.Builder builder, @Nullable CharSequence charSequence) {
            builder.setSubtitle(charSequence);
        }

        @DoNotInline
        static void p(MediaDescription.Builder builder, @Nullable CharSequence charSequence) {
            builder.setTitle(charSequence);
        }
    }

    @RequiresApi(23)
    private static class c {
        @Nullable
        @DoNotInline
        static Uri a(MediaDescription mediaDescription) {
            return mediaDescription.getMediaUri();
        }

        @DoNotInline
        static void b(MediaDescription.Builder builder, @Nullable Uri uri) {
            builder.setMediaUri(uri);
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f628a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private CharSequence f629b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private CharSequence f630c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private CharSequence f631d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Bitmap f632e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Uri f633f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Bundle f634g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Uri f635h;

        public MediaDescriptionCompat a() {
            return new MediaDescriptionCompat(this.f628a, this.f629b, this.f630c, this.f631d, this.f632e, this.f633f, this.f634g, this.f635h);
        }

        public d b(@Nullable CharSequence charSequence) {
            this.f631d = charSequence;
            return this;
        }

        public d c(@Nullable Bundle bundle) {
            this.f634g = bundle;
            return this;
        }

        public d d(@Nullable Bitmap bitmap) {
            this.f632e = bitmap;
            return this;
        }

        public d e(@Nullable Uri uri) {
            this.f633f = uri;
            return this;
        }

        public d f(@Nullable String str) {
            this.f628a = str;
            return this;
        }

        public d g(@Nullable Uri uri) {
            this.f635h = uri;
            return this;
        }

        public d h(@Nullable CharSequence charSequence) {
            this.f630c = charSequence;
            return this;
        }

        public d i(@Nullable CharSequence charSequence) {
            this.f629b = charSequence;
            return this;
        }
    }

    MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f619a = str;
        this.f620b = charSequence;
        this.f621c = charSequence2;
        this.f622d = charSequence3;
        this.f623e = bitmap;
        this.f624f = uri;
        this.f625g = bundle;
        this.f626h = uri2;
    }

    public static MediaDescriptionCompat a(Object obj) {
        Bundle bundle = null;
        if (obj == null) {
            return null;
        }
        d dVar = new d();
        MediaDescription mediaDescription = (MediaDescription) obj;
        dVar.f(b.g(mediaDescription));
        dVar.i(b.i(mediaDescription));
        dVar.h(b.h(mediaDescription));
        dVar.b(b.c(mediaDescription));
        dVar.d(b.e(mediaDescription));
        dVar.e(b.f(mediaDescription));
        Bundle bundleD = b.d(mediaDescription);
        if (bundleD != null) {
            bundleD = MediaSessionCompat.c(bundleD);
        }
        Uri uri = bundleD != null ? (Uri) bundleD.getParcelable("android.support.v4.media.description.MEDIA_URI") : null;
        if (uri == null) {
            bundle = bundleD;
        } else if (!bundleD.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") || bundleD.size() != 2) {
            bundleD.remove("android.support.v4.media.description.MEDIA_URI");
            bundleD.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
            bundle = bundleD;
        }
        dVar.c(bundle);
        if (uri != null) {
            dVar.g(uri);
        } else {
            dVar.g(c.a(mediaDescription));
        }
        MediaDescriptionCompat mediaDescriptionCompatA = dVar.a();
        mediaDescriptionCompatA.f627i = mediaDescription;
        return mediaDescriptionCompatA;
    }

    public Object b() {
        MediaDescription mediaDescription = this.f627i;
        if (mediaDescription != null) {
            return mediaDescription;
        }
        MediaDescription.Builder builderB = b.b();
        b.n(builderB, this.f619a);
        b.p(builderB, this.f620b);
        b.o(builderB, this.f621c);
        b.j(builderB, this.f622d);
        b.l(builderB, this.f623e);
        b.m(builderB, this.f624f);
        b.k(builderB, this.f625g);
        c.b(builderB, this.f626h);
        MediaDescription mediaDescriptionA = b.a(builderB);
        this.f627i = mediaDescriptionA;
        return mediaDescriptionA;
    }

    @Nullable
    public String c() {
        return this.f619a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return ((Object) this.f620b) + ", " + ((Object) this.f621c) + ", " + ((Object) this.f622d);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        ((MediaDescription) b()).writeToParcel(parcel, i10);
    }
}
